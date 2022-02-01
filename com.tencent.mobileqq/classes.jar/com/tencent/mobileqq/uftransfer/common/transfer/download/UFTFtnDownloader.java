package com.tencent.mobileqq.uftransfer.common.transfer.download;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTHttpUrlProcessor;
import com.tencent.mobileqq.uftransfer.depend.UFTHttpCommunicator;
import com.tencent.mobileqq.uftransfer.depend.UFTHttpCommunicator.UFTHttpErr;
import com.tencent.mobileqq.uftransfer.depend.UFTHttpCommunicator.UFTHttpReq;
import com.tencent.mobileqq.uftransfer.depend.UFTHttpCommunicator.UFTHttpRsp;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;

public class UFTFtnDownloader
  extends UFTHttpCommunicator
{
  private IUFTFtnDownloaderCallback jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferDownloadIUFTFtnDownloaderCallback;
  private final UFTFtnDownloader.DlderProp jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferDownloadUFTFtnDownloader$DlderProp;
  
  public void a()
  {
    b();
  }
  
  protected void a(UFTHttpCommunicator.UFTHttpErr paramUFTHttpErr)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("id[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("] onError errCode:");
    ((StringBuilder)localObject).append(paramUFTHttpErr.a());
    ((StringBuilder)localObject).append(" errMsg:");
    ((StringBuilder)localObject).append(paramUFTHttpErr.a());
    UFTLog.d("[UFTTransfer] UFTFtnDownloader", 1, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    if (TextUtils.isEmpty(paramUFTHttpErr.c())) {
      ((Bundle)localObject).putString("User-ReturnCode", paramUFTHttpErr.c());
    }
    IUFTFtnDownloaderCallback localIUFTFtnDownloaderCallback = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferDownloadIUFTFtnDownloaderCallback;
    if (localIUFTFtnDownloaderCallback != null) {
      localIUFTFtnDownloaderCallback.a(paramUFTHttpErr.a(), paramUFTHttpErr.a(), paramUFTHttpErr.b(), (Bundle)localObject);
    }
  }
  
  protected void a(UFTHttpCommunicator.UFTHttpRsp paramUFTHttpRsp)
  {
    long l = paramUFTHttpRsp.b();
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferDownloadUFTFtnDownloader$DlderProp.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferDownloadUFTFtnDownloader$DlderProp.jdField_a_of_type_Long = l;
    }
    IUFTFtnDownloaderCallback localIUFTFtnDownloaderCallback = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferDownloadIUFTFtnDownloaderCallback;
    if (localIUFTFtnDownloaderCallback != null) {
      localIUFTFtnDownloaderCallback.a(paramUFTHttpRsp.a(), paramUFTHttpRsp.b(), paramUFTHttpRsp.a());
    }
  }
  
  protected void a(String paramString)
  {
    IUFTFtnDownloaderCallback localIUFTFtnDownloaderCallback = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferDownloadIUFTFtnDownloaderCallback;
    if (localIUFTFtnDownloaderCallback != null) {
      localIUFTFtnDownloaderCallback.f_(paramString);
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("] ftn downloadData url:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" pos:");
    ((StringBuilder)localObject).append(paramLong);
    UFTLog.b("[UFTTransfer] UFTFtnDownloader", 1, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    UFTHttpCommunicator.UFTHttpReq localUFTHttpReq = new UFTHttpCommunicator.UFTHttpReq(paramString, null, true);
    localUFTHttpReq.a(5);
    localUFTHttpReq.b(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferDownloadUFTFtnDownloader$DlderProp.jdField_b_of_type_Int);
    localUFTHttpReq.c(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferDownloadUFTFtnDownloader$DlderProp.jdField_a_of_type_Int);
    localUFTHttpReq.e(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferDownloadUFTFtnDownloader$DlderProp.jdField_a_of_type_JavaLangString);
    localUFTHttpReq.d(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferDownloadUFTFtnDownloader$DlderProp.jdField_b_of_type_JavaLangString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bytes=");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("-");
    localUFTHttpReq.c(((StringBuilder)localObject).toString());
    localUFTHttpReq.f("identity");
    localUFTHttpReq.c(true);
    if (paramString != null) {
      localObject = paramString.toLowerCase();
    } else {
      localObject = "";
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferDownloadUFTFtnDownloader$DlderProp.jdField_a_of_type_Boolean) && (((String)localObject).startsWith("https")))
    {
      localUFTHttpReq.a(true);
      localUFTHttpReq.b(UFTHttpUrlProcessor.a(paramString));
      localUFTHttpReq.b(this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferDownloadUFTFtnDownloader$DlderProp.c);
    }
    return a(localUFTHttpReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.download.UFTFtnDownloader
 * JD-Core Version:    0.7.0.1
 */