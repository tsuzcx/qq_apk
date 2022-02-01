package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class SSOErrorInfoMapProcessor
  extends BaseQVipConfigProcessor<SSOErrorInfoMapConfig>
{
  public static SSOErrorInfoMapConfig c()
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig2 = (SSOErrorInfoMapConfig)QConfigManager.a().a(477);
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig1 = localSSOErrorInfoMapConfig2;
    if (localSSOErrorInfoMapConfig2 == null) {
      localSSOErrorInfoMapConfig1 = new SSOErrorInfoMapConfig();
    }
    return localSSOErrorInfoMapConfig1;
  }
  
  @NonNull
  public SSOErrorInfoMapConfig a()
  {
    return new SSOErrorInfoMapConfig();
  }
  
  @NonNull
  public SSOErrorInfoMapConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig = new SSOErrorInfoMapConfig();
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
    for (;;)
    {
      String str1;
      SSOErrorInfoMapConfig.ErrorInfoMap localErrorInfoMap;
      String str2;
      SSOErrorInfoMapConfig.LocaleInfoMap localLocaleInfoMap;
      try
      {
        if (!TextUtils.isEmpty(paramArrayOfQConfItem))
        {
          paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem);
          Iterator localIterator1 = paramArrayOfQConfItem.keys();
          if (localIterator1.hasNext())
          {
            str1 = (String)localIterator1.next();
            JSONObject localJSONObject1 = paramArrayOfQConfItem.optJSONObject(str1);
            Iterator localIterator2 = localJSONObject1.keys();
            localErrorInfoMap = new SSOErrorInfoMapConfig.ErrorInfoMap();
            if (!localIterator2.hasNext()) {
              break label220;
            }
            str2 = (String)localIterator2.next();
            JSONObject localJSONObject2 = localJSONObject1.optJSONObject(str2);
            Iterator localIterator3 = localJSONObject2.keys();
            localLocaleInfoMap = new SSOErrorInfoMapConfig.LocaleInfoMap();
            if (!localIterator3.hasNext()) {
              break label204;
            }
            String str3 = (String)localIterator3.next();
            String str4 = localJSONObject2.optString(str3);
            localLocaleInfoMap.a.put(str3, str4);
            continue;
          }
        }
        return localSSOErrorInfoMapConfig;
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        SLog.e("SSOErrorInfoMapProcessor", "SSOErrorInfoMapConfig onParsed exception :" + paramArrayOfQConfItem.getMessage());
      }
      label204:
      localErrorInfoMap.a.put(str2, localLocaleInfoMap);
      continue;
      label220:
      localSSOErrorInfoMapConfig.mErrorMap.put(str1, localErrorInfoMap);
    }
  }
  
  @NonNull
  public SSOErrorInfoMapConfig b()
  {
    return new SSOErrorInfoMapConfig();
  }
  
  public Class<SSOErrorInfoMapConfig> clazz()
  {
    return SSOErrorInfoMapConfig.class;
  }
  
  public int type()
  {
    return 477;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.SSOErrorInfoMapProcessor
 * JD-Core Version:    0.7.0.1
 */