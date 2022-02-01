package com.tencent.open.base.img;

import android.text.TextUtils;
import bjjo;
import bjrc;
import bjtu;
import bjtx;
import bjtz;
import bjuw;
import bjux;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ImageCache
{
  protected static bjuw a;
  public static final String a;
  protected static ThreadPoolExecutor a;
  protected static final String b = File.separator + "tencent" + File.separator + "qzone" + File.separator + "ImgCache2" + File.separator;
  
  static
  {
    jdField_a_of_type_JavaLangString = File.separator + "tencent" + File.separator + "qzone" + File.separator + ".AppCenterImgCache" + File.separator;
    try
    {
      File localFile = new File(bjrc.e() + b);
      if (localFile.exists()) {
        localFile.renameTo(new File(bjrc.e() + jdField_a_of_type_JavaLangString));
      }
      jdField_a_of_type_Bjuw = new bjuw(bjjo.a().a());
      jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(3, 5, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return bjrc.e() + jdField_a_of_type_JavaLangString + paramString1 + File.separator + bjtu.a(paramString2);
  }
  
  protected static void a(ImageCache.UpdateTask paramUpdateTask)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue().contains(paramUpdateTask)) {
        bjtx.a("ImageCache", "download task already exist, return. key= " + paramUpdateTask.jdField_a_of_type_JavaLangString + " url=" + paramUpdateTask.c);
      }
      for (;;)
      {
        return;
        bjtx.a("ImageCache", "add download task to queue. key= " + paramUpdateTask.jdField_a_of_type_JavaLangString + " url=" + paramUpdateTask.c);
        jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(paramUpdateTask);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bjtx.c("ImageCache", "execute>>> ", localException);
        if (paramUpdateTask.jdField_a_of_type_Bjux != null) {
          paramUpdateTask.jdField_a_of_type_Bjux.b(paramUpdateTask.jdField_a_of_type_JavaLangString, paramUpdateTask.b, paramUpdateTask.c);
        }
      }
    }
    finally {}
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
      bjtx.c("ImageCache", "-->delete image file failed.", paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2, bjux parambjux)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    a(bjtz.b(paramString2), paramString1, paramString2, parambjux);
  }
  
  protected static void a(String paramString1, String paramString2, String paramString3, bjux parambjux)
  {
    a(new ImageCache.UpdateTask(paramString1, paramString2, paramString3, parambjux));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache
 * JD-Core Version:    0.7.0.1
 */