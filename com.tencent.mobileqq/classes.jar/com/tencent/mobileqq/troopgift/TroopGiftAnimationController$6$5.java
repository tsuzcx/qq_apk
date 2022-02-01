package com.tencent.mobileqq.troopgift;

import android.graphics.Bitmap;

class TroopGiftAnimationController$6$5
  implements Runnable
{
  TroopGiftAnimationController$6$5(TroopGiftAnimationController.6 param6, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   4: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   7: getfield 48	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   10: ifnull +2288 -> 2298
    //   13: aload_0
    //   14: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   17: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   20: getfield 48	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   23: invokevirtual 54	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getVisibility	()I
    //   26: bipush 8
    //   28: if_icmpeq +2270 -> 2298
    //   31: aload_0
    //   32: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   35: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   38: invokestatic 57	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:d	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   41: invokevirtual 63	android/app/Activity:isFinishing	()Z
    //   44: ifeq +6 -> 50
    //   47: goto +2251 -> 2298
    //   50: aload_0
    //   51: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   54: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   57: invokestatic 57	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:d	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   60: invokevirtual 67	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   63: invokevirtual 73	android/content/Context:getPackageName	()Ljava/lang/String;
    //   66: astore 22
    //   68: aload_0
    //   69: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   72: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   75: invokestatic 57	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:d	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   78: instanceof 75
    //   81: istore 20
    //   83: aconst_null
    //   84: astore 24
    //   86: iload 20
    //   88: ifeq +29 -> 117
    //   91: aload_0
    //   92: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   95: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   98: invokestatic 57	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:d	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   101: astore 21
    //   103: invokestatic 81	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   106: invokevirtual 85	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   109: checkcast 87	com/tencent/common/app/AppInterface
    //   112: astore 23
    //   114: goto +246 -> 360
    //   117: aload_0
    //   118: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   121: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   124: invokestatic 57	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:d	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   127: instanceof 89
    //   130: ifeq +143 -> 273
    //   133: aload_0
    //   134: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   137: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   140: invokestatic 57	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:d	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   143: checkcast 89	com/tencent/mobileqq/pluginsdk/BasePluginActivity
    //   146: invokevirtual 93	com/tencent/mobileqq/pluginsdk/BasePluginActivity:getOutActivity	()Landroid/app/Activity;
    //   149: astore 23
    //   151: aload_0
    //   152: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   155: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   158: getfield 97	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:i	I
    //   161: iconst_2
    //   162: if_icmpne +38 -> 200
    //   165: new 99	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   172: astore 21
    //   174: aload 21
    //   176: aload 22
    //   178: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 21
    //   184: ldc 106
    //   186: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 21
    //   192: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: astore 21
    //   197: goto +54 -> 251
    //   200: aload 22
    //   202: astore 21
    //   204: aload_0
    //   205: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   208: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   211: getfield 97	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:i	I
    //   214: bipush 20
    //   216: if_icmpne +35 -> 251
    //   219: new 99	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   226: astore 21
    //   228: aload 21
    //   230: aload 22
    //   232: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 21
    //   238: ldc 111
    //   240: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 21
    //   246: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: astore 21
    //   251: invokestatic 81	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   254: invokevirtual 85	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   257: checkcast 87	com/tencent/common/app/AppInterface
    //   260: astore 22
    //   262: aload 21
    //   264: astore 22
    //   266: aload 23
    //   268: astore 21
    //   270: goto +90 -> 360
    //   273: aload_0
    //   274: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   277: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   280: invokestatic 57	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:d	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   283: instanceof 113
    //   286: ifeq +71 -> 357
    //   289: new 99	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   296: astore 21
    //   298: aload 21
    //   300: aload 22
    //   302: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 21
    //   308: ldc 115
    //   310: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 21
    //   316: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: astore 22
    //   321: aload_0
    //   322: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   325: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   328: invokestatic 57	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:d	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   331: astore 21
    //   333: aload_0
    //   334: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   337: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   340: invokestatic 57	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:d	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   343: checkcast 113	com/tencent/mobileqq/activity/QQBrowserActivity
    //   346: invokevirtual 118	com/tencent/mobileqq/activity/QQBrowserActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   349: checkcast 87	com/tencent/common/app/AppInterface
    //   352: astore 23
    //   354: goto +6 -> 360
    //   357: aconst_null
    //   358: astore 21
    //   360: aload 21
    //   362: ifnull +13 -> 375
    //   365: aload 21
    //   367: aload 22
    //   369: invokestatic 123	com/tencent/mobileqq/utils/ProcessUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   372: ifeq +56 -> 428
    //   375: aload 21
    //   377: instanceof 75
    //   380: ifeq +10 -> 390
    //   383: getstatic 126	com/tencent/mobileqq/activity/SplashActivity:currentFragment	I
    //   386: iconst_2
    //   387: if_icmpne +41 -> 428
    //   390: aload 21
    //   392: instanceof 128
    //   395: ifeq +48 -> 443
    //   398: aload 21
    //   400: checkcast 128	com/tencent/mobileqq/webview/swift/SwiftWebViewFragmentSupporter
    //   403: astore 22
    //   405: aload 22
    //   407: invokeinterface 132 1 0
    //   412: ifnull +31 -> 443
    //   415: aload 22
    //   417: invokeinterface 132 1 0
    //   422: invokevirtual 137	com/tencent/mobileqq/webview/swift/WebViewFragment:isActivityResume	()Z
    //   425: ifne +18 -> 443
    //   428: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq +11 -> 442
    //   434: ldc 144
    //   436: iconst_2
    //   437: ldc 146
    //   439: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: return
    //   443: getstatic 154	android/os/Build$VERSION:SDK_INT	I
    //   446: bipush 21
    //   448: if_icmplt +25 -> 473
    //   451: aload_0
    //   452: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   455: getfield 157	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   458: invokevirtual 162	com/tencent/mobileqq/data/MessageForDeliverGiftTips:isToAll	()Z
    //   461: ifne +6 -> 467
    //   464: goto +9 -> 473
    //   467: iconst_0
    //   468: istore 10
    //   470: goto +18 -> 488
    //   473: aload_0
    //   474: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   477: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   480: invokestatic 57	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:d	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   483: invokestatic 165	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Landroid/app/Activity;)I
    //   486: istore 10
    //   488: aload_0
    //   489: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   492: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   495: invokestatic 57	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:d	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   498: invokevirtual 169	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   501: ldc 170
    //   503: invokevirtual 176	android/content/res/Resources:getDimension	(I)F
    //   506: f2i
    //   507: istore 16
    //   509: aload_0
    //   510: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   513: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   516: invokestatic 57	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:d	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   519: invokevirtual 180	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   522: invokeinterface 186 1 0
    //   527: invokevirtual 191	android/view/Display:getWidth	()I
    //   530: istore 14
    //   532: aload_0
    //   533: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   536: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   539: invokestatic 57	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:d	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   542: invokevirtual 180	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   545: invokeinterface 186 1 0
    //   550: invokevirtual 194	android/view/Display:getHeight	()I
    //   553: iload 10
    //   555: isub
    //   556: istore 12
    //   558: aload_0
    //   559: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   562: getfield 157	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   565: invokestatic 199	com/tencent/mobileqq/troop/utils/TroopGiftUtil:e	(Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;)Ljava/util/List;
    //   568: astore 23
    //   570: aload_0
    //   571: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   574: getfield 157	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   577: invokestatic 203	com/tencent/mobileqq/troop/utils/TroopGiftUtil:f	(Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;)Ljava/lang/String;
    //   580: astore 25
    //   582: aload_0
    //   583: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   586: getfield 157	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   589: getfield 206	com/tencent/mobileqq/data/MessageForDeliverGiftTips:animationType	I
    //   592: iconst_1
    //   593: if_icmpne +55 -> 648
    //   596: aload_0
    //   597: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   600: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   603: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   606: getfield 214	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:q	I
    //   609: i2f
    //   610: getstatic 219	com/tencent/mobileqq/utils/DeviceInfoUtil:a	F
    //   613: fmul
    //   614: fconst_2
    //   615: fdiv
    //   616: f2i
    //   617: istore 7
    //   619: aload_0
    //   620: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   623: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   626: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   629: getfield 222	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:r	I
    //   632: i2f
    //   633: getstatic 219	com/tencent/mobileqq/utils/DeviceInfoUtil:a	F
    //   636: fmul
    //   637: fconst_2
    //   638: fdiv
    //   639: f2i
    //   640: istore 8
    //   642: aconst_null
    //   643: astore 22
    //   645: goto +201 -> 846
    //   648: aload 23
    //   650: invokestatic 225	com/tencent/mobileqq/troop/utils/TroopGiftUtil:a	(Ljava/util/List;)Z
    //   653: ifeq +18 -> 671
    //   656: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   659: ifeq +11 -> 670
    //   662: ldc 144
    //   664: iconst_2
    //   665: ldc 227
    //   667: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   670: return
    //   671: aload 23
    //   673: invokestatic 233	java/util/Collections:sort	(Ljava/util/List;)V
    //   676: getstatic 154	android/os/Build$VERSION:SDK_INT	I
    //   679: bipush 19
    //   681: if_icmple +15 -> 696
    //   684: aload 23
    //   686: invokeinterface 238 1 0
    //   691: istore 7
    //   693: goto +28 -> 721
    //   696: aload 23
    //   698: invokeinterface 238 1 0
    //   703: i2d
    //   704: dstore_1
    //   705: dload_1
    //   706: invokestatic 244	java/lang/Double:isNaN	(D)Z
    //   709: pop
    //   710: dload_1
    //   711: ldc2_w 245
    //   714: ddiv
    //   715: invokestatic 252	java/lang/Math:ceil	(D)D
    //   718: d2i
    //   719: istore 7
    //   721: iload 7
    //   723: anewarray 254	java/lang/String
    //   726: astore 22
    //   728: getstatic 154	android/os/Build$VERSION:SDK_INT	I
    //   731: bipush 19
    //   733: if_icmple +39 -> 772
    //   736: iconst_0
    //   737: istore 8
    //   739: iload 8
    //   741: iload 7
    //   743: if_icmpge +67 -> 810
    //   746: aload 22
    //   748: iload 8
    //   750: aload 23
    //   752: iload 8
    //   754: invokeinterface 258 2 0
    //   759: checkcast 254	java/lang/String
    //   762: aastore
    //   763: iload 8
    //   765: iconst_1
    //   766: iadd
    //   767: istore 8
    //   769: goto -30 -> 739
    //   772: iconst_0
    //   773: istore 8
    //   775: iload 8
    //   777: iload 7
    //   779: if_icmpge +31 -> 810
    //   782: aload 22
    //   784: iload 8
    //   786: aload 23
    //   788: iload 8
    //   790: iconst_2
    //   791: imul
    //   792: invokeinterface 258 2 0
    //   797: checkcast 254	java/lang/String
    //   800: aastore
    //   801: iload 8
    //   803: iconst_1
    //   804: iadd
    //   805: istore 8
    //   807: goto -32 -> 775
    //   810: aload 22
    //   812: iconst_0
    //   813: aaload
    //   814: aconst_null
    //   815: invokestatic 263	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   818: astore 23
    //   820: aload 23
    //   822: invokevirtual 266	android/graphics/Bitmap:getWidth	()I
    //   825: istore 7
    //   827: aload 23
    //   829: invokevirtual 267	android/graphics/Bitmap:getHeight	()I
    //   832: istore 8
    //   834: goto +12 -> 846
    //   837: goto +6 -> 843
    //   840: iconst_0
    //   841: istore 7
    //   843: iconst_0
    //   844: istore 8
    //   846: getstatic 154	android/os/Build$VERSION:SDK_INT	I
    //   849: bipush 21
    //   851: if_icmplt +24 -> 875
    //   854: aload_0
    //   855: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   858: getfield 157	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   861: invokevirtual 162	com/tencent/mobileqq/data/MessageForDeliverGiftTips:isToAll	()Z
    //   864: ifeq +11 -> 875
    //   867: ldc_w 268
    //   870: istore 9
    //   872: goto +7 -> 879
    //   875: bipush 8
    //   877: istore 9
    //   879: aload 21
    //   881: ifnull +18 -> 899
    //   884: aload 21
    //   886: instanceof 113
    //   889: ifeq +10 -> 899
    //   892: bipush 24
    //   894: istore 11
    //   896: goto +7 -> 903
    //   899: iload 9
    //   901: istore 11
    //   903: getstatic 154	android/os/Build$VERSION:SDK_INT	I
    //   906: bipush 19
    //   908: if_icmple +10 -> 918
    //   911: bipush 20
    //   913: istore 9
    //   915: goto +7 -> 922
    //   918: bipush 10
    //   920: istore 9
    //   922: aload_0
    //   923: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   926: getfield 157	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   929: invokevirtual 162	com/tencent/mobileqq/data/MessageForDeliverGiftTips:isToAll	()Z
    //   932: ifeq +538 -> 1470
    //   935: new 99	java/lang/StringBuilder
    //   938: dup
    //   939: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   942: astore 21
    //   944: aload 21
    //   946: aload_0
    //   947: getfield 20	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:a	Ljava/lang/String;
    //   950: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: pop
    //   954: aload 21
    //   956: ldc_w 270
    //   959: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: pop
    //   963: aload 21
    //   965: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   968: invokestatic 276	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   971: astore 21
    //   973: goto +21 -> 994
    //   976: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   979: ifeq +12 -> 991
    //   982: ldc 144
    //   984: iconst_2
    //   985: ldc_w 278
    //   988: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   991: aconst_null
    //   992: astore 21
    //   994: new 99	java/lang/StringBuilder
    //   997: dup
    //   998: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   1001: astore 23
    //   1003: aload 23
    //   1005: aload_0
    //   1006: getfield 20	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:a	Ljava/lang/String;
    //   1009: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: pop
    //   1013: aload 23
    //   1015: ldc_w 280
    //   1018: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: pop
    //   1022: aload 23
    //   1024: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1027: invokestatic 276	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1030: astore 23
    //   1032: goto +26 -> 1058
    //   1035: aload 24
    //   1037: astore 23
    //   1039: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1042: ifeq +16 -> 1058
    //   1045: ldc 144
    //   1047: iconst_2
    //   1048: ldc_w 282
    //   1051: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1054: aload 24
    //   1056: astore 23
    //   1058: new 284	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options
    //   1061: dup
    //   1062: invokespecial 285	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:<init>	()V
    //   1065: astore 24
    //   1067: aload 24
    //   1069: iload 14
    //   1071: putfield 287	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:a	I
    //   1074: aload 24
    //   1076: iload 12
    //   1078: putfield 289	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:b	I
    //   1081: iload 14
    //   1083: i2f
    //   1084: iload 7
    //   1086: i2f
    //   1087: fdiv
    //   1088: fstore 5
    //   1090: iload 12
    //   1092: i2f
    //   1093: iload 8
    //   1095: i2f
    //   1096: fdiv
    //   1097: fstore 6
    //   1099: fload 5
    //   1101: fload 6
    //   1103: fcmpl
    //   1104: ifle +13 -> 1117
    //   1107: aload 24
    //   1109: fload 5
    //   1111: putfield 291	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:c	F
    //   1114: goto +10 -> 1124
    //   1117: aload 24
    //   1119: fload 6
    //   1121: putfield 291	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:c	F
    //   1124: aload 24
    //   1126: aload_0
    //   1127: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1130: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1133: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1136: getfield 294	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:x	I
    //   1139: putfield 296	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:d	I
    //   1142: aload 24
    //   1144: aload_0
    //   1145: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1148: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1151: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1154: getfield 299	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:A	I
    //   1157: putfield 302	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:h	I
    //   1160: aload 24
    //   1162: aload_0
    //   1163: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1166: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1169: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1172: getfield 305	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:y	I
    //   1175: putfield 307	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:e	I
    //   1178: aload 24
    //   1180: aload_0
    //   1181: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1184: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1187: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1190: getfield 310	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:s	I
    //   1193: putfield 313	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:g	I
    //   1196: aload 24
    //   1198: aload_0
    //   1199: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1202: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1205: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1208: getfield 316	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:C	I
    //   1211: putfield 317	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:i	I
    //   1214: aload 24
    //   1216: aload_0
    //   1217: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1220: getfield 157	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   1223: getfield 320	com/tencent/mobileqq/data/MessageForDeliverGiftTips:senderName	Ljava/lang/String;
    //   1226: putfield 323	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:j	Ljava/lang/String;
    //   1229: aload 24
    //   1231: aload_0
    //   1232: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1235: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1238: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1241: getfield 325	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:F	Ljava/lang/String;
    //   1244: putfield 328	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:k	Ljava/lang/String;
    //   1247: aload 24
    //   1249: aload_0
    //   1250: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1253: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1256: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1259: getfield 332	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:z	Z
    //   1262: putfield 334	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:f	Z
    //   1265: aload 24
    //   1267: iload 9
    //   1269: putfield 337	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:l	I
    //   1272: new 339	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5$1
    //   1275: dup
    //   1276: aload_0
    //   1277: invokespecial 342	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5$1:<init>	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5;)V
    //   1280: astore 26
    //   1282: aload_0
    //   1283: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1286: getfield 157	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   1289: getfield 206	com/tencent/mobileqq/data/MessageForDeliverGiftTips:animationType	I
    //   1292: iconst_1
    //   1293: if_icmpne +36 -> 1329
    //   1296: aload_0
    //   1297: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1300: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1303: getfield 48	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1306: checkcast 344	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView
    //   1309: aload 23
    //   1311: aload_0
    //   1312: getfield 22	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:b	Landroid/graphics/Bitmap;
    //   1315: aload 21
    //   1317: aload 25
    //   1319: aload 26
    //   1321: aload 24
    //   1323: invokevirtual 347	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/String;Lcom/tencent/mobileqq/surfaceviewaction/gl/ImageButton$OnClickListener;Lcom/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options;)V
    //   1326: goto +33 -> 1359
    //   1329: aload_0
    //   1330: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1333: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1336: getfield 48	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1339: checkcast 344	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView
    //   1342: aload 23
    //   1344: aload_0
    //   1345: getfield 22	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:b	Landroid/graphics/Bitmap;
    //   1348: aload 21
    //   1350: aload 22
    //   1352: aload 26
    //   1354: aload 24
    //   1356: invokevirtual 350	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;[Ljava/lang/String;Lcom/tencent/mobileqq/surfaceviewaction/gl/ImageButton$OnClickListener;Lcom/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options;)V
    //   1359: new 352	android/view/WindowManager$LayoutParams
    //   1362: dup
    //   1363: iconst_m1
    //   1364: iconst_m1
    //   1365: iconst_2
    //   1366: iload 11
    //   1368: bipush 254
    //   1370: invokespecial 355	android/view/WindowManager$LayoutParams:<init>	(IIIII)V
    //   1373: astore 21
    //   1375: aload 21
    //   1377: bipush 51
    //   1379: putfield 358	android/view/WindowManager$LayoutParams:gravity	I
    //   1382: aload_0
    //   1383: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1386: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1389: invokestatic 361	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:h	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/view/WindowManager;
    //   1392: aload_0
    //   1393: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1396: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1399: getfield 364	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:b	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   1402: invokeinterface 368 2 0
    //   1407: aload_0
    //   1408: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1411: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1414: invokestatic 361	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:h	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/view/WindowManager;
    //   1417: aload_0
    //   1418: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1421: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1424: getfield 364	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:b	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   1427: aload 21
    //   1429: invokeinterface 372 3 0
    //   1434: aload_0
    //   1435: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1438: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1441: getfield 48	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1444: iconst_0
    //   1445: invokevirtual 376	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:setVisibility	(I)V
    //   1448: aload_0
    //   1449: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1452: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1455: iconst_0
    //   1456: aload_0
    //   1457: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1460: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1463: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1466: invokevirtual 379	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(ILcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   1469: return
    //   1470: aload_0
    //   1471: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1474: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1477: getfield 48	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1480: checkcast 381	com/tencent/mobileqq/troopgift/TroopGiftToPersonalSurfaceView
    //   1483: astore 21
    //   1485: aload_0
    //   1486: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1489: getfield 157	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   1492: getfield 206	com/tencent/mobileqq/data/MessageForDeliverGiftTips:animationType	I
    //   1495: iconst_1
    //   1496: if_icmpne +29 -> 1525
    //   1499: aload 21
    //   1501: aload_0
    //   1502: getfield 22	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:b	Landroid/graphics/Bitmap;
    //   1505: aload_0
    //   1506: getfield 24	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:c	Landroid/graphics/Bitmap;
    //   1509: aload_0
    //   1510: getfield 26	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:d	Landroid/graphics/Bitmap;
    //   1513: aload 25
    //   1515: iload 14
    //   1517: iload 12
    //   1519: invokevirtual 385	com/tencent/mobileqq/troopgift/TroopGiftToPersonalSurfaceView:setResourceWithFps	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/String;II)V
    //   1522: goto +24 -> 1546
    //   1525: aload 21
    //   1527: aload_0
    //   1528: getfield 22	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:b	Landroid/graphics/Bitmap;
    //   1531: aload_0
    //   1532: getfield 24	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:c	Landroid/graphics/Bitmap;
    //   1535: aload_0
    //   1536: getfield 26	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:d	Landroid/graphics/Bitmap;
    //   1539: aload 22
    //   1541: iload 9
    //   1543: invokevirtual 388	com/tencent/mobileqq/troopgift/TroopGiftToPersonalSurfaceView:setResourceWithFps	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;[Ljava/lang/String;I)V
    //   1546: iload 7
    //   1548: ifeq +694 -> 2242
    //   1551: iload 8
    //   1553: ifne +6 -> 1559
    //   1556: goto +686 -> 2242
    //   1559: aload_0
    //   1560: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1563: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1566: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1569: getfield 214	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:q	I
    //   1572: ifeq +25 -> 1597
    //   1575: aload_0
    //   1576: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1579: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1582: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1585: getfield 222	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:r	I
    //   1588: ifne +6 -> 1594
    //   1591: goto +6 -> 1597
    //   1594: goto +36 -> 1630
    //   1597: aload_0
    //   1598: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1601: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1604: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1607: iload 14
    //   1609: putfield 214	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:q	I
    //   1612: aload_0
    //   1613: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1616: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1619: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1622: iload 12
    //   1624: iload 16
    //   1626: isub
    //   1627: putfield 222	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:r	I
    //   1630: iload 8
    //   1632: iload 14
    //   1634: imul
    //   1635: iload 7
    //   1637: idiv
    //   1638: istore 8
    //   1640: iload 8
    //   1642: iload 12
    //   1644: if_icmple +20 -> 1664
    //   1647: iload 14
    //   1649: iload 12
    //   1651: imul
    //   1652: iload 8
    //   1654: idiv
    //   1655: istore 13
    //   1657: iload 12
    //   1659: istore 8
    //   1661: goto +7 -> 1668
    //   1664: iload 14
    //   1666: istore 13
    //   1668: aload_0
    //   1669: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1672: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1675: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1678: getfield 391	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:t	I
    //   1681: iload 12
    //   1683: imul
    //   1684: bipush 100
    //   1686: idiv
    //   1687: iload 8
    //   1689: iconst_2
    //   1690: idiv
    //   1691: isub
    //   1692: istore 15
    //   1694: iload 15
    //   1696: ifge +9 -> 1705
    //   1699: iconst_0
    //   1700: istore 9
    //   1702: goto +24 -> 1726
    //   1705: iload 15
    //   1707: istore 9
    //   1709: iload 15
    //   1711: iload 8
    //   1713: iadd
    //   1714: iload 12
    //   1716: if_icmple +10 -> 1726
    //   1719: iload 12
    //   1721: iload 8
    //   1723: isub
    //   1724: istore 9
    //   1726: iload 14
    //   1728: iload 13
    //   1730: isub
    //   1731: iconst_2
    //   1732: idiv
    //   1733: istore 19
    //   1735: aload_0
    //   1736: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1739: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1742: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1745: getfield 310	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:s	I
    //   1748: iload 8
    //   1750: imul
    //   1751: bipush 100
    //   1753: idiv
    //   1754: istore 17
    //   1756: aload_0
    //   1757: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1760: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1763: invokestatic 57	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:d	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   1766: ldc_w 392
    //   1769: invokestatic 397	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1772: iload 17
    //   1774: iadd
    //   1775: aload_0
    //   1776: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1779: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1782: invokestatic 57	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:d	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   1785: ldc_w 398
    //   1788: invokestatic 397	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1791: iadd
    //   1792: istore 18
    //   1794: iload 16
    //   1796: iload 18
    //   1798: iadd
    //   1799: istore 15
    //   1801: iload 8
    //   1803: istore 14
    //   1805: iload 15
    //   1807: iload 8
    //   1809: if_icmple +18 -> 1827
    //   1812: iload 8
    //   1814: istore 14
    //   1816: iload 15
    //   1818: iload 12
    //   1820: if_icmpge +7 -> 1827
    //   1823: iload 15
    //   1825: istore 14
    //   1827: aload_0
    //   1828: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1831: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1834: getfield 48	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1837: invokevirtual 402	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1840: checkcast 404	android/widget/RelativeLayout$LayoutParams
    //   1843: astore 22
    //   1845: aload 22
    //   1847: iload 13
    //   1849: putfield 407	android/widget/RelativeLayout$LayoutParams:width	I
    //   1852: aload 22
    //   1854: iload 14
    //   1856: putfield 410	android/widget/RelativeLayout$LayoutParams:height	I
    //   1859: aload 22
    //   1861: iload 19
    //   1863: putfield 413	android/widget/RelativeLayout$LayoutParams:leftMargin	I
    //   1866: aload_0
    //   1867: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1870: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1873: getfield 48	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1876: aload 22
    //   1878: invokevirtual 417	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1881: new 352	android/view/WindowManager$LayoutParams
    //   1884: dup
    //   1885: iconst_m1
    //   1886: iload 14
    //   1888: iconst_2
    //   1889: iload 11
    //   1891: bipush 254
    //   1893: invokespecial 355	android/view/WindowManager$LayoutParams:<init>	(IIIII)V
    //   1896: astore 22
    //   1898: aload 22
    //   1900: bipush 51
    //   1902: putfield 358	android/view/WindowManager$LayoutParams:gravity	I
    //   1905: aload 22
    //   1907: iconst_0
    //   1908: putfield 418	android/view/WindowManager$LayoutParams:x	I
    //   1911: aload 22
    //   1913: iload 10
    //   1915: iload 9
    //   1917: iadd
    //   1918: putfield 419	android/view/WindowManager$LayoutParams:y	I
    //   1921: iload 12
    //   1923: iconst_4
    //   1924: idiv
    //   1925: istore 8
    //   1927: aload_0
    //   1928: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1931: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1934: invokestatic 57	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:d	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   1937: ldc_w 420
    //   1940: invokestatic 397	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1943: istore 10
    //   1945: aload_0
    //   1946: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1949: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1952: getfield 423	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	Landroid/widget/ImageView;
    //   1955: invokevirtual 426	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1958: checkcast 404	android/widget/RelativeLayout$LayoutParams
    //   1961: astore 23
    //   1963: aload 23
    //   1965: iload 8
    //   1967: iload 9
    //   1969: isub
    //   1970: iload 10
    //   1972: isub
    //   1973: putfield 429	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   1976: aload_0
    //   1977: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1980: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1983: getfield 423	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	Landroid/widget/ImageView;
    //   1986: aload 23
    //   1988: invokevirtual 430	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1991: aload_0
    //   1992: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1995: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1998: invokestatic 433	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:e	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   2001: getfield 436	com/tencent/mobileqq/data/MessageForDeliverGiftTips:showCloseBtn	Z
    //   2004: ifne +18 -> 2022
    //   2007: aload_0
    //   2008: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   2011: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   2014: getfield 423	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	Landroid/widget/ImageView;
    //   2017: bipush 8
    //   2019: invokevirtual 437	android/widget/ImageView:setVisibility	(I)V
    //   2022: aload_0
    //   2023: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   2026: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   2029: invokestatic 361	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:h	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/view/WindowManager;
    //   2032: aload_0
    //   2033: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   2036: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   2039: getfield 364	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:b	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   2042: invokeinterface 368 2 0
    //   2047: aload_0
    //   2048: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   2051: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   2054: invokestatic 361	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:h	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/view/WindowManager;
    //   2057: aload_0
    //   2058: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   2061: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   2064: getfield 364	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:b	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   2067: aload 22
    //   2069: invokeinterface 372 3 0
    //   2074: aload_0
    //   2075: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   2078: getfield 157	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   2081: getfield 206	com/tencent/mobileqq/data/MessageForDeliverGiftTips:animationType	I
    //   2084: iconst_1
    //   2085: if_icmpne +9 -> 2094
    //   2088: iconst_1
    //   2089: istore 20
    //   2091: goto +6 -> 2097
    //   2094: iconst_0
    //   2095: istore 20
    //   2097: iload 13
    //   2099: i2d
    //   2100: dstore_1
    //   2101: dload_1
    //   2102: invokestatic 244	java/lang/Double:isNaN	(D)Z
    //   2105: pop
    //   2106: iload 7
    //   2108: i2d
    //   2109: dstore_3
    //   2110: dload_3
    //   2111: invokestatic 244	java/lang/Double:isNaN	(D)Z
    //   2114: pop
    //   2115: dload_1
    //   2116: dconst_1
    //   2117: dmul
    //   2118: dload_3
    //   2119: ddiv
    //   2120: d2f
    //   2121: fstore 6
    //   2123: iload 20
    //   2125: ifeq +13 -> 2138
    //   2128: getstatic 219	com/tencent/mobileqq/utils/DeviceInfoUtil:a	F
    //   2131: fconst_2
    //   2132: fdiv
    //   2133: fstore 5
    //   2135: goto +6 -> 2141
    //   2138: fconst_1
    //   2139: fstore 5
    //   2141: aload 21
    //   2143: iload 13
    //   2145: iload 14
    //   2147: fload 6
    //   2149: fload 5
    //   2151: fmul
    //   2152: iload 17
    //   2154: iload 20
    //   2156: invokevirtual 441	com/tencent/mobileqq/troopgift/TroopGiftToPersonalSurfaceView:setHeadPositionY	(IIFIZ)V
    //   2159: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2162: ifeq +57 -> 2219
    //   2165: new 99	java/lang/StringBuilder
    //   2168: dup
    //   2169: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   2172: astore 21
    //   2174: aload 21
    //   2176: ldc_w 443
    //   2179: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2182: pop
    //   2183: aload 21
    //   2185: iload 13
    //   2187: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2190: pop
    //   2191: aload 21
    //   2193: ldc_w 448
    //   2196: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2199: pop
    //   2200: aload 21
    //   2202: iload 14
    //   2204: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2207: pop
    //   2208: ldc 144
    //   2210: iconst_2
    //   2211: aload 21
    //   2213: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2216: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2219: aload_0
    //   2220: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   2223: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   2226: iload 18
    //   2228: aload_0
    //   2229: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   2232: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   2235: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:c	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   2238: invokevirtual 379	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(ILcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   2241: return
    //   2242: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2245: ifeq +12 -> 2257
    //   2248: ldc 144
    //   2250: iconst_2
    //   2251: ldc_w 450
    //   2254: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2257: aload_0
    //   2258: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   2261: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   2264: invokestatic 453	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:i	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/surfaceviewaction/gl/FrameSprite$OnFrameEndListener;
    //   2267: ifnull +30 -> 2297
    //   2270: aload_0
    //   2271: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   2274: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   2277: invokestatic 453	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:i	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/surfaceviewaction/gl/FrameSprite$OnFrameEndListener;
    //   2280: invokeinterface 457 1 0
    //   2285: aload_0
    //   2286: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:e	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   2289: getfield 43	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   2292: aconst_null
    //   2293: invokestatic 460	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;Lcom/tencent/mobileqq/surfaceviewaction/gl/FrameSprite$OnFrameEndListener;)Lcom/tencent/mobileqq/surfaceviewaction/gl/FrameSprite$OnFrameEndListener;
    //   2296: pop
    //   2297: return
    //   2298: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2301: ifeq +12 -> 2313
    //   2304: ldc 144
    //   2306: iconst_2
    //   2307: ldc_w 462
    //   2310: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2313: return
    //   2314: astore 23
    //   2316: goto -1476 -> 840
    //   2319: astore 23
    //   2321: goto -1484 -> 837
    //   2324: astore 21
    //   2326: goto -1350 -> 976
    //   2329: astore 23
    //   2331: goto -1296 -> 1035
    //   2334: astore 22
    //   2336: goto -929 -> 1407
    //   2339: astore 23
    //   2341: goto -294 -> 2047
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2344	0	this	5
    //   704	1412	1	d1	double
    //   2109	10	3	d2	double
    //   1088	1062	5	f1	float
    //   1097	1051	6	f2	float
    //   617	1490	7	i	int
    //   640	1330	8	j	int
    //   870	1100	9	k	int
    //   468	1505	10	m	int
    //   894	996	11	n	int
    //   556	1369	12	i1	int
    //   1655	531	13	i2	int
    //   530	1673	14	i3	int
    //   1692	132	15	i4	int
    //   507	1292	16	i5	int
    //   1754	399	17	i6	int
    //   1792	435	18	i7	int
    //   1733	129	19	i8	int
    //   81	2074	20	bool	boolean
    //   101	2111	21	localObject1	Object
    //   2324	1	21	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   66	2002	22	localObject2	Object
    //   2334	1	22	localException1	java.lang.Exception
    //   112	1875	23	localObject3	Object
    //   2314	1	23	localThrowable1	java.lang.Throwable
    //   2319	1	23	localThrowable2	java.lang.Throwable
    //   2329	1	23	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   2339	1	23	localException2	java.lang.Exception
    //   84	1271	24	localOptions	TroopGiftToAllSurfaceView.Options
    //   580	934	25	str	String
    //   1280	73	26	local1	TroopGiftAnimationController.6.5.1
    // Exception table:
    //   from	to	target	type
    //   810	827	2314	java/lang/Throwable
    //   827	834	2319	java/lang/Throwable
    //   935	973	2324	java/lang/OutOfMemoryError
    //   994	1032	2329	java/lang/OutOfMemoryError
    //   1382	1407	2334	java/lang/Exception
    //   2022	2047	2339	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController.6.5
 * JD-Core Version:    0.7.0.1
 */