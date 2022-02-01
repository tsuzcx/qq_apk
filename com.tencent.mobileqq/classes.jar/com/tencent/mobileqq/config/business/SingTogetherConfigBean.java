package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SingTogetherConfigBean
{
  private SingTogetherConfigBean.GeneralTogetherItem[] a = null;
  
  public static SingTogetherConfigBean a(String paramString)
  {
    int i = 0;
    SingTogetherConfigBean localSingTogetherConfigBean = new SingTogetherConfigBean();
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherConfigBean", 0, "parse content is empty");
      }
    }
    for (;;)
    {
      return localSingTogetherConfigBean;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("array");
        if ((paramString != null) && (paramString.length() > 0))
        {
          localSingTogetherConfigBean.a = new SingTogetherConfigBean.GeneralTogetherItem[paramString.length()];
          while (i < paramString.length())
          {
            SingTogetherConfigBean.GeneralTogetherItem localGeneralTogetherItem = SingTogetherConfigBean.GeneralTogetherItem.a(paramString.getJSONObject(i));
            localSingTogetherConfigBean.a[i] = localGeneralTogetherItem;
            i += 1;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("SingTogetherConfigBean", 0, "parse config=" + localSingTogetherConfigBean);
            return localSingTogetherConfigBean;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return localSingTogetherConfigBean;
  }
  
  public SingTogetherConfigBean.GeneralTogetherItem a(int paramInt)
  {
    Object localObject;
    if ((this.a == null) || (this.a.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    SingTogetherConfigBean.GeneralTogetherItem[] arrayOfGeneralTogetherItem = this.a;
    int j = arrayOfGeneralTogetherItem.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label64;
      }
      SingTogetherConfigBean.GeneralTogetherItem localGeneralTogetherItem = arrayOfGeneralTogetherItem[i];
      localObject = localGeneralTogetherItem;
      if (localGeneralTogetherItem.a == paramInt) {
        break;
      }
      i += 1;
    }
    label64:
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString()).append(" ");
    if ((this.a != null) && (this.a.length > 0))
    {
      SingTogetherConfigBean.GeneralTogetherItem[] arrayOfGeneralTogetherItem = this.a;
      int j = arrayOfGeneralTogetherItem.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfGeneralTogetherItem[i]).append(" ");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.SingTogetherConfigBean
 * JD-Core Version:    0.7.0.1
 */