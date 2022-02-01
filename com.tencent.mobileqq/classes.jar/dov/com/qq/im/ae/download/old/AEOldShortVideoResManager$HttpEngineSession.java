package dov.com.qq.im.ae.download.old;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class AEOldShortVideoResManager$HttpEngineSession
{
  int jdField_a_of_type_Int;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  String jdField_a_of_type_JavaLangString;
  ArrayList<AEOldShortVideoResManager.INet_ShortVideoResource> jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  int b = 0;
  
  AEOldShortVideoResManager$HttpEngineSession(AEOldShortVideoResManager paramAEOldShortVideoResManager, HttpNetReq paramHttpNetReq)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = paramHttpNetReq;
    this.b = 0;
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEOldShortVideoResManager", 2, "HttpEngineTask[start]: " + this);
    }
    this.b = 1;
    ((IHttpEngineService)AEOldShortVideoResManager.a(this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager).getRuntimeService(IHttpEngineService.class, "all")).sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.HttpEngineSession
 * JD-Core Version:    0.7.0.1
 */