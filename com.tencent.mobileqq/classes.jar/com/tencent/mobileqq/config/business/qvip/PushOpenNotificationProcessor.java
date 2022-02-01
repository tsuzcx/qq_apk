package com.tencent.mobileqq.config.business.qvip;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class PushOpenNotificationProcessor
  extends BaseQVipConfigProcessor<PushOpenNotificationConfig>
{
  @NonNull
  public PushOpenNotificationConfig a()
  {
    return new PushOpenNotificationConfig();
  }
  
  @NonNull
  public PushOpenNotificationConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = paramArrayOfQConfItem.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfQConfItem[i].a;
        if (QLog.isColorLevel()) {
          QLog.i("PushOpenNotify", 2, "config :" + str);
        }
        if (!TextUtils.isEmpty(str))
        {
          MsgNotifyPushDialog.a(localQQAppInterface, str, false);
          PreferenceManager.getDefaultSharedPreferences(localQQAppInterface.getApp()).edit().putString(localQQAppInterface.getCurrentUin() + "_" + "push_open_notify_xml", str).commit();
        }
      }
      else
      {
        return new PushOpenNotificationConfig();
      }
      i += 1;
    }
  }
  
  @NonNull
  public PushOpenNotificationConfig b()
  {
    return new PushOpenNotificationConfig();
  }
  
  public Class<PushOpenNotificationConfig> clazz()
  {
    return PushOpenNotificationConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public int type()
  {
    return 95;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.PushOpenNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */