package com.tencent.mobileqq.richmedia.mediacodec;

import baef;
import com.tencent.qphone.base.util.QLog;

class AudioDecoder$AudioPlayRunnable
  implements Runnable
{
  private float jdField_a_of_type_Float;
  private volatile int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private volatile boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d;
  
  public AudioDecoder$AudioPlayRunnable(AudioDecoder paramAudioDecoder, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_4
    //   1: istore_2
    //   2: ldc 38
    //   4: iconst_4
    //   5: ldc 40
    //   7: invokestatic 45	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10: aconst_null
    //   11: astore 9
    //   13: aload_0
    //   14: getfield 21	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   17: invokestatic 50	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lbaef;
    //   20: getfield 55	baef:jdField_a_of_type_Bbwq	Lbbwq;
    //   23: getfield 60	bbwq:e	I
    //   26: iconst_1
    //   27: if_icmpne +546 -> 573
    //   30: aload_0
    //   31: getfield 21	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   34: invokestatic 50	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lbaef;
    //   37: getfield 55	baef:jdField_a_of_type_Bbwq	Lbbwq;
    //   40: getfield 62	bbwq:jdField_b_of_type_Int	I
    //   43: bipush 16
    //   45: if_icmpne +534 -> 579
    //   48: iconst_2
    //   49: istore_3
    //   50: aload_0
    //   51: getfield 21	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   54: invokestatic 50	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lbaef;
    //   57: getfield 55	baef:jdField_a_of_type_Bbwq	Lbbwq;
    //   60: getfield 64	bbwq:d	I
    //   63: iload_2
    //   64: iload_3
    //   65: invokestatic 70	android/media/AudioTrack:getMinBufferSize	(III)I
    //   68: istore 5
    //   70: iload 5
    //   72: iconst_2
    //   73: imul
    //   74: newarray byte
    //   76: astore 10
    //   78: new 66	android/media/AudioTrack
    //   81: dup
    //   82: iconst_3
    //   83: aload_0
    //   84: getfield 21	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   87: invokestatic 50	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lbaef;
    //   90: getfield 55	baef:jdField_a_of_type_Bbwq	Lbbwq;
    //   93: getfield 64	bbwq:d	I
    //   96: iload_2
    //   97: iload_3
    //   98: iload 5
    //   100: iconst_1
    //   101: invokespecial 73	android/media/AudioTrack:<init>	(IIIIII)V
    //   104: astore 8
    //   106: aload 8
    //   108: invokevirtual 76	android/media/AudioTrack:play	()V
    //   111: iconst_0
    //   112: istore_3
    //   113: aload_0
    //   114: getfield 78	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   117: aload_1
    //   118: arraylength
    //   119: if_icmpge +396 -> 515
    //   122: invokestatic 84	java/lang/Thread:interrupted	()Z
    //   125: ifne +390 -> 515
    //   128: iload_3
    //   129: ifne +386 -> 515
    //   132: aload_0
    //   133: getfield 86	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Float	F
    //   136: fconst_0
    //   137: fcmpl
    //   138: ifeq +87 -> 225
    //   141: aload_0
    //   142: getfield 86	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Float	F
    //   145: aload_0
    //   146: getfield 87	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:d	I
    //   149: i2f
    //   150: fmul
    //   151: aload_0
    //   152: getfield 30	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Float	F
    //   155: fdiv
    //   156: f2i
    //   157: istore 4
    //   159: iload 4
    //   161: aload_0
    //   162: getfield 21	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   165: invokestatic 50	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lbaef;
    //   168: getfield 55	baef:jdField_a_of_type_Bbwq	Lbbwq;
    //   171: getfield 62	bbwq:jdField_b_of_type_Int	I
    //   174: irem
    //   175: istore 6
    //   177: iload 4
    //   179: istore_2
    //   180: iload 6
    //   182: ifeq +23 -> 205
    //   185: iload 4
    //   187: aload_0
    //   188: getfield 21	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   191: invokestatic 50	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lbaef;
    //   194: getfield 55	baef:jdField_a_of_type_Bbwq	Lbbwq;
    //   197: getfield 62	bbwq:jdField_b_of_type_Int	I
    //   200: iload 6
    //   202: isub
    //   203: iadd
    //   204: istore_2
    //   205: aload_0
    //   206: iload_2
    //   207: aload_0
    //   208: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Int	I
    //   211: isub
    //   212: putfield 78	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   215: aload 8
    //   217: invokevirtual 91	android/media/AudioTrack:flush	()V
    //   220: aload_0
    //   221: fconst_0
    //   222: putfield 86	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Float	F
    //   225: aload_0
    //   226: getfield 21	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   229: invokestatic 50	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lbaef;
    //   232: getfield 92	baef:jdField_a_of_type_Int	I
    //   235: tableswitch	default:+335 -> 570, 1:+190->425, 2:+208->443, 3:+226->461
    //   261: aload_0
    //   262: getfield 78	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   265: aload 10
    //   267: iload 5
    //   269: iconst_2
    //   270: imul
    //   271: invokestatic 97	bahd:a	([BI[BI)I
    //   274: istore_2
    //   275: aload_0
    //   276: getfield 21	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   279: invokestatic 50	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lbaef;
    //   282: getfield 99	baef:jdField_b_of_type_Boolean	Z
    //   285: ifne +16 -> 301
    //   288: aload 8
    //   290: aload 10
    //   292: iconst_0
    //   293: iload 5
    //   295: iconst_2
    //   296: imul
    //   297: invokevirtual 103	android/media/AudioTrack:write	([BII)I
    //   300: pop
    //   301: aload_0
    //   302: iload_2
    //   303: aload_0
    //   304: getfield 78	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   307: iadd
    //   308: putfield 78	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   311: aload_0
    //   312: getfield 78	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   315: aload_1
    //   316: arraylength
    //   317: if_icmplt +55 -> 372
    //   320: aload_0
    //   321: getfield 21	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   324: invokestatic 50	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lbaef;
    //   327: getfield 105	baef:jdField_a_of_type_Boolean	Z
    //   330: ifeq +42 -> 372
    //   333: aload_0
    //   334: getfield 21	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   337: invokestatic 50	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lbaef;
    //   340: getfield 92	baef:jdField_a_of_type_Int	I
    //   343: iconst_3
    //   344: if_icmpeq +23 -> 367
    //   347: aload_0
    //   348: monitorenter
    //   349: aload_0
    //   350: getfield 106	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Boolean	Z
    //   353: ifne +12 -> 365
    //   356: aload_0
    //   357: invokevirtual 109	java/lang/Object:wait	()V
    //   360: aload_0
    //   361: iconst_0
    //   362: putfield 106	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Boolean	Z
    //   365: aload_0
    //   366: monitorexit
    //   367: aload_0
    //   368: iconst_0
    //   369: putfield 78	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   372: aload_0
    //   373: getfield 110	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Boolean	Z
    //   376: istore 7
    //   378: iload 7
    //   380: ifeq -267 -> 113
    //   383: aload_0
    //   384: getfield 26	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   387: astore 9
    //   389: aload 9
    //   391: monitorenter
    //   392: aload_0
    //   393: getfield 26	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   396: invokevirtual 109	java/lang/Object:wait	()V
    //   399: aload 9
    //   401: monitorexit
    //   402: goto -289 -> 113
    //   405: astore 11
    //   407: aload 9
    //   409: monitorexit
    //   410: aload 11
    //   412: athrow
    //   413: astore 9
    //   415: aload 9
    //   417: invokevirtual 113	java/lang/InterruptedException:printStackTrace	()V
    //   420: iconst_1
    //   421: istore_3
    //   422: goto -309 -> 113
    //   425: aload_1
    //   426: aload_0
    //   427: getfield 78	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   430: aload 10
    //   432: iload 5
    //   434: iconst_2
    //   435: imul
    //   436: invokestatic 115	bahd:b	([BI[BI)I
    //   439: istore_2
    //   440: goto -165 -> 275
    //   443: aload_1
    //   444: aload_0
    //   445: getfield 78	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   448: aload 10
    //   450: iload 5
    //   452: iconst_2
    //   453: imul
    //   454: invokestatic 117	bahd:c	([BI[BI)I
    //   457: istore_2
    //   458: goto -183 -> 275
    //   461: aload_1
    //   462: aload_0
    //   463: getfield 78	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Int	I
    //   466: aload 10
    //   468: iload 5
    //   470: iconst_2
    //   471: imul
    //   472: invokestatic 119	bahd:d	([BI[BI)I
    //   475: istore_2
    //   476: goto -201 -> 275
    //   479: astore_1
    //   480: aload_0
    //   481: monitorexit
    //   482: aload_1
    //   483: athrow
    //   484: astore 9
    //   486: aload 8
    //   488: astore_1
    //   489: aload 9
    //   491: astore 8
    //   493: ldc 38
    //   495: iconst_4
    //   496: ldc 121
    //   498: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   501: aload 8
    //   503: invokevirtual 124	java/lang/Throwable:printStackTrace	()V
    //   506: aload_1
    //   507: ifnull +7 -> 514
    //   510: aload_1
    //   511: invokevirtual 127	android/media/AudioTrack:release	()V
    //   514: return
    //   515: aload 8
    //   517: invokevirtual 130	android/media/AudioTrack:stop	()V
    //   520: aload 8
    //   522: ifnull -8 -> 514
    //   525: aload 8
    //   527: invokevirtual 127	android/media/AudioTrack:release	()V
    //   530: return
    //   531: astore_1
    //   532: aload 9
    //   534: astore 8
    //   536: aload 8
    //   538: ifnull +8 -> 546
    //   541: aload 8
    //   543: invokevirtual 127	android/media/AudioTrack:release	()V
    //   546: aload_1
    //   547: athrow
    //   548: astore_1
    //   549: goto -13 -> 536
    //   552: astore 9
    //   554: aload_1
    //   555: astore 8
    //   557: aload 9
    //   559: astore_1
    //   560: goto -24 -> 536
    //   563: astore 8
    //   565: aconst_null
    //   566: astore_1
    //   567: goto -74 -> 493
    //   570: goto -310 -> 260
    //   573: bipush 12
    //   575: istore_2
    //   576: goto -546 -> 30
    //   579: iconst_3
    //   580: istore_3
    //   581: goto -531 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	584	0	this	AudioPlayRunnable
    //   0	584	1	paramArrayOfByte	byte[]
    //   1	575	2	i	int
    //   49	532	3	j	int
    //   157	47	4	k	int
    //   68	404	5	m	int
    //   175	28	6	n	int
    //   376	3	7	bool	boolean
    //   104	452	8	localObject1	Object
    //   563	1	8	localThrowable1	java.lang.Throwable
    //   11	397	9	localObject2	Object
    //   413	3	9	localInterruptedException	InterruptedException
    //   484	49	9	localThrowable2	java.lang.Throwable
    //   552	6	9	localObject3	Object
    //   76	391	10	arrayOfByte	byte[]
    //   405	6	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   392	402	405	finally
    //   407	410	405	finally
    //   383	392	413	java/lang/InterruptedException
    //   410	413	413	java/lang/InterruptedException
    //   349	365	479	finally
    //   365	367	479	finally
    //   480	482	479	finally
    //   106	111	484	java/lang/Throwable
    //   113	128	484	java/lang/Throwable
    //   132	177	484	java/lang/Throwable
    //   185	205	484	java/lang/Throwable
    //   205	225	484	java/lang/Throwable
    //   225	260	484	java/lang/Throwable
    //   260	275	484	java/lang/Throwable
    //   275	301	484	java/lang/Throwable
    //   301	349	484	java/lang/Throwable
    //   367	372	484	java/lang/Throwable
    //   372	378	484	java/lang/Throwable
    //   383	392	484	java/lang/Throwable
    //   410	413	484	java/lang/Throwable
    //   415	420	484	java/lang/Throwable
    //   425	440	484	java/lang/Throwable
    //   443	458	484	java/lang/Throwable
    //   461	476	484	java/lang/Throwable
    //   482	484	484	java/lang/Throwable
    //   515	520	484	java/lang/Throwable
    //   13	30	531	finally
    //   30	48	531	finally
    //   50	106	531	finally
    //   106	111	548	finally
    //   113	128	548	finally
    //   132	177	548	finally
    //   185	205	548	finally
    //   205	225	548	finally
    //   225	260	548	finally
    //   260	275	548	finally
    //   275	301	548	finally
    //   301	349	548	finally
    //   367	372	548	finally
    //   372	378	548	finally
    //   383	392	548	finally
    //   410	413	548	finally
    //   415	420	548	finally
    //   425	440	548	finally
    //   443	458	548	finally
    //   461	476	548	finally
    //   482	484	548	finally
    //   515	520	548	finally
    //   493	506	552	finally
    //   13	30	563	java/lang/Throwable
    //   30	48	563	java/lang/Throwable
    //   50	106	563	java/lang/Throwable
  }
  
  /* Error */
  private byte[] a()
  {
    // Byte code:
    //   0: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 141	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: getfield 21	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   12: invokestatic 50	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lbaef;
    //   15: getfield 144	baef:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 5
    //   23: aload_0
    //   24: aload 5
    //   26: invokevirtual 150	java/io/File:length	()J
    //   29: l2i
    //   30: putfield 87	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:d	I
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 87	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:d	I
    //   38: i2f
    //   39: aload_0
    //   40: getfield 28	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Float	F
    //   43: fmul
    //   44: f2i
    //   45: putfield 88	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Int	I
    //   48: aload_0
    //   49: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Int	I
    //   52: aload_0
    //   53: getfield 21	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   56: invokestatic 50	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lbaef;
    //   59: getfield 55	baef:jdField_a_of_type_Bbwq	Lbbwq;
    //   62: getfield 62	bbwq:jdField_b_of_type_Int	I
    //   65: irem
    //   66: istore_1
    //   67: iload_1
    //   68: ifeq +29 -> 97
    //   71: aload_0
    //   72: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Int	I
    //   75: istore_2
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 21	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   81: invokestatic 50	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lbaef;
    //   84: getfield 55	baef:jdField_a_of_type_Bbwq	Lbbwq;
    //   87: getfield 62	bbwq:jdField_b_of_type_Int	I
    //   90: iload_1
    //   91: isub
    //   92: iload_2
    //   93: iadd
    //   94: putfield 88	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Int	I
    //   97: aload_0
    //   98: getfield 30	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Float	F
    //   101: fconst_0
    //   102: fcmpl
    //   103: ifne +160 -> 263
    //   106: aload_0
    //   107: aload_0
    //   108: getfield 87	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:d	I
    //   111: putfield 152	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   114: ldc 38
    //   116: iconst_4
    //   117: new 154	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   124: ldc 157
    //   126: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_0
    //   130: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Int	I
    //   133: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: ldc 166
    //   138: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 152	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   145: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 45	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_0
    //   155: getfield 152	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   158: aload_0
    //   159: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Int	I
    //   162: isub
    //   163: newarray byte
    //   165: astore 7
    //   167: new 172	java/io/FileInputStream
    //   170: dup
    //   171: aload 5
    //   173: invokespecial 175	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   176: astore 6
    //   178: aload 6
    //   180: ifnull +41 -> 221
    //   183: aload 6
    //   185: astore 5
    //   187: aload_0
    //   188: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Int	I
    //   191: ifeq +18 -> 209
    //   194: aload 6
    //   196: astore 5
    //   198: aload 6
    //   200: aload_0
    //   201: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Int	I
    //   204: i2l
    //   205: invokevirtual 179	java/io/FileInputStream:skip	(J)J
    //   208: pop2
    //   209: aload 6
    //   211: astore 5
    //   213: aload 6
    //   215: aload 7
    //   217: invokevirtual 183	java/io/FileInputStream:read	([B)I
    //   220: pop
    //   221: aload 6
    //   223: ifnull +8 -> 231
    //   226: aload 6
    //   228: invokevirtual 186	java/io/FileInputStream:close	()V
    //   231: ldc 38
    //   233: iconst_4
    //   234: new 154	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   241: ldc 188
    //   243: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   249: lload_3
    //   250: lsub
    //   251: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   254: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 45	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload 7
    //   262: areturn
    //   263: aload_0
    //   264: aload_0
    //   265: getfield 87	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:d	I
    //   268: i2f
    //   269: aload_0
    //   270: getfield 30	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Float	F
    //   273: fmul
    //   274: f2i
    //   275: putfield 152	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   278: aload_0
    //   279: getfield 152	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   282: aload_0
    //   283: getfield 21	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   286: invokestatic 50	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lbaef;
    //   289: getfield 55	baef:jdField_a_of_type_Bbwq	Lbbwq;
    //   292: getfield 62	bbwq:jdField_b_of_type_Int	I
    //   295: irem
    //   296: istore_1
    //   297: iload_1
    //   298: ifeq -184 -> 114
    //   301: aload_0
    //   302: getfield 152	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   305: istore_2
    //   306: aload_0
    //   307: aload_0
    //   308: getfield 21	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   311: invokestatic 50	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lbaef;
    //   314: getfield 55	baef:jdField_a_of_type_Bbwq	Lbbwq;
    //   317: getfield 62	bbwq:jdField_b_of_type_Int	I
    //   320: iload_1
    //   321: isub
    //   322: iload_2
    //   323: iadd
    //   324: putfield 152	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_c_of_type_Int	I
    //   327: goto -213 -> 114
    //   330: astore 5
    //   332: aload 5
    //   334: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   337: goto -106 -> 231
    //   340: astore 7
    //   342: aconst_null
    //   343: astore 6
    //   345: aload 6
    //   347: astore 5
    //   349: ldc 38
    //   351: iconst_4
    //   352: ldc 121
    //   354: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: aload 6
    //   359: astore 5
    //   361: aload 7
    //   363: invokevirtual 124	java/lang/Throwable:printStackTrace	()V
    //   366: aload 6
    //   368: ifnull +8 -> 376
    //   371: aload 6
    //   373: invokevirtual 186	java/io/FileInputStream:close	()V
    //   376: aconst_null
    //   377: areturn
    //   378: astore 5
    //   380: aload 5
    //   382: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   385: goto -9 -> 376
    //   388: astore 6
    //   390: aconst_null
    //   391: astore 5
    //   393: aload 5
    //   395: ifnull +8 -> 403
    //   398: aload 5
    //   400: invokevirtual 186	java/io/FileInputStream:close	()V
    //   403: aload 6
    //   405: athrow
    //   406: astore 5
    //   408: aload 5
    //   410: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   413: goto -10 -> 403
    //   416: astore 6
    //   418: goto -25 -> 393
    //   421: astore 7
    //   423: goto -78 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	AudioPlayRunnable
    //   66	256	1	i	int
    //   75	249	2	j	int
    //   3	247	3	l	long
    //   21	191	5	localObject1	Object
    //   330	3	5	localIOException1	java.io.IOException
    //   347	13	5	localObject2	Object
    //   378	3	5	localIOException2	java.io.IOException
    //   391	8	5	localObject3	Object
    //   406	3	5	localIOException3	java.io.IOException
    //   176	196	6	localFileInputStream	java.io.FileInputStream
    //   388	16	6	localObject4	Object
    //   416	1	6	localObject5	Object
    //   165	96	7	arrayOfByte	byte[]
    //   340	22	7	localThrowable1	java.lang.Throwable
    //   421	1	7	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   226	231	330	java/io/IOException
    //   167	178	340	java/lang/Throwable
    //   371	376	378	java/io/IOException
    //   167	178	388	finally
    //   398	403	406	java/io/IOException
    //   187	194	416	finally
    //   198	209	416	finally
    //   213	221	416	finally
    //   349	357	416	finally
    //   361	366	416	finally
    //   187	194	421	java/lang/Throwable
    //   198	209	421	java/lang/Throwable
    //   213	221	421	java/lang/Throwable
  }
  
  /* Error */
  private byte[] a(String paramString)
  {
    // Byte code:
    //   0: ldc 38
    //   2: iconst_4
    //   3: ldc 197
    //   5: invokestatic 45	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   11: lstore 10
    //   13: aconst_null
    //   14: astore 14
    //   16: new 199	android/media/MediaExtractor
    //   19: dup
    //   20: invokespecial 200	android/media/MediaExtractor:<init>	()V
    //   23: astore 15
    //   25: aload 15
    //   27: aload_1
    //   28: invokevirtual 203	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   31: new 205	java/io/ByteArrayOutputStream
    //   34: dup
    //   35: invokespecial 206	java/io/ByteArrayOutputStream:<init>	()V
    //   38: astore 16
    //   40: lconst_0
    //   41: lstore 6
    //   43: iconst_0
    //   44: istore_2
    //   45: iload_2
    //   46: aload 15
    //   48: invokevirtual 210	android/media/MediaExtractor:getTrackCount	()I
    //   51: if_icmpge +665 -> 716
    //   54: aload 15
    //   56: iload_2
    //   57: invokevirtual 214	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   60: astore 17
    //   62: aload 17
    //   64: ldc 216
    //   66: invokevirtual 222	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 18
    //   71: aload_0
    //   72: aload 17
    //   74: ldc 224
    //   76: invokevirtual 228	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   79: putfield 230	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Long	J
    //   82: aload_0
    //   83: getfield 28	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Float	F
    //   86: aload_0
    //   87: getfield 230	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Long	J
    //   90: l2f
    //   91: fmul
    //   92: f2l
    //   93: lstore 12
    //   95: aload_0
    //   96: getfield 30	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_b_of_type_Float	F
    //   99: aload_0
    //   100: getfield 230	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Long	J
    //   103: l2f
    //   104: fmul
    //   105: f2l
    //   106: lstore 8
    //   108: lload 8
    //   110: lstore 6
    //   112: lload 8
    //   114: lconst_0
    //   115: lcmp
    //   116: ifne +9 -> 125
    //   119: aload_0
    //   120: getfield 230	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:jdField_a_of_type_Long	J
    //   123: lstore 6
    //   125: aload 18
    //   127: ldc 232
    //   129: invokevirtual 238	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   132: ifeq +83 -> 215
    //   135: aload 15
    //   137: iload_2
    //   138: invokevirtual 242	android/media/MediaExtractor:selectTrack	(I)V
    //   141: lload 12
    //   143: lconst_0
    //   144: lcmp
    //   145: ifle +11 -> 156
    //   148: aload 15
    //   150: lload 12
    //   152: iconst_0
    //   153: invokevirtual 246	android/media/MediaExtractor:seekTo	(JI)V
    //   156: aload 14
    //   158: astore_1
    //   159: aload 18
    //   161: invokestatic 252	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   164: astore 14
    //   166: aload 14
    //   168: astore_1
    //   169: aload 14
    //   171: aload 17
    //   173: aconst_null
    //   174: aconst_null
    //   175: iconst_0
    //   176: invokevirtual 256	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   179: aload 14
    //   181: ifnonnull +41 -> 222
    //   184: ldc 38
    //   186: iconst_2
    //   187: ldc_w 258
    //   190: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aconst_null
    //   194: areturn
    //   195: astore_1
    //   196: aload_1
    //   197: invokevirtual 192	java/io/IOException:printStackTrace	()V
    //   200: aconst_null
    //   201: areturn
    //   202: astore 14
    //   204: aload 14
    //   206: invokevirtual 124	java/lang/Throwable:printStackTrace	()V
    //   209: aload_1
    //   210: astore 14
    //   212: goto -33 -> 179
    //   215: iload_2
    //   216: iconst_1
    //   217: iadd
    //   218: istore_2
    //   219: goto -174 -> 45
    //   222: aload 14
    //   224: invokevirtual 261	android/media/MediaCodec:start	()V
    //   227: aload 14
    //   229: invokevirtual 265	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   232: astore 17
    //   234: aload 14
    //   236: invokevirtual 268	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   239: astore_1
    //   240: new 270	android/media/MediaCodec$BufferInfo
    //   243: dup
    //   244: invokespecial 271	android/media/MediaCodec$BufferInfo:<init>	()V
    //   247: astore 18
    //   249: iconst_0
    //   250: istore_2
    //   251: iconst_0
    //   252: istore_3
    //   253: iload_3
    //   254: ifne +241 -> 495
    //   257: aload 14
    //   259: ldc2_w 272
    //   262: invokevirtual 277	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   265: istore 4
    //   267: iload 4
    //   269: iflt +226 -> 495
    //   272: aload 15
    //   274: aload 17
    //   276: iload 4
    //   278: aaload
    //   279: iconst_0
    //   280: invokevirtual 281	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   283: istore 5
    //   285: aload 15
    //   287: invokevirtual 284	android/media/MediaExtractor:getSampleTime	()J
    //   290: lstore 8
    //   292: iload 5
    //   294: iflt +18 -> 312
    //   297: lload 6
    //   299: lconst_0
    //   300: lcmp
    //   301: ifle +175 -> 476
    //   304: lload 8
    //   306: lload 6
    //   308: lcmp
    //   309: iflt +167 -> 476
    //   312: aload 14
    //   314: iload 4
    //   316: iconst_0
    //   317: iconst_0
    //   318: lconst_0
    //   319: iconst_4
    //   320: invokevirtual 288	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   323: iconst_1
    //   324: istore_3
    //   325: iload_2
    //   326: ifne +387 -> 713
    //   329: aload 14
    //   331: aload 18
    //   333: ldc2_w 272
    //   336: invokevirtual 292	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   339: istore 4
    //   341: iload 4
    //   343: tableswitch	default:+25 -> 368, -3:+155->498, -2:+179->522, -1:+218->561
    //   369: ldc 180
    //   371: aconst_null
    //   372: dload_1
    //   373: iconst_4
    //   374: iand
    //   375: ifeq +204 -> 579
    //   378: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   381: ifeq +12 -> 393
    //   384: ldc 38
    //   386: iconst_2
    //   387: ldc_w 300
    //   390: invokestatic 45	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: iconst_1
    //   394: istore_2
    //   395: aload 14
    //   397: iload 4
    //   399: iconst_0
    //   400: invokevirtual 304	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   403: iload_2
    //   404: ifeq +306 -> 710
    //   407: aload 14
    //   409: invokevirtual 305	android/media/MediaCodec:stop	()V
    //   412: aload 14
    //   414: invokevirtual 306	android/media/MediaCodec:release	()V
    //   417: aload 15
    //   419: invokevirtual 307	android/media/MediaExtractor:release	()V
    //   422: ldc 38
    //   424: iconst_1
    //   425: new 154	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   432: ldc_w 309
    //   435: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   441: lload 10
    //   443: lsub
    //   444: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   447: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 45	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: aload 16
    //   455: invokevirtual 312	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   458: areturn
    //   459: astore_1
    //   460: aload_1
    //   461: invokevirtual 124	java/lang/Throwable:printStackTrace	()V
    //   464: ldc 38
    //   466: iconst_2
    //   467: ldc_w 314
    //   470: aload_1
    //   471: invokestatic 317	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   474: aconst_null
    //   475: areturn
    //   476: aload 14
    //   478: iload 4
    //   480: iconst_0
    //   481: iload 5
    //   483: lload 8
    //   485: iconst_0
    //   486: invokevirtual 288	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   489: aload 15
    //   491: invokevirtual 320	android/media/MediaExtractor:advance	()Z
    //   494: pop
    //   495: goto -170 -> 325
    //   498: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   501: ifeq +12 -> 513
    //   504: ldc 38
    //   506: iconst_2
    //   507: ldc_w 322
    //   510: invokestatic 45	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   513: aload 14
    //   515: invokevirtual 268	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   518: astore_1
    //   519: goto -116 -> 403
    //   522: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   525: ifeq +188 -> 713
    //   528: ldc 38
    //   530: iconst_2
    //   531: new 154	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   538: ldc_w 324
    //   541: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 14
    //   546: invokevirtual 328	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   549: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 45	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   558: goto -155 -> 403
    //   561: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   564: ifeq +149 -> 713
    //   567: ldc 38
    //   569: iconst_2
    //   570: ldc_w 333
    //   573: invokestatic 45	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   576: goto -173 -> 403
    //   579: aload_1
    //   580: iload 4
    //   582: aaload
    //   583: astore 19
    //   585: aload 19
    //   587: ifnonnull +15 -> 602
    //   590: ldc 38
    //   592: iconst_1
    //   593: ldc_w 335
    //   596: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   599: goto -196 -> 403
    //   602: aload 18
    //   604: getfield 338	android/media/MediaCodec$BufferInfo:size	I
    //   607: ifeq +31 -> 638
    //   610: aload 19
    //   612: aload 18
    //   614: getfield 341	android/media/MediaCodec$BufferInfo:offset	I
    //   617: invokevirtual 347	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   620: pop
    //   621: aload 19
    //   623: aload 18
    //   625: getfield 341	android/media/MediaCodec$BufferInfo:offset	I
    //   628: aload 18
    //   630: getfield 338	android/media/MediaCodec$BufferInfo:size	I
    //   633: iadd
    //   634: invokevirtual 350	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   637: pop
    //   638: aload 19
    //   640: invokevirtual 353	java/nio/ByteBuffer:remaining	()I
    //   643: istore 5
    //   645: iload 5
    //   647: newarray byte
    //   649: astore 20
    //   651: aload 19
    //   653: aload 20
    //   655: iconst_0
    //   656: iload 5
    //   658: invokevirtual 357	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   661: pop
    //   662: aload 16
    //   664: aload 20
    //   666: iconst_0
    //   667: iload 5
    //   669: invokevirtual 360	java/io/ByteArrayOutputStream:write	([BII)V
    //   672: goto -277 -> 395
    //   675: astore 19
    //   677: ldc 38
    //   679: iconst_1
    //   680: new 154	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   687: ldc_w 362
    //   690: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: aload 19
    //   695: invokevirtual 363	java/lang/Exception:toString	()Ljava/lang/String;
    //   698: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   707: goto -304 -> 403
    //   710: goto -457 -> 253
    //   713: goto -310 -> 403
    //   716: aconst_null
    //   717: astore 14
    //   719: goto -540 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	722	0	this	AudioPlayRunnable
    //   0	722	1	paramString	String
    //   44	360	2	i	int
    //   252	73	3	j	int
    //   265	316	4	k	int
    //   283	385	5	m	int
    //   41	266	6	l1	long
    //   106	378	8	l2	long
    //   11	431	10	l3	long
    //   93	58	12	l4	long
    //   14	166	14	localMediaCodec	android.media.MediaCodec
    //   202	3	14	localThrowable	java.lang.Throwable
    //   210	508	14	str	String
    //   23	467	15	localMediaExtractor	android.media.MediaExtractor
    //   38	625	16	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   60	215	17	localObject1	Object
    //   69	560	18	localObject2	Object
    //   583	69	19	localObject3	Object
    //   675	19	19	localException	Exception
    //   649	16	20	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   25	31	195	java/io/IOException
    //   159	166	202	java/lang/Throwable
    //   169	179	202	java/lang/Throwable
    //   222	227	459	java/lang/Throwable
    //   590	599	675	java/lang/Exception
    //   602	638	675	java/lang/Exception
    //   638	672	675	java/lang/Exception
  }
  
  public void a()
  {
    if (AudioDecoder.a(this.this$0).jdField_a_of_type_Int != 3) {}
    try
    {
      Thread.sleep(500L);
    }
    catch (InterruptedException localInterruptedException)
    {
      try
      {
        for (;;)
        {
          this.jdField_b_of_type_Boolean = true;
          notifyAll();
          this.jdField_a_of_type_Int = 0;
          return;
          localInterruptedException = localInterruptedException;
          localInterruptedException.printStackTrace();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      finally {}
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    float f = (float)paramLong1 / (float)paramLong2;
    if ((f >= this.jdField_a_of_type_Float) && (f <= this.jdField_b_of_type_Float))
    {
      this.jdField_c_of_type_Float = f;
      return;
    }
    QLog.w("AudioDecoder", 1, "seek error, timePercent=" + f);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public void run()
  {
    if (AudioDecoder.a(this.this$0).jdField_a_of_type_JavaLangString.endsWith(".mp4")) {}
    for (byte[] arrayOfByte = a(AudioDecoder.a(this.this$0).jdField_a_of_type_JavaLangString); arrayOfByte == null; arrayOfByte = a()) {
      return;
    }
    a(arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.AudioPlayRunnable
 * JD-Core Version:    0.7.0.1
 */