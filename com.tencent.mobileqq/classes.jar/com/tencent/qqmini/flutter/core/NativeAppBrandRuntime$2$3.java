package com.tencent.qqmini.flutter.core;

import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.util.Map;

class NativeAppBrandRuntime$2$3
  implements NativeAppBrandRuntime.TissueEventHandler
{
  NativeAppBrandRuntime$2$3(NativeAppBrandRuntime.2 param2) {}
  
  public void on(Map paramMap, BasicMessageChannel.Reply paramReply)
  {
    paramMap = (Map)paramMap.get("data");
    if (paramMap != null)
    {
      Integer localInteger3 = (Integer)paramMap.get("matchTimeCost");
      Integer localInteger2 = (Integer)paramMap.get("setDataTimeCost");
      Integer localInteger1 = (Integer)paramMap.get("renderTimeCost");
      paramReply = (Integer)paramMap.get("totalTimeCost");
      if (localInteger3 != null)
      {
        if (this.this$1.this$0.getMiniAppInfo() != null) {
          break label211;
        }
        paramMap = MiniProgramReportHelper.miniAppConfigForPreload();
        MiniReportManager.reportEventType(paramMap, 217, "0", localInteger3.intValue());
      }
      if (localInteger2 != null)
      {
        if (this.this$1.this$0.getMiniAppInfo() != null) {
          break label225;
        }
        paramMap = MiniProgramReportHelper.miniAppConfigForPreload();
        label125:
        MiniReportManager.reportEventType(paramMap, 218, "0", localInteger2.intValue());
      }
      if (localInteger1 != null)
      {
        if (this.this$1.this$0.getMiniAppInfo() != null) {
          break label239;
        }
        paramMap = MiniProgramReportHelper.miniAppConfigForPreload();
        label161:
        MiniReportManager.reportEventType(paramMap, 219, "0", localInteger1.intValue());
      }
      if (paramReply != null) {
        if (this.this$1.this$0.getMiniAppInfo() != null) {
          break label253;
        }
      }
    }
    label211:
    label225:
    label239:
    label253:
    for (paramMap = MiniProgramReportHelper.miniAppConfigForPreload();; paramMap = this.this$1.this$0.getMiniAppInfo())
    {
      MiniReportManager.reportEventType(paramMap, 220, "0", paramReply.intValue());
      return;
      paramMap = this.this$1.this$0.getMiniAppInfo();
      break;
      paramMap = this.this$1.this$0.getMiniAppInfo();
      break label125;
      paramMap = this.this$1.this$0.getMiniAppInfo();
      break label161;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeAppBrandRuntime.2.3
 * JD-Core Version:    0.7.0.1
 */