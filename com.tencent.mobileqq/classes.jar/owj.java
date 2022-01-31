import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.WeakReferenceRunnable;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class owj
  implements TVK_SDKMgr.InstallListener
{
  public owj(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment) {}
  
  public void onInstallProgress(float paramFloat)
  {
    yxp.a("ReadInjoyIMAXAdFragment", "installSDK onInstallProgress arg0=");
  }
  
  public void onInstalledFailed(int paramInt)
  {
    yxp.a("ReadInjoyIMAXAdFragment", "installSDK onInstalledFailed arg0=");
  }
  
  public void onInstalledSuccessed()
  {
    yxp.a("ReadInjoyIMAXAdFragment", "installSDK onInstalledSuccessed");
    if ((ReadInjoyIMAXAdFragment.a()) && (ReadInjoyIMAXAdFragment.b(this.a) != null)) {
      ReadInjoyIMAXAdFragment.b(this.a).post(new ReadInjoyIMAXAdFragment.WeakReferenceRunnable(this.a, 4));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owj
 * JD-Core Version:    0.7.0.1
 */