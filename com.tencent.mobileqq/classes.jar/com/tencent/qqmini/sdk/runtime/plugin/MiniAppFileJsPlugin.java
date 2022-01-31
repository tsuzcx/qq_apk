package com.tencent.qqmini.sdk.runtime.plugin;

import bglv;
import bgmk;
import bgok;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;

public class MiniAppFileJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_OPEN_DOCUMENT = "openDocument";
  
  public void openDocument(bgok parambgok)
  {
    this.mMiniAppContext.a(bgmk.a(parambgok, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MiniAppFileJsPlugin
 * JD-Core Version:    0.7.0.1
 */