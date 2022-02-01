package com.tencent.mobileqq.qwallet.hb.aio.specify.impl;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;

class SpecifyRedPacketAnimMsg$3$1
  implements Runnable
{
  SpecifyRedPacketAnimMsg$3$1(SpecifyRedPacketAnimMsg.3 param3, IPreloadService.PathResult paramPathResult) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 31
    //   8: iconst_2
    //   9: ldc 33
    //   11: invokestatic 37	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 14	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1:b	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3;
    //   18: getfield 43	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3:d	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg;
    //   21: invokestatic 48	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg:a	(Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg;)Z
    //   24: ifeq +4 -> 28
    //   27: return
    //   28: aload_0
    //   29: getfield 14	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1:b	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3;
    //   32: getfield 51	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3:a	Ljava/lang/ref/WeakReference;
    //   35: invokevirtual 57	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   38: checkcast 59	com/tencent/mobileqq/data/MessageForQQWalletMsg
    //   41: astore 5
    //   43: aload 5
    //   45: ifnonnull +16 -> 61
    //   48: aload_0
    //   49: getfield 14	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1:b	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3;
    //   52: getfield 62	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3:b	Lcom/qwallet/temp/ISpriteVideoViewTemp$OnFrameEndListener;
    //   55: invokeinterface 66 1 0
    //   60: return
    //   61: new 68	java/io/File
    //   64: dup
    //   65: aload_0
    //   66: getfield 16	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1:a	Lcom/tencent/mobileqq/qwallet/preload/IPreloadService$PathResult;
    //   69: getfield 74	com/tencent/mobileqq/qwallet/preload/IPreloadService$PathResult:folderPath	Ljava/lang/String;
    //   72: ldc 76
    //   74: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: astore_2
    //   81: new 68	java/io/File
    //   84: dup
    //   85: aload_2
    //   86: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: invokevirtual 89	java/io/File:exists	()Z
    //   92: ifne +16 -> 108
    //   95: aload_0
    //   96: getfield 14	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1:b	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3;
    //   99: getfield 62	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3:b	Lcom/qwallet/temp/ISpriteVideoViewTemp$OnFrameEndListener;
    //   102: invokeinterface 66 1 0
    //   107: return
    //   108: aload_0
    //   109: getfield 14	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1:b	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3;
    //   112: getfield 92	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3:c	Ljava/lang/ref/WeakReference;
    //   115: invokevirtual 57	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   118: checkcast 94	com/qwallet/temp/IBaseChatPieProxy
    //   121: astore_3
    //   122: ldc 96
    //   124: invokestatic 102	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   127: checkcast 96	com/qwallet/temp/IQwTemp
    //   130: ldc 104
    //   132: invokeinterface 108 2 0
    //   137: istore_1
    //   138: aload_3
    //   139: ifnull +263 -> 402
    //   142: aload_3
    //   143: invokeinterface 112 1 0
    //   148: iload_1
    //   149: if_icmpne +253 -> 402
    //   152: aload_3
    //   153: invokeinterface 115 1 0
    //   158: ifnull +244 -> 402
    //   161: aload_3
    //   162: invokeinterface 115 1 0
    //   167: invokevirtual 120	com/tencent/mobileqq/app/QBaseActivity:isFinishing	()Z
    //   170: ifeq +6 -> 176
    //   173: goto +229 -> 402
    //   176: aload_3
    //   177: invokeinterface 115 1 0
    //   182: astore 4
    //   184: aload_0
    //   185: getfield 14	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1:b	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3;
    //   188: getfield 43	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3:d	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg;
    //   191: new 122	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyGiftView
    //   194: dup
    //   195: aload 4
    //   197: aload 5
    //   199: invokespecial 125	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyGiftView:<init>	(Landroid/content/Context;Lcom/tencent/mobileqq/data/MessageForQQWalletMsg;)V
    //   202: putfield 128	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg:c	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyGiftView;
    //   205: getstatic 134	android/os/Build$VERSION:SDK_INT	I
    //   208: bipush 19
    //   210: if_icmplt +263 -> 473
    //   213: ldc 135
    //   215: istore_1
    //   216: goto +3 -> 219
    //   219: new 137	android/view/WindowManager$LayoutParams
    //   222: dup
    //   223: iconst_m1
    //   224: bipush 254
    //   226: iconst_2
    //   227: iload_1
    //   228: bipush 254
    //   230: invokespecial 140	android/view/WindowManager$LayoutParams:<init>	(IIIII)V
    //   233: astore 5
    //   235: aload 5
    //   237: bipush 49
    //   239: putfield 143	android/view/WindowManager$LayoutParams:gravity	I
    //   242: aload_3
    //   243: invokeinterface 147 1 0
    //   248: astore 6
    //   250: iconst_2
    //   251: newarray int
    //   253: astore 7
    //   255: aload 6
    //   257: aload 7
    //   259: invokevirtual 153	android/view/View:getLocationOnScreen	([I)V
    //   262: aload 4
    //   264: invokestatic 158	com/tencent/util/LiuHaiUtils:b	(Landroid/app/Activity;)Z
    //   267: ifeq +17 -> 284
    //   270: aload 5
    //   272: aload_3
    //   273: invokeinterface 160 1 0
    //   278: putfield 163	android/view/WindowManager$LayoutParams:y	I
    //   281: goto +19 -> 300
    //   284: aload 5
    //   286: aload 7
    //   288: iconst_1
    //   289: iaload
    //   290: aload_3
    //   291: invokeinterface 160 1 0
    //   296: iadd
    //   297: putfield 163	android/view/WindowManager$LayoutParams:y	I
    //   300: aload_0
    //   301: getfield 14	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1:b	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3;
    //   304: getfield 43	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3:d	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg;
    //   307: aload 4
    //   309: ldc 165
    //   311: invokevirtual 171	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   314: checkcast 173	android/view/WindowManager
    //   317: putfield 176	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg:b	Landroid/view/WindowManager;
    //   320: aload_0
    //   321: getfield 14	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1:b	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3;
    //   324: getfield 43	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3:d	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg;
    //   327: getfield 176	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg:b	Landroid/view/WindowManager;
    //   330: aload_0
    //   331: getfield 14	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1:b	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3;
    //   334: getfield 43	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3:d	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg;
    //   337: getfield 128	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg:c	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyGiftView;
    //   340: invokeinterface 180 2 0
    //   345: aload_0
    //   346: getfield 14	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1:b	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3;
    //   349: getfield 43	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3:d	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg;
    //   352: getfield 176	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg:b	Landroid/view/WindowManager;
    //   355: aload_0
    //   356: getfield 14	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1:b	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3;
    //   359: getfield 43	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3:d	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg;
    //   362: getfield 128	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg:c	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyGiftView;
    //   365: aload 5
    //   367: invokeinterface 184 3 0
    //   372: aload_0
    //   373: getfield 14	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1:b	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3;
    //   376: getfield 43	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3:d	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg;
    //   379: getfield 128	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg:c	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyGiftView;
    //   382: aload_2
    //   383: aload_0
    //   384: getfield 14	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1:b	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3;
    //   387: getfield 62	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3:b	Lcom/qwallet/temp/ISpriteVideoViewTemp$OnFrameEndListener;
    //   390: new 186	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1$1
    //   393: dup
    //   394: aload_0
    //   395: invokespecial 189	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1$1:<init>	(Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1;)V
    //   398: invokevirtual 192	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyGiftView:a	(Ljava/lang/String;Lcom/qwallet/temp/ISpriteVideoViewTemp$OnFrameEndListener;Landroid/view/View$OnClickListener;)V
    //   401: return
    //   402: aload_0
    //   403: getfield 14	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1:b	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3;
    //   406: getfield 62	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3:b	Lcom/qwallet/temp/ISpriteVideoViewTemp$OnFrameEndListener;
    //   409: invokeinterface 66 1 0
    //   414: return
    //   415: astore_2
    //   416: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq +37 -> 456
    //   422: new 194	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   429: astore_3
    //   430: aload_3
    //   431: ldc 197
    //   433: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload_3
    //   438: aload_2
    //   439: invokevirtual 204	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   442: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: ldc 31
    //   448: iconst_2
    //   449: aload_3
    //   450: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: aload_0
    //   457: getfield 14	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3$1:b	Lcom/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3;
    //   460: getfield 62	com/tencent/mobileqq/qwallet/hb/aio/specify/impl/SpecifyRedPacketAnimMsg$3:b	Lcom/qwallet/temp/ISpriteVideoViewTemp$OnFrameEndListener;
    //   463: invokeinterface 66 1 0
    //   468: return
    //   469: astore_3
    //   470: goto -125 -> 345
    //   473: bipush 8
    //   475: istore_1
    //   476: goto -257 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	1
    //   137	339	1	i	int
    //   80	303	2	str	java.lang.String
    //   415	24	2	localThrowable1	java.lang.Throwable
    //   121	329	3	localObject1	Object
    //   469	1	3	localThrowable2	java.lang.Throwable
    //   182	126	4	localQBaseActivity	com.tencent.mobileqq.app.QBaseActivity
    //   41	325	5	localObject2	Object
    //   248	8	6	localView	android.view.View
    //   253	34	7	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   14	27	415	java/lang/Throwable
    //   28	43	415	java/lang/Throwable
    //   48	60	415	java/lang/Throwable
    //   61	107	415	java/lang/Throwable
    //   108	138	415	java/lang/Throwable
    //   142	173	415	java/lang/Throwable
    //   176	213	415	java/lang/Throwable
    //   219	281	415	java/lang/Throwable
    //   284	300	415	java/lang/Throwable
    //   300	320	415	java/lang/Throwable
    //   345	401	415	java/lang/Throwable
    //   402	414	415	java/lang/Throwable
    //   320	345	469	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.specify.impl.SpecifyRedPacketAnimMsg.3.1
 * JD-Core Version:    0.7.0.1
 */