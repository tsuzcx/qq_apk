package com.tencent.mobileqq.config.business.qvip;

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
    boolean bool = true;
    localQVipColorNickConfig = new QVipColorNickConfig();
    try
    {
      if (new JSONObject(paramArrayOfQConfItem[0].a).optInt("allow_edit_color_nick", 1) == 1) {}
      for (;;)
      {
        localQVipColorNickConfig.a = bool;
        return localQVipColorNickConfig;
        bool = false;
      }
      return localQVipColorNickConfig;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      SLog.e("QVipColorNickProcessor", "QVipColorNickProcessor onParsed exception :" + paramArrayOfQConfItem.getMessage());
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipColorNickProcessor
 * JD-Core Version:    0.7.0.1
 */