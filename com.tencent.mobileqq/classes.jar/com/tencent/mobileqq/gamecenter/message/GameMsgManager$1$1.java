package com.tencent.mobileqq.gamecenter.message;

import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class GameMsgManager$1$1
  implements Runnable
{
  GameMsgManager$1$1(GameMsgManager.1 param1, Object paramObject) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(GameMsgManager.g(), 2, "[onGameUserInfoChangedNotify] detail:" + this.jdField_a_of_type_JavaLangObject);
    }
    if ((this.jdField_a_of_type_JavaLangObject instanceof ArrayList))
    {
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaLangObject;
      int j = localArrayList.size();
      int i = 0;
      if (i < j)
      {
        Object localObject;
        if ((localArrayList.get(i) instanceof GameDetailInfo))
        {
          localObject = (GameDetailInfo)localArrayList.get(i);
          if ((localObject == null) || (!this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager$1.a.b(((GameDetailInfo)localObject).d))) {
            break label152;
          }
          if (QLog.isColorLevel()) {
            QLog.i(GameMsgManager.g(), 2, "[onGameUserInfoChangedNotify], blocked! gameId:" + ((GameDetailInfo)localObject).d);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label152:
          GameCenterSessionInfo localGameCenterSessionInfo = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager$1.a.b(((GameDetailInfo)localObject).b);
          if (localGameCenterSessionInfo != null)
          {
            GameMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager$1.a, localGameCenterSessionInfo, (GameDetailInfo)localObject);
            if (j > 30)
            {
              if (i == j - 1) {
                this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager$1.a.a("action_qgame_messgae_change", localGameCenterSessionInfo, 3, this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager$1.a.a());
              }
            }
            else if (localGameCenterSessionInfo.a() == 0)
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager$1.a.c(localGameCenterSessionInfo.e());
              if (QLog.isColorLevel()) {
                QLog.d(GameMsgManager.g(), 2, "[onGameUserInfoChangedNotify] folder session:" + localObject);
              }
              if ((localObject != null) && (((GameCenterSessionInfo)localObject).d().equals(localGameCenterSessionInfo.d()))) {
                this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager$1.a.a("action_qgame_messgae_change", (GameCenterSessionInfo)localObject, 2, this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager$1.a.a());
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager$1.a.a("action_qgame_messgae_change", localGameCenterSessionInfo, 2, this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager$1.a.a());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgManager.1.1
 * JD-Core Version:    0.7.0.1
 */