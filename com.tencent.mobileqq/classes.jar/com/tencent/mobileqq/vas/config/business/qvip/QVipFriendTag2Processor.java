package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipFriendTag2Processor
  extends BaseQVipConfigProcessor<QVipFriendTag2Config>
{
  public static QVipFriendTag2Config c()
  {
    QVipFriendTag2Config localQVipFriendTag2Config2 = (QVipFriendTag2Config)QConfigManager.a().a(469);
    QVipFriendTag2Config localQVipFriendTag2Config1 = localQVipFriendTag2Config2;
    if (localQVipFriendTag2Config2 == null) {
      localQVipFriendTag2Config1 = new QVipFriendTag2Config();
    }
    return localQVipFriendTag2Config1;
  }
  
  @NonNull
  public QVipFriendTag2Config a()
  {
    return new QVipFriendTag2Config();
  }
  
  @NonNull
  public QVipFriendTag2Config a(QConfItem[] paramArrayOfQConfItem)
  {
    QVipFriendTag2Config localQVipFriendTag2Config = new QVipFriendTag2Config();
    boolean bool = false;
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem);
      if (paramArrayOfQConfItem.optInt("is_show_recover_entry", 1) == 1) {
        bool = true;
      }
      localQVipFriendTag2Config.jdField_a_of_type_Boolean = bool;
      localQVipFriendTag2Config.jdField_a_of_type_JavaLangString = paramArrayOfQConfItem.optString("recover_text", localQVipFriendTag2Config.jdField_a_of_type_JavaLangString);
      localQVipFriendTag2Config.b = paramArrayOfQConfItem.optString("recover_url", localQVipFriendTag2Config.b);
      localQVipFriendTag2Config.c = paramArrayOfQConfItem.optString("recoveryHomePageUrl", localQVipFriendTag2Config.c);
      return localQVipFriendTag2Config;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QVipFriendTag2Config onParsed exception :");
      localStringBuilder.append(paramArrayOfQConfItem.getMessage());
      SLog.e("QVipFriendTag2Processor", localStringBuilder.toString());
    }
    return localQVipFriendTag2Config;
  }
  
  @NonNull
  public QVipFriendTag2Config b()
  {
    return new QVipFriendTag2Config();
  }
  
  public Class<QVipFriendTag2Config> clazz()
  {
    return QVipFriendTag2Config.class;
  }
  
  public int type()
  {
    return 469;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipFriendTag2Processor
 * JD-Core Version:    0.7.0.1
 */