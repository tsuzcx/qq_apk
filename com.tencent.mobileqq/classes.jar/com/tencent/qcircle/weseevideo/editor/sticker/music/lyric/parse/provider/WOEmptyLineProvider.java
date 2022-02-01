package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider;

import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.IParser;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.LrcParserWOEmptyLine;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.QrcNoDecryptParserWOEmptyLine;

public class WOEmptyLineProvider
  implements IParserProvider
{
  public static WOEmptyLineProvider getInstance()
  {
    return WOEmptyLineProvider.InstanceHolder.INSTANCE;
  }
  
  public IParser createLrcParser()
  {
    return new LrcParserWOEmptyLine();
  }
  
  public IParser createQrcParser()
  {
    return new QrcNoDecryptParserWOEmptyLine();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider.WOEmptyLineProvider
 * JD-Core Version:    0.7.0.1
 */