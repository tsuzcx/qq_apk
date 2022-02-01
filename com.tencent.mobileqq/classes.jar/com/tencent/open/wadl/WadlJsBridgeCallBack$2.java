package com.tencent.open.wadl;

import android.app.Activity;
import android.content.Context;
import anni;
import bglp;
import bgpa;
import biud;
import bize;
import bizk;
import bizl;
import bizm;
import com.tencent.smtt.sdk.WebView;
import cooperation.wadl.ipc.WadlParams;

public class WadlJsBridgeCallBack$2
  implements Runnable
{
  public WadlJsBridgeCallBack$2(bizk parambizk, WadlParams paramWadlParams) {}
  
  public void run()
  {
    Object localObject = null;
    if (bizk.a(this.this$0) != null) {
      localObject = bizk.a(this.this$0).getWebview();
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
      bglp.a((Context)localObject, 230, null, "主人的手机空间不足咯，继续下载可能导致本次下载出现异常哦~\n建议主人手动清理手机空间，帮助本次下载顺利完成。", anni.a(2131715541), anni.a(2131715540), new bizl(this), new bizm(this)).show();
      return;
    }
    catch (Exception localException)
    {
      bize.a(bizk.a, "showDialog exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeCallBack.2
 * JD-Core Version:    0.7.0.1
 */