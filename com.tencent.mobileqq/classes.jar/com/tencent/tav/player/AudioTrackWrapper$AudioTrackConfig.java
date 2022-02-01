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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioTrackConfig{streamType=");
    localStringBuilder.append(this.streamType);
    localStringBuilder.append(", sampleRateInHz=");
    localStringBuilder.append(this.sampleRateInHz);
    localStringBuilder.append(", channelConfig=");
    localStringBuilder.append(this.channelConfig);
    localStringBuilder.append(", audioFormat=");
    localStringBuilder.append(this.audioFormat);
    localStringBuilder.append(", bufferSizeInBytes=");
    localStringBuilder.append(this.bufferSizeInBytes);
    localStringBuilder.append(", mode=");
    localStringBuilder.append(this.mode);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.player.AudioTrackWrapper.AudioTrackConfig
 * JD-Core Version:    0.7.0.1
 */