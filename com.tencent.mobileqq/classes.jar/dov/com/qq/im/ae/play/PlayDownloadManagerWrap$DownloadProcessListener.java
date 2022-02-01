package dov.com.qq.im.ae.play;

import blvb;
import blvj;
import com.tencent.qphone.base.util.QLog;

class PlayDownloadManagerWrap$DownloadProcessListener
  implements blvj
{
  public void onDownloadFinish(blvb paramblvb, boolean paramBoolean)
  {
    if (paramblvb == null) {
      return;
    }
    paramblvb.f = false;
    if (paramBoolean) {
      paramblvb.e = true;
    }
    for (;;)
    {
      PlayDownloadManagerWrap.getInstance().notifyDownloadFinish(paramblvb, paramBoolean);
      PlayDownloadManagerWrap.access$300(PlayDownloadManagerWrap.getInstance(), paramblvb.a);
      return;
      QLog.e("PlayDownloadManagerWrap", 1, "download failed with id: " + paramblvb.a);
    }
  }
  
  public void onProgressUpdate(blvb paramblvb, int paramInt)
  {
    if (paramInt <= 1) {
      return;
    }
    PlayDownloadManagerWrap.getInstance().notifyDownloadProgress(paramblvb.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.PlayDownloadManagerWrap.DownloadProcessListener
 * JD-Core Version:    0.7.0.1
 */