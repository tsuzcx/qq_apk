package com.tencent.mobileqq.weiyun.sdk.download;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.weiyun.api.download.IDownloadListener;
import com.tencent.mobileqq.weiyun.api.download.IDownloadStatusListener;
import com.tencent.mobileqq.weiyun.model.WeiyunDownloadStatusInfo;
import java.io.File;

class WyDownloader$3
  implements IDownloadListener
{
  WyDownloader$3(WyDownloader paramWyDownloader, IDownloadStatusListener paramIDownloadStatusListener, int paramInt) {}
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    WeiyunDownloadStatusInfo localWeiyunDownloadStatusInfo = new WeiyunDownloadStatusInfo();
    localWeiyunDownloadStatusInfo.g = paramString;
    localWeiyunDownloadStatusInfo.a = 2;
    localWeiyunDownloadStatusInfo.e = (paramFloat);
    localWeiyunDownloadStatusInfo.d = paramLong;
    this.a.a(paramString, this.b, localWeiyunDownloadStatusInfo, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("download finish:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" successed:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("errorCode:");
    ((StringBuilder)localObject).append(paramInt);
    Log.e("WyDownloader", ((StringBuilder)localObject).toString());
    int i;
    if ((paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists())) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = new WeiyunDownloadStatusInfo();
    ((WeiyunDownloadStatusInfo)localObject).f = paramString2;
    ((WeiyunDownloadStatusInfo)localObject).g = paramString1;
    ((WeiyunDownloadStatusInfo)localObject).b = paramInt;
    ((WeiyunDownloadStatusInfo)localObject).c = paramString3;
    if (i != 0)
    {
      ((WeiyunDownloadStatusInfo)localObject).a = 4;
      this.a.a(paramString1, this.b, (WeiyunDownloadStatusInfo)localObject, true);
      return;
    }
    ((WeiyunDownloadStatusInfo)localObject).a = 5;
    this.a.a(paramString1, this.b, (WeiyunDownloadStatusInfo)localObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.WyDownloader.3
 * JD-Core Version:    0.7.0.1
 */