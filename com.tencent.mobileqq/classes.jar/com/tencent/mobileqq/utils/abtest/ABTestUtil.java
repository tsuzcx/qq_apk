package com.tencent.mobileqq.utils.abtest;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.qcircle.api.impl.QCircleOnlineExpProviderImpl;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mtt.abtestsdk.entity.ExpEntity;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ABTestUtil
{
  @ConfigInject(configPath="Foundation/QQCommon/src/main/resources/Inject_Online_TabExpList.yml", version=1)
  public static ArrayList<Class<? extends IOnlineExpProvider>> a = new ArrayList();
  
  static
  {
    a.add(QCircleOnlineExpProviderImpl.class);
  }
  
  public static StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if ((paramDrawable1 != null) && (paramDrawable2 != null))
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16843518 }, paramDrawable2);
      localStateListDrawable.addState(new int[] { -16843518 }, paramDrawable1);
      return localStateListDrawable;
    }
    return null;
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString)) && (paramInt1 > 0) && (paramInt2 > 0) && (paramString.startsWith("https")))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt1;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
      ((URLDrawable.URLDrawableOptions)localObject).mUseApngImage = false;
      ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = true;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      if (paramString != null) {
        paramString.startDownload();
      }
      return paramString;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getUrlDrawable params error, url:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AIOUtils", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public static String a(ExpEntity paramExpEntity, String paramString)
  {
    if (paramExpEntity != null) {
      return String.format("exp:%s. %s->%s", new Object[] { paramExpEntity.getExpName(), paramString, paramExpEntity.getAssignment() });
    }
    return "";
  }
  
  public static List<String> a()
  {
    try
    {
      ArrayList localArrayList;
      if ((a != null) && (!a.isEmpty()))
      {
        localArrayList = new ArrayList();
        localObject1 = a.iterator();
      }
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Class)((Iterator)localObject1).next();
        if (localObject2 == null)
        {
          a("getInjectedExpList when clazz=null");
        }
        else
        {
          localObject2 = ((Class)localObject2).getDeclaredConstructor(new Class[0]);
          ((Constructor)localObject2).setAccessible(true);
          localObject2 = (IOnlineExpProvider)((Constructor)localObject2).newInstance(new Object[0]);
          if (localObject2 != null)
          {
            localArrayList.addAll(((IOnlineExpProvider)localObject2).getRegisterExpNameList());
            continue;
            a("getInjectedExpList sOnlineExpInjector=null or isEmpty");
            return null;
          }
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getInjectedExpList error:");
      ((StringBuilder)localObject1).append(localException.getMessage());
      a(((StringBuilder)localObject1).toString());
      return null;
    }
    return localException;
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ABTestController", 2, paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public static boolean a(ExpEntityInfo paramExpEntityInfo)
  {
    if ((paramExpEntityInfo != null) && (paramExpEntityInfo.c()) && (a(paramExpEntityInfo.getExpName()))) {
      return a(paramExpEntityInfo.getAssignment()) ^ true;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.equals("default", paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.abtest.ABTestUtil
 * JD-Core Version:    0.7.0.1
 */