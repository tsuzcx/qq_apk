package com.tencent.mobileqq.vas.config.business.qvip;

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
  public static SSOErrorInfoMapConfig e()
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig2 = (SSOErrorInfoMapConfig)QConfigManager.b().b(477);
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
    localSSOErrorInfoMapConfig = new SSOErrorInfoMapConfig();
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty(paramArrayOfQConfItem))
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem);
        localObject = paramArrayOfQConfItem.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          JSONObject localJSONObject1 = paramArrayOfQConfItem.optJSONObject(str1);
          Iterator localIterator1 = localJSONObject1.keys();
          SSOErrorInfoMapConfig.ErrorInfoMap localErrorInfoMap = new SSOErrorInfoMapConfig.ErrorInfoMap();
          while (localIterator1.hasNext())
          {
            String str2 = (String)localIterator1.next();
            JSONObject localJSONObject2 = localJSONObject1.optJSONObject(str2);
            Iterator localIterator2 = localJSONObject2.keys();
            SSOErrorInfoMapConfig.LocaleInfoMap localLocaleInfoMap = new SSOErrorInfoMapConfig.LocaleInfoMap();
            while (localIterator2.hasNext())
            {
              String str3 = (String)localIterator2.next();
              String str4 = localJSONObject2.optString(str3);
              localLocaleInfoMap.a.put(str3, str4);
            }
            localErrorInfoMap.a.put(str2, localLocaleInfoMap);
          }
          localSSOErrorInfoMapConfig.mErrorMap.put(str1, localErrorInfoMap);
        }
      }
      return localSSOErrorInfoMapConfig;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SSOErrorInfoMapConfig onParsed exception :");
      ((StringBuilder)localObject).append(paramArrayOfQConfItem.getMessage());
      SLog.e("SSOErrorInfoMapProcessor", ((StringBuilder)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.SSOErrorInfoMapProcessor
 * JD-Core Version:    0.7.0.1
 */