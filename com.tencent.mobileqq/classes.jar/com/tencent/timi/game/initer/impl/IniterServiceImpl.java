package com.tencent.timi.game.initer.impl;

import android.content.Context;
import android.view.LayoutInflater.Factory2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.env.ServerEnv;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.initer.api.InitCallback;
import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.initer.api.OnPAGLibraryLoadedListener;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.impl.YoloRoomList;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.impl.config.SmobaConfigManager;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ThreadPool;
import mqq.app.MobileQQ;

public class IniterServiceImpl
  implements IniterService
{
  private boolean a = false;
  private boolean b = false;
  private TGGroundInterfaceWrapper c;
  private Runnable d = new IniterServiceImpl.1(this);
  
  private static boolean f()
  {
    boolean bool = YoloRoomList.a().d();
    IExpandHall localIExpandHall = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkTimiGameRes#checkCouldReleaseTg, - hasRoomList= ");
    localStringBuilder.append(bool);
    localStringBuilder.append(", expandHall= ");
    localStringBuilder.append(localIExpandHall);
    Logger.a("IniterServiceImpl", localStringBuilder.toString());
    return (!bool) && (localIExpandHall == null);
  }
  
  public LayoutInflater.Factory2 a()
  {
    return new AppLayoutFactory();
  }
  
  public void a(int paramInt)
  {
    boolean bool = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doWhenLaunchYesScenes - ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", isFirstLaunch = ");
    localStringBuilder.append(bool ^ true);
    Logger.a("IniterServiceImpl", localStringBuilder.toString());
    this.b = true;
    if (!bool)
    {
      Logger.a("IniterServiceImpl", "first launch scene, refreshRoomRouteAndResume");
      ((IRoomService)ServiceCenter.a(IRoomService.class)).a();
    }
  }
  
  public void a(Context paramContext) {}
  
  public void a(InitCallback paramInitCallback)
  {
    boolean bool = d();
    if (paramInitCallback != null) {
      paramInitCallback.a(bool);
    }
  }
  
  public void a(OnPAGLibraryLoadedListener paramOnPAGLibraryLoadedListener)
  {
    LibraryInitManager.a.a(paramOnPAGLibraryLoadedListener);
  }
  
  public void a(String paramString)
  {
    boolean bool = f();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkTimiGameRes, ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" - ");
    localStringBuilder.append(bool);
    if (bool) {
      paramString = ", postRunnable";
    } else {
      paramString = "";
    }
    localStringBuilder.append(paramString);
    Logger.a("IniterServiceImpl", localStringBuilder.toString());
    if (bool)
    {
      ThreadPool.b(this.d);
      ThreadPool.a(this.d, 5000L);
    }
  }
  
  public void b()
  {
    Logger.c("IniterServiceImpl", "destroyTg");
    this.b = false;
    this.a = false;
    ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).c();
    ((IRoomService)ServiceCenter.a(IRoomService.class)).b();
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).c();
    ServiceCenter.a();
    YesDataBaseHelper.b();
    if (GuardManager.sInstance != null)
    {
      Logger.a("IniterServiceImpl", "GuardManager.sInstance.unregisterCallback success");
      GuardManager.sInstance.unregisterCallback(this.c);
    }
    else
    {
      Logger.a("IniterServiceImpl", "GuardManager.sInstance.unregisterCallback error");
    }
    if (SmobaConfigManager.a() != null) {
      SmobaConfigManager.a().c();
    }
  }
  
  public void b(OnPAGLibraryLoadedListener paramOnPAGLibraryLoadedListener)
  {
    LibraryInitManager.a.b(paramOnPAGLibraryLoadedListener);
  }
  
  public boolean c()
  {
    return LibraryInitManager.a.a();
  }
  
  public boolean d()
  {
    if (!this.a)
    {
      long l1 = System.currentTimeMillis();
      Logger.a("IniterServiceImpl", 1, "syncEnsureInit START");
      Env.a(MobileQQ.getContext());
      DataBaseTableIniter.a();
      LibraryInitManager.a.a();
      SmobaConfigManager.a();
      ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).a();
      this.c = new TGGroundInterfaceWrapper();
      if (GuardManager.sInstance != null)
      {
        Logger.a("IniterServiceImpl", "GuardManager.sInstance.registerCallBack success");
        GuardManager.sInstance.registerCallBack(this.c);
      }
      else
      {
        Logger.a("IniterServiceImpl", "GuardManager.sInstance.registerCallBack error");
      }
      ServiceCenter.a(BaseApplication.getContext());
      String str = ServerEnv.c();
      long l2 = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("syncEnsureInit END, curSvrName = ");
      localStringBuilder.append(str);
      localStringBuilder.append(" ");
      localStringBuilder.append(l2 - l1);
      localStringBuilder.append("ms");
      Logger.a("IniterServiceImpl", localStringBuilder.toString());
      this.a = true;
    }
    return true;
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.initer.impl.IniterServiceImpl
 * JD-Core Version:    0.7.0.1
 */