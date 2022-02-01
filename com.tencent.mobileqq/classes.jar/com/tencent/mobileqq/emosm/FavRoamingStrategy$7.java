package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.utils.NetworkUtil;

class FavRoamingStrategy$7
  implements Runnable
{
  FavRoamingStrategy$7(FavRoamingStrategy paramFavRoamingStrategy) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (!NetworkUtil.d(this.this$0.a.getApp()))) {
      return;
    }
    ((FavroamingManager)this.this$0.a.getManager(QQManagerFactory.FAV_ROAMING_MANAGER)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy.7
 * JD-Core Version:    0.7.0.1
 */