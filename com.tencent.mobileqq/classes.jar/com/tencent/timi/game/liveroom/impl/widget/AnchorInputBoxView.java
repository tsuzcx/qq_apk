package com.tencent.timi.game.liveroom.impl.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomOperation;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.ExtData;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.app.event.AnchorAtEvent;
import com.tencent.timi.game.component.chat.at.FamilyAtFunction;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.datareport.api.ILiveReportService.DefaultImpls;
import com.tencent.timi.game.liveroom.impl.more.AnchorMoreSettingUtil;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.TimMsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/widget/AnchorInputBoxView;", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/timi/game/app/event/AnchorAtEvent;", "Lcom/tencent/timi/game/component/chat/at/FamilyAtFunction;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clickDelegateView", "Landroid/view/View;", "editText", "Landroid/widget/EditText;", "emojiBtn", "isLandscape", "", "roomId", "", "sendView", "acquireInputBoxView", "acquireInputView", "bindForceExpose", "", "bindReport", "extraInfo", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "doBeforeSend", "view", "getEmojiBtn", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getInputEditText", "getLayoutId", "getSendBtn", "layoutInflated", "onAttachedToWindow", "onDetachedFromWindow", "onEnterRoom", "onExitRoom", "onOrientationChange", "onReceiveEvent", "p0", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "sendMsgReally", "msgBody", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "text", "", "setClickDelegate", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public class AnchorInputBoxView
  extends TimiBaseInputView
  implements SimpleEventReceiver<AnchorAtEvent>, FamilyAtFunction
{
  private long a;
  private EditText c;
  private View d;
  private View e;
  private View f;
  private boolean g;
  
  @JvmOverloads
  public AnchorInputBoxView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public AnchorInputBoxView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public AnchorInputBoxView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setClickable(true);
  }
  
  private final void a(MessageOuterClass.TimMsgBody paramTimMsgBody, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    LiveMessageData.ExtData localExtData = new LiveMessageData.ExtData(new LiveMessageData());
    localExtData.mId = 100001;
    localExtData.mValue = Base64Util.encode(paramTimMsgBody.toByteArray(), 2);
    localArrayList.add(localExtData);
    paramTimMsgBody = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).k(this.a);
    if (paramTimMsgBody != null) {
      paramTimMsgBody.sendMessage(paramString, localArrayList, (IQQLiveMessageCallback)new AnchorInputBoxView.sendMsgReally.1(this));
    }
  }
  
  public void a()
  {
    this.c = ((EditText)findViewById(2131435831));
    this.d = findViewById(2131445618);
    this.e = findViewById(2131432439);
    Object localObject = getFuncLayout();
    if (localObject != null) {
      ((FrameLayout)localObject).setBackgroundColor(Color.parseColor("#0B0820"));
    }
    localObject = this.e;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)new AnchorInputBoxView.layoutInflated.1(this));
    }
    localObject = this.c;
    if (localObject != null) {
      ((EditText)localObject).post((Runnable)new AnchorInputBoxView.layoutInflated.2(this));
    }
    localObject = this.c;
    if (localObject != null) {
      ((EditText)localObject).setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(50), (InputFilter)new AnchorInputBoxView.layoutInflated.3() });
    }
    localObject = this.c;
    if (localObject != null) {
      ((EditText)localObject).addTextChangedListener((TextWatcher)new AnchorInputBoxView.layoutInflated.4(this));
    }
    a((TimiBaseInputView.StateChangedListener)new AnchorInputBoxView.layoutInflated.5(this));
    k();
    localObject = this.c;
    if (localObject != null)
    {
      VideoReport.setElementId((Object)localObject, "em_qqlive_inputpanel_box");
      VideoReport.setLogicParent((View)this.c, this.d);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
  }
  
  public final void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(long paramLong, @Nullable LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    paramLiveRoomExtraInfo = AnchorMoreSettingUtil.a(paramLong);
    ILiveReportService localILiveReportService = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
    if (paramLiveRoomExtraInfo != null)
    {
      localILiveReportService.a(this, "pg_qqlive_anchorlive", (Map)paramLiveRoomExtraInfo);
      paramLiveRoomExtraInfo = getSendBtn();
      if (paramLiveRoomExtraInfo != null)
      {
        ILiveReportService.DefaultImpls.b((ILiveReportService)ServiceCenter.a(ILiveReportService.class), paramLiveRoomExtraInfo, false, null, "em_qqlive_send_message", null, 22, null);
        VideoReport.setEventDynamicParams(paramLiveRoomExtraInfo, (IDynamicParams)new AnchorInputBoxView.bindReport..inlined.apply.lambda.1(this));
      }
      paramLiveRoomExtraInfo = getEmojiBtn();
      if (paramLiveRoomExtraInfo != null) {
        ILiveReportService.DefaultImpls.a((ILiveReportService)ServiceCenter.a(ILiveReportService.class), paramLiveRoomExtraInfo, false, null, "em_qqlive_emoji_entrance", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("zengzhi_moduleid", "em_qqlive_inputbar") }), 6, null);
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
  }
  
  protected void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    ILiveReportService localILiveReportService = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
    paramView = (Object)paramView;
    localILiveReportService.a("clck", paramView, (Map)new LinkedHashMap());
    ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a("dt_submit", paramView, MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("dt_submit_way", "2"), TuplesKt.to("dt_submit_type", "SEND") }));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    View localView = this.f;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public final void b()
  {
    this.a = 0L;
  }
  
  @Nullable
  public EditText c()
  {
    return getInputEditText();
  }
  
  @Nullable
  public TimiBaseInputView dJ_()
  {
    return (TimiBaseInputView)this;
  }
  
  @Nullable
  public View getEmojiBtn()
  {
    return this.e;
  }
  
  @NotNull
  public ArrayList<Class<AnchorAtEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AnchorAtEvent.class);
    return localArrayList;
  }
  
  @Nullable
  public EditText getInputEditText()
  {
    return this.c;
  }
  
  public int getLayoutId()
  {
    return 2131629431;
  }
  
  @Nullable
  public View getSendBtn()
  {
    return this.d;
  }
  
  public void k()
  {
    a((TimiBaseInputView.StateChangedListener)new AnchorInputBoxView.bindForceExpose.1(this));
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
  }
  
  public void onReceiveEvent(@Nullable SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AnchorAtEvent))
    {
      CommonOuterClass.QQUserId localQQUserId = new CommonOuterClass.QQUserId();
      Object localObject1 = localQQUserId.uid;
      paramSimpleBaseEvent = (AnchorAtEvent)paramSimpleBaseEvent;
      ((PBUInt64Field)localObject1).set(paramSimpleBaseEvent.getLiveUserInfo().uid);
      localObject1 = (FamilyAtFunction)this;
      String str1 = paramSimpleBaseEvent.getLiveUserInfo().nick;
      Object localObject2 = (CharSequence)str1;
      int i;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        localObject2 = SpecialMsgUtil.a;
        String str2 = paramSimpleBaseEvent.getQuickTip();
        paramSimpleBaseEvent = paramSimpleBaseEvent.getLiveUserInfo().headUrl;
        Intrinsics.checkExpressionValueIsNotNull(paramSimpleBaseEvent, "p0.liveUserInfo.headUrl");
        ((SpecialMsgUtil)localObject2).a(localQQUserId, str1, (FamilyAtFunction)localObject1, str2, paramSimpleBaseEvent);
      }
    }
  }
  
  public final void setClickDelegate(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    this.f = paramView;
    paramView.setOnClickListener((View.OnClickListener)new AnchorInputBoxView.setClickDelegate.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AnchorInputBoxView
 * JD-Core Version:    0.7.0.1
 */