package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
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
        QLog.d("SubAccountConfigBean", 0, "parse content is empty");
      }
      return localSubAccountConfigBean;
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).optInt("isSideAccountGroupMsgEnabled", 0) != 0) {
          break label109;
        }
        bool = true;
        localSubAccountConfigBean.a = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SubAccountConfigBean", 0, "parse configValue=" + localSubAccountConfigBean.a);
        return localSubAccountConfigBean;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SubAccountConfigBean", 0, "parse e:", paramString);
      return localSubAccountConfigBean;
      label109:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.SubAccountConfigBean
 * JD-Core Version:    0.7.0.1
 */