package com.tencent.mobileqq.qqgamepub.hippy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.data.GamePubAccountMessage;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GamePubAccountMsgObserver
  implements Observer
{
  public void a(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    paramArrayList = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!(paramArrayList instanceof BaseQQAppInterface)) {
      return;
    }
    ((IGamePubAccountMsgService)paramArrayList.getRuntimeService(IGamePubAccountMsgService.class, "")).clearUnreadMsg("2747277822");
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObservable instanceof IGamePubAccountMsgService)) {
      return;
    }
    try
    {
      if ((paramObject instanceof GamePubAccountMessage))
      {
        paramObservable = (GamePubAccountMessage)paramObject;
        if (("action_qgame_tool_messgae".equals(paramObservable.a)) && (paramObservable.b != null))
        {
          a((ArrayList)paramObservable.b);
          return;
        }
      }
    }
    catch (Throwable paramObservable)
    {
      paramObservable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.GamePubAccountMsgObserver
 * JD-Core Version:    0.7.0.1
 */