package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.falco.base.floatwindow.permission.FWPermission;
import com.tencent.falco.base.libapi.network.NetworkStateInterface;
import com.tencent.falco.base.libapi.network.OnNetworkListener;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.ilive.base.component.ComponentFactory;
import com.tencent.ilive.base.component.ComponentFactory.ComponentsBuilder;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.base.event.ModuleEventInterface;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowHandleCallback;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.livesdk.liveengine.FloatRoomManager;
import com.tencent.livesdk.liveengine.FloatRoomManager.RoomEventInterceptor;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.event.MultiVoicePageEvent;
import com.tencent.mobileqq.now.utils.UrlUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/intervideo/lite_now_biz/mutil_voice/MultiVoiceFloatingWindowModule;", "Lcom/tencent/ilive/pages/room/bizmodule/RoomBizModule;", "Lcom/tencent/falco/utils/ThreadCenter$HandlerKeyable;", "()V", "TAG", "", "floatWindowComponent", "Lcom/tencent/ilive/uicomponent/floatwindowcomponent_interface/FloatWindowComponent;", "isActivityVisible", "", "isFloatingWindowDisable", "isFloatingWindowShowing", "isWebReady", "launchFailNotice", "Ljava/lang/Runnable;", "launchFailNoticeForXiaomi", "multiVoicePageObserver", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mobileqq/intervideo/lite_now_biz/mutil_voice/event/MultiVoicePageEvent;", "networkService", "Lcom/tencent/falco/base/libapi/network/NetworkStateInterface;", "onDestroyCalled", "onNetworkListener", "Lcom/tencent/falco/base/libapi/network/OnNetworkListener;", "roomEventInterceptor", "Lcom/tencent/livesdk/liveengine/FloatRoomManager$RoomEventInterceptor;", "switchRoomInfo", "Lcom/tencent/ilivesdk/roomswitchservice_interface/SwitchRoomInfo;", "textView", "Landroid/widget/TextView;", "backToRoom", "", "showExitRoomNoticeDialog", "dismissFloatingWindow", "getFloatRoomManager", "Lcom/tencent/livesdk/liveengine/FloatRoomManager;", "kotlin.jvm.PlatformType", "hasFloatingWindowPermission", "isActivityDestroyed", "isXiaomi", "onActivityDestroy", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onActivityStart", "onActivityStop", "onCreate", "context", "Landroid/content/Context;", "onDestroy", "onEnterRoom", "isOutEnter", "onExtActive", "onExtDeActive", "onSwitchRoom", "onVisibleToUser", "isVisibleToUser", "removeLaunchTask", "showExitRoomNoticeIfNeeded", "showFloatingWindow", "Companion", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class MultiVoiceFloatingWindowModule
  extends RoomBizModule
  implements ThreadCenter.HandlerKeyable
{
  public static final MultiVoiceFloatingWindowModule.Companion a = new MultiVoiceFloatingWindowModule.Companion(null);
  private static boolean q;
  private final String b = "MultiVoiceFloatingWindowModule";
  private FloatWindowComponent c;
  private boolean d;
  private SwitchRoomInfo e;
  private FloatRoomManager.RoomEventInterceptor f;
  private boolean g;
  private boolean h = true;
  private boolean i;
  private TextView j;
  private NetworkStateInterface k;
  private boolean l;
  private final OnNetworkListener m = (OnNetworkListener)new MultiVoiceFloatingWindowModule.onNetworkListener.1(this);
  private final Runnable n = (Runnable)new MultiVoiceFloatingWindowModule.launchFailNoticeForXiaomi.1(this);
  private final Runnable o = (Runnable)new MultiVoiceFloatingWindowModule.launchFailNotice.1(this);
  private final Observer<MultiVoicePageEvent> p = (Observer)new MultiVoiceFloatingWindowModule.multiVoicePageObserver.1(this);
  
  private final boolean a()
  {
    Context localContext = this.context;
    if ((localContext instanceof Activity)) {
      return ((Activity)localContext).isFinishing();
    }
    return false;
  }
  
  private final void b(boolean paramBoolean)
  {
    Object localObject1 = getRoomBizContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "getRoomBizContext()");
    localObject1 = ((RoomBizContext)localObject1).getEnterRoomInfo().extData.getString("mqqschema");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mqqschema");
    localObject1 = UrlUtil.a(UrlUtil.b(UrlUtil.b(StringsKt.replace$default((String)localObject1, "&&", "&", false, 4, null), "toolProcessState"), "startEnterTime"), "showExitRoomNoticeDialog", String.valueOf(paramBoolean));
    if (QLog.isColorLevel())
    {
      localObject2 = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mqqschema = ");
      localStringBuilder.append((String)localObject1);
      QLog.i((String)localObject2, 1, localStringBuilder.toString());
    }
    Object localObject2 = new Intent("android.intent.action.VIEW");
    ((Intent)localObject2).setData(Uri.parse((String)localObject1));
    this.context.startActivity((Intent)localObject2);
  }
  
  private final boolean b()
  {
    return StringsKt.equals("xiaomi", Build.MANUFACTURER, true);
  }
  
  private final void c()
  {
    if ((this.g) && (this.i))
    {
      if (!q) {
        return;
      }
      RoomBizContext localRoomBizContext = getRoomBizContext();
      Intrinsics.checkExpressionValueIsNotNull(localRoomBizContext, "getRoomBizContext()");
      if ("true".equals(UrlUtil.a(localRoomBizContext.getEnterRoomInfo().extData.getString("mqqschema"), "showExitRoomNoticeDialog"))) {
        getEvent().post((ModuleEventInterface)new MultiVoicePageEvent(3));
      }
    }
  }
  
  private final void d()
  {
    if (this.d)
    {
      FloatWindowComponent localFloatWindowComponent = this.c;
      if (localFloatWindowComponent != null) {
        localFloatWindowComponent.dismiss(1);
      }
      this.d = false;
    }
  }
  
  private final void e()
  {
    if (!g()) {
      return;
    }
    FloatWindowComponent localFloatWindowComponent = this.c;
    if (localFloatWindowComponent != null) {
      localFloatWindowComponent.show(2131625544);
    }
    this.d = true;
    if (a()) {
      f().d();
    }
  }
  
  private final FloatRoomManager f()
  {
    Object localObject = BizEngineMgr.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BizEngineMgr.getInstance()");
    localObject = ((BizEngineMgr)localObject).getLiveEngine();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BizEngineMgr.getInstance().liveEngine");
    return ((LiveEngine)localObject).getFloatRoomManager();
  }
  
  private final boolean g()
  {
    Context localContext = this.context;
    if (localContext != null) {
      return FWPermission.hasPermission(localContext);
    }
    return false;
  }
  
  private final void h()
  {
    ThreadCenter.HandlerKeyable localHandlerKeyable = (ThreadCenter.HandlerKeyable)this;
    ThreadCenter.removeUITask(localHandlerKeyable, this.n);
    ThreadCenter.removeUITask(localHandlerKeyable, this.o);
  }
  
  public void onActivityDestroy(@Nullable LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityDestroy(paramLifecycleOwner);
    if (this.h) {
      d();
    }
  }
  
  public void onActivityStart(@Nullable LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityStart(paramLifecycleOwner);
    this.i = true;
    c();
    d();
  }
  
  public void onActivityStop(@Nullable LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityStop(paramLifecycleOwner);
    this.i = false;
    e();
  }
  
  public void onCreate(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    super.onCreate(paramContext);
    Object localObject = BizEngineMgr.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BizEngineMgr.getInstance()");
    this.k = ((NetworkStateInterface)((BizEngineMgr)localObject).getLiveEngine().getService(NetworkStateInterface.class));
    getEvent().observe(MultiVoicePageEvent.class, this.p);
    localObject = (FloatWindowComponent)getComponentFactory().getComponent(FloatWindowComponent.class).build();
    ((FloatWindowComponent)localObject).init(paramContext);
    ((FloatWindowComponent)localObject).setHandleCallback((FloatWindowHandleCallback)new MultiVoiceFloatingWindowModule.onCreate..inlined.apply.lambda.1((FloatWindowComponent)localObject, this, paramContext));
    this.c = ((FloatWindowComponent)localObject);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getEvent().removeObserver(MultiVoicePageEvent.class, this.p);
    this.l = true;
    Object localObject = this.k;
    if (localObject != null) {
      ((NetworkStateInterface)localObject).removeListener(this.m);
    }
    h();
    localObject = this.c;
    if ((localObject != null) && (((FloatWindowComponent)localObject).isCalledShow())) {
      ((FloatWindowComponent)localObject).dismiss(2);
    }
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    NetworkStateInterface localNetworkStateInterface = this.k;
    if (localNetworkStateInterface != null) {
      localNetworkStateInterface.addListener(this.m);
    }
  }
  
  public void onExtActive()
  {
    super.onExtActive();
    onActivityStart(this.mLifecycleOwner);
  }
  
  public void onExtDeActive()
  {
    super.onExtDeActive();
    onActivityStop(this.mLifecycleOwner);
  }
  
  public void onSwitchRoom(@Nullable SwitchRoomInfo paramSwitchRoomInfo)
  {
    this.e = paramSwitchRoomInfo;
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    super.onVisibleToUser(paramBoolean);
    if (!paramBoolean)
    {
      h();
      return;
    }
    Object localObject = new MultiVoiceFloatingWindowModule.onVisibleToUser.1(this);
    FloatRoomManager localFloatRoomManager = f();
    localObject = (FloatRoomManager.RoomEventInterceptor)localObject;
    localFloatRoomManager.a((FloatRoomManager.RoomEventInterceptor)localObject);
    this.f = ((FloatRoomManager.RoomEventInterceptor)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.MultiVoiceFloatingWindowModule
 * JD-Core Version:    0.7.0.1
 */