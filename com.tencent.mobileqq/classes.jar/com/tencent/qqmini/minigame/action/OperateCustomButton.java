package com.tencent.qqmini.minigame.action;

import android.view.View.OnClickListener;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import org.json.JSONObject;

public class OperateCustomButton
  implements Action<Boolean>
{
  public static final String OPERATE_CREATE = "create";
  public static final String OPERATE_DESTROY = "destroy";
  public static final String OPERATE_HIDE = "hide";
  public static final String OPERATE_SHOW = "show";
  public static final String OPERATE_UPDATE = "update";
  private long componentId;
  private JSONObject jsonParam;
  private IMiniAppContext miniAppContext;
  private View.OnClickListener onClickListener;
  private String operateType;
  
  public static OperateCustomButton obtain(IMiniAppContext paramIMiniAppContext)
  {
    OperateCustomButton localOperateCustomButton = new OperateCustomButton();
    localOperateCustomButton.miniAppContext = paramIMiniAppContext;
    return localOperateCustomButton;
  }
  
  public boolean operate(String paramString, long paramLong, JSONObject paramJSONObject, View.OnClickListener paramOnClickListener)
  {
    this.operateType = paramString;
    this.componentId = paramLong;
    this.jsonParam = paramJSONObject;
    this.onClickListener = paramOnClickListener;
    return ((Boolean)this.miniAppContext.performAction(this)).booleanValue();
  }
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (paramBaseRuntime == null) {
      return null;
    }
    return Boolean.valueOf(paramBaseRuntime.operateCustomButton(this.operateType, this.componentId, this.jsonParam, this.onClickListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.action.OperateCustomButton
 * JD-Core Version:    0.7.0.1
 */