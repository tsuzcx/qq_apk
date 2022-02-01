package dov.com.qq.im.ae.download.old;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.lang.ref.WeakReference;

class AEOldQuicResDownload$MyRunnable
  implements Runnable
{
  private WeakReference<QQAppInterface> a;
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (QQAppInterface)((WeakReference)localObject).get();
      if (localObject != null)
      {
        VideoEnvironment.LogDownLoad("AEOldQuicResDownload", "start download quic res", null);
        AEOldQuicResDownload.a(new AEOldQuicResDownload((QQAppInterface)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldQuicResDownload.MyRunnable
 * JD-Core Version:    0.7.0.1
 */