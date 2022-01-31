package com.tencent.mobileqq.util;

import akaf;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ImageCache
{
  private CustomLruCache jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache;
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public ImageCache(int paramInt)
  {
    paramInt = Math.max(paramInt, 5);
    if (QLog.isColorLevel()) {
      QLog.d("ImageCache", 2, "Memory cache size = " + paramInt + "MB");
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache = new akaf(this, paramInt * 1024 * 1024);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilCustomLruCache.evictAll();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageCache
 * JD-Core Version:    0.7.0.1
 */