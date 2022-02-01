package com.tencent.mobileqq.emosm;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.utils.NetworkUtil;

class FavRoamingStrategy$7
  implements Runnable
{
  FavRoamingStrategy$7(FavRoamingStrategy paramFavRoamingStrategy) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      if (!NetworkUtil.isNetSupport(this.this$0.a.getApp())) {
        return;
      }
      ((IFavroamingManagerService)this.this$0.a.getRuntimeService(IFavroamingManagerService.class)).syncRoaming();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy.7
 * JD-Core Version:    0.7.0.1
 */