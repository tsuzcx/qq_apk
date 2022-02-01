package com.tencent.mobileqq.richmediabrowser.utils;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import java.util.concurrent.ConcurrentHashMap;

public class LongVideoUrlCacheManager
{
  private static int a = 900000;
  public ConcurrentHashMap<Long, LongVideoUrlCacheManager.UrlsCacheBean> a;
  
  private LongVideoUrlCacheManager()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static final LongVideoUrlCacheManager a()
  {
    return LongVideoUrlCacheManager.LazyStyle.a();
  }
  
  public LongVideoUrlCacheManager.UrlsCacheBean a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return (LongVideoUrlCacheManager.UrlsCacheBean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void a()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d(" LongVideoUrlCacheManager", 4, "LongVideoUrlCacheManager,clearCache");
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(long paramLong1, String[] paramArrayOfString, long paramLong2, MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), new LongVideoUrlCacheManager.UrlsCacheBean(this, paramArrayOfString, paramLong2, paramMessageRecord, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.utils.LongVideoUrlCacheManager
 * JD-Core Version:    0.7.0.1
 */