package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class HttpDownloadFileProcessor
  extends BaseTransProcessor
  implements IHttpCommunicatorListener
{
  protected QQAppInterface a;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfInt)
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg != null) {
            break label68;
          }
          throw new Exception("send or recv mFile==null");
        }
        catch (Exception paramHttpMsg1)
        {
          if (paramHttpMsg1.toString().equals("java.io.IOException: No space left on device")) {
            d(2006);
          }
          b(null, null);
        }
        return;
      }
      label68:
      if (paramHttpMsg1 != this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) {
        throw new Exception("send or recv req!=mFile.curRequest");
      }
      if ((paramHttpMsg2.c() == 200) || (paramHttpMsg2.c() == 206))
      {
        j();
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream != null)
        {
          paramHttpMsg1 = paramHttpMsg2.a();
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream.write(paramHttpMsg1);
          paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
          paramHttpMsg1.e += paramHttpMsg2.a().length;
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = paramHttpMsg2.a();
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e == paramHttpMsg2.a())
          {
            i();
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a();
            this.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e = 0L;
            paramHttpMsg1 = new File(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c);
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.renameTo(paramHttpMsg1))
            {
              this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.setLastModified(System.currentTimeMillis());
              d(false);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
              d(2003);
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.delete();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
              d(2004);
            }
          }
          else
          {
            g();
          }
        }
      }
    }
  }
  
  public void a(String paramString) {}
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "HttpDownloadFileProcessor statusChanged(),status is:" + paramInt);
    }
    return true;
  }
  
  public void ap_()
  {
    super.ap_();
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c == null)) {
      b(null, null);
    }
    this.jdField_a_of_type_Boolean = false;
    HttpMsg localHttpMsg = new HttpMsg(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, null, this, true);
    localHttpMsg.b(5);
    localHttpMsg.a(true);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream == null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c + ".tmp");
      localHttpMsg.b(false);
      localHttpMsg.a("Accept-Encoding", "identity");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localHttpMsg);
      d(2001);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        b(null, null);
        localFileNotFoundException.printStackTrace();
      }
    }
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    h();
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d(boolean paramBoolean) {}
  
  public void h()
  {
    super.h();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a();
    d(2004);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e = 0L;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpDownloadFileProcessor
 * JD-Core Version:    0.7.0.1
 */