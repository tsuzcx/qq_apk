package com.tencent.xaction.trigger;

import android.gesture.Prediction;
import android.view.View;
import com.tencent.xaction.trigger.gesture.GestureListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/trigger/GestureTrigger$monitor$1", "Lcom/tencent/xaction/trigger/gesture/GestureListener;", "onFailed", "", "onRecognized", "predictionList", "", "Landroid/gesture/Prediction;", "onStart", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class GestureTrigger$monitor$1
  implements GestureListener
{
  GestureTrigger$monitor$1(View paramView) {}
  
  public void a()
  {
    this.a.updateStatus(this.b, "undefined");
  }
  
  public void a(@NotNull List<? extends Prediction> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "predictionList");
    GestureTrigger.access$recognized(this.a, this.b, paramList);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.GestureTrigger.monitor.1
 * JD-Core Version:    0.7.0.1
 */