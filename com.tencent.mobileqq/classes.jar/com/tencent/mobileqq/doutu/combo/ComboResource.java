package com.tencent.mobileqq.doutu.combo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.doutu.api.IDoutuUtils;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@TargetApi(12)
public class ComboResource
{
  public static final String a;
  public static final String[] b;
  public static final String[] c;
  public static boolean d;
  public static float e;
  public static final String[] f;
  public static final String g;
  public static final String[] h;
  private static LruCache<String, ComboResource.ImageObject> i = new LruCache(15);
  
  static
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(IDoutuUtils.DOUTU_ANIMA_RES_PATH);
    ((StringBuilder)localObject1).append("combo");
    ((StringBuilder)localObject1).append(File.separator);
    a = RmVFSUtils.getVFSPath(((StringBuilder)localObject1).toString());
    b = new String[] { "ribbon0.png", "ribbon1.png", "ribbon2.png", "ribbon3.png", "ribbon4.png", "ribbon5.png", "ribbon6.png", "ribbon7.png", "ribbon8.png", "ribbon9.png" };
    c = new String[] { "0.png", "1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png", "9.png" };
    d = false;
    e = 2.0F;
    f = new String[] { "1bitX.png", "2bitX.png", "3bitX.png" };
    g = IDoutuUtils.DOUTU_ANIMA_RES_PATH;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(g);
    ((StringBuilder)localObject1).append("bonus_8");
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("doutuX8_");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(g);
    ((StringBuilder)localObject2).append("bonus_18");
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("doutuX18_");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(g);
    ((StringBuilder)localObject3).append("bonus_88");
    ((StringBuilder)localObject3).append(File.separator);
    ((StringBuilder)localObject3).append("doutuX88_");
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(g);
    localStringBuilder.append("bonus_888");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("doutuX888_");
    h = new String[] { localObject1, localObject2, localObject3, localStringBuilder.toString() };
  }
  
  public static ComboResource.ImageObject a(int paramInt, Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(b[paramInt]);
    return a(localStringBuilder.toString(), 2, paramContext);
  }
  
  public static ComboResource.ImageObject a(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("dui.png");
    return a(localStringBuilder.toString(), 2, paramContext);
  }
  
  public static ComboResource.ImageObject a(String paramString, int paramInt, Context paramContext)
  {
    Object localObject1 = (ComboResource.ImageObject)i.get(paramString);
    if (localObject1 != null) {
      return localObject1;
    }
    boolean bool = new File(paramString).exists();
    int j = 0;
    if (!bool)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("resource missing: ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("ComboUIManager", 2, ((StringBuilder)localObject1).toString());
      }
      if (!d)
      {
        d = true;
        ThreadManager.post(new ComboResource.1(paramContext), 5, null, false);
      }
      return null;
    }
    Object localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject2);
    localObject1 = paramContext.getResources();
    int k = ((BitmapFactory.Options)localObject2).outHeight;
    int m = ((BitmapFactory.Options)localObject2).outWidth;
    try
    {
      localObject2 = Drawable.createFromPath(paramString);
      if ((m != 0) && (k != 0) && (localObject2 != null))
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              k = 0;
              paramInt = j;
              j = k;
              break label259;
            }
            paramInt = Utils.a(24.0F, (Resources)localObject1);
          }
          else
          {
            paramInt = Utils.a(32.0F, (Resources)localObject1);
          }
          j = (int)(paramInt / k * m);
        }
        else
        {
          j = Utils.a(m / e, (Resources)localObject1);
          paramInt = Utils.a(k / e, (Resources)localObject1);
        }
        label259:
        paramContext = new ComboResource.ImageObject();
        paramContext.a = j;
        paramContext.b = paramInt;
        paramContext.c = ((Drawable)localObject2);
        i.put(paramString, paramContext);
        return paramContext;
      }
      if (!d)
      {
        d = true;
        ThreadManager.post(new ComboResource.2(paramContext), 5, null, false);
      }
      return null;
    }
    catch (OutOfMemoryError paramContext)
    {
      label320:
      break label320;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("load resource oom: ");
      paramContext.append(paramString);
      QLog.d("ComboUIManager", 2, paramContext.toString());
    }
    return null;
  }
  
  public static void a()
  {
    i.evictAll();
  }
  
  public static File[] a(int paramInt)
  {
    int j = 0;
    String str = null;
    while (j < ComboEggView.a.length)
    {
      if (paramInt == ComboEggView.a[j]) {
        str = h[j];
      }
      j += 1;
    }
    if (str == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramInt = 1;
    while (paramInt <= 31)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(".png");
      localObject = new File(((StringBuilder)localObject).toString());
      if (((File)localObject).exists()) {
        localArrayList.add(localObject);
      }
      paramInt += 1;
    }
    if (localArrayList.size() > 0) {
      return (File[])localArrayList.toArray(new File[localArrayList.size()]);
    }
    return null;
  }
  
  public static ComboResource.ImageObject b(int paramInt, Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(c[paramInt]);
    return a(localStringBuilder.toString(), 1, paramContext);
  }
  
  public static ComboResource.ImageObject b(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("ribbonX.png");
    return a(localStringBuilder.toString(), 3, paramContext);
  }
  
  public static ComboResource.ImageObject c(int paramInt, Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(f[(paramInt - 1)]);
    return a(localStringBuilder.toString(), 1, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboResource
 * JD-Core Version:    0.7.0.1
 */