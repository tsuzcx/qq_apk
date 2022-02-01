package com.tencent.mobileqq.richmediabrowser.utils;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

public class LongVideoUrlCacheManager$UrlsCacheBean
{
  public String[] a;
  public long b;
  public MessageRecord c;
  public int d;
  String e;
  
  public LongVideoUrlCacheManager$UrlsCacheBean(LongVideoUrlCacheManager paramLongVideoUrlCacheManager, String[] paramArrayOfString, long paramLong, MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    this.a = paramArrayOfString;
    this.b = paramLong;
    this.c = paramMessageRecord;
    this.d = paramInt;
    this.e = paramString;
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.b;
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UrlsCacheBean, now=  ");
    localStringBuilder.append(l1);
    localStringBuilder.append(", mGetTime");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" diff=");
    localStringBuilder.append(l2);
    localStringBuilder.append(" urlTimeValidDiff=");
    localStringBuilder.append(LongVideoUrlCacheManager.c());
    localIBrowserLog.d(" LongVideoUrlCacheManager", 4, localStringBuilder.toString());
    return l2 < LongVideoUrlCacheManager.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.utils.LongVideoUrlCacheManager.UrlsCacheBean
 * JD-Core Version:    0.7.0.1
 */