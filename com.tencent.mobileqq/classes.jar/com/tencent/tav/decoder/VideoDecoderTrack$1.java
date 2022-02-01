package com.tencent.tav.decoder;

class VideoDecoderTrack$1
  implements Runnable
{
  VideoDecoderTrack$1(VideoDecoderTrack paramVideoDecoderTrack, IVideoDecoder paramIVideoDecoder) {}
  
  public void run()
  {
    VideoDecoderTrack.access$300(this.this$0, this.val$decoder.outputSurface());
    this.val$decoder.release(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoderTrack.1
 * JD-Core Version:    0.7.0.1
 */