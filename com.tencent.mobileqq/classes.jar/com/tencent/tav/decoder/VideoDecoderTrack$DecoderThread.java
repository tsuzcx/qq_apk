package com.tencent.tav.decoder;

import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;

class VideoDecoderTrack$DecoderThread
  extends ReActionThread
{
  private static final String NAME = "VideoDecoder";
  
  private VideoDecoderTrack$DecoderThread(VideoDecoderTrack paramVideoDecoderTrack)
  {
    super("VideoDecoder");
  }
  
  private void doActionInDecoderLock()
  {
    if (VideoDecoderTrack.access$1700(this.this$0) == null) {}
    do
    {
      return;
      if (VideoDecoderTrack.access$1800(this.this$0).isInvalid())
      {
        VideoDecoderTrack.access$1900(this.this$0, "DecoderThread doAction: CMTime.CMTimeZero");
        VideoDecoderTrack.access$1702(this.this$0, VideoDecoderTrack.access$2000(this.this$0, CMTime.CMTimeZero, true));
        return;
      }
    } while (VideoDecoderTrack.access$1800(this.this$0).getStateCode() < 0L);
    VideoDecoderTrack.access$1900(this.this$0, "DecoderThread doAction: lastSampleTime.add(frameDuration) ");
    VideoDecoderTrack.access$1702(this.this$0, VideoDecoderTrack.access$2000(this.this$0, VideoDecoderTrack.access$1700(this.this$0).getTime(), true));
  }
  
  protected void doAction()
  {
    synchronized (VideoDecoderTrack.access$1600(this.this$0))
    {
      doActionInDecoderLock();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoderTrack.DecoderThread
 * JD-Core Version:    0.7.0.1
 */