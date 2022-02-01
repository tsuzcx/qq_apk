package com.tencent.mobileqq.webview.swift.component;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.ar.utils.QRScanUtil;
import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import com.tencent.mobileqq.util.ScreenShotUtil;
import com.tencent.mobileqq.util.ScreenShotUtil.ScreenLongShotCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class SwiftBrowserShareMenuHandler$3
  implements ScreenShotUtil.ScreenLongShotCallback<String>
{
  SwiftBrowserShareMenuHandler$3(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler) {}
  
  public String a(Bitmap paramBitmap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ScreenShotUtil.a());
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".jpg");
    localObject = ((StringBuilder)localObject).toString();
    QRScanUtil.a(paramBitmap, (String)localObject, Bitmap.CompressFormat.JPEG, 100, true);
    return localObject;
  }
  
  public void a(Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onScreenShotError , error is ");
    localStringBuilder.append(paramException.getMessage());
    QLog.e("SwiftBrowserShareMenuHandler", 1, localStringBuilder.toString());
    if (this.a.a.a() == null)
    {
      QLog.e("SwiftBrowserShareMenuHandler", 1, "screen long shot onScreenShotError, activity is null");
      return;
    }
    QQToast.a(this.a.a.a(), 2131718549, 0).a();
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.a.a.a() == null)
    {
      QLog.e("SwiftBrowserShareMenuHandler", 1, "screen long shot error, activity is null");
      return;
    }
    paramBitmap = new Intent();
    paramBitmap.putExtra("public_fragment_window_feature", 1);
    paramBitmap.putExtra("screen_path", paramString);
    paramBitmap.putExtra("is_web_screen_long_shot", true);
    PublicFragmentActivity.Launcher.a(this.a.a.a(), paramBitmap, PublicTransFragmentActivity.class, ScreenShotFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.3
 * JD-Core Version:    0.7.0.1
 */