package com.tencent.timi.game.profile.impl;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.profile.api.IProfileDialogService;
import com.tencent.timi.game.profile.api.listener.CPDDProfileClickListener;
import com.tencent.timi.game.profile.api.listener.CommunityClickListener;
import com.tencent.timi.game.profile.api.listener.FleetProfileClickListener;
import com.tencent.timi.game.profile.api.ui.ProfileDialog;
import com.tencent.timi.game.profile.impl.dialog.CPDDProfileDialogImpl;
import com.tencent.timi.game.profile.impl.dialog.CommunityProfileDialogImpl;
import com.tencent.timi.game.profile.impl.dialog.FleetProfileDialogImpl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/impl/ProfileDialogServiceImpl;", "Lcom/tencent/timi/game/profile/api/IProfileDialogService;", "()V", "init", "", "context", "Landroid/content/Context;", "isTmmiHelper", "", "uid", "", "(Ljava/lang/Long;)Z", "serviceDestroy", "showCADDProfileDialog", "Lcom/tencent/timi/game/profile/api/ui/ProfileDialog;", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "userId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "isVoiceRoom", "listener", "Lcom/tencent/timi/game/profile/api/listener/CPDDProfileClickListener;", "reportParamMap", "", "", "roomId", "showCommunityDialog", "Lcom/tencent/timi/game/profile/api/listener/CommunityClickListener;", "showFleetProfileDialog", "selfUserId", "otherUserId", "isCaptain", "Lcom/tencent/timi/game/profile/api/listener/FleetProfileClickListener;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileDialogServiceImpl
  implements IProfileDialogService
{
  private final boolean a(Long paramLong)
  {
    return (paramLong != null) && (2000L == paramLong.longValue());
  }
  
  @Nullable
  public ProfileDialog a(@NotNull QBaseActivity paramQBaseActivity, @NotNull CommonOuterClass.QQUserId paramQQUserId, @Nullable CommunityClickListener paramCommunityClickListener, @NotNull Map<String, String> paramMap, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "userId");
    Intrinsics.checkParameterIsNotNull(paramMap, "reportParamMap");
    if (a(Long.valueOf(paramQQUserId.uid.get()))) {
      return null;
    }
    paramQBaseActivity = new CommunityProfileDialogImpl(paramQBaseActivity, paramQQUserId, paramMap, paramLong);
    paramQBaseActivity.a(paramCommunityClickListener);
    paramQBaseActivity.show();
    return (ProfileDialog)paramQBaseActivity;
  }
  
  @Nullable
  public ProfileDialog a(@NotNull QBaseActivity paramQBaseActivity, @Nullable CommonOuterClass.QQUserId paramQQUserId1, @NotNull CommonOuterClass.QQUserId paramQQUserId2, boolean paramBoolean, @Nullable FleetProfileClickListener paramFleetProfileClickListener, @NotNull Map<String, String> paramMap, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramQQUserId2, "otherUserId");
    Intrinsics.checkParameterIsNotNull(paramMap, "reportParamMap");
    if (a(Long.valueOf(paramQQUserId2.uid.get()))) {
      return null;
    }
    paramQBaseActivity = new FleetProfileDialogImpl(paramQBaseActivity, paramQQUserId2, paramBoolean, paramMap, paramLong);
    paramQBaseActivity.a(paramQQUserId1);
    paramQBaseActivity.a(paramFleetProfileClickListener);
    paramQBaseActivity.show();
    return (ProfileDialog)paramQBaseActivity;
  }
  
  @Nullable
  public ProfileDialog a(@NotNull QBaseActivity paramQBaseActivity, @NotNull CommonOuterClass.QQUserId paramQQUserId, boolean paramBoolean, @Nullable CPDDProfileClickListener paramCPDDProfileClickListener, @NotNull Map<String, String> paramMap, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "userId");
    Intrinsics.checkParameterIsNotNull(paramMap, "reportParamMap");
    if (a(Long.valueOf(paramQQUserId.uid.get()))) {
      return null;
    }
    paramQBaseActivity = new CPDDProfileDialogImpl(paramQBaseActivity, paramQQUserId, paramBoolean, paramMap, paramLong);
    paramQBaseActivity.a(paramCPDDProfileClickListener);
    if (!paramBoolean) {
      paramQBaseActivity.a(false, false);
    } else {
      paramQBaseActivity.a(true, false);
    }
    paramQBaseActivity.show();
    return (ProfileDialog)paramQBaseActivity;
  }
  
  public void a(@Nullable Context paramContext) {}
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.ProfileDialogServiceImpl
 * JD-Core Version:    0.7.0.1
 */