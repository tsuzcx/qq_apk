package com.tencent.qqmini.minigame;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.net.URLDecoder;

class GamePage$1
  implements Runnable
{
  GamePage$1(GamePage paramGamePage, MiniAppInfo paramMiniAppInfo, Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = URLDecoder.decode(this.val$miniInfo.iconUrl);
      localObject1 = ImageUtil.drawableToBitmap(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getDrawable(this.val$activity, (String)localObject1, 0, 0, null));
      if (localObject1 != null)
      {
        int i = (int)(((Bitmap)localObject1).getWidth() / 4.0F);
        Object localObject2 = RoundedBitmapDrawableFactory.create(GamePage.access$000(this.this$0).getResources(), (Bitmap)localObject1);
        ((RoundedBitmapDrawable)localObject2).setCornerRadius(i);
        ((RoundedBitmapDrawable)localObject2).setAntiAlias(true);
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject2 = new ActivityManager.TaskDescription(this.val$miniInfo.name, ImageUtil.drawableToBitmap((Drawable)localObject2));
          GamePage.access$000(this.this$0).setTaskDescription((ActivityManager.TaskDescription)localObject2);
        }
        if (!((Bitmap)localObject1).isRecycled()) {
          ((Bitmap)localObject1).recycle();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("GamePage", "changeWindowInfo exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GamePage.1
 * JD-Core Version:    0.7.0.1
 */