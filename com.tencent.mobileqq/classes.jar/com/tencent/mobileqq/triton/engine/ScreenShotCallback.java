package com.tencent.mobileqq.triton.engine;

import androidx.annotation.MainThread;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/engine/ScreenShotCallback;", "", "onGetScreenShot", "", "result", "Lkotlin/Result;", "Landroid/graphics/Bitmap;", "(Ljava/lang/Object;)V", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface ScreenShotCallback
{
  @MainThread
  public abstract void onGetScreenShot(@NotNull Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.ScreenShotCallback
 * JD-Core Version:    0.7.0.1
 */