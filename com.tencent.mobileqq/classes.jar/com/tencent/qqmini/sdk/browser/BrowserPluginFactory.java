package com.tencent.qqmini.sdk.browser;

import android.text.TextUtils;
import java.util.HashMap;

public class BrowserPluginFactory
{
  public static final HashMap<String, Integer> sPluginNameSpaceHashMap = new HashMap();
  
  static
  {
    sPluginNameSpaceHashMap.put("miniApp", Integer.valueOf(1));
  }
  
  public static BrowserPlugin createWebViewPlugin(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new BrowserMiniAppPlugin();
  }
  
  public static BrowserPlugin createWebViewPlugin(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (sPluginNameSpaceHashMap.containsKey(paramString))) {
      return createWebViewPlugin(((Integer)sPluginNameSpaceHashMap.get(paramString)).intValue());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.browser.BrowserPluginFactory
 * JD-Core Version:    0.7.0.1
 */