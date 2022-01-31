import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailVideoManager.5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class nfk
  implements TVK_SDKMgr.InstallListener
{
  public nfk(AccountDetailVideoManager.5 param5) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailVideoManager", 2, "installSDK onInstalledFailed arg0=" + paramInt);
    }
    nfg.a = false;
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailVideoManager", 2, "installSDK onInstalledSuccessed");
    }
    nfg.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfk
 * JD-Core Version:    0.7.0.1
 */