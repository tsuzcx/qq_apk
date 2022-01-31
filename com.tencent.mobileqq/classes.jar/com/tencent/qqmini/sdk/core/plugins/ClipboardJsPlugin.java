package com.tencent.qqmini.sdk.core.plugins;

import bdfz;
import bdgi;

public class ClipboardJsPlugin
  extends BaseJsPlugin
{
  public String getClipboardData(bdfz parambdfz)
  {
    bdgi.a(new ClipboardJsPlugin.1(this, parambdfz));
    return "";
  }
  
  public String setClipboardData(bdfz parambdfz)
  {
    bdgi.a(new ClipboardJsPlugin.2(this, parambdfz));
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ClipboardJsPlugin
 * JD-Core Version:    0.7.0.1
 */