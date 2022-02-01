package com.tencent.mobileqq.theme;

import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import com.tencent.mobileqq.vas.ipc.RemoteProxy;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import eipc.EIPCResult;

public class ThemeIPCModule
  extends QIPCModule
{
  private static ThemeIPCModule jdField_a_of_type_ComTencentMobileqqThemeThemeIPCModule;
  private static String jdField_a_of_type_JavaLangString = "setup";
  
  private ThemeIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static ThemeIPCModule a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqThemeThemeIPCModule == null) {
        jdField_a_of_type_ComTencentMobileqqThemeThemeIPCModule = new ThemeIPCModule("ThemeIPCModule");
      }
      ThemeIPCModule localThemeIPCModule = jdField_a_of_type_ComTencentMobileqqThemeThemeIPCModule;
      return localThemeIPCModule;
    }
    finally {}
  }
  
  public static void a(String paramString, QueryCallback<ThemeLocator> paramQueryCallback)
  {
    if ((TextUtils.isEmpty(paramString)) || ("1000".equals(paramString)))
    {
      paramQueryCallback.postQuery(null);
      return;
    }
    if ("999".equals(paramString))
    {
      paramQueryCallback.postQuery(new ThemeLocator().a());
      return;
    }
    QuickUpdateIPCModule.a(3, ThemeUtil.getThemeConfigID(paramString), true, new ThemeIPCModule.2(paramString, paramQueryCallback));
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
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeIPCModule", 2, "onCall action = " + paramString);
    }
    paramBundle.setClassLoader(BinderWarpper.class.getClassLoader());
    String str = paramBundle.getString("themeId");
    if (paramBundle.containsKey("binder")) {}
    for (IBinder localIBinder = ((BinderWarpper)paramBundle.getParcelable("binder")).a;; localIBinder = null)
    {
      if (jdField_a_of_type_JavaLangString.equals(paramString)) {
        if (localIBinder == null) {
          break label144;
        }
      }
      label144:
      for (paramString = new ThemeIPCModule.1(this, ISwitchCallback.Stub.asInterface(localIBinder));; paramString = null)
      {
        ThemeSwitcher.a(str, "200", paramString);
        return null;
        QLog.e("ThemeIPCModule", 1, "onCall missing action = " + paramString);
        return RemoteProxy.onCall(this, paramString, paramBundle, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeIPCModule
 * JD-Core Version:    0.7.0.1
 */