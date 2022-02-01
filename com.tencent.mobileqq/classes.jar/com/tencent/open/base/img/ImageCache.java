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
  public static final String a;
  protected static final String b;
  protected static ImageDbHelper c = new ImageDbHelper(CommonDataAdapter.a().b());
  protected static ThreadPoolExecutor d = new ThreadPoolExecutor(3, 5, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
  
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
    a = ((StringBuilder)localObject).toString();
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
      ((StringBuilder)localObject).append(Common.f());
      ((StringBuilder)localObject).append(b);
      localObject = new File(((StringBuilder)localObject).toString());
      if (((File)localObject).exists())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(Common.f());
        localStringBuilder.append(a);
        ((File)localObject).renameTo(new File(localStringBuilder.toString()));
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Common.f());
    localStringBuilder.append(a);
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
    //   3: getstatic 99	com/tencent/open/base/img/ImageCache:d	Ljava/util/concurrent/ThreadPoolExecutor;
    //   6: invokevirtual 112	java/util/concurrent/ThreadPoolExecutor:getQueue	()Ljava/util/concurrent/BlockingQueue;
    //   9: aload_0
    //   10: invokeinterface 118 2 0
    //   15: ifeq +56 -> 71
    //   18: new 17	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   25: astore_1
    //   26: aload_1
    //   27: ldc 120
    //   29: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_1
    //   34: aload_0
    //   35: getfield 123	com/tencent/open/base/img/ImageCache$UpdateTask:a	Ljava/lang/String;
    //   38: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_1
    //   43: ldc 125
    //   45: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_1
    //   50: aload_0
    //   51: getfield 127	com/tencent/open/base/img/ImageCache$UpdateTask:c	Ljava/lang/String;
    //   54: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: ldc 129
    //   60: aload_1
    //   61: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 134	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: ldc 2
    //   69: monitorexit
    //   70: return
    //   71: new 17	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: ldc 136
    //   82: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_1
    //   87: aload_0
    //   88: getfield 123	com/tencent/open/base/img/ImageCache$UpdateTask:a	Ljava/lang/String;
    //   91: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_1
    //   96: ldc 125
    //   98: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_1
    //   103: aload_0
    //   104: getfield 127	com/tencent/open/base/img/ImageCache$UpdateTask:c	Ljava/lang/String;
    //   107: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: ldc 129
    //   113: aload_1
    //   114: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 134	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: getstatic 99	com/tencent/open/base/img/ImageCache:d	Ljava/util/concurrent/ThreadPoolExecutor;
    //   123: aload_0
    //   124: invokevirtual 140	java/util/concurrent/ThreadPoolExecutor:execute	(Ljava/lang/Runnable;)V
    //   127: goto +44 -> 171
    //   130: astore_0
    //   131: goto +44 -> 175
    //   134: astore_1
    //   135: ldc 129
    //   137: ldc 142
    //   139: aload_1
    //   140: invokestatic 145	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: aload_0
    //   144: getfield 148	com/tencent/open/base/img/ImageCache$UpdateTask:d	Lcom/tencent/open/base/img/ImageDownCallback;
    //   147: ifnull +24 -> 171
    //   150: aload_0
    //   151: getfield 148	com/tencent/open/base/img/ImageCache$UpdateTask:d	Lcom/tencent/open/base/img/ImageDownCallback;
    //   154: aload_0
    //   155: getfield 123	com/tencent/open/base/img/ImageCache$UpdateTask:a	Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 149	com/tencent/open/base/img/ImageCache$UpdateTask:b	Ljava/lang/String;
    //   162: aload_0
    //   163: getfield 127	com/tencent/open/base/img/ImageCache$UpdateTask:c	Ljava/lang/String;
    //   166: invokeinterface 154 4 0
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache
 * JD-Core Version:    0.7.0.1
 */