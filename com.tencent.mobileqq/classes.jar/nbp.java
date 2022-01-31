import android.os.Handler;
import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class nbp
  implements INetInfoHandler
{
  public nbp(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, "network change from mobile to none");
    }
    ReadInJoyNativeAdAppVideoView.e(this.a, 6);
    ReadInJoyNativeAdAppVideoView.a(this.a).pause();
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
 * Qualified Name:     nbp
 * JD-Core Version:    0.7.0.1
 */