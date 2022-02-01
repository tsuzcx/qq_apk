package com.tencent.mobileqq.vashealth;

import mqq.observer.BusinessObserver;

class HealthBusinessPlugin$4
  implements BusinessObserver
{
  HealthBusinessPlugin$4(HealthBusinessPlugin paramHealthBusinessPlugin, String paramString) {}
  
  /* Error */
  public void onReceive(int paramInt, boolean paramBoolean, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +25 -> 28
    //   6: ldc 31
    //   8: iconst_2
    //   9: iconst_2
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: ldc 33
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: iload_2
    //   21: invokestatic 39	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: aastore
    //   25: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   28: new 45	org/json/JSONObject
    //   31: dup
    //   32: invokespecial 46	org/json/JSONObject:<init>	()V
    //   35: astore 4
    //   37: iload_2
    //   38: ifne +44 -> 82
    //   41: ldc 31
    //   43: iconst_1
    //   44: ldc 48
    //   46: invokestatic 52	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload 4
    //   51: ldc 54
    //   53: iconst_m1
    //   54: invokevirtual 58	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   57: pop
    //   58: aload_0
    //   59: getfield 13	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$4:jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   62: aload_0
    //   63: getfield 15	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$4:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   66: iconst_1
    //   67: anewarray 60	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: aload 4
    //   74: invokevirtual 64	org/json/JSONObject:toString	()Ljava/lang/String;
    //   77: aastore
    //   78: invokevirtual 70	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   81: return
    //   82: aload_3
    //   83: ldc 72
    //   85: invokevirtual 78	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   88: astore_3
    //   89: aload_3
    //   90: ifnull +159 -> 249
    //   93: new 80	com/tencent/mobileqq/mp/mobileqq_mp$FollowResponse
    //   96: dup
    //   97: invokespecial 81	com/tencent/mobileqq/mp/mobileqq_mp$FollowResponse:<init>	()V
    //   100: astore 5
    //   102: aload 5
    //   104: aload_3
    //   105: invokevirtual 85	com/tencent/mobileqq/mp/mobileqq_mp$FollowResponse:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   108: pop
    //   109: aload 5
    //   111: getfield 89	com/tencent/mobileqq/mp/mobileqq_mp$FollowResponse:ret_info	Lcom/tencent/mobileqq/mp/mobileqq_mp$RetInfo;
    //   114: invokevirtual 95	com/tencent/mobileqq/mp/mobileqq_mp$RetInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   117: checkcast 91	com/tencent/mobileqq/mp/mobileqq_mp$RetInfo
    //   120: astore_3
    //   121: aload_3
    //   122: getfield 99	com/tencent/mobileqq/mp/mobileqq_mp$RetInfo:ret_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: invokevirtual 104	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   128: istore_1
    //   129: aload_3
    //   130: getfield 108	com/tencent/mobileqq/mp/mobileqq_mp$RetInfo:err_info	Lcom/tencent/mobileqq/pb/PBStringField;
    //   133: invokevirtual 112	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   136: astore_3
    //   137: aload 4
    //   139: ldc 54
    //   141: iconst_0
    //   142: invokevirtual 58	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   145: pop
    //   146: new 45	org/json/JSONObject
    //   149: dup
    //   150: invokespecial 46	org/json/JSONObject:<init>	()V
    //   153: astore 5
    //   155: iload_1
    //   156: ifne +50 -> 206
    //   159: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +11 -> 173
    //   165: ldc 31
    //   167: iconst_2
    //   168: ldc 114
    //   170: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload 5
    //   175: ldc 118
    //   177: iconst_1
    //   178: invokevirtual 121	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   181: pop
    //   182: aload 4
    //   184: ldc 123
    //   186: aload 5
    //   188: invokevirtual 126	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   191: pop
    //   192: goto -134 -> 58
    //   195: astore_3
    //   196: ldc 31
    //   198: iconst_1
    //   199: ldc 128
    //   201: aload_3
    //   202: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   205: return
    //   206: ldc 31
    //   208: iconst_1
    //   209: iconst_4
    //   210: anewarray 4	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: ldc 133
    //   217: aastore
    //   218: dup
    //   219: iconst_1
    //   220: iload_1
    //   221: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   224: aastore
    //   225: dup
    //   226: iconst_2
    //   227: ldc 140
    //   229: aastore
    //   230: dup
    //   231: iconst_3
    //   232: aload_3
    //   233: aastore
    //   234: invokestatic 142	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   237: aload 5
    //   239: ldc 118
    //   241: iconst_0
    //   242: invokevirtual 121	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   245: pop
    //   246: goto -64 -> 182
    //   249: ldc 31
    //   251: iconst_1
    //   252: ldc 144
    //   254: invokestatic 52	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload 4
    //   259: ldc 54
    //   261: iconst_m1
    //   262: invokevirtual 58	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   265: pop
    //   266: goto -208 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	4
    //   0	269	1	paramInt	int
    //   0	269	2	paramBoolean	boolean
    //   0	269	3	paramBundle	android.os.Bundle
    //   35	223	4	localJSONObject	org.json.JSONObject
    //   100	138	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   28	37	195	java/lang/Exception
    //   41	58	195	java/lang/Exception
    //   58	81	195	java/lang/Exception
    //   82	89	195	java/lang/Exception
    //   93	155	195	java/lang/Exception
    //   159	173	195	java/lang/Exception
    //   173	182	195	java/lang/Exception
    //   182	192	195	java/lang/Exception
    //   206	246	195	java/lang/Exception
    //   249	266	195	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.4
 * JD-Core Version:    0.7.0.1
 */