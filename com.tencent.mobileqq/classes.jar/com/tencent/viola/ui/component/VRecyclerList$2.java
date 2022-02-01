package com.tencent.viola.ui.component;

import android.text.TextUtils;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONArray;
import org.json.JSONObject;

class VRecyclerList$2
  implements Runnable
{
  VRecyclerList$2(VRecyclerList paramVRecyclerList, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.val$callbackId))
    {
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(this.val$callbackId);
      ViolaBridgeManager.getInstance().callbackJavascript(VRecyclerList.access$000(this.this$0).getInstanceId(), "", "callback", localJSONArray, localJSONObject, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.component.VRecyclerList.2
 * JD-Core Version:    0.7.0.1
 */