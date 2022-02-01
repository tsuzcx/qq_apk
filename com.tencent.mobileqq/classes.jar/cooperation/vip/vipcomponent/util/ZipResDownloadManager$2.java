package cooperation.vip.vipcomponent.util;

import bnxe;
import bnxh;

public class ZipResDownloadManager$2
  implements Runnable
{
  public ZipResDownloadManager$2(bnxe parambnxe, String paramString1, String paramString2, bnxh parambnxh, int paramInt) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: getfield 19	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: astore 4
    //   10: aload 4
    //   12: invokestatic 39	bnxe:a	(Ljava/lang/String;)Ljava/io/File;
    //   15: invokestatic 42	bnxe:a	(Ljava/io/File;)Z
    //   18: ifeq +346 -> 364
    //   21: aload 4
    //   23: aload_0
    //   24: getfield 21	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:b	Ljava/lang/String;
    //   27: invokestatic 45	bnxe:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   30: astore 5
    //   32: aload 5
    //   34: invokestatic 47	bnxe:b	(Ljava/io/File;)Z
    //   37: ifeq +302 -> 339
    //   40: aload_0
    //   41: monitorenter
    //   42: aload_0
    //   43: getfield 17	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:this$0	Lbnxe;
    //   46: invokestatic 50	bnxe:a	(Lbnxe;)Landroid/support/v4/util/LruCache;
    //   49: new 52	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   56: aload 4
    //   58: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 59
    //   63: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_0
    //   67: getfield 21	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:b	Ljava/lang/String;
    //   70: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokevirtual 69	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 71	android/graphics/Bitmap
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull +213 -> 297
    //   87: aload_0
    //   88: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:jdField_a_of_type_Bnxh	Lbnxh;
    //   91: ifnull +69 -> 160
    //   94: aload_0
    //   95: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:jdField_a_of_type_Bnxh	Lbnxh;
    //   98: astore_2
    //   99: aload_2
    //   100: monitorenter
    //   101: aload_0
    //   102: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:jdField_a_of_type_Bnxh	Lbnxh;
    //   105: astore_3
    //   106: aload_3
    //   107: aload_3
    //   108: getfield 76	bnxh:mCount	I
    //   111: iconst_1
    //   112: isub
    //   113: putfield 76	bnxh:mCount	I
    //   116: aload_2
    //   117: monitorexit
    //   118: aload_1
    //   119: sipush 320
    //   122: invokevirtual 80	android/graphics/Bitmap:setDensity	(I)V
    //   125: new 82	android/graphics/drawable/BitmapDrawable
    //   128: dup
    //   129: aload_1
    //   130: invokespecial 85	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   133: astore_2
    //   134: aload_2
    //   135: invokestatic 91	bhtq:c	()F
    //   138: f2i
    //   139: invokevirtual 94	android/graphics/drawable/BitmapDrawable:setTargetDensity	(I)V
    //   142: aload_0
    //   143: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:jdField_a_of_type_Bnxh	Lbnxh;
    //   146: aload 4
    //   148: aload_0
    //   149: getfield 25	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:jdField_a_of_type_Int	I
    //   152: aload_0
    //   153: getfield 21	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:b	Ljava/lang/String;
    //   156: aload_2
    //   157: invokevirtual 98	bnxh:onDownloaded	(Ljava/lang/String;ILjava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   160: aload_0
    //   161: monitorexit
    //   162: return
    //   163: astore_3
    //   164: aload_2
    //   165: monitorexit
    //   166: aload_3
    //   167: athrow
    //   168: astore_2
    //   169: ldc 100
    //   171: aload_2
    //   172: invokevirtual 101	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   175: invokestatic 107	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_1
    //   181: ifnull -19 -> 162
    //   184: aload_0
    //   185: getfield 17	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:this$0	Lbnxe;
    //   188: invokestatic 50	bnxe:a	(Lbnxe;)Landroid/support/v4/util/LruCache;
    //   191: new 52	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   198: aload 4
    //   200: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc 59
    //   205: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_0
    //   209: getfield 21	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:b	Ljava/lang/String;
    //   212: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: aload_1
    //   219: invokevirtual 111	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   222: pop
    //   223: aload_0
    //   224: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:jdField_a_of_type_Bnxh	Lbnxh;
    //   227: ifnull -65 -> 162
    //   230: aload_0
    //   231: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:jdField_a_of_type_Bnxh	Lbnxh;
    //   234: astore_2
    //   235: aload_2
    //   236: monitorenter
    //   237: aload_0
    //   238: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:jdField_a_of_type_Bnxh	Lbnxh;
    //   241: astore_3
    //   242: aload_3
    //   243: aload_3
    //   244: getfield 76	bnxh:mCount	I
    //   247: iconst_1
    //   248: isub
    //   249: putfield 76	bnxh:mCount	I
    //   252: aload_2
    //   253: monitorexit
    //   254: aload_1
    //   255: sipush 320
    //   258: invokevirtual 80	android/graphics/Bitmap:setDensity	(I)V
    //   261: new 82	android/graphics/drawable/BitmapDrawable
    //   264: dup
    //   265: aload_1
    //   266: invokespecial 85	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   269: astore_1
    //   270: aload_1
    //   271: invokestatic 91	bhtq:c	()F
    //   274: f2i
    //   275: invokevirtual 94	android/graphics/drawable/BitmapDrawable:setTargetDensity	(I)V
    //   278: aload_0
    //   279: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:jdField_a_of_type_Bnxh	Lbnxh;
    //   282: aload 4
    //   284: aload_0
    //   285: getfield 25	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:jdField_a_of_type_Int	I
    //   288: aload_0
    //   289: getfield 21	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:b	Ljava/lang/String;
    //   292: aload_1
    //   293: invokevirtual 98	bnxh:onDownloaded	(Ljava/lang/String;ILjava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   296: return
    //   297: aload 5
    //   299: invokevirtual 116	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   302: aconst_null
    //   303: invokestatic 121	bnwv:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   306: astore_2
    //   307: aload_2
    //   308: astore_1
    //   309: goto -131 -> 178
    //   312: astore_3
    //   313: aload_2
    //   314: astore_1
    //   315: aload_3
    //   316: astore_2
    //   317: ldc 100
    //   319: aload_2
    //   320: invokevirtual 122	java/lang/Exception:toString	()Ljava/lang/String;
    //   323: invokestatic 107	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: goto -148 -> 178
    //   329: astore_1
    //   330: aload_0
    //   331: monitorexit
    //   332: aload_1
    //   333: athrow
    //   334: astore_1
    //   335: aload_2
    //   336: monitorexit
    //   337: aload_1
    //   338: athrow
    //   339: aload_0
    //   340: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:jdField_a_of_type_Bnxh	Lbnxh;
    //   343: ifnull -181 -> 162
    //   346: aload_0
    //   347: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:jdField_a_of_type_Bnxh	Lbnxh;
    //   350: aload 4
    //   352: aload_0
    //   353: getfield 25	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:jdField_a_of_type_Int	I
    //   356: aload_0
    //   357: getfield 21	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:b	Ljava/lang/String;
    //   360: invokevirtual 126	bnxh:onFailed	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: return
    //   364: aload_0
    //   365: getfield 17	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:this$0	Lbnxe;
    //   368: aload 4
    //   370: aload_0
    //   371: getfield 25	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:jdField_a_of_type_Int	I
    //   374: aload_0
    //   375: getfield 21	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:b	Ljava/lang/String;
    //   378: aload_0
    //   379: getfield 23	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:jdField_a_of_type_Bnxh	Lbnxh;
    //   382: invokestatic 129	bnxe:a	(Lbnxe;Ljava/lang/String;ILjava/lang/String;Lbnxh;)Lbnxg;
    //   385: astore_1
    //   386: aload_0
    //   387: getfield 17	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:this$0	Lbnxe;
    //   390: aload 4
    //   392: aload_1
    //   393: invokestatic 132	bnxe:a	(Lbnxe;Ljava/lang/String;Lbnxg;)Z
    //   396: ifeq -234 -> 162
    //   399: aload_0
    //   400: getfield 17	cooperation/vip/vipcomponent/util/ZipResDownloadManager$2:this$0	Lbnxe;
    //   403: aload_1
    //   404: invokestatic 135	bnxe:a	(Lbnxe;Lbnxg;)V
    //   407: return
    //   408: astore_2
    //   409: goto -92 -> 317
    //   412: astore_2
    //   413: aload_3
    //   414: astore_1
    //   415: goto -246 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	2
    //   82	233	1	localObject1	Object
    //   329	4	1	localObject2	Object
    //   334	4	1	localObject3	Object
    //   385	30	1	localObject4	Object
    //   168	4	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   408	1	2	localException1	java.lang.Exception
    //   412	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   3	105	3	localbnxh1	bnxh
    //   163	4	3	localObject7	Object
    //   241	3	3	localbnxh2	bnxh
    //   312	102	3	localException2	java.lang.Exception
    //   8	383	4	str	String
    //   30	268	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   101	118	163	finally
    //   164	166	163	finally
    //   87	101	168	java/lang/OutOfMemoryError
    //   118	160	168	java/lang/OutOfMemoryError
    //   166	168	168	java/lang/OutOfMemoryError
    //   297	307	168	java/lang/OutOfMemoryError
    //   42	83	312	java/lang/Exception
    //   42	83	329	finally
    //   87	101	329	finally
    //   118	160	329	finally
    //   160	162	329	finally
    //   166	168	329	finally
    //   169	178	329	finally
    //   178	180	329	finally
    //   297	307	329	finally
    //   317	326	329	finally
    //   330	332	329	finally
    //   237	254	334	finally
    //   335	337	334	finally
    //   87	101	408	java/lang/Exception
    //   118	160	408	java/lang/Exception
    //   166	168	408	java/lang/Exception
    //   297	307	408	java/lang/Exception
    //   42	83	412	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.ZipResDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */