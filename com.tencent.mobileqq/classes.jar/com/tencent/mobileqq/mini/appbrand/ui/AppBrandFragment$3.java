package com.tencent.mobileqq.mini.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import bdda;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;

class AppBrandFragment$3
  implements Runnable
{
  AppBrandFragment$3(AppBrandFragment paramAppBrandFragment, MiniAppConfig paramMiniAppConfig, Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap = ImageUtil.drawableToBitmap(URLDrawable.getDrawable(URLDecoder.decode(this.val$miniConfig.config.iconUrl), null));
      if (localBitmap != null)
      {
        int i = (int)(localBitmap.getWidth() / 4.0F);
        Object localObject = RoundedBitmapDrawableFactory.create(this.val$activity.getResources(), localBitmap);
        ((RoundedBitmapDrawable)localObject).setCornerRadius(i);
        ((RoundedBitmapDrawable)localObject).setAntiAlias(true);
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject = new ActivityManager.TaskDescription(this.val$miniConfig.config.name, bdda.b((Drawable)localObject));
          this.val$activity.setTaskDescription((ActivityManager.TaskDescription)localObject);
        }
        if (!localBitmap.isRecycled()) {
          localBitmap.recycle();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-start", 1, "AppBrandFragment changeWindowInfo exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandFragment.3
 * JD-Core Version:    0.7.0.1
 */