package com.tencent.qqmini.miniapp.widget.camera;

import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppCamera$1
  implements MiniAppCamera.GetPhotoCallback
{
  MiniAppCamera$1(MiniAppCamera paramMiniAppCamera, RequestEvent paramRequestEvent) {}
  
  public void onGetPhoto(String paramString)
  {
    if (StringUtil.isEmpty(paramString))
    {
      this.val$req.fail();
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tempImagePath", this.this$0.getWxFilePath(paramString));
      this.val$req.jsService.evaluateCallbackJs(this.val$req.callbackId, localJSONObject.toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.1
 * JD-Core Version:    0.7.0.1
 */