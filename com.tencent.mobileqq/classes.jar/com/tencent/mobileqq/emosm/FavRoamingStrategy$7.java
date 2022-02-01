package com.tencent.mobileqq.emosm;

import asdv;
import asfl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;

public class FavRoamingStrategy$7
  implements Runnable
{
  public FavRoamingStrategy$7(asdv paramasdv) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (!NetworkUtil.isNetSupport(this.this$0.a.getApp()))) {
      return;
    }
    ((asfl)this.this$0.a.getManager(QQManagerFactory.FAV_ROAMING_MANAGER)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy.7
 * JD-Core Version:    0.7.0.1
 */