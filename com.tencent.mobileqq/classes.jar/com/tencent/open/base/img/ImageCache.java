package com.tencent.open.base.img;

import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.MD5Utils;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ImageCache
{
  protected static ImageDbHelper a;
  public static final String a;
  protected static ThreadPoolExecutor a;
  protected static final String b;
  
  static
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("tencent");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("qzone");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(".AppCenterImgCache");
    ((StringBuilder)localObject).append(File.separator);
    jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("tencent");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("qzone");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("ImgCache2");
    ((StringBuilder)localObject).append(File.separator);
    b = ((StringBuilder)localObject).toString();
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Common.e());
      ((StringBuilder)localObject).append(b);
      localObject = new File(((StringBuilder)localObject).toString());
      if (((File)localObject).exists())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(Common.e());
        localStringBuilder.append(jdField_a_of_type_JavaLangString);
        ((File)localObject).renameTo(new File(localStringBuilder.toString()));
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    jdField_a_of_type_ComTencentOpenBaseImgImageDbHelper = new ImageDbHelper(CommonDataAdapter.a().a());
    jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(3, 5, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Common.e());
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(FileUtils.a(paramString2));
    return localStringBuilder.toString();
  }
  
  /* Error */
  protected static void a(ImageCache.UpdateTask paramUpdateTask)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 97	com/tencent/open/base/img/ImageCache:jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   6: invokevirtual 110	java/util/concurrent/ThreadPoolExecutor:getQueue	()Ljava/util/concurrent/BlockingQueue;
    //   9: aload_0
    //   10: invokeinterface 116 2 0
    //   15: ifeq +56 -> 71
    //   18: new 15	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   25: astore_1
    //   26: aload_1
    //   27: ldc 118
    //   29: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_1
    //   34: aload_0
    //   35: getfield 121	com/tencent/open/base/img/ImageCache$UpdateTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   38: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_1
    //   43: ldc 123
    //   45: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_1
    //   50: aload_0
    //   51: getfield 126	com/tencent/open/base/img/ImageCache$UpdateTask:c	Ljava/lang/String;
    //   54: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: ldc 128
    //   60: aload_1
    //   61: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 133	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: ldc 2
    //   69: monitorexit
    //   70: return
    //   71: new 15	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: ldc 135
    //   82: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_1
    //   87: aload_0
    //   88: getfield 121	com/tencent/open/base/img/ImageCache$UpdateTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   91: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_1
    //   96: ldc 123
    //   98: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_1
    //   103: aload_0
    //   104: getfield 126	com/tencent/open/base/img/ImageCache$UpdateTask:c	Ljava/lang/String;
    //   107: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: ldc 128
    //   113: aload_1
    //   114: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 133	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: getstatic 97	com/tencent/open/base/img/ImageCache:jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor	Ljava/util/concurrent/ThreadPoolExecutor;
    //   123: aload_0
    //   124: invokevirtual 139	java/util/concurrent/ThreadPoolExecutor:execute	(Ljava/lang/Runnable;)V
    //   127: goto +44 -> 171
    //   130: astore_0
    //   131: goto +44 -> 175
    //   134: astore_1
    //   135: ldc 128
    //   137: ldc 141
    //   139: aload_1
    //   140: invokestatic 144	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: aload_0
    //   144: getfield 147	com/tencent/open/base/img/ImageCache$UpdateTask:jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback	Lcom/tencent/open/base/img/ImageDownCallback;
    //   147: ifnull +24 -> 171
    //   150: aload_0
    //   151: getfield 147	com/tencent/open/base/img/ImageCache$UpdateTask:jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback	Lcom/tencent/open/base/img/ImageDownCallback;
    //   154: aload_0
    //   155: getfield 121	com/tencent/open/base/img/ImageCache$UpdateTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 148	com/tencent/open/base/img/ImageCache$UpdateTask:b	Ljava/lang/String;
    //   162: aload_0
    //   163: getfield 126	com/tencent/open/base/img/ImageCache$UpdateTask:c	Ljava/lang/String;
    //   166: invokeinterface 153 4 0
    //   171: ldc 2
    //   173: monitorexit
    //   174: return
    //   175: ldc 2
    //   177: monitorexit
    //   178: aload_0
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramUpdateTask	ImageCache.UpdateTask
    //   25	89	1	localStringBuilder	StringBuilder
    //   134	6	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   3	67	130	finally
    //   71	127	130	finally
    //   135	171	130	finally
    //   3	67	134	java/lang/Exception
    //   71	127	134	java/lang/Exception
  }
  
  public static void a(String paramString)
  {
    try
    {
      new File(a("app", paramString)).delete();
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c("ImageCache", "-->delete image file failed.", paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2, ImageDownCallback paramImageDownCallback)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      a(MD5Utils.encodeHexStr(paramString2), paramString1, paramString2, paramImageDownCallback);
    }
  }
  
  protected static void a(String paramString1, String paramString2, String paramString3, ImageDownCallback paramImageDownCallback)
  {
    a(new ImageCache.UpdateTask(paramString1, paramString2, paramString3, paramImageDownCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache
 * JD-Core Version:    0.7.0.1
 */