package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.config.QConfItem;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipFriendTagProcessor
  extends BaseQVipConfigProcessor<QVipFriendTagConfig>
{
  @NonNull
  public QVipFriendTagConfig a()
  {
    return new QVipFriendTagConfig();
  }
  
  @NonNull
  public QVipFriendTagConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    QVipFriendTagConfig localQVipFriendTagConfig = new QVipFriendTagConfig();
    boolean bool = false;
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem);
      if (paramArrayOfQConfItem.optInt("is_show_recover_entry", 1) == 1) {
        bool = true;
      }
      localQVipFriendTagConfig.jdField_a_of_type_Boolean = bool;
      localQVipFriendTagConfig.jdField_a_of_type_JavaLangString = paramArrayOfQConfItem.optString("recover_text", localQVipFriendTagConfig.jdField_a_of_type_JavaLangString);
      localQVipFriendTagConfig.b = paramArrayOfQConfItem.optString("recover_url", localQVipFriendTagConfig.b);
      return localQVipFriendTagConfig;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QVipFriendTagConfig onParsed exception :");
      localStringBuilder.append(paramArrayOfQConfItem.getMessage());
      SLog.e("QVipFriendTagProcessor", localStringBuilder.toString());
    }
    return localQVipFriendTagConfig;
  }
  
  @NonNull
  public QVipFriendTagConfig b()
  {
    return new QVipFriendTagConfig();
  }
  
  public Class<QVipFriendTagConfig> clazz()
  {
    return QVipFriendTagConfig.class;
  }
  
  public int type()
  {
    return 409;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipFriendTagProcessor
 * JD-Core Version:    0.7.0.1
 */