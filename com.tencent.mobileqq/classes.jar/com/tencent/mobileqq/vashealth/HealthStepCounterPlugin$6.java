package com.tencent.mobileqq.vashealth;

import mqq.observer.BusinessObserver;

class HealthStepCounterPlugin$6
  implements BusinessObserver
{
  HealthStepCounterPlugin$6(HealthStepCounterPlugin paramHealthStepCounterPlugin) {}
  
  /* Error */
  public void onReceive(int paramInt, boolean paramBoolean, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifeq +551 -> 552
    //   4: aload_3
    //   5: ldc 22
    //   7: invokevirtual 28	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 7
    //   12: aload_3
    //   13: ldc 30
    //   15: invokevirtual 28	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 8
    //   20: new 32	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   27: astore 9
    //   29: aload 9
    //   31: ldc 35
    //   33: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 9
    //   39: aload 8
    //   41: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: ldc 41
    //   47: iconst_1
    //   48: aload 9
    //   50: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_3
    //   57: ldc 53
    //   59: invokevirtual 28	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: ifnull +420 -> 482
    //   65: new 55	org/json/JSONObject
    //   68: dup
    //   69: invokespecial 56	org/json/JSONObject:<init>	()V
    //   72: astore 9
    //   74: aload 9
    //   76: ldc 58
    //   78: iconst_0
    //   79: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   82: pop
    //   83: aload 9
    //   85: ldc 64
    //   87: iconst_0
    //   88: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   91: pop
    //   92: invokestatic 69	com/tencent/mobileqq/vashealth/config/StepConfigProcessor:a	()Lcom/tencent/mobileqq/vashealth/config/StepConfigBean;
    //   95: invokevirtual 74	com/tencent/mobileqq/vashealth/config/StepConfigBean:a	()I
    //   98: iconst_2
    //   99: if_icmpne +154 -> 253
    //   102: aload_3
    //   103: ldc 76
    //   105: invokevirtual 80	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   108: checkcast 82	java/util/Map
    //   111: astore 10
    //   113: invokestatic 87	com/tencent/mobileqq/vashealth/SSOHttpUtils:a	()J
    //   116: ldc2_w 88
    //   119: ldiv
    //   120: lstore 5
    //   122: aload 10
    //   124: ifnull +103 -> 227
    //   127: aload 10
    //   129: lload 5
    //   131: invokestatic 95	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   134: invokeinterface 99 2 0
    //   139: ifeq +88 -> 227
    //   142: aload 10
    //   144: lload 5
    //   146: invokestatic 95	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   149: invokeinterface 103 2 0
    //   154: checkcast 105	java/lang/Integer
    //   157: invokevirtual 108	java/lang/Integer:intValue	()I
    //   160: istore_1
    //   161: aload 9
    //   163: ldc 64
    //   165: iload_1
    //   166: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   169: pop
    //   170: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +54 -> 227
    //   176: new 32	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   183: astore 10
    //   185: aload 10
    //   187: ldc 114
    //   189: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 10
    //   195: lload 5
    //   197: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 10
    //   203: ldc 119
    //   205: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 10
    //   211: iload_1
    //   212: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: ldc 41
    //   218: iconst_2
    //   219: aload 10
    //   221: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: aload_0
    //   228: getfield 12	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$6:a	Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;
    //   231: aload_3
    //   232: ldc 53
    //   234: invokevirtual 28	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   237: iconst_1
    //   238: anewarray 127	java/lang/String
    //   241: dup
    //   242: iconst_0
    //   243: aload 9
    //   245: invokevirtual 128	org/json/JSONObject:toString	()Ljava/lang/String;
    //   248: aastore
    //   249: invokevirtual 134	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   252: return
    //   253: aload 8
    //   255: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   258: ifne +143 -> 401
    //   261: invokestatic 87	com/tencent/mobileqq/vashealth/SSOHttpUtils:a	()J
    //   264: invokestatic 143	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   267: astore 10
    //   269: new 55	org/json/JSONObject
    //   272: dup
    //   273: aload 8
    //   275: invokespecial 146	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   278: astore 11
    //   280: new 32	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   287: astore 12
    //   289: aload 12
    //   291: aload 10
    //   293: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 12
    //   299: ldc 148
    //   301: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 11
    //   307: aload 12
    //   309: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokevirtual 152	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   315: istore_1
    //   316: new 32	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   323: astore 12
    //   325: aload 12
    //   327: aload 10
    //   329: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload 12
    //   335: ldc 154
    //   337: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 11
    //   343: aload 12
    //   345: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokevirtual 152	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   351: istore 4
    //   353: new 32	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   360: astore 12
    //   362: aload 12
    //   364: aload 10
    //   366: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload 12
    //   372: ldc 156
    //   374: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 9
    //   380: ldc 64
    //   382: iload_1
    //   383: iload 4
    //   385: isub
    //   386: aload 11
    //   388: aload 12
    //   390: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokevirtual 152	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   396: iadd
    //   397: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   400: pop
    //   401: aload_0
    //   402: getfield 12	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$6:a	Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;
    //   405: aload_3
    //   406: ldc 53
    //   408: invokevirtual 28	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   411: iconst_1
    //   412: anewarray 127	java/lang/String
    //   415: dup
    //   416: iconst_0
    //   417: aload 9
    //   419: invokevirtual 128	org/json/JSONObject:toString	()Ljava/lang/String;
    //   422: aastore
    //   423: invokevirtual 134	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   426: return
    //   427: astore 7
    //   429: aload_0
    //   430: getfield 12	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$6:a	Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;
    //   433: aload_3
    //   434: ldc 53
    //   436: invokevirtual 28	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   439: iconst_1
    //   440: anewarray 127	java/lang/String
    //   443: dup
    //   444: iconst_0
    //   445: aload 9
    //   447: invokevirtual 128	org/json/JSONObject:toString	()Ljava/lang/String;
    //   450: aastore
    //   451: invokevirtual 134	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   454: aload 7
    //   456: athrow
    //   457: aload_0
    //   458: getfield 12	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$6:a	Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;
    //   461: aload_3
    //   462: ldc 53
    //   464: invokevirtual 28	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   467: iconst_1
    //   468: anewarray 127	java/lang/String
    //   471: dup
    //   472: iconst_0
    //   473: aload 9
    //   475: invokevirtual 128	org/json/JSONObject:toString	()Ljava/lang/String;
    //   478: aastore
    //   479: invokevirtual 134	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   482: aload 7
    //   484: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   487: ifeq +11 -> 498
    //   490: aload 8
    //   492: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   495: ifne +57 -> 552
    //   498: aload_0
    //   499: getfield 12	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$6:a	Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;
    //   502: getfield 159	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   505: invokevirtual 163	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   508: ifeq +12 -> 520
    //   511: aload_0
    //   512: getfield 12	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$6:a	Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;
    //   515: aload 8
    //   517: putfield 167	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:f	Ljava/lang/String;
    //   520: invokestatic 172	java/lang/System:currentTimeMillis	()J
    //   523: getstatic 175	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_Long	J
    //   526: lsub
    //   527: ldc2_w 176
    //   530: lcmp
    //   531: ifge +4 -> 535
    //   534: return
    //   535: invokestatic 172	java/lang/System:currentTimeMillis	()J
    //   538: putstatic 175	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:jdField_a_of_type_Long	J
    //   541: aload_0
    //   542: getfield 12	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$6:a	Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;
    //   545: aload 7
    //   547: aload 8
    //   549: invokestatic 180	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin:a	(Lcom/tencent/mobileqq/vashealth/HealthStepCounterPlugin;Ljava/lang/String;Ljava/lang/String;)V
    //   552: return
    //   553: astore 10
    //   555: goto -98 -> 457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	558	0	this	6
    //   0	558	1	paramInt	int
    //   0	558	2	paramBoolean	boolean
    //   0	558	3	paramBundle	android.os.Bundle
    //   351	35	4	i	int
    //   120	76	5	l	long
    //   10	1	7	str1	java.lang.String
    //   427	119	7	localCharSequence	java.lang.CharSequence
    //   18	530	8	str2	java.lang.String
    //   27	447	9	localObject1	Object
    //   111	254	10	localObject2	Object
    //   553	1	10	localJSONException	org.json.JSONException
    //   278	109	11	localJSONObject	org.json.JSONObject
    //   287	102	12	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   74	122	427	finally
    //   127	227	427	finally
    //   253	401	427	finally
    //   74	122	553	org/json/JSONException
    //   127	227	553	org/json/JSONException
    //   253	401	553	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.6
 * JD-Core Version:    0.7.0.1
 */