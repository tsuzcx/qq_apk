package com.tencent.mobileqq.jsp;

import android.app.Activity;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.mobileqq.forward.ForwardSdkUtil;
import com.tencent.qphone.base.util.QLog;

class WeiBoSharePlugin$1
  implements WbShareCallback
{
  WeiBoSharePlugin$1(WeiBoSharePlugin paramWeiBoSharePlugin) {}
  
  public void onCancel()
  {
    QLog.d("LoginPlugin_demo", 1, "onCancel");
    ForwardSdkUtil.a(WeiBoSharePlugin.a(this.a), "分享取消");
  }
  
  public void onComplete()
  {
    QLog.d("LoginPlugin_demo", 1, "onComplete");
    ForwardSdkUtil.a(WeiBoSharePlugin.a(this.a), "分享成功");
  }
  
  public void onError(UiError paramUiError)
  {
    QLog.d("LoginPlugin_demo", 1, new Object[] { "onError errorMessage=", paramUiError.errorMessage, ", errorCode=", Integer.valueOf(paramUiError.errorCode) });
    Activity localActivity = WeiBoSharePlugin.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("分享失败 message=");
    localStringBuilder.append(paramUiError.errorMessage);
    ForwardSdkUtil.a(localActivity, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.WeiBoSharePlugin.1
 * JD-Core Version:    0.7.0.1
 */