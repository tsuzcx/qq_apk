package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameDetailInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class GameMsgManagerServiceImpl$1$1
  implements Runnable
{
  GameMsgManagerServiceImpl$1$1(GameMsgManagerServiceImpl.1 param1, Object paramObject) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof ArrayList))
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = GameMsgManagerServiceImpl.access$000();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[onGameUserInfoChangedNotify] detail:");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangObject);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject1 = (ArrayList)this.jdField_a_of_type_JavaLangObject;
      int j = ((ArrayList)localObject1).size();
      int i = 0;
      while (i < j)
      {
        if ((((ArrayList)localObject1).get(i) instanceof GameDetailInfo))
        {
          Object localObject3 = (GameDetailInfo)((ArrayList)localObject1).get(i);
          Object localObject4;
          if ((localObject3 != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterApiImplGameMsgManagerServiceImpl$1.a.isGameMsgBlocked(((GameDetailInfo)localObject3).c)))
          {
            if (QLog.isColorLevel())
            {
              localObject2 = GameMsgManagerServiceImpl.access$000();
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("[onGameUserInfoChangedNotify], blocked! gameId:");
              ((StringBuilder)localObject4).append(((GameDetailInfo)localObject3).c);
              QLog.i((String)localObject2, 2, ((StringBuilder)localObject4).toString());
            }
          }
          else
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiImplGameMsgManagerServiceImpl$1.a.getSessionInfoByRoleId(((GameDetailInfo)localObject3).a);
            if (localObject2 != null)
            {
              GameMsgManagerServiceImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqGamecenterApiImplGameMsgManagerServiceImpl$1.a, (GameCenterSessionInfo)localObject2, (GameDetailInfo)localObject3);
              if (j > 30)
              {
                if (i == j - 1) {
                  GameMsgManagerServiceImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqGamecenterApiImplGameMsgManagerServiceImpl$1.a, "action_qgame_messgae_change", (GameCenterSessionInfo)localObject2, 3, this.jdField_a_of_type_ComTencentMobileqqGamecenterApiImplGameMsgManagerServiceImpl$1.a.getUnreadCnt());
                }
              }
              else if (((GameCenterSessionInfo)localObject2).a() == 0)
              {
                localObject3 = GameMsgManagerServiceImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqGamecenterApiImplGameMsgManagerServiceImpl$1.a, ((GameCenterSessionInfo)localObject2).e());
                if (QLog.isColorLevel())
                {
                  localObject4 = GameMsgManagerServiceImpl.access$000();
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("[onGameUserInfoChangedNotify] folder session:");
                  localStringBuilder.append(localObject3);
                  QLog.d((String)localObject4, 2, localStringBuilder.toString());
                }
                if ((localObject3 != null) && (((GameCenterSessionInfo)localObject3).d().equals(((GameCenterSessionInfo)localObject2).d()))) {
                  GameMsgManagerServiceImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqGamecenterApiImplGameMsgManagerServiceImpl$1.a, "action_qgame_messgae_change", (GameCenterSessionInfo)localObject3, 2, this.jdField_a_of_type_ComTencentMobileqqGamecenterApiImplGameMsgManagerServiceImpl$1.a.getUnreadCnt());
                }
              }
              else
              {
                GameMsgManagerServiceImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqGamecenterApiImplGameMsgManagerServiceImpl$1.a, "action_qgame_messgae_change", (GameCenterSessionInfo)localObject2, 2, this.jdField_a_of_type_ComTencentMobileqqGamecenterApiImplGameMsgManagerServiceImpl$1.a.getUnreadCnt());
              }
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl.1.1
 * JD-Core Version:    0.7.0.1
 */