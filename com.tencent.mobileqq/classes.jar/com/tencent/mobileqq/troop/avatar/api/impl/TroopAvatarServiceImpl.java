package com.tencent.mobileqq.troop.avatar.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.troop.avatar.api.ITroopAvatarService;
import com.tencent.mobileqq.troop.handler.TroopAvatarHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class TroopAvatarServiceImpl
  implements ITroopAvatarService
{
  private static final String TAG = "TroopAvatarServiceImpl";
  private AppRuntime app;
  private GroupIconHelper mIconHelper;
  
  public Bitmap getGroupFaceIcon(String paramString, boolean paramBoolean)
  {
    Bitmap localBitmap;
    if ((paramString != null) || (paramBoolean))
    {
      try
      {
        return ImageUtil.g();
      }
      catch (Throwable paramString)
      {
        if (!QLog.isColorLevel()) {
          break label85;
        }
        QLog.e("TroopAvatarServiceImpl", 2, "getDiscussionFaceIcon error", paramString);
      }
      if (!(this.app instanceof QQAppInterface)) {
        break label89;
      }
      localBitmap = ((QQAppInterface)this.app).getFaceBitmap(113, paramString, (byte)3, false, (byte)1, 0);
    }
    for (;;)
    {
      if (localBitmap == null)
      {
        updateGroupIcon(paramString, true);
        if (paramBoolean) {
          return ImageUtil.g();
        }
      }
      else
      {
        updateGroupIcon(paramString, false);
        return localBitmap;
      }
      label85:
      return null;
      return null;
      label89:
      localBitmap = null;
    }
  }
  
  public GroupIconHelper getGroupIconHelper()
  {
    return this.mIconHelper;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    Object localObject = this.app;
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (TroopAvatarHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.TROOP_AVATAR_HANDLER);
      this.mIconHelper = new GroupIconHelper(paramAppRuntime.getCurrentAccountUin(), (BusinessHandler)localObject);
    }
  }
  
  public void onDestroy()
  {
    GroupIconHelper localGroupIconHelper = this.mIconHelper;
    if (localGroupIconHelper != null) {
      localGroupIconHelper.c();
    }
  }
  
  public void updateGroupIcon(String paramString, boolean paramBoolean)
  {
    AppRuntime localAppRuntime = this.app;
    if (((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).mAutomator.h()))
    {
      if (paramBoolean)
      {
        this.mIconHelper.a(paramString);
        return;
      }
      this.mIconHelper.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.api.impl.TroopAvatarServiceImpl
 * JD-Core Version:    0.7.0.1
 */