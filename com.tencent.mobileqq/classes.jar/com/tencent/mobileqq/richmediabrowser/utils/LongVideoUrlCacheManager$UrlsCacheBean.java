package com.tencent.mobileqq.richmediabrowser.utils;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

public class LongVideoUrlCacheManager$UrlsCacheBean
{
  public int a;
  public long a;
  public MessageForShortVideo a;
  String jdField_a_of_type_JavaLangString;
  public String[] a;
  
  public LongVideoUrlCacheManager$UrlsCacheBean(LongVideoUrlCacheManager paramLongVideoUrlCacheManager, String[] paramArrayOfString, long paramLong, MessageForShortVideo paramMessageForShortVideo, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    BrowserLogHelper.getInstance().getGalleryLog().d(" LongVideoUrlCacheManager", 4, "UrlsCacheBean, now=  " + l1 + ", mGetTime" + this.jdField_a_of_type_Long + " diff=" + l2 + " urlTimeValidDiff=" + LongVideoUrlCacheManager.a());
    return l2 < LongVideoUrlCacheManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.utils.LongVideoUrlCacheManager.UrlsCacheBean
 * JD-Core Version:    0.7.0.1
 */