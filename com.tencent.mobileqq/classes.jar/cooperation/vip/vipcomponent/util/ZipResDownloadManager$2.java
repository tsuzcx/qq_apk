package cooperation.vip.vipcomponent.util;

class ZipResDownloadManager$2
  implements Runnable
{
  ZipResDownloadManager$2(ZipResDownloadManager paramZipResDownloadManager, String paramString1, String paramString2, ZipResLoadListener paramZipResLoadListener, int paramInt) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:a	Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: invokestatic 41	cooperation/vip/vipcomponent/util/ZipResDownloadManager:c	(Ljava/lang/String;)Ljava/io/File;
    //   9: invokestatic 44	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Ljava/io/File;)Z
    //   12: ifeq +383 -> 395
    //   15: aload_3
    //   16: aload_0
    //   17: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:b	Ljava/lang/String;
    //   20: invokestatic 47	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   23: astore_2
    //   24: aload_2
    //   25: invokestatic 49	cooperation/vip/vipcomponent/util/ZipResDownloadManager:b	(Ljava/io/File;)Z
    //   28: ifeq +344 -> 372
    //   31: aload_0
    //   32: monitorenter
    //   33: aload_0
    //   34: getfield 19	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:this$0	Lcooperation/vip/vipcomponent/util/ZipResDownloadManager;
    //   37: invokestatic 52	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Lcooperation/vip/vipcomponent/util/ZipResDownloadManager;)Landroid/support/v4/util/LruCache;
    //   40: astore_1
    //   41: new 54	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   48: astore 4
    //   50: aload 4
    //   52: aload_3
    //   53: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 4
    //   59: ldc 61
    //   61: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 4
    //   67: aload_0
    //   68: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:b	Ljava/lang/String;
    //   71: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_1
    //   76: aload 4
    //   78: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokevirtual 71	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   84: checkcast 73	android/graphics/Bitmap
    //   87: astore_1
    //   88: aload_1
    //   89: ifnull +91 -> 180
    //   92: aload_0
    //   93: getfield 25	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:c	Lcooperation/vip/vipcomponent/util/ZipResLoadListener;
    //   96: ifnull +81 -> 177
    //   99: aload_0
    //   100: getfield 25	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:c	Lcooperation/vip/vipcomponent/util/ZipResLoadListener;
    //   103: astore_2
    //   104: aload_2
    //   105: monitorenter
    //   106: aload_0
    //   107: getfield 25	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:c	Lcooperation/vip/vipcomponent/util/ZipResLoadListener;
    //   110: astore 4
    //   112: aload 4
    //   114: aload 4
    //   116: getfield 78	cooperation/vip/vipcomponent/util/ZipResLoadListener:mCount	I
    //   119: iconst_1
    //   120: isub
    //   121: putfield 78	cooperation/vip/vipcomponent/util/ZipResLoadListener:mCount	I
    //   124: aload_2
    //   125: monitorexit
    //   126: aload_1
    //   127: sipush 320
    //   130: invokevirtual 82	android/graphics/Bitmap:setDensity	(I)V
    //   133: new 84	android/graphics/drawable/BitmapDrawable
    //   136: dup
    //   137: aload_1
    //   138: invokespecial 87	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   141: astore_2
    //   142: aload_2
    //   143: invokestatic 93	com/tencent/mobileqq/utils/ViewUtils:getDensityDpi	()F
    //   146: f2i
    //   147: invokevirtual 96	android/graphics/drawable/BitmapDrawable:setTargetDensity	(I)V
    //   150: aload_0
    //   151: getfield 25	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:c	Lcooperation/vip/vipcomponent/util/ZipResLoadListener;
    //   154: aload_3
    //   155: aload_0
    //   156: getfield 27	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:d	I
    //   159: aload_0
    //   160: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:b	Ljava/lang/String;
    //   163: aload_2
    //   164: invokevirtual 100	cooperation/vip/vipcomponent/util/ZipResLoadListener:onDownloaded	(Ljava/lang/String;ILjava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   167: goto +10 -> 177
    //   170: astore 4
    //   172: aload_2
    //   173: monitorexit
    //   174: aload 4
    //   176: athrow
    //   177: aload_0
    //   178: monitorexit
    //   179: return
    //   180: aload_2
    //   181: invokevirtual 105	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   184: aconst_null
    //   185: invokestatic 110	cooperation/vip/vipcomponent/VipUtils:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   188: astore_2
    //   189: aload_2
    //   190: astore_1
    //   191: goto +39 -> 230
    //   194: astore_2
    //   195: goto +14 -> 209
    //   198: astore_2
    //   199: goto +22 -> 221
    //   202: astore_1
    //   203: goto +165 -> 368
    //   206: astore_2
    //   207: aconst_null
    //   208: astore_1
    //   209: ldc 112
    //   211: aload_2
    //   212: invokevirtual 113	java/lang/Exception:toString	()Ljava/lang/String;
    //   215: invokestatic 119	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: goto +12 -> 230
    //   221: ldc 112
    //   223: aload_2
    //   224: invokevirtual 120	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   227: invokestatic 119	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload_0
    //   231: monitorexit
    //   232: aload_1
    //   233: ifnull +203 -> 436
    //   236: aload_0
    //   237: getfield 19	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:this$0	Lcooperation/vip/vipcomponent/util/ZipResDownloadManager;
    //   240: invokestatic 52	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Lcooperation/vip/vipcomponent/util/ZipResDownloadManager;)Landroid/support/v4/util/LruCache;
    //   243: astore_2
    //   244: new 54	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   251: astore 4
    //   253: aload 4
    //   255: aload_3
    //   256: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 4
    //   262: ldc 61
    //   264: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 4
    //   270: aload_0
    //   271: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:b	Ljava/lang/String;
    //   274: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_2
    //   279: aload 4
    //   281: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: aload_1
    //   285: invokevirtual 124	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   288: pop
    //   289: aload_0
    //   290: getfield 25	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:c	Lcooperation/vip/vipcomponent/util/ZipResLoadListener;
    //   293: astore_2
    //   294: aload_2
    //   295: ifnull +72 -> 367
    //   298: aload_2
    //   299: monitorenter
    //   300: aload_0
    //   301: getfield 25	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:c	Lcooperation/vip/vipcomponent/util/ZipResLoadListener;
    //   304: astore 4
    //   306: aload 4
    //   308: aload 4
    //   310: getfield 78	cooperation/vip/vipcomponent/util/ZipResLoadListener:mCount	I
    //   313: iconst_1
    //   314: isub
    //   315: putfield 78	cooperation/vip/vipcomponent/util/ZipResLoadListener:mCount	I
    //   318: aload_2
    //   319: monitorexit
    //   320: aload_1
    //   321: sipush 320
    //   324: invokevirtual 82	android/graphics/Bitmap:setDensity	(I)V
    //   327: new 84	android/graphics/drawable/BitmapDrawable
    //   330: dup
    //   331: aload_1
    //   332: invokespecial 87	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   335: astore_1
    //   336: aload_1
    //   337: invokestatic 93	com/tencent/mobileqq/utils/ViewUtils:getDensityDpi	()F
    //   340: f2i
    //   341: invokevirtual 96	android/graphics/drawable/BitmapDrawable:setTargetDensity	(I)V
    //   344: aload_0
    //   345: getfield 25	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:c	Lcooperation/vip/vipcomponent/util/ZipResLoadListener;
    //   348: aload_3
    //   349: aload_0
    //   350: getfield 27	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:d	I
    //   353: aload_0
    //   354: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:b	Ljava/lang/String;
    //   357: aload_1
    //   358: invokevirtual 100	cooperation/vip/vipcomponent/util/ZipResLoadListener:onDownloaded	(Ljava/lang/String;ILjava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   361: return
    //   362: astore_1
    //   363: aload_2
    //   364: monitorexit
    //   365: aload_1
    //   366: athrow
    //   367: return
    //   368: aload_0
    //   369: monitorexit
    //   370: aload_1
    //   371: athrow
    //   372: aload_0
    //   373: getfield 25	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:c	Lcooperation/vip/vipcomponent/util/ZipResLoadListener;
    //   376: astore_1
    //   377: aload_1
    //   378: ifnull +58 -> 436
    //   381: aload_1
    //   382: aload_3
    //   383: aload_0
    //   384: getfield 27	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:d	I
    //   387: aload_0
    //   388: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:b	Ljava/lang/String;
    //   391: invokevirtual 128	cooperation/vip/vipcomponent/util/ZipResLoadListener:onFailed	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: return
    //   395: aload_0
    //   396: getfield 19	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:this$0	Lcooperation/vip/vipcomponent/util/ZipResDownloadManager;
    //   399: aload_3
    //   400: aload_0
    //   401: getfield 27	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:d	I
    //   404: aload_0
    //   405: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:b	Ljava/lang/String;
    //   408: aload_0
    //   409: getfield 25	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:c	Lcooperation/vip/vipcomponent/util/ZipResLoadListener;
    //   412: invokestatic 131	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Lcooperation/vip/vipcomponent/util/ZipResDownloadManager;Ljava/lang/String;ILjava/lang/String;Lcooperation/vip/vipcomponent/util/ZipResLoadListener;)Lcooperation/vip/vipcomponent/util/ZipResEntry;
    //   415: astore_1
    //   416: aload_0
    //   417: getfield 19	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:this$0	Lcooperation/vip/vipcomponent/util/ZipResDownloadManager;
    //   420: aload_3
    //   421: aload_1
    //   422: invokestatic 134	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Lcooperation/vip/vipcomponent/util/ZipResDownloadManager;Ljava/lang/String;Lcooperation/vip/vipcomponent/util/ZipResEntry;)Z
    //   425: ifeq +11 -> 436
    //   428: aload_0
    //   429: getfield 19	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:this$0	Lcooperation/vip/vipcomponent/util/ZipResDownloadManager;
    //   432: aload_1
    //   433: invokestatic 137	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Lcooperation/vip/vipcomponent/util/ZipResDownloadManager;Lcooperation/vip/vipcomponent/util/ZipResEntry;)V
    //   436: return
    //   437: astore_2
    //   438: aconst_null
    //   439: astore_1
    //   440: goto -219 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	2
    //   40	151	1	localObject1	Object
    //   202	1	1	localObject2	Object
    //   208	150	1	localObject3	Object
    //   362	9	1	localObject4	Object
    //   376	64	1	localObject5	Object
    //   23	167	2	localObject6	Object
    //   194	1	2	localException1	java.lang.Exception
    //   198	1	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   206	18	2	localException2	java.lang.Exception
    //   243	121	2	localObject7	Object
    //   437	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   4	417	3	str	String
    //   48	67	4	localObject8	Object
    //   170	5	4	localObject9	Object
    //   251	58	4	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   106	126	170	finally
    //   172	174	170	finally
    //   92	106	194	java/lang/Exception
    //   126	167	194	java/lang/Exception
    //   174	177	194	java/lang/Exception
    //   180	189	194	java/lang/Exception
    //   92	106	198	java/lang/OutOfMemoryError
    //   126	167	198	java/lang/OutOfMemoryError
    //   174	177	198	java/lang/OutOfMemoryError
    //   180	189	198	java/lang/OutOfMemoryError
    //   33	88	202	finally
    //   92	106	202	finally
    //   126	167	202	finally
    //   174	177	202	finally
    //   177	179	202	finally
    //   180	189	202	finally
    //   209	218	202	finally
    //   221	230	202	finally
    //   230	232	202	finally
    //   368	370	202	finally
    //   33	88	206	java/lang/Exception
    //   300	320	362	finally
    //   363	365	362	finally
    //   33	88	437	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.ZipResDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */