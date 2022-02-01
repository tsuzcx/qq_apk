package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;

class HtmlChangeUtil$SpanBuilder
{
  int a;
  private int b;
  private int c;
  
  public static SpanBuilder a(int paramInt, Object... paramVarArgs)
  {
    SpanBuilder localSpanBuilder = new SpanBuilder();
    localSpanBuilder.a = paramInt;
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 4) {
        return localSpanBuilder;
      }
      localSpanBuilder.c = ((Integer)paramVarArgs[0]).intValue();
      return localSpanBuilder;
    }
    localSpanBuilder.b = ((Integer)paramVarArgs[0]).intValue();
    return localSpanBuilder;
  }
  
  public Object a()
  {
    int i = this.a;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return null;
            }
            return new StrikethroughSpan();
          }
          return new StyleSpan(this.c);
        }
        return new UnderlineSpan();
      }
      return new ForegroundColorSpan(this.b);
    }
    return new HtmlChangeUtil.MyBackgroundColorSpan(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.HtmlChangeUtil.SpanBuilder
 * JD-Core Version:    0.7.0.1
 */