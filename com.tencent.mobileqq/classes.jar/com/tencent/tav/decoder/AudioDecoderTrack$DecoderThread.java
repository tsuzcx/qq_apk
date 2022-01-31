package com.tencent.tav.decoder;

import com.tencent.tav.coremedia.CMSampleBuffer;
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
        if (AudioDecoderTrack.access$1600(this.this$0) != CMTime.CMTimeInvalid) {
          break label259;
        }
        if (Logger.LOG_VERBOSE) {
          Logger.d(AudioDecoderTrack.access$700(), "doAction: CMTime.CMTimeZero");
        }
        localCMSampleBuffer = AudioDecoderTrack.access$1700(this.this$0, CMTime.CMTimeZero);
      }
      label259:
      while (AudioDecoderTrack.access$1600(this.this$0).smallThan(CMTime.CMTimeZero))
      {
        if (localCMSampleBuffer != null)
        {
          if (localCMSampleBuffer.getSampleByteBuffer() != null)
          {
            if (Logger.LOG_VERBOSE) {
              Logger.i(AudioDecoderTrack.access$700(), "doAction: processFrame [volume " + AudioDecoderTrack.access$1900(this.this$0) + "] [_speed " + AudioDecoderTrack.access$2000(this.this$0) + "]", new Object[0]);
            }
            localCMSampleBuffer.setSampleByteBuffer(this.this$0.processFrame(localCMSampleBuffer.getSampleByteBuffer(), 1.0F, AudioDecoderTrack.access$2000(this.this$0), this.this$0.getAudioInfo()));
            if (Logger.LOG_VERBOSE) {
              Logger.i(AudioDecoderTrack.access$700(), "doAction: processFrame finish [volume " + AudioDecoderTrack.access$1900(this.this$0) + "] [_speed " + AudioDecoderTrack.access$2000(this.this$0) + "]", new Object[0]);
            }
          }
          this.pcmFrame = new AudioDecoderTrack.CacheBuffer(null);
          AudioDecoderTrack.CacheBuffer.access$2202(this.pcmFrame, AudioDecoderTrack.access$1600(this.this$0));
          AudioDecoderTrack.CacheBuffer.access$302(this.pcmFrame, localCMSampleBuffer.getTime());
        }
        return;
      }
      if (Logger.LOG_VERBOSE) {
        Logger.d(AudioDecoderTrack.access$700(), "doAction: lastSampleTime.add(frameDuration)");
      }
      localCMSampleBuffer = AudioDecoderTrack.access$1700(this.this$0, AudioDecoderTrack.access$1600(this.this$0).add(AudioDecoderTrack.access$1800(this.this$0)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoderTrack.DecoderThread
 * JD-Core Version:    0.7.0.1
 */