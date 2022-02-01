package com.tencent.viola.ui.component;

import android.text.TextUtils;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.view.VRefreshLayout;
import com.tencent.viola.ui.view.refresh.VRefreshViewGroup;
import org.json.JSONArray;
import org.json.JSONObject;

class VKdRefresh$2
  implements Runnable
{
  VKdRefresh$2(VKdRefresh paramVKdRefresh, String paramString) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.val$callId)) && (this.this$0.getInstance() != null))
    {
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(this.val$callId);
      ViolaBridgeManager.getInstance().callbackJavascript(this.this$0.getInstance().getInstanceId(), "", "callback", localJSONArray, localJSONObject, true);
    }
    if ((this.this$0.getHostView() != null) && (((VRefreshLayout)this.this$0.getHostView()).getParent() != null)) {
      ((VRefreshViewGroup)((VRefreshLayout)this.this$0.getHostView()).getParent()).stopRefresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.component.VKdRefresh.2
 * JD-Core Version:    0.7.0.1
 */