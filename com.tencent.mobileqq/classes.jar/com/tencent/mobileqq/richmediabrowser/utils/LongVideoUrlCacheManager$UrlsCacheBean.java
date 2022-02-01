package com.tencent.mobileqq.richmediabrowser.utils;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

public class LongVideoUrlCacheManager$UrlsCacheBean
{
  public int a;
  public long a;
  public MessageRecord a;
  String jdField_a_of_type_JavaLangString;
  public String[] a;
  
  public LongVideoUrlCacheManager$UrlsCacheBean(LongVideoUrlCacheManager paramLongVideoUrlCacheManager, String[] paramArrayOfString, long paramLong, MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UrlsCacheBean, now=  ");
    localStringBuilder.append(l1);
    localStringBuilder.append(", mGetTime");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" diff=");
    localStringBuilder.append(l2);
    localStringBuilder.append(" urlTimeValidDiff=");
    localStringBuilder.append(LongVideoUrlCacheManager.a());
    localIBrowserLog.d(" LongVideoUrlCacheManager", 4, localStringBuilder.toString());
    return l2 < LongVideoUrlCacheManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.utils.LongVideoUrlCacheManager.UrlsCacheBean
 * JD-Core Version:    0.7.0.1
 */