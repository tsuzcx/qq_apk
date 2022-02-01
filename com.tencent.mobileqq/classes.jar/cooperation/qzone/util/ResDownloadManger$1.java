package cooperation.qzone.util;

import android.graphics.BitmapFactory.Options;

class ResDownloadManger$1
  implements Runnable
{
  ResDownloadManger$1(ResDownloadManger paramResDownloadManger, int paramInt, String paramString, ResDownloadManger.ResLoadListener paramResLoadListener, BitmapFactory.Options paramOptions) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 43	cooperation/qzone/util/ResDownloadManger:access$000	()[Ljava/lang/String;
    //   3: aload_0
    //   4: getfield 22	cooperation/qzone/util/ResDownloadManger$1:val$type	I
    //   7: aaload
    //   8: astore_1
    //   9: aload_1
    //   10: aload_0
    //   11: getfield 24	cooperation/qzone/util/ResDownloadManger$1:val$resName	Ljava/lang/String;
    //   14: invokestatic 47	cooperation/qzone/util/ResDownloadManger:access$100	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   17: astore 4
    //   19: aload 4
    //   21: invokestatic 51	cooperation/qzone/util/ResDownloadManger:access$200	(Ljava/io/File;)Z
    //   24: ifeq +243 -> 267
    //   27: aload_0
    //   28: monitorenter
    //   29: aconst_null
    //   30: astore_3
    //   31: aconst_null
    //   32: astore_2
    //   33: aload_0
    //   34: getfield 20	cooperation/qzone/util/ResDownloadManger$1:this$0	Lcooperation/qzone/util/ResDownloadManger;
    //   37: invokestatic 55	cooperation/qzone/util/ResDownloadManger:access$300	(Lcooperation/qzone/util/ResDownloadManger;)Landroid/util/LruCache;
    //   40: astore_1
    //   41: new 57	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   48: astore 5
    //   50: aload 5
    //   52: aload_0
    //   53: getfield 22	cooperation/qzone/util/ResDownloadManger$1:val$type	I
    //   56: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 5
    //   62: ldc 64
    //   64: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 5
    //   70: aload_0
    //   71: getfield 24	cooperation/qzone/util/ResDownloadManger$1:val$resName	Ljava/lang/String;
    //   74: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_1
    //   79: aload 5
    //   81: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokevirtual 77	android/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   87: checkcast 79	android/graphics/Bitmap
    //   90: astore_1
    //   91: aload_1
    //   92: ifnull +31 -> 123
    //   95: aload_0
    //   96: getfield 26	cooperation/qzone/util/ResDownloadManger$1:val$resLoadListener	Lcooperation/qzone/util/ResDownloadManger$ResLoadListener;
    //   99: ifnull +21 -> 120
    //   102: aload_0
    //   103: getfield 26	cooperation/qzone/util/ResDownloadManger$1:val$resLoadListener	Lcooperation/qzone/util/ResDownloadManger$ResLoadListener;
    //   106: aload_0
    //   107: getfield 22	cooperation/qzone/util/ResDownloadManger$1:val$type	I
    //   110: aload_0
    //   111: getfield 24	cooperation/qzone/util/ResDownloadManger$1:val$resName	Ljava/lang/String;
    //   114: aload_1
    //   115: invokeinterface 85 4 0
    //   120: aload_0
    //   121: monitorexit
    //   122: return
    //   123: aload 4
    //   125: invokevirtual 90	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   128: aload_0
    //   129: getfield 28	cooperation/qzone/util/ResDownloadManger$1:val$options	Landroid/graphics/BitmapFactory$Options;
    //   132: invokestatic 94	cooperation/qzone/util/ResDownloadManger:decodeFileWithBuffer	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   135: astore_2
    //   136: aload_2
    //   137: astore_1
    //   138: goto +43 -> 181
    //   141: astore_2
    //   142: goto +16 -> 158
    //   145: astore_2
    //   146: goto +25 -> 171
    //   149: astore_1
    //   150: goto +113 -> 263
    //   153: astore_3
    //   154: aload_2
    //   155: astore_1
    //   156: aload_3
    //   157: astore_2
    //   158: ldc 96
    //   160: iconst_1
    //   161: aload_2
    //   162: invokevirtual 97	java/lang/Exception:toString	()Ljava/lang/String;
    //   165: invokestatic 103	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: goto +13 -> 181
    //   171: ldc 96
    //   173: iconst_1
    //   174: aload_2
    //   175: invokevirtual 104	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   178: invokestatic 103	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_1
    //   184: ifnull +124 -> 308
    //   187: aload_0
    //   188: getfield 20	cooperation/qzone/util/ResDownloadManger$1:this$0	Lcooperation/qzone/util/ResDownloadManger;
    //   191: invokestatic 55	cooperation/qzone/util/ResDownloadManger:access$300	(Lcooperation/qzone/util/ResDownloadManger;)Landroid/util/LruCache;
    //   194: astore_2
    //   195: new 57	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   202: astore_3
    //   203: aload_3
    //   204: aload_0
    //   205: getfield 22	cooperation/qzone/util/ResDownloadManger$1:val$type	I
    //   208: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_3
    //   213: ldc 64
    //   215: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_3
    //   220: aload_0
    //   221: getfield 24	cooperation/qzone/util/ResDownloadManger$1:val$resName	Ljava/lang/String;
    //   224: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_2
    //   229: aload_3
    //   230: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: aload_1
    //   234: invokevirtual 108	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: pop
    //   238: aload_0
    //   239: getfield 26	cooperation/qzone/util/ResDownloadManger$1:val$resLoadListener	Lcooperation/qzone/util/ResDownloadManger$ResLoadListener;
    //   242: astore_2
    //   243: aload_2
    //   244: ifnull +18 -> 262
    //   247: aload_2
    //   248: aload_0
    //   249: getfield 22	cooperation/qzone/util/ResDownloadManger$1:val$type	I
    //   252: aload_0
    //   253: getfield 24	cooperation/qzone/util/ResDownloadManger$1:val$resName	Ljava/lang/String;
    //   256: aload_1
    //   257: invokeinterface 85 4 0
    //   262: return
    //   263: aload_0
    //   264: monitorexit
    //   265: aload_1
    //   266: athrow
    //   267: aload_0
    //   268: getfield 20	cooperation/qzone/util/ResDownloadManger$1:this$0	Lcooperation/qzone/util/ResDownloadManger;
    //   271: aload_1
    //   272: aload_0
    //   273: getfield 22	cooperation/qzone/util/ResDownloadManger$1:val$type	I
    //   276: aload_0
    //   277: getfield 24	cooperation/qzone/util/ResDownloadManger$1:val$resName	Ljava/lang/String;
    //   280: aload_0
    //   281: getfield 26	cooperation/qzone/util/ResDownloadManger$1:val$resLoadListener	Lcooperation/qzone/util/ResDownloadManger$ResLoadListener;
    //   284: invokestatic 112	cooperation/qzone/util/ResDownloadManger:access$400	(Lcooperation/qzone/util/ResDownloadManger;Ljava/lang/String;ILjava/lang/String;Lcooperation/qzone/util/ResDownloadManger$ResLoadListener;)Lcooperation/qzone/util/ResEntry;
    //   287: astore_2
    //   288: aload_0
    //   289: getfield 20	cooperation/qzone/util/ResDownloadManger$1:this$0	Lcooperation/qzone/util/ResDownloadManger;
    //   292: aload_1
    //   293: aload_2
    //   294: invokestatic 116	cooperation/qzone/util/ResDownloadManger:access$500	(Lcooperation/qzone/util/ResDownloadManger;Ljava/lang/String;Lcooperation/qzone/util/ResEntry;)Z
    //   297: ifeq +11 -> 308
    //   300: aload_0
    //   301: getfield 20	cooperation/qzone/util/ResDownloadManger$1:this$0	Lcooperation/qzone/util/ResDownloadManger;
    //   304: aload_2
    //   305: invokestatic 120	cooperation/qzone/util/ResDownloadManger:access$600	(Lcooperation/qzone/util/ResDownloadManger;Lcooperation/qzone/util/ResEntry;)V
    //   308: return
    //   309: astore_2
    //   310: aload_3
    //   311: astore_1
    //   312: goto -141 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	1
    //   8	130	1	localObject1	Object
    //   149	1	1	localObject2	Object
    //   155	157	1	localObject3	Object
    //   32	105	2	localBitmap	android.graphics.Bitmap
    //   141	1	2	localException1	java.lang.Exception
    //   145	10	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   157	148	2	localObject4	Object
    //   309	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   30	1	3	localObject5	Object
    //   153	4	3	localException2	java.lang.Exception
    //   202	109	3	localStringBuilder1	java.lang.StringBuilder
    //   17	107	4	localFile	java.io.File
    //   48	32	5	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   95	120	141	java/lang/Exception
    //   123	136	141	java/lang/Exception
    //   95	120	145	java/lang/OutOfMemoryError
    //   123	136	145	java/lang/OutOfMemoryError
    //   33	91	149	finally
    //   95	120	149	finally
    //   120	122	149	finally
    //   123	136	149	finally
    //   158	168	149	finally
    //   171	181	149	finally
    //   181	183	149	finally
    //   263	265	149	finally
    //   33	91	153	java/lang/Exception
    //   33	91	309	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.ResDownloadManger.1
 * JD-Core Version:    0.7.0.1
 */