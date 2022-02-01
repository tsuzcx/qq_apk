package com.tencent.mobileqq.forward;

import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class ForwardPluginShareWebViewHelper$1$1
  implements Runnable
{
  ForwardPluginShareWebViewHelper$1$1(ForwardPluginShareWebViewHelper.1 param1, String paramString) {}
  
  public void run()
  {
    if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) != 0) {
      QQToast.makeText(this.this$0.c.getApp(), 2, this.a, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareWebViewHelper.1.1
 * JD-Core Version:    0.7.0.1
 */