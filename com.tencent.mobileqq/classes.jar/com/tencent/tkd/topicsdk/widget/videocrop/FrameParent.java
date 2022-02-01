package com.tencent.tkd.topicsdk.widget.videocrop;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameParent;", "", "getContext", "Landroid/content/Context;", "invalidate", "", "postInvalidate", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface FrameParent
{
  @NotNull
  public abstract Context getContext();
  
  public abstract void invalidate();
  
  public abstract void postInvalidate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.FrameParent
 * JD-Core Version:    0.7.0.1
 */