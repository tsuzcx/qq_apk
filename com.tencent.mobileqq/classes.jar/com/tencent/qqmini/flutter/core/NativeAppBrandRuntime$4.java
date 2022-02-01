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
      if (!paramObject.containsKey("messageType")) {
        break label123;
      }
      if ("__tissue_bridge_ready_".equals((String)paramObject.get("messageType")))
      {
        QMLog.w("miniapp-start-TISSUE", " tissue initialization done, runtime:" + this.this$0.hashCode());
        if (this.this$0.getMiniAppInfo() != null) {
          break label112;
        }
        paramObject = MiniProgramReportHelper.miniAppConfigForPreload();
        MiniAppReportManager2.reportLaunchPiecewise(214, "", paramObject);
        if (this.val$initCallback != null) {
          this.val$initCallback.onChannelInited();
        }
      }
    }
    label112:
    label123:
    Object localObject;
    do
    {
      do
      {
        return;
        paramObject = this.this$0.getMiniAppInfo();
        break;
      } while (!paramObject.containsKey("method"));
      localObject = paramObject.get("method").toString();
      localObject = (NativeAppBrandRuntime.TissueEventHandler)this.this$0.handlers.get(localObject);
    } while (localObject == null);
    ((NativeAppBrandRuntime.TissueEventHandler)localObject).on(paramObject, paramReply);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeAppBrandRuntime.4
 * JD-Core Version:    0.7.0.1
 */