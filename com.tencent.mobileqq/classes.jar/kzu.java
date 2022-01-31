import android.os.Handler;
import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class kzu
  implements Runnable
{
  public kzu(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView) {}
  
  public void run()
  {
    ReadInJoyNativeAdAppVideoView.a(this.a).start();
    ReadInJoyNativeAdAppVideoView.e(this.a, 4);
    ReadInJoyNativeAdAppVideoView.a(this.a);
    ReadInJoyNativeAdAppVideoView.a(this.a).post(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kzu
 * JD-Core Version:    0.7.0.1
 */