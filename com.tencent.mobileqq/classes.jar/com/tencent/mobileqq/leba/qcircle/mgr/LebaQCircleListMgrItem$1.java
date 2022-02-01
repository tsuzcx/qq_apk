package com.tencent.mobileqq.leba.qcircle.mgr;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import qqcircle.QQCircleSwitch.SetMultiCircleSwitchRsp;

class LebaQCircleListMgrItem$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.SetMultiCircleSwitchRsp>
{
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.SetMultiCircleSwitchRsp paramSetMultiCircleSwitchRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("list setCircleSwitch success isChecked");
      paramBaseRequest.append(this.a);
      QLog.w("LebaQCircleListMgrItem", 1, paramBaseRequest.toString());
      if (!this.a)
      {
        QCircleUtils.b().clearPedPoint();
        QLog.w("LebaQCircleListMgrItem", 1, "list setCircleSwitch success clearPedPoint");
      }
    }
    else
    {
      paramBoolean = TextUtils.isEmpty(this.b);
      paramString = "0";
      if (!paramBoolean)
      {
        paramSetMultiCircleSwitchRsp = QzoneConfig.getInstance();
        if (this.a) {
          paramBaseRequest = "0";
        } else {
          paramBaseRequest = "1";
        }
        paramSetMultiCircleSwitchRsp.updateOneConfig("qqcircle", "qqcircle_entrance_enable_on_children_mode", paramBaseRequest);
      }
      paramSetMultiCircleSwitchRsp = QzoneConfig.getInstance();
      if (this.a) {
        paramBaseRequest = paramString;
      } else {
        paramBaseRequest = "1";
      }
      paramSetMultiCircleSwitchRsp.updateOneConfig("qqcircle", "qqcircle_entrance_enable", paramBaseRequest);
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("list setCircleSwitch error retcode= ");
      paramBaseRequest.append(paramLong);
      QLog.w("LebaQCircleListMgrItem", 1, paramBaseRequest.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mgr.LebaQCircleListMgrItem.1
 * JD-Core Version:    0.7.0.1
 */