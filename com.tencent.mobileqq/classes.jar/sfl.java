import com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob;
import com.tencent.image.URLDrawableHandler;

public class sfl
  implements URLDrawableHandler
{
  public sfl(RunningJob paramRunningJob) {}
  
  public void doCancel() {}
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted()
  {
    pdz.b(3, this.a.a);
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    if (this.a.a.d == 0) {
      pdz.b(2, this.a.a);
    }
  }
  
  public void publishProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sfl
 * JD-Core Version:    0.7.0.1
 */