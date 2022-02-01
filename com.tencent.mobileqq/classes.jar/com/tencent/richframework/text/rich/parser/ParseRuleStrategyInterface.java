package com.tencent.richframework.text.rich.parser;

import android.text.SpannableStringBuilder;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;

public abstract interface ParseRuleStrategyInterface
{
  public abstract void a(SpannableStringBuilder paramSpannableStringBuilder, RichTextPreloadParserInfo paramRichTextPreloadParserInfo, RichTextPreloadConfig paramRichTextPreloadConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.parser.ParseRuleStrategyInterface
 * JD-Core Version:    0.7.0.1
 */