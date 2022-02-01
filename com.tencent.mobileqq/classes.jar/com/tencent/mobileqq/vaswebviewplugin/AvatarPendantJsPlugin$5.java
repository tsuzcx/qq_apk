package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.File;

class AvatarPendantJsPlugin$5
  implements ActionSheet.OnButtonClickListener
{
  AvatarPendantJsPlugin$5(AvatarPendantJsPlugin paramAvatarPendantJsPlugin, String paramString, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        paramView = new Intent();
        paramView.putExtra("keyFromPendantPhoto", true);
        paramView.putExtra("Business_Origin", 100);
        paramInt = Math.min(482, ProfileCardUtil.a(this.this$0.mRuntime.d()));
        PhotoUtils.startPhotoListEdit(paramView, this.this$0.mRuntime.d(), QQBrowserActivity.class.getName(), paramInt, paramInt, 1080, 1080, FaceUtil.a());
        AvatarPendantUiPlugin.sJsHandler = this.this$0;
        AvatarPendantUiPlugin.sCallbackId = this.val$callbackId;
      }
    }
    else
    {
      if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
        return;
      }
      paramView = new StringBuilder();
      paramView.append(AppConstants.SDCARD_PATH);
      paramView.append("photo/");
      paramView = new File(paramView.toString());
      if (!paramView.exists()) {
        paramView.mkdirs();
      }
      paramView = new Intent();
      Object localObject = this.this$0.mRuntime.d();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_PATH);
      localStringBuilder.append("photo/");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(".jpg");
      localObject = FileProvider7Helper.setSystemCapture((Context)localObject, new File(localStringBuilder.toString()), paramView);
      this.this$0.mRuntime.d().startActivityForResult(paramView, 1);
      AvatarPendantUiPlugin.sJsHandler = this.this$0;
      AvatarPendantUiPlugin.sCallbackId = this.val$callbackId;
      AvatarPendantUiPlugin.sUploadPhotoUri = (Uri)localObject;
    }
    try
    {
      this.val$sheet.dismiss();
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */