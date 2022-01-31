package com.tencent.open.wadl;

import ajyc;
import android.app.Activity;
import android.content.Context;
import bbcv;
import bbgg;
import bdiy;
import bdok;
import bdol;
import bdom;
import com.tencent.smtt.sdk.WebView;
import cooperation.wadl.ipc.WadlParams;

public class WadlJsBridgeCallBack$2
  implements Runnable
{
  public WadlJsBridgeCallBack$2(bdok parambdok, WadlParams paramWadlParams) {}
  
  public void run()
  {
    if (bdok.a(this.this$0) != null) {}
    for (Object localObject = bdok.a(this.this$0).getWebview();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((WebView)localObject).getContext();
        if (((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
          break;
        }
      }
      return;
    }
    bbcv.a((Context)localObject, 230, null, "主人的手机空间不足咯，继续下载可能导致本次下载出现异常哦~\n建议主人手动清理手机空间，帮助本次下载顺利完成。", ajyc.a(2131716869), ajyc.a(2131716868), new bdol(this), new bdom(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeCallBack.2
 * JD-Core Version:    0.7.0.1
 */