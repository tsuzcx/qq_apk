package com.tencent.mobileqq.troop.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.ITroopHandlerService;
import com.tencent.mobileqq.troop.avatar.api.ITroopAvatarService;
import com.tencent.mobileqq.troop.onlinepush.api.ITroopOnlinePushHandler;
import mqq.app.AppRuntime;

public class TroopHandlerServiceImpl
  implements ITroopHandlerService
{
  protected AppRuntime mApp;
  
  public Bitmap getGroupFaceIcon(String paramString, boolean paramBoolean)
  {
    AppRuntime localAppRuntime = this.mApp;
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((ITroopAvatarService)localAppRuntime.getRuntimeService(ITroopAvatarService.class, "")).getGroupFaceIcon(paramString, paramBoolean);
    }
    return null;
  }
  
  public void handleMemberExit(String paramString1, String paramString2)
  {
    AppRuntime localAppRuntime = this.mApp;
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((ITroopOnlinePushHandler)((QQAppInterface)localAppRuntime).getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_PUSH_HANDLER)).a(paramString1, paramString2);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    this.mApp = null;
  }
  
  public void updateGroupIcon(String paramString, boolean paramBoolean)
  {
    AppRuntime localAppRuntime = this.mApp;
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((ITroopAvatarService)localAppRuntime.getRuntimeService(ITroopAvatarService.class, "")).updateGroupIcon(paramString, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopHandlerServiceImpl
 * JD-Core Version:    0.7.0.1
 */