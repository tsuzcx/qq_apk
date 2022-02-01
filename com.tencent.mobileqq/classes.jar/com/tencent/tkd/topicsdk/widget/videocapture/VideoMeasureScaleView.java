package com.tencent.tkd.topicsdk.widget.videocapture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocapture/VideoMeasureScaleView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "checkNeedAddChildView", "", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoMeasureScaleView
  extends LinearLayout
{
  public static final VideoMeasureScaleView.Companion a = new VideoMeasureScaleView.Companion(null);
  
  public VideoMeasureScaleView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final void a()
  {
    if (getChildCount() < 40)
    {
      removeAllViews();
      int j = (getMeasuredWidth() - 80) / 39;
      int i = 0;
      while (i < 40)
      {
        View localView = new View(getContext());
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(2, -1);
        if (i != 0) {
          localLayoutParams.setMargins(j, 0, 0, 0);
        }
        localView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        localView.setBackgroundColor(-1);
        localView.setAlpha(0.1F);
        addView(localView);
        i += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocapture.VideoMeasureScaleView
 * JD-Core Version:    0.7.0.1
 */