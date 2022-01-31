package com.tencent.qqmini.sdk.minigame;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import bekr;
import besl;
import beug;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.net.URLDecoder;

public class GamePage$1
  implements Runnable
{
  public GamePage$1(beug parambeug, MiniAppInfo paramMiniAppInfo, Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = URLDecoder.decode(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.iconUrl);
      localObject1 = bekr.a(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getDrawable(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, 0, 0, null));
      if (localObject1 != null)
      {
        int i = (int)(((Bitmap)localObject1).getWidth() / 4.0F);
        Object localObject2 = RoundedBitmapDrawableFactory.create(beug.a(this.this$0).getResources(), (Bitmap)localObject1);
        ((RoundedBitmapDrawable)localObject2).setCornerRadius(i);
        ((RoundedBitmapDrawable)localObject2).setAntiAlias(true);
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject2 = new ActivityManager.TaskDescription(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name, bekr.a((Drawable)localObject2));
          beug.a(this.this$0).setTaskDescription((ActivityManager.TaskDescription)localObject2);
        }
        if (!((Bitmap)localObject1).isRecycled()) {
          ((Bitmap)localObject1).recycle();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      besl.d("GamePage", "changeWindowInfo exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GamePage.1
 * JD-Core Version:    0.7.0.1
 */