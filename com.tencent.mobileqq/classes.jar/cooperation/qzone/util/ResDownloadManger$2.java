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
    //   21: astore_3
    //   22: aload_3
    //   23: invokeinterface 38 1 0
    //   28: ifeq +229 -> 257
    //   31: aload_3
    //   32: invokeinterface 42 1 0
    //   37: checkcast 44	cooperation/qzone/util/ResEntry
    //   40: astore 4
    //   42: aload 4
    //   44: getfield 48	cooperation/qzone/util/ResEntry:mResLoadListener	Ljava/lang/ref/WeakReference;
    //   47: invokevirtual 53	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   50: checkcast 55	cooperation/qzone/util/ResDownloadManger$ResLoadListener
    //   53: astore 5
    //   55: aload 5
    //   57: ifnull +111 -> 168
    //   60: aload 4
    //   62: getfield 87	cooperation/qzone/util/ResEntry:mUrl	Ljava/lang/String;
    //   65: aload 4
    //   67: getfield 63	cooperation/qzone/util/ResEntry:fileName	Ljava/lang/String;
    //   70: invokestatic 91	cooperation/qzone/util/ResDownloadManger:access$100	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   73: astore 6
    //   75: aload 6
    //   77: invokestatic 95	cooperation/qzone/util/ResDownloadManger:access$200	(Ljava/io/File;)Z
    //   80: ifeq +152 -> 232
    //   83: aload_0
    //   84: monitorenter
    //   85: aload_0
    //   86: getfield 12	cooperation/qzone/util/ResDownloadManger$2:this$0	Lcooperation/qzone/util/ResDownloadManger;
    //   89: invokestatic 99	cooperation/qzone/util/ResDownloadManger:access$300	(Lcooperation/qzone/util/ResDownloadManger;)Landroid/support/v4/util/LruCache;
    //   92: aload 4
    //   94: getfield 102	cooperation/qzone/util/ResEntry:mUrlKey	Ljava/lang/String;
    //   97: invokevirtual 107	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 109	android/graphics/Bitmap
    //   103: astore_1
    //   104: aload_1
    //   105: astore_2
    //   106: aload_1
    //   107: ifnonnull +13 -> 120
    //   110: aload 6
    //   112: invokevirtual 115	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   115: aconst_null
    //   116: invokestatic 119	cooperation/qzone/util/ResDownloadManger:decodeFileWithBuffer	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   119: astore_2
    //   120: aload_2
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: ifnull +82 -> 207
    //   128: aload_0
    //   129: getfield 12	cooperation/qzone/util/ResDownloadManger$2:this$0	Lcooperation/qzone/util/ResDownloadManger;
    //   132: invokestatic 99	cooperation/qzone/util/ResDownloadManger:access$300	(Lcooperation/qzone/util/ResDownloadManger;)Landroid/support/v4/util/LruCache;
    //   135: aload 4
    //   137: getfield 102	cooperation/qzone/util/ResEntry:mUrlKey	Ljava/lang/String;
    //   140: aload_1
    //   141: invokevirtual 123	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: aload 5
    //   147: ifnull +21 -> 168
    //   150: aload 5
    //   152: aload 4
    //   154: getfield 59	cooperation/qzone/util/ResEntry:type	I
    //   157: aload 4
    //   159: getfield 63	cooperation/qzone/util/ResEntry:fileName	Ljava/lang/String;
    //   162: aload_1
    //   163: invokeinterface 127 4 0
    //   168: aload 4
    //   170: invokevirtual 70	cooperation/qzone/util/ResEntry:recycle	()V
    //   173: goto -151 -> 22
    //   176: astore_2
    //   177: aconst_null
    //   178: astore_1
    //   179: ldc 129
    //   181: iconst_1
    //   182: aload_2
    //   183: invokevirtual 132	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   186: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: goto -67 -> 122
    //   192: astore_1
    //   193: aload_0
    //   194: monitorexit
    //   195: aload_1
    //   196: athrow
    //   197: astore_2
    //   198: aconst_null
    //   199: astore_1
    //   200: aload_2
    //   201: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   204: goto -82 -> 122
    //   207: aload 5
    //   209: ifnull -41 -> 168
    //   212: aload 5
    //   214: aload 4
    //   216: getfield 59	cooperation/qzone/util/ResEntry:type	I
    //   219: aload 4
    //   221: getfield 63	cooperation/qzone/util/ResEntry:fileName	Ljava/lang/String;
    //   224: invokeinterface 67 3 0
    //   229: goto -61 -> 168
    //   232: aload 5
    //   234: ifnull -66 -> 168
    //   237: aload 5
    //   239: aload 4
    //   241: getfield 59	cooperation/qzone/util/ResEntry:type	I
    //   244: aload 4
    //   246: getfield 63	cooperation/qzone/util/ResEntry:fileName	Ljava/lang/String;
    //   249: invokeinterface 67 3 0
    //   254: goto -86 -> 168
    //   257: return
    //   258: astore_2
    //   259: goto -59 -> 200
    //   262: astore_2
    //   263: goto -84 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	2
    //   0	266	1	paramString	String
    //   0	266	2	paramDownloadResult	DownloadResult
    //   21	11	3	localIterator	Iterator
    //   40	205	4	localResEntry	ResEntry
    //   53	185	5	localResLoadListener	ResDownloadManger.ResLoadListener
    //   73	38	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   85	104	176	java/lang/OutOfMemoryError
    //   85	104	192	finally
    //   110	120	192	finally
    //   122	124	192	finally
    //   179	189	192	finally
    //   193	195	192	finally
    //   200	204	192	finally
    //   85	104	197	java/lang/Exception
    //   110	120	258	java/lang/Exception
    //   110	120	262	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.ResDownloadManger.2
 * JD-Core Version:    0.7.0.1
 */