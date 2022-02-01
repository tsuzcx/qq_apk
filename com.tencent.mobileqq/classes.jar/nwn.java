import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class nwn
  implements URLDrawable.DownloadListener
{
  nwn(nwm paramnwm) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    synchronized ()
    {
      String str = (String)nwm.a(this.a).get(0);
      nwm.a(this.a).remove(0);
      if (nwm.b(this.a) != null)
      {
        if (!nwm.b(this.a).contains(str)) {
          break label119;
        }
        nwm.b(this.a).remove(str);
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(delete) url:" + str);
        }
      }
      label119:
      do
      {
        nwm.a(this.a, null);
        nwm.a(this.a);
        return;
        nwm.a(this.a).add(str);
        nwm.b(this.a).add(str);
      } while (!QLog.isColorLevel());
      QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(retry) url:" + str);
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    synchronized ()
    {
      String str = (String)nwm.a(this.a).get(0);
      nwm.a(this.a).remove(0);
      if ((nwm.b(this.a) != null) && (nwm.b(this.a).contains(str))) {
        nwm.b(this.a).remove(str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadSucceed url:" + str);
      }
      nwm.a(this.a, null);
      nwm.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nwn
 * JD-Core Version:    0.7.0.1
 */