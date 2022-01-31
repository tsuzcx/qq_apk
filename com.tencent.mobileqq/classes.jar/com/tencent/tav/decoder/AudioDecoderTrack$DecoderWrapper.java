package com.tencent.tav.decoder;

import com.tencent.tav.decoder.logger.Logger;

class AudioDecoderTrack$DecoderWrapper
{
  IDecoder decoder;
  DecoderAssetTrack extractor;
  int segmentIndex = -1;
  
  private void release()
  {
    Logger.d(AudioDecoderTrack.access$700(), "Audio DecoderWrapper release: ");
    try
    {
      if (this.decoder != null) {
        this.decoder.release();
      }
      return;
    }
    catch (Exception localException) {}catch (Error localError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoderTrack.DecoderWrapper
 * JD-Core Version:    0.7.0.1
 */