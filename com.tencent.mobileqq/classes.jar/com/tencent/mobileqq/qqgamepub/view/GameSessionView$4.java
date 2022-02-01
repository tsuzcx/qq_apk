package com.tencent.mobileqq.qqgamepub.view;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class GameSessionView$4
  implements EIPCResultCallback
{
  GameSessionView$4(GameSessionView paramGameSessionView, Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data;
      if (paramEIPCResult != null)
      {
        paramEIPCResult = paramEIPCResult.getString("key_get_msg_list_url");
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).openGameMsgSessionPageFromToolProcess(this.a, this.b, "gongzhonghao", paramEIPCResult);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameSessionView.4
 * JD-Core Version:    0.7.0.1
 */