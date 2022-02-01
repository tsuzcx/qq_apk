package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class GameMsgManagerServiceImpl$5
  implements Runnable
{
  GameMsgManagerServiceImpl$5(GameMsgManagerServiceImpl paramGameMsgManagerServiceImpl, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = GameMsgManagerServiceImpl.access$400(this.this$0);
    int i = 1;
    if (localObject == null)
    {
      QLog.w(GameMsgManagerServiceImpl.access$000(), 1, "app is null");
      return;
    }
    localObject = GameCenterUnissoHandler.a();
    if (this.jdField_a_of_type_Boolean)
    {
      ((GameCenterUnissoHandler)localObject).a(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    ArrayList localArrayList = GameMsgManagerServiceImpl.access$1600(this.this$0, this.jdField_a_of_type_JavaUtilArrayList);
    if ((localArrayList == null) || (localArrayList.size() <= 0)) {
      i = 0;
    }
    if (i != 0) {
      ((GameCenterUnissoHandler)localObject).a(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */