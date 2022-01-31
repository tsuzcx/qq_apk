package com.tencent.tav.decoder;

import android.view.Surface;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.ExtractorUtils;
import java.util.ArrayList;

class VideoDecoderTrack$DecoderCreateThread
  extends Thread
{
  private Surface outputSurface;
  private int segmentIndex;
  DecoderAssetTrack videoAsset;
  
  private VideoDecoderTrack$DecoderCreateThread(VideoDecoderTrack paramVideoDecoderTrack, DecoderAssetTrack paramDecoderAssetTrack, Surface paramSurface, int paramInt)
  {
    super("DecoderCreateThread " + paramDecoderAssetTrack.assetPath);
    this.videoAsset = paramDecoderAssetTrack;
    this.outputSurface = paramSurface;
    this.segmentIndex = paramInt;
  }
  
  private void checkCreateDecoder()
  {
    if ((VideoDecoderTrack.access$900(this.this$0) != null) && (ExtractorUtils.isSameExtractor(VideoDecoderTrack.access$900(this.this$0).extractor, this.videoAsset))) {
      return;
    }
    if (VideoDecoderTrack.access$900(this.this$0) == null)
    {
      createDecoder();
      return;
    }
    Logger.d(VideoDecoderTrack.access$400(), "DecoderCreateThread create - " + this.videoAsset.assetPath);
    if ((VideoDecoderTrack.access$900(this.this$0).decoder != null) && (VideoDecoderTrack.access$900(this.this$0).decoder != VideoDecoderTrack.access$1000(this.this$0))) {
      releaseNextDecoder();
    }
    createDecoder();
  }
  
  private void createDecoder()
  {
    if ((VideoDecoderTrack.access$1100(this.this$0) == null) || (this.segmentIndex >= VideoDecoderTrack.access$1100(this.this$0).size())) {
      return;
    }
    for (;;)
    {
      try
      {
        Surface localSurface = this.outputSurface;
        if (this.videoAsset.sourceType != 3) {
          continue;
        }
        localObject2 = new ImageDecoder();
        localObject1 = localObject2;
        try
        {
          VideoDecoderTrack.access$1200(this.this$0, localSurface);
          localObject1 = localObject2;
          ((IVideoDecoder)localObject2).init(this.videoAsset.assetPath, ImageDecoder.IMAGE_DECODE_SIZE, null);
          localObject1 = localObject2;
          ((IVideoDecoder)localObject2).start(VideoDecoderTrack.access$1300(this.this$0, this.segmentIndex).getTimeRange(), VideoDecoderTrack.access$1300(this.this$0, this.segmentIndex).getDecoderStartTime());
          localObject1 = localObject2;
          VideoDecoderTrack.access$902(this.this$0, new VideoDecoderTrack.DecoderWrapper(this.this$0, null));
          localObject1 = localObject2;
          VideoDecoderTrack.access$900(this.this$0).outputSurface = localSurface;
          localObject1 = localObject2;
          VideoDecoderTrack.access$900(this.this$0).decoder = ((IVideoDecoder)localObject2);
          localObject1 = localObject2;
          VideoDecoderTrack.access$900(this.this$0).extractor = this.videoAsset;
          localObject1 = localObject2;
          VideoDecoderTrack.access$900(this.this$0).segmentIndex = this.segmentIndex;
          localObject1 = localObject2;
          Logger.d(VideoDecoderTrack.access$400(), "DecoderCreateThread success - " + this.videoAsset.assetPath);
          return;
        }
        catch (Exception localException2)
        {
          localObject2 = localObject1;
          localObject1 = localException2;
        }
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Object localObject2 = null;
        continue;
      }
      Logger.e(VideoDecoderTrack.access$400(), (Throwable)localObject1);
      VideoDecoderTrack.access$500(this.this$0, (IVideoDecoder)localObject2);
      return;
      localObject2 = new VideoDecoder(this.videoAsset.assetPath, localException2);
    }
  }
  
  private void releaseNextDecoder()
  {
    synchronized (VideoDecoderTrack.access$800(this.this$0))
    {
      if (VideoDecoderTrack.access$900(this.this$0) != null)
      {
        VideoDecoderTrack.DecoderWrapper.access$300(VideoDecoderTrack.access$900(this.this$0));
        VideoDecoderTrack.access$902(this.this$0, null);
      }
      return;
    }
  }
  
  public void run()
  {
    ??? = VideoDecoderTrack.access$400();
    StringBuilder localStringBuilder = new StringBuilder().append("DecoderCreateThread start - ").append(this.videoAsset.assetPath).append(" - ");
    if (this.outputSurface != null) {}
    for (boolean bool = true;; bool = false)
    {
      Logger.d((String)???, bool);
      if (!VideoDecoderTrack.access$600(this.this$0)) {
        break;
      }
      VideoDecoderTrack.access$702(this.this$0, null);
      return;
    }
    synchronized (VideoDecoderTrack.access$800(this.this$0))
    {
      checkCreateDecoder();
      VideoDecoderTrack.access$702(this.this$0, null);
      if (VideoDecoderTrack.access$600(this.this$0)) {
        releaseNextDecoder();
      }
      Logger.d(VideoDecoderTrack.access$400(), "DecoderCreateThread finish - " + this.videoAsset.assetPath);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoderTrack.DecoderCreateThread
 * JD-Core Version:    0.7.0.1
 */