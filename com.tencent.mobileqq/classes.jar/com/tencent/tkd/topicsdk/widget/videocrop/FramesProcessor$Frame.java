package com.tencent.tkd.topicsdk.widget.videocrop;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$Frame;", "", "()V", "frameBitmap", "Landroid/graphics/Bitmap;", "getFrameBitmap", "()Landroid/graphics/Bitmap;", "setFrameBitmap", "(Landroid/graphics/Bitmap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class FramesProcessor$Frame
{
  @Nullable
  private Bitmap a;
  private int b;
  
  @Nullable
  public final Bitmap a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a(@Nullable Bitmap paramBitmap)
  {
    this.a = paramBitmap;
  }
  
  public final int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.FramesProcessor.Frame
 * JD-Core Version:    0.7.0.1
 */