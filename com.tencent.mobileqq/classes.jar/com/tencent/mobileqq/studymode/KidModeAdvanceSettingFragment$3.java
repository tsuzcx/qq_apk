package com.tencent.mobileqq.studymode;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import qqcircle.QQCircleSwitch.GetCircleSwitchRsp;
import qqcircle.QQCircleSwitch.StSwitch;

class KidModeAdvanceSettingFragment$3
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.GetCircleSwitchRsp>
{
  KidModeAdvanceSettingFragment$3(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.GetCircleSwitchRsp paramGetCircleSwitchRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramBaseRequest = paramGetCircleSwitchRsp.sw.value.get();
      QLog.d("IphoneTitleBarFragment", 1, "requestEntertainCount GetCircleSwitch success" + paramBaseRequest);
      QzoneConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_entrance_enable", paramBaseRequest);
    }
    for (;;)
    {
      KidModeAdvanceSettingFragment.b(this.a);
      return;
      QLog.d("IphoneTitleBarFragment", 1, "requestEntertainCount GetCircleSwitch error retcode= " + paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */