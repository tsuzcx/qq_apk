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
    if (QQVideoPlaySDKManager.b()) {
      localObject = "sucess";
    } else {
      localObject = "error";
    }
    localHashMap.put("status_msg", localObject);
    localHashMap.put("isDebug", "0");
    VasStatisticCollector.a("live_player_load", localHashMap, System.currentTimeMillis() - this.a.jdField_a_of_type_Long);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initVideoSDK status = ");
    ((StringBuilder)localObject).append(QQVideoPlaySDKManager.b());
    QLog.e("IliveLaunchActivity", 1, ((StringBuilder)localObject).toString());
    IliveLaunchFragment.access$202(this.a.jdField_a_of_type_CooperationIliveIliveLaunchFragment, QQVideoPlaySDKManager.b());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initVideoSDK onSDKInited = ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.e("IliveLaunchActivity", 1, ((StringBuilder)localObject).toString());
    if (!IliveLaunchFragment.access$200(this.a.jdField_a_of_type_CooperationIliveIliveLaunchFragment)) {
      this.a.jdField_a_of_type_CooperationIliveIliveLaunchFragment.onFail(108, "media play so load fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment.5.1
 * JD-Core Version:    0.7.0.1
 */