package com.tencent.webbundle.sdk;

import android.content.Context;
import android.content.Intent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class WebBundleClient
{
  private String bizId;
  @Nullable
  private WebBundle webBundle;
  
  public WebBundleClient(String paramString)
  {
    this.bizId = paramString;
  }
  
  @Nullable
  public final IWebBundleWebView getValidWebView(@NotNull Context paramContext, String paramString)
  {
    this.webBundle = WebBundleManager.getInstance(this.bizId).getAvailableWebBundle(paramContext, paramString);
    paramContext = this.webBundle;
    if (paramContext != null) {
      return paramContext.getWebView();
    }
    return null;
  }
  
  public final boolean interceptLoadUrl(@NotNull Intent paramIntent)
  {
    if (this.webBundle != null)
    {
      String str1 = paramIntent.getStringExtra("bundle_data");
      String str2 = paramIntent.getStringExtra("real_url");
      paramIntent = new JSONObject();
      try
      {
        paramIntent.put("type", "pushView");
        paramIntent.put("data", new JSONObject(str1));
        paramIntent.put("url", str2);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      this.webBundle.use(paramIntent);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.webbundle.sdk.WebBundleClient
 * JD-Core Version:    0.7.0.1
 */