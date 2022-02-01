package com.tencent.mobileqq.shortvideo.gesture;

class GestureMgrRecognize$RecognizeRunnable
  implements Runnable
{
  int mToken = 0;
  
  public GestureMgrRecognize$RecognizeRunnable(GestureMgrRecognize paramGestureMgrRecognize, int paramInt)
  {
    this.mToken = paramInt;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 29	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: astore 4
    //   5: bipush 15
    //   7: newarray long
    //   9: astore 5
    //   11: new 31	java/util/HashMap
    //   14: dup
    //   15: invokespecial 32	java/util/HashMap:<init>	()V
    //   18: astore 6
    //   20: iconst_5
    //   21: anewarray 34	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$GestureInfo
    //   24: astore 7
    //   26: iconst_0
    //   27: istore_1
    //   28: iload_1
    //   29: iconst_5
    //   30: if_icmpge +25 -> 55
    //   33: aload 7
    //   35: iload_1
    //   36: new 34	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$GestureInfo
    //   39: dup
    //   40: aload_0
    //   41: getfield 14	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:this$0	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize;
    //   44: invokespecial 37	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$GestureInfo:<init>	(Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize;)V
    //   47: aastore
    //   48: iload_1
    //   49: iconst_1
    //   50: iadd
    //   51: istore_1
    //   52: goto -24 -> 28
    //   55: ldc 39
    //   57: ldc 41
    //   59: iconst_2
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload 4
    //   67: invokevirtual 45	java/lang/Thread:getId	()J
    //   70: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_0
    //   77: getfield 19	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:mToken	I
    //   80: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: aastore
    //   84: invokestatic 62	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   87: invokestatic 68	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: iconst_0
    //   91: istore_2
    //   92: iconst_0
    //   93: istore_1
    //   94: aload_0
    //   95: getfield 14	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:this$0	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize;
    //   98: invokevirtual 74	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:loadSo	()Z
    //   101: ifne +41 -> 142
    //   104: ldc 39
    //   106: ldc 76
    //   108: iconst_2
    //   109: anewarray 4	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload 4
    //   116: invokevirtual 45	java/lang/Thread:getId	()J
    //   119: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: aload_0
    //   126: getfield 19	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:mToken	I
    //   129: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: aastore
    //   133: invokestatic 62	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   136: invokestatic 68	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: goto +250 -> 389
    //   142: aload_0
    //   143: getfield 19	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:mToken	I
    //   146: aload_0
    //   147: getfield 14	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:this$0	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize;
    //   150: getfield 79	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mCurRecognizeRunnableToken	I
    //   153: if_icmpeq +54 -> 207
    //   156: ldc 39
    //   158: ldc 81
    //   160: iconst_3
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: aload 4
    //   168: invokevirtual 45	java/lang/Thread:getId	()J
    //   171: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: aload_0
    //   178: getfield 19	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:mToken	I
    //   181: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: aastore
    //   185: dup
    //   186: iconst_2
    //   187: aload_0
    //   188: getfield 14	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:this$0	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize;
    //   191: getfield 79	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mCurRecognizeRunnableToken	I
    //   194: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: aastore
    //   198: invokestatic 62	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   201: invokestatic 68	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: goto +185 -> 389
    //   207: aload_0
    //   208: getfield 14	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:this$0	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize;
    //   211: getfield 85	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mGestureData	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$GestureData;
    //   214: astore 10
    //   216: aload_0
    //   217: getfield 14	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:this$0	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize;
    //   220: aconst_null
    //   221: putfield 85	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mGestureData	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$GestureData;
    //   224: aload 10
    //   226: ifnull +241 -> 467
    //   229: aload 7
    //   231: iload_2
    //   232: aaload
    //   233: astore 9
    //   235: aload_0
    //   236: getfield 14	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:this$0	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize;
    //   239: getfield 89	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mGestureInfo	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$GestureInfo;
    //   242: aload 9
    //   244: invokevirtual 93	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$GestureInfo:copyTo	(Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$GestureInfo;)V
    //   247: getstatic 97	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mGestureLock	Ljava/lang/Object;
    //   250: astore 8
    //   252: aload 8
    //   254: monitorenter
    //   255: aload_0
    //   256: getfield 19	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:mToken	I
    //   259: aload 10
    //   261: aload 9
    //   263: getfield 101	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$GestureInfo:type	Ljava/lang/String;
    //   266: aload 5
    //   268: iload_1
    //   269: invokestatic 105	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:doProcess	(ILcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$GestureData;Ljava/lang/String;[JI)Lcom/tencent/mobileqq/shortvideo/gesture/GestureKeyInfo;
    //   272: astore 10
    //   274: aload 8
    //   276: monitorexit
    //   277: aload 6
    //   279: aload 10
    //   281: getfield 108	com/tencent/mobileqq/shortvideo/gesture/GestureKeyInfo:type	Ljava/lang/String;
    //   284: invokevirtual 112	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   287: ifeq +263 -> 550
    //   290: aload 6
    //   292: aload 10
    //   294: getfield 108	com/tencent/mobileqq/shortvideo/gesture/GestureKeyInfo:type	Ljava/lang/String;
    //   297: invokevirtual 116	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   300: checkcast 53	java/lang/Integer
    //   303: invokevirtual 120	java/lang/Integer:intValue	()I
    //   306: istore_3
    //   307: goto +3 -> 310
    //   310: aload 6
    //   312: aload 10
    //   314: getfield 108	com/tencent/mobileqq/shortvideo/gesture/GestureKeyInfo:type	Ljava/lang/String;
    //   317: iload_3
    //   318: iconst_1
    //   319: iadd
    //   320: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   323: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   326: pop
    //   327: aload_0
    //   328: getfield 19	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:mToken	I
    //   331: aload_0
    //   332: getfield 14	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:this$0	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize;
    //   335: getfield 79	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mCurRecognizeRunnableToken	I
    //   338: if_icmpeq +70 -> 408
    //   341: ldc 39
    //   343: ldc 126
    //   345: iconst_3
    //   346: anewarray 4	java/lang/Object
    //   349: dup
    //   350: iconst_0
    //   351: aload 4
    //   353: invokevirtual 45	java/lang/Thread:getId	()J
    //   356: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   359: aastore
    //   360: dup
    //   361: iconst_1
    //   362: aload_0
    //   363: getfield 19	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:mToken	I
    //   366: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   369: aastore
    //   370: dup
    //   371: iconst_2
    //   372: aload_0
    //   373: getfield 14	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:this$0	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize;
    //   376: getfield 79	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mCurRecognizeRunnableToken	I
    //   379: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   382: aastore
    //   383: invokestatic 62	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   386: invokestatic 68	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: aload_0
    //   390: getfield 14	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:this$0	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize;
    //   393: aload 6
    //   395: invokestatic 130	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:access$000	(Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize;Ljava/util/HashMap;)V
    //   398: aload 5
    //   400: iload_1
    //   401: i2l
    //   402: invokestatic 134	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:reportCost	([JJ)V
    //   405: goto +104 -> 509
    //   408: aload_0
    //   409: getfield 19	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:mToken	I
    //   412: aload 9
    //   414: aload 10
    //   416: invokestatic 138	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mergeData	(ILcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$GestureInfo;Lcom/tencent/mobileqq/shortvideo/gesture/GestureKeyInfo;)V
    //   419: aload_0
    //   420: getfield 14	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:this$0	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize;
    //   423: aload 9
    //   425: putfield 89	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mGestureInfo	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$GestureInfo;
    //   428: iload_2
    //   429: iconst_1
    //   430: iadd
    //   431: iconst_5
    //   432: irem
    //   433: istore_2
    //   434: iload_1
    //   435: iconst_1
    //   436: iadd
    //   437: istore_1
    //   438: iload_1
    //   439: bipush 15
    //   441: if_icmpne +10 -> 451
    //   444: aload 5
    //   446: iload_1
    //   447: i2l
    //   448: invokestatic 134	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:reportCost	([JJ)V
    //   451: iload_1
    //   452: bipush 15
    //   454: irem
    //   455: istore_1
    //   456: goto +11 -> 467
    //   459: astore 5
    //   461: aload 8
    //   463: monitorexit
    //   464: aload 5
    //   466: athrow
    //   467: aload_0
    //   468: getfield 14	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:this$0	Lcom/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize;
    //   471: getfield 142	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize:mRecognizeRunnableSleepMillis	J
    //   474: invokestatic 146	java/lang/Thread:sleep	(J)V
    //   477: goto -383 -> 94
    //   480: astore 5
    //   482: ldc 39
    //   484: ldc 148
    //   486: iconst_1
    //   487: anewarray 4	java/lang/Object
    //   490: dup
    //   491: iconst_0
    //   492: aload 5
    //   494: invokevirtual 152	java/lang/Object:getClass	()Ljava/lang/Class;
    //   497: invokevirtual 158	java/lang/Class:getName	()Ljava/lang/String;
    //   500: aastore
    //   501: invokestatic 62	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   504: aload 5
    //   506: invokestatic 162	com/tencent/sveffects/SLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   509: ldc 39
    //   511: ldc 164
    //   513: iconst_2
    //   514: anewarray 4	java/lang/Object
    //   517: dup
    //   518: iconst_0
    //   519: aload 4
    //   521: invokevirtual 45	java/lang/Thread:getId	()J
    //   524: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   527: aastore
    //   528: dup
    //   529: iconst_1
    //   530: aload_0
    //   531: getfield 19	com/tencent/mobileqq/shortvideo/gesture/GestureMgrRecognize$RecognizeRunnable:mToken	I
    //   534: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   537: aastore
    //   538: invokestatic 62	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   541: invokestatic 68	com/tencent/sveffects/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   544: return
    //   545: astore 8
    //   547: goto -70 -> 477
    //   550: iconst_0
    //   551: istore_3
    //   552: goto -242 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	555	0	this	RecognizeRunnable
    //   27	429	1	i	int
    //   91	343	2	j	int
    //   306	246	3	k	int
    //   3	517	4	localThread	java.lang.Thread
    //   9	436	5	arrayOfLong	long[]
    //   459	6	5	localObject1	Object
    //   480	25	5	localException1	java.lang.Exception
    //   18	376	6	localHashMap	java.util.HashMap
    //   24	206	7	arrayOfGestureInfo	GestureMgrRecognize.GestureInfo[]
    //   545	1	8	localException2	java.lang.Exception
    //   233	191	9	localGestureInfo	GestureMgrRecognize.GestureInfo
    //   214	201	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   255	277	459	finally
    //   461	464	459	finally
    //   5	26	480	java/lang/Exception
    //   33	48	480	java/lang/Exception
    //   55	90	480	java/lang/Exception
    //   94	139	480	java/lang/Exception
    //   142	204	480	java/lang/Exception
    //   207	224	480	java/lang/Exception
    //   235	255	480	java/lang/Exception
    //   277	307	480	java/lang/Exception
    //   310	389	480	java/lang/Exception
    //   389	405	480	java/lang/Exception
    //   408	428	480	java/lang/Exception
    //   444	451	480	java/lang/Exception
    //   464	467	480	java/lang/Exception
    //   467	477	545	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize.RecognizeRunnable
 * JD-Core Version:    0.7.0.1
 */