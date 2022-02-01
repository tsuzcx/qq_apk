package com.tencent.timi.game.liveroom.impl.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi;
import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi.IQQLiveFollowStateListener;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftEntranceService;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.app.event.AnchorAtEvent;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.datareport.api.ILiveReportService.DefaultImpls;
import com.tencent.timi.game.liveroom.api.IRoomWidget;
import com.tencent.timi.game.liveroom.impl.observable.FollowStatusWrapper;
import com.tencent.timi.game.liveroom.impl.profile.LivingOperateHelper;
import com.tencent.timi.game.liveroom.impl.report.TGReportUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.utils.ResUtils;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/widget/AudienceOperationBarView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/timi/game/app/event/AnchorAtEvent;", "Lcom/tencent/timi/game/liveroom/api/IRoomWidget;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "curAnchorInfo", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "curAnchorUid", "", "curAudienceRoom", "Lcom/tencent/mobileqq/qqlive/api/room/ILiveRoom;", "curHeadUrl", "", "curRoomId", "followMsgListener", "com/tencent/timi/game/liveroom/impl/widget/AudienceOperationBarView$followMsgListener$1", "Lcom/tencent/timi/game/liveroom/impl/widget/AudienceOperationBarView$followMsgListener$1;", "followStateObserver", "Ljava/util/Observer;", "followStatusWrapper", "Lcom/tencent/timi/game/liveroom/impl/observable/FollowStatusWrapper;", "iAudienceOperationViewListener", "Lcom/tencent/timi/game/liveroom/impl/widget/AudienceOperationBarView$IAudienceOperationViewListener;", "webFollowStateChangeListener", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveFollowApi$IQQLiveFollowStateListener;", "bindReportElement", "", "roomId", "extraInfo", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "follow", "liveRoom", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "handleFollowState", "loadAudienceRoomData", "onAttachedToWindow", "onDetachedFromWindow", "onEnterRoom", "isAnchor", "", "onExitRoom", "onPageIn", "onPageOut", "onPreload", "videoUrl", "onReceiveEvent", "event", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "refreshGiftIv", "roomExtraInfo", "anchorInfo", "Lcom/tencent/mobileqq/qqlive/data/room/LiveAnchorInfo;", "setAnchorOperationViewListener", "listener", "setFollowStatusObservable", "showProfileDialog", "view", "Landroid/view/View;", "Companion", "IAudienceOperationViewListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AudienceOperationBarView
  extends LinearLayout
  implements SimpleEventReceiver<AnchorAtEvent>, IRoomWidget
{
  public static final AudienceOperationBarView.Companion a = new AudienceOperationBarView.Companion(null);
  private String b = "";
  private long c;
  private long d;
  private ILiveRoom e;
  private LiveUserInfo f = new LiveUserInfo();
  private FollowStatusWrapper g;
  private AudienceOperationBarView.IAudienceOperationViewListener h;
  private final AudienceOperationBarView.followMsgListener.1 i = new AudienceOperationBarView.followMsgListener.1(this);
  private final IQQLiveFollowApi.IQQLiveFollowStateListener j = (IQQLiveFollowApi.IQQLiveFollowStateListener)new AudienceOperationBarView.webFollowStateChangeListener.1(this);
  private final Observer k;
  private HashMap l;
  
  @JvmOverloads
  public AudienceOperationBarView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public AudienceOperationBarView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public AudienceOperationBarView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LinearLayout.inflate(getContext(), 2131629421, (ViewGroup)this);
    setOrientation(0);
    setClipChildren(false);
    ((TextView)a(2131435816)).setOnClickListener((View.OnClickListener)new AudienceOperationBarView.1(this));
    ((ImageView)a(2131445755)).setOnClickListener((View.OnClickListener)new AudienceOperationBarView.2(this));
    ((GiftEntranceView)a(2131434237)).setOnClickListener((View.OnClickListener)new AudienceOperationBarView.3(this));
    ((FrameLayout)a(2131433509)).setOnClickListener((View.OnClickListener)new AudienceOperationBarView.4(this));
    this.k = ((Observer)new AudienceOperationBarView.followStateObserver.1(this));
  }
  
  private final void a(View paramView)
  {
    if (!NoDoubleClickUtils.a())
    {
      Activity localActivity = CommonExKt.a(this);
      if (localActivity != null) {
        LivingOperateHelper.a.a(paramView, (Context)localActivity, this.d, this.f, 2);
      }
    }
  }
  
  private final void a(ILiveRoom paramILiveRoom)
  {
    if (paramILiveRoom != null) {
      paramILiveRoom = paramILiveRoom.getAnchorInfo();
    } else {
      paramILiveRoom = null;
    }
    if (paramILiveRoom == null)
    {
      Logger.c("AudienceOperationBarView", 1, "handleFollowState anchorInfo is null");
      return;
    }
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).d();
    if (localObject == null)
    {
      Logger.c("AudienceOperationBarView", 1, "handleFollowState qqLiveSdk is null");
      return;
    }
    if (((IQQLiveSDK)localObject).getFollowMsgService() == null)
    {
      Logger.c("AudienceOperationBarView", 1, "handleFollowState followService is null");
      return;
    }
    localObject = this.g;
    if (localObject != null) {
      ((FollowStatusWrapper)localObject).a(paramILiveRoom.getAnchorUid(), this.d);
    }
  }
  
  private final void b(ILiveRoom paramILiveRoom)
  {
    if (paramILiveRoom == null)
    {
      Logger.c("AudienceOperationBarView", 1, "follow liveRoom is null");
      QQToast.makeText(getContext(), (CharSequence)"房间数据异常，请重新进入直播间后再试试", 0).show();
      return;
    }
    BaseAnchorInfo localBaseAnchorInfo = paramILiveRoom.getAnchorInfo();
    if (localBaseAnchorInfo == null)
    {
      Logger.c("AudienceOperationBarView", 1, "follow anchorInfo is null");
      return;
    }
    Object localObject = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
    localObject = ((ITgLiveRoomService)localObject).d();
    if (localObject == null)
    {
      Logger.c("AudienceOperationBarView", 1, "follow qqLiveSdk is null");
      return;
    }
    localObject = ((IQQLiveSDK)localObject).getFollowMsgService();
    if (localObject == null)
    {
      Logger.c("AudienceOperationBarView", 1, "follow followService is null");
      return;
    }
    long l1 = localBaseAnchorInfo.getAnchorUid();
    BaseRoomInfo localBaseRoomInfo = paramILiveRoom.getRoomInfo();
    Intrinsics.checkExpressionValueIsNotNull(localBaseRoomInfo, "liveRoom.roomInfo");
    ((IQQLiveFollowMsgService)localObject).followAnchor(l1, localBaseRoomInfo.getRoomId(), (IQQLiveFollowCallback)new AudienceOperationBarView.follow.1(this, localBaseAnchorInfo, paramILiveRoom));
  }
  
  private final void d(long paramLong)
  {
    Object localObject2 = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).e(paramLong);
    ILiveRoom localILiveRoom = (ILiveRoom)localObject2;
    this.e = localILiveRoom;
    if (localObject2 == null)
    {
      Logger.c("AudienceOperationBarView", "audience room is null");
      return;
    }
    Object localObject1 = ((IAudienceRoom)localObject2).getRoomLiveInfo();
    if (localObject1 == null)
    {
      Logger.c("AudienceOperationBarView", "liveInfo is null");
      return;
    }
    localObject1 = ((LiveInfo)localObject1).anchorInfo;
    if (localObject1 == null)
    {
      Logger.c("AudienceOperationBarView", "anchorInfo is null");
      return;
    }
    Object localObject3 = ((LiveAnchorInfo)localObject1).headUrl;
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "anchorInfo.headUrl");
    this.b = ((String)localObject3);
    this.c = ((LiveAnchorInfo)localObject1).getAnchorUid();
    localObject3 = this.f;
    ((LiveUserInfo)localObject3).uid = this.c;
    ((LiveUserInfo)localObject3).headUrl = this.b;
    ((LiveUserInfo)localObject3).nick = ((LiveAnchorInfo)localObject1).nickName;
    this.f.sex = ((LiveAnchorInfo)localObject1).sex;
    localObject2 = ((IAudienceRoom)localObject2).getRoomInfo();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "audienceRoom.roomInfo");
    this.d = ((BaseRoomInfo)localObject2).getRoomId();
    localObject2 = (URLImageView)a(2131433510);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "followIv");
    localObject1 = ((LiveAnchorInfo)localObject1).headUrl;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "anchorInfo.headUrl");
    localObject3 = URLDrawable.URLDrawableOptions.obtain();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "URLDrawable.URLDrawableOptions.obtain()");
    CommonExKt.a((URLImageView)localObject2, (String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
    a(localILiveRoom);
  }
  
  public View a(int paramInt)
  {
    if (this.l == null) {
      this.l = new HashMap();
    }
    View localView2 = (View)this.l.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.l.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a(long paramLong)
  {
    GiftEntranceView.a((GiftEntranceView)a(2131434237), null, 1, null);
    ((FrameLayout)a(2131433509)).setOnClickListener(null);
  }
  
  public final void a(long paramLong, @Nullable LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    paramLiveRoomExtraInfo = TGReportUtil.a.a(paramLong, paramLiveRoomExtraInfo);
    Object localObject = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
    if (paramLiveRoomExtraInfo != null)
    {
      ((ILiveReportService)localObject).a(this, "pg_qqlive_audience", (Map)paramLiveRoomExtraInfo);
      ILiveReportService.DefaultImpls.a((ILiveReportService)ServiceCenter.a(ILiveReportService.class), (View)this, false, null, "em_qqlive_bottom_bar", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("qqlive_screen_orientation", "0") }), 6, null);
      paramLiveRoomExtraInfo = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localObject = (ImageView)a(2131445755);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "shareIv");
      ILiveReportService.DefaultImpls.a(paramLiveRoomExtraInfo, (View)localObject, false, null, "em_qqlive_share", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("zengzhi_moduleid", "em_qqlive_bottom_bar") }), 6, null);
      paramLiveRoomExtraInfo = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localObject = (TextView)a(2131435816);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "inputTv");
      ILiveReportService.DefaultImpls.a(paramLiveRoomExtraInfo, (View)localObject, false, null, "em_qqlive_inputbar", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("zengzhi_moduleid", "em_qqlive_bottom_bar") }), 6, null);
      paramLiveRoomExtraInfo = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localObject = (GiftEntranceView)a(2131434237);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "giftIv");
      ILiveReportService.DefaultImpls.a(paramLiveRoomExtraInfo, (View)localObject, false, null, "em_qqlive_gift_entrance", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("zengzhi_moduleid", "em_qqlive_bottom_bar") }), 6, null);
      paramLiveRoomExtraInfo = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localObject = (FrameLayout)a(2131433509);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "followFl");
      ILiveReportService.DefaultImpls.a(paramLiveRoomExtraInfo, (View)localObject, false, null, "em_qqlive_follow", null, 22, null);
      VideoReport.setEventDynamicParams((FrameLayout)a(2131433509), (IDynamicParams)new AudienceOperationBarView.bindReportElement.1(this, paramLong));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
  }
  
  public void a(long paramLong, @Nullable String paramString)
  {
    GiftEntranceView.a((GiftEntranceView)a(2131434237), null, 1, null);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    d(paramLong);
    IAudienceRoom localIAudienceRoom = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).e(paramLong);
    if (localIAudienceRoom != null) {
      localIAudienceRoom.unRegisterFollowMessageListener((IQQLiveReceiveFollowListener)this.i);
    }
    localIAudienceRoom = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).e(paramLong);
    if (localIAudienceRoom != null) {
      localIAudienceRoom.registerFollowMessageListener((IQQLiveReceiveFollowListener)this.i);
    }
    ((IQQLiveFollowApi)QRoute.api(IQQLiveFollowApi.class)).removeWebFollowStateChangeListener(this.j);
    ((IQQLiveFollowApi)QRoute.api(IQQLiveFollowApi.class)).addWebFollowStateChangeListener(this.j);
  }
  
  public final void a(@NotNull LiveRoomExtraInfo paramLiveRoomExtraInfo, @NotNull LiveAnchorInfo paramLiveAnchorInfo, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramLiveRoomExtraInfo, "roomExtraInfo");
    Intrinsics.checkParameterIsNotNull(paramLiveAnchorInfo, "anchorInfo");
    IQQLiveSDK localIQQLiveSDK = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1037");
    Intrinsics.checkExpressionValueIsNotNull(localIQQLiveSDK, "liveSDK");
    if ((localIQQLiveSDK.isInited()) && (!localIQQLiveSDK.isDestroyed())) {
      localIQQLiveSDK.getGiftEntranceService().needShowGiftIcon(paramLiveRoomExtraInfo.d, paramLiveRoomExtraInfo.a, paramLiveRoomExtraInfo.b, String.valueOf(paramLiveAnchorInfo.getAnchorUid()), (OnQueryGiftIconCallback)new AudienceOperationBarView.refreshGiftIv.1(this, paramLong, paramLiveAnchorInfo));
    }
  }
  
  public void b(long paramLong)
  {
    GiftEntranceView localGiftEntranceView = (GiftEntranceView)a(2131434237);
    Intrinsics.checkExpressionValueIsNotNull(localGiftEntranceView, "giftIv");
    localGiftEntranceView.setVisibility(8);
    ((GiftEntranceView)a(2131434237)).a();
    ((ImageView)a(2131433508)).setImageDrawable(ResUtils.a(2130853023));
  }
  
  public void c(long paramLong)
  {
    IAudienceRoom localIAudienceRoom = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).e(paramLong);
    if (localIAudienceRoom != null) {
      localIAudienceRoom.unRegisterFollowMessageListener((IQQLiveReceiveFollowListener)this.i);
    }
    ((IQQLiveFollowApi)QRoute.api(IQQLiveFollowApi.class)).removeWebFollowStateChangeListener(this.j);
  }
  
  @NotNull
  public ArrayList<Class<AnchorAtEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AnchorAtEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver((SimpleEventReceiver)this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver((SimpleEventReceiver)this);
    IAudienceRoom localIAudienceRoom = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).e(this.d);
    if (localIAudienceRoom != null) {
      localIAudienceRoom.unRegisterFollowMessageListener((IQQLiveReceiveFollowListener)this.i);
    }
    ((IQQLiveFollowApi)QRoute.api(IQQLiveFollowApi.class)).removeWebFollowStateChangeListener(this.j);
  }
  
  public void onReceiveEvent(@Nullable SimpleBaseEvent paramSimpleBaseEvent)
  {
    paramSimpleBaseEvent = this.h;
    if (paramSimpleBaseEvent != null) {
      paramSimpleBaseEvent.a();
    }
  }
  
  public final void setAnchorOperationViewListener(@NotNull AudienceOperationBarView.IAudienceOperationViewListener paramIAudienceOperationViewListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIAudienceOperationViewListener, "listener");
    this.h = paramIAudienceOperationViewListener;
  }
  
  public final void setFollowStatusObservable(@NotNull FollowStatusWrapper paramFollowStatusWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramFollowStatusWrapper, "followStatusWrapper");
    this.g = paramFollowStatusWrapper;
    paramFollowStatusWrapper.addObserver(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AudienceOperationBarView
 * JD-Core Version:    0.7.0.1
 */