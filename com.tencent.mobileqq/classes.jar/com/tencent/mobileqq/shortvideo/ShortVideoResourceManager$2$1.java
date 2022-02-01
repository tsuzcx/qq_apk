package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.utils.quic.QuicResDownload;

class ShortVideoResourceManager$2$1
  implements ShortVideoResourceManager.INet_ShortVideoResource
{
  ShortVideoResourceManager$2$1(ShortVideoResourceManager.2 param2) {}
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doUserDownloadQuicResourceAsync: [onDownloadFinish]name=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" filepath=");
    localStringBuilder.append(paramString2);
    VideoEnvironment.LogDownLoad("QuicResDownload", localStringBuilder.toString(), null);
  }
  
  public void onNetWorkNone()
  {
    VideoEnvironment.LogDownLoad("QuicResDownload", "doUserDownloadQuicResourceAsync: [onNetWorkNone]", null);
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == paramLong2) && (!QuicResDownload.a)) {
      QuicResDownload.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.2.1
 * JD-Core Version:    0.7.0.1
 */