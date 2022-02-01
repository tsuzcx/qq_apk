package com.tencent.mobileqq.qqgamepub.view;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.List;

class GameSessionView$3
  implements EIPCResultCallback
{
  GameSessionView$3(GameSessionView paramGameSessionView) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      Object localObject = paramEIPCResult.data;
      if (localObject != null)
      {
        paramEIPCResult = (List)((Bundle)localObject).getSerializable("key_get_game_msg");
        if (!GameSessionView.b(this.a))
        {
          if (!((Bundle)localObject).getBoolean("key_get_game_gray_user", false))
          {
            if (QLog.isColorLevel()) {
              QLog.d(GameSessionView.a, 2, "[setData] gray is not open. return.");
            }
            return;
          }
          GameSessionView.a(this.a, ((Bundle)localObject).getBoolean("key_get_game_show_on_list", false));
          GameSessionView.a(((Bundle)localObject).getBoolean("key_get_game_show_req_msg_unread", false));
          GameSessionView.b(this.a, true);
        }
        localObject = GameSessionView.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onCallback] list:");
        localStringBuilder.append(paramEIPCResult.size());
        localStringBuilder.append(",type:");
        localStringBuilder.append(GameSessionView.d(this.a));
        QLog.e((String)localObject, 1, localStringBuilder.toString());
        GameSessionView.c(this.a).post(new GameSessionView.3.1(this, paramEIPCResult));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GameSessionView.3
 * JD-Core Version:    0.7.0.1
 */