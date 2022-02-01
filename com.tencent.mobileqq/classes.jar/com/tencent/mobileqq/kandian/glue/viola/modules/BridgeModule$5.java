package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment.ViolaGestureLayoutListener;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONException;
import org.json.JSONObject;

class BridgeModule$5
  implements ViolaFragment.ViolaGestureLayoutListener
{
  BridgeModule$5(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(int paramInt)
  {
    if ((BridgeModule.access$000(this.b) != paramInt) && (this.b.getViolaInstance() != null)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = CommonSuspensionGestureLayout.c;
      if ((paramInt != i) && (paramInt != CommonSuspensionGestureLayout.e)) {
        localJSONObject.put("state", 0);
      } else {
        localJSONObject.put("state", 1);
      }
      BridgeModule.access$002(this.b, paramInt);
      ViolaBridgeManager.getInstance().callbackJavascript(this.b.getViolaInstance().getInstanceId(), this.b.getModuleName(), "callback", this.a, localJSONObject, true);
      return;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.5
 * JD-Core Version:    0.7.0.1
 */