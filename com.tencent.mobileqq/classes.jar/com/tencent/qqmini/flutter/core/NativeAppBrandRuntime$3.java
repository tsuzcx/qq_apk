package com.tencent.qqmini.flutter.core;

import com.tencent.qqmini.flutter.core.task.IChannelInitCallback;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.miniapp.util.URL;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class NativeAppBrandRuntime$3
  implements BasicMessageChannel.MessageHandler
{
  NativeAppBrandRuntime$3(NativeAppBrandRuntime paramNativeAppBrandRuntime, IChannelInitCallback paramIChannelInitCallback) {}
  
  public void onMessage(Object paramObject, BasicMessageChannel.Reply paramReply)
  {
    Object localObject1 = null;
    Object localObject2;
    if ((paramObject instanceof Map))
    {
      localObject2 = (Map)paramObject;
      if ((((Map)localObject2).containsKey("messageType")) && ("__tissue_bridge_ready_".equals((String)((Map)localObject2).get("messageType"))))
      {
        QMLog.w("miniapp-start-TISSUE", " tissue initialization done, runtime:" + this.this$0.hashCode());
        if (this.this$0.getMiniAppInfo() != null) {
          break label297;
        }
      }
    }
    Object localObject3;
    label297:
    for (paramObject = MiniProgramReportHelper.miniAppConfigForPreload();; paramObject = this.this$0.getMiniAppInfo())
    {
      MiniAppReportManager2.reportLaunchPiecewise(214, "", paramObject);
      if (this.val$initCallback != null) {
        this.val$initCallback.onChannelInited();
      }
      if (((Map)localObject2).containsKey("method"))
      {
        paramObject = ((Map)localObject2).get("method").toString();
        if (!paramObject.equals("publishHandler")) {
          break;
        }
        paramReply = (Map)((Map)localObject2).get("data");
        localObject3 = paramReply.get("event").toString();
        localObject2 = (Integer)paramReply.get("pageID");
        paramObject = localObject1;
        if (paramReply.containsKey("dataForEvent")) {
          paramObject = (Map)paramReply.get("dataForEvent");
        }
        paramReply = (BasicMessageChannel.Reply)localObject2;
        if (localObject2 == null)
        {
          paramReply = (BasicMessageChannel.Reply)localObject2;
          if (paramObject != null)
          {
            paramReply = (BasicMessageChannel.Reply)localObject2;
            if (paramObject.containsKey("pageID")) {
              paramReply = (Integer)paramObject.get("pageID");
            }
          }
        }
        localObject1 = "null";
        if (paramObject != null) {
          localObject1 = new JSONObject(paramObject).toString();
        }
        NativeAppBrandRuntime.access$100(this.this$0).onWebViewEvent((String)localObject3, (String)localObject1, paramReply.intValue());
      }
      return;
    }
    if (paramObject.equals("onAppRoute"))
    {
      paramObject = (Map)((Map)localObject2).get("data");
      localObject2 = paramObject.get("path").toString();
      paramReply = (Integer)paramObject.get("pageID");
      localObject1 = (String)paramObject.get("openType");
      if (!paramObject.containsKey("query")) {
        break label1338;
      }
    }
    label1080:
    label1338:
    for (paramObject = (Map)paramObject.get("query");; paramObject = null)
    {
      paramObject = new URL((String)localObject2, paramObject);
      NativeAppBrandRuntime.access$200(this.this$0).onAppRoute((String)localObject1, paramObject.getFullUrl(), paramReply.intValue());
      return;
      if (paramObject.equals("onAppRouteDone"))
      {
        paramObject = (Map)((Map)localObject2).get("data");
        localObject2 = paramObject.get("path").toString();
        paramReply = (Integer)paramObject.get("pageID");
        localObject1 = (String)paramObject.get("openType");
        if (!paramObject.containsKey("query")) {
          break label1333;
        }
      }
      for (paramObject = (Map)paramObject.get("query");; paramObject = null)
      {
        paramObject = new URL((String)localObject2, paramObject);
        NativeAppBrandRuntime.access$300(this.this$0).onAppRouteDone((String)localObject1, paramObject.getFullUrl(), paramReply.intValue());
        return;
        if ("viewDidAppear".equals(paramObject))
        {
          this.this$0.performAction(AppStateEvent.obtain(11));
          if ((!((Map)localObject2).containsKey("data")) || (!(((Map)localObject2).get("data") instanceof Map))) {
            break label1325;
          }
          paramObject = (Map)((Map)localObject2).get("data");
          if ((!paramObject.containsKey("pageID")) || (!(paramObject.get("pageID") instanceof Integer))) {
            break label1325;
          }
        }
        for (paramObject = (Integer)paramObject.get("pageID");; paramObject = Integer.valueOf(0))
        {
          QMLog.w("miniapp-start-TISSUE", "flutter page " + paramObject + " shown" + System.currentTimeMillis() + "runtime: " + this.this$0.hashCode());
          if (NativeAppBrandRuntime.access$400(this.this$0)) {
            break;
          }
          if (this.this$0.getMiniAppInfo() == null) {}
          for (paramObject = MiniProgramReportHelper.miniAppConfigForPreload();; paramObject = this.this$0.getMiniAppInfo())
          {
            MiniAppReportManager2.reportLaunchPiecewise(216, "", paramObject);
            NativeAppBrandRuntime.access$402(this.this$0, true);
            return;
          }
          if ("invokeHandler".equals(paramObject))
          {
            paramReply = (Map)((Map)localObject2).get("data");
            paramObject = (String)paramReply.get("event");
            if ("invokeMiniProgramAPI".equals(paramObject))
            {
              int i = ((Integer)paramReply.get("pageID")).intValue();
              NativeAppBrandRuntime.access$500(this.this$0).onWebViewEvent("onWebInvokeAppService", (String)paramReply.get("param"), i);
            }
            paramReply = new JSONObject(paramReply).toString();
            NativeAppBrandRuntime.access$600(this.this$0).onWebViewNativeRequest(paramObject, paramReply, this.this$0.getJsService(), 0);
            return;
          }
          if ("timeCostReport".equals(paramObject))
          {
            paramObject = (Map)((Map)localObject2).get("data");
            if (paramObject == null) {
              break;
            }
            localObject3 = (Integer)paramObject.get("matchTimeCost");
            localObject2 = (Integer)paramObject.get("setDataTimeCost");
            localObject1 = (Integer)paramObject.get("renderTimeCost");
            paramReply = (Integer)paramObject.get("totalTimeCost");
            if (localObject3 != null)
            {
              if (this.this$0.getMiniAppInfo() == null)
              {
                paramObject = MiniProgramReportHelper.miniAppConfigForPreload();
                MiniReportManager.reportEventType(paramObject, 217, "0", ((Integer)localObject3).intValue());
              }
            }
            else
            {
              if (localObject2 != null)
              {
                if (this.this$0.getMiniAppInfo() != null) {
                  break label1080;
                }
                paramObject = MiniProgramReportHelper.miniAppConfigForPreload();
                label987:
                MiniReportManager.reportEventType(paramObject, 218, "0", ((Integer)localObject2).intValue());
              }
              if (localObject1 != null)
              {
                if (this.this$0.getMiniAppInfo() != null) {
                  break label1091;
                }
                paramObject = MiniProgramReportHelper.miniAppConfigForPreload();
                label1021:
                MiniReportManager.reportEventType(paramObject, 219, "0", ((Integer)localObject1).intValue());
              }
              if (paramReply == null) {
                break;
              }
              if (this.this$0.getMiniAppInfo() != null) {
                break label1102;
              }
            }
            label1091:
            label1102:
            for (paramObject = MiniProgramReportHelper.miniAppConfigForPreload();; paramObject = this.this$0.getMiniAppInfo())
            {
              MiniReportManager.reportEventType(paramObject, 220, "0", paramReply.intValue());
              return;
              paramObject = this.this$0.getMiniAppInfo();
              break;
              paramObject = this.this$0.getMiniAppInfo();
              break label987;
              paramObject = this.this$0.getMiniAppInfo();
              break label1021;
            }
          }
          if ("getAbsolutePath".equals(paramObject))
          {
            paramObject = (String)((Map)((Map)localObject2).get("data")).get("filePath");
            paramReply.reply(((MiniAppFileManager)this.this$0.getManager(MiniAppFileManager.class)).getAbsolutePath(paramObject));
            return;
          }
          if (!"getWebConfiguration".equals(paramObject)) {
            break;
          }
          localObject1 = QUAUtil.getWebViewUA() + " tissue";
          paramObject = "";
          localObject2 = new HashMap();
          localObject3 = this.this$0.getBaselibContent();
          if (localObject3 != null) {
            paramObject = ((BaselibLoader.BaselibContent)localObject3).miniappWebviewStr;
          }
          ((Map)localObject2).put("customUserAgent", localObject1);
          QMLog.w("miniapp-start-TISSUE", "systemUA" + (String)localObject1);
          QMLog.w("miniapp-start-TISSUE", " miniapp launch" + NativeAppBrandRuntime.access$700(this.this$0).appId);
          paramReply.reply(new NativeAppBrandRuntime.3.1(this, (String)localObject1, paramObject));
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeAppBrandRuntime.3
 * JD-Core Version:    0.7.0.1
 */