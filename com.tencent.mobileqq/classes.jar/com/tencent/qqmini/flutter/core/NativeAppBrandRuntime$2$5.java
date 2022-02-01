package com.tencent.qqmini.flutter.core;

import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.util.Map;

class NativeAppBrandRuntime$2$5
  implements NativeAppBrandRuntime.TissueEventHandler
{
  NativeAppBrandRuntime$2$5(NativeAppBrandRuntime.2 param2) {}
  
  public void on(Map paramMap, BasicMessageChannel.Reply paramReply)
  {
    this.this$1.this$0.performAction(AppStateEvent.obtain(11));
    if ((paramMap.containsKey("data")) && ((paramMap.get("data") instanceof Map)))
    {
      paramMap = (Map)paramMap.get("data");
      if ((!paramMap.containsKey("pageID")) || (!(paramMap.get("pageID") instanceof Integer))) {}
    }
    for (paramMap = (Integer)paramMap.get("pageID");; paramMap = Integer.valueOf(0))
    {
      QMLog.w("miniapp-start-TISSUE", "flutter page " + paramMap + " shown" + System.currentTimeMillis() + "runtime: " + this.this$1.this$0.hashCode());
      if (!NativeAppBrandRuntime.access$400(this.this$1.this$0)) {
        if (this.this$1.this$0.getMiniAppInfo() != null) {
          break label195;
        }
      }
      label195:
      for (paramMap = MiniProgramReportHelper.miniAppConfigForPreload();; paramMap = this.this$1.this$0.getMiniAppInfo())
      {
        MiniAppReportManager2.reportLaunchPiecewise(216, "", paramMap);
        NativeAppBrandRuntime.access$402(this.this$1.this$0, true);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeAppBrandRuntime.2.5
 * JD-Core Version:    0.7.0.1
 */