import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class oey
  implements URLDrawable.DownloadListener
{
  oey(oex paramoex) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    synchronized ()
    {
      String str = (String)oex.a(this.a).get(0);
      oex.a(this.a).remove(0);
      if (oex.b(this.a) != null)
      {
        if (!oex.b(this.a).contains(str)) {
          break label119;
        }
        oex.b(this.a).remove(str);
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(delete) url:" + str);
        }
      }
      label119:
      do
      {
        oex.a(this.a, null);
        oex.a(this.a);
        return;
        oex.a(this.a).add(str);
        oex.b(this.a).add(str);
      } while (!QLog.isColorLevel());
      QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(retry) url:" + str);
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    synchronized ()
    {
      String str = (String)oex.a(this.a).get(0);
      oex.a(this.a).remove(0);
      if ((oex.b(this.a) != null) && (oex.b(this.a).contains(str))) {
        oex.b(this.a).remove(str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadSucceed url:" + str);
      }
      oex.a(this.a, null);
      oex.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oey
 * JD-Core Version:    0.7.0.1
 */