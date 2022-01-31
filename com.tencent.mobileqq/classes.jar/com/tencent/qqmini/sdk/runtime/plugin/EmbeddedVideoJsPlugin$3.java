package com.tencent.qqmini.sdk.runtime.plugin;

import bgls;
import bgmc;
import bgok;
import bgor;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

class EmbeddedVideoJsPlugin$3
  implements bgmc<Void>
{
  EmbeddedVideoJsPlugin$3(EmbeddedVideoJsPlugin paramEmbeddedVideoJsPlugin, bgok parambgok) {}
  
  public Void perform(bgls parambgls)
  {
    parambgls = parambgls.a();
    if (!(parambgls instanceof AppBrandPageContainer))
    {
      QMLog.d("Action", "Page is invalid");
      return null;
    }
    parambgls = ((AppBrandPageContainer)parambgls).a();
    if (parambgls != null)
    {
      bgor.a(new EmbeddedVideoJsPlugin.3.1(this, parambgls));
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