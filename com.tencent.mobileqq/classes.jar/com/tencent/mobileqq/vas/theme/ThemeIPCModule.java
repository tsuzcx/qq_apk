package com.tencent.mobileqq.vas.theme;

import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.vas.aidl.ISwitchCallback;
import com.tencent.mobileqq.vas.aidl.ISwitchCallback.Stub;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.ipc.QuickUpdateIPCModule;
import com.tencent.mobileqq.vas.theme.api.QueryCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import eipc.EIPCResult;

public class ThemeIPCModule
  extends QIPCModule
{
  private static ThemeIPCModule jdField_a_of_type_ComTencentMobileqqVasThemeThemeIPCModule;
  private static String jdField_a_of_type_JavaLangString = "setup";
  
  private ThemeIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static ThemeIPCModule a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqVasThemeThemeIPCModule == null) {
        jdField_a_of_type_ComTencentMobileqqVasThemeThemeIPCModule = new ThemeIPCModule("ThemeIPCModule");
      }
      ThemeIPCModule localThemeIPCModule = jdField_a_of_type_ComTencentMobileqqVasThemeThemeIPCModule;
      return localThemeIPCModule;
    }
    finally {}
  }
  
  public static void a(String paramString, ISwitchCallback paramISwitchCallback)
  {
    Bundle localBundle = new Bundle();
    if (paramISwitchCallback != null) {
      localBundle.putParcelable("binder", new BinderWarpper(paramISwitchCallback.asBinder()));
    }
    localBundle.putString("themeId", paramString);
    QIPCClientHelper.getInstance().callServer("ThemeIPCModule", jdField_a_of_type_JavaLangString, localBundle, null);
  }
  
  public static void a(String paramString, QueryCallback<ThemeLocator> paramQueryCallback)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!"1000".equals(paramString)))
    {
      if ("999".equals(paramString))
      {
        paramQueryCallback.postQuery(new ThemeLocator().a());
        return;
      }
      QuickUpdateIPCModule.queryItemVersion(3, ThemeUtil.getThemeConfigID(paramString), true, new ThemeIPCModule.2(paramString, paramQueryCallback));
      return;
    }
    paramQueryCallback.postQuery(null);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCall action = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ThemeIPCModule", 2, ((StringBuilder)localObject).toString());
    }
    paramBundle.setClassLoader(BinderWarpper.class.getClassLoader());
    String str = paramBundle.getString("themeId");
    if (paramBundle.containsKey("binder")) {
      localObject = ((BinderWarpper)paramBundle.getParcelable("binder")).a;
    } else {
      localObject = null;
    }
    if (jdField_a_of_type_JavaLangString.equals(paramString))
    {
      if (localObject != null) {
        paramString = new ThemeIPCModule.1(this, ISwitchCallback.Stub.asInterface((IBinder)localObject));
      } else {
        paramString = null;
      }
      ThemeSwitcher.a(str, "200", paramString);
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCall missing action = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("ThemeIPCModule", 1, ((StringBuilder)localObject).toString());
    return RemoteProxy.a(this, paramString, paramBundle, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.ThemeIPCModule
 * JD-Core Version:    0.7.0.1
 */