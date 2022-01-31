package com.tencent.open.base.img;

import android.text.TextUtils;
import bcyb;
import bdfn;
import bdif;
import bdii;
import bdik;
import bdjh;
import bdji;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ImageCache
{
  protected static bdjh a;
  public static final String a;
  protected static ThreadPoolExecutor a;
  protected static final String b = File.separator + "tencent" + File.separator + "qzone" + File.separator + "ImgCache2" + File.separator;
  
  static
  {
    jdField_a_of_type_JavaLangString = File.separator + "tencent" + File.separator + "qzone" + File.separator + ".AppCenterImgCache" + File.separator;
    try
    {
      File localFile = new File(bdfn.e() + b);
      if (localFile.exists()) {
        localFile.renameTo(new File(bdfn.e() + jdField_a_of_type_JavaLangString));
      }
      jdField_a_of_type_Bdjh = new bdjh(bcyb.a().a());
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
    return bdfn.e() + jdField_a_of_type_JavaLangString + paramString1 + File.separator + bdif.a(paramString2);
  }
  
  protected static void a(ImageCache.UpdateTask paramUpdateTask)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.getQueue().contains(paramUpdateTask)) {
        bdii.a("ImageCache", "download task already exist, return. key= " + paramUpdateTask.jdField_a_of_type_JavaLangString + " url=" + paramUpdateTask.c);
      }
      for (;;)
      {
        return;
        bdii.a("ImageCache", "add download task to queue. key= " + paramUpdateTask.jdField_a_of_type_JavaLangString + " url=" + paramUpdateTask.c);
        jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(paramUpdateTask);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bdii.c("ImageCache", "execute>>> ", localException);
        if (paramUpdateTask.jdField_a_of_type_Bdji != null) {
          paramUpdateTask.jdField_a_of_type_Bdji.b(paramUpdateTask.jdField_a_of_type_JavaLangString, paramUpdateTask.b, paramUpdateTask.c);
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
      bdii.c("ImageCache", "-->delete image file failed.", paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2, bdji parambdji)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    a(bdik.b(paramString2), paramString1, paramString2, parambdji);
  }
  
  protected static void a(String paramString1, String paramString2, String paramString3, bdji parambdji)
  {
    a(new ImageCache.UpdateTask(paramString1, paramString2, paramString3, parambdji));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache
 * JD-Core Version:    0.7.0.1
 */