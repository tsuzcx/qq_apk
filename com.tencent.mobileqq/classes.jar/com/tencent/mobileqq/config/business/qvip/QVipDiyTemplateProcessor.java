package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipDiyTemplateProcessor
  extends BaseQVipConfigProcessor<QVipDiyTemplateConfig>
{
  static QVipDiyTemplateConfig a = new QVipDiyTemplateConfig();
  
  public static QVipDiyTemplateConfig c()
  {
    QVipDiyTemplateConfig localQVipDiyTemplateConfig2 = (QVipDiyTemplateConfig)QConfigManager.a().a(444);
    QVipDiyTemplateConfig localQVipDiyTemplateConfig1 = localQVipDiyTemplateConfig2;
    if (localQVipDiyTemplateConfig2 == null) {
      localQVipDiyTemplateConfig1 = a;
    }
    return localQVipDiyTemplateConfig1;
  }
  
  @NonNull
  public QVipDiyTemplateConfig a()
  {
    return a;
  }
  
  @NonNull
  public QVipDiyTemplateConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    QVipDiyTemplateConfig localQVipDiyTemplateConfig = new QVipDiyTemplateConfig();
    int m = paramArrayOfQConfItem.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      Object localObject = paramArrayOfQConfItem[i];
      if (j > ((QConfItem)localObject).jdField_a_of_type_Int)
      {
        i += 1;
      }
      else
      {
        int k = ((QConfItem)localObject).jdField_a_of_type_Int;
        j = k;
        for (;;)
        {
          try
          {
            if (paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString == null) {
              break;
            }
            localObject = new JSONObject(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
            localQVipDiyTemplateConfig.a = ((JSONObject)localObject).optBoolean("enable", false);
            if (((JSONObject)localObject).optInt("dltc", 0) != 1) {
              break label166;
            }
            bool = true;
            localQVipDiyTemplateConfig.b = bool;
            j = k;
          }
          catch (JSONException localJSONException)
          {
            SLog.e("QVipDiyTemplateProcessor", "parsed : " + paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString + " error:" + localJSONException);
            j = k;
          }
          break;
          label166:
          boolean bool = false;
        }
      }
    }
    return localQVipDiyTemplateConfig;
  }
  
  @NonNull
  public QVipDiyTemplateConfig b()
  {
    return a;
  }
  
  public Class<QVipDiyTemplateConfig> clazz()
  {
    return QVipDiyTemplateConfig.class;
  }
  
  public int type()
  {
    return 444;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipDiyTemplateProcessor
 * JD-Core Version:    0.7.0.1
 */