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
    long l = 0L;
    Object localObject1 = null;
    int i = (int)(this.startTime + paramLong);
    Object localObject2 = this.mCurrentSentence;
    if (localObject2 != null) {
      paramLong = ((Sentence)localObject2).mStartTime;
    }
    for (paramLong = ((Sentence)localObject2).mDuration + paramLong;; paramLong = 0L)
    {
      localObject2 = this.mCurrentSentence;
      if (localObject2 != null) {
        l = ((Sentence)localObject2).mStartTime;
      }
      if ((l >= i) || (i >= paramLong)) {
        break;
      }
      localObject1 = this.mCurrentSentence;
      return localObject1;
    }
    localObject2 = this.lyric;
    if (localObject2 != null)
    {
      i = ((Lyric)localObject2).findLineNo(i);
      label105:
      if (i == -1) {
        break label163;
      }
      localObject1 = this.lyric;
      if (localObject1 == null) {
        break label165;
      }
      localObject1 = ((Lyric)localObject1).getSentenceList();
      if (localObject1 == null) {
        break label165;
      }
      localObject1 = (Sentence)((List)localObject1).get(i);
      if (localObject1 == null) {
        break label165;
      }
      this.mCurrentSentence = ((Sentence)localObject1);
    }
    for (;;)
    {
      return localObject1;
      i = -1;
      break label105;
      label163:
      break;
      label165:
      localObject1 = null;
    }
  }
  
  public final long getEndTime()
  {
    Object localObject = this.lyric;
    if (localObject != null)
    {
      localObject = ((Lyric)localObject).getSentenceList();
      if (localObject == null) {}
    }
    for (localObject = (Sentence)CollectionsKt.lastOrNull((List)localObject); localObject != null; localObject = null)
    {
      long l = ((Sentence)localObject).mStartTime;
      return ((Sentence)localObject).mDuration + l;
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