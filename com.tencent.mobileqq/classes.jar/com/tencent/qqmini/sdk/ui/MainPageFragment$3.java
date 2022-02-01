package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class MainPageFragment$3
  implements AsyncResult
{
  MainPageFragment$3(MainPageFragment paramMainPageFragment) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = paramJSONObject.optString("token");
      MainPageFragment.access$200(this.this$0, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MainPageFragment.3
 * JD-Core Version:    0.7.0.1
 */