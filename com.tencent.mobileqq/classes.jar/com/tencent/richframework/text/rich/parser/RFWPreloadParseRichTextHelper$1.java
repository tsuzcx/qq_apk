package com.tencent.richframework.text.rich.parser;

import android.text.Spannable;
import android.util.LruCache;

class RFWPreloadParseRichTextHelper$1
  extends LruCache<String, Spannable>
{
  RFWPreloadParseRichTextHelper$1(RFWPreloadParseRichTextHelper paramRFWPreloadParseRichTextHelper, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, Spannable paramSpannable)
  {
    return paramSpannable.length() * 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.parser.RFWPreloadParseRichTextHelper.1
 * JD-Core Version:    0.7.0.1
 */