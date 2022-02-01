package com.tencent.mobileqq.loginwelcome;

import android.net.Network;
import tencent.im.login.GatewayVerify.SelfPhoneUrl;

class GateWayVerifyManager$2
  implements Runnable
{
  GateWayVerifyManager$2(GateWayVerifyManager paramGateWayVerifyManager, GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, Network paramNetwork, GatewayCallback paramGatewayCallback) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aload_2
    //   6: astore_1
    //   7: new 31	java/net/URL
    //   10: dup
    //   11: aload_0
    //   12: getfield 18	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:jdField_a_of_type_TencentImLoginGatewayVerify$SelfPhoneUrl	Ltencent/im/login/GatewayVerify$SelfPhoneUrl;
    //   15: getfield 37	tencent/im/login/GatewayVerify$SelfPhoneUrl:str_upload_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   18: invokevirtual 43	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   21: invokespecial 46	java/net/URL:<init>	(Ljava/lang/String;)V
    //   24: astore_3
    //   25: aload_2
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 20	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:jdField_a_of_type_AndroidNetNetwork	Landroid/net/Network;
    //   31: aload_3
    //   32: invokevirtual 52	android/net/Network:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   35: checkcast 54	java/net/HttpURLConnection
    //   38: astore_2
    //   39: aload_0
    //   40: getfield 16	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:this$0	Lcom/tencent/mobileqq/loginwelcome/GateWayVerifyManager;
    //   43: aload_2
    //   44: aload_0
    //   45: getfield 18	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:jdField_a_of_type_TencentImLoginGatewayVerify$SelfPhoneUrl	Ltencent/im/login/GatewayVerify$SelfPhoneUrl;
    //   48: aload_0
    //   49: getfield 22	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:jdField_a_of_type_ComTencentMobileqqLoginwelcomeGatewayCallback	Lcom/tencent/mobileqq/loginwelcome/GatewayCallback;
    //   52: invokestatic 59	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager:a	(Lcom/tencent/mobileqq/loginwelcome/GateWayVerifyManager;Ljava/net/HttpURLConnection;Ltencent/im/login/GatewayVerify$SelfPhoneUrl;Lcom/tencent/mobileqq/loginwelcome/GatewayCallback;)V
    //   55: aload_2
    //   56: ifnull +75 -> 131
    //   59: aload_2
    //   60: invokevirtual 62	java/net/HttpURLConnection:disconnect	()V
    //   63: return
    //   64: astore_1
    //   65: goto +67 -> 132
    //   68: astore_1
    //   69: aload_1
    //   70: astore_3
    //   71: goto +15 -> 86
    //   74: astore_3
    //   75: aload_1
    //   76: astore_2
    //   77: aload_3
    //   78: astore_1
    //   79: goto +53 -> 132
    //   82: astore_3
    //   83: aload 4
    //   85: astore_2
    //   86: aload_2
    //   87: astore_1
    //   88: ldc 64
    //   90: iconst_1
    //   91: iconst_2
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: ldc 66
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: aload_3
    //   103: invokevirtual 69	java/io/IOException:getMessage	()Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   110: aload_2
    //   111: astore_1
    //   112: aload_0
    //   113: getfield 22	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:jdField_a_of_type_ComTencentMobileqqLoginwelcomeGatewayCallback	Lcom/tencent/mobileqq/loginwelcome/GatewayCallback;
    //   116: iconst_m1
    //   117: aload_3
    //   118: invokeinterface 81 3 0
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 62	java/net/HttpURLConnection:disconnect	()V
    //   131: return
    //   132: aload_2
    //   133: ifnull +7 -> 140
    //   136: aload_2
    //   137: invokevirtual 62	java/net/HttpURLConnection:disconnect	()V
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	2
    //   6	21	1	localObject1	Object
    //   64	1	1	localObject2	Object
    //   68	8	1	localIOException1	java.io.IOException
    //   78	63	1	localObject3	Object
    //   4	133	2	localObject4	Object
    //   24	47	3	localObject5	Object
    //   74	4	3	localObject6	Object
    //   82	36	3	localIOException2	java.io.IOException
    //   1	83	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   39	55	64	finally
    //   39	55	68	java/io/IOException
    //   7	25	74	finally
    //   27	39	74	finally
    //   88	110	74	finally
    //   112	123	74	finally
    //   7	25	82	java/io/IOException
    //   27	39	82	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.2
 * JD-Core Version:    0.7.0.1
 */