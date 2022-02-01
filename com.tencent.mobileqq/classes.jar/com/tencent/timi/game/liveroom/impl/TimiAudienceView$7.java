package com.tencent.timi.game.liveroom.impl;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener;
import com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass.MsgContent;

class TimiAudienceView$7
  implements TimiBaseInputView.StateChangedListener
{
  GradientDrawable a = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { Color.parseColor("#00111129"), Color.parseColor("#E6111129") });
  
  TimiAudienceView$7(TimiAudienceView paramTimiAudienceView) {}
  
  public void a(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)TimiAudienceView.k(this.b).getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)TimiAudienceView.l(this.b).getLayoutParams();
    localLayoutParams1.height = TimiAudienceView.k(this.b).getHeight();
    localLayoutParams2.height = TimiAudienceView.l(this.b).getHeight();
    localLayoutParams1.addRule(3, 0);
    localLayoutParams1.addRule(2, 2131428306);
    localLayoutParams2.addRule(3, 0);
    localLayoutParams2.addRule(2, 2131428311);
    TimiAudienceView.k(this.b).setLayoutParams(localLayoutParams1);
    TimiAudienceView.l(this.b).setLayoutParams(localLayoutParams2);
    if (paramInt != 1)
    {
      TimiAudienceView.k(this.b).setBackgroundColor(Color.parseColor("#E6111129"));
      TimiAudienceView.l(this.b).setBackgroundDrawable(this.a);
      TimiAudienceView.k(this.b).post(new TimiAudienceView.7.1(this));
      return;
    }
    TimiAudienceView.k(this.b).setBackgroundColor(0);
    TimiAudienceView.l(this.b).setBackgroundDrawable(null);
  }
  
  public void a(@NotNull String paramString, @NotNull TimiBaseInputView paramTimiBaseInputView) {}
  
  public void a(@NotNull String paramString, @NotNull MessageOuterClass.MsgContent paramMsgContent, @NotNull TimiBaseInputView paramTimiBaseInputView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAudienceView.7
 * JD-Core Version:    0.7.0.1
 */