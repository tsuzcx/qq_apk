package com.tencent.timi.game.float_window;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.app.event.AppBecomeBackgroundEvent;
import com.tencent.timi.game.app.event.AppBecomeForegroundEvent;
import com.tencent.timi.game.float_window.impl.YesFloatWindowManager;
import com.tencent.timi.game.float_window.impl.YesFloatWindowManager.Companion;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/BusFloatManager;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "backgrounding", "", "floatShowingStatusMap", "", "", "floatStatusListener", "Lcom/tencent/timi/game/float_window/IFloatWindowStatusListener;", "floatingViewMap", "Lcom/tencent/timi/game/float_window/IFloatView;", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getTeamFloatingAnimateInfo", "Lcom/tencent/timi/game/float_window/FloatingAnimateInfo;", "roomId", "hideFloatWindow", "", "onReceiveEvent", "simpleBaseEvent", "releaseFloatWindow", "showFloatWindow", "creator", "Lcom/tencent/timi/game/float_window/IFloatViewCreator;", "updateSize", "w", "", "h", "BusFloatManager", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BusFloatManager
  implements SimpleEventReceiver<SimpleBaseEvent>
{
  public static final BusFloatManager.Companion a = new BusFloatManager.Companion(null);
  @NotNull
  private static final BusFloatManager f = BusFloatManager.BusFloatManager.a.a();
  private boolean b;
  private IFloatWindowStatusListener c = (IFloatWindowStatusListener)new BusFloatManager.floatStatusListener.1(this);
  private Map<String, IFloatView> d = (Map)new HashMap();
  private final Map<String, Boolean> e = (Map)new HashMap();
  
  public BusFloatManager()
  {
    SimpleEventBus.getInstance().registerReceiver((SimpleEventReceiver)this);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "roomId");
    if (this.d.get(paramString) != null)
    {
      String str = YesFloatWindowManager.a.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideFloatWindow ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" , backgrounding:");
      localStringBuilder.append(this.b);
      Logger.a(str, localStringBuilder.toString());
      ((IFloatWindowService)ServiceCenter.a(IFloatWindowService.class)).b(paramString.toString());
      this.e.put(paramString, Boolean.valueOf(false));
      paramString = (IFloatView)this.d.get(paramString);
      if (paramString != null) {
        paramString.b();
      }
    }
  }
  
  public final void a(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "roomId");
    if ((IFloatView)this.d.get(paramString) != null) {
      ((IFloatWindowService)ServiceCenter.a(IFloatWindowService.class)).a(paramString.toString(), paramInt1, paramInt2);
    }
  }
  
  public final void a(@NotNull String paramString, @Nullable IFloatViewCreator paramIFloatViewCreator)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "roomId");
    Object localObject = this.d.get(paramString);
    Boolean localBoolean = Boolean.valueOf(true);
    if (localObject != null)
    {
      paramIFloatViewCreator = YesFloatWindowManager.a.a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showFloatWindow ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" , backgrounding:");
      ((StringBuilder)localObject).append(this.b);
      Logger.a(paramIFloatViewCreator, ((StringBuilder)localObject).toString());
      if ((this.b) && (!QBaseActivity.mAppForground))
      {
        this.b = true;
      }
      else
      {
        this.b = false;
        ((IFloatWindowService)ServiceCenter.a(IFloatWindowService.class)).a(paramString.toString());
        paramIFloatViewCreator = (IFloatView)this.d.get(paramString);
        if (paramIFloatViewCreator != null) {
          paramIFloatViewCreator.a();
        }
      }
      this.e.put(paramString, localBoolean);
    }
    else
    {
      if (paramIFloatViewCreator != null) {
        paramIFloatViewCreator = paramIFloatViewCreator.a(paramString);
      } else {
        paramIFloatViewCreator = null;
      }
      if (paramIFloatViewCreator != null)
      {
        ((IFloatWindowService)ServiceCenter.a(IFloatWindowService.class)).a(paramString.toString(), paramIFloatViewCreator.getFloatingConfigParams(), paramIFloatViewCreator.getView());
        this.d.put(paramString, paramIFloatViewCreator);
        this.e.put(paramString, localBoolean);
        paramIFloatViewCreator.c();
        if ((this.b) && (!QBaseActivity.mAppForground))
        {
          this.b = true;
          ((IFloatWindowService)ServiceCenter.a(IFloatWindowService.class)).b(paramString.toString());
        }
        else
        {
          this.b = false;
          paramIFloatViewCreator.a();
        }
      }
    }
    if ((this.d.isEmpty() ^ true)) {
      ((IFloatWindowService)ServiceCenter.a(IFloatWindowService.class)).a(this.c);
    }
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "roomId");
    if (this.d.get(paramString) != null)
    {
      Object localObject = YesFloatWindowManager.a.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("releaseFloatWindow ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" , backgrounding:");
      localStringBuilder.append(this.b);
      Logger.a((String)localObject, localStringBuilder.toString());
      ((IFloatWindowService)ServiceCenter.a(IFloatWindowService.class)).a(paramString.toString(), 0);
      localObject = (IFloatView)this.d.remove(paramString);
      if (localObject != null) {
        ((IFloatView)localObject).d();
      }
      this.e.remove(paramString);
    }
  }
  
  @NotNull
  public final FloatingAnimateInfo c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "roomId");
    paramString = (IFloatView)this.d.get(paramString);
    if (paramString != null) {
      return paramString.getAnimateInfo();
    }
    return FloatingAnimateInfo.a.a();
  }
  
  @NotNull
  public ArrayList<Class<SimpleBaseEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AppBecomeForegroundEvent.class);
    localArrayList.add(AppBecomeBackgroundEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(@Nullable SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AppBecomeForegroundEvent))
    {
      Logger.a(YesFloatWindowManager.a.a(), "AppBecomeForegroundEvent called");
      paramSimpleBaseEvent = this.d.entrySet().iterator();
      while (paramSimpleBaseEvent.hasNext()) {
        ((IFloatView)((Map.Entry)paramSimpleBaseEvent.next()).getValue()).f();
      }
    }
    if ((paramSimpleBaseEvent instanceof AppBecomeBackgroundEvent))
    {
      Logger.a(YesFloatWindowManager.a.a(), "AppBecomeBackgroundEvent called");
      paramSimpleBaseEvent = this.d.entrySet().iterator();
      while (paramSimpleBaseEvent.hasNext()) {
        ((IFloatView)((Map.Entry)paramSimpleBaseEvent.next()).getValue()).e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.BusFloatManager
 * JD-Core Version:    0.7.0.1
 */