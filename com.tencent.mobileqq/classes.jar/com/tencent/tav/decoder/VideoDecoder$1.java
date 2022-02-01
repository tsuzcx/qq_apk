package com.tencent.tav.decoder;

import android.os.SystemClock;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;

class VideoDecoder$1
  implements Runnable
{
  VideoDecoder$1(VideoDecoder paramVideoDecoder) {}
  
  public void run()
  {
    long l2;
    try
    {
      l2 = SystemClock.currentThreadTimeMillis();
      AssetExtractor localAssetExtractor = new AssetExtractor();
      localAssetExtractor.setDataSource(VideoDecoder.access$000(this.this$0));
      while (localAssetExtractor.getSampleTrackIndex() != -1) {
        localAssetExtractor.unselectTrack(localAssetExtractor.getSampleTrackIndex());
      }
      localException.selectTrack(DecoderUtils.getFirstTrackIndex(localException, "video/"));
    }
    catch (Exception localException)
    {
      Logger.e(this.this$0.TAG, "createMirrorExtractor: ", localException);
      return;
    }
    if (VideoDecoder.access$100(this.this$0) == null) {}
    for (long l1 = 0L;; l1 = VideoDecoder.access$100(this.this$0).getStartUs())
    {
      localException.seekTo(l1, 0);
      while (localException.getSampleTime() != -1L) {
        localException.advance();
      }
    }
    VideoDecoder.access$202(this.this$0, localException);
    Logger.d(this.this$0.TAG, "Decoder: MirrorExtractor Init " + (SystemClock.currentThreadTimeMillis() - l2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoder.1
 * JD-Core Version:    0.7.0.1
 */