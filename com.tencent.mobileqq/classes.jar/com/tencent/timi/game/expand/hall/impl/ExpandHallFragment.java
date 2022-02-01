package com.tencent.timi.game.expand.hall.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.AbsGestureListener;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.ChannelData;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.NotifyData;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.api.cb.ExpandHallListener;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.base.TimiGameBaseFragment;
import com.tencent.timi.game.component.chat.ChatView.IMsgSendStatusListener;
import com.tencent.timi.game.component.chat.ConvType;
import com.tencent.timi.game.component.chat.GroupChatView;
import com.tencent.timi.game.component.chat.at.FamilyAtFunction;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener;
import com.tencent.timi.game.component.chat.message.IMessageListener;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.datareport.api.IReportService.DefaultImpls;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.expand.hall.impl.cache.ExpandHallInfoCacheManager;
import com.tencent.timi.game.expand.hall.impl.gm.ExpandHallGMManager;
import com.tencent.timi.game.expand.hall.impl.mic.MicCardView;
import com.tencent.timi.game.expand.hall.impl.util.GuildUtil;
import com.tencent.timi.game.expand.hall.impl.util.SafeNoticeMsgManager;
import com.tencent.timi.game.expand.hall.impl.util.SafeNoticeMsgManager.Companion;
import com.tencent.timi.game.expand.hall.impl.util.TouchUtil;
import com.tencent.timi.game.expand.hall.impl.view.ExpandHallInfoView;
import com.tencent.timi.game.expand.hall.impl.view.ExpandHallRightDrawerView;
import com.tencent.timi.game.expand.hall.impl.view.ExpandHallSmobaAuthView;
import com.tencent.timi.game.gift.impl.timi.GiftLayerBuilder;
import com.tencent.timi.game.gift.impl.timi.TimiGiftController;
import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.initer.impl.GiftSdkInitManager;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomCommonListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomLifecycleListener;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.api.wrapper.IRoomListenerService;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.view.SmobaAuthAndBindHintView;
import com.tencent.timi.game.team.api.ITeamService;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService;
import com.tencent.timi.game.teamlist.view.TeamListView;
import com.tencent.timi.game.test.api.ITimiGameTestService;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.group.IGroupManager;
import com.tencent.timi.game.ui.ViewStateChangeListener;
import com.tencent.timi.game.ui.widget.CommonDialog;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.NetUtils;
import com.tencent.timi.game.utils.StatusBarUtil;
import com.tencent.timi.game.utils.TimeDetector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCommunityConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomUserData;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomUserWhiteList;
import trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf;
import trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloRoomCommunityOnlineNumItem;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/ExpandHallFragment;", "Lcom/tencent/timi/game/base/TimiGameBaseFragment;", "Lcom/tencent/timi/game/component/chat/at/FamilyAtFunction;", "Lcom/tencent/timi/game/expand/hall/api/IExpandHall;", "()V", "defaultColorDrawable", "Landroid/graphics/drawable/ColorDrawable;", "expandHallGMManager", "Lcom/tencent/timi/game/expand/hall/impl/gm/ExpandHallGMManager;", "giftController", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftController;", "gpServiceObserver", "com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$gpServiceObserver$1", "Lcom/tencent/timi/game/expand/hall/impl/ExpandHallFragment$gpServiceObserver$1;", "isExpand", "", "mAbsGestureListener", "com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$mAbsGestureListener$1", "Lcom/tencent/timi/game/expand/hall/impl/ExpandHallFragment$mAbsGestureListener$1;", "mAllRoomLifeCycleListener", "com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$mAllRoomLifeCycleListener$1", "Lcom/tencent/timi/game/expand/hall/impl/ExpandHallFragment$mAllRoomLifeCycleListener$1;", "mCurrentHallRoomData", "Lcom/tencent/timi/game/room/api/wrapper/IRoomGetDataService;", "mDelayJoinRoomTask", "Ljava/lang/Runnable;", "mExpandHallInfoView", "Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallInfoView;", "mExpandHallRightDrawerView", "Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallRightDrawerView;", "mGroupMsgManager", "Lcom/tencent/timi/game/tim/api/group/IGroupManager;", "mHallInfo", "Ltrpc/yes/wuji/WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;", "mHallListener", "Lcom/tencent/timi/game/api/cb/ExpandHallListener;", "mHallState", "", "mHallState$annotations", "mInputStateChangeView", "com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$mInputStateChangeView$1", "Lcom/tencent/timi/game/expand/hall/impl/ExpandHallFragment$mInputStateChangeView$1;", "mIsInputViewNormal", "mJoinRoomTimeStamp", "mLaunchParam", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "mOnlineNum", "", "mOnlineNumListener", "com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$mOnlineNumListener$1", "Lcom/tencent/timi/game/expand/hall/impl/ExpandHallFragment$mOnlineNumListener$1;", "mQQUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "mReporterHelper", "Lcom/tencent/timi/game/expand/hall/api/HallReportHelper;", "mRoomIdFromServer", "mRoomLifecycleListener", "com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$mRoomLifecycleListener$1", "Lcom/tencent/timi/game/expand/hall/impl/ExpandHallFragment$mRoomLifecycleListener$1;", "mRoomListenerService", "Lcom/tencent/timi/game/room/api/wrapper/IRoomListenerService;", "mRootView", "Landroid/view/View;", "mSafeNoticeMsgManager", "Lcom/tencent/timi/game/expand/hall/impl/util/SafeNoticeMsgManager;", "mSmobaAuthView", "Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallSmobaAuthView;", "originWindowSoftInputMode", "Ljava/lang/Integer;", "acquireInputBoxView", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "acquireInputView", "Landroid/widget/EditText;", "adjStatusBarMargin", "", "applyWindowSoftInputMode", "bindReportInfo", "consumeTouchEvent", "ev", "Landroid/view/MotionEvent;", "createExpandHallRightDrawerView", "createExpandInfoView", "createSmobaAuthView", "currentRoomId", "delayCheckTask", "destroySelf", "doOnKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "finish", "exitSource", "getAttachedContext", "Lcom/tencent/mobileqq/app/QBaseActivity;", "getLaunchParam", "getReportHelper", "getRootView", "Landroid/view/ViewGroup;", "getURLDrawableOptions", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "igv", "Lcom/tencent/image/URLImageView;", "handleAutoExitTask", "data", "Lcom/tencent/mobileqq/guild/mainframe/attachcontainer/NotifyData;", "handleDelayJoinRoomTask", "handleLaunchParamOnJoinSucceed", "handleUiStyle", "initCreateTeamView", "initMicCardView", "initViews", "isMicCardWhiteListUser", "isWrapContent", "joinRoom", "joinRoomFailed", "errorCode", "errorMsg", "", "joinRoomSucceed", "roomInfo", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "loadCacheData", "micCardSwitch", "needImmersive", "onBackEvent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onDestroy", "onDestroyView", "onPause", "onResume", "onStart", "onViewCreated", "view", "openCreateSmobaTeam", "openHallSetting", "openRightDrawer", "parseIntent", "intent", "recoverWindowSoftInputMode", "refreshChannelInfo", "channelUin", "refreshChannelUI", "cIcon", "cName", "refreshHallUI", "pageData", "refreshOnlineNumUI", "registerGuildObserver", "setHallListener", "listener", "showExpandHallInfoView", "topGestureInterceptScroll", "intercept", "unRegisterGuildObserver", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallFragment
  extends TimiGameBaseFragment
  implements FamilyAtFunction, IExpandHall
{
  public static final ExpandHallFragment.Companion a = new ExpandHallFragment.Companion(null);
  private ExpandHallListener A;
  private Runnable B;
  private long C = 1L;
  private IRoomGetDataService D;
  private HashMap E;
  private ExpandHallInfoView b;
  private ExpandHallRightDrawerView c;
  private ExpandHallSmobaAuthView d;
  private long e;
  private boolean f = true;
  private ColorDrawable g = new ColorDrawable(16052712);
  private IRoomListenerService h;
  private IGroupManager i;
  private Integer j;
  private boolean k = true;
  private TimiGiftController l;
  private ExpandHallGMManager m = new ExpandHallGMManager();
  private final ExpandHallFragment.mOnlineNumListener.1 n = new ExpandHallFragment.mOnlineNumListener.1(this);
  private final ExpandHallFragment.mRoomLifecycleListener.1 o = new ExpandHallFragment.mRoomLifecycleListener.1(this);
  private WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf p;
  private int q;
  private ExpandHallLaunchParam r = new ExpandHallLaunchParam();
  private HallReportHelper s = new HallReportHelper(this.r);
  private final CommonOuterClass.QQUserId t = new CommonOuterClass.QQUserId();
  private final ExpandHallFragment.mAllRoomLifeCycleListener.1 u = new ExpandHallFragment.mAllRoomLifeCycleListener.1(this);
  private final ExpandHallFragment.mInputStateChangeView.1 v = new ExpandHallFragment.mInputStateChangeView.1(this);
  private long w;
  private final ExpandHallFragment.gpServiceObserver.1 x = new ExpandHallFragment.gpServiceObserver.1(this);
  private View y;
  private ExpandHallFragment.mAbsGestureListener.1 z = new ExpandHallFragment.mAbsGestureListener.1(this);
  
  private final void A()
  {
    if (this.b != null) {
      return;
    }
    if (this.p == null)
    {
      if (NetUtils.a.a(2131917230)) {
        QQToast.makeText(getContext(), 2131917230, 0).show();
      }
      return;
    }
    Object localObject = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "qBaseActivity");
    this.b = new ExpandHallInfoView((Context)localObject, null, 0, this.s, 6, null);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout)c(2131445143)).addView((View)this.b, (ViewGroup.LayoutParams)localObject);
    localObject = this.b;
    if (localObject != null)
    {
      QBaseActivity localQBaseActivity = getQBaseActivity();
      Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "qBaseActivity");
      ((ExpandHallInfoView)localObject).a(localQBaseActivity, this.p);
    }
    localObject = this.b;
    if (localObject != null) {
      ((ExpandHallInfoView)localObject).setSmobaAuthClickListener((View.OnClickListener)new ExpandHallFragment.createExpandInfoView.1(this));
    }
  }
  
  private final void B()
  {
    if (this.d != null) {
      return;
    }
    Object localObject = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "qBaseActivity");
    this.d = new ExpandHallSmobaAuthView((Context)localObject, null, 0, this.s, 6, null);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout)c(2131445143)).addView((View)this.d, (ViewGroup.LayoutParams)localObject);
    localObject = this.d;
    if (localObject != null)
    {
      QBaseActivity localQBaseActivity = getQBaseActivity();
      Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "qBaseActivity");
      ((ExpandHallSmobaAuthView)localObject).a(localQBaseActivity);
    }
    localObject = this.d;
    if (localObject != null) {
      ((ExpandHallSmobaAuthView)localObject).setOnBackListener((View.OnClickListener)new ExpandHallFragment.createSmobaAuthView.1(this));
    }
    localObject = this.d;
    if (localObject != null) {
      ((ExpandHallSmobaAuthView)localObject).setOnCloseListener((View.OnClickListener)new ExpandHallFragment.createSmobaAuthView.2(this));
    }
  }
  
  private final void C()
  {
    int i1 = ImmersiveUtils.getStatusBarHeight((Context)getQBaseActivity());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setStatusBarToLightStatus statusBarHeight:");
    ((StringBuilder)localObject1).append(i1);
    Logger.a("ExpandHallFragment_", ((StringBuilder)localObject1).toString());
    localObject1 = (LinearLayout)c(2131447700);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "topAreaLl");
    localObject1 = ((LinearLayout)localObject1).getLayoutParams();
    if (localObject1 != null)
    {
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setStatusBarToLightStatus lp.topMargin before:");
      ((StringBuilder)localObject2).append(((RelativeLayout.LayoutParams)localObject1).topMargin);
      Logger.a("ExpandHallFragment_", ((StringBuilder)localObject2).toString());
      ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, ((RelativeLayout.LayoutParams)localObject1).topMargin + i1, ((RelativeLayout.LayoutParams)localObject1).rightMargin, ((RelativeLayout.LayoutParams)localObject1).bottomMargin);
      localObject2 = (LinearLayout)c(2131447700);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "topAreaLl");
      ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
  }
  
  private final void D()
  {
    Object localObject1 = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "qBaseActivity");
    localObject1 = new GiftLayerBuilder((Context)localObject1);
    int i1;
    if (this.r.a == 1) {
      i1 = 10005;
    } else {
      i1 = 10004;
    }
    localObject1 = ((GiftLayerBuilder)localObject1).a(i1).a(this.t).a(this.e).b(2);
    Object localObject2 = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "qBaseActivity");
    localObject1 = ((GiftLayerBuilder)localObject1).a((QBaseActivity)localObject2);
    localObject2 = (RelativeLayout)c(2131445143);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "rootView");
    this.l = ((GiftLayerBuilder)localObject1).a((ViewGroup)localObject2);
    localObject1 = this.l;
    if (localObject1 != null)
    {
      localObject2 = c(2131434235);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "giftBannerPlaceHolder");
      ((TimiGiftController)localObject1).a((View)localObject2);
    }
    localObject1 = (SmobaAuthAndBindHintView)c(2131428878);
    localObject2 = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "qBaseActivity");
    ((SmobaAuthAndBindHintView)localObject1).a((QBaseActivity)localObject2);
  }
  
  private final URLDrawable.URLDrawableOptions a(URLImageView paramURLImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable;
    if (paramURLImageView.getDrawable() != null) {
      localDrawable = paramURLImageView.getDrawable();
    } else {
      localDrawable = (Drawable)this.g;
    }
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    if (paramURLImageView.getDrawable() != null) {
      paramURLImageView = paramURLImageView.getDrawable();
    } else {
      paramURLImageView = (Drawable)this.g;
    }
    localURLDrawableOptions.mFailedDrawable = paramURLImageView;
    Intrinsics.checkExpressionValueIsNotNull(localURLDrawableOptions, "options");
    return localURLDrawableOptions;
  }
  
  private final void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("joinRoomFailed errorCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", errorMsg:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", mHallState:");
    ((StringBuilder)localObject).append(this.C);
    Logger.a("ExpandHallFragment_", ((StringBuilder)localObject).toString());
    long l1 = this.C;
    int i1 = 1;
    if ((l1 != 3L) && (l1 != 4L))
    {
      IExpandHallService localIExpandHallService = (IExpandHallService)ServiceCenter.a(IExpandHallService.class);
      if (paramString != null) {
        localObject = paramString;
      } else {
        localObject = "";
      }
      localIExpandHallService.a(paramInt, (String)localObject, (IExpandHall)this);
      localObject = this.A;
      if (localObject != null) {
        ((ExpandHallListener)localObject).a(this.r.i, this.r, paramInt, paramString);
      }
      if ((920020 != paramInt) && (920022 != paramInt))
      {
        QQToast.makeText(getContext(), (CharSequence)"进房失败", 0).show();
        paramString = getQBaseActivity();
        Intrinsics.checkExpressionValueIsNotNull(paramString, "qBaseActivity");
        localObject = new CommonDialog.Builder((Context)paramString);
        if (NetUtils.a.a())
        {
          ((CommonDialog.Builder)localObject).a(17);
          paramString = "好像迷路了，没能正常进入房间";
        }
        else
        {
          ((CommonDialog.Builder)localObject).a(8388611);
          paramString = "当前网络不可用，请检查你的网络设置，点击重试";
        }
        ((CommonDialog.Builder)localObject).c(paramString);
        ((CommonDialog.Builder)localObject).d("刷新一下");
        ((CommonDialog.Builder)localObject).a((DialogInterface.OnClickListener)new ExpandHallFragment.joinRoomFailed.1(this));
        ((CommonDialog.Builder)localObject).e("退出大厅");
        ((CommonDialog.Builder)localObject).b((DialogInterface.OnClickListener)new ExpandHallFragment.joinRoomFailed.2(this));
        ((CommonDialog.Builder)localObject).b(true);
        ((CommonDialog.Builder)localObject).a().show();
        return;
      }
      localObject = (CharSequence)paramString;
      paramInt = i1;
      if (localObject != null) {
        if (((CharSequence)localObject).length() == 0) {
          paramInt = i1;
        } else {
          paramInt = 0;
        }
      }
      if (paramInt != 0) {
        paramString = "由于帐户异常，你暂时无法使用开黑扩列大厅功能";
      }
      QQToast.makeText(getContext(), (CharSequence)paramString, 0).show();
      a(3);
      return;
    }
    Logger.c("ExpandHallFragment_", 1, "joinRoomFailed hall already destroyed!");
  }
  
  private final void a(Bundle paramBundle)
  {
    try
    {
      paramBundle = (ExpandHallLaunchParam)paramBundle.getParcelable("key_expand_hall_launch_param");
      if (paramBundle != null) {
        this.r = paramBundle;
      }
      this.s = new HallReportHelper(this.r);
      this.t.guild_id.set(this.r.c);
      paramBundle = this.t.uid;
      IService localIService = ServiceCenter.a(ILoginCoreService.class);
      Intrinsics.checkExpressionValueIsNotNull(localIService, "ServiceCenter.getService…nCoreService::class.java)");
      paramBundle.set(((ILoginCoreService)localIService).a());
      paramBundle = this.t.user_from;
      int i2 = this.r.a;
      i1 = 1;
      if (i2 != 1) {
        break label173;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        label133:
        continue;
        label173:
        int i1 = 2;
      }
    }
    paramBundle.set(i1);
    break label133;
    Logger.c("ExpandHallFragment_", "parse mLaunchParam failed");
    paramBundle = new StringBuilder();
    paramBundle.append("mLaunchParam:");
    paramBundle.append(this.r);
    Logger.a("ExpandHallFragment_", paramBundle.toString());
  }
  
  private final void a(NotifyData paramNotifyData)
  {
    if (this.B == null) {
      return;
    }
    if ((paramNotifyData.a() == 3) && (paramNotifyData.b() == 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("data.curMoveState = ");
      localStringBuilder.append(paramNotifyData.a());
      localStringBuilder.append(", ");
      localStringBuilder.append("data.curMoveProgress=");
      localStringBuilder.append(paramNotifyData.b());
      Logger.a("ExpandHallFragment_", 1, localStringBuilder.toString());
      ThreadManagerV2.getUIHandlerV2().post(this.B);
      this.B = ((Runnable)null);
      Logger.a("ExpandHallFragment_", 1, "mDelayJoinRoomTask task handled");
    }
  }
  
  private final void a(IRoomGetDataService paramIRoomGetDataService)
  {
    if (!j())
    {
      Logger.d("ExpandHallFragment_", 1, "micCardSwitch is false!");
      paramIRoomGetDataService = (MicCardView)c(2131438163);
      Intrinsics.checkExpressionValueIsNotNull(paramIRoomGetDataService, "micCardView");
      paramIRoomGetDataService.setVisibility(8);
      return;
    }
    ((MicCardView)c(2131438163)).a(this.e);
    MicCardView localMicCardView = (MicCardView)c(2131438163);
    paramIRoomGetDataService = paramIRoomGetDataService.h();
    Intrinsics.checkExpressionValueIsNotNull(paramIRoomGetDataService, "data.speakingPosInfoList");
    localMicCardView.a(paramIRoomGetDataService);
  }
  
  private final void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      Object localObject = (RoundCornerImageView)c(2131430498);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "channelIcon");
      localObject = (URLImageView)localObject;
      RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)c(2131430498);
      Intrinsics.checkExpressionValueIsNotNull(localRoundCornerImageView, "channelIcon");
      CommonExKt.a((URLImageView)localObject, paramString1, a((URLImageView)localRoundCornerImageView));
    }
    if (paramString2 != null)
    {
      paramString1 = (TextView)c(2131430499);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "channelName");
      paramString1.setText((CharSequence)paramString2);
    }
  }
  
  private final void a(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("joinRoomSucceed mHallState:");
    ((StringBuilder)localObject1).append(this.C);
    Logger.a("ExpandHallFragment_", 1, ((StringBuilder)localObject1).toString());
    long l1 = this.C;
    if ((l1 != 3L) && (l1 != 4L))
    {
      this.e = paramYoloRoomInfo.room_id.get();
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new ExpandHallFragment.joinRoomSucceed.1(this));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("joinRoomSucceed mRoomIdFromServer:");
      ((StringBuilder)localObject1).append(this.e);
      Logger.a("ExpandHallFragment_", ((StringBuilder)localObject1).toString());
      localObject1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.e);
      this.D = ((IRoomGetDataService)localObject1);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "data");
      int i1 = ((IRoomGetDataService)localObject1).a();
      this.s.a(this.e);
      this.s.a(i1);
      ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a(this.e, (IExpandHall)this);
      Object localObject2 = this.A;
      if (localObject2 != null) {
        ((ExpandHallListener)localObject2).a(this.e, this.r, getQBaseActivity());
      }
      w();
      this.w = System.currentTimeMillis();
      ((IReportService)ServiceCenter.a(IReportService.class)).a("ev_yes_room_in", this.s.v());
      this.h = ((IRoomService)ServiceCenter.a(IRoomService.class)).c(this.e);
      localObject2 = this.h;
      if (localObject2 != null) {
        ((IRoomListenerService)localObject2).a((YoloRoomInterface.YoloRoomCommonListener)this.n);
      }
      this.p = ((IRoomGetDataService)localObject1).c().yolo_room_community_conf.wuji_yolo_room_community_conf;
      ExpandHallInfoCacheManager.a.a(this.p);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("joinRoomSucceed pageData:");
      ((StringBuilder)localObject2).append(this.p);
      Logger.a("ExpandHallFragment_", ((StringBuilder)localObject2).toString());
      this.q = ((IRoomGetDataService)localObject1).e();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("joinRoomSucceed mOnlineNum:");
      ((StringBuilder)localObject2).append(this.q);
      Logger.a("ExpandHallFragment_", ((StringBuilder)localObject2).toString());
      localObject2 = this.p;
      if (localObject2 != null) {
        a((WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf)localObject2);
      }
      SafeNoticeMsgManager.a.a(new SafeNoticeMsgManager(this.t, paramYoloRoomInfo.room_id.get(), paramYoloRoomInfo.tim_group_id.get()));
      ((GroupChatView)c(2131434395)).b();
      ((GroupChatView)c(2131434395)).a(ConvType.Group, paramYoloRoomInfo, this.t);
      ((GroupChatView)c(2131434395)).setMessageListener((IMessageListener)new ExpandHallFragment.joinRoomSucceed.3(this));
      ((GroupChatView)c(2131434395)).setMsgSendStatusListener((ChatView.IMsgSendStatusListener)new ExpandHallFragment.joinRoomSucceed.4(this));
      this.i = ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).d();
      paramYoloRoomInfo = this.h;
      if (paramYoloRoomInfo != null) {
        paramYoloRoomInfo.a((YoloRoomInterface.YoloRoomLifecycleListener)this.o);
      }
      a((IRoomGetDataService)localObject1);
      o();
      return;
    }
    Logger.c("ExpandHallFragment_", 1, "joinRoomSucceed hall already destroyed!");
  }
  
  private final void a(WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf paramWujiYoloCommunityRoomConf)
  {
    Object localObject1 = paramWujiYoloCommunityRoomConf.room_background_img_v2.get();
    Object localObject2;
    Object localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshHallUI bgUrl:");
      ((StringBuilder)localObject2).append((String)localObject1);
      Logger.a("ExpandHallFragment_", ((StringBuilder)localObject2).toString());
      localObject2 = (URLImageView)c(2131447702);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "topBgIgv");
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "bgUrl");
      localObject3 = (URLImageView)c(2131447702);
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "topBgIgv");
      CommonExKt.a((URLImageView)localObject2, (String)localObject1, a((URLImageView)localObject3));
    }
    if (this.r.a != 2)
    {
      localObject1 = paramWujiYoloCommunityRoomConf.room_cover.get();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshHallUI  iconUrl:");
      ((StringBuilder)localObject2).append((String)localObject1);
      Logger.a("ExpandHallFragment_", ((StringBuilder)localObject2).toString());
      localObject2 = (RoundCornerImageView)c(2131434888);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "headIgv");
      localObject2 = (URLImageView)localObject2;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "iconUrl");
      localObject3 = (RoundCornerImageView)c(2131434888);
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "headIgv");
      CommonExKt.a((URLImageView)localObject2, (String)localObject1, a((URLImageView)localObject3));
      localObject1 = (TextView)c(2131434792);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "hallName");
      ((TextView)localObject1).setText((CharSequence)paramWujiYoloCommunityRoomConf.introduce.get());
      u();
      return;
    }
    paramWujiYoloCommunityRoomConf = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(paramWujiYoloCommunityRoomConf, "qBaseActivity");
    paramWujiYoloCommunityRoomConf = paramWujiYoloCommunityRoomConf.getAppRuntime().getRuntimeService(IGPSService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(paramWujiYoloCommunityRoomConf, "qBaseActivity.appRuntime…nt.MAIN\n                )");
    paramWujiYoloCommunityRoomConf = ((IGPSService)paramWujiYoloCommunityRoomConf).getChannelInfo(this.r.f);
    if (paramWujiYoloCommunityRoomConf != null)
    {
      paramWujiYoloCommunityRoomConf = paramWujiYoloCommunityRoomConf.getChannelName();
      if (paramWujiYoloCommunityRoomConf != null) {}
    }
    else
    {
      paramWujiYoloCommunityRoomConf = this.r.d;
    }
    a(this.r.e, paramWujiYoloCommunityRoomConf);
  }
  
  private final void a(boolean paramBoolean) {}
  
  private final boolean a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.c;
    boolean bool;
    if (localObject != null) {
      bool = ((ExpandHallRightDrawerView)localObject).a();
    } else {
      bool = false;
    }
    if (bool)
    {
      Logger.b("ExpandHallFragment_", "consumeTouchEvent consumed=true");
      return bool;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add((TeamListView)c(2131446859));
    ((ArrayList)localObject).add((MicCardView)c(2131438163));
    Iterator localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (View)localIterator.next();
      TouchUtil localTouchUtil = TouchUtil.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "view");
      bool = localTouchUtil.a((View)localObject, paramMotionEvent);
      if (bool)
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("consumeTouchEvent is touched on ");
        paramMotionEvent.append(localObject);
        Logger.b("ExpandHallFragment_", paramMotionEvent.toString());
        return bool;
      }
    }
    paramMotionEvent = new StringBuilder();
    paramMotionEvent.append("consumeTouchEvent consumed=");
    paramMotionEvent.append(bool);
    Logger.b("ExpandHallFragment_", paramMotionEvent.toString());
    return bool;
  }
  
  private final void b(NotifyData paramNotifyData)
  {
    if ((paramNotifyData.a() == 3) && (paramNotifyData.b() == 1000))
    {
      boolean bool = j();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleAutoExitTask Total collapse. data.curMoveState = ");
      localStringBuilder.append(paramNotifyData.a());
      localStringBuilder.append(", ");
      localStringBuilder.append("data.curMoveProgress=");
      localStringBuilder.append(paramNotifyData.b());
      localStringBuilder.append(" micSwitch=");
      localStringBuilder.append(bool);
      localStringBuilder.append(", mHallInfo:");
      localStringBuilder.append(this.p);
      Logger.a("ExpandHallFragment_", 1, localStringBuilder.toString());
      if ((this.p == null) || (bool)) {
        ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).closeAppChannel(getQBaseActivity(), new ChannelData(this.r.f));
      }
    }
  }
  
  private final void b(String paramString)
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "qBaseActivity");
    paramString = ((IGPSService)localQBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).getChannelInfo(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "channelInfo");
    a(paramString.getChannelUin(), paramString.getChannelName());
  }
  
  private final void m()
  {
    if (!this.k) {
      return;
    }
    Object localObject = this.j;
    if (localObject != null)
    {
      int i1 = ((Integer)localObject).intValue();
      localObject = getActivity();
      if (localObject != null)
      {
        localObject = ((FragmentActivity)localObject).getWindow();
        if (localObject != null) {
          ((Window)localObject).setSoftInputMode(i1 & 0xF | 0x10);
        }
      }
    }
  }
  
  private final void n()
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      int i1 = ((Number)localObject).intValue();
      localObject = getActivity();
      if (localObject != null)
      {
        localObject = ((FragmentActivity)localObject).getWindow();
        if (localObject != null) {
          ((Window)localObject).setSoftInputMode(i1);
        }
      }
    }
  }
  
  private final void o()
  {
    if (this.r.h)
    {
      Logger.a("ExpandHallFragment_", "handleLaunchParamOnJoinSucceed autoShowTeamList");
      f();
    }
    int i1;
    if (this.r.a == 2) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    if (this.r.g != 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleLaunchParamOnJoinSucceed auto join team(");
      localStringBuilder.append(this.r.g);
      localStringBuilder.append(')');
      Logger.a("ExpandHallFragment_", localStringBuilder.toString());
      ((IRoomService)ServiceCenter.a(IRoomService.class)).a(true, (Activity)getQBaseActivity(), this.r.g, i1, 1, 1, 0, 0, (List)new ArrayList(), false, this.s.u(), 0L, (IResultListener)new ExpandHallFragment.handleLaunchParamOnJoinSucceed.1(this));
    }
  }
  
  private final void p()
  {
    if (this.r.a == 2)
    {
      localObject = (RelativeLayout)c(2131434890);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "headInfoArea");
      ((RelativeLayout)localObject).setVisibility(8);
      localObject = (LinearLayout)c(2131434891);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "headInfoAreaGuildStyle");
      ((LinearLayout)localObject).setVisibility(0);
      return;
    }
    Object localObject = (RelativeLayout)c(2131434890);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "headInfoArea");
    ((RelativeLayout)localObject).setVisibility(0);
    localObject = (LinearLayout)c(2131434891);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "headInfoAreaGuildStyle");
    ((LinearLayout)localObject).setVisibility(8);
  }
  
  private final void q()
  {
    WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf localWujiYoloCommunityRoomConf = ExpandHallInfoCacheManager.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hallInfo from cache:");
    localStringBuilder.append(localWujiYoloCommunityRoomConf);
    Logger.a("ExpandHallFragment_", localStringBuilder.toString());
    if (localWujiYoloCommunityRoomConf != null) {
      a(localWujiYoloCommunityRoomConf);
    }
  }
  
  private final void r()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("joinRoom mRoomId:");
    ((StringBuilder)localObject1).append(this.r.i);
    Logger.a("ExpandHallFragment_", 1, ((StringBuilder)localObject1).toString());
    dK_();
    localObject1 = new ExpandHallFragment.joinRoom.joinListener.1(this);
    Object localObject2;
    if (this.r.a == 2)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("joinRoom#from guild. param:");
      ((StringBuilder)localObject2).append(this.r);
      Logger.a("ExpandHallFragment_", 1, ((StringBuilder)localObject2).toString());
      if (this.B != null) {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.B);
      }
      this.B = ((Runnable)new ExpandHallFragment.joinRoom.1(this, (ExpandHallFragment.joinRoom.joinListener.1)localObject1));
      s();
      return;
    }
    if (this.r.j)
    {
      Logger.a("ExpandHallFragment_", 1, "joinRoom#from AssignedRoom");
      ((IRoomService)ServiceCenter.a(IRoomService.class)).a(false, (Activity)getQBaseActivity(), this.r.i, 1, 1, 5, 0, 0, null, false, this.s.u(), 0L, (IResultListener)localObject1);
      localObject2 = this.m;
      localObject1 = this.y;
      if (localObject1 != null) {
        localObject1 = ((View)localObject1).findViewById(2131434289);
      } else {
        localObject1 = null;
      }
      ((ExpandHallGMManager)localObject2).a((View)localObject1, this.r);
      return;
    }
    Logger.a("ExpandHallFragment_", 1, "joinRoom#from expand");
    ((IRoomService)ServiceCenter.a(IRoomService.class)).a((Activity)getQBaseActivity(), 1, (IResultListener)localObject1);
  }
  
  private final void s()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "qBaseActivity");
    ((IGPSService)localQBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).addObserver((GPServiceObserver)this.x);
    ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).addGestureListener(getQBaseActivity(), (AbsGestureListener)this.z);
    Logger.a("ExpandHallFragment_", "registerGuildObserver finish");
  }
  
  private final void t()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "qBaseActivity");
    ((IGPSService)localQBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).deleteObserver((GPServiceObserver)this.x);
    ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).removeGestureListener(getQBaseActivity(), (AbsGestureListener)this.z);
    Logger.a("ExpandHallFragment_", "unRegisterGuildObserver finish");
  }
  
  private final void u()
  {
    Object localObject1 = this.p;
    if (localObject1 != null)
    {
      localObject1 = ((WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf)localObject1).online_num_items;
      if (localObject1 != null)
      {
        localObject2 = ((PBRepeatMessageField)localObject1).get();
        break label28;
      }
    }
    Object localObject2 = null;
    label28:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("refreshOnlineNumUI mOnlineNum:");
    ((StringBuilder)localObject1).append(this.q);
    ((StringBuilder)localObject1).append(", numConfigList:");
    ((StringBuilder)localObject1).append(localObject2);
    Logger.a("ExpandHallFragment_", ((StringBuilder)localObject1).toString());
    if ((this.q >= 0) && (localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject1 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (WujiYoloRoomOuterClass.WujiYoloRoomCommunityOnlineNumItem)((Iterator)localObject1).next();
        int i1;
        if ((this.q >= ((WujiYoloRoomOuterClass.WujiYoloRoomCommunityOnlineNumItem)localObject3).min.get()) && (this.q <= ((WujiYoloRoomOuterClass.WujiYoloRoomCommunityOnlineNumItem)localObject3).max.get())) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0)
        {
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = ((List)localObject2).listIterator(((List)localObject2).size());
            while (((ListIterator)localObject2).hasPrevious())
            {
              localObject1 = (WujiYoloRoomOuterClass.WujiYoloRoomCommunityOnlineNumItem)((ListIterator)localObject2).previous();
              if (this.q >= ((WujiYoloRoomOuterClass.WujiYoloRoomCommunityOnlineNumItem)localObject1).min.get()) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              if (i1 != 0) {
                break label253;
              }
            }
            throw ((Throwable)new NoSuchElementException("List contains no element matching the predicate."));
          }
          label253:
          if (localObject1 == null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("refreshOnlineNumUI can not find fine config! mOnlineNum:");
            ((StringBuilder)localObject1).append(this.q);
            Logger.c("ExpandHallFragment_", ((StringBuilder)localObject1).toString());
            return;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("refreshOnlineNumUI  mOnlineNum:");
          ((StringBuilder)localObject2).append(this.q);
          ((StringBuilder)localObject2).append(", min:");
          ((StringBuilder)localObject2).append(((WujiYoloRoomOuterClass.WujiYoloRoomCommunityOnlineNumItem)localObject1).min.get());
          ((StringBuilder)localObject2).append(", max:");
          ((StringBuilder)localObject2).append(((WujiYoloRoomOuterClass.WujiYoloRoomCommunityOnlineNumItem)localObject1).max.get());
          Logger.a("ExpandHallFragment_", ((StringBuilder)localObject2).toString());
          localObject2 = ((WujiYoloRoomOuterClass.WujiYoloRoomCommunityOnlineNumItem)localObject1).icon.get();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("refreshOnlineNumUI iconUrl=");
          ((StringBuilder)localObject3).append((String)localObject2);
          Logger.a("ExpandHallFragment_", ((StringBuilder)localObject3).toString());
          localObject3 = (URLImageView)c(2131439569);
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "onlineIconIgv");
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "iconUrl");
          URLImageView localURLImageView = (URLImageView)c(2131439569);
          Intrinsics.checkExpressionValueIsNotNull(localURLImageView, "onlineIconIgv");
          CommonExKt.a((URLImageView)localObject3, (String)localObject2, a(localURLImageView));
          localObject2 = (URLImageView)c(2131439569);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "onlineIconIgv");
          ((URLImageView)localObject2).setVisibility(0);
          localObject2 = (TextView)c(2131439570);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "onlineNumTxv");
          ((TextView)localObject2).setText((CharSequence)((WujiYoloRoomOuterClass.WujiYoloRoomCommunityOnlineNumItem)localObject1).text.get());
          localObject2 = (TextView)c(2131439570);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "onlineNumTxv");
          ((TextView)localObject2).setVisibility(0);
          try
          {
            i1 = Color.parseColor(((WujiYoloRoomOuterClass.WujiYoloRoomCommunityOnlineNumItem)localObject1).text_color.get());
            ((TextView)c(2131439570)).setTextColor(i1);
            return;
          }
          catch (Exception localException)
          {
            Logger.b("ExpandHallFragment_", "parseColor failed, ", (Throwable)localException);
            return;
          }
        }
      }
      throw ((Throwable)new NoSuchElementException("Collection contains no element matching the predicate."));
    }
    Logger.c("ExpandHallFragment_", "refreshOnlineNumUI bad data,can not show online num");
  }
  
  private final void v()
  {
    ((RelativeLayout)c(2131445143)).setOnClickListener((View.OnClickListener)ExpandHallFragment.initViews.1.a);
    ((RoundCornerImageView)c(2131434888)).setRadius(CommonExKt.b(9));
    ((ImageView)c(2131429214)).setOnClickListener((View.OnClickListener)new ExpandHallFragment.initViews.2(this));
    ((ImageView)c(2131432657)).setOnClickListener((View.OnClickListener)new ExpandHallFragment.initViews.3(this));
    ((RelativeLayout)c(2131434890)).setOnClickListener((View.OnClickListener)new ExpandHallFragment.initViews.4(this));
    ((TeamListView)c(2131446859)).setOnMoreClickListener((View.OnClickListener)new ExpandHallFragment.initViews.5(this));
    x();
    if (this.r.a == 2)
    {
      localObject1 = (LinearLayout)c(2131431495);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "createTeamArea");
      ((LinearLayout)localObject1).setVisibility(8);
      ((ImageView)c(2131432657)).setOnClickListener((View.OnClickListener)new ExpandHallFragment.initViews.6(this));
      localObject1 = GuildUtil.a;
      Object localObject2 = getQBaseActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "qBaseActivity");
      localObject2 = ((QBaseActivity)localObject2).getAppRuntime();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "qBaseActivity.appRuntime");
      if (!((GuildUtil)localObject1).a((AppRuntime)localObject2, String.valueOf(this.r.c)))
      {
        localObject1 = (ImageView)c(2131432657);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "expandHallInfoIgv");
        ((ImageView)localObject1).setVisibility(8);
        return;
      }
      localObject1 = (ImageView)c(2131432657);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "expandHallInfoIgv");
      ((ImageView)localObject1).setVisibility(0);
      return;
    }
    Object localObject1 = (LinearLayout)c(2131431495);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "createTeamArea");
    ((LinearLayout)localObject1).setVisibility(0);
    ((LinearLayout)c(2131431495)).setOnClickListener((View.OnClickListener)new ExpandHallFragment.initViews.7(this));
    localObject1 = (ImageView)c(2131432657);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "expandHallInfoIgv");
    ((ImageView)localObject1).setVisibility(8);
  }
  
  private final void w()
  {
    IReportService localIReportService = (IReportService)ServiceCenter.a(IReportService.class);
    Object localObject = (RelativeLayout)c(2131434890);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "headInfoArea");
    IReportService.DefaultImpls.a(localIReportService, (View)localObject, false, null, this.s.b(), (Map)this.s.s(), 6, null);
    localIReportService = (IReportService)ServiceCenter.a(IReportService.class);
    localObject = (LinearLayout)c(2131431495);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "createTeamArea");
    IReportService.DefaultImpls.a(localIReportService, (View)localObject, false, null, "em_yes_create_team", (Map)this.s.s(), 6, null);
    localIReportService = (IReportService)ServiceCenter.a(IReportService.class);
    localObject = (ImageView)c(2131432657);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "expandHallInfoIgv");
    IReportService.DefaultImpls.b(localIReportService, (View)localObject, false, null, this.s.c(), (Map)this.s.s(), 6, null);
    ((TeamListView)c(2131446859)).f();
  }
  
  private final void x()
  {
    ImageView localImageView = (ImageView)c(2131431496);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "createTeamView");
    localImageView.setVisibility(8);
    ((ImageView)c(2131431496)).setOnClickListener((View.OnClickListener)new ExpandHallFragment.initCreateTeamView.1(this));
    ((GroupChatView)c(2131434395)).a((TimiBaseInputView.StateChangedListener)this.v);
  }
  
  private final void y()
  {
    A();
    ExpandHallInfoView localExpandHallInfoView = this.b;
    if (localExpandHallInfoView != null) {
      localExpandHallInfoView.a();
    }
  }
  
  private final void z()
  {
    if (this.c != null) {
      return;
    }
    Object localObject = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "qBaseActivity");
    this.c = new ExpandHallRightDrawerView((Context)localObject, null, 0, 6, null);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ExpandHallRightDrawerView localExpandHallRightDrawerView = this.c;
    if (localExpandHallRightDrawerView != null) {
      localExpandHallRightDrawerView.a((ViewStateChangeListener)new ExpandHallFragment.createExpandHallRightDrawerView.1(this));
    }
    ((RelativeLayout)c(2131445143)).addView((View)this.c, (ViewGroup.LayoutParams)localObject);
  }
  
  @Nullable
  public ViewGroup a()
  {
    return (RelativeLayout)c(2131445143);
  }
  
  public final void a(@Nullable ExpandHallListener paramExpandHallListener)
  {
    this.A = paramExpandHallListener;
  }
  
  public boolean a(int paramInt)
  {
    ExpandHallListener localExpandHallListener = this.A;
    if (localExpandHallListener != null)
    {
      boolean bool = localExpandHallListener.a(paramInt, this.r, getQBaseActivity());
      if (bool) {
        return bool;
      }
    }
    return super.a(paramInt);
  }
  
  @NotNull
  public ExpandHallLaunchParam b()
  {
    return this.s.w();
  }
  
  public View c(int paramInt)
  {
    if (this.E == null) {
      this.E = new HashMap();
    }
    View localView2 = (View)this.E.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = getView();
      if (localView1 == null) {
        return null;
      }
      localView1 = localView1.findViewById(paramInt);
      this.E.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @Nullable
  public EditText c()
  {
    return ((GroupChatView)c(2131434395)).c();
  }
  
  public void d()
  {
    HashMap localHashMap = this.E;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  @Nullable
  public TimiBaseInputView dJ_()
  {
    return ((GroupChatView)c(2131434395)).dJ_();
  }
  
  public boolean doOnKeyDown(int paramInt, @Nullable KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Object localObject = this.l;
      if ((localObject != null) && (((TimiGiftController)localObject).c() == true))
      {
        paramKeyEvent = this.l;
        if (paramKeyEvent != null) {
          paramKeyEvent.b();
        }
        return true;
      }
      localObject = this.A;
      if (localObject != null)
      {
        boolean bool = ((ExpandHallListener)localObject).a(1, this.r, getQBaseActivity());
        if (bool) {
          return bool;
        }
      }
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  @NotNull
  public HallReportHelper e()
  {
    return this.s;
  }
  
  public void f()
  {
    z();
    ((GroupChatView)c(2131434395)).a();
    ExpandHallRightDrawerView localExpandHallRightDrawerView = this.c;
    if (localExpandHallRightDrawerView != null) {
      localExpandHallRightDrawerView.b();
    }
  }
  
  public void g()
  {
    int i1 = b().a;
    ITeamService localITeamService = (ITeamService)ServiceCenter.a(ITeamService.class);
    Activity localActivity = (Activity)getQBaseActivity();
    if (i1 == 1) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    localITeamService.a(localActivity, i1, 1, this.e, this.s.u());
  }
  
  public long h()
  {
    return this.e;
  }
  
  public void i()
  {
    if (this.r.a != 2)
    {
      getQBaseActivity().finish();
      return;
    }
    ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).closeAppChannel(getQBaseActivity(), new ChannelData(this.r.f));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean j()
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = ((WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf)localObject).speaking_list_switch;
      if (localObject != null)
      {
        bool = ((PBBoolField)localObject).get();
        break label28;
      }
    }
    boolean bool = false;
    label28:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("micCardSwitch:");
    ((StringBuilder)localObject).append(bool);
    Logger.b("ExpandHallFragment_", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public boolean k()
  {
    Object localObject = this.D;
    if (localObject != null)
    {
      localObject = ((IRoomGetDataService)localObject).d();
      if (localObject != null)
      {
        localObject = ((YoloRoomOuterClass.YoloRoomUserData)localObject).yolo_room_user_white_list;
        if (localObject != null)
        {
          localObject = ((YoloRoomOuterClass.YoloRoomUserWhiteList)localObject).is_community_host;
          if (localObject != null)
          {
            bool = ((PBBoolField)localObject).get();
            break label48;
          }
        }
      }
    }
    boolean bool = false;
    label48:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isMicCardWhiteListUser:");
    ((StringBuilder)localObject).append(bool);
    Logger.b("ExpandHallFragment_", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public void l()
  {
    ((GroupChatView)c(2131434395)).a();
    y();
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.d;
    boolean bool2 = false;
    if ((localObject != null) && (((ExpandHallSmobaAuthView)localObject).getState() == 1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("smobaAuthViewShowing:");
    ((StringBuilder)localObject).append(bool1);
    Logger.a("ExpandHallFragment_", ((StringBuilder)localObject).toString());
    if (bool1)
    {
      localObject = this.d;
      if (localObject != null)
      {
        localObject = ((ExpandHallSmobaAuthView)localObject).getOnBackListener();
        if (localObject != null) {
          ((View.OnClickListener)localObject).onClick(null);
        }
      }
      localObject = this.d;
      if (localObject != null) {
        ((ExpandHallSmobaAuthView)localObject).b();
      }
      return true;
    }
    localObject = this.b;
    if ((localObject != null) && (((ExpandHallInfoView)localObject).getState() == 1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("expandHallInfoShowing:");
    ((StringBuilder)localObject).append(bool1);
    Logger.a("ExpandHallFragment_", ((StringBuilder)localObject).toString());
    if (bool1)
    {
      localObject = this.b;
      if (localObject != null) {
        ((ExpandHallInfoView)localObject).b();
      }
      return true;
    }
    localObject = this.c;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((ExpandHallRightDrawerView)localObject).getState() == 1) {
        bool1 = true;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("expandHallRightDrawerShowing:");
    ((StringBuilder)localObject).append(bool1);
    Logger.a("ExpandHallFragment_", ((StringBuilder)localObject).toString());
    if (bool1)
    {
      localObject = this.c;
      if (localObject != null) {
        ((ExpandHallRightDrawerView)localObject).c();
      }
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.C = 2L;
    paramBundle = new StringBuilder();
    paramBundle.append("onCreate in, this:");
    paramBundle.append(this);
    Logger.a("ExpandHallFragment_", 1, paramBundle.toString());
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramBundle, "this");
      a(paramBundle);
    }
    ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a((IExpandHall)this);
    paramBundle = getActivity();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getWindow();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getAttributes();
        if (paramBundle != null) {
          paramBundle = Integer.valueOf(paramBundle.softInputMode);
        } else {
          paramBundle = null;
        }
        this.j = paramBundle;
        Logger.a("ExpandHallFragment_", "apply adjust resize # onCreate");
        m();
      }
    }
    paramBundle = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "ServiceCenter.getService…nCoreService::class.java)");
    long l1 = ((ILoginCoreService)paramBundle).a();
    ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).c(l1, null);
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    Logger.a("ExpandHallFragment_", "onCreateView in");
    paramBundle = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "qBaseActivity");
    StatusBarUtil.b(paramBundle.getWindow());
    this.y = paramLayoutInflater.inflate(2131629517, paramViewGroup, false);
    paramLayoutInflater = this.y;
    if (paramLayoutInflater != null) {
      ((IReportService)ServiceCenter.a(IReportService.class)).a((Fragment)this, paramLayoutInflater, this.s.a());
    }
    ((ITimiGameTestService)ServiceCenter.a(ITimiGameTestService.class)).a(this.y);
    paramLayoutInflater = this.y;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((IRoomListenerService)localObject).b((YoloRoomInterface.YoloRoomCommonListener)this.n);
    }
    localObject = this.h;
    if (localObject != null) {
      ((IRoomListenerService)localObject).b((YoloRoomInterface.YoloRoomLifecycleListener)this.o);
    }
    this.i = ((IGroupManager)null);
    SafeNoticeMsgManager.a.a((SafeNoticeMsgManager)null);
    if (this.e != 0L) {
      ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.e, true, 0, null, false);
    }
    ((IRoomService)ServiceCenter.a(IRoomService.class)).b((YoloRoomInterface.YoloRoomLifecycleListener)this.u);
    if (this.w != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.w;
      localObject = new HashMap();
      ((HashMap)localObject).putAll(this.s.v());
      localObject = (Map)localObject;
      ((Map)localObject).put("yes_room_lvtm", String.valueOf(l1 - l2));
      ((Map)localObject).put("yes_leave_reason", "normal-leave");
      ((IReportService)ServiceCenter.a(IReportService.class)).a("ev_yes_room_out", (Map)localObject);
    }
    ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).b((IExpandHall)this);
    TeamInfoAutoUpdateService.a().c();
    t();
    ((IniterService)ServiceCenter.a(IniterService.class)).a("ExpandHallFragment.destroy");
    Logger.a("ExpandHallFragment_", "onDestroy");
    n();
    super.onDestroy();
    this.C = 4L;
    if (this.r.a == 1)
    {
      GiftSdkInitManager.a.b(10005);
      return;
    }
    if (this.r.a == 2) {
      GiftSdkInitManager.a.b(10004);
    }
  }
  
  public void onDestroyView()
  {
    this.C = 3L;
    this.B = ((Runnable)null);
    Logger.a("ExpandHallFragment_", "onDestroyView");
    ((GroupChatView)c(2131434395)).b((TimiBaseInputView.StateChangedListener)this.v);
    ((GroupChatView)c(2131434395)).b();
    ((TeamListView)c(2131446859)).e();
    TimiGiftController localTimiGiftController = this.l;
    if (localTimiGiftController != null) {
      localTimiGiftController.a(true);
    }
    ((MicCardView)c(2131438163)).a();
    super.onDestroyView();
    d();
  }
  
  public void onPause()
  {
    super.onPause();
    Logger.a("ExpandHallFragment_", "recover origin window soft input mode # onResume");
    n();
  }
  
  public void onResume()
  {
    super.onResume();
    Logger.a("ExpandHallFragment_", "apply adjust resize # onResume");
    m();
  }
  
  public void onStart()
  {
    super.onStart();
    ExpandHallRightDrawerView localExpandHallRightDrawerView = this.c;
    if ((localExpandHallRightDrawerView != null) && (localExpandHallRightDrawerView.a() == true))
    {
      a(false);
      return;
    }
    a(true);
  }
  
  public void onViewCreated(@NotNull View paramView, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    TimeDetector localTimeDetector = TimeDetector.a().b();
    super.onViewCreated(paramView, paramBundle);
    p();
    localTimeDetector.a("ExpandHallFragment_", "super.onViewCreated");
    C();
    v();
    localTimeDetector.a("ExpandHallFragment_", "initViews");
    q();
    localTimeDetector.a("ExpandHallFragment_", "loadCacheData");
    r();
    localTimeDetector.a("ExpandHallFragment_", "joinRoom-doOnCreate end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallFragment
 * JD-Core Version:    0.7.0.1
 */