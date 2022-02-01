package com.tencent.qcircle.tavcut.view.ext;

import android.view.MotionEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/tavcut/view/ext/OnSingleFlingListener;", "", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public abstract interface OnSingleFlingListener
{
  public abstract boolean onFling(@Nullable MotionEvent paramMotionEvent1, @Nullable MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.view.ext.OnSingleFlingListener
 * JD-Core Version:    0.7.0.1
 */