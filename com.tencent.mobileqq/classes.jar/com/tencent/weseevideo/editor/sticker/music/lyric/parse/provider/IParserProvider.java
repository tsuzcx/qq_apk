package com.tencent.weseevideo.editor.sticker.music.lyric.parse.provider;

import com.tencent.weseevideo.editor.sticker.music.lyric.parse.parser.IParser;

public abstract interface IParserProvider
{
  public abstract IParser createLrcParser();
  
  public abstract IParser createQrcParser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.lyric.parse.provider.IParserProvider
 * JD-Core Version:    0.7.0.1
 */