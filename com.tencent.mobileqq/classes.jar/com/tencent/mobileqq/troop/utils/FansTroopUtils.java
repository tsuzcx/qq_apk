package com.tencent.mobileqq.troop.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansEntryConfig;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;

public class FansTroopUtils
{
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    if (paramContext != null)
    {
      if (paramInt == 0) {
        return;
      }
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      if (TextUtils.isEmpty(paramString)) {
        localIntent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/index?idol_id=%1$s&_wv=16777216&_wwv=128", new Object[] { Integer.valueOf(paramInt) }));
      } else {
        localIntent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/index?gc=%1$s&idol_id=%2$s&_wv=16777216&_wwv=128", new Object[] { paramString, Integer.valueOf(paramInt) }));
      }
      paramContext.startActivity(localIntent);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/bind?gc=%1$s&_wv=16777218&_wwv=129", new Object[] { paramString }));
      paramContext.startActivity(localIntent);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramInt == 0) {
        return;
      }
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/index?gc=%1$s&idol_id=%2$s&show=1&_wv=16777216&_wwv=128", new Object[] { paramString, Integer.valueOf(paramInt) }));
      paramContext.startActivity(localIntent);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramInt1 == 0) {
        return;
      }
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/index?gc=%1$s&idol_id=%2$s&_wv=16777216&_wwv=128", new Object[] { paramString, Integer.valueOf(paramInt1) }));
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt2);
    }
  }
  
  public static boolean a()
  {
    TroopFansEntryConfig localTroopFansEntryConfig = (TroopFansEntryConfig)QConfigManager.a().a(701);
    if (localTroopFansEntryConfig != null)
    {
      if (!localTroopFansEntryConfig.isProfileCardEntranceSwitchOn()) {
        return false;
      }
      return !StudyModeManager.a();
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, TroopInfoExt paramTroopInfoExt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramTroopInfoExt == null) {
          return false;
        }
        int j = paramTroopInfoExt.starId;
        paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
        int i;
        if (paramQQAppInterface != null) {
          i = paramQQAppInterface.getFansTroopStarId();
        } else {
          i = 0;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FansTroopUtils", 2, new Object[] { "isIdolBindStatusChanged oldId=", Integer.valueOf(j), ", newid=", Integer.valueOf(i) });
        }
        bool1 = bool2;
        if (j != i) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("url", String.format("https://qun.qq.com/v2/fans/rank/hot?gc=%1$s&_wv=16777218&_wwv=129", new Object[] { paramString }));
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.FansTroopUtils
 * JD-Core Version:    0.7.0.1
 */