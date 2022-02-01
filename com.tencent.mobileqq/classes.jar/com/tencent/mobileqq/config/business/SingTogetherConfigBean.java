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
    SingTogetherConfigBean localSingTogetherConfigBean = new SingTogetherConfigBean();
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherConfigBean", 0, "parse content is empty");
      }
      return localSingTogetherConfigBean;
    }
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("array");
      if (paramString != null)
      {
        if (paramString.length() <= 0) {
          return localSingTogetherConfigBean;
        }
        localSingTogetherConfigBean.a = new SingTogetherConfigBean.GeneralTogetherItem[paramString.length()];
        int i = 0;
        while (i < paramString.length())
        {
          SingTogetherConfigBean.GeneralTogetherItem localGeneralTogetherItem = SingTogetherConfigBean.GeneralTogetherItem.a(paramString.getJSONObject(i));
          localSingTogetherConfigBean.a[i] = localGeneralTogetherItem;
          i += 1;
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("parse config=");
          paramString.append(localSingTogetherConfigBean);
          QLog.d("SingTogetherConfigBean", 0, paramString.toString());
        }
      }
      return localSingTogetherConfigBean;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localSingTogetherConfigBean;
  }
  
  public SingTogetherConfigBean.GeneralTogetherItem a(int paramInt)
  {
    SingTogetherConfigBean.GeneralTogetherItem[] arrayOfGeneralTogetherItem = this.a;
    if (arrayOfGeneralTogetherItem != null)
    {
      if (arrayOfGeneralTogetherItem.length <= 0) {
        return null;
      }
      int j = arrayOfGeneralTogetherItem.length;
      int i = 0;
      while (i < j)
      {
        SingTogetherConfigBean.GeneralTogetherItem localGeneralTogetherItem = arrayOfGeneralTogetherItem[i];
        if (localGeneralTogetherItem.c == paramInt) {
          return localGeneralTogetherItem;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append(" ");
    SingTogetherConfigBean.GeneralTogetherItem[] arrayOfGeneralTogetherItem = this.a;
    if ((arrayOfGeneralTogetherItem != null) && (arrayOfGeneralTogetherItem.length > 0))
    {
      int j = arrayOfGeneralTogetherItem.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfGeneralTogetherItem[i]);
        localStringBuilder.append(" ");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.SingTogetherConfigBean
 * JD-Core Version:    0.7.0.1
 */