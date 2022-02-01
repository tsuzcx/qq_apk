package com.tencent.qqmini.flutter.core;

import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.util.HashMap;
import java.util.Map;

class NativeAppBrandRuntime$2$2
  implements NativeAppBrandRuntime.TissueEventHandler
{
  NativeAppBrandRuntime$2$2(NativeAppBrandRuntime.2 param2) {}
  
  public void on(Map paramMap, BasicMessageChannel.Reply paramReply)
  {
    paramMap = new StringBuilder();
    paramMap.append(QUAUtil.getWebViewUA());
    paramMap.append(" tissue");
    String str = paramMap.toString();
    Object localObject = new HashMap();
    paramMap = this.this$1.this$0.getBaselibContent();
    if (paramMap != null) {
      paramMap = paramMap.miniappWebviewStr;
    } else {
      paramMap = "";
    }
    ((Map)localObject).put("customUserAgent", str);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("systemUA");
    ((StringBuilder)localObject).append(str);
    QMLog.w("miniapp-start-TISSUE", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" miniapp launch");
    ((StringBuilder)localObject).append(NativeAppBrandRuntime.access$100(this.this$1.this$0).appId);
    QMLog.w("miniapp-start-TISSUE", ((StringBuilder)localObject).toString());
    paramReply.reply(new NativeAppBrandRuntime.2.2.1(this, str, paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeAppBrandRuntime.2.2
 * JD-Core Version:    0.7.0.1
 */