package cooperation.ilive;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.util.ElapseStat;

class IliveLaunchFragment$5
  implements LoadSoCallback
{
  IliveLaunchFragment$5(IliveLaunchFragment paramIliveLaunchFragment, long paramLong) {}
  
  public void onLoad(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initVideoSDK loadSo = ");
    localStringBuilder.append(paramBoolean);
    QLog.e("IliveLaunchActivity", 1, localStringBuilder.toString());
    ElapseStat.b("IliveLaunch initVideoSDK");
    if (paramBoolean)
    {
      ElapseStat.a("IliveLaunch initSDKAsync");
      QQVideoPlaySDKManager.a(BaseApplicationImpl.getApplication(), new IliveLaunchFragment.5.1(this));
      return;
    }
    this.jdField_a_of_type_CooperationIliveIliveLaunchFragment.onFail(108, "media play so load fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment.5
 * JD-Core Version:    0.7.0.1
 */