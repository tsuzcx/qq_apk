package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class WeiyunTipsBarConfigBean
{
  private Map<String, WeiyunTipsBarConfigBean.WeiyunTipsBarConfigItem> a = new HashMap();
  
  public static WeiyunTipsBarConfigBean.WeiyunTipsBarConfigItem a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (WeiYunTipsBarConfigProcessor.a() != null)) {
      return (WeiyunTipsBarConfigBean.WeiyunTipsBarConfigItem)WeiYunTipsBarConfigProcessor.a().a().get(paramString);
    }
    return null;
  }
  
  public static WeiyunTipsBarConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    WeiyunTipsBarConfigBean localWeiyunTipsBarConfigBean;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      localWeiyunTipsBarConfigBean = new WeiyunTipsBarConfigBean();
    }
    try
    {
      paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].a);
      Iterator localIterator = paramArrayOfQConfItem.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramArrayOfQConfItem.getJSONObject(str);
        localWeiyunTipsBarConfigBean.a.put(str, WeiyunTipsBarConfigBean.WeiyunTipsBarConfigItem.a(localJSONObject));
      }
      return localWeiyunTipsBarConfigBean;
    }
    catch (JSONException paramArrayOfQConfItem) {}
    return null;
    return localWeiyunTipsBarConfigBean;
  }
  
  public Map<String, WeiyunTipsBarConfigBean.WeiyunTipsBarConfigItem> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WeiyunTipsBarConfigBean
 * JD-Core Version:    0.7.0.1
 */