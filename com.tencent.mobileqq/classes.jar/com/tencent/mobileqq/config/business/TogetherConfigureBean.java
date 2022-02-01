package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TogetherConfigureBean
{
  public boolean a = false;
  public WatchTogetherBean b = new WatchTogetherBean();
  
  public static TogetherConfigureBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      TogetherConfigureBean localTogetherConfigureBean = new TogetherConfigureBean();
      paramString = new JSONObject(paramString);
      localTogetherConfigureBean.a = paramString.optBoolean("showTogetherWatchInTroopSettingCard", false);
      paramString = paramString.optJSONObject("watchTogether");
      if (paramString != null)
      {
        WatchTogetherBean localWatchTogetherBean = new WatchTogetherBean();
        localWatchTogetherBean.a(paramString.optInt("version"));
        localWatchTogetherBean.b(paramString.optInt("jumpType"));
        localWatchTogetherBean.a(paramString.optString("jumpUrl"));
        localWatchTogetherBean.b(paramString.optString("jumpExtensionInfo"));
        localTogetherConfigureBean.b = localWatchTogetherBean;
      }
      paramString = new StringBuilder();
      paramString.append("confBean = ");
      paramString.append(localTogetherConfigureBean.toString());
      QLog.d("TogetherBusinessConfProcessor", 2, paramString.toString());
      return localTogetherConfigureBean;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TogetherBusinessConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TogetherConfigureBean{showTogetherWatchInTroopSettingCard=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", watchTogether=");
    Object localObject = this.b;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((WatchTogetherBean)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TogetherConfigureBean
 * JD-Core Version:    0.7.0.1
 */