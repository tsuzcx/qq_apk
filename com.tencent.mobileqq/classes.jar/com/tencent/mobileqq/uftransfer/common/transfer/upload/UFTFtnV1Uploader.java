package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTHttpUrlProcessor;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTHttpCommunicator;
import com.tencent.mobileqq.uftransfer.depend.UFTHttpCommunicator.UFTHttpErr;
import com.tencent.mobileqq.uftransfer.depend.UFTHttpCommunicator.UFTHttpReq;
import com.tencent.mobileqq.uftransfer.depend.UFTHttpCommunicator.UFTHttpRsp;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import mqq.app.AppRuntime;

public class UFTFtnV1Uploader
  extends UFTHttpCommunicator
  implements IUFTFtnUploader
{
  private final int jdField_a_of_type_Int;
  private IUFTFtnUploaderCallback jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploaderCallback;
  protected String a;
  protected boolean a;
  private final int b;
  
  private UFTFtnV1Uploader(AppRuntime paramAppRuntime, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    super(paramAppRuntime, paramLong);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static UFTFtnV1Uploader a(AppRuntime paramAppRuntime, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    return new UFTFtnV1Uploader(paramAppRuntime, paramLong, paramInt1, paramInt2, paramBoolean, paramString);
  }
  
  public void a()
  {
    b();
  }
  
  public void a(IUFTFtnUploaderCallback paramIUFTFtnUploaderCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploaderCallback = paramIUFTFtnUploaderCallback;
  }
  
  protected void a(UFTHttpCommunicator.UFTHttpErr paramUFTHttpErr)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] onError errCode:");
    localStringBuilder.append(paramUFTHttpErr.a());
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramUFTHttpErr.a());
    UFTLog.d("[UFTTransfer] UFTFtnV1Uploader", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploaderCallback.a(paramUFTHttpErr.a(), paramUFTHttpErr.a(), paramUFTHttpErr.b());
  }
  
  protected void a(UFTHttpCommunicator.UFTHttpRsp paramUFTHttpRsp)
  {
    if (paramUFTHttpRsp.a() < 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("] onDataErr transferedSize:");
      localStringBuilder.append(paramUFTHttpRsp.a());
      UFTLog.d("[UFTTransfer] UFTFtnV1Uploader", 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploaderCallback.a(9001, "httpServer not has range");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploaderCallback.a(paramUFTHttpRsp.a(), paramUFTHttpRsp.a());
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUploadIUFTFtnUploaderCallback.g_(paramString);
  }
  
  public boolean a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&bmd5=");
    ((StringBuilder)localObject).append(UFTDependFeatureApi.c(paramArrayOfByte));
    ((StringBuilder)localObject).append("&range=");
    ((StringBuilder)localObject).append(String.valueOf(paramLong));
    localObject = ((StringBuilder)localObject).toString();
    paramArrayOfByte = new UFTHttpCommunicator.UFTHttpReq((String)localObject, paramArrayOfByte, false);
    paramArrayOfByte.a("POST");
    paramArrayOfByte.a(5);
    paramArrayOfByte.b(this.b);
    paramArrayOfByte.c(this.jdField_a_of_type_Int);
    paramString = new StringBuilder();
    paramString.append("bytes=");
    paramString.append(paramLong);
    paramString.append("-");
    paramArrayOfByte.c(paramString.toString());
    if (localObject != null) {
      paramString = ((String)localObject).toLowerCase();
    } else {
      paramString = "";
    }
    if ((this.jdField_a_of_type_Boolean) && (paramString.startsWith("https")))
    {
      paramArrayOfByte.a(true);
      paramArrayOfByte.b(UFTHttpUrlProcessor.a((String)localObject));
      paramArrayOfByte.b(this.jdField_a_of_type_JavaLangString);
    }
    return a(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFtnV1Uploader
 * JD-Core Version:    0.7.0.1
 */