package com.tencent.qqmini.nativePlugins;

import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.treasurecard.VasFtCard;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class TreasureCardMiniJsPlugin
  extends BaseJsPlugin
{
  @JsEvent({"freeTrafficCardModel"})
  public void freeTrafficCardModel(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optJSONObject("data").optString("from", "MiniApp");
      IVasFTManager localIVasFTManager = VasUtil.a().getVasFtManager();
      JSONObject localJSONObject = localIVasFTManager.obtainCardInfo(str).toJson();
      localJSONObject.put("cardStates", localIVasFTManager.obtainCardState(str));
      paramRequestEvent.ok(localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      paramRequestEvent.fail(localException.getMessage());
      QLog.d("TreasureCardMiniJsPlugin", 2, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TreasureCardMiniJsPlugin
 * JD-Core Version:    0.7.0.1
 */