package com.tencent.xaction.api.style;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/style/AnimStyle;", "", "scaleX", "", "scaleY", "translationX", "translationY", "rotateX", "rotateY", "opacity", "bgColor", "", "(FFFFFFFLjava/lang/String;)V", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "getOpacity", "()F", "setOpacity", "(F)V", "getRotateX", "setRotateX", "getRotateY", "setRotateY", "getScaleX", "setScaleX", "getScaleY", "setScaleY", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public final class AnimStyle
{
  @Nullable
  private String bgColor;
  private float opacity;
  private float rotateX;
  private float rotateY;
  private float scaleX;
  private float scaleY;
  private float translationX;
  private float translationY;
  
  public AnimStyle()
  {
    this(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, null, 255, null);
  }
  
  public AnimStyle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, @Nullable String paramString)
  {
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
    this.translationX = paramFloat3;
    this.translationY = paramFloat4;
    this.rotateX = paramFloat5;
    this.rotateY = paramFloat6;
    this.opacity = paramFloat7;
    this.bgColor = paramString;
  }
  
  public final float component1()
  {
    return this.scaleX;
  }
  
  public final float component2()
  {
    return this.scaleY;
  }
  
  public final float component3()
  {
    return this.translationX;
  }
  
  public final float component4()
  {
    return this.translationY;
  }
  
  public final float component5()
  {
    return this.rotateX;
  }
  
  public final float component6()
  {
    return this.rotateY;
  }
  
  public final float component7()
  {
    return this.opacity;
  }
  
  @Nullable
  public final String component8()
  {
    return this.bgColor;
  }
  
  @NotNull
  public final AnimStyle copy(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, @Nullable String paramString)
  {
    return new AnimStyle(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof AnimStyle))
      {
        paramObject = (AnimStyle)paramObject;
        if ((Float.compare(this.scaleX, paramObject.scaleX) != 0) || (Float.compare(this.scaleY, paramObject.scaleY) != 0) || (Float.compare(this.translationX, paramObject.translationX) != 0) || (Float.compare(this.translationY, paramObject.translationY) != 0) || (Float.compare(this.rotateX, paramObject.rotateX) != 0) || (Float.compare(this.rotateY, paramObject.rotateY) != 0) || (Float.compare(this.opacity, paramObject.opacity) != 0) || (!Intrinsics.areEqual(this.bgColor, paramObject.bgColor))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @Nullable
  public final String getBgColor()
  {
    return this.bgColor;
  }
  
  public final float getOpacity()
  {
    return this.opacity;
  }
  
  public final float getRotateX()
  {
    return this.rotateX;
  }
  
  public final float getRotateY()
  {
    return this.rotateY;
  }
  
  public final float getScaleX()
  {
    return this.scaleX;
  }
  
  public final float getScaleY()
  {
    return this.scaleY;
  }
  
  public final float getTranslationX()
  {
    return this.translationX;
  }
  
  public final float getTranslationY()
  {
    return this.translationY;
  }
  
  public int hashCode()
  {
    int j = Float.floatToIntBits(this.scaleX);
    int k = Float.floatToIntBits(this.scaleY);
    int m = Float.floatToIntBits(this.translationX);
    int n = Float.floatToIntBits(this.translationY);
    int i1 = Float.floatToIntBits(this.rotateX);
    int i2 = Float.floatToIntBits(this.rotateY);
    int i3 = Float.floatToIntBits(this.opacity);
    String str = this.bgColor;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0) {
      return i + ((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31;
    }
  }
  
  public final void setBgColor(@Nullable String paramString)
  {
    this.bgColor = paramString;
  }
  
  public final void setOpacity(float paramFloat)
  {
    this.opacity = paramFloat;
  }
  
  public final void setRotateX(float paramFloat)
  {
    this.rotateX = paramFloat;
  }
  
  public final void setRotateY(float paramFloat)
  {
    this.rotateY = paramFloat;
  }
  
  public final void setScaleX(float paramFloat)
  {
    this.scaleX = paramFloat;
  }
  
  public final void setScaleY(float paramFloat)
  {
    this.scaleY = paramFloat;
  }
  
  public final void setTranslationX(float paramFloat)
  {
    this.translationX = paramFloat;
  }
  
  public final void setTranslationY(float paramFloat)
  {
    this.translationY = paramFloat;
  }
  
  @NotNull
  public String toString()
  {
    return "AnimStyle(scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", translationX=" + this.translationX + ", translationY=" + this.translationY + ", rotateX=" + this.rotateX + ", rotateY=" + this.rotateY + ", opacity=" + this.opacity + ", bgColor=" + this.bgColor + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.style.AnimStyle
 * JD-Core Version:    0.7.0.1
 */