package com.tencent.qqmini.minigame.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;

public class OperatePendantAd
  implements Action<Boolean>
{
  private IMiniAppContext miniAppContext;
  private String operateType;
  private PendantAdInfo pendantAdInfo;
  
  public static OperatePendantAd obtain(IMiniAppContext paramIMiniAppContext)
  {
    OperatePendantAd localOperatePendantAd = new OperatePendantAd();
    localOperatePendantAd.miniAppContext = paramIMiniAppContext;
    return localOperatePendantAd;
  }
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (paramBaseRuntime == null) {
      return null;
    }
    return Boolean.valueOf(paramBaseRuntime.operatePendantAd(this.operateType, this.pendantAdInfo));
  }
  
  public boolean remove()
  {
    this.operateType = "remove";
    return ((Boolean)this.miniAppContext.performAction(this)).booleanValue();
  }
  
  public boolean show(PendantAdInfo paramPendantAdInfo)
  {
    this.operateType = "add";
    this.pendantAdInfo = paramPendantAdInfo;
    return ((Boolean)this.miniAppContext.performAction(this)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.action.OperatePendantAd
 * JD-Core Version:    0.7.0.1
 */