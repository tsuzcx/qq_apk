package com.tencent.mobileqq.mini.appbrand.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import bcyz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;

class AppLoadingUI$1
  implements Runnable
{
  AppLoadingUI$1(AppLoadingUI paramAppLoadingUI) {}
  
  public void run()
  {
    try
    {
      int i = DisplayUtil.dip2px(BaseApplicationImpl.getContext(), 60.0F);
      Object localObject1 = this.this$0.getActivity().getResources().getDrawable(2130840898);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
      localObject1 = URLDrawable.getDrawable(URLDecoder.decode(AppLoadingUI.access$000(this.this$0).config.iconUrl), (URLDrawable.URLDrawableOptions)localObject2);
      ((URLDrawable)localObject1).setTag(bcyz.b(i, i, 40));
      ((URLDrawable)localObject1).setDecodeHandler(bcyz.i);
      localObject2 = Message.obtain();
      ((Message)localObject2).what = 7;
      ((Message)localObject2).obj = localObject1;
      this.this$0.uiHandler.sendMessage((Message)localObject2);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-start", 1, "exception: ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppLoadingUI.1
 * JD-Core Version:    0.7.0.1
 */