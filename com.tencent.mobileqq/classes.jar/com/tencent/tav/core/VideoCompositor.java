package com.tencent.tav.core;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest;
import com.tencent.tav.core.compositing.IVideoCompositionInstruction;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.compositing.VideoCompositionRenderContext;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction.CropRectangleRamp;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction.OpacityRamp;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction.TransformRamp;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.coremedia.Transform;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.RenderContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class VideoCompositor
  implements VideoCompositing
{
  private MultiTextureFilter filter;
  
  private boolean checkRequest(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest)
  {
    return (paramAsynchronousVideoCompositionRequest.getRenderContext() != null) && (paramAsynchronousVideoCompositionRequest.getSourceTrackIDs() != null) && (!paramAsynchronousVideoCompositionRequest.getSourceTrackIDs().isEmpty());
  }
  
  private void drawInstructionBuffer(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest, IVideoCompositionInstruction paramIVideoCompositionInstruction)
  {
    this.filter.clearBufferBuffer(paramIVideoCompositionInstruction.getBackgroundColor());
    Iterator localIterator = paramIVideoCompositionInstruction.getLayerInstructions().iterator();
    while (localIterator.hasNext())
    {
      VideoCompositionLayerInstruction localVideoCompositionLayerInstruction = (VideoCompositionLayerInstruction)localIterator.next();
      CMSampleBuffer localCMSampleBuffer = paramAsynchronousVideoCompositionRequest.sourceFrameByTrackID(localVideoCompositionLayerInstruction.getTrackID());
      if ((localCMSampleBuffer != null) && (localCMSampleBuffer.getTextureInfo() != null))
      {
        CMTime localCMTime = paramAsynchronousVideoCompositionRequest.getCompositionTime();
        paramIVideoCompositionInstruction = getTransformForTime(localCMTime, localVideoCompositionLayerInstruction.getTransformRampForTime(localCMTime));
        if (paramIVideoCompositionInstruction == null) {
          paramIVideoCompositionInstruction = null;
        } else {
          paramIVideoCompositionInstruction = paramIVideoCompositionInstruction.toMatrix();
        }
        CGRect localCGRect = getCropRectangleForTime(localCMTime, localVideoCompositionLayerInstruction.getCropRectangleRampForTime(localCMTime));
        float f = getOpacityForTime(localCMTime, localVideoCompositionLayerInstruction.getOpacityRampForTime(localCMTime));
        this.filter.applyFilter(localCMSampleBuffer.getTextureInfo(), paramIVideoCompositionInstruction, null, f, localCGRect);
      }
    }
  }
  
  private void drawSrcBuffer(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest)
  {
    this.filter.clearBufferBuffer(-16777216);
    Iterator localIterator = paramAsynchronousVideoCompositionRequest.getSourceTrackIDs().iterator();
    while (localIterator.hasNext())
    {
      CMSampleBuffer localCMSampleBuffer = paramAsynchronousVideoCompositionRequest.sourceFrameByTrackID(((Integer)localIterator.next()).intValue());
      if ((localCMSampleBuffer != null) && (localCMSampleBuffer.getTextureInfo() != null))
      {
        TextureInfo localTextureInfo = localCMSampleBuffer.getTextureInfo();
        Matrix localMatrix = new Matrix();
        DecoderUtils.getRotationMatrix(localMatrix, localTextureInfo.preferRotation, localTextureInfo.width, localTextureInfo.height);
        this.filter.applyFilter(localCMSampleBuffer.getTextureInfo(), localMatrix, localTextureInfo.getTextureMatrix(), 1.0F, null);
      }
    }
  }
  
  @Nullable
  private static CGRect getCropRectangleForTime(CMTime paramCMTime, VideoCompositionLayerInstruction.CropRectangleRamp paramCropRectangleRamp)
  {
    if ((paramCropRectangleRamp.startCropRectangle != null) && (paramCropRectangleRamp.endCropRectangle != null) && (paramCropRectangleRamp.timeRange.containsTime(paramCMTime)))
    {
      long l = paramCropRectangleRamp.timeRange.getDurationUs();
      float f = (float)(paramCMTime.getTimeUs() - paramCropRectangleRamp.timeRange.getStartUs()) * 1.0F / (float)l;
      return new CGRect(interpolation(f, paramCropRectangleRamp.startCropRectangle.origin.x, paramCropRectangleRamp.endCropRectangle.origin.x), interpolation(f, paramCropRectangleRamp.startCropRectangle.origin.y, paramCropRectangleRamp.endCropRectangle.origin.y), interpolation(f, paramCropRectangleRamp.startCropRectangle.size.width, paramCropRectangleRamp.endCropRectangle.size.width), interpolation(f, paramCropRectangleRamp.startCropRectangle.size.height, paramCropRectangleRamp.endCropRectangle.size.height));
    }
    return null;
  }
  
  private static float getOpacityForTime(CMTime paramCMTime, VideoCompositionLayerInstruction.OpacityRamp paramOpacityRamp)
  {
    if (!paramOpacityRamp.timeRange.containsTime(paramCMTime)) {
      return 1.0F;
    }
    long l = paramOpacityRamp.timeRange.getDurationUs();
    return interpolation((float)(paramCMTime.getTimeUs() - paramOpacityRamp.timeRange.getStartUs()) * 1.0F / (float)l, paramOpacityRamp.startOpacity, paramOpacityRamp.endOpacity);
  }
  
  @Nullable
  private static Transform getTransformForTime(CMTime paramCMTime, VideoCompositionLayerInstruction.TransformRamp paramTransformRamp)
  {
    if ((paramTransformRamp.timeRange.containsTime(paramCMTime)) && (paramTransformRamp.startTransform != null) && (paramTransformRamp.endTransform != null))
    {
      long l = paramTransformRamp.timeRange.getDurationUs();
      float f = (float)(paramCMTime.getTimeUs() - paramTransformRamp.timeRange.getStartUs()) * 1.0F / (float)l;
      return new Transform(interpolation(f, paramTransformRamp.startTransform.scaleX, paramTransformRamp.endTransform.scaleX), interpolation(f, paramTransformRamp.startTransform.scaleY, paramTransformRamp.endTransform.scaleY), interpolation(f, paramTransformRamp.startTransform.translateX, paramTransformRamp.endTransform.translateX), interpolation(f, paramTransformRamp.startTransform.translateY, paramTransformRamp.endTransform.translateY), interpolation(f, paramTransformRamp.startTransform.degrees, paramTransformRamp.endTransform.degrees));
    }
    return null;
  }
  
  private void initFilter(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest)
  {
    if (this.filter == null)
    {
      paramAsynchronousVideoCompositionRequest = paramAsynchronousVideoCompositionRequest.getRenderContext().getSize();
      int i = (int)paramAsynchronousVideoCompositionRequest.width;
      int j = (int)paramAsynchronousVideoCompositionRequest.height;
      this.filter = new MultiTextureFilter();
      this.filter.setRendererWidth(i);
      this.filter.setRendererHeight(j);
      this.filter.setRenderForScreen(false);
    }
  }
  
  private static float interpolation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat2 == paramFloat3) {
      return paramFloat2;
    }
    return (paramFloat3 - paramFloat2) * paramFloat1 + paramFloat2;
  }
  
  public void cancelAllPendingVideoCompositionRequests() {}
  
  public CMSampleBuffer finishComposedVideoFrame(RenderContext paramRenderContext, CMSampleBuffer paramCMSampleBuffer)
  {
    return paramCMSampleBuffer;
  }
  
  public void release()
  {
    MultiTextureFilter localMultiTextureFilter = this.filter;
    if (localMultiTextureFilter != null)
    {
      localMultiTextureFilter.release();
      this.filter = null;
    }
  }
  
  public void renderContextChanged(VideoCompositionRenderContext paramVideoCompositionRenderContext) {}
  
  public HashMap<String, Object> requiredPixelBufferAttributesForRenderContext()
  {
    return null;
  }
  
  public HashMap<String, Object> sourcePixelBufferAttributes()
  {
    return null;
  }
  
  public void startVideoCompositionRequest(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest)
  {
    if (!checkRequest(paramAsynchronousVideoCompositionRequest)) {
      return;
    }
    initFilter(paramAsynchronousVideoCompositionRequest);
    Object localObject = paramAsynchronousVideoCompositionRequest.getRenderContext().newTextureInfo();
    localObject = new CMSampleBuffer(paramAsynchronousVideoCompositionRequest.getCompositionTime(), (TextureInfo)localObject, false);
    if (((CMSampleBuffer)localObject).getTextureInfo() == null) {
      return;
    }
    this.filter.setDesTextureInfo(((CMSampleBuffer)localObject).getTextureInfo());
    IVideoCompositionInstruction localIVideoCompositionInstruction = paramAsynchronousVideoCompositionRequest.getVideoCompositionInstruction();
    if ((localIVideoCompositionInstruction != null) && (localIVideoCompositionInstruction.getLayerInstructions() != null) && (localIVideoCompositionInstruction.getLayerInstructions().size() != 0)) {
      drawInstructionBuffer(paramAsynchronousVideoCompositionRequest, localIVideoCompositionInstruction);
    } else {
      drawSrcBuffer(paramAsynchronousVideoCompositionRequest);
    }
    paramAsynchronousVideoCompositionRequest.finishWithComposedVideoFrame(finishComposedVideoFrame(paramAsynchronousVideoCompositionRequest.getRenderContext().getRenderContext(), (CMSampleBuffer)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.VideoCompositor
 * JD-Core Version:    0.7.0.1
 */