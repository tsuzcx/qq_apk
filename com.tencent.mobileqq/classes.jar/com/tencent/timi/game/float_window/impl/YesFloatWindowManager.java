package com.tencent.timi.game.float_window.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.timi.game.float_window.FloatingConfigParams;
import com.tencent.timi.game.float_window.FloatingConfigParams.FloatingBuilder;
import com.tencent.timi.game.float_window.IFloatWindowStatusListener;
import com.tencent.timi.game.utils.FloatingPermission;
import com.tencent.timi.game.utils.Logger;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/impl/YesFloatWindowManager;", "", "()V", "floatItemMap", "", "", "Lcom/tencent/timi/game/float_window/impl/YesFloatWindowManager$FloatingItem;", "getFloatItemMap", "()Ljava/util/Map;", "setFloatItemMap", "(Ljava/util/Map;)V", "floatingStatusReceiver", "Lcom/tencent/timi/game/float_window/impl/FloatingStatusReceiver;", "getFloatingStatusReceiver", "()Lcom/tencent/timi/game/float_window/impl/FloatingStatusReceiver;", "setFloatingStatusReceiver", "(Lcom/tencent/timi/game/float_window/impl/FloatingStatusReceiver;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "addScreenStatusReceiver", "", "listener", "Lcom/tencent/timi/game/float_window/IFloatWindowStatusListener;", "enterWindowFloat", "", "key", "floatParams", "Lcom/tencent/timi/game/float_window/FloatingConfigParams;", "customView", "Landroid/view/View;", "hideFloatingView", "initWidgetWrapper", "isFloatShowing", "", "quitWindowFloat", "closeReason", "removeParent", "childView", "setViewsVisibility", "visible", "views", "", "(Z[Landroid/view/View;)V", "showFloatingView", "updateWindowFloat", "w", "h", "Companion", "FloatingItem", "YesFloatWindowManager", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class YesFloatWindowManager
{
  public static final YesFloatWindowManager.Companion a = new YesFloatWindowManager.Companion(null);
  @NotNull
  private static final String e = "YesFloatWindowManager";
  @NotNull
  private static final YesFloatWindowManager f = YesFloatWindowManager.YesFloatWindowManager.a.a();
  @NotNull
  private Context b;
  @Nullable
  private FloatingStatusReceiver c;
  @NotNull
  private Map<String, YesFloatWindowManager.FloatingItem> d = (Map)new HashMap();
  
  public YesFloatWindowManager()
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    Intrinsics.checkExpressionValueIsNotNull(localMobileQQ, "MobileQQ.sMobileQQ");
    this.b = ((Context)localMobileQQ);
  }
  
  private final void b(String paramString, View paramView)
  {
    YesFloatWindowManager.FloatingItem localFloatingItem = (YesFloatWindowManager.FloatingItem)this.d.get(paramString);
    if (localFloatingItem != null)
    {
      localFloatingItem.b().removeAllViews();
      a(paramString, paramView);
      localFloatingItem.b().addView(paramView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
  }
  
  public final int a(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    paramString = (YesFloatWindowManager.FloatingItem)this.d.get(paramString);
    if (paramString != null) {
      paramString.a().b(paramInt1, paramInt2);
    }
    return 0;
  }
  
  public final int a(@NotNull String paramString, @Nullable FloatingConfigParams paramFloatingConfigParams, @Nullable View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    if (paramView == null) {
      return 2;
    }
    if (!FloatingPermission.a(this.b)) {
      return 1;
    }
    FloatingConfigParams localFloatingConfigParams = paramFloatingConfigParams;
    if (paramFloatingConfigParams == null) {
      localFloatingConfigParams = new FloatingConfigParams.FloatingBuilder().a(true).a();
    }
    if (this.d.get(paramString) == null) {
      this.d.put(paramString, new YesFloatWindowManager.FloatingItem(paramString, null, null, 6, null));
    }
    paramFloatingConfigParams = (YesFloatWindowManager.FloatingItem)this.d.get(paramString);
    if (paramFloatingConfigParams != null)
    {
      b(paramString, paramView);
      a(paramString, (View)paramFloatingConfigParams.b());
      paramFloatingConfigParams.a().a((View)paramFloatingConfigParams.b(), paramView, localFloatingConfigParams);
      b(paramString);
    }
    return 0;
  }
  
  public final void a(@Nullable IFloatWindowStatusListener paramIFloatWindowStatusListener)
  {
    if (this.c == null)
    {
      this.c = new FloatingStatusReceiver(this.b);
      FloatingStatusReceiver localFloatingStatusReceiver = this.c;
      if (localFloatingStatusReceiver != null) {
        localFloatingStatusReceiver.a(paramIFloatWindowStatusListener);
      }
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    YesFloatWindowManager.FloatingItem localFloatingItem = (YesFloatWindowManager.FloatingItem)this.d.get(paramString);
    if (localFloatingItem != null)
    {
      String str = e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideFloatingView ");
      localStringBuilder.append(paramString);
      Logger.a(str, localStringBuilder.toString());
      a(false, new View[] { (View)localFloatingItem.a() });
    }
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    YesFloatWindowManager.FloatingItem localFloatingItem = (YesFloatWindowManager.FloatingItem)this.d.get(paramString);
    if (localFloatingItem != null)
    {
      String str = e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("quitWindowFloat ");
      localStringBuilder.append(paramString);
      Logger.a(str, localStringBuilder.toString());
      if ((localFloatingItem.a() != null) && (localFloatingItem.a().c()))
      {
        a(paramString, (View)localFloatingItem.b());
        if (localFloatingItem.b() != null) {
          localFloatingItem.b().removeAllViews();
        }
        a(false, new View[] { (View)localFloatingItem.a() });
      }
      this.d.remove(paramString);
    }
    if (this.d.isEmpty())
    {
      paramString = this.c;
      if (paramString != null) {
        paramString.a();
      }
      this.c = ((FloatingStatusReceiver)null);
    }
  }
  
  public final void a(@NotNull String paramString, @Nullable View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    if (((YesFloatWindowManager.FloatingItem)this.d.get(paramString) != null) && (paramView != null)) {
      try
      {
        ViewParent localViewParent = paramView.getParent();
        paramString = localViewParent;
        if (!(localViewParent instanceof ViewGroup)) {
          paramString = null;
        }
        paramString = (ViewGroup)paramString;
        if (paramString != null)
        {
          paramString.removeView(paramView);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      catch (ClassCastException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public final void a(boolean paramBoolean, @NotNull View... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "views");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      View localView = paramVarArgs[i];
      if (localView != null) {
        if (paramBoolean) {
          localView.setVisibility(0);
        } else {
          localView.setVisibility(4);
        }
      }
      i += 1;
    }
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    YesFloatWindowManager.FloatingItem localFloatingItem = (YesFloatWindowManager.FloatingItem)this.d.get(paramString);
    if (localFloatingItem != null)
    {
      String str = e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showFloatingView ");
      localStringBuilder.append(paramString);
      Logger.a(str, localStringBuilder.toString());
      a(true, new View[] { (View)localFloatingItem.a() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.YesFloatWindowManager
 * JD-Core Version:    0.7.0.1
 */