package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ShortVideoResourceManager$HttpEngineSession
{
  int jdField_a_of_type_Int;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  String jdField_a_of_type_JavaLangString;
  ArrayList<ShortVideoResourceManager.INet_ShortVideoResource> jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  int b = 0;
  
  ShortVideoResourceManager$HttpEngineSession(ShortVideoResourceManager paramShortVideoResourceManager, HttpNetReq paramHttpNetReq)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = paramHttpNetReq;
    this.b = 0;
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoResourceManager", 2, "HttpEngineTask[start]: " + this);
    }
    this.b = 1;
    ((IHttpEngineService)ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager).getRuntimeService(IHttpEngineService.class, "all")).sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.HttpEngineSession
 * JD-Core Version:    0.7.0.1
 */