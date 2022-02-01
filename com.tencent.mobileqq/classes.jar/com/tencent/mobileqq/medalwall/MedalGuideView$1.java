package com.tencent.mobileqq.medalwall;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class MedalGuideView$1
  implements Runnable
{
  MedalGuideView$1(MedalGuideView paramMedalGuideView) {}
  
  public void run()
  {
    try
    {
      ((MedalWallMng)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(1, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalGuideView.1
 * JD-Core Version:    0.7.0.1
 */