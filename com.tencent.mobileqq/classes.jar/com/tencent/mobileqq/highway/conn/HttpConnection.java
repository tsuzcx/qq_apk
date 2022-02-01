package com.tencent.mobileqq.highway.conn;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.highway.codec.IProtocolCodecListener;
import com.tencent.mobileqq.highway.codec.TcpProtocolDataCodec;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.segment.IRequestListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class HttpConnection
  implements IProtocolCodecListener, IConnection
{
  private static final String BIG_DATA_HIGHWAY_URL = "/cgi-bin/httpconn?htcmd=0x6ff0082";
  private static final int MAX_REDIRECT_NUM = 5;
  private int iErrCode = 0;
  private boolean isIpv6;
  private int mConnId;
  private IConnectionListener mConnListener;
  private HttpURLConnection mConnection;
  private ConnManager mConnmanager;
  private EndPoint mCurrentPoint;
  private TcpProtocolDataCodec mDataCodec;
  private HandlerThread mExecutor;
  private Handler mHandler;
  private String mStrErrInfo = "";
  
  public HttpConnection(ConnManager paramConnManager, int paramInt, EndPoint paramEndPoint, boolean paramBoolean)
  {
    this.mConnmanager = paramConnManager;
    this.mConnId = paramInt;
    this.mCurrentPoint = paramEndPoint;
    paramConnManager = new StringBuilder();
    paramConnManager.append("BDH-HTTP-");
    paramConnManager.append(paramInt);
    this.mExecutor = new HandlerThread(paramConnManager.toString());
    this.isIpv6 = paramBoolean;
  }
  
  private void doSendRequest()
  {
    BdhLogUtil.LogEvent("C", "[HttpConn] doSendRequest about to peak one request.");
    HwRequest localHwRequest = this.mConnmanager.pullNextRequest(this, false, 0L, 0L, 0);
    if (localHwRequest == null) {
      return;
    }
    this.mDataCodec = new TcpProtocolDataCodec();
    this.mDataCodec.setProtocolCodecListener(this);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[HttpConn] doSendRequest continue to send. ReqInfo : ");
    ((StringBuilder)localObject).append(localHwRequest.toString());
    BdhLogUtil.LogEvent("C", ((StringBuilder)localObject).toString());
    localHwRequest.endpoint = this.mCurrentPoint;
    localObject = localHwRequest.getRequestBody();
    if ((localObject == null) && (localHwRequest.hasRequestBody()))
    {
      localHwRequest.reqListener.handleError(-1004, "NullBody", this);
      wakeupChannel();
      return;
    }
    handleHttpReqData(localHwRequest, this.mDataCodec.encodeC2SData(this.mCurrentPoint, localHwRequest, (byte[])localObject), localHwRequest.mBuCmdId);
    if (this.iErrCode == 0)
    {
      wakeupChannel();
      return;
    }
    localHwRequest.reqListener.handleError(this.iErrCode, this.mStrErrInfo, this);
    if (this.iErrCode == -1014) {
      stopConnThread();
    }
  }
  
  private String getBdhConnURL()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.isIpv6)
    {
      localStringBuilder.append("http://");
      localStringBuilder.append("[");
      localStringBuilder.append(this.mCurrentPoint.host);
      localStringBuilder.append("]");
    }
    else
    {
      localStringBuilder.append("http://");
      localStringBuilder.append(this.mCurrentPoint.host);
    }
    if (this.mCurrentPoint.port != 80)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(this.mCurrentPoint.port);
    }
    localStringBuilder.append("/cgi-bin/httpconn?htcmd=0x6ff0082");
    return localStringBuilder.toString();
  }
  
  private HttpURLConnection getConnection(String paramString, HashMap<String, String> paramHashMap, long paramLong, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[HttpConn] Open Connection. Try Open : ");
    ((StringBuilder)localObject).append(paramString);
    BdhLogUtil.LogEvent("C", ((StringBuilder)localObject).toString());
    String str = android.net.Proxy.getDefaultHost();
    int m = android.net.Proxy.getDefaultPort();
    localObject = null;
    paramInt = 0;
    int i = 0;
    while ((paramInt == 0) && (i < 2))
    {
      localObject = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      int k = -1;
      if (localObject != null)
      {
        k = ((NetworkInfo)localObject).getType();
        localObject = ((NetworkInfo)localObject).getExtraInfo();
      }
      else
      {
        localObject = null;
      }
      localObject = BdhUtils.getApnType((String)localObject);
      if ((k != 1) && (!((String)localObject).toLowerCase().equals(BdhUtils.APN_TYPE_CMWAP))) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      int j = paramInt;
      if (k == 1) {
        if (!"10.0.0.172".equals(str))
        {
          j = paramInt;
          if (!"10.0.0.200".equals(str)) {}
        }
        else
        {
          j = 1;
        }
      }
      if ((str != null) && (m > 0)) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if ((j == 0) && (paramInt != 0))
      {
        if ((!((String)localObject).equals(BdhUtils.APN_TYPE_CMWAP)) && (!((String)localObject).equals(BdhUtils.APN_TYPE_UNIWAP)) && (!((String)localObject).equals(BdhUtils.APN_TYPE_3GWAP)))
        {
          if (((String)localObject).equals(BdhUtils.APN_TYPE_CTWAP)) {
            localObject = BdhUtils.getConnectionWithDefaultProxy(paramString, str, m);
          } else {
            localObject = BdhUtils.getConnectionWithDefaultProxy(paramString, str, m);
          }
        }
        else {
          localObject = BdhUtils.getConnectionWithXOnlineHost(paramString, str, m);
        }
        j = 1;
      }
      else
      {
        localObject = (HttpURLConnection)new URL(paramString).openConnection(java.net.Proxy.NO_PROXY);
        j = 0;
      }
      ((HttpURLConnection)localObject).setConnectTimeout(30000);
      ((HttpURLConnection)localObject).setReadTimeout(30000);
      ((HttpURLConnection)localObject).setInstanceFollowRedirects(false);
      ((HttpURLConnection)localObject).setDoOutput(true);
      ((HttpURLConnection)localObject).setFixedLengthStreamingMode((int)paramLong);
      ((HttpURLConnection)localObject).addRequestProperty("Accept-Encoding", "identity");
      ((HttpURLConnection)localObject).addRequestProperty("Connection", "close");
      Iterator localIterator = paramHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((HttpURLConnection)localObject).setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      try
      {
        ((HttpURLConnection)localObject).connect();
        paramInt = 1;
      }
      catch (Throwable localThrowable)
      {
        if (paramInt == 0) {
          break label501;
        }
      }
      if ((j != 0) && (paramInt != 0)) {}
      for (;;)
      {
        paramInt = 0;
        break;
        if ((paramInt == 0) || (j != 0)) {
          break label498;
        }
      }
      i += 1;
      continue;
      label498:
      throw localThrowable;
      label501:
      throw localThrowable;
    }
    BdhLogUtil.LogEvent("C", "[HttpConn] Open Connection Succ.");
    return localObject;
  }
  
  /* Error */
  private void handleHttpReqData(HwRequest paramHwRequest, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +956 -> 957
    //   4: aload_2
    //   5: arraylength
    //   6: ifgt +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: iconst_0
    //   12: putfield 41	com/tencent/mobileqq/highway/conn/HttpConnection:iErrCode	I
    //   15: aload_0
    //   16: invokespecial 344	com/tencent/mobileqq/highway/conn/HttpConnection:getBdhConnURL	()Ljava/lang/String;
    //   19: astore 9
    //   21: new 301	java/util/HashMap
    //   24: dup
    //   25: invokespecial 345	java/util/HashMap:<init>	()V
    //   28: astore 14
    //   30: aconst_null
    //   31: astore 10
    //   33: aconst_null
    //   34: astore 13
    //   36: aconst_null
    //   37: astore 11
    //   39: aconst_null
    //   40: astore 12
    //   42: aconst_null
    //   43: astore 6
    //   45: iconst_0
    //   46: istore 4
    //   48: aload 6
    //   50: astore 7
    //   52: aload 6
    //   54: astore 8
    //   56: aload_1
    //   57: getfield 135	com/tencent/mobileqq/highway/segment/HwRequest:reqListener	Lcom/tencent/mobileqq/highway/segment/IRequestListener;
    //   60: ifnull +24 -> 84
    //   63: aload 6
    //   65: astore 7
    //   67: aload 6
    //   69: astore 8
    //   71: aload_1
    //   72: getfield 135	com/tencent/mobileqq/highway/segment/HwRequest:reqListener	Lcom/tencent/mobileqq/highway/segment/IRequestListener;
    //   75: aload_0
    //   76: getfield 49	com/tencent/mobileqq/highway/conn/HttpConnection:mConnId	I
    //   79: invokeinterface 348 2 0
    //   84: aload 6
    //   86: astore 7
    //   88: aload 6
    //   90: astore 8
    //   92: aload_0
    //   93: aload_0
    //   94: aload 9
    //   96: aload 14
    //   98: aload_2
    //   99: arraylength
    //   100: i2l
    //   101: iload_3
    //   102: invokespecial 350	com/tencent/mobileqq/highway/conn/HttpConnection:getConnection	(Ljava/lang/String;Ljava/util/HashMap;JI)Ljava/net/HttpURLConnection;
    //   105: putfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   108: aload 6
    //   110: astore 7
    //   112: aload 6
    //   114: astore 8
    //   116: aload_0
    //   117: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   120: invokevirtual 356	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   123: astore 6
    //   125: iconst_0
    //   126: istore 5
    //   128: aload 6
    //   130: astore 7
    //   132: aload 6
    //   134: astore 8
    //   136: iload 5
    //   138: aload_2
    //   139: arraylength
    //   140: if_icmpge +54 -> 194
    //   143: aload 6
    //   145: astore 7
    //   147: aload 6
    //   149: astore 8
    //   151: aload 6
    //   153: aload_2
    //   154: iload 5
    //   156: sipush 10240
    //   159: aload_2
    //   160: arraylength
    //   161: iload 5
    //   163: isub
    //   164: invokestatic 362	java/lang/Math:min	(II)I
    //   167: invokevirtual 368	java/io/OutputStream:write	([BII)V
    //   170: aload 6
    //   172: astore 7
    //   174: aload 6
    //   176: astore 8
    //   178: aload 6
    //   180: invokevirtual 371	java/io/OutputStream:flush	()V
    //   183: iload 5
    //   185: sipush 10240
    //   188: iadd
    //   189: istore 5
    //   191: goto -63 -> 128
    //   194: aload 6
    //   196: astore 7
    //   198: aload 6
    //   200: astore 8
    //   202: aload_1
    //   203: getfield 135	com/tencent/mobileqq/highway/segment/HwRequest:reqListener	Lcom/tencent/mobileqq/highway/segment/IRequestListener;
    //   206: ifnull +28 -> 234
    //   209: aload 6
    //   211: astore 7
    //   213: aload 6
    //   215: astore 8
    //   217: aload_1
    //   218: getfield 135	com/tencent/mobileqq/highway/segment/HwRequest:reqListener	Lcom/tencent/mobileqq/highway/segment/IRequestListener;
    //   221: aload_0
    //   222: getfield 49	com/tencent/mobileqq/highway/conn/HttpConnection:mConnId	I
    //   225: aload_0
    //   226: invokevirtual 374	com/tencent/mobileqq/highway/conn/HttpConnection:getProtoType	()I
    //   229: invokeinterface 378 3 0
    //   234: aload 6
    //   236: astore 7
    //   238: aload 6
    //   240: astore 8
    //   242: ldc 92
    //   244: ldc_w 380
    //   247: invokestatic 100	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload 6
    //   252: astore 7
    //   254: aload 6
    //   256: astore 8
    //   258: aload_0
    //   259: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   262: invokevirtual 383	java/net/HttpURLConnection:getResponseCode	()I
    //   265: istore 5
    //   267: aload 6
    //   269: astore 7
    //   271: aload 6
    //   273: astore 8
    //   275: new 53	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   282: astore 9
    //   284: aload 6
    //   286: astore 7
    //   288: aload 6
    //   290: astore 8
    //   292: aload 9
    //   294: ldc_w 385
    //   297: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 6
    //   303: astore 7
    //   305: aload 6
    //   307: astore 8
    //   309: aload 9
    //   311: iload 5
    //   313: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 6
    //   319: astore 7
    //   321: aload 6
    //   323: astore 8
    //   325: ldc 92
    //   327: aload 9
    //   329: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 100	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: iload 5
    //   337: sipush 200
    //   340: if_icmpeq +200 -> 540
    //   343: iload 5
    //   345: sipush 206
    //   348: if_icmpne +652 -> 1000
    //   351: goto +189 -> 540
    //   354: aload 6
    //   356: astore 7
    //   358: aload 6
    //   360: astore 8
    //   362: aload_0
    //   363: sipush -1013
    //   366: putfield 41	com/tencent/mobileqq/highway/conn/HttpConnection:iErrCode	I
    //   369: aload 6
    //   371: astore 7
    //   373: aload 6
    //   375: astore 8
    //   377: aload_0
    //   378: aload_0
    //   379: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   382: invokevirtual 389	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   385: invokevirtual 118	java/lang/Object:toString	()Ljava/lang/String;
    //   388: putfield 45	com/tencent/mobileqq/highway/conn/HttpConnection:mStrErrInfo	Ljava/lang/String;
    //   391: goto +628 -> 1019
    //   394: iload 4
    //   396: iconst_5
    //   397: if_icmpge +103 -> 500
    //   400: aload 6
    //   402: astore 7
    //   404: aload 6
    //   406: astore 8
    //   408: aload_0
    //   409: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   412: ldc_w 391
    //   415: invokevirtual 394	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   418: astore 9
    //   420: aload 9
    //   422: ifnull +78 -> 500
    //   425: aload 6
    //   427: astore 7
    //   429: aload 6
    //   431: astore 8
    //   433: aload 9
    //   435: invokevirtual 397	java/lang/String:length	()I
    //   438: istore 5
    //   440: iload 5
    //   442: ifle +58 -> 500
    //   445: aload 6
    //   447: ifnull +12 -> 459
    //   450: aload 6
    //   452: astore 7
    //   454: aload 6
    //   456: invokevirtual 399	java/io/OutputStream:close	()V
    //   459: aload 6
    //   461: astore 7
    //   463: aload_0
    //   464: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   467: invokevirtual 402	java/net/HttpURLConnection:disconnect	()V
    //   470: aload 6
    //   472: astore 7
    //   474: aload 6
    //   476: astore 8
    //   478: aload 14
    //   480: ldc_w 404
    //   483: aload_0
    //   484: invokespecial 344	com/tencent/mobileqq/highway/conn/HttpConnection:getBdhConnURL	()Ljava/lang/String;
    //   487: invokevirtual 408	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   490: pop
    //   491: iload 4
    //   493: iconst_1
    //   494: iadd
    //   495: istore 4
    //   497: goto -449 -> 48
    //   500: aload 6
    //   502: astore 7
    //   504: aload 6
    //   506: astore 8
    //   508: aload_0
    //   509: sipush -1013
    //   512: putfield 41	com/tencent/mobileqq/highway/conn/HttpConnection:iErrCode	I
    //   515: aload 6
    //   517: astore 7
    //   519: aload 6
    //   521: astore 8
    //   523: aload_0
    //   524: aload_0
    //   525: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   528: invokevirtual 389	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   531: invokevirtual 118	java/lang/Object:toString	()Ljava/lang/String;
    //   534: putfield 45	com/tencent/mobileqq/highway/conn/HttpConnection:mStrErrInfo	Ljava/lang/String;
    //   537: goto +482 -> 1019
    //   540: aload 6
    //   542: astore 7
    //   544: aload 6
    //   546: astore 8
    //   548: aload_0
    //   549: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   552: invokevirtual 412	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   555: astore_1
    //   556: aload_1
    //   557: astore_2
    //   558: aload 13
    //   560: astore 7
    //   562: aload 6
    //   564: astore 8
    //   566: new 414	java/io/ByteArrayOutputStream
    //   569: dup
    //   570: invokespecial 415	java/io/ByteArrayOutputStream:<init>	()V
    //   573: astore 9
    //   575: sipush 10240
    //   578: newarray byte
    //   580: astore_2
    //   581: goto +446 -> 1027
    //   584: aload_1
    //   585: aload_2
    //   586: iload_3
    //   587: aload_2
    //   588: arraylength
    //   589: iload_3
    //   590: isub
    //   591: invokevirtual 421	java/io/InputStream:read	([BII)I
    //   594: istore 4
    //   596: iload 4
    //   598: ifle +28 -> 626
    //   601: iload_3
    //   602: iload 4
    //   604: iadd
    //   605: istore 4
    //   607: iload 4
    //   609: istore_3
    //   610: iload 4
    //   612: aload_2
    //   613: arraylength
    //   614: if_icmplt -30 -> 584
    //   617: aload 9
    //   619: aload_2
    //   620: invokevirtual 424	java/io/ByteArrayOutputStream:write	([B)V
    //   623: goto +404 -> 1027
    //   626: iload_3
    //   627: ifle +11 -> 638
    //   630: aload 9
    //   632: aload_2
    //   633: iconst_0
    //   634: iload_3
    //   635: invokevirtual 425	java/io/ByteArrayOutputStream:write	([BII)V
    //   638: aload 9
    //   640: invokevirtual 426	java/io/ByteArrayOutputStream:flush	()V
    //   643: aload 9
    //   645: invokevirtual 429	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   648: astore_2
    //   649: aload_0
    //   650: getfield 111	com/tencent/mobileqq/highway/conn/HttpConnection:mDataCodec	Lcom/tencent/mobileqq/highway/codec/TcpProtocolDataCodec;
    //   653: aload_2
    //   654: invokevirtual 433	com/tencent/mobileqq/highway/codec/TcpProtocolDataCodec:decodeS2CData	([B)Z
    //   657: pop
    //   658: ldc 92
    //   660: ldc_w 435
    //   663: invokestatic 100	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   666: aload 9
    //   668: invokevirtual 436	java/io/ByteArrayOutputStream:close	()V
    //   671: aload 9
    //   673: astore_2
    //   674: aload_2
    //   675: ifnull +14 -> 689
    //   678: aload_2
    //   679: invokevirtual 436	java/io/ByteArrayOutputStream:close	()V
    //   682: goto +7 -> 689
    //   685: astore_1
    //   686: goto +39 -> 725
    //   689: aload_1
    //   690: ifnull +10 -> 700
    //   693: aload_1
    //   694: invokevirtual 437	java/io/InputStream:close	()V
    //   697: goto +3 -> 700
    //   700: aload 6
    //   702: ifnull +8 -> 710
    //   705: aload 6
    //   707: invokevirtual 399	java/io/OutputStream:close	()V
    //   710: aload_0
    //   711: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   714: ifnull +15 -> 729
    //   717: aload_0
    //   718: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   721: invokevirtual 402	java/net/HttpURLConnection:disconnect	()V
    //   724: return
    //   725: aload_1
    //   726: invokevirtual 440	java/lang/Exception:printStackTrace	()V
    //   729: return
    //   730: astore_2
    //   731: aload 9
    //   733: astore 7
    //   735: goto +149 -> 884
    //   738: astore_2
    //   739: aload 9
    //   741: astore 10
    //   743: aload_2
    //   744: astore 9
    //   746: goto +30 -> 776
    //   749: astore 9
    //   751: goto +25 -> 776
    //   754: astore_1
    //   755: aconst_null
    //   756: astore_2
    //   757: aload 11
    //   759: astore 9
    //   761: aload 7
    //   763: astore 6
    //   765: goto +131 -> 896
    //   768: astore 9
    //   770: aconst_null
    //   771: astore_1
    //   772: aload 8
    //   774: astore 6
    //   776: aload_1
    //   777: astore_2
    //   778: aload 10
    //   780: astore 7
    //   782: aload 6
    //   784: astore 8
    //   786: aload_0
    //   787: sipush -1003
    //   790: putfield 41	com/tencent/mobileqq/highway/conn/HttpConnection:iErrCode	I
    //   793: aload_1
    //   794: astore_2
    //   795: aload 10
    //   797: astore 7
    //   799: aload 6
    //   801: astore 8
    //   803: aload_0
    //   804: aload 9
    //   806: invokevirtual 444	java/lang/Object:getClass	()Ljava/lang/Class;
    //   809: invokevirtual 449	java/lang/Class:getName	()Ljava/lang/String;
    //   812: putfield 45	com/tencent/mobileqq/highway/conn/HttpConnection:mStrErrInfo	Ljava/lang/String;
    //   815: aload 10
    //   817: ifnull +15 -> 832
    //   820: aload 10
    //   822: invokevirtual 436	java/io/ByteArrayOutputStream:close	()V
    //   825: goto +7 -> 832
    //   828: astore_1
    //   829: goto +39 -> 868
    //   832: aload_1
    //   833: ifnull +10 -> 843
    //   836: aload_1
    //   837: invokevirtual 437	java/io/InputStream:close	()V
    //   840: goto +3 -> 843
    //   843: aload 6
    //   845: ifnull +8 -> 853
    //   848: aload 6
    //   850: invokevirtual 399	java/io/OutputStream:close	()V
    //   853: aload_0
    //   854: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   857: ifnull +15 -> 872
    //   860: aload_0
    //   861: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   864: invokevirtual 402	java/net/HttpURLConnection:disconnect	()V
    //   867: return
    //   868: aload_1
    //   869: invokevirtual 440	java/lang/Exception:printStackTrace	()V
    //   872: return
    //   873: astore 9
    //   875: aload 8
    //   877: astore 6
    //   879: aload_2
    //   880: astore_1
    //   881: aload 9
    //   883: astore_2
    //   884: aload_1
    //   885: astore 8
    //   887: aload 7
    //   889: astore 9
    //   891: aload_2
    //   892: astore_1
    //   893: aload 8
    //   895: astore_2
    //   896: aload 9
    //   898: ifnull +15 -> 913
    //   901: aload 9
    //   903: invokevirtual 436	java/io/ByteArrayOutputStream:close	()V
    //   906: goto +7 -> 913
    //   909: astore_2
    //   910: goto +41 -> 951
    //   913: aload_2
    //   914: ifnull +10 -> 924
    //   917: aload_2
    //   918: invokevirtual 437	java/io/InputStream:close	()V
    //   921: goto +3 -> 924
    //   924: aload 6
    //   926: ifnull +8 -> 934
    //   929: aload 6
    //   931: invokevirtual 399	java/io/OutputStream:close	()V
    //   934: aload_0
    //   935: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   938: ifnull +17 -> 955
    //   941: aload_0
    //   942: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   945: invokevirtual 402	java/net/HttpURLConnection:disconnect	()V
    //   948: goto +7 -> 955
    //   951: aload_2
    //   952: invokevirtual 440	java/lang/Exception:printStackTrace	()V
    //   955: aload_1
    //   956: athrow
    //   957: return
    //   958: astore 7
    //   960: goto -490 -> 470
    //   963: astore_2
    //   964: goto -275 -> 689
    //   967: astore_1
    //   968: goto -268 -> 700
    //   971: astore_1
    //   972: goto -262 -> 710
    //   975: astore_2
    //   976: goto -144 -> 832
    //   979: astore_1
    //   980: goto -137 -> 843
    //   983: astore_1
    //   984: goto -131 -> 853
    //   987: astore 7
    //   989: goto -76 -> 913
    //   992: astore_2
    //   993: goto -69 -> 924
    //   996: astore_2
    //   997: goto -63 -> 934
    //   1000: iload 5
    //   1002: sipush 302
    //   1005: if_icmpeq -611 -> 394
    //   1008: iload 5
    //   1010: sipush 301
    //   1013: if_icmpne -659 -> 354
    //   1016: goto -622 -> 394
    //   1019: aconst_null
    //   1020: astore_1
    //   1021: aload 12
    //   1023: astore_2
    //   1024: goto -350 -> 674
    //   1027: iconst_0
    //   1028: istore_3
    //   1029: goto -445 -> 584
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1032	0	this	HttpConnection
    //   0	1032	1	paramHwRequest	HwRequest
    //   0	1032	2	paramArrayOfByte	byte[]
    //   0	1032	3	paramInt	int
    //   46	569	4	i	int
    //   126	888	5	j	int
    //   43	887	6	localObject1	Object
    //   50	838	7	localObject2	Object
    //   958	1	7	localThrowable1	Throwable
    //   987	1	7	localIOException	java.io.IOException
    //   54	840	8	localObject3	Object
    //   19	726	9	localObject4	Object
    //   749	1	9	localThrowable2	Throwable
    //   759	1	9	localObject5	Object
    //   768	37	9	localThrowable3	Throwable
    //   873	9	9	localObject6	Object
    //   889	13	9	localObject7	Object
    //   31	790	10	localObject8	Object
    //   37	721	11	localObject9	Object
    //   40	982	12	localObject10	Object
    //   34	525	13	localObject11	Object
    //   28	451	14	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   678	682	685	java/lang/Exception
    //   693	697	685	java/lang/Exception
    //   705	710	685	java/lang/Exception
    //   710	724	685	java/lang/Exception
    //   575	581	730	finally
    //   584	596	730	finally
    //   610	623	730	finally
    //   630	638	730	finally
    //   638	671	730	finally
    //   575	581	738	java/lang/Throwable
    //   584	596	738	java/lang/Throwable
    //   610	623	738	java/lang/Throwable
    //   630	638	738	java/lang/Throwable
    //   638	671	738	java/lang/Throwable
    //   566	575	749	java/lang/Throwable
    //   56	63	754	finally
    //   71	84	754	finally
    //   92	108	754	finally
    //   116	125	754	finally
    //   136	143	754	finally
    //   151	170	754	finally
    //   178	183	754	finally
    //   202	209	754	finally
    //   217	234	754	finally
    //   242	250	754	finally
    //   258	267	754	finally
    //   275	284	754	finally
    //   292	301	754	finally
    //   309	317	754	finally
    //   325	335	754	finally
    //   362	369	754	finally
    //   377	391	754	finally
    //   408	420	754	finally
    //   433	440	754	finally
    //   454	459	754	finally
    //   463	470	754	finally
    //   478	491	754	finally
    //   508	515	754	finally
    //   523	537	754	finally
    //   548	556	754	finally
    //   56	63	768	java/lang/Throwable
    //   71	84	768	java/lang/Throwable
    //   92	108	768	java/lang/Throwable
    //   116	125	768	java/lang/Throwable
    //   136	143	768	java/lang/Throwable
    //   151	170	768	java/lang/Throwable
    //   178	183	768	java/lang/Throwable
    //   202	209	768	java/lang/Throwable
    //   217	234	768	java/lang/Throwable
    //   242	250	768	java/lang/Throwable
    //   258	267	768	java/lang/Throwable
    //   275	284	768	java/lang/Throwable
    //   292	301	768	java/lang/Throwable
    //   309	317	768	java/lang/Throwable
    //   325	335	768	java/lang/Throwable
    //   362	369	768	java/lang/Throwable
    //   377	391	768	java/lang/Throwable
    //   408	420	768	java/lang/Throwable
    //   433	440	768	java/lang/Throwable
    //   478	491	768	java/lang/Throwable
    //   508	515	768	java/lang/Throwable
    //   523	537	768	java/lang/Throwable
    //   548	556	768	java/lang/Throwable
    //   820	825	828	java/lang/Exception
    //   836	840	828	java/lang/Exception
    //   848	853	828	java/lang/Exception
    //   853	867	828	java/lang/Exception
    //   566	575	873	finally
    //   786	793	873	finally
    //   803	815	873	finally
    //   901	906	909	java/lang/Exception
    //   917	921	909	java/lang/Exception
    //   929	934	909	java/lang/Exception
    //   934	948	909	java/lang/Exception
    //   454	459	958	java/lang/Throwable
    //   463	470	958	java/lang/Throwable
    //   678	682	963	java/io/IOException
    //   693	697	967	java/io/IOException
    //   705	710	971	java/io/IOException
    //   820	825	975	java/io/IOException
    //   836	840	979	java/io/IOException
    //   848	853	983	java/io/IOException
    //   901	906	987	java/io/IOException
    //   917	921	992	java/io/IOException
    //   929	934	996	java/io/IOException
  }
  
  private void stopConnThread()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null)
    {
      HandlerThread localHandlerThread = this.mExecutor;
      if ((localHandlerThread != null) && (localHandlerThread.isAlive())) {
        localHandler.post(new HttpConnection.2(this));
      }
    }
  }
  
  public boolean connect()
  {
    try
    {
      this.mExecutor.start();
      this.mHandler = new Handler(this.mExecutor.getLooper());
      if (this.mConnListener != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("C. On Http ConnectionConnected : ID:");
        localStringBuilder.append(this.mConnId);
        QLog.d("BDH_LOG", 1, localStringBuilder.toString());
        this.mConnListener.onConnect(true, this.mConnId, this, this.mCurrentPoint, 0, new ConnReportInfo());
      }
      wakeupChannel();
      return true;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      disConnect();
    }
    return false;
  }
  
  public void disConnect()
  {
    Object localObject = this.mConnection;
    if (localObject != null) {}
    try
    {
      ((HttpURLConnection)localObject).disconnect();
    }
    catch (Throwable localThrowable)
    {
      label16:
      break label16;
    }
    if (this.mConnListener != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("C. On Http DisConnected : ID:");
      ((StringBuilder)localObject).append(this.mConnId);
      QLog.d("BDH_LOG", 1, ((StringBuilder)localObject).toString());
      this.mConnListener.onDisConnect(this.mConnId, this);
    }
    stopConnThread();
  }
  
  public int getConnId()
  {
    return this.mConnId;
  }
  
  public EndPoint getEndPoint()
  {
    return this.mCurrentPoint;
  }
  
  public int getProtoType()
  {
    return 2;
  }
  
  public boolean isIpv6()
  {
    return this.isIpv6;
  }
  
  public boolean isWritable()
  {
    return true;
  }
  
  public void onDecodeInvalidData(int paramInt)
  {
    this.iErrCode = -1013;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DecodeError[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("]");
    this.mStrErrInfo = ((StringBuilder)localObject).toString();
    localObject = this.mConnListener;
    if (localObject != null) {
      ((IConnectionListener)localObject).onRecvInvalidData(this.mCurrentPoint, this);
    }
    disConnect();
  }
  
  public void onDecodeSucessfully(List<HwResponse> paramList)
  {
    if (this.mConnListener != null) {
      this.mConnmanager.onDecodeSucessfully(paramList);
    }
  }
  
  public void onEncodePkgError(HwRequest paramHwRequest, int paramInt) {}
  
  public void setConnectListener(IConnectionListener paramIConnectionListener)
  {
    this.mConnListener = paramIConnectionListener;
  }
  
  public void setUrgentFlag(boolean paramBoolean) {}
  
  public void wakeupChannel()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null)
    {
      HandlerThread localHandlerThread = this.mExecutor;
      if ((localHandlerThread != null) && (localHandlerThread.isAlive())) {
        localHandler.post(new HttpConnection.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.HttpConnection
 * JD-Core Version:    0.7.0.1
 */