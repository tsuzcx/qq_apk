package com.tencent.timi.game.component.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.component.chat.at.AtMsgManager;
import com.tencent.timi.game.component.chat.at.AtMsgManager.Companion;
import com.tencent.timi.game.component.chat.at.FamilyAtFunction;
import com.tencent.timi.game.component.chat.input.ExpandHallInputBoxView;
import com.tencent.timi.game.component.chat.input.IInputView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener;
import com.tencent.timi.game.component.chat.message.IMessageListener;
import com.tencent.timi.game.component.chat.message.MessageLayout.LayoutClickListener;
import com.tencent.timi.game.component.chat.message.MessageLayoutImpl;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.datareport.api.IReportService.DefaultImpls;
import com.tencent.timi.game.expand.hall.impl.util.SafeNoticeMsgManager;
import com.tencent.timi.game.expand.hall.impl.util.SafeNoticeMsgManager.Companion;
import com.tencent.timi.game.room.api.IRoomCommonConf;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.utils.Logger;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/ChatView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/timi/game/component/chat/at/FamilyAtFunction;", "Lcom/tencent/timi/game/component/chat/input/IInputView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "chatId", "", "msgListener", "Lcom/tencent/timi/game/tim/api/message/IMsgListener;", "msgSendStatusListener", "Lcom/tencent/timi/game/component/chat/ChatView$IMsgSendStatusListener;", "getMsgSendStatusListener", "()Lcom/tencent/timi/game/component/chat/ChatView$IMsgSendStatusListener;", "setMsgSendStatusListener", "(Lcom/tencent/timi/game/component/chat/ChatView$IMsgSendStatusListener;)V", "qqUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "sendMsgIntervalTime", "getSendMsgIntervalTime", "()J", "type", "Lcom/tencent/timi/game/component/chat/ConvType;", "acquireInputBoxView", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "acquireInputView", "Landroid/widget/EditText;", "addStateChangedListener", "", "listener", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$StateChangedListener;", "createChat", "roomInfo", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "destroyChat", "getMessageManager", "Lcom/tencent/timi/game/tim/api/message/IMsgManager;", "getMsgNumOnList", "hideKeyboard", "init", "insertLocalMsg", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "onPause", "removeStateChangedListener", "setMessageListener", "Lcom/tencent/timi/game/component/chat/message/IMessageListener;", "showKeyBoard", "Companion", "IMsgSendStatusListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class ChatView
  extends LinearLayout
  implements FamilyAtFunction, IInputView
{
  public static final ChatView.Companion a = new ChatView.Companion(null);
  private long b;
  private CommonOuterClass.QQUserId c;
  private ConvType d = ConvType.C2C;
  @Nullable
  private ChatView.IMsgSendStatusListener e;
  private IMsgListener f;
  private HashMap g;
  
  public ChatView(@NotNull Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public ChatView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public ChatView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private final void e()
  {
    setOrientation(1);
    View.inflate(getContext(), 2131629426, (ViewGroup)this);
    ((MessageLayoutImpl)a(2131438151)).setLayoutClickListener((MessageLayout.LayoutClickListener)new ChatView.init.1(this));
  }
  
  private final long getSendMsgIntervalTime()
  {
    IService localIService = ServiceCenter.a(IRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localIService, "ServiceCenter.getService(IRoomService::class.java)");
    return ((IRoomService)localIService).c().a() * 1000L;
  }
  
  public View a(int paramInt)
  {
    if (this.g == null) {
      this.g = new HashMap();
    }
    View localView2 = (View)this.g.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.g.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public abstract IMsgManager a(long paramLong);
  
  public void a()
  {
    ((ExpandHallInputBoxView)a(2131435812)).i();
  }
  
  public final void a(@NotNull ConvType paramConvType, @NotNull YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, @NotNull CommonOuterClass.QQUserId paramQQUserId)
  {
    Intrinsics.checkParameterIsNotNull(paramConvType, "type");
    Intrinsics.checkParameterIsNotNull(paramYoloRoomInfo, "roomInfo");
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "qqUserId");
    this.d = paramConvType;
    this.b = paramYoloRoomInfo.tim_group_id.get();
    this.c = paramQQUserId;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createChat type = [");
    ((StringBuilder)localObject).append(paramConvType);
    ((StringBuilder)localObject).append("], chatId = [");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(']');
    Logger.b("ChatView", ((StringBuilder)localObject).toString());
    AtMsgManager.a.a().a(String.valueOf(this.b), paramQQUserId);
    paramConvType = a(this.b);
    paramConvType.b(this.f);
    this.f = ((IMsgListener)new ChatView.createChat.1(this, paramYoloRoomInfo));
    paramConvType.a(this.f);
    ((MessageLayoutImpl)a(2131438151)).setChatId(this.b);
    ((MessageLayoutImpl)a(2131438151)).setRoomInfo(paramYoloRoomInfo);
    ((MessageLayoutImpl)a(2131438151)).setQQUserId(paramQQUserId);
    ((ExpandHallInputBoxView)a(2131435812)).a(paramYoloRoomInfo.room_id.get());
    localObject = ((ExpandHallInputBoxView)a(2131435812)).getFuncBtn();
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)new ChatView.createChat.2(this, paramQQUserId, paramConvType, paramYoloRoomInfo));
    }
    ((ExpandHallInputBoxView)a(2131435812)).a((TimiBaseInputView.StateChangedListener)new ChatView.createChat.3(this, paramConvType, paramQQUserId));
    if (paramConvType != null) {
      paramConvType.a(((MessageLayoutImpl)a(2131438151)).c());
    }
    paramConvType = SafeNoticeMsgManager.a.a();
    if (paramConvType != null) {
      paramConvType.a(this);
    }
    paramQQUserId = ((ExpandHallInputBoxView)a(2131435812)).getEmojiBtn();
    if (paramQQUserId != null)
    {
      paramConvType = (IReportService)ServiceCenter.a(IReportService.class);
      paramQQUserId = (View)paramQQUserId;
      localObject = YoloRoomUtil.c(paramYoloRoomInfo);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "YoloRoomUtil.getCommonRo…InfoReportParam(roomInfo)");
      IReportService.DefaultImpls.a(paramConvType, paramQQUserId, false, null, "em_yes_emoji", (Map)localObject, 6, null);
    }
    paramConvType = ((ExpandHallInputBoxView)a(2131435812)).getFuncBtn();
    if (paramConvType != null)
    {
      paramQQUserId = (IReportService)ServiceCenter.a(IReportService.class);
      paramYoloRoomInfo = YoloRoomUtil.c(paramYoloRoomInfo);
      Intrinsics.checkExpressionValueIsNotNull(paramYoloRoomInfo, "YoloRoomUtil.getCommonRo…InfoReportParam(roomInfo)");
      IReportService.DefaultImpls.a(paramQQUserId, paramConvType, false, null, "em_yes_myprofile", (Map)paramYoloRoomInfo, 6, null);
    }
  }
  
  public void a(@NotNull TimiBaseInputView.StateChangedListener paramStateChangedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramStateChangedListener, "listener");
    ((ExpandHallInputBoxView)a(2131435812)).a(paramStateChangedListener);
  }
  
  public final void a(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    ((MessageLayoutImpl)a(2131438151)).c(paramIMsg);
  }
  
  public final void b()
  {
    IMsgManager localIMsgManager = a(this.b);
    if (localIMsgManager != null) {
      localIMsgManager.b(this.f);
    }
    AtMsgManager.a.a().a(String.valueOf(this.b));
  }
  
  public void b(@NotNull TimiBaseInputView.StateChangedListener paramStateChangedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramStateChangedListener, "listener");
    ((ExpandHallInputBoxView)a(2131435812)).b(paramStateChangedListener);
  }
  
  @Nullable
  public EditText c()
  {
    return ((ExpandHallInputBoxView)a(2131435812)).getInputEditText();
  }
  
  @Nullable
  public TimiBaseInputView dJ_()
  {
    return (ExpandHallInputBoxView)a(2131435812);
  }
  
  public final int getMsgNumOnList()
  {
    return ((MessageLayoutImpl)a(2131438151)).getMsgNumOnList();
  }
  
  @Nullable
  public final ChatView.IMsgSendStatusListener getMsgSendStatusListener()
  {
    return this.e;
  }
  
  public final void setMessageListener(@NotNull IMessageListener paramIMessageListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIMessageListener, "listener");
    ((MessageLayoutImpl)a(2131438151)).setMessageListener(paramIMessageListener);
  }
  
  public final void setMsgSendStatusListener(@Nullable ChatView.IMsgSendStatusListener paramIMsgSendStatusListener)
  {
    this.e = paramIMsgSendStatusListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.ChatView
 * JD-Core Version:    0.7.0.1
 */