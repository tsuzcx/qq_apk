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
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("setCircleSwitch success isChecked");
      paramBaseRequest.append(this.jdField_a_of_type_Boolean);
      QLog.w("LebaQCircleTableMgrItem", 1, paramBaseRequest.toString());
      if (!this.jdField_a_of_type_Boolean)
      {
        QCircleUtils.a().clearPedPoint();
        QLog.w("LebaQCircleTableMgrItem", 1, "setCircleSwitch success clearPedPoint");
      }
    }
    else
    {
      paramBoolean = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
      paramString = "0";
      if (!paramBoolean)
      {
        paramSetMultiCircleSwitchRsp = QzoneConfig.getInstance();
        if (this.jdField_a_of_type_Boolean) {
          paramBaseRequest = "0";
        } else {
          paramBaseRequest = "1";
        }
        paramSetMultiCircleSwitchRsp.updateOneConfig("qqcircle", "qqcircle_entrance_enable_on_children_mode", paramBaseRequest);
      }
      paramSetMultiCircleSwitchRsp = QzoneConfig.getInstance();
      if (this.jdField_a_of_type_Boolean) {
        paramBaseRequest = paramString;
      } else {
        paramBaseRequest = "1";
      }
      paramSetMultiCircleSwitchRsp.updateOneConfig("qqcircle", "qqcircle_entrance_enable", paramBaseRequest);
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("setCircleSwitch error retcode= ");
      paramBaseRequest.append(paramLong);
      QLog.w("LebaQCircleTableMgrItem", 1, paramBaseRequest.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mgr.LebaQCircleTableMgrItem.SwitchBtnViewHolder.1.1
 * JD-Core Version:    0.7.0.1
 */