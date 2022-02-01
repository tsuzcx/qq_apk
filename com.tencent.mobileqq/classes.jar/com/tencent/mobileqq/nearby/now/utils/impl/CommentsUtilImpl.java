package com.tencent.mobileqq.nearby.now.utils.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.utils.CommentsUtil;
import com.tencent.mobileqq.nearby.now.utils.ICommentsUtil;

public class CommentsUtilImpl
  implements ICommentsUtil
{
  public CharSequence clip(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return CommentsUtil.a(paramCharSequence, paramInt1, paramInt2);
  }
  
  public String encode16(byte[] paramArrayOfByte)
  {
    return CommentsUtil.a(paramArrayOfByte);
  }
  
  public String formatNumber(long paramLong)
  {
    return CommentsUtil.c(paramLong);
  }
  
  public String formatSimpleDateTime(long paramLong)
  {
    return CommentsUtil.b(paramLong);
  }
  
  public String formatWatchNumber(long paramLong)
  {
    return CommentsUtil.d(paramLong);
  }
  
  public int getChinese(String paramString)
  {
    return CommentsUtil.a(paramString);
  }
  
  public int getLength(CharSequence paramCharSequence)
  {
    return CommentsUtil.a(paramCharSequence);
  }
  
  public boolean isSingleWord(char paramChar)
  {
    return CommentsUtil.a(paramChar);
  }
  
  public void reportClickEvent(AppInterface paramAppInterface, String paramString)
  {
    CommentsUtil.a((QQAppInterface)paramAppInterface, paramString);
  }
  
  public void reportClickEvent(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    CommentsUtil.a((QQAppInterface)paramAppInterface, paramString1, paramString2);
  }
  
  public void reportClickEvent(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    CommentsUtil.a((QQAppInterface)paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public String simpleFormatTime(long paramLong)
  {
    return CommentsUtil.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.impl.CommentsUtilImpl
 * JD-Core Version:    0.7.0.1
 */