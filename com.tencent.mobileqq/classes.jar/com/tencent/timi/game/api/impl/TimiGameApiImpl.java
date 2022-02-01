package com.tencent.timi.game.api.impl;

import android.content.Context;
import androidx.annotation.MainThread;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.cb.ExpandHallListener;
import com.tencent.timi.game.api.live.BaseGameLiveAudienceView;
import com.tencent.timi.game.api.live.GameLiveResultListener;
import com.tencent.timi.game.api.live.ILiveModuleStatusListener;
import com.tencent.timi.game.api.live.ILiveReportUtil;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.expand.hall.impl.ExpandHallFragment;
import com.tencent.timi.game.initer.api.InitCallback;
import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.jump.api.impl.TimiGameJumpAction;
import com.tencent.timi.game.jump.api.impl.TimiGameJumpParser;
import com.tencent.timi.game.liveroom.api.IAnchorRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.sp.TGSharedPreferenceUtil;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import com.tencent.timi.game.utils.ThreadPool;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/api/impl/TimiGameApiImpl;", "Lcom/tencent/timi/game/api/ITimiGameApi;", "()V", "hasCalledBusiness", "", "getHasCalledBusiness", "()Z", "setHasCalledBusiness", "(Z)V", "buildLaunchParamFromLink", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "context", "Landroid/content/Context;", "jumpLink", "", "createExpandHallFragment", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "expandHallOpenParam", "listener", "Lcom/tencent/timi/game/api/cb/ExpandHallListener;", "destroyLiveModule", "", "doWhenQQLogin", "loginOrReconnect", "doWhenQQLogout", "getAudienceView", "Lcom/tencent/timi/game/api/live/BaseGameLiveAudienceView;", "getExpandHallFragment", "Ljava/lang/Class;", "getLiveModuleStatusListener", "Lcom/tencent/timi/game/api/live/ILiveModuleStatusListener;", "getLiveReportUtil", "Lcom/tencent/timi/game/api/live/ILiveReportUtil;", "initLiveModule", "openAnchorRoomPage", "openExpandHall", "openTimiGameTestPage", "resumeGameLive", "roomId", "", "programId", "Lcom/tencent/timi/game/api/live/GameLiveResultListener;", "startGameLive", "type", "Lcom/tencent/mobileqq/qqlive/data/anchor/camera/QQLiveAnchorStreamRecordType;", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameApiImpl
  implements ITimiGameApi
{
  public static final TimiGameApiImpl.Companion Companion = new TimiGameApiImpl.Companion(null);
  @NotNull
  public static final String TAG = "TimiGameApiImpl_";
  private boolean hasCalledBusiness;
  
  private final void setHasCalledBusiness()
  {
    this.hasCalledBusiness = true;
  }
  
  @NotNull
  public ExpandHallLaunchParam buildLaunchParamFromLink(@NotNull Context paramContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "jumpLink");
    paramContext = new TimiGameJumpParser().a((BaseQQAppInterface)TimiGameActivityManager.c(), paramContext, paramString, null);
    if (paramContext != null)
    {
      paramContext = (TimiGameJumpAction)paramContext;
      paramString = new ExpandHallLaunchParam();
      paramContext.a(paramString);
      return paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.timi.game.jump.api.impl.TimiGameJumpAction");
  }
  
  @NotNull
  public QPublicBaseFragment createExpandHallFragment(@NotNull Context paramContext, @NotNull ExpandHallLaunchParam paramExpandHallLaunchParam, @Nullable ExpandHallListener paramExpandHallListener)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramExpandHallLaunchParam, "expandHallOpenParam");
    return TimiGameApp.a.a(paramContext, paramExpandHallLaunchParam, paramExpandHallListener);
  }
  
  public void destroyLiveModule()
  {
    Logger.c("TimiGameApiImpl_", "destroyLiveModule start");
    ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).c();
    ((IniterService)ServiceCenter.a(IniterService.class)).b();
    ServiceCenter.a();
    Logger.c("TimiGameApiImpl_", "destroyLiveModule end");
  }
  
  public void doWhenQQLogin(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doWhenQQLogin START - ");
    localStringBuilder.append(paramBoolean);
    Logger.c("YesApiImpl", localStringBuilder.toString());
    if (TGSharedPreferenceUtil.b("tg_rooms_exist", false))
    {
      setHasCalledBusiness();
      Logger.a("YesApiImpl", "doWhenQQLogin#Logic_Room resume");
      ((IniterService)ServiceCenter.a(IniterService.class)).a((InitCallback)TimiGameApiImpl.doWhenQQLogin.1.a);
    }
    Logger.a("YesApiImpl", "doWhenQQLogin END");
  }
  
  public void doWhenQQLogout()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doWhenQQLogout, hasCalledBiz = ");
    localStringBuilder.append(this.hasCalledBusiness);
    Logger.c("YesApiImpl", localStringBuilder.toString());
    if (this.hasCalledBusiness) {
      ((IniterService)ServiceCenter.a(IniterService.class)).b();
    }
  }
  
  @NotNull
  public BaseGameLiveAudienceView getAudienceView(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    setHasCalledBusiness();
    paramContext = ((IAnchorRoomService)ServiceCenter.a(IAnchorRoomService.class)).b(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "ServiceCenter.getService….getAudienceView(context)");
    return paramContext;
  }
  
  @NotNull
  public Class<? extends QPublicBaseFragment> getExpandHallFragment()
  {
    return ExpandHallFragment.class;
  }
  
  public final boolean getHasCalledBusiness()
  {
    return this.hasCalledBusiness;
  }
  
  @NotNull
  public ILiveModuleStatusListener getLiveModuleStatusListener()
  {
    Object localObject = ServiceCenter.a(IAnchorRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…rRoomService::class.java)");
    localObject = ((IAnchorRoomService)localObject).b();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService….liveModuleStatusListener");
    return localObject;
  }
  
  @NotNull
  public ILiveReportUtil getLiveReportUtil()
  {
    return ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a();
  }
  
  public void initLiveModule(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initLiveModule - ");
    localStringBuilder.append(paramContext);
    Logger.a("TimiGameApiImpl_", localStringBuilder.toString());
    ThreadPool.c((Runnable)TimiGameApiImpl.initLiveModule.1.a);
  }
  
  public void openAnchorRoomPage(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    ((IAnchorRoomService)ServiceCenter.a(IAnchorRoomService.class)).a(paramContext, false);
  }
  
  @MainThread
  public void openExpandHall(@NotNull Context paramContext, @NotNull ExpandHallLaunchParam paramExpandHallLaunchParam)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramExpandHallLaunchParam, "expandHallOpenParam");
    if (NoDoubleClickUtils.a("TimiGameApiImpl_openExpandHall", 500L))
    {
      Logger.a("TimiGameApiImpl_", "openExpandHall doubleClick");
      return;
    }
    setHasCalledBusiness();
    TimiGameApp.a.a(paramContext, paramExpandHallLaunchParam);
  }
  
  public void openTimiGameTestPage()
  {
    setHasCalledBusiness();
    ((IniterService)ServiceCenter.a(IniterService.class)).a((InitCallback)TimiGameApiImpl.openTimiGameTestPage.1.a);
  }
  
  public void resumeGameLive(@NotNull Context paramContext, long paramLong, @Nullable String paramString, @Nullable GameLiveResultListener paramGameLiveResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    setHasCalledBusiness();
    ((IniterService)ServiceCenter.a(IniterService.class)).a((InitCallback)new TimiGameApiImpl.resumeGameLive.1(paramLong, paramString, paramContext, paramGameLiveResultListener));
  }
  
  public final void setHasCalledBusiness(boolean paramBoolean)
  {
    this.hasCalledBusiness = paramBoolean;
  }
  
  public void startGameLive(@NotNull Context paramContext, @NotNull QQLiveAnchorStreamRecordType paramQQLiveAnchorStreamRecordType, @Nullable GameLiveResultListener paramGameLiveResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramQQLiveAnchorStreamRecordType, "type");
    setHasCalledBusiness();
    ((IniterService)ServiceCenter.a(IniterService.class)).a((InitCallback)new TimiGameApiImpl.startGameLive.1(paramQQLiveAnchorStreamRecordType, paramContext, paramGameLiveResultListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.impl.TimiGameApiImpl
 * JD-Core Version:    0.7.0.1
 */