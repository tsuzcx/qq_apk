package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.medalwall.MedalWallMng;

class AbsShareMsg$1$1
  implements Runnable
{
  AbsShareMsg$1$1(AbsShareMsg.1 param1, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ((MedalWallMng)this.a.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsShareMsg.1.1
 * JD-Core Version:    0.7.0.1
 */