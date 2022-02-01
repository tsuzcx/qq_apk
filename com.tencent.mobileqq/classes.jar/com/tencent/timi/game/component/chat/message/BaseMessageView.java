package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.datareport.api.IReportService.DefaultImpls;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.AutoUpdateServiceListener;
import com.tencent.timi.game.tim.api.impl.ex.LongExKt;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import com.tencent.timi.game.ui.utils.TimeUtils;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.userinfo.impl.view.TimiAvatarRoundImageViewImpl;
import com.tencent.timi.game.userinfo.impl.view.TimiAvatarTextViewImpl;
import com.tencent.timi.game.utils.IResultListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.OnlineRouteInfo;
import trpc.yes.common.CommonOuterClass.OnlineRouteInfoList;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.CommonOuterClass.RoomRouteInfo;
import trpc.yes.common.PremadesTeamServerOuterClass.UserOnlineRouteInfoList;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "Lcom/tencent/timi/game/component/chat/message/TouchPositionGetableRelativeLayout;", "Lcom/tencent/timi/game/component/chat/message/IMessageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "filterForwardOption", "", "getFilterForwardOption", "()Ljava/lang/Boolean;", "setFilterForwardOption", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "iImConfig", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$IIMConfig;", "getIImConfig", "()Lcom/tencent/timi/game/component/chat/message/MessageLayout$IIMConfig;", "setIImConfig", "(Lcom/tencent/timi/game/component/chat/message/MessageLayout$IIMConfig;)V", "iMessageListener", "Lcom/tencent/timi/game/component/chat/message/IMessageListener;", "getIMessageListener", "()Lcom/tencent/timi/game/component/chat/message/IMessageListener;", "setIMessageListener", "(Lcom/tencent/timi/game/component/chat/message/IMessageListener;)V", "lastPointerRawX", "lastPointerRawY", "messageViewOperator", "Lcom/tencent/timi/game/component/chat/message/MessageViewOperator;", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "getMsg", "()Lcom/tencent/timi/game/tim/api/message/IMsg;", "setMsg", "(Lcom/tencent/timi/game/tim/api/message/IMsg;)V", "onAvatarClickListener", "Landroid/view/View$OnClickListener;", "onAvatarLongClickListener", "Landroid/view/View$OnLongClickListener;", "onLongClickListner", "getOnLongClickListner", "()Landroid/view/View$OnLongClickListener;", "setOnLongClickListner", "(Landroid/view/View$OnLongClickListener;)V", "onResendClick", "onlineStatusDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getOnlineStatusDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "onlineStatusDrawable$delegate", "Lkotlin/Lazy;", "positionOnTouchListener", "Landroid/view/View$OnTouchListener;", "getPositionOnTouchListener", "()Landroid/view/View$OnTouchListener;", "reportParam", "", "", "getReportParam", "()Ljava/util/Map;", "setReportParam", "(Ljava/util/Map;)V", "roomInfo", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "getRoomInfo", "()Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "setRoomInfo", "(Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;)V", "routeInfoRoomId", "", "selfQQUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "getSelfQQUserId", "()Ltrpc/yes/common/CommonOuterClass$QQUserId;", "setSelfQQUserId", "(Ltrpc/yes/common/CommonOuterClass$QQUserId;)V", "sendingDrawable", "teamUpdateListener", "com/tencent/timi/game/component/chat/message/BaseMessageView$teamUpdateListener$1", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView$teamUpdateListener$1;", "alwaysAlignLeft", "getLongOperOptions", "", "Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "()[Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "isSelf", "needAvatar", "needBottomMarginSpecial", "needShowTime", "onAttachedToWindow", "", "onDetachedFromWindow", "performAvatarClick", "uid", "refresh", "qqUserId", "preMsg", "renderUI", "setContentView", "view", "Landroid/view/View;", "layoutResID", "setImConfig", "config", "setMessageListener", "listener", "setYoloRoomInfo", "shouldShowSenderNick", "shouldShowSendingAnimate", "updateAvatarStatus", "userOnlineRouteInfoList", "Ltrpc/yes/common/PremadesTeamServerOuterClass$UserOnlineRouteInfoList;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class BaseMessageView
  extends TouchPositionGetableRelativeLayout
  implements IMessageView
{
  private Drawable a;
  private Drawable b;
  @Nullable
  private IMsg c;
  private int d;
  private int e;
  private MessageViewOperator f = new MessageViewOperator();
  @Nullable
  private MessageLayout.IIMConfig g;
  @Nullable
  private YoloRoomOuterClass.YoloRoomInfo h;
  @Nullable
  private Boolean i;
  @Nullable
  private IMessageListener j;
  @Nullable
  private CommonOuterClass.QQUserId k;
  @Nullable
  private Map<String, String> l;
  private long m;
  @NotNull
  private final View.OnTouchListener n = (View.OnTouchListener)new BaseMessageView.positionOnTouchListener.1(this);
  private final Lazy o = LazyKt.lazy((Function0)BaseMessageView.onlineStatusDrawable.2.INSTANCE);
  private final BaseMessageView.teamUpdateListener.1 p = new BaseMessageView.teamUpdateListener.1(this);
  @NotNull
  private View.OnLongClickListener q;
  private final View.OnClickListener r;
  private final View.OnClickListener s;
  private final View.OnLongClickListener t;
  private HashMap u;
  
  public BaseMessageView(@NotNull Context paramContext)
  {
    super(paramContext);
    setClipChildren(false);
    setClipToPadding(false);
    paramContext = getResources().getDrawable(2130839585);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "resources.getDrawable(R.drawable.common_loading3)");
    this.a = paramContext;
    paramContext = getResources().getDrawable(2130853047);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "resources.getDrawable(R.drawable.tg_send_fail)");
    this.b = paramContext;
    View.inflate(getContext(), 2131629422, (ViewGroup)this);
    ((FrameLayout)a(2131429328)).setOnTouchListener(this.n);
    ((ImageView)a(2131445576)).setOnTouchListener(this.n);
    paramContext = (TextView)a(2131429330);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "baseStatusDescTv");
    ViewExKt.a((View)paramContext, LayoutExKt.b(10), new int[] { Color.parseColor("#00CC8F") });
    ((TextView)a(2131429330)).setOnClickListener((View.OnClickListener)new BaseMessageView.1(this));
    this.q = ((View.OnLongClickListener)new BaseMessageView.onLongClickListner.1(this));
    this.r = ((View.OnClickListener)new BaseMessageView.onResendClick.1(this));
    this.s = ((View.OnClickListener)BaseMessageView.onAvatarClickListener.1.a);
    this.t = ((View.OnLongClickListener)new BaseMessageView.onAvatarLongClickListener.1(this));
  }
  
  public BaseMessageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setClipChildren(false);
    setClipToPadding(false);
    paramContext = getResources().getDrawable(2130839585);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "resources.getDrawable(R.drawable.common_loading3)");
    this.a = paramContext;
    paramContext = getResources().getDrawable(2130853047);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "resources.getDrawable(R.drawable.tg_send_fail)");
    this.b = paramContext;
    View.inflate(getContext(), 2131629422, (ViewGroup)this);
    ((FrameLayout)a(2131429328)).setOnTouchListener(this.n);
    ((ImageView)a(2131445576)).setOnTouchListener(this.n);
    paramContext = (TextView)a(2131429330);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "baseStatusDescTv");
    ViewExKt.a((View)paramContext, LayoutExKt.b(10), new int[] { Color.parseColor("#00CC8F") });
    ((TextView)a(2131429330)).setOnClickListener((View.OnClickListener)new BaseMessageView.1(this));
    this.q = ((View.OnLongClickListener)new BaseMessageView.onLongClickListner.1(this));
    this.r = ((View.OnClickListener)new BaseMessageView.onResendClick.1(this));
    this.s = ((View.OnClickListener)BaseMessageView.onAvatarClickListener.1.a);
    this.t = ((View.OnLongClickListener)new BaseMessageView.onAvatarLongClickListener.1(this));
  }
  
  public BaseMessageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setClipChildren(false);
    setClipToPadding(false);
    paramContext = getResources().getDrawable(2130839585);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "resources.getDrawable(R.drawable.common_loading3)");
    this.a = paramContext;
    paramContext = getResources().getDrawable(2130853047);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "resources.getDrawable(R.drawable.tg_send_fail)");
    this.b = paramContext;
    View.inflate(getContext(), 2131629422, (ViewGroup)this);
    ((FrameLayout)a(2131429328)).setOnTouchListener(this.n);
    ((ImageView)a(2131445576)).setOnTouchListener(this.n);
    paramContext = (TextView)a(2131429330);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "baseStatusDescTv");
    ViewExKt.a((View)paramContext, LayoutExKt.b(10), new int[] { Color.parseColor("#00CC8F") });
    ((TextView)a(2131429330)).setOnClickListener((View.OnClickListener)new BaseMessageView.1(this));
    this.q = ((View.OnLongClickListener)new BaseMessageView.onLongClickListner.1(this));
    this.r = ((View.OnClickListener)new BaseMessageView.onResendClick.1(this));
    this.s = ((View.OnClickListener)BaseMessageView.onAvatarClickListener.1.a);
    this.t = ((View.OnLongClickListener)new BaseMessageView.onAvatarLongClickListener.1(this));
  }
  
  private final void a(PremadesTeamServerOuterClass.UserOnlineRouteInfoList paramUserOnlineRouteInfoList)
  {
    Object localObject = this.c;
    ConcurrentHashMap localConcurrentHashMap = null;
    if (localObject != null)
    {
      localObject = this.h;
      if (localObject != null)
      {
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        if (((YoloRoomOuterClass.YoloRoomInfo)localObject).room_type.get() != 1)
        {
          if (paramUserOnlineRouteInfoList != null)
          {
            paramUserOnlineRouteInfoList = paramUserOnlineRouteInfoList.list;
            if (paramUserOnlineRouteInfoList != null)
            {
              paramUserOnlineRouteInfoList = paramUserOnlineRouteInfoList.route_list;
              if (paramUserOnlineRouteInfoList != null)
              {
                paramUserOnlineRouteInfoList = paramUserOnlineRouteInfoList.get();
                if (paramUserOnlineRouteInfoList != null)
                {
                  localObject = ((Iterable)paramUserOnlineRouteInfoList).iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    paramUserOnlineRouteInfoList = ((Iterator)localObject).next();
                    int i1;
                    if (((CommonOuterClass.OnlineRouteInfo)paramUserOnlineRouteInfoList).route_status.get() == 1) {
                      i1 = 1;
                    } else {
                      i1 = 0;
                    }
                    if (i1 != 0) {
                      break label138;
                    }
                  }
                  paramUserOnlineRouteInfoList = null;
                  label138:
                  paramUserOnlineRouteInfoList = (CommonOuterClass.OnlineRouteInfo)paramUserOnlineRouteInfoList;
                  break label148;
                }
              }
            }
          }
          paramUserOnlineRouteInfoList = null;
          label148:
          if (paramUserOnlineRouteInfoList == null)
          {
            paramUserOnlineRouteInfoList = (TextView)a(2131429330);
            Intrinsics.checkExpressionValueIsNotNull(paramUserOnlineRouteInfoList, "baseStatusDescTv");
            paramUserOnlineRouteInfoList.setVisibility(4);
            ((TimiAvatarRoundImageViewImpl)a(2131429327)).setBackgroundDrawable(null);
            return;
          }
          long l1 = paramUserOnlineRouteInfoList.yolo_room_route_info.room_id.get();
          ((TimiAvatarRoundImageViewImpl)a(2131429327)).setBackgroundDrawable((Drawable)getOnlineStatusDrawable());
          paramUserOnlineRouteInfoList = (TextView)a(2131429330);
          Intrinsics.checkExpressionValueIsNotNull(paramUserOnlineRouteInfoList, "baseStatusDescTv");
          paramUserOnlineRouteInfoList.setVisibility(0);
          if (this.m != l1)
          {
            this.m = l1;
            localObject = (IReportService)ServiceCenter.a(IReportService.class);
            paramUserOnlineRouteInfoList = (TextView)a(2131429330);
            Intrinsics.checkExpressionValueIsNotNull(paramUserOnlineRouteInfoList, "baseStatusDescTv");
            View localView = (View)paramUserOnlineRouteInfoList;
            IMsg localIMsg = this.c;
            paramUserOnlineRouteInfoList = localConcurrentHashMap;
            if (localIMsg != null) {
              paramUserOnlineRouteInfoList = localIMsg.a();
            }
            localConcurrentHashMap = YoloRoomUtil.c(this.h);
            localConcurrentHashMap.put("yes_team_id", String.valueOf(l1));
            Intrinsics.checkExpressionValueIsNotNull(localConcurrentHashMap, "YoloRoomUtil.getCommonRo…d\")\n                    }");
            IReportService.DefaultImpls.a((IReportService)localObject, localView, false, paramUserOnlineRouteInfoList, "em_yes_chat_teaming", (Map)localConcurrentHashMap, 2, null);
          }
          return;
        }
      }
    }
    paramUserOnlineRouteInfoList = (TextView)a(2131429330);
    Intrinsics.checkExpressionValueIsNotNull(paramUserOnlineRouteInfoList, "baseStatusDescTv");
    paramUserOnlineRouteInfoList.setVisibility(4);
    ((TimiAvatarRoundImageViewImpl)a(2131429327)).setBackgroundDrawable(null);
  }
  
  private final GradientDrawable getOnlineStatusDrawable()
  {
    return (GradientDrawable)this.o.getValue();
  }
  
  public View a(int paramInt)
  {
    if (this.u == null) {
      this.u = new HashMap();
    }
    View localView2 = (View)this.u.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.u.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  protected final void a(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    IMessageListener localIMessageListener = this.j;
    if (localIMessageListener != null) {
      localIMessageListener.a(paramIMsg.d());
    }
  }
  
  protected final void a(@NotNull CommonOuterClass.QQUserId paramQQUserId)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "uid");
    IMessageListener localIMessageListener = this.j;
    if (localIMessageListener != null) {
      localIMessageListener.a(paramQQUserId);
    }
  }
  
  public void a(@Nullable CommonOuterClass.QQUserId paramQQUserId, @NotNull IMsg paramIMsg1, @Nullable IMsg paramIMsg2)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg1, "msg");
    this.c = paramIMsg1;
    this.k = paramQQUserId;
    if ((c()) && ((paramIMsg2 == null) || (Math.abs(paramIMsg1.e() - paramIMsg2.e()) > 180000L)))
    {
      paramQQUserId = (TextView)a(2131429331);
      Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "baseTimeView");
      ViewExKt.a((View)paramQQUserId, true);
      paramQQUserId = (TextView)a(2131429331);
      Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "baseTimeView");
      paramQQUserId.setText((CharSequence)TimeUtils.a(paramIMsg1.e()));
      paramQQUserId = this.g;
      if (paramQQUserId != null) {
        ((TextView)a(2131429331)).setTextColor(paramQQUserId.a());
      }
    }
    else
    {
      paramQQUserId = (TextView)a(2131429331);
      Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "baseTimeView");
      ViewExKt.a((View)paramQQUserId, false);
    }
    if (paramIMsg1.f() == MsgStatus.REVOKE)
    {
      paramQQUserId = (FrameLayout)a(2131429328);
      Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "baseContentContainer");
      ViewExKt.a((View)paramQQUserId, false);
      paramQQUserId = (TextView)a(2131429330);
      Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "baseStatusDescTv");
      ViewExKt.a((View)paramQQUserId, false);
      paramQQUserId = (TimiAvatarRoundImageViewImpl)a(2131429327);
      Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "baseAvatarView");
      ViewExKt.a((View)paramQQUserId, false);
      paramQQUserId = (ImageView)a(2131445576);
      Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "sendState");
      ViewExKt.a((View)paramQQUserId, false);
      paramQQUserId = (TimiAvatarTextViewImpl)a(2131429329);
      Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "baseNickView");
      ViewExKt.a((View)paramQQUserId, false);
      paramQQUserId = (TextView)a(2131444750);
      Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "revokeView");
      ViewExKt.a((View)paramQQUserId, true);
      if (paramIMsg1.j())
      {
        paramQQUserId = (TextView)a(2131444750);
        Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "revokeView");
        paramQQUserId.setText((CharSequence)"你撤回了一条消息");
        return;
      }
      ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).b(paramIMsg1.d().uid.get(), (IResultListener)new BaseMessageView.refresh.2(this, paramIMsg1));
      return;
    }
    paramQQUserId = (TextView)a(2131444750);
    Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "revokeView");
    ViewExKt.a((View)paramQQUserId, false);
    paramQQUserId = (FrameLayout)a(2131429328);
    Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "baseContentContainer");
    ViewExKt.a((View)paramQQUserId, true);
    paramQQUserId = (TimiAvatarRoundImageViewImpl)a(2131429327);
    Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "baseAvatarView");
    ViewExKt.a((View)paramQQUserId, true);
    paramQQUserId = (ImageView)a(2131445576);
    Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "sendState");
    ViewExKt.a((View)paramQQUserId, true);
    paramQQUserId = (TimiAvatarTextViewImpl)a(2131429329);
    Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "baseNickView");
    ViewExKt.a((View)paramQQUserId, true);
    b(paramIMsg1);
  }
  
  protected final boolean a()
  {
    return true;
  }
  
  @CallSuper
  protected void b(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    boolean bool1 = c(paramIMsg);
    boolean bool2 = b();
    int i1 = 2131429327;
    int i2 = 0;
    if (bool2)
    {
      localObject1 = (TimiAvatarRoundImageViewImpl)a(2131429327);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "baseAvatarView");
      ((TimiAvatarRoundImageViewImpl)localObject1).setVisibility(0);
      ((TimiAvatarRoundImageViewImpl)a(2131429327)).setUserId(paramIMsg.d());
      ((TimiAvatarRoundImageViewImpl)a(2131429327)).setOnClickListener((View.OnClickListener)new BaseMessageView.renderUI.1(this, paramIMsg));
      ((TimiAvatarRoundImageViewImpl)a(2131429327)).setOnLongClickListener(this.t);
      localObject1 = this.h;
      if (localObject1 != null)
      {
        localObject1 = YoloRoomUtil.c((YoloRoomOuterClass.YoloRoomInfo)localObject1);
        ((ConcurrentHashMap)localObject1).put("yes_to_uid", LongExKt.a(paramIMsg.d().uid.get()));
        this.l = ((Map)localObject1);
        localObject1 = (IReportService)ServiceCenter.a(IReportService.class);
        localObject2 = (TimiAvatarRoundImageViewImpl)a(2131429327);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "baseAvatarView");
        localObject2 = (View)localObject2;
        localObject3 = paramIMsg.a();
        Map localMap = this.l;
        if (localMap == null) {
          Intrinsics.throwNpe();
        }
        IReportService.DefaultImpls.b((IReportService)localObject1, (View)localObject2, false, (String)localObject3, "em_yes_chat_user_head", localMap, 2, null);
      }
    }
    else
    {
      localObject1 = (TimiAvatarRoundImageViewImpl)a(2131429327);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "baseAvatarView");
      ((TimiAvatarRoundImageViewImpl)localObject1).setVisibility(8);
    }
    if (d(paramIMsg))
    {
      localObject1 = (TimiAvatarRoundImageViewImpl)a(2131429327);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "baseAvatarView");
      localObject1 = ((TimiAvatarRoundImageViewImpl)localObject1).getLayoutParams();
      if (localObject1 != null)
      {
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        ((RelativeLayout.LayoutParams)localObject1).addRule(11, 1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(9, 0);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = LayoutExKt.a(13.5F);
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = LayoutExKt.a(5.5F);
        localObject2 = (TimiAvatarRoundImageViewImpl)a(2131429327);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "baseAvatarView");
        ((TimiAvatarRoundImageViewImpl)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (FrameLayout)a(2131429328);
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = ((FrameLayout)localObject1).getLayoutParams();
        if (localObject1 != null)
        {
          localObject1 = (RelativeLayout.LayoutParams)localObject1;
          if (!b()) {
            i1 = 0;
          }
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, i1);
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
          localObject2 = (FrameLayout)a(2131429328);
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          ((FrameLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localObject1 = (ImageView)a(2131445576);
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          localObject1 = ((ImageView)localObject1).getLayoutParams();
          if (localObject1 != null)
          {
            localObject1 = (RelativeLayout.LayoutParams)localObject1;
            ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131429328);
            ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = LayoutExKt.b(10);
            ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
            localObject2 = (ImageView)a(2131445576);
            if (localObject2 == null) {
              Intrinsics.throwNpe();
            }
            ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            localObject1 = (TimiAvatarTextViewImpl)a(2131429329);
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "baseNickView");
            localObject1 = ((TimiAvatarTextViewImpl)localObject1).getLayoutParams();
            if (localObject1 != null)
            {
              localObject1 = (RelativeLayout.LayoutParams)localObject1;
              ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131429328);
              ((RelativeLayout.LayoutParams)localObject1).addRule(5, 0);
              localObject2 = (TimiAvatarTextViewImpl)a(2131429329);
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "baseNickView");
              ((TimiAvatarTextViewImpl)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      }
    }
    else
    {
      localObject1 = (TimiAvatarRoundImageViewImpl)a(2131429327);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "baseAvatarView");
      localObject1 = ((TimiAvatarRoundImageViewImpl)localObject1).getLayoutParams();
      if (localObject1 == null) {
        break label1663;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).addRule(11, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(9, 1);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = LayoutExKt.a(5.5F);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = LayoutExKt.a(13.5F);
      localObject2 = (TimiAvatarRoundImageViewImpl)a(2131429327);
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((TimiAvatarRoundImageViewImpl)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (FrameLayout)a(2131429328);
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((FrameLayout)localObject1).getLayoutParams();
      if (localObject1 == null) {
        break label1652;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 0);
      if (!b()) {
        i1 = 0;
      }
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, i1);
      localObject2 = (FrameLayout)a(2131429328);
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((FrameLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (ImageView)a(2131445576);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "sendState");
      localObject1 = ((ImageView)localObject1).getLayoutParams();
      if (localObject1 == null) {
        break label1641;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131429328);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = LayoutExKt.b(10);
      localObject2 = (ImageView)a(2131445576);
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (TimiAvatarTextViewImpl)a(2131429329);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "baseNickView");
      localObject1 = ((TimiAvatarTextViewImpl)localObject1).getLayoutParams();
      if (localObject1 == null) {
        break label1630;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131429328);
      localObject2 = (TimiAvatarTextViewImpl)a(2131429329);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "baseNickView");
      ((TimiAvatarTextViewImpl)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if (bool1)
    {
      localObject1 = (TimiAvatarTextViewImpl)a(2131429329);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "baseNickView");
      ViewExKt.a((View)localObject1, true);
      ((TimiAvatarTextViewImpl)a(2131429329)).setUserId(paramIMsg.d());
      ((TimiAvatarTextViewImpl)a(2131429329)).setShowRoleName(true);
    }
    else
    {
      localObject1 = (TimiAvatarTextViewImpl)a(2131429329);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "baseNickView");
      ViewExKt.a((View)localObject1, false);
    }
    Object localObject1 = this.g;
    if (localObject1 != null) {
      ((TimiAvatarTextViewImpl)a(2131429329)).setTextColor(((MessageLayout.IIMConfig)localObject1).c(paramIMsg));
    }
    localObject1 = getLongOperOptions();
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((i1 ^ 0x1) != 0)
      {
        localObject1 = (FrameLayout)a(2131429328);
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((FrameLayout)localObject1).setOnLongClickListener(this.q);
      }
    }
    Object localObject2 = null;
    localObject1 = (Drawable)null;
    if ((a()) && (paramIMsg.f() == MsgStatus.SENDING)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (paramIMsg.f() == MsgStatus.FAILED) {
      i2 = 1;
    }
    if (i1 != 0) {
      localObject1 = this.a;
    } else if (i2 != 0) {
      localObject1 = this.b;
    }
    if (localObject1 != null)
    {
      ((ImageView)a(2131445576)).setImageDrawable((Drawable)localObject1);
      if (i1 != 0)
      {
        localObject1 = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        ((RotateAnimation)localObject1).setDuration(500L);
        ((RotateAnimation)localObject1).setInterpolator((Interpolator)new LinearInterpolator());
        ((RotateAnimation)localObject1).setRepeatCount(2147483647);
        ((RotateAnimation)localObject1).setRepeatMode(-1);
        localObject3 = (ImageView)a(2131445576);
        if (localObject3 == null) {
          Intrinsics.throwNpe();
        }
        ((ImageView)localObject3).startAnimation((Animation)localObject1);
      }
      else if (i2 != 0)
      {
        localObject1 = (ImageView)a(2131445576);
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((ImageView)localObject1).clearAnimation();
        localObject1 = (ImageView)a(2131445576);
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((ImageView)localObject1).setOnClickListener(this.r);
      }
    }
    else
    {
      localObject1 = (ImageView)a(2131445576);
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((ImageView)localObject1).clearAnimation();
      localObject1 = (ImageView)a(2131445576);
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((ImageView)localObject1).setImageDrawable(null);
    }
    localObject1 = TeamInfoAutoUpdateService.a();
    Object localObject3 = paramIMsg.d();
    paramIMsg = (IMsg)localObject2;
    if (localObject3 != null) {
      paramIMsg = ((CommonOuterClass.QQUserId)localObject3).uid;
    }
    a(((TeamInfoAutoUpdateService)localObject1).a(paramIMsg.get()));
    return;
    label1630:
    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    label1641:
    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    label1652:
    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    label1663:
    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
  }
  
  protected final boolean b()
  {
    return true;
  }
  
  protected final boolean c()
  {
    return true;
  }
  
  protected final boolean c(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    boolean bool2 = paramIMsg.k();
    paramIMsg = this.g;
    boolean bool1 = bool2;
    if (paramIMsg != null)
    {
      if ((bool2) && (paramIMsg.b())) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  protected boolean d(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    return paramIMsg.j();
  }
  
  @Nullable
  public final Boolean getFilterForwardOption()
  {
    return this.i;
  }
  
  @Nullable
  protected final MessageLayout.IIMConfig getIImConfig()
  {
    return this.g;
  }
  
  @Nullable
  protected final IMessageListener getIMessageListener()
  {
    return this.j;
  }
  
  @Nullable
  protected LongClickOperOption[] getLongOperOptions()
  {
    return new LongClickOperOption[] { LongClickOperOption.DELETE };
  }
  
  @Nullable
  protected final IMsg getMsg()
  {
    return this.c;
  }
  
  @NotNull
  protected final View.OnLongClickListener getOnLongClickListner()
  {
    return this.q;
  }
  
  @NotNull
  protected final View.OnTouchListener getPositionOnTouchListener()
  {
    return this.n;
  }
  
  @Nullable
  protected final Map<String, String> getReportParam()
  {
    return this.l;
  }
  
  @Nullable
  protected final YoloRoomOuterClass.YoloRoomInfo getRoomInfo()
  {
    return this.h;
  }
  
  @Nullable
  protected final CommonOuterClass.QQUserId getSelfQQUserId()
  {
    return this.k;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    TeamInfoAutoUpdateService localTeamInfoAutoUpdateService = TeamInfoAutoUpdateService.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("base_chat_");
    localStringBuilder.append(this.p.hashCode());
    localTeamInfoAutoUpdateService.a(localStringBuilder.toString(), (TeamInfoAutoUpdateService.AutoUpdateServiceListener)this.p);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.m = 0L;
    this.f.a();
    TeamInfoAutoUpdateService localTeamInfoAutoUpdateService = TeamInfoAutoUpdateService.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("base_chat_");
    localStringBuilder.append(this.p.hashCode());
    localTeamInfoAutoUpdateService.a(localStringBuilder.toString());
  }
  
  public void setContentView(@LayoutRes int paramInt)
  {
    RelativeLayout.inflate(getContext(), paramInt, (FrameLayout)a(2131429328));
  }
  
  public void setContentView(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    ((FrameLayout)a(2131429328)).addView(paramView);
  }
  
  public final void setFilterForwardOption(@Nullable Boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  protected final void setIImConfig(@Nullable MessageLayout.IIMConfig paramIIMConfig)
  {
    this.g = paramIIMConfig;
  }
  
  protected final void setIMessageListener(@Nullable IMessageListener paramIMessageListener)
  {
    this.j = paramIMessageListener;
  }
  
  public final void setImConfig(@Nullable MessageLayout.IIMConfig paramIIMConfig)
  {
    this.g = paramIIMConfig;
  }
  
  public final void setMessageListener(@Nullable IMessageListener paramIMessageListener)
  {
    this.j = paramIMessageListener;
  }
  
  protected final void setMsg(@Nullable IMsg paramIMsg)
  {
    this.c = paramIMsg;
  }
  
  protected final void setOnLongClickListner(@NotNull View.OnLongClickListener paramOnLongClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnLongClickListener, "<set-?>");
    this.q = paramOnLongClickListener;
  }
  
  protected final void setReportParam(@Nullable Map<String, String> paramMap)
  {
    this.l = paramMap;
  }
  
  protected final void setRoomInfo(@Nullable YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    this.h = paramYoloRoomInfo;
  }
  
  protected final void setSelfQQUserId(@Nullable CommonOuterClass.QQUserId paramQQUserId)
  {
    this.k = paramQQUserId;
  }
  
  public final void setYoloRoomInfo(@Nullable YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    this.h = paramYoloRoomInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.BaseMessageView
 * JD-Core Version:    0.7.0.1
 */