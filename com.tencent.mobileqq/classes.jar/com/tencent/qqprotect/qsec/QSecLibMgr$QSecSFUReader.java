package com.tencent.qqprotect.qsec;

class QSecLibMgr$QSecSFUReader
{
  private QSecLibMgr.SFUVisitor a;
  
  public QSecLibMgr$QSecSFUReader(QSecLibMgr.SFUVisitor paramSFUVisitor)
  {
    this.a = paramSFUVisitor;
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: getstatic 23	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   3: aconst_null
    //   4: invokevirtual 27	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   7: checkcast 29	com/tencent/mobileqq/app/QQAppInterface
    //   10: astore 6
    //   12: aload 6
    //   14: ifnonnull +20 -> 34
    //   17: aload_0
    //   18: getfield 13	com/tencent/qqprotect/qsec/QSecLibMgr$QSecSFUReader:a	Lcom/tencent/qqprotect/qsec/QSecLibMgr$SFUVisitor;
    //   21: astore 6
    //   23: aload 6
    //   25: ifnull +8 -> 33
    //   28: aload 6
    //   30: invokevirtual 33	com/tencent/qqprotect/qsec/QSecLibMgr$SFUVisitor:a	()V
    //   33: return
    //   34: new 35	com/tencent/qqprotect/singleupdate/QPUpdateConfig
    //   37: dup
    //   38: aload 6
    //   40: invokespecial 38	com/tencent/qqprotect/singleupdate/QPUpdateConfig:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   43: lconst_1
    //   44: invokevirtual 41	com/tencent/qqprotect/singleupdate/QPUpdateConfig:a	(J)Ljava/util/List;
    //   47: astore 6
    //   49: aload 6
    //   51: ifnull +252 -> 303
    //   54: aload 6
    //   56: invokeinterface 47 1 0
    //   61: astore 7
    //   63: aload 7
    //   65: invokeinterface 53 1 0
    //   70: ifeq +233 -> 303
    //   73: aload 7
    //   75: invokeinterface 57 1 0
    //   80: checkcast 59	com/tencent/qqprotect/singleupdate/SFU$UpdateSection
    //   83: astore 6
    //   85: aload 6
    //   87: getfield 63	com/tencent/qqprotect/singleupdate/SFU$UpdateSection:b	J
    //   90: iload_1
    //   91: i2l
    //   92: lcmp
    //   93: ifne -30 -> 63
    //   96: aload 6
    //   98: getfield 67	com/tencent/qqprotect/singleupdate/SFU$UpdateSection:p	Ljava/util/List;
    //   101: ifnonnull +6 -> 107
    //   104: goto -41 -> 63
    //   107: aload 6
    //   109: getfield 67	com/tencent/qqprotect/singleupdate/SFU$UpdateSection:p	Ljava/util/List;
    //   112: invokeinterface 47 1 0
    //   117: astore 8
    //   119: aload 8
    //   121: invokeinterface 53 1 0
    //   126: ifeq -63 -> 63
    //   129: aload 8
    //   131: invokeinterface 57 1 0
    //   136: checkcast 69	com/tencent/qqprotect/singleupdate/SFU$FileInfo
    //   139: astore 9
    //   141: aload 9
    //   143: getfield 73	com/tencent/qqprotect/singleupdate/SFU$FileInfo:k	Ljava/lang/String;
    //   146: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifeq +6 -> 155
    //   152: goto -33 -> 119
    //   155: aload 9
    //   157: getfield 82	com/tencent/qqprotect/singleupdate/SFU$FileInfo:f	Ljava/lang/String;
    //   160: astore 6
    //   162: aload 9
    //   164: getfield 85	com/tencent/qqprotect/singleupdate/SFU$FileInfo:g	Ljava/lang/String;
    //   167: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifne +10 -> 180
    //   173: aload 9
    //   175: getfield 85	com/tencent/qqprotect/singleupdate/SFU$FileInfo:g	Ljava/lang/String;
    //   178: astore 6
    //   180: aload 6
    //   182: ifnull -63 -> 119
    //   185: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +31 -> 219
    //   191: ldc 92
    //   193: iconst_2
    //   194: ldc 94
    //   196: iconst_2
    //   197: anewarray 4	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: aload 9
    //   204: getfield 73	com/tencent/qqprotect/singleupdate/SFU$FileInfo:k	Ljava/lang/String;
    //   207: aastore
    //   208: dup
    //   209: iconst_1
    //   210: aload 6
    //   212: aastore
    //   213: invokestatic 100	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   216: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: new 106	org/json/JSONObject
    //   222: dup
    //   223: aload 9
    //   225: getfield 73	com/tencent/qqprotect/singleupdate/SFU$FileInfo:k	Ljava/lang/String;
    //   228: invokespecial 109	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   231: astore 9
    //   233: aload 9
    //   235: ldc 111
    //   237: invokevirtual 115	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   240: istore_2
    //   241: aload 9
    //   243: ldc 117
    //   245: invokevirtual 115	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   248: istore_3
    //   249: aload 9
    //   251: ldc 119
    //   253: invokevirtual 115	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   256: istore 4
    //   258: aload 9
    //   260: ldc 121
    //   262: invokevirtual 115	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   265: istore 5
    //   267: aload 9
    //   269: ldc 123
    //   271: invokevirtual 127	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   274: astore 9
    //   276: aload_0
    //   277: getfield 13	com/tencent/qqprotect/qsec/QSecLibMgr$QSecSFUReader:a	Lcom/tencent/qqprotect/qsec/QSecLibMgr$SFUVisitor;
    //   280: ifnull -161 -> 119
    //   283: aload_0
    //   284: getfield 13	com/tencent/qqprotect/qsec/QSecLibMgr$QSecSFUReader:a	Lcom/tencent/qqprotect/qsec/QSecLibMgr$SFUVisitor;
    //   287: aload 6
    //   289: aload 9
    //   291: iload_2
    //   292: iload_3
    //   293: iload 4
    //   295: iload 5
    //   297: invokevirtual 130	com/tencent/qqprotect/qsec/QSecLibMgr$SFUVisitor:a	(Ljava/lang/String;Ljava/lang/String;IIII)V
    //   300: goto -181 -> 119
    //   303: aload_0
    //   304: getfield 13	com/tencent/qqprotect/qsec/QSecLibMgr$QSecSFUReader:a	Lcom/tencent/qqprotect/qsec/QSecLibMgr$SFUVisitor;
    //   307: astore 6
    //   309: aload 6
    //   311: ifnull +34 -> 345
    //   314: goto +26 -> 340
    //   317: astore 6
    //   319: goto +27 -> 346
    //   322: astore 6
    //   324: aload 6
    //   326: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   329: aload_0
    //   330: getfield 13	com/tencent/qqprotect/qsec/QSecLibMgr$QSecSFUReader:a	Lcom/tencent/qqprotect/qsec/QSecLibMgr$SFUVisitor;
    //   333: astore 6
    //   335: aload 6
    //   337: ifnull +8 -> 345
    //   340: aload 6
    //   342: invokevirtual 33	com/tencent/qqprotect/qsec/QSecLibMgr$SFUVisitor:a	()V
    //   345: return
    //   346: aload_0
    //   347: getfield 13	com/tencent/qqprotect/qsec/QSecLibMgr$QSecSFUReader:a	Lcom/tencent/qqprotect/qsec/QSecLibMgr$SFUVisitor;
    //   350: astore 7
    //   352: aload 7
    //   354: ifnull +8 -> 362
    //   357: aload 7
    //   359: invokevirtual 33	com/tencent/qqprotect/qsec/QSecLibMgr$SFUVisitor:a	()V
    //   362: goto +6 -> 368
    //   365: aload 6
    //   367: athrow
    //   368: goto -3 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	QSecSFUReader
    //   0	371	1	paramInt	int
    //   240	52	2	i	int
    //   248	45	3	j	int
    //   256	38	4	k	int
    //   265	31	5	m	int
    //   10	300	6	localObject1	Object
    //   317	1	6	localObject2	Object
    //   322	3	6	localException	java.lang.Exception
    //   333	33	6	localSFUVisitor	QSecLibMgr.SFUVisitor
    //   61	297	7	localObject3	Object
    //   117	13	8	localIterator	java.util.Iterator
    //   139	151	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	12	317	finally
    //   34	49	317	finally
    //   54	63	317	finally
    //   63	104	317	finally
    //   107	119	317	finally
    //   119	152	317	finally
    //   155	162	317	finally
    //   162	180	317	finally
    //   185	219	317	finally
    //   219	300	317	finally
    //   324	329	317	finally
    //   0	12	322	java/lang/Exception
    //   34	49	322	java/lang/Exception
    //   54	63	322	java/lang/Exception
    //   63	104	322	java/lang/Exception
    //   107	119	322	java/lang/Exception
    //   119	152	322	java/lang/Exception
    //   155	162	322	java/lang/Exception
    //   162	180	322	java/lang/Exception
    //   185	219	322	java/lang/Exception
    //   219	300	322	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecLibMgr.QSecSFUReader
 * JD-Core Version:    0.7.0.1
 */