package com.tencent.richframework.text.rich.parser;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig.TextHashTagConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.event.RichTextPreloadEvent;
import com.tencent.richframework.text.rich.span.BoldClickableSpan;
import com.tencent.richframework.text.rich.span.BoldClickableSpan.OnClickBoldTextListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RichTextHashTagParser
  implements ParseRuleStrategyInterface
{
  public static final Pattern a = Pattern.compile("#?\\{tagName=.*?\\}");
  private BoldClickableSpan.OnClickBoldTextListener b;
  
  private void a()
  {
    if (this.b == null) {
      this.b = new RichTextHashTagParser.1(this);
    }
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, BoldClickableSpan.OnClickBoldTextListener paramOnClickBoldTextListener, int paramInt3, boolean paramBoolean, RichTextPreloadEvent paramRichTextPreloadEvent)
  {
    if ((!TextUtils.isEmpty(paramSpannableStringBuilder)) && (paramInt2 >= paramInt1))
    {
      if (paramSpannableStringBuilder.length() < paramInt2) {
        return;
      }
      paramSpannableStringBuilder.setSpan(new BoldClickableSpan(paramOnClickBoldTextListener, paramInt3, paramBoolean, paramRichTextPreloadEvent), paramInt1, paramInt2, 33);
    }
  }
  
  public ArrayList<String> a(SpannableStringBuilder paramSpannableStringBuilder, RichTextPreloadConfig.TextHashTagConfig paramTextHashTagConfig, RichTextPreloadParserInfo paramRichTextPreloadParserInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramSpannableStringBuilder)) {
      return localArrayList;
    }
    Matcher localMatcher = a.matcher(paramSpannableStringBuilder);
    int i = 0;
    label358:
    for (;;)
    {
      try
      {
        if (localMatcher.find())
        {
          int m = localMatcher.start() - i;
          j = localMatcher.end();
          Object localObject1 = localMatcher.group();
          String str = ((String)localObject1).substring(((String)localObject1).indexOf("tagName=") + 8, ((String)localObject1).indexOf("}"));
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(" # ");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(" ");
          localObject2 = ((StringBuilder)localObject2).toString();
          paramSpannableStringBuilder.replace(m, j - i, (CharSequence)localObject2);
          int n = ((String)localObject1).length();
          int i1 = ((String)localObject2).length();
          int k = m + ((String)localObject2).length();
          if (k == paramSpannableStringBuilder.length())
          {
            j = 1;
            if (paramRichTextPreloadParserInfo == null) {
              break label358;
            }
            a();
            localObject1 = new RichTextPreloadEvent(3, paramRichTextPreloadParserInfo.b(), paramRichTextPreloadParserInfo.c());
            ((RichTextPreloadEvent)localObject1).tagName = str;
            a(paramSpannableStringBuilder, m, k - j, this.b, paramTextHashTagConfig.a(), paramTextHashTagConfig.b(), (RichTextPreloadEvent)localObject1);
            localArrayList.add(str);
            paramSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(ViewUtils.a(4.0F)), m, m + 1, 17);
            paramSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(ViewUtils.a(4.0F)), m + 2, m + 3, 17);
            paramSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(ViewUtils.a(4.0F)), k - 1, k, 17);
            i += n - i1;
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Exception paramSpannableStringBuilder)
      {
        QLog.e("RichTextTagParser", 1, paramSpannableStringBuilder, new Object[0]);
      }
      int j = 0;
    }
  }
  
  public void a(SpannableStringBuilder paramSpannableStringBuilder, RichTextPreloadParserInfo paramRichTextPreloadParserInfo, RichTextPreloadConfig paramRichTextPreloadConfig)
  {
    if ((paramSpannableStringBuilder != null) && (paramRichTextPreloadParserInfo != null) && (paramRichTextPreloadConfig != null))
    {
      if (paramRichTextPreloadConfig.c() == null) {
        return;
      }
      a(paramSpannableStringBuilder, paramRichTextPreloadConfig.c(), paramRichTextPreloadParserInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.parser.RichTextHashTagParser
 * JD-Core Version:    0.7.0.1
 */