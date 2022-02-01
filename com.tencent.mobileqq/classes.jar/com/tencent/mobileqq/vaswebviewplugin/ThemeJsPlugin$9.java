package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.vas.theme.api.QueryCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import org.json.JSONObject;

class ThemeJsPlugin$9
  implements QueryCallback<ThemeLocator>
{
  ThemeJsPlugin$9(ThemeJsPlugin paramThemeJsPlugin, JSONObject paramJSONObject, String paramString) {}
  
  public void postQuery(ThemeLocator paramThemeLocator)
  {
    this.this$0.queryInfo(this.val$json, this.val$callbackId, paramThemeLocator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */