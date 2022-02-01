package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSdkSwitchConfBean$OpenSdkSwitchConfig
  implements IQStorageSafable<String>
{
  public boolean a = false;
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("OpenSdkSwitchConfig", 1, "OpenVirtual.config content is empty");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OpenVirtual.switch.config.parse=");
    localStringBuilder.append(paramString);
    QLog.i("OpenSdkSwitchConfig", 1, localStringBuilder.toString());
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).optInt("enable", 0) != 1) {
          break label115;
        }
        bool = true;
        this.a = bool;
        if (QLog.isColorLevel())
        {
          QLog.e("OpenSdkSwitchConfig", 2, new Object[] { "OpenVirtual.switch.config.parse=", toString() });
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("OpenSdkSwitchConfig", 1, "OpenVirtual.config.getException.", paramString);
      }
      return;
      label115:
      boolean bool = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("OpenSdkSwitchConfig={");
    localStringBuilder.append("enable:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkSwitchConfBean.OpenSdkSwitchConfig
 * JD-Core Version:    0.7.0.1
 */