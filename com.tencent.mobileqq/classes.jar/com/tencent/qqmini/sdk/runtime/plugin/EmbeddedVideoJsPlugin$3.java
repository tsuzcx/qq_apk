package com.tencent.qqmini.sdk.runtime.plugin;

import bghl;
import bghv;
import bgkd;
import bgkk;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

class EmbeddedVideoJsPlugin$3
  implements bghv<Void>
{
  EmbeddedVideoJsPlugin$3(EmbeddedVideoJsPlugin paramEmbeddedVideoJsPlugin, bgkd parambgkd) {}
  
  public Void perform(bghl parambghl)
  {
    parambghl = parambghl.a();
    if (!(parambghl instanceof AppBrandPageContainer))
    {
      QMLog.d("Action", "Page is invalid");
      return null;
    }
    parambghl = ((AppBrandPageContainer)parambghl).a();
    if (parambghl != null)
    {
      bgkk.a(new EmbeddedVideoJsPlugin.3.1(this, parambghl));
      return null;
    }
    this.val$req.b();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.EmbeddedVideoJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */