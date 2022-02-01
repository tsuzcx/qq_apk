package com.tencent.mobileqq.freshnews.feed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NearbyImgLoader
{
  public static int a;
  public static int b;
  public static int c;
  private static NearbyImgLoader h = new NearbyImgLoader();
  NearbyImgDownloader d = new NearbyImgDownloader();
  public List<URL> e = new ArrayList();
  ArrayList<NearbyImgLoader.OnLoadNearbyImgsCallback> f = new ArrayList();
  AtomicInteger g = new AtomicInteger();
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int i = ((WindowManager)localBaseApplication.getSystemService("window")).getDefaultDisplay().getWidth();
    b = (i - AIOUtils.b(2.0F, localBaseApplication.getResources())) / 2;
    a = i;
    c = localBaseApplication.getResources().getDisplayMetrics().densityDpi;
  }
  
  public static NearbyImgLoader a()
  {
    return h;
  }
  
  public Pair<Bitmap, Boolean> a(String paramString, Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    paramBitmap.setDensity(c);
    int i;
    int j;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          i = 0;
          j = 0;
        }
        else
        {
          i = b;
          j = i;
        }
      }
      else
      {
        i = a;
        j = i / 2;
      }
    }
    else
    {
      i = a;
      j = i * 3 / 4;
    }
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    if ((k == i) && (m == j)) {
      return new Pair(paramBitmap, Boolean.valueOf(true));
    }
    if (k > m) {
      if ((paramInt != 1) && (paramInt != 2))
      {
        paramString = paramBitmap;
        if (paramInt != 3) {
          break label780;
        }
        f1 = j / m;
        paramString = paramBitmap;
      }
    }
    try
    {
      localObject = new Matrix();
      paramString = paramBitmap;
      ((Matrix)localObject).setScale(f1, f1);
      paramString = paramBitmap;
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, k, m, (Matrix)localObject, false);
      if (paramBitmap != localObject) {
        paramString = (String)localObject;
      }
    }
    catch (Throwable localThrowable1)
    {
      Object localObject;
      paramBitmap = paramString;
      paramString = localThrowable1;
    }
    try
    {
      paramBitmap.recycle();
      paramString = (String)localObject;
      paramInt = ((Bitmap)localObject).getWidth();
      paramString = (String)localObject;
      ((Bitmap)localObject).getHeight();
      paramString = (String)localObject;
      if (paramInt <= i) {
        break label780;
      }
      paramString = (String)localObject;
      paramBitmap = Bitmap.createBitmap((Bitmap)localObject, (paramInt - i) / 2, 0, i, j);
      paramString = paramBitmap;
      if (localObject == paramBitmap) {
        break label780;
      }
      paramString = paramBitmap;
      ((Bitmap)localObject).recycle();
      paramString = paramBitmap;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        paramBitmap = paramString;
        paramString = localThrowable2;
      }
    }
    paramString = paramBitmap;
    float f1 = i / k;
    paramString = paramBitmap;
    localObject = new Matrix();
    paramString = paramBitmap;
    ((Matrix)localObject).setScale(f1, f1);
    paramString = paramBitmap;
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, k, m, (Matrix)localObject, false);
    if (paramBitmap != localObject)
    {
      paramString = (String)localObject;
      paramBitmap.recycle();
    }
    paramString = (String)localObject;
    ((Bitmap)localObject).getWidth();
    paramString = (String)localObject;
    paramInt = ((Bitmap)localObject).getHeight();
    paramString = (String)localObject;
    if (paramInt > j)
    {
      paramString = (String)localObject;
      paramBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, (paramInt - j) / 2, i, j);
      paramString = paramBitmap;
      if (localObject != paramBitmap)
      {
        paramString = paramBitmap;
        ((Bitmap)localObject).recycle();
        paramString = paramBitmap;
        break label780;
        paramString = paramBitmap;
        f1 = i / k;
        paramString = paramBitmap;
        localObject = new Matrix();
        paramString = paramBitmap;
        ((Matrix)localObject).setScale(f1, f1);
        paramString = paramBitmap;
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, k, m, (Matrix)localObject, false);
        paramString = paramBitmap;
        i = paramBitmap.getWidth();
        paramString = paramBitmap;
        j = paramBitmap.getHeight();
        if (paramInt == 1)
        {
          paramString = paramBitmap;
          paramInt = j / 3;
          k = i * 3;
          paramString = paramBitmap;
          if (paramInt >= k / 8)
          {
            paramString = paramBitmap;
            localObject = Bitmap.createBitmap(paramBitmap, 0, j / 3 - k / 8, i, k / 4);
            paramString = (String)localObject;
            if (paramBitmap != localObject)
            {
              paramString = (String)localObject;
              paramBitmap.recycle();
              paramString = (String)localObject;
            }
          }
          else
          {
            paramString = paramBitmap;
            localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, k / 4);
            paramString = (String)localObject;
            if (paramBitmap != localObject)
            {
              paramString = (String)localObject;
              paramBitmap.recycle();
              paramString = (String)localObject;
            }
          }
        }
        else if (paramInt == 2)
        {
          paramString = paramBitmap;
          localObject = Bitmap.createBitmap(paramBitmap, 0, j / 3 - i / 4, i, i / 2);
          paramString = (String)localObject;
          if (paramBitmap != localObject)
          {
            paramString = (String)localObject;
            paramBitmap.recycle();
            paramString = (String)localObject;
          }
        }
        else
        {
          paramString = paramBitmap;
          if (paramInt != 3) {
            break label780;
          }
          paramString = paramBitmap;
          if (i >= j * 2 / 3)
          {
            paramString = paramBitmap;
            localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, i);
            paramString = (String)localObject;
            if (paramBitmap != localObject)
            {
              paramString = (String)localObject;
              paramBitmap.recycle();
              paramString = (String)localObject;
            }
          }
          else
          {
            paramString = paramBitmap;
            localObject = Bitmap.createBitmap(paramBitmap, 0, j * 1 / 3 - i / 2, i, i);
            paramString = (String)localObject;
            if (paramBitmap != localObject)
            {
              paramString = (String)localObject;
              paramBitmap.recycle();
              paramString = (String)localObject;
            }
          }
        }
      }
    }
    label780:
    for (;;)
    {
      if (paramString != null) {
        paramString.setDensity(c);
      }
      return new Pair(paramString, Boolean.valueOf(true));
      paramString.printStackTrace();
      System.gc();
      return new Pair(paramBitmap, Boolean.valueOf(false));
    }
  }
  
  public void a(URL paramURL)
  {
    synchronized (this.e)
    {
      if (!this.e.contains(paramURL)) {
        this.e.add(paramURL);
      }
      b();
      return;
    }
  }
  
  void b()
  {
    if (this.g.get() < 4) {}
    for (;;)
    {
      synchronized (this.e)
      {
        if (this.e.size() <= 0) {
          break label117;
        }
        ??? = (URL)this.e.remove(this.e.size() - 1);
        if (??? != null)
        {
          ThreadManager.post(new NearbyImgLoader.RequestLoadedImgTask(this, (URL)???), 8, null, true);
          return;
        }
        synchronized (this.e)
        {
          if (this.e.size() > 0) {
            b();
          }
          return;
        }
      }
      return;
      label117:
      Object localObject3 = null;
    }
  }
  
  public void c()
  {
    synchronized (this.e)
    {
      this.e.clear();
      synchronized (this.f)
      {
        this.f.clear();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.feed.NearbyImgLoader
 * JD-Core Version:    0.7.0.1
 */