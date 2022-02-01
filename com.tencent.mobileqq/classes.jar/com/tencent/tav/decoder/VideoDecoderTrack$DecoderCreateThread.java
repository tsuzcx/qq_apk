package com.tencent.tav.decoder;

import android.view.Surface;
import com.tencent.tav.decoder.factory.AVDecoderFactory;
import com.tencent.tav.decoder.factory.IDecoderFactory;
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
    if ((VideoDecoderTrack.access$1000(this.this$0) != null) && (ExtractorUtils.isSameExtractor(VideoDecoderTrack.access$1000(this.this$0).extractor, this.videoAsset))) {
      return;
    }
    if (VideoDecoderTrack.access$1000(this.this$0) == null)
    {
      createDecoder();
      return;
    }
    Logger.d(VideoDecoderTrack.access$500(), "DecoderCreateThread create - " + this.videoAsset.assetPath);
    if ((VideoDecoderTrack.access$1000(this.this$0).decoder != null) && (VideoDecoderTrack.access$1000(this.this$0).decoder != VideoDecoderTrack.access$1100(this.this$0))) {
      releaseNextDecoder();
    }
    createDecoder();
  }
  
  private void createDecoder()
  {
    IVideoDecoder localIVideoDecoder2 = null;
    if ((VideoDecoderTrack.access$1200(this.this$0) == null) || (this.segmentIndex >= VideoDecoderTrack.access$1200(this.this$0).size())) {}
    for (;;)
    {
      return;
      IVideoDecoder localIVideoDecoder1 = localIVideoDecoder2;
      try
      {
        Surface localSurface = this.outputSurface;
        localIVideoDecoder1 = localIVideoDecoder2;
        IVideoDecoder.Params localParams = VideoDecoderTrack.access$1300(this.this$0, this.videoAsset, localSurface);
        localIVideoDecoder1 = localIVideoDecoder2;
        localIVideoDecoder2 = AVDecoderFactory.getInstance().createVideoDecoder(localParams);
        localIVideoDecoder1 = localIVideoDecoder2;
        if (localParams.sourceType == 3)
        {
          localIVideoDecoder1 = localIVideoDecoder2;
          VideoDecoderTrack.access$300(this.this$0, localSurface);
        }
        if (localIVideoDecoder2 != null)
        {
          localIVideoDecoder1 = localIVideoDecoder2;
          localIVideoDecoder2.start(VideoDecoderTrack.access$1400(this.this$0, this.segmentIndex).getTimeRange(), VideoDecoderTrack.access$1400(this.this$0, this.segmentIndex).getDecoderStartTime());
          localIVideoDecoder1 = localIVideoDecoder2;
          VideoDecoderTrack.access$1002(this.this$0, new VideoDecoderTrack.DecoderWrapper(this.this$0, null));
          localIVideoDecoder1 = localIVideoDecoder2;
          VideoDecoderTrack.access$1000(this.this$0).outputSurface = localSurface;
          localIVideoDecoder1 = localIVideoDecoder2;
          VideoDecoderTrack.access$1000(this.this$0).decoder = localIVideoDecoder2;
          localIVideoDecoder1 = localIVideoDecoder2;
          VideoDecoderTrack.access$1000(this.this$0).extractor = this.videoAsset;
          localIVideoDecoder1 = localIVideoDecoder2;
          VideoDecoderTrack.access$1000(this.this$0).segmentIndex = this.segmentIndex;
          localIVideoDecoder1 = localIVideoDecoder2;
          Logger.d(VideoDecoderTrack.access$500(), "DecoderCreateThread success - " + this.videoAsset.assetPath);
          return;
        }
      }
      catch (Exception localException)
      {
        Logger.e(VideoDecoderTrack.access$500(), "createDecoder: ", localException);
        VideoDecoderTrack.access$600(this.this$0, localIVideoDecoder1);
      }
    }
  }
  
  private void releaseNextDecoder()
  {
    synchronized (VideoDecoderTrack.access$900(this.this$0))
    {
      if (VideoDecoderTrack.access$1000(this.this$0) != null)
      {
        VideoDecoderTrack.DecoderWrapper.access$400(VideoDecoderTrack.access$1000(this.this$0));
        VideoDecoderTrack.access$1002(this.this$0, null);
      }
      return;
    }
  }
  
  public void run()
  {
    ??? = VideoDecoderTrack.access$500();
    StringBuilder localStringBuilder = new StringBuilder().append("DecoderCreateThread start - ").append(this.videoAsset.assetPath).append(" - ");
    if (this.outputSurface != null) {}
    for (boolean bool = true;; bool = false)
    {
      Logger.d((String)???, bool);
      if (!VideoDecoderTrack.access$700(this.this$0)) {
        break;
      }
      VideoDecoderTrack.access$802(this.this$0, null);
      return;
    }
    synchronized (VideoDecoderTrack.access$900(this.this$0))
    {
      checkCreateDecoder();
      VideoDecoderTrack.access$802(this.this$0, null);
      if (VideoDecoderTrack.access$700(this.this$0)) {
        releaseNextDecoder();
      }
      Logger.d(VideoDecoderTrack.access$500(), "DecoderCreateThread finish - " + this.videoAsset.assetPath);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoderTrack.DecoderCreateThread
 * JD-Core Version:    0.7.0.1
 */