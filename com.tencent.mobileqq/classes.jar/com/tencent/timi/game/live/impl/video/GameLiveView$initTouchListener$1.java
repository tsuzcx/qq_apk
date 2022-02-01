package com.tencent.timi.game.live.impl.video;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k=3, mv={1, 1, 16})
final class GameLiveView$initTouchListener$1
  implements View.OnTouchListener
{
  GameLiveView$initTouchListener$1(GameLiveView paramGameLiveView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (GameLiveView.a(this.a)) {
      return GameLiveView.b(this.a).onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.video.GameLiveView.initTouchListener.1
 * JD-Core Version:    0.7.0.1
 */