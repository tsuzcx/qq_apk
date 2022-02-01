package com.tencent.mobileqq.troop.homework.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.observer.TroopRedDotObserver;
import com.tencent.mobileqq.troop.troopreddot.api.ITroopRedDotHandler;
import com.tencent.mobileqq.troop.troopreddot.handler.TroopRedDotHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class HWTroopUtilsApiImpl
  implements IHWTroopUtilsApi
{
  public static final String FILE_HW_TROOP_AIO_HAS_UNREAD_HOMEWORK = "file_homework_troop_aio_has_unread";
  private static final String TAG = "HWTroopUtilsApiImpl";
  
  private void clearHomeworkTroopRedPointWith0x8c2(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str;
      if (paramString1 == null) {
        str = "";
      } else {
        str = paramString1;
      }
      QLog.d("HWTroopUtilsApiImpl", 2, new Object[] { "clearHomeworkTroopRedPointWith0x8c2. troopUin=", str, ", type=", paramString2 });
    }
    try
    {
      int i = Integer.parseInt(paramString2);
      if (!TextUtils.isEmpty(paramString1)) {
        ((ITroopRedDotHandler)paramAppInterface.getBusinessHandler(TroopRedDotHandler.class.getName())).a(paramString1, i);
      }
      return;
    }
    catch (NumberFormatException paramAppInterface) {}
  }
  
  public void clearHomeworkTroopRedPoint(AppInterface paramAppInterface, String paramString)
  {
    setAIOHomeworkBtnRedPoint(paramAppInterface, paramString, 0);
    String str = String.valueOf(1104445552);
    ((ITroopRedDotHandler)paramAppInterface.getBusinessHandler(TroopRedDotHandler.class.getName())).a(TroopRedDotObserver.a, true, new Object[] { paramString, str, Boolean.valueOf(false) });
    clearHomeworkTroopRedPointWith0x8c2(paramAppInterface, paramString, str);
  }
  
  public int getAIOHomeworkBtnRedPoint(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      BaseApplication localBaseApplication = paramAppRuntime.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append("file_homework_troop_aio_has_unread");
      return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getInt(paramString, 0);
    }
    return 0;
  }
  
  public boolean hasHomeworkTroopIdentity(int paramInt)
  {
    return (paramInt == 332) || (paramInt == 333) || (paramInt == 334) || (paramInt == 335);
  }
  
  public void setAIOHomeworkBtnRedPoint(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      BaseApplication localBaseApplication = paramAppRuntime.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append("file_homework_troop_aio_has_unread");
      localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt(paramString, paramInt).commit();
      ThreadManager.post(new HWTroopUtilsApiImpl.1(this, paramAppRuntime, paramString), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.api.impl.HWTroopUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */