package com.tencent.tav.decoder;

import android.os.SystemClock;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import java.util.ArrayList;
import java.util.List;

class VideoDecoder$1
  extends Thread
{
  VideoDecoder$1(VideoDecoder paramVideoDecoder) {}
  
  public void run()
  {
    long l2;
    try
    {
      l2 = SystemClock.currentThreadTimeMillis();
      AssetExtractor localAssetExtractor = new AssetExtractor();
      localAssetExtractor.setDataSource(VideoDecoder.access$000(this.this$0).getSourcePath());
      while (localAssetExtractor.getSampleTrackIndex() != -1) {
        localAssetExtractor.unselectTrack(localAssetExtractor.getSampleTrackIndex());
      }
      localException.selectTrack(DecoderUtils.getFirstTrackIndex(localException, "video/"));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    if (VideoDecoder.access$100(this.this$0) == null) {}
    ArrayList localArrayList;
    for (long l1 = 0L;; l1 = VideoDecoder.access$100(this.this$0).getStartUs())
    {
      localException.seekTo(l1, 0);
      localArrayList = new ArrayList();
      while (localException.getSampleTime() != -1L)
      {
        localArrayList.add(Long.valueOf(localException.getSampleTime()));
        localException.advance();
      }
    }
    VideoDecoder.access$200(this.this$0).addAll(localArrayList);
    VideoDecoder.access$302(this.this$0, localException);
    Logger.i(this.this$0.TAG, "Decoder: MirrorExtractor Init " + (SystemClock.currentThreadTimeMillis() - l2), new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoder.1
 * JD-Core Version:    0.7.0.1
 */