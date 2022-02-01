package com.tencent.open.wadl;

import android.app.Activity;
import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.util.WLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.business.base.IJsCallBack;
import com.tencent.smtt.sdk.WebView;

class WadlJsBridgeCallBack$2
  implements Runnable
{
  WadlJsBridgeCallBack$2(WadlJsBridgeCallBack paramWadlJsBridgeCallBack, WadlParams paramWadlParams) {}
  
  public void run()
  {
    Object localObject = null;
    if (WadlJsBridgeCallBack.a(this.this$0) != null) {
      localObject = WadlJsBridgeCallBack.a(this.this$0).getWebview();
    }
    if (localObject != null)
    {
      localObject = ((WebView)localObject).getContext();
      if (((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {}
    }
    else
    {
      return;
    }
    try
    {
      DialogUtil.a((Context)localObject, 230, null, "主人的手机空间不足咯，继续下载可能导致本次下载出现异常哦~\n建议主人手动清理手机空间，帮助本次下载顺利完成。", HardCodeUtil.a(2131716698), HardCodeUtil.a(2131716697), new WadlJsBridgeCallBack.2.1(this), new WadlJsBridgeCallBack.2.2(this)).show();
      return;
    }
    catch (Exception localException)
    {
      WLog.a(WadlJsBridgeCallBack.a, "showDialog exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeCallBack.2
 * JD-Core Version:    0.7.0.1
 */