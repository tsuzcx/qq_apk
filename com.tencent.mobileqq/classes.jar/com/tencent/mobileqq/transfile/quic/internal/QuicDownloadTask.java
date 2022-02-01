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
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
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
    return null;
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
        return;
      }
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
    if ((paramString != null) && (paramString.length() != 0))
    {
      int j = paramString.length() / 2;
      byte[] arrayOfByte = new byte[j];
      paramString = paramString.toUpperCase().toCharArray();
      int i = 0;
      while (i < j)
      {
        int k = i * 2;
        int m = charToByte(paramString[k]);
        arrayOfByte[i] = ((byte)(charToByte(paramString[(k + 1)]) | m << 4));
        i += 1;
      }
      return arrayOfByte;
    }
    return null;
  }
  
  void connectionClose(int paramInt, String paramString)
  {
    if (this.running)
    {
      if (this.mClosed) {
        return;
      }
      this.mClosed = true;
      if ((!this.mCompleted) && (!this.mClientFailed))
      {
        try
        {
          if (this.mRealQuicCall != null)
          {
            this.report.extra = this.mRealQuicCall.getState();
            this.report.srvMessage = this.mRealQuicCall.getSrvMessage();
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          localUnsatisfiedLinkError.printStackTrace();
        }
        this.report.errCode = (paramInt + 20000);
        this.report.errMsg = paramString;
        handleException(this.report.errCode, 3);
      }
      clear();
      if (this.handler != null)
      {
        paramString = Message.obtain();
        paramString.what = 7;
        paramString.obj = this;
        this.handler.handleMessage(paramString);
      }
      this.running = false;
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
      QLog.e("quic", 4, localUnsatisfiedLinkError1, new Object[0]);
    }
    try
    {
      if (this.savedFile != null) {
        this.savedFile.close();
      }
    }
    catch (Exception localException)
    {
      this.report.errMsg = localException.toString();
    }
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt == 10) {
          handleException(this.report.errCode, 9);
        }
      }
      else {
        handleException(this.report.errCode, 4);
      }
    }
    else {
      handleFinish(this.report.tempPath);
    }
    if (paramInt != 5) {
      return;
    }
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
    Object localObject = paramString.substring(0, i).trim();
    paramString = paramString.substring(i + 1).trim();
    this.headers.put(localObject, paramString);
    if (((String)localObject).equalsIgnoreCase("content-length"))
    {
      this.report.contentLength = (Long.parseLong(paramString) + this.downloadLength);
      return false;
    }
    if (((String)localObject).equalsIgnoreCase("content-type"))
    {
      this.report.contentType = paramString;
      return false;
    }
    if ((((String)localObject).equalsIgnoreCase("User-ReturnCode")) && (Integer.parseInt(paramString) != 0))
    {
      this.mClientFailed = true;
      this.report.errCode = Integer.parseInt(paramString);
      paramString = this.report;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("User-ReturnCode is ");
      ((StringBuilder)localObject).append(this.report.errCode);
      paramString.errMsg = ((StringBuilder)localObject).toString();
      doFinish(5);
      return true;
    }
    if (((String)localObject).equalsIgnoreCase("x-nws-log-uuid")) {
      this.report.uuid = paramString;
    }
    return false;
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
      this.mClientFailed = true;
      this.report.errMsg = paramArrayOfByte.toString();
      this.report.errCode = 10006;
      doFinish(5);
    }
    if (this.report.fileSize == this.report.contentLength)
    {
      finishRecv();
      paramArrayOfByte = this.mRealQuicCall;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.setTransCompleted(true);
      }
    }
  }
  
  /* Error */
  protected void parseResponseHeader(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: new 96	java/lang/String
    //   3: dup
    //   4: aload_1
    //   5: ldc 9
    //   7: invokespecial 413	java/lang/String:<init>	([BLjava/lang/String;)V
    //   10: astore 7
    //   12: goto +15 -> 27
    //   15: astore 5
    //   17: aload 5
    //   19: invokevirtual 414	java/lang/Exception:printStackTrace	()V
    //   22: ldc_w 416
    //   25: astore 7
    //   27: aload_0
    //   28: getfield 73	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   31: aload_0
    //   32: getfield 47	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:headers	Ljava/util/Map;
    //   35: putfield 417	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:headers	Ljava/util/Map;
    //   38: aconst_null
    //   39: astore 6
    //   41: aconst_null
    //   42: astore 5
    //   44: aconst_null
    //   45: astore 9
    //   47: iconst_0
    //   48: istore_3
    //   49: new 419	java/io/ByteArrayInputStream
    //   52: dup
    //   53: aload_1
    //   54: iconst_0
    //   55: iload_2
    //   56: invokespecial 421	java/io/ByteArrayInputStream:<init>	([BII)V
    //   59: astore_1
    //   60: aload 6
    //   62: astore 5
    //   64: aload_1
    //   65: astore 6
    //   67: new 303	java/io/BufferedReader
    //   70: dup
    //   71: new 423	java/io/InputStreamReader
    //   74: dup
    //   75: aload_1
    //   76: invokespecial 426	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   79: invokespecial 429	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   82: astore 8
    //   84: aload 8
    //   86: invokevirtual 306	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   89: astore 5
    //   91: iload_3
    //   92: istore_2
    //   93: aload 5
    //   95: ifnull +175 -> 270
    //   98: aload 5
    //   100: ldc_w 431
    //   103: invokevirtual 434	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   106: ifeq +49 -> 155
    //   109: aload_0
    //   110: aload 5
    //   112: invokevirtual 436	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:handleStateLine	(Ljava/lang/String;)Z
    //   115: istore 4
    //   117: iload 4
    //   119: ifeq +29 -> 148
    //   122: aload 8
    //   124: invokevirtual 437	java/io/BufferedReader:close	()V
    //   127: goto +10 -> 137
    //   130: astore 5
    //   132: aload 5
    //   134: invokevirtual 438	java/io/IOException:printStackTrace	()V
    //   137: aload_1
    //   138: invokevirtual 439	java/io/ByteArrayInputStream:close	()V
    //   141: return
    //   142: astore_1
    //   143: aload_1
    //   144: invokevirtual 438	java/io/IOException:printStackTrace	()V
    //   147: return
    //   148: iload_2
    //   149: iconst_1
    //   150: iadd
    //   151: istore_3
    //   152: goto +106 -> 258
    //   155: aload 5
    //   157: ldc 210
    //   159: invokevirtual 443	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   162: ifeq +42 -> 204
    //   165: aload_0
    //   166: aload 5
    //   168: invokevirtual 445	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:handleHeaderLine	(Ljava/lang/String;)Z
    //   171: istore 4
    //   173: iload 4
    //   175: ifeq -27 -> 148
    //   178: aload 8
    //   180: invokevirtual 437	java/io/BufferedReader:close	()V
    //   183: goto +10 -> 193
    //   186: astore 5
    //   188: aload 5
    //   190: invokevirtual 438	java/io/IOException:printStackTrace	()V
    //   193: aload_1
    //   194: invokevirtual 439	java/io/ByteArrayInputStream:close	()V
    //   197: return
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 438	java/io/IOException:printStackTrace	()V
    //   203: return
    //   204: iload_2
    //   205: istore_3
    //   206: aload 5
    //   208: invokevirtual 100	java/lang/String:length	()I
    //   211: ifne +47 -> 258
    //   214: aload_0
    //   215: aload 7
    //   217: aload 8
    //   219: iload_2
    //   220: invokevirtual 447	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:handleBodyOnParseHeader	(Ljava/lang/String;Ljava/io/BufferedReader;I)Z
    //   223: istore 4
    //   225: iload_2
    //   226: istore_3
    //   227: iload 4
    //   229: ifeq +29 -> 258
    //   232: aload 8
    //   234: invokevirtual 437	java/io/BufferedReader:close	()V
    //   237: goto +10 -> 247
    //   240: astore 5
    //   242: aload 5
    //   244: invokevirtual 438	java/io/IOException:printStackTrace	()V
    //   247: aload_1
    //   248: invokevirtual 439	java/io/ByteArrayInputStream:close	()V
    //   251: return
    //   252: astore_1
    //   253: aload_1
    //   254: invokevirtual 438	java/io/IOException:printStackTrace	()V
    //   257: return
    //   258: aload 8
    //   260: invokevirtual 306	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   263: astore 5
    //   265: iload_3
    //   266: istore_2
    //   267: goto -174 -> 93
    //   270: aload 8
    //   272: invokevirtual 437	java/io/BufferedReader:close	()V
    //   275: goto +10 -> 285
    //   278: astore 5
    //   280: aload 5
    //   282: invokevirtual 438	java/io/IOException:printStackTrace	()V
    //   285: aload_1
    //   286: invokevirtual 439	java/io/ByteArrayInputStream:close	()V
    //   289: return
    //   290: astore 7
    //   292: aload 8
    //   294: astore 5
    //   296: goto +140 -> 436
    //   299: astore 5
    //   301: aload 8
    //   303: astore 7
    //   305: aload 5
    //   307: astore 8
    //   309: goto +27 -> 336
    //   312: astore 8
    //   314: aload 9
    //   316: astore 7
    //   318: goto +18 -> 336
    //   321: astore 7
    //   323: aconst_null
    //   324: astore_1
    //   325: goto +111 -> 436
    //   328: astore 8
    //   330: aconst_null
    //   331: astore_1
    //   332: aload 9
    //   334: astore 7
    //   336: aload 7
    //   338: astore 5
    //   340: aload_1
    //   341: astore 6
    //   343: aload_0
    //   344: iconst_1
    //   345: putfield 61	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:mClientFailed	Z
    //   348: aload 7
    //   350: astore 5
    //   352: aload_1
    //   353: astore 6
    //   355: aload_0
    //   356: getfield 73	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   359: aload 8
    //   361: invokevirtual 293	java/lang/Exception:toString	()Ljava/lang/String;
    //   364: putfield 130	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:errMsg	Ljava/lang/String;
    //   367: aload 7
    //   369: astore 5
    //   371: aload_1
    //   372: astore 6
    //   374: aload_0
    //   375: getfield 73	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:report	Lcom/tencent/mobileqq/transfile/quic/report/QuicNetReport;
    //   378: sipush 10001
    //   381: putfield 133	com/tencent/mobileqq/transfile/quic/report/QuicNetReport:errCode	I
    //   384: aload 7
    //   386: astore 5
    //   388: aload_1
    //   389: astore 6
    //   391: aload_0
    //   392: iconst_5
    //   393: invokevirtual 136	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadTask:doFinish	(I)V
    //   396: aload 7
    //   398: ifnull +18 -> 416
    //   401: aload 7
    //   403: invokevirtual 437	java/io/BufferedReader:close	()V
    //   406: goto +10 -> 416
    //   409: astore 5
    //   411: aload 5
    //   413: invokevirtual 438	java/io/IOException:printStackTrace	()V
    //   416: aload_1
    //   417: ifnull +13 -> 430
    //   420: aload_1
    //   421: invokevirtual 439	java/io/ByteArrayInputStream:close	()V
    //   424: return
    //   425: astore_1
    //   426: aload_1
    //   427: invokevirtual 438	java/io/IOException:printStackTrace	()V
    //   430: return
    //   431: astore 7
    //   433: aload 6
    //   435: astore_1
    //   436: aload 5
    //   438: ifnull +18 -> 456
    //   441: aload 5
    //   443: invokevirtual 437	java/io/BufferedReader:close	()V
    //   446: goto +10 -> 456
    //   449: astore 5
    //   451: aload 5
    //   453: invokevirtual 438	java/io/IOException:printStackTrace	()V
    //   456: aload_1
    //   457: ifnull +15 -> 472
    //   460: aload_1
    //   461: invokevirtual 439	java/io/ByteArrayInputStream:close	()V
    //   464: goto +8 -> 472
    //   467: astore_1
    //   468: aload_1
    //   469: invokevirtual 438	java/io/IOException:printStackTrace	()V
    //   472: goto +6 -> 478
    //   475: aload 7
    //   477: athrow
    //   478: goto -3 -> 475
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	481	0	this	QuicDownloadTask
    //   0	481	1	paramArrayOfByte	byte[]
    //   0	481	2	paramInt	int
    //   48	218	3	i	int
    //   115	113	4	bool	boolean
    //   15	3	5	localException1	Exception
    //   42	69	5	localObject1	Object
    //   130	37	5	localIOException1	java.io.IOException
    //   186	21	5	localIOException2	java.io.IOException
    //   240	3	5	localIOException3	java.io.IOException
    //   263	1	5	str1	String
    //   278	3	5	localIOException4	java.io.IOException
    //   294	1	5	localObject2	Object
    //   299	7	5	localException2	Exception
    //   338	49	5	localObject3	Object
    //   409	33	5	localIOException5	java.io.IOException
    //   449	3	5	localIOException6	java.io.IOException
    //   39	395	6	arrayOfByte	byte[]
    //   10	206	7	str2	String
    //   290	1	7	localObject4	Object
    //   303	14	7	localObject5	Object
    //   321	1	7	localObject6	Object
    //   334	68	7	localObject7	Object
    //   431	45	7	localObject8	Object
    //   82	226	8	localObject9	Object
    //   312	1	8	localException3	Exception
    //   328	32	8	localException4	Exception
    //   45	288	9	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   0	12	15	java/lang/Exception
    //   122	127	130	java/io/IOException
    //   137	141	142	java/io/IOException
    //   178	183	186	java/io/IOException
    //   193	197	198	java/io/IOException
    //   232	237	240	java/io/IOException
    //   247	251	252	java/io/IOException
    //   270	275	278	java/io/IOException
    //   84	91	290	finally
    //   98	117	290	finally
    //   155	173	290	finally
    //   206	225	290	finally
    //   258	265	290	finally
    //   84	91	299	java/lang/Exception
    //   98	117	299	java/lang/Exception
    //   155	173	299	java/lang/Exception
    //   206	225	299	java/lang/Exception
    //   258	265	299	java/lang/Exception
    //   67	84	312	java/lang/Exception
    //   49	60	321	finally
    //   49	60	328	java/lang/Exception
    //   401	406	409	java/io/IOException
    //   285	289	425	java/io/IOException
    //   420	424	425	java/io/IOException
    //   67	84	431	finally
    //   343	348	431	finally
    //   355	367	431	finally
    //   374	384	431	finally
    //   391	396	431	finally
    //   441	446	449	java/io/IOException
    //   460	464	467	java/io/IOException
  }
  
  public void prepare(QuicNative.QuicCallback paramQuicCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("quic", 4, new Object[] { "prepare ", Integer.valueOf(this.report.id) });
    }
    this.mQuicDownloadRequest = new QuicDownloadRequest(this.report.ip, this.report.port, this.report.url);
    Map localMap = this.headers;
    if (localMap != null) {
      this.mQuicDownloadRequest.setHeader(localMap);
    }
    this.report.slice = 1;
    this.mRealQuicCall = new QuicNative();
    this.mRealQuicCall.setCallback(paramQuicCallback);
  }
  
  void receiveResponse(byte[] paramArrayOfByte, int paramInt)
  {
    if ((this.running) && (!this.mClosed) && (!this.mClientFailed))
    {
      if (this.mCompleted) {
        return;
      }
      if (cancelFinishIfNeed()) {
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
  }
  
  public void sendData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("quic", 4, new Object[] { Integer.valueOf(this.report.id), " has get a connect" });
    }
    this.report.tConn = (System.currentTimeMillis() - this.startConnTime);
    if ((this.running) && (!this.mClosed) && (!this.mClientFailed))
    {
      if (this.mCompleted) {
        return;
      }
      this.isHeader = true;
    }
    try
    {
      this.sendReqTime = System.currentTimeMillis();
      while (!this.mQuicDownloadRequest.isFinish)
      {
        byte[] arrayOfByte = this.mQuicDownloadRequest.getRequestData();
        this.mRealQuicCall.sendRequest(arrayOfByte, arrayOfByte.length, this.mQuicDownloadRequest.isFinish, this.timeOut);
      }
    }
    catch (Throwable localThrowable)
    {
      label133:
      break label133;
    }
    handleException(30006, 4);
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
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.report.id);
      localStringBuilder.append(" setOutputStream failed");
      QLog.e("quic", 4, localException, new Object[] { localStringBuilder.toString() });
    }
    if ((this.running) && (!this.mClosed) && (!this.mClientFailed))
    {
      if (this.mCompleted) {
        return;
      }
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
    }
    try
    {
      if (this.mRealQuicCall == null) {
        break label287;
      }
      this.startConnTime = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("quic", 4, new Object[] { "startConnect ", Long.valueOf(this.startConnTime) });
      }
      this.mRealQuicCall.startConnect(this.report.id, this.mQuicDownloadRequest.host, this.mQuicDownloadRequest.ip, this.mQuicDownloadRequest.port, this.encryption, this.fec, this.report.getReportMsg(), this.report.isIpv6, this.report.rttHost);
      return;
    }
    catch (Throwable localThrowable)
    {
      label279:
      label287:
      break label279;
    }
    handleException(30006, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.QuicDownloadTask
 * JD-Core Version:    0.7.0.1
 */