package com.tencent.richframework.text.rich.parser;

import android.graphics.drawable.Drawable;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.event.RichTextPreloadEvent;

class RichTextEmojiParser$1
  implements RichTextEmojiParser.OnDrawableListener
{
  RichTextEmojiParser$1(RichTextEmojiParser paramRichTextEmojiParser, RichTextPreloadParserInfo paramRichTextPreloadParserInfo) {}
  
  public void a(Drawable paramDrawable)
  {
    RFWPreloadParseRichTextHelper.a().a(this.a.c());
    SimpleEventBus.getInstance().dispatchEvent(new RichTextPreloadEvent(1, this.a.b(), this.a.c()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.parser.RichTextEmojiParser.1
 * JD-Core Version:    0.7.0.1
 */