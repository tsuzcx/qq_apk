package dov.com.qq.im.ae.download.old;

import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import java.util.List;

class AEOldShortVideoResDownload$1
  implements AEOldShortVideoResStatus.ISVConfig
{
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startDownloadConfigNoLogin onConfigResult | result=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("serverError=");
    ((StringBuilder)localObject).append(paramInt2);
    VideoEnvironment.LogDownLoad(AEOldShortVideoResDownload.a(), ((StringBuilder)localObject).toString(), null);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localObject = AEOldShortVideoResDownload.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDownloadConfigNoLogin onConfigResult| result= RESULT_FAILED error=");
      localStringBuilder.append(paramInt2);
      VideoEnvironment.LogDownLoad((String)localObject, localStringBuilder.toString(), null);
      AEOldShortVideoResDownload.a(this.a);
      return;
    }
    if (paramInt2 != 0)
    {
      localObject = AEOldShortVideoResDownload.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDownloadConfigNoLogin onConfigResult| uncompress config error=");
      localStringBuilder.append(paramInt2);
      VideoEnvironment.LogDownLoad((String)localObject, localStringBuilder.toString(), null);
      AEOldShortVideoResDownload.a(this.a);
      return;
    }
    localObject = new ArrayList(1);
    paramInt1 = AEOldShortVideoResManager.a(AEOldShortVideoResDownload.a(this.a), (List)localObject);
    if (paramInt1 == 0)
    {
      VideoEnvironment.LogDownLoad(AEOldShortVideoResDownload.a(), "startDownloadConfigNoLogin onConfigResult| check config success...", null);
      AEOldShortVideoResDownload.a(this.a).b();
      return;
    }
    localObject = AEOldShortVideoResDownload.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startDownloadConfigNoLogin onConfigResult| check config error=");
    localStringBuilder.append(paramInt1);
    VideoEnvironment.LogDownLoad((String)localObject, localStringBuilder.toString(), null);
    AEOldShortVideoResDownload.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResDownload.1
 * JD-Core Version:    0.7.0.1
 */