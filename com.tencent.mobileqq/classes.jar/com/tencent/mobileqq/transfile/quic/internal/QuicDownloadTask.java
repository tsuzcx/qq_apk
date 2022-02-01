package com.tencent.mobileqq.transfile.quic.internal;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QuicDownloadTask
  extends Task<DownloadListener>
{
  private static final String ISO_8859_1 = "ISO-8859-1";
  private float currentProgress = 0.0F;
  public boolean encryption = false;
  public int fec = 0;
  public Map<String, String> headers = new LinkedHashMap();
  private boolean isHeader;
  private volatile boolean mClientFailed = false;
  private volatile boolean mClosed = false;
  private volatile boolean mCompleted = false;
  public QuicDownloadRequest mQuicDownloadRequest;
  private QuicNative mRealQuicCall;
  private RandomAccessFile savedFile = null;
  private long sendReqTime = 0L;
  private long startConnTime = 0L;
  private long sum = 0L;
  public int timeOut = 10000;
  
  public QuicDownloadTask(ITaskHandler paramITaskHandler, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, DownloadListener paramDownloadListener)
  {
    super(paramITaskHandler, "quic", paramString1, paramString2, paramString3, paramMap, paramDownloadListener);
    this.report.channel = "quic";
  }
  
  public static String bytesToHexString(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str.toUpperCase());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private boolean cancelFinishIfNeed()
  {
    if ((this.netListener != null) && (((DownloadListener)this.netListener).isCanceled()))
    {
      this.mClientFailed = true;
      this.report.errMsg = "task is canceled.";
      this.report.errCode = 10007;
      doFinish(10);
      return true;
    }
    return false;
  }
  
  private static byte charToByte(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  private void clear()
  {
    try
    {
      if (this.mRealQuicCall != null)
      {
        this.mRealQuicCall.clear();
        this.mRealQuicCall = null;
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  private void finishRecv()
  {
    this.report.endTime = System.currentTimeMillis();
    this.report.totaltime = (this.report.endTime - this.report.startTime);
    StringBuilder localStringBuilder = new StringBuilder("header=>");
    Iterator localIterator = this.headers.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(":");
      localStringBuilder.append((String)localEntry.getValue());
      localStringBuilder.append("\n");
    }
    this.report.header = localStringBuilder.toString();
    this.mCompleted = true;
    doFinish(3);
  }
  
  public static byte[] hexStringToBytes(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      paramString = null;
      return paramString;
    }
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    char[] arrayOfChar = paramString.toUpperCase().toCharArray();
    int i = 0;
    for (;;)
    {
      paramString = arrayOfByte;
      if (i >= j) {
        break;
      }
      int k = i * 2;
      int m = charToByte(arrayOfChar[k]);
      arrayOfByte[i] = ((byte)(charToByte(arrayOfChar[(k + 1)]) | m << 4));
      i += 1;
    }
  }
  
  void connectionClose(int paramInt, String paramString)
  {
    if ((!this.running) || (this.mClosed)) {
      return;
    }
    this.mClosed = true;
    if ((!this.mCompleted) && (!this.mClientFailed)) {}
    try
    {
      if (this.mRealQuicCall != null)
      {
        this.report.extra = this.mRealQuicCall.getState();
        this.report.srvMessage = this.mRealQuicCall.getSrvMessage();
      }
      this.report.errCode = (paramInt + 20000);
      this.report.errMsg = paramString;
      handleException(this.report.errCode, 3);
      clear();
      if (this.handler != null)
      {
        paramString = Message.obtain();
        paramString.what = 7;
        paramString.obj = this;
        this.handler.handleMessage(paramString);
      }
      this.running = false;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
  }
  
  void doFinish(int paramInt)
  {
    try
    {
      if (this.mRealQuicCall != null)
      {
        this.report.extra = this.mRealQuicCall.getState();
        this.report.srvMessage = this.mRealQuicCall.getSrvMessage();
        this.mRealQuicCall.setTransCompleted(true);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      try
      {
        for (;;)
        {
          if (this.savedFile != null) {
            this.savedFile.close();
          }
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              return;
              localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
              QLog.e("quic", 4, localUnsatisfiedLinkError1, new Object[0]);
            }
            break;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.report.errMsg = localException.toString();
          continue;
          handleFinish(this.report.tempPath);
          continue;
          handleException(this.report.errCode, 4);
          continue;
          handleException(this.report.errCode, 9);
          continue;
          try
          {
            if (this.mRealQuicCall != null)
            {
              this.mRealQuicCall.setTransCompleted(true);
              return;
            }
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
          {
            localUnsatisfiedLinkError2.printStackTrace();
          }
        }
      }
    }
  }
  
  protected boolean handleBodyOnParseHeader(String paramString, BufferedReader paramBufferedReader, int paramInt)
  {
    if (paramBufferedReader.readLine() != null)
    {
      paramString = paramString.split(System.getProperty("line.separator"), paramInt + 2);
      paramString = hexStringToBytes(bytesToHexString(paramString[(paramString.length - 1)].getBytes("ISO-8859-1")));
      if (paramString != null)
      {
        parseBody(paramString, paramString.length);
        return true;
      }
    }
    return false;
  }
  
  protected boolean handleHeaderLine(String paramString)
  {
    int i = paramString.indexOf(":");
    String str = paramString.substring(0, i).trim();
    paramString = paramString.substring(i + 1).trim();
    this.headers.put(str, paramString);
    if (str.equalsIgnoreCase("content-length")) {
      this.report.contentLength = (Long.parseLong(paramString) + this.downloadLength);
    }
    for (;;)
    {
      return false;
      if (str.equalsIgnoreCase("content-type"))
      {
        this.report.contentType = paramString;
      }
      else
      {
        if ((str.equalsIgnoreCase("User-ReturnCode")) && (Integer.parseInt(paramString) != 0))
        {
          this.mClientFailed = true;
          this.report.errCode = Integer.parseInt(paramString);
          this.report.errMsg = ("User-ReturnCode is " + this.report.errCode);
          doFinish(5);
          return true;
        }
        if (str.equalsIgnoreCase("x-nws-log-uuid")) {
          this.report.uuid = paramString;
        }
      }
    }
  }
  
  protected boolean handleStateLine(String paramString)
  {
    parseStateLine(paramString);
    if ((this.report.httpStatus != 200) && (this.report.httpStatus != 206))
    {
      this.mClientFailed = true;
      this.report.errCode = this.report.httpStatus;
      doFinish(5);
      return true;
    }
    return false;
  }
  
  void parseBody(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      if (this.savedFile != null)
      {
        this.savedFile.write(paramArrayOfByte, 0, paramInt);
        this.sum += paramInt;
        this.report.fileSize = (this.sum + this.downloadLength);
        float f = (float)this.report.fileSize * 1.0F / (float)this.report.contentLength;
        if ((f - this.currentProgress >= 0.01F) || (f == 1.0F))
        {
          this.currentProgress = f;
          if (this.netListener != null) {
            ((DownloadListener)this.netListener).onDownloadProgress(this.report.url, this.report.contentLength, this.report.fileSize);
          }
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        this.mClientFailed = true;
        this.report.errMsg = paramArrayOfByte.toString();
        this.report.errCode = 10006;
        doFinish(5);
      }
    }
    if (this.report.fileSize == this.report.contentLength)
    {
      finishRecv();
      if (this.mRealQuicCall != null) {
        this.mRealQuicCall.setTransCompleted(true);
      }
    }
  }
  
  /* Error */
  protected void parseResponseHeader(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 96	java/lang/String
    //   6: dup
    //   7: aload_1
    //   8: ldc 9
    //   10: invokespecial 413	java/lang/String:<init>	([BLjava/lang/String;)V
    //   13: astore 7
    //   15: aload_0
    //   16: getfield 73	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   19: aload_0
    //   20: getfield 47	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:headers	Ljava/util/Map;
    //   23: putfield 414	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:headers	Ljava/util/Map;
    //   26: new 416	java/io/ByteArrayInputStream
    //   29: dup
    //   30: aload_1
    //   31: iconst_0
    //   32: iload_2
    //   33: invokespecial 418	java/io/ByteArrayInputStream:<init>	([BII)V
    //   36: astore 6
    //   38: new 303	java/io/BufferedReader
    //   41: dup
    //   42: new 420	java/io/InputStreamReader
    //   45: dup
    //   46: aload 6
    //   48: invokespecial 423	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   51: invokespecial 426	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   54: astore 5
    //   56: aload 5
    //   58: invokevirtual 306	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   61: astore_1
    //   62: iconst_0
    //   63: istore_3
    //   64: aload_1
    //   65: ifnull +215 -> 280
    //   68: aload_1
    //   69: ldc_w 428
    //   72: invokevirtual 431	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   75: ifeq +80 -> 155
    //   78: aload_0
    //   79: aload_1
    //   80: invokevirtual 433	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:handleStateLine	(Ljava/lang/String;)Z
    //   83: istore 4
    //   85: iload 4
    //   87: ifeq +53 -> 140
    //   90: aload 5
    //   92: ifnull +8 -> 100
    //   95: aload 5
    //   97: invokevirtual 434	java/io/BufferedReader:close	()V
    //   100: aload 6
    //   102: ifnull +8 -> 110
    //   105: aload 6
    //   107: invokevirtual 435	java/io/ByteArrayInputStream:close	()V
    //   110: return
    //   111: astore 6
    //   113: aload 6
    //   115: invokevirtual 436	java/lang/Exception:printStackTrace	()V
    //   118: ldc_w 438
    //   121: astore 7
    //   123: goto -108 -> 15
    //   126: astore_1
    //   127: aload_1
    //   128: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   131: goto -31 -> 100
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   139: return
    //   140: iload_3
    //   141: iconst_1
    //   142: iadd
    //   143: istore_2
    //   144: aload 5
    //   146: invokevirtual 306	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   149: astore_1
    //   150: iload_2
    //   151: istore_3
    //   152: goto -88 -> 64
    //   155: aload_1
    //   156: ldc 210
    //   158: invokevirtual 443	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   161: ifeq +57 -> 218
    //   164: aload_0
    //   165: aload_1
    //   166: invokevirtual 445	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:handleHeaderLine	(Ljava/lang/String;)Z
    //   169: istore 4
    //   171: iload 4
    //   173: ifeq +38 -> 211
    //   176: aload 5
    //   178: ifnull +8 -> 186
    //   181: aload 5
    //   183: invokevirtual 434	java/io/BufferedReader:close	()V
    //   186: aload 6
    //   188: ifnull -78 -> 110
    //   191: aload 6
    //   193: invokevirtual 435	java/io/ByteArrayInputStream:close	()V
    //   196: return
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   202: return
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   208: goto -22 -> 186
    //   211: iload_3
    //   212: iconst_1
    //   213: iadd
    //   214: istore_2
    //   215: goto -71 -> 144
    //   218: iload_3
    //   219: istore_2
    //   220: aload_1
    //   221: invokevirtual 100	java/lang/String:length	()I
    //   224: ifne -80 -> 144
    //   227: aload_0
    //   228: aload 7
    //   230: aload 5
    //   232: iload_3
    //   233: invokevirtual 447	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:handleBodyOnParseHeader	(Ljava/lang/String;Ljava/io/BufferedReader;I)Z
    //   236: istore 4
    //   238: iload_3
    //   239: istore_2
    //   240: iload 4
    //   242: ifeq -98 -> 144
    //   245: aload 5
    //   247: ifnull +8 -> 255
    //   250: aload 5
    //   252: invokevirtual 434	java/io/BufferedReader:close	()V
    //   255: aload 6
    //   257: ifnull -147 -> 110
    //   260: aload 6
    //   262: invokevirtual 435	java/io/ByteArrayInputStream:close	()V
    //   265: return
    //   266: astore_1
    //   267: aload_1
    //   268: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   271: return
    //   272: astore_1
    //   273: aload_1
    //   274: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   277: goto -22 -> 255
    //   280: aload 5
    //   282: ifnull +8 -> 290
    //   285: aload 5
    //   287: invokevirtual 434	java/io/BufferedReader:close	()V
    //   290: aload 6
    //   292: ifnull -182 -> 110
    //   295: aload 6
    //   297: invokevirtual 435	java/io/ByteArrayInputStream:close	()V
    //   300: return
    //   301: astore_1
    //   302: aload_1
    //   303: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   306: return
    //   307: astore_1
    //   308: aload_1
    //   309: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   312: goto -22 -> 290
    //   315: astore 6
    //   317: aconst_null
    //   318: astore 7
    //   320: aload 5
    //   322: astore_1
    //   323: aload 7
    //   325: astore 5
    //   327: aload_0
    //   328: iconst_1
    //   329: putfield 61	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:mClientFailed	Z
    //   332: aload_0
    //   333: getfield 73	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   336: aload 6
    //   338: invokevirtual 293	java/lang/Exception:toString	()Ljava/lang/String;
    //   341: putfield 130	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:errMsg	Ljava/lang/String;
    //   344: aload_0
    //   345: getfield 73	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   348: sipush 10001
    //   351: putfield 133	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:errCode	I
    //   354: aload_0
    //   355: iconst_5
    //   356: invokevirtual 136	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:doFinish	(I)V
    //   359: aload 5
    //   361: ifnull +8 -> 369
    //   364: aload 5
    //   366: invokevirtual 434	java/io/BufferedReader:close	()V
    //   369: aload_1
    //   370: ifnull -260 -> 110
    //   373: aload_1
    //   374: invokevirtual 435	java/io/ByteArrayInputStream:close	()V
    //   377: return
    //   378: astore_1
    //   379: aload_1
    //   380: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   383: return
    //   384: astore 5
    //   386: aload 5
    //   388: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   391: goto -22 -> 369
    //   394: astore_1
    //   395: aconst_null
    //   396: astore 5
    //   398: aconst_null
    //   399: astore 6
    //   401: aload 5
    //   403: ifnull +8 -> 411
    //   406: aload 5
    //   408: invokevirtual 434	java/io/BufferedReader:close	()V
    //   411: aload 6
    //   413: ifnull +8 -> 421
    //   416: aload 6
    //   418: invokevirtual 435	java/io/ByteArrayInputStream:close	()V
    //   421: aload_1
    //   422: athrow
    //   423: astore 5
    //   425: aload 5
    //   427: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   430: goto -19 -> 411
    //   433: astore 5
    //   435: aload 5
    //   437: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   440: goto -19 -> 421
    //   443: astore_1
    //   444: aconst_null
    //   445: astore 5
    //   447: goto -46 -> 401
    //   450: astore_1
    //   451: goto -50 -> 401
    //   454: astore 7
    //   456: aload_1
    //   457: astore 6
    //   459: aload 7
    //   461: astore_1
    //   462: goto -61 -> 401
    //   465: astore 7
    //   467: aconst_null
    //   468: astore 5
    //   470: aload 6
    //   472: astore_1
    //   473: aload 7
    //   475: astore 6
    //   477: goto -150 -> 327
    //   480: astore 7
    //   482: aload 6
    //   484: astore_1
    //   485: aload 7
    //   487: astore 6
    //   489: goto -162 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	492	0	this	QuicDownloadTask
    //   0	492	1	paramArrayOfByte	byte[]
    //   0	492	2	paramInt	int
    //   63	176	3	i	int
    //   83	158	4	bool	boolean
    //   1	364	5	localObject1	Object
    //   384	3	5	localIOException1	java.io.IOException
    //   396	11	5	localObject2	Object
    //   423	3	5	localIOException2	java.io.IOException
    //   433	3	5	localIOException3	java.io.IOException
    //   445	24	5	localObject3	Object
    //   36	70	6	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   111	185	6	localException1	Exception
    //   315	22	6	localException2	Exception
    //   399	89	6	localObject4	Object
    //   13	311	7	str	String
    //   454	6	7	localObject5	Object
    //   465	9	7	localException3	Exception
    //   480	6	7	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   3	15	111	java/lang/Exception
    //   95	100	126	java/io/IOException
    //   105	110	134	java/io/IOException
    //   191	196	197	java/io/IOException
    //   181	186	203	java/io/IOException
    //   260	265	266	java/io/IOException
    //   250	255	272	java/io/IOException
    //   295	300	301	java/io/IOException
    //   285	290	307	java/io/IOException
    //   26	38	315	java/lang/Exception
    //   373	377	378	java/io/IOException
    //   364	369	384	java/io/IOException
    //   26	38	394	finally
    //   406	411	423	java/io/IOException
    //   416	421	433	java/io/IOException
    //   38	56	443	finally
    //   56	62	450	finally
    //   68	85	450	finally
    //   144	150	450	finally
    //   155	171	450	finally
    //   220	238	450	finally
    //   327	359	454	finally
    //   38	56	465	java/lang/Exception
    //   56	62	480	java/lang/Exception
    //   68	85	480	java/lang/Exception
    //   144	150	480	java/lang/Exception
    //   155	171	480	java/lang/Exception
    //   220	238	480	java/lang/Exception
  }
  
  public void prepare(QuicNative.QuicCallback paramQuicCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("quic", 4, new Object[] { "prepare ", Integer.valueOf(this.report.id) });
    }
    this.mQuicDownloadRequest = new QuicDownloadRequest(this.report.ip, this.report.port, this.report.url);
    if (this.headers != null) {
      this.mQuicDownloadRequest.setHeader(this.headers);
    }
    this.report.slice = 1;
    this.mRealQuicCall = new QuicNative();
    this.mRealQuicCall.setCallback(paramQuicCallback);
  }
  
  void receiveResponse(byte[] paramArrayOfByte, int paramInt)
  {
    if ((!this.running) || (this.mClosed) || (this.mClientFailed) || (this.mCompleted)) {}
    while (cancelFinishIfNeed()) {
      return;
    }
    if (paramArrayOfByte == null)
    {
      this.mClientFailed = true;
      this.report.errMsg = "receiveResponse data is null.";
      this.report.errCode = 10006;
      doFinish(5);
      return;
    }
    if (this.isHeader)
    {
      this.report.firstPackageCost = (System.currentTimeMillis() - this.sendReqTime);
      parseResponseHeader(paramArrayOfByte, paramInt);
      this.isHeader = false;
      return;
    }
    parseBody(paramArrayOfByte, paramInt);
  }
  
  public void sendData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("quic", 4, new Object[] { Integer.valueOf(this.report.id), " has get a connect" });
    }
    this.report.tConn = (System.currentTimeMillis() - this.startConnTime);
    if ((!this.running) || (this.mClosed) || (this.mClientFailed) || (this.mCompleted)) {}
    for (;;)
    {
      return;
      this.isHeader = true;
      try
      {
        this.sendReqTime = System.currentTimeMillis();
        while (!this.mQuicDownloadRequest.isFinish)
        {
          byte[] arrayOfByte = this.mQuicDownloadRequest.getRequestData();
          this.mRealQuicCall.sendRequest(arrayOfByte, arrayOfByte.length, this.mQuicDownloadRequest.isFinish, this.timeOut);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        handleException(30006, 4);
      }
    }
  }
  
  void startConnect()
  {
    try
    {
      if (!TextUtils.isEmpty(this.report.tempPath))
      {
        this.savedFile = new RandomAccessFile(this.report.tempPath, "rw");
        this.savedFile.seek(this.downloadLength);
      }
      if ((!this.running) || (this.mClosed) || (this.mClientFailed) || (this.mCompleted)) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("quic", 4, localException, new Object[] { this.report.id + " setOutputStream failed" });
        continue;
        if (TextUtils.isEmpty(this.mQuicDownloadRequest.ip))
        {
          handleException(10005, 4);
          return;
        }
        if (TextUtils.isEmpty(this.report.tempPath))
        {
          handleException(10004, 4);
          return;
        }
        try
        {
          if (this.mRealQuicCall != null)
          {
            this.startConnTime = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("quic", 4, new Object[] { "startConnect ", Long.valueOf(this.startConnTime) });
            }
            this.mRealQuicCall.startConnect(this.report.id, this.mQuicDownloadRequest.host, this.mQuicDownloadRequest.ip, this.mQuicDownloadRequest.port, this.encryption, this.fec, this.report.getReportMsg(), this.report.isIpv6, this.report.rttHost);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          handleException(30006, 4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.QuicDownloadTask
 * JD-Core Version:    0.7.0.1
 */