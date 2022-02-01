package com.tencent.weseevideo.model.extra;

import android.graphics.PointF;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/extra/FaceInfoModel;", "Ljava/io/Serializable;", "mWidth", "", "mHeight", "mFacePoints", "", "Landroid/graphics/PointF;", "mFaceDetectScale", "", "(IILjava/util/List;D)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class FaceInfoModel
  implements Serializable
{
  @JvmField
  public final double mFaceDetectScale;
  @JvmField
  @Nullable
  public final List<List<PointF>> mFacePoints;
  @JvmField
  public final int mHeight;
  @JvmField
  public final int mWidth;
  
  public FaceInfoModel()
  {
    this(0, 0, null, 0.0D, 15, null);
  }
  
  public FaceInfoModel(int paramInt1, int paramInt2, @Nullable List<? extends List<? extends PointF>> paramList, double paramDouble)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mFacePoints = paramList;
    this.mFaceDetectScale = paramDouble;
  }
  
  public final int component1()
  {
    return this.mWidth;
  }
  
  public final int component2()
  {
    return this.mHeight;
  }
  
  @Nullable
  public final List<List<PointF>> component3()
  {
    return this.mFacePoints;
  }
  
  public final double component4()
  {
    return this.mFaceDetectScale;
  }
  
  @NotNull
  public final FaceInfoModel copy(int paramInt1, int paramInt2, @Nullable List<? extends List<? extends PointF>> paramList, double paramDouble)
  {
    return new FaceInfoModel(paramInt1, paramInt2, paramList, paramDouble);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof FaceInfoModel))
      {
        paramObject = (FaceInfoModel)paramObject;
        if ((this.mWidth == paramObject.mWidth) && (this.mHeight == paramObject.mHeight) && (Intrinsics.areEqual(this.mFacePoints, paramObject.mFacePoints)) && (Double.compare(this.mFaceDetectScale, paramObject.mFaceDetectScale) == 0)) {}
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
    int j = this.mWidth;
    int k = this.mHeight;
    List localList = this.mFacePoints;
    int i;
    if (localList != null) {
      i = localList.hashCode();
    } else {
      i = 0;
    }
    long l = Double.doubleToLongBits(this.mFaceDetectScale);
    return ((j * 31 + k) * 31 + i) * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FaceInfoModel(mWidth=");
    localStringBuilder.append(this.mWidth);
    localStringBuilder.append(", mHeight=");
    localStringBuilder.append(this.mHeight);
    localStringBuilder.append(", mFacePoints=");
    localStringBuilder.append(this.mFacePoints);
    localStringBuilder.append(", mFaceDetectScale=");
    localStringBuilder.append(this.mFaceDetectScale);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.extra.FaceInfoModel
 * JD-Core Version:    0.7.0.1
 */