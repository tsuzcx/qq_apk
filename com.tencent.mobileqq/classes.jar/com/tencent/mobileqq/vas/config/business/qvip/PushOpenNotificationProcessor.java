package com.tencent.mobileqq.vas.config.business.qvip;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.msgnotify.api.IMsgNotifyPushDialog;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

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
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    int j = paramArrayOfQConfItem.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfQConfItem[i].a;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("config :");
        localStringBuilder.append(str);
        QLog.i("PushOpenNotify", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(str))
      {
        ((IMsgNotifyPushDialog)QRoute.api(IMsgNotifyPushDialog.class)).parsePushOpenNotifyXML(localAppRuntime, str, false);
        paramArrayOfQConfItem = PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext()).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localAppRuntime.getCurrentUin());
        localStringBuilder.append("_");
        localStringBuilder.append("push_open_notify_xml");
        paramArrayOfQConfItem.putString(localStringBuilder.toString(), str).commit();
        break;
      }
      i += 1;
    }
    return new PushOpenNotificationConfig();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.PushOpenNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */