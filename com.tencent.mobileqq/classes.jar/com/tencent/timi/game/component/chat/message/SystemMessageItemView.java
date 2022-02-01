package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.utils.CommonExKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.YoloRoomRotateMsg;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomRotateMessage;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/SystemMessageItemView;", "Lcom/tencent/timi/game/component/chat/message/CenterMessageView;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "systemTv", "Landroid/widget/TextView;", "renderUI", "", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SystemMessageItemView
  extends CenterMessageView
{
  private final TextView a;
  private HashMap b;
  
  @JvmOverloads
  public SystemMessageItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public SystemMessageItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public SystemMessageItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2131629485);
    paramContext = findViewById(2131446718);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.system_tv)");
    this.a = ((TextView)paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.leftMargin = CommonExKt.a(16);
    paramContext.rightMargin = CommonExKt.a(16);
    this.a.setLayoutParams((ViewGroup.LayoutParams)paramContext);
  }
  
  public View a(int paramInt)
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    View localView2 = (View)this.b.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.b.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  protected void a(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    super.a(paramIMsg);
    paramIMsg = paramIMsg.g().yolo_room_rotate_msg;
    if (paramIMsg != null)
    {
      paramIMsg = paramIMsg.yolo_room_rotate_message;
      if (paramIMsg != null)
      {
        paramIMsg = paramIMsg.message_tpl;
        if (paramIMsg != null)
        {
          paramIMsg = paramIMsg.get();
          break label53;
        }
      }
    }
    paramIMsg = null;
    label53:
    paramIMsg = (CharSequence)paramIMsg;
    int i;
    if ((paramIMsg != null) && (!StringsKt.isBlank(paramIMsg))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      this.a.setText((CharSequence)"");
      return;
    }
    this.a.setText(paramIMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.SystemMessageItemView
 * JD-Core Version:    0.7.0.1
 */