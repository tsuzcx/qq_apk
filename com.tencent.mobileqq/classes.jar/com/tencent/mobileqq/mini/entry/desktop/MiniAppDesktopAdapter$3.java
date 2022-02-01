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
    //   11: ifne +43 -> 54
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
    //   46: invokestatic 64	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   49: aload_1
    //   50: invokevirtual 67	com/tencent/qqlive/module/videoreport/collect/EventCollector:onViewClicked	(Landroid/view/View;)V
    //   53: return
    //   54: aload_1
    //   55: invokevirtual 71	android/view/View:getParent	()Landroid/view/ViewParent;
    //   58: checkcast 73	android/support/v7/widget/RecyclerView
    //   61: aload_1
    //   62: invokevirtual 77	android/support/v7/widget/RecyclerView:getChildViewHolder	(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    //   65: checkcast 79	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder
    //   68: astore 6
    //   70: aload 6
    //   72: getfield 83	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:miniAppInfo	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   75: astore 5
    //   77: aload_0
    //   78: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$3:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   81: aload 5
    //   83: getfield 89	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   86: invokestatic 95	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2400	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;Ljava/lang/String;)Z
    //   89: istore 4
    //   91: aload 6
    //   93: getfield 99	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   96: iconst_1
    //   97: if_icmpne +365 -> 462
    //   100: iload 4
    //   102: ifeq +353 -> 455
    //   105: sipush 3020
    //   108: istore_2
    //   109: ldc 38
    //   111: iconst_1
    //   112: new 40	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   119: ldc 101
    //   121: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 5
    //   126: getfield 89	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   129: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 103
    //   134: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 6
    //   139: getfield 99	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   142: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload 6
    //   153: getfield 99	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   156: iconst_2
    //   157: if_icmpne +349 -> 506
    //   160: aload 6
    //   162: getfield 113	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:desktopAppInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   165: ifnull +341 -> 506
    //   168: aload 6
    //   170: getfield 113	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:desktopAppInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   173: getfield 118	com/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo:fromBackup	I
    //   176: iconst_1
    //   177: if_icmpne +329 -> 506
    //   180: new 120	com/tencent/mobileqq/mini/sdk/LaunchParam
    //   183: dup
    //   184: invokespecial 121	com/tencent/mobileqq/mini/sdk/LaunchParam:<init>	()V
    //   187: astore 7
    //   189: aload 7
    //   191: iload_2
    //   192: putfield 124	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   195: aload_0
    //   196: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$3:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   199: invokestatic 128	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2500	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;)Ljava/lang/ref/WeakReference;
    //   202: invokevirtual 133	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   205: checkcast 135	android/content/Context
    //   208: aload 5
    //   210: getfield 89	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   213: aconst_null
    //   214: aconst_null
    //   215: aload 7
    //   217: aconst_null
    //   218: invokestatic 141	com/tencent/mobileqq/mini/sdk/MiniAppController:startAppByAppid	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/LaunchParam;Lcom/tencent/mobileqq/mini/sdk/MiniAppLauncher$MiniAppLaunchListener;)V
    //   221: ldc 38
    //   223: iconst_1
    //   224: new 40	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   231: ldc 101
    //   233: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload 5
    //   238: getfield 89	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   241: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc 103
    //   246: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 6
    //   251: getfield 99	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   254: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: ldc 143
    //   259: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload 6
    //   264: getfield 113	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:desktopAppInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   267: getfield 118	com/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo:fromBackup	I
    //   270: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 146	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: aload_0
    //   280: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$3:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   283: aload 5
    //   285: getfield 89	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   288: invokestatic 150	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2600	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;Ljava/lang/String;)I
    //   291: istore_3
    //   292: new 152	com/tencent/mobileqq/mini/apkg/MiniAppConfig
    //   295: dup
    //   296: aload 5
    //   298: invokespecial 155	com/tencent/mobileqq/mini/apkg/MiniAppConfig:<init>	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   301: astore 6
    //   303: aload 6
    //   305: getfield 159	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   308: iload_2
    //   309: putfield 124	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   312: aload 6
    //   314: ldc 161
    //   316: ldc 163
    //   318: aconst_null
    //   319: iload_3
    //   320: invokestatic 169	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   323: invokestatic 175	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC04239:reportAsync	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   326: aload 5
    //   328: getfield 178	com/tencent/mobileqq/mini/apkg/MiniAppInfo:amsAdInfo	Ljava/lang/String;
    //   331: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   334: istore 4
    //   336: iload 4
    //   338: ifne +79 -> 417
    //   341: new 186	org/json/JSONObject
    //   344: dup
    //   345: aload 5
    //   347: getfield 178	com/tencent/mobileqq/mini/apkg/MiniAppInfo:amsAdInfo	Ljava/lang/String;
    //   350: invokespecial 189	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   353: astore 6
    //   355: ldc 191
    //   357: new 191	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   360: dup
    //   361: invokespecial 192	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   364: aload 6
    //   366: invokestatic 198	acvb:a	(Lcom/tencent/mobileqq/pb/PBField;Ljava/lang/Object;)Lcom/tencent/mobileqq/pb/PBField;
    //   369: invokevirtual 204	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   372: checkcast 191	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   375: getfield 208	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   378: getfield 214	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   381: invokevirtual 218	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   384: astore 6
    //   386: aload 6
    //   388: invokestatic 223	com/tencent/mobileqq/mini/entry/MiniAppUtils:reportMiniAppAd	(Ljava/lang/String;)V
    //   391: ldc 38
    //   393: iconst_1
    //   394: new 40	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   401: ldc 225
    //   403: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload 6
    //   408: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aload 5
    //   419: getfield 228	com/tencent/mobileqq/mini/apkg/MiniAppInfo:tianshuAdId	I
    //   422: ifle -376 -> 46
    //   425: ldc 230
    //   427: ldc 230
    //   429: aload 5
    //   431: getfield 228	com/tencent/mobileqq/mini/apkg/MiniAppInfo:tianshuAdId	I
    //   434: invokestatic 169	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   437: bipush 102
    //   439: invokestatic 234	com/tencent/mobileqq/mini/entry/MiniAppUtils:miniAppTianShuReport	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   442: goto -396 -> 46
    //   445: astore 5
    //   447: aload 5
    //   449: invokevirtual 237	com/tencent/mobileqq/mini/sdk/MiniAppException:printStackTrace	()V
    //   452: goto -406 -> 46
    //   455: sipush 3001
    //   458: istore_2
    //   459: goto -350 -> 109
    //   462: aload 6
    //   464: getfield 99	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   467: iconst_2
    //   468: if_icmpne +10 -> 478
    //   471: sipush 3002
    //   474: istore_2
    //   475: goto -366 -> 109
    //   478: aload 6
    //   480: getfield 99	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   483: iconst_3
    //   484: if_icmpne +78 -> 562
    //   487: iload 4
    //   489: ifeq +10 -> 499
    //   492: sipush 3021
    //   495: istore_2
    //   496: goto -387 -> 109
    //   499: sipush 3003
    //   502: istore_2
    //   503: goto -7 -> 496
    //   506: aload_0
    //   507: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$3:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   510: invokestatic 128	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2500	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;)Ljava/lang/ref/WeakReference;
    //   513: invokevirtual 133	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   516: checkcast 239	android/app/Activity
    //   519: aload 5
    //   521: iload_2
    //   522: invokestatic 243	com/tencent/mobileqq/mini/sdk/MiniAppController:launchMiniAppByAppInfo	(Landroid/app/Activity;Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;I)V
    //   525: goto -246 -> 279
    //   528: astore 6
    //   530: ldc 38
    //   532: iconst_1
    //   533: new 40	java/lang/StringBuilder
    //   536: dup
    //   537: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   540: ldc 245
    //   542: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: aload 6
    //   547: invokestatic 251	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   550: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 254	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   559: goto -142 -> 417
    //   562: sipush 9999
    //   565: istore_2
    //   566: goto -457 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	this	3
    //   0	569	1	paramView	android.view.View
    //   108	458	2	i	int
    //   291	29	3	j	int
    //   89	399	4	bool	boolean
    //   4	426	5	localObject1	Object
    //   445	75	5	localMiniAppException	com.tencent.mobileqq.mini.sdk.MiniAppException
    //   68	411	6	localObject2	Object
    //   528	18	6	localException	java.lang.Exception
    //   187	29	7	localLaunchParam	com.tencent.mobileqq.mini.sdk.LaunchParam
    // Exception table:
    //   from	to	target	type
    //   109	279	445	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   279	336	445	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   341	417	445	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   417	442	445	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   506	525	445	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   530	559	445	com/tencent/mobileqq/mini/sdk/MiniAppException
    //   341	417	528	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.3
 * JD-Core Version:    0.7.0.1
 */