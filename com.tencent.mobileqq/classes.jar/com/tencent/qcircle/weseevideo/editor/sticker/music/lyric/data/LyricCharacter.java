package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data;

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
    StringBuilder localStringBuilder1 = new StringBuilder("LyricCharacter -> ");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mStartTime:");
    localStringBuilder2.append(this.mStartTime);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mDuration:");
    localStringBuilder2.append(this.mDuration);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mStart:");
    localStringBuilder2.append(this.mStart);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", mEnd:");
    localStringBuilder2.append(this.mEnd);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.LyricCharacter
 * JD-Core Version:    0.7.0.1
 */