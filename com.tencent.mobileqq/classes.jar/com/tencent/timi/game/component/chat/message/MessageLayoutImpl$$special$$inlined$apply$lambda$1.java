package com.tencent.timi.game.component.chat.message;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "onTouch", "com/tencent/timi/game/component/chat/message/MessageLayoutImpl$1$1"}, k=3, mv={1, 1, 16})
final class MessageLayoutImpl$$special$$inlined$apply$lambda$1
  implements View.OnTouchListener
{
  MessageLayoutImpl$$special$$inlined$apply$lambda$1(MessageLayoutImpl paramMessageLayoutImpl) {}
  
  public final boolean onTouch(@Nullable View paramView, @Nullable MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null)
    {
      int i = paramMotionEvent.getAction();
      if ((i == 0) || (3 == i))
      {
        paramView = MessageLayoutImpl.j(this.a);
        if (paramView != null) {
          paramView.a();
        }
      }
      if ((1 == i) || (3 == i))
      {
        paramView = MessageLayoutImpl.k(this.a);
        if (paramView != null) {
          paramView.a();
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageLayoutImpl..special..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */