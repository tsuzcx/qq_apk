package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipColorNickProcessor
  extends BaseQVipConfigProcessor<QVipColorNickConfig>
{
  public static QVipColorNickConfig c()
  {
    return (QVipColorNickConfig)QConfigManager.a().a(412);
  }
  
  @NonNull
  public QVipColorNickConfig a()
  {
    return new QVipColorNickConfig();
  }
  
  @NonNull
  public QVipColorNickConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    QVipColorNickConfig localQVipColorNickConfig = new QVipColorNickConfig();
    boolean bool = false;
    try
    {
      if (new JSONObject(paramArrayOfQConfItem[0].a).optInt("allow_edit_color_nick", 1) == 1) {
        bool = true;
      }
      localQVipColorNickConfig.a = bool;
      return localQVipColorNickConfig;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QVipColorNickProcessor onParsed exception :");
      localStringBuilder.append(paramArrayOfQConfItem.getMessage());
      SLog.e("QVipColorNickProcessor", localStringBuilder.toString());
    }
    return localQVipColorNickConfig;
  }
  
  @NonNull
  public QVipColorNickConfig b()
  {
    return new QVipColorNickConfig();
  }
  
  public Class<QVipColorNickConfig> clazz()
  {
    return QVipColorNickConfig.class;
  }
  
  public int type()
  {
    return 412;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipColorNickProcessor
 * JD-Core Version:    0.7.0.1
 */