package com.tencent.timi.game.component.chat.message;

import android.view.View;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.userinfo.impl.view.TimiAvatarRoundImageViewImpl;
import com.tencent.timi.game.userinfo.impl.view.TimiAvatarTextViewImpl;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/MessageViewWrapper;", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "context", "Landroid/content/Context;", "iView", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$IView;", "(Landroid/content/Context;Lcom/tencent/timi/game/component/chat/message/MessageLayout$IView;)V", "wrapperView", "Landroid/view/View;", "getLongOperOptions", "", "Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "()[Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "renderUI", "", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MessageViewWrapper
  extends BaseMessageView
{
  private MessageLayout.IView a;
  private View b;
  private HashMap c;
  
  public View a(int paramInt)
  {
    if (this.c == null) {
      this.c = new HashMap();
    }
    View localView2 = (View)this.c.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.c.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  protected void b(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    super.b(paramIMsg);
    this.a.a(this.b, paramIMsg);
    paramIMsg = (TimiAvatarRoundImageViewImpl)a(2131429327);
    Intrinsics.checkExpressionValueIsNotNull(paramIMsg, "baseAvatarView");
    paramIMsg.setLongClickable(false);
    paramIMsg = (TimiAvatarTextViewImpl)a(2131429329);
    Intrinsics.checkExpressionValueIsNotNull(paramIMsg, "baseNickView");
    paramIMsg.setText((CharSequence)"YES小助手");
  }
  
  @Nullable
  protected LongClickOperOption[] getLongOperOptions()
  {
    LongClickOperOption[] arrayOfLongClickOperOption = this.a.a();
    if (arrayOfLongClickOperOption != null) {
      return arrayOfLongClickOperOption;
    }
    return new LongClickOperOption[] { LongClickOperOption.DELETE };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageViewWrapper
 * JD-Core Version:    0.7.0.1
 */