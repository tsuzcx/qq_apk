package com.tencent.tavcut.view.ext;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/view/ext/OnViewTapListener;", "", "onViewTap", "", "view", "Landroid/view/View;", "x", "", "y", "e", "Landroid/view/MotionEvent;", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public abstract interface OnViewTapListener
{
  public abstract void a(@Nullable View paramView, float paramFloat1, float paramFloat2, @NotNull MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.view.ext.OnViewTapListener
 * JD-Core Version:    0.7.0.1
 */