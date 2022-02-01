package com.tencent.mobileqq.structmsg;

import bdnq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.medalwall.MedalWallMng;

public class AbsShareMsg$1$1
  implements Runnable
{
  public AbsShareMsg$1$1(bdnq parambdnq, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ((MedalWallMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsShareMsg.1.1
 * JD-Core Version:    0.7.0.1
 */