package com.tencent.tavkit.component;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.core.AssetImageGenerator.ImageGeneratorListener;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVSourceImageGenerator
{
  public static final String TAG = "TAVSourceImageGenerator";
  private AssetImageGenerator assetImageGenerator;
  
  public TAVSourceImageGenerator(@NonNull TAVComposition paramTAVComposition, CGSize paramCGSize)
  {
    init(new TAVCompositionBuilder(paramTAVComposition).buildSource(), paramCGSize);
  }
  
  public TAVSourceImageGenerator(@NonNull TAVSource paramTAVSource, CGSize paramCGSize)
  {
    init(paramTAVSource, paramCGSize);
  }
  
  private void checkRequestedTimes(List<CMTime> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if (((List)localObject).isEmpty()) {
      ((List)localObject).add(CMTime.CMTimeZero);
    }
    int i = 0;
    while (i < ((List)localObject).size())
    {
      paramList = (CMTime)((List)localObject).get(i);
      if ((paramList == null) || (paramList.getTimeUs() < 0L)) {
        ((List)localObject).set(i, CMTime.CMTimeZero);
      }
      i += 1;
    }
    paramList = new ArrayList(((List)localObject).size());
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      CMTime localCMTime = (CMTime)localIterator.next();
      if (!paramList.contains(localCMTime)) {
        paramList.add(localCMTime);
      }
    }
    ((List)localObject).clear();
    ((List)localObject).addAll(paramList);
  }
  
  private void init(@NonNull TAVSource paramTAVSource, CGSize paramCGSize)
  {
    this.assetImageGenerator = new AssetImageGenerator(paramTAVSource.getAsset());
    this.assetImageGenerator.setMaximumSize(paramCGSize);
    this.assetImageGenerator.setAppliesPreferredTrackTransform(true);
    this.assetImageGenerator.setVideoComposition(paramTAVSource.getVideoComposition());
  }
  
  public void generateThumbnailAtTime(CMTime paramCMTime, @NonNull AssetImageGenerator.ImageGeneratorListener paramImageGeneratorListener)
  {
    ArrayList localArrayList = new ArrayList();
    CMTime localCMTime;
    if (paramCMTime != null)
    {
      localCMTime = paramCMTime;
      if (paramCMTime.getTimeUs() >= 0L) {}
    }
    else
    {
      localCMTime = CMTime.CMTimeZero;
    }
    localArrayList.add(localCMTime);
    generateThumbnailAtTimes(localArrayList, paramImageGeneratorListener);
  }
  
  public Bitmap generateThumbnailAtTimeSync(CMTime paramCMTime)
  {
    if (this.assetImageGenerator != null)
    {
      CMTime localCMTime;
      if (paramCMTime != null) {
        localCMTime = paramCMTime;
      }
      try
      {
        if (paramCMTime.getTimeUs() < 0L) {
          localCMTime = CMTime.CMTimeZero;
        }
        paramCMTime = this.assetImageGenerator.copyCGImageAtTimeAndActualTime(localCMTime, null);
        return paramCMTime;
      }
      catch (Exception paramCMTime)
      {
        paramCMTime.printStackTrace();
        throw new Exception(paramCMTime);
      }
    }
    return null;
  }
  
  public void generateThumbnailAtTimes(List<CMTime> paramList, @NonNull AssetImageGenerator.ImageGeneratorListener paramImageGeneratorListener)
  {
    try
    {
      checkRequestedTimes(paramList);
      if (!paramList.isEmpty())
      {
        AssetImageGenerator localAssetImageGenerator = this.assetImageGenerator;
        if (localAssetImageGenerator == null) {
          return;
        }
        this.assetImageGenerator.generateCGImagesAsynchronouslyForTimes(paramList, new TAVSourceImageGenerator.1(this, paramImageGeneratorListener));
      }
      return;
    }
    finally {}
  }
  
  public AssetImageGenerator getAssetImageGenerator()
  {
    return this.assetImageGenerator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVSourceImageGenerator
 * JD-Core Version:    0.7.0.1
 */