package com.tencent.qcircle.weseevideo.model.resource;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.qcircle.weseevideo.model.effect.VideoEffectModel;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/model/resource/VideoConfigurationModel;", "Ljava/io/Serializable;", "contentMode", "", "frameOrigin", "Lcom/tencent/qcircle/weseevideo/model/resource/EditorPointF;", "frameWidth", "", "frameHeight", "matrix", "", "effects", "Lcom/tencent/qcircle/weseevideo/model/effect/VideoEffectModel;", "rotate", "(ILcom/tencent/qcircle/weseevideo/model/resource/EditorPointF;FFLjava/util/List;Ljava/util/List;I)V", "getContentMode", "()I", "setContentMode", "(I)V", "getEffects", "()Ljava/util/List;", "setEffects", "(Ljava/util/List;)V", "getFrameHeight", "()F", "setFrameHeight", "(F)V", "getFrameOrigin", "()Lcom/tencent/qcircle/weseevideo/model/resource/EditorPointF;", "setFrameOrigin", "(Lcom/tencent/qcircle/weseevideo/model/resource/EditorPointF;)V", "getFrameWidth", "setFrameWidth", "getMatrix", "setMatrix", "getRotate", "setRotate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "createFrameRect", "Lcom/tencent/tav/coremedia/CGRect;", "deepClone", "equals", "", "other", "", "getMatrixCompat", "Landroid/graphics/Matrix;", "hashCode", "setMatrixCompat", "", "toString", "", "update", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class VideoConfigurationModel
  implements Serializable
{
  private int contentMode;
  @Nullable
  private List<VideoEffectModel> effects;
  private float frameHeight;
  @Nullable
  private EditorPointF frameOrigin;
  private float frameWidth;
  @NotNull
  private List<Float> matrix;
  private int rotate;
  
  public VideoConfigurationModel()
  {
    this(0, null, 0.0F, 0.0F, null, null, 0, 127, null);
  }
  
  public VideoConfigurationModel(int paramInt1, @Nullable EditorPointF paramEditorPointF, float paramFloat1, float paramFloat2, @NotNull List<Float> paramList, @Nullable List<VideoEffectModel> paramList1, int paramInt2)
  {
    this.contentMode = paramInt1;
    this.frameOrigin = paramEditorPointF;
    this.frameWidth = paramFloat1;
    this.frameHeight = paramFloat2;
    this.matrix = paramList;
    this.effects = paramList1;
    this.rotate = paramInt2;
  }
  
  public final int component1()
  {
    return this.contentMode;
  }
  
  @Nullable
  public final EditorPointF component2()
  {
    return this.frameOrigin;
  }
  
  public final float component3()
  {
    return this.frameWidth;
  }
  
  public final float component4()
  {
    return this.frameHeight;
  }
  
  @NotNull
  public final List<Float> component5()
  {
    return this.matrix;
  }
  
  @Nullable
  public final List<VideoEffectModel> component6()
  {
    return this.effects;
  }
  
  public final int component7()
  {
    return this.rotate;
  }
  
  @NotNull
  public final VideoConfigurationModel copy(int paramInt1, @Nullable EditorPointF paramEditorPointF, float paramFloat1, float paramFloat2, @NotNull List<Float> paramList, @Nullable List<VideoEffectModel> paramList1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "matrix");
    return new VideoConfigurationModel(paramInt1, paramEditorPointF, paramFloat1, paramFloat2, paramList, paramList1, paramInt2);
  }
  
  @Nullable
  public final CGRect createFrameRect()
  {
    EditorPointF localEditorPointF = this.frameOrigin;
    if (localEditorPointF != null)
    {
      float f1 = this.frameWidth;
      float f2 = 0;
      if ((f1 > f2) && (this.frameHeight > f2))
      {
        f2 = 0.0F;
        if (localEditorPointF != null) {
          f1 = localEditorPointF.getX();
        } else {
          f1 = 0.0F;
        }
        localEditorPointF = this.frameOrigin;
        if (localEditorPointF != null) {
          f2 = localEditorPointF.getY();
        }
        return new CGRect(new PointF(f1, f2), new CGSize(this.frameWidth, this.frameHeight));
      }
    }
    return null;
  }
  
  @NotNull
  public final VideoConfigurationModel deepClone()
  {
    try
    {
      localObject1 = this.effects;
      if (localObject1 == null) {
        break label138;
      }
      Object localObject3 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject1).add(VideoEffectModel.copy$default((VideoEffectModel)((Iterator)localObject3).next(), 0, null, null, 0.0F, 0.0F, false, 0, null, null, 0, 0L, null, 0, null, null, 0, 0, 0L, 0L, false, false, null, 4194303, null));
      }
      localObject1 = (List)localObject1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        Object localObject1;
        continue;
        label138:
        Object localObject2 = null;
      }
    }
    localObject1 = copy$default(this, 0, null, 0.0F, 0.0F, null, (List)localObject1, 0, 95, null);
    return localObject1;
    return copy$default(this, 0, null, 0.0F, 0.0F, null, null, 0, 127, null);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VideoConfigurationModel))
      {
        paramObject = (VideoConfigurationModel)paramObject;
        if ((this.contentMode == paramObject.contentMode) && (Intrinsics.areEqual(this.frameOrigin, paramObject.frameOrigin)) && (Float.compare(this.frameWidth, paramObject.frameWidth) == 0) && (Float.compare(this.frameHeight, paramObject.frameHeight) == 0) && (Intrinsics.areEqual(this.matrix, paramObject.matrix)) && (Intrinsics.areEqual(this.effects, paramObject.effects)) && (this.rotate == paramObject.rotate)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getContentMode()
  {
    return this.contentMode;
  }
  
  @Nullable
  public final List<VideoEffectModel> getEffects()
  {
    return this.effects;
  }
  
  public final float getFrameHeight()
  {
    return this.frameHeight;
  }
  
  @Nullable
  public final EditorPointF getFrameOrigin()
  {
    return this.frameOrigin;
  }
  
  public final float getFrameWidth()
  {
    return this.frameWidth;
  }
  
  @NotNull
  public final List<Float> getMatrix()
  {
    return this.matrix;
  }
  
  @NotNull
  public final Matrix getMatrixCompat()
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(CollectionsKt.toFloatArray((Collection)this.matrix));
    return localMatrix;
  }
  
  public final int getRotate()
  {
    return this.rotate;
  }
  
  public int hashCode()
  {
    int m = this.contentMode;
    Object localObject = this.frameOrigin;
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    int n = Float.floatToIntBits(this.frameWidth);
    int i1 = Float.floatToIntBits(this.frameHeight);
    localObject = this.matrix;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.effects;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (((((m * 31 + i) * 31 + n) * 31 + i1) * 31 + j) * 31 + k) * 31 + this.rotate;
  }
  
  public final void setContentMode(int paramInt)
  {
    this.contentMode = paramInt;
  }
  
  public final void setEffects(@Nullable List<VideoEffectModel> paramList)
  {
    this.effects = paramList;
  }
  
  public final void setFrameHeight(float paramFloat)
  {
    this.frameHeight = paramFloat;
  }
  
  public final void setFrameOrigin(@Nullable EditorPointF paramEditorPointF)
  {
    this.frameOrigin = paramEditorPointF;
  }
  
  public final void setFrameWidth(float paramFloat)
  {
    this.frameWidth = paramFloat;
  }
  
  public final void setMatrix(@NotNull List<Float> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "<set-?>");
    this.matrix = paramList;
  }
  
  public final void setMatrixCompat(@NotNull Matrix paramMatrix)
  {
    Intrinsics.checkParameterIsNotNull(paramMatrix, "matrix");
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    this.matrix = ArraysKt.toList(arrayOfFloat);
  }
  
  public final void setRotate(int paramInt)
  {
    this.rotate = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoConfigurationModel(contentMode=");
    localStringBuilder.append(this.contentMode);
    localStringBuilder.append(", frameOrigin=");
    localStringBuilder.append(this.frameOrigin);
    localStringBuilder.append(", frameWidth=");
    localStringBuilder.append(this.frameWidth);
    localStringBuilder.append(", frameHeight=");
    localStringBuilder.append(this.frameHeight);
    localStringBuilder.append(", matrix=");
    localStringBuilder.append(this.matrix);
    localStringBuilder.append(", effects=");
    localStringBuilder.append(this.effects);
    localStringBuilder.append(", rotate=");
    localStringBuilder.append(this.rotate);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final VideoConfigurationModel update(int paramInt)
  {
    return copy$default(this, 0, null, 0.0F, 0.0F, null, null, paramInt, 63, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.resource.VideoConfigurationModel
 * JD-Core Version:    0.7.0.1
 */