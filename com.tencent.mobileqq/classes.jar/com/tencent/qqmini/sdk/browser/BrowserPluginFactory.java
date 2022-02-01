package com.tencent.qqmini.sdk.browser;

import android.text.TextUtils;
import java.util.HashMap;

public class BrowserPluginFactory
{
  public static final HashMap<String, Integer> S_PLUGIN_NAME_SPACE_HASH_MAP = new HashMap();
  
  static
  {
    S_PLUGIN_NAME_SPACE_HASH_MAP.put("miniApp", Integer.valueOf(1));
  }
  
  public static BrowserPlugin createWebViewPlugin(int paramInt)
  {
    if (paramInt != 1) {
      return null;
    }
    return new BrowserMiniAppPlugin();
  }
  
  public static BrowserPlugin createWebViewPlugin(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (S_PLUGIN_NAME_SPACE_HASH_MAP.containsKey(paramString))) {
      return createWebViewPlugin(((Integer)S_PLUGIN_NAME_SPACE_HASH_MAP.get(paramString)).intValue());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.browser.BrowserPluginFactory
 * JD-Core Version:    0.7.0.1
 */