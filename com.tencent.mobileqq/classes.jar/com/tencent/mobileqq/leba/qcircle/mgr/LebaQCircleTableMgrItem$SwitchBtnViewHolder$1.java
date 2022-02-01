package com.tencent.mobileqq.leba.qcircle.mgr;

import android.text.TextUtils;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetMultiCircleWnsConfigRequest;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.HashMap;

class LebaQCircleTableMgrItem$SwitchBtnViewHolder$1
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    String str = "1";
    if (paramBoolean) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    HashMap localHashMap = new HashMap();
    if ((!StudyModeManager.h()) && (paramBoolean)) {
      str = "";
    } else if (!paramBoolean) {
      str = "0";
    }
    if (!TextUtils.isEmpty(str))
    {
      localHashMap.put("qqcircle_entrance_enable_on_children_mode", str);
      QzoneConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_entrance_enable_on_children_mode", str);
    }
    localHashMap.put("qqcircle_entrance_enable", localObject);
    QzoneConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_entrance_enable", (String)localObject);
    Object localObject = new HashMap();
    ((HashMap)localObject).put("qqcircle", localHashMap);
    localObject = new QCircleSetMultiCircleWnsConfigRequest((HashMap)localObject);
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new LebaQCircleTableMgrItem.SwitchBtnViewHolder.1.1(this, paramBoolean, str));
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mgr.LebaQCircleTableMgrItem.SwitchBtnViewHolder.1
 * JD-Core Version:    0.7.0.1
 */