package com.tencent.mobileqq.portal;

class PortalManager$4$1
  implements Runnable
{
  PortalManager$4$1(PortalManager.4 param4, String paramString, boolean paramBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mobileqq/portal/PortalManager$4$1:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$4	Lcom/tencent/mobileqq/portal/PortalManager$4;
    //   4: getfield 30	com/tencent/mobileqq/portal/PortalManager$4:a	Lcom/tencent/mobileqq/portal/PortalManager;
    //   7: getfield 35	com/tencent/mobileqq/portal/PortalManager:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   10: aload_0
    //   11: getfield 16	com/tencent/mobileqq/portal/PortalManager$4$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14: invokevirtual 41	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast 43	com/tencent/mobileqq/portal/PortalManager$IconReqDetails
    //   20: astore_3
    //   21: aload_0
    //   22: getfield 14	com/tencent/mobileqq/portal/PortalManager$4$1:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$4	Lcom/tencent/mobileqq/portal/PortalManager$4;
    //   25: getfield 30	com/tencent/mobileqq/portal/PortalManager$4:a	Lcom/tencent/mobileqq/portal/PortalManager;
    //   28: getfield 35	com/tencent/mobileqq/portal/PortalManager:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   31: aload_0
    //   32: getfield 16	com/tencent/mobileqq/portal/PortalManager$4$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   35: invokevirtual 46	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: pop
    //   39: aload_0
    //   40: getfield 18	com/tencent/mobileqq/portal/PortalManager$4$1:jdField_a_of_type_Boolean	Z
    //   43: ifeq +303 -> 346
    //   46: iconst_1
    //   47: istore_1
    //   48: aload_0
    //   49: getfield 14	com/tencent/mobileqq/portal/PortalManager$4$1:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$4	Lcom/tencent/mobileqq/portal/PortalManager$4;
    //   52: getfield 30	com/tencent/mobileqq/portal/PortalManager$4:a	Lcom/tencent/mobileqq/portal/PortalManager;
    //   55: invokestatic 49	com/tencent/mobileqq/portal/PortalManager:a	(Lcom/tencent/mobileqq/portal/PortalManager;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   58: aload_0
    //   59: getfield 16	com/tencent/mobileqq/portal/PortalManager$4$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   62: iconst_0
    //   63: invokevirtual 55	com/tencent/mobileqq/app/QQAppInterface:getFaceBitmap	(Ljava/lang/String;Z)Landroid/graphics/Bitmap;
    //   66: astore_2
    //   67: aload_2
    //   68: ifnull +278 -> 346
    //   71: aload_2
    //   72: invokestatic 60	com/tencent/mobileqq/portal/PortalUtils:a	(Landroid/graphics/Bitmap;)Ljava/lang/String;
    //   75: astore_2
    //   76: new 62	org/json/JSONObject
    //   79: dup
    //   80: invokespecial 63	org/json/JSONObject:<init>	()V
    //   83: astore 4
    //   85: aload 4
    //   87: ldc 65
    //   89: iconst_0
    //   90: invokevirtual 69	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   93: pop
    //   94: aload 4
    //   96: ldc 71
    //   98: aload_3
    //   99: getfield 72	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   102: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   105: pop
    //   106: aload 4
    //   108: ldc 77
    //   110: aload_2
    //   111: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   114: pop
    //   115: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +37 -> 155
    //   121: new 85	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   128: astore_2
    //   129: aload_2
    //   130: ldc 88
    //   132: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_2
    //   137: aload_3
    //   138: getfield 72	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   141: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: ldc 94
    //   147: iconst_2
    //   148: aload_2
    //   149: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_0
    //   156: getfield 14	com/tencent/mobileqq/portal/PortalManager$4$1:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$4	Lcom/tencent/mobileqq/portal/PortalManager$4;
    //   159: getfield 30	com/tencent/mobileqq/portal/PortalManager$4:a	Lcom/tencent/mobileqq/portal/PortalManager;
    //   162: aload_3
    //   163: getfield 106	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:b	I
    //   166: aload 4
    //   168: invokevirtual 107	org/json/JSONObject:toString	()Ljava/lang/String;
    //   171: aload_3
    //   172: getfield 109	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:jdField_a_of_type_Int	I
    //   175: invokestatic 112	com/tencent/mobileqq/portal/PortalManager:a	(Lcom/tencent/mobileqq/portal/PortalManager;ILjava/lang/String;I)V
    //   178: return
    //   179: astore_2
    //   180: goto +92 -> 272
    //   183: astore_2
    //   184: aload_2
    //   185: invokevirtual 115	org/json/JSONException:printStackTrace	()V
    //   188: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +35 -> 226
    //   194: new 85	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   201: astore_2
    //   202: aload_2
    //   203: ldc 117
    //   205: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_2
    //   210: aload 4
    //   212: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: ldc 94
    //   218: iconst_2
    //   219: aload_2
    //   220: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +117 -> 346
    //   232: new 85	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   239: astore_2
    //   240: aload_2
    //   241: ldc 88
    //   243: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_2
    //   248: aload_3
    //   249: getfield 72	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   252: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: ldc 94
    //   258: iconst_2
    //   259: aload_2
    //   260: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: goto +80 -> 346
    //   269: astore_2
    //   270: iconst_0
    //   271: istore_1
    //   272: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +41 -> 316
    //   278: new 85	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   285: astore 5
    //   287: aload 5
    //   289: ldc 88
    //   291: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 5
    //   297: aload_3
    //   298: getfield 72	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   301: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: ldc 94
    //   307: iconst_2
    //   308: aload 5
    //   310: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: iload_1
    //   317: ifeq +27 -> 344
    //   320: aload_0
    //   321: getfield 14	com/tencent/mobileqq/portal/PortalManager$4$1:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$4	Lcom/tencent/mobileqq/portal/PortalManager$4;
    //   324: getfield 30	com/tencent/mobileqq/portal/PortalManager$4:a	Lcom/tencent/mobileqq/portal/PortalManager;
    //   327: aload_3
    //   328: getfield 106	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:b	I
    //   331: aload 4
    //   333: invokevirtual 107	org/json/JSONObject:toString	()Ljava/lang/String;
    //   336: aload_3
    //   337: getfield 109	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:jdField_a_of_type_Int	I
    //   340: invokestatic 112	com/tencent/mobileqq/portal/PortalManager:a	(Lcom/tencent/mobileqq/portal/PortalManager;ILjava/lang/String;I)V
    //   343: return
    //   344: aload_2
    //   345: athrow
    //   346: aload_0
    //   347: getfield 14	com/tencent/mobileqq/portal/PortalManager$4$1:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$4	Lcom/tencent/mobileqq/portal/PortalManager$4;
    //   350: getfield 30	com/tencent/mobileqq/portal/PortalManager$4:a	Lcom/tencent/mobileqq/portal/PortalManager;
    //   353: aload_3
    //   354: getfield 106	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:b	I
    //   357: aload_3
    //   358: getfield 109	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:jdField_a_of_type_Int	I
    //   361: aconst_null
    //   362: iconst_m1
    //   363: ldc 122
    //   365: invokestatic 125	com/tencent/mobileqq/portal/PortalManager:a	(Lcom/tencent/mobileqq/portal/PortalManager;IILjava/lang/String;ILjava/lang/String;)V
    //   368: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	1
    //   47	270	1	i	int
    //   66	83	2	localObject1	Object
    //   179	1	2	localObject2	Object
    //   183	2	2	localJSONException	org.json.JSONException
    //   201	59	2	localStringBuilder1	java.lang.StringBuilder
    //   269	76	2	localObject3	Object
    //   20	338	3	localIconReqDetails	PortalManager.IconReqDetails
    //   83	249	4	localJSONObject	org.json.JSONObject
    //   285	24	5	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   85	115	179	finally
    //   184	188	179	finally
    //   85	115	183	org/json/JSONException
    //   188	226	269	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.4.1
 * JD-Core Version:    0.7.0.1
 */