package com.tencent.mobileqq.leba.qcircle.mgr;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import qqcircle.QQCircleSwitch.SetMultiCircleSwitchRsp;

class LebaQCircleTableMgrItem$SwitchBtnViewHolder$1$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.SetMultiCircleSwitchRsp>
{
  LebaQCircleTableMgrItem$SwitchBtnViewHolder$1$1(LebaQCircleTableMgrItem.SwitchBtnViewHolder.1 param1, boolean paramBoolean, String paramString) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.SetMultiCircleSwitchRsp paramSetMultiCircleSwitchRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      QLog.w("LebaQCircleTableMgrItem", 1, "setCircleSwitch success isChecked" + this.jdField_a_of_type_Boolean);
      if (!this.jdField_a_of_type_Boolean)
      {
        QCircleUtils.a().clearPedPoint();
        QLog.w("LebaQCircleTableMgrItem", 1, "setCircleSwitch success clearPedPoint");
      }
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramString = QzoneConfig.getInstance();
      if (this.jdField_a_of_type_Boolean)
      {
        paramBaseRequest = "0";
        paramString.updateOneConfig("qqcircle", "qqcircle_entrance_enable_on_children_mode", paramBaseRequest);
      }
    }
    else
    {
      paramString = QzoneConfig.getInstance();
      if (!this.jdField_a_of_type_Boolean) {
        break label154;
      }
    }
    label154:
    for (paramBaseRequest = "0";; paramBaseRequest = "1")
    {
      paramString.updateOneConfig("qqcircle", "qqcircle_entrance_enable", paramBaseRequest);
      QLog.w("LebaQCircleTableMgrItem", 1, "setCircleSwitch error retcode= " + paramLong);
      return;
      paramBaseRequest = "1";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mgr.LebaQCircleTableMgrItem.SwitchBtnViewHolder.1.1
 * JD-Core Version:    0.7.0.1
 */