package dov.com.qq.im.ae.play;

import bnke;
import bnkq;
import com.tencent.qphone.base.util.QLog;

class PlayDownloadManagerWrap$DownloadProcessListener
  implements bnkq
{
  public void onDownloadFinish(bnke parambnke, boolean paramBoolean)
  {
    if (parambnke == null) {
      return;
    }
    parambnke.f = false;
    if (paramBoolean) {
      parambnke.e = true;
    }
    for (;;)
    {
      PlayDownloadManagerWrap.getInstance().notifyDownloadFinish(parambnke, paramBoolean);
      PlayDownloadManagerWrap.access$300(PlayDownloadManagerWrap.getInstance(), parambnke.a);
      return;
      QLog.e("PlayDownloadManagerWrap", 1, "download failed with id: " + parambnke.a);
    }
  }
  
  public void onProgressUpdate(bnke parambnke, int paramInt)
  {
    if (paramInt <= 1) {
      return;
    }
    PlayDownloadManagerWrap.getInstance().notifyDownloadProgress(parambnke.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.PlayDownloadManagerWrap.DownloadProcessListener
 * JD-Core Version:    0.7.0.1
 */