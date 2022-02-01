package com.tencent.qcircle.weseevideo.model.resource;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/model/resource/EditorPointF;", "Ljava/io/Serializable;", "x", "", "y", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class EditorPointF
  implements Serializable
{
  private final float x;
  private final float y;
  
  public EditorPointF()
  {
    this(0.0F, 0.0F, 3, null);
  }
  
  public EditorPointF(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public final float component1()
  {
    return this.x;
  }
  
  public final float component2()
  {
    return this.y;
  }
  
  @NotNull
  public final EditorPointF copy(float paramFloat1, float paramFloat2)
  {
    return new EditorPointF(paramFloat1, paramFloat2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof EditorPointF))
      {
        paramObject = (EditorPointF)paramObject;
        if ((Float.compare(this.x, paramObject.x) == 0) && (Float.compare(this.y, paramObject.y) == 0)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final float getX()
  {
    return this.x;
  }
  
  public final float getY()
  {
    return this.y;
  }
  
  public int hashCode()
  {
    return Float.floatToIntBits(this.x) * 31 + Float.floatToIntBits(this.y);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditorPointF(x=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.resource.EditorPointF
 * JD-Core Version:    0.7.0.1
 */