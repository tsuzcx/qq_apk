package com.tencent.mobileqq.emoticonview;

class FastImagePreviewLayout$2
  implements Runnable
{
  FastImagePreviewLayout$2(FastImagePreviewLayout paramFastImagePreviewLayout) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: invokestatic 31	android/os/SystemClock:elapsedRealtime	()J
    //   5: pop2
    //   6: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +12 -> 21
    //   12: getstatic 43	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:TAG	Ljava/lang/String;
    //   15: iconst_2
    //   16: ldc 45
    //   18: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: getfield 12	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout$2:this$0	Lcom/tencent/mobileqq/emoticonview/FastImagePreviewLayout;
    //   25: getfield 53	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:context	Landroid/content/Context;
    //   28: sipush 210
    //   31: iconst_1
    //   32: getstatic 59	com/tencent/mobileqq/activity/photo/MediaFileFilter:MEDIA_FILTER_SHOW_IMAGE	Lcom/tencent/mobileqq/activity/photo/MediaFileFilter;
    //   35: invokestatic 65	com/tencent/mobileqq/utils/AlbumUtil:queryRecentImages	(Landroid/content/Context;IILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   38: astore 6
    //   40: aload 6
    //   42: ifnull +524 -> 566
    //   45: aload 6
    //   47: invokeinterface 71 1 0
    //   52: ifle +514 -> 566
    //   55: aload 6
    //   57: iconst_0
    //   58: invokeinterface 75 2 0
    //   63: checkcast 77	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   66: astore 8
    //   68: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +33 -> 104
    //   74: getstatic 43	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:TAG	Ljava/lang/String;
    //   77: iconst_2
    //   78: new 79	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   85: ldc 82
    //   87: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 8
    //   92: getfield 89	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   95: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: getstatic 98	afcm:b	Ljava/lang/String;
    //   107: ifnull +33 -> 140
    //   110: getstatic 98	afcm:b	Ljava/lang/String;
    //   113: aload 8
    //   115: getfield 89	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   118: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: ifeq +19 -> 140
    //   124: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +12 -> 139
    //   130: getstatic 43	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:TAG	Ljava/lang/String;
    //   133: iconst_2
    //   134: ldc 106
    //   136: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: return
    //   140: aload 8
    //   142: getfield 89	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   145: putstatic 98	afcm:b	Ljava/lang/String;
    //   148: invokestatic 112	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   151: astore 6
    //   153: getstatic 118	android/os/Build$VERSION:SDK_INT	I
    //   156: bipush 10
    //   158: if_icmple +5 -> 163
    //   161: iconst_4
    //   162: istore_1
    //   163: aload 6
    //   165: ldc 120
    //   167: iload_1
    //   168: invokevirtual 124	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   171: ldc 126
    //   173: ldc 128
    //   175: invokeinterface 134 3 0
    //   180: astore 6
    //   182: getstatic 98	afcm:b	Ljava/lang/String;
    //   185: aload 6
    //   187: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: ifeq +19 -> 209
    //   193: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq -57 -> 139
    //   199: getstatic 43	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:TAG	Ljava/lang/String;
    //   202: iconst_2
    //   203: ldc 136
    //   205: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: return
    //   209: getstatic 139	afcm:a	Ljava/lang/String;
    //   212: ifnull +31 -> 243
    //   215: getstatic 98	afcm:b	Ljava/lang/String;
    //   218: getstatic 139	afcm:a	Ljava/lang/String;
    //   221: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   224: ifeq +19 -> 243
    //   227: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq -91 -> 139
    //   233: getstatic 43	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:TAG	Ljava/lang/String;
    //   236: iconst_2
    //   237: ldc 141
    //   239: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: return
    //   243: aload 8
    //   245: getfield 89	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   248: ldc 143
    //   250: invokevirtual 147	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   253: ifeq +19 -> 272
    //   256: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   259: ifeq -120 -> 139
    //   262: getstatic 43	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:TAG	Ljava/lang/String;
    //   265: iconst_2
    //   266: ldc 149
    //   268: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: return
    //   272: new 151	android/graphics/drawable/ColorDrawable
    //   275: dup
    //   276: ldc 152
    //   278: invokespecial 155	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   281: astore 9
    //   283: aconst_null
    //   284: astore 7
    //   286: aload_0
    //   287: getfield 12	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout$2:this$0	Lcom/tencent/mobileqq/emoticonview/FastImagePreviewLayout;
    //   290: getfield 53	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:context	Landroid/content/Context;
    //   293: invokevirtual 161	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   296: ldc 162
    //   298: invokevirtual 168	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   301: astore 6
    //   303: aload 8
    //   305: invokestatic 172	com/tencent/mobileqq/utils/AlbumUtil:generateAlbumThumbURL	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)Ljava/net/URL;
    //   308: astore 7
    //   310: getstatic 177	com/tencent/mobileqq/transfile/AlbumThumbDownloader:THUMB_WIDHT	I
    //   313: istore_1
    //   314: aload 8
    //   316: iload_1
    //   317: putfield 180	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   320: aload 8
    //   322: iload_1
    //   323: putfield 183	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   326: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   329: lstore_2
    //   330: lload_2
    //   331: aload 8
    //   333: getfield 192	com/tencent/mobileqq/activity/photo/LocalMediaInfo:addedDate	J
    //   336: ldc2_w 193
    //   339: lmul
    //   340: lsub
    //   341: lstore 4
    //   343: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   346: ifeq +65 -> 411
    //   349: getstatic 43	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:TAG	Ljava/lang/String;
    //   352: iconst_2
    //   353: new 79	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   360: ldc 196
    //   362: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: lload 4
    //   367: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   370: ldc 201
    //   372: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: lload_2
    //   376: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   379: ldc 203
    //   381: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload 8
    //   386: getfield 192	com/tencent/mobileqq/activity/photo/LocalMediaInfo:addedDate	J
    //   389: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   392: ldc 205
    //   394: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload 8
    //   399: getfield 208	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   402: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   405: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload_0
    //   412: getfield 12	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout$2:this$0	Lcom/tencent/mobileqq/emoticonview/FastImagePreviewLayout;
    //   415: getfield 211	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:mPicTimeInterval	J
    //   418: lconst_0
    //   419: lcmp
    //   420: ifne +34 -> 454
    //   423: invokestatic 216	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   426: getstatic 222	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:aio_fastimage	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   429: invokevirtual 225	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   432: ldc 227
    //   434: invokevirtual 229	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   437: astore 10
    //   439: aload_0
    //   440: getfield 12	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout$2:this$0	Lcom/tencent/mobileqq/emoticonview/FastImagePreviewLayout;
    //   443: aload 10
    //   445: invokestatic 235	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   448: invokevirtual 238	java/lang/Long:longValue	()J
    //   451: putfield 211	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:mPicTimeInterval	J
    //   454: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   457: ifeq +35 -> 492
    //   460: getstatic 43	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:TAG	Ljava/lang/String;
    //   463: iconst_2
    //   464: new 79	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   471: ldc 240
    //   473: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload_0
    //   477: getfield 12	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout$2:this$0	Lcom/tencent/mobileqq/emoticonview/FastImagePreviewLayout;
    //   480: getfield 211	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:mPicTimeInterval	J
    //   483: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   486: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   492: lload 4
    //   494: aload_0
    //   495: getfield 12	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout$2:this$0	Lcom/tencent/mobileqq/emoticonview/FastImagePreviewLayout;
    //   498: getfield 211	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:mPicTimeInterval	J
    //   501: lcmp
    //   502: ifge +64 -> 566
    //   505: aload_0
    //   506: getfield 12	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout$2:this$0	Lcom/tencent/mobileqq/emoticonview/FastImagePreviewLayout;
    //   509: aload 7
    //   511: aload 9
    //   513: aload 6
    //   515: invokestatic 245	com/tencent/mobileqq/transfile/URLDrawableHelper:getDrawable	(Ljava/net/URL;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Lcom/tencent/image/URLDrawable;
    //   518: putfield 249	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:fastImgDrawable	Lcom/tencent/image/URLDrawable;
    //   521: aload_0
    //   522: getfield 12	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout$2:this$0	Lcom/tencent/mobileqq/emoticonview/FastImagePreviewLayout;
    //   525: getfield 249	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:fastImgDrawable	Lcom/tencent/image/URLDrawable;
    //   528: aload 8
    //   530: invokevirtual 255	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   533: aload_0
    //   534: getfield 12	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout$2:this$0	Lcom/tencent/mobileqq/emoticonview/FastImagePreviewLayout;
    //   537: getfield 249	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:fastImgDrawable	Lcom/tencent/image/URLDrawable;
    //   540: invokevirtual 258	com/tencent/image/URLDrawable:startDownload	()V
    //   543: aload_0
    //   544: getfield 12	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout$2:this$0	Lcom/tencent/mobileqq/emoticonview/FastImagePreviewLayout;
    //   547: getfield 262	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:mHandler	Lmqq/os/MqqHandler;
    //   550: aload_0
    //   551: getfield 12	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout$2:this$0	Lcom/tencent/mobileqq/emoticonview/FastImagePreviewLayout;
    //   554: getfield 262	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:mHandler	Lmqq/os/MqqHandler;
    //   557: bipush 32
    //   559: invokevirtual 268	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   562: invokevirtual 272	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   565: pop
    //   566: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   569: ifeq -430 -> 139
    //   572: getstatic 43	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:TAG	Ljava/lang/String;
    //   575: iconst_2
    //   576: ldc_w 274
    //   579: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: return
    //   583: astore 10
    //   585: aload 7
    //   587: astore 6
    //   589: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   592: ifeq -289 -> 303
    //   595: getstatic 43	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:TAG	Ljava/lang/String;
    //   598: iconst_2
    //   599: new 79	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   606: ldc_w 276
    //   609: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: aload 10
    //   614: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   617: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   623: aload 7
    //   625: astore 6
    //   627: goto -324 -> 303
    //   630: astore 10
    //   632: aload 7
    //   634: astore 6
    //   636: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   639: ifeq -336 -> 303
    //   642: getstatic 43	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:TAG	Ljava/lang/String;
    //   645: iconst_2
    //   646: new 79	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   653: ldc_w 281
    //   656: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload 10
    //   661: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   664: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   670: aload 7
    //   672: astore 6
    //   674: goto -371 -> 303
    //   677: astore 10
    //   679: aload 7
    //   681: astore 6
    //   683: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   686: ifeq -383 -> 303
    //   689: getstatic 43	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:TAG	Ljava/lang/String;
    //   692: iconst_2
    //   693: new 79	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   700: ldc_w 283
    //   703: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: aload 10
    //   708: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   717: aload 7
    //   719: astore 6
    //   721: goto -418 -> 303
    //   724: astore 10
    //   726: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   729: ifeq +31 -> 760
    //   732: getstatic 43	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:TAG	Ljava/lang/String;
    //   735: iconst_2
    //   736: new 79	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   743: ldc_w 285
    //   746: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload 10
    //   751: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   754: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   760: aload_0
    //   761: getfield 12	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout$2:this$0	Lcom/tencent/mobileqq/emoticonview/FastImagePreviewLayout;
    //   764: ldc2_w 286
    //   767: putfield 211	com/tencent/mobileqq/emoticonview/FastImagePreviewLayout:mPicTimeInterval	J
    //   770: goto -316 -> 454
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	773	0	this	2
    //   1	322	1	i	int
    //   329	47	2	l1	long
    //   341	152	4	l2	long
    //   38	682	6	localObject	Object
    //   284	434	7	localURL	java.net.URL
    //   66	463	8	localLocalMediaInfo	com.tencent.mobileqq.activity.photo.LocalMediaInfo
    //   281	231	9	localColorDrawable	android.graphics.drawable.ColorDrawable
    //   437	7	10	str	java.lang.String
    //   583	30	10	localEmptyStackException	java.util.EmptyStackException
    //   630	30	10	localNullPointerException	java.lang.NullPointerException
    //   677	30	10	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   724	26	10	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   286	303	583	java/util/EmptyStackException
    //   286	303	630	java/lang/NullPointerException
    //   286	303	677	java/lang/OutOfMemoryError
    //   439	454	724	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FastImagePreviewLayout.2
 * JD-Core Version:    0.7.0.1
 */