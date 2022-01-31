package common.config.service;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.QUA;
import cooperation.qzone.util.QZLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneAlphaConfig
{
  private static QzoneAlphaConfig jdField_a_of_type_CommonConfigServiceQzoneAlphaConfig;
  private Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("(\\d+)\\.(\\d+).(\\d+)_(\\d+)");
  
  public static QzoneAlphaConfig a()
  {
    if (jdField_a_of_type_CommonConfigServiceQzoneAlphaConfig == null) {}
    try
    {
      if (jdField_a_of_type_CommonConfigServiceQzoneAlphaConfig == null) {
        jdField_a_of_type_CommonConfigServiceQzoneAlphaConfig = new QzoneAlphaConfig();
      }
      return jdField_a_of_type_CommonConfigServiceQzoneAlphaConfig;
    }
    finally {}
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = paramString.split(",");
        if (localObject.length >= 2)
        {
          paramString = a(localObject[0].trim());
          localObject = a(localObject[1].trim());
          if ((paramString != null) && (localObject != null) && (paramString.length >= 4) && (localObject.length >= 4))
          {
            long l1 = paramString[0];
            long l2 = paramString[1] << 24;
            long l3 = paramString[2] << 16;
            long l4 = paramString[3];
            long l5 = localObject[0];
            long l6 = localObject[1] << 24;
            long l7 = localObject[2] << 16;
            long l8 = localObject[3];
            paramString = this.jdField_a_of_type_JavaUtilRegexPattern.matcher(QUA.a());
            if (paramString.find())
            {
              long l9 = Long.parseLong(paramString.group(1));
              long l10 = Long.parseLong(paramString.group(2));
              long l11 = Long.parseLong(paramString.group(3));
              long l12 = Long.parseLong(paramString.group(4));
              l9 = l12 + ((l9 << 32) + (l10 << 24) + (l11 << 16));
              if ((l9 < (l1 << 32) + l2 + l3 + l4) || (l9 > l8 + ((l5 << 32) + l6 + l7))) {}
            }
            else
            {
              return true;
            }
          }
        }
      }
      catch (Throwable paramString) {}
    }
    return false;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    int i;
    int j;
    int k;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            localObject = paramJSONObject.optString("appVersionRange");
          } while ((!TextUtils.isEmpty((CharSequence)localObject)) && (!a((String)localObject)));
          Object localObject = paramJSONObject.optString("osVersionRange");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          localObject = ((String)localObject).split(",");
          i = Integer.parseInt(localObject[0].trim());
          j = Integer.parseInt(localObject[1].trim());
        } while ((Build.VERSION.SDK_INT < i) || (Build.VERSION.SDK_INT > j));
        paramJSONObject = paramJSONObject.optString("uinRange");
        if (TextUtils.isEmpty(paramJSONObject)) {
          break;
        }
        paramJSONObject = paramJSONObject.split(",");
        k = paramJSONObject[0].length();
      } while (k != paramJSONObject[1].length());
      i = Integer.parseInt(paramJSONObject[0]);
      j = Integer.parseInt(paramJSONObject[1]);
      k = (int)Math.pow(10.0D, k);
      k = (int)(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin() % k);
    } while ((k < i) || (k > j));
    return true;
  }
  
  private int[] a(String paramString)
  {
    int i = 0;
    try
    {
      paramString = paramString.split("_");
      if (paramString.length < 2) {
        return null;
      }
      String[] arrayOfString = paramString[0].split("\\.");
      if (arrayOfString.length >= 3)
      {
        int[] arrayOfInt = new int[4];
        while (i < 3)
        {
          arrayOfInt[i] = Integer.parseInt(arrayOfString[i]);
          i += 1;
        }
        arrayOfInt[3] = Integer.parseInt(paramString[1]);
        return arrayOfInt;
      }
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public float a(String paramString1, String paramString2, float paramFloat)
  {
    paramString1 = a(paramString1, paramString2);
    if (paramString1 == null) {
      return paramFloat;
    }
    try
    {
      float f = Float.valueOf(paramString1).floatValue();
      return f;
    }
    catch (Exception paramString1) {}
    return paramFloat;
  }
  
  public int a(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = a(paramString1, paramString2);
    if (paramString1 == null) {
      return paramInt;
    }
    try
    {
      int i = Integer.valueOf(paramString1).intValue();
      return i;
    }
    catch (Exception paramString1) {}
    return paramInt;
  }
  
  public long a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = a(paramString1, paramString2);
    if (paramString1 == null) {
      return paramLong;
    }
    try
    {
      long l = Long.valueOf(paramString1).longValue();
      return l;
    }
    catch (Exception paramString1) {}
    return paramLong;
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString1 = QzoneConfig.getInstance().getConfig(paramString1, paramString2);
    if (paramString1 == null) {}
    for (;;)
    {
      return null;
      try
      {
        paramString2 = new JSONArray(paramString1);
        int j = paramString2.length();
        int i = 0;
        while (i < j)
        {
          JSONObject localJSONObject = paramString2.getJSONObject(i);
          String str1 = localJSONObject.optString("configId");
          String str2 = localJSONObject.optString("value");
          Log.d("QzoneAlphaConfig", "configId=" + str1 + " value=" + str2);
          boolean bool = a(localJSONObject);
          if (bool) {
            return str2;
          }
          i += 1;
        }
        return null;
      }
      catch (JSONException paramString2)
      {
        QZLog.e("QzoneAlphaConfig", "failed parsing config:" + paramString1);
      }
    }
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = a(paramString1, paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return paramString3;
    }
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     common.config.service.QzoneAlphaConfig
 * JD-Core Version:    0.7.0.1
 */