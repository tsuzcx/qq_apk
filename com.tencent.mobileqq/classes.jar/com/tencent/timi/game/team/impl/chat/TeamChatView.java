package com.tencent.timi.game.team.impl.chat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.component.chat.at.AtMsgManager;
import com.tencent.timi.game.component.chat.at.AtMsgManager.Companion;
import com.tencent.timi.game.component.chat.at.FamilyAtFunction;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener;
import com.tencent.timi.game.component.chat.message.IMessageListener;
import com.tencent.timi.game.component.chat.message.MessageLayout.LayoutClickListener;
import com.tencent.timi.game.component.chat.message.MessageLayoutImpl;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.datareport.api.IReportService.DefaultImpls;
import com.tencent.timi.game.gift.api.ReceiverInfoModel;
import com.tencent.timi.game.gift.impl.timi.TimiGiftController;
import com.tencent.timi.game.room.api.IRoomCommonConf;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.SimpleYoloRoomCommonListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomCommonListener;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.api.wrapper.IRoomListenerService;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.impl.input.TeamOperateView;
import com.tencent.timi.game.team.impl.input.TeamOperateView.OnActionClickListener;
import com.tencent.timi.game.team.impl.main.TeamUtil;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.YoloRoomActionMsg;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomUpdateGameRouteInfoAction;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/team/impl/chat/TeamChatView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/timi/game/component/chat/at/FamilyAtFunction;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "chatId", "", "giftController", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftController;", "historyHandler", "com/tencent/timi/game/team/impl/chat/TeamChatView$historyHandler$1", "Lcom/tencent/timi/game/team/impl/chat/TeamChatView$historyHandler$1;", "historyMsgIdList", "", "", "iMsgManager", "Lcom/tencent/timi/game/tim/api/message/IMsgManager;", "getIMsgManager", "()Lcom/tencent/timi/game/tim/api/message/IMsgManager;", "setIMsgManager", "(Lcom/tencent/timi/game/tim/api/message/IMsgManager;)V", "inputBoxView", "Lcom/tencent/timi/game/team/impl/chat/TeamInputView;", "lastMsg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "listener", "Lcom/tencent/timi/game/room/api/SimpleYoloRoomCommonListener;", "messageLayout", "Lcom/tencent/timi/game/component/chat/message/MessageLayoutImpl;", "msgListener", "com/tencent/timi/game/team/impl/chat/TeamChatView$msgListener$1", "Lcom/tencent/timi/game/team/impl/chat/TeamChatView$msgListener$1;", "openFrom", "qqUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "retryGetHistory", "", "getRetryGetHistory", "()Z", "setRetryGetHistory", "(Z)V", "roomId", "roomInfo", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "sendMsgIntervalTime", "getSendMsgIntervalTime", "()J", "teamOperationView", "Lcom/tencent/timi/game/team/impl/input/TeamOperateView;", "acquireInputBoxView", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "acquireInputView", "Landroid/widget/EditText;", "create", "", "destroy", "dismissGiftPanel", "getOperateView", "initGiftLayer", "isGiftPanelVisible", "isSupportActionMessage", "msg", "onNewMsg", "messageIsExist", "notifyGiftMemberChanged", "memberList", "", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "noAnimate", "onAttachedToWindow", "onDetachedFromWindow", "onPageHide", "onPageShow", "setChatViewBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "setMessageListener", "Lcom/tencent/timi/game/component/chat/message/IMessageListener;", "showGiftPanel", "showKeyboard", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamChatView
  extends RelativeLayout
  implements FamilyAtFunction
{
  public static final TeamChatView.Companion a = new TeamChatView.Companion(null);
  private List<String> b = (List)new ArrayList();
  private IMsg c;
  private MessageLayoutImpl d;
  private TeamInputView e;
  private TeamOperateView f;
  private long g;
  private long h;
  private int i;
  private YoloRoomOuterClass.YoloRoomInfo j;
  private CommonOuterClass.QQUserId k;
  @Nullable
  private IMsgManager l;
  private TimiGiftController m;
  private boolean n;
  private TeamChatView.historyHandler.1 o = new TeamChatView.historyHandler.1(this);
  private final SimpleYoloRoomCommonListener p;
  private final TeamChatView.msgListener.1 q;
  private HashMap r;
  
  @JvmOverloads
  public TeamChatView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TeamChatView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TeamChatView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    RelativeLayout.inflate(paramContext, 2131629490, (ViewGroup)this);
    paramContext = findViewById(2131438151);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.messageLayout)");
    this.d = ((MessageLayoutImpl)paramContext);
    paramContext = findViewById(2131435812);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.inputBoxView)");
    this.e = ((TeamInputView)paramContext);
    setClipChildren(false);
    paramContext = findViewById(2131446906);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.team_operate_layout)");
    this.f = ((TeamOperateView)paramContext);
    this.d.setLayoutClickListener((MessageLayout.LayoutClickListener)new TeamChatView.1(this));
    this.f.setOnActionClickListener((TeamOperateView.OnActionClickListener)new TeamChatView.2(this));
    this.p = ((SimpleYoloRoomCommonListener)new TeamChatView.listener.1(this));
    this.q = new TeamChatView.msgListener.1(this);
  }
  
  private final void a(List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList, boolean paramBoolean)
  {
    List localList = (List)new ArrayList();
    int i2 = ((Collection)paramList).size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)paramList.get(i1)).uid.get() > 0L)
      {
        MessageMicro localMessageMicro = ((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)paramList.get(i1)).user_id.get();
        Intrinsics.checkExpressionValueIsNotNull(localMessageMicro, "memberList[i].user_id.get()");
        localList.add(new ReceiverInfoModel((CommonOuterClass.QQUserId)localMessageMicro, i1, "", false, false, false, 56, null));
      }
      i1 += 1;
    }
    paramList = this.m;
    if (paramList != null) {
      paramList.a(localList);
    }
  }
  
  private final boolean a(IMsg paramIMsg, boolean paramBoolean)
  {
    int i1 = paramIMsg.c();
    boolean bool = true;
    paramBoolean = bool;
    if (i1 == 49)
    {
      paramBoolean = bool;
      if (paramIMsg.g().yolo_room_action_msg.has())
      {
        i1 = paramIMsg.g().yolo_room_action_msg.yolo_room_action.action_type.get();
        paramBoolean = bool;
        if (i1 != 252)
        {
          paramBoolean = bool;
          if (i1 != 103)
          {
            paramBoolean = bool;
            if (i1 != 102)
            {
              paramBoolean = bool;
              if (i1 != 251)
              {
                if (i1 == 108)
                {
                  paramIMsg = paramIMsg.g().yolo_room_action_msg.yolo_room_action.yolo_room_update_game_route_info_action.status_change_text.get();
                  Intrinsics.checkExpressionValueIsNotNull(paramIMsg, "msg.content().yolo_room_….status_change_text.get()");
                  if ((StringsKt.isBlank((CharSequence)paramIMsg) ^ true)) {
                    return true;
                  }
                }
                paramBoolean = false;
              }
            }
          }
        }
      }
    }
    return paramBoolean;
  }
  
  private final boolean b(IMsg paramIMsg, boolean paramBoolean)
  {
    if (this.b.contains(paramIMsg.a()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("messageIsExist ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",id=");
      localStringBuilder.append(paramIMsg.a());
      localStringBuilder.append(',');
      localStringBuilder.append(paramIMsg.c());
      Logger.b("TeamChatView", localStringBuilder.toString());
      return true;
    }
    this.b.add(paramIMsg.a());
    return false;
  }
  
  private final long getSendMsgIntervalTime()
  {
    IService localIService = ServiceCenter.a(IRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localIService, "ServiceCenter.getService(IRoomService::class.java)");
    return ((IRoomService)localIService).c().b() * 1000L;
  }
  
  private final void i()
  {
    AtMsgManager.a.a().a(String.valueOf(this.g));
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(this.g).b((IMsgListener)this.q);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(this.h).b((YoloRoomInterface.YoloRoomCommonListener)this.p);
    TimiGiftController localTimiGiftController = this.m;
    if (localTimiGiftController != null) {
      localTimiGiftController.a(false);
    }
  }
  
  public View a(int paramInt)
  {
    if (this.r == null) {
      this.r = new HashMap();
    }
    View localView2 = (View)this.r.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.r.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a(@NotNull TimiGiftController paramTimiGiftController)
  {
    Intrinsics.checkParameterIsNotNull(paramTimiGiftController, "giftController");
    this.m = paramTimiGiftController;
  }
  
  public final void a(@NotNull YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, @NotNull CommonOuterClass.QQUserId paramQQUserId, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramYoloRoomInfo, "roomInfo");
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "qqUserId");
    this.j = paramYoloRoomInfo;
    this.g = paramYoloRoomInfo.tim_group_id.get();
    this.h = paramYoloRoomInfo.room_id.get();
    this.k = paramQQUserId;
    this.i = paramInt;
    this.d.setMessageListener((IMessageListener)new TeamChatView.create.1());
    AtMsgManager.a.a().a(String.valueOf(this.g), paramQQUserId);
    this.l = ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(this.g);
    Object localObject = this.l;
    if (localObject != null) {
      ((IMsgManager)localObject).b((IMsgListener)this.q);
    }
    localObject = this.l;
    if (localObject != null) {
      ((IMsgManager)localObject).a((IMsgListener)this.q);
    }
    this.d.setRoomInfo(paramYoloRoomInfo);
    this.d.setChatId(this.g);
    this.d.setQQUserId(paramQQUserId);
    localObject = this.l;
    if (localObject != null) {
      ((IMsgManager)localObject).a(this.c);
    }
    postDelayed((Runnable)new TeamChatView.create.2(this, paramInt, paramYoloRoomInfo), 500L);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).c(this.h).a((YoloRoomInterface.YoloRoomCommonListener)this.p);
    this.e.a((TimiBaseInputView.StateChangedListener)new TeamChatView.create.3(this, paramQQUserId));
    localObject = this.e.getEmojiBtn();
    if (localObject != null)
    {
      paramQQUserId = (IReportService)ServiceCenter.a(IReportService.class);
      localObject = (View)localObject;
      paramYoloRoomInfo = YoloRoomUtil.c(paramYoloRoomInfo);
      Intrinsics.checkExpressionValueIsNotNull(paramYoloRoomInfo, "YoloRoomUtil.getCommonRo…InfoReportParam(roomInfo)");
      IReportService.DefaultImpls.a(paramQQUserId, (View)localObject, false, null, "em_yes_emoji", (Map)paramYoloRoomInfo, 6, null);
    }
    paramYoloRoomInfo = this.f.getGiftBtn();
    if (paramYoloRoomInfo != null)
    {
      paramQQUserId = (IReportService)ServiceCenter.a(IReportService.class);
      localObject = TeamUtil.a(this.h);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "TeamUtil.getCommonRoomInfoReportParam(roomId)");
      paramQQUserId.a(paramYoloRoomInfo, false, "礼物入口按钮", "em_yes_gift", (Map)localObject);
    }
  }
  
  public final boolean a()
  {
    TimiGiftController localTimiGiftController = this.m;
    return (localTimiGiftController != null) && (localTimiGiftController.c() == true);
  }
  
  public final void b()
  {
    TimiGiftController localTimiGiftController = this.m;
    if (localTimiGiftController != null) {
      localTimiGiftController.b();
    }
  }
  
  @Nullable
  public EditText c()
  {
    return this.e.getInputEditText();
  }
  
  @Nullable
  public TimiBaseInputView dJ_()
  {
    return (TimiBaseInputView)this.e;
  }
  
  public final void e()
  {
    Logger.c("ROOM_ENTER_TEST", "onPageShow");
  }
  
  public final void f()
  {
    TimiGiftController localTimiGiftController = this.m;
    if (localTimiGiftController != null) {
      localTimiGiftController.b();
    }
    this.e.setState(1);
    i();
  }
  
  public final void g()
  {
    Object localObject = this.m;
    if (localObject != null) {
      ((TimiGiftController)localObject).a();
    }
    localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.h);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…ass.java).getData(roomId)");
    localObject = ((IRoomGetDataService)localObject).h();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "memberList");
    a((List)localObject, true);
    localObject = this.m;
    if (localObject != null) {
      ((TimiGiftController)localObject).a("0");
    }
  }
  
  @Nullable
  public final IMsgManager getIMsgManager()
  {
    return this.l;
  }
  
  @NotNull
  public final TeamOperateView getOperateView()
  {
    return this.f;
  }
  
  public final boolean getRetryGetHistory()
  {
    return this.n;
  }
  
  public final void h()
  {
    this.e.setVisibility(0);
    this.e.h();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = this.f.getGiftBtn();
    if (localObject != null)
    {
      IReportService localIReportService = (IReportService)ServiceCenter.a(IReportService.class);
      if (localObject != null)
      {
        localObject = (Object)localObject;
        ConcurrentHashMap localConcurrentHashMap = TeamUtil.a(this.h);
        Intrinsics.checkExpressionValueIsNotNull(localConcurrentHashMap, "TeamUtil.getCommonRoomInfoReportParam(roomId)");
        localIReportService.a("imp", localObject, (Map)localConcurrentHashMap);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.f.getGiftBtn();
    if (localObject != null)
    {
      IReportService localIReportService = (IReportService)ServiceCenter.a(IReportService.class);
      if (localObject != null)
      {
        localObject = (Object)localObject;
        ConcurrentHashMap localConcurrentHashMap = TeamUtil.a(this.h);
        Intrinsics.checkExpressionValueIsNotNull(localConcurrentHashMap, "TeamUtil.getCommonRoomInfoReportParam(roomId)");
        localIReportService.a("imp_end", localObject, (Map)localConcurrentHashMap);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
    }
  }
  
  public final void setChatViewBackground(@NotNull Drawable paramDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "drawable");
    if (Build.VERSION.SDK_INT >= 16)
    {
      View localView = a(2131438150);
      Intrinsics.checkExpressionValueIsNotNull(localView, "messageBottomBackground");
      localView.setBackground(paramDrawable);
    }
  }
  
  public final void setIMsgManager(@Nullable IMsgManager paramIMsgManager)
  {
    this.l = paramIMsgManager;
  }
  
  public final void setMessageListener(@NotNull IMessageListener paramIMessageListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIMessageListener, "listener");
    this.d.setMessageListener(paramIMessageListener);
  }
  
  public final void setRetryGetHistory(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamChatView
 * JD-Core Version:    0.7.0.1
 */