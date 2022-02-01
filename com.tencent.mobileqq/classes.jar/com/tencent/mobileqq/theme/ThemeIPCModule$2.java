package com.tencent.mobileqq.theme;

import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

final class ThemeIPCModule$2
  implements QueryItemCallback
{
  ThemeIPCModule$2(String paramString, QueryCallback paramQueryCallback) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    QLog.e("ThemeIPCModule", 1, "onQueryItemVer: " + paramInt + "," + paramString1 + "," + paramString2);
    ThemeLocator localThemeLocator;
    if (paramInt == 0)
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      localThemeLocator = new ThemeLocator().a(this.jdField_a_of_type_JavaLangString);
      localThemeLocator.a(localBaseApplication, paramString1, paramString2);
    }
    for (paramString1 = localThemeLocator;; paramString1 = null)
    {
      ThreadManagerV2.getUIHandlerV2().post(new ThemeIPCModule.2.1(this, paramString1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeIPCModule.2
 * JD-Core Version:    0.7.0.1
 */