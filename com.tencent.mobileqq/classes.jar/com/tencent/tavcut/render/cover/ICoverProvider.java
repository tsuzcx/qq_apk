package com.tencent.tavcut.render.cover;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/cover/ICoverProvider;", "", "getCoverAtTime", "Landroid/graphics/Bitmap;", "atTimeMs", "", "getCoverAtTimeAsync", "", "callback", "Lkotlin/Function1;", "getCoverAtTimesAsync", "", "release", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface ICoverProvider
{
  @Nullable
  public abstract Bitmap a(long paramLong);
  
  public abstract void a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.cover.ICoverProvider
 * JD-Core Version:    0.7.0.1
 */