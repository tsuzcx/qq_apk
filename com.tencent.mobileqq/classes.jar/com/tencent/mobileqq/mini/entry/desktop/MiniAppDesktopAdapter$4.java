package com.tencent.mobileqq.mini.entry.desktop;

import android.view.View.OnClickListener;

class MiniAppDesktopAdapter$4
  implements View.OnClickListener
{
  MiniAppDesktopAdapter$4(MiniAppDesktopAdapter paramMiniAppDesktopAdapter) {}
  
  /* Error */
  public void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 26	android/view/View:getTag	()Ljava/lang/Object;
    //   4: astore 5
    //   6: aload 5
    //   8: instanceof 28
    //   11: ifne +36 -> 47
    //   14: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +29 -> 46
    //   20: ldc 36
    //   22: iconst_2
    //   23: new 38	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   30: ldc 41
    //   32: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload 5
    //   37: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 56	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: return
    //   47: aload_1
    //   48: invokevirtual 60	android/view/View:getParent	()Landroid/view/ViewParent;
    //   51: checkcast 62	android/support/v7/widget/RecyclerView
    //   54: aload_1
    //   55: invokevirtual 66	android/support/v7/widget/RecyclerView:getChildViewHolder	(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    //   58: checkcast 68	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder
    //   61: astore 5
    //   63: aload 5
    //   65: getfield 72	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:miniAppInfo	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   68: astore_1
    //   69: aload_0
    //   70: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$4:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   73: aload_1
    //   74: getfield 78	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   77: invokestatic 84	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2400	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;Ljava/lang/String;)Z
    //   80: istore 4
    //   82: aload 5
    //   84: getfield 88	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   87: iconst_1
    //   88: if_icmpne +374 -> 462
    //   91: iload 4
    //   93: ifeq +362 -> 455
    //   96: sipush 3020
    //   99: istore_2
    //   100: ldc 36
    //   102: iconst_1
    //   103: new 38	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   110: ldc 90
    //   112: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: getfield 78	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   119: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 92
    //   124: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload 5
    //   129: getfield 88	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   132: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload 5
    //   143: getfield 88	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   146: iconst_2
    //   147: if_icmpne +359 -> 506
    //   150: aload 5
    //   152: getfield 102	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:desktopAppInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   155: ifnull +351 -> 506
    //   158: aload 5
    //   160: getfield 102	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:desktopAppInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   163: getfield 107	com/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo:fromBackup	I
    //   166: iconst_1
    //   167: if_icmpne +339 -> 506
    //   170: new 109	com/tencent/mobileqq/mini/sdk/LaunchParam
    //   173: dup
    //   174: invokespecial 110	com/tencent/mobileqq/mini/sdk/LaunchParam:<init>	()V
    //   177: astore 6
    //   179: aload 6
    //   181: iload_2
    //   182: putfield 113	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   185: aload_0
    //   186: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$4:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   189: invokestatic 117	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2500	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;)Ljava/lang/ref/WeakReference;
    //   192: invokevirtual 122	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   195: checkcast 124	android/content/Context
    //   198: aload_1
    //   199: getfield 78	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   202: aconst_null
    //   203: aconst_null
    //   204: aload 6
    //   206: aconst_null
    //   207: invokestatic 130	com/tencent/mobileqq/mini/sdk/MiniAppController:startAppByAppid	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/LaunchParam;Lcom/tencent/mobileqq/mini/sdk/MiniAppLauncher$MiniAppLaunchListener;)V
    //   210: ldc 36
    //   212: iconst_1
    //   213: new 38	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   220: ldc 90
    //   222: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_1
    //   226: getfield 78	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   229: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc 92
    //   234: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload 5
    //   239: getfield 88	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   242: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   245: ldc 132
    //   247: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 5
    //   252: getfield 102	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:desktopAppInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   255: getfield 107	com/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo:fromBackup	I
    //   258: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 135	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: aload_0
    //   268: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$4:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   271: aload_1
    //   272: getfield 78	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   275: invokestatic 139	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2600	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;Ljava/lang/String;)I
    //   278: istore_3
    //   279: new 141	com/tencent/mobileqq/mini/apkg/MiniAppConfig
    //   282: dup
    //   283: aload_1
    //   284: invokespecial 144	com/tencent/mobileqq/mini/apkg/MiniAppConfig:<init>	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   287: astore 5
    //   289: aload 5
    //   291: getfield 148	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   294: iload_2
    //   295: putfield 113	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   298: aload 5
    //   300: ldc 150
    //   302: ldc 152
    //   304: aconst_null
    //   305: iload_3
    //   306: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   309: invokestatic 164	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC04239:reportAsync	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   312: aload_1
    //   313: getfield 167	com/tencent/mobileqq/mini/apkg/MiniAppInfo:amsAdInfo	Ljava/lang/String;
    //   316: invokestatic 173	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   319: istore 4
    //   321: iload 4
    //   323: ifne +78 -> 401
    //   326: new 175	org/json/JSONObject
    //   329: dup
    //   330: aload_1
    //   331: getfield 167	com/tencent/mobileqq/mini/apkg/MiniAppInfo:amsAdInfo	Ljava/lang/String;
    //   334: invokespecial 178	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   337: astore 5
    //   339: ldc 180
    //   341: new 180	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   344: dup
    //   345: invokespecial 181	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   348: aload 5
    //   350: invokestatic 187	com/tencent/gdtad/json/GdtJsonPbUtil:a	(Lcom/tencent/mobileqq/pb/PBField;Ljava/lang/Object;)Lcom/tencent/mobileqq/pb/PBField;
    //   353: invokevirtual 193	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   356: checkcast 180	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   359: getfield 197	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   362: getfield 203	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   365: invokevirtual 207	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   368: astore 5
    //   370: aload 5
    //   372: invokestatic 212	com/tencent/mobileqq/mini/entry/MiniAppUtils:reportMiniAppAd	(Ljava/lang/String;)V
    //   375: ldc 36
    //   377: iconst_1
    //   378: new 38	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   385: ldc 214
    //   387: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 5
    //   392: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: aload_1
    //   402: getfield 217	com/tencent/mobileqq/mini/apkg/MiniAppInfo:tianshuAdId	I
    //   405: ifle -359 -> 46
    //   408: ldc 219
    //   410: ldc 219
    //   412: aload_1
    //   413: getfield 217	com/tencent/mobileqq/mini/apkg/MiniAppInfo:tianshuAdId	I
    //   416: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   419: bipush 102
    //   421: invokestatic 223	com/tencent/mobileqq/mini/entry/MiniAppUtils:miniAppTianShuReport	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   424: return
    //   425: astore_1
    //   426: ldc 36
    //   428: iconst_1
    //   429: new 38	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   436: ldc 225
    //   438: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload_1
    //   442: invokestatic 231	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   445: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 234	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: return
    //   455: sipush 3001
    //   458: istore_2
    //   459: goto -359 -> 100
    //   462: aload 5
    //   464: getfield 88	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   467: iconst_2
    //   468: if_icmpne +10 -> 478
    //   471: sipush 3002
    //   474: istore_2
    //   475: goto -375 -> 100
    //   478: aload 5
    //   480: getfield 88	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   483: iconst_3
    //   484: if_icmpne +77 -> 561
    //   487: iload 4
    //   489: ifeq +10 -> 499
    //   492: sipush 3021
    //   495: istore_2
    //   496: goto -396 -> 100
    //   499: sipush 3003
    //   502: istore_2
    //   503: goto -7 -> 496
    //   506: aload_0
    //   507: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$4:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   510: invokestatic 117	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2500	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;)Ljava/lang/ref/WeakReference;
    //   513: invokevirtual 122	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   516: checkcast 236	android/app/Activity
    //   519: aload_1
    //   520: iload_2
    //   521: invokestatic 240	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:startMiniApp	(Landroid/app/Activity;Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;I)V
    //   524: goto -257 -> 267
    //   527: astore 5
    //   529: ldc 36
    //   531: iconst_1
    //   532: new 38	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   539: ldc 242
    //   541: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 5
    //   546: invokestatic 231	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   549: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 234	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   558: goto -157 -> 401
    //   561: sipush 9999
    //   564: istore_2
    //   565: goto -465 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	568	0	this	4
    //   0	568	1	paramView	android.view.View
    //   99	466	2	i	int
    //   278	28	3	j	int
    //   80	408	4	bool	boolean
    //   4	475	5	localObject	Object
    //   527	18	5	localException	java.lang.Exception
    //   177	28	6	localLaunchParam	com.tencent.mobileqq.mini.sdk.LaunchParam
    // Exception table:
    //   from	to	target	type
    //   100	267	425	java/lang/Exception
    //   267	321	425	java/lang/Exception
    //   401	424	425	java/lang/Exception
    //   506	524	425	java/lang/Exception
    //   529	558	425	java/lang/Exception
    //   326	401	527	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.4
 * JD-Core Version:    0.7.0.1
 */