package com.tencent.mobileqq.mini.entry.desktop;

import android.view.View.OnClickListener;

class MiniAppDesktopAdapter$3
  implements View.OnClickListener
{
  MiniAppDesktopAdapter$3(MiniAppDesktopAdapter paramMiniAppDesktopAdapter) {}
  
  /* Error */
  public void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 28	android/view/View:getTag	()Ljava/lang/Object;
    //   4: astore 5
    //   6: aload 5
    //   8: instanceof 30
    //   11: ifne +36 -> 47
    //   14: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +29 -> 46
    //   20: ldc 38
    //   22: iconst_2
    //   23: new 40	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   30: ldc 43
    //   32: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload 5
    //   37: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 58	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: return
    //   47: aload_1
    //   48: invokevirtual 62	android/view/View:getParent	()Landroid/view/ViewParent;
    //   51: checkcast 64	android/support/v7/widget/RecyclerView
    //   54: aload_1
    //   55: invokevirtual 68	android/support/v7/widget/RecyclerView:getChildViewHolder	(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    //   58: checkcast 70	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder
    //   61: astore 5
    //   63: aload 5
    //   65: getfield 74	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:miniAppInfo	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   68: astore_1
    //   69: aload 5
    //   71: getfield 78	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   74: iconst_1
    //   75: if_icmpne +338 -> 413
    //   78: sipush 3001
    //   81: istore_2
    //   82: ldc 38
    //   84: iconst_1
    //   85: new 40	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   92: ldc 80
    //   94: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: getfield 86	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   101: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 88
    //   106: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 5
    //   111: getfield 78	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   114: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload 5
    //   125: getfield 78	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   128: iconst_2
    //   129: if_icmpne +316 -> 445
    //   132: aload 5
    //   134: getfield 98	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:desktopAppInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   137: ifnull +308 -> 445
    //   140: aload 5
    //   142: getfield 98	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:desktopAppInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   145: getfield 103	com/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo:fromBackup	I
    //   148: iconst_1
    //   149: if_icmpne +296 -> 445
    //   152: new 105	com/tencent/mobileqq/mini/sdk/LaunchParam
    //   155: dup
    //   156: invokespecial 106	com/tencent/mobileqq/mini/sdk/LaunchParam:<init>	()V
    //   159: astore 6
    //   161: aload 6
    //   163: iload_2
    //   164: putfield 109	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   167: aload_0
    //   168: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$3:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   171: invokestatic 115	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2400	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;)Ljava/lang/ref/WeakReference;
    //   174: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   177: checkcast 122	android/content/Context
    //   180: aload_1
    //   181: getfield 86	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   184: aconst_null
    //   185: aconst_null
    //   186: aload 6
    //   188: aconst_null
    //   189: invokestatic 128	com/tencent/mobileqq/mini/sdk/MiniAppController:startAppByAppid	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/LaunchParam;Lcom/tencent/mobileqq/mini/sdk/MiniAppLauncher$MiniAppLaunchListener;)V
    //   192: ldc 38
    //   194: iconst_1
    //   195: new 40	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   202: ldc 80
    //   204: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_1
    //   208: getfield 86	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   211: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc 88
    //   216: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload 5
    //   221: getfield 78	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   224: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: ldc 130
    //   229: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload 5
    //   234: getfield 98	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:desktopAppInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   237: getfield 103	com/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo:fromBackup	I
    //   240: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 133	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload_0
    //   250: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$3:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   253: aload_1
    //   254: getfield 86	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   257: invokestatic 137	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2500	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;Ljava/lang/String;)I
    //   260: istore_3
    //   261: new 139	com/tencent/mobileqq/mini/apkg/MiniAppConfig
    //   264: dup
    //   265: aload_1
    //   266: invokespecial 142	com/tencent/mobileqq/mini/apkg/MiniAppConfig:<init>	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   269: astore 5
    //   271: aload 5
    //   273: getfield 146	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   276: iload_2
    //   277: putfield 109	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   280: aload 5
    //   282: ldc 148
    //   284: ldc 150
    //   286: aconst_null
    //   287: iload_3
    //   288: invokestatic 156	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   291: invokestatic 162	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC04239:reportAsync	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload_1
    //   295: getfield 165	com/tencent/mobileqq/mini/apkg/MiniAppInfo:amsAdInfo	Ljava/lang/String;
    //   298: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   301: istore 4
    //   303: iload 4
    //   305: ifne +78 -> 383
    //   308: new 173	org/json/JSONObject
    //   311: dup
    //   312: aload_1
    //   313: getfield 165	com/tencent/mobileqq/mini/apkg/MiniAppInfo:amsAdInfo	Ljava/lang/String;
    //   316: invokespecial 176	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   319: astore 5
    //   321: ldc 178
    //   323: new 178	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   326: dup
    //   327: invokespecial 179	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   330: aload 5
    //   332: invokestatic 185	aasd:a	(Lcom/tencent/mobileqq/pb/PBField;Ljava/lang/Object;)Lcom/tencent/mobileqq/pb/PBField;
    //   335: invokevirtual 191	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   338: checkcast 178	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   341: getfield 195	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   344: getfield 201	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   347: invokevirtual 205	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   350: astore 5
    //   352: aload 5
    //   354: invokestatic 210	com/tencent/mobileqq/mini/entry/MiniAppUtils:reportMiniAppAd	(Ljava/lang/String;)V
    //   357: ldc 38
    //   359: iconst_1
    //   360: new 40	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   367: ldc 212
    //   369: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload 5
    //   374: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: aload_1
    //   384: getfield 215	com/tencent/mobileqq/mini/apkg/MiniAppInfo:tianshuAdId	I
    //   387: ifle -341 -> 46
    //   390: ldc 217
    //   392: ldc 217
    //   394: aload_1
    //   395: getfield 215	com/tencent/mobileqq/mini/apkg/MiniAppInfo:tianshuAdId	I
    //   398: invokestatic 156	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   401: bipush 102
    //   403: invokestatic 221	com/tencent/mobileqq/mini/entry/MiniAppUtils:miniAppTianShuReport	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   406: return
    //   407: astore_1
    //   408: aload_1
    //   409: invokevirtual 224	com/tencent/mobileqq/mini/sdk/MiniAppException:printStackTrace	()V
    //   412: return
    //   413: aload 5
    //   415: getfield 78	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   418: iconst_2
    //   419: if_icmpne +10 -> 429
    //   422: sipush 3002
    //   425: istore_2
    //   426: goto -344 -> 82
    //   429: aload 5
    //   431: getfield 78	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   434: iconst_3
    //   435: if_icmpne +65 -> 500
    //   438: sipush 3003
    //   441: istore_2
    //   442: goto -360 -> 82
    //   445: aload_0
    //   446: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$3:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   449: invokestatic 115	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2400	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;)Ljava/lang/ref/WeakReference;
    //   452: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   455: checkcast 226	android/app/Activity
    //   458: aload_1
    //   459: iload_2
    //   460: invokestatic 230	com/tencent/mobileqq/mini/sdk/MiniAppController:launchMiniAppByAppInfo	(Landroid/app/Activity;Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;I)V
    //   463: goto -214 -> 249
    //   466: astore 5
    //   468: ldc 38
    //   470: iconst_1
    //   471: new 40	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   478: ldc 232
    //   480: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: aload 5
    //   485: invokestatic 238	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   488: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 241	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   497: goto -114 -> 383
    //   500: sipush 9999
    //   503: istore_2
    //   504: goto -422 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	this	3
    //   0	507	1	paramView	android.view.View
    //   81	423	2	i	int
    //   260	28	3	j	int
    //   301	3	4	bool	boolean
    //   4	426	5	localObject	Object
    //   466	18	5	localException	java.lang.Exception
    //   159	28	6	localLaunchParam	com.tencent.mobileqq.mini.sdk.LaunchParam
    // Exception table:
    //   from	to	target	type
    //   82	249	407	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   249	303	407	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   308	383	407	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   383	406	407	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   445	463	407	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   468	497	407	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   308	383	466	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.3
 * JD-Core Version:    0.7.0.1
 */