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
    //   4: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   7: getfield 46	bfip:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   10: ifnull +37 -> 47
    //   13: aload_0
    //   14: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   17: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   20: getfield 46	bfip:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   23: invokevirtual 52	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getVisibility	()I
    //   26: bipush 8
    //   28: if_icmpeq +19 -> 47
    //   31: aload_0
    //   32: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   35: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   38: invokestatic 55	bfip:a	(Lbfip;)Landroid/app/Activity;
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
    //   66: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   69: invokestatic 55	bfip:a	(Lbfip;)Landroid/app/Activity;
    //   72: invokevirtual 78	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   75: invokevirtual 84	android/content/Context:getPackageName	()Ljava/lang/String;
    //   78: astore 16
    //   80: aconst_null
    //   81: astore 18
    //   83: aload_0
    //   84: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   87: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   90: invokestatic 55	bfip:a	(Lbfip;)Landroid/app/Activity;
    //   93: instanceof 86
    //   96: ifeq +118 -> 214
    //   99: aload_0
    //   100: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   103: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   106: invokestatic 55	bfip:a	(Lbfip;)Landroid/app/Activity;
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
    //   144: ifeq +55 -> 199
    //   147: aload 15
    //   149: instanceof 86
    //   152: ifeq +10 -> 162
    //   155: getstatic 105	com/tencent/mobileqq/activity/SplashActivity:jdField_a_of_type_Int	I
    //   158: iconst_2
    //   159: if_icmpne +40 -> 199
    //   162: aload 15
    //   164: instanceof 107
    //   167: ifeq +258 -> 425
    //   170: aload 15
    //   172: checkcast 107	bguf
    //   175: invokeinterface 110 1 0
    //   180: ifnull +245 -> 425
    //   183: aload 15
    //   185: checkcast 107	bguf
    //   188: invokeinterface 110 1 0
    //   193: invokevirtual 115	com/tencent/mobileqq/webview/swift/WebViewFragment:isActivityResume	()Z
    //   196: ifne +229 -> 425
    //   199: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq -141 -> 61
    //   205: ldc 68
    //   207: iconst_2
    //   208: ldc 117
    //   210: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: return
    //   214: aload_0
    //   215: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   218: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   221: invokestatic 55	bfip:a	(Lbfip;)Landroid/app/Activity;
    //   224: instanceof 119
    //   227: ifeq +127 -> 354
    //   230: aload_0
    //   231: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   234: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   237: invokestatic 55	bfip:a	(Lbfip;)Landroid/app/Activity;
    //   240: checkcast 119	com/tencent/mobileqq/pluginsdk/BasePluginActivity
    //   243: invokevirtual 123	com/tencent/mobileqq/pluginsdk/BasePluginActivity:getOutActivity	()Landroid/app/Activity;
    //   246: astore 17
    //   248: aload_0
    //   249: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   252: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   255: getfield 124	bfip:jdField_a_of_type_Int	I
    //   258: iconst_2
    //   259: if_icmpne +51 -> 310
    //   262: new 126	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   269: aload 16
    //   271: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc 133
    //   276: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: astore 15
    //   284: invokestatic 92	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   287: invokevirtual 96	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   290: checkcast 98	com/tencent/common/app/AppInterface
    //   293: astore 16
    //   295: aload 15
    //   297: astore 18
    //   299: aload 17
    //   301: astore 15
    //   303: aload 18
    //   305: astore 17
    //   307: goto -177 -> 130
    //   310: aload 16
    //   312: astore 15
    //   314: aload_0
    //   315: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   318: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   321: getfield 124	bfip:jdField_a_of_type_Int	I
    //   324: bipush 20
    //   326: if_icmpne -42 -> 284
    //   329: new 126	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   336: aload 16
    //   338: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: ldc 138
    //   343: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: astore 15
    //   351: goto -67 -> 284
    //   354: aload_0
    //   355: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   358: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   361: invokestatic 55	bfip:a	(Lbfip;)Landroid/app/Activity;
    //   364: instanceof 140
    //   367: ifeq +1851 -> 2218
    //   370: new 126	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   377: aload 16
    //   379: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: ldc 142
    //   384: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: astore 17
    //   392: aload_0
    //   393: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   396: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   399: invokestatic 55	bfip:a	(Lbfip;)Landroid/app/Activity;
    //   402: astore 15
    //   404: aload_0
    //   405: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   408: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   411: invokestatic 55	bfip:a	(Lbfip;)Landroid/app/Activity;
    //   414: checkcast 140	com/tencent/mobileqq/activity/QQBrowserActivity
    //   417: invokevirtual 146	com/tencent/mobileqq/activity/QQBrowserActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   420: astore 16
    //   422: goto -292 -> 130
    //   425: getstatic 151	android/os/Build$VERSION:SDK_INT	I
    //   428: bipush 21
    //   430: if_icmplt +16 -> 446
    //   433: aload_0
    //   434: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   437: getfield 154	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   440: invokevirtual 159	com/tencent/mobileqq/data/MessageForDeliverGiftTips:isToAll	()Z
    //   443: ifne +665 -> 1108
    //   446: aload_0
    //   447: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   450: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   453: invokestatic 55	bfip:a	(Lbfip;)Landroid/app/Activity;
    //   456: invokestatic 165	cooperation/qwallet/plugin/PropertyUtils:getStatusBarHeight	(Landroid/app/Activity;)I
    //   459: istore 6
    //   461: aload_0
    //   462: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   465: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   468: invokestatic 55	bfip:a	(Lbfip;)Landroid/app/Activity;
    //   471: invokevirtual 169	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   474: ldc 170
    //   476: invokevirtual 176	android/content/res/Resources:getDimension	(I)F
    //   479: f2i
    //   480: istore 11
    //   482: aload_0
    //   483: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   486: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   489: invokestatic 55	bfip:a	(Lbfip;)Landroid/app/Activity;
    //   492: invokevirtual 180	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   495: invokeinterface 186 1 0
    //   500: invokevirtual 191	android/view/Display:getWidth	()I
    //   503: istore 10
    //   505: aload_0
    //   506: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   509: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   512: invokestatic 55	bfip:a	(Lbfip;)Landroid/app/Activity;
    //   515: invokevirtual 180	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   518: invokeinterface 186 1 0
    //   523: invokevirtual 194	android/view/Display:getHeight	()I
    //   526: iload 6
    //   528: isub
    //   529: istore 9
    //   531: aload_0
    //   532: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   535: getfield 154	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   538: invokestatic 199	bfcv:a	(Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;)Ljava/util/List;
    //   541: astore 17
    //   543: aconst_null
    //   544: astore 16
    //   546: aload_0
    //   547: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   550: getfield 154	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   553: invokestatic 202	bfcv:d	(Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;)Ljava/lang/String;
    //   556: astore 19
    //   558: aload_0
    //   559: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   562: getfield 154	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   565: getfield 205	com/tencent/mobileqq/data/MessageForDeliverGiftTips:animationType	I
    //   568: iconst_1
    //   569: if_icmpne +545 -> 1114
    //   572: aload_0
    //   573: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   576: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   579: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   582: getfield 212	avli:d	I
    //   585: i2f
    //   586: getstatic 218	com/tencent/mobileqq/utils/DeviceInfoUtil:density	F
    //   589: fmul
    //   590: fconst_2
    //   591: fdiv
    //   592: f2i
    //   593: istore_3
    //   594: aload_0
    //   595: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   598: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   601: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   604: getfield 221	avli:e	I
    //   607: i2f
    //   608: getstatic 218	com/tencent/mobileqq/utils/DeviceInfoUtil:density	F
    //   611: fmul
    //   612: fconst_2
    //   613: fdiv
    //   614: f2i
    //   615: istore 4
    //   617: getstatic 151	android/os/Build$VERSION:SDK_INT	I
    //   620: bipush 21
    //   622: if_icmplt +679 -> 1301
    //   625: aload_0
    //   626: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   629: getfield 154	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   632: invokevirtual 159	com/tencent/mobileqq/data/MessageForDeliverGiftTips:isToAll	()Z
    //   635: ifeq +666 -> 1301
    //   638: ldc 222
    //   640: istore 5
    //   642: aload 15
    //   644: ifnull +1567 -> 2211
    //   647: aload 15
    //   649: instanceof 140
    //   652: ifeq +1559 -> 2211
    //   655: bipush 24
    //   657: istore 7
    //   659: getstatic 151	android/os/Build$VERSION:SDK_INT	I
    //   662: bipush 19
    //   664: if_icmple +644 -> 1308
    //   667: bipush 20
    //   669: istore 5
    //   671: aload_0
    //   672: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   675: getfield 154	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   678: invokevirtual 159	com/tencent/mobileqq/data/MessageForDeliverGiftTips:isToAll	()Z
    //   681: ifeq +738 -> 1419
    //   684: aconst_null
    //   685: astore 17
    //   687: new 126	java/lang/StringBuilder
    //   690: dup
    //   691: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   694: aload_0
    //   695: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   698: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: ldc 224
    //   703: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 230	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   712: astore 15
    //   714: aconst_null
    //   715: astore 18
    //   717: new 126	java/lang/StringBuilder
    //   720: dup
    //   721: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   724: aload_0
    //   725: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   728: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: ldc 232
    //   733: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   739: invokestatic 230	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   742: astore 17
    //   744: new 234	bfjh
    //   747: dup
    //   748: invokespecial 235	bfjh:<init>	()V
    //   751: astore 18
    //   753: aload 18
    //   755: iload 10
    //   757: putfield 236	bfjh:jdField_a_of_type_Int	I
    //   760: aload 18
    //   762: iload 9
    //   764: putfield 238	bfjh:jdField_b_of_type_Int	I
    //   767: iload 10
    //   769: i2f
    //   770: iload_3
    //   771: i2f
    //   772: fdiv
    //   773: iload 9
    //   775: i2f
    //   776: iload 4
    //   778: i2f
    //   779: fdiv
    //   780: fcmpl
    //   781: ifle +590 -> 1371
    //   784: aload 18
    //   786: iload 10
    //   788: i2f
    //   789: iload_3
    //   790: i2f
    //   791: fdiv
    //   792: putfield 240	bfjh:jdField_a_of_type_Float	F
    //   795: aload 18
    //   797: aload_0
    //   798: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   801: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   804: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   807: getfield 243	avli:i	I
    //   810: putfield 245	bfjh:c	I
    //   813: aload 18
    //   815: aload_0
    //   816: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   819: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   822: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   825: getfield 248	avli:k	I
    //   828: putfield 251	bfjh:jdField_f_of_type_Int	I
    //   831: aload 18
    //   833: aload_0
    //   834: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   837: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   840: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   843: getfield 254	avli:j	I
    //   846: putfield 255	bfjh:d	I
    //   849: aload 18
    //   851: aload_0
    //   852: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   855: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   858: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   861: getfield 256	avli:jdField_f_of_type_Int	I
    //   864: putfield 257	bfjh:e	I
    //   867: aload 18
    //   869: aload_0
    //   870: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   873: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   876: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   879: getfield 260	avli:l	I
    //   882: putfield 263	bfjh:g	I
    //   885: aload 18
    //   887: aload_0
    //   888: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   891: getfield 154	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   894: getfield 266	com/tencent/mobileqq/data/MessageForDeliverGiftTips:senderName	Ljava/lang/String;
    //   897: putfield 267	bfjh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   900: aload 18
    //   902: aload_0
    //   903: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   906: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   909: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   912: getfield 270	avli:h	Ljava/lang/String;
    //   915: putfield 272	bfjh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   918: aload 18
    //   920: aload_0
    //   921: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   924: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   927: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   930: getfield 275	avli:jdField_f_of_type_Boolean	Z
    //   933: putfield 277	bfjh:jdField_a_of_type_Boolean	Z
    //   936: aload 18
    //   938: iload 5
    //   940: putfield 279	bfjh:h	I
    //   943: new 281	bfiy
    //   946: dup
    //   947: aload_0
    //   948: invokespecial 284	bfiy:<init>	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5;)V
    //   951: astore 20
    //   953: aload_0
    //   954: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   957: getfield 154	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   960: getfield 205	com/tencent/mobileqq/data/MessageForDeliverGiftTips:animationType	I
    //   963: iconst_1
    //   964: if_icmpne +422 -> 1386
    //   967: aload_0
    //   968: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   971: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   974: getfield 46	bfip:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   977: checkcast 286	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView
    //   980: aload 17
    //   982: aload_0
    //   983: getfield 20	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   986: aload 15
    //   988: aload 19
    //   990: aload 20
    //   992: aload 18
    //   994: invokevirtual 289	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/String;Lbcsd;Lbfjh;)V
    //   997: new 291	android/view/WindowManager$LayoutParams
    //   1000: dup
    //   1001: iconst_m1
    //   1002: iconst_m1
    //   1003: iconst_2
    //   1004: iload 7
    //   1006: bipush 254
    //   1008: invokespecial 294	android/view/WindowManager$LayoutParams:<init>	(IIIII)V
    //   1011: astore 15
    //   1013: aload 15
    //   1015: bipush 51
    //   1017: putfield 297	android/view/WindowManager$LayoutParams:gravity	I
    //   1020: aload_0
    //   1021: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1024: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1027: invokestatic 300	bfip:a	(Lbfip;)Landroid/view/WindowManager;
    //   1030: aload_0
    //   1031: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1034: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1037: getfield 303	bfip:jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   1040: invokeinterface 307 2 0
    //   1045: aload_0
    //   1046: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1049: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1052: invokestatic 300	bfip:a	(Lbfip;)Landroid/view/WindowManager;
    //   1055: aload_0
    //   1056: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1059: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1062: getfield 303	bfip:jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   1065: aload 15
    //   1067: invokeinterface 311 3 0
    //   1072: aload_0
    //   1073: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1076: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1079: getfield 46	bfip:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1082: iconst_0
    //   1083: invokevirtual 315	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:setVisibility	(I)V
    //   1086: aload_0
    //   1087: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1090: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1093: iconst_0
    //   1094: aload_0
    //   1095: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1098: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1101: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   1104: invokevirtual 318	bfip:a	(ILavli;)V
    //   1107: return
    //   1108: iconst_0
    //   1109: istore 6
    //   1111: goto -650 -> 461
    //   1114: aload 17
    //   1116: invokestatic 321	bfcv:a	(Ljava/util/List;)Z
    //   1119: ifeq +19 -> 1138
    //   1122: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1125: ifeq -1064 -> 61
    //   1128: ldc 68
    //   1130: iconst_2
    //   1131: ldc_w 323
    //   1134: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1137: return
    //   1138: aload 17
    //   1140: invokestatic 329	java/util/Collections:sort	(Ljava/util/List;)V
    //   1143: getstatic 151	android/os/Build$VERSION:SDK_INT	I
    //   1146: bipush 19
    //   1148: if_icmple +60 -> 1208
    //   1151: aload 17
    //   1153: invokeinterface 334 1 0
    //   1158: istore_3
    //   1159: iload_3
    //   1160: anewarray 336	java/lang/String
    //   1163: astore 16
    //   1165: getstatic 151	android/os/Build$VERSION:SDK_INT	I
    //   1168: bipush 19
    //   1170: if_icmple +58 -> 1228
    //   1173: iconst_0
    //   1174: istore 4
    //   1176: iload 4
    //   1178: iload_3
    //   1179: if_icmpge +86 -> 1265
    //   1182: aload 16
    //   1184: iload 4
    //   1186: aload 17
    //   1188: iload 4
    //   1190: invokeinterface 340 2 0
    //   1195: checkcast 336	java/lang/String
    //   1198: aastore
    //   1199: iload 4
    //   1201: iconst_1
    //   1202: iadd
    //   1203: istore 4
    //   1205: goto -29 -> 1176
    //   1208: aload 17
    //   1210: invokeinterface 334 1 0
    //   1215: i2d
    //   1216: ldc2_w 341
    //   1219: ddiv
    //   1220: invokestatic 348	java/lang/Math:ceil	(D)D
    //   1223: d2i
    //   1224: istore_3
    //   1225: goto -66 -> 1159
    //   1228: iconst_0
    //   1229: istore 4
    //   1231: iload 4
    //   1233: iload_3
    //   1234: if_icmpge +31 -> 1265
    //   1237: aload 16
    //   1239: iload 4
    //   1241: aload 17
    //   1243: iload 4
    //   1245: iconst_2
    //   1246: imul
    //   1247: invokeinterface 340 2 0
    //   1252: checkcast 336	java/lang/String
    //   1255: aastore
    //   1256: iload 4
    //   1258: iconst_1
    //   1259: iadd
    //   1260: istore 4
    //   1262: goto -31 -> 1231
    //   1265: aload 16
    //   1267: iconst_0
    //   1268: aaload
    //   1269: aconst_null
    //   1270: invokestatic 353	bfvo:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1273: astore 17
    //   1275: aload 17
    //   1277: invokevirtual 356	android/graphics/Bitmap:getWidth	()I
    //   1280: istore_3
    //   1281: aload 17
    //   1283: invokevirtual 357	android/graphics/Bitmap:getHeight	()I
    //   1286: istore 4
    //   1288: goto -671 -> 617
    //   1291: astore 17
    //   1293: iconst_0
    //   1294: istore_3
    //   1295: iconst_0
    //   1296: istore 4
    //   1298: goto -681 -> 617
    //   1301: bipush 8
    //   1303: istore 5
    //   1305: goto -663 -> 642
    //   1308: bipush 10
    //   1310: istore 5
    //   1312: goto -641 -> 671
    //   1315: astore 15
    //   1317: aload 17
    //   1319: astore 15
    //   1321: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1324: ifeq -610 -> 714
    //   1327: ldc 68
    //   1329: iconst_2
    //   1330: ldc_w 359
    //   1333: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1336: aload 17
    //   1338: astore 15
    //   1340: goto -626 -> 714
    //   1343: astore 17
    //   1345: aload 18
    //   1347: astore 17
    //   1349: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1352: ifeq -608 -> 744
    //   1355: ldc 68
    //   1357: iconst_2
    //   1358: ldc_w 361
    //   1361: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1364: aload 18
    //   1366: astore 17
    //   1368: goto -624 -> 744
    //   1371: aload 18
    //   1373: iload 9
    //   1375: i2f
    //   1376: iload 4
    //   1378: i2f
    //   1379: fdiv
    //   1380: putfield 240	bfjh:jdField_a_of_type_Float	F
    //   1383: goto -588 -> 795
    //   1386: aload_0
    //   1387: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1390: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1393: getfield 46	bfip:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1396: checkcast 286	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView
    //   1399: aload 17
    //   1401: aload_0
    //   1402: getfield 20	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1405: aload 15
    //   1407: aload 16
    //   1409: aload 20
    //   1411: aload 18
    //   1413: invokevirtual 364	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;[Ljava/lang/String;Lbcsd;Lbfjh;)V
    //   1416: goto -419 -> 997
    //   1419: aload_0
    //   1420: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1423: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1426: getfield 46	bfip:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1429: checkcast 366	com/tencent/mobileqq/troopgift/TroopGiftToPersonalSurfaceView
    //   1432: astore 15
    //   1434: aload_0
    //   1435: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1438: getfield 154	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   1441: getfield 205	com/tencent/mobileqq/data/MessageForDeliverGiftTips:animationType	I
    //   1444: iconst_1
    //   1445: if_icmpne +91 -> 1536
    //   1448: aload 15
    //   1450: aload_0
    //   1451: getfield 20	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1454: aload_0
    //   1455: getfield 22	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:b	Landroid/graphics/Bitmap;
    //   1458: aload_0
    //   1459: getfield 24	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:c	Landroid/graphics/Bitmap;
    //   1462: aload 19
    //   1464: iload 10
    //   1466: iload 9
    //   1468: invokevirtual 370	com/tencent/mobileqq/troopgift/TroopGiftToPersonalSurfaceView:setResourceWithFps	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/String;II)V
    //   1471: iload_3
    //   1472: ifeq +8 -> 1480
    //   1475: iload 4
    //   1477: ifne +83 -> 1560
    //   1480: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1483: ifeq +12 -> 1495
    //   1486: ldc 68
    //   1488: iconst_2
    //   1489: ldc_w 372
    //   1492: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1495: aload_0
    //   1496: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1499: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1502: invokestatic 375	bfip:a	(Lbfip;)Lbcrz;
    //   1505: ifnull -1444 -> 61
    //   1508: aload_0
    //   1509: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1512: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1515: invokestatic 375	bfip:a	(Lbfip;)Lbcrz;
    //   1518: invokeinterface 379 1 0
    //   1523: aload_0
    //   1524: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1527: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1530: aconst_null
    //   1531: invokestatic 382	bfip:a	(Lbfip;Lbcrz;)Lbcrz;
    //   1534: pop
    //   1535: return
    //   1536: aload 15
    //   1538: aload_0
    //   1539: getfield 20	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1542: aload_0
    //   1543: getfield 22	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:b	Landroid/graphics/Bitmap;
    //   1546: aload_0
    //   1547: getfield 24	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:c	Landroid/graphics/Bitmap;
    //   1550: aload 16
    //   1552: iload 5
    //   1554: invokevirtual 385	com/tencent/mobileqq/troopgift/TroopGiftToPersonalSurfaceView:setResourceWithFps	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;[Ljava/lang/String;I)V
    //   1557: goto -86 -> 1471
    //   1560: aload_0
    //   1561: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1564: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1567: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   1570: getfield 212	avli:d	I
    //   1573: ifeq +19 -> 1592
    //   1576: aload_0
    //   1577: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1580: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1583: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   1586: getfield 221	avli:e	I
    //   1589: ifne +36 -> 1625
    //   1592: aload_0
    //   1593: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1596: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1599: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   1602: iload 10
    //   1604: putfield 212	avli:d	I
    //   1607: aload_0
    //   1608: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1611: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1614: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   1617: iload 9
    //   1619: iload 11
    //   1621: isub
    //   1622: putfield 221	avli:e	I
    //   1625: iload 4
    //   1627: iload 10
    //   1629: imul
    //   1630: iload_3
    //   1631: idiv
    //   1632: istore 4
    //   1634: iload 4
    //   1636: iload 9
    //   1638: if_icmple +566 -> 2204
    //   1641: iload 10
    //   1643: iload 9
    //   1645: imul
    //   1646: iload 4
    //   1648: idiv
    //   1649: istore 8
    //   1651: iload 9
    //   1653: istore 4
    //   1655: aload_0
    //   1656: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1659: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1662: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   1665: getfield 386	avli:g	I
    //   1668: iload 9
    //   1670: imul
    //   1671: bipush 100
    //   1673: idiv
    //   1674: iload 4
    //   1676: iconst_2
    //   1677: idiv
    //   1678: isub
    //   1679: istore 5
    //   1681: iload 5
    //   1683: ifge +469 -> 2152
    //   1686: iconst_0
    //   1687: istore 5
    //   1689: iload 10
    //   1691: iload 8
    //   1693: isub
    //   1694: iconst_2
    //   1695: idiv
    //   1696: istore 13
    //   1698: aload_0
    //   1699: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1702: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1705: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   1708: getfield 256	avli:jdField_f_of_type_Int	I
    //   1711: iload 4
    //   1713: imul
    //   1714: bipush 100
    //   1716: idiv
    //   1717: istore 10
    //   1719: aload_0
    //   1720: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1723: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1726: invokestatic 55	bfip:a	(Lbfip;)Landroid/app/Activity;
    //   1729: ldc_w 387
    //   1732: invokestatic 393	com/tencent/mobileqq/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   1735: iload 10
    //   1737: iadd
    //   1738: aload_0
    //   1739: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1742: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1745: invokestatic 55	bfip:a	(Lbfip;)Landroid/app/Activity;
    //   1748: ldc_w 394
    //   1751: invokestatic 393	com/tencent/mobileqq/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   1754: iadd
    //   1755: istore 12
    //   1757: iload 12
    //   1759: iload 11
    //   1761: iadd
    //   1762: iload 4
    //   1764: if_icmple +434 -> 2198
    //   1767: iload 12
    //   1769: iload 11
    //   1771: iadd
    //   1772: iload 9
    //   1774: if_icmpge +424 -> 2198
    //   1777: iload 12
    //   1779: iload 11
    //   1781: iadd
    //   1782: istore 4
    //   1784: aload_0
    //   1785: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1788: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1791: getfield 46	bfip:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1794: invokevirtual 398	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1797: checkcast 400	android/widget/RelativeLayout$LayoutParams
    //   1800: astore 16
    //   1802: aload 16
    //   1804: iload 8
    //   1806: putfield 403	android/widget/RelativeLayout$LayoutParams:width	I
    //   1809: aload 16
    //   1811: iload 4
    //   1813: putfield 406	android/widget/RelativeLayout$LayoutParams:height	I
    //   1816: aload 16
    //   1818: iload 13
    //   1820: putfield 409	android/widget/RelativeLayout$LayoutParams:leftMargin	I
    //   1823: aload_0
    //   1824: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1827: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1830: getfield 46	bfip:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1833: aload 16
    //   1835: invokevirtual 413	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1838: new 291	android/view/WindowManager$LayoutParams
    //   1841: dup
    //   1842: iconst_m1
    //   1843: iload 4
    //   1845: iconst_2
    //   1846: iload 7
    //   1848: bipush 254
    //   1850: invokespecial 294	android/view/WindowManager$LayoutParams:<init>	(IIIII)V
    //   1853: astore 16
    //   1855: aload 16
    //   1857: bipush 51
    //   1859: putfield 297	android/view/WindowManager$LayoutParams:gravity	I
    //   1862: aload 16
    //   1864: iconst_0
    //   1865: putfield 416	android/view/WindowManager$LayoutParams:x	I
    //   1868: aload 16
    //   1870: iload 5
    //   1872: iload 6
    //   1874: iadd
    //   1875: putfield 419	android/view/WindowManager$LayoutParams:y	I
    //   1878: iload 9
    //   1880: iconst_4
    //   1881: idiv
    //   1882: istore 6
    //   1884: aload_0
    //   1885: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1888: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1891: invokestatic 55	bfip:a	(Lbfip;)Landroid/app/Activity;
    //   1894: ldc_w 420
    //   1897: invokestatic 393	com/tencent/mobileqq/util/DisplayUtil:dip2px	(Landroid/content/Context;F)I
    //   1900: istore 7
    //   1902: aload_0
    //   1903: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1906: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1909: getfield 423	bfip:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1912: invokevirtual 426	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1915: checkcast 400	android/widget/RelativeLayout$LayoutParams
    //   1918: astore 17
    //   1920: aload 17
    //   1922: iload 6
    //   1924: iload 5
    //   1926: isub
    //   1927: iload 7
    //   1929: isub
    //   1930: putfield 429	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   1933: aload_0
    //   1934: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1937: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1940: getfield 423	bfip:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1943: aload 17
    //   1945: invokevirtual 430	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1948: aload_0
    //   1949: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1952: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1955: invokestatic 433	bfip:a	(Lbfip;)Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   1958: getfield 436	com/tencent/mobileqq/data/MessageForDeliverGiftTips:showCloseBtn	Z
    //   1961: ifne +18 -> 1979
    //   1964: aload_0
    //   1965: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1968: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1971: getfield 423	bfip:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1974: bipush 8
    //   1976: invokevirtual 437	android/widget/ImageView:setVisibility	(I)V
    //   1979: aload_0
    //   1980: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1983: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1986: invokestatic 300	bfip:a	(Lbfip;)Landroid/view/WindowManager;
    //   1989: aload_0
    //   1990: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   1993: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   1996: getfield 303	bfip:jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   1999: invokeinterface 307 2 0
    //   2004: aload_0
    //   2005: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   2008: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   2011: invokestatic 300	bfip:a	(Lbfip;)Landroid/view/WindowManager;
    //   2014: aload_0
    //   2015: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   2018: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   2021: getfield 303	bfip:jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   2024: aload 16
    //   2026: invokeinterface 311 3 0
    //   2031: aload_0
    //   2032: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   2035: getfield 154	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   2038: getfield 205	com/tencent/mobileqq/data/MessageForDeliverGiftTips:animationType	I
    //   2041: iconst_1
    //   2042: if_icmpne +130 -> 2172
    //   2045: iconst_1
    //   2046: istore 14
    //   2048: iload 8
    //   2050: i2d
    //   2051: dconst_1
    //   2052: dmul
    //   2053: iload_3
    //   2054: i2d
    //   2055: ddiv
    //   2056: d2f
    //   2057: fstore_2
    //   2058: iload 14
    //   2060: ifeq +118 -> 2178
    //   2063: getstatic 218	com/tencent/mobileqq/utils/DeviceInfoUtil:density	F
    //   2066: fconst_2
    //   2067: fdiv
    //   2068: fstore_1
    //   2069: aload 15
    //   2071: iload 8
    //   2073: iload 4
    //   2075: fload_2
    //   2076: fload_1
    //   2077: fmul
    //   2078: iload 10
    //   2080: iload 14
    //   2082: invokevirtual 441	com/tencent/mobileqq/troopgift/TroopGiftToPersonalSurfaceView:setHeadPositionY	(IIFIZ)V
    //   2085: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2088: ifeq +41 -> 2129
    //   2091: ldc 68
    //   2093: iconst_2
    //   2094: new 126	java/lang/StringBuilder
    //   2097: dup
    //   2098: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2101: ldc_w 443
    //   2104: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2107: iload 8
    //   2109: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2112: ldc_w 448
    //   2115: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2118: iload 4
    //   2120: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2123: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2126: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2129: aload_0
    //   2130: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   2133: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   2136: iload 12
    //   2138: aload_0
    //   2139: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$5	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$5;
    //   2142: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$5:this$0	Lbfip;
    //   2145: invokestatic 208	bfip:a	(Lbfip;)Lavli;
    //   2148: invokevirtual 318	bfip:a	(ILavli;)V
    //   2151: return
    //   2152: iload 5
    //   2154: iload 4
    //   2156: iadd
    //   2157: iload 9
    //   2159: if_icmple +42 -> 2201
    //   2162: iload 9
    //   2164: iload 4
    //   2166: isub
    //   2167: istore 5
    //   2169: goto -480 -> 1689
    //   2172: iconst_0
    //   2173: istore 14
    //   2175: goto -127 -> 2048
    //   2178: fconst_1
    //   2179: fstore_1
    //   2180: goto -111 -> 2069
    //   2183: astore 17
    //   2185: goto -181 -> 2004
    //   2188: astore 16
    //   2190: goto -1145 -> 1045
    //   2193: astore 17
    //   2195: goto -900 -> 1295
    //   2198: goto -414 -> 1784
    //   2201: goto -512 -> 1689
    //   2204: iload 10
    //   2206: istore 8
    //   2208: goto -553 -> 1655
    //   2211: iload 5
    //   2213: istore 7
    //   2215: goto -1556 -> 659
    //   2218: aconst_null
    //   2219: astore 15
    //   2221: aload 16
    //   2223: astore 17
    //   2225: aload 18
    //   2227: astore 16
    //   2229: goto -2099 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2232	0	this	5
    //   2068	112	1	f1	float
    //   2057	19	2	f2	float
    //   593	1461	3	i	int
    //   615	1552	4	j	int
    //   640	1572	5	k	int
    //   459	1468	6	m	int
    //   657	1557	7	n	int
    //   1649	558	8	i1	int
    //   529	1638	9	i2	int
    //   503	1702	10	i3	int
    //   480	1302	11	i4	int
    //   1755	382	12	i5	int
    //   1696	123	13	i6	int
    //   2046	128	14	bool	boolean
    //   109	957	15	localObject1	Object
    //   1315	1	15	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1319	901	15	localObject2	Object
    //   78	1947	16	localObject3	Object
    //   2188	34	16	localException1	java.lang.Exception
    //   2227	1	16	localObject4	Object
    //   124	1158	17	localObject5	Object
    //   1291	46	17	localThrowable1	java.lang.Throwable
    //   1343	1	17	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1347	597	17	localObject6	Object
    //   2183	1	17	localException2	java.lang.Exception
    //   2193	1	17	localThrowable2	java.lang.Throwable
    //   2223	1	17	localException3	java.lang.Exception
    //   81	2145	18	localObject7	Object
    //   556	907	19	str	String
    //   951	459	20	localbfiy	bfiy
    // Exception table:
    //   from	to	target	type
    //   1265	1281	1291	java/lang/Throwable
    //   687	714	1315	java/lang/OutOfMemoryError
    //   717	744	1343	java/lang/OutOfMemoryError
    //   1979	2004	2183	java/lang/Exception
    //   1020	1045	2188	java/lang/Exception
    //   1281	1288	2193	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5.5
 * JD-Core Version:    0.7.0.1
 */