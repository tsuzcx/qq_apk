package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class SubAccountConfigBean
{
  public static boolean b = false;
  public boolean a = true;
  
  public static SubAccountConfigBean a(String paramString)
  {
    SubAccountConfigBean localSubAccountConfigBean = new SubAccountConfigBean();
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountConfigBean", 2, "parse content is empty");
      }
      return localSubAccountConfigBean;
    }
    try
    {
      paramString = new JSONObject(paramString);
      boolean bool = false;
      if (paramString.optInt("isSideAccountGroupMsgEnabled", 0) == 0) {
        bool = true;
      }
      localSubAccountConfigBean.a = bool;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("parse configValue=");
        paramString.append(localSubAccountConfigBean.a);
        QLog.d("SubAccountConfigBean", 2, paramString.toString());
      }
      return localSubAccountConfigBean;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SubAccountConfigBean", 2, "parse e:", paramString);
      }
    }
    return localSubAccountConfigBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.SubAccountConfigBean
 * JD-Core Version:    0.7.0.1
 */