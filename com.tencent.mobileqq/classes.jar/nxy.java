import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class nxy
  implements URLDrawable.DownloadListener
{
  nxy(nxx paramnxx) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    synchronized ()
    {
      String str = (String)nxx.a(this.a).get(0);
      nxx.a(this.a).remove(0);
      if (nxx.b(this.a) != null)
      {
        if (!nxx.b(this.a).contains(str)) {
          break label119;
        }
        nxx.b(this.a).remove(str);
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(delete) url:" + str);
        }
      }
      label119:
      do
      {
        nxx.a(this.a, null);
        nxx.a(this.a);
        return;
        nxx.a(this.a).add(str);
        nxx.b(this.a).add(str);
      } while (!QLog.isColorLevel());
      QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(retry) url:" + str);
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    synchronized ()
    {
      String str = (String)nxx.a(this.a).get(0);
      nxx.a(this.a).remove(0);
      if ((nxx.b(this.a) != null) && (nxx.b(this.a).contains(str))) {
        nxx.b(this.a).remove(str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadSucceed url:" + str);
      }
      nxx.a(this.a, null);
      nxx.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nxy
 * JD-Core Version:    0.7.0.1
 */