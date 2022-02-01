package com.tencent.mobileqq.mini.appbrand.utils;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;

final class ShareUtils$2
  implements MiniAppController.ActivityResultListener
{
  ShareUtils$2(Activity paramActivity) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    MiniAppController.getInstance().removeActivityResultListener(this);
    return ShareUtils.access$000(this.val$activity, paramInt1, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.2
 * JD-Core Version:    0.7.0.1
 */