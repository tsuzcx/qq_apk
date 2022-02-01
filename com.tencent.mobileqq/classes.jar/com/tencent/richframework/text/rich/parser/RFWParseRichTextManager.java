package com.tencent.richframework.text.rich.parser;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RFWParseRichTextManager
{
  private static final List<ParseRuleStrategyInterface> a = new ArrayList();
  
  static
  {
    a.add(new RichTextEmojiParser());
    a.add(new RichTextAtParser());
    a.add(new RichTextHashTagParser());
  }
  
  public static Spannable a(RichTextPreloadParserInfo paramRichTextPreloadParserInfo, RichTextPreloadConfig paramRichTextPreloadConfig)
  {
    if ((paramRichTextPreloadParserInfo != null) && (paramRichTextPreloadParserInfo.a() != null) && (!TextUtils.isEmpty(paramRichTextPreloadParserInfo.a().toString())))
    {
      RichTextPreloadConfig localRichTextPreloadConfig = paramRichTextPreloadConfig;
      if (paramRichTextPreloadConfig == null) {
        localRichTextPreloadConfig = new RichTextPreloadConfig();
      }
      if ((paramRichTextPreloadParserInfo.a() instanceof SpannableStringBuilder)) {
        paramRichTextPreloadConfig = (SpannableStringBuilder)paramRichTextPreloadParserInfo.a();
      } else {
        paramRichTextPreloadConfig = new SpannableStringBuilder(paramRichTextPreloadParserInfo.a());
      }
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        ((ParseRuleStrategyInterface)localIterator.next()).a(paramRichTextPreloadConfig, paramRichTextPreloadParserInfo, localRichTextPreloadConfig);
      }
      return a(paramRichTextPreloadConfig);
    }
    return null;
  }
  
  protected static QQText a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    return new QQText(paramSpannableStringBuilder, 3, 16);
  }
  
  public static RichTextHashTagParser a()
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      ParseRuleStrategyInterface localParseRuleStrategyInterface = (ParseRuleStrategyInterface)localIterator.next();
      if ((localParseRuleStrategyInterface instanceof RichTextHashTagParser)) {
        return (RichTextHashTagParser)localParseRuleStrategyInterface;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.parser.RFWParseRichTextManager
 * JD-Core Version:    0.7.0.1
 */