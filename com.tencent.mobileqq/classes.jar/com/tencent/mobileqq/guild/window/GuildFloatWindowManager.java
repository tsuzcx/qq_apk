package com.tencent.mobileqq.guild.window;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.qqfloatingwindow.FloatingBaseProxyWrapper;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/window/GuildFloatWindowManager;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "()V", "TAG", "", "floatWindowStatusMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isApplicationForeground", "isInitCallbacks", "checkFloatWindowPermission", "context", "Landroid/content/Context;", "getFloatWindowChannelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "className", "getFloatingWindowWrapper", "Lcom/tencent/mobileqq/qqfloatingwindow/FloatingBaseProxyWrapper;", "hideGuildFloatWindow", "", "isApplicationProcessForeground", "isShowGuildFloatWindow", "onApplicationBackground", "onApplicationForeground", "onBackgroundTimeTick", "tick", "", "onBackgroundUnguardTimeTick", "onLiteTimeTick", "onScreensStateChanged", "isEnabled", "registerCallback", "showGuildFloatWindow", "customView", "Landroid/view/View;", "params", "Lcom/tencent/mobileqq/qqfloatingwindow/FloatingScreenParams;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "channelInfo", "unregisterCallback", "updateFloatWindowDisplayStatus", "display", "updateFloatWindowLocation", "centerX", "", "centerY", "updateFloatWindowSize", "width", "height", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class GuildFloatWindowManager
  implements IGuardInterface
{
  public static final GuildFloatWindowManager a = new GuildFloatWindowManager();
  private static final HashMap<String, Boolean> b = new HashMap();
  private static boolean c;
  private static boolean d = true;
  
  private final void a(String paramString, boolean paramBoolean)
  {
    ((Map)b).put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  private final void b()
  {
    if (c) {
      return;
    }
    QLog.i("GuildFloatWindowManager", 1, "registerCallback:");
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.registerCallBack((IGuardInterface)this);
    }
    c = true;
  }
  
  private final void c()
  {
    if (!c) {
      return;
    }
    QLog.i("GuildFloatWindowManager", 1, "unregisterCallback:");
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.unregisterCallback((IGuardInterface)this);
    }
    c = false;
  }
  
  private final FloatingBaseProxyWrapper d(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    return ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).getFloatingProxyWrapper((Context)localBaseApplication, paramString);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "className");
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(paramString);
    int j = 0;
    int i = 0;
    a(paramString, false);
    if (b.size() > 0)
    {
      paramString = b.values();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "floatWindowStatusMap.values");
      paramString = ((Iterable)paramString).iterator();
      for (;;)
      {
        j = i;
        if (!paramString.hasNext()) {
          break;
        }
        Boolean localBoolean = (Boolean)paramString.next();
        Intrinsics.checkExpressionValueIsNotNull(localBoolean, "it");
        if (localBoolean.booleanValue()) {
          i = 1;
        }
      }
    }
    if (j == 0) {
      c();
    }
  }
  
  public final boolean a()
  {
    return d;
  }
  
  public final boolean a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(paramContext);
  }
  
  public final boolean a(@NotNull View paramView, @NotNull String paramString, @NotNull FloatingScreenParams paramFloatingScreenParams, @NotNull IGProGuildInfo paramIGProGuildInfo, @NotNull IGProChannelInfo paramIGProChannelInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "customView");
    Intrinsics.checkParameterIsNotNull(paramString, "className");
    Intrinsics.checkParameterIsNotNull(paramFloatingScreenParams, "params");
    Intrinsics.checkParameterIsNotNull(paramIGProGuildInfo, "guildInfo");
    Intrinsics.checkParameterIsNotNull(paramIGProChannelInfo, "channelInfo");
    Object localObject = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "floatContext");
    localObject = (Context)localObject;
    if (!a((Context)localObject)) {
      return false;
    }
    FloatingBaseProxyWrapper localFloatingBaseProxyWrapper = d(paramString);
    if (localFloatingBaseProxyWrapper != null) {
      if (localFloatingBaseProxyWrapper != null) {
        ((IGuildFloatWindowWrapper)localFloatingBaseProxyWrapper).a(paramIGProGuildInfo, paramIGProChannelInfo);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.guild.window.IGuildFloatWindowWrapper");
      }
    }
    if (((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).enterCustomFloatingScreen((Context)localObject, paramView, paramFloatingScreenParams, paramString, 0) == 0)
    {
      a(paramString, true);
      b();
      return true;
    }
    return false;
  }
  
  public final boolean b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "className");
    boolean bool3 = b.containsKey(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramString = (Boolean)b.get(paramString);
      bool1 = bool2;
      if (paramString != null) {
        bool1 = paramString.booleanValue();
      }
    }
    return bool1;
  }
  
  @Nullable
  public final IGProChannelInfo c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "className");
    if (!b(paramString)) {
      return null;
    }
    paramString = d(paramString);
    if (paramString != null)
    {
      if (paramString != null) {
        return ((IGuildFloatWindowWrapper)paramString).b();
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.guild.window.IGuildFloatWindowWrapper");
    }
    return null;
  }
  
  public void onApplicationBackground()
  {
    QLog.i("GuildFloatWindowManager", 1, "onApplicationBackground:");
    d = false;
  }
  
  public void onApplicationForeground()
  {
    QLog.i("GuildFloatWindowManager", 1, "onApplicationForeground:");
    d = true;
  }
  
  public void onBackgroundTimeTick(long paramLong) {}
  
  public void onBackgroundUnguardTimeTick(long paramLong) {}
  
  public void onLiteTimeTick(long paramLong) {}
  
  public void onScreensStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.window.GuildFloatWindowManager
 * JD-Core Version:    0.7.0.1
 */