package com.tencent.mobileqq.wink.editor.music.lyric;

public class WinkLyricProgressCalculator
{
  private long a;
  private long b;
  private long c;
  private long d;
  private long e;
  
  public static WinkLyricProgressCalculator a()
  {
    return WinkLyricProgressCalculator.InstanceHolder.a;
  }
  
  public long a(long paramLong, boolean paramBoolean)
  {
    this.a = paramLong;
    paramLong = this.e;
    long l;
    if (paramLong >= this.b) {
      l = this.c;
    }
    for (paramLong = this.a;; paramLong = this.a)
    {
      return l + paramLong;
      if (paramBoolean) {
        return this.c + this.a % paramLong;
      }
      l = this.c;
    }
  }
  
  public long a(boolean paramBoolean)
  {
    return a(this.a, paramBoolean);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = (paramLong2 - paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.WinkLyricProgressCalculator
 * JD-Core Version:    0.7.0.1
 */