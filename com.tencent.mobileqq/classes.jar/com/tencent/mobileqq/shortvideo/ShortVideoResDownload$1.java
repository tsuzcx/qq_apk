package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.identification.IdentificationIpcServer;
import java.util.ArrayList;
import java.util.List;

class ShortVideoResDownload$1
  implements ShortVideoResourceStatus.ISVConfig
{
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startDownloadConfigNoLogin onConfigResult | result=").append(paramInt1).append("serverError=").append(paramInt2);
    VideoEnvironment.LogDownLoad(ShortVideoResDownload.a(), ((StringBuilder)localObject).toString(), null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.LogDownLoad(ShortVideoResDownload.a(), "startDownloadConfigNoLogin onConfigResult| uncompress config error=" + paramInt2, null);
        ShortVideoResDownload.a(this.a);
        return;
      }
      localObject = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(ShortVideoResDownload.a(this.a), (List)localObject);
      if (paramInt1 == 0)
      {
        VideoEnvironment.LogDownLoad(ShortVideoResDownload.a(), "startDownloadConfigNoLogin onConfigResult| check config success...", null);
        ShortVideoResDownload.a(this.a).a();
        IdentificationIpcServer.a().a();
        return;
      }
      VideoEnvironment.LogDownLoad(ShortVideoResDownload.a(), "startDownloadConfigNoLogin onConfigResult| check config error=" + paramInt1, null);
      ShortVideoResDownload.a(this.a);
      return;
    }
    VideoEnvironment.LogDownLoad(ShortVideoResDownload.a(), "startDownloadConfigNoLogin onConfigResult| result= RESULT_FAILED error=" + paramInt2, null);
    ShortVideoResDownload.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResDownload.1
 * JD-Core Version:    0.7.0.1
 */