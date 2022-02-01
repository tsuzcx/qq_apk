package com.tencent.qcircle.cooperation.config;

import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class QCircleUrlUtil
{
  public static String a(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString).getHost();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      if (!b(paramString3))
      {
        if (paramString3.startsWith("http")) {
          return paramString3;
        }
        String str = QCircleConfigHelper.a(paramString1, paramString2);
        QLog.d("QCircleUrlUtil", 1, String.format("convertDomainToIp ips:%s, main:%s,second:%s", new Object[] { str, paramString1, paramString2 }));
        if (str != null)
        {
          paramString2 = new JSONObject(str);
          if (paramString4 != null)
          {
            paramString1 = paramString4;
            if (paramString4.trim().length() != 0) {}
          }
          else
          {
            paramString1 = a(paramString3);
          }
          if ((paramString1 != null) && (paramString2.has(paramString1)))
          {
            paramString4 = paramString2.getJSONArray(paramString1);
            if ((paramString4.length() > 0) && ((paramString4.get(0) instanceof JSONObject)) && (((JSONObject)paramString4.get(0)).has("ip")) && (((JSONObject)paramString4.get(0)).has("port")))
            {
              paramString2 = ((JSONObject)paramString4.get(0)).getString("ip");
              paramString4 = ((JSONObject)paramString4.get(0)).getString("port");
              if ((paramString2.trim().length() > 0) && (paramString4.trim().length() > 0))
              {
                paramString1 = paramString3.replace(paramString1, String.format("%s:%s", new Object[] { paramString2, paramString4 }));
                paramString2 = new StringBuilder();
                paramString2.append("convertDomainToIp newUrl:");
                paramString2.append(paramString1);
                QLog.d("QCircleUrlUtil", 1, paramString2.toString());
                return paramString1;
              }
              QLog.w("QCircleUrlUtil", 1, String.format("convertDomainToIp  IP&Port empty url:%s, ip:%s,  port:%s", new Object[] { paramString3, paramString2, paramString4 }));
            }
          }
        }
        QLog.d("QCircleUrlUtil", 1, "convertDomainToIp use old url");
      }
      return paramString3;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      QLog.d("QCircleUrlUtil", 1, "convertDomainToIp use old url");
    }
    return paramString3;
  }
  
  private static boolean b(String paramString)
  {
    if (paramString.startsWith("/storage"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNativeUrl local url return:");
      localStringBuilder.append(paramString);
      QLog.d("QCircleUrlUtil", 1, localStringBuilder.toString());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.cooperation.config.QCircleUrlUtil
 * JD-Core Version:    0.7.0.1
 */