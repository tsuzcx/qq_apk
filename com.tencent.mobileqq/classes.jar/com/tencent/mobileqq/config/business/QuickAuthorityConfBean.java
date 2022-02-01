package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class QuickAuthorityConfBean
{
  public int a = 0;
  public int b = 0;
  public int c = 1;
  public int d = 0;
  public int e = 1;
  public ConcurrentHashMap<String, String> f = new ConcurrentHashMap(10);
  
  public static QuickAuthorityConfBean a(String paramString)
  {
    QuickAuthorityConfBean localQuickAuthorityConfBean = new QuickAuthorityConfBean();
    if (paramString == null) {
      return localQuickAuthorityConfBean;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localQuickAuthorityConfBean.a = paramString.optInt("kCheckSignatureSwitch", 0);
        localQuickAuthorityConfBean.b = paramString.optInt("kDisableChooseSwitch", 0);
        localQuickAuthorityConfBean.c = paramString.optInt("kShowKickDialog", 1);
        localQuickAuthorityConfBean.d = paramString.optInt("kFDHookSwitch", 0);
        localQuickAuthorityConfBean.e = paramString.optInt("kWtloginPowTest", 1);
        paramString = paramString.optJSONObject("kSignatureList");
        if (paramString != null)
        {
          Iterator localIterator = paramString.keys();
          if (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = paramString.optString(str1);
            if (TextUtils.isEmpty(str2)) {
              continue;
            }
            localQuickAuthorityConfBean.f.put(str1, str2);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("QuickAuthorityConfProcessor", 2, new Object[] { "package: ", str1, " signature:", str2 });
            continue;
          }
        }
        paramString = new StringBuilder();
        paramString.append("confBean = ");
        paramString.append(localQuickAuthorityConfBean.toString());
        QLog.d("QuickAuthorityConfProcessor", 2, paramString.toString());
        if (localQuickAuthorityConfBean.e == 1)
        {
          bool = true;
          ThreadManagerV2.executeOnSubThread(new QuickAuthorityConfBean.1(bool));
          return localQuickAuthorityConfBean;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QuickAuthorityConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return null;
      }
      boolean bool = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("kCheckSignatureSwitch:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" kDisableChooseSwitch:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" signatureMaps:");
    localStringBuilder.append(this.f.size());
    localStringBuilder.append(" fdSwitch:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" wtloginPowTest:");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QuickAuthorityConfBean
 * JD-Core Version:    0.7.0.1
 */