package com.tencent.viola.ui.component;

import android.text.TextUtils;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONArray;
import org.json.JSONObject;

class VRecyclerList$3
  implements Runnable
{
  VRecyclerList$3(VRecyclerList paramVRecyclerList, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.val$callbackId))
    {
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(this.val$callbackId);
      ViolaBridgeManager.getInstance().callbackJavascript(VRecyclerList.access$100(this.this$0).getInstanceId(), "", "callback", localJSONArray, localJSONObject, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VRecyclerList.3
 * JD-Core Version:    0.7.0.1
 */