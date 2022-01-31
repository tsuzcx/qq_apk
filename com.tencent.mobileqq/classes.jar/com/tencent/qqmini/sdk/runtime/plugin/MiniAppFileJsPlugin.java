package com.tencent.qqmini.sdk.runtime.plugin;

import bgho;
import bgid;
import bgkd;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;

public class MiniAppFileJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_OPEN_DOCUMENT = "openDocument";
  
  public void openDocument(bgkd parambgkd)
  {
    this.mMiniAppContext.a(bgid.a(parambgkd, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MiniAppFileJsPlugin
 * JD-Core Version:    0.7.0.1
 */