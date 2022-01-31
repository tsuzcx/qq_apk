package com.tencent.tvkbeacon.core.event;

import android.content.Context;
import com.tencent.tvkbeacon.core.info.d;
import com.tencent.tvkbeacon.core.strategy.StrategyQueryModule;
import com.tencent.tvkbeacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

public class UserEventModule
  extends com.tencent.tvkbeacon.core.b
{
  private static UserEventModule mInstance = null;
  private n sensorManager;
  private boolean uploadMode = true;
  
  protected UserEventModule(Context paramContext)
  {
    super(paramContext);
    com.tencent.tvkbeacon.core.info.b.a(this.mContext);
    EventStrategyBean.getInstance();
    this.sensorManager = new n();
  }
  
  public static UserEventModule getInstance()
  {
    try
    {
      UserEventModule localUserEventModule = mInstance;
      return localUserEventModule;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static UserEventModule getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new UserEventModule(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  public void onAppHotLaunch()
  {
    sensorEvent();
  }
  
  public void onAppStop() {}
  
  public void onModuleStarted()
  {
    super.onModuleStarted();
    com.tencent.tvkbeacon.core.c.c.b("[event] start userEvent module > heartbeat & launched", new Object[0]);
    new g(this.mContext).b();
    startAppLaunched();
  }
  
  public void sensorEvent()
  {
    this.sensorManager.a(this.mContext);
  }
  
  public void setUploadMode(boolean paramBoolean)
  {
    if (paramBoolean != this.uploadMode)
    {
      this.uploadMode = paramBoolean;
      if (this.uploadMode)
      {
        new g(this.mContext).b();
        startAppLaunched();
      }
    }
    else
    {
      return;
    }
    g.a(this.mContext);
  }
  
  public void startAppLaunched()
  {
    if (EventStrategyBean.getInstance().isLaunchEventSimple())
    {
      str = com.tencent.tvkbeacon.core.a.c.a(this.mContext).a("LAUEVE_DENGTA", "");
      if (com.tencent.tvkbeacon.core.c.a.a().equals(str))
      {
        com.tencent.tvkbeacon.core.c.c.a("[event] AppLaunchedEvent has been uploaded!", new Object[0]);
        return;
      }
    }
    if (d.a(this.mContext) == null)
    {
      com.tencent.tvkbeacon.core.c.c.d("[event] DeviceInfo is null then return", new Object[0]);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("A33", d.j(this.mContext));
    localHashMap.put("A133", d.f(this.mContext));
    localHashMap.put("A63", "Y");
    if (com.tencent.tvkbeacon.core.info.a.a(this.mContext))
    {
      localHashMap.put("A21", "Y");
      if (!StrategyQueryModule.getInstance(this.mContext).isAppFirstRun()) {
        break label338;
      }
      localHashMap.put("A45", "Y");
      label160:
      if (!com.tencent.tvkbeacon.core.info.a.e(this.mContext)) {
        break label352;
      }
      localHashMap.put("A66", "F");
      label181:
      localHashMap.put("A68", com.tencent.tvkbeacon.core.info.a.f(this.mContext));
      if (!com.tencent.tvkbeacon.core.info.a.a) {
        break label366;
      }
    }
    label338:
    label352:
    label366:
    for (String str = "Y";; str = "N")
    {
      localHashMap.put("A85", str);
      localHashMap.put("A9", d.e());
      localHashMap.put("A14", d.f());
      localHashMap.put("A20", d.g(this.mContext));
      localHashMap.put("A69", d.h(this.mContext));
      if (UserAction.onUserAction("rqd_applaunched", true, 0L, 0L, localHashMap, true)) {
        com.tencent.tvkbeacon.core.a.c.a(this.mContext).a().a("LAUEVE_DENGTA", com.tencent.tvkbeacon.core.c.a.a()).b();
      }
      sensorEvent();
      return;
      localHashMap.put("A21", "N");
      break;
      localHashMap.put("A45", "N");
      break label160;
      localHashMap.put("A66", "B");
      break label181;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.UserEventModule
 * JD-Core Version:    0.7.0.1
 */