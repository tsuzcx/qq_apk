package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipBigClubSVIP9Processor
  extends BaseQVipConfigProcessor<QVipBigClubSVIP9Config>
{
  public static QVipBigClubSVIP9Config c()
  {
    QVipBigClubSVIP9Config localQVipBigClubSVIP9Config2 = (QVipBigClubSVIP9Config)QConfigManager.a().a(427);
    QVipBigClubSVIP9Config localQVipBigClubSVIP9Config1 = localQVipBigClubSVIP9Config2;
    if (localQVipBigClubSVIP9Config2 == null) {
      localQVipBigClubSVIP9Config1 = new QVipBigClubSVIP9Config();
    }
    return localQVipBigClubSVIP9Config1;
  }
  
  @NonNull
  public QVipBigClubSVIP9Config a()
  {
    return new QVipBigClubSVIP9Config();
  }
  
  @NonNull
  public QVipBigClubSVIP9Config a(QConfItem[] paramArrayOfQConfItem)
  {
    boolean bool = true;
    localQVipBigClubSVIP9Config = new QVipBigClubSVIP9Config();
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
    try
    {
      if (!TextUtils.isEmpty(paramArrayOfQConfItem))
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem);
        if (paramArrayOfQConfItem.optInt("enable", 1) != 1) {
          break label93;
        }
      }
      for (;;)
      {
        localQVipBigClubSVIP9Config.mIsEnable = bool;
        localQVipBigClubSVIP9Config.mAPngIconUrl = paramArrayOfQConfItem.optString("apng_icon_url_pattern", localQVipBigClubSVIP9Config.mAPngIconUrl);
        localQVipBigClubSVIP9Config.mAPngIconUrlNewGray = paramArrayOfQConfItem.optString("apng_gray_icon_url_pattern", localQVipBigClubSVIP9Config.mAPngIconUrlNewGray);
        localQVipBigClubSVIP9Config.mVipIconSettingsUrl = paramArrayOfQConfItem.optString("vipicon_setting_url_pattern", localQVipBigClubSVIP9Config.mVipIconSettingsUrl);
        return localQVipBigClubSVIP9Config;
        label93:
        bool = false;
      }
      return localQVipBigClubSVIP9Config;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      SLog.e("QVipBigTroopExpiredProcessor", "QVipBigClubSVIP9Config onParsed exception :" + paramArrayOfQConfItem.getMessage());
    }
  }
  
  @NonNull
  public QVipBigClubSVIP9Config b()
  {
    return new QVipBigClubSVIP9Config();
  }
  
  public Class<QVipBigClubSVIP9Config> clazz()
  {
    return QVipBigClubSVIP9Config.class;
  }
  
  public int type()
  {
    return 427;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipBigClubSVIP9Processor
 * JD-Core Version:    0.7.0.1
 */