package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeSoLoader
{
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public static boolean a;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static boolean b;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    b = false;
  }
  
  public static byte a(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("/lib");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".so");
    paramString = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start TKNativeSo: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("TK_Config_NativeSoLoader", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new File(paramString);
    if ((!jdField_a_of_type_Boolean) && (((File)localObject).exists())) {
      try
      {
        System.load(paramString);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("load ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" success!");
          QLog.i("TK_Config_NativeSoLoader", 2, ((StringBuilder)localObject).toString());
        }
        return 0;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("load from tk dir failed: ");
          ((StringBuilder)localObject).append(paramString.getMessage());
          QLog.i("TK_Config_NativeSoLoader", 2, ((StringBuilder)localObject).toString());
        }
        return -3;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TK_Config_NativeSoLoader", 2, "no tk so in ar dir");
    }
    return -2;
  }
  
  public static String a()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TK_Config_NativeSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile.getParent());
    localStringBuilder.append("/tk");
    return localStringBuilder.toString();
  }
  
  public static boolean a(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(a());
    ((StringBuilder)localObject1).append("/lib");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(".so");
    localObject1 = ((StringBuilder)localObject1).toString();
    ??? = new File((String)localObject1);
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("isSoFileExist: exist= ");
      ((StringBuilder)localObject3).append(((File)???).exists());
      ((StringBuilder)localObject3).append(" isUncompressZip=");
      ((StringBuilder)localObject3).append(jdField_a_of_type_Boolean);
      QLog.d("TK_Config_NativeSoLoader", 2, ((StringBuilder)localObject3).toString());
    }
    boolean bool1 = jdField_a_of_type_Boolean;
    boolean bool2 = false;
    if ((!bool1) && (((File)???).exists())) {}
    for (;;)
    {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        localObject3 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tk_native_");
        localStringBuilder.append(paramString);
        localObject3 = ((SharedPreferences)localObject3).getString(localStringBuilder.toString(), null);
        if ((localObject3 == null) || (((String)localObject3).equalsIgnoreCase(PortalUtils.a((String)localObject1)))) {
          break label273;
        }
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("isSoFileExist: soName= ");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(" check md5 false!");
          QLog.d("TK_Config_NativeSoLoader", 2, ((StringBuilder)localObject1).toString());
          bool1 = bool2;
        }
        return bool1;
      }
      return false;
      label273:
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.NativeSoLoader
 * JD-Core Version:    0.7.0.1
 */