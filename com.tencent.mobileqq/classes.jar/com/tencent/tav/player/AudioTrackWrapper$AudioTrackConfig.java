package com.tencent.tav.player;

class AudioTrackWrapper$AudioTrackConfig
{
  int audioFormat = 2;
  int bufferSizeInBytes;
  int channelConfig = 12;
  int mode = 1;
  int sampleRateInHz;
  int streamType = 3;
  
  public AudioTrackWrapper$AudioTrackConfig(int paramInt1, int paramInt2)
  {
    this.sampleRateInHz = getSampleRateInHz(paramInt1, paramInt2);
    this.bufferSizeInBytes = 8192;
  }
  
  private int getSampleRateInHz(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 == 1) {
      i = paramInt1 / 2;
    }
    return i;
  }
  
  public String toString()
  {
    return "AudioTrackConfig{streamType=" + this.streamType + ", sampleRateInHz=" + this.sampleRateInHz + ", channelConfig=" + this.channelConfig + ", audioFormat=" + this.audioFormat + ", bufferSizeInBytes=" + this.bufferSizeInBytes + ", mode=" + this.mode + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.player.AudioTrackWrapper.AudioTrackConfig
 * JD-Core Version:    0.7.0.1
 */