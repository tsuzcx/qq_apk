import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class nja
  implements URLDrawable.DownloadListener
{
  nja(niz paramniz) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    synchronized ()
    {
      String str = (String)niz.a(this.a).get(0);
      niz.a(this.a).remove(0);
      if (niz.b(this.a) != null)
      {
        if (!niz.b(this.a).contains(str)) {
          break label119;
        }
        niz.b(this.a).remove(str);
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(delete) url:" + str);
        }
      }
      label119:
      do
      {
        niz.a(this.a, null);
        niz.a(this.a);
        return;
        niz.a(this.a).add(str);
        niz.b(this.a).add(str);
      } while (!QLog.isColorLevel());
      QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(retry) url:" + str);
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    synchronized ()
    {
      String str = (String)niz.a(this.a).get(0);
      niz.a(this.a).remove(0);
      if ((niz.b(this.a) != null) && (niz.b(this.a).contains(str))) {
        niz.b(this.a).remove(str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadSucceed url:" + str);
      }
      niz.a(this.a, null);
      niz.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nja
 * JD-Core Version:    0.7.0.1
 */