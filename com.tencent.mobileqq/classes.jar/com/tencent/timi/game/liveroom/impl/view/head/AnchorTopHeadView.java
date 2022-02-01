package com.tencent.timi.game.liveroom.impl.view.head;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi;
import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi.IQQLiveFollowStateListener;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.GetRoomInfoCallback;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.datareport.api.ILiveReportService.DefaultImpls;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.liveroom.api.IRoomWidget;
import com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionReportHelper;
import com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionReportHelper.Companion;
import com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionReportHelper.StatusListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.Logger;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/head/AnchorTopHeadView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/liveroom/api/IRoomWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultColorDrawable", "Landroid/graphics/drawable/ColorDrawable;", "isDetachedFromWindow", "", "isLandscape", "mAnchorId", "", "mCurrentFollowState", "mCurrentLiveUserInfo", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "mFollowMsgListener", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveReceiveFollowListener;", "mIsAnchor", "mLiveRoom", "Lcom/tencent/mobileqq/qqlive/api/room/ILiveRoom;", "mRoomAudienceInfoListener", "Lcom/tencent/mobileqq/qqlive/callback/room/RoomAudienceInfoListener;", "mRoomId", "mStatusListener", "Lcom/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionReportHelper$StatusListener;", "qqLiveFollowStateListener", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveFollowApi$IQQLiveFollowStateListener;", "addWebFollowStateChangeListener", "", "getURLDrawableOptions", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "igv", "Lcom/tencent/image/URLImageView;", "handleFollowState", "liveRoom", "needReport", "hideFollowUI", "initView", "jumpToMainPage", "loadingAnchorRoomData", "loadingAudienceRoomData", "loadingData", "onDetachedFromWindow", "onEnterRoom", "roomId", "isAnchor", "onExitRoom", "onOrientationChange", "onPageIn", "onPageOut", "onPreload", "videoUrl", "", "refreshAudienceRoomAnchorInfo", "nickName", "headUrl", "refreshFollowUI", "isFollow", "fromClick", "refreshInitOnlineNum", "registerNumReceiver", "removeWebFollowStateChangeListener", "reportFollowInfo", "reportTopAreaInfo", "resetLiveUserInfo", "anchorInfo", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataUserInfo;", "Lcom/tencent/mobileqq/qqlive/data/room/LiveAnchorInfo;", "unRegisterNumReceiver", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorTopHeadView
  extends FrameLayout
  implements IRoomWidget
{
  public static final AnchorTopHeadView.Companion a = new AnchorTopHeadView.Companion(null);
  private long b;
  private boolean c;
  private ColorDrawable d = new ColorDrawable(0);
  private ILiveRoom e;
  private LiveUserInfo f = new LiveUserInfo();
  private long g;
  private boolean h;
  private final RoomAudienceInfoListener i = (RoomAudienceInfoListener)new AnchorTopHeadView.mRoomAudienceInfoListener.1(this);
  private final IQQLiveReceiveFollowListener j = (IQQLiveReceiveFollowListener)new AnchorTopHeadView.mFollowMsgListener.1(this);
  private boolean k;
  private boolean l;
  private final LivingInscriptionReportHelper.StatusListener m = (LivingInscriptionReportHelper.StatusListener)new AnchorTopHeadView.mStatusListener.1(this);
  private final IQQLiveFollowApi.IQQLiveFollowStateListener n;
  private HashMap o;
  
  @JvmOverloads
  public AnchorTopHeadView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public AnchorTopHeadView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public AnchorTopHeadView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(paramContext, 2131629419, (ViewGroup)this);
    setBackgroundResource(2130852910);
    a();
    this.n = ((IQQLiveFollowApi.IQQLiveFollowStateListener)new AnchorTopHeadView.qqLiveFollowStateListener.1(this));
  }
  
  private final URLDrawable.URLDrawableOptions a(URLImageView paramURLImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable;
    if (paramURLImageView.getDrawable() != null) {
      localDrawable = paramURLImageView.getDrawable();
    } else {
      localDrawable = (Drawable)this.d;
    }
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    if (paramURLImageView.getDrawable() != null) {
      paramURLImageView = paramURLImageView.getDrawable();
    } else {
      paramURLImageView = (Drawable)this.d;
    }
    localURLDrawableOptions.mFailedDrawable = paramURLImageView;
    Intrinsics.checkExpressionValueIsNotNull(localURLDrawableOptions, "options");
    return localURLDrawableOptions;
  }
  
  private final void a()
  {
    RoundCornerImageView.setRadius$default((RoundCornerImageView)a(2131440524), LayoutExKt.a(16), 0.0F, 0.0F, LayoutExKt.a(16), 6, null);
    ((RoundCornerImageView)a(2131440524)).setOnClickListener((View.OnClickListener)new AnchorTopHeadView.initView.1(this));
  }
  
  private final void a(ILiveRoom paramILiveRoom, boolean paramBoolean)
  {
    paramILiveRoom = paramILiveRoom.getAnchorInfo();
    if (paramILiveRoom == null)
    {
      Logger.c("AnchorTopHeadView_", 1, "handleFollowState anchorInfo is null");
      return;
    }
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).d();
    if (localObject == null)
    {
      Logger.c("AnchorTopHeadView_", 1, "handleFollowState qqLiveSdk is null");
      return;
    }
    localObject = ((IQQLiveSDK)localObject).getFollowMsgService();
    if (localObject == null)
    {
      Logger.c("AnchorTopHeadView_", 1, "handleFollowState followService is null");
      return;
    }
    ((IQQLiveFollowMsgService)localObject).checkFollowAnchor(paramILiveRoom.getAnchorUid(), (IQQLiveCheckFollowCallback)new AnchorTopHeadView.handleFollowState.1(this, paramBoolean));
  }
  
  private final void a(QQLiveAnchorDataUserInfo paramQQLiveAnchorDataUserInfo)
  {
    this.f.uid = paramQQLiveAnchorDataUserInfo.id;
    this.f.nick = paramQQLiveAnchorDataUserInfo.nickName;
    this.f.headUrl = paramQQLiveAnchorDataUserInfo.avatarUrl;
    this.f.sex = -1;
  }
  
  private final void a(LiveAnchorInfo paramLiveAnchorInfo)
  {
    this.f.uid = paramLiveAnchorInfo.uid;
    this.f.nick = paramLiveAnchorInfo.nickName;
    this.f.headUrl = paramLiveAnchorInfo.headUrl;
    this.f.sex = paramLiveAnchorInfo.sex;
  }
  
  private final void a(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshAudienceRoomAnchorInfo nickname:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", url:");
    ((StringBuilder)localObject).append(paramString2);
    Logger.a("AnchorTopHeadView_", ((StringBuilder)localObject).toString());
    localObject = (TextView)a(2131439128);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "nameTxv");
    ((TextView)localObject).setText((CharSequence)paramString1);
    if (paramString2 != null)
    {
      paramString1 = (RoundCornerImageView)a(2131440524);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "portraitIgv");
      paramString1 = (URLImageView)paramString1;
      localObject = (RoundCornerImageView)a(2131440524);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "portraitIgv");
      CommonExKt.a(paramString1, paramString2, a((URLImageView)localObject));
    }
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = a(2131440353);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "placeHolderView");
    int i1 = 8;
    ((View)localObject).setVisibility(8);
    this.k = paramBoolean1;
    if (paramBoolean3) {
      b();
    }
    if (paramBoolean1)
    {
      localObject = (TextView)a(2131433511);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "followTxv");
      ((TextView)localObject).setVisibility(8);
      localObject = (ImageView)a(2131433536);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "followedIgv");
      if (paramBoolean2) {
        i1 = 0;
      }
      ((ImageView)localObject).setVisibility(i1);
      return;
    }
    localObject = (TextView)a(2131433511);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "followTxv");
    ((TextView)localObject).setVisibility(0);
    localObject = (ImageView)a(2131433536);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "followedIgv");
    ((ImageView)localObject).setVisibility(8);
    ((TextView)a(2131433511)).setOnClickListener((View.OnClickListener)new AnchorTopHeadView.refreshFollowUI.1(this));
  }
  
  private final void b()
  {
    Object localObject1 = new HashMap();
    if (!this.c)
    {
      Map localMap = (Map)localObject1;
      boolean bool = this.k;
      Object localObject2 = "1";
      if (bool) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      localMap.put("qqlive_follow_status", localObject1);
      if (this.l) {
        localObject1 = localObject2;
      } else {
        localObject1 = "0";
      }
      localMap.put("qqlive_screen_orientation", localObject1);
      localMap.put("zengzhi_moduleid", "em_qqlive_anchor_inf");
      localMap.put("qqlive_equip_status", LivingInscriptionReportHelper.a.a().a(this.b));
      localObject1 = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localObject2 = (TextView)a(2131433511);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "followTxv");
      ILiveReportService.DefaultImpls.a((ILiveReportService)localObject1, (View)localObject2, false, null, "em_qqlive_follow", localMap, 6, null);
      LivingInscriptionReportHelper.a.a().a(this.m);
    }
  }
  
  private final void b(boolean paramBoolean)
  {
    Object localObject = new HashMap();
    if (!this.c)
    {
      Map localMap = (Map)localObject;
      String str = "1";
      if (paramBoolean) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localMap.put("qqlive_follow_status", localObject);
      if (this.l) {
        localObject = str;
      } else {
        localObject = "0";
      }
      localMap.put("qqlive_screen_orientation", localObject);
      ILiveReportService.DefaultImpls.a((ILiveReportService)ServiceCenter.a(ILiveReportService.class), (View)this, false, null, "em_qqlive_anchor_inf", localMap, 6, null);
      return;
    }
    ILiveReportService.DefaultImpls.a((ILiveReportService)ServiceCenter.a(ILiveReportService.class), (View)this, false, null, "em_qqlive_anchor_inf", (Map)localObject, 6, null);
  }
  
  private final void c()
  {
    ILiveRoom localILiveRoom = this.e;
    if (localILiveRoom != null) {
      localILiveRoom.getRoomRealTimeInfo((GetRoomInfoCallback)new AnchorTopHeadView.refreshInitOnlineNum.1(this));
    }
  }
  
  private final void d()
  {
    if (this.c)
    {
      f();
      return;
    }
    e();
  }
  
  private final void e()
  {
    Object localObject = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).e(this.b);
    if (localObject == null)
    {
      Logger.c("AnchorTopHeadView_", "audienceRoom is null!");
      return;
    }
    this.e = ((ILiveRoom)localObject);
    localObject = ((IAudienceRoom)localObject).getRoomLiveInfo();
    if (localObject == null)
    {
      Logger.c("AnchorTopHeadView_", "liveInfo is null!");
      return;
    }
    localObject = ((LiveInfo)localObject).anchorInfo;
    if (localObject == null)
    {
      Logger.c("AnchorTopHeadView_", "anchorInfo is null!");
      return;
    }
    a(((LiveAnchorInfo)localObject).nickName, ((LiveAnchorInfo)localObject).headUrl);
    a((LiveAnchorInfo)localObject);
    this.g = ((LiveAnchorInfo)localObject).uid;
    localObject = this.e;
    if (localObject != null) {
      a(this, (ILiveRoom)localObject, false, 2, null);
    }
  }
  
  private final void f()
  {
    Object localObject = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).c(this.b);
    if (localObject == null)
    {
      Logger.c("AnchorTopHeadView_", "anchorRoom is null!");
      return;
    }
    this.e = ((ILiveRoom)localObject);
    localObject = ((IQQLiveAnchorRoom)localObject).getAnchorRoomInfo();
    if (localObject == null)
    {
      Logger.c("AnchorTopHeadView_", "anchorRoomInfo is null!");
      return;
    }
    localObject = ((QQLiveAnchorRoomInfo)localObject).userDta;
    if (localObject == null)
    {
      Logger.c("AnchorTopHeadView_", "userDta is null!");
      return;
    }
    this.g = ((QQLiveAnchorDataUserInfo)localObject).id;
    a(((QQLiveAnchorDataUserInfo)localObject).nickName, ((QQLiveAnchorDataUserInfo)localObject).avatarUrl);
    a((QQLiveAnchorDataUserInfo)localObject);
    k();
    b(false);
  }
  
  private final void g()
  {
    Logger.b("AnchorTopHeadView_", 1, "registerNumReceiver");
    h();
    ILiveRoom localILiveRoom = this.e;
    if (localILiveRoom != null) {
      localILiveRoom.registerAudienceInfoListener(this.i);
    }
    localILiveRoom = this.e;
    if (localILiveRoom != null) {
      localILiveRoom.registerFollowMessageListener(this.j);
    }
    j();
  }
  
  private final void h()
  {
    Logger.b("AnchorTopHeadView_", 1, "unRegisterNumReceiver");
    ILiveRoom localILiveRoom = this.e;
    if (localILiveRoom != null) {
      localILiveRoom.unRegisterAudienceInfoListener(this.i);
    }
    localILiveRoom = this.e;
    if (localILiveRoom != null) {
      localILiveRoom.unRegisterFollowMessageListener(this.j);
    }
    i();
  }
  
  private final void i()
  {
    ((IQQLiveFollowApi)QRoute.api(IQQLiveFollowApi.class)).removeWebFollowStateChangeListener(this.n);
  }
  
  private final void j()
  {
    ((IQQLiveFollowApi)QRoute.api(IQQLiveFollowApi.class)).addWebFollowStateChangeListener(this.n);
  }
  
  private final void k()
  {
    Object localObject = (TextView)a(2131433511);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "followTxv");
    ((TextView)localObject).setVisibility(8);
    localObject = (ImageView)a(2131433536);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "followedIgv");
    ((ImageView)localObject).setVisibility(8);
    localObject = a(2131440353);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "placeHolderView");
    ((View)localObject).setVisibility(0);
  }
  
  public View a(int paramInt)
  {
    if (this.o == null) {
      this.o = new HashMap();
    }
    View localView2 = (View)this.o.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.o.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong, @Nullable String paramString) {}
  
  public void a(long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoom roomId:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", isAnchor:");
    localStringBuilder.append(paramBoolean);
    Logger.a("AnchorTopHeadView_", 1, localStringBuilder.toString());
    this.b = paramLong;
    this.c = paramBoolean;
    d();
    g();
    c();
    setVisibility(0);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
    b(this.k);
  }
  
  public void b(long paramLong) {}
  
  public void c(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExitRoom roomId:");
    localStringBuilder.append(paramLong);
    Logger.a("AnchorTopHeadView_", 1, localStringBuilder.toString());
    h();
    LivingInscriptionReportHelper.a.a().b(this.m);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.h = true;
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.head.AnchorTopHeadView
 * JD-Core Version:    0.7.0.1
 */