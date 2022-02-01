package com.tencent.mobileqq.kandian.base.image.api;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/image/api/ICloseableBitmap;", "", "clone", "close", "", "get", "Landroid/graphics/Bitmap;", "isValid", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ICloseableBitmap
{
  public abstract void a();
  
  @Nullable
  public abstract Bitmap b();
  
  @Nullable
  public abstract ICloseableBitmap c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap
 * JD-Core Version:    0.7.0.1
 */