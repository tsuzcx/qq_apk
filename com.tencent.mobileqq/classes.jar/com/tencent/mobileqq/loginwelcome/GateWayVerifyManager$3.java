package com.tencent.mobileqq.loginwelcome;

import tencent.im.login.GatewayVerify.SelfPhoneUrl;

class GateWayVerifyManager$3
  implements Runnable
{
  GateWayVerifyManager$3(GateWayVerifyManager paramGateWayVerifyManager, GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, GatewayCallback paramGatewayCallback) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 28
    //   2: iconst_1
    //   3: ldc 30
    //   5: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_1
    //   13: new 38	java/net/URL
    //   16: dup
    //   17: aload_0
    //   18: getfield 17	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$3:jdField_a_of_type_TencentImLoginGatewayVerify$SelfPhoneUrl	Ltencent/im/login/GatewayVerify$SelfPhoneUrl;
    //   21: getfield 44	tencent/im/login/GatewayVerify$SelfPhoneUrl:str_upload_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   24: invokevirtual 50	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   27: invokespecial 53	java/net/URL:<init>	(Ljava/lang/String;)V
    //   30: invokevirtual 57	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   33: checkcast 59	java/net/HttpURLConnection
    //   36: astore_2
    //   37: aload_0
    //   38: getfield 15	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$3:this$0	Lcom/tencent/mobileqq/loginwelcome/GateWayVerifyManager;
    //   41: aload_2
    //   42: aload_0
    //   43: getfield 17	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$3:jdField_a_of_type_TencentImLoginGatewayVerify$SelfPhoneUrl	Ltencent/im/login/GatewayVerify$SelfPhoneUrl;
    //   46: aload_0
    //   47: getfield 19	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$3:jdField_a_of_type_ComTencentMobileqqLoginwelcomeGatewayCallback	Lcom/tencent/mobileqq/loginwelcome/GatewayCallback;
    //   50: invokestatic 64	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager:a	(Lcom/tencent/mobileqq/loginwelcome/GateWayVerifyManager;Ljava/net/HttpURLConnection;Ltencent/im/login/GatewayVerify$SelfPhoneUrl;Lcom/tencent/mobileqq/loginwelcome/GatewayCallback;)V
    //   53: aload_2
    //   54: ifnull +75 -> 129
    //   57: aload_2
    //   58: invokevirtual 67	java/net/HttpURLConnection:disconnect	()V
    //   61: return
    //   62: astore_3
    //   63: aload_2
    //   64: astore_1
    //   65: aload_3
    //   66: astore_2
    //   67: goto +63 -> 130
    //   70: astore_1
    //   71: aload_1
    //   72: astore_3
    //   73: goto +11 -> 84
    //   76: astore_2
    //   77: goto +53 -> 130
    //   80: astore_3
    //   81: aload 4
    //   83: astore_2
    //   84: aload_2
    //   85: astore_1
    //   86: ldc 28
    //   88: iconst_1
    //   89: iconst_2
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: ldc 69
    //   97: aastore
    //   98: dup
    //   99: iconst_1
    //   100: aload_3
    //   101: invokevirtual 72	java/io/IOException:getMessage	()Ljava/lang/String;
    //   104: aastore
    //   105: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   108: aload_2
    //   109: astore_1
    //   110: aload_0
    //   111: getfield 19	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$3:jdField_a_of_type_ComTencentMobileqqLoginwelcomeGatewayCallback	Lcom/tencent/mobileqq/loginwelcome/GatewayCallback;
    //   114: iconst_m1
    //   115: aload_3
    //   116: invokeinterface 82 3 0
    //   121: aload_2
    //   122: ifnull +7 -> 129
    //   125: aload_2
    //   126: invokevirtual 67	java/net/HttpURLConnection:disconnect	()V
    //   129: return
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 67	java/net/HttpURLConnection:disconnect	()V
    //   138: aload_2
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	3
    //   12	53	1	localObject1	Object
    //   70	2	1	localIOException1	java.io.IOException
    //   85	50	1	localObject2	Object
    //   36	31	2	localObject3	Object
    //   76	1	2	localObject4	Object
    //   83	56	2	localObject5	Object
    //   62	4	3	localObject6	Object
    //   72	1	3	localIOException2	java.io.IOException
    //   80	36	3	localIOException3	java.io.IOException
    //   9	73	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   37	53	62	finally
    //   37	53	70	java/io/IOException
    //   13	37	76	finally
    //   86	108	76	finally
    //   110	121	76	finally
    //   13	37	80	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.3
 * JD-Core Version:    0.7.0.1
 */