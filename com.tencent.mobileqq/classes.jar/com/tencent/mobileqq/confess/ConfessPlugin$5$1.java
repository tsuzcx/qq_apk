package com.tencent.mobileqq.confess;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

class ConfessPlugin$5$1
  implements Runnable
{
  ConfessPlugin$5$1(ConfessPlugin.5 param5, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bitmap paramBitmap) {}
  
  public void run()
  {
    ConfessPlugin.b(this.g.this$0);
    Activity localActivity = this.g.this$0.mRuntime.d();
    AppInterface localAppInterface = this.g.this$0.mRuntime.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processShare activity=");
      localStringBuilder.append(localActivity);
      localStringBuilder.append("  app=");
      localStringBuilder.append(localAppInterface);
      localStringBuilder.append(" finishing?");
      boolean bool;
      if ((localActivity != null) && (localActivity.isFinishing())) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append(" share_type=");
      localStringBuilder.append(this.g.b);
      localStringBuilder.append(" share_url:");
      localStringBuilder.append(this.g.f);
      localStringBuilder.append(" new_share_url:");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" imageUrl:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" new_srcUrl:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" new_srcIconUrl:");
      localStringBuilder.append(this.d);
      QLog.d("ConfessPlugin", 2, localStringBuilder.toString());
    }
    if ((localActivity != null) && (localAppInterface != null) && (!localActivity.isFinishing()))
    {
      int i = this.g.b;
      if (i != 0)
      {
        if (i != 1)
        {
          if ((i != 2) && (i != 3)) {
            return;
          }
          if (this.g.this$0.b == null)
          {
            this.g.this$0.b = new ConfessPlugin.5.1.1(this);
            WXShareHelper.a().a(this.g.this$0.b);
          }
          if (this.g.b == 2)
          {
            WXShareHelper.a().a(this.e, this.f, 0);
            return;
          }
          WXShareHelper.a().a(this.e, this.f, 1);
          return;
        }
        ConfessPlugin.a(this.g.this$0, localAppInterface, localActivity, this.e, this.g.d, this.g.f, this.g.e);
        return;
      }
      ConfessPlugin.a(this.g.this$0, this.b, this.g.d, this.a, this.g.j, String.valueOf(this.g.k), this.c, this.d, this.g.e, this.g.l);
      return;
    }
    ConfessPlugin.a(this.g.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin.5.1
 * JD-Core Version:    0.7.0.1
 */