package dov.com.qq.im.ae.download.old;

import com.tencent.mobileqq.identification.IdentificationIpcServer;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import java.util.List;

class AEOldShortVideoResDownload$1
  implements AEOldShortVideoResStatus.ISVConfig
{
  AEOldShortVideoResDownload$1(AEOldShortVideoResDownload paramAEOldShortVideoResDownload) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startDownloadConfigNoLogin onConfigResult | result=").append(paramInt1).append("serverError=").append(paramInt2);
    VideoEnvironment.LogDownLoad(AEOldShortVideoResDownload.a(), ((StringBuilder)localObject).toString(), null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.LogDownLoad(AEOldShortVideoResDownload.a(), "startDownloadConfigNoLogin onConfigResult| uncompress config error=" + paramInt2, null);
        AEOldShortVideoResDownload.a(this.a);
        return;
      }
      localObject = new ArrayList(1);
      paramInt1 = AEOldShortVideoResManager.a(AEOldShortVideoResDownload.a(this.a), (List)localObject);
      if (paramInt1 == 0)
      {
        VideoEnvironment.LogDownLoad(AEOldShortVideoResDownload.a(), "startDownloadConfigNoLogin onConfigResult| check config success...", null);
        AEOldShortVideoResDownload.a(this.a).b();
        IdentificationIpcServer.a().a();
        return;
      }
      VideoEnvironment.LogDownLoad(AEOldShortVideoResDownload.a(), "startDownloadConfigNoLogin onConfigResult| check config error=" + paramInt1, null);
      AEOldShortVideoResDownload.a(this.a);
      return;
    }
    VideoEnvironment.LogDownLoad(AEOldShortVideoResDownload.a(), "startDownloadConfigNoLogin onConfigResult| result= RESULT_FAILED error=" + paramInt2, null);
    AEOldShortVideoResDownload.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResDownload.1
 * JD-Core Version:    0.7.0.1
 */