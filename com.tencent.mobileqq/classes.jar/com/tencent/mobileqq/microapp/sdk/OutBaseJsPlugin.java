package com.tencent.mobileqq.microapp.sdk;

import android.app.Activity;
import com.tencent.mobileqq.microapp.MiniAppInterface;
import com.tencent.mobileqq.microapp.b.a;
import java.util.Set;
import org.json.JSONObject;

public abstract class OutBaseJsPlugin
{
  protected MiniAppInterface appInterface;
  boolean isDestroy = false;
  
  public OutBaseJsPlugin(MiniAppInterface paramMiniAppInterface)
  {
    this.appInterface = paramMiniAppInterface;
  }
  
  public boolean canHandleJsRequest(String paramString)
  {
    Set localSet = getEventMap();
    if (localSet != null) {
      return localSet.contains(paramString);
    }
    return false;
  }
  
  protected String gernerateStateResultParams(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    return a.a(paramJSONObject, "errMsg", paramString1 + ":" + paramString2).toString();
  }
  
  public abstract Set getEventMap();
  
  public String handleNativeRequest(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return "";
  }
  
  public void handleNativeResponse(String paramString1, String paramString2, int paramInt)
  {
    MiniAppController.getInstance().handleNativeResponse(this, paramString1, paramString2, paramInt);
  }
  
  public void onDestroy()
  {
    this.isDestroy = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.OutBaseJsPlugin
 * JD-Core Version:    0.7.0.1
 */