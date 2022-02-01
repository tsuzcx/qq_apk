package com.tencent.weishi.module.publisher.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration.VolumeEdge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weishi/module/publisher/data/VolumeAutomaticEffect;", "Landroid/os/Parcelable;", "startOffset", "", "endOffset", "duration", "volumeRange", "Lcom/tencent/weishi/module/publisher/data/VolumeRange;", "(JJJLcom/tencent/weishi/module/publisher/data/VolumeRange;)V", "getDuration", "()J", "getEndOffset", "getStartOffset", "getVolumeRange", "()Lcom/tencent/weishi/module/publisher/data/VolumeRange;", "component1", "component2", "component3", "component4", "convertToAudioVolumeEdge", "Lcom/tencent/tavkit/composition/model/TAVAudioConfiguration$VolumeEdge;", "allDuration", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "libtavcut_debug"}, k=1, mv={1, 1, 16})
@Parcelize
public final class VolumeAutomaticEffect
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new VolumeAutomaticEffect.Creator();
  public static final VolumeAutomaticEffect.Companion Companion = new VolumeAutomaticEffect.Companion(null);
  @NotNull
  public static final String TAG = "VolumeAutomaticEffect";
  private final long duration;
  private final long endOffset;
  private final long startOffset;
  @NotNull
  private final VolumeRange volumeRange;
  
  public VolumeAutomaticEffect(long paramLong1, long paramLong2, long paramLong3, @NotNull VolumeRange paramVolumeRange)
  {
    this.startOffset = paramLong1;
    this.endOffset = paramLong2;
    this.duration = paramLong3;
    this.volumeRange = paramVolumeRange;
  }
  
  public final long component1()
  {
    return this.startOffset;
  }
  
  public final long component2()
  {
    return this.endOffset;
  }
  
  public final long component3()
  {
    return this.duration;
  }
  
  @NotNull
  public final VolumeRange component4()
  {
    return this.volumeRange;
  }
  
  @Nullable
  public final TAVAudioConfiguration.VolumeEdge convertToAudioVolumeEdge(long paramLong)
  {
    TAVAudioConfiguration.VolumeEdge localVolumeEdge = null;
    long l = this.duration;
    if ((this.startOffset > -1L) && (this.endOffset == -1L)) {
      paramLong = this.startOffset;
    }
    for (;;)
    {
      if (l > 0L) {
        localVolumeEdge = new TAVAudioConfiguration.VolumeEdge(new CMTimeRange(CMTime.fromMs(paramLong), CMTime.fromMs(l)), this.volumeRange.getStart(), this.volumeRange.getEnd());
      }
      return localVolumeEdge;
      if ((this.startOffset == -1L) && (this.endOffset > -1L))
      {
        paramLong -= l;
      }
      else
      {
        if ((this.startOffset <= -1L) || (this.endOffset <= -1L)) {
          break;
        }
        l = paramLong - this.startOffset - this.endOffset;
        paramLong = this.startOffset;
      }
    }
    Logger.e("VolumeAutomaticEffect", "effect's startOffset and endOffset is wrong.");
    return null;
  }
  
  @NotNull
  public final VolumeAutomaticEffect copy(long paramLong1, long paramLong2, long paramLong3, @NotNull VolumeRange paramVolumeRange)
  {
    Intrinsics.checkParameterIsNotNull(paramVolumeRange, "volumeRange");
    return new VolumeAutomaticEffect(paramLong1, paramLong2, paramLong3, paramVolumeRange);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof VolumeAutomaticEffect))
      {
        paramObject = (VolumeAutomaticEffect)paramObject;
        if ((this.startOffset != paramObject.startOffset) || (this.endOffset != paramObject.endOffset) || (this.duration != paramObject.duration) || (!Intrinsics.areEqual(this.volumeRange, paramObject.volumeRange))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public final long getEndOffset()
  {
    return this.endOffset;
  }
  
  public final long getStartOffset()
  {
    return this.startOffset;
  }
  
  @NotNull
  public final VolumeRange getVolumeRange()
  {
    return this.volumeRange;
  }
  
  public int hashCode()
  {
    long l = this.startOffset;
    int j = (int)(l ^ l >>> 32);
    l = this.endOffset;
    int k = (int)(l ^ l >>> 32);
    l = this.duration;
    int m = (int)(l ^ l >>> 32);
    VolumeRange localVolumeRange = this.volumeRange;
    if (localVolumeRange != null) {}
    for (int i = localVolumeRange.hashCode();; i = 0) {
      return i + ((j * 31 + k) * 31 + m) * 31;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "VolumeAutomaticEffect(startOffset=" + this.startOffset + ", endOffset=" + this.endOffset + ", duration=" + this.duration + ", volumeRange=" + this.volumeRange + ")";
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeLong(this.startOffset);
    paramParcel.writeLong(this.endOffset);
    paramParcel.writeLong(this.duration);
    this.volumeRange.writeToParcel(paramParcel, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weishi.module.publisher.data.VolumeAutomaticEffect
 * JD-Core Version:    0.7.0.1
 */