package com.tencent.mobileqq.gamecenter.gameBuddy;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class GameBuddyModule
  extends QIPCModule
{
  public static GameBuddyModule a;
  
  public GameBuddyModule()
  {
    super("module_game_buddy");
  }
  
  public static GameBuddyModule a()
  {
    try
    {
      if (a == null) {
        try
        {
          if (a == null) {
            a = new GameBuddyModule();
          }
        }
        finally {}
      }
      GameBuddyModule localGameBuddyModule = a;
      return localGameBuddyModule;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", params = ");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(",callbackId=");
      localStringBuilder.append(paramInt);
      QLog.d("module_game_buddy", 2, localStringBuilder.toString());
    }
    if ("action_check_aio_type".equals(paramString))
    {
      paramString = paramBundle.getString("uin_value");
      int j = 10009;
      paramBundle = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      int i;
      if (paramBundle != null)
      {
        paramBundle = (FriendsManager)paramBundle.getManager(QQManagerFactory.FRIENDS_MANAGER);
        i = j;
        if (paramBundle != null)
        {
          i = j;
          if (!TextUtils.isEmpty(paramString))
          {
            i = j;
            if (paramBundle.b(paramString)) {
              i = 0;
            }
          }
        }
      }
      else
      {
        QLog.w("module_game_buddy", 1, "app is null");
        i = j;
      }
      paramString = new Bundle();
      paramString.putInt("uin_type", i);
      callbackResult(paramInt, EIPCResult.createResult(0, paramString));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.gameBuddy.GameBuddyModule
 * JD-Core Version:    0.7.0.1
 */