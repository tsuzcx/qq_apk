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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.login.GatewayVerify.SelfPhoneUrl;

public class GateWayVerifyManager
{
  private static volatile GateWayVerifyManager a;
  private ConnectivityManager b = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
  private Network c;
  private ConnectivityManager.NetworkCallback d;
  private MqqHandler e = ThreadManager.getUIHandler();
  private List<GateWayVerifyManager.OnNetChangedListener> f = new ArrayList();
  private boolean g;
  private boolean h;
  
  private GateWayVerifyManager()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        this.d = f();
        g();
        return;
      }
      catch (Exception localException)
      {
        QLog.d("GateWayVerifyManager", 1, new Object[] { "requestMobileNetwork error : ", localException.getMessage() });
        this.h = true;
      }
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
      int j = i + 1;
      int k = paramString.indexOf(".", j);
      int m = k + 1;
      int n = paramString.indexOf(".", m);
      arrayOfLong[0] = Long.parseLong(paramString.substring(0, i));
      arrayOfLong[1] = Long.parseLong(paramString.substring(j, k));
      arrayOfLong[2] = Long.parseLong(paramString.substring(m, n));
      arrayOfLong[3] = Long.parseLong(paramString.substring(n + 1));
      long l1 = arrayOfLong[3];
      long l2 = arrayOfLong[2];
      long l3 = arrayOfLong[1];
      long l4 = arrayOfLong[0];
      return (int)((l1 << 24) + (l2 << 16) + (l3 << 8) + l4);
    }
    catch (Exception paramString)
    {
      QLog.e("GateWayVerifyManager", 1, new Object[] { "ipv4toInt error : ", paramString.getMessage() });
    }
    return 0;
  }
  
  public static GateWayVerifyManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new GateWayVerifyManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(GateWayVerifyManager.OnNetChangedListener paramOnNetChangedListener)
  {
    this.f.add(paramOnNetChangedListener);
  }
  
  /* Error */
  private void a(java.net.HttpURLConnection paramHttpURLConnection, GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, GatewayCallback paramGatewayCallback)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_1
    //   10: ldc 150
    //   12: invokevirtual 156	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ldc 158
    //   18: ldc 160
    //   20: invokevirtual 164	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_1
    //   24: ldc 166
    //   26: ldc 168
    //   28: invokevirtual 164	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_1
    //   32: sipush 4000
    //   35: invokevirtual 172	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   38: aload_1
    //   39: sipush 4000
    //   42: invokevirtual 175	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   45: aload_1
    //   46: invokevirtual 178	java/net/HttpURLConnection:connect	()V
    //   49: aload_1
    //   50: invokevirtual 182	java/net/HttpURLConnection:getResponseCode	()I
    //   53: istore 4
    //   55: ldc 70
    //   57: iconst_1
    //   58: iconst_2
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: ldc 184
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: iload 4
    //   71: invokestatic 190	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   78: iload 4
    //   80: sipush 200
    //   83: if_icmpne +133 -> 216
    //   86: aload_1
    //   87: invokevirtual 194	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   90: astore_1
    //   91: new 196	java/io/ByteArrayOutputStream
    //   94: dup
    //   95: invokespecial 197	java/io/ByteArrayOutputStream:<init>	()V
    //   98: astore 5
    //   100: sipush 1024
    //   103: newarray byte
    //   105: astore 6
    //   107: aload_1
    //   108: aload 6
    //   110: invokevirtual 203	java/io/InputStream:read	([B)I
    //   113: istore 4
    //   115: iload 4
    //   117: iconst_m1
    //   118: if_icmpeq +16 -> 134
    //   121: aload 5
    //   123: aload 6
    //   125: iconst_0
    //   126: iload 4
    //   128: invokevirtual 207	java/io/ByteArrayOutputStream:write	([BII)V
    //   131: goto -24 -> 107
    //   134: aload 5
    //   136: invokevirtual 210	java/io/ByteArrayOutputStream:flush	()V
    //   139: aload 5
    //   141: invokevirtual 213	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   144: astore 6
    //   146: aload_3
    //   147: aload_2
    //   148: aload 6
    //   150: invokeinterface 218 3 0
    //   155: ldc 70
    //   157: iconst_1
    //   158: iconst_2
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: ldc 220
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: aload 6
    //   171: aastore
    //   172: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   175: aload 5
    //   177: astore_2
    //   178: goto +117 -> 295
    //   181: astore_2
    //   182: aload 5
    //   184: astore_3
    //   185: goto +18 -> 203
    //   188: astore 6
    //   190: aload 5
    //   192: astore_2
    //   193: aload 6
    //   195: astore 5
    //   197: goto +16 -> 213
    //   200: astore_2
    //   201: aconst_null
    //   202: astore_3
    //   203: aload_2
    //   204: astore 5
    //   206: goto +213 -> 419
    //   209: astore 5
    //   211: aconst_null
    //   212: astore_2
    //   213: goto +130 -> 343
    //   216: iload 4
    //   218: sipush 302
    //   221: if_icmpne +28 -> 249
    //   224: aload_1
    //   225: ldc 222
    //   227: invokevirtual 226	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   230: astore_1
    //   231: aload_2
    //   232: getfield 232	tencent/im/login/GatewayVerify$SelfPhoneUrl:str_upload_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   235: aload_1
    //   236: invokevirtual 237	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   239: aload_3
    //   240: aload_2
    //   241: invokeinterface 240 2 0
    //   246: goto +44 -> 290
    //   249: new 242	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   256: astore_1
    //   257: aload_1
    //   258: ldc 245
    //   260: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_1
    //   265: iload 4
    //   267: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_3
    //   272: iload 4
    //   274: new 24	java/lang/Exception
    //   277: dup
    //   278: aload_1
    //   279: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokespecial 255	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   285: invokeinterface 258 3 0
    //   290: aconst_null
    //   291: astore_1
    //   292: aload 7
    //   294: astore_2
    //   295: aload_1
    //   296: ifnull +19 -> 315
    //   299: aload_1
    //   300: invokevirtual 261	java/io/InputStream:close	()V
    //   303: goto +12 -> 315
    //   306: ldc 70
    //   308: iconst_1
    //   309: ldc_w 263
    //   312: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload_2
    //   316: ifnull +98 -> 414
    //   319: aload_2
    //   320: invokevirtual 267	java/io/ByteArrayOutputStream:close	()V
    //   323: return
    //   324: astore_2
    //   325: aconst_null
    //   326: astore_3
    //   327: aload 5
    //   329: astore_1
    //   330: aload_2
    //   331: astore 5
    //   333: goto +86 -> 419
    //   336: astore 5
    //   338: aconst_null
    //   339: astore_2
    //   340: aload 6
    //   342: astore_1
    //   343: ldc 70
    //   345: iconst_1
    //   346: iconst_2
    //   347: anewarray 4	java/lang/Object
    //   350: dup
    //   351: iconst_0
    //   352: ldc_w 269
    //   355: aastore
    //   356: dup
    //   357: iconst_1
    //   358: aload 5
    //   360: invokevirtual 270	java/io/IOException:getMessage	()Ljava/lang/String;
    //   363: aastore
    //   364: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   367: aload_3
    //   368: iconst_m1
    //   369: aload 5
    //   371: invokeinterface 258 3 0
    //   376: aload_1
    //   377: ifnull +19 -> 396
    //   380: aload_1
    //   381: invokevirtual 261	java/io/InputStream:close	()V
    //   384: goto +12 -> 396
    //   387: ldc 70
    //   389: iconst_1
    //   390: ldc_w 263
    //   393: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   396: aload_2
    //   397: ifnull +17 -> 414
    //   400: aload_2
    //   401: invokevirtual 267	java/io/ByteArrayOutputStream:close	()V
    //   404: return
    //   405: ldc 70
    //   407: iconst_1
    //   408: ldc_w 272
    //   411: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   414: return
    //   415: astore 5
    //   417: aload_2
    //   418: astore_3
    //   419: aload_1
    //   420: ifnull +19 -> 439
    //   423: aload_1
    //   424: invokevirtual 261	java/io/InputStream:close	()V
    //   427: goto +12 -> 439
    //   430: ldc 70
    //   432: iconst_1
    //   433: ldc_w 263
    //   436: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: aload_3
    //   440: ifnull +19 -> 459
    //   443: aload_3
    //   444: invokevirtual 267	java/io/ByteArrayOutputStream:close	()V
    //   447: goto +12 -> 459
    //   450: ldc 70
    //   452: iconst_1
    //   453: ldc_w 272
    //   456: invokestatic 266	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: goto +6 -> 465
    //   462: aload 5
    //   464: athrow
    //   465: goto -3 -> 462
    //   468: astore_1
    //   469: goto -163 -> 306
    //   472: astore_1
    //   473: goto -68 -> 405
    //   476: astore_1
    //   477: goto -90 -> 387
    //   480: astore_1
    //   481: goto -51 -> 430
    //   484: astore_1
    //   485: goto -35 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	GateWayVerifyManager
    //   0	488	1	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	488	2	paramSelfPhoneUrl	GatewayVerify.SelfPhoneUrl
    //   0	488	3	paramGatewayCallback	GatewayCallback
    //   53	220	4	i	int
    //   4	201	5	localObject1	Object
    //   209	119	5	localIOException1	java.io.IOException
    //   331	1	5	localSelfPhoneUrl	GatewayVerify.SelfPhoneUrl
    //   336	34	5	localIOException2	java.io.IOException
    //   415	48	5	localObject2	Object
    //   1	169	6	localObject3	Object
    //   188	153	6	localIOException3	java.io.IOException
    //   7	286	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   100	107	181	finally
    //   107	115	181	finally
    //   121	131	181	finally
    //   134	175	181	finally
    //   100	107	188	java/io/IOException
    //   107	115	188	java/io/IOException
    //   121	131	188	java/io/IOException
    //   134	175	188	java/io/IOException
    //   91	100	200	finally
    //   91	100	209	java/io/IOException
    //   9	78	324	finally
    //   86	91	324	finally
    //   224	246	324	finally
    //   249	290	324	finally
    //   9	78	336	java/io/IOException
    //   86	91	336	java/io/IOException
    //   224	246	336	java/io/IOException
    //   249	290	336	java/io/IOException
    //   343	376	415	finally
    //   299	303	468	java/io/IOException
    //   319	323	472	java/io/IOException
    //   400	404	472	java/io/IOException
    //   380	384	476	java/io/IOException
    //   423	427	480	java/io/IOException
    //   443	447	484	java/io/IOException
  }
  
  @RequiresApi(api=21)
  private void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, Network paramNetwork, GatewayCallback paramGatewayCallback)
  {
    ThreadManagerV2.excute(new GateWayVerifyManager.2(this, paramSelfPhoneUrl, paramNetwork, paramGatewayCallback), 128, null, true);
  }
  
  /* Error */
  private java.math.BigInteger b(String paramString)
  {
    // Byte code:
    //   0: getstatic 296	java/math/BigInteger:ZERO	Ljava/math/BigInteger;
    //   3: astore 6
    //   5: aload_1
    //   6: ldc_w 298
    //   9: invokevirtual 95	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   12: istore_2
    //   13: iload_2
    //   14: iconst_m1
    //   15: if_icmpeq +73 -> 88
    //   18: aload_1
    //   19: iconst_0
    //   20: iload_2
    //   21: invokevirtual 102	java/lang/String:substring	(II)Ljava/lang/String;
    //   24: astore 7
    //   26: aload_1
    //   27: iload_2
    //   28: iconst_1
    //   29: iadd
    //   30: invokevirtual 111	java/lang/String:substring	(I)Ljava/lang/String;
    //   33: astore 8
    //   35: aload_0
    //   36: aload 7
    //   38: invokespecial 290	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager:b	(Ljava/lang/String;)Ljava/math/BigInteger;
    //   41: astore_1
    //   42: aload_0
    //   43: aload 8
    //   45: invokespecial 290	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager:b	(Ljava/lang/String;)Ljava/math/BigInteger;
    //   48: astore 8
    //   50: aload 7
    //   52: invokevirtual 302	java/lang/String:toCharArray	()[C
    //   55: astore 7
    //   57: aload 7
    //   59: arraylength
    //   60: istore 5
    //   62: iconst_0
    //   63: istore_2
    //   64: iconst_0
    //   65: istore 4
    //   67: goto +150 -> 217
    //   70: aload_1
    //   71: bipush 7
    //   73: iload 4
    //   75: isub
    //   76: bipush 16
    //   78: imul
    //   79: invokevirtual 306	java/math/BigInteger:shiftLeft	(I)Ljava/math/BigInteger;
    //   82: aload 8
    //   84: invokevirtual 309	java/math/BigInteger:add	(Ljava/math/BigInteger;)Ljava/math/BigInteger;
    //   87: areturn
    //   88: aload_1
    //   89: ldc_w 311
    //   92: invokevirtual 315	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   95: astore 7
    //   97: aload 6
    //   99: astore_1
    //   100: iconst_0
    //   101: istore_2
    //   102: aload_1
    //   103: astore 6
    //   105: iload_2
    //   106: aload 7
    //   108: arraylength
    //   109: if_icmpge +105 -> 214
    //   112: aload 7
    //   114: iload_2
    //   115: aaload
    //   116: invokevirtual 319	java/lang/String:isEmpty	()Z
    //   119: ifeq +10 -> 129
    //   122: aload 7
    //   124: iload_2
    //   125: ldc_w 321
    //   128: aastore
    //   129: aload_1
    //   130: aload 7
    //   132: iload_2
    //   133: aaload
    //   134: bipush 16
    //   136: invokestatic 324	java/lang/Long:valueOf	(Ljava/lang/String;I)Ljava/lang/Long;
    //   139: invokevirtual 328	java/lang/Long:longValue	()J
    //   142: invokestatic 331	java/math/BigInteger:valueOf	(J)Ljava/math/BigInteger;
    //   145: aload 7
    //   147: arraylength
    //   148: iload_2
    //   149: isub
    //   150: iconst_1
    //   151: isub
    //   152: bipush 16
    //   154: imul
    //   155: invokevirtual 306	java/math/BigInteger:shiftLeft	(I)Ljava/math/BigInteger;
    //   158: invokevirtual 309	java/math/BigInteger:add	(Ljava/math/BigInteger;)Ljava/math/BigInteger;
    //   161: astore 6
    //   163: iload_2
    //   164: iconst_1
    //   165: iadd
    //   166: istore_2
    //   167: aload 6
    //   169: astore_1
    //   170: goto -68 -> 102
    //   173: astore 6
    //   175: goto +12 -> 187
    //   178: astore 7
    //   180: aload 6
    //   182: astore_1
    //   183: aload 7
    //   185: astore 6
    //   187: ldc 70
    //   189: iconst_1
    //   190: iconst_2
    //   191: anewarray 4	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: ldc_w 333
    //   199: aastore
    //   200: dup
    //   201: iconst_1
    //   202: aload 6
    //   204: invokevirtual 76	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   207: aastore
    //   208: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   211: aload_1
    //   212: astore 6
    //   214: aload 6
    //   216: areturn
    //   217: iload_2
    //   218: iload 5
    //   220: if_icmpge -150 -> 70
    //   223: iload 4
    //   225: istore_3
    //   226: aload 7
    //   228: iload_2
    //   229: caload
    //   230: bipush 58
    //   232: if_icmpne +8 -> 240
    //   235: iload 4
    //   237: iconst_1
    //   238: iadd
    //   239: istore_3
    //   240: iload_2
    //   241: iconst_1
    //   242: iadd
    //   243: istore_2
    //   244: iload_3
    //   245: istore 4
    //   247: goto -30 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	GateWayVerifyManager
    //   0	250	1	paramString	String
    //   12	232	2	i	int
    //   225	20	3	j	int
    //   65	181	4	k	int
    //   60	161	5	m	int
    //   3	165	6	localObject1	Object
    //   173	8	6	localException1	Exception
    //   185	30	6	localObject2	Object
    //   24	122	7	localObject3	Object
    //   178	49	7	localException2	Exception
    //   33	50	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   105	122	173	java/lang/Exception
    //   129	163	173	java/lang/Exception
    //   5	13	178	java/lang/Exception
    //   18	62	178	java/lang/Exception
    //   70	88	178	java/lang/Exception
    //   88	97	178	java/lang/Exception
  }
  
  private void b(Network paramNetwork)
  {
    try
    {
      QLog.d("GateWayVerifyManager", 1, "switch network success");
      if ((this.c == null) || (!this.c.equals(paramNetwork)))
      {
        a(paramNetwork);
        Iterator localIterator = this.f.iterator();
        while (localIterator.hasNext()) {
          ((GateWayVerifyManager.OnNetChangedListener)localIterator.next()).a(paramNetwork);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramNetwork;
    }
  }
  
  private void b(GateWayVerifyManager.OnNetChangedListener paramOnNetChangedListener)
  {
    this.f.remove(paramOnNetChangedListener);
  }
  
  private void b(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, GatewayCallback paramGatewayCallback)
  {
    ThreadManagerV2.excute(new GateWayVerifyManager.3(this, paramSelfPhoneUrl, paramGatewayCallback), 128, null, true);
  }
  
  public static boolean b()
  {
    return a == null;
  }
  
  private void c(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, GatewayCallback paramGatewayCallback)
  {
    QLog.d("GateWayVerifyManager", 1, "start changeNetTypeToMobileV19");
    ThreadManagerV2.excute(new GateWayVerifyManager.4(this, paramSelfPhoneUrl, paramGatewayCallback), 128, null, true);
  }
  
  @RequiresApi(api=21)
  private void d(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, GatewayCallback paramGatewayCallback)
  {
    try
    {
      GateWayVerifyManager.OnNetChangedListener localOnNetChangedListener = e(paramSelfPhoneUrl, paramGatewayCallback);
      a(localOnNetChangedListener);
      Network localNetwork = c();
      boolean bool = false;
      if (localNetwork == null) {
        bool = true;
      }
      QLog.d("GateWayVerifyManager", 1, new Object[] { "start changeNetTypeToMobileV20, mNetwork is null [", Boolean.valueOf(bool), "]" });
      if (localNetwork == null) {
        this.e.postDelayed(new GateWayVerifyManager.5(this, localOnNetChangedListener, paramGatewayCallback), 4000L);
      } else {
        a(paramSelfPhoneUrl, localNetwork, new NetGatewayCallback(paramGatewayCallback, localNetwork));
      }
      return;
    }
    finally {}
  }
  
  @RequiresApi(api=21)
  private GateWayVerifyManager.OnNetChangedListener e(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, GatewayCallback paramGatewayCallback)
  {
    return new GateWayVerifyManager.6(this, paramSelfPhoneUrl, paramGatewayCallback);
  }
  
  @RequiresApi(api=21)
  private ConnectivityManager.NetworkCallback f()
  {
    return new GateWayVerifyManager.1(this);
  }
  
  @RequiresApi(api=21)
  private void g()
  {
    Object localObject = new NetworkRequest.Builder();
    ((NetworkRequest.Builder)localObject).addCapability(12);
    ((NetworkRequest.Builder)localObject).addTransportType(0);
    localObject = ((NetworkRequest.Builder)localObject).build();
    this.b.requestNetwork((NetworkRequest)localObject, this.d);
  }
  
  private boolean h()
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
  
  void a(Network paramNetwork)
  {
    try
    {
      this.c = paramNetwork;
      return;
    }
    finally {}
  }
  
  public void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, GatewayCallback paramGatewayCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GateWayVerifyManager", 2, new Object[] { "gateway url is : ", paramSelfPhoneUrl.str_upload_url.get() });
    }
    if (this.h)
    {
      paramGatewayCallback.a(new Exception("request network error"));
      return;
    }
    if ((paramSelfPhoneUrl != null) && (!TextUtils.isEmpty(paramSelfPhoneUrl.str_upload_url.get())))
    {
      QLog.d("GateWayVerifyManager", 1, "start verifyMobile");
      if (NetworkUtil.isMobileNetWork(BaseApplication.getContext()))
      {
        QLog.d("GateWayVerifyManager", 1, "current network is mobile");
        b(paramSelfPhoneUrl, paramGatewayCallback);
        return;
      }
      QLog.d("GateWayVerifyManager", 1, "current network is not mobile");
      if (!h())
      {
        paramGatewayCallback.a(new Exception("mobile network is unable"));
        return;
      }
      if (!d())
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
      return;
    }
    paramGatewayCallback.a(new Exception("urlBean is null or str_upload_url is empty"));
  }
  
  Network c()
  {
    try
    {
      Network localNetwork = this.c;
      return localNetwork;
    }
    finally {}
  }
  
  public boolean d()
  {
    int i = ((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getSimState();
    boolean bool;
    if ((i != 0) && (i != 1)) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("GateWayVerifyManager", 1, new Object[] { "hasSimCard result : ", Boolean.valueOf(bool) });
    return bool;
  }
  
  public void e()
  {
    try
    {
      if (this.g)
      {
        QLog.d("GateWayVerifyManager", 1, "current gateway manage has been destroyed");
        return;
      }
      a = null;
      this.g = true;
      if (Build.VERSION.SDK_INT >= 21)
      {
        try
        {
          this.b.unregisterNetworkCallback(this.d);
        }
        catch (Exception localException)
        {
          QLog.d("GateWayVerifyManager", 1, new Object[] { "unregisterNetworkCallback error : ", localException.getMessage() });
        }
        a(null);
        this.f.clear();
      }
      this.e.removeCallbacksAndMessages(null);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyManager
 * JD-Core Version:    0.7.0.1
 */