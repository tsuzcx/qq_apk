package com.tencent.timi.game.expand.hall.impl.util;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/util/TouchUtil;", "", "()V", "isTouchOnView", "", "view", "Landroid/view/View;", "ev", "Landroid/view/MotionEvent;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TouchUtil
{
  public static final TouchUtil a = new TouchUtil();
  
  public final boolean a(@NotNull View paramView, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "ev");
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight()).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.util.TouchUtil
 * JD-Core Version:    0.7.0.1
 */