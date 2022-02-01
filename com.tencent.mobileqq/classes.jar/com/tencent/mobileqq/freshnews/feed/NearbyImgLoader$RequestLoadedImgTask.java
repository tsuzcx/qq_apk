package com.tencent.mobileqq.freshnews.feed;

import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

public class NearbyImgLoader$RequestLoadedImgTask
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  URL jdField_a_of_type_JavaNetURL;
  
  public NearbyImgLoader$RequestLoadedImgTask(NearbyImgLoader paramNearbyImgLoader, URL paramURL)
  {
    paramNearbyImgLoader.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    this.jdField_a_of_type_JavaNetURL = paramURL;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:jdField_a_of_type_JavaNetURL	Ljava/net/URL;
    //   4: ifnull +270 -> 274
    //   7: new 41	com/tencent/image/DownloadParams
    //   10: dup
    //   11: invokespecial 42	com/tencent/image/DownloadParams:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: aload_0
    //   17: getfield 33	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:jdField_a_of_type_JavaNetURL	Ljava/net/URL;
    //   20: putfield 45	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   23: aload_1
    //   24: aload_0
    //   25: getfield 33	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:jdField_a_of_type_JavaNetURL	Ljava/net/URL;
    //   28: invokevirtual 51	java/net/URL:toString	()Ljava/lang/String;
    //   31: putfield 55	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   34: aload_1
    //   35: getfield 55	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   38: astore_3
    //   39: new 57	attx
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 60	attx:<init>	(Lcom/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask;)V
    //   47: astore_2
    //   48: aload_0
    //   49: getfield 15	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:this$0	Lcom/tencent/mobileqq/freshnews/feed/NearbyImgLoader;
    //   52: getfield 63	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader:jdField_a_of_type_ComTencentMobileqqTransfileNearbyImgDownloader	Lcom/tencent/mobileqq/transfile/NearbyImgDownloader;
    //   55: aload_1
    //   56: aload_2
    //   57: invokevirtual 69	com/tencent/mobileqq/transfile/NearbyImgDownloader:loadImageFile	(Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   60: astore 4
    //   62: aconst_null
    //   63: astore_2
    //   64: aload_2
    //   65: astore_1
    //   66: aload 4
    //   68: invokevirtual 75	java/io/File:exists	()Z
    //   71: ifeq +104 -> 175
    //   74: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq +34 -> 111
    //   80: ldc 82
    //   82: iconst_2
    //   83: new 84	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   90: ldc 87
    //   92: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: getfield 33	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:jdField_a_of_type_JavaNetURL	Ljava/net/URL;
    //   99: invokevirtual 51	java/net/URL:toString	()Ljava/lang/String;
    //   102: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: new 98	android/graphics/BitmapFactory$Options
    //   114: dup
    //   115: invokespecial 99	android/graphics/BitmapFactory$Options:<init>	()V
    //   118: astore_1
    //   119: aload_1
    //   120: iconst_1
    //   121: putfield 103	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   124: aload 4
    //   126: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   129: aload_1
    //   130: invokestatic 111	bfvo:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   133: pop
    //   134: aload_1
    //   135: getfield 114	android/graphics/BitmapFactory$Options:outWidth	I
    //   138: i2l
    //   139: invokestatic 120	com/tencent/mobileqq/utils/DeviceInfoUtil:getPortraitWidth	()J
    //   142: lcmp
    //   143: ifle +17 -> 160
    //   146: aload_1
    //   147: invokestatic 120	com/tencent/mobileqq/utils/DeviceInfoUtil:getPortraitWidth	()J
    //   150: aload_1
    //   151: getfield 114	android/graphics/BitmapFactory$Options:outWidth	I
    //   154: i2l
    //   155: ldiv
    //   156: l2i
    //   157: putfield 123	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   160: aload_1
    //   161: iconst_0
    //   162: putfield 103	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   165: aload 4
    //   167: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   170: aload_1
    //   171: invokestatic 111	bfvo:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   174: astore_1
    //   175: aload_0
    //   176: getfield 15	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:this$0	Lcom/tencent/mobileqq/freshnews/feed/NearbyImgLoader;
    //   179: getfield 126	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   182: astore_2
    //   183: aload_2
    //   184: monitorenter
    //   185: aload_0
    //   186: getfield 15	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:this$0	Lcom/tencent/mobileqq/freshnews/feed/NearbyImgLoader;
    //   189: getfield 126	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   192: invokevirtual 132	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   195: astore 4
    //   197: aload 4
    //   199: invokeinterface 137 1 0
    //   204: ifeq +146 -> 350
    //   207: aload 4
    //   209: invokeinterface 141 1 0
    //   214: checkcast 143	attw
    //   217: astore 5
    //   219: aload 5
    //   221: ifnull -24 -> 197
    //   224: aload_1
    //   225: ifnonnull +113 -> 338
    //   228: aload_0
    //   229: getfield 20	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:jdField_a_of_type_Int	I
    //   232: iconst_3
    //   233: if_icmpge +94 -> 327
    //   236: aload_0
    //   237: getfield 15	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:this$0	Lcom/tencent/mobileqq/freshnews/feed/NearbyImgLoader;
    //   240: new 47	java/net/URL
    //   243: dup
    //   244: aload_3
    //   245: invokespecial 146	java/net/URL:<init>	(Ljava/lang/String;)V
    //   248: invokevirtual 149	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader:a	(Ljava/net/URL;)V
    //   251: aload_0
    //   252: aload_0
    //   253: getfield 20	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:jdField_a_of_type_Int	I
    //   256: iconst_1
    //   257: iadd
    //   258: putfield 20	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:jdField_a_of_type_Int	I
    //   261: goto -64 -> 197
    //   264: astore_1
    //   265: aload_2
    //   266: monitorexit
    //   267: aload_1
    //   268: athrow
    //   269: astore_1
    //   270: aload_1
    //   271: invokevirtual 152	java/lang/Exception:printStackTrace	()V
    //   274: aload_0
    //   275: getfield 15	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:this$0	Lcom/tencent/mobileqq/freshnews/feed/NearbyImgLoader;
    //   278: getfield 25	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   281: invokevirtual 155	java/util/concurrent/atomic/AtomicInteger:getAndDecrement	()I
    //   284: pop
    //   285: aload_0
    //   286: getfield 15	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader$RequestLoadedImgTask:this$0	Lcom/tencent/mobileqq/freshnews/feed/NearbyImgLoader;
    //   289: invokevirtual 157	com/tencent/mobileqq/freshnews/feed/NearbyImgLoader:a	()V
    //   292: return
    //   293: astore 5
    //   295: aload 5
    //   297: invokevirtual 158	java/lang/OutOfMemoryError:printStackTrace	()V
    //   300: goto -166 -> 134
    //   303: astore_1
    //   304: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +11 -> 318
    //   310: ldc 82
    //   312: iconst_2
    //   313: ldc 160
    //   315: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aload_1
    //   319: invokevirtual 158	java/lang/OutOfMemoryError:printStackTrace	()V
    //   322: aload_2
    //   323: astore_1
    //   324: goto -149 -> 175
    //   327: aload 5
    //   329: aload_3
    //   330: invokeinterface 162 2 0
    //   335: goto -138 -> 197
    //   338: aload 5
    //   340: aload_3
    //   341: aload_1
    //   342: invokeinterface 165 3 0
    //   347: goto -150 -> 197
    //   350: aload_2
    //   351: monitorexit
    //   352: goto -78 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	RequestLoadedImgTask
    //   14	211	1	localObject1	Object
    //   264	4	1	localObject2	Object
    //   269	2	1	localException	java.lang.Exception
    //   303	16	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   323	19	1	localObject3	Object
    //   38	303	3	str	java.lang.String
    //   60	148	4	localObject5	Object
    //   217	3	5	localattw	attw
    //   293	46	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   185	197	264	finally
    //   197	219	264	finally
    //   228	261	264	finally
    //   265	267	264	finally
    //   327	335	264	finally
    //   338	347	264	finally
    //   350	352	264	finally
    //   48	62	269	java/lang/Exception
    //   66	111	269	java/lang/Exception
    //   111	124	269	java/lang/Exception
    //   124	134	269	java/lang/Exception
    //   134	160	269	java/lang/Exception
    //   160	165	269	java/lang/Exception
    //   165	175	269	java/lang/Exception
    //   175	185	269	java/lang/Exception
    //   267	269	269	java/lang/Exception
    //   295	300	269	java/lang/Exception
    //   304	318	269	java/lang/Exception
    //   318	322	269	java/lang/Exception
    //   124	134	293	java/lang/OutOfMemoryError
    //   165	175	303	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.feed.NearbyImgLoader.RequestLoadedImgTask
 * JD-Core Version:    0.7.0.1
 */