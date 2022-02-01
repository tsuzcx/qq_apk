package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import org.json.JSONException;
import org.json.JSONObject;

public class QQFriendRelation2Processor
  extends BaseQVipConfigProcessor<QQFriendRelation2Config>
{
  public static QQFriendRelation2Config e()
  {
    QQFriendRelation2Config localQQFriendRelation2Config2 = (QQFriendRelation2Config)QConfigManager.b().b(491);
    QQFriendRelation2Config localQQFriendRelation2Config1 = localQQFriendRelation2Config2;
    if (localQQFriendRelation2Config2 == null) {
      localQQFriendRelation2Config1 = new QQFriendRelation2Config();
    }
    return localQQFriendRelation2Config1;
  }
  
  @NonNull
  public QQFriendRelation2Config a()
  {
    return new QQFriendRelation2Config();
  }
  
  @NonNull
  public QQFriendRelation2Config a(QConfItem[] paramArrayOfQConfItem)
  {
    QQFriendRelation2Config localQQFriendRelation2Config = new QQFriendRelation2Config();
    boolean bool = false;
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
    try
    {
      if (!TextUtils.isEmpty(paramArrayOfQConfItem))
      {
        if (new JSONObject(paramArrayOfQConfItem).optInt("enable", 1) == 1) {
          bool = true;
        }
        localQQFriendRelation2Config.mIsEnable = bool;
        return localQQFriendRelation2Config;
      }
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQFriendRelation2Config onParsed exception :");
      localStringBuilder.append(paramArrayOfQConfItem.getMessage());
      SLog.e("QQFriendRelation2Processor", localStringBuilder.toString());
    }
    return localQQFriendRelation2Config;
  }
  
  @NonNull
  public QQFriendRelation2Config b()
  {
    return new QQFriendRelation2Config();
  }
  
  public Class<QQFriendRelation2Config> clazz()
  {
    return QQFriendRelation2Config.class;
  }
  
  public int type()
  {
    return 491;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QQFriendRelation2Processor
 * JD-Core Version:    0.7.0.1
 */