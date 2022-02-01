package com.tencent.timi.game.component.chat.message;

import android.view.View;
import com.tencent.timi.game.tim.api.message.IMsg;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/CenterMessageViewWrapper;", "Lcom/tencent/timi/game/component/chat/message/CenterMessageView;", "context", "Landroid/content/Context;", "iView", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$IView;", "(Landroid/content/Context;Lcom/tencent/timi/game/component/chat/message/MessageLayout$IView;)V", "wrapperView", "Landroid/view/View;", "getLongOperOptions", "", "Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "()[Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "renderUI", "", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class CenterMessageViewWrapper
  extends CenterMessageView
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
  
  protected void a(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    super.a(paramIMsg);
    this.a.a(this.b, paramIMsg);
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
 * Qualified Name:     com.tencent.timi.game.component.chat.message.CenterMessageViewWrapper
 * JD-Core Version:    0.7.0.1
 */