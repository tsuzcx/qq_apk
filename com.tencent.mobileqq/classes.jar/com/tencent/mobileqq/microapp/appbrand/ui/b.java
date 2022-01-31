package com.tencent.mobileqq.microapp.appbrand.ui;

import Wallet.ApkgConfig;
import android.app.ActivityManager.TaskDescription;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import bdda;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.b.a;
import java.net.URLDecoder;

final class b
  implements Runnable
{
  b(AppBrandUI paramAppBrandUI, MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap = a.a(URLDrawable.getDrawable(URLDecoder.decode(this.a.config.icon_url), null));
      if (localBitmap != null)
      {
        int i = (int)(localBitmap.getWidth() / 4.0F);
        Object localObject = RoundedBitmapDrawableFactory.create(this.b.getResources(), localBitmap);
        ((RoundedBitmapDrawable)localObject).setCornerRadius(i);
        ((RoundedBitmapDrawable)localObject).setAntiAlias(true);
        localObject = new ActivityManager.TaskDescription(this.a.config.app_name, bdda.b((Drawable)localObject));
        this.b.setTaskDescription((ActivityManager.TaskDescription)localObject);
        if (!localBitmap.isRecycled()) {
          localBitmap.recycle();
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.ui.b
 * JD-Core Version:    0.7.0.1
 */