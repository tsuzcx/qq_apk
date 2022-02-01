package com.tencent.tav.decoder;

import android.os.SystemClock;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;

class VideoDecoder$1
  implements Runnable
{
  VideoDecoder$1(VideoDecoder paramVideoDecoder) {}
  
  public void run()
  {
    try
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      Object localObject = new AssetExtractor();
      ((AssetExtractor)localObject).setDataSource(VideoDecoder.access$000(this.this$0));
      while (((AssetExtractor)localObject).getSampleTrackIndex() != -1) {
        ((AssetExtractor)localObject).unselectTrack(((AssetExtractor)localObject).getSampleTrackIndex());
      }
      ((AssetExtractor)localObject).selectTrack(ExtractorUtils.getFirstTrackIndex((AssetExtractor)localObject, "video/"));
      long l1;
      if (VideoDecoder.access$100(this.this$0) == null) {
        l1 = 0L;
      } else {
        l1 = VideoDecoder.access$100(this.this$0).getStartUs();
      }
      ((AssetExtractor)localObject).seekTo(l1, 0);
      while (((AssetExtractor)localObject).getSampleTime() != -1L) {
        ((AssetExtractor)localObject).advance();
      }
      VideoDecoder.access$202(this.this$0, (AssetExtractor)localObject);
      localObject = this.this$0.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Decoder: MirrorExtractor Init ");
      localStringBuilder.append(SystemClock.currentThreadTimeMillis() - l2);
      Logger.d((String)localObject, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      Logger.e(this.this$0.TAG, "createMirrorExtractor: ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoder.1
 * JD-Core Version:    0.7.0.1
 */