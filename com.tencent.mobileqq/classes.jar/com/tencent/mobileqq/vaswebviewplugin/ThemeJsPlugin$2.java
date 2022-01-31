package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import aphy;
import apic;
import bakr;
import org.json.JSONObject;

class ThemeJsPlugin$2
  implements bakr
{
  ThemeJsPlugin$2(ThemeJsPlugin paramThemeJsPlugin) {}
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    this.this$0.callJs(paramString, paramVarArgs);
  }
  
  public void diyThemeSetup(JSONObject paramJSONObject, String paramString)
  {
    this.this$0.diyThemeSetup(paramJSONObject.optString("id"), paramJSONObject.optString("version"), paramString);
  }
  
  public void downloadBgPic(String paramString, Bundle paramBundle)
  {
    paramString = apic.a("chatbackground_startDownload", paramString, this.this$0.mOnRemoteResp.key, paramBundle);
    this.this$0.sendRemoteReq(paramString, false, true);
  }
  
  public void startDownload(JSONObject paramJSONObject, String paramString)
  {
    this.this$0.startDownload(paramJSONObject, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */