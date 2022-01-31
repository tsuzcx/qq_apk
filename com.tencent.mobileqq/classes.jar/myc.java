import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class myc
  implements URLDrawable.DownloadListener
{
  myc(myb parammyb) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    synchronized ()
    {
      String str = (String)myb.a(this.a).get(0);
      myb.a(this.a).remove(0);
      if (myb.b(this.a) != null)
      {
        if (!myb.b(this.a).contains(str)) {
          break label119;
        }
        myb.b(this.a).remove(str);
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(delete) url:" + str);
        }
      }
      label119:
      do
      {
        myb.a(this.a, null);
        myb.a(this.a);
        return;
        myb.a(this.a).add(str);
        myb.b(this.a).add(str);
      } while (!QLog.isColorLevel());
      QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(retry) url:" + str);
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    synchronized ()
    {
      String str = (String)myb.a(this.a).get(0);
      myb.a(this.a).remove(0);
      if ((myb.b(this.a) != null) && (myb.b(this.a).contains(str))) {
        myb.b(this.a).remove(str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadSucceed url:" + str);
      }
      myb.a(this.a, null);
      myb.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     myc
 * JD-Core Version:    0.7.0.1
 */