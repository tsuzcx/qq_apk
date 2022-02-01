package com.tencent.weseevideo.editor.sticker.music.lyric.data;

public class LyricCharacter
{
  public final long mDuration;
  public final int mEnd;
  public final int mStart;
  public final long mStartTime;
  
  public LyricCharacter(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this.mStartTime = paramLong1;
    this.mDuration = paramLong2;
    this.mStart = paramInt1;
    this.mEnd = paramInt2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LyricCharacter -> ");
    localStringBuilder.append("mStartTime:" + this.mStartTime);
    localStringBuilder.append(", mDuration:" + this.mDuration);
    localStringBuilder.append(", mStart:" + this.mStart);
    localStringBuilder.append(", mEnd:" + this.mEnd);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.lyric.data.LyricCharacter
 * JD-Core Version:    0.7.0.1
 */