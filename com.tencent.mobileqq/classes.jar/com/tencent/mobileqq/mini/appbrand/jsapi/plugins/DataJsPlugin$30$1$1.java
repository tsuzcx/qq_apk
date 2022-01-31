package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import alpo;
import android.app.Activity;
import android.content.res.Resources;
import bepp;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class DataJsPlugin$30$1$1
  implements URLDrawable.URLDrawableListener
{
  DataJsPlugin$30$1$1(DataJsPlugin.30.1 param1) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.e("[mini] DataJsPlugin", 1, "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("[mini] DataJsPlugin", 1, "shareNetworkPicMessage failed, because of picture downloadFailed");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getFileInLocal();
    if ((paramURLDrawable != null) && (paramURLDrawable.exists())) {}
    for (int i = 1;; i = 0)
    {
      this.this$2.val$loadingDialog.dismiss();
      if (i == 0) {
        QQToast.a(this.this$2.this$1.this$0.jsPluginEngine.appBrandRuntime.activity, 1, alpo.a(2131703116), 1).b(this.this$2.this$1.this$0.jsPluginEngine.appBrandRuntime.activity.getResources().getDimensionPixelSize(2131298914));
      }
      if (i == 0) {
        break;
      }
      DataJsPlugin.access$100(this.this$2.this$1.this$0, this.this$2.this$1.val$title, paramURLDrawable.getPath(), this.this$2.this$1.val$shareType);
      return;
    }
    QLog.e("[mini] DataJsPlugin", 1, "shareNetworkPicMessage failed, because of picture downloadFailed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.30.1.1
 * JD-Core Version:    0.7.0.1
 */