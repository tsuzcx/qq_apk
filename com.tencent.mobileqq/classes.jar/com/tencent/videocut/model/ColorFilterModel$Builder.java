package com.tencent.videocut.model;

import com.squareup.wire.Message.Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/ColorFilterModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/ColorFilterModel;", "()V", "brightness", "", "Ljava/lang/Integer;", "contrast", "highlights", "hue", "saturation", "shadows", "sharpness", "temperature", "(Ljava/lang/Integer;)Lcom/tencent/videocut/model/ColorFilterModel$Builder;", "build", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ColorFilterModel$Builder
  extends Message.Builder<ColorFilterModel, Builder>
{
  @JvmField
  @Nullable
  public Integer a;
  @JvmField
  @Nullable
  public Integer b;
  @JvmField
  @Nullable
  public Integer c;
  @JvmField
  @Nullable
  public Integer d;
  @JvmField
  @Nullable
  public Integer e;
  @JvmField
  @Nullable
  public Integer f;
  @JvmField
  @Nullable
  public Integer g;
  @JvmField
  @Nullable
  public Integer h;
  
  @NotNull
  public ColorFilterModel a()
  {
    Integer localInteger = this.a;
    int i;
    if (localInteger != null) {
      i = localInteger.intValue();
    } else {
      i = 0;
    }
    localInteger = this.b;
    int j;
    if (localInteger != null) {
      j = localInteger.intValue();
    } else {
      j = 0;
    }
    localInteger = this.c;
    int k;
    if (localInteger != null) {
      k = localInteger.intValue();
    } else {
      k = 0;
    }
    localInteger = this.d;
    int m;
    if (localInteger != null) {
      m = localInteger.intValue();
    } else {
      m = 0;
    }
    localInteger = this.e;
    int n;
    if (localInteger != null) {
      n = localInteger.intValue();
    } else {
      n = 0;
    }
    localInteger = this.f;
    int i1;
    if (localInteger != null) {
      i1 = localInteger.intValue();
    } else {
      i1 = 0;
    }
    localInteger = this.g;
    int i2;
    if (localInteger != null) {
      i2 = localInteger.intValue();
    } else {
      i2 = 0;
    }
    localInteger = this.h;
    int i3;
    if (localInteger != null) {
      i3 = localInteger.intValue();
    } else {
      i3 = 0;
    }
    return new ColorFilterModel(i, j, k, m, n, i1, i2, i3, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.ColorFilterModel.Builder
 * JD-Core Version:    0.7.0.1
 */