package com.tencent.tav.decoder;

class AudioDecoderTrack$ReleaseDecoderThread
  extends Thread
{
  private IDecoder decoder;
  
  AudioDecoderTrack$ReleaseDecoderThread(IDecoder paramIDecoder)
  {
    super("ReleaseDecoderThread");
    this.decoder = paramIDecoder;
  }
  
  public void run()
  {
    if (this.decoder != null) {
      this.decoder.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoderTrack.ReleaseDecoderThread
 * JD-Core Version:    0.7.0.1
 */