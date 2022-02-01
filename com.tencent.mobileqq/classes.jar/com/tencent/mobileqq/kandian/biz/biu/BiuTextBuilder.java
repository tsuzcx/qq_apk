package com.tencent.mobileqq.kandian.biz.biu;

import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.EmoticonSpan;

public class BiuTextBuilder
  extends QQTextBuilder
{
  public BiuTextBuilder(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
  }
  
  public int a()
  {
    int j = super.length();
    int i = 0;
    EmoticonSpan[] arrayOfEmoticonSpan = (EmoticonSpan[])getSpans(0, j, EmoticonSpan.class);
    if ((arrayOfEmoticonSpan != null) && (arrayOfEmoticonSpan.length > 0))
    {
      int k = arrayOfEmoticonSpan.length;
      j = 0;
      while (i < k)
      {
        EmoticonSpan localEmoticonSpan = arrayOfEmoticonSpan[i];
        int m = localEmoticonSpan.emojiType;
        if ((m == 0) || (m == 1) || (m == 2))
        {
          m = getSpanStart(localEmoticonSpan);
          j += getSpanEnd(localEmoticonSpan) - m - 1;
        }
        i += 1;
      }
      return super.length() - j;
    }
    return super.length();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.BiuTextBuilder
 * JD-Core Version:    0.7.0.1
 */