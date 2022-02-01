package com.tencent.richframework.text.rich.parser;

import android.text.Spannable;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;

class RFWPreloadParseRichTextHelper$2
  implements Runnable
{
  RFWPreloadParseRichTextHelper$2(RFWPreloadParseRichTextHelper paramRFWPreloadParseRichTextHelper, RichTextPreloadParserInfo paramRichTextPreloadParserInfo, RichTextPreloadConfig paramRichTextPreloadConfig) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = RFWParseRichTextManager.a((RichTextPreloadParserInfo)localObject, this.b);
    if (localObject != null) {
      this.this$0.a(this.a.c(), (Spannable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.parser.RFWPreloadParseRichTextHelper.2
 * JD-Core Version:    0.7.0.1
 */