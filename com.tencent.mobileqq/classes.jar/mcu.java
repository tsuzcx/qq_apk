import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import java.lang.ref.WeakReference;

public class mcu
  implements Runnable
{
  public mcu(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    if (VideoFeedsPlayManager.a(this.a) == null) {
      return;
    }
    VideoFeedsPlayManager.a(this.a).removeMessages(-2);
    new WeakReference(VideoFeedsPlayManager.a(this.a));
    new WeakReference(VideoFeedsPlayManager.a(this.a));
    VideoFeedsPlayManager.a(this.a).sendEmptyMessage(-2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mcu
 * JD-Core Version:    0.7.0.1
 */