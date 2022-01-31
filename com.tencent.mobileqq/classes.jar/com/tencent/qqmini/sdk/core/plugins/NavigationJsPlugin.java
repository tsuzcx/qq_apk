package com.tencent.qqmini.sdk.core.plugins;

import bdcz;
import bdfz;
import bdgi;

public class NavigationJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "NavigationJsPlugin";
  
  public void exitMiniProgram(bdfz parambdfz)
  {
    bdgi.a(new NavigationJsPlugin.1(this, this.mMiniAppContext.a()));
    parambdfz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.NavigationJsPlugin
 * JD-Core Version:    0.7.0.1
 */