package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.component.chat.at.AtMessageClickListener;
import com.tencent.timi.game.component.chat.at.AtMsgManager;
import com.tencent.timi.game.component.chat.at.AtMsgManager.Companion;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.component.chat.util.EmotionCodecUtils;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.impl.main.TeamUtil;
import com.tencent.timi.game.tim.api.impl.message.MessageOuterClassExKt;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.ui.CenterAlignSizeImageSpan;
import com.tencent.timi.game.ui.utils.ResUtils;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.AtUser;
import trpc.yes.common.MessageOuterClass.AtUserMsg;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.TextMsg;
import trpc.yes.common.MessageOuterClass.YoloRoomActionMsg;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomAction;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/TextMessageItemView;", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "atUserInfoMap", "", "", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "otherBubbleBg", "Landroid/graphics/drawable/GradientDrawable;", "roomId", "", "selfBubbleBg", "spannable", "Landroid/text/SpannableStringBuilder;", "getLongOperOptions", "", "Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "()[Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "handleAtMsg", "", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "handleHelperMsg", "handleTextMsg", "handleUnsupportMsg", "onDetachedFromWindow", "putIntoShowedList", "msgId", "renderUI", "resetUserInfoMap", "data", "", "Ltrpc/yes/common/MessageOuterClass$AtUser;", "setRoomId", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TextMessageItemView
  extends BaseMessageView
{
  public static final TextMessageItemView.Companion a = new TextMessageItemView.Companion(null);
  private static final ForegroundColorSpan g = new ForegroundColorSpan(Color.parseColor("#F5A300"));
  private static final Bitmap h;
  private static final CenterAlignSizeImageSpan i;
  private GradientDrawable b;
  private GradientDrawable c;
  private Map<String, CommonOuterClass.QQUserId> d = (Map)new LinkedHashMap();
  private final SpannableStringBuilder e = new SpannableStringBuilder();
  private long f;
  private HashMap j;
  
  static
  {
    Object localObject = MobileQQ.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MobileQQ.getContext()");
    h = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(((BaseApplication)localObject).getResources(), 2130853127), LayoutExKt.b(12), LayoutExKt.b(12), false);
    localObject = h;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "arrowBitmap");
    i = new CenterAlignSizeImageSpan((Bitmap)localObject);
  }
  
  @JvmOverloads
  public TextMessageItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TextMessageItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TextMessageItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2131629504);
    paramInt = LayoutExKt.b(8);
    this.b = new GradientDrawable();
    this.b.setColor(Color.parseColor("#FD942F"));
    paramContext = this.b;
    float f1 = paramInt;
    paramContext.setCornerRadii(new float[] { f1, f1, 0.0F, 0.0F, f1, f1, f1, f1 });
    this.c = new GradientDrawable();
    this.c.setColor(Color.parseColor("#FFFFFF"));
    this.c.setCornerRadii(new float[] { 0.0F, 0.0F, f1, f1, f1, f1, f1, f1 });
    ((TextView)a(2131447089)).setSpannableFactory(QQText.SPANNABLE_FACTORY);
    paramContext = (TextView)a(2131447089);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "textView");
    paramContext.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private final void e(IMsg paramIMsg)
  {
    if (paramIMsg != null) {
      AtMsgManager.a.a().b(String.valueOf(paramIMsg.h()), paramIMsg.a());
    }
  }
  
  private final void f(IMsg paramIMsg)
  {
    paramIMsg = EmotionCodecUtils.c(paramIMsg.g().text_msg.text.get());
    TextView localTextView = (TextView)a(2131447089);
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "textView");
    localTextView.setText((CharSequence)new QQText((CharSequence)paramIMsg, 3, 20));
  }
  
  private final void g(IMsg paramIMsg)
  {
    Object localObject1 = (IReportService)ServiceCenter.a(IReportService.class);
    Object localObject2 = (TextView)a(2131447089);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "textView");
    localObject2 = (View)localObject2;
    paramIMsg = String.valueOf(paramIMsg.a());
    ConcurrentHashMap localConcurrentHashMap = TeamUtil.a(this.f);
    Intrinsics.checkExpressionValueIsNotNull(localConcurrentHashMap, "TeamUtil.getCommonRoomInfoReportParam(roomId)");
    ((IReportService)localObject1).a((View)localObject2, true, paramIMsg, "em_yes_chat_send_smoba_cpdd", (Map)localConcurrentHashMap);
    paramIMsg = (TextView)a(2131447089);
    Intrinsics.checkExpressionValueIsNotNull(paramIMsg, "textView");
    localObject1 = new SpannableString((CharSequence)"你已经成功创建车队，快去邀请好友加入吧 发送到大厅 ");
    ((SpannableString)localObject1).setSpan(new TextMessageItemView.handleHelperMsg..inlined.apply.lambda.1(this), 20, 26, 33);
    ((SpannableString)localObject1).setSpan(g, 20, 25, 33);
    ((SpannableString)localObject1).setSpan(i, 25, 26, 33);
    paramIMsg.setText((CharSequence)localObject1);
    paramIMsg = (TextView)a(2131447089);
    Intrinsics.checkExpressionValueIsNotNull(paramIMsg, "textView");
    paramIMsg.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private final void h(IMsg paramIMsg)
  {
    a(paramIMsg.g().at_user_msg.user_list.get());
    Object localObject1 = EmotionCodecUtils.c(paramIMsg.g().at_user_msg.text.get());
    this.e.clear();
    this.e.clearSpans();
    this.e.append((CharSequence)localObject1);
    Object localObject2 = SpecialMsgUtil.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "text");
    Object localObject3 = this.d;
    SpannableStringBuilder localSpannableStringBuilder = this.e;
    int k;
    if (paramIMsg.j()) {
      k = 2131168464;
    } else {
      k = 2131168293;
    }
    ((SpecialMsgUtil)localObject2).a(0, (String)localObject1, (Map)localObject3, localSpannableStringBuilder, ResUtils.b(k), paramIMsg.j(), (AtMessageClickListener)new TextMessageItemView.handleAtMsg.1(this));
    localObject1 = (TextView)a(2131447089);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "textView");
    ((TextView)localObject1).setText((CharSequence)new QQText((CharSequence)this.e, 3, 20));
    localObject1 = (IReportService)ServiceCenter.a(IReportService.class);
    localObject2 = (TextView)a(2131447089);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "textView");
    localObject2 = (View)localObject2;
    paramIMsg = String.valueOf(paramIMsg.a());
    localObject3 = YoloRoomUtil.c(getRoomInfo());
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "YoloRoomUtil.getCommonRo…InfoReportParam(roomInfo)");
    ((IReportService)localObject1).b((View)localObject2, true, paramIMsg, "em_yes_chat_at_msg", (Map)localObject3);
    ((TextView)a(2131447089)).setOnClickListener((View.OnClickListener)TextMessageItemView.handleAtMsg.2.a);
  }
  
  private final void i(IMsg paramIMsg)
  {
    Object localObject = (TextView)a(2131447089);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "textView");
    ((TextView)localObject).setText((CharSequence)"[收到一条消息，当前版本不支持查看，请更新至新版本]");
    if (Env.b())
    {
      localObject = (TextView)a(2131447089);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "textView");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("调试展示：不支持消息类型type[");
      localStringBuilder.append(paramIMsg.c());
      localStringBuilder.append("], actionType[");
      localStringBuilder.append(paramIMsg.g().yolo_room_action_msg.yolo_room_action.action_type.get());
      localStringBuilder.append(']');
      ((TextView)localObject).setText((CharSequence)localStringBuilder.toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("not support type ");
    ((StringBuilder)localObject).append(paramIMsg.c());
    Logger.b("TextMessageViewDebug", ((StringBuilder)localObject).toString());
  }
  
  public View a(int paramInt)
  {
    if (this.j == null) {
      this.j = new HashMap();
    }
    View localView2 = (View)this.j.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.j.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a(@Nullable List<MessageOuterClass.AtUser> paramList)
  {
    this.d.clear();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        Object localObject = (MessageOuterClass.AtUser)paramList.next();
        if (((MessageOuterClass.AtUser)localObject).user_id.uid.get() != 0L)
        {
          CommonOuterClass.QQUserId localQQUserId = (CommonOuterClass.QQUserId)((MessageOuterClass.AtUser)localObject).user_id.get();
          localObject = ((MessageOuterClass.AtUser)localObject).nick_name.get();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            Map localMap = this.d;
            Intrinsics.checkExpressionValueIsNotNull(localObject, "atUserName");
            Intrinsics.checkExpressionValueIsNotNull(localQQUserId, "atUserId");
            localMap.put(localObject, localQQUserId);
          }
        }
      }
    }
    paramList = new StringBuilder();
    paramList.append("atUserInfoMap =");
    paramList.append(this.d);
    Logger.a("TxtMsgView ", paramList.toString());
  }
  
  protected void b(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    super.b(paramIMsg);
    TextView localTextView = (TextView)a(2131447089);
    if (paramIMsg.j())
    {
      localObject = getResources();
      k = 2131168464;
    }
    else
    {
      localObject = getResources();
      k = 2131165564;
    }
    localTextView.setTextColor(((Resources)localObject).getColor(k));
    localTextView = (TextView)a(2131447089);
    if (paramIMsg.j()) {
      localObject = this.b;
    } else {
      localObject = this.c;
    }
    localTextView.setBackgroundDrawable((Drawable)localObject);
    Object localObject = getIImConfig();
    if (localObject != null)
    {
      ((TextView)a(2131447089)).setTextColor(((MessageLayout.IIMConfig)localObject).b(paramIMsg));
      if (paramIMsg.j()) {
        this.b.setColor(((MessageLayout.IIMConfig)localObject).a(paramIMsg));
      } else {
        this.c.setColor(((MessageLayout.IIMConfig)localObject).a(paramIMsg));
      }
      localTextView = (TextView)a(2131447089);
      if (paramIMsg.j()) {
        localObject = this.b;
      } else {
        localObject = this.c;
      }
      localTextView.setBackgroundDrawable((Drawable)localObject);
    }
    int k = paramIMsg.c();
    if (k == 1) {
      f(paramIMsg);
    } else if (k == MessageOuterClassExKt.a()) {
      g(paramIMsg);
    } else if (k == 70) {
      h(paramIMsg);
    } else {
      i(paramIMsg);
    }
    ((TextView)a(2131447089)).setOnTouchListener(getPositionOnTouchListener());
    ((TextView)a(2131447089)).setOnLongClickListener(getOnLongClickListner());
  }
  
  @Nullable
  protected LongClickOperOption[] getLongOperOptions()
  {
    Object localObject = (List)new ArrayList();
    IMsg localIMsg = getMsg();
    if (localIMsg != null)
    {
      if ((localIMsg.c() == 1) || (localIMsg.c() == 70))
      {
        ((List)localObject).add(LongClickOperOption.COPY);
        if (!localIMsg.j()) {
          ((List)localObject).add(LongClickOperOption.REPORT);
        }
      }
      ((List)localObject).add(LongClickOperOption.DELETE);
    }
    localObject = ((Collection)localObject).toArray(new LongClickOperOption[0]);
    if (localObject != null) {
      return (LongClickOperOption[])localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    IMsg localIMsg = getMsg();
    if ((localIMsg != null) && (localIMsg.k())) {
      e(localIMsg);
    }
  }
  
  public final void setRoomId(long paramLong)
  {
    this.f = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.TextMessageItemView
 * JD-Core Version:    0.7.0.1
 */