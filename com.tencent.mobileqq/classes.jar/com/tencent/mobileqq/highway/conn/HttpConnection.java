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
    this.mExecutor = new HandlerThread("BDH-HTTP-" + paramInt);
    this.isIpv6 = paramBoolean;
  }
  
  private void doSendRequest()
  {
    BdhLogUtil.LogEvent("C", "[HttpConn] doSendRequest about to peak one request.");
    HwRequest localHwRequest = this.mConnmanager.pullNextRequest(this, false, 0L, 0L, 0);
    if (localHwRequest == null) {}
    do
    {
      return;
      this.mDataCodec = new TcpProtocolDataCodec();
      this.mDataCodec.setProtocolCodecListener(this);
      BdhLogUtil.LogEvent("C", "[HttpConn] doSendRequest continue to send. ReqInfo : " + localHwRequest.toString());
      localHwRequest.endpoint = this.mCurrentPoint;
      byte[] arrayOfByte = localHwRequest.getRequestBody();
      if ((arrayOfByte == null) && (localHwRequest.hasRequestBody()))
      {
        localHwRequest.reqListener.handleError(-1004, "NullBody", this);
        wakeupChannel();
        return;
      }
      handleHttpReqData(localHwRequest, this.mDataCodec.encodeC2SData(this.mCurrentPoint, localHwRequest, arrayOfByte), localHwRequest.mBuCmdId);
      if (this.iErrCode == 0)
      {
        wakeupChannel();
        return;
      }
      localHwRequest.reqListener.handleError(this.iErrCode, this.mStrErrInfo, this);
    } while (this.iErrCode != -1014);
    stopConnThread();
  }
  
  private String getBdhConnURL()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.isIpv6) {
      localStringBuilder.append("http://").append("[").append(this.mCurrentPoint.host).append("]");
    }
    for (;;)
    {
      if (this.mCurrentPoint.port != 80) {
        localStringBuilder.append(":").append(this.mCurrentPoint.port);
      }
      localStringBuilder.append("/cgi-bin/httpconn?htcmd=0x6ff0082");
      return localStringBuilder.toString();
      localStringBuilder.append("http://").append(this.mCurrentPoint.host);
    }
  }
  
  private HttpURLConnection getConnection(String paramString, HashMap<String, String> paramHashMap, long paramLong, int paramInt)
  {
    BdhLogUtil.LogEvent("C", "[HttpConn] Open Connection. Try Open : " + paramString);
    String str = android.net.Proxy.getDefaultHost();
    int k = android.net.Proxy.getDefaultPort();
    paramInt = 0;
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    if ((paramInt == 0) && (i < 2))
    {
      localObject2 = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      j = -1;
      localObject1 = null;
      if (localObject2 != null)
      {
        j = ((NetworkInfo)localObject2).getType();
        localObject1 = ((NetworkInfo)localObject2).getExtraInfo();
      }
      localObject1 = BdhUtils.getApnType((String)localObject1);
      if ((j == 1) || (((String)localObject1).toLowerCase().equals(BdhUtils.APN_TYPE_CMWAP)))
      {
        paramInt = 0;
        if ((j != 1) || ((!"10.0.0.172".equals(str)) && (!"10.0.0.200".equals(str)))) {
          break label488;
        }
      }
    }
    label220:
    label488:
    for (int j = 1;; j = paramInt)
    {
      if ((str != null) && (k > 0)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if ((j == 0) && (paramInt != 0)) {
          if ((((String)localObject1).equals(BdhUtils.APN_TYPE_CMWAP)) || (((String)localObject1).equals(BdhUtils.APN_TYPE_UNIWAP)) || (((String)localObject1).equals(BdhUtils.APN_TYPE_3GWAP))) {
            localObject1 = BdhUtils.getConnectionWithXOnlineHost(paramString, str, k);
          }
        }
        for (j = 1;; j = 0)
        {
          ((HttpURLConnection)localObject1).setConnectTimeout(30000);
          ((HttpURLConnection)localObject1).setReadTimeout(30000);
          ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
          ((HttpURLConnection)localObject1).setDoOutput(true);
          ((HttpURLConnection)localObject1).setFixedLengthStreamingMode((int)paramLong);
          ((HttpURLConnection)localObject1).addRequestProperty("Accept-Encoding", "identity");
          ((HttpURLConnection)localObject1).addRequestProperty("Connection", "close");
          localObject2 = paramHashMap.entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            ((HttpURLConnection)localObject1).setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
          }
          paramInt = 1;
          break;
          if (((String)localObject1).equals(BdhUtils.APN_TYPE_CTWAP))
          {
            localObject1 = BdhUtils.getConnectionWithDefaultProxy(paramString, str, k);
            break label220;
          }
          localObject1 = BdhUtils.getConnectionWithDefaultProxy(paramString, str, k);
          break label220;
          localObject1 = (HttpURLConnection)new URL(paramString).openConnection(java.net.Proxy.NO_PROXY);
        }
        try
        {
          ((HttpURLConnection)localObject1).connect();
          paramInt = 1;
        }
        catch (Throwable localThrowable)
        {
          while (paramInt != 0) {
            if ((j != 0) && (paramInt != 0)) {
              paramInt = 0;
            } else if ((paramInt != 0) && (j == 0)) {
              paramInt = 0;
            } else {
              throw localThrowable;
            }
          }
          throw localThrowable;
        }
        i += 1;
        break;
        BdhLogUtil.LogEvent("C", "[HttpConn] Open Connection Succ.");
        return localObject1;
      }
    }
  }
  
  /* Error */
  private void handleHttpReqData(HwRequest paramHwRequest, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 11
    //   9: aload_2
    //   10: ifnull +8 -> 18
    //   13: aload_2
    //   14: arraylength
    //   15: ifgt +4 -> 19
    //   18: return
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 41	com/tencent/mobileqq/highway/conn/HttpConnection:iErrCode	I
    //   24: aload_0
    //   25: invokespecial 344	com/tencent/mobileqq/highway/conn/HttpConnection:getBdhConnURL	()Ljava/lang/String;
    //   28: astore 8
    //   30: new 282	java/util/HashMap
    //   33: dup
    //   34: invokespecial 345	java/util/HashMap:<init>	()V
    //   37: astore 12
    //   39: iconst_0
    //   40: istore 4
    //   42: aconst_null
    //   43: astore 7
    //   45: aload_1
    //   46: getfield 135	com/tencent/mobileqq/highway/segment/HwRequest:reqListener	Lcom/tencent/mobileqq/highway/segment/IRequestListener;
    //   49: ifnull +16 -> 65
    //   52: aload_1
    //   53: getfield 135	com/tencent/mobileqq/highway/segment/HwRequest:reqListener	Lcom/tencent/mobileqq/highway/segment/IRequestListener;
    //   56: aload_0
    //   57: getfield 49	com/tencent/mobileqq/highway/conn/HttpConnection:mConnId	I
    //   60: invokeinterface 348 2 0
    //   65: aload_0
    //   66: aload_0
    //   67: aload 8
    //   69: aload 12
    //   71: aload_2
    //   72: arraylength
    //   73: i2l
    //   74: iload_3
    //   75: invokespecial 350	com/tencent/mobileqq/highway/conn/HttpConnection:getConnection	(Ljava/lang/String;Ljava/util/HashMap;JI)Ljava/net/HttpURLConnection;
    //   78: putfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   81: aload_0
    //   82: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   85: invokevirtual 356	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   88: astore 8
    //   90: aload 8
    //   92: astore 7
    //   94: iconst_0
    //   95: istore 5
    //   97: iload 5
    //   99: aload_2
    //   100: arraylength
    //   101: if_icmpge +38 -> 139
    //   104: aload 7
    //   106: aload_2
    //   107: iload 5
    //   109: sipush 10240
    //   112: aload_2
    //   113: arraylength
    //   114: iload 5
    //   116: isub
    //   117: invokestatic 362	java/lang/Math:min	(II)I
    //   120: invokevirtual 368	java/io/OutputStream:write	([BII)V
    //   123: aload 7
    //   125: invokevirtual 371	java/io/OutputStream:flush	()V
    //   128: iload 5
    //   130: sipush 10240
    //   133: iadd
    //   134: istore 5
    //   136: goto -39 -> 97
    //   139: aload_1
    //   140: getfield 135	com/tencent/mobileqq/highway/segment/HwRequest:reqListener	Lcom/tencent/mobileqq/highway/segment/IRequestListener;
    //   143: ifnull +20 -> 163
    //   146: aload_1
    //   147: getfield 135	com/tencent/mobileqq/highway/segment/HwRequest:reqListener	Lcom/tencent/mobileqq/highway/segment/IRequestListener;
    //   150: aload_0
    //   151: getfield 49	com/tencent/mobileqq/highway/conn/HttpConnection:mConnId	I
    //   154: aload_0
    //   155: invokevirtual 374	com/tencent/mobileqq/highway/conn/HttpConnection:getProtoType	()I
    //   158: invokeinterface 378 3 0
    //   163: ldc 92
    //   165: ldc_w 380
    //   168: invokestatic 100	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_0
    //   172: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   175: invokevirtual 383	java/net/HttpURLConnection:getResponseCode	()I
    //   178: istore 5
    //   180: ldc 92
    //   182: new 55	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 385
    //   192: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: iload 5
    //   197: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 100	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: iload 5
    //   208: sipush 200
    //   211: if_icmpeq +11 -> 222
    //   214: iload 5
    //   216: sipush 206
    //   219: if_icmpne +184 -> 403
    //   222: aload_0
    //   223: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   226: invokevirtual 389	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   229: astore_2
    //   230: new 391	java/io/ByteArrayOutputStream
    //   233: dup
    //   234: invokespecial 392	java/io/ByteArrayOutputStream:<init>	()V
    //   237: astore_1
    //   238: sipush 10240
    //   241: newarray byte
    //   243: astore 8
    //   245: iconst_0
    //   246: istore_3
    //   247: iconst_0
    //   248: istore 4
    //   250: aload_2
    //   251: aload 8
    //   253: iload_3
    //   254: aload 8
    //   256: arraylength
    //   257: iload_3
    //   258: isub
    //   259: invokevirtual 398	java/io/InputStream:read	([BII)I
    //   262: istore 6
    //   264: iload 6
    //   266: ifle +46 -> 312
    //   269: iload_3
    //   270: iload 6
    //   272: iadd
    //   273: istore 5
    //   275: iload 4
    //   277: iload 6
    //   279: iadd
    //   280: istore 6
    //   282: iload 5
    //   284: istore_3
    //   285: iload 6
    //   287: istore 4
    //   289: iload 5
    //   291: aload 8
    //   293: arraylength
    //   294: if_icmplt -44 -> 250
    //   297: aload_1
    //   298: aload 8
    //   300: invokevirtual 401	java/io/ByteArrayOutputStream:write	([B)V
    //   303: iconst_0
    //   304: istore_3
    //   305: iload 6
    //   307: istore 4
    //   309: goto -59 -> 250
    //   312: iload_3
    //   313: ifle +11 -> 324
    //   316: aload_1
    //   317: aload 8
    //   319: iconst_0
    //   320: iload_3
    //   321: invokevirtual 402	java/io/ByteArrayOutputStream:write	([BII)V
    //   324: aload_1
    //   325: invokevirtual 403	java/io/ByteArrayOutputStream:flush	()V
    //   328: aload_1
    //   329: invokevirtual 406	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   332: astore 8
    //   334: aload_0
    //   335: getfield 111	com/tencent/mobileqq/highway/conn/HttpConnection:mDataCodec	Lcom/tencent/mobileqq/highway/codec/TcpProtocolDataCodec;
    //   338: aload 8
    //   340: invokevirtual 410	com/tencent/mobileqq/highway/codec/TcpProtocolDataCodec:decodeS2CData	([B)Z
    //   343: pop
    //   344: ldc 92
    //   346: ldc_w 412
    //   349: invokestatic 100	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload_1
    //   353: invokevirtual 414	java/io/ByteArrayOutputStream:close	()V
    //   356: aload_1
    //   357: ifnull +7 -> 364
    //   360: aload_1
    //   361: invokevirtual 414	java/io/ByteArrayOutputStream:close	()V
    //   364: aload_2
    //   365: ifnull +7 -> 372
    //   368: aload_2
    //   369: invokevirtual 415	java/io/InputStream:close	()V
    //   372: aload 7
    //   374: ifnull +8 -> 382
    //   377: aload 7
    //   379: invokevirtual 416	java/io/OutputStream:close	()V
    //   382: aload_0
    //   383: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   386: ifnull -368 -> 18
    //   389: aload_0
    //   390: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   393: invokevirtual 419	java/net/HttpURLConnection:disconnect	()V
    //   396: return
    //   397: astore_1
    //   398: aload_1
    //   399: invokevirtual 422	java/lang/Exception:printStackTrace	()V
    //   402: return
    //   403: iload 5
    //   405: sipush 302
    //   408: if_icmpeq +11 -> 419
    //   411: iload 5
    //   413: sipush 301
    //   416: if_icmpne +106 -> 522
    //   419: iload 4
    //   421: iconst_5
    //   422: if_icmpge +71 -> 493
    //   425: aload_0
    //   426: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   429: ldc_w 424
    //   432: invokevirtual 427	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   435: astore 8
    //   437: aload 8
    //   439: ifnull +54 -> 493
    //   442: aload 8
    //   444: invokevirtual 430	java/lang/String:length	()I
    //   447: istore 5
    //   449: iload 5
    //   451: ifle +42 -> 493
    //   454: aload 7
    //   456: ifnull +8 -> 464
    //   459: aload 7
    //   461: invokevirtual 416	java/io/OutputStream:close	()V
    //   464: aload_0
    //   465: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   468: invokevirtual 419	java/net/HttpURLConnection:disconnect	()V
    //   471: aload 12
    //   473: ldc_w 432
    //   476: aload_0
    //   477: invokespecial 344	com/tencent/mobileqq/highway/conn/HttpConnection:getBdhConnURL	()Ljava/lang/String;
    //   480: invokevirtual 436	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   483: pop
    //   484: iload 4
    //   486: iconst_1
    //   487: iadd
    //   488: istore 4
    //   490: goto -445 -> 45
    //   493: aload_0
    //   494: sipush -1013
    //   497: putfield 41	com/tencent/mobileqq/highway/conn/HttpConnection:iErrCode	I
    //   500: aload_0
    //   501: aload_0
    //   502: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   505: invokevirtual 440	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   508: invokevirtual 118	java/lang/Object:toString	()Ljava/lang/String;
    //   511: putfield 45	com/tencent/mobileqq/highway/conn/HttpConnection:mStrErrInfo	Ljava/lang/String;
    //   514: aconst_null
    //   515: astore_2
    //   516: aload 11
    //   518: astore_1
    //   519: goto -163 -> 356
    //   522: aload_0
    //   523: sipush -1013
    //   526: putfield 41	com/tencent/mobileqq/highway/conn/HttpConnection:iErrCode	I
    //   529: aload_0
    //   530: aload_0
    //   531: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   534: invokevirtual 440	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   537: invokevirtual 118	java/lang/Object:toString	()Ljava/lang/String;
    //   540: putfield 45	com/tencent/mobileqq/highway/conn/HttpConnection:mStrErrInfo	Ljava/lang/String;
    //   543: aconst_null
    //   544: astore_2
    //   545: aload 11
    //   547: astore_1
    //   548: goto -192 -> 356
    //   551: astore_2
    //   552: aconst_null
    //   553: astore_1
    //   554: aload 10
    //   556: astore 8
    //   558: aload_0
    //   559: sipush -1003
    //   562: putfield 41	com/tencent/mobileqq/highway/conn/HttpConnection:iErrCode	I
    //   565: aload_0
    //   566: aload_2
    //   567: invokevirtual 444	java/lang/Object:getClass	()Ljava/lang/Class;
    //   570: invokevirtual 449	java/lang/Class:getName	()Ljava/lang/String;
    //   573: putfield 45	com/tencent/mobileqq/highway/conn/HttpConnection:mStrErrInfo	Ljava/lang/String;
    //   576: aload_1
    //   577: ifnull +7 -> 584
    //   580: aload_1
    //   581: invokevirtual 414	java/io/ByteArrayOutputStream:close	()V
    //   584: aload 8
    //   586: ifnull +8 -> 594
    //   589: aload 8
    //   591: invokevirtual 415	java/io/InputStream:close	()V
    //   594: aload 7
    //   596: ifnull +8 -> 604
    //   599: aload 7
    //   601: invokevirtual 416	java/io/OutputStream:close	()V
    //   604: aload_0
    //   605: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   608: ifnull -590 -> 18
    //   611: aload_0
    //   612: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   615: invokevirtual 419	java/net/HttpURLConnection:disconnect	()V
    //   618: return
    //   619: astore_1
    //   620: aload_1
    //   621: invokevirtual 422	java/lang/Exception:printStackTrace	()V
    //   624: return
    //   625: astore_1
    //   626: aconst_null
    //   627: astore_2
    //   628: aload 9
    //   630: astore 8
    //   632: aload 8
    //   634: ifnull +8 -> 642
    //   637: aload 8
    //   639: invokevirtual 414	java/io/ByteArrayOutputStream:close	()V
    //   642: aload_2
    //   643: ifnull +7 -> 650
    //   646: aload_2
    //   647: invokevirtual 415	java/io/InputStream:close	()V
    //   650: aload 7
    //   652: ifnull +8 -> 660
    //   655: aload 7
    //   657: invokevirtual 416	java/io/OutputStream:close	()V
    //   660: aload_0
    //   661: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   664: ifnull +10 -> 674
    //   667: aload_0
    //   668: getfield 352	com/tencent/mobileqq/highway/conn/HttpConnection:mConnection	Ljava/net/HttpURLConnection;
    //   671: invokevirtual 419	java/net/HttpURLConnection:disconnect	()V
    //   674: aload_1
    //   675: athrow
    //   676: astore_2
    //   677: aload_2
    //   678: invokevirtual 422	java/lang/Exception:printStackTrace	()V
    //   681: goto -7 -> 674
    //   684: astore_1
    //   685: goto -321 -> 364
    //   688: astore_1
    //   689: goto -317 -> 372
    //   692: astore_1
    //   693: goto -311 -> 382
    //   696: astore_1
    //   697: goto -113 -> 584
    //   700: astore_1
    //   701: goto -107 -> 594
    //   704: astore_1
    //   705: goto -101 -> 604
    //   708: astore 8
    //   710: goto -68 -> 642
    //   713: astore_2
    //   714: goto -64 -> 650
    //   717: astore_2
    //   718: goto -58 -> 660
    //   721: astore_1
    //   722: aload 9
    //   724: astore 8
    //   726: goto -94 -> 632
    //   729: astore 9
    //   731: aload_1
    //   732: astore 8
    //   734: aload 9
    //   736: astore_1
    //   737: goto -105 -> 632
    //   740: astore_1
    //   741: aconst_null
    //   742: astore_2
    //   743: aload 9
    //   745: astore 8
    //   747: goto -115 -> 632
    //   750: astore 9
    //   752: aload 8
    //   754: astore_2
    //   755: aload_1
    //   756: astore 8
    //   758: aload 9
    //   760: astore_1
    //   761: goto -129 -> 632
    //   764: astore 9
    //   766: aconst_null
    //   767: astore_1
    //   768: aload_2
    //   769: astore 8
    //   771: aload 9
    //   773: astore_2
    //   774: goto -216 -> 558
    //   777: astore 9
    //   779: aload_2
    //   780: astore 8
    //   782: aload 9
    //   784: astore_2
    //   785: goto -227 -> 558
    //   788: astore_2
    //   789: aconst_null
    //   790: astore_1
    //   791: aload 10
    //   793: astore 8
    //   795: goto -237 -> 558
    //   798: astore 13
    //   800: goto -329 -> 471
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	803	0	this	HttpConnection
    //   0	803	1	paramHwRequest	HwRequest
    //   0	803	2	paramArrayOfByte	byte[]
    //   0	803	3	paramInt	int
    //   40	449	4	i	int
    //   95	355	5	j	int
    //   262	44	6	k	int
    //   43	613	7	localObject1	Object
    //   28	610	8	localObject2	Object
    //   708	1	8	localIOException	java.io.IOException
    //   724	70	8	localObject3	Object
    //   4	719	9	localObject4	Object
    //   729	15	9	localObject5	Object
    //   750	9	9	localObject6	Object
    //   764	8	9	localThrowable1	Throwable
    //   777	6	9	localThrowable2	Throwable
    //   1	791	10	localObject7	Object
    //   7	539	11	localObject8	Object
    //   37	435	12	localHashMap	HashMap
    //   798	1	13	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   360	364	397	java/lang/Exception
    //   368	372	397	java/lang/Exception
    //   377	382	397	java/lang/Exception
    //   382	396	397	java/lang/Exception
    //   97	128	551	java/lang/Throwable
    //   139	163	551	java/lang/Throwable
    //   163	206	551	java/lang/Throwable
    //   222	230	551	java/lang/Throwable
    //   425	437	551	java/lang/Throwable
    //   442	449	551	java/lang/Throwable
    //   471	484	551	java/lang/Throwable
    //   493	514	551	java/lang/Throwable
    //   522	543	551	java/lang/Throwable
    //   580	584	619	java/lang/Exception
    //   589	594	619	java/lang/Exception
    //   599	604	619	java/lang/Exception
    //   604	618	619	java/lang/Exception
    //   97	128	625	finally
    //   139	163	625	finally
    //   163	206	625	finally
    //   222	230	625	finally
    //   425	437	625	finally
    //   442	449	625	finally
    //   459	464	625	finally
    //   464	471	625	finally
    //   471	484	625	finally
    //   493	514	625	finally
    //   522	543	625	finally
    //   637	642	676	java/lang/Exception
    //   646	650	676	java/lang/Exception
    //   655	660	676	java/lang/Exception
    //   660	674	676	java/lang/Exception
    //   360	364	684	java/io/IOException
    //   368	372	688	java/io/IOException
    //   377	382	692	java/io/IOException
    //   580	584	696	java/io/IOException
    //   589	594	700	java/io/IOException
    //   599	604	704	java/io/IOException
    //   637	642	708	java/io/IOException
    //   646	650	713	java/io/IOException
    //   655	660	717	java/io/IOException
    //   230	238	721	finally
    //   238	245	729	finally
    //   250	264	729	finally
    //   289	303	729	finally
    //   316	324	729	finally
    //   324	356	729	finally
    //   45	65	740	finally
    //   65	90	740	finally
    //   558	576	750	finally
    //   230	238	764	java/lang/Throwable
    //   238	245	777	java/lang/Throwable
    //   250	264	777	java/lang/Throwable
    //   289	303	777	java/lang/Throwable
    //   316	324	777	java/lang/Throwable
    //   324	356	777	java/lang/Throwable
    //   45	65	788	java/lang/Throwable
    //   65	90	788	java/lang/Throwable
    //   459	464	798	java/lang/Throwable
    //   464	471	798	java/lang/Throwable
  }
  
  private void stopConnThread()
  {
    Handler localHandler = this.mHandler;
    if ((localHandler != null) && (this.mExecutor != null) && (this.mExecutor.isAlive())) {
      localHandler.post(new HttpConnection.2(this));
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
        QLog.d("BDH_LOG", 1, "C. On Http ConnectionConnected : ID:" + this.mConnId);
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
    if (this.mConnection != null) {}
    try
    {
      this.mConnection.disconnect();
      label14:
      if (this.mConnListener != null)
      {
        QLog.d("BDH_LOG", 1, "C. On Http DisConnected : ID:" + this.mConnId);
        this.mConnListener.onDisConnect(this.mConnId, this);
      }
      stopConnThread();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label14;
    }
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
    this.mStrErrInfo = ("DecodeError[" + paramInt + "]");
    if (this.mConnListener != null) {
      this.mConnListener.onRecvInvalidData(this.mCurrentPoint, this);
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
    if ((localHandler != null) && (this.mExecutor != null) && (this.mExecutor.isAlive())) {
      localHandler.post(new HttpConnection.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.HttpConnection
 * JD-Core Version:    0.7.0.1
 */