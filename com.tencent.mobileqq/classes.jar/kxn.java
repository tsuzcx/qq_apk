import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class kxn
  implements Runnable
{
  public kxn(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView) {}
  
  public void run()
  {
    ReadInJoyNativeAdAppVideoView.a(this.a).start();
    ReadInJoyNativeAdAppVideoView.e(this.a, 3);
    ReadInJoyNativeAdAppVideoView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kxn
 * JD-Core Version:    0.7.0.1
 */