package com.tencent.mobileqq.logintempapi.impl;

import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.logintempapi.ILoginApi;
import com.tencent.mobileqq.vas.VasApngIPCModule;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.webprocess.PreloadService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.observer.WtloginObserver;

public class LoginApiImpl
  implements ILoginApi
{
  private static final String TAG = "LoginApiImpl";
  
  private QQAppInterface getAppInterface(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)paramAppRuntime;
    }
    return null;
  }
  
  public int getDevLockStatus(AppRuntime paramAppRuntime, String paramString, WtloginObserver paramWtloginObserver)
  {
    return EquipmentLockImpl.a().a(paramAppRuntime, paramString, paramWtloginObserver);
  }
  
  public Object getFaceBitmap(AppRuntime paramAppRuntime, String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramAppRuntime = getAppInterface(paramAppRuntime);
    if (paramAppRuntime == null)
    {
      QLog.e("LoginApiImpl", 1, "removeHandler error, app is null");
      return null;
    }
    paramAppRuntime = paramAppRuntime.getFaceBitmap(paramString, paramByte, paramBoolean1);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("LoginView getHead bitmap: ");
    ((StringBuilder)localObject1).append(paramAppRuntime);
    QLog.d("Q.qqhead.freq", 1, ((StringBuilder)localObject1).toString());
    if ((paramBoolean2) && (paramAppRuntime != null) && (VasApngIPCModule.a().b()))
    {
      int i = BaseApplication.getContext().getSharedPreferences(paramString, 0).getInt("my_store_face_id", 0);
      if (i > 0)
      {
        paramString = VasFaceManager.a(i, "small");
        if (new File(paramString).exists())
        {
          localObject1 = new BitmapDrawable(paramAppRuntime);
          try
          {
            localObject2 = new URL("vasapngdownloader", paramString, "-login-face-");
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mUseApngImage = true;
            localURLDrawableOptions.mUseMemoryCache = true;
            localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
            localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
            localURLDrawableOptions.mExtraInfo = VasFaceManager.a();
            localObject1 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
            return localObject1;
          }
          catch (Exception localException)
          {
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getApngDrawable ApngImage err, path:");
            ((StringBuilder)localObject2).append(paramString);
            QLog.e("LoginApiImpl", 1, ((StringBuilder)localObject2).toString(), localException);
          }
        }
      }
    }
    return paramAppRuntime;
  }
  
  public void preloadThirdService()
  {
    PreloadService.b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.logintempapi.impl.LoginApiImpl
 * JD-Core Version:    0.7.0.1
 */