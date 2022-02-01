package com.tencent.timi.game.teamlist.service;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.timi.game.app.event.AppBecomeBackgroundEvent;
import com.tencent.timi.game.app.event.AppBecomeForegroundEvent;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.teamlist.model.BatchUpdateTeamListServlet;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import trpc.yes.common.PremadesTeamServerOuterClass.RefreshAPIRsp;
import trpc.yes.common.PremadesTeamServerOuterClass.UserOnlineRouteInfoList;

public class TeamInfoAutoUpdateService
  implements SimpleEventReceiver
{
  private static TeamInfoAutoUpdateService c;
  private boolean a = false;
  private TeamInfoAutoUpdateService.TimerHelper b = new TeamInfoAutoUpdateService.TimerHelper(this, null);
  private boolean d = true;
  private ConcurrentHashMap<String, TeamInfoAutoUpdateService.AutoUpdateServiceListener> e = new ConcurrentHashMap();
  private HashMap<Long, PremadesTeamServerOuterClass.UserOnlineRouteInfoList> f = new HashMap();
  
  public static TeamInfoAutoUpdateService a()
  {
    try
    {
      if (c == null) {
        c = new TeamInfoAutoUpdateService();
      }
      TeamInfoAutoUpdateService localTeamInfoAutoUpdateService = c;
      return localTeamInfoAutoUpdateService;
    }
    finally {}
  }
  
  private void d()
  {
    try
    {
      if (this.a)
      {
        Logger.c("TeamInfoAutoUpdateService", "doUpdate频次控制当前请求未完成");
        return;
      }
      Object localObject3 = new HashSet();
      Object localObject1 = new HashSet();
      Object localObject4 = this.e.entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
        ((Set)localObject3).addAll(((TeamInfoAutoUpdateService.AutoUpdateServiceListener)localEntry.getValue()).a());
        ((Set)localObject1).addAll(((TeamInfoAutoUpdateService.AutoUpdateServiceListener)localEntry.getValue()).b());
      }
      localObject4 = new ArrayList();
      ((List)localObject4).addAll((Collection)localObject3);
      localObject3 = new ArrayList();
      ((List)localObject3).addAll((Collection)localObject1);
      if ((((List)localObject4).isEmpty()) && (((List)localObject3).isEmpty()))
      {
        Logger.b("TeamInfoAutoUpdateService", "无可见Team");
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("发起请求, teamIdList.size:");
      ((StringBuilder)localObject1).append(((List)localObject4).size());
      ((StringBuilder)localObject1).append(", uidList.size:");
      ((StringBuilder)localObject1).append(((List)localObject3).size());
      Logger.b("TeamInfoAutoUpdateService", ((StringBuilder)localObject1).toString());
      this.a = true;
      ((NetApi)ServiceCenter.a(NetApi.class)).a(BatchUpdateTeamListServlet.a((List)localObject4, (List)localObject3), PremadesTeamServerOuterClass.RefreshAPIRsp.class, new TeamInfoAutoUpdateService.1(this, (List)localObject3, (List)localObject4));
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void e()
  {
    try
    {
      Logger.b("TeamInfoAutoUpdateService", "startUpdate");
      if (!this.d)
      {
        Logger.b("TeamInfoAutoUpdateService", "AppNotForeGroundExit");
        return;
      }
      if (this.e.size() == 0)
      {
        Logger.b("TeamInfoAutoUpdateService", "NoListenerExit");
        return;
      }
      this.b.b();
      return;
    }
    finally {}
  }
  
  public PremadesTeamServerOuterClass.UserOnlineRouteInfoList a(long paramLong)
  {
    return (PremadesTeamServerOuterClass.UserOnlineRouteInfoList)this.f.get(Long.valueOf(paramLong));
  }
  
  public void a(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unregTeamInfoAutoUpdate requestScene = ");
      localStringBuilder.append(paramString);
      Logger.b("TeamInfoAutoUpdateService", localStringBuilder.toString());
      this.e.remove(paramString);
      if (this.e.size() == 0)
      {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        c();
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, TeamInfoAutoUpdateService.AutoUpdateServiceListener paramAutoUpdateServiceListener)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("regTeamInfoAutoUpdate requestScene = ");
      localStringBuilder.append(paramString);
      Logger.b("TeamInfoAutoUpdateService", localStringBuilder.toString());
      this.e.put(paramString, paramAutoUpdateServiceListener);
      if (this.e.size() == 1)
      {
        SimpleEventBus.getInstance().registerReceiver(this);
        e();
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b()
  {
    this.f.clear();
  }
  
  public void c()
  {
    try
    {
      Logger.b("TeamInfoAutoUpdateService", "stopUpdate");
      this.b.c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AppBecomeForegroundEvent.class);
    localArrayList.add(AppBecomeBackgroundEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AppBecomeForegroundEvent))
    {
      Logger.a("TeamInfoAutoUpdateService", "AppBecomeForegroundEvent called");
      this.d = true;
      e();
      return;
    }
    if ((paramSimpleBaseEvent instanceof AppBecomeBackgroundEvent))
    {
      Logger.a("TeamInfoAutoUpdateService", "AppBecomeBackgroundEvent called");
      this.d = false;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService
 * JD-Core Version:    0.7.0.1
 */