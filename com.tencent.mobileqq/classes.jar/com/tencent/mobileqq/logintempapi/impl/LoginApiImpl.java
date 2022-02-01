package com.tencent.mobileqq.logintempapi.impl;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.logintempapi.ILoginApi;
import com.tencent.mobileqq.vas.VasApngIPCModule;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import mqq.app.AppRuntime;

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
  
  public Object getFaceBitmap(AppRuntime paramAppRuntime, String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramAppRuntime = getAppInterface(paramAppRuntime);
    if (paramAppRuntime == null)
    {
      QLog.e("LoginApiImpl", 1, "removeHandler error, app is null");
      paramAppRuntime = null;
    }
    Bitmap localBitmap;
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              return paramAppRuntime;
              localBitmap = paramAppRuntime.getFaceBitmap(paramString, paramByte, paramBoolean1);
              QLog.d("Q.qqhead.freq", 1, "LoginView getHead bitmap: " + localBitmap);
              paramAppRuntime = localBitmap;
            } while (!paramBoolean2);
            paramAppRuntime = localBitmap;
          } while (localBitmap == null);
          paramAppRuntime = localBitmap;
        } while (!VasApngIPCModule.a().b());
        i = BaseApplication.getContext().getSharedPreferences(paramString, 0).getInt("my_store_face_id", 0);
        paramAppRuntime = localBitmap;
      } while (i <= 0);
      paramString = VasFaceManager.a(i, "small");
      paramAppRuntime = localBitmap;
    } while (!new File(paramString).exists());
    paramAppRuntime = new BitmapDrawable(localBitmap);
    try
    {
      URL localURL = new URL("vasapngdownloader", paramString, "-login-face-");
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseApngImage = true;
      localURLDrawableOptions.mUseMemoryCache = true;
      localURLDrawableOptions.mFailedDrawable = paramAppRuntime;
      localURLDrawableOptions.mLoadingDrawable = paramAppRuntime;
      localURLDrawableOptions.mExtraInfo = VasFaceManager.a();
      paramAppRuntime = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      return paramAppRuntime;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("LoginApiImpl", 1, "getApngDrawable ApngImage err, path:" + paramString, paramAppRuntime);
    }
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.logintempapi.impl.LoginApiImpl
 * JD-Core Version:    0.7.0.1
 */