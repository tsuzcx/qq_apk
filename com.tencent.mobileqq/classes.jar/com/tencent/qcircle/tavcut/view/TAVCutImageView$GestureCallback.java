package com.tencent.qcircle.tavcut.view;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/tavcut/view/TAVCutImageView$GestureCallback;", "", "getPoints", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getRotate", "", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public abstract interface TAVCutImageView$GestureCallback
{
  @Nullable
  public abstract ArrayList<float[]> getPoints();
  
  public abstract float getRotate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.view.TAVCutImageView.GestureCallback
 * JD-Core Version:    0.7.0.1
 */