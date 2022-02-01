package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import com.tencent.timi.game.ui.utils.TimeUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/CenterMessageView;", "Lcom/tencent/timi/game/component/chat/message/TouchPositionGetableRelativeLayout;", "Lcom/tencent/timi/game/component/chat/message/IMessageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iThemeConfig", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$IIMConfig;", "getIThemeConfig", "()Lcom/tencent/timi/game/component/chat/message/MessageLayout$IIMConfig;", "setIThemeConfig", "(Lcom/tencent/timi/game/component/chat/message/MessageLayout$IIMConfig;)V", "lastPointerRawX", "lastPointerRawY", "messageViewOperator", "Lcom/tencent/timi/game/component/chat/message/MessageViewOperator;", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "getMsg", "()Lcom/tencent/timi/game/tim/api/message/IMsg;", "setMsg", "(Lcom/tencent/timi/game/tim/api/message/IMsg;)V", "onLongClickListner", "Landroid/view/View$OnLongClickListener;", "getOnLongClickListner", "()Landroid/view/View$OnLongClickListener;", "setOnLongClickListner", "(Landroid/view/View$OnLongClickListener;)V", "position", "getPosition", "()I", "setPosition", "(I)V", "getLongOperOptions", "", "Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "()[Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "needShowTime", "", "onDetachedFromWindow", "", "refresh", "qqUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "preMsg", "renderUI", "setContentView", "view", "Landroid/view/View;", "layoutResID", "setThemeConfig", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class CenterMessageView
  extends TouchPositionGetableRelativeLayout
  implements IMessageView
{
  @Nullable
  private IMsg a;
  private int b;
  private int c;
  private MessageViewOperator d = new MessageViewOperator();
  @Nullable
  private MessageLayout.IIMConfig e;
  private int f;
  @NotNull
  private View.OnLongClickListener g;
  private HashMap h;
  
  public CenterMessageView(@NotNull Context paramContext)
  {
    super(paramContext);
    setClipChildren(false);
    setClipToPadding(false);
    View.inflate(getContext(), 2131629423, (ViewGroup)this);
    paramContext = (View.OnTouchListener)new CenterMessageView.positionOnTouchListener.1(this);
    ((FrameLayout)a(2131431324)).setOnTouchListener(paramContext);
    this.g = ((View.OnLongClickListener)new CenterMessageView.onLongClickListner.1(this));
  }
  
  public CenterMessageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setClipChildren(false);
    setClipToPadding(false);
    View.inflate(getContext(), 2131629423, (ViewGroup)this);
    paramContext = (View.OnTouchListener)new CenterMessageView.positionOnTouchListener.1(this);
    ((FrameLayout)a(2131431324)).setOnTouchListener(paramContext);
    this.g = ((View.OnLongClickListener)new CenterMessageView.onLongClickListner.1(this));
  }
  
  public CenterMessageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setClipChildren(false);
    setClipToPadding(false);
    View.inflate(getContext(), 2131629423, (ViewGroup)this);
    paramContext = (View.OnTouchListener)new CenterMessageView.positionOnTouchListener.1(this);
    ((FrameLayout)a(2131431324)).setOnTouchListener(paramContext);
    this.g = ((View.OnLongClickListener)new CenterMessageView.onLongClickListner.1(this));
  }
  
  public View a(int paramInt)
  {
    if (this.h == null) {
      this.h = new HashMap();
    }
    View localView2 = (View)this.h.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.h.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  protected void a(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    paramIMsg = getLongOperOptions();
    if (paramIMsg != null)
    {
      int i;
      if (paramIMsg.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i ^ 0x1) != 0)
      {
        paramIMsg = (FrameLayout)a(2131431324);
        if (paramIMsg == null) {
          Intrinsics.throwNpe();
        }
        paramIMsg.setOnLongClickListener(this.g);
      }
    }
  }
  
  public void a(@Nullable CommonOuterClass.QQUserId paramQQUserId, @NotNull IMsg paramIMsg1, @Nullable IMsg paramIMsg2)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg1, "msg");
    this.a = paramIMsg1;
    if ((a()) && ((paramIMsg2 == null) || (Math.abs(paramIMsg1.e() - paramIMsg2.e()) > 180000L)))
    {
      paramQQUserId = (TextView)a(2131447352);
      Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "timeView");
      ViewExKt.a((View)paramQQUserId, true);
      paramQQUserId = (TextView)a(2131447352);
      Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "timeView");
      paramQQUserId.setText((CharSequence)TimeUtils.a(paramIMsg1.e()));
      paramQQUserId = this.e;
      if (paramQQUserId != null) {
        ((TextView)a(2131447352)).setTextColor(paramQQUserId.a());
      }
    }
    else
    {
      paramQQUserId = (TextView)a(2131447352);
      Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "timeView");
      ViewExKt.a((View)paramQQUserId, false);
    }
    if (paramIMsg1.f() == MsgStatus.REVOKE)
    {
      paramQQUserId = (FrameLayout)a(2131431324);
      Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "contentContainer");
      ViewExKt.a((View)paramQQUserId, false);
      paramQQUserId = (TextView)a(2131444750);
      Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "revokeView");
      paramQQUserId.setText((CharSequence)"消息已被撤回");
      return;
    }
    paramQQUserId = (TextView)a(2131444750);
    Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "revokeView");
    ViewExKt.a((View)paramQQUserId, false);
    paramQQUserId = (FrameLayout)a(2131431324);
    Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "contentContainer");
    ViewExKt.a((View)paramQQUserId, true);
    a(paramIMsg1);
  }
  
  protected final boolean a()
  {
    return true;
  }
  
  @Nullable
  protected final MessageLayout.IIMConfig getIThemeConfig()
  {
    return this.e;
  }
  
  @Nullable
  protected LongClickOperOption[] getLongOperOptions()
  {
    return null;
  }
  
  @Nullable
  protected final IMsg getMsg()
  {
    return this.a;
  }
  
  @NotNull
  protected final View.OnLongClickListener getOnLongClickListner()
  {
    return this.g;
  }
  
  public final int getPosition()
  {
    return this.f;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.d.a();
  }
  
  public void setContentView(@LayoutRes int paramInt)
  {
    ((FrameLayout)a(2131431324)).addView(RelativeLayout.inflate(getContext(), paramInt, null));
  }
  
  public void setContentView(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    ((FrameLayout)a(2131431324)).addView(paramView);
  }
  
  protected final void setIThemeConfig(@Nullable MessageLayout.IIMConfig paramIIMConfig)
  {
    this.e = paramIIMConfig;
  }
  
  protected final void setMsg(@Nullable IMsg paramIMsg)
  {
    this.a = paramIMsg;
  }
  
  protected final void setOnLongClickListner(@NotNull View.OnLongClickListener paramOnLongClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnLongClickListener, "<set-?>");
    this.g = paramOnLongClickListener;
  }
  
  public final void setPosition(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void setThemeConfig(@Nullable MessageLayout.IIMConfig paramIIMConfig)
  {
    this.e = paramIIMConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.CenterMessageView
 * JD-Core Version:    0.7.0.1
 */