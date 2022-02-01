package com.tencent.mobileqq.config;

import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.BaseConf;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class Config
{
  public static byte a;
  private static ConfigManager jdField_a_of_type_ComTencentMobileqqConfigConfigManager;
  public static PicAndAdConf a;
  private static HttpCommunicator jdField_a_of_type_ComTencentMobileqqTransfileHttpCommunicator;
  private static ArrayList<ConfigListener> jdField_a_of_type_JavaUtilArrayList;
  static BaseConf[] jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf;
  public static byte b;
  static PicAndAdConf b;
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Byte = 3;
    jdField_b_of_type_Byte = 1;
  }
  
  public Config(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_ComTencentMobileqqTransfileHttpCommunicator = (HttpCommunicator)((IHttpEngineService)paramQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator();
    jdField_a_of_type_ComTencentMobileqqConfigConfigManager = new ConfigManager(paramQQAppInterface.getApp(), paramString);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf = new PicAndAdConf((short)24, (byte)0);
    jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf = new PicAndAdConf((short)12, (byte)1);
    jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf = new BaseConf[] { jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf, jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf };
    jdField_a_of_type_ComTencentMobileqqConfigConfigManager.a();
  }
  
  public static ConfigManager a()
  {
    return jdField_a_of_type_ComTencentMobileqqConfigConfigManager;
  }
  
  public static HttpCommunicator a()
  {
    return jdField_a_of_type_ComTencentMobileqqTransfileHttpCommunicator;
  }
  
  public static String a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = new StringBuffer(ConfigManager.a(paramString1, paramInt).trim());
    if (paramString2 != null)
    {
      paramString2 = paramString2.trim();
      if (paramString2.length() > 0)
      {
        if (paramString2.charAt(0) != '&') {
          paramString1.append('&');
        }
        paramString1.append(paramString2);
      }
    }
    return paramString1.toString();
  }
  
  public static ArrayList<ConfigListener> a()
  {
    return jdField_a_of_type_JavaUtilArrayList;
  }
  
  public static void a()
  {
    jdField_a_of_type_ComTencentMobileqqConfigConfigManager = null;
    if (jdField_a_of_type_ComTencentMobileqqTransfileHttpCommunicator != null) {
      jdField_a_of_type_ComTencentMobileqqTransfileHttpCommunicator.close();
    }
    jdField_a_of_type_ComTencentMobileqqTransfileHttpCommunicator = null;
  }
  
  public int a(int paramInt)
  {
    return jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt].a();
  }
  
  public long a(int paramInt1, int paramInt2)
  {
    return ((PicAndAdConf)jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt1]).a(paramInt2);
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    return ((PicAndAdConf)jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt1]).a(paramInt2);
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    return ((PicAndAdConf)jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt1]).c(paramInt2);
  }
  
  public short a(int paramInt1, int paramInt2)
  {
    return ((PicAndAdConf)jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt1]).a(paramInt2);
  }
  
  public String b(int paramInt1, int paramInt2)
  {
    return ((PicAndAdConf)jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt1]).a(paramInt2);
  }
  
  public String c(int paramInt1, int paramInt2)
  {
    return ((PicAndAdConf)jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt1]).b(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.Config
 * JD-Core Version:    0.7.0.1
 */