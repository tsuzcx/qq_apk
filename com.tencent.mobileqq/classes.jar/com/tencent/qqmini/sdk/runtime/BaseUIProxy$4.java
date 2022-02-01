package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import android.content.Context;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.widget.MiniToast;

class BaseUIProxy$4
  implements Runnable
{
  BaseUIProxy$4(BaseUIProxy paramBaseUIProxy, int paramInt, String paramString) {}
  
  public void run()
  {
    Context localContext = MiniAppEnv.g().getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("加载失败 retCode=");
    localStringBuilder.append(this.val$retCode);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.val$msg);
    MiniToast.makeText(localContext, localStringBuilder.toString(), 0).show();
    if (this.this$0.mActivity != null) {
      this.this$0.mActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.BaseUIProxy.4
 * JD-Core Version:    0.7.0.1
 */