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
    //   1: getfield 16	com/tencent/mobileqq/portal/PortalManager$4$1:c	Lcom/tencent/mobileqq/portal/PortalManager$4;
    //   4: getfield 32	com/tencent/mobileqq/portal/PortalManager$4:a	Lcom/tencent/mobileqq/portal/PortalManager;
    //   7: getfield 38	com/tencent/mobileqq/portal/PortalManager:q	Ljava/util/concurrent/ConcurrentHashMap;
    //   10: aload_0
    //   11: getfield 18	com/tencent/mobileqq/portal/PortalManager$4$1:a	Ljava/lang/String;
    //   14: invokevirtual 44	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast 46	com/tencent/mobileqq/portal/PortalManager$IconReqDetails
    //   20: astore_3
    //   21: aload_0
    //   22: getfield 16	com/tencent/mobileqq/portal/PortalManager$4$1:c	Lcom/tencent/mobileqq/portal/PortalManager$4;
    //   25: getfield 32	com/tencent/mobileqq/portal/PortalManager$4:a	Lcom/tencent/mobileqq/portal/PortalManager;
    //   28: getfield 38	com/tencent/mobileqq/portal/PortalManager:q	Ljava/util/concurrent/ConcurrentHashMap;
    //   31: aload_0
    //   32: getfield 18	com/tencent/mobileqq/portal/PortalManager$4$1:a	Ljava/lang/String;
    //   35: invokevirtual 49	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: pop
    //   39: aload_0
    //   40: getfield 20	com/tencent/mobileqq/portal/PortalManager$4$1:b	Z
    //   43: ifeq +303 -> 346
    //   46: iconst_1
    //   47: istore_1
    //   48: aload_0
    //   49: getfield 16	com/tencent/mobileqq/portal/PortalManager$4$1:c	Lcom/tencent/mobileqq/portal/PortalManager$4;
    //   52: getfield 32	com/tencent/mobileqq/portal/PortalManager$4:a	Lcom/tencent/mobileqq/portal/PortalManager;
    //   55: invokestatic 52	com/tencent/mobileqq/portal/PortalManager:b	(Lcom/tencent/mobileqq/portal/PortalManager;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   58: aload_0
    //   59: getfield 18	com/tencent/mobileqq/portal/PortalManager$4$1:a	Ljava/lang/String;
    //   62: iconst_0
    //   63: invokevirtual 58	com/tencent/mobileqq/app/QQAppInterface:getFaceBitmap	(Ljava/lang/String;Z)Landroid/graphics/Bitmap;
    //   66: astore_2
    //   67: aload_2
    //   68: ifnull +278 -> 346
    //   71: aload_2
    //   72: invokestatic 63	com/tencent/mobileqq/portal/PortalUtils:a	(Landroid/graphics/Bitmap;)Ljava/lang/String;
    //   75: astore_2
    //   76: new 65	org/json/JSONObject
    //   79: dup
    //   80: invokespecial 66	org/json/JSONObject:<init>	()V
    //   83: astore 4
    //   85: aload 4
    //   87: ldc 68
    //   89: iconst_0
    //   90: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   93: pop
    //   94: aload 4
    //   96: ldc 74
    //   98: aload_3
    //   99: getfield 76	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:c	Ljava/lang/String;
    //   102: invokevirtual 79	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   105: pop
    //   106: aload 4
    //   108: ldc 81
    //   110: aload_2
    //   111: invokevirtual 79	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   114: pop
    //   115: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +37 -> 155
    //   121: new 89	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   128: astore_2
    //   129: aload_2
    //   130: ldc 92
    //   132: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_2
    //   137: aload_3
    //   138: getfield 76	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:c	Ljava/lang/String;
    //   141: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: ldc 98
    //   147: iconst_2
    //   148: aload_2
    //   149: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_0
    //   156: getfield 16	com/tencent/mobileqq/portal/PortalManager$4$1:c	Lcom/tencent/mobileqq/portal/PortalManager$4;
    //   159: getfield 32	com/tencent/mobileqq/portal/PortalManager$4:a	Lcom/tencent/mobileqq/portal/PortalManager;
    //   162: aload_3
    //   163: getfield 109	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:b	I
    //   166: aload 4
    //   168: invokevirtual 110	org/json/JSONObject:toString	()Ljava/lang/String;
    //   171: aload_3
    //   172: getfield 112	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:a	I
    //   175: invokestatic 115	com/tencent/mobileqq/portal/PortalManager:a	(Lcom/tencent/mobileqq/portal/PortalManager;ILjava/lang/String;I)V
    //   178: return
    //   179: astore_2
    //   180: goto +92 -> 272
    //   183: astore_2
    //   184: aload_2
    //   185: invokevirtual 118	org/json/JSONException:printStackTrace	()V
    //   188: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +35 -> 226
    //   194: new 89	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   201: astore_2
    //   202: aload_2
    //   203: ldc 120
    //   205: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_2
    //   210: aload 4
    //   212: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: ldc 98
    //   218: iconst_2
    //   219: aload_2
    //   220: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +117 -> 346
    //   232: new 89	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   239: astore_2
    //   240: aload_2
    //   241: ldc 92
    //   243: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_2
    //   248: aload_3
    //   249: getfield 76	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:c	Ljava/lang/String;
    //   252: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: ldc 98
    //   258: iconst_2
    //   259: aload_2
    //   260: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: goto +80 -> 346
    //   269: astore_2
    //   270: iconst_0
    //   271: istore_1
    //   272: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +41 -> 316
    //   278: new 89	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   285: astore 5
    //   287: aload 5
    //   289: ldc 92
    //   291: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 5
    //   297: aload_3
    //   298: getfield 76	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:c	Ljava/lang/String;
    //   301: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: ldc 98
    //   307: iconst_2
    //   308: aload 5
    //   310: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: iload_1
    //   317: ifeq +27 -> 344
    //   320: aload_0
    //   321: getfield 16	com/tencent/mobileqq/portal/PortalManager$4$1:c	Lcom/tencent/mobileqq/portal/PortalManager$4;
    //   324: getfield 32	com/tencent/mobileqq/portal/PortalManager$4:a	Lcom/tencent/mobileqq/portal/PortalManager;
    //   327: aload_3
    //   328: getfield 109	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:b	I
    //   331: aload 4
    //   333: invokevirtual 110	org/json/JSONObject:toString	()Ljava/lang/String;
    //   336: aload_3
    //   337: getfield 112	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:a	I
    //   340: invokestatic 115	com/tencent/mobileqq/portal/PortalManager:a	(Lcom/tencent/mobileqq/portal/PortalManager;ILjava/lang/String;I)V
    //   343: return
    //   344: aload_2
    //   345: athrow
    //   346: aload_0
    //   347: getfield 16	com/tencent/mobileqq/portal/PortalManager$4$1:c	Lcom/tencent/mobileqq/portal/PortalManager$4;
    //   350: getfield 32	com/tencent/mobileqq/portal/PortalManager$4:a	Lcom/tencent/mobileqq/portal/PortalManager;
    //   353: aload_3
    //   354: getfield 109	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:b	I
    //   357: aload_3
    //   358: getfield 112	com/tencent/mobileqq/portal/PortalManager$IconReqDetails:a	I
    //   361: aconst_null
    //   362: iconst_m1
    //   363: ldc 125
    //   365: invokestatic 128	com/tencent/mobileqq/portal/PortalManager:a	(Lcom/tencent/mobileqq/portal/PortalManager;IILjava/lang/String;ILjava/lang/String;)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.4.1
 * JD-Core Version:    0.7.0.1
 */