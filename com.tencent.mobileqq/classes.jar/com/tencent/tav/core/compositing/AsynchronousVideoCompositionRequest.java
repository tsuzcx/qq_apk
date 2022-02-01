package com.tencent.tav.core.compositing;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.ErrorMsg;
import java.util.ArrayList;
import java.util.List;

public class AsynchronousVideoCompositionRequest
{
  private final AssetExtension assetExtension;
  private final Object authorComposition;
  private volatile CMSampleBuffer composedVideoFrame = null;
  private CMTime compositionTime;
  private volatile ErrorMsg error;
  private VideoCompositionRenderContext renderContext;
  private SparseArray<CMSampleBuffer> sampleBuffers = new SparseArray();
  private List<Integer> sourceTrackIDs = new ArrayList();
  @AsynchronousVideoCompositionRequest.RequestStatus
  private volatile int status = -2147483648;
  private IVideoCompositionInstruction videoCompositionInstruction;
  
  public AsynchronousVideoCompositionRequest(@Nullable Object paramObject, @NonNull AssetExtension paramAssetExtension)
  {
    this.authorComposition = paramObject;
    this.assetExtension = paramAssetExtension;
  }
  
  private void notifyFinish()
  {
    Object localObject1 = this.authorComposition;
    if (localObject1 != null) {
      try
      {
        this.authorComposition.notifyAll();
        return;
      }
      finally {}
    }
  }
  
  public void appendCMSampleBuffer(CMSampleBuffer paramCMSampleBuffer, int paramInt)
  {
    this.sampleBuffers.put(paramInt, paramCMSampleBuffer);
    this.sourceTrackIDs.add(Integer.valueOf(paramInt));
  }
  
  public void finishCancelledRequest()
  {
    try
    {
      this.status = 1;
      notifyFinish();
      return;
    }
    finally {}
  }
  
  public void finishWithComposedVideoFrame(@NonNull CMSampleBuffer paramCMSampleBuffer)
  {
    try
    {
      this.composedVideoFrame = paramCMSampleBuffer;
      this.status = 0;
      notifyFinish();
      return;
    }
    finally {}
  }
  
  public void finishWithError(ErrorMsg paramErrorMsg)
  {
    try
    {
      this.error = paramErrorMsg;
      this.status = -1;
      notifyFinish();
      return;
    }
    finally {}
  }
  
  public AssetExtension getAssetExtension()
  {
    return this.assetExtension;
  }
  
  public CMSampleBuffer getComposedSampleBuffer()
  {
    try
    {
      CMSampleBuffer localCMSampleBuffer = this.composedVideoFrame;
      return localCMSampleBuffer;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public CMTime getCompositionTime()
  {
    return this.compositionTime;
  }
  
  public VideoCompositionRenderContext getRenderContext()
  {
    return this.renderContext;
  }
  
  public List<Integer> getSourceTrackIDs()
  {
    return this.sourceTrackIDs;
  }
  
  @AsynchronousVideoCompositionRequest.RequestStatus
  public int getStatus()
  {
    try
    {
      int i = this.status;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public IVideoCompositionInstruction getVideoCompositionInstruction()
  {
    return this.videoCompositionInstruction;
  }
  
  public void setCompositionTime(CMTime paramCMTime)
  {
    this.compositionTime = paramCMTime;
  }
  
  public void setRenderContext(VideoCompositionRenderContext paramVideoCompositionRenderContext)
  {
    this.renderContext = paramVideoCompositionRenderContext;
  }
  
  public void setVideoCompositionInstruction(IVideoCompositionInstruction paramIVideoCompositionInstruction)
  {
    this.videoCompositionInstruction = paramIVideoCompositionInstruction;
  }
  
  public CMSampleBuffer sourceFrameByTrackID(int paramInt)
  {
    SparseArray localSparseArray = this.sampleBuffers;
    if (localSparseArray != null) {
      return (CMSampleBuffer)localSparseArray.get(paramInt);
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AsynchronousVideoCompositionRequest{renderContext=");
    localStringBuilder.append(this.renderContext);
    localStringBuilder.append(", compositionTime=");
    localStringBuilder.append(this.compositionTime);
    localStringBuilder.append(", videoCompositionInstruction=");
    localStringBuilder.append(this.videoCompositionInstruction);
    localStringBuilder.append(", sampleBuffers=");
    localStringBuilder.append(this.sampleBuffers);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest
 * JD-Core Version:    0.7.0.1
 */