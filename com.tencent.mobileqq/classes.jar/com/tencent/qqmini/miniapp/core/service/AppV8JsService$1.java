package com.tencent.qqmini.miniapp.core.service;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.core.fsm.JsStatMachine.JsState;
import com.tencent.qqmini.miniapp.core.fsm.JsStatMachine.JsStateListener;
import com.tencent.qqmini.v8rt.engine.SpeedUtil;

class AppV8JsService$1
  implements JsStatMachine.JsStateListener
{
  AppV8JsService$1(AppV8JsService paramAppV8JsService) {}
  
  public void onJsStateEnd(JsStatMachine.JsState paramJsState)
  {
    paramJsState = paramJsState.getJsPath();
    if ((!TextUtils.isEmpty(paramJsState)) && (paramJsState.contains("QLogic.js")))
    {
      paramJsState = SpeedUtil.DEFAULT;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("runQLogicJs finish ");
      localStringBuilder.append(this);
      paramJsState.event(localStringBuilder.toString());
    }
  }
  
  public void onJsStateStart(JsStatMachine.JsState paramJsState)
  {
    paramJsState = paramJsState.getJsPath();
    if ((!TextUtils.isEmpty(paramJsState)) && (paramJsState.contains("QLogic.js")))
    {
      paramJsState = SpeedUtil.DEFAULT;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("runQLogicJs start ");
      localStringBuilder.append(this);
      paramJsState.event(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppV8JsService.1
 * JD-Core Version:    0.7.0.1
 */