package com.tencent.tavkit.composition.video;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction.CropRectangleRamp;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction.OpacityRamp;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction.TransformRamp;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import org.jetbrains.annotations.NotNull;

public class TAVVideoCompositionLayerInstruction
  implements VideoCompositionLayerInstruction
{
  private final TAVVideoCompositionTrack imageSource;
  private Matrix preferredTransform;
  private CMTimeRange timeRange;
  private int trackID;
  private TAVVideoTransition transition;
  private final TAVVideoConfiguration videoConfiguration;
  
  public TAVVideoCompositionLayerInstruction(int paramInt, TAVTransitionableVideo paramTAVTransitionableVideo)
  {
    this(paramInt, paramTAVTransitionableVideo.getVideoConfiguration(), paramTAVTransitionableVideo);
    setTimeRange(paramTAVTransitionableVideo.getTimeRange());
    setTransition(paramTAVTransitionableVideo.getVideoTransition());
  }
  
  public TAVVideoCompositionLayerInstruction(int paramInt, @NonNull TAVVideoConfiguration paramTAVVideoConfiguration, @NonNull TAVVideoCompositionTrack paramTAVVideoCompositionTrack)
  {
    this.trackID = paramInt;
    this.videoConfiguration = paramTAVVideoConfiguration;
    this.imageSource = paramTAVVideoCompositionTrack;
    this.preferredTransform = new Matrix();
  }
  
  public Bitmap applySourceImage(Bitmap paramBitmap, CMTime paramCMTime, CGSize paramCGSize)
  {
    return null;
  }
  
  public VideoCompositionLayerInstruction.CropRectangleRamp getCropRectangleRampForTime(CMTime paramCMTime)
  {
    return new VideoCompositionLayerInstruction.CropRectangleRamp(CMTimeRange.fromSeconds(0.0F, 0.0F));
  }
  
  @NonNull
  public TAVVideoCompositionTrack getImageSource()
  {
    return this.imageSource;
  }
  
  public VideoCompositionLayerInstruction.OpacityRamp getOpacityRampForTime(CMTime paramCMTime)
  {
    return new VideoCompositionLayerInstruction.OpacityRamp(CMTimeRange.fromSeconds(0.0F, 0.0F));
  }
  
  public Matrix getPreferredTransform()
  {
    return this.preferredTransform;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public int getTrackID()
  {
    return this.trackID;
  }
  
  public VideoCompositionLayerInstruction.TransformRamp getTransformRampForTime(CMTime paramCMTime)
  {
    return new VideoCompositionLayerInstruction.TransformRamp(CMTimeRange.fromSeconds(0.0F, 0.0F));
  }
  
  public TAVVideoTransition getTransition()
  {
    return this.transition;
  }
  
  @NotNull
  public TAVVideoConfiguration getVideoConfiguration()
  {
    return this.videoConfiguration;
  }
  
  public void setPreferredTransform(Matrix paramMatrix)
  {
    this.preferredTransform = paramMatrix;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
  
  public void setTrackID(int paramInt)
  {
    this.trackID = paramInt;
  }
  
  public void setTransition(TAVVideoTransition paramTAVVideoTransition)
  {
    this.transition = paramTAVVideoTransition;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVVideoCompositionLayerInstruction{trackID=");
    localStringBuilder.append(this.trackID);
    localStringBuilder.append(", timeRange=");
    localStringBuilder.append(this.timeRange.toSimpleString());
    localStringBuilder.append(", preferredTransform=");
    localStringBuilder.append(this.preferredTransform);
    localStringBuilder.append(", transition=");
    localStringBuilder.append(this.transition);
    localStringBuilder.append(", videoConfiguration=");
    localStringBuilder.append(this.videoConfiguration);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoCompositionLayerInstruction
 * JD-Core Version:    0.7.0.1
 */