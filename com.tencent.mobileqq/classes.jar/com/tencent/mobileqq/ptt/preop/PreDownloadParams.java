package com.tencent.mobileqq.ptt.preop;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.highway.utils.BaseConstants.NetType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.app.AppRuntime;

public final class PreDownloadParams
  implements BaseConstants.NetType
{
  protected static boolean a;
  protected static PreDownloadParams.Params[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfComTencentMobileqqPttPreopPreDownloadParams$Params = new PreDownloadParams.Params[4];
    jdField_a_of_type_ArrayOfComTencentMobileqqPttPreopPreDownloadParams$Params[1] = new PreDownloadParams.Params();
    jdField_a_of_type_ArrayOfComTencentMobileqqPttPreopPreDownloadParams$Params[2] = new PreDownloadParams.Params();
    jdField_a_of_type_ArrayOfComTencentMobileqqPttPreopPreDownloadParams$Params[3] = new PreDownloadParams.Params();
  }
  
  public static PreDownloadParams.Params a(AppRuntime paramAppRuntime, int paramInt)
  {
    a(paramAppRuntime, false);
    return jdField_a_of_type_ArrayOfComTencentMobileqqPttPreopPreDownloadParams$Params[paramInt];
  }
  
  protected static String a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = paramAppRuntime.getCurrentAccountUin();
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordParams_");
    localStringBuilder.append(paramAppRuntime);
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString("PreDownloadCfg", null);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Params getSavedCfg: ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" for:");
      localStringBuilder.append(paramAppRuntime);
      QLog.d("PreDownloadParams", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  static String a(AppRuntime paramAppRuntime, int paramInt, PreDownloadParams.Params paramParams)
  {
    paramAppRuntime = paramAppRuntime.getCurrentAccountUin();
    Object localObject1 = BaseApplication.getContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("RecordParams_");
    ((StringBuilder)localObject2).append(paramAppRuntime);
    localObject2 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("PTTPreDownloadParams_");
    ((StringBuilder)localObject1).append(paramInt);
    Object localObject3 = ((StringBuilder)localObject1).toString();
    localObject1 = null;
    localObject2 = ((SharedPreferences)localObject2).getString((String)localObject3, null);
    if (QLog.isDevelopLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Params getSavedParams: ");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(" for: PTTPreDownloadParams_");
      ((StringBuilder)localObject3).append(paramInt);
      ((StringBuilder)localObject3).append(" for:");
      ((StringBuilder)localObject3).append(paramAppRuntime);
      QLog.d("PreDownloadParams", 4, ((StringBuilder)localObject3).toString());
    }
    paramAppRuntime = (AppRuntime)localObject1;
    if (localObject2 != null)
    {
      paramAppRuntime = (AppRuntime)localObject1;
      if (((String)localObject2).length() > 0)
      {
        localObject1 = ((String)localObject2).split("##");
        paramAppRuntime = localObject1[0];
        localObject1 = localObject1[1];
      }
    }
    try
    {
      a(((String)localObject1).substring(((String)localObject1).indexOf(':') + 1), paramParams);
      return paramAppRuntime;
    }
    catch (Exception paramParams) {}
    return paramAppRuntime;
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ArrayOfComTencentMobileqqPttPreopPreDownloadParams$Params = new PreDownloadParams.Params[4];
    jdField_a_of_type_ArrayOfComTencentMobileqqPttPreopPreDownloadParams$Params[1] = new PreDownloadParams.Params();
    jdField_a_of_type_ArrayOfComTencentMobileqqPttPreopPreDownloadParams$Params[2] = new PreDownloadParams.Params();
    jdField_a_of_type_ArrayOfComTencentMobileqqPttPreopPreDownloadParams$Params[3] = new PreDownloadParams.Params();
  }
  
  protected static void a(String paramString, PreDownloadParams.Params paramParams)
  {
    paramString = paramString.split("#");
    if (paramString != null)
    {
      if (paramString.length < 2) {
        return;
      }
      paramParams.jdField_a_of_type_Int = Integer.parseInt(paramString[0]);
      int i = 1;
      while (i < paramString.length)
      {
        String[] arrayOfString = paramString[i].split("_");
        if (arrayOfString == null) {
          break;
        }
        if (arrayOfString.length < 2) {
          return;
        }
        int j = Integer.parseInt(arrayOfString[0]);
        int k = Integer.parseInt(arrayOfString[1]);
        paramParams.jdField_a_of_type_ArrayOfInt[j] = k;
        i += 1;
      }
    }
  }
  
  static void a(AppRuntime paramAppRuntime, PreDownloadParams.Params paramParams, int paramInt)
  {
    Object localObject1 = new StringBuilder(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    ((StringBuilder)localObject1).append("##");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(':');
    ((StringBuilder)localObject1).append(paramParams.jdField_a_of_type_Int);
    int i = 0;
    while (i <= 5)
    {
      ((StringBuilder)localObject1).append('#');
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append('_');
      ((StringBuilder)localObject1).append(paramParams.jdField_a_of_type_ArrayOfInt[i]);
      i += 1;
    }
    paramAppRuntime = paramAppRuntime.getCurrentAccountUin();
    paramParams = BaseApplication.getContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("RecordParams_");
    ((StringBuilder)localObject2).append(paramAppRuntime);
    localObject2 = paramParams.getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    paramParams = ((StringBuilder)localObject1).toString();
    localObject1 = ((SharedPreferences)localObject2).edit();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("PTTPreDownloadParams_");
    ((StringBuilder)localObject2).append(paramInt);
    ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), paramParams).commit();
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Params saveParams: ");
      ((StringBuilder)localObject1).append(paramParams);
      ((StringBuilder)localObject1).append(" for: PTTPreDownloadParams_");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" for:");
      ((StringBuilder)localObject1).append(paramAppRuntime);
      QLog.d("PreDownloadParams", 4, ((StringBuilder)localObject1).toString());
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    String str = paramAppRuntime.getCurrentAccountUin();
    paramAppRuntime = a(paramAppRuntime);
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordParams_");
    localStringBuilder.append(str);
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putString("PreDownloadCfg", paramString);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Params saveCfg: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" for:");
      localStringBuilder.append(str);
      QLog.d("PreDownloadParams", 2, localStringBuilder.toString());
    }
    boolean bool;
    if (TextUtils.isEmpty(paramAppRuntime)) {
      bool = TextUtils.isEmpty(paramString);
    } else {
      bool = paramAppRuntime.equals(paramString);
    }
    if ((bool ^ true))
    {
      ((SharedPreferences.Editor)localObject).putString("PTTPreDownloadParams_1", "");
      ((SharedPreferences.Editor)localObject).putString("PTTPreDownloadParams_3", "");
      ((SharedPreferences.Editor)localObject).putString("PTTPreDownloadParams_2", "");
      if (QLog.isDevelopLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("Params ClearParams for:");
        paramAppRuntime.append(str);
        QLog.d("PreDownloadParams", 4, paramAppRuntime.toString());
      }
    }
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (((jdField_a_of_type_Boolean) && (!paramBoolean)) || (paramAppRuntime == null)) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    try
    {
      paramAppRuntime = a(paramAppRuntime);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Params initCfg :");
        ((StringBuilder)localObject).append(paramAppRuntime);
        QLog.d("PreDownloadParams", 2, ((StringBuilder)localObject).toString());
      }
      if (paramAppRuntime != null)
      {
        if (paramAppRuntime.length() == 0) {
          return;
        }
        paramAppRuntime = paramAppRuntime.split("\\|");
        if (paramAppRuntime != null)
        {
          if (paramAppRuntime.length < 1) {
            return;
          }
          int i = paramAppRuntime.length - 1;
          while (i >= 0)
          {
            localObject = paramAppRuntime[i].split(":");
            if ((localObject != null) && (localObject.length >= 2))
            {
              int j = Integer.parseInt(localObject[0]);
              if ((j >= 1) && (j < jdField_a_of_type_ArrayOfComTencentMobileqqPttPreopPreDownloadParams$Params.length))
              {
                PreDownloadParams.Params localParams = jdField_a_of_type_ArrayOfComTencentMobileqqPttPreopPreDownloadParams$Params[j];
                a(localObject[1], localParams);
              }
            }
            i -= 1;
          }
        }
      }
      return;
    }
    catch (Exception paramAppRuntime) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.preop.PreDownloadParams
 * JD-Core Version:    0.7.0.1
 */