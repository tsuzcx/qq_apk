package com.tencent.mobileqq.freshnews.feed;

import aekt;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import asds;
import baqq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NearbyImgLoader
{
  public static int a;
  private static NearbyImgLoader jdField_a_of_type_ComTencentMobileqqFreshnewsFeedNearbyImgLoader = new NearbyImgLoader();
  public static int b;
  public static int c;
  baqq jdField_a_of_type_Baqq = new baqq();
  ArrayList<asds> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public List<URL> a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int i = ((WindowManager)localBaseApplication.getSystemService("window")).getDefaultDisplay().getWidth();
    b = (i - aekt.a(2.0F, localBaseApplication.getResources())) / 2;
    jdField_a_of_type_Int = i;
    c = localBaseApplication.getResources().getDisplayMetrics().densityDpi;
  }
  
  private NearbyImgLoader()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static NearbyImgLoader a()
  {
    return jdField_a_of_type_ComTencentMobileqqFreshnewsFeedNearbyImgLoader;
  }
  
  public Pair<Bitmap, Boolean> a(String paramString, Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    paramBitmap.setDensity(c);
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      i = 0;
      j = 0;
    }
    int k;
    int m;
    for (;;)
    {
      k = paramBitmap.getWidth();
      m = paramBitmap.getHeight();
      if ((k != j) || (m != i)) {
        break;
      }
      return new Pair(paramBitmap, Boolean.valueOf(true));
      j = jdField_a_of_type_Int;
      i = jdField_a_of_type_Int * 3 / 4;
      continue;
      j = jdField_a_of_type_Int;
      i = jdField_a_of_type_Int / 2;
      continue;
      i = b;
      j = b;
    }
    float f;
    if (k > m) {
      if ((paramInt == 1) || (paramInt == 2))
      {
        f = j / k;
        paramString = paramBitmap;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new Matrix();
        paramString = paramBitmap;
        ((Matrix)localObject).setScale(f, f);
        paramString = paramBitmap;
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, k, m, (Matrix)localObject, false);
        if (paramBitmap != localObject) {
          paramString = (String)localObject;
        }
      }
      catch (Throwable paramBitmap)
      {
        Object localObject;
        continue;
      }
      try
      {
        paramBitmap.recycle();
        paramString = (String)localObject;
        ((Bitmap)localObject).getWidth();
        paramString = (String)localObject;
        paramInt = ((Bitmap)localObject).getHeight();
        paramString = (String)localObject;
        if (paramInt <= i) {
          break label794;
        }
        paramString = (String)localObject;
        paramBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, (paramInt - i) / 2, j, i);
        paramString = paramBitmap;
        if (localObject != paramBitmap) {
          paramString = paramBitmap;
        }
      }
      catch (Throwable paramBitmap)
      {
        continue;
        continue;
        continue;
      }
      try
      {
        ((Bitmap)localObject).recycle();
        paramString = paramBitmap;
        if (paramString != null) {
          paramString.setDensity(c);
        }
        return new Pair(paramString, Boolean.valueOf(true));
      }
      catch (Throwable paramBitmap) {}
      paramString = paramBitmap;
      if (paramInt != 3) {
        break label791;
      }
      f = i / m;
      paramString = paramBitmap;
      localObject = new Matrix();
      paramString = paramBitmap;
      ((Matrix)localObject).setScale(f, f);
      paramString = paramBitmap;
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, k, m, (Matrix)localObject, false);
      if (paramBitmap != localObject)
      {
        paramString = (String)localObject;
        paramBitmap.recycle();
      }
      paramString = (String)localObject;
      paramInt = ((Bitmap)localObject).getWidth();
      paramString = (String)localObject;
      ((Bitmap)localObject).getHeight();
      paramString = (String)localObject;
      if (paramInt <= j) {
        break label794;
      }
      paramString = (String)localObject;
      paramBitmap = Bitmap.createBitmap((Bitmap)localObject, (paramInt - j) / 2, 0, j, i);
      paramString = paramBitmap;
      if (localObject != paramBitmap)
      {
        paramString = paramBitmap;
        ((Bitmap)localObject).recycle();
        paramString = paramBitmap;
        continue;
        paramBitmap.printStackTrace();
        System.gc();
        return new Pair(paramString, Boolean.valueOf(false));
        f = j / k;
        paramString = paramBitmap;
        localObject = new Matrix();
        paramString = paramBitmap;
        ((Matrix)localObject).setScale(f, f);
        paramString = paramBitmap;
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, k, m, (Matrix)localObject, false);
        paramString = (String)localObject;
        i = ((Bitmap)localObject).getWidth();
        paramString = (String)localObject;
        j = ((Bitmap)localObject).getHeight();
        if (paramInt == 1)
        {
          paramString = (String)localObject;
          if (j / 3 >= i * 3 / 8)
          {
            paramString = (String)localObject;
            paramBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, j / 3 - i * 3 / 8, i, i * 3 / 4);
            paramString = paramBitmap;
            if (localObject != paramBitmap)
            {
              paramString = paramBitmap;
              ((Bitmap)localObject).recycle();
              paramString = paramBitmap;
            }
          }
          else
          {
            paramString = (String)localObject;
            paramBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, 0, i, i * 3 / 4);
            paramString = paramBitmap;
            if (localObject != paramBitmap)
            {
              paramString = paramBitmap;
              ((Bitmap)localObject).recycle();
              paramString = paramBitmap;
            }
          }
        }
        else if (paramInt == 2)
        {
          paramString = (String)localObject;
          paramBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, j / 3 - i / 4, i, i / 2);
          paramString = paramBitmap;
          if (localObject != paramBitmap)
          {
            paramString = paramBitmap;
            ((Bitmap)localObject).recycle();
            paramString = paramBitmap;
          }
        }
        else
        {
          paramString = (String)localObject;
          if (paramInt != 3) {
            break label791;
          }
          paramString = (String)localObject;
          if (i >= j * 2 / 3)
          {
            paramString = (String)localObject;
            paramBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, 0, i, i);
            paramString = paramBitmap;
            if (localObject != paramBitmap)
            {
              paramString = paramBitmap;
              ((Bitmap)localObject).recycle();
              paramString = paramBitmap;
            }
          }
          else
          {
            paramString = (String)localObject;
            paramBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, j * 1 / 3 - i / 2, i, i);
            paramString = paramBitmap;
            if (localObject != paramBitmap)
            {
              paramString = paramBitmap;
              ((Bitmap)localObject).recycle();
              paramString = paramBitmap;
            }
          }
        }
      }
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 4) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
          break label113;
        }
        URL localURL = (URL)this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
        if (localURL != null)
        {
          ThreadManager.post(new NearbyImgLoader.RequestLoadedImgTask(this, localURL), 8, null, true);
          return;
        }
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          a();
        }
        return;
      }
      label113:
      ??? = null;
    }
  }
  
  public void a(URL paramURL)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramURL)) {
        this.jdField_a_of_type_JavaUtilList.add(paramURL);
      }
      a();
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.feed.NearbyImgLoader
 * JD-Core Version:    0.7.0.1
 */