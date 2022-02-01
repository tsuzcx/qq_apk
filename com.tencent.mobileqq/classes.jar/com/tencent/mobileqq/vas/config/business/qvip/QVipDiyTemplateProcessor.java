package com.tencent.mobileqq.vas.config.business.qvip;

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
    Object localObject;
    int k;
    if (i < m)
    {
      localObject = paramArrayOfQConfItem[i];
      if (j <= ((QConfItem)localObject).jdField_a_of_type_Int)
      {
        k = ((QConfItem)localObject).jdField_a_of_type_Int;
        j = k;
      }
    }
    for (;;)
    {
      try
      {
        if (paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString != null)
        {
          localObject = new JSONObject(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
          localQVipDiyTemplateConfig.a = ((JSONObject)localObject).optBoolean("enable", false);
          j = ((JSONObject)localObject).optInt("dltc", 0);
          bool = true;
          if (j != 1) {
            break label190;
          }
          localQVipDiyTemplateConfig.b = bool;
          j = k;
        }
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parsed : ");
        localStringBuilder.append(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" error:");
        localStringBuilder.append(localJSONException);
        SLog.e("QVipDiyTemplateProcessor", localStringBuilder.toString());
        j = k;
      }
      i += 1;
      break;
      return localQVipDiyTemplateConfig;
      label190:
      boolean bool = false;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipDiyTemplateProcessor
 * JD-Core Version:    0.7.0.1
 */