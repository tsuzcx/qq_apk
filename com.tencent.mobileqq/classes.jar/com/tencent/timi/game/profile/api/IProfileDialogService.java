package com.tencent.timi.game.profile.api;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.profile.api.listener.CPDDProfileClickListener;
import com.tencent.timi.game.profile.api.listener.CommunityClickListener;
import com.tencent.timi.game.profile.api.listener.FleetProfileClickListener;
import com.tencent.timi.game.profile.api.ui.ProfileDialog;
import com.tencent.timi.game.router.IService;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/api/IProfileDialogService;", "Lcom/tencent/timi/game/router/IService;", "showCADDProfileDialog", "Lcom/tencent/timi/game/profile/api/ui/ProfileDialog;", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "userId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "isVoiceRoom", "", "listener", "Lcom/tencent/timi/game/profile/api/listener/CPDDProfileClickListener;", "reportParamMap", "", "", "roomId", "", "showCommunityDialog", "Lcom/tencent/timi/game/profile/api/listener/CommunityClickListener;", "showFleetProfileDialog", "selfUserId", "otherUserId", "isCaptain", "Lcom/tencent/timi/game/profile/api/listener/FleetProfileClickListener;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IProfileDialogService
  extends IService
{
  @Nullable
  public abstract ProfileDialog a(@NotNull QBaseActivity paramQBaseActivity, @NotNull CommonOuterClass.QQUserId paramQQUserId, @Nullable CommunityClickListener paramCommunityClickListener, @NotNull Map<String, String> paramMap, long paramLong);
  
  @Nullable
  public abstract ProfileDialog a(@NotNull QBaseActivity paramQBaseActivity, @Nullable CommonOuterClass.QQUserId paramQQUserId1, @NotNull CommonOuterClass.QQUserId paramQQUserId2, boolean paramBoolean, @Nullable FleetProfileClickListener paramFleetProfileClickListener, @NotNull Map<String, String> paramMap, long paramLong);
  
  @Nullable
  public abstract ProfileDialog a(@NotNull QBaseActivity paramQBaseActivity, @NotNull CommonOuterClass.QQUserId paramQQUserId, boolean paramBoolean, @Nullable CPDDProfileClickListener paramCPDDProfileClickListener, @NotNull Map<String, String> paramMap, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.api.IProfileDialogService
 * JD-Core Version:    0.7.0.1
 */