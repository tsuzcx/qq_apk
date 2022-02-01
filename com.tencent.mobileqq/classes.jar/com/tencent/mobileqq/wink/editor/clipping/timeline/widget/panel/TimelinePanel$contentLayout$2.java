package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"}, k=3, mv={1, 1, 16})
final class TimelinePanel$contentLayout$2
  extends Lambda
  implements Function0<LinearLayout>
{
  TimelinePanel$contentLayout$2(Context paramContext)
  {
    super(0);
  }
  
  @NotNull
  public final LinearLayout invoke()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.$context);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)new ConstraintLayout.LayoutParams(-1, -1));
    return localLinearLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel.contentLayout.2
 * JD-Core Version:    0.7.0.1
 */