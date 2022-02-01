package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider;

import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.IParser;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.LrcParserWEmptyLine;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.QrcNoDecryptParserWEmptyLine;

public class WEmptyLineProvider
  implements IParserProvider
{
  public static WEmptyLineProvider getInstance()
  {
    return WEmptyLineProvider.InstanceHolder.INSTANCE;
  }
  
  public IParser createLrcParser()
  {
    return new LrcParserWEmptyLine();
  }
  
  public IParser createQrcParser()
  {
    return new QrcNoDecryptParserWEmptyLine();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider.WEmptyLineProvider
 * JD-Core Version:    0.7.0.1
 */