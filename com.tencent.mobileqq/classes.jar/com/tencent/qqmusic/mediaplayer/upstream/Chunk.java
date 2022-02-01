package com.tencent.qqmusic.mediaplayer.upstream;

public class Chunk
{
  public final int bufferSize;
  public final long size;
  public final long start;
  
  public Chunk(int paramInt, long paramLong1, long paramLong2)
  {
    this.bufferSize = paramInt;
    this.start = paramLong1;
    this.size = paramLong2;
  }
  
  public boolean contains(long paramLong)
  {
    if (isEndless()) {
      return paramLong >= this.start;
    }
    long l = this.start;
    return (paramLong >= l) && (paramLong <= l + this.size);
  }
  
  public boolean isEndless()
  {
    return this.size == -1L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Chunk{bufferSize=");
    localStringBuilder.append(this.bufferSize);
    localStringBuilder.append(", start=");
    localStringBuilder.append(this.start);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.size);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.Chunk
 * JD-Core Version:    0.7.0.1
 */