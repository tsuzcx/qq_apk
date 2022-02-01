package com.tencent.tav.decoder;

public class AudioInfo
  implements Cloneable
{
  public int channelCount = 1;
  public int pcmEncoding = 2;
  public int sampleRate = 44100;
  
  public AudioInfo() {}
  
  public AudioInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.sampleRate = paramInt1;
    this.channelCount = paramInt2;
    this.pcmEncoding = paramInt3;
  }
  
  public AudioInfo clone()
  {
    return new AudioInfo(this.sampleRate, this.channelCount, this.pcmEncoding);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioInfo{sampleRate=");
    localStringBuilder.append(this.sampleRate);
    localStringBuilder.append(", channelCount=");
    localStringBuilder.append(this.channelCount);
    localStringBuilder.append(", pcmEncoding=");
    localStringBuilder.append(this.pcmEncoding);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioInfo
 * JD-Core Version:    0.7.0.1
 */