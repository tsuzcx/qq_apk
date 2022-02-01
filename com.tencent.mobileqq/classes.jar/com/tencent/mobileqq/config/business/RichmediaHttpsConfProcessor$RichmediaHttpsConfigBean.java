package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class RichmediaHttpsConfProcessor$RichmediaHttpsConfigBean
{
  public int a;
  
  public static RichmediaHttpsConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    RichmediaHttpsConfigBean localRichmediaHttpsConfigBean = new RichmediaHttpsConfigBean();
    int j;
    int i;
    try
    {
      j = paramArrayOfQConfItem.length;
      i = 0;
    }
    catch (Throwable paramArrayOfQConfItem)
    {
      boolean bool;
      StringBuilder localStringBuilder;
      QLog.d("RichmediaHttpsConfProcessor", 2, "parse S$EConfBean failed!", paramArrayOfQConfItem);
    }
    Object localObject = ((QConfItem)localObject).a;
    bool = TextUtils.isEmpty((CharSequence)localObject);
    if (!bool)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        if (localJSONObject.has("pic_down_https_switch")) {
          localRichmediaHttpsConfigBean.a = localJSONObject.optInt("pic_down_https_switch", 0);
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse S$EConfBean: ");
        localStringBuilder.append((String)localObject);
        QLog.i("RichmediaHttpsConfProcessor", 2, localStringBuilder.toString());
      }
    }
    for (;;)
    {
      i += 1;
      while (i >= j) {
        return localRichmediaHttpsConfigBean;
      }
      localObject = paramArrayOfQConfItem[i];
      if (localObject != null) {
        break;
      }
    }
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RichmediaHttpsConfigBean{mPicDownHttpsSwitch=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.RichmediaHttpsConfProcessor.RichmediaHttpsConfigBean
 * JD-Core Version:    0.7.0.1
 */