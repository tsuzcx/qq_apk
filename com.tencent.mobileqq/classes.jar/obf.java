import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailVideoManager.5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class obf
  implements TVK_SDKMgr.InstallListener
{
  public obf(AccountDetailVideoManager.5 param5) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailVideoManager", 2, "installSDK onInstalledFailed arg0=" + paramInt);
    }
    obb.a = false;
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailVideoManager", 2, "installSDK onInstalledSuccessed");
    }
    obb.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obf
 * JD-Core Version:    0.7.0.1
 */