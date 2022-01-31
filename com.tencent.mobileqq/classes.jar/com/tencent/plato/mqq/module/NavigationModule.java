package com.tencent.plato.mqq.module;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.plato.ExportedModule;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.PlatoAppFragment;
import com.tencent.plato.PlatoAppManager;
import com.tencent.plato.annotation.Exported;
import com.tencent.plato.core.IFunction;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.utils.PLog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class NavigationModule
  extends ExportedModule
{
  private static String TAG = "PlatoNavigationModule";
  private final AppRuntime mApp;
  
  public NavigationModule(AppRuntime paramAppRuntime)
  {
    super("PLTQQNavigation");
    this.mApp = paramAppRuntime;
  }
  
  @Exported("getSkey")
  public void getSkey(IPlatoRuntime paramIPlatoRuntime, IFunction paramIFunction)
  {
    paramIFunction.invoke(new Object[] { ((TicketManager)this.mApp.getManager(2)).getSkey(this.mApp.getAccount()) });
  }
  
  @Exported("popUpViewController")
  public void popUpViewController(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap)
  {
    if (paramIReadableMap.has("docId"))
    {
      paramIPlatoRuntime = PlatoAppManager.getRunningAppModule(paramIReadableMap.getString("docId", null));
      if (paramIPlatoRuntime != null) {
        paramIPlatoRuntime.getActivity().finish();
      }
    }
  }
  
  @Exported("refreshGroupCard")
  public void refreshGroupCard(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap)
  {
    paramIPlatoRuntime = paramIReadableMap.getString("gc", "");
    TroopMemberApiClient localTroopMemberApiClient = TroopMemberApiClient.a();
    localTroopMemberApiClient.a();
    localTroopMemberApiClient.a(true, paramIPlatoRuntime);
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 2, "refreshGroupCard:" + paramIReadableMap);
    }
  }
  
  @Exported("setLeftButton")
  public void setLeftButton(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap)
  {
    if (paramIReadableMap.has("docId"))
    {
      paramIPlatoRuntime = paramIReadableMap.getString("docId", null);
      paramIReadableMap = paramIReadableMap.getString("text", "");
      paramIPlatoRuntime = PlatoAppManager.getRunningAppModule(paramIPlatoRuntime);
      if (paramIPlatoRuntime != null) {
        paramIPlatoRuntime.mUIHander.post(new NavigationModule.2(this, paramIPlatoRuntime, paramIReadableMap));
      }
    }
  }
  
  @Exported("setRightButton")
  public void setRightButton(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap)
  {
    if (paramIReadableMap.has("docId"))
    {
      Object localObject = paramIReadableMap.getString("docId", null);
      paramIPlatoRuntime = paramIReadableMap.getString("text", "");
      paramIReadableMap = paramIReadableMap.getFunction("onClick");
      localObject = PlatoAppManager.getRunningAppModule((String)localObject);
      if (localObject != null) {
        ((PlatoAppFragment)localObject).mUIHander.post(new NavigationModule.1(this, (PlatoAppFragment)localObject, paramIPlatoRuntime, paramIReadableMap));
      }
      return;
    }
    PLog.w(TAG, "setRightButton without docId [" + paramIReadableMap + "]");
  }
  
  @Exported("showToast")
  public void showToast(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap)
  {
    int j = 1;
    paramIPlatoRuntime = paramIReadableMap.getString("icon", "suc");
    String str = paramIReadableMap.getString("msg", "");
    if (paramIReadableMap.getInt("duration", 1000) > 2000) {}
    for (int i = 1;; i = 0)
    {
      if (paramIPlatoRuntime.equals("suc")) {
        j = 2;
      }
      QQToast.a(BaseApplication.getContext(), j, str, i).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.mqq.module.NavigationModule
 * JD-Core Version:    0.7.0.1
 */