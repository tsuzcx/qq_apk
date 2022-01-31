import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class nlw
  implements URLDrawable.DownloadListener
{
  nlw(nlv paramnlv) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    synchronized ()
    {
      String str = (String)nlv.a(this.a).get(0);
      nlv.a(this.a).remove(0);
      if (nlv.b(this.a) != null)
      {
        if (!nlv.b(this.a).contains(str)) {
          break label119;
        }
        nlv.b(this.a).remove(str);
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(delete) url:" + str);
        }
      }
      label119:
      do
      {
        nlv.a(this.a, null);
        nlv.a(this.a);
        return;
        nlv.a(this.a).add(str);
        nlv.b(this.a).add(str);
      } while (!QLog.isColorLevel());
      QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(retry) url:" + str);
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    synchronized ()
    {
      String str = (String)nlv.a(this.a).get(0);
      nlv.a(this.a).remove(0);
      if ((nlv.b(this.a) != null) && (nlv.b(this.a).contains(str))) {
        nlv.b(this.a).remove(str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadSucceed url:" + str);
      }
      nlv.a(this.a, null);
      nlv.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nlw
 * JD-Core Version:    0.7.0.1
 */