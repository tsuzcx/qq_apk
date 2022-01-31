package com.tencent.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class SOPreLoader
{
  private static int jdField_a_of_type_Int;
  public static final Object a;
  private static String jdField_a_of_type_JavaLangString = "";
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      Object localObject = BaseApplicationImpl.getContext();
      if (localObject == null) {
        break label65;
      }
      localObject = ((Context)localObject).getFilesDir();
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
        jdField_a_of_type_JavaLangString = ((File)localObject).getParent() + "/txlib/" + "cmshow/";
      }
    }
    for (;;)
    {
      return jdField_a_of_type_JavaLangString;
      label65:
      QLog.w("ApolloSoLoader_preLoader", 2, "getSoLibPath but context is null");
    }
  }
  
  public static String a(int paramInt)
  {
    a();
    String str = jdField_a_of_type_JavaLangString;
    if (paramInt == 0) {
      str = jdField_a_of_type_JavaLangString + "jsc_temp_dir" + "/";
    }
    while (1 != paramInt) {
      return str;
    }
    return jdField_a_of_type_JavaLangString + "sava_temp_dir" + "/";
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      a();
      String str;
      if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
        str = a(paramInt);
      }
      try
      {
        jdField_a_of_type_Int = 1;
        FileUtils.a(paramString, str, false);
        jdField_a_of_type_Int = 0;
        QLog.i("ApolloSoLoader_preLoader", 1, "succeed to unzip so.");
        if (jdField_a_of_type_Int == 0) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          jdField_a_of_type_Int = 2;
          QLog.e("ApolloSoLoader_preLoader", 1, paramString, new Object[0]);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.util.SOPreLoader
 * JD-Core Version:    0.7.0.1
 */