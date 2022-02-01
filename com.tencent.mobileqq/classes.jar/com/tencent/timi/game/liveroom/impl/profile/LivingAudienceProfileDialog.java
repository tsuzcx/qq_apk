package com.tencent.timi.game.liveroom.impl.profile;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveBanChat;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveModuleKickOut;
import com.tencent.mobileqq.qqlive.callback.supervision.QueryIsBanedChatCallback;
import com.tencent.mobileqq.qqlive.callback.supervision.SetBanChatCallback;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.liveroom.api.ProfileOperateType;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/profile/LivingAudienceProfileDialog;", "Lcom/tencent/timi/game/liveroom/impl/profile/BaseLivingProfileDialog;", "context", "Landroid/content/Context;", "openByAnchor", "", "liveUserInfo", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "blurBackgroundView", "Landroid/view/View;", "roomId", "", "reprotInfo", "Lcom/tencent/timi/game/liveroom/impl/profile/LivingProfileReportInfo;", "(Landroid/content/Context;ZLcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;Landroid/view/View;JLcom/tencent/timi/game/liveroom/impl/profile/LivingProfileReportInfo;)V", "TAG", "", "isBanChat", "addToBlackList", "", "cancelBanChat", "checkSpeechState", "forbiddenSpeech", "initView", "onLeftButtonClick", "onRightButtonClick", "onStart", "report", "setOperateView", "setSpeechState", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingAudienceProfileDialog
  extends BaseLivingProfileDialog
{
  private final String a;
  private boolean b;
  private final boolean c;
  
  public LivingAudienceProfileDialog(@NotNull Context paramContext, boolean paramBoolean, @NotNull LiveUserInfo paramLiveUserInfo, @Nullable View paramView, long paramLong, @Nullable LivingProfileReportInfo paramLivingProfileReportInfo)
  {
    super(paramLiveUserInfo, paramContext, paramView, paramLong, paramLivingProfileReportInfo);
    this.c = paramBoolean;
    this.a = "LivingAudienceProfileDialog";
  }
  
  private final void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    TextView localTextView = k();
    String str;
    if (paramBoolean) {
      str = "取消禁言";
    } else {
      str = "禁言";
    }
    localTextView.setText((CharSequence)str);
  }
  
  private final void s()
  {
    g();
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a(l(), true, null, "em_qqlive_setmute", g());
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a((View)h(), true, null, "em_qqlive_setblock", g());
  }
  
  private final void t()
  {
    if (this.c)
    {
      j();
      a("加入黑名单", "禁言");
      v();
    }
  }
  
  private final void u()
  {
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).d();
    if (localObject != null) {
      localObject = ((IQQLiveSDK)localObject).getBanChatModule();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((IQQLiveBanChat)localObject).cancelBanChat(LivingOperateHelper.a.a(), e(), b().uid, (SetBanChatCallback)new LivingAudienceProfileDialog.cancelBanChat.1(this));
    }
  }
  
  private final void v()
  {
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).d();
    if (localObject != null) {
      localObject = ((IQQLiveSDK)localObject).getBanChatModule();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((IQQLiveBanChat)localObject).isBanedChat(LivingOperateHelper.a.a(), e(), b().uid, (QueryIsBanedChatCallback)new LivingAudienceProfileDialog.checkSpeechState.1(this));
    }
  }
  
  private final void w()
  {
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).d();
    Integer localInteger = null;
    if (localObject != null) {
      localObject = ((IQQLiveSDK)localObject).getBanChatModule();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      str = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("forbiddenSpeech module error ");
      localStringBuilder.append(localObject);
      Logger.c(str, localStringBuilder.toString());
    }
    if (localObject != null) {
      localObject = ((IQQLiveBanChat)localObject).getBanChatReasonList();
    } else {
      localObject = null;
    }
    a(ProfileOperateType.a.a(), (List)localObject);
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addToBlackList list ");
    if (localObject != null) {
      localInteger = Integer.valueOf(((List)localObject).size());
    }
    localStringBuilder.append(localInteger);
    Logger.a(str, localStringBuilder.toString());
    dismiss();
  }
  
  private final void x()
  {
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).d();
    Integer localInteger = null;
    if (localObject != null) {
      localObject = ((IQQLiveSDK)localObject).getKickOutModule();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      str = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("forbiddenSpeech module error ");
      localStringBuilder.append(localObject);
      Logger.c(str, localStringBuilder.toString());
    }
    if (localObject != null) {
      localObject = ((IQQLiveModuleKickOut)localObject).getKickOutReasonList();
    } else {
      localObject = null;
    }
    a(ProfileOperateType.a.b(), (List)localObject);
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("forbiddenSpeech list ");
    if (localObject != null) {
      localInteger = Integer.valueOf(((List)localObject).size());
    }
    localStringBuilder.append(localInteger);
    Logger.a(str, localStringBuilder.toString());
    dismiss();
  }
  
  public void i() {}
  
  public void n()
  {
    if (this.c) {
      w();
    }
  }
  
  public void o()
  {
    if (this.c)
    {
      if (!this.b)
      {
        x();
        return;
      }
      u();
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    if (!f())
    {
      t();
      s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.LivingAudienceProfileDialog
 * JD-Core Version:    0.7.0.1
 */