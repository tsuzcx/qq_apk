package com.tencent.qqmini.minigame.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo;

public class OperateFloatDragAd
  implements Action<Boolean>
{
  private FloatDragAdInfo floatDragAdInfo;
  private IMiniAppContext miniAppContext;
  private String operateType;
  
  public static OperateFloatDragAd obtain(IMiniAppContext paramIMiniAppContext)
  {
    OperateFloatDragAd localOperateFloatDragAd = new OperateFloatDragAd();
    localOperateFloatDragAd.miniAppContext = paramIMiniAppContext;
    return localOperateFloatDragAd;
  }
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (paramBaseRuntime == null) {
      return null;
    }
    return Boolean.valueOf(paramBaseRuntime.operateFloatDragAd(this.operateType, this.floatDragAdInfo));
  }
  
  public boolean remove()
  {
    this.operateType = "remove";
    return ((Boolean)this.miniAppContext.performAction(this)).booleanValue();
  }
  
  public boolean show(FloatDragAdInfo paramFloatDragAdInfo)
  {
    this.operateType = "add";
    this.floatDragAdInfo = paramFloatDragAdInfo;
    return ((Boolean)this.miniAppContext.performAction(this)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.action.OperateFloatDragAd
 * JD-Core Version:    0.7.0.1
 */