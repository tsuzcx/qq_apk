package com.tencent.mobileqq.vas.theme;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.theme.api.QueryCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

final class ThemeIPCModule$2
  implements QueryItemCallback
{
  ThemeIPCModule$2(String paramString, QueryCallback paramQueryCallback) {}
  
  public void onQueryItemVer(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onQueryItemVer: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramString2);
    QLog.e("ThemeIPCModule", 1, ((StringBuilder)localObject).toString());
    if (paramInt == 0)
    {
      BaseApplication localBaseApplication = MobileQQ.getContext();
      localObject = new ThemeLocator().a(this.a);
      ((ThemeLocator)localObject).a(localBaseApplication, paramString1, paramString2);
      paramString1 = (String)localObject;
    }
    else
    {
      paramString1 = null;
    }
    ThreadManagerV2.getUIHandlerV2().post(new ThemeIPCModule.2.1(this, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.ThemeIPCModule.2
 * JD-Core Version:    0.7.0.1
 */