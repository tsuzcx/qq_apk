package com.tencent.tavcut.render.thumb;

import android.graphics.Bitmap;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/thumb/IThumbProvider;", "", "getThumbAtTime", "Landroid/graphics/Bitmap;", "atTimeUs", "", "getThumbAtTimeAsync", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bitmap", "actualTime", "getThumbAtTimesAsync", "", "release", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface IThumbProvider
{
  @WorkerThread
  @Nullable
  public abstract Bitmap a(long paramLong);
  
  public abstract void a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.thumb.IThumbProvider
 * JD-Core Version:    0.7.0.1
 */