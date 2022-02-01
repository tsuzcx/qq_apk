package com.tencent.weseevideo.model.extra;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/extra/FrameInfoModel;", "Ljava/io/Serializable;", "mWidth", "", "mHeight", "left", "top", "right", "bottom", "(IIIIII)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class FrameInfoModel
  implements Serializable
{
  @JvmField
  public final int bottom;
  @JvmField
  public final int left;
  @JvmField
  public final int mHeight;
  @JvmField
  public final int mWidth;
  @JvmField
  public final int right;
  @JvmField
  public final int top;
  
  public FrameInfoModel()
  {
    this(0, 0, 0, 0, 0, 0, 63, null);
  }
  
  public FrameInfoModel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.left = paramInt3;
    this.top = paramInt4;
    this.right = paramInt5;
    this.bottom = paramInt6;
  }
  
  public final int component1()
  {
    return this.mWidth;
  }
  
  public final int component2()
  {
    return this.mHeight;
  }
  
  public final int component3()
  {
    return this.left;
  }
  
  public final int component4()
  {
    return this.top;
  }
  
  public final int component5()
  {
    return this.right;
  }
  
  public final int component6()
  {
    return this.bottom;
  }
  
  @NotNull
  public final FrameInfoModel copy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return new FrameInfoModel(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof FrameInfoModel))
      {
        paramObject = (FrameInfoModel)paramObject;
        if ((this.mWidth == paramObject.mWidth) && (this.mHeight == paramObject.mHeight) && (this.left == paramObject.left) && (this.top == paramObject.top) && (this.right == paramObject.right) && (this.bottom == paramObject.bottom)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    return ((((this.mWidth * 31 + this.mHeight) * 31 + this.left) * 31 + this.top) * 31 + this.right) * 31 + this.bottom;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FrameInfoModel(mWidth=");
    localStringBuilder.append(this.mWidth);
    localStringBuilder.append(", mHeight=");
    localStringBuilder.append(this.mHeight);
    localStringBuilder.append(", left=");
    localStringBuilder.append(this.left);
    localStringBuilder.append(", top=");
    localStringBuilder.append(this.top);
    localStringBuilder.append(", right=");
    localStringBuilder.append(this.right);
    localStringBuilder.append(", bottom=");
    localStringBuilder.append(this.bottom);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.extra.FrameInfoModel
 * JD-Core Version:    0.7.0.1
 */