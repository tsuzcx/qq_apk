import android.app.Dialog;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;

public final class mby
  implements Runnable
{
  public void run()
  {
    try
    {
      if (VideoFeedsHelper.a != null)
      {
        VideoFeedsHelper.a.dismiss();
        VideoFeedsHelper.a = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mby
 * JD-Core Version:    0.7.0.1
 */