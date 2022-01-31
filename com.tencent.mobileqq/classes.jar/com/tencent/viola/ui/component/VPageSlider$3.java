package com.tencent.viola.ui.component;

import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONArray;
import org.json.JSONObject;

class VPageSlider$3
  implements Runnable
{
  VPageSlider$3(VPageSlider paramVPageSlider, String paramString) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(this.val$callbackId);
    ViolaBridgeManager.getInstance().callbackJavascript(VPageSlider.access$100(this.this$0).getInstanceId(), "", "callback", localJSONArray, localJSONObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.component.VPageSlider.3
 * JD-Core Version:    0.7.0.1
 */