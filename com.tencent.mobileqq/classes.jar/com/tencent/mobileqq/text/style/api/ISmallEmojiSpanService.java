package com.tencent.mobileqq.text.style.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.text.style.ISmallEmojiSpan;

@QAPI(process={"all"})
public abstract interface ISmallEmojiSpanService
  extends QRouteApi
{
  public abstract ISmallEmojiSpan createSmallEmojiSpan(char[] paramArrayOfChar, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.api.ISmallEmojiSpanService
 * JD-Core Version:    0.7.0.1
 */