package com.tencent.mobileqq.microapp.appbrand;

import com.tencent.mobileqq.microapp.sdk.OnUpdateListener;
import org.json.JSONObject;

final class c
  implements OnUpdateListener
{
  c(a parama) {}
  
  public void onCheckForUpdate(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {
        localJSONObject.put("state", "updating");
      } else {
        localJSONObject.put("state", "noUpdate");
      }
      this.a.a("onUpdateStatusChange", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void onUpdateSucc(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {
        localJSONObject.put("state", "updateready");
      } else {
        localJSONObject.put("state", "updatefailed");
      }
      this.a.a("onUpdateStatusChange", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.c
 * JD-Core Version:    0.7.0.1
 */