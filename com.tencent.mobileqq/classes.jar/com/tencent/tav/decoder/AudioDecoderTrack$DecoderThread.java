package com.tencent.tav.decoder;

import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;

class AudioDecoderTrack$DecoderThread
  extends ReActionThread
{
  private static final String NAME = "AudioDecoderThread";
  private final Object nextFrameDecoderLock = new Object();
  private AudioDecoderTrack.CacheBuffer pcmFrame;
  
  public AudioDecoderTrack$DecoderThread(AudioDecoderTrack paramAudioDecoderTrack)
  {
    super("AudioDecoderThread");
  }
  
  protected void doAction()
  {
    CMSampleBuffer localCMSampleBuffer = null;
    synchronized (this.nextFrameDecoderLock)
    {
      if (this.pcmFrame != null)
      {
        if (AudioDecoderTrack.access$1700(this.this$0).getTime() != CMTime.CMTimeInvalid) {
          break label239;
        }
        Logger.v(AudioDecoderTrack.access$700(), "doAction: CMTime.CMTimeZero");
        localCMSampleBuffer = AudioDecoderTrack.access$1800(this.this$0, CMTime.CMTimeZero);
      }
      label239:
      while (AudioDecoderTrack.access$1700(this.this$0).getTime().smallThan(CMTime.CMTimeZero))
      {
        if (localCMSampleBuffer != null)
        {
          if (localCMSampleBuffer.getSampleByteBuffer() != null)
          {
            Logger.v(AudioDecoderTrack.access$700(), "doAction: processFrame [volume " + AudioDecoderTrack.access$2000(this.this$0) + "] [_speed " + AudioDecoderTrack.access$2100(this.this$0) + "]");
            localCMSampleBuffer.setSampleByteBuffer(this.this$0.processFrame(localCMSampleBuffer.getSampleByteBuffer(), 1.0F, AudioDecoderTrack.access$2100(this.this$0), this.this$0.getAudioInfo()));
            Logger.v(AudioDecoderTrack.access$700(), "doAction: processFrame finish [volume " + AudioDecoderTrack.access$2000(this.this$0) + "] [_speed " + AudioDecoderTrack.access$2100(this.this$0) + "]");
          }
          this.pcmFrame = new AudioDecoderTrack.CacheBuffer(null);
          AudioDecoderTrack.CacheBuffer.access$2302(this.pcmFrame, AudioDecoderTrack.access$1700(this.this$0).getTime());
          AudioDecoderTrack.CacheBuffer.access$302(this.pcmFrame, localCMSampleBuffer.getTime());
        }
        return;
      }
      Logger.v(AudioDecoderTrack.access$700(), "doAction: lastSampleTime.add(frameDuration)");
      localCMSampleBuffer = AudioDecoderTrack.access$1800(this.this$0, AudioDecoderTrack.access$1700(this.this$0).getTime().add(AudioDecoderTrack.access$1900(this.this$0)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoderTrack.DecoderThread
 * JD-Core Version:    0.7.0.1
 */