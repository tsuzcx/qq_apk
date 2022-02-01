package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipRedNameCardProcessor
  extends BaseQVipConfigProcessor<QVipRedNameCardConfig>
{
  public static QVipRedNameCardConfig a = new QVipRedNameCardConfig();
  
  public static QVipRedNameCardConfig c()
  {
    QVipRedNameCardConfig localQVipRedNameCardConfig2 = (QVipRedNameCardConfig)QConfigManager.a().a(423);
    QVipRedNameCardConfig localQVipRedNameCardConfig1 = localQVipRedNameCardConfig2;
    if (localQVipRedNameCardConfig2 == null) {
      localQVipRedNameCardConfig1 = new QVipRedNameCardConfig();
    }
    return localQVipRedNameCardConfig1;
  }
  
  @NonNull
  public QVipRedNameCardConfig a()
  {
    return a;
  }
  
  @NonNull
  public QVipRedNameCardConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    boolean bool = true;
    localQVipRedNameCardConfig = new QVipRedNameCardConfig();
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
    try
    {
      if (new JSONObject(paramArrayOfQConfItem).optInt("show_red_name_card", 0) == 1) {}
      for (;;)
      {
        localQVipRedNameCardConfig.a = bool;
        return localQVipRedNameCardConfig;
        bool = false;
      }
      return localQVipRedNameCardConfig;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      SLog.e("QVipRedNameCardProcessor", "QVipRedNameCardConfig onParsed exception :" + paramArrayOfQConfItem.getMessage());
    }
  }
  
  @NonNull
  public QVipRedNameCardConfig b()
  {
    return a;
  }
  
  public Class<QVipRedNameCardConfig> clazz()
  {
    return QVipRedNameCardConfig.class;
  }
  
  public int type()
  {
    return 423;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipRedNameCardProcessor
 * JD-Core Version:    0.7.0.1
 */