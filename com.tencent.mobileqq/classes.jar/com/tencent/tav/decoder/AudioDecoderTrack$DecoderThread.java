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
    for (;;)
    {
      synchronized (this.nextFrameDecoderLock)
      {
        if (this.pcmFrame != null)
        {
          CMSampleBuffer localCMSampleBuffer;
          if (AudioDecoderTrack.access$1700(this.this$0).getTime() == CMTime.CMTimeInvalid)
          {
            Logger.v(AudioDecoderTrack.access$700(), "doAction: CMTime.CMTimeZero");
            localCMSampleBuffer = AudioDecoderTrack.access$1800(this.this$0, CMTime.CMTimeZero);
          }
          else
          {
            if (AudioDecoderTrack.access$1700(this.this$0).getTime().smallThan(CMTime.CMTimeZero)) {
              break label345;
            }
            Logger.v(AudioDecoderTrack.access$700(), "doAction: lastSampleTime.add(frameDuration)");
            localCMSampleBuffer = AudioDecoderTrack.access$1800(this.this$0, AudioDecoderTrack.access$1700(this.this$0).getTime().add(AudioDecoderTrack.access$1900(this.this$0)));
          }
          if (localCMSampleBuffer != null)
          {
            if (localCMSampleBuffer.getSampleByteBuffer() != null)
            {
              String str = AudioDecoderTrack.access$700();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("doAction: processFrame [volume ");
              localStringBuilder.append(AudioDecoderTrack.access$2000(this.this$0));
              localStringBuilder.append("] [_speed ");
              localStringBuilder.append(AudioDecoderTrack.access$2100(this.this$0));
              localStringBuilder.append("]");
              Logger.v(str, localStringBuilder.toString());
              localCMSampleBuffer.setSampleByteBuffer(this.this$0.processFrame(localCMSampleBuffer.getSampleByteBuffer(), 1.0F, AudioDecoderTrack.access$2100(this.this$0), this.this$0.getAudioInfo()));
              str = AudioDecoderTrack.access$700();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("doAction: processFrame finish [volume ");
              localStringBuilder.append(AudioDecoderTrack.access$2000(this.this$0));
              localStringBuilder.append("] [_speed ");
              localStringBuilder.append(AudioDecoderTrack.access$2100(this.this$0));
              localStringBuilder.append("]");
              Logger.v(str, localStringBuilder.toString());
            }
            this.pcmFrame = new AudioDecoderTrack.CacheBuffer(null);
            AudioDecoderTrack.CacheBuffer.access$2302(this.pcmFrame, AudioDecoderTrack.access$1700(this.this$0).getTime());
            AudioDecoderTrack.CacheBuffer.access$302(this.pcmFrame, localCMSampleBuffer.getTime());
          }
        }
        return;
      }
      label345:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioDecoderTrack.DecoderThread
 * JD-Core Version:    0.7.0.1
 */