package com.tencent.mobileqq.transfile;

import java.util.HashMap;

public class UrlDownloader
  extends BaseDownloadProcessor
{
  public UrlDownloader(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.b = ((TransferRequest.PicDownExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Int;
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    StringBuilder localStringBuilder = new StringBuilder().append(" result:");
    if (paramNetResp.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      b("onHttpResp", bool);
      this.b += paramNetResp.jdField_c_of_type_Long;
      if (paramNetResp.jdField_a_of_type_Int != 0) {
        break;
      }
      e();
      return;
    }
    d();
  }
  
  public void ar_()
  {
    f();
  }
  
  void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a(TransFileController.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest));
    TransferResult localTransferResult = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    if (localTransferResult != null)
    {
      localTransferResult.jdField_a_of_type_Int = -1;
      localTransferResult.jdField_a_of_type_Long = this.jdField_j_of_type_Int;
      localTransferResult.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      localTransferResult.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    try
    {
      b("notify", "start");
      notifyAll();
      b("notify", "end");
      return;
    }
    finally {}
  }
  
  void e()
  {
    super.e();
    TransferResult localTransferResult = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqTransfileTransferResult;
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a(TransFileController.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest));
    if (localTransferResult != null)
    {
      localTransferResult.jdField_a_of_type_Int = 0;
      localTransferResult.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
    }
    try
    {
      b("notify", "start");
      notifyAll();
      b("notify", "end");
      return;
    }
    finally {}
  }
  
  void f()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = str;
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaIoOutputStream;
    localHttpNetReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
    localHttpNetReq.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localHttpNetReq.g = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localHttpNetReq.f = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b;
    localHttpNetReq.jdField_a_of_type_Long = this.b;
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localHttpNetReq.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d)
    {
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localHttpNetReq.jdField_a_of_type_Long + "-");
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    }
    localHttpNetReq.jdField_c_of_type_Int = 4;
    localHttpNetReq.jdField_c_of_type_Long = 90000L;
    b("httpDown", " url:" + str + ",downOffset:" + localHttpNetReq.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.UrlDownloader
 * JD-Core Version:    0.7.0.1
 */