package com.tencent.qqmini.sdk.core.plugins;

import bgok;
import bgor;

public class ClipboardJsPlugin
  extends BaseJsPlugin
{
  public String getClipboardData(bgok parambgok)
  {
    bgor.a(new ClipboardJsPlugin.1(this, parambgok));
    return "";
  }
  
  public String setClipboardData(bgok parambgok)
  {
    bgor.a(new ClipboardJsPlugin.2(this, parambgok));
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ClipboardJsPlugin
 * JD-Core Version:    0.7.0.1
 */