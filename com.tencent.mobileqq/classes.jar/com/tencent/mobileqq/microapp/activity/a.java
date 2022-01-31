package com.tencent.mobileqq.microapp.activity;

import Wallet.ApkgConfig;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import azue;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.microapp.R.drawable;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import java.net.URLDecoder;

final class a
  implements Runnable
{
  a(LoadingFragment paramLoadingFragment) {}
  
  public void run()
  {
    int i = DisplayUtil.dip2px(BaseApplicationImpl.getContext(), 100.0F);
    Object localObject1 = this.a.getResources().getDrawable(R.drawable.s);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i;
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
    try
    {
      localObject1 = URLDrawable.getDrawable(URLDecoder.decode(LoadingFragment.access$000(this.a).config.icon_url), (URLDrawable.URLDrawableOptions)localObject2);
      ((URLDrawable)localObject1).setTag(azue.a(i, i));
      ((URLDrawable)localObject1).setDecodeHandler(azue.a);
      localObject2 = Message.obtain();
      ((Message)localObject2).what = 7;
      ((Message)localObject2).obj = localObject1;
      this.a.uiHandler.sendMessage((Message)localObject2);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.activity.a
 * JD-Core Version:    0.7.0.1
 */