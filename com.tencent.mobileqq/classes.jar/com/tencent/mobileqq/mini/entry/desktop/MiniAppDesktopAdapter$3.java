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
    //   1: invokevirtual 26	android/view/View:getTag	()Ljava/lang/Object;
    //   4: astore 5
    //   6: aload 5
    //   8: instanceof 28
    //   11: ifne +43 -> 54
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
    //   46: invokestatic 62	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   49: aload_1
    //   50: invokevirtual 65	com/tencent/qqlive/module/videoreport/collect/EventCollector:onViewClicked	(Landroid/view/View;)V
    //   53: return
    //   54: aload_1
    //   55: invokevirtual 69	android/view/View:getParent	()Landroid/view/ViewParent;
    //   58: checkcast 71	android/support/v7/widget/RecyclerView
    //   61: aload_1
    //   62: invokevirtual 75	android/support/v7/widget/RecyclerView:getChildViewHolder	(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    //   65: checkcast 77	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder
    //   68: astore 6
    //   70: aload 6
    //   72: getfield 81	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:miniAppInfo	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   75: astore 5
    //   77: aload_0
    //   78: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$3:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   81: aload 5
    //   83: getfield 87	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   86: invokestatic 93	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2400	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;Ljava/lang/String;)Z
    //   89: istore 4
    //   91: aload 6
    //   93: getfield 97	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   96: iconst_1
    //   97: if_icmpne +389 -> 486
    //   100: iload 4
    //   102: ifeq +377 -> 479
    //   105: sipush 3020
    //   108: istore_2
    //   109: ldc 36
    //   111: iconst_1
    //   112: new 38	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   119: ldc 99
    //   121: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 5
    //   126: getfield 87	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   129: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 101
    //   134: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 6
    //   139: getfield 97	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   142: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload 6
    //   153: getfield 97	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   156: iconst_2
    //   157: if_icmpne +373 -> 530
    //   160: aload 6
    //   162: getfield 111	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:desktopAppInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   165: ifnull +365 -> 530
    //   168: aload 6
    //   170: getfield 111	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:desktopAppInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   173: getfield 116	com/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo:fromBackup	I
    //   176: iconst_1
    //   177: if_icmpne +353 -> 530
    //   180: new 118	com/tencent/mobileqq/mini/sdk/LaunchParam
    //   183: dup
    //   184: invokespecial 119	com/tencent/mobileqq/mini/sdk/LaunchParam:<init>	()V
    //   187: astore 7
    //   189: aload 7
    //   191: iload_2
    //   192: putfield 122	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   195: aload_0
    //   196: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$3:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   199: invokestatic 126	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2500	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;)Ljava/lang/ref/WeakReference;
    //   202: invokevirtual 131	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   205: checkcast 133	android/content/Context
    //   208: aload 5
    //   210: getfield 87	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   213: aconst_null
    //   214: aconst_null
    //   215: aload 7
    //   217: aconst_null
    //   218: invokestatic 139	com/tencent/mobileqq/mini/sdk/MiniAppController:startAppByAppid	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/sdk/LaunchParam;Lcom/tencent/mobileqq/mini/sdk/MiniAppLauncher$MiniAppLaunchListener;)V
    //   221: ldc 36
    //   223: iconst_1
    //   224: new 38	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   231: ldc 99
    //   233: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload 5
    //   238: getfield 87	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   241: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc 101
    //   246: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 6
    //   251: getfield 97	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   254: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: ldc 141
    //   259: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload 6
    //   264: getfield 111	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:desktopAppInfo	Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;
    //   267: getfield 116	com/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo:fromBackup	I
    //   270: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 144	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: aload_0
    //   280: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$3:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   283: aload 5
    //   285: getfield 87	com/tencent/mobileqq/mini/apkg/MiniAppInfo:appId	Ljava/lang/String;
    //   288: invokestatic 148	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2600	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;Ljava/lang/String;)I
    //   291: istore_3
    //   292: new 150	com/tencent/mobileqq/mini/apkg/MiniAppConfig
    //   295: dup
    //   296: aload 5
    //   298: invokespecial 153	com/tencent/mobileqq/mini/apkg/MiniAppConfig:<init>	(Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;)V
    //   301: astore 6
    //   303: aload 6
    //   305: getfield 157	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   308: iload_2
    //   309: putfield 122	com/tencent/mobileqq/mini/sdk/LaunchParam:scene	I
    //   312: aload 6
    //   314: ldc 159
    //   316: ldc 161
    //   318: aconst_null
    //   319: iload_3
    //   320: invokestatic 167	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   323: invokestatic 173	com/tencent/mobileqq/mini/report/MiniProgramLpReportDC04239:reportAsync	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   326: aload 5
    //   328: getfield 176	com/tencent/mobileqq/mini/apkg/MiniAppInfo:amsAdInfo	Ljava/lang/String;
    //   331: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   334: istore 4
    //   336: iload 4
    //   338: ifne +79 -> 417
    //   341: new 184	org/json/JSONObject
    //   344: dup
    //   345: aload 5
    //   347: getfield 176	com/tencent/mobileqq/mini/apkg/MiniAppInfo:amsAdInfo	Ljava/lang/String;
    //   350: invokespecial 187	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   353: astore 6
    //   355: ldc 189
    //   357: new 189	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   360: dup
    //   361: invokespecial 190	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   364: aload 6
    //   366: invokestatic 196	abrk:a	(Lcom/tencent/mobileqq/pb/PBField;Ljava/lang/Object;)Lcom/tencent/mobileqq/pb/PBField;
    //   369: invokevirtual 202	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   372: checkcast 189	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   375: getfield 206	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   378: getfield 212	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   381: invokevirtual 216	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   384: astore 6
    //   386: aload 6
    //   388: invokestatic 221	com/tencent/mobileqq/mini/entry/MiniAppUtils:reportMiniAppAd	(Ljava/lang/String;)V
    //   391: ldc 36
    //   393: iconst_1
    //   394: new 38	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   401: ldc 223
    //   403: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload 6
    //   408: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aload 5
    //   419: getfield 226	com/tencent/mobileqq/mini/apkg/MiniAppInfo:tianshuAdId	I
    //   422: ifle -376 -> 46
    //   425: ldc 228
    //   427: ldc 228
    //   429: aload 5
    //   431: getfield 226	com/tencent/mobileqq/mini/apkg/MiniAppInfo:tianshuAdId	I
    //   434: invokestatic 167	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   437: bipush 102
    //   439: invokestatic 232	com/tencent/mobileqq/mini/entry/MiniAppUtils:miniAppTianShuReport	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   442: goto -396 -> 46
    //   445: astore 5
    //   447: ldc 36
    //   449: iconst_1
    //   450: new 38	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   457: ldc 234
    //   459: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload 5
    //   464: invokestatic 240	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   467: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: goto -430 -> 46
    //   479: sipush 3001
    //   482: istore_2
    //   483: goto -374 -> 109
    //   486: aload 6
    //   488: getfield 97	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   491: iconst_2
    //   492: if_icmpne +10 -> 502
    //   495: sipush 3002
    //   498: istore_2
    //   499: goto -390 -> 109
    //   502: aload 6
    //   504: getfield 97	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$MicroAppViewHolder:moduleType	I
    //   507: iconst_3
    //   508: if_icmpne +78 -> 586
    //   511: iload 4
    //   513: ifeq +10 -> 523
    //   516: sipush 3021
    //   519: istore_2
    //   520: goto -411 -> 109
    //   523: sipush 3003
    //   526: istore_2
    //   527: goto -7 -> 520
    //   530: aload_0
    //   531: getfield 12	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter$3:this$0	Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;
    //   534: invokestatic 126	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:access$2500	(Lcom/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter;)Ljava/lang/ref/WeakReference;
    //   537: invokevirtual 131	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   540: checkcast 245	android/app/Activity
    //   543: aload 5
    //   545: iload_2
    //   546: invokestatic 249	com/tencent/mobileqq/mini/entry/desktop/MiniAppDesktopAdapter:startMiniApp	(Landroid/app/Activity;Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;I)V
    //   549: goto -270 -> 279
    //   552: astore 6
    //   554: ldc 36
    //   556: iconst_1
    //   557: new 38	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   564: ldc 251
    //   566: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload 6
    //   571: invokestatic 240	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   574: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   583: goto -166 -> 417
    //   586: sipush 9999
    //   589: istore_2
    //   590: goto -481 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	593	0	this	3
    //   0	593	1	paramView	android.view.View
    //   108	482	2	i	int
    //   291	29	3	j	int
    //   89	423	4	bool	boolean
    //   4	426	5	localObject1	Object
    //   445	99	5	localException1	java.lang.Exception
    //   68	435	6	localObject2	Object
    //   552	18	6	localException2	java.lang.Exception
    //   187	29	7	localLaunchParam	com.tencent.mobileqq.mini.sdk.LaunchParam
    // Exception table:
    //   from	to	target	type
    //   109	279	445	java/lang/Exception
    //   279	336	445	java/lang/Exception
    //   417	442	445	java/lang/Exception
    //   530	549	445	java/lang/Exception
    //   554	583	445	java/lang/Exception
    //   341	417	552	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.3
 * JD-Core Version:    0.7.0.1
 */