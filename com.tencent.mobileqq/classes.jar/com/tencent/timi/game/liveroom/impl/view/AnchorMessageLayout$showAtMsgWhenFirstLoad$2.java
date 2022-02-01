package com.tencent.timi.game.liveroom.impl.view;

import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AnchorMessageLayout$showAtMsgWhenFirstLoad$2
  implements Runnable
{
  public final void run()
  {
    if (AnchorMessageLayout.f(this.this$0))
    {
      int i = AnchorMessageLayout.g(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showAtMsgWhenFirstLoad: findPos=");
      localStringBuilder.append(i);
      Logger.b("AnchorMessageLayout", localStringBuilder.toString());
      if (i >= 0)
      {
        AnchorMessageLayout.h(this.this$0).setText((CharSequence)AnchorMessageLayout.i(this.this$0));
        AnchorMessageLayout.a(this.this$0, true, (View.OnClickListener)new AnchorMessageLayout.showAtMsgWhenFirstLoad.2.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout.showAtMsgWhenFirstLoad.2
 * JD-Core Version:    0.7.0.1
 */