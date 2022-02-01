package com.tencent.richframework.text.rich.parser;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RFWFriend;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig.TextAtConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.event.RichTextPreloadEvent;
import com.tencent.richframework.text.rich.span.BoldClickableSpan;
import com.tencent.richframework.text.rich.span.BoldClickableSpan.OnClickBoldTextListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RichTextAtParser
  implements ParseRuleStrategyInterface
{
  public static final Pattern a = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");
  private BoldClickableSpan.OnClickBoldTextListener b;
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    Matcher localMatcher = a.matcher(paramString);
    int i = 0;
    try
    {
      while (localMatcher.find())
      {
        int j = localMatcher.start();
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        String str2 = str1.substring(str1.indexOf(",nick:") + 6, str1.length() - 1).replace("%25", "%").replace("%2C", ",").replace("%7D", "}").replace("%7B", "{").replace("%3A", ":").replace("%3E", ">");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("@");
        localStringBuilder.append(str2);
        str2 = localStringBuilder.toString();
        paramString.replace(j - i, k - i, str2);
        j = str1.length();
        k = str2.length();
        i += j - k;
      }
      return paramString.toString();
    }
    catch (Exception localException)
    {
      QLog.e("RichTextAtParser", 1, localException, new Object[0]);
    }
  }
  
  private void a()
  {
    if (this.b == null) {
      this.b = new RichTextAtParser.1(this);
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
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, RichTextPreloadConfig.TextAtConfig paramTextAtConfig, RichTextPreloadParserInfo paramRichTextPreloadParserInfo)
  {
    if (TextUtils.isEmpty(paramSpannableStringBuilder)) {
      return;
    }
    Matcher localMatcher = a.matcher(paramSpannableStringBuilder);
    int i = 0;
    try
    {
      for (;;)
      {
        if (localMatcher.find())
        {
          int j = localMatcher.start() - i;
          int k = localMatcher.end();
          Object localObject1 = localMatcher.group();
          int m = ((String)localObject1).indexOf("uin:");
          int n = ((String)localObject1).indexOf(",nick:");
          String str = ((String)localObject1).substring(m + 4, n);
          Object localObject3 = ((String)localObject1).substring(n + 6, ((String)localObject1).length() - 1).replace("%25", "%").replace("%2C", ",").replace("%7D", "}").replace("%7B", "{").replace("%3A", ":").replace("%3E", ">");
          Object localObject2 = new RFWFriend();
          ((RFWFriend)localObject2).a = Long.parseLong(str);
          ((RFWFriend)localObject2).b = ((String)localObject3);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("@");
          ((StringBuilder)localObject3).append(((RFWFriend)localObject2).b);
          localObject2 = ((StringBuilder)localObject3).toString();
          paramSpannableStringBuilder.replace(j, k - i, (CharSequence)localObject2);
          k = ((String)localObject1).length();
          m = ((String)localObject2).length();
          n = j + ((String)localObject2).length();
          if (n == paramSpannableStringBuilder.length()) {
            paramSpannableStringBuilder.append(" ");
          }
          a();
          localObject1 = new RichTextPreloadEvent(2, paramRichTextPreloadParserInfo.b(), paramRichTextPreloadParserInfo.c());
          ((RichTextPreloadEvent)localObject1).uin = str;
          try
          {
            a(paramSpannableStringBuilder, j, n, this.b, paramTextAtConfig.a(), paramTextAtConfig.b(), (RichTextPreloadEvent)localObject1);
            i += k - m;
          }
          catch (Exception paramSpannableStringBuilder)
          {
            break label330;
          }
        }
      }
      return;
    }
    catch (Exception paramSpannableStringBuilder)
    {
      label330:
      QLog.e("RichTextAtParser", 1, paramSpannableStringBuilder, new Object[0]);
    }
  }
  
  public void a(SpannableStringBuilder paramSpannableStringBuilder, RichTextPreloadParserInfo paramRichTextPreloadParserInfo, RichTextPreloadConfig paramRichTextPreloadConfig)
  {
    if ((paramSpannableStringBuilder != null) && (paramRichTextPreloadParserInfo != null) && (paramRichTextPreloadConfig != null))
    {
      if (paramRichTextPreloadConfig.b() == null) {
        return;
      }
      a(paramSpannableStringBuilder, paramRichTextPreloadConfig.b(), paramRichTextPreloadParserInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.parser.RichTextAtParser
 * JD-Core Version:    0.7.0.1
 */