package com.tencent.tav.core;

import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.decoder.ReActionThread;
import com.tencent.tav.decoder.logger.Logger;

class AudioCompositionDecoderTrack$DecoderThread
  extends ReActionThread
{
  private static final String NAME = "AudioDecoderThread";
  private final Object nextFrameDecoderLock = new Object();
  private CMSampleBuffer pcmFrame;
  
  public AudioCompositionDecoderTrack$DecoderThread(AudioCompositionDecoderTrack paramAudioCompositionDecoderTrack)
  {
    super("AudioDecoderThread");
  }
  
  protected void doAction()
  {
    synchronized (this.nextFrameDecoderLock)
    {
      Logger.v("AudioCompositionDecoder", "doAction: start ");
      this.pcmFrame = AudioCompositionDecoderTrack.access$200(this.this$0);
      if (this.pcmFrame.getSampleByteBuffer() != null) {
        this.pcmFrame.setSampleByteBuffer(this.this$0.processFrame(this.pcmFrame.getSampleByteBuffer(), AudioCompositionDecoderTrack.access$300(this.this$0), AudioCompositionDecoderTrack.access$400(this.this$0), AudioCompositionDecoderTrack.access$500(this.this$0)));
      }
      Logger.v("AudioCompositionDecoder", "doAction: finish ");
      return;
    }
  }
  
  public void run()
  {
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.AudioCompositionDecoderTrack.DecoderThread
 * JD-Core Version:    0.7.0.1
 */