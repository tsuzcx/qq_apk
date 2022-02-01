package com.tencent.timi.game.component.chat.message;

import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MessageLayoutImpl$showAtMsgWhenFirstLoad$2
  implements Runnable
{
  MessageLayoutImpl$showAtMsgWhenFirstLoad$2(MessageLayoutImpl paramMessageLayoutImpl) {}
  
  public final void run()
  {
    if (MessageLayoutImpl.a(this.this$0))
    {
      int i = MessageLayoutImpl.c(this.this$0);
      String str = MessageLayoutImpl.d(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showAtMsgWhenFirstLoad: findPos=");
      localStringBuilder.append(i);
      Logger.b(str, localStringBuilder.toString());
      if (i >= 0)
      {
        MessageLayoutImpl.e(this.this$0).setText((CharSequence)MessageLayoutImpl.f(this.this$0));
        MessageLayoutImpl.a(this.this$0, true, (View.OnClickListener)new MessageLayoutImpl.showAtMsgWhenFirstLoad.2.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageLayoutImpl.showAtMsgWhenFirstLoad.2
 * JD-Core Version:    0.7.0.1
 */