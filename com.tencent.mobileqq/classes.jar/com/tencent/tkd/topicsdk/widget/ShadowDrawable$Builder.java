package com.tencent.tkd.topicsdk.widget;

import android.graphics.Color;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/ShadowDrawable$Builder;", "", "()V", "mBgColor", "", "mOffsetX", "", "mOffsetY", "mShadowColor", "mShadowRadius", "mShape", "mShapeRadius", "builder", "Lcom/tencent/tkd/topicsdk/widget/ShadowDrawable;", "setBgColor", "BgColor", "setOffsetX", "OffsetX", "setOffsetY", "OffsetY", "setShadowColor", "shadowColor", "setShadowRadius", "shadowRadius", "setShape", "setShapeRadius", "ShapeRadius", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class ShadowDrawable$Builder
{
  private int jdField_a_of_type_Int = 1;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private int b = 12;
  private int c = Color.parseColor("#4d000000");
  private int d = 18;
  private int e = 0;
  private int f = 0;
  
  public ShadowDrawable$Builder()
  {
    this.jdField_a_of_type_ArrayOfInt[0] = 0;
  }
  
  @NotNull
  public final Builder a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  @NotNull
  public final ShadowDrawable a()
  {
    return new ShadowDrawable(this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt, this.b, this.c, this.d, this.e, this.f, null);
  }
  
  @NotNull
  public final Builder b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  @NotNull
  public final Builder c(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  @NotNull
  public final Builder d(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  @NotNull
  public final Builder e(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  @NotNull
  public final Builder f(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfInt[0] = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.ShadowDrawable.Builder
 * JD-Core Version:    0.7.0.1
 */