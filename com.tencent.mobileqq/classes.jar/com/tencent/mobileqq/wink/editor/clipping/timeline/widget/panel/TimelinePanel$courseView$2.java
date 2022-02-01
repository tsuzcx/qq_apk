package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.tencent.videocut.utils.DensityUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/view/View;", "invoke"}, k=3, mv={1, 1, 16})
final class TimelinePanel$courseView$2
  extends Lambda
  implements Function0<View>
{
  TimelinePanel$courseView$2(Context paramContext)
  {
    super(0);
  }
  
  @NotNull
  public final View invoke()
  {
    View localView = new View(this.$context);
    localView.setBackgroundColor(-1);
    ViewCompat.setElevation(localView, DensityUtils.a.a(3.0F));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel.courseView.2
 * JD-Core Version:    0.7.0.1
 */