package com.tencent.mobileqq.vashealth;

class HealthBusinessPlugin$4
  implements Runnable
{
  HealthBusinessPlugin$4(HealthBusinessPlugin paramHealthBusinessPlugin, String paramString1, String paramString2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 28	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 29	org/json/JSONObject:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_3
    //   13: aload_2
    //   14: astore_1
    //   15: new 28	org/json/JSONObject
    //   18: dup
    //   19: aload_0
    //   20: getfield 17	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$4:a	Ljava/lang/String;
    //   23: invokespecial 32	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   26: astore 6
    //   28: aload_2
    //   29: astore_1
    //   30: aload 6
    //   32: ldc 34
    //   34: invokevirtual 38	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore 5
    //   39: aload_2
    //   40: astore_1
    //   41: aload 6
    //   43: ldc 40
    //   45: invokevirtual 43	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 6
    //   50: aload_2
    //   51: astore_1
    //   52: new 45	java/io/File
    //   55: dup
    //   56: aload 5
    //   58: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   61: astore 7
    //   63: aload_2
    //   64: astore_1
    //   65: aload 7
    //   67: invokevirtual 50	java/io/File:exists	()Z
    //   70: ifeq +32 -> 102
    //   73: aload_2
    //   74: astore_1
    //   75: aload 7
    //   77: invokevirtual 53	java/io/File:isFile	()Z
    //   80: ifeq +22 -> 102
    //   83: aload_2
    //   84: astore_1
    //   85: aload 4
    //   87: ldc 55
    //   89: aload 7
    //   91: invokevirtual 59	java/io/File:length	()J
    //   94: ldc2_w 60
    //   97: ldiv
    //   98: invokevirtual 65	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   101: pop
    //   102: aload_2
    //   103: astore_1
    //   104: aload 4
    //   106: ldc 67
    //   108: aload 6
    //   110: invokevirtual 70	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   113: pop
    //   114: aload_2
    //   115: astore_1
    //   116: aload 4
    //   118: ldc 72
    //   120: aload 5
    //   122: invokevirtual 70	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   125: pop
    //   126: aload_2
    //   127: astore_1
    //   128: new 74	android/media/MediaMetadataRetriever
    //   131: dup
    //   132: invokespecial 75	android/media/MediaMetadataRetriever:<init>	()V
    //   135: astore_2
    //   136: aload_2
    //   137: aload 5
    //   139: invokevirtual 78	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   142: aload 4
    //   144: ldc 80
    //   146: aload_2
    //   147: bipush 9
    //   149: invokevirtual 84	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   152: invokestatic 90	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   155: ldc2_w 91
    //   158: ldiv
    //   159: invokestatic 98	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   162: invokevirtual 70	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   165: pop
    //   166: aload_0
    //   167: getfield 15	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$4:this$0	Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;
    //   170: aload_0
    //   171: getfield 19	com/tencent/mobileqq/vashealth/HealthBusinessPlugin$4:b	Ljava/lang/String;
    //   174: iconst_1
    //   175: anewarray 94	java/lang/String
    //   178: dup
    //   179: iconst_0
    //   180: aload 4
    //   182: invokevirtual 102	org/json/JSONObject:toString	()Ljava/lang/String;
    //   185: aastore
    //   186: invokestatic 107	com/tencent/mobileqq/vashealth/HealthBusinessPlugin:b	(Lcom/tencent/mobileqq/vashealth/HealthBusinessPlugin;Ljava/lang/String;[Ljava/lang/String;)V
    //   189: aload_2
    //   190: ifnull +7 -> 197
    //   193: aload_2
    //   194: invokevirtual 110	android/media/MediaMetadataRetriever:release	()V
    //   197: return
    //   198: astore_1
    //   199: aload_3
    //   200: astore_2
    //   201: aload_1
    //   202: astore_3
    //   203: aload_2
    //   204: astore_1
    //   205: ldc 112
    //   207: iconst_1
    //   208: aload_3
    //   209: iconst_0
    //   210: anewarray 4	java/lang/Object
    //   213: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   216: aload_2
    //   217: ifnull -20 -> 197
    //   220: aload_2
    //   221: invokevirtual 110	android/media/MediaMetadataRetriever:release	()V
    //   224: return
    //   225: astore_3
    //   226: aload_1
    //   227: astore_2
    //   228: aload_3
    //   229: astore_1
    //   230: aload_2
    //   231: ifnull +7 -> 238
    //   234: aload_2
    //   235: invokevirtual 110	android/media/MediaMetadataRetriever:release	()V
    //   238: aload_1
    //   239: athrow
    //   240: astore_1
    //   241: goto -11 -> 230
    //   244: astore_3
    //   245: goto -42 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	4
    //   14	114	1	localObject1	Object
    //   198	4	1	localException1	java.lang.Exception
    //   204	35	1	localObject2	Object
    //   240	1	1	localObject3	Object
    //   10	225	2	localObject4	Object
    //   12	197	3	localObject5	Object
    //   225	4	3	localObject6	Object
    //   244	1	3	localException2	java.lang.Exception
    //   7	174	4	localJSONObject	org.json.JSONObject
    //   37	101	5	str	String
    //   26	83	6	localObject7	Object
    //   61	29	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   15	28	198	java/lang/Exception
    //   30	39	198	java/lang/Exception
    //   41	50	198	java/lang/Exception
    //   52	63	198	java/lang/Exception
    //   65	73	198	java/lang/Exception
    //   75	83	198	java/lang/Exception
    //   85	102	198	java/lang/Exception
    //   104	114	198	java/lang/Exception
    //   116	126	198	java/lang/Exception
    //   128	136	198	java/lang/Exception
    //   15	28	225	finally
    //   30	39	225	finally
    //   41	50	225	finally
    //   52	63	225	finally
    //   65	73	225	finally
    //   75	83	225	finally
    //   85	102	225	finally
    //   104	114	225	finally
    //   116	126	225	finally
    //   128	136	225	finally
    //   205	216	225	finally
    //   136	189	240	finally
    //   136	189	244	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.4
 * JD-Core Version:    0.7.0.1
 */