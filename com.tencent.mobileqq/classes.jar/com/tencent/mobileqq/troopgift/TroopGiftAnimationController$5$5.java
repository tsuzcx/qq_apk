package com.tencent.mobileqq.troopgift;

import android.graphics.Bitmap;

public class TroopGiftAnimationController$5$5
  implements Runnable
{
  TroopGiftAnimationController$5$5(TroopGiftAnimationController.5 param5, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   4: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   7: getfield 46	bcqi:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   10: ifnull +37 -> 47
    //   13: aload_0
    //   14: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   17: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   20: getfield 46	bcqi:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   23: invokevirtual 52	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getVisibility	()I
    //   26: bipush 8
    //   28: if_icmpeq +19 -> 47
    //   31: aload_0
    //   32: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   35: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   38: invokestatic 55	bcqi:a	(Lbcqi;)Landroid/app/Activity;
    //   41: invokevirtual 61	android/app/Activity:isFinishing	()Z
    //   44: ifeq +18 -> 62
    //   47: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +11 -> 61
    //   53: ldc 68
    //   55: iconst_2
    //   56: ldc 70
    //   58: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: return
    //   62: aload_0
    //   63: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   66: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   69: invokestatic 55	bcqi:a	(Lbcqi;)Landroid/app/Activity;
    //   72: invokevirtual 78	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   75: invokevirtual 84	android/content/Context:getPackageName	()Ljava/lang/String;
    //   78: astore 16
    //   80: aconst_null
    //   81: astore 18
    //   83: aload_0
    //   84: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   87: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   90: invokestatic 55	bcqi:a	(Lbcqi;)Landroid/app/Activity;
    //   93: instanceof 86
    //   96: ifeq +105 -> 201
    //   99: aload_0
    //   100: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   103: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   106: invokestatic 55	bcqi:a	(Lbcqi;)Landroid/app/Activity;
    //   109: astore 15
    //   111: invokestatic 92	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   114: invokevirtual 96	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   117: checkcast 98	com/tencent/common/app/AppInterface
    //   120: astore 18
    //   122: aload 16
    //   124: astore 17
    //   126: aload 18
    //   128: astore 16
    //   130: aload 15
    //   132: ifnull +15 -> 147
    //   135: aload 16
    //   137: aload 15
    //   139: aload 17
    //   141: invokevirtual 102	com/tencent/common/app/AppInterface:isAppOnForeground	(Landroid/content/Context;Ljava/lang/String;)Z
    //   144: ifeq +42 -> 186
    //   147: aload 15
    //   149: instanceof 86
    //   152: ifeq +10 -> 162
    //   155: getstatic 105	com/tencent/mobileqq/activity/SplashActivity:jdField_a_of_type_Int	I
    //   158: iconst_2
    //   159: if_icmpne +27 -> 186
    //   162: aload 15
    //   164: instanceof 107
    //   167: ifeq +245 -> 412
    //   170: aload 15
    //   172: checkcast 107	bebt
    //   175: invokeinterface 110 1 0
    //   180: invokevirtual 114	com/tencent/mobileqq/webview/swift/WebViewFragment:b	()Z
    //   183: ifne +229 -> 412
    //   186: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq -128 -> 61
    //   192: ldc 68
    //   194: iconst_2
    //   195: ldc 116
    //   197: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: return
    //   201: aload_0
    //   202: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   205: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   208: invokestatic 55	bcqi:a	(Lbcqi;)Landroid/app/Activity;
    //   211: instanceof 118
    //   214: ifeq +127 -> 341
    //   217: aload_0
    //   218: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   221: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   224: invokestatic 55	bcqi:a	(Lbcqi;)Landroid/app/Activity;
    //   227: checkcast 118	com/tencent/mobileqq/pluginsdk/BasePluginActivity
    //   230: invokevirtual 122	com/tencent/mobileqq/pluginsdk/BasePluginActivity:getOutActivity	()Landroid/app/Activity;
    //   233: astore 17
    //   235: aload_0
    //   236: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   239: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   242: getfield 123	bcqi:jdField_a_of_type_Int	I
    //   245: iconst_2
    //   246: if_icmpne +51 -> 297
    //   249: new 125	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   256: aload 16
    //   258: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc 132
    //   263: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: astore 15
    //   271: invokestatic 92	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   274: invokevirtual 96	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   277: checkcast 98	com/tencent/common/app/AppInterface
    //   280: astore 16
    //   282: aload 15
    //   284: astore 18
    //   286: aload 17
    //   288: astore 15
    //   290: aload 18
    //   292: astore 17
    //   294: goto -164 -> 130
    //   297: aload 16
    //   299: astore 15
    //   301: aload_0
    //   302: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   305: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   308: getfield 123	bcqi:jdField_a_of_type_Int	I
    //   311: bipush 20
    //   313: if_icmpne -42 -> 271
    //   316: new 125	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   323: aload 16
    //   325: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: ldc 137
    //   330: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: astore 15
    //   338: goto -67 -> 271
    //   341: aload_0
    //   342: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   345: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   348: invokestatic 55	bcqi:a	(Lbcqi;)Landroid/app/Activity;
    //   351: instanceof 139
    //   354: ifeq +1851 -> 2205
    //   357: new 125	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   364: aload 16
    //   366: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: ldc 141
    //   371: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: astore 17
    //   379: aload_0
    //   380: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   383: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   386: invokestatic 55	bcqi:a	(Lbcqi;)Landroid/app/Activity;
    //   389: astore 15
    //   391: aload_0
    //   392: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   395: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   398: invokestatic 55	bcqi:a	(Lbcqi;)Landroid/app/Activity;
    //   401: checkcast 139	com/tencent/mobileqq/activity/QQBrowserActivity
    //   404: invokevirtual 145	com/tencent/mobileqq/activity/QQBrowserActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   407: astore 16
    //   409: goto -279 -> 130
    //   412: getstatic 150	android/os/Build$VERSION:SDK_INT	I
    //   415: bipush 21
    //   417: if_icmplt +16 -> 433
    //   420: aload_0
    //   421: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   424: getfield 153	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   427: invokevirtual 158	com/tencent/mobileqq/data/MessageForDeliverGiftTips:isToAll	()Z
    //   430: ifne +665 -> 1095
    //   433: aload_0
    //   434: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   437: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   440: invokestatic 55	bcqi:a	(Lbcqi;)Landroid/app/Activity;
    //   443: invokestatic 164	cooperation/qwallet/plugin/PropertyUtils:getStatusBarHeight	(Landroid/app/Activity;)I
    //   446: istore 6
    //   448: aload_0
    //   449: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   452: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   455: invokestatic 55	bcqi:a	(Lbcqi;)Landroid/app/Activity;
    //   458: invokevirtual 168	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   461: ldc 169
    //   463: invokevirtual 175	android/content/res/Resources:getDimension	(I)F
    //   466: f2i
    //   467: istore 11
    //   469: aload_0
    //   470: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   473: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   476: invokestatic 55	bcqi:a	(Lbcqi;)Landroid/app/Activity;
    //   479: invokevirtual 179	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   482: invokeinterface 185 1 0
    //   487: invokevirtual 190	android/view/Display:getWidth	()I
    //   490: istore 10
    //   492: aload_0
    //   493: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   496: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   499: invokestatic 55	bcqi:a	(Lbcqi;)Landroid/app/Activity;
    //   502: invokevirtual 179	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   505: invokeinterface 185 1 0
    //   510: invokevirtual 193	android/view/Display:getHeight	()I
    //   513: iload 6
    //   515: isub
    //   516: istore 9
    //   518: aload_0
    //   519: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   522: getfield 153	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   525: invokestatic 198	bckh:a	(Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;)Ljava/util/List;
    //   528: astore 17
    //   530: aconst_null
    //   531: astore 16
    //   533: aload_0
    //   534: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   537: getfield 153	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   540: invokestatic 201	bckh:d	(Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;)Ljava/lang/String;
    //   543: astore 19
    //   545: aload_0
    //   546: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   549: getfield 153	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   552: getfield 204	com/tencent/mobileqq/data/MessageForDeliverGiftTips:animationType	I
    //   555: iconst_1
    //   556: if_icmpne +545 -> 1101
    //   559: aload_0
    //   560: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   563: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   566: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   569: getfield 211	attr:d	I
    //   572: i2f
    //   573: getstatic 216	bdcb:jdField_a_of_type_Float	F
    //   576: fmul
    //   577: fconst_2
    //   578: fdiv
    //   579: f2i
    //   580: istore_3
    //   581: aload_0
    //   582: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   585: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   588: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   591: getfield 219	attr:e	I
    //   594: i2f
    //   595: getstatic 216	bdcb:jdField_a_of_type_Float	F
    //   598: fmul
    //   599: fconst_2
    //   600: fdiv
    //   601: f2i
    //   602: istore 4
    //   604: getstatic 150	android/os/Build$VERSION:SDK_INT	I
    //   607: bipush 21
    //   609: if_icmplt +679 -> 1288
    //   612: aload_0
    //   613: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   616: getfield 153	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   619: invokevirtual 158	com/tencent/mobileqq/data/MessageForDeliverGiftTips:isToAll	()Z
    //   622: ifeq +666 -> 1288
    //   625: ldc 220
    //   627: istore 5
    //   629: aload 15
    //   631: ifnull +1567 -> 2198
    //   634: aload 15
    //   636: instanceof 139
    //   639: ifeq +1559 -> 2198
    //   642: bipush 24
    //   644: istore 7
    //   646: getstatic 150	android/os/Build$VERSION:SDK_INT	I
    //   649: bipush 19
    //   651: if_icmple +644 -> 1295
    //   654: bipush 20
    //   656: istore 5
    //   658: aload_0
    //   659: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   662: getfield 153	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   665: invokevirtual 158	com/tencent/mobileqq/data/MessageForDeliverGiftTips:isToAll	()Z
    //   668: ifeq +738 -> 1406
    //   671: aconst_null
    //   672: astore 17
    //   674: new 125	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   681: aload_0
    //   682: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   685: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: ldc 222
    //   690: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: invokestatic 228	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   699: astore 15
    //   701: aconst_null
    //   702: astore 18
    //   704: new 125	java/lang/StringBuilder
    //   707: dup
    //   708: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   711: aload_0
    //   712: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   715: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: ldc 230
    //   720: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: invokestatic 228	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   729: astore 17
    //   731: new 232	bcra
    //   734: dup
    //   735: invokespecial 233	bcra:<init>	()V
    //   738: astore 18
    //   740: aload 18
    //   742: iload 10
    //   744: putfield 234	bcra:jdField_a_of_type_Int	I
    //   747: aload 18
    //   749: iload 9
    //   751: putfield 236	bcra:jdField_b_of_type_Int	I
    //   754: iload 10
    //   756: i2f
    //   757: iload_3
    //   758: i2f
    //   759: fdiv
    //   760: iload 9
    //   762: i2f
    //   763: iload 4
    //   765: i2f
    //   766: fdiv
    //   767: fcmpl
    //   768: ifle +590 -> 1358
    //   771: aload 18
    //   773: iload 10
    //   775: i2f
    //   776: iload_3
    //   777: i2f
    //   778: fdiv
    //   779: putfield 237	bcra:jdField_a_of_type_Float	F
    //   782: aload 18
    //   784: aload_0
    //   785: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   788: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   791: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   794: getfield 240	attr:i	I
    //   797: putfield 242	bcra:c	I
    //   800: aload 18
    //   802: aload_0
    //   803: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   806: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   809: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   812: getfield 245	attr:k	I
    //   815: putfield 248	bcra:jdField_f_of_type_Int	I
    //   818: aload 18
    //   820: aload_0
    //   821: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   824: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   827: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   830: getfield 251	attr:j	I
    //   833: putfield 252	bcra:d	I
    //   836: aload 18
    //   838: aload_0
    //   839: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   842: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   845: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   848: getfield 253	attr:jdField_f_of_type_Int	I
    //   851: putfield 254	bcra:e	I
    //   854: aload 18
    //   856: aload_0
    //   857: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   860: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   863: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   866: getfield 257	attr:l	I
    //   869: putfield 260	bcra:g	I
    //   872: aload 18
    //   874: aload_0
    //   875: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   878: getfield 153	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   881: getfield 263	com/tencent/mobileqq/data/MessageForDeliverGiftTips:senderName	Ljava/lang/String;
    //   884: putfield 264	bcra:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   887: aload 18
    //   889: aload_0
    //   890: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   893: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   896: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   899: getfield 267	attr:h	Ljava/lang/String;
    //   902: putfield 269	bcra:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   905: aload 18
    //   907: aload_0
    //   908: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   911: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   914: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   917: getfield 272	attr:jdField_f_of_type_Boolean	Z
    //   920: putfield 274	bcra:jdField_a_of_type_Boolean	Z
    //   923: aload 18
    //   925: iload 5
    //   927: putfield 276	bcra:h	I
    //   930: new 278	bcqr
    //   933: dup
    //   934: aload_0
    //   935: invokespecial 281	bcqr:<init>	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5;)V
    //   938: astore 20
    //   940: aload_0
    //   941: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   944: getfield 153	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   947: getfield 204	com/tencent/mobileqq/data/MessageForDeliverGiftTips:animationType	I
    //   950: iconst_1
    //   951: if_icmpne +422 -> 1373
    //   954: aload_0
    //   955: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   958: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   961: getfield 46	bcqi:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   964: checkcast 283	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView
    //   967: aload 17
    //   969: aload_0
    //   970: getfield 20	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   973: aload 15
    //   975: aload 19
    //   977: aload 20
    //   979: aload 18
    //   981: invokevirtual 286	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/String;Lbaae;Lbcra;)V
    //   984: new 288	android/view/WindowManager$LayoutParams
    //   987: dup
    //   988: iconst_m1
    //   989: iconst_m1
    //   990: iconst_2
    //   991: iload 7
    //   993: bipush 254
    //   995: invokespecial 291	android/view/WindowManager$LayoutParams:<init>	(IIIII)V
    //   998: astore 15
    //   1000: aload 15
    //   1002: bipush 51
    //   1004: putfield 294	android/view/WindowManager$LayoutParams:gravity	I
    //   1007: aload_0
    //   1008: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1011: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1014: invokestatic 297	bcqi:a	(Lbcqi;)Landroid/view/WindowManager;
    //   1017: aload_0
    //   1018: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1021: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1024: getfield 300	bcqi:jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   1027: invokeinterface 304 2 0
    //   1032: aload_0
    //   1033: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1036: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1039: invokestatic 297	bcqi:a	(Lbcqi;)Landroid/view/WindowManager;
    //   1042: aload_0
    //   1043: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1046: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1049: getfield 300	bcqi:jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   1052: aload 15
    //   1054: invokeinterface 308 3 0
    //   1059: aload_0
    //   1060: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1063: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1066: getfield 46	bcqi:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1069: iconst_0
    //   1070: invokevirtual 312	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:setVisibility	(I)V
    //   1073: aload_0
    //   1074: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1077: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1080: iconst_0
    //   1081: aload_0
    //   1082: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1085: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1088: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   1091: invokevirtual 315	bcqi:a	(ILattr;)V
    //   1094: return
    //   1095: iconst_0
    //   1096: istore 6
    //   1098: goto -650 -> 448
    //   1101: aload 17
    //   1103: invokestatic 318	bckh:a	(Ljava/util/List;)Z
    //   1106: ifeq +19 -> 1125
    //   1109: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1112: ifeq -1051 -> 61
    //   1115: ldc 68
    //   1117: iconst_2
    //   1118: ldc_w 320
    //   1121: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1124: return
    //   1125: aload 17
    //   1127: invokestatic 326	java/util/Collections:sort	(Ljava/util/List;)V
    //   1130: getstatic 150	android/os/Build$VERSION:SDK_INT	I
    //   1133: bipush 19
    //   1135: if_icmple +60 -> 1195
    //   1138: aload 17
    //   1140: invokeinterface 331 1 0
    //   1145: istore_3
    //   1146: iload_3
    //   1147: anewarray 333	java/lang/String
    //   1150: astore 16
    //   1152: getstatic 150	android/os/Build$VERSION:SDK_INT	I
    //   1155: bipush 19
    //   1157: if_icmple +58 -> 1215
    //   1160: iconst_0
    //   1161: istore 4
    //   1163: iload 4
    //   1165: iload_3
    //   1166: if_icmpge +86 -> 1252
    //   1169: aload 16
    //   1171: iload 4
    //   1173: aload 17
    //   1175: iload 4
    //   1177: invokeinterface 337 2 0
    //   1182: checkcast 333	java/lang/String
    //   1185: aastore
    //   1186: iload 4
    //   1188: iconst_1
    //   1189: iadd
    //   1190: istore 4
    //   1192: goto -29 -> 1163
    //   1195: aload 17
    //   1197: invokeinterface 331 1 0
    //   1202: i2d
    //   1203: ldc2_w 338
    //   1206: ddiv
    //   1207: invokestatic 345	java/lang/Math:ceil	(D)D
    //   1210: d2i
    //   1211: istore_3
    //   1212: goto -66 -> 1146
    //   1215: iconst_0
    //   1216: istore 4
    //   1218: iload 4
    //   1220: iload_3
    //   1221: if_icmpge +31 -> 1252
    //   1224: aload 16
    //   1226: iload 4
    //   1228: aload 17
    //   1230: iload 4
    //   1232: iconst_2
    //   1233: imul
    //   1234: invokeinterface 337 2 0
    //   1239: checkcast 333	java/lang/String
    //   1242: aastore
    //   1243: iload 4
    //   1245: iconst_1
    //   1246: iadd
    //   1247: istore 4
    //   1249: goto -31 -> 1218
    //   1252: aload 16
    //   1254: iconst_0
    //   1255: aaload
    //   1256: aconst_null
    //   1257: invokestatic 350	bdda:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1260: astore 17
    //   1262: aload 17
    //   1264: invokevirtual 353	android/graphics/Bitmap:getWidth	()I
    //   1267: istore_3
    //   1268: aload 17
    //   1270: invokevirtual 354	android/graphics/Bitmap:getHeight	()I
    //   1273: istore 4
    //   1275: goto -671 -> 604
    //   1278: astore 17
    //   1280: iconst_0
    //   1281: istore_3
    //   1282: iconst_0
    //   1283: istore 4
    //   1285: goto -681 -> 604
    //   1288: bipush 8
    //   1290: istore 5
    //   1292: goto -663 -> 629
    //   1295: bipush 10
    //   1297: istore 5
    //   1299: goto -641 -> 658
    //   1302: astore 15
    //   1304: aload 17
    //   1306: astore 15
    //   1308: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1311: ifeq -610 -> 701
    //   1314: ldc 68
    //   1316: iconst_2
    //   1317: ldc_w 356
    //   1320: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1323: aload 17
    //   1325: astore 15
    //   1327: goto -626 -> 701
    //   1330: astore 17
    //   1332: aload 18
    //   1334: astore 17
    //   1336: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1339: ifeq -608 -> 731
    //   1342: ldc 68
    //   1344: iconst_2
    //   1345: ldc_w 358
    //   1348: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1351: aload 18
    //   1353: astore 17
    //   1355: goto -624 -> 731
    //   1358: aload 18
    //   1360: iload 9
    //   1362: i2f
    //   1363: iload 4
    //   1365: i2f
    //   1366: fdiv
    //   1367: putfield 237	bcra:jdField_a_of_type_Float	F
    //   1370: goto -588 -> 782
    //   1373: aload_0
    //   1374: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1377: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1380: getfield 46	bcqi:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1383: checkcast 283	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView
    //   1386: aload 17
    //   1388: aload_0
    //   1389: getfield 20	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1392: aload 15
    //   1394: aload 16
    //   1396: aload 20
    //   1398: aload 18
    //   1400: invokevirtual 361	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;[Ljava/lang/String;Lbaae;Lbcra;)V
    //   1403: goto -419 -> 984
    //   1406: aload_0
    //   1407: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1410: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1413: getfield 46	bcqi:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1416: checkcast 363	com/tencent/mobileqq/troopgift/TroopGiftToPersonalSurfaceView
    //   1419: astore 15
    //   1421: aload_0
    //   1422: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1425: getfield 153	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   1428: getfield 204	com/tencent/mobileqq/data/MessageForDeliverGiftTips:animationType	I
    //   1431: iconst_1
    //   1432: if_icmpne +91 -> 1523
    //   1435: aload 15
    //   1437: aload_0
    //   1438: getfield 20	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1441: aload_0
    //   1442: getfield 22	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:b	Landroid/graphics/Bitmap;
    //   1445: aload_0
    //   1446: getfield 24	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:c	Landroid/graphics/Bitmap;
    //   1449: aload 19
    //   1451: iload 10
    //   1453: iload 9
    //   1455: invokevirtual 367	com/tencent/mobileqq/troopgift/TroopGiftToPersonalSurfaceView:setResourceWithFps	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/String;II)V
    //   1458: iload_3
    //   1459: ifeq +8 -> 1467
    //   1462: iload 4
    //   1464: ifne +83 -> 1547
    //   1467: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1470: ifeq +12 -> 1482
    //   1473: ldc 68
    //   1475: iconst_2
    //   1476: ldc_w 369
    //   1479: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1482: aload_0
    //   1483: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1486: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1489: invokestatic 372	bcqi:a	(Lbcqi;)Lbaaa;
    //   1492: ifnull -1431 -> 61
    //   1495: aload_0
    //   1496: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1499: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1502: invokestatic 372	bcqi:a	(Lbcqi;)Lbaaa;
    //   1505: invokeinterface 376 1 0
    //   1510: aload_0
    //   1511: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1514: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1517: aconst_null
    //   1518: invokestatic 379	bcqi:a	(Lbcqi;Lbaaa;)Lbaaa;
    //   1521: pop
    //   1522: return
    //   1523: aload 15
    //   1525: aload_0
    //   1526: getfield 20	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1529: aload_0
    //   1530: getfield 22	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:b	Landroid/graphics/Bitmap;
    //   1533: aload_0
    //   1534: getfield 24	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:c	Landroid/graphics/Bitmap;
    //   1537: aload 16
    //   1539: iload 5
    //   1541: invokevirtual 382	com/tencent/mobileqq/troopgift/TroopGiftToPersonalSurfaceView:setResourceWithFps	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;[Ljava/lang/String;I)V
    //   1544: goto -86 -> 1458
    //   1547: aload_0
    //   1548: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1551: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1554: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   1557: getfield 211	attr:d	I
    //   1560: ifeq +19 -> 1579
    //   1563: aload_0
    //   1564: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1567: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1570: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   1573: getfield 219	attr:e	I
    //   1576: ifne +36 -> 1612
    //   1579: aload_0
    //   1580: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1583: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1586: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   1589: iload 10
    //   1591: putfield 211	attr:d	I
    //   1594: aload_0
    //   1595: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1598: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1601: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   1604: iload 9
    //   1606: iload 11
    //   1608: isub
    //   1609: putfield 219	attr:e	I
    //   1612: iload 4
    //   1614: iload 10
    //   1616: imul
    //   1617: iload_3
    //   1618: idiv
    //   1619: istore 4
    //   1621: iload 4
    //   1623: iload 9
    //   1625: if_icmple +566 -> 2191
    //   1628: iload 10
    //   1630: iload 9
    //   1632: imul
    //   1633: iload 4
    //   1635: idiv
    //   1636: istore 8
    //   1638: iload 9
    //   1640: istore 4
    //   1642: aload_0
    //   1643: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1646: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1649: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   1652: getfield 383	attr:g	I
    //   1655: iload 9
    //   1657: imul
    //   1658: bipush 100
    //   1660: idiv
    //   1661: iload 4
    //   1663: iconst_2
    //   1664: idiv
    //   1665: isub
    //   1666: istore 5
    //   1668: iload 5
    //   1670: ifge +469 -> 2139
    //   1673: iconst_0
    //   1674: istore 5
    //   1676: iload 10
    //   1678: iload 8
    //   1680: isub
    //   1681: iconst_2
    //   1682: idiv
    //   1683: istore 13
    //   1685: aload_0
    //   1686: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1689: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1692: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   1695: getfield 253	attr:jdField_f_of_type_Int	I
    //   1698: iload 4
    //   1700: imul
    //   1701: bipush 100
    //   1703: idiv
    //   1704: istore 10
    //   1706: aload_0
    //   1707: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1710: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1713: invokestatic 55	bcqi:a	(Lbcqi;)Landroid/app/Activity;
    //   1716: ldc_w 384
    //   1719: invokestatic 389	bcwh:a	(Landroid/content/Context;F)I
    //   1722: iload 10
    //   1724: iadd
    //   1725: aload_0
    //   1726: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1729: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1732: invokestatic 55	bcqi:a	(Lbcqi;)Landroid/app/Activity;
    //   1735: ldc_w 390
    //   1738: invokestatic 389	bcwh:a	(Landroid/content/Context;F)I
    //   1741: iadd
    //   1742: istore 12
    //   1744: iload 12
    //   1746: iload 11
    //   1748: iadd
    //   1749: iload 4
    //   1751: if_icmple +434 -> 2185
    //   1754: iload 12
    //   1756: iload 11
    //   1758: iadd
    //   1759: iload 9
    //   1761: if_icmpge +424 -> 2185
    //   1764: iload 12
    //   1766: iload 11
    //   1768: iadd
    //   1769: istore 4
    //   1771: aload_0
    //   1772: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1775: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1778: getfield 46	bcqi:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1781: invokevirtual 394	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1784: checkcast 396	android/widget/RelativeLayout$LayoutParams
    //   1787: astore 16
    //   1789: aload 16
    //   1791: iload 8
    //   1793: putfield 399	android/widget/RelativeLayout$LayoutParams:width	I
    //   1796: aload 16
    //   1798: iload 4
    //   1800: putfield 402	android/widget/RelativeLayout$LayoutParams:height	I
    //   1803: aload 16
    //   1805: iload 13
    //   1807: putfield 405	android/widget/RelativeLayout$LayoutParams:leftMargin	I
    //   1810: aload_0
    //   1811: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1814: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1817: getfield 46	bcqi:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1820: aload 16
    //   1822: invokevirtual 409	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1825: new 288	android/view/WindowManager$LayoutParams
    //   1828: dup
    //   1829: iconst_m1
    //   1830: iload 4
    //   1832: iconst_2
    //   1833: iload 7
    //   1835: bipush 254
    //   1837: invokespecial 291	android/view/WindowManager$LayoutParams:<init>	(IIIII)V
    //   1840: astore 16
    //   1842: aload 16
    //   1844: bipush 51
    //   1846: putfield 294	android/view/WindowManager$LayoutParams:gravity	I
    //   1849: aload 16
    //   1851: iconst_0
    //   1852: putfield 412	android/view/WindowManager$LayoutParams:x	I
    //   1855: aload 16
    //   1857: iload 5
    //   1859: iload 6
    //   1861: iadd
    //   1862: putfield 415	android/view/WindowManager$LayoutParams:y	I
    //   1865: iload 9
    //   1867: iconst_4
    //   1868: idiv
    //   1869: istore 6
    //   1871: aload_0
    //   1872: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1875: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1878: invokestatic 55	bcqi:a	(Lbcqi;)Landroid/app/Activity;
    //   1881: ldc_w 416
    //   1884: invokestatic 389	bcwh:a	(Landroid/content/Context;F)I
    //   1887: istore 7
    //   1889: aload_0
    //   1890: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1893: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1896: getfield 419	bcqi:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1899: invokevirtual 422	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1902: checkcast 396	android/widget/RelativeLayout$LayoutParams
    //   1905: astore 17
    //   1907: aload 17
    //   1909: iload 6
    //   1911: iload 5
    //   1913: isub
    //   1914: iload 7
    //   1916: isub
    //   1917: putfield 425	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   1920: aload_0
    //   1921: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1924: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1927: getfield 419	bcqi:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1930: aload 17
    //   1932: invokevirtual 426	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1935: aload_0
    //   1936: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1939: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1942: invokestatic 429	bcqi:a	(Lbcqi;)Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   1945: getfield 432	com/tencent/mobileqq/data/MessageForDeliverGiftTips:showCloseBtn	Z
    //   1948: ifne +18 -> 1966
    //   1951: aload_0
    //   1952: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1955: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1958: getfield 419	bcqi:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1961: bipush 8
    //   1963: invokevirtual 433	android/widget/ImageView:setVisibility	(I)V
    //   1966: aload_0
    //   1967: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1970: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1973: invokestatic 297	bcqi:a	(Lbcqi;)Landroid/view/WindowManager;
    //   1976: aload_0
    //   1977: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1980: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1983: getfield 300	bcqi:jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   1986: invokeinterface 304 2 0
    //   1991: aload_0
    //   1992: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1995: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   1998: invokestatic 297	bcqi:a	(Lbcqi;)Landroid/view/WindowManager;
    //   2001: aload_0
    //   2002: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   2005: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   2008: getfield 300	bcqi:jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   2011: aload 16
    //   2013: invokeinterface 308 3 0
    //   2018: aload_0
    //   2019: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   2022: getfield 153	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   2025: getfield 204	com/tencent/mobileqq/data/MessageForDeliverGiftTips:animationType	I
    //   2028: iconst_1
    //   2029: if_icmpne +130 -> 2159
    //   2032: iconst_1
    //   2033: istore 14
    //   2035: iload 8
    //   2037: i2d
    //   2038: dconst_1
    //   2039: dmul
    //   2040: iload_3
    //   2041: i2d
    //   2042: ddiv
    //   2043: d2f
    //   2044: fstore_2
    //   2045: iload 14
    //   2047: ifeq +118 -> 2165
    //   2050: getstatic 216	bdcb:jdField_a_of_type_Float	F
    //   2053: fconst_2
    //   2054: fdiv
    //   2055: fstore_1
    //   2056: aload 15
    //   2058: iload 8
    //   2060: iload 4
    //   2062: fload_2
    //   2063: fload_1
    //   2064: fmul
    //   2065: iload 10
    //   2067: iload 14
    //   2069: invokevirtual 437	com/tencent/mobileqq/troopgift/TroopGiftToPersonalSurfaceView:setHeadPositionY	(IIFIZ)V
    //   2072: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2075: ifeq +41 -> 2116
    //   2078: ldc 68
    //   2080: iconst_2
    //   2081: new 125	java/lang/StringBuilder
    //   2084: dup
    //   2085: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   2088: ldc_w 439
    //   2091: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2094: iload 8
    //   2096: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2099: ldc_w 444
    //   2102: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2105: iload 4
    //   2107: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2110: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2113: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2116: aload_0
    //   2117: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   2120: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   2123: iload 12
    //   2125: aload_0
    //   2126: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   2129: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbcqi;
    //   2132: invokestatic 207	bcqi:a	(Lbcqi;)Lattr;
    //   2135: invokevirtual 315	bcqi:a	(ILattr;)V
    //   2138: return
    //   2139: iload 5
    //   2141: iload 4
    //   2143: iadd
    //   2144: iload 9
    //   2146: if_icmple +42 -> 2188
    //   2149: iload 9
    //   2151: iload 4
    //   2153: isub
    //   2154: istore 5
    //   2156: goto -480 -> 1676
    //   2159: iconst_0
    //   2160: istore 14
    //   2162: goto -127 -> 2035
    //   2165: fconst_1
    //   2166: fstore_1
    //   2167: goto -111 -> 2056
    //   2170: astore 17
    //   2172: goto -181 -> 1991
    //   2175: astore 16
    //   2177: goto -1145 -> 1032
    //   2180: astore 17
    //   2182: goto -900 -> 1282
    //   2185: goto -414 -> 1771
    //   2188: goto -512 -> 1676
    //   2191: iload 10
    //   2193: istore 8
    //   2195: goto -553 -> 1642
    //   2198: iload 5
    //   2200: istore 7
    //   2202: goto -1556 -> 646
    //   2205: aconst_null
    //   2206: astore 15
    //   2208: aload 16
    //   2210: astore 17
    //   2212: aload 18
    //   2214: astore 16
    //   2216: goto -2086 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2219	0	this	5
    //   2055	112	1	f1	float
    //   2044	19	2	f2	float
    //   580	1461	3	i	int
    //   602	1552	4	j	int
    //   627	1572	5	k	int
    //   446	1468	6	m	int
    //   644	1557	7	n	int
    //   1636	558	8	i1	int
    //   516	1638	9	i2	int
    //   490	1702	10	i3	int
    //   467	1302	11	i4	int
    //   1742	382	12	i5	int
    //   1683	123	13	i6	int
    //   2033	128	14	bool	boolean
    //   109	944	15	localObject1	Object
    //   1302	1	15	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1306	901	15	localObject2	Object
    //   78	1934	16	localObject3	Object
    //   2175	34	16	localException1	java.lang.Exception
    //   2214	1	16	localObject4	Object
    //   124	1145	17	localObject5	Object
    //   1278	46	17	localThrowable1	java.lang.Throwable
    //   1330	1	17	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1334	597	17	localObject6	Object
    //   2170	1	17	localException2	java.lang.Exception
    //   2180	1	17	localThrowable2	java.lang.Throwable
    //   2210	1	17	localException3	java.lang.Exception
    //   81	2132	18	localObject7	Object
    //   543	907	19	str	String
    //   938	459	20	localbcqr	bcqr
    // Exception table:
    //   from	to	target	type
    //   1252	1268	1278	java/lang/Throwable
    //   674	701	1302	java/lang/OutOfMemoryError
    //   704	731	1330	java/lang/OutOfMemoryError
    //   1966	1991	2170	java/lang/Exception
    //   1007	1032	2175	java/lang/Exception
    //   1268	1275	2180	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5.5
 * JD-Core Version:    0.7.0.1
 */