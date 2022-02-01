package com.tencent.mobileqq.winkpublish.uploader.service;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AUploadAlphaConfig
{
  private static AUploadAlphaConfig a;
  private Pattern b = Pattern.compile("(\\d+)\\.(\\d+).(\\d+)_(\\d+)");
  
  public static AUploadAlphaConfig a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AUploadAlphaConfig();
        }
      }
      finally {}
    }
    return a;
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      Object localObject = paramString.split(",");
      if (localObject.length < 2) {
        return false;
      }
      paramString = b(localObject[0].trim());
      localObject = b(localObject[1].trim());
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
        paramString = this.b.matcher(HostDataTransUtils.getQUA3());
        if (paramString.find())
        {
          long l9 = Long.parseLong(paramString.group(1));
          long l10 = Long.parseLong(paramString.group(2));
          long l11 = Long.parseLong(paramString.group(3));
          long l12 = Long.parseLong(paramString.group(4));
          l9 = (l9 << 32) + (l10 << 24) + (l11 << 16) + l12;
          if ((l9 < (l1 << 32) + l2 + l3 + l4) || (l9 > (l5 << 32) + l6 + l7 + l8)) {
            return false;
          }
        }
        return true;
      }
      return false;
    }
    catch (Throwable paramString)
    {
      label264:
      break label264;
    }
    return false;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    Object localObject = paramJSONObject.optString("appVersionRange");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!a((String)localObject))) {
      return false;
    }
    localObject = paramJSONObject.optString("osVersionRange");
    int i;
    int j;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      i = Integer.parseInt(localObject[0].trim());
      j = Integer.parseInt(localObject[1].trim());
      if ((Build.VERSION.SDK_INT < i) || (Build.VERSION.SDK_INT > j)) {
        return false;
      }
    }
    paramJSONObject = paramJSONObject.optString("uinRange");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = paramJSONObject.split(",");
      int k = paramJSONObject[0].length();
      if (k != paramJSONObject[1].length()) {
        return false;
      }
      i = Integer.parseInt(paramJSONObject[0]);
      j = Integer.parseInt(paramJSONObject[1]);
      k = (int)Math.pow(10.0D, k);
      k = (int)(Long.parseLong(((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount()) % k);
      if ((k < i) || (k > j)) {
        return false;
      }
    }
    return true;
  }
  
  private int[] b(String paramString)
  {
    try
    {
      paramString = paramString.split("_");
      if (paramString.length < 2) {
        return null;
      }
      int i = 0;
      String[] arrayOfString = paramString[0].split("\\.");
      if (arrayOfString.length < 3) {
        return null;
      }
      int[] arrayOfInt = new int[4];
      while (i < 3)
      {
        arrayOfInt[i] = Integer.parseInt(arrayOfString[i]);
        i += 1;
      }
      arrayOfInt[3] = Integer.parseInt(paramString[1]);
      return arrayOfInt;
    }
    catch (Throwable paramString) {}
    return null;
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
  
  public String a(String paramString1, String paramString2)
  {
    paramString1 = QCircleConfigHelper.a(paramString1, paramString2);
    if (paramString1 == null) {
      return null;
    }
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("configId=");
        localStringBuilder.append(str1);
        localStringBuilder.append(" value=");
        localStringBuilder.append(str2);
        Log.d("QzoneAlphaConfig", localStringBuilder.toString());
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
      label137:
      break label137;
    }
    paramString2 = new StringBuilder();
    paramString2.append("failed parsing config:");
    paramString2.append(paramString1);
    QLog.e("QzoneAlphaConfig", 1, paramString2.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.uploader.service.AUploadAlphaConfig
 * JD-Core Version:    0.7.0.1
 */