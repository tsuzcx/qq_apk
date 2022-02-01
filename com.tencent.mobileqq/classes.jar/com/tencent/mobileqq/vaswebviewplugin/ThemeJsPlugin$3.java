package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.vas.theme.api.QueryCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import org.json.JSONObject;

class ThemeJsPlugin$3
  implements QueryCallback<ThemeLocator>
{
  ThemeJsPlugin$3(ThemeJsPlugin paramThemeJsPlugin, JSONObject paramJSONObject, String paramString) {}
  
  public void postQuery(ThemeLocator paramThemeLocator)
  {
    this.this$0.startDownload(this.val$json, this.val$callbackId, paramThemeLocator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */