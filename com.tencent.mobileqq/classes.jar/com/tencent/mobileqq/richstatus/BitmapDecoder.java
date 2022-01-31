package com.tencent.mobileqq.richstatus;

import ahbf;
import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

public class BitmapDecoder
{
  private volatile long jdField_a_of_type_Long;
  private BitmapDecoder.IBitmapListener jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder$IBitmapListener;
  private String jdField_a_of_type_JavaLangString;
  private HashSet jdField_a_of_type_JavaUtilHashSet;
  
  public BitmapDecoder(String paramString, BitmapDecoder.IBitmapListener paramIBitmapListener)
  {
    paramString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusBitmapDecoder$IBitmapListener = paramIBitmapListener;
  }
  
  public static File a()
  {
    if (SystemUtil.a()) {
      return new File(AppConstants.aJ + "status_ic");
    }
    return null;
  }
  
  private boolean a(String paramString, File paramFile)
  {
    int i = HttpDownloadUtil.a(null, paramString, paramFile);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.img", 2, "download " + paramString + "result " + i);
    }
    paramFile = StatisticCollector.a(BaseApplication.getContext());
    HashMap localHashMap = new HashMap();
    localHashMap.put("result", String.valueOf(i));
    localHashMap.put("url", paramString);
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramFile.a("", "RichStatusIcon", bool, 0L, 0L, localHashMap, "");
      if (i != 0) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public Bitmap a(String paramString)
  {
    return (Bitmap)BaseApplicationImpl.sImageCache.get(this.jdField_a_of_type_JavaLangString + paramString);
  }
  
  public Bitmap a(String paramString1, String paramString2, String paramString3)
  {
    Bitmap localBitmap = a(paramString1);
    if (localBitmap == null)
    {
      if (this.jdField_a_of_type_JavaUtilHashSet == null) {
        this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
      }
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.img", 2, "decodeBitmap " + paramString1 + ", " + paramString2 + ", " + paramString3);
        }
        this.jdField_a_of_type_JavaUtilHashSet.add(paramString1);
        new ahbf(this, paramString1, paramString2, paramString3).execute((Void[])null);
      }
    }
    return localBitmap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.BitmapDecoder
 * JD-Core Version:    0.7.0.1
 */