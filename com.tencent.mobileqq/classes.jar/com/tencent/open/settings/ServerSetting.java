package com.tencent.open.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import java.lang.ref.WeakReference;
import java.net.URL;

public class ServerSetting
{
  protected static ServerSetting a;
  protected static final String a = "com.tencent.open.settings.ServerSetting";
  protected volatile WeakReference<SharedPreferences> a;
  
  public ServerSetting()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public static ServerSetting a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenSettingsServerSetting == null) {
        jdField_a_of_type_ComTencentOpenSettingsServerSetting = new ServerSetting();
      }
      ServerSetting localServerSetting = jdField_a_of_type_ComTencentOpenSettingsServerSetting;
      return localServerSetting;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    return a(paramString, null);
  }
  
  public String a(String paramString, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(OpensdkPreference.a(CommonDataAdapter.a().a(), "OpenSettings"));
    }
    String str1 = paramString;
    try
    {
      Object localObject1 = new URL(paramString).getHost();
      if (localObject1 == null)
      {
        str1 = paramString;
        paramBundle = jdField_a_of_type_JavaLangString;
        str1 = paramString;
        localObject1 = new StringBuilder();
        str1 = paramString;
        ((StringBuilder)localObject1).append("Get host error. url=");
        str1 = paramString;
        ((StringBuilder)localObject1).append(paramString);
        str1 = paramString;
        LogUtility.e(paramBundle, ((StringBuilder)localObject1).toString());
        return paramString;
      }
      str1 = paramString;
      Object localObject2 = (SharedPreferences)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject2 != null)
      {
        str1 = paramString;
        String str2 = ((SharedPreferences)localObject2).getString((String)localObject1, null);
        if (str2 != null)
        {
          str1 = paramString;
          if (!((String)localObject1).equals(str2))
          {
            if (paramBundle != null)
            {
              str1 = paramString;
              paramBundle.putString("env", ((SharedPreferences)localObject2).getString("OpenEnvironment", "formal"));
            }
            str1 = paramString;
            paramString = paramString.replace((CharSequence)localObject1, str2);
            str1 = paramString;
            paramBundle = jdField_a_of_type_JavaLangString;
            str1 = paramString;
            localObject1 = new StringBuilder();
            str1 = paramString;
            ((StringBuilder)localObject1).append("return environment url : ");
            str1 = paramString;
            ((StringBuilder)localObject1).append(paramString);
            str1 = paramString;
            LogUtility.c(paramBundle, ((StringBuilder)localObject1).toString());
            return paramString;
          }
        }
        str1 = paramString;
        paramBundle = jdField_a_of_type_JavaLangString;
        str1 = paramString;
        localObject2 = new StringBuilder();
        str1 = paramString;
        ((StringBuilder)localObject2).append("host=");
        str1 = paramString;
        ((StringBuilder)localObject2).append((String)localObject1);
        str1 = paramString;
        ((StringBuilder)localObject2).append(", envHost=");
        str1 = paramString;
        ((StringBuilder)localObject2).append(str2);
        str1 = paramString;
        LogUtility.c(paramBundle, ((StringBuilder)localObject2).toString());
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = jdField_a_of_type_JavaLangString;
      paramBundle = new StringBuilder();
      paramBundle.append("getEnvUrl error. url=");
      paramBundle.append(str1);
      LogUtility.e(paramString, paramBundle.toString());
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.settings.ServerSetting
 * JD-Core Version:    0.7.0.1
 */