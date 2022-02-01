package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import java.util.List;

class FavroamingManagerServiceImpl$3
  implements Runnable
{
  FavroamingManagerServiceImpl$3(FavroamingManagerServiceImpl paramFavroamingManagerServiceImpl, FavEmoRoamingHandler paramFavEmoRoamingHandler) {}
  
  public void run()
  {
    List localList = ((IFavroamingDBManagerService)FavroamingManagerServiceImpl.access$800(this.this$0).getRuntimeService(IFavroamingDBManagerService.class)).getCustomEmoticonResIdsByType("needDel");
    if (localList.size() > 0)
    {
      this.a.a(localList, true);
      return;
    }
    if (localList.size() == 0) {
      this.this$0.syncRoaming();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */