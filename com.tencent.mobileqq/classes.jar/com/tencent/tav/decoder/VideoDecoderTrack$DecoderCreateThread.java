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
    super(paramVideoDecoderTrack.toString());
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
    String str = VideoDecoderTrack.access$500();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DecoderCreateThread create - ");
    localStringBuilder.append(this.videoAsset.assetPath);
    Logger.d(str, localStringBuilder.toString());
    if ((VideoDecoderTrack.access$1000(this.this$0).decoder != null) && (VideoDecoderTrack.access$1000(this.this$0).decoder != VideoDecoderTrack.access$1100(this.this$0))) {
      releaseNextDecoder();
    }
    createDecoder();
  }
  
  private void createDecoder()
  {
    if (VideoDecoderTrack.access$1200(this.this$0) != null)
    {
      if (this.segmentIndex >= VideoDecoderTrack.access$1200(this.this$0).size()) {
        return;
      }
      IVideoDecoder localIVideoDecoder;
      try
      {
        Object localObject1 = this.outputSurface;
        Object localObject2 = VideoDecoderTrack.access$1300(this.this$0, this.videoAsset, (Surface)localObject1);
        localIVideoDecoder = AVDecoderFactory.getInstance().createVideoDecoder((IVideoDecoder.Params)localObject2);
        try
        {
          if (((IVideoDecoder.Params)localObject2).sourceType == 3) {
            VideoDecoderTrack.access$300(this.this$0, (Surface)localObject1);
          }
          if (localIVideoDecoder == null) {
            return;
          }
          localIVideoDecoder.start(VideoDecoderTrack.access$1400(this.this$0, this.segmentIndex).getTimeRange(), VideoDecoderTrack.access$1400(this.this$0, this.segmentIndex).getDecoderStartTime());
          VideoDecoderTrack.access$1002(this.this$0, new VideoDecoderTrack.DecoderWrapper(this.this$0, null));
          VideoDecoderTrack.access$1000(this.this$0).outputSurface = ((Surface)localObject1);
          VideoDecoderTrack.access$1000(this.this$0).decoder = localIVideoDecoder;
          VideoDecoderTrack.access$1000(this.this$0).extractor = this.videoAsset;
          VideoDecoderTrack.access$1000(this.this$0).segmentIndex = this.segmentIndex;
          localObject1 = VideoDecoderTrack.access$500();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("DecoderCreateThread success - ");
          ((StringBuilder)localObject2).append(this.videoAsset.assetPath);
          Logger.d((String)localObject1, ((StringBuilder)localObject2).toString());
          return;
        }
        catch (Exception localException1) {}
        Logger.e(VideoDecoderTrack.access$500(), "createDecoder: ", localException2);
      }
      catch (Exception localException2)
      {
        localIVideoDecoder = null;
      }
      VideoDecoderTrack.access$600(this.this$0, localIVideoDecoder);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DecoderCreateThread start - ");
    localStringBuilder.append(this.videoAsset.assetPath);
    localStringBuilder.append(" - ");
    boolean bool;
    if (this.outputSurface != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    Logger.d((String)???, localStringBuilder.toString());
    if (VideoDecoderTrack.access$700(this.this$0))
    {
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
      ??? = VideoDecoderTrack.access$500();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DecoderCreateThread finish - ");
      localStringBuilder.append(this.videoAsset.assetPath);
      Logger.d((String)???, localStringBuilder.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoderTrack.DecoderCreateThread
 * JD-Core Version:    0.7.0.1
 */