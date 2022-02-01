package com.tencent.weseevideo.editor.sticker.music;

import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Sentence;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/editor/sticker/music/WSLyricSticker$LyricWrapper;", "", "lyric", "Lcom/tencent/weseevideo/editor/sticker/music/lyric/data/Lyric;", "startTime", "", "(Lcom/tencent/weseevideo/editor/sticker/music/lyric/data/Lyric;I)V", "endTime", "", "getEndTime", "()J", "getLyric", "()Lcom/tencent/weseevideo/editor/sticker/music/lyric/data/Lyric;", "mCurrentSentence", "Lcom/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence;", "getStartTime", "()I", "setStartTime", "(I)V", "getCurrentSentence", "position", "libtavcut_debug"}, k=1, mv={1, 1, 16})
final class WSLyricSticker$LyricWrapper
{
  @Nullable
  private final Lyric lyric;
  private Sentence mCurrentSentence;
  private int startTime;
  
  public WSLyricSticker$LyricWrapper(@Nullable Lyric paramLyric, int paramInt)
  {
    this.lyric = paramLyric;
    this.startTime = paramInt;
  }
  
  @Nullable
  public final Sentence getCurrentSentence(long paramLong)
  {
    int i = (int)(paramLong + this.startTime);
    Object localObject = this.mCurrentSentence;
    long l1 = 0L;
    if (localObject != null) {
      paramLong = ((Sentence)localObject).mStartTime + ((Sentence)localObject).mDuration;
    } else {
      paramLong = 0L;
    }
    localObject = this.mCurrentSentence;
    if (localObject != null) {
      l1 = ((Sentence)localObject).mStartTime;
    }
    long l2 = i;
    if ((l1 < l2) && (l2 < paramLong)) {
      return this.mCurrentSentence;
    }
    localObject = this.lyric;
    if (localObject != null) {
      i = ((Lyric)localObject).findLineNo(i);
    } else {
      i = -1;
    }
    if (i == -1) {
      return null;
    }
    localObject = this.lyric;
    if (localObject != null)
    {
      localObject = ((Lyric)localObject).getSentenceList();
      if (localObject != null)
      {
        localObject = (Sentence)((List)localObject).get(i);
        if (localObject != null)
        {
          this.mCurrentSentence = ((Sentence)localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  public final long getEndTime()
  {
    Object localObject = this.lyric;
    if (localObject != null)
    {
      localObject = ((Lyric)localObject).getSentenceList();
      if (localObject != null)
      {
        localObject = (Sentence)CollectionsKt.lastOrNull((List)localObject);
        break label31;
      }
    }
    localObject = null;
    label31:
    if (localObject != null) {
      return ((Sentence)localObject).mStartTime + ((Sentence)localObject).mDuration;
    }
    return 0L;
  }
  
  @Nullable
  public final Lyric getLyric()
  {
    return this.lyric;
  }
  
  public final int getStartTime()
  {
    return this.startTime;
  }
  
  public final void setStartTime(int paramInt)
  {
    this.startTime = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.WSLyricSticker.LyricWrapper
 * JD-Core Version:    0.7.0.1
 */