package com.tencent.mobileqq.transfile;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class BaseDownloadProcessor
  extends BaseTransProcessor
{
  public static final boolean b;
  private static int jdField_c_of_type_Int;
  private static boolean jdField_c_of_type_Boolean;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)this.a;
  String jdField_a_of_type_JavaLangString;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected boolean a;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString;
  ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  String jdField_c_of_type_JavaLangString = null;
  String d = null;
  String e = null;
  
  static
  {
    boolean bool = true;
    jdField_c_of_type_Int = 80;
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      jdField_b_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public BaseDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    if ((paramTransferRequest != null) && (paramTransferRequest.a != null)) {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramTransferRequest.a);
    }
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString.length() % 2 != 0) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      StringBuilder localStringBuilder = new StringBuilder(2);
      localStringBuilder.append(paramString[i]).append(paramString[(i + 1)]);
      arrayOfByte[(i / 2)] = ((byte)Integer.parseInt(localStringBuilder.toString(), 16));
      i += 2;
    }
    return arrayOfByte;
  }
  
  public static int d()
  {
    if (!jdField_c_of_type_Boolean) {}
    try
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "");
      if (QLog.isColorLevel()) {
        QLog.d("BaseTransProcessor", 2, "getPicDownloadPort:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 9) {
        jdField_c_of_type_Int = Integer.valueOf(localObject[9]).intValue();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseTransProcessor", 2, "getPicDownloadPort e:" + localException.toString());
        }
      }
    }
    jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, "getPicDownloadPort return " + jdField_c_of_type_Int);
    }
    return jdField_c_of_type_Int;
  }
  
  byte[] a(String paramString1, String paramString2)
  {
    String str = null;
    Object localObject = str;
    if (paramString1 != null)
    {
      localObject = str;
      if (paramString1.length() == 32) {
        localObject = a(paramString1);
      }
    }
    paramString1 = (String)localObject;
    if (localObject == null)
    {
      paramString1 = (String)localObject;
      if (paramString2 != null)
      {
        int i = paramString2.indexOf(".");
        str = paramString2;
        if (i > 0) {
          str = paramString2.substring(0, i);
        }
        if (str.length() != 32) {
          break label85;
        }
        paramString1 = a(str);
      }
    }
    label85:
    do
    {
      do
      {
        do
        {
          return paramString1;
          if (str.length() != 38) {
            break;
          }
          paramString2 = str.substring(1, 37).replace("-", "");
          paramString1 = (String)localObject;
        } while (paramString2.length() != 32);
        return a(paramString2);
        paramString1 = (String)localObject;
      } while (str.length() != 34);
      paramString2 = str.substring(1, 33);
      paramString1 = (String)localObject;
    } while (paramString2.length() != 32);
    return a(paramString2);
  }
  
  public void ap_()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.d = 2001;
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "start ");
        }
      }
      super.ap_();
      return;
    }
    finally {}
  }
  
  public void b()
  {
    b(9366, "transfileController destroy");
    d();
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG", 2, "accountChanged transfileController destroy");
    }
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */