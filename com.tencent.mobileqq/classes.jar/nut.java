import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class nut
  implements URLDrawable.DownloadListener
{
  nut(nus paramnus) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    synchronized ()
    {
      String str = (String)nus.a(this.a).get(0);
      nus.a(this.a).remove(0);
      if (nus.b(this.a) != null)
      {
        if (!nus.b(this.a).contains(str)) {
          break label119;
        }
        nus.b(this.a).remove(str);
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(delete) url:" + str);
        }
      }
      label119:
      do
      {
        nus.a(this.a, null);
        nus.a(this.a);
        return;
        nus.a(this.a).add(str);
        nus.b(this.a).add(str);
      } while (!QLog.isColorLevel());
      QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(retry) url:" + str);
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    synchronized ()
    {
      String str = (String)nus.a(this.a).get(0);
      nus.a(this.a).remove(0);
      if ((nus.b(this.a) != null) && (nus.b(this.a).contains(str))) {
        nus.b(this.a).remove(str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadSucceed url:" + str);
      }
      nus.a(this.a, null);
      nus.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nut
 * JD-Core Version:    0.7.0.1
 */