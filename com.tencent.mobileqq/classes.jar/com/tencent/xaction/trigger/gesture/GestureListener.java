package com.tencent.xaction.trigger.gesture;

import android.gesture.Prediction;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/gesture/GestureListener;", "", "onFailed", "", "onRecognized", "predictionList", "", "Landroid/gesture/Prediction;", "onStart", "XActionCore_release"}, k=1, mv={1, 1, 16})
public abstract interface GestureListener
{
  public abstract void a();
  
  public abstract void a(@NotNull List<? extends Prediction> paramList);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.gesture.GestureListener
 * JD-Core Version:    0.7.0.1
 */