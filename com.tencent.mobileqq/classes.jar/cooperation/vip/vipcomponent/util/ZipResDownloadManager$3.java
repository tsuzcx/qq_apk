package cooperation.vip.vipcomponent.util;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;

class ZipResDownloadManager$3
  implements Downloader.DownloadListener
{
  ZipResDownloadManager$3(ZipResDownloadManager paramZipResDownloadManager) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = ZipResDownloadManager.a(this.a, paramString, true).iterator();
    while (paramString.hasNext())
    {
      paramDownloadResult = (ZipResEntry)paramString.next();
      ZipResLoadListener localZipResLoadListener = (ZipResLoadListener)paramDownloadResult.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localZipResLoadListener != null) {
        localZipResLoadListener.onFailed(paramDownloadResult.b, paramDownloadResult.jdField_a_of_type_Int, paramDownloadResult.d);
      }
      paramDownloadResult.a();
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  /* Error */
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 79	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore 4
    //   6: aload 4
    //   8: invokestatic 81	cooperation/vip/vipcomponent/util/ZipResDownloadManager:b	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 12	cooperation/vip/vipcomponent/util/ZipResDownloadManager$3:a	Lcooperation/vip/vipcomponent/util/ZipResDownloadManager;
    //   15: aload_1
    //   16: iconst_1
    //   17: invokestatic 25	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Lcooperation/vip/vipcomponent/util/ZipResDownloadManager;Ljava/lang/String;Z)Ljava/util/Collection;
    //   20: invokeinterface 31 1 0
    //   25: astore 6
    //   27: aload 6
    //   29: invokeinterface 37 1 0
    //   34: ifeq +333 -> 367
    //   37: aload 6
    //   39: invokeinterface 41 1 0
    //   44: checkcast 43	cooperation/vip/vipcomponent/util/ZipResEntry
    //   47: astore 7
    //   49: aload 7
    //   51: getfield 46	cooperation/vip/vipcomponent/util/ZipResEntry:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   54: invokevirtual 51	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   57: checkcast 53	cooperation/vip/vipcomponent/util/ZipResLoadListener
    //   60: astore 5
    //   62: aload 5
    //   64: ifnull +295 -> 359
    //   67: aload 7
    //   69: getfield 60	cooperation/vip/vipcomponent/util/ZipResEntry:jdField_a_of_type_Int	I
    //   72: sipush 999
    //   75: if_icmpne +27 -> 102
    //   78: aload 5
    //   80: aload 7
    //   82: getfield 57	cooperation/vip/vipcomponent/util/ZipResEntry:b	Ljava/lang/String;
    //   85: aload 7
    //   87: getfield 60	cooperation/vip/vipcomponent/util/ZipResEntry:jdField_a_of_type_Int	I
    //   90: aload 4
    //   92: invokestatic 83	cooperation/vip/vipcomponent/util/ZipResDownloadManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   95: aconst_null
    //   96: invokevirtual 87	cooperation/vip/vipcomponent/util/ZipResLoadListener:onDownloaded	(Ljava/lang/String;ILjava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   99: goto -72 -> 27
    //   102: aload 7
    //   104: getfield 57	cooperation/vip/vipcomponent/util/ZipResEntry:b	Ljava/lang/String;
    //   107: aload 7
    //   109: getfield 63	cooperation/vip/vipcomponent/util/ZipResEntry:d	Ljava/lang/String;
    //   112: invokestatic 90	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   115: astore_3
    //   116: aload_3
    //   117: invokestatic 93	cooperation/vip/vipcomponent/util/ZipResDownloadManager:b	(Ljava/io/File;)Z
    //   120: ifeq +214 -> 334
    //   123: aload_0
    //   124: monitorenter
    //   125: aload_0
    //   126: getfield 12	cooperation/vip/vipcomponent/util/ZipResDownloadManager$3:a	Lcooperation/vip/vipcomponent/util/ZipResDownloadManager;
    //   129: invokestatic 96	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Lcooperation/vip/vipcomponent/util/ZipResDownloadManager;)Landroid/support/v4/util/LruCache;
    //   132: aload 7
    //   134: getfield 98	cooperation/vip/vipcomponent/util/ZipResEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   137: invokevirtual 103	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: checkcast 105	android/graphics/Bitmap
    //   143: astore_2
    //   144: aload_2
    //   145: astore_1
    //   146: aload_2
    //   147: ifnonnull +55 -> 202
    //   150: aload_3
    //   151: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   154: aconst_null
    //   155: invokestatic 116	cooperation/vip/vipcomponent/VipUtils:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   158: astore_1
    //   159: goto +43 -> 202
    //   162: astore_3
    //   163: aload_2
    //   164: astore_1
    //   165: goto +16 -> 181
    //   168: astore_3
    //   169: aload_2
    //   170: astore_1
    //   171: goto +22 -> 193
    //   174: astore_1
    //   175: goto +155 -> 330
    //   178: astore_3
    //   179: aconst_null
    //   180: astore_1
    //   181: ldc 118
    //   183: aload_3
    //   184: invokevirtual 121	java/lang/Exception:toString	()Ljava/lang/String;
    //   187: invokestatic 127	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: goto +12 -> 202
    //   193: ldc 118
    //   195: aload_3
    //   196: invokevirtual 128	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   199: invokestatic 127	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload_0
    //   203: monitorexit
    //   204: aload_1
    //   205: ifnull +97 -> 302
    //   208: aload_0
    //   209: getfield 12	cooperation/vip/vipcomponent/util/ZipResDownloadManager$3:a	Lcooperation/vip/vipcomponent/util/ZipResDownloadManager;
    //   212: invokestatic 96	cooperation/vip/vipcomponent/util/ZipResDownloadManager:a	(Lcooperation/vip/vipcomponent/util/ZipResDownloadManager;)Landroid/support/v4/util/LruCache;
    //   215: aload 7
    //   217: getfield 98	cooperation/vip/vipcomponent/util/ZipResEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   220: aload_1
    //   221: invokevirtual 132	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   224: pop
    //   225: aload 5
    //   227: ifnull +132 -> 359
    //   230: aload 5
    //   232: monitorenter
    //   233: aload 5
    //   235: aload 5
    //   237: getfield 135	cooperation/vip/vipcomponent/util/ZipResLoadListener:mCount	I
    //   240: iconst_1
    //   241: isub
    //   242: putfield 135	cooperation/vip/vipcomponent/util/ZipResLoadListener:mCount	I
    //   245: aload 5
    //   247: monitorexit
    //   248: aload_1
    //   249: sipush 320
    //   252: invokevirtual 139	android/graphics/Bitmap:setDensity	(I)V
    //   255: new 141	android/graphics/drawable/BitmapDrawable
    //   258: dup
    //   259: aload_1
    //   260: invokespecial 144	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   263: astore_1
    //   264: aload_1
    //   265: invokestatic 150	com/tencent/mobileqq/utils/ViewUtils:c	()F
    //   268: f2i
    //   269: invokevirtual 153	android/graphics/drawable/BitmapDrawable:setTargetDensity	(I)V
    //   272: aload 5
    //   274: aload 7
    //   276: getfield 57	cooperation/vip/vipcomponent/util/ZipResEntry:b	Ljava/lang/String;
    //   279: aload 7
    //   281: getfield 60	cooperation/vip/vipcomponent/util/ZipResEntry:jdField_a_of_type_Int	I
    //   284: aload 7
    //   286: getfield 63	cooperation/vip/vipcomponent/util/ZipResEntry:d	Ljava/lang/String;
    //   289: aload_1
    //   290: invokevirtual 87	cooperation/vip/vipcomponent/util/ZipResLoadListener:onDownloaded	(Ljava/lang/String;ILjava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   293: goto +66 -> 359
    //   296: astore_1
    //   297: aload 5
    //   299: monitorexit
    //   300: aload_1
    //   301: athrow
    //   302: aload 5
    //   304: ifnull +55 -> 359
    //   307: aload 5
    //   309: aload 7
    //   311: getfield 57	cooperation/vip/vipcomponent/util/ZipResEntry:b	Ljava/lang/String;
    //   314: aload 7
    //   316: getfield 60	cooperation/vip/vipcomponent/util/ZipResEntry:jdField_a_of_type_Int	I
    //   319: aload 7
    //   321: getfield 63	cooperation/vip/vipcomponent/util/ZipResEntry:d	Ljava/lang/String;
    //   324: invokevirtual 67	cooperation/vip/vipcomponent/util/ZipResLoadListener:onFailed	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: goto +32 -> 359
    //   330: aload_0
    //   331: monitorexit
    //   332: aload_1
    //   333: athrow
    //   334: aload 5
    //   336: ifnull +23 -> 359
    //   339: aload 5
    //   341: aload 7
    //   343: getfield 57	cooperation/vip/vipcomponent/util/ZipResEntry:b	Ljava/lang/String;
    //   346: aload 7
    //   348: getfield 60	cooperation/vip/vipcomponent/util/ZipResEntry:jdField_a_of_type_Int	I
    //   351: aload 7
    //   353: getfield 63	cooperation/vip/vipcomponent/util/ZipResEntry:d	Ljava/lang/String;
    //   356: invokevirtual 67	cooperation/vip/vipcomponent/util/ZipResLoadListener:onFailed	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: aload 7
    //   361: invokevirtual 69	cooperation/vip/vipcomponent/util/ZipResEntry:a	()V
    //   364: goto -337 -> 27
    //   367: return
    //   368: astore_3
    //   369: aconst_null
    //   370: astore_1
    //   371: goto -178 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	this	3
    //   0	374	1	paramString	String
    //   0	374	2	paramDownloadResult	DownloadResult
    //   115	36	3	localFile	java.io.File
    //   162	1	3	localException1	java.lang.Exception
    //   168	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   178	18	3	localException2	java.lang.Exception
    //   368	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   4	87	4	str	String
    //   60	280	5	localZipResLoadListener	ZipResLoadListener
    //   25	13	6	localIterator	Iterator
    //   47	313	7	localZipResEntry	ZipResEntry
    // Exception table:
    //   from	to	target	type
    //   150	159	162	java/lang/Exception
    //   150	159	168	java/lang/OutOfMemoryError
    //   125	144	174	finally
    //   150	159	174	finally
    //   181	190	174	finally
    //   193	202	174	finally
    //   202	204	174	finally
    //   330	332	174	finally
    //   125	144	178	java/lang/Exception
    //   233	248	296	finally
    //   297	300	296	finally
    //   125	144	368	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.ZipResDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */