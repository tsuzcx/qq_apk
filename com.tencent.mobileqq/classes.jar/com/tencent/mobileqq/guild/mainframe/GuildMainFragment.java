package com.tencent.mobileqq.guild.mainframe;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameGestureManager;
import com.tencent.mobileqq.guild.mainframe.container.GuildContainerController;
import com.tencent.mobileqq.guild.mainframe.helper.GuildMFJumpHelper;
import com.tencent.mobileqq.guild.mainframe.helper.HelperProvider;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildLeftBarController;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildLeftBarController.OnLeftBarItemCountUpdateListener;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildListItemAdapter.ItemCountInfo;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.Logger.ILog;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.widget.NetStatusInfoView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/mainframe/GuildMainFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mobileqq/guild/mainframe/GuildContextProvider;", "Lcom/tencent/mobileqq/guild/mainframe/leftbar/GuildLeftBarController$OnLeftBarItemCountUpdateListener;", "Lcom/tencent/mobileqq/guild/mainframe/IGuildMainFrame;", "()V", "app", "Lcom/tencent/common/app/AppInterface;", "attachContainerController", "Lcom/tencent/mobileqq/guild/mainframe/attachcontainer/GuildAttachContainerController;", "containerController", "Lcom/tencent/mobileqq/guild/mainframe/container/GuildContainerController;", "controllers", "Ljava/util/LinkedHashMap;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/guild/mainframe/GuildMainViewLifeCycle;", "dragFrame", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "guildChatFrameGestureManager", "Lcom/tencent/mobileqq/guild/mainframe/attachcontainer/GuildChatFrameGestureManager;", "hasDestroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "helperProvider", "Lcom/tencent/mobileqq/guild/mainframe/helper/HelperProvider;", "layoutEmpty", "Landroid/view/View;", "leftBarController", "Lcom/tencent/mobileqq/guild/mainframe/leftbar/GuildLeftBarController;", "mainViewContext", "Lcom/tencent/mobileqq/guild/mainframe/GuildMainViewContext;", "netStatusInfoView", "Lcom/tencent/mobileqq/guild/widget/NetStatusInfoView;", "rootView", "tabHeight", "", "getApp", "Lmqq/app/AppRuntime;", "getContainerController", "getDragFrame", "getGuildAttachContainerController", "getGuildChatFrameGestureManager", "getGuildFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getHelper", "", "type", "getLeftBarController", "getMainViewContext", "guildAttachContainerInOrOut", "", "isIn", "", "isPlayAnim", "handleJumpAction", "extra", "Landroid/os/Bundle;", "message", "Lkotlin/Lazy;", "", "method", "notifyAfterAccountChanged", "isSwitchAccount", "notifyBeforeAccountChanged", "notifyCreate", "notifyDestroy", "notifyOnActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "notifyOnBackPressed", "notifyPause", "notifyResume", "tabChanged", "notifyStart", "notifyStop", "observerUserInfo", "tinyId", "onCreate", "savedInstanceState", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onLeftBarItemCountUpdate", "countInfo", "Lcom/tencent/mobileqq/guild/mainframe/leftbar/GuildListItemAdapter$ItemCountInfo;", "onPause", "onPostThemeChanged", "height", "onResume", "onStart", "onStop", "realDestroy", "setTabHeight", "updateSelectPicker", "Companion", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class GuildMainFragment
  extends ReportAndroidXFragment
  implements GuildContextProvider, IGuildMainFrame, GuildLeftBarController.OnLeftBarItemCountUpdateListener
{
  public static final GuildMainFragment.Companion a = new GuildMainFragment.Companion(null);
  private GuildMainViewContext b;
  private HelperProvider c;
  private GuildLeftBarController d;
  private GuildContainerController e;
  private GuildAttachContainerController f;
  private GuildChatFrameGestureManager g;
  private DragFrameLayout h;
  private NetStatusInfoView i;
  private View j;
  private View k;
  private AppInterface l;
  private final LinkedHashMap<Class<? extends GuildMainViewLifeCycle>, GuildMainViewLifeCycle> m = new LinkedHashMap();
  private final AtomicBoolean n = new AtomicBoolean(false);
  private int o;
  private HashMap p;
  
  private final void a(Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringArrayExtra("select_member_list");
    } else {
      paramIntent = null;
    }
    int i2 = 1;
    int i1 = i2;
    if (paramIntent != null)
    {
      if (paramIntent.length == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        i1 = i2;
      } else {
        i1 = 0;
      }
    }
    if (i1 != 0) {
      return;
    }
    paramIntent = paramIntent[0];
    try
    {
      Object localObject1 = this.l;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("app");
      }
      localObject1 = (IQQGuildAvatarApi)((AppInterface)localObject1).getRuntimeService(IQQGuildAvatarApi.class, "");
      Object localObject2 = this.l;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("app");
      }
      localObject1 = ((IQQGuildAvatarApi)localObject1).getAvatarDrawable((AppRuntime)localObject2, paramIntent);
      localObject2 = this.l;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("app");
      }
      localObject2 = ((IGPSService)((AppInterface)localObject2).getRuntimeService(IGPSService.class, "")).getGuildUserNick(paramIntent);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        Intrinsics.checkExpressionValueIsNotNull(paramIntent, "tinyId");
        a(paramIntent);
      }
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setSelectMember(paramIntent, (String)localObject2, (Drawable)localObject1);
      return;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  private final void a(String paramString)
  {
    try
    {
      paramString = (GPServiceObserver)new GuildMainFragment.observerUserInfo.mGpsObserver.1(this, paramString);
      AppInterface localAppInterface = this.l;
      if (localAppInterface == null) {
        Intrinsics.throwUninitializedPropertyAccessException("app");
      }
      ((IGPSService)localAppInterface.getRuntimeService(IGPSService.class, "")).addObserver(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private final Lazy<String> b(String paramString)
  {
    return GuildDebugUtils.a.a((Fragment)this, "GuildMainFragment", paramString);
  }
  
  private final void q()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = b("realDestroy");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    localObject2 = ((Map)this.m).entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((GuildMainViewLifeCycle)((Map.Entry)((Iterator)localObject2).next()).getValue()).e();
    }
    localObject2 = this.i;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("netStatusInfoView");
    }
    ((NetStatusInfoView)localObject2).c();
    localObject2 = this.g;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("guildChatFrameGestureManager");
    }
    ((GuildChatFrameGestureManager)localObject2).a();
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  @Nullable
  public Object a(int paramInt)
  {
    HelperProvider localHelperProvider = this.c;
    if (localHelperProvider == null) {
      Intrinsics.throwUninitializedPropertyAccessException("helperProvider");
    }
    return localHelperProvider.a(paramInt);
  }
  
  public final void a()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = b("notifyCreate");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    localObject2 = ((Map)this.m).entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((GuildMainViewLifeCycle)((Map.Entry)((Iterator)localObject2).next()).getValue()).f();
    }
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  public final void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(paramIntent);
    localObject1 = b(((StringBuilder)localObject1).toString());
    Object localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    a(paramIntent);
    paramIntent = Unit.INSTANCE;
    paramIntent = Logger.a;
    if (QLog.isColorLevel())
    {
      paramIntent = paramIntent.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)((Lazy)localObject1).getValue());
      ((StringBuilder)localObject2).append(" end...");
      paramIntent.a("VASH_DEBUG", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void a(@Nullable Bundle paramBundle)
  {
    Object localObject = a(GuildMainFrameConstants.c);
    if (localObject != null)
    {
      ((GuildMFJumpHelper)localObject).a(paramBundle);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.guild.mainframe.helper.GuildMFJumpHelper");
  }
  
  public void a(@NotNull GuildListItemAdapter.ItemCountInfo paramItemCountInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramItemCountInfo, "countInfo");
    Object localObject = this.j;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("layoutEmpty");
    }
    int i1 = paramItemCountInfo.a();
    int i2 = 0;
    if (i1 == 0) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((View)localObject).setVisibility(i1);
    localObject = QRoute.api(IQQGuildRouterApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IQQGuildRouterApi::class.java)");
    boolean bool = ((IQQGuildRouterApi)localObject).isShowGuildTab();
    i1 = i2;
    if (paramItemCountInfo.a(3) == paramItemCountInfo.a()) {
      i1 = 1;
    }
    if ((i1 != 0) && (bool))
    {
      paramItemCountInfo = this.b;
      if (paramItemCountInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
      }
      paramItemCountInfo.a(4, null);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = b("notifyResume");
    Object localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)((Lazy)localObject1).getValue());
      ((StringBuilder)localObject3).append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, ((StringBuilder)localObject3).toString());
    }
    localObject2 = ((Map)this.m).entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((GuildMainViewLifeCycle)((Map.Entry)((Iterator)localObject2).next()).getValue()).a(paramBoolean);
    }
    localObject2 = this.i;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("netStatusInfoView");
    }
    ((NetStatusInfoView)localObject2).a(paramBoolean);
    localObject2 = (IGuildTempApi)QRoute.api(IGuildTempApi.class);
    Object localObject3 = this.b;
    if (localObject3 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
    }
    ((IGuildTempApi)localObject2).adjustTab(((GuildMainViewContext)localObject3).b());
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)((Lazy)localObject1).getValue());
      ((StringBuilder)localObject3).append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, ((StringBuilder)localObject3).toString());
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      localGuildAttachContainerController = this.f;
      if (localGuildAttachContainerController == null) {
        Intrinsics.throwUninitializedPropertyAccessException("attachContainerController");
      }
      localGuildAttachContainerController.e(paramBoolean1);
      return;
    }
    GuildAttachContainerController localGuildAttachContainerController = this.f;
    if (localGuildAttachContainerController == null) {
      Intrinsics.throwUninitializedPropertyAccessException("attachContainerController");
    }
    localGuildAttachContainerController.d(paramBoolean1);
  }
  
  public final void b()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = b("notifyStart");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    localObject2 = ((Map)this.m).entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((GuildMainViewLifeCycle)((Map.Entry)((Iterator)localObject2).next()).getValue()).b();
    }
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = b("onPostThemeChanged()");
    Object localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)((Lazy)localObject1).getValue());
      ((StringBuilder)localObject3).append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, ((StringBuilder)localObject3).toString());
    }
    if (paramInt != -1) {
      c(paramInt);
    }
    localObject2 = (ImmersiveTitleBar2)null;
    Object localObject3 = requireActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "requireActivity()");
    SimpleUIUtil.a((ImmersiveTitleBar2)localObject2, ((FragmentActivity)localObject3).getWindow());
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)((Lazy)localObject1).getValue());
      ((StringBuilder)localObject3).append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, ((StringBuilder)localObject3).toString());
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("notifyAfterAccountChanged(");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(')');
    localObject1 = b(((StringBuilder)localObject1).toString());
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    localObject2 = ((Map)this.m).entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((GuildMainViewLifeCycle)((Map.Entry)((Iterator)localObject2).next()).getValue()).b(paramBoolean);
    }
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  public final void c()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = b("notifyPause");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    localObject2 = ((Map)this.m).entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((GuildMainViewLifeCycle)((Map.Entry)((Iterator)localObject2).next()).getValue()).c();
    }
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt == this.o) {
      return;
    }
    this.o = paramInt;
    View localView = this.k;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localView.setPadding(0, 0, 0, 0);
  }
  
  @NotNull
  public GuildMainViewContext cw_()
  {
    GuildMainViewContext localGuildMainViewContext = this.b;
    if (localGuildMainViewContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
    }
    return localGuildMainViewContext;
  }
  
  public final void d()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = b("notifyStop");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    localObject2 = ((Map)this.m).entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((GuildMainViewLifeCycle)((Map.Entry)((Iterator)localObject2).next()).getValue()).d();
    }
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  public final void f()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = b("notifyDestroy");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    if (this.n.compareAndSet(false, true)) {
      q();
    }
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  @NotNull
  public AppRuntime g()
  {
    AppInterface localAppInterface = QQGuildUtil.g();
    Intrinsics.checkExpressionValueIsNotNull(localAppInterface, "QQGuildUtil.appInterface()");
    return (AppRuntime)localAppInterface;
  }
  
  public final void h()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = b("notifyBeforeAccountChanged()");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    localObject2 = ((Map)this.m).entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((GuildMainViewLifeCycle)((Map.Entry)((Iterator)localObject2).next()).getValue()).g();
    }
    localObject2 = this.b;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
    }
    ((GuildMainViewContext)localObject2).a(4, null);
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  public final boolean i()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = b("notifyOnBackPressed");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    boolean bool = false;
    localObject2 = ((Map)this.m).entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (((GuildMainViewLifeCycle)((Map.Entry)((Iterator)localObject2).next()).getValue()).h()) {
        bool = true;
      }
    }
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  @NotNull
  public GuildLeftBarController j()
  {
    GuildLeftBarController localGuildLeftBarController = this.d;
    if (localGuildLeftBarController == null) {
      Intrinsics.throwUninitializedPropertyAccessException("leftBarController");
    }
    return localGuildLeftBarController;
  }
  
  public void k()
  {
    HashMap localHashMap = this.p;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  @NotNull
  public GuildContainerController l()
  {
    GuildContainerController localGuildContainerController = this.e;
    if (localGuildContainerController == null) {
      Intrinsics.throwUninitializedPropertyAccessException("containerController");
    }
    return localGuildContainerController;
  }
  
  @NotNull
  public GuildAttachContainerController m()
  {
    GuildAttachContainerController localGuildAttachContainerController = this.f;
    if (localGuildAttachContainerController == null) {
      Intrinsics.throwUninitializedPropertyAccessException("attachContainerController");
    }
    return localGuildAttachContainerController;
  }
  
  @NotNull
  public GuildChatFrameGestureManager n()
  {
    GuildChatFrameGestureManager localGuildChatFrameGestureManager = this.g;
    if (localGuildChatFrameGestureManager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("guildChatFrameGestureManager");
    }
    return localGuildChatFrameGestureManager;
  }
  
  @NotNull
  public DragFrameLayout o()
  {
    DragFrameLayout localDragFrameLayout = this.h;
    if (localDragFrameLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("dragFrame");
    }
    return localDragFrameLayout;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = QQGuildUtil.g();
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "QQGuildUtil.appInterface()");
    this.l = paramBundle;
    this.b = new GuildMainViewContext((GuildContextProvider)this);
    paramBundle = this.b;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
    }
    this.c = new HelperProvider(paramBundle);
    paramBundle = this.b;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
    }
    this.d = new GuildLeftBarController(paramBundle, (GuildLeftBarController.OnLeftBarItemCountUpdateListener)this);
    paramBundle = this.b;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
    }
    this.e = new GuildContainerController(paramBundle);
    paramBundle = this.b;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
    }
    this.f = new GuildAttachContainerController(paramBundle);
    paramBundle = this.b;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
    }
    this.g = new GuildChatFrameGestureManager(paramBundle);
    paramBundle = (Map)this.m;
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("helperProvider");
    }
    paramBundle.put(HelperProvider.class, localObject);
    paramBundle = (Map)this.m;
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("leftBarController");
    }
    paramBundle.put(GuildLeftBarController.class, localObject);
    paramBundle = (Map)this.m;
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("containerController");
    }
    paramBundle.put(GuildContainerController.class, localObject);
    paramBundle = (Map)this.m;
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("attachContainerController");
    }
    paramBundle.put(GuildAttachContainerController.class, localObject);
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramBundle = GuildDebugUtils.a;
    paramBundle = b("onCreateView");
    Object localObject = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject = ((Logger)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)paramBundle.getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    paramLayoutInflater = paramLayoutInflater.inflate(2131625041, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "inflater.inflate(R.layou…e_main, container, false)");
    this.k = paramLayoutInflater;
    paramLayoutInflater = this.k;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    paramLayoutInflater = paramLayoutInflater.findViewById(2131447739);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "rootView.findViewById(R.…top_net_status_info_view)");
    this.i = ((NetStatusInfoView)paramLayoutInflater);
    paramLayoutInflater = this.k;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    paramLayoutInflater = paramLayoutInflater.findViewById(2131432160);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "rootView.findViewById(R.id.dragframe)");
    this.h = ((DragFrameLayout)paramLayoutInflater);
    paramLayoutInflater = this.k;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    paramLayoutInflater = paramLayoutInflater.findViewById(2131436915);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "rootView.findViewById(R.id.layout_empty)");
    this.j = paramLayoutInflater;
    paramLayoutInflater = (ImmersiveTitleBar2)null;
    paramViewGroup = requireActivity();
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "requireActivity()");
    SimpleUIUtil.a(paramLayoutInflater, paramViewGroup.getWindow());
    paramLayoutInflater = this.g;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("guildChatFrameGestureManager");
    }
    paramViewGroup = this.k;
    if (paramViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localObject = this.k;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    paramLayoutInflater.a(paramViewGroup, ((View)localObject).findViewById(2131430657));
    paramLayoutInflater = this.e;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("containerController");
    }
    paramViewGroup = this.k;
    if (paramViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    paramLayoutInflater.a(paramViewGroup.findViewById(2131434689));
    paramLayoutInflater = this.d;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("leftBarController");
    }
    paramViewGroup = this.k;
    if (paramViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    paramLayoutInflater.a(paramViewGroup.findViewById(2131437137));
    paramLayoutInflater = this.f;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("attachContainerController");
    }
    paramViewGroup = this.k;
    if (paramViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    paramLayoutInflater.a(paramViewGroup.findViewById(2131430657));
    paramLayoutInflater = this.k;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    paramViewGroup = Logger.a;
    if (QLog.isColorLevel())
    {
      paramViewGroup = paramViewGroup.a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((String)paramBundle.getValue());
      ((StringBuilder)localObject).append(" end...");
      paramViewGroup.a("VASH_DEBUG", 2, ((StringBuilder)localObject).toString());
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = b("onDestroyView()");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    super.onDestroyView();
    if (this.n.compareAndSet(false, true)) {
      q();
    }
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    k();
  }
  
  public void onPause()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = b("onPause()");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    super.onPause();
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  public void onResume()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = b("onResume()");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    super.onResume();
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  public void onStart()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = b("onStart()");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    super.onStart();
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  public void onStop()
  {
    Object localObject1 = GuildDebugUtils.a;
    localObject1 = b("onStop()");
    Object localObject2 = Logger.a;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" begin...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
    super.onStop();
    localObject2 = Unit.INSTANCE;
    localObject2 = Logger.a;
    if (QLog.isColorLevel())
    {
      localObject2 = ((Logger)localObject2).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)((Lazy)localObject1).getValue());
      localStringBuilder.append(" end...");
      ((Logger.ILog)localObject2).a("VASH_DEBUG", 2, localStringBuilder.toString());
    }
  }
  
  @NotNull
  public FragmentManager p()
  {
    if (isDetached())
    {
      localObject = Logger.a;
      if (QLog.isColorLevel()) {
        ((Logger)localObject).a().a("GuildMainFragment", 2, "getGuildFragmentManager, return NullObject FragmentManager");
      }
      return (FragmentManager)new GuildMainFragment.getGuildFragmentManager.2();
    }
    Object localObject = getChildFragmentManager();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "childFragmentManager");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.GuildMainFragment
 * JD-Core Version:    0.7.0.1
 */