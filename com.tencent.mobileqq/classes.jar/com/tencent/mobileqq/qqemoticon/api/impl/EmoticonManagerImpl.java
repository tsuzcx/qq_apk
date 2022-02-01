package com.tencent.mobileqq.qqemoticon.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.qqemoticon.api.IEmoticonManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class EmoticonManagerImpl
  implements IEmoticonManager
{
  public static final String TAG = "EmoticonManagerImpl";
  private IEmoticonManagerService mEmoMgr = null;
  
  public String getSmallEmoticonDescription(String paramString1, String paramString2)
  {
    IEmoticonManagerService localIEmoticonManagerService = this.mEmoMgr;
    if (localIEmoticonManagerService != null) {
      return localIEmoticonManagerService.getSmallEmoticonDescription(paramString1, paramString2);
    }
    return "";
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel())
    {
      boolean bool1 = false;
      boolean bool2 = paramAppRuntime instanceof QQAppInterface;
      if (paramAppRuntime == null) {
        bool1 = true;
      }
      QLog.d("EmoticonManagerImpl", 2, new Object[] { "onCreate is QQApp ", Boolean.valueOf(bool2), "app is null: ", Boolean.valueOf(bool1) });
    }
    if (paramAppRuntime != null) {
      try
      {
        if (!(paramAppRuntime instanceof INearbyAppInterface))
        {
          this.mEmoMgr = ((IEmoticonManagerService)paramAppRuntime.getRuntimeService(IEmoticonManagerService.class, ""));
          return;
        }
      }
      catch (Throwable paramAppRuntime)
      {
        paramAppRuntime.printStackTrace();
      }
    }
  }
  
  public void onDestroy()
  {
    this.mEmoMgr = null;
  }
  
  public String syncGetEmoticonDescriptionById(String paramString1, String paramString2)
  {
    IEmoticonManagerService localIEmoticonManagerService = this.mEmoMgr;
    if (localIEmoticonManagerService != null)
    {
      paramString1 = localIEmoticonManagerService.syncFindEmoticonById(paramString1, paramString2);
      if (paramString1 != null) {
        return paramString1.character;
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqemoticon.api.impl.EmoticonManagerImpl
 * JD-Core Version:    0.7.0.1
 */