package com.tencent.mobileqq.mini.sdk;

import android.app.Activity;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.util.JSONUtil;
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
    return JSONUtil.append(paramJSONObject, "errMsg", paramString1 + ":" + paramString2).toString();
  }
  
  public abstract Set<String> getEventMap();
  
  public String handleNativeRequest(Activity paramActivity, ApkgInfo paramApkgInfo, String paramString1, String paramString2, int paramInt)
  {
    return "";
  }
  
  public void onDestroy()
  {
    this.isDestroy = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.OutBaseJsPlugin
 * JD-Core Version:    0.7.0.1
 */