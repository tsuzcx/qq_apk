package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class TrackerSoLoader
{
  public static int a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Int = -4;
  }
  
  private static int a(String paramString)
  {
    int i;
    if (paramString == null) {
      i = -1;
    }
    do
    {
      return i;
      if (!new File(paramString).exists()) {
        return -2;
      }
      try
      {
        System.load(paramString);
        return 0;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        i = -3;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TrackerSoLoader", 2, "LoadExtractedShortVideoFilterLib : exp=", paramString);
    return -3;
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    String str = PtvFilterSoLoad.e(BaseApplicationImpl.getContext());
    if (str == null) {
      return false;
    }
    if (!FileUtils.a(str + "libObjectTracker.so")) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TrackerSoLoader", 2, " isTrackingSoExist =" + bool);
      }
      jdField_a_of_type_Boolean = bool;
      return jdField_a_of_type_Boolean;
      bool = true;
    }
  }
  
  public static boolean a(Context arg0)
  {
    if (b()) {
      return true;
    }
    String str = PtvFilterSoLoad.e(BaseApplicationImpl.getContext());
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TrackerSoLoader", 2, "loadAllFilterSo: soRootPath==null");
      }
      return false;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int != 0) {
        jdField_a_of_type_Int = a(str + "libObjectTracker.so");
      }
      boolean bool = b();
      if (QLog.isColorLevel()) {
        QLog.i("TrackerSoLoader", 2, String.format("loadAllFilterSo, bSuc[%s], soPath[%s]", new Object[] { Boolean.valueOf(bool), str }));
      }
      return bool;
    }
  }
  
  public static boolean b()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TrackerSoLoader", 2, "isLoadSoSuccess mLoadStatus =" + jdField_a_of_type_Int);
      }
      return jdField_a_of_type_Int == 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.TrackerSoLoader
 * JD-Core Version:    0.7.0.1
 */