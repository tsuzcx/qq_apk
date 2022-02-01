package com.tencent.weseevideo.camera.mvauto.redo;

import android.graphics.PointF;
import com.tencent.weseevideo.model.effect.VideoEffectModel;
import com.tencent.weseevideo.model.resource.VideoConfigurationModel;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/camera/mvauto/redo/VideoConfigurationModelKt;", "", "contentMode", "", "frameOrigin", "Landroid/graphics/PointF;", "frameWidth", "", "frameHeight", "matrix", "", "effects", "", "Lcom/tencent/weseevideo/model/effect/VideoEffectModel;", "rotate", "(ILandroid/graphics/PointF;FF[FLjava/util/List;I)V", "getContentMode", "()I", "getEffects", "()Ljava/util/List;", "getFrameHeight", "()F", "getFrameOrigin", "()Landroid/graphics/PointF;", "getFrameWidth", "getMatrix", "()[F", "getRotate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "convert", "Lcom/tencent/weseevideo/model/resource/VideoConfigurationModel;", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class VideoConfigurationModelKt
{
  public static final VideoConfigurationModelKt.Companion Companion = new VideoConfigurationModelKt.Companion(null);
  private final int contentMode;
  @Nullable
  private final List<VideoEffectModel> effects;
  private final float frameHeight;
  @Nullable
  private final PointF frameOrigin;
  private final float frameWidth;
  @NotNull
  private final float[] matrix;
  private final int rotate;
  
  public VideoConfigurationModelKt(int paramInt1, @Nullable PointF paramPointF, float paramFloat1, float paramFloat2, @NotNull float[] paramArrayOfFloat, @Nullable List<? extends VideoEffectModel> paramList, int paramInt2)
  {
    this.contentMode = paramInt1;
    this.frameOrigin = paramPointF;
    this.frameWidth = paramFloat1;
    this.frameHeight = paramFloat2;
    this.matrix = paramArrayOfFloat;
    this.effects = paramList;
    this.rotate = paramInt2;
  }
  
  public final int component1()
  {
    return this.contentMode;
  }
  
  @Nullable
  public final PointF component2()
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
  public final float[] component5()
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
  public final VideoConfigurationModel convert()
  {
    VideoConfigurationModel localVideoConfigurationModel = new VideoConfigurationModel();
    localVideoConfigurationModel.setContentMode(this.contentMode);
    localVideoConfigurationModel.setFrameOrigin(this.frameOrigin);
    localVideoConfigurationModel.setFrameWidth(this.frameWidth);
    localVideoConfigurationModel.setFrameHeight(this.frameHeight);
    Object localObject = this.matrix;
    localObject = Arrays.copyOf((float[])localObject, localObject.length);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.copyOf(this, size)");
    localVideoConfigurationModel.setMatrix((float[])localObject);
    localObject = this.effects;
    if (localObject != null) {}
    for (localObject = CollectionsKt.toMutableList((Collection)localObject);; localObject = null)
    {
      localVideoConfigurationModel.setEffects((List)localObject);
      localVideoConfigurationModel.setRotate(this.rotate);
      return localVideoConfigurationModel;
    }
  }
  
  @NotNull
  public final VideoConfigurationModelKt copy(int paramInt1, @Nullable PointF paramPointF, float paramFloat1, float paramFloat2, @NotNull float[] paramArrayOfFloat, @Nullable List<? extends VideoEffectModel> paramList, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "matrix");
    return new VideoConfigurationModelKt(paramInt1, paramPointF, paramFloat1, paramFloat2, paramArrayOfFloat, paramList, paramInt2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof VideoConfigurationModelKt))
      {
        paramObject = (VideoConfigurationModelKt)paramObject;
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
  public final PointF getFrameOrigin()
  {
    return this.frameOrigin;
  }
  
  public final float getFrameWidth()
  {
    return this.frameWidth;
  }
  
  @NotNull
  public final float[] getMatrix()
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
    for (int j = Arrays.hashCode((float[])localObject);; j = 0)
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
  
  @NotNull
  public String toString()
  {
    return "VideoConfigurationModelKt(contentMode=" + this.contentMode + ", frameOrigin=" + this.frameOrigin + ", frameWidth=" + this.frameWidth + ", frameHeight=" + this.frameHeight + ", matrix=" + Arrays.toString(this.matrix) + ", effects=" + this.effects + ", rotate=" + this.rotate + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.camera.mvauto.redo.VideoConfigurationModelKt
 * JD-Core Version:    0.7.0.1
 */