package cooperation.qzone.util;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;

class ResDownloadManger$2
  implements Downloader.DownloadListener
{
  ResDownloadManger$2(ResDownloadManger paramResDownloadManger) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = ResDownloadManger.access$700(this.this$0, paramString, true).iterator();
    while (paramString.hasNext())
    {
      paramDownloadResult = (ResEntry)paramString.next();
      ResDownloadManger.ResLoadListener localResLoadListener = (ResDownloadManger.ResLoadListener)paramDownloadResult.mResLoadListener.get();
      if (localResLoadListener != null) {
        localResLoadListener.onFailed(paramDownloadResult.type, paramDownloadResult.fileName);
      }
      paramDownloadResult.recycle();
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  /* Error */
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 81	cooperation/qzone/util/ResDownloadManger:access$800	(Ljava/lang/String;)Ljava/lang/String;
    //   4: invokestatic 84	cooperation/qzone/util/ResDownloadManger:access$900	(Ljava/lang/String;)V
    //   7: aload_0
    //   8: getfield 12	cooperation/qzone/util/ResDownloadManger$2:this$0	Lcooperation/qzone/util/ResDownloadManger;
    //   11: aload_1
    //   12: iconst_1
    //   13: invokestatic 26	cooperation/qzone/util/ResDownloadManger:access$700	(Lcooperation/qzone/util/ResDownloadManger;Ljava/lang/String;Z)Ljava/util/Collection;
    //   16: invokeinterface 32 1 0
    //   21: astore 4
    //   23: aload 4
    //   25: invokeinterface 38 1 0
    //   30: ifeq +237 -> 267
    //   33: aload 4
    //   35: invokeinterface 42 1 0
    //   40: checkcast 44	cooperation/qzone/util/ResEntry
    //   43: astore 5
    //   45: aload 5
    //   47: getfield 48	cooperation/qzone/util/ResEntry:mResLoadListener	Ljava/lang/ref/WeakReference;
    //   50: invokevirtual 53	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   53: checkcast 55	cooperation/qzone/util/ResDownloadManger$ResLoadListener
    //   56: astore 6
    //   58: aload 6
    //   60: ifnull +199 -> 259
    //   63: aload 5
    //   65: getfield 87	cooperation/qzone/util/ResEntry:mUrl	Ljava/lang/String;
    //   68: aload 5
    //   70: getfield 63	cooperation/qzone/util/ResEntry:fileName	Ljava/lang/String;
    //   73: invokestatic 91	cooperation/qzone/util/ResDownloadManger:access$100	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   76: astore_3
    //   77: aload_3
    //   78: invokestatic 95	cooperation/qzone/util/ResDownloadManger:access$200	(Ljava/io/File;)Z
    //   81: ifeq +156 -> 237
    //   84: aload_0
    //   85: monitorenter
    //   86: aload_0
    //   87: getfield 12	cooperation/qzone/util/ResDownloadManger$2:this$0	Lcooperation/qzone/util/ResDownloadManger;
    //   90: invokestatic 99	cooperation/qzone/util/ResDownloadManger:access$300	(Lcooperation/qzone/util/ResDownloadManger;)Landroid/util/LruCache;
    //   93: aload 5
    //   95: getfield 102	cooperation/qzone/util/ResEntry:mUrlKey	Ljava/lang/String;
    //   98: invokevirtual 107	android/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   101: checkcast 109	android/graphics/Bitmap
    //   104: astore_2
    //   105: aload_2
    //   106: astore_1
    //   107: aload_2
    //   108: ifnonnull +51 -> 159
    //   111: aload_3
    //   112: invokevirtual 115	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   115: aconst_null
    //   116: invokestatic 119	cooperation/qzone/util/ResDownloadManger:decodeFileWithBuffer	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   119: astore_1
    //   120: goto +39 -> 159
    //   123: astore_3
    //   124: aload_2
    //   125: astore_1
    //   126: goto +16 -> 142
    //   129: astore_3
    //   130: aload_2
    //   131: astore_1
    //   132: goto +17 -> 149
    //   135: astore_1
    //   136: goto +97 -> 233
    //   139: astore_3
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_3
    //   143: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   146: goto +13 -> 159
    //   149: ldc 124
    //   151: iconst_1
    //   152: aload_3
    //   153: invokevirtual 127	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   156: invokestatic 133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_1
    //   162: ifnull +46 -> 208
    //   165: aload_0
    //   166: getfield 12	cooperation/qzone/util/ResDownloadManger$2:this$0	Lcooperation/qzone/util/ResDownloadManger;
    //   169: invokestatic 99	cooperation/qzone/util/ResDownloadManger:access$300	(Lcooperation/qzone/util/ResDownloadManger;)Landroid/util/LruCache;
    //   172: aload 5
    //   174: getfield 102	cooperation/qzone/util/ResEntry:mUrlKey	Ljava/lang/String;
    //   177: aload_1
    //   178: invokevirtual 137	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   181: pop
    //   182: aload 6
    //   184: ifnull +75 -> 259
    //   187: aload 6
    //   189: aload 5
    //   191: getfield 59	cooperation/qzone/util/ResEntry:type	I
    //   194: aload 5
    //   196: getfield 63	cooperation/qzone/util/ResEntry:fileName	Ljava/lang/String;
    //   199: aload_1
    //   200: invokeinterface 141 4 0
    //   205: goto +54 -> 259
    //   208: aload 6
    //   210: ifnull +49 -> 259
    //   213: aload 6
    //   215: aload 5
    //   217: getfield 59	cooperation/qzone/util/ResEntry:type	I
    //   220: aload 5
    //   222: getfield 63	cooperation/qzone/util/ResEntry:fileName	Ljava/lang/String;
    //   225: invokeinterface 67 3 0
    //   230: goto +29 -> 259
    //   233: aload_0
    //   234: monitorexit
    //   235: aload_1
    //   236: athrow
    //   237: aload 6
    //   239: ifnull +20 -> 259
    //   242: aload 6
    //   244: aload 5
    //   246: getfield 59	cooperation/qzone/util/ResEntry:type	I
    //   249: aload 5
    //   251: getfield 63	cooperation/qzone/util/ResEntry:fileName	Ljava/lang/String;
    //   254: invokeinterface 67 3 0
    //   259: aload 5
    //   261: invokevirtual 70	cooperation/qzone/util/ResEntry:recycle	()V
    //   264: goto -241 -> 23
    //   267: return
    //   268: astore_3
    //   269: aconst_null
    //   270: astore_1
    //   271: goto -122 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	2
    //   0	274	1	paramString	String
    //   0	274	2	paramDownloadResult	DownloadResult
    //   76	36	3	localFile	java.io.File
    //   123	1	3	localException1	java.lang.Exception
    //   129	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   139	14	3	localException2	java.lang.Exception
    //   268	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   21	13	4	localIterator	Iterator
    //   43	217	5	localResEntry	ResEntry
    //   56	187	6	localResLoadListener	ResDownloadManger.ResLoadListener
    // Exception table:
    //   from	to	target	type
    //   111	120	123	java/lang/Exception
    //   111	120	129	java/lang/OutOfMemoryError
    //   86	105	135	finally
    //   111	120	135	finally
    //   142	146	135	finally
    //   149	159	135	finally
    //   159	161	135	finally
    //   233	235	135	finally
    //   86	105	139	java/lang/Exception
    //   86	105	268	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.ResDownloadManger.2
 * JD-Core Version:    0.7.0.1
 */