package com.tencent.xaction.api.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/data/Border;", "", "orientation", "", "st", "", "w", "", "c", "(ILjava/lang/String;FI)V", "getC", "()I", "setC", "(I)V", "getOrientation", "setOrientation", "getSt", "()Ljava/lang/String;", "setSt", "(Ljava/lang/String;)V", "getW", "()F", "setW", "(F)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Border
{
  private int c;
  private int orientation;
  @NotNull
  private String st;
  private float w;
  
  public Border(int paramInt1, @NotNull String paramString, float paramFloat, int paramInt2)
  {
    this.orientation = paramInt1;
    this.st = paramString;
    this.w = paramFloat;
    this.c = paramInt2;
  }
  
  public final int component1()
  {
    return this.orientation;
  }
  
  @NotNull
  public final String component2()
  {
    return this.st;
  }
  
  public final float component3()
  {
    return this.w;
  }
  
  public final int component4()
  {
    return this.c;
  }
  
  @NotNull
  public final Border copy(int paramInt1, @NotNull String paramString, float paramFloat, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "st");
    return new Border(paramInt1, paramString, paramFloat, paramInt2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Border))
      {
        paramObject = (Border)paramObject;
        if ((this.orientation == paramObject.orientation) && (Intrinsics.areEqual(this.st, paramObject.st)) && (Float.compare(this.w, paramObject.w) == 0) && (this.c == paramObject.c)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getC()
  {
    return this.c;
  }
  
  public final int getOrientation()
  {
    return this.orientation;
  }
  
  @NotNull
  public final String getSt()
  {
    return this.st;
  }
  
  public final float getW()
  {
    return this.w;
  }
  
  public int hashCode()
  {
    int j = this.orientation;
    String str = this.st;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return ((j * 31 + i) * 31 + Float.floatToIntBits(this.w)) * 31 + this.c;
  }
  
  public final void setC(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void setOrientation(int paramInt)
  {
    this.orientation = paramInt;
  }
  
  public final void setSt(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.st = paramString;
  }
  
  public final void setW(float paramFloat)
  {
    this.w = paramFloat;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Border(orientation=");
    localStringBuilder.append(this.orientation);
    localStringBuilder.append(", st=");
    localStringBuilder.append(this.st);
    localStringBuilder.append(", w=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", c=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.data.Border
 * JD-Core Version:    0.7.0.1
 */