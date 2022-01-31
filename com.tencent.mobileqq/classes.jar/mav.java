import android.app.Dialog;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;

public final class mav
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
 * Qualified Name:     mav
 * JD-Core Version:    0.7.0.1
 */