package com.tencent.qqmini.minigame.action;

import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.debug.QQDebugWebSocket;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class DebugSocketAction
  implements Action<Boolean>
{
  public static final int QUIT_DEBUG_SOCKET = 2;
  public static final int SEND_DEBUG_MSG = 1;
  private int action;
  private String cmd;
  private String data;
  private IMiniAppContext miniAppContext;
  
  public static DebugSocketAction obtain(IMiniAppContext paramIMiniAppContext)
  {
    DebugSocketAction localDebugSocketAction = new DebugSocketAction();
    localDebugSocketAction.miniAppContext = paramIMiniAppContext;
    return localDebugSocketAction;
  }
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    boolean bool = paramBaseRuntime instanceof GameRuntime;
    Boolean localBoolean = Boolean.valueOf(false);
    if (!bool) {
      return localBoolean;
    }
    paramBaseRuntime = ((GameRuntime)paramBaseRuntime).getQQDebugSocket();
    if (paramBaseRuntime == null)
    {
      QMLog.w("Action", "QQDebugWebSocket is null");
      return localBoolean;
    }
    int i = this.action;
    if (i != 1)
    {
      if (i == 2) {
        paramBaseRuntime.sendQuitDebugMsgInfo();
      }
    }
    else {
      paramBaseRuntime.sendQQDebugMethodMsg(this.cmd, this.data);
    }
    return Boolean.valueOf(true);
  }
  
  public void quitDebugSocket()
  {
    this.action = 2;
    this.miniAppContext.performAction(this);
  }
  
  public void sendQQDebugMethodMsg(String paramString1, String paramString2)
  {
    this.action = 1;
    this.cmd = paramString1;
    this.data = paramString2;
    this.miniAppContext.performAction(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.action.DebugSocketAction
 * JD-Core Version:    0.7.0.1
 */