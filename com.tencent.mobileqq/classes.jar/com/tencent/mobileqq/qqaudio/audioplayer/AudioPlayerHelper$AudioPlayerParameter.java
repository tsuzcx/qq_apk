package com.tencent.mobileqq.qqaudio.audioplayer;

public class AudioPlayerHelper$AudioPlayerParameter
{
  public int a;
  public int b;
  public boolean c;
  
  public AudioPlayerHelper$AudioPlayerParameter(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.b = paramInt1;
    this.a = paramInt2;
    this.c = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if ((paramObject instanceof AudioPlayerParameter))
    {
      paramObject = (AudioPlayerParameter)paramObject;
      return (paramObject.b == this.b) && (paramObject.a == this.a) && (paramObject.c == this.c);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerHelper.AudioPlayerParameter
 * JD-Core Version:    0.7.0.1
 */