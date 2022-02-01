package com.tencent.mobileqq.vas.theme.diy;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;

public class DIYThemeUtils
{
  public static String a = "https://gxh.vip.qq.com/xydata/";
  
  public static Drawable a(Context paramContext, ResData paramResData, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject2;
    Object localObject1;
    if ((paramResData != null) && (paramContext != null))
    {
      if (paramResData.h > 0)
      {
        if (paramResData.h == 2130847705)
        {
          paramResData = paramContext.getResources().getAssets();
          try
          {
            InputStream localInputStream = paramResData.open("999_540/drawable-xhdpi/qq_setting_me_bg.png");
            try
            {
              paramResData = BitmapFactory.decodeStream(localInputStream);
            }
            catch (OutOfMemoryError paramResData)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("getDIYDrawable decodeStream oom:");
              ((StringBuilder)localObject2).append(paramResData.getMessage());
              QLog.e("DIYThemeUtils", 1, ((StringBuilder)localObject2).toString());
              paramResData = null;
            }
            try
            {
              localInputStream.close();
            }
            catch (Exception localException1) {}
            localObject2 = new StringBuilder();
          }
          catch (Exception localException2)
          {
            paramResData = null;
          }
          ((StringBuilder)localObject2).append("getDIYDrawable AssetManager err:");
          ((StringBuilder)localObject2).append(localException2.getMessage());
          QLog.e("DIYThemeUtils", 1, ((StringBuilder)localObject2).toString());
          if (paramResData != null) {
            return new BitmapDrawable(paramContext.getResources(), paramResData);
          }
          QLog.e("DIYThemeUtils", 1, "getDIYDrawable qq_setting_me_bg.png bitmap null err");
          return null;
        }
        return SkinEngine.getInstances().getDefaultThemeDrawable(paramResData.h);
      }
      if (1 == paramResData.i) {
        localObject1 = paramContext.getResources().getDrawable(2130847705);
      } else if (2 == paramResData.i) {
        localObject1 = paramContext.getResources().getDrawable(2130852152);
      } else if (3 == paramResData.i) {
        localObject1 = paramContext.getResources().getDrawable(2130852162);
      } else {
        localObject1 = paramContext.getResources().getDrawable(2130849357);
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = paramResData.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramResData.e);
        if (!paramBoolean) {
          break label511;
        }
        paramResData = "";
        localStringBuilder.append(paramResData);
        paramResData = new URL("themediydownloader", (String)localObject2, localStringBuilder.toString());
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        if (paramInt3 == 100) {
          ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = Integer.valueOf(paramInt3);
        }
        ((URLDrawable.URLDrawableOptions)localObject2).mUseApngImage = paramBoolean;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramInt1;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramInt2;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mUseSharpPImage = ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).isFunctionAvaliable(paramContext);
        return URLDrawable.getDrawable(paramResData, (URLDrawable.URLDrawableOptions)localObject2);
      }
      catch (MalformedURLException paramContext)
      {
        paramResData = new StringBuilder();
        paramResData.append("getDIYDrawable err:");
        paramResData.append(paramContext.getMessage());
        QLog.e("DIYThemeUtils", 1, paramResData.toString());
        return localObject1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getDIYDrawable null err:");
      ((StringBuilder)localObject1).append(paramResData);
      ((StringBuilder)localObject1).append(", ctx:");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(", pageIndex=");
      ((StringBuilder)localObject1).append(paramInt3);
      QLog.e("DIYThemeUtils", 1, ((StringBuilder)localObject1).toString());
      return null;
      label511:
      paramResData = "?play=false";
    }
  }
  
  public static ResData a(AppRuntime paramAppRuntime, ResSuitData paramResSuitData, int paramInt, String paramString)
  {
    ResData localResData = new ResData();
    localResData.g = paramInt;
    localResData.b = paramResSuitData.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(paramResSuitData.f);
    localStringBuilder.append("/");
    localStringBuilder.append(paramResSuitData.g);
    localStringBuilder.append("/");
    localStringBuilder.append(localResData.b);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    localResData.e = localStringBuilder.toString();
    localResData.a = paramString;
    if (paramInt != 110)
    {
      if ((paramInt != 120) && (paramInt != 121))
      {
        if (paramInt != 201)
        {
          if (paramInt != 202)
          {
            switch (paramInt)
            {
            default: 
              return localResData;
            case 117: 
              paramAppRuntime = new StringBuilder();
              paramAppRuntime.append(AppConstants.PATH_SYSTEM_BACKGROUND_THUMBNAIL);
              paramAppRuntime.append(localResData.b);
              paramAppRuntime.append("/");
              paramAppRuntime.append(localResData.e.hashCode());
              localResData.d = paramAppRuntime.toString();
              return localResData;
            case 116: 
              paramAppRuntime = new StringBuilder();
              paramAppRuntime.append(AppConstants.PATH_SYSTEM_BACKGROUND_RESOURCE);
              paramAppRuntime.append("deal/");
              paramAppRuntime.append(paramResSuitData.b);
              localResData.d = paramAppRuntime.toString();
              return localResData;
            }
            localResData.d = ChatBackgroundUtil.a(true, paramResSuitData.b);
            return localResData;
          }
          paramAppRuntime = new StringBuilder();
          paramAppRuntime.append(ThemeDiyStyleLogic.a());
          paramAppRuntime.append("styleThum/");
          paramAppRuntime.append(paramString);
          localResData.d = paramAppRuntime.toString();
          return localResData;
        }
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append(ThemeDiyStyleLogic.a());
        paramAppRuntime.append("styleShot/");
        paramAppRuntime.append(paramString);
        localResData.d = paramAppRuntime.toString();
        return localResData;
      }
      if (paramAppRuntime == null) {
        paramAppRuntime = "0";
      } else {
        paramAppRuntime = paramAppRuntime.getAccount();
      }
      paramResSuitData = new StringBuilder();
      paramResSuitData.append(ThemeDiyStyleLogic.b());
      paramResSuitData.append(DiySecureFileHelper.a(paramAppRuntime));
      paramResSuitData.append("/");
      if (120 != paramInt)
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("org/");
        paramAppRuntime.append(paramString);
        paramString = paramAppRuntime.toString();
      }
      paramResSuitData.append(paramString);
      localResData.d = paramResSuitData.toString();
      return localResData;
    }
    localResData.d = ChatBackgroundUtil.a(true, paramResSuitData.b);
    return localResData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.DIYThemeUtils
 * JD-Core Version:    0.7.0.1
 */