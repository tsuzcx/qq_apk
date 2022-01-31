package com.tencent.tav.decoder;

import com.tencent.tav.decoder.logger.Logger;

class VideoDecoderTrack$ReleaseDecoderThread
  extends Thread
{
  private IVideoDecoder decoder;
  
  VideoDecoderTrack$ReleaseDecoderThread(VideoDecoderTrack paramVideoDecoderTrack, IVideoDecoder paramIVideoDecoder)
  {
    super("ReleaseDecoderThread");
    this.decoder = paramIVideoDecoder;
  }
  
  private void doRelease()
  {
    if (this.decoder != null)
    {
      Logger.d(VideoDecoderTrack.access$400(), "ReleaseDecoderThread start");
      this.decoder.release(true);
      VideoDecoderTrack.access$1200(this.this$0, this.decoder.outputSurface());
      this.decoder = null;
      Logger.d(VideoDecoderTrack.access$400(), "ReleaseDecoderThread end");
    }
  }
  
  public void run()
  {
    doRelease();
  }
  
  public void start()
  {
    if (!(this.decoder instanceof VideoDecoder)) {
      doRelease();
    }
    super.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoderTrack.ReleaseDecoderThread
 * JD-Core Version:    0.7.0.1
 */