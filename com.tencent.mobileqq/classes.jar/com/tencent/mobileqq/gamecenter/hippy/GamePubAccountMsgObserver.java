package com.tencent.mobileqq.gamecenter.hippy;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;

public class GamePubAccountMsgObserver
  implements Observer
{
  public void a(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    paramArrayList = BaseApplicationImpl.getApplication().getRuntime();
    if (!(paramArrayList instanceof QQAppInterface)) {
      return;
    }
    ((GamePubAccountMsgManager)paramArrayList.getManager(QQManagerFactory.GAME_PUB_ACCOUNT_MSG_MANAGER)).a("2747277822");
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObservable instanceof GamePubAccountMsgManager)) {}
    for (;;)
    {
      return;
      try
      {
        if ((paramObject instanceof GamePubAccountMessage))
        {
          paramObservable = (GamePubAccountMessage)paramObject;
          if (("action_qgame_tool_messgae".equals(paramObservable.jdField_a_of_type_JavaLangString)) && (paramObservable.jdField_a_of_type_JavaLangObject != null))
          {
            a((ArrayList)paramObservable.jdField_a_of_type_JavaLangObject);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePubAccountMsgObserver
 * JD-Core Version:    0.7.0.1
 */