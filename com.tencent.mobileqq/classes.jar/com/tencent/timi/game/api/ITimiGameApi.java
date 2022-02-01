package com.tencent.timi.game.api;

import android.content.Context;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.timi.game.api.cb.ExpandHallListener;
import com.tencent.timi.game.api.live.BaseGameLiveAudienceView;
import com.tencent.timi.game.api.live.GameLiveResultListener;
import com.tencent.timi.game.api.live.ILiveModuleStatusListener;
import com.tencent.timi.game.api.live.ILiveReportUtil;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/api/ITimiGameApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "buildLaunchParamFromLink", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "context", "Landroid/content/Context;", "jumpLink", "", "createExpandHallFragment", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "expandHallOpenParam", "listener", "Lcom/tencent/timi/game/api/cb/ExpandHallListener;", "destroyLiveModule", "", "doWhenQQLogin", "loginOrReconnect", "", "doWhenQQLogout", "getAudienceView", "Lcom/tencent/timi/game/api/live/BaseGameLiveAudienceView;", "getExpandHallFragment", "Ljava/lang/Class;", "getLiveModuleStatusListener", "Lcom/tencent/timi/game/api/live/ILiveModuleStatusListener;", "getLiveReportUtil", "Lcom/tencent/timi/game/api/live/ILiveReportUtil;", "initLiveModule", "openAnchorRoomPage", "openExpandHall", "openTimiGameTestPage", "resumeGameLive", "roomId", "", "programId", "Lcom/tencent/timi/game/api/live/GameLiveResultListener;", "startGameLive", "type", "Lcom/tencent/mobileqq/qqlive/data/anchor/camera/QQLiveAnchorStreamRecordType;", "timi-game-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ITimiGameApi
  extends QRouteApi
{
  @NotNull
  public abstract ExpandHallLaunchParam buildLaunchParamFromLink(@NotNull Context paramContext, @NotNull String paramString);
  
  @NotNull
  public abstract QPublicBaseFragment createExpandHallFragment(@NotNull Context paramContext, @NotNull ExpandHallLaunchParam paramExpandHallLaunchParam, @Nullable ExpandHallListener paramExpandHallListener);
  
  public abstract void destroyLiveModule();
  
  public abstract void doWhenQQLogin(boolean paramBoolean);
  
  public abstract void doWhenQQLogout();
  
  @NotNull
  public abstract BaseGameLiveAudienceView getAudienceView(@NotNull Context paramContext);
  
  @NotNull
  public abstract Class<? extends QPublicBaseFragment> getExpandHallFragment();
  
  @NotNull
  public abstract ILiveModuleStatusListener getLiveModuleStatusListener();
  
  @NotNull
  public abstract ILiveReportUtil getLiveReportUtil();
  
  public abstract void initLiveModule(@NotNull Context paramContext);
  
  public abstract void openAnchorRoomPage(@NotNull Context paramContext);
  
  public abstract void openExpandHall(@NotNull Context paramContext, @NotNull ExpandHallLaunchParam paramExpandHallLaunchParam);
  
  public abstract void openTimiGameTestPage();
  
  public abstract void resumeGameLive(@NotNull Context paramContext, long paramLong, @Nullable String paramString, @Nullable GameLiveResultListener paramGameLiveResultListener);
  
  public abstract void startGameLive(@NotNull Context paramContext, @NotNull QQLiveAnchorStreamRecordType paramQQLiveAnchorStreamRecordType, @Nullable GameLiveResultListener paramGameLiveResultListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.ITimiGameApi
 * JD-Core Version:    0.7.0.1
 */