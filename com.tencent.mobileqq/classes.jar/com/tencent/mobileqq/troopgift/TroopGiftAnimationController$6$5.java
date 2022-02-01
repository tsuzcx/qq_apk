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
    //   1: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   4: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   7: getfield 46	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   10: ifnull +37 -> 47
    //   13: aload_0
    //   14: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   17: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   20: getfield 46	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   23: invokevirtual 52	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getVisibility	()I
    //   26: bipush 8
    //   28: if_icmpeq +19 -> 47
    //   31: aload_0
    //   32: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   35: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   38: invokestatic 55	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
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
    //   63: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   66: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   69: invokestatic 55	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   72: invokevirtual 78	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   75: invokevirtual 84	android/content/Context:getPackageName	()Ljava/lang/String;
    //   78: astore 16
    //   80: aload_0
    //   81: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   84: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   87: invokestatic 55	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   90: instanceof 86
    //   93: ifeq +108 -> 201
    //   96: aload_0
    //   97: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   100: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   103: invokestatic 55	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   106: astore 15
    //   108: invokestatic 92	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   111: invokevirtual 96	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   114: checkcast 98	com/tencent/common/app/AppInterface
    //   117: astore 17
    //   119: aload 15
    //   121: ifnull +13 -> 134
    //   124: aload 15
    //   126: aload 16
    //   128: invokestatic 103	com/tencent/mobileqq/utils/ProcessUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   131: ifeq +55 -> 186
    //   134: aload 15
    //   136: instanceof 86
    //   139: ifeq +10 -> 149
    //   142: getstatic 107	com/tencent/mobileqq/activity/SplashActivity:currentFragment	I
    //   145: iconst_2
    //   146: if_icmpne +40 -> 186
    //   149: aload 15
    //   151: instanceof 109
    //   154: ifeq +253 -> 407
    //   157: aload 15
    //   159: checkcast 109	com/tencent/mobileqq/webview/swift/SwiftWebViewFragmentSupporter
    //   162: invokeinterface 113 1 0
    //   167: ifnull +240 -> 407
    //   170: aload 15
    //   172: checkcast 109	com/tencent/mobileqq/webview/swift/SwiftWebViewFragmentSupporter
    //   175: invokeinterface 113 1 0
    //   180: invokevirtual 118	com/tencent/mobileqq/webview/swift/WebViewFragment:isActivityResume	()Z
    //   183: ifne +224 -> 407
    //   186: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq -128 -> 61
    //   192: ldc 68
    //   194: iconst_2
    //   195: ldc 120
    //   197: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: return
    //   201: aload_0
    //   202: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   205: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   208: invokestatic 55	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   211: instanceof 122
    //   214: ifeq +123 -> 337
    //   217: aload_0
    //   218: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   221: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   224: invokestatic 55	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   227: checkcast 122	com/tencent/mobileqq/pluginsdk/BasePluginActivity
    //   230: invokevirtual 126	com/tencent/mobileqq/pluginsdk/BasePluginActivity:getOutActivity	()Landroid/app/Activity;
    //   233: astore 17
    //   235: aload_0
    //   236: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   239: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   242: getfield 128	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_Int	I
    //   245: iconst_2
    //   246: if_icmpne +47 -> 293
    //   249: new 130	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   256: aload 16
    //   258: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc 137
    //   263: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: astore 15
    //   271: invokestatic 92	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   274: invokevirtual 96	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   277: checkcast 98	com/tencent/common/app/AppInterface
    //   280: astore 16
    //   282: aload 15
    //   284: astore 16
    //   286: aload 17
    //   288: astore 15
    //   290: goto -171 -> 119
    //   293: aload 16
    //   295: astore 15
    //   297: aload_0
    //   298: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   301: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   304: getfield 128	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_Int	I
    //   307: bipush 20
    //   309: if_icmpne -38 -> 271
    //   312: new 130	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   319: aload 16
    //   321: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc 142
    //   326: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: astore 15
    //   334: goto -63 -> 271
    //   337: aload_0
    //   338: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   341: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   344: invokestatic 55	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   347: instanceof 144
    //   350: ifeq +1850 -> 2200
    //   353: new 130	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   360: aload 16
    //   362: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: ldc 146
    //   367: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: astore 16
    //   375: aload_0
    //   376: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   379: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   382: invokestatic 55	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   385: astore 15
    //   387: aload_0
    //   388: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   391: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   394: invokestatic 55	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   397: checkcast 144	com/tencent/mobileqq/activity/QQBrowserActivity
    //   400: invokevirtual 150	com/tencent/mobileqq/activity/QQBrowserActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   403: pop
    //   404: goto -285 -> 119
    //   407: getstatic 155	android/os/Build$VERSION:SDK_INT	I
    //   410: bipush 21
    //   412: if_icmplt +16 -> 428
    //   415: aload_0
    //   416: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   419: getfield 158	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   422: invokevirtual 163	com/tencent/mobileqq/data/MessageForDeliverGiftTips:isToAll	()Z
    //   425: ifne +665 -> 1090
    //   428: aload_0
    //   429: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   432: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   435: invokestatic 55	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   438: invokestatic 166	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Landroid/app/Activity;)I
    //   441: istore 6
    //   443: aload_0
    //   444: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   447: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   450: invokestatic 55	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   453: invokevirtual 170	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   456: ldc 171
    //   458: invokevirtual 177	android/content/res/Resources:getDimension	(I)F
    //   461: f2i
    //   462: istore 11
    //   464: aload_0
    //   465: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   468: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   471: invokestatic 55	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   474: invokevirtual 181	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   477: invokeinterface 187 1 0
    //   482: invokevirtual 192	android/view/Display:getWidth	()I
    //   485: istore 10
    //   487: aload_0
    //   488: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   491: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   494: invokestatic 55	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   497: invokevirtual 181	android/app/Activity:getWindowManager	()Landroid/view/WindowManager;
    //   500: invokeinterface 187 1 0
    //   505: invokevirtual 195	android/view/Display:getHeight	()I
    //   508: iload 6
    //   510: isub
    //   511: istore 9
    //   513: aload_0
    //   514: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   517: getfield 158	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   520: invokestatic 200	com/tencent/mobileqq/troop/utils/TroopGiftUtil:a	(Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;)Ljava/util/List;
    //   523: astore 17
    //   525: aconst_null
    //   526: astore 16
    //   528: aload_0
    //   529: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   532: getfield 158	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   535: invokestatic 203	com/tencent/mobileqq/troop/utils/TroopGiftUtil:d	(Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;)Ljava/lang/String;
    //   538: astore 19
    //   540: aload_0
    //   541: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   544: getfield 158	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   547: getfield 206	com/tencent/mobileqq/data/MessageForDeliverGiftTips:animationType	I
    //   550: iconst_1
    //   551: if_icmpne +545 -> 1096
    //   554: aload_0
    //   555: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   558: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   561: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   564: getfield 213	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:d	I
    //   567: i2f
    //   568: getstatic 218	com/tencent/mobileqq/utils/DeviceInfoUtil:jdField_a_of_type_Float	F
    //   571: fmul
    //   572: fconst_2
    //   573: fdiv
    //   574: f2i
    //   575: istore_3
    //   576: aload_0
    //   577: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   580: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   583: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   586: getfield 221	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:e	I
    //   589: i2f
    //   590: getstatic 218	com/tencent/mobileqq/utils/DeviceInfoUtil:jdField_a_of_type_Float	F
    //   593: fmul
    //   594: fconst_2
    //   595: fdiv
    //   596: f2i
    //   597: istore 4
    //   599: getstatic 155	android/os/Build$VERSION:SDK_INT	I
    //   602: bipush 21
    //   604: if_icmplt +679 -> 1283
    //   607: aload_0
    //   608: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   611: getfield 158	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   614: invokevirtual 163	com/tencent/mobileqq/data/MessageForDeliverGiftTips:isToAll	()Z
    //   617: ifeq +666 -> 1283
    //   620: ldc 222
    //   622: istore 5
    //   624: aload 15
    //   626: ifnull +1567 -> 2193
    //   629: aload 15
    //   631: instanceof 144
    //   634: ifeq +1559 -> 2193
    //   637: bipush 24
    //   639: istore 7
    //   641: getstatic 155	android/os/Build$VERSION:SDK_INT	I
    //   644: bipush 19
    //   646: if_icmple +644 -> 1290
    //   649: bipush 20
    //   651: istore 5
    //   653: aload_0
    //   654: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   657: getfield 158	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   660: invokevirtual 163	com/tencent/mobileqq/data/MessageForDeliverGiftTips:isToAll	()Z
    //   663: ifeq +738 -> 1401
    //   666: aconst_null
    //   667: astore 17
    //   669: new 130	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   676: aload_0
    //   677: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   680: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: ldc 224
    //   685: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokestatic 230	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   694: astore 15
    //   696: aconst_null
    //   697: astore 18
    //   699: new 130	java/lang/StringBuilder
    //   702: dup
    //   703: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   706: aload_0
    //   707: getfield 18	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   710: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: ldc 232
    //   715: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokestatic 230	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   724: astore 17
    //   726: new 234	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options
    //   729: dup
    //   730: invokespecial 235	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:<init>	()V
    //   733: astore 18
    //   735: aload 18
    //   737: iload 10
    //   739: putfield 236	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:jdField_a_of_type_Int	I
    //   742: aload 18
    //   744: iload 9
    //   746: putfield 238	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:jdField_b_of_type_Int	I
    //   749: iload 10
    //   751: i2f
    //   752: iload_3
    //   753: i2f
    //   754: fdiv
    //   755: iload 9
    //   757: i2f
    //   758: iload 4
    //   760: i2f
    //   761: fdiv
    //   762: fcmpl
    //   763: ifle +590 -> 1353
    //   766: aload 18
    //   768: iload 10
    //   770: i2f
    //   771: iload_3
    //   772: i2f
    //   773: fdiv
    //   774: putfield 239	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:jdField_a_of_type_Float	F
    //   777: aload 18
    //   779: aload_0
    //   780: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   783: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   786: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   789: getfield 242	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:i	I
    //   792: putfield 244	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:c	I
    //   795: aload 18
    //   797: aload_0
    //   798: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   801: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   804: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   807: getfield 247	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:k	I
    //   810: putfield 250	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:jdField_f_of_type_Int	I
    //   813: aload 18
    //   815: aload_0
    //   816: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   819: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   822: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   825: getfield 253	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:j	I
    //   828: putfield 254	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:d	I
    //   831: aload 18
    //   833: aload_0
    //   834: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   837: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   840: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   843: getfield 255	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_f_of_type_Int	I
    //   846: putfield 256	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:e	I
    //   849: aload 18
    //   851: aload_0
    //   852: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   855: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   858: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   861: getfield 259	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:l	I
    //   864: putfield 262	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:g	I
    //   867: aload 18
    //   869: aload_0
    //   870: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   873: getfield 158	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   876: getfield 265	com/tencent/mobileqq/data/MessageForDeliverGiftTips:senderName	Ljava/lang/String;
    //   879: putfield 266	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   882: aload 18
    //   884: aload_0
    //   885: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   888: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   891: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   894: getfield 269	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:h	Ljava/lang/String;
    //   897: putfield 271	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   900: aload 18
    //   902: aload_0
    //   903: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   906: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   909: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   912: getfield 274	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_f_of_type_Boolean	Z
    //   915: putfield 276	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:jdField_a_of_type_Boolean	Z
    //   918: aload 18
    //   920: iload 5
    //   922: putfield 278	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:h	I
    //   925: new 280	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5$1
    //   928: dup
    //   929: aload_0
    //   930: invokespecial 283	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5$1:<init>	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5;)V
    //   933: astore 20
    //   935: aload_0
    //   936: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   939: getfield 158	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   942: getfield 206	com/tencent/mobileqq/data/MessageForDeliverGiftTips:animationType	I
    //   945: iconst_1
    //   946: if_icmpne +422 -> 1368
    //   949: aload_0
    //   950: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   953: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   956: getfield 46	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   959: checkcast 285	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView
    //   962: aload 17
    //   964: aload_0
    //   965: getfield 20	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   968: aload 15
    //   970: aload 19
    //   972: aload 20
    //   974: aload 18
    //   976: invokevirtual 288	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/String;Lcom/tencent/mobileqq/surfaceviewaction/gl/ImageButton$OnClickListener;Lcom/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options;)V
    //   979: new 290	android/view/WindowManager$LayoutParams
    //   982: dup
    //   983: iconst_m1
    //   984: iconst_m1
    //   985: iconst_2
    //   986: iload 7
    //   988: bipush 254
    //   990: invokespecial 293	android/view/WindowManager$LayoutParams:<init>	(IIIII)V
    //   993: astore 15
    //   995: aload 15
    //   997: bipush 51
    //   999: putfield 296	android/view/WindowManager$LayoutParams:gravity	I
    //   1002: aload_0
    //   1003: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1006: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1009: invokestatic 299	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/view/WindowManager;
    //   1012: aload_0
    //   1013: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1016: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1019: getfield 302	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   1022: invokeinterface 306 2 0
    //   1027: aload_0
    //   1028: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1031: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1034: invokestatic 299	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/view/WindowManager;
    //   1037: aload_0
    //   1038: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1041: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1044: getfield 302	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   1047: aload 15
    //   1049: invokeinterface 310 3 0
    //   1054: aload_0
    //   1055: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1058: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1061: getfield 46	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1064: iconst_0
    //   1065: invokevirtual 314	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:setVisibility	(I)V
    //   1068: aload_0
    //   1069: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1072: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1075: iconst_0
    //   1076: aload_0
    //   1077: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1080: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1083: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1086: invokevirtual 317	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(ILcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   1089: return
    //   1090: iconst_0
    //   1091: istore 6
    //   1093: goto -650 -> 443
    //   1096: aload 17
    //   1098: invokestatic 320	com/tencent/mobileqq/troop/utils/TroopGiftUtil:a	(Ljava/util/List;)Z
    //   1101: ifeq +19 -> 1120
    //   1104: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1107: ifeq -1046 -> 61
    //   1110: ldc 68
    //   1112: iconst_2
    //   1113: ldc_w 322
    //   1116: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1119: return
    //   1120: aload 17
    //   1122: invokestatic 328	java/util/Collections:sort	(Ljava/util/List;)V
    //   1125: getstatic 155	android/os/Build$VERSION:SDK_INT	I
    //   1128: bipush 19
    //   1130: if_icmple +60 -> 1190
    //   1133: aload 17
    //   1135: invokeinterface 333 1 0
    //   1140: istore_3
    //   1141: iload_3
    //   1142: anewarray 335	java/lang/String
    //   1145: astore 16
    //   1147: getstatic 155	android/os/Build$VERSION:SDK_INT	I
    //   1150: bipush 19
    //   1152: if_icmple +58 -> 1210
    //   1155: iconst_0
    //   1156: istore 4
    //   1158: iload 4
    //   1160: iload_3
    //   1161: if_icmpge +86 -> 1247
    //   1164: aload 16
    //   1166: iload 4
    //   1168: aload 17
    //   1170: iload 4
    //   1172: invokeinterface 339 2 0
    //   1177: checkcast 335	java/lang/String
    //   1180: aastore
    //   1181: iload 4
    //   1183: iconst_1
    //   1184: iadd
    //   1185: istore 4
    //   1187: goto -29 -> 1158
    //   1190: aload 17
    //   1192: invokeinterface 333 1 0
    //   1197: i2d
    //   1198: ldc2_w 340
    //   1201: ddiv
    //   1202: invokestatic 347	java/lang/Math:ceil	(D)D
    //   1205: d2i
    //   1206: istore_3
    //   1207: goto -66 -> 1141
    //   1210: iconst_0
    //   1211: istore 4
    //   1213: iload 4
    //   1215: iload_3
    //   1216: if_icmpge +31 -> 1247
    //   1219: aload 16
    //   1221: iload 4
    //   1223: aload 17
    //   1225: iload 4
    //   1227: iconst_2
    //   1228: imul
    //   1229: invokeinterface 339 2 0
    //   1234: checkcast 335	java/lang/String
    //   1237: aastore
    //   1238: iload 4
    //   1240: iconst_1
    //   1241: iadd
    //   1242: istore 4
    //   1244: goto -31 -> 1213
    //   1247: aload 16
    //   1249: iconst_0
    //   1250: aaload
    //   1251: aconst_null
    //   1252: invokestatic 352	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1255: astore 17
    //   1257: aload 17
    //   1259: invokevirtual 355	android/graphics/Bitmap:getWidth	()I
    //   1262: istore_3
    //   1263: aload 17
    //   1265: invokevirtual 356	android/graphics/Bitmap:getHeight	()I
    //   1268: istore 4
    //   1270: goto -671 -> 599
    //   1273: astore 17
    //   1275: iconst_0
    //   1276: istore_3
    //   1277: iconst_0
    //   1278: istore 4
    //   1280: goto -681 -> 599
    //   1283: bipush 8
    //   1285: istore 5
    //   1287: goto -663 -> 624
    //   1290: bipush 10
    //   1292: istore 5
    //   1294: goto -641 -> 653
    //   1297: astore 15
    //   1299: aload 17
    //   1301: astore 15
    //   1303: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1306: ifeq -610 -> 696
    //   1309: ldc 68
    //   1311: iconst_2
    //   1312: ldc_w 358
    //   1315: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1318: aload 17
    //   1320: astore 15
    //   1322: goto -626 -> 696
    //   1325: astore 17
    //   1327: aload 18
    //   1329: astore 17
    //   1331: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1334: ifeq -608 -> 726
    //   1337: ldc 68
    //   1339: iconst_2
    //   1340: ldc_w 360
    //   1343: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1346: aload 18
    //   1348: astore 17
    //   1350: goto -624 -> 726
    //   1353: aload 18
    //   1355: iload 9
    //   1357: i2f
    //   1358: iload 4
    //   1360: i2f
    //   1361: fdiv
    //   1362: putfield 239	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options:jdField_a_of_type_Float	F
    //   1365: goto -588 -> 777
    //   1368: aload_0
    //   1369: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1372: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1375: getfield 46	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1378: checkcast 285	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView
    //   1381: aload 17
    //   1383: aload_0
    //   1384: getfield 20	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1387: aload 15
    //   1389: aload 16
    //   1391: aload 20
    //   1393: aload 18
    //   1395: invokevirtual 363	com/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;[Ljava/lang/String;Lcom/tencent/mobileqq/surfaceviewaction/gl/ImageButton$OnClickListener;Lcom/tencent/mobileqq/troopgift/TroopGiftToAllSurfaceView$Options;)V
    //   1398: goto -419 -> 979
    //   1401: aload_0
    //   1402: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1405: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1408: getfield 46	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1411: checkcast 365	com/tencent/mobileqq/troopgift/TroopGiftToPersonalSurfaceView
    //   1414: astore 15
    //   1416: aload_0
    //   1417: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1420: getfield 158	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   1423: getfield 206	com/tencent/mobileqq/data/MessageForDeliverGiftTips:animationType	I
    //   1426: iconst_1
    //   1427: if_icmpne +91 -> 1518
    //   1430: aload 15
    //   1432: aload_0
    //   1433: getfield 20	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1436: aload_0
    //   1437: getfield 22	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:b	Landroid/graphics/Bitmap;
    //   1440: aload_0
    //   1441: getfield 24	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:c	Landroid/graphics/Bitmap;
    //   1444: aload 19
    //   1446: iload 10
    //   1448: iload 9
    //   1450: invokevirtual 369	com/tencent/mobileqq/troopgift/TroopGiftToPersonalSurfaceView:setResourceWithFps	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/String;II)V
    //   1453: iload_3
    //   1454: ifeq +8 -> 1462
    //   1457: iload 4
    //   1459: ifne +83 -> 1542
    //   1462: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1465: ifeq +12 -> 1477
    //   1468: ldc 68
    //   1470: iconst_2
    //   1471: ldc_w 371
    //   1474: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1477: aload_0
    //   1478: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1481: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1484: invokestatic 374	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/surfaceviewaction/gl/FrameSprite$OnFrameEndListener;
    //   1487: ifnull -1426 -> 61
    //   1490: aload_0
    //   1491: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1494: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1497: invokestatic 374	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/surfaceviewaction/gl/FrameSprite$OnFrameEndListener;
    //   1500: invokeinterface 378 1 0
    //   1505: aload_0
    //   1506: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1509: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1512: aconst_null
    //   1513: invokestatic 381	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;Lcom/tencent/mobileqq/surfaceviewaction/gl/FrameSprite$OnFrameEndListener;)Lcom/tencent/mobileqq/surfaceviewaction/gl/FrameSprite$OnFrameEndListener;
    //   1516: pop
    //   1517: return
    //   1518: aload 15
    //   1520: aload_0
    //   1521: getfield 20	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1524: aload_0
    //   1525: getfield 22	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:b	Landroid/graphics/Bitmap;
    //   1528: aload_0
    //   1529: getfield 24	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:c	Landroid/graphics/Bitmap;
    //   1532: aload 16
    //   1534: iload 5
    //   1536: invokevirtual 384	com/tencent/mobileqq/troopgift/TroopGiftToPersonalSurfaceView:setResourceWithFps	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;[Ljava/lang/String;I)V
    //   1539: goto -86 -> 1453
    //   1542: aload_0
    //   1543: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1546: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1549: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1552: getfield 213	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:d	I
    //   1555: ifeq +19 -> 1574
    //   1558: aload_0
    //   1559: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1562: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1565: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1568: getfield 221	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:e	I
    //   1571: ifne +36 -> 1607
    //   1574: aload_0
    //   1575: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1578: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1581: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1584: iload 10
    //   1586: putfield 213	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:d	I
    //   1589: aload_0
    //   1590: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1593: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1596: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1599: iload 9
    //   1601: iload 11
    //   1603: isub
    //   1604: putfield 221	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:e	I
    //   1607: iload 4
    //   1609: iload 10
    //   1611: imul
    //   1612: iload_3
    //   1613: idiv
    //   1614: istore 4
    //   1616: iload 4
    //   1618: iload 9
    //   1620: if_icmple +566 -> 2186
    //   1623: iload 10
    //   1625: iload 9
    //   1627: imul
    //   1628: iload 4
    //   1630: idiv
    //   1631: istore 8
    //   1633: iload 9
    //   1635: istore 4
    //   1637: aload_0
    //   1638: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1641: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1644: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1647: getfield 385	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:g	I
    //   1650: iload 9
    //   1652: imul
    //   1653: bipush 100
    //   1655: idiv
    //   1656: iload 4
    //   1658: iconst_2
    //   1659: idiv
    //   1660: isub
    //   1661: istore 5
    //   1663: iload 5
    //   1665: ifge +469 -> 2134
    //   1668: iconst_0
    //   1669: istore 5
    //   1671: iload 10
    //   1673: iload 8
    //   1675: isub
    //   1676: iconst_2
    //   1677: idiv
    //   1678: istore 13
    //   1680: aload_0
    //   1681: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1684: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1687: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   1690: getfield 255	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_f_of_type_Int	I
    //   1693: iload 4
    //   1695: imul
    //   1696: bipush 100
    //   1698: idiv
    //   1699: istore 10
    //   1701: aload_0
    //   1702: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1705: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1708: invokestatic 55	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   1711: ldc_w 386
    //   1714: invokestatic 391	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1717: iload 10
    //   1719: iadd
    //   1720: aload_0
    //   1721: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1724: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1727: invokestatic 55	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   1730: ldc_w 392
    //   1733: invokestatic 391	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1736: iadd
    //   1737: istore 12
    //   1739: iload 12
    //   1741: iload 11
    //   1743: iadd
    //   1744: iload 4
    //   1746: if_icmple +434 -> 2180
    //   1749: iload 12
    //   1751: iload 11
    //   1753: iadd
    //   1754: iload 9
    //   1756: if_icmpge +424 -> 2180
    //   1759: iload 12
    //   1761: iload 11
    //   1763: iadd
    //   1764: istore 4
    //   1766: aload_0
    //   1767: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1770: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1773: getfield 46	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1776: invokevirtual 396	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1779: checkcast 398	android/widget/RelativeLayout$LayoutParams
    //   1782: astore 16
    //   1784: aload 16
    //   1786: iload 8
    //   1788: putfield 401	android/widget/RelativeLayout$LayoutParams:width	I
    //   1791: aload 16
    //   1793: iload 4
    //   1795: putfield 404	android/widget/RelativeLayout$LayoutParams:height	I
    //   1798: aload 16
    //   1800: iload 13
    //   1802: putfield 407	android/widget/RelativeLayout$LayoutParams:leftMargin	I
    //   1805: aload_0
    //   1806: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1809: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1812: getfield 46	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   1815: aload 16
    //   1817: invokevirtual 411	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1820: new 290	android/view/WindowManager$LayoutParams
    //   1823: dup
    //   1824: iconst_m1
    //   1825: iload 4
    //   1827: iconst_2
    //   1828: iload 7
    //   1830: bipush 254
    //   1832: invokespecial 293	android/view/WindowManager$LayoutParams:<init>	(IIIII)V
    //   1835: astore 16
    //   1837: aload 16
    //   1839: bipush 51
    //   1841: putfield 296	android/view/WindowManager$LayoutParams:gravity	I
    //   1844: aload 16
    //   1846: iconst_0
    //   1847: putfield 414	android/view/WindowManager$LayoutParams:x	I
    //   1850: aload 16
    //   1852: iload 5
    //   1854: iload 6
    //   1856: iadd
    //   1857: putfield 417	android/view/WindowManager$LayoutParams:y	I
    //   1860: iload 9
    //   1862: iconst_4
    //   1863: idiv
    //   1864: istore 6
    //   1866: aload_0
    //   1867: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1870: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1873: invokestatic 55	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/app/Activity;
    //   1876: ldc_w 418
    //   1879: invokestatic 391	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1882: istore 7
    //   1884: aload_0
    //   1885: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1888: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1891: getfield 421	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1894: invokevirtual 424	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1897: checkcast 398	android/widget/RelativeLayout$LayoutParams
    //   1900: astore 17
    //   1902: aload 17
    //   1904: iload 6
    //   1906: iload 5
    //   1908: isub
    //   1909: iload 7
    //   1911: isub
    //   1912: putfield 427	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   1915: aload_0
    //   1916: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1919: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1922: getfield 421	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1925: aload 17
    //   1927: invokevirtual 428	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1930: aload_0
    //   1931: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1934: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1937: invokestatic 431	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   1940: getfield 434	com/tencent/mobileqq/data/MessageForDeliverGiftTips:showCloseBtn	Z
    //   1943: ifne +18 -> 1961
    //   1946: aload_0
    //   1947: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1950: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1953: getfield 421	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1956: bipush 8
    //   1958: invokevirtual 435	android/widget/ImageView:setVisibility	(I)V
    //   1961: aload_0
    //   1962: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1965: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1968: invokestatic 299	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/view/WindowManager;
    //   1971: aload_0
    //   1972: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1975: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1978: getfield 302	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   1981: invokeinterface 306 2 0
    //   1986: aload_0
    //   1987: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   1990: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   1993: invokestatic 299	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Landroid/view/WindowManager;
    //   1996: aload_0
    //   1997: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   2000: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   2003: getfield 302	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout	Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;
    //   2006: aload 16
    //   2008: invokeinterface 310 3 0
    //   2013: aload_0
    //   2014: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   2017: getfield 158	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:a	Lcom/tencent/mobileqq/data/MessageForDeliverGiftTips;
    //   2020: getfield 206	com/tencent/mobileqq/data/MessageForDeliverGiftTips:animationType	I
    //   2023: iconst_1
    //   2024: if_icmpne +130 -> 2154
    //   2027: iconst_1
    //   2028: istore 14
    //   2030: iload 8
    //   2032: i2d
    //   2033: dconst_1
    //   2034: dmul
    //   2035: iload_3
    //   2036: i2d
    //   2037: ddiv
    //   2038: d2f
    //   2039: fstore_2
    //   2040: iload 14
    //   2042: ifeq +118 -> 2160
    //   2045: getstatic 218	com/tencent/mobileqq/utils/DeviceInfoUtil:jdField_a_of_type_Float	F
    //   2048: fconst_2
    //   2049: fdiv
    //   2050: fstore_1
    //   2051: aload 15
    //   2053: iload 8
    //   2055: iload 4
    //   2057: fload_2
    //   2058: fload_1
    //   2059: fmul
    //   2060: iload 10
    //   2062: iload 14
    //   2064: invokevirtual 439	com/tencent/mobileqq/troopgift/TroopGiftToPersonalSurfaceView:setHeadPositionY	(IIFIZ)V
    //   2067: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2070: ifeq +41 -> 2111
    //   2073: ldc 68
    //   2075: iconst_2
    //   2076: new 130	java/lang/StringBuilder
    //   2079: dup
    //   2080: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   2083: ldc_w 441
    //   2086: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2089: iload 8
    //   2091: invokevirtual 444	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2094: ldc_w 446
    //   2097: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2100: iload 4
    //   2102: invokevirtual 444	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2105: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2108: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2111: aload_0
    //   2112: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   2115: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   2118: iload 12
    //   2120: aload_0
    //   2121: getfield 16	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6$5:jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController$6;
    //   2124: getfield 41	com/tencent/mobileqq/troopgift/TroopGiftAnimationController$6:this$0	Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;
    //   2127: invokestatic 209	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(Lcom/tencent/mobileqq/troopgift/TroopGiftAnimationController;)Lcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;
    //   2130: invokevirtual 317	com/tencent/mobileqq/troopgift/TroopGiftAnimationController:a	(ILcom/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData;)V
    //   2133: return
    //   2134: iload 5
    //   2136: iload 4
    //   2138: iadd
    //   2139: iload 9
    //   2141: if_icmple +42 -> 2183
    //   2144: iload 9
    //   2146: iload 4
    //   2148: isub
    //   2149: istore 5
    //   2151: goto -480 -> 1671
    //   2154: iconst_0
    //   2155: istore 14
    //   2157: goto -127 -> 2030
    //   2160: fconst_1
    //   2161: fstore_1
    //   2162: goto -111 -> 2051
    //   2165: astore 17
    //   2167: goto -181 -> 1986
    //   2170: astore 16
    //   2172: goto -1145 -> 1027
    //   2175: astore 17
    //   2177: goto -900 -> 1277
    //   2180: goto -414 -> 1766
    //   2183: goto -512 -> 1671
    //   2186: iload 10
    //   2188: istore 8
    //   2190: goto -553 -> 1637
    //   2193: iload 5
    //   2195: istore 7
    //   2197: goto -1556 -> 641
    //   2200: aconst_null
    //   2201: astore 15
    //   2203: goto -2084 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2206	0	this	5
    //   2050	112	1	f1	float
    //   2039	19	2	f2	float
    //   575	1461	3	i	int
    //   597	1552	4	j	int
    //   622	1572	5	k	int
    //   441	1468	6	m	int
    //   639	1557	7	n	int
    //   1631	558	8	i1	int
    //   511	1638	9	i2	int
    //   485	1702	10	i3	int
    //   462	1302	11	i4	int
    //   1737	382	12	i5	int
    //   1678	123	13	i6	int
    //   2028	128	14	bool	boolean
    //   106	942	15	localObject1	Object
    //   1297	1	15	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1301	901	15	localObject2	Object
    //   78	1929	16	localObject3	Object
    //   2170	1	16	localException1	java.lang.Exception
    //   117	1147	17	localObject4	Object
    //   1273	46	17	localThrowable1	java.lang.Throwable
    //   1325	1	17	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1329	597	17	localObject5	Object
    //   2165	1	17	localException2	java.lang.Exception
    //   2175	1	17	localThrowable2	java.lang.Throwable
    //   697	697	18	localOptions	TroopGiftToAllSurfaceView.Options
    //   538	907	19	str	String
    //   933	459	20	local1	TroopGiftAnimationController.6.5.1
    // Exception table:
    //   from	to	target	type
    //   1247	1263	1273	java/lang/Throwable
    //   669	696	1297	java/lang/OutOfMemoryError
    //   699	726	1325	java/lang/OutOfMemoryError
    //   1961	1986	2165	java/lang/Exception
    //   1002	1027	2170	java/lang/Exception
    //   1263	1270	2175	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController.6.5
 * JD-Core Version:    0.7.0.1
 */