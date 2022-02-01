package com.tencent.mobileqq.servlet;

import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.mobileqq.qroute.QRoute;

class GameCenterManagerImp$1
  implements Runnable
{
  GameCenterManagerImp$1(GameCenterManagerImp paramGameCenterManagerImp) {}
  
  public void run()
  {
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).getAutoDownloadApk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.GameCenterManagerImp.1
 * JD-Core Version:    0.7.0.1
 */