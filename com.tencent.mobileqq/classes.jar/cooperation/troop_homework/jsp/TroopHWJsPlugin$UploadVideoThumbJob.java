package cooperation.troop_homework.jsp;

class TroopHWJsPlugin$UploadVideoThumbJob
  implements Runnable
{
  TroopHWJsPlugin.UploadMediaEntry a;
  TroopHWJsPlugin.UploadVideoThumbCallback b;
  protected boolean c = false;
  
  public TroopHWJsPlugin$UploadVideoThumbJob(TroopHWJsPlugin paramTroopHWJsPlugin, TroopHWJsPlugin.UploadMediaEntry paramUploadMediaEntry, TroopHWJsPlugin.UploadVideoThumbCallback paramUploadVideoThumbCallback, boolean paramBoolean)
  {
    this.a = paramUploadMediaEntry;
    this.b = paramUploadVideoThumbCallback;
    this.c = paramBoolean;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 33	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: ldc 36
    //   13: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 4
    //   19: aload_0
    //   20: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   23: getfield 45	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:c	I
    //   26: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 50
    //   32: iconst_2
    //   33: aload 4
    //   35: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_0
    //   42: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   45: getfield 63	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:d	Landroid/graphics/Bitmap;
    //   48: ifnull +694 -> 742
    //   51: aload_0
    //   52: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   55: getfield 63	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:d	Landroid/graphics/Bitmap;
    //   58: invokevirtual 69	android/graphics/Bitmap:isRecycled	()Z
    //   61: ifne +681 -> 742
    //   64: aload_0
    //   65: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   68: getfield 73	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:h	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   71: invokevirtual 78	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   74: ifne +668 -> 742
    //   77: aload_0
    //   78: getfield 23	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:c	Z
    //   81: ifeq +10 -> 91
    //   84: ldc 80
    //   86: astore 6
    //   88: goto +7 -> 95
    //   91: ldc 82
    //   93: astore 6
    //   95: aload_0
    //   96: getfield 18	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:this$0	Lcooperation/troop_homework/jsp/TroopHWJsPlugin;
    //   99: getfield 88	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   102: invokevirtual 93	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   105: astore 5
    //   107: aload 5
    //   109: iconst_2
    //   110: invokevirtual 99	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   113: checkcast 101	mqq/manager/TicketManager
    //   116: astore 4
    //   118: aload 5
    //   120: invokevirtual 104	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   123: astore 7
    //   125: aload 4
    //   127: aload 7
    //   129: invokeinterface 108 2 0
    //   134: astore 8
    //   136: new 33	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   143: astore 4
    //   145: aload 4
    //   147: getstatic 114	com/tencent/mobileqq/app/AppConstants:SDCARD_FILE_SAVE_TROOPTMP_PATH	Ljava/lang/String;
    //   150: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 4
    //   156: ldc 116
    //   158: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: new 118	java/io/File
    //   165: dup
    //   166: aload 4
    //   168: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: astore 4
    //   176: aload 4
    //   178: astore 5
    //   180: aload_0
    //   181: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   184: getfield 63	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:d	Landroid/graphics/Bitmap;
    //   187: aload 4
    //   189: invokestatic 126	com/tencent/mobileqq/utils/BaseImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   192: aload 4
    //   194: astore 5
    //   196: aload_0
    //   197: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   200: getfield 73	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:h	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   203: invokevirtual 78	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   206: ifeq +87 -> 293
    //   209: aload 4
    //   211: astore 5
    //   213: new 33	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   220: astore 6
    //   222: aload 4
    //   224: astore 5
    //   226: aload 6
    //   228: ldc 128
    //   230: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 4
    //   236: astore 5
    //   238: aload 6
    //   240: aload_0
    //   241: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   244: getfield 45	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:c	I
    //   247: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 4
    //   253: astore 5
    //   255: ldc 50
    //   257: iconst_2
    //   258: aload 6
    //   260: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: aload_0
    //   267: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   270: getfield 63	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:d	Landroid/graphics/Bitmap;
    //   273: ifnull +13 -> 286
    //   276: aload_0
    //   277: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   280: getfield 63	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:d	Landroid/graphics/Bitmap;
    //   283: invokevirtual 131	android/graphics/Bitmap:recycle	()V
    //   286: aload 4
    //   288: invokevirtual 134	java/io/File:delete	()Z
    //   291: pop
    //   292: return
    //   293: aload 4
    //   295: astore 5
    //   297: aload 4
    //   299: invokevirtual 137	java/io/File:exists	()Z
    //   302: ifeq +295 -> 597
    //   305: aload 4
    //   307: astore 5
    //   309: new 33	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   316: astore 9
    //   318: aload 4
    //   320: astore 5
    //   322: aload 9
    //   324: ldc 139
    //   326: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 4
    //   332: astore 5
    //   334: aload 9
    //   336: aload 4
    //   338: invokevirtual 142	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   341: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 4
    //   347: astore 5
    //   349: aload 9
    //   351: ldc 144
    //   353: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload 4
    //   359: astore 5
    //   361: aload 9
    //   363: aload 4
    //   365: invokevirtual 148	java/io/File:length	()J
    //   368: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 4
    //   374: astore 5
    //   376: ldc 50
    //   378: iconst_2
    //   379: aload 9
    //   381: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: aload 4
    //   389: astore 5
    //   391: aload 6
    //   393: aload 4
    //   395: invokevirtual 142	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   398: aload 7
    //   400: aload 8
    //   402: ldc2_w 152
    //   405: invokestatic 158	cooperation/troop_homework/TroopHomeworkHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   408: astore 6
    //   410: aload 4
    //   412: astore 5
    //   414: aload_0
    //   415: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   418: getfield 73	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:h	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   421: invokevirtual 78	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   424: istore_3
    //   425: iload_3
    //   426: ifeq +30 -> 456
    //   429: aload_0
    //   430: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   433: getfield 63	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:d	Landroid/graphics/Bitmap;
    //   436: ifnull +13 -> 449
    //   439: aload_0
    //   440: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   443: getfield 63	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:d	Landroid/graphics/Bitmap;
    //   446: invokevirtual 131	android/graphics/Bitmap:recycle	()V
    //   449: aload 4
    //   451: invokevirtual 134	java/io/File:delete	()Z
    //   454: pop
    //   455: return
    //   456: aload 4
    //   458: astore 5
    //   460: aload 6
    //   462: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   465: istore_3
    //   466: iconst_1
    //   467: istore_2
    //   468: iload_3
    //   469: ifne +274 -> 743
    //   472: aload 4
    //   474: astore 5
    //   476: new 166	org/json/JSONObject
    //   479: dup
    //   480: aload 6
    //   482: invokespecial 167	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   485: astore 6
    //   487: aload 4
    //   489: astore 5
    //   491: aload 6
    //   493: ldc 169
    //   495: iconst_m1
    //   496: invokevirtual 173	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   499: ifne +244 -> 743
    //   502: aload 4
    //   504: astore 5
    //   506: aload 6
    //   508: ldc 175
    //   510: invokevirtual 179	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   513: astore 6
    //   515: aload 6
    //   517: ifnull +226 -> 743
    //   520: aload 4
    //   522: astore 5
    //   524: aload 6
    //   526: ldc 181
    //   528: invokevirtual 184	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   531: astore 6
    //   533: iload_2
    //   534: istore_1
    //   535: aload 4
    //   537: astore 5
    //   539: aload_0
    //   540: getfield 27	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbCallback;
    //   543: ifnull +24 -> 567
    //   546: aload 4
    //   548: astore 5
    //   550: aload_0
    //   551: getfield 27	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbCallback;
    //   554: iconst_1
    //   555: aload 6
    //   557: invokeinterface 189 3 0
    //   562: iload_2
    //   563: istore_1
    //   564: goto +3 -> 567
    //   567: iload_1
    //   568: ifne +29 -> 597
    //   571: aload 4
    //   573: astore 5
    //   575: aload_0
    //   576: getfield 27	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbCallback;
    //   579: ifnull +18 -> 597
    //   582: aload 4
    //   584: astore 5
    //   586: aload_0
    //   587: getfield 27	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:b	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbCallback;
    //   590: iconst_0
    //   591: aconst_null
    //   592: invokeinterface 189 3 0
    //   597: aload 4
    //   599: astore 5
    //   601: aload_0
    //   602: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   605: getfield 63	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:d	Landroid/graphics/Bitmap;
    //   608: ifnull +91 -> 699
    //   611: aload_0
    //   612: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   615: getfield 63	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:d	Landroid/graphics/Bitmap;
    //   618: invokevirtual 131	android/graphics/Bitmap:recycle	()V
    //   621: aload 4
    //   623: astore 5
    //   625: goto +74 -> 699
    //   628: astore 6
    //   630: goto +16 -> 646
    //   633: astore 4
    //   635: aconst_null
    //   636: astore 5
    //   638: goto +70 -> 708
    //   641: astore 6
    //   643: aconst_null
    //   644: astore 4
    //   646: aload 4
    //   648: astore 5
    //   650: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   653: ifeq +17 -> 670
    //   656: aload 4
    //   658: astore 5
    //   660: ldc 50
    //   662: iconst_2
    //   663: ldc 194
    //   665: aload 6
    //   667: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   670: aload_0
    //   671: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   674: getfield 63	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:d	Landroid/graphics/Bitmap;
    //   677: ifnull +13 -> 690
    //   680: aload_0
    //   681: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   684: getfield 63	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:d	Landroid/graphics/Bitmap;
    //   687: invokevirtual 131	android/graphics/Bitmap:recycle	()V
    //   690: aload 4
    //   692: ifnull +50 -> 742
    //   695: aload 4
    //   697: astore 5
    //   699: aload 5
    //   701: invokevirtual 134	java/io/File:delete	()Z
    //   704: pop
    //   705: return
    //   706: astore 4
    //   708: aload_0
    //   709: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   712: getfield 63	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:d	Landroid/graphics/Bitmap;
    //   715: ifnull +13 -> 728
    //   718: aload_0
    //   719: getfield 25	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadVideoThumbJob:a	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   722: getfield 63	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:d	Landroid/graphics/Bitmap;
    //   725: invokevirtual 131	android/graphics/Bitmap:recycle	()V
    //   728: aload 5
    //   730: ifnull +9 -> 739
    //   733: aload 5
    //   735: invokevirtual 134	java/io/File:delete	()Z
    //   738: pop
    //   739: aload 4
    //   741: athrow
    //   742: return
    //   743: iconst_0
    //   744: istore_1
    //   745: goto -178 -> 567
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	748	0	this	UploadVideoThumbJob
    //   534	211	1	i	int
    //   467	96	2	j	int
    //   424	45	3	bool	boolean
    //   7	615	4	localObject1	Object
    //   633	1	4	localObject2	Object
    //   644	52	4	localObject3	Object
    //   706	34	4	localObject4	Object
    //   105	629	5	localObject5	Object
    //   86	470	6	localObject6	Object
    //   628	1	6	localException1	java.lang.Exception
    //   641	25	6	localException2	java.lang.Exception
    //   123	276	7	str1	java.lang.String
    //   134	267	8	str2	java.lang.String
    //   316	64	9	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   180	192	628	java/lang/Exception
    //   196	209	628	java/lang/Exception
    //   213	222	628	java/lang/Exception
    //   226	234	628	java/lang/Exception
    //   238	251	628	java/lang/Exception
    //   255	266	628	java/lang/Exception
    //   297	305	628	java/lang/Exception
    //   309	318	628	java/lang/Exception
    //   322	330	628	java/lang/Exception
    //   334	345	628	java/lang/Exception
    //   349	357	628	java/lang/Exception
    //   361	372	628	java/lang/Exception
    //   376	387	628	java/lang/Exception
    //   391	410	628	java/lang/Exception
    //   414	425	628	java/lang/Exception
    //   460	466	628	java/lang/Exception
    //   476	487	628	java/lang/Exception
    //   491	502	628	java/lang/Exception
    //   506	515	628	java/lang/Exception
    //   524	533	628	java/lang/Exception
    //   539	546	628	java/lang/Exception
    //   550	562	628	java/lang/Exception
    //   575	582	628	java/lang/Exception
    //   586	597	628	java/lang/Exception
    //   136	176	633	finally
    //   136	176	641	java/lang/Exception
    //   180	192	706	finally
    //   196	209	706	finally
    //   213	222	706	finally
    //   226	234	706	finally
    //   238	251	706	finally
    //   255	266	706	finally
    //   297	305	706	finally
    //   309	318	706	finally
    //   322	330	706	finally
    //   334	345	706	finally
    //   349	357	706	finally
    //   361	372	706	finally
    //   376	387	706	finally
    //   391	410	706	finally
    //   414	425	706	finally
    //   460	466	706	finally
    //   476	487	706	finally
    //   491	502	706	finally
    //   506	515	706	finally
    //   524	533	706	finally
    //   539	546	706	finally
    //   550	562	706	finally
    //   575	582	706	finally
    //   586	597	706	finally
    //   650	656	706	finally
    //   660	670	706	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadVideoThumbJob
 * JD-Core Version:    0.7.0.1
 */