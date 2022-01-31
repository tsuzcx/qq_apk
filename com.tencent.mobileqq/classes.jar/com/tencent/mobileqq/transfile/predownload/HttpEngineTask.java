package com.tencent.mobileqq.transfile.predownload;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

public class HttpEngineTask
  extends AbsPreDownloadTask
  implements INetEngine.INetEngineListener
{
  public HttpNetReq a;
  private HttpEngineTask.IHttpEngineTask a;
  
  public HttpEngineTask(QQAppInterface paramQQAppInterface, String paramString, HttpEngineTask.IHttpEngineTask paramIHttpEngineTask, HttpNetReq paramHttpNetReq)
  {
    super(paramQQAppInterface, paramString);
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = paramHttpNetReq;
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadHttpEngineTask$IHttpEngineTask = paramIHttpEngineTask;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Task", 2, "start: " + this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0).a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadHttpEngineTask$IHttpEngineTask.a(this);
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadHttpEngineTask$IHttpEngineTask.a(paramNetReq, paramLong1, paramLong2);
  }
  
  public void a(NetResp paramNetResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadHttpEngineTask$IHttpEngineTask.a(paramNetResp);
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.a(this);
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_JavaLangString + ", " + this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadHttpEngineTask$IHttpEngineTask + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.HttpEngineTask
 * JD-Core Version:    0.7.0.1
 */