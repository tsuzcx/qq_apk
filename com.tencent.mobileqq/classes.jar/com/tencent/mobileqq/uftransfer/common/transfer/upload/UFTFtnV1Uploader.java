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
  protected boolean a;
  protected String b;
  private final int f;
  private final int g;
  private IUFTFtnUploaderCallback h;
  
  private UFTFtnV1Uploader(AppRuntime paramAppRuntime, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    super(paramAppRuntime, paramLong);
    this.f = paramInt1;
    this.g = paramInt2;
    this.a = paramBoolean;
    this.b = paramString;
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
    this.h = paramIUFTFtnUploaderCallback;
  }
  
  protected void a(UFTHttpCommunicator.UFTHttpErr paramUFTHttpErr)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("] onError errCode:");
    localStringBuilder.append(paramUFTHttpErr.a());
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramUFTHttpErr.b());
    UFTLog.d("[UFTTransfer] UFTFtnV1Uploader", 1, localStringBuilder.toString());
    this.h.a(paramUFTHttpErr.a(), paramUFTHttpErr.b(), paramUFTHttpErr.c());
  }
  
  protected void a(UFTHttpCommunicator.UFTHttpRsp paramUFTHttpRsp)
  {
    if (paramUFTHttpRsp.a() < 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("] onDataErr transferedSize:");
      localStringBuilder.append(paramUFTHttpRsp.a());
      UFTLog.d("[UFTTransfer] UFTFtnV1Uploader", 1, localStringBuilder.toString());
      this.h.a(9001, "httpServer not has range");
      return;
    }
    this.h.a(paramUFTHttpRsp.a(), paramUFTHttpRsp.c());
  }
  
  protected void a(String paramString)
  {
    this.h.r_(paramString);
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
    paramArrayOfByte.b(this.g);
    paramArrayOfByte.c(this.f);
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
    if ((this.a) && (paramString.startsWith("https")))
    {
      paramArrayOfByte.a(true);
      paramArrayOfByte.b(UFTHttpUrlProcessor.a((String)localObject));
      paramArrayOfByte.b(this.b);
    }
    return a(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFtnV1Uploader
 * JD-Core Version:    0.7.0.1
 */