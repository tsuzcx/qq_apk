package com.tencent.richframework.text.rich.parser;

import android.os.Handler;
import android.text.Spannable;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;

public class RFWPreloadParseRichTextHelper
{
  private static volatile RFWPreloadParseRichTextHelper a;
  private LruCache<String, Spannable> b = new RFWPreloadParseRichTextHelper.1(this, 2097152);
  
  public static RFWPreloadParseRichTextHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new RFWPreloadParseRichTextHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(RichTextPreloadParserInfo paramRichTextPreloadParserInfo, RichTextPreloadConfig paramRichTextPreloadConfig)
  {
    RFThreadManager.getSerialThreadHandler().post(new RFWPreloadParseRichTextHelper.2(this, paramRichTextPreloadParserInfo, paramRichTextPreloadConfig));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.b.remove(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeCachePool  key = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" , mCachePool.size = ");
    localStringBuilder.append(this.b.size());
    localStringBuilder.append(" , ThreadName = ");
    localStringBuilder.append(Thread.currentThread().getName());
    QLog.i("RFWPreloadParseRichTextHelper", 1, localStringBuilder.toString());
  }
  
  public void a(String paramString, Spannable paramSpannable)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (TextUtils.isEmpty(paramSpannable)) {
        return;
      }
      this.b.put(paramString, paramSpannable);
      paramSpannable = new StringBuilder();
      paramSpannable.append("putCachePool  key = ");
      paramSpannable.append(paramString);
      paramSpannable.append(" , mCachePool.size = ");
      paramSpannable.append(this.b.size());
      paramSpannable.append(" , ThreadName = ");
      paramSpannable.append(Thread.currentThread().getName());
      QLog.i("RFWPreloadParseRichTextHelper", 1, paramSpannable.toString());
    }
  }
  
  public Spannable b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (Spannable)this.b.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.parser.RFWPreloadParseRichTextHelper
 * JD-Core Version:    0.7.0.1
 */