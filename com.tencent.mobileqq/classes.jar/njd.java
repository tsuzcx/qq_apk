import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class njd
  implements URLDrawable.DownloadListener
{
  njd(njc paramnjc) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    synchronized ()
    {
      String str = (String)njc.a(this.a).get(0);
      njc.a(this.a).remove(0);
      if (njc.b(this.a) != null)
      {
        if (!njc.b(this.a).contains(str)) {
          break label119;
        }
        njc.b(this.a).remove(str);
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(delete) url:" + str);
        }
      }
      label119:
      do
      {
        njc.a(this.a, null);
        njc.a(this.a);
        return;
        njc.a(this.a).add(str);
        njc.b(this.a).add(str);
      } while (!QLog.isColorLevel());
      QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(retry) url:" + str);
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    synchronized ()
    {
      String str = (String)njc.a(this.a).get(0);
      njc.a(this.a).remove(0);
      if ((njc.b(this.a) != null) && (njc.b(this.a).contains(str))) {
        njc.b(this.a).remove(str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadSucceed url:" + str);
      }
      njc.a(this.a, null);
      njc.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     njd
 * JD-Core Version:    0.7.0.1
 */