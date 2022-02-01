package com.tencent.timi.game.liveroom.impl;

import android.graphics.Rect;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.timi.game.liveroom.impl.view.AnchorPrivateGuideView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

class TimiAnchorView$12$1
  implements Function1<Rect, Unit>
{
  TimiAnchorView$12$1(TimiAnchorView.12 param12) {}
  
  public Unit a(Rect paramRect)
  {
    TimiAnchorView.t(this.a.this$0).setVisibility(0);
    TimiAnchorView.t(this.a.this$0).setPrivateBtnRect(paramRect);
    paramRect = this.a.this$0.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("");
    SharePreferenceUtils.a(paramRect, "TIMI_ANCHOR_PRIVACY_GUIDE_SHOW_FLAG", localStringBuilder.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.TimiAnchorView.12.1
 * JD-Core Version:    0.7.0.1
 */