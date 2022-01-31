package dov.com.qq.im;

public class QIMCameraUtil
{
  /* Error */
  public static android.graphics.Bitmap a(android.content.Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 12
    //   12: aload_0
    //   13: ifnonnull +9 -> 22
    //   16: aconst_null
    //   17: astore 10
    //   19: aload 10
    //   21: areturn
    //   22: aload_0
    //   23: invokevirtual 19	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   26: astore 13
    //   28: lconst_0
    //   29: lstore_3
    //   30: iload_1
    //   31: ifeq +597 -> 628
    //   34: aload 13
    //   36: getstatic 25	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 31	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_0
    //   47: aload_0
    //   48: ifnull +571 -> 619
    //   51: aload_0
    //   52: astore 10
    //   54: aload_0
    //   55: invokeinterface 37 1 0
    //   60: istore_1
    //   61: iload_1
    //   62: ifeq +557 -> 619
    //   65: lconst_0
    //   66: lstore_3
    //   67: aload_0
    //   68: astore 10
    //   70: lload_3
    //   71: lstore 7
    //   73: aload 12
    //   75: astore 11
    //   77: aload_0
    //   78: aload_0
    //   79: ldc 39
    //   81: invokeinterface 43 2 0
    //   86: invokeinterface 47 2 0
    //   91: istore_2
    //   92: aload_0
    //   93: astore 10
    //   95: lload_3
    //   96: lstore 7
    //   98: aload 12
    //   100: astore 11
    //   102: aload_0
    //   103: aload_0
    //   104: ldc 49
    //   106: invokeinterface 43 2 0
    //   111: invokeinterface 53 2 0
    //   116: aload_0
    //   117: aload_0
    //   118: ldc 55
    //   120: invokeinterface 43 2 0
    //   125: invokeinterface 53 2 0
    //   130: invokestatic 61	java/lang/Math:max	(JJ)J
    //   133: lstore 5
    //   135: aload_0
    //   136: astore 10
    //   138: lload 5
    //   140: lstore 7
    //   142: aload 12
    //   144: astore 11
    //   146: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +39 -> 188
    //   152: aload_0
    //   153: astore 10
    //   155: lload 5
    //   157: lstore 7
    //   159: aload 12
    //   161: astore 11
    //   163: ldc 68
    //   165: iconst_2
    //   166: new 70	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   173: ldc 73
    //   175: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload_2
    //   179: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aload_0
    //   189: astore 10
    //   191: lload 5
    //   193: lstore 7
    //   195: aload 12
    //   197: astore 11
    //   199: aload 13
    //   201: iload_2
    //   202: i2l
    //   203: iconst_3
    //   204: aconst_null
    //   205: invokestatic 94	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   208: astore 9
    //   210: aload 9
    //   212: ifnull +197 -> 409
    //   215: lload 5
    //   217: lstore_3
    //   218: lload_3
    //   219: lstore 5
    //   221: aload_0
    //   222: astore 11
    //   224: aload 9
    //   226: astore 10
    //   228: aload_0
    //   229: ifnull +377 -> 606
    //   232: aload_0
    //   233: invokeinterface 97 1 0
    //   238: aload 13
    //   240: getstatic 100	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   243: aconst_null
    //   244: aconst_null
    //   245: aconst_null
    //   246: aconst_null
    //   247: invokevirtual 31	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   250: astore 10
    //   252: aload 10
    //   254: astore_0
    //   255: aload_0
    //   256: ifnull +262 -> 518
    //   259: aload_0
    //   260: astore 10
    //   262: aload_0
    //   263: invokeinterface 37 1 0
    //   268: ifeq +250 -> 518
    //   271: aload_0
    //   272: astore 10
    //   274: aload_0
    //   275: aload_0
    //   276: ldc 39
    //   278: invokeinterface 43 2 0
    //   283: invokeinterface 47 2 0
    //   288: istore_2
    //   289: aload_0
    //   290: astore 10
    //   292: aload_0
    //   293: aload_0
    //   294: ldc 49
    //   296: invokeinterface 43 2 0
    //   301: invokeinterface 53 2 0
    //   306: aload_0
    //   307: aload_0
    //   308: ldc 55
    //   310: invokeinterface 43 2 0
    //   315: invokeinterface 53 2 0
    //   320: invokestatic 61	java/lang/Math:max	(JJ)J
    //   323: lstore 5
    //   325: aload_0
    //   326: astore 10
    //   328: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq +31 -> 362
    //   334: aload_0
    //   335: astore 10
    //   337: ldc 68
    //   339: iconst_2
    //   340: new 70	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   347: ldc 102
    //   349: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: iload_2
    //   353: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: aload_0
    //   363: astore 10
    //   365: aload 13
    //   367: iload_2
    //   368: i2l
    //   369: iconst_3
    //   370: aconst_null
    //   371: invokestatic 105	android/provider/MediaStore$Images$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   374: astore 11
    //   376: aload 11
    //   378: ifnull +126 -> 504
    //   381: lload 5
    //   383: lload_3
    //   384: lcmp
    //   385: ifle +133 -> 518
    //   388: aload 11
    //   390: astore 9
    //   392: aload 9
    //   394: astore 10
    //   396: aload_0
    //   397: ifnull -378 -> 19
    //   400: aload_0
    //   401: invokeinterface 97 1 0
    //   406: aload 9
    //   408: areturn
    //   409: aload_0
    //   410: astore 10
    //   412: lload 5
    //   414: lstore 7
    //   416: aload 9
    //   418: astore 11
    //   420: aload_0
    //   421: invokeinterface 108 1 0
    //   426: istore_1
    //   427: lload 5
    //   429: lstore_3
    //   430: aload 9
    //   432: astore 12
    //   434: iload_1
    //   435: ifne -368 -> 67
    //   438: lload 5
    //   440: lstore_3
    //   441: goto -223 -> 218
    //   444: astore 12
    //   446: lconst_0
    //   447: lstore_3
    //   448: aconst_null
    //   449: astore_0
    //   450: aload_0
    //   451: astore 10
    //   453: ldc 68
    //   455: iconst_2
    //   456: ldc 110
    //   458: aload 12
    //   460: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   463: lload_3
    //   464: lstore 5
    //   466: aload_0
    //   467: astore 11
    //   469: aload 9
    //   471: astore 10
    //   473: aload_0
    //   474: ifnull +132 -> 606
    //   477: aload_0
    //   478: invokeinterface 97 1 0
    //   483: goto -245 -> 238
    //   486: astore_0
    //   487: aconst_null
    //   488: astore 10
    //   490: aload 10
    //   492: ifnull +10 -> 502
    //   495: aload 10
    //   497: invokeinterface 97 1 0
    //   502: aload_0
    //   503: athrow
    //   504: aload_0
    //   505: astore 10
    //   507: aload_0
    //   508: invokeinterface 108 1 0
    //   513: istore_1
    //   514: iload_1
    //   515: ifne -244 -> 271
    //   518: goto -126 -> 392
    //   521: astore 11
    //   523: aload_0
    //   524: astore 10
    //   526: ldc 68
    //   528: iconst_2
    //   529: ldc 116
    //   531: aload 11
    //   533: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   536: aload_0
    //   537: ifnull +66 -> 603
    //   540: aload_0
    //   541: invokeinterface 97 1 0
    //   546: aload 9
    //   548: areturn
    //   549: astore 9
    //   551: aload_0
    //   552: astore 10
    //   554: aload 9
    //   556: astore_0
    //   557: aload 10
    //   559: ifnull +10 -> 569
    //   562: aload 10
    //   564: invokeinterface 97 1 0
    //   569: aload_0
    //   570: athrow
    //   571: astore_0
    //   572: goto -15 -> 557
    //   575: astore 11
    //   577: goto -54 -> 523
    //   580: astore_0
    //   581: goto -91 -> 490
    //   584: astore 12
    //   586: lconst_0
    //   587: lstore_3
    //   588: goto -138 -> 450
    //   591: astore 12
    //   593: lload 7
    //   595: lstore_3
    //   596: aload 11
    //   598: astore 9
    //   600: goto -150 -> 450
    //   603: aload 9
    //   605: areturn
    //   606: lload 5
    //   608: lstore_3
    //   609: aload 11
    //   611: astore_0
    //   612: aload 10
    //   614: astore 9
    //   616: goto -378 -> 238
    //   619: lconst_0
    //   620: lstore_3
    //   621: aload 11
    //   623: astore 9
    //   625: goto -407 -> 218
    //   628: aconst_null
    //   629: astore_0
    //   630: aload 10
    //   632: astore 9
    //   634: goto -396 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	637	0	paramContext	android.content.Context
    //   0	637	1	paramBoolean	boolean
    //   91	277	2	i	int
    //   29	592	3	l1	long
    //   133	474	5	l2	long
    //   71	523	7	l3	long
    //   7	540	9	localObject1	Object
    //   549	6	9	localObject2	Object
    //   598	35	9	localObject3	Object
    //   4	627	10	localObject4	Object
    //   1	467	11	localObject5	Object
    //   521	11	11	localException1	java.lang.Exception
    //   575	47	11	localException2	java.lang.Exception
    //   10	423	12	localObject6	Object
    //   444	15	12	localException3	java.lang.Exception
    //   584	1	12	localException4	java.lang.Exception
    //   591	1	12	localException5	java.lang.Exception
    //   26	340	13	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   34	47	444	java/lang/Exception
    //   34	47	486	finally
    //   238	252	521	java/lang/Exception
    //   238	252	549	finally
    //   262	271	571	finally
    //   274	289	571	finally
    //   292	325	571	finally
    //   328	334	571	finally
    //   337	362	571	finally
    //   365	376	571	finally
    //   507	514	571	finally
    //   526	536	571	finally
    //   262	271	575	java/lang/Exception
    //   274	289	575	java/lang/Exception
    //   292	325	575	java/lang/Exception
    //   328	334	575	java/lang/Exception
    //   337	362	575	java/lang/Exception
    //   365	376	575	java/lang/Exception
    //   507	514	575	java/lang/Exception
    //   54	61	580	finally
    //   77	92	580	finally
    //   102	135	580	finally
    //   146	152	580	finally
    //   163	188	580	finally
    //   199	210	580	finally
    //   420	427	580	finally
    //   453	463	580	finally
    //   54	61	584	java/lang/Exception
    //   77	92	591	java/lang/Exception
    //   102	135	591	java/lang/Exception
    //   146	152	591	java/lang/Exception
    //   163	188	591	java/lang/Exception
    //   199	210	591	java/lang/Exception
    //   420	427	591	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraUtil
 * JD-Core Version:    0.7.0.1
 */