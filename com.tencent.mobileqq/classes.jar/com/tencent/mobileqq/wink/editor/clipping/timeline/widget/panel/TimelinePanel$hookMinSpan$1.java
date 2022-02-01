package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel;

import android.view.ScaleGestureDetector;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/reflect/Field;", "invoke"}, k=3, mv={1, 1, 16})
final class TimelinePanel$hookMinSpan$1
  extends Lambda
  implements Function1<Field, Unit>
{
  TimelinePanel$hookMinSpan$1(ScaleGestureDetector paramScaleGestureDetector)
  {
    super(1);
  }
  
  public final void invoke(@NotNull Field paramField)
  {
    Intrinsics.checkParameterIsNotNull(paramField, "it");
    paramField.set(this.$detector, Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel.hookMinSpan.1
 * JD-Core Version:    0.7.0.1
 */