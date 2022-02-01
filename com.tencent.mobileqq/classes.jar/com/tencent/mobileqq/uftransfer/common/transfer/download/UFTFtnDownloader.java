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
  private final UFTFtnDownloader.DlderProp a;
  private IUFTFtnDownloaderCallback b;
  
  public void a()
  {
    b();
  }
  
  protected void a(UFTHttpCommunicator.UFTHttpErr paramUFTHttpErr)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("id[");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("] onError errCode:");
    ((StringBuilder)localObject).append(paramUFTHttpErr.a());
    ((StringBuilder)localObject).append(" errMsg:");
    ((StringBuilder)localObject).append(paramUFTHttpErr.b());
    UFTLog.d("[UFTTransfer] UFTFtnDownloader", 1, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    if (TextUtils.isEmpty(paramUFTHttpErr.d())) {
      ((Bundle)localObject).putString("User-ReturnCode", paramUFTHttpErr.d());
    }
    IUFTFtnDownloaderCallback localIUFTFtnDownloaderCallback = this.b;
    if (localIUFTFtnDownloaderCallback != null) {
      localIUFTFtnDownloaderCallback.a(paramUFTHttpErr.a(), paramUFTHttpErr.b(), paramUFTHttpErr.c(), (Bundle)localObject);
    }
  }
  
  protected void a(UFTHttpCommunicator.UFTHttpRsp paramUFTHttpRsp)
  {
    long l = paramUFTHttpRsp.d();
    if (this.a.c == 0L) {
      this.a.c = l;
    }
    IUFTFtnDownloaderCallback localIUFTFtnDownloaderCallback = this.b;
    if (localIUFTFtnDownloaderCallback != null) {
      localIUFTFtnDownloaderCallback.a(paramUFTHttpRsp.b(), paramUFTHttpRsp.d(), paramUFTHttpRsp.c());
    }
  }
  
  protected void a(String paramString)
  {
    IUFTFtnDownloaderCallback localIUFTFtnDownloaderCallback = this.b;
    if (localIUFTFtnDownloaderCallback != null) {
      localIUFTFtnDownloaderCallback.q_(paramString);
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.d);
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
    localUFTHttpReq.b(this.a.b);
    localUFTHttpReq.c(this.a.a);
    localUFTHttpReq.e(this.a.d);
    localUFTHttpReq.d(this.a.e);
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
    if ((this.a.f) && (((String)localObject).startsWith("https")))
    {
      localUFTHttpReq.a(true);
      localUFTHttpReq.b(UFTHttpUrlProcessor.a(paramString));
      localUFTHttpReq.b(this.a.g);
    }
    return a(localUFTHttpReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.download.UFTFtnDownloader
 * JD-Core Version:    0.7.0.1
 */