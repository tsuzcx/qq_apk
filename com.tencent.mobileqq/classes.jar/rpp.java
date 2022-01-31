import com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob;
import com.tencent.image.URLDrawableHandler;

public class rpp
  implements URLDrawableHandler
{
  public rpp(RunningJob paramRunningJob) {}
  
  public void doCancel() {}
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
  
  public void publishProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpp
 * JD-Core Version:    0.7.0.1
 */