package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser;

import android.support.annotation.NonNull;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric;

public abstract interface IParser
{
  public abstract void init(@NonNull String paramString);
  
  public abstract Lyric parse();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.IParser
 * JD-Core Version:    0.7.0.1
 */