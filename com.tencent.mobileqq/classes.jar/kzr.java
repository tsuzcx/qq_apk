import android.os.Handler;
import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class kzr
  implements INetInfoHandler
{
  public kzr(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, "network change from mobile to none");
    }
    ReadInJoyNativeAdAppVideoView.e(this.a, 6);
    ReadInJoyNativeAdAppVideoView.a(this.a).pause();
    QQToast.a(ReadInJoyNativeAdAppVideoView.a(this.a), 1, "视频加载失败，请稍后重试", 0).a();
    ReadInJoyNativeAdAppVideoView.a(this.a);
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, "network change from none to mobile");
    }
    ReadInJoyNativeAdAppVideoView.a(this.a).removeCallbacks(this.a.b);
    ReadInJoyNativeAdAppVideoView.e(this.a, 6);
    ReadInJoyNativeAdAppVideoView.a(this.a).pause();
    QQToast.a(ReadInJoyNativeAdAppVideoView.a(this.a), 0, "当前为非WiFi环境，继续播放将消耗流量", 0).a();
    ReadInJoyNativeAdAppVideoView.a(this.a);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, "network change from none to wifi");
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    ReadInJoyNativeAdAppVideoView.e(this.a, 6);
    ReadInJoyNativeAdAppVideoView.a(this.a).pause();
    QQToast.a(ReadInJoyNativeAdAppVideoView.a(this.a), 0, "当前为非WiFi环境，继续播放将消耗流量", 0).a();
    ReadInJoyNativeAdAppVideoView.a(this.a);
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, "network change from wifi to none");
    }
    ReadInJoyNativeAdAppVideoView.a(this.a).postDelayed(this.a.b, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kzr
 * JD-Core Version:    0.7.0.1
 */