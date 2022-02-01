package com.tencent.mobileqq.loginwelcome;

import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.math.BigInteger;
import mqq.os.MqqHandler;
import tencent.im.login.GatewayVerify.SelfPhoneUrl;

public class GateWayVerifyManager
{
  private static volatile GateWayVerifyManager jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager;
  private ConnectivityManager.NetworkCallback jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback;
  private ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
  private Network jdField_a_of_type_AndroidNetNetwork;
  private GateWayVerifyManager.OnNetChangedListener jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager$OnNetChangedListener;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private GateWayVerifyManager()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback = new GateWayVerifyManager.1(this);
    }
    try
    {
      b();
      return;
    }
    catch (Exception localException)
    {
      QLog.d("GateWayVerifyManager", 1, new Object[] { "requestMobileNetwork error : ", localException.getMessage() });
      this.b = true;
    }
  }
  
  private int a(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    try
    {
      long[] arrayOfLong = new long[4];
      int i = paramString.indexOf(".");
      int j = paramString.indexOf(".", i + 1);
      int k = paramString.indexOf(".", j + 1);
      arrayOfLong[0] = Long.parseLong(paramString.substring(0, i));
      arrayOfLong[1] = Long.parseLong(paramString.substring(i + 1, j));
      arrayOfLong[2] = Long.parseLong(paramString.substring(j + 1, k));
      arrayOfLong[3] = Long.parseLong(paramString.substring(k + 1));
      long l1 = arrayOfLong[3];
      long l2 = arrayOfLong[2];
      long l3 = arrayOfLong[1];
      long l4 = arrayOfLong[0];
      return (int)(l4 + ((l1 << 24) + (l2 << 16) + (l3 << 8)));
    }
    catch (Exception paramString)
    {
      QLog.e("GateWayVerifyManager", 1, new Object[] { "ipv4toInt error : ", paramString.getMessage() });
    }
    return 0;
  }
  
  public static GateWayVerifyManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager == null) {
        jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager = new GateWayVerifyManager();
      }
      return jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager;
    }
    finally {}
  }
  
  private BigInteger a(String paramString)
  {
    BigInteger localBigInteger = BigInteger.ZERO;
    int i;
    int j;
    try
    {
      i = paramString.indexOf("::");
      Object localObject1;
      Object localObject2;
      int m;
      if (i != -1)
      {
        localObject1 = paramString.substring(0, i);
        localObject2 = paramString.substring(i + 1);
        paramString = a((String)localObject1);
        localObject2 = a((String)localObject2);
        localObject1 = ((String)localObject1).toCharArray();
        m = localObject1.length;
        j = 0;
      }
      label170:
      for (i = 0; j >= m; i = 0)
      {
        return paramString.shiftLeft((7 - i) * 16).add((BigInteger)localObject2);
        localObject1 = paramString.split(":");
        paramString = localBigInteger;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        while (i < localObject1.length)
        {
          if (localObject1[i].isEmpty()) {
            localObject1[i] = "0";
          }
          localBigInteger = paramString.add(BigInteger.valueOf(Long.valueOf(localObject1[i], 16).longValue()).shiftLeft((localObject1.length - i - 1) * 16));
          i += 1;
          paramString = localBigInteger;
        }
        localException1 = localException1;
        paramString = localBigInteger;
      }
      catch (Exception localException2)
      {
        break label170;
      }
      QLog.e("GateWayVerifyManager", 1, new Object[] { "ipv6toInt error : ", localException1.getMessage() });
      return paramString;
    }
    for (;;)
    {
      int k = i;
      if (localException2[j] == ':') {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
    return paramString;
  }
  
  private void a(GateWayVerifyManager.OnNetChangedListener paramOnNetChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager$OnNetChangedListener = paramOnNetChangedListener;
  }
  
  /* Error */
  private void a(java.net.HttpURLConnection paramHttpURLConnection, GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, GatewayCallback paramGatewayCallback)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 7
    //   12: aload_1
    //   13: ldc 187
    //   15: invokevirtual 193	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   18: aload_1
    //   19: ldc 195
    //   21: ldc 197
    //   23: invokevirtual 201	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_1
    //   27: ldc 203
    //   29: ldc 205
    //   31: invokevirtual 201	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_1
    //   35: sipush 4000
    //   38: invokevirtual 209	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   41: aload_1
    //   42: sipush 4000
    //   45: invokevirtual 212	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   48: aload_1
    //   49: invokevirtual 215	java/net/HttpURLConnection:connect	()V
    //   52: aload_1
    //   53: invokevirtual 219	java/net/HttpURLConnection:getResponseCode	()I
    //   56: istore 4
    //   58: ldc 60
    //   60: iconst_1
    //   61: iconst_2
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: ldc 221
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: iload 4
    //   74: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   81: iload 4
    //   83: sipush 200
    //   86: if_icmpne +186 -> 272
    //   89: aload_1
    //   90: invokevirtual 230	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   93: astore_1
    //   94: new 232	java/io/ByteArrayOutputStream
    //   97: dup
    //   98: invokespecial 233	java/io/ByteArrayOutputStream:<init>	()V
    //   101: astore 5
    //   103: sipush 1024
    //   106: newarray byte
    //   108: astore 6
    //   110: aload_1
    //   111: aload 6
    //   113: invokevirtual 239	java/io/InputStream:read	([B)I
    //   116: istore 4
    //   118: iload 4
    //   120: iconst_m1
    //   121: if_icmpeq +76 -> 197
    //   124: aload 5
    //   126: aload 6
    //   128: iconst_0
    //   129: iload 4
    //   131: invokevirtual 243	java/io/ByteArrayOutputStream:write	([BII)V
    //   134: goto -24 -> 110
    //   137: astore 6
    //   139: aload_1
    //   140: astore_2
    //   141: aload 5
    //   143: astore_1
    //   144: aload 6
    //   146: astore 5
    //   148: ldc 60
    //   150: iconst_1
    //   151: iconst_2
    //   152: anewarray 4	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: ldc 245
    //   159: aastore
    //   160: dup
    //   161: iconst_1
    //   162: aload 5
    //   164: invokevirtual 246	java/io/IOException:getMessage	()Ljava/lang/String;
    //   167: aastore
    //   168: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   171: aload_3
    //   172: iconst_m1
    //   173: aload 5
    //   175: invokeinterface 251 3 0
    //   180: aload_2
    //   181: ifnull +7 -> 188
    //   184: aload_2
    //   185: invokevirtual 254	java/io/InputStream:close	()V
    //   188: aload_1
    //   189: ifnull +7 -> 196
    //   192: aload_1
    //   193: invokevirtual 255	java/io/ByteArrayOutputStream:close	()V
    //   196: return
    //   197: aload 5
    //   199: invokevirtual 258	java/io/ByteArrayOutputStream:flush	()V
    //   202: aload 5
    //   204: invokevirtual 261	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   207: astore 6
    //   209: aload_3
    //   210: aload_2
    //   211: aload 6
    //   213: invokeinterface 264 3 0
    //   218: ldc 60
    //   220: iconst_1
    //   221: iconst_2
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: ldc_w 266
    //   230: aastore
    //   231: dup
    //   232: iconst_1
    //   233: aload 6
    //   235: aastore
    //   236: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   239: aload_1
    //   240: astore_2
    //   241: aload 5
    //   243: astore_1
    //   244: aload_2
    //   245: ifnull +7 -> 252
    //   248: aload_2
    //   249: invokevirtual 254	java/io/InputStream:close	()V
    //   252: aload_1
    //   253: ifnull -57 -> 196
    //   256: aload_1
    //   257: invokevirtual 255	java/io/ByteArrayOutputStream:close	()V
    //   260: return
    //   261: astore_1
    //   262: ldc 60
    //   264: iconst_1
    //   265: ldc_w 268
    //   268: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: return
    //   272: iload 4
    //   274: sipush 302
    //   277: if_icmpne +35 -> 312
    //   280: aload_1
    //   281: ldc_w 273
    //   284: invokevirtual 277	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   287: astore_1
    //   288: aload_2
    //   289: getfield 283	tencent/im/login/GatewayVerify$SelfPhoneUrl:str_upload_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   292: aload_1
    //   293: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   296: aload_3
    //   297: aload_2
    //   298: invokeinterface 291 2 0
    //   303: aload 8
    //   305: astore_2
    //   306: aload 7
    //   308: astore_1
    //   309: goto -65 -> 244
    //   312: aload_3
    //   313: iload 4
    //   315: new 17	java/lang/Exception
    //   318: dup
    //   319: new 293	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 294	java/lang/StringBuilder:<init>	()V
    //   326: ldc_w 296
    //   329: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: iload 4
    //   334: invokevirtual 303	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   337: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokespecial 306	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   343: invokeinterface 251 3 0
    //   348: aload 8
    //   350: astore_2
    //   351: aload 7
    //   353: astore_1
    //   354: goto -110 -> 244
    //   357: astore_1
    //   358: aload 6
    //   360: astore_3
    //   361: aload 5
    //   363: astore_2
    //   364: aload_2
    //   365: ifnull +7 -> 372
    //   368: aload_2
    //   369: invokevirtual 254	java/io/InputStream:close	()V
    //   372: aload_3
    //   373: ifnull +7 -> 380
    //   376: aload_3
    //   377: invokevirtual 255	java/io/ByteArrayOutputStream:close	()V
    //   380: aload_1
    //   381: athrow
    //   382: astore_2
    //   383: ldc 60
    //   385: iconst_1
    //   386: ldc_w 308
    //   389: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: goto -140 -> 252
    //   395: astore_2
    //   396: ldc 60
    //   398: iconst_1
    //   399: ldc_w 308
    //   402: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: goto -217 -> 188
    //   408: astore_1
    //   409: ldc 60
    //   411: iconst_1
    //   412: ldc_w 268
    //   415: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: return
    //   419: astore_2
    //   420: ldc 60
    //   422: iconst_1
    //   423: ldc_w 308
    //   426: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: goto -57 -> 372
    //   432: astore_2
    //   433: ldc 60
    //   435: iconst_1
    //   436: ldc_w 268
    //   439: invokestatic 271	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: goto -62 -> 380
    //   445: astore_3
    //   446: aload_1
    //   447: astore_2
    //   448: aload_3
    //   449: astore_1
    //   450: aload 6
    //   452: astore_3
    //   453: goto -89 -> 364
    //   456: astore 6
    //   458: aload 5
    //   460: astore_3
    //   461: aload_1
    //   462: astore_2
    //   463: aload 6
    //   465: astore_1
    //   466: goto -102 -> 364
    //   469: astore 5
    //   471: aload_1
    //   472: astore_3
    //   473: aload 5
    //   475: astore_1
    //   476: goto -112 -> 364
    //   479: astore 5
    //   481: aconst_null
    //   482: astore 6
    //   484: aload_1
    //   485: astore_2
    //   486: aload 6
    //   488: astore_1
    //   489: goto -341 -> 148
    //   492: astore 5
    //   494: aconst_null
    //   495: astore_2
    //   496: aconst_null
    //   497: astore_1
    //   498: goto -350 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	this	GateWayVerifyManager
    //   0	501	1	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	501	2	paramSelfPhoneUrl	GatewayVerify.SelfPhoneUrl
    //   0	501	3	paramGatewayCallback	GatewayCallback
    //   56	277	4	i	int
    //   1	458	5	localObject1	Object
    //   469	5	5	localObject2	Object
    //   479	1	5	localIOException1	java.io.IOException
    //   492	1	5	localIOException2	java.io.IOException
    //   7	120	6	arrayOfByte	byte[]
    //   137	8	6	localIOException3	java.io.IOException
    //   207	244	6	str	String
    //   456	8	6	localObject3	Object
    //   482	5	6	localObject4	Object
    //   10	342	7	localObject5	Object
    //   4	345	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   103	110	137	java/io/IOException
    //   110	118	137	java/io/IOException
    //   124	134	137	java/io/IOException
    //   197	239	137	java/io/IOException
    //   256	260	261	java/io/IOException
    //   12	81	357	finally
    //   89	94	357	finally
    //   280	303	357	finally
    //   312	348	357	finally
    //   248	252	382	java/io/IOException
    //   184	188	395	java/io/IOException
    //   192	196	408	java/io/IOException
    //   368	372	419	java/io/IOException
    //   376	380	432	java/io/IOException
    //   94	103	445	finally
    //   103	110	456	finally
    //   110	118	456	finally
    //   124	134	456	finally
    //   197	239	456	finally
    //   148	180	469	finally
    //   94	103	479	java/io/IOException
    //   12	81	492	java/io/IOException
    //   89	94	492	java/io/IOException
    //   280	303	492	java/io/IOException
    //   312	348	492	java/io/IOException
  }
  
  @RequiresApi(api=21)
  private void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, Network paramNetwork, GatewayCallback paramGatewayCallback)
  {
    ThreadManagerV2.excute(new GateWayVerifyManager.2(this, paramSelfPhoneUrl, paramNetwork, paramGatewayCallback), 128, null, true);
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager == null;
  }
  
  @RequiresApi(api=21)
  private void b()
  {
    Object localObject = new NetworkRequest.Builder();
    ((NetworkRequest.Builder)localObject).addCapability(12);
    ((NetworkRequest.Builder)localObject).addTransportType(0);
    localObject = ((NetworkRequest.Builder)localObject).build();
    this.jdField_a_of_type_AndroidNetConnectivityManager.requestNetwork((NetworkRequest)localObject, this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback);
  }
  
  private void b(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, GatewayCallback paramGatewayCallback)
  {
    ThreadManagerV2.excute(new GateWayVerifyManager.3(this, paramSelfPhoneUrl, paramGatewayCallback), 128, null, true);
  }
  
  private void c(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, GatewayCallback paramGatewayCallback)
  {
    QLog.d("GateWayVerifyManager", 1, "start changeNetTypeToMobileV19");
    ThreadManagerV2.excute(new GateWayVerifyManager.4(this, paramSelfPhoneUrl, paramGatewayCallback), 128, null, true);
  }
  
  private boolean c()
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    try
    {
      Method localMethod = localConnectivityManager.getClass().getMethod("getMobileDataEnabled", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(localConnectivityManager, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("GateWayVerifyManager", 1, new Object[] { "getMobileDataEnabled error : ", localException.getMessage() });
    }
    return true;
  }
  
  @RequiresApi(api=21)
  private void d(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, GatewayCallback paramGatewayCallback)
  {
    boolean bool = false;
    Network localNetwork = a();
    if (localNetwork == null) {
      bool = true;
    }
    QLog.d("GateWayVerifyManager", 1, new Object[] { "start changeNetTypeToMobileV20, mNetwork is null [", Boolean.valueOf(bool), "]" });
    a(new GateWayVerifyManager.5(this, paramSelfPhoneUrl, paramGatewayCallback));
    if (localNetwork == null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new GateWayVerifyManager.6(this, paramGatewayCallback), 4000L);
      return;
    }
    a(paramSelfPhoneUrl, localNetwork, new NetGatewayCallback(paramGatewayCallback, localNetwork));
  }
  
  Network a()
  {
    try
    {
      Network localNetwork = this.jdField_a_of_type_AndroidNetNetwork;
      return localNetwork;
    }
    finally {}
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield 414	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager:jdField_a_of_type_Boolean	Z
    //   7: ifeq +16 -> 23
    //   10: ldc 60
    //   12: iconst_1
    //   13: ldc_w 416
    //   16: invokestatic 349	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: aconst_null
    //   24: putstatic 116	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager:jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager	Lcom/tencent/mobileqq/loginwelcome/GateWayVerifyManager;
    //   27: aload_0
    //   28: iconst_1
    //   29: putfield 414	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager:jdField_a_of_type_Boolean	Z
    //   32: ldc 2
    //   34: monitorexit
    //   35: getstatic 49	android/os/Build$VERSION:SDK_INT	I
    //   38: bipush 21
    //   40: if_icmplt +19 -> 59
    //   43: aload_0
    //   44: getfield 35	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   47: aload_0
    //   48: getfield 56	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager:jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback	Landroid/net/ConnectivityManager$NetworkCallback;
    //   51: invokevirtual 420	android/net/ConnectivityManager:unregisterNetworkCallback	(Landroid/net/ConnectivityManager$NetworkCallback;)V
    //   54: aload_0
    //   55: aconst_null
    //   56: invokevirtual 423	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager:a	(Landroid/net/Network;)V
    //   59: aload_0
    //   60: getfield 43	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   63: aconst_null
    //   64: invokevirtual 427	mqq/os/MqqHandler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   67: return
    //   68: astore_1
    //   69: ldc 2
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    //   74: astore_1
    //   75: ldc 60
    //   77: iconst_1
    //   78: iconst_2
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: ldc_w 429
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: aload_1
    //   91: invokevirtual 66	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   94: aastore
    //   95: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   98: goto -44 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	GateWayVerifyManager
    //   68	5	1	localObject	Object
    //   74	17	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   3	22	68	finally
    //   23	35	68	finally
    //   69	72	68	finally
    //   43	54	74	java/lang/Exception
  }
  
  void a(Network paramNetwork)
  {
    try
    {
      this.jdField_a_of_type_AndroidNetNetwork = paramNetwork;
      return;
    }
    finally {}
  }
  
  public void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, GatewayCallback paramGatewayCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GateWayVerifyManager", 2, new Object[] { "gateway url is : ", paramSelfPhoneUrl.str_upload_url.get() });
    }
    if (this.b)
    {
      paramGatewayCallback.a(new Exception("request network error"));
      return;
    }
    if ((paramSelfPhoneUrl == null) || (TextUtils.isEmpty(paramSelfPhoneUrl.str_upload_url.get())))
    {
      paramGatewayCallback.a(new Exception("urlBean is null or str_upload_url is empty"));
      return;
    }
    QLog.d("GateWayVerifyManager", 1, "start verifyMobile");
    if (NetworkUtil.b(BaseApplication.getContext()))
    {
      QLog.d("GateWayVerifyManager", 1, "current network is mobile");
      b(paramSelfPhoneUrl, paramGatewayCallback);
      return;
    }
    QLog.d("GateWayVerifyManager", 1, "current network is not mobile");
    if (!c())
    {
      paramGatewayCallback.a(new Exception("mobile network is unable"));
      return;
    }
    if (!b())
    {
      paramGatewayCallback.a(new Exception("no sim card"));
      return;
    }
    QLog.d("GateWayVerifyManager", 1, new Object[] { "current version is ", Integer.valueOf(Build.VERSION.SDK_INT) });
    if (Build.VERSION.SDK_INT <= 20)
    {
      c(paramSelfPhoneUrl, paramGatewayCallback);
      return;
    }
    d(paramSelfPhoneUrl, paramGatewayCallback);
  }
  
  public boolean b()
  {
    boolean bool;
    switch (((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getSimState())
    {
    default: 
      bool = true;
    }
    for (;;)
    {
      QLog.d("GateWayVerifyManager", 1, new Object[] { "hasSimCard result : ", Boolean.valueOf(bool) });
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyManager
 * JD-Core Version:    0.7.0.1
 */