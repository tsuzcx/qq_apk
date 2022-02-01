package dov.com.qq.im.ae.download.old;

import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.quic.QuicResDownload;

class AEOldShortVideoResManager$2$1
  implements AEOldShortVideoResManager.INet_ShortVideoResource
{
  AEOldShortVideoResManager$2$1(AEOldShortVideoResManager.2 param2) {}
  
  public void a()
  {
    VideoEnvironment.LogDownLoad("QuicResDownload", "doUserDownloadQuicResourceAsync: [onNetWorkNone]", null);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doUserDownloadQuicResourceAsync: [onDownloadFinish]name=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" filepath=");
    localStringBuilder.append(paramString2);
    VideoEnvironment.LogDownLoad("QuicResDownload", localStringBuilder.toString(), null);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == paramLong2) && (!QuicResDownload.a)) {
      QuicResDownload.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.2.1
 * JD-Core Version:    0.7.0.1
 */