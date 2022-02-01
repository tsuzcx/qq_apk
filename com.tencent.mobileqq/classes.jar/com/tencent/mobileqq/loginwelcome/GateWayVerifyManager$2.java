package com.tencent.mobileqq.loginwelcome;

import android.net.Network;
import awoq;
import awou;
import tencent.im.login.GatewayVerify.SelfPhoneUrl;

public class GateWayVerifyManager$2
  implements Runnable
{
  public GateWayVerifyManager$2(awoq paramawoq, GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, Network paramNetwork, awou paramawou) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_2
    //   5: astore_1
    //   6: new 31	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: getfield 18	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:jdField_a_of_type_TencentImLoginGatewayVerify$SelfPhoneUrl	Ltencent/im/login/GatewayVerify$SelfPhoneUrl;
    //   14: getfield 37	tencent/im/login/GatewayVerify$SelfPhoneUrl:str_upload_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   17: invokevirtual 43	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   20: invokespecial 46	java/net/URL:<init>	(Ljava/lang/String;)V
    //   23: astore 4
    //   25: aload_2
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 20	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:jdField_a_of_type_AndroidNetNetwork	Landroid/net/Network;
    //   31: aload 4
    //   33: invokevirtual 52	android/net/Network:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   36: checkcast 54	java/net/HttpURLConnection
    //   39: astore_2
    //   40: aload_0
    //   41: getfield 16	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:this$0	Lawoq;
    //   44: aload_2
    //   45: aload_0
    //   46: getfield 18	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:jdField_a_of_type_TencentImLoginGatewayVerify$SelfPhoneUrl	Ltencent/im/login/GatewayVerify$SelfPhoneUrl;
    //   49: aload_0
    //   50: getfield 22	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:jdField_a_of_type_Awou	Lawou;
    //   53: invokestatic 59	awoq:a	(Lawoq;Ljava/net/HttpURLConnection;Ltencent/im/login/GatewayVerify$SelfPhoneUrl;Lawou;)V
    //   56: aload_2
    //   57: ifnull +7 -> 64
    //   60: aload_2
    //   61: invokevirtual 62	java/net/HttpURLConnection:disconnect	()V
    //   64: return
    //   65: astore_1
    //   66: aload_3
    //   67: astore_2
    //   68: aload_1
    //   69: astore_3
    //   70: aload_2
    //   71: astore_1
    //   72: ldc 64
    //   74: iconst_1
    //   75: iconst_2
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: ldc 66
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: aload_3
    //   87: invokevirtual 69	java/io/IOException:getMessage	()Ljava/lang/String;
    //   90: aastore
    //   91: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   94: aload_2
    //   95: astore_1
    //   96: aload_0
    //   97: getfield 22	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:jdField_a_of_type_Awou	Lawou;
    //   100: iconst_m1
    //   101: aload_3
    //   102: invokeinterface 80 3 0
    //   107: aload_2
    //   108: ifnull -44 -> 64
    //   111: aload_2
    //   112: invokevirtual 62	java/net/HttpURLConnection:disconnect	()V
    //   115: return
    //   116: astore_3
    //   117: aload_1
    //   118: astore_2
    //   119: aload_3
    //   120: astore_1
    //   121: aload_2
    //   122: ifnull +7 -> 129
    //   125: aload_2
    //   126: invokevirtual 62	java/net/HttpURLConnection:disconnect	()V
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: goto -11 -> 121
    //   135: astore_3
    //   136: goto -66 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	2
    //   5	22	1	localObject1	Object
    //   65	4	1	localIOException1	java.io.IOException
    //   71	59	1	localObject2	Object
    //   131	1	1	localObject3	Object
    //   1	125	2	localObject4	Object
    //   3	99	3	localObject5	Object
    //   116	4	3	localObject6	Object
    //   135	1	3	localIOException2	java.io.IOException
    //   23	9	4	localURL	java.net.URL
    // Exception table:
    //   from	to	target	type
    //   6	25	65	java/io/IOException
    //   27	40	65	java/io/IOException
    //   6	25	116	finally
    //   27	40	116	finally
    //   72	94	116	finally
    //   96	107	116	finally
    //   40	56	131	finally
    //   40	56	135	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.2
 * JD-Core Version:    0.7.0.1
 */