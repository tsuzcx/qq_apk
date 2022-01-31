package com.tencent.mobileqq.doutu.combo;

import abyp;
import abyq;
import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@TargetApi(12)
public class ComboResource
{
  public static float a;
  private static LruCache a;
  public static final String a;
  public static boolean a;
  public static final String[] a;
  public static final String b;
  public static final String[] b;
  public static final String[] c;
  public static final String[] d;
  
  static
  {
    jdField_a_of_type_JavaLangString = DoutuManager.jdField_a_of_type_JavaLangString + "combo" + File.separator;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "ribbon0.png", "ribbon1.png", "ribbon2.png", "ribbon3.png", "ribbon4.png", "ribbon5.png", "ribbon6.png", "ribbon7.png", "ribbon8.png", "ribbon9.png" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "0.png", "1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png", "9.png" };
    jdField_a_of_type_Float = 2.0F;
    c = new String[] { "1bitX.png", "2bitX.png", "3bitX.png" };
    jdField_b_of_type_JavaLangString = DoutuManager.jdField_a_of_type_JavaLangString;
    d = new String[] { jdField_b_of_type_JavaLangString + "bonus_8" + File.separator + "doutuX8_", jdField_b_of_type_JavaLangString + "bonus_18" + File.separator + "doutuX18_", jdField_b_of_type_JavaLangString + "bonus_88" + File.separator + "doutuX88_", jdField_b_of_type_JavaLangString + "bonus_888" + File.separator + "doutuX888_" };
    jdField_a_of_type_AndroidUtilLruCache = new LruCache(15);
  }
  
  public static ComboResource.ImageObject a()
  {
    return a(jdField_a_of_type_JavaLangString + "dui.png", 2);
  }
  
  public static ComboResource.ImageObject a(int paramInt)
  {
    return a(jdField_a_of_type_JavaLangString + jdField_a_of_type_ArrayOfJavaLangString[paramInt], 2);
  }
  
  public static ComboResource.ImageObject a(String paramString, int paramInt)
  {
    int i = 0;
    Object localObject1 = (ComboResource.ImageObject)jdField_a_of_type_AndroidUtilLruCache.get(paramString);
    if (localObject1 != null) {
      return localObject1;
    }
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComboUIManager", 2, "resource missing: " + paramString);
      }
      if (!jdField_a_of_type_Boolean)
      {
        jdField_a_of_type_Boolean = true;
        ThreadManager.post(new abyp(), 5, null, false);
      }
      return null;
    }
    Object localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject2);
    localObject1 = BaseApplicationImpl.sApplication.getResources();
    int j = ((BitmapFactory.Options)localObject2).outHeight;
    int k = ((BitmapFactory.Options)localObject2).outWidth;
    try
    {
      localObject2 = Drawable.createFromPath(paramString);
      if ((k == 0) || (j == 0) || (localObject2 == null))
      {
        if (!jdField_a_of_type_Boolean)
        {
          jdField_a_of_type_Boolean = true;
          ThreadManager.post(new abyq(), 5, null, false);
        }
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComboUIManager", 2, "load resource oom: " + paramString);
      }
      return null;
    }
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      ComboResource.ImageObject localImageObject = new ComboResource.ImageObject();
      localImageObject.jdField_a_of_type_Int = i;
      localImageObject.b = paramInt;
      localImageObject.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject2);
      jdField_a_of_type_AndroidUtilLruCache.put(paramString, localImageObject);
      return localImageObject;
      i = AIOUtils.a(k / jdField_a_of_type_Float, localImageObject);
      paramInt = AIOUtils.a(j / jdField_a_of_type_Float, localImageObject);
      continue;
      paramInt = AIOUtils.a(32.0F, localImageObject);
      i = (int)(paramInt / j * k);
      continue;
      paramInt = AIOUtils.a(24.0F, localImageObject);
      i = (int)(paramInt / j * k);
    }
  }
  
  public static void a()
  {
    jdField_a_of_type_AndroidUtilLruCache.evictAll();
  }
  
  public static File[] a(int paramInt)
  {
    int i = 0;
    String str = null;
    while (i < ComboEggView.a.length)
    {
      if (paramInt == ComboEggView.a[i]) {
        str = d[i];
      }
      i += 1;
    }
    if (str == null) {}
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = new ArrayList();
      paramInt = 1;
      while (paramInt <= 31)
      {
        File localFile = new File(str + paramInt + ".png");
        if (localFile.exists()) {
          localArrayList.add(localFile);
        }
        paramInt += 1;
      }
    } while (localArrayList.size() <= 0);
    return (File[])localArrayList.toArray(new File[localArrayList.size()]);
  }
  
  public static ComboResource.ImageObject b()
  {
    return a(jdField_a_of_type_JavaLangString + "ribbonX.png", 3);
  }
  
  public static ComboResource.ImageObject b(int paramInt)
  {
    return a(jdField_a_of_type_JavaLangString + jdField_b_of_type_ArrayOfJavaLangString[paramInt], 1);
  }
  
  public static ComboResource.ImageObject c(int paramInt)
  {
    return a(jdField_a_of_type_JavaLangString + c[(paramInt - 1)], 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboResource
 * JD-Core Version:    0.7.0.1
 */