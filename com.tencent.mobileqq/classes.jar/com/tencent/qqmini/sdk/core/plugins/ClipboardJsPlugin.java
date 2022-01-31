package com.tencent.qqmini.sdk.core.plugins;

import bekr;
import bekz;

public class ClipboardJsPlugin
  extends BaseJsPlugin
{
  public String getClipboardData(bekr parambekr)
  {
    bekz.a(new ClipboardJsPlugin.1(this, parambekr));
    return "";
  }
  
  public String setClipboardData(bekr parambekr)
  {
    bekz.a(new ClipboardJsPlugin.2(this, parambekr));
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ClipboardJsPlugin
 * JD-Core Version:    0.7.0.1
 */