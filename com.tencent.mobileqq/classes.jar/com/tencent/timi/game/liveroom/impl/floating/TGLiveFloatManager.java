package com.tencent.timi.game.liveroom.impl.floating;

import android.content.Intent;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.listener.supervision.OnKickedOutOfRoomListener;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.float_window.BusFloatManager;
import com.tencent.timi.game.float_window.BusFloatManager.Companion;
import com.tencent.timi.game.float_window.IFloatViewCreator;
import com.tencent.timi.game.liveroom.impl.TimiAudienceKickOutHelper;
import com.tencent.timi.game.liveroom.impl.report.TGReportUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/floating/TGLiveFloatManager;", "", "()V", "KEY_KEEP_ALIVE", "", "getKEY_KEEP_ALIVE", "()Ljava/lang/String;", "TAG", "onKickedOutOfRoomListener", "Lcom/tencent/mobileqq/qqlive/listener/supervision/OnKickedOutOfRoomListener;", "destroyFloatingView", "", "roomId", "", "autoExitRoom", "", "hideFloatView", "registerRoomListener", "isAnchor", "showFloatView", "resumeIntent", "Landroid/content/Intent;", "showKeepAliveFloatView", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGLiveFloatManager
{
  public static final TGLiveFloatManager a = new TGLiveFloatManager();
  @NotNull
  private static final String b = "_keepAlive";
  private static OnKickedOutOfRoomListener c = (OnKickedOutOfRoomListener)TGLiveFloatManager.onKickedOutOfRoomListener.1.a;
  private static final String d = "TGLiveFloatManager";
  
  public final void a()
  {
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).h(0L);
    if (localObject != null) {
      localObject = Long.valueOf(((BaseRoomInfo)localObject).getRoomId());
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ((Number)localObject).longValue();
      BusFloatManager localBusFloatManager = BusFloatManager.a.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(((Long)localObject).longValue()));
      localStringBuilder.append(b);
      localBusFloatManager.a(localStringBuilder.toString(), (IFloatViewCreator)new TGLiveFloatManager.showKeepAliveFloatView.1.1());
    }
  }
  
  public final void a(long paramLong)
  {
    a(paramLong, true);
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroyFloatingView  roomId:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", autoExitRoom:");
    localStringBuilder.append(paramBoolean);
    Logger.a((String)localObject, localStringBuilder.toString());
    TimiAudienceKickOutHelper.a.b(c);
    BusFloatManager.a.a().b(String.valueOf(paramLong));
    localObject = BusFloatManager.a.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramLong));
    localStringBuilder.append(b);
    ((BusFloatManager)localObject).b(localStringBuilder.toString());
    if (paramBoolean)
    {
      localObject = ServiceCenter.a(ITgLiveRoomService.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
      localObject = (ITgLiveRoomService)localObject;
      TGReportUtil.a.a(0L);
      ((ITgLiveRoomService)localObject).a(paramLong, (IResultListener)new TGLiveFloatManager.destroyFloatingView.1());
    }
  }
  
  public final void a(boolean paramBoolean, long paramLong)
  {
    Object localObject1 = d;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("registerRoomListener isAnchor:");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append(" roomId:");
    ((StringBuilder)localObject2).append(paramLong);
    Logger.a((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ServiceCenter.getService…eRoomService::class.java)");
    localObject1 = (ITgLiveRoomService)localObject1;
    localObject2 = (ILiveRoomMessage)null;
    if (!paramBoolean) {
      localObject1 = (ILiveRoomMessage)((ITgLiveRoomService)localObject1).e(paramLong);
    } else {
      localObject1 = (ILiveRoomMessage)((ITgLiveRoomService)localObject1).c(paramLong);
    }
    TimiAudienceKickOutHelper.a.a(c);
  }
  
  public final void a(boolean paramBoolean, @Nullable Intent paramIntent)
  {
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = (ITgLiveRoomService)localObject;
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObject = ((ITgLiveRoomService)localObject).h(0L);
    if (localObject != null) {
      localObject = Long.valueOf(((BaseRoomInfo)localObject).getRoomId());
    } else {
      localObject = null;
    }
    localObjectRef.element = localObject;
    localObject = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showFloatView isAnchor:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" roomId:");
    localStringBuilder.append((Long)localObjectRef.element);
    Logger.a((String)localObject, localStringBuilder.toString());
    localObject = (Long)localObjectRef.element;
    if (localObject != null)
    {
      long l = ((Number)localObject).longValue();
      BusFloatManager.a.a().a(String.valueOf(((Long)localObjectRef.element).longValue()), (IFloatViewCreator)new TGLiveFloatManager.showFloatView..inlined.let.lambda.1(l, localObjectRef, paramBoolean, paramIntent));
    }
    localObject = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).b(0L);
    paramIntent = (Intent)localObject;
    if (!(localObject instanceof ILiveTPPlayerRoom)) {
      paramIntent = null;
    }
    paramIntent = (ILiveTPPlayerRoom)paramIntent;
    if (paramIntent != null) {
      paramIntent.startPlay("");
    }
  }
  
  public final void b()
  {
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).h(0L);
    if (localObject != null) {
      localObject = Long.valueOf(((BaseRoomInfo)localObject).getRoomId());
    } else {
      localObject = null;
    }
    String str = d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hideFloatView  roomId:");
    localStringBuilder.append(localObject);
    Logger.a(str, localStringBuilder.toString());
    if (localObject != null)
    {
      long l = ((Number)localObject).longValue();
      BusFloatManager.a.a().a(String.valueOf(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveFloatManager
 * JD-Core Version:    0.7.0.1
 */