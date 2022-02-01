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
    Object localObject = null;
    if (this.assetImageGenerator != null) {
      if (paramCMTime != null) {
        localObject = paramCMTime;
      }
    }
    try
    {
      if (paramCMTime.getTimeUs() < 0L) {
        localObject = CMTime.CMTimeZero;
      }
      localObject = this.assetImageGenerator.copyCGImageAtTimeAndActualTime((CMTime)localObject, null);
      return localObject;
    }
    catch (Exception paramCMTime)
    {
      paramCMTime.printStackTrace();
      throw new Exception(paramCMTime);
    }
  }
  
  /* Error */
  public void generateThumbnailAtTimes(List<CMTime> paramList, @NonNull AssetImageGenerator.ImageGeneratorListener paramImageGeneratorListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 147	com/tencent/tavkit/component/TAVSourceImageGenerator:checkRequestedTimes	(Ljava/util/List;)V
    //   7: aload_1
    //   8: invokeinterface 42 1 0
    //   13: ifne +12 -> 25
    //   16: aload_0
    //   17: getfield 109	com/tencent/tavkit/component/TAVSourceImageGenerator:assetImageGenerator	Lcom/tencent/tav/core/AssetImageGenerator;
    //   20: astore_3
    //   21: aload_3
    //   22: ifnonnull +6 -> 28
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 109	com/tencent/tavkit/component/TAVSourceImageGenerator:assetImageGenerator	Lcom/tencent/tav/core/AssetImageGenerator;
    //   32: aload_1
    //   33: new 149	com/tencent/tavkit/component/TAVSourceImageGenerator$1
    //   36: dup
    //   37: aload_0
    //   38: aload_2
    //   39: invokespecial 152	com/tencent/tavkit/component/TAVSourceImageGenerator$1:<init>	(Lcom/tencent/tavkit/component/TAVSourceImageGenerator;Lcom/tencent/tav/core/AssetImageGenerator$ImageGeneratorListener;)V
    //   42: invokevirtual 155	com/tencent/tav/core/AssetImageGenerator:generateCGImagesAsynchronouslyForTimes	(Ljava/util/List;Lcom/tencent/tav/core/AssetImageGenerator$ImageGeneratorListener;)V
    //   45: goto -20 -> 25
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	TAVSourceImageGenerator
    //   0	53	1	paramList	List<CMTime>
    //   0	53	2	paramImageGeneratorListener	AssetImageGenerator.ImageGeneratorListener
    //   20	2	3	localAssetImageGenerator	AssetImageGenerator
    // Exception table:
    //   from	to	target	type
    //   2	21	48	finally
    //   28	45	48	finally
  }
  
  public AssetImageGenerator getAssetImageGenerator()
  {
    return this.assetImageGenerator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVSourceImageGenerator
 * JD-Core Version:    0.7.0.1
 */