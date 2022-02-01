package com.tencent.richframework.text.rich.parser;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.biz.qqcircle.richframework.widget.VerticalCenterImageSpan;
import com.tencent.biz.richframework.AutoShadowPluginRuntime;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig.TextImageSpanConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RichTextEmojiParser
  implements ParseRuleStrategyInterface
{
  public static final Pattern a = Pattern.compile("\\{img:(.*?),w:(\\d+),h:(\\d+)\\}");
  private static ConcurrentHashMap<String, Drawable> b = new ConcurrentHashMap();
  
  private SpannableStringBuilder a(SpannableStringBuilder paramSpannableStringBuilder, RichTextPreloadConfig.TextImageSpanConfig paramTextImageSpanConfig, RichTextEmojiParser.OnDrawableListener paramOnDrawableListener)
  {
    a(paramTextImageSpanConfig, paramSpannableStringBuilder, paramOnDrawableListener);
    paramTextImageSpanConfig.a(paramTextImageSpanConfig.a() + ViewUtils.dip2px(4.0F));
    b(paramTextImageSpanConfig, paramSpannableStringBuilder, paramOnDrawableListener);
    return paramSpannableStringBuilder;
  }
  
  private static VerticalCenterImageSpan a(RichTextPreloadConfig.TextImageSpanConfig paramTextImageSpanConfig, Drawable paramDrawable)
  {
    int i = (int)paramTextImageSpanConfig.a();
    Rect localRect = new Rect(0, 0, i, i);
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(localRect);
      return new VerticalCenterImageSpan(paramDrawable, paramTextImageSpanConfig.b());
    }
    return null;
  }
  
  public static void a(RichTextPreloadConfig.TextImageSpanConfig paramTextImageSpanConfig, SpannableStringBuilder paramSpannableStringBuilder, RichTextEmojiParser.OnDrawableListener paramOnDrawableListener)
  {
    if (paramSpannableStringBuilder == null) {
      return;
    }
    Matcher localMatcher = Patterns.k.matcher(paramSpannableStringBuilder);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      if ((j <= paramSpannableStringBuilder.length()) && (i <= j) && (i >= 0))
      {
        for (;;)
        {
          try
          {
            localObject2 = paramSpannableStringBuilder.subSequence(i, j).toString();
            localObject1 = null;
            if (b.containsKey(localObject2)) {
              localObject1 = (Drawable)b.get(localObject2);
            }
            if (localObject1 == null)
            {
              localObject1 = HostEmotionUtil.getEmoDrawableFromEMCode((String)localObject2);
              if (localObject1 != null)
              {
                b(paramTextImageSpanConfig, paramSpannableStringBuilder, i, j, (Drawable)localObject1, true, (String)localObject2);
                break;
              }
              int k = ((String)localObject2).indexOf(HostEmotionUtil.EMO_PREFIX()) + HostEmotionUtil.EMO_PREFIX().length();
              int m = ((String)localObject2).indexOf(HostEmotionUtil.EMO_TAIL());
              if (k != -1)
              {
                if (m == -1) {
                  return;
                }
                str = ((String)localObject2).substring(k, m);
              }
            }
          }
          catch (Exception localException1)
          {
            Object localObject1;
            String str;
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(" e = ");
            ((StringBuilder)localObject2).append(localException1.getMessage());
            QLog.e("RichTextEmojiParser", 1, ((StringBuilder)localObject2).toString());
          }
          try
          {
            localObject1 = HostEmotionUtil.getEmoUrlFromConfig(str);
          }
          catch (Exception localException2)
          {
            continue;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HostEmotionUtil.SIGN_ICON_URL_PREFIX());
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(HostEmotionUtil.SIGN_ICON_URL_END());
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        b(paramTextImageSpanConfig, paramSpannableStringBuilder, i, j, RFApplication.getApplication().getResources().getDrawable(2130851587), false, (String)localObject2);
        localObject1 = new Option().setUrl((String)localObject1);
        QCircleFeedPicLoader.g().loadImage((Option)localObject1, new RichTextEmojiParser.2(paramTextImageSpanConfig, paramSpannableStringBuilder, i, j, (String)localObject2, paramOnDrawableListener));
        continue;
        return;
        b(paramTextImageSpanConfig, paramSpannableStringBuilder, i, j, (Drawable)localObject1, true, (String)localObject2);
      }
      else
      {
        QLog.e("RichTextEmojiParser", 1, "ArrayIndexOutOfBounds  end > spannable.length() || start > end || start < 0");
      }
    }
  }
  
  private static boolean a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramSpannableStringBuilder == null) {
      return false;
    }
    int i = paramSpannableStringBuilder.length();
    if (paramInt1 <= i)
    {
      if (paramInt2 > i) {
        return false;
      }
      if ((paramInt1 >= 0) && (paramInt2 >= 0)) {
        return paramInt1 <= paramInt2;
      }
    }
    return false;
  }
  
  private static void b(RichTextPreloadConfig.TextImageSpanConfig paramTextImageSpanConfig, SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, Drawable paramDrawable, boolean paramBoolean, String paramString)
  {
    if (paramDrawable != null)
    {
      if (paramBoolean) {}
      try
      {
        b.put(paramString, paramDrawable);
        paramTextImageSpanConfig = a(paramTextImageSpanConfig, paramDrawable);
        if ((paramTextImageSpanConfig != null) && (a(paramSpannableStringBuilder, paramInt1, paramInt2)))
        {
          paramSpannableStringBuilder.setSpan(paramTextImageSpanConfig, paramInt1, paramInt2, 33);
          return;
        }
      }
      catch (Exception paramTextImageSpanConfig)
      {
        QLog.d("RichTextEmojiParser", 4, paramTextImageSpanConfig.getMessage());
      }
    }
  }
  
  private void b(RichTextPreloadConfig.TextImageSpanConfig paramTextImageSpanConfig, SpannableStringBuilder paramSpannableStringBuilder, RichTextEmojiParser.OnDrawableListener paramOnDrawableListener)
  {
    if (TextUtils.isEmpty(paramSpannableStringBuilder)) {
      return;
    }
    Matcher localMatcher = a.matcher(paramSpannableStringBuilder);
    try
    {
      while (localMatcher.find())
      {
        String str1 = localMatcher.group(1);
        if (str1.startsWith("https://qzonestyle.gtimg.cn/"))
        {
          String str3 = localMatcher.group(2);
          String str4 = localMatcher.group(3);
          int i = localMatcher.start();
          int j = localMatcher.end();
          String str2 = paramSpannableStringBuilder.subSequence(i, j).toString();
          Object localObject = null;
          if (b.containsKey(str2)) {
            localObject = (Drawable)b.get(str2);
          }
          if (localObject == null)
          {
            b(paramTextImageSpanConfig, paramSpannableStringBuilder, i, j, AutoShadowPluginRuntime.a().b().getResources().getDrawable(2130851587), false, str2);
            localObject = new Option();
            try
            {
              int k = Integer.parseInt(str4);
              int m = Integer.parseInt(str3);
              if ((k > 0) && (m > 0))
              {
                ((Option)localObject).setRequestHeight(k);
                ((Option)localObject).setRequestWidth(m);
              }
            }
            catch (Exception localException)
            {
              QLog.e("RichTextEmojiParser", 1, localException, new Object[0]);
            }
            ((Option)localObject).setUrl(str1);
            QCircleFeedPicLoader.g().loadImage((Option)localObject, new RichTextEmojiParser.3(this, paramTextImageSpanConfig, paramSpannableStringBuilder, i, j, str2, paramOnDrawableListener));
          }
          else
          {
            b(paramTextImageSpanConfig, paramSpannableStringBuilder, i, j, (Drawable)localObject, true, str2);
          }
        }
      }
      return;
    }
    catch (Exception paramTextImageSpanConfig)
    {
      paramTextImageSpanConfig.printStackTrace();
    }
  }
  
  public void a(SpannableStringBuilder paramSpannableStringBuilder, RichTextPreloadParserInfo paramRichTextPreloadParserInfo, RichTextPreloadConfig paramRichTextPreloadConfig)
  {
    if ((paramSpannableStringBuilder != null) && (paramRichTextPreloadParserInfo != null) && (paramRichTextPreloadConfig != null))
    {
      if (paramRichTextPreloadConfig.a() == null) {
        return;
      }
      a(paramSpannableStringBuilder, paramRichTextPreloadConfig.a(), new RichTextEmojiParser.1(this, paramRichTextPreloadParserInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.parser.RichTextEmojiParser
 * JD-Core Version:    0.7.0.1
 */