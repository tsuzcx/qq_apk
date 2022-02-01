package com.tencent.mobileqq.nearby.now.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ICommentsUtil
  extends QRouteApi
{
  public abstract CharSequence clip(CharSequence paramCharSequence, int paramInt1, int paramInt2);
  
  public abstract String encode16(byte[] paramArrayOfByte);
  
  public abstract String formatNumber(long paramLong);
  
  public abstract String formatSimpleDateTime(long paramLong);
  
  public abstract String formatWatchNumber(long paramLong);
  
  public abstract int getChinese(String paramString);
  
  public abstract int getLength(CharSequence paramCharSequence);
  
  public abstract boolean isSingleWord(char paramChar);
  
  public abstract void reportClickEvent(AppInterface paramAppInterface, String paramString);
  
  public abstract void reportClickEvent(AppInterface paramAppInterface, String paramString1, String paramString2);
  
  public abstract void reportClickEvent(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract String simpleFormatTime(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.ICommentsUtil
 * JD-Core Version:    0.7.0.1
 */