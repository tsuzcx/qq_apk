import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class kzs
  implements Runnable
{
  public kzs(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView) {}
  
  public void run()
  {
    ReadInJoyNativeAdAppVideoView.e(this.a, 6);
    ReadInJoyNativeAdAppVideoView.a(this.a).pause();
    QQToast.a(ReadInJoyNativeAdAppVideoView.a(this.a), 1, "视频加载失败，请稍后重试", 0).a();
    ReadInJoyNativeAdAppVideoView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kzs
 * JD-Core Version:    0.7.0.1
 */