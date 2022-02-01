package com.tencent.mobileqq.guild.util;

import android.text.Spannable;
import androidx.emoji.text.EmojiSpan;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;

class QQGuildTextUtils$SpanPair
{
  public final int a;
  public final int b;
  public final int c;
  
  QQGuildTextUtils$SpanPair(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public static SpanPair a(Spannable paramSpannable, Object paramObject)
  {
    int j = paramSpannable.getSpanEnd(paramObject);
    int k = paramSpannable.getSpanStart(paramObject);
    boolean bool = paramObject instanceof EmoticonSpan;
    int i = 1;
    if (bool) {
      QLog.d("QQGuildTextUtils", 4, new Object[] { "SpanPair.from EmoticonSpan: type: ", Integer.valueOf(((EmoticonSpan)paramObject).emojiType), " start: ", Integer.valueOf(k), " end: ", Integer.valueOf(j) });
    }
    if ((paramObject instanceof EmojiSpan)) {
      i = 0;
    }
    return new SpanPair(k, j, i);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SpanPair{start=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", end=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildTextUtils.SpanPair
 * JD-Core Version:    0.7.0.1
 */