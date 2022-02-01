package com.tencent.weseevideo.model.resource;

import android.graphics.PointF;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.weseevideo.model.effect.VideoEffectModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/resource/VideoConfigurationModel;", "Ljava/io/Serializable;", "contentMode", "", "frameOrigin", "Lcom/tencent/weseevideo/model/resource/EditorPointF;", "frameWidth", "", "frameHeight", "matrix", "", "effects", "Lcom/tencent/weseevideo/model/effect/VideoEffectModel;", "rotate", "(ILcom/tencent/weseevideo/model/resource/EditorPointF;FFLjava/util/List;Ljava/util/List;I)V", "getContentMode", "()I", "setContentMode", "(I)V", "getEffects", "()Ljava/util/List;", "getFrameHeight", "()F", "getFrameOrigin", "()Lcom/tencent/weseevideo/model/resource/EditorPointF;", "getFrameWidth", "getMatrix", "getRotate", "setRotate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "createFrameRect", "Lcom/tencent/tav/coremedia/CGRect;", "deepClone", "equals", "", "other", "", "hashCode", "toString", "", "update", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class VideoConfigurationModel
  implements Serializable
{
  private int contentMode;
  @Nullable
  private final List<VideoEffectModel> effects;
  private final float frameHeight;
  @Nullable
  private final EditorPointF frameOrigin;
  private final float frameWidth;
  @NotNull
  private final List<Float> matrix;
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
    if ((this.frameOrigin == null) || (this.frameWidth <= 0) || (this.frameHeight <= 0)) {
      return null;
    }
    return new CGRect(new PointF(this.frameOrigin.getX(), this.frameOrigin.getY()), new CGSize(this.frameWidth, this.frameHeight));
  }
  
  @NotNull
  public final VideoConfigurationModel deepClone()
  {
    try
    {
      Object localObject1 = this.effects;
      if (localObject1 != null)
      {
        Object localObject3 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)localObject1).add(VideoEffectModel.copy$default((VideoEffectModel)((Iterator)localObject3).next(), 0, null, null, 0.0F, 0.0F, false, 0, null, null, 0, 0L, null, 0, null, null, 0, 0, 0L, 0L, false, false, null, 4194303, null));
        }
        localObject2 = (List)localCloneNotSupportedException;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      return copy$default(this, 0, null, 0.0F, 0.0F, null, null, 0, 127, null);
    }
    for (;;)
    {
      Object localObject2 = copy$default(this, 0, null, 0.0F, 0.0F, null, (List)localObject2, 0, 95, null);
      return localObject2;
      localObject2 = null;
    }
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof VideoConfigurationModel))
      {
        paramObject = (VideoConfigurationModel)paramObject;
        if ((this.contentMode != paramObject.contentMode) || (!Intrinsics.areEqual(this.frameOrigin, paramObject.frameOrigin)) || (Float.compare(this.frameWidth, paramObject.frameWidth) != 0) || (Float.compare(this.frameHeight, paramObject.frameHeight) != 0) || (!Intrinsics.areEqual(this.matrix, paramObject.matrix)) || (!Intrinsics.areEqual(this.effects, paramObject.effects)) || (this.rotate != paramObject.rotate)) {}
      }
    }
    else {
      return true;
    }
    return false;
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
  
  public final int getRotate()
  {
    return this.rotate;
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = this.contentMode;
    Object localObject = this.frameOrigin;
    int i;
    int n;
    int i1;
    if (localObject != null)
    {
      i = localObject.hashCode();
      n = Float.floatToIntBits(this.frameWidth);
      i1 = Float.floatToIntBits(this.frameHeight);
      localObject = this.matrix;
      if (localObject == null) {
        break label120;
      }
    }
    label120:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.effects;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      return ((j + (((i + m * 31) * 31 + n) * 31 + i1) * 31) * 31 + k) * 31 + this.rotate;
      i = 0;
      break;
    }
  }
  
  public final void setContentMode(int paramInt)
  {
    this.contentMode = paramInt;
  }
  
  public final void setRotate(int paramInt)
  {
    this.rotate = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    return "VideoConfigurationModel(contentMode=" + this.contentMode + ", frameOrigin=" + this.frameOrigin + ", frameWidth=" + this.frameWidth + ", frameHeight=" + this.frameHeight + ", matrix=" + this.matrix + ", effects=" + this.effects + ", rotate=" + this.rotate + ")";
  }
  
  @NotNull
  public final VideoConfigurationModel update(int paramInt)
  {
    return copy$default(this, 0, null, 0.0F, 0.0F, null, null, paramInt, 63, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.resource.VideoConfigurationModel
 * JD-Core Version:    0.7.0.1
 */