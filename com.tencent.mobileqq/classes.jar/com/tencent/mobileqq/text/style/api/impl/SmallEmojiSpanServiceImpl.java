package com.tencent.mobileqq.text.style.api.impl;

import com.tencent.mobileqq.text.style.ISmallEmojiSpan;
import com.tencent.mobileqq.text.style.SmallEmojiSpan;
import com.tencent.mobileqq.text.style.api.ISmallEmojiSpanService;

public class SmallEmojiSpanServiceImpl
  implements ISmallEmojiSpanService
{
  public ISmallEmojiSpan createSmallEmojiSpan(char[] paramArrayOfChar, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new SmallEmojiSpan(paramArrayOfChar, paramInt, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.api.impl.SmallEmojiSpanServiceImpl
 * JD-Core Version:    0.7.0.1
 */