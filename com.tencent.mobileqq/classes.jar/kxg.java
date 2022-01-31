import android.os.Handler;
import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class kxg
  implements TVK_SDKMgr.InstallListener
{
  kxg(kxf paramkxf) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, "install sdk failed");
    }
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppVideoView", 2, "install sdk success");
    }
    ReadInJoyNativeAdAppVideoView.a(this.a.a).post(new kxh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kxg
 * JD-Core Version:    0.7.0.1
 */