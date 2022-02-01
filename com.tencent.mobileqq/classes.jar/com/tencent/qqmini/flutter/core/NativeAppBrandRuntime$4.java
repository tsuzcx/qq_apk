package com.tencent.qqmini.flutter.core;

import com.tencent.qqmini.flutter.core.task.IChannelInitCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.util.Map;

class NativeAppBrandRuntime$4
  implements BasicMessageChannel.MessageHandler
{
  NativeAppBrandRuntime$4(NativeAppBrandRuntime paramNativeAppBrandRuntime, IChannelInitCallback paramIChannelInitCallback) {}
  
  public void onMessage(Object paramObject, BasicMessageChannel.Reply paramReply)
  {
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if (paramObject.containsKey("messageType"))
      {
        if ("__tissue_bridge_ready_".equals((String)paramObject.get("messageType")))
        {
          paramObject = new StringBuilder();
          paramObject.append(" tissue initialization done, runtime:");
          paramObject.append(this.this$0.hashCode());
          QMLog.w("miniapp-start-TISSUE", paramObject.toString());
          if (this.this$0.getMiniAppInfo() == null) {
            paramObject = MiniProgramReportHelper.miniAppConfigForPreload();
          } else {
            paramObject = this.this$0.getMiniAppInfo();
          }
          MiniAppReportManager2.reportLaunchPiecewise(214, "", paramObject);
          paramObject = this.val$initCallback;
          if (paramObject != null) {
            paramObject.onChannelInited();
          }
        }
        return;
      }
      if (paramObject.containsKey("method"))
      {
        Object localObject = paramObject.get("method").toString();
        localObject = (NativeAppBrandRuntime.TissueEventHandler)this.this$0.handlers.get(localObject);
        if (localObject != null) {
          ((NativeAppBrandRuntime.TissueEventHandler)localObject).on(paramObject, paramReply);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeAppBrandRuntime.4
 * JD-Core Version:    0.7.0.1
 */