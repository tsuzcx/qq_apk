package com.tencent.mobileqq.webview.swift.component;

import java.util.Hashtable;

public class SwiftBrowserSetting
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
{
  Hashtable<String, Boolean> a = new Hashtable();
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.a.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    paramString = (Boolean)this.a.get(paramString);
    if (paramString == null) {
      return paramBoolean;
    }
    return paramString.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserSetting
 * JD-Core Version:    0.7.0.1
 */