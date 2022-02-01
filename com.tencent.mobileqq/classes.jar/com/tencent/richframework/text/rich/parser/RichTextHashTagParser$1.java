package com.tencent.richframework.text.rich.parser;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.richframework.text.rich.event.RichTextPreloadEvent;
import com.tencent.richframework.text.rich.span.BoldClickableSpan.OnClickBoldTextListener;

class RichTextHashTagParser$1
  implements BoldClickableSpan.OnClickBoldTextListener
{
  RichTextHashTagParser$1(RichTextHashTagParser paramRichTextHashTagParser) {}
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof RichTextPreloadEvent)) {
      return;
    }
    SimpleEventBus.getInstance().dispatchEvent((RichTextPreloadEvent)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.parser.RichTextHashTagParser.1
 * JD-Core Version:    0.7.0.1
 */