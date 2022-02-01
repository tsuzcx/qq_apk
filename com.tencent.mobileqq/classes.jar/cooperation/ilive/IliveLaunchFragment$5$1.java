package cooperation.ilive;

import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.util.ElapseStat;
import java.util.HashMap;

class IliveLaunchFragment$5$1
  implements SDKInitListener
{
  IliveLaunchFragment$5$1(IliveLaunchFragment.5 param5) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    ElapseStat.b("IliveLaunch initSDKAsync");
    HashMap localHashMap = new HashMap();
    if (QQVideoPlaySDKManager.b()) {}
    for (String str = "sucess";; str = "error")
    {
      localHashMap.put("status_msg", str);
      localHashMap.put("isDebug", "0");
      VasStatisticCollector.a("live_player_load", localHashMap, System.currentTimeMillis() - this.a.jdField_a_of_type_Long);
      QLog.e("IliveLaunchActivity", 1, "initVideoSDK status = " + QQVideoPlaySDKManager.b());
      IliveLaunchFragment.access$202(this.a.jdField_a_of_type_CooperationIliveIliveLaunchFragment, QQVideoPlaySDKManager.b());
      QLog.e("IliveLaunchActivity", 1, "initVideoSDK onSDKInited = " + paramBoolean);
      if (!IliveLaunchFragment.access$200(this.a.jdField_a_of_type_CooperationIliveIliveLaunchFragment)) {
        this.a.jdField_a_of_type_CooperationIliveIliveLaunchFragment.onFail(108, "media play so load fail");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment.5.1
 * JD-Core Version:    0.7.0.1
 */