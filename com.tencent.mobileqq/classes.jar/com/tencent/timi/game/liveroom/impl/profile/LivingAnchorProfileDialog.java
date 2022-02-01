package com.tencent.timi.game.liveroom.impl.profile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveAnchorPageService;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveGetAnchorPageUrlCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.datareport.api.ILiveReportService.DefaultImpls;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.liveroom.impl.util.LivingWebUtil;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/profile/LivingAnchorProfileDialog;", "Lcom/tencent/timi/game/liveroom/impl/profile/BaseLivingProfileDialog;", "liveUserInfo", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "context", "Landroid/content/Context;", "blurBackgroundView", "Landroid/view/View;", "roomId", "", "reportInfo", "Lcom/tencent/timi/game/liveroom/impl/profile/LivingProfileReportInfo;", "(Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;Landroid/content/Context;Landroid/view/View;JLcom/tencent/timi/game/liveroom/impl/profile/LivingProfileReportInfo;)V", "TAG", "", "followDrawable", "Landroid/graphics/drawable/Drawable;", "followListener", "com/tencent/timi/game/liveroom/impl/profile/LivingAnchorProfileDialog$followListener$1", "Lcom/tencent/timi/game/liveroom/impl/profile/LivingAnchorProfileDialog$followListener$1;", "followModule", "Lcom/tencent/mobileqq/qqlive/api/message/IQQLiveFollowMsgService;", "followedDrawable", "followedType", "", "isFollowAnchor", "", "unFollowListener", "com/tencent/timi/game/liveroom/impl/profile/LivingAnchorProfileDialog$unFollowListener$1", "Lcom/tencent/timi/game/liveroom/impl/profile/LivingAnchorProfileDialog$unFollowListener$1;", "changeFollow", "", "followAnchor", "initDrawable", "initFollow", "initView", "isFollowedAnchor", "jumpToMainPage", "onLeftButtonClick", "onRightButtonClick", "realJumpMainPage", "url", "report", "setFollowContent", "unFollowAnchor", "updateFollow", "isFollow", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingAnchorProfileDialog
  extends BaseLivingProfileDialog
{
  private final String a = "LivingAnchorProfileDialog";
  private Drawable b;
  private Drawable c;
  private IQQLiveFollowMsgService d;
  private boolean f;
  private final int g = 1;
  private final LivingAnchorProfileDialog.followListener.1 h = new LivingAnchorProfileDialog.followListener.1(this);
  private final LivingAnchorProfileDialog.unFollowListener.1 i = new LivingAnchorProfileDialog.unFollowListener.1(this);
  
  public LivingAnchorProfileDialog(@NotNull LiveUserInfo paramLiveUserInfo, @NotNull Context paramContext, @Nullable View paramView, long paramLong, @Nullable LivingProfileReportInfo paramLivingProfileReportInfo)
  {
    super(paramLiveUserInfo, paramContext, paramView, paramLong, paramLivingProfileReportInfo);
  }
  
  private final void A()
  {
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).d();
    if (localObject != null)
    {
      localObject = ((IQQLiveSDK)localObject).getAnchorPageService();
      if (localObject != null) {
        ((IQQLiveAnchorPageService)localObject).getAnchorPageUrl(b().uid, (IQQLiveGetAnchorPageUrlCallback)new LivingAnchorProfileDialog.jumpToMainPage.1(this));
      }
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    v();
  }
  
  private final void b(String paramString)
  {
    LivingWebUtil.a.a(c(), paramString);
  }
  
  private final void s()
  {
    ILiveReportService.DefaultImpls.a((ILiveReportService)ServiceCenter.a(ILiveReportService.class), l(), true, null, "em_qqlive_follow", null, 16, null);
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a((View)h(), true, null, "em_qqlive_inf_extrance", g());
    VideoReport.setEventDynamicParams(l(), (IDynamicParams)new LivingAnchorProfileDialog.report.1(this));
  }
  
  private final void t()
  {
    IQQLiveFollowMsgService localIQQLiveFollowMsgService = this.d;
    if (localIQQLiveFollowMsgService != null) {
      localIQQLiveFollowMsgService.checkFollowAnchor(b().uid, (IQQLiveCheckFollowCallback)new LivingAnchorProfileDialog.initFollow.1(this));
    }
  }
  
  private final void u()
  {
    int j = LayoutExKt.b(10);
    this.b = c().getResources().getDrawable(2130852847);
    this.c = c().getResources().getDrawable(2130852865);
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      localDrawable.setBounds(0, 0, j, j);
    }
    localDrawable = this.c;
    if (localDrawable != null) {
      localDrawable.setBounds(0, 0, j, j);
    }
  }
  
  private final void v()
  {
    if (x())
    {
      a("主页", "已关注");
      k().setCompoundDrawables(this.c, null, null, null);
      k().setTextColor(-1);
      return;
    }
    a("主页", "关注");
    k().setCompoundDrawables(this.b, null, null, null);
    k().setTextColor(Color.parseColor("#8A8AFF"));
  }
  
  private final void w()
  {
    if (x())
    {
      z();
      return;
    }
    y();
  }
  
  private final boolean x()
  {
    return this.f;
  }
  
  private final void y()
  {
    IQQLiveFollowMsgService localIQQLiveFollowMsgService = this.d;
    if (localIQQLiveFollowMsgService != null) {
      localIQQLiveFollowMsgService.followAnchor(b().uid, e(), (IQQLiveFollowCallback)this.h);
    }
  }
  
  private final void z()
  {
    IQQLiveFollowMsgService localIQQLiveFollowMsgService = this.d;
    if (localIQQLiveFollowMsgService != null) {
      localIQQLiveFollowMsgService.unFollowAnchor(b().uid, e(), (IQQLiveFollowCallback)this.i);
    }
  }
  
  public void i()
  {
    if (!f())
    {
      Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
      localObject = ((ITgLiveRoomService)localObject).d();
      if (localObject != null) {
        localObject = ((IQQLiveSDK)localObject).getFollowMsgService();
      } else {
        localObject = null;
      }
      this.d = ((IQQLiveFollowMsgService)localObject);
      j();
      k().setCompoundDrawablePadding(ViewUtils.dpToPx(6.0F));
      u();
      v();
      t();
      m();
    }
  }
  
  public void n()
  {
    A();
  }
  
  public void o()
  {
    w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.LivingAnchorProfileDialog
 * JD-Core Version:    0.7.0.1
 */