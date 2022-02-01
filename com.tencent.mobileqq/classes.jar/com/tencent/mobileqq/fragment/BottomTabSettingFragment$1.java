package com.tencent.mobileqq.fragment;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import qqcircle.QQCircleSwitch.SetCircleSwitchRsp;

class BottomTabSettingFragment$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.SetCircleSwitchRsp>
{
  BottomTabSettingFragment$1(BottomTabSettingFragment paramBottomTabSettingFragment, boolean paramBoolean, String paramString) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.SetCircleSwitchRsp paramSetCircleSwitchRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("toggleQCircleTab success isChecked");
      paramBaseRequest.append(this.jdField_a_of_type_Boolean);
      QLog.w("BottomTabSettingFragment", 1, paramBaseRequest.toString());
      paramString = QzoneConfig.getInstance();
      paramSetCircleSwitchRsp = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Boolean) {
        paramBaseRequest = "1";
      } else {
        paramBaseRequest = "0";
      }
      paramString.updateOneConfig("qqcircle", paramSetCircleSwitchRsp, paramBaseRequest);
      if (!this.jdField_a_of_type_Boolean)
      {
        QCircleUtils.a().clearPedPoint();
        QLog.w("BottomTabSettingFragment", 1, "toggleQCircleTab success clearPedPoint");
      }
    }
    else
    {
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("toggleQCircleTab error retcode= ");
      paramBaseRequest.append(paramLong);
      QLog.w("BottomTabSettingFragment", 1, paramBaseRequest.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.BottomTabSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */