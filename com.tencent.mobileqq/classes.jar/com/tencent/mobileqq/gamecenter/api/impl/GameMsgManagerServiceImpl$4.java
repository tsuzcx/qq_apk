package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class GameMsgManagerServiceImpl$4
  implements Runnable
{
  GameMsgManagerServiceImpl$4(GameMsgManagerServiceImpl paramGameMsgManagerServiceImpl, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (GameMsgManagerServiceImpl.access$400(this.this$0) == null)
    {
      QLog.w(GameMsgManagerServiceImpl.access$300(), 1, "app is null");
      return;
    }
    GameCenterUnissoHandler localGameCenterUnissoHandler = GameCenterUnissoHandler.a();
    if (this.a)
    {
      localGameCenterUnissoHandler.a(GameMsgManagerServiceImpl.access$1600(this.this$0), this.b);
      return;
    }
    ArrayList localArrayList = GameMsgManagerServiceImpl.access$1700(this.this$0, this.b);
    int i;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      QLog.i(GameMsgManagerServiceImpl.access$300(), 1, "Ready to request user info from svr.");
      localGameCenterUnissoHandler.a(GameMsgManagerServiceImpl.access$1600(this.this$0), localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */