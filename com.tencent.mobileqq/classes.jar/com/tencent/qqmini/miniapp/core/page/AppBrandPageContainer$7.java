package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.miniapp.R.string;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;

class AppBrandPageContainer$7
  implements Runnable
{
  AppBrandPageContainer$7(AppBrandPageContainer paramAppBrandPageContainer, boolean paramBoolean) {}
  
  public void run()
  {
    DialogUtil.createCustomDialog(AppBrandPageContainer.access$200(this.this$0).getAttachedActivity(), 230, "重启后生效", null, R.string.mini_sdk_cancel, R.string.mini_sdk_ok, new AppBrandPageContainer.7.1(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.7
 * JD-Core Version:    0.7.0.1
 */