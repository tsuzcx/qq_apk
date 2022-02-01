package com.tencent.timi.game.liveroom.impl.inscription;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorUserInfo;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.liveroom.api.IRoomWidget;
import com.tencent.timi.game.liveroom.impl.inscription.net.GetAnchorRoomInfoRequest;
import com.tencent.timi.game.liveroom.impl.inscription.net.GetAnchorRoomInfoRequest.Result;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.DrawableUtil;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.web.business.api.IWebBusinessService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.AnchorGameInfo;
import trpc.yes.common.MessageOuterClass.AnchorEquipStatusNotifyMsg;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.TimMsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionInterEntranceView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/timi/game/liveroom/api/IRoomWidget;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "anchorId", "", "getAnchorId", "()J", "setAnchorId", "(J)V", "anchorRoomInfoCallback", "com/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionInterEntranceView$anchorRoomInfoCallback$1", "Lcom/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionInterEntranceView$anchorRoomInfoCallback$1;", "backgroundUrl", "gameId", "getGameId", "()I", "setGameId", "(I)V", "inscriptionUrl", "isDestroyed", "", "isLandscape", "isReport", "liveRoomMessage", "Lcom/tencent/mobileqq/qqlive/api/room/ILiveRoomMessage;", "periodTime", "roomId", "getRoomId", "setRoomId", "settingEntranceShowFlag", "getSettingEntranceShowFlag", "()Z", "setSettingEntranceShowFlag", "(Z)V", "statusListener", "com/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionInterEntranceView$statusListener$1", "Lcom/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionInterEntranceView$statusListener$1;", "updateInfoTimer", "Ljava/util/Timer;", "acquireAnchorBusiness", "acquireReportEquipStatusParam", "cancelTimer", "", "initItemView", "view", "Landroid/view/View;", "url", "initView", "isAnchor", "isSameRoom", "result", "Lcom/tencent/timi/game/liveroom/impl/inscription/net/GetAnchorRoomInfoRequest$Result;", "loadData", "onAttachedToWindow", "onDetachedFromWindow", "onEnterRoom", "onExitRoom", "onOrientationChange", "onPageIn", "onPageOut", "onPreload", "videoUrl", "registerStatusListener", "rooid", "reloadData", "reportData", "restData", "info", "Ltrpc/yes/common/GameDataServerOuterClass$AnchorGameInfo;", "showTag", "setBackgroundIcon", "setContentWhenStatusChanged", "msg", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "setHeroList", "setLiveRoomInfo", "audienceInfo", "Lcom/tencent/mobileqq/qqlive/api/room/IAudienceRoom;", "extraRoom", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "setPeriodTimer", "setVisibleByData", "startTimer", "unRegisterStatusListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingInscriptionInterEntranceView
  extends RelativeLayout
  implements IRoomWidget
{
  private final String a = "LivingInscriptionInterEntranceView";
  private final String b = "https://cdn.yes.qq.com/live/tg_anchor_inscription_entrance_bg.png";
  private String c = "";
  private ILiveRoomMessage d;
  private Timer e;
  private long f;
  private boolean g;
  private long h;
  private int i;
  private long j;
  private boolean k;
  private boolean l;
  private boolean m;
  private final LivingInscriptionInterEntranceView.anchorRoomInfoCallback.1 n = new LivingInscriptionInterEntranceView.anchorRoomInfoCallback.1(this);
  private final LivingInscriptionInterEntranceView.statusListener.1 o = new LivingInscriptionInterEntranceView.statusListener.1(this);
  private HashMap p;
  
  public LivingInscriptionInterEntranceView(@Nullable Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public LivingInscriptionInterEntranceView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public LivingInscriptionInterEntranceView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private final void a(View paramView, String paramString)
  {
    paramView = (ImageView)paramView.findViewById(2131435016);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = DrawableUtil.a.a(ViewUtils.dpToPx(22.0F), (View)paramView, 0);
    DrawableUtil.a.a(paramString, paramView, localURLDrawableOptions);
  }
  
  private final void a(GameDataServerOuterClass.AnchorGameInfo paramAnchorGameInfo, boolean paramBoolean)
  {
    if (paramAnchorGameInfo != null)
    {
      paramAnchorGameInfo = paramAnchorGameInfo.url;
      if (paramAnchorGameInfo != null)
      {
        paramAnchorGameInfo = paramAnchorGameInfo.get();
        if (paramAnchorGameInfo != null) {
          break label28;
        }
      }
    }
    paramAnchorGameInfo = "";
    label28:
    if ((paramBoolean) && (!TextUtils.isEmpty((CharSequence)paramAnchorGameInfo))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    ViewExKt.a(this, paramBoolean);
  }
  
  private final boolean a(GetAnchorRoomInfoRequest.Result paramResult)
  {
    long l1 = this.j;
    return (paramResult != null) && (l1 == paramResult.b());
  }
  
  private final void b()
  {
    RelativeLayout.inflate(getContext(), 2131629449, (ViewGroup)this);
    setOnClickListener((View.OnClickListener)new LivingInscriptionInterEntranceView.initView.1(this));
    g();
    ImageView localImageView = (ImageView)a(2131435845);
    if (localImageView != null) {
      localImageView.setColorFilter(Color.parseColor("#84818E"));
    }
  }
  
  private final void b(GameDataServerOuterClass.AnchorGameInfo paramAnchorGameInfo, boolean paramBoolean)
  {
    TextView localTextView = (TextView)a(2131432577);
    Object localObject;
    if (localTextView != null)
    {
      if (paramAnchorGameInfo != null)
      {
        localObject = paramAnchorGameInfo.title;
        if (localObject != null)
        {
          localObject = ((PBStringField)localObject).get();
          if (localObject != null)
          {
            localObject = (CharSequence)localObject;
            break label53;
          }
        }
      }
      localObject = (CharSequence)"";
      label53:
      localTextView.setText((CharSequence)localObject);
    }
    localTextView = (TextView)a(2131432576);
    if (localTextView != null)
    {
      if (paramAnchorGameInfo != null)
      {
        localObject = paramAnchorGameInfo.desc;
        if (localObject != null)
        {
          localObject = ((PBStringField)localObject).get();
          if (localObject != null)
          {
            localObject = (CharSequence)localObject;
            break label112;
          }
        }
      }
      localObject = (CharSequence)"";
      label112:
      localTextView.setText((CharSequence)localObject);
    }
    a(paramAnchorGameInfo, paramBoolean);
    setHeroList(paramAnchorGameInfo);
    i();
  }
  
  private final void c()
  {
    if (this.m) {
      return;
    }
    this.m = true;
    Map localMap = (Map)new LinkedHashMap();
    localMap.put("qqlive_equip_status", d());
    if (!f())
    {
      String str;
      if (this.l) {
        str = "1";
      } else {
        str = "0";
      }
      localMap.put("qqlive_screen_orientation", str);
    }
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a((View)this, true, null, "em_qqlive_equip_entrance", localMap);
  }
  
  private final String d()
  {
    if (getVisibility() == 0)
    {
      Object localObject = (TextView)a(2131432576);
      if (localObject != null)
      {
        localObject = ((TextView)localObject).getText();
        if (localObject != null)
        {
          localObject = localObject.toString();
          if (localObject != null) {
            break label46;
          }
        }
      }
      localObject = "";
      label46:
      if (StringsKt.contains$default((CharSequence)localObject, (CharSequence)"常用英雄", false, 2, null)) {
        return "1";
      }
    }
    return "0";
  }
  
  private final void d(long paramLong)
  {
    Object localObject = (ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class);
    if (localObject != null) {
      localObject = ((ITgLiveRoomService)localObject).j(paramLong);
    } else {
      localObject = null;
    }
    this.d = ((ILiveRoomMessage)localObject);
    localObject = this.d;
    if (localObject != null) {
      ((ILiveRoomMessage)localObject).registerHighPriorityListener(TemConstant.a.a(), (IQQCmdPushCallback)this.o);
    }
  }
  
  private final String e()
  {
    Object localObject = (ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class);
    if (localObject != null)
    {
      localObject = ((ITgLiveRoomService)localObject).i(this.j);
      if (localObject != null)
      {
        localObject = ((TgLiveAnchorUserInfo)localObject).d;
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return "";
  }
  
  private final boolean f()
  {
    Object localObject = (ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class);
    if (localObject != null)
    {
      localObject = ((ITgLiveRoomService)localObject).f();
      if (localObject != null)
      {
        l1 = ((LiveUserInfo)localObject).uid;
        break label35;
      }
    }
    long l1 = 0L;
    label35:
    return l1 == this.h;
  }
  
  private final void g()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = getResources().getDrawable(2130852876);
    localURLDrawableOptions.mRequestWidth = UITools.a(getContext());
    localURLDrawableOptions.mRequestHeight = LayoutExKt.b(54);
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    DrawableUtil.a.a(this.b, (ImageView)a(2131429235), localURLDrawableOptions);
  }
  
  private final void h()
  {
    GetAnchorRoomInfoRequest.a.a(e(), this.i, this.j, (IResultListener)this.n);
  }
  
  private final void i()
  {
    if (this.f > 0L)
    {
      j();
      return;
    }
    k();
  }
  
  private final void j()
  {
    if ((this.e == null) && (this.f > 0L))
    {
      this.e = new Timer();
      LivingInscriptionInterEntranceView.startTimer.timerTask.1 local1 = new LivingInscriptionInterEntranceView.startTimer.timerTask.1(this);
      Timer localTimer = this.e;
      if (localTimer != null) {
        localTimer.schedule((TimerTask)local1, 1000L, this.f);
      }
    }
  }
  
  private final void k()
  {
    Timer localTimer = this.e;
    if (localTimer != null) {
      localTimer.cancel();
    }
    this.e = ((Timer)null);
  }
  
  private final void l()
  {
    ILiveRoomMessage localILiveRoomMessage = this.d;
    if (localILiveRoomMessage != null) {
      localILiveRoomMessage.unRegisterHighPriorityListener(TemConstant.a.a(), (IQQCmdPushCallback)this.o);
    }
    this.d = ((ILiveRoomMessage)null);
  }
  
  private final void setContentWhenStatusChanged(MessageOuterClass.TimMsgBody paramTimMsgBody)
  {
    if (paramTimMsgBody.msg_type.get() == 81)
    {
      Object localObject1 = paramTimMsgBody.content;
      boolean bool1 = false;
      if (localObject1 != null)
      {
        localObject1 = ((MessageOuterClass.MsgContent)localObject1).anchor_equip_status_notify_msg;
        if (localObject1 != null)
        {
          localObject1 = ((MessageOuterClass.AnchorEquipStatusNotifyMsg)localObject1).equip_status;
          if (localObject1 != null)
          {
            i1 = ((PBInt32Field)localObject1).get();
            break label60;
          }
        }
      }
      int i1 = 0;
      label60:
      if (1 == i1) {
        bool1 = true;
      }
      localObject1 = paramTimMsgBody.content;
      Object localObject2 = null;
      if (localObject1 != null)
      {
        localObject1 = ((MessageOuterClass.MsgContent)localObject1).anchor_equip_status_notify_msg;
        if (localObject1 != null)
        {
          localObject1 = ((MessageOuterClass.AnchorEquipStatusNotifyMsg)localObject1).game_info;
          if (localObject1 != null)
          {
            localObject1 = ((GameDataServerOuterClass.AnchorGameInfo)localObject1).url;
            if (localObject1 != null)
            {
              localObject1 = ((PBStringField)localObject1).get();
              break label130;
            }
          }
        }
      }
      localObject1 = null;
      label130:
      boolean bool2 = TextUtils.isEmpty((CharSequence)localObject1);
      localObject1 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setContentWhenStatusChanged ");
      localStringBuilder.append(i1);
      localStringBuilder.append(' ');
      localStringBuilder.append(bool1);
      localStringBuilder.append(' ');
      localStringBuilder.append(bool2);
      Logger.a((String)localObject1, localStringBuilder.toString());
      localObject1 = paramTimMsgBody.content;
      paramTimMsgBody = localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((MessageOuterClass.MsgContent)localObject1).anchor_equip_status_notify_msg;
        paramTimMsgBody = localObject2;
        if (localObject1 != null)
        {
          localObject1 = ((MessageOuterClass.AnchorEquipStatusNotifyMsg)localObject1).game_info;
          paramTimMsgBody = localObject2;
          if (localObject1 != null) {
            paramTimMsgBody = (GameDataServerOuterClass.AnchorGameInfo)((GameDataServerOuterClass.AnchorGameInfo)localObject1).get();
          }
        }
      }
      b(paramTimMsgBody, bool1);
    }
  }
  
  private final void setHeroList(GameDataServerOuterClass.AnchorGameInfo paramAnchorGameInfo)
  {
    ((LinearLayout)a(2131435846)).removeAllViews();
    if (paramAnchorGameInfo != null)
    {
      Object localObject2;
      if (!this.c.equals(paramAnchorGameInfo.url.get()))
      {
        localObject1 = (IWebBusinessService)ServiceCenter.a(IWebBusinessService.class);
        localObject2 = paramAnchorGameInfo.url.get();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.url.get()");
        ((IWebBusinessService)localObject1).a((String)localObject2);
      }
      Object localObject1 = paramAnchorGameInfo.url.get();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "it.url.get()");
      this.c = ((String)localObject1);
      int i1 = LayoutExKt.b(2);
      int i2 = LayoutExKt.b(22);
      paramAnchorGameInfo = paramAnchorGameInfo.hero_url_list.get();
      Intrinsics.checkExpressionValueIsNotNull(paramAnchorGameInfo, "it.hero_url_list.get()");
      paramAnchorGameInfo = ((Iterable)paramAnchorGameInfo).iterator();
      while (paramAnchorGameInfo.hasNext())
      {
        localObject2 = (String)paramAnchorGameInfo.next();
        localObject1 = LayoutInflater.from(getContext()).inflate(2131629407, null);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "view");
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "url");
        a((View)localObject1, (String)localObject2);
        localObject2 = new LinearLayout.LayoutParams(i2, i2);
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i1;
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i1;
        ((LinearLayout)a(2131435846)).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      }
    }
  }
  
  public View a(int paramInt)
  {
    if (this.p == null) {
      this.p = new HashMap();
    }
    View localView2 = (View)this.p.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.p.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a()
  {
    h();
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong, @Nullable String paramString)
  {
    ((IWebBusinessService)ServiceCenter.a(IWebBusinessService.class)).b();
  }
  
  public void a(long paramLong, boolean paramBoolean) {}
  
  public final void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void b(long paramLong)
  {
    ViewExKt.a(this, false);
    k();
    LivingInscriptionReportHelper.a.a().a();
  }
  
  public void c(long paramLong)
  {
    l();
    k();
    LivingInscriptionReportHelper.a.a().a();
  }
  
  public final long getAnchorId()
  {
    return this.h;
  }
  
  public final int getGameId()
  {
    return this.i;
  }
  
  public final long getRoomId()
  {
    return this.j;
  }
  
  public final boolean getSettingEntranceShowFlag()
  {
    return this.g;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.k = false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.k = true;
    k();
    l();
  }
  
  public final void setAnchorId(long paramLong)
  {
    this.h = paramLong;
  }
  
  public final void setGameId(int paramInt)
  {
    this.i = paramInt;
  }
  
  public final void setLiveRoomInfo(long paramLong1, long paramLong2, int paramInt)
  {
    this.h = paramLong1;
    this.j = paramLong2;
    this.i = paramInt;
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLiveRoomInfo  ");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramInt);
    Logger.a(str, localStringBuilder.toString());
    h();
    l();
    d(paramLong2);
  }
  
  public final void setLiveRoomInfo(@Nullable IAudienceRoom paramIAudienceRoom, @Nullable LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    long l3 = 0L;
    if (paramIAudienceRoom != null)
    {
      Object localObject = paramIAudienceRoom.getRoomLiveInfo();
      if (localObject != null)
      {
        localObject = ((LiveInfo)localObject).anchorInfo;
        if (localObject != null)
        {
          l1 = ((LiveAnchorInfo)localObject).uid;
          break label45;
        }
      }
    }
    long l1 = 0L;
    label45:
    long l2 = l3;
    if (paramIAudienceRoom != null)
    {
      paramIAudienceRoom = paramIAudienceRoom.getRoomLiveInfo();
      l2 = l3;
      if (paramIAudienceRoom != null)
      {
        paramIAudienceRoom = paramIAudienceRoom.roomInfo;
        l2 = l3;
        if (paramIAudienceRoom != null) {
          l2 = paramIAudienceRoom.roomId;
        }
      }
    }
    int i1;
    if (paramLiveRoomExtraInfo != null) {
      i1 = paramLiveRoomExtraInfo.b;
    } else {
      i1 = 0;
    }
    setLiveRoomInfo(l1, l2, i1);
  }
  
  public final void setRoomId(long paramLong)
  {
    this.j = paramLong;
  }
  
  public final void setSettingEntranceShowFlag(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionInterEntranceView
 * JD-Core Version:    0.7.0.1
 */