package com.tencent.tavcut.creator;

import android.graphics.Matrix;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.ClipSource.ClipType;
import com.tencent.tavcut.rendermodel.transform.MatrixTransform;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/creator/ClipSourceCreator;", "Lcom/tencent/tavcut/creator/IClipSourceCreator;", "()V", "createPhotoClipSource", "Lcom/tencent/tavcut/model/ClipSource;", "path", "", "timeRange", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "createVideoClipSource", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class ClipSourceCreator
  implements IClipSourceCreator
{
  public static final ClipSourceCreator a = new ClipSourceCreator();
  
  @NotNull
  public ClipSource a(@NotNull String paramString, @NotNull TimeRange paramTimeRange)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(paramTimeRange, "timeRange");
    Matrix localMatrix = new Matrix();
    ClipSource.ClipType localClipType = ClipSource.ClipType.VIDEO;
    String str = UUID.randomUUID().toString();
    long l1 = paramTimeRange.startTime;
    long l2 = paramTimeRange.duration;
    paramTimeRange = Float.valueOf(1.0F);
    return new ClipSource(str, paramString, localClipType, l2, paramTimeRange, paramTimeRange, Long.valueOf(l1), MatrixTransform.transMatrixToListMatrix(localMatrix), null, null, null, null, 3840, null);
  }
  
  @NotNull
  public ClipSource b(@NotNull String paramString, @NotNull TimeRange paramTimeRange)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(paramTimeRange, "timeRange");
    Matrix localMatrix = new Matrix();
    ClipSource.ClipType localClipType = ClipSource.ClipType.PHOTO;
    String str = UUID.randomUUID().toString();
    long l = paramTimeRange.startTime;
    return new ClipSource(str, paramString, localClipType, paramTimeRange.duration, null, null, Long.valueOf(l), MatrixTransform.transMatrixToListMatrix(localMatrix), null, null, null, null, 3888, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.creator.ClipSourceCreator
 * JD-Core Version:    0.7.0.1
 */