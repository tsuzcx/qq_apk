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
  private static volatile GateWayVerifyManager jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager;
  private ConnectivityManager.NetworkCallback jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback;
  private ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
  private Network jdField_a_of_type_AndroidNetNetwork;
  private List<GateWayVerifyManager.OnNetChangedListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private GateWayVerifyManager()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback = a();
        b();
        return;
      }
      catch (Exception localException)
      {
        QLog.d("GateWayVerifyManager", 1, new Object[] { "requestMobileNetwork error : ", localException.getMessage() });
        this.b = true;
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
  
  @RequiresApi(api=21)
  private ConnectivityManager.NetworkCallback a()
  {
    return new GateWayVerifyManager.1(this);
  }
  
  @RequiresApi(api=21)
  private GateWayVerifyManager.OnNetChangedListener a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, GatewayCallback paramGatewayCallback)
  {
    return new GateWayVerifyManager.6(this, paramSelfPhoneUrl, paramGatewayCallback);
  }
  
  public static GateWayVerifyManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager == null) {
          jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager = new GateWayVerifyManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager;
  }
  
  /* Error */
  private java.math.BigInteger a(String paramString)
  {
    // Byte code:
    //   0: getstatic 140	java/math/BigInteger:ZERO	Ljava/math/BigInteger;
    //   3: astore 6
    //   5: aload_1
    //   6: ldc 142
    //   8: invokevirtual 90	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   11: istore_2
    //   12: iload_2
    //   13: iconst_m1
    //   14: if_icmpeq +73 -> 87
    //   17: aload_1
    //   18: iconst_0
    //   19: iload_2
    //   20: invokevirtual 97	java/lang/String:substring	(II)Ljava/lang/String;
    //   23: astore 7
    //   25: aload_1
    //   26: iload_2
    //   27: iconst_1
    //   28: iadd
    //   29: invokevirtual 106	java/lang/String:substring	(I)Ljava/lang/String;
    //   32: astore 8
    //   34: aload_0
    //   35: aload 7
    //   37: invokespecial 134	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager:a	(Ljava/lang/String;)Ljava/math/BigInteger;
    //   40: astore_1
    //   41: aload_0
    //   42: aload 8
    //   44: invokespecial 134	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager:a	(Ljava/lang/String;)Ljava/math/BigInteger;
    //   47: astore 8
    //   49: aload 7
    //   51: invokevirtual 146	java/lang/String:toCharArray	()[C
    //   54: astore 7
    //   56: aload 7
    //   58: arraylength
    //   59: istore 5
    //   61: iconst_0
    //   62: istore_2
    //   63: iconst_0
    //   64: istore 4
    //   66: goto +147 -> 213
    //   69: aload_1
    //   70: bipush 7
    //   72: iload 4
    //   74: isub
    //   75: bipush 16
    //   77: imul
    //   78: invokevirtual 150	java/math/BigInteger:shiftLeft	(I)Ljava/math/BigInteger;
    //   81: aload 8
    //   83: invokevirtual 154	java/math/BigInteger:add	(Ljava/math/BigInteger;)Ljava/math/BigInteger;
    //   86: areturn
    //   87: aload_1
    //   88: ldc 156
    //   90: invokevirtual 160	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   93: astore 7
    //   95: aload 6
    //   97: astore_1
    //   98: iconst_0
    //   99: istore_2
    //   100: aload_1
    //   101: astore 6
    //   103: iload_2
    //   104: aload 7
    //   106: arraylength
    //   107: if_icmpge +103 -> 210
    //   110: aload 7
    //   112: iload_2
    //   113: aaload
    //   114: invokevirtual 164	java/lang/String:isEmpty	()Z
    //   117: ifeq +9 -> 126
    //   120: aload 7
    //   122: iload_2
    //   123: ldc 166
    //   125: aastore
    //   126: aload_1
    //   127: aload 7
    //   129: iload_2
    //   130: aaload
    //   131: bipush 16
    //   133: invokestatic 170	java/lang/Long:valueOf	(Ljava/lang/String;I)Ljava/lang/Long;
    //   136: invokevirtual 174	java/lang/Long:longValue	()J
    //   139: invokestatic 177	java/math/BigInteger:valueOf	(J)Ljava/math/BigInteger;
    //   142: aload 7
    //   144: arraylength
    //   145: iload_2
    //   146: isub
    //   147: iconst_1
    //   148: isub
    //   149: bipush 16
    //   151: imul
    //   152: invokevirtual 150	java/math/BigInteger:shiftLeft	(I)Ljava/math/BigInteger;
    //   155: invokevirtual 154	java/math/BigInteger:add	(Ljava/math/BigInteger;)Ljava/math/BigInteger;
    //   158: astore 6
    //   160: iload_2
    //   161: iconst_1
    //   162: iadd
    //   163: istore_2
    //   164: aload 6
    //   166: astore_1
    //   167: goto -67 -> 100
    //   170: astore 6
    //   172: goto +12 -> 184
    //   175: astore 7
    //   177: aload 6
    //   179: astore_1
    //   180: aload 7
    //   182: astore 6
    //   184: ldc 64
    //   186: iconst_1
    //   187: iconst_2
    //   188: anewarray 4	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: ldc 179
    //   195: aastore
    //   196: dup
    //   197: iconst_1
    //   198: aload 6
    //   200: invokevirtual 70	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   203: aastore
    //   204: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   207: aload_1
    //   208: astore 6
    //   210: aload 6
    //   212: areturn
    //   213: iload_2
    //   214: iload 5
    //   216: if_icmpge -147 -> 69
    //   219: iload 4
    //   221: istore_3
    //   222: aload 7
    //   224: iload_2
    //   225: caload
    //   226: bipush 58
    //   228: if_icmpne +8 -> 236
    //   231: iload 4
    //   233: iconst_1
    //   234: iadd
    //   235: istore_3
    //   236: iload_2
    //   237: iconst_1
    //   238: iadd
    //   239: istore_2
    //   240: iload_3
    //   241: istore 4
    //   243: goto -30 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	GateWayVerifyManager
    //   0	246	1	paramString	String
    //   11	229	2	i	int
    //   221	20	3	j	int
    //   64	178	4	k	int
    //   59	158	5	m	int
    //   3	162	6	localObject1	Object
    //   170	8	6	localException1	Exception
    //   182	29	6	localObject2	Object
    //   23	120	7	localObject3	Object
    //   175	48	7	localException2	Exception
    //   32	50	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   103	120	170	java/lang/Exception
    //   126	160	170	java/lang/Exception
    //   5	12	175	java/lang/Exception
    //   17	61	175	java/lang/Exception
    //   69	87	175	java/lang/Exception
    //   87	95	175	java/lang/Exception
  }
  
  private void a(GateWayVerifyManager.OnNetChangedListener paramOnNetChangedListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramOnNetChangedListener);
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
    //   10: ldc 208
    //   12: invokevirtual 214	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ldc 216
    //   18: ldc 218
    //   20: invokevirtual 222	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_1
    //   24: ldc 224
    //   26: ldc 226
    //   28: invokevirtual 222	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_1
    //   32: sipush 4000
    //   35: invokevirtual 230	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   38: aload_1
    //   39: sipush 4000
    //   42: invokevirtual 233	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   45: aload_1
    //   46: invokevirtual 236	java/net/HttpURLConnection:connect	()V
    //   49: aload_1
    //   50: invokevirtual 240	java/net/HttpURLConnection:getResponseCode	()I
    //   53: istore 4
    //   55: ldc 64
    //   57: iconst_1
    //   58: iconst_2
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: ldc 242
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: iload 4
    //   71: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   78: iload 4
    //   80: sipush 200
    //   83: if_icmpne +134 -> 217
    //   86: aload_1
    //   87: invokevirtual 251	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   90: astore_1
    //   91: new 253	java/io/ByteArrayOutputStream
    //   94: dup
    //   95: invokespecial 254	java/io/ByteArrayOutputStream:<init>	()V
    //   98: astore 5
    //   100: sipush 1024
    //   103: newarray byte
    //   105: astore 6
    //   107: aload_1
    //   108: aload 6
    //   110: invokevirtual 260	java/io/InputStream:read	([B)I
    //   113: istore 4
    //   115: iload 4
    //   117: iconst_m1
    //   118: if_icmpeq +16 -> 134
    //   121: aload 5
    //   123: aload 6
    //   125: iconst_0
    //   126: iload 4
    //   128: invokevirtual 264	java/io/ByteArrayOutputStream:write	([BII)V
    //   131: goto -24 -> 107
    //   134: aload 5
    //   136: invokevirtual 267	java/io/ByteArrayOutputStream:flush	()V
    //   139: aload 5
    //   141: invokevirtual 270	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   144: astore 6
    //   146: aload_3
    //   147: aload_2
    //   148: aload 6
    //   150: invokeinterface 275 3 0
    //   155: ldc 64
    //   157: iconst_1
    //   158: iconst_2
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: ldc_w 277
    //   167: aastore
    //   168: dup
    //   169: iconst_1
    //   170: aload 6
    //   172: aastore
    //   173: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   176: aload 5
    //   178: astore_2
    //   179: goto +119 -> 298
    //   182: astore_2
    //   183: aload 5
    //   185: astore_3
    //   186: goto +18 -> 204
    //   189: astore 6
    //   191: aload 5
    //   193: astore_2
    //   194: aload 6
    //   196: astore 5
    //   198: goto +16 -> 214
    //   201: astore_2
    //   202: aconst_null
    //   203: astore_3
    //   204: aload_2
    //   205: astore 5
    //   207: goto +215 -> 422
    //   210: astore 5
    //   212: aconst_null
    //   213: astore_2
    //   214: goto +132 -> 346
    //   217: iload 4
    //   219: sipush 302
    //   222: if_icmpne +29 -> 251
    //   225: aload_1
    //   226: ldc_w 279
    //   229: invokevirtual 283	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   232: astore_1
    //   233: aload_2
    //   234: getfield 289	tencent/im/login/GatewayVerify$SelfPhoneUrl:str_upload_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   237: aload_1
    //   238: invokevirtual 294	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   241: aload_3
    //   242: aload_2
    //   243: invokeinterface 297 2 0
    //   248: goto +45 -> 293
    //   251: new 299	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   258: astore_1
    //   259: aload_1
    //   260: ldc_w 302
    //   263: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_1
    //   268: iload 4
    //   270: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_3
    //   275: iload 4
    //   277: new 18	java/lang/Exception
    //   280: dup
    //   281: aload_1
    //   282: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokespecial 312	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   288: invokeinterface 315 3 0
    //   293: aconst_null
    //   294: astore_1
    //   295: aload 7
    //   297: astore_2
    //   298: aload_1
    //   299: ifnull +19 -> 318
    //   302: aload_1
    //   303: invokevirtual 318	java/io/InputStream:close	()V
    //   306: goto +12 -> 318
    //   309: ldc 64
    //   311: iconst_1
    //   312: ldc_w 320
    //   315: invokestatic 323	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aload_2
    //   319: ifnull +98 -> 417
    //   322: aload_2
    //   323: invokevirtual 324	java/io/ByteArrayOutputStream:close	()V
    //   326: return
    //   327: astore_2
    //   328: aconst_null
    //   329: astore_3
    //   330: aload 5
    //   332: astore_1
    //   333: aload_2
    //   334: astore 5
    //   336: goto +86 -> 422
    //   339: astore 5
    //   341: aconst_null
    //   342: astore_2
    //   343: aload 6
    //   345: astore_1
    //   346: ldc 64
    //   348: iconst_1
    //   349: iconst_2
    //   350: anewarray 4	java/lang/Object
    //   353: dup
    //   354: iconst_0
    //   355: ldc_w 326
    //   358: aastore
    //   359: dup
    //   360: iconst_1
    //   361: aload 5
    //   363: invokevirtual 327	java/io/IOException:getMessage	()Ljava/lang/String;
    //   366: aastore
    //   367: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   370: aload_3
    //   371: iconst_m1
    //   372: aload 5
    //   374: invokeinterface 315 3 0
    //   379: aload_1
    //   380: ifnull +19 -> 399
    //   383: aload_1
    //   384: invokevirtual 318	java/io/InputStream:close	()V
    //   387: goto +12 -> 399
    //   390: ldc 64
    //   392: iconst_1
    //   393: ldc_w 320
    //   396: invokestatic 323	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: aload_2
    //   400: ifnull +17 -> 417
    //   403: aload_2
    //   404: invokevirtual 324	java/io/ByteArrayOutputStream:close	()V
    //   407: return
    //   408: ldc 64
    //   410: iconst_1
    //   411: ldc_w 329
    //   414: invokestatic 323	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: return
    //   418: astore 5
    //   420: aload_2
    //   421: astore_3
    //   422: aload_1
    //   423: ifnull +19 -> 442
    //   426: aload_1
    //   427: invokevirtual 318	java/io/InputStream:close	()V
    //   430: goto +12 -> 442
    //   433: ldc 64
    //   435: iconst_1
    //   436: ldc_w 320
    //   439: invokestatic 323	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: aload_3
    //   443: ifnull +19 -> 462
    //   446: aload_3
    //   447: invokevirtual 324	java/io/ByteArrayOutputStream:close	()V
    //   450: goto +12 -> 462
    //   453: ldc 64
    //   455: iconst_1
    //   456: ldc_w 329
    //   459: invokestatic 323	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: goto +6 -> 468
    //   465: aload 5
    //   467: athrow
    //   468: goto -3 -> 465
    //   471: astore_1
    //   472: goto -163 -> 309
    //   475: astore_1
    //   476: goto -68 -> 408
    //   479: astore_1
    //   480: goto -90 -> 390
    //   483: astore_1
    //   484: goto -51 -> 433
    //   487: astore_1
    //   488: goto -35 -> 453
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	this	GateWayVerifyManager
    //   0	491	1	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	491	2	paramSelfPhoneUrl	GatewayVerify.SelfPhoneUrl
    //   0	491	3	paramGatewayCallback	GatewayCallback
    //   53	223	4	i	int
    //   4	202	5	localObject1	Object
    //   210	121	5	localIOException1	java.io.IOException
    //   334	1	5	localSelfPhoneUrl	GatewayVerify.SelfPhoneUrl
    //   339	34	5	localIOException2	java.io.IOException
    //   418	48	5	localObject2	Object
    //   1	170	6	localObject3	Object
    //   189	155	6	localIOException3	java.io.IOException
    //   7	289	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   100	107	182	finally
    //   107	115	182	finally
    //   121	131	182	finally
    //   134	176	182	finally
    //   100	107	189	java/io/IOException
    //   107	115	189	java/io/IOException
    //   121	131	189	java/io/IOException
    //   134	176	189	java/io/IOException
    //   91	100	201	finally
    //   91	100	210	java/io/IOException
    //   9	78	327	finally
    //   86	91	327	finally
    //   225	248	327	finally
    //   251	293	327	finally
    //   9	78	339	java/io/IOException
    //   86	91	339	java/io/IOException
    //   225	248	339	java/io/IOException
    //   251	293	339	java/io/IOException
    //   346	379	418	finally
    //   302	306	471	java/io/IOException
    //   322	326	475	java/io/IOException
    //   403	407	475	java/io/IOException
    //   383	387	479	java/io/IOException
    //   426	430	483	java/io/IOException
    //   446	450	487	java/io/IOException
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
  
  private void b(Network paramNetwork)
  {
    try
    {
      QLog.d("GateWayVerifyManager", 1, "switch network success");
      if ((this.jdField_a_of_type_AndroidNetNetwork == null) || (!this.jdField_a_of_type_AndroidNetNetwork.equals(paramNetwork)))
      {
        a(paramNetwork);
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
    this.jdField_a_of_type_JavaUtilList.remove(paramOnNetChangedListener);
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
    try
    {
      GateWayVerifyManager.OnNetChangedListener localOnNetChangedListener = a(paramSelfPhoneUrl, paramGatewayCallback);
      a(localOnNetChangedListener);
      Network localNetwork = a();
      boolean bool = false;
      if (localNetwork == null) {
        bool = true;
      }
      QLog.d("GateWayVerifyManager", 1, new Object[] { "start changeNetTypeToMobileV20, mNetwork is null [", Boolean.valueOf(bool), "]" });
      if (localNetwork == null) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new GateWayVerifyManager.5(this, localOnNetChangedListener, paramGatewayCallback), 4000L);
      } else {
        a(paramSelfPhoneUrl, localNetwork, new NetGatewayCallback(paramGatewayCallback, localNetwork));
      }
      return;
    }
    finally {}
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
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        QLog.d("GateWayVerifyManager", 1, "current gateway manage has been destroyed");
        return;
      }
      jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager = null;
      this.jdField_a_of_type_Boolean = true;
      if (Build.VERSION.SDK_INT >= 21)
      {
        try
        {
          this.jdField_a_of_type_AndroidNetConnectivityManager.unregisterNetworkCallback(this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback);
        }
        catch (Exception localException)
        {
          QLog.d("GateWayVerifyManager", 1, new Object[] { "unregisterNetworkCallback error : ", localException.getMessage() });
        }
        a(null);
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      return;
    }
    finally {}
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
      return;
    }
    paramGatewayCallback.a(new Exception("urlBean is null or str_upload_url is empty"));
  }
  
  public boolean b()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyManager
 * JD-Core Version:    0.7.0.1
 */