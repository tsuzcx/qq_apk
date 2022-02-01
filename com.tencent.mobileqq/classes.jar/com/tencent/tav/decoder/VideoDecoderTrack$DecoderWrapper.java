package com.tencent.tav.decoder;

import android.view.Surface;
import com.tencent.tav.decoder.logger.Logger;

class VideoDecoderTrack$DecoderWrapper
{
  IVideoDecoder decoder;
  DecoderAssetTrack extractor;
  Surface outputSurface;
  int segmentIndex = -1;
  
  private VideoDecoderTrack$DecoderWrapper(VideoDecoderTrack paramVideoDecoderTrack) {}
  
  private void release()
  {
    Logger.d(VideoDecoderTrack.access$500(), "Video DecoderWrapper release: ");
    VideoDecoderTrack.access$600(this.this$0, this.decoder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoderTrack.DecoderWrapper
 * JD-Core Version:    0.7.0.1
 */