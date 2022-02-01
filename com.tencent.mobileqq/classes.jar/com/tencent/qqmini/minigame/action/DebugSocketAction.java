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
    if (!(paramBaseRuntime instanceof GameRuntime)) {
      return Boolean.valueOf(false);
    }
    paramBaseRuntime = ((GameRuntime)paramBaseRuntime).getQQDebugSocket();
    if (paramBaseRuntime == null)
    {
      QMLog.w("Action", "QQDebugWebSocket is null");
      return Boolean.valueOf(false);
    }
    switch (this.action)
    {
    }
    for (;;)
    {
      return Boolean.valueOf(true);
      paramBaseRuntime.sendQQDebugMethodMsg(this.cmd, this.data);
      continue;
      paramBaseRuntime.sendQuitDebugMsgInfo();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.action.DebugSocketAction
 * JD-Core Version:    0.7.0.1
 */