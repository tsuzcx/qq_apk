package com.tencent.mobileqq.vaswebviewplugin;

import aljq;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import bcyw;
import becq;
import bhpy;
import bhqd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import java.io.File;
import lmm;

class AvatarPendantJsPlugin$5
  implements bhqd
{
  AvatarPendantJsPlugin$5(AvatarPendantJsPlugin paramAvatarPendantJsPlugin, String paramString, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.val$sheet.dismiss();
        return;
      }
      catch (Exception paramView) {}
      if (!lmm.b(BaseApplicationImpl.getContext()))
      {
        paramView = new File(aljq.aX + "photo/");
        if (!paramView.exists()) {
          paramView.mkdirs();
        }
        paramView = new Intent();
        Uri localUri = FileProvider7Helper.setSystemCapture(this.this$0.mRuntime.a(), new File(aljq.aX + "photo/" + System.currentTimeMillis() + ".jpg"), paramView);
        this.this$0.mRuntime.a().startActivityForResult(paramView, 1);
        AvatarPendantUiPlugin.sJsHandler = this.this$0;
        AvatarPendantUiPlugin.sCallbackId = this.val$callbackId;
        AvatarPendantUiPlugin.sUploadPhotoUri = localUri;
        continue;
        paramView = new Intent();
        paramView.putExtra("keyFromPendantPhoto", true);
        paramView.putExtra("Business_Origin", 100);
        paramInt = Math.min(482, bcyw.a(this.this$0.mRuntime.a()));
        PhotoUtils.a(paramView, this.this$0.mRuntime.a(), QQBrowserActivity.class.getName(), paramInt, paramInt, 1080, 1080, bcyw.a());
        AvatarPendantUiPlugin.sJsHandler = this.this$0;
        AvatarPendantUiPlugin.sCallbackId = this.val$callbackId;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */