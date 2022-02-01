package com.tencent.mobileqq.leba.qcircle.more;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.leba.business.ILabaMoreVipBiz;
import com.tencent.mobileqq.leba.entity.LebaMoreViewItem;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetMultiCircleWnsConfigRequest;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaMoreQCircleBiz
  extends ILabaMoreVipBiz
{
  public void a(int paramInt, boolean paramBoolean, List<LebaMoreViewItem> paramList1, List<LebaMoreViewItem> paramList2)
  {
    if (paramInt != 0) {
      return;
    }
    if (!QCircleConfigHelper.c(false)) {
      return;
    }
    paramBoolean = QCircleConfigHelper.e(false);
    LebaMoreViewItem localLebaMoreViewItem = new LebaMoreViewItem();
    localLebaMoreViewItem.a = 2;
    localLebaMoreViewItem.e = true;
    localLebaMoreViewItem.d = paramBoolean;
    localLebaMoreViewItem.f = 2;
    localLebaMoreViewItem.c = new LebaViewItem();
    localLebaMoreViewItem.c.b = new LebaPluginInfo();
    localLebaMoreViewItem.g = 2130846950;
    localLebaMoreViewItem.h = QCircleConfigHelper.bo();
    localLebaMoreViewItem.i = true;
    if (paramBoolean)
    {
      localLebaMoreViewItem.c.a();
      paramList1.add(localLebaMoreViewItem);
      return;
    }
    localLebaMoreViewItem.c.b();
    paramList2.add(localLebaMoreViewItem);
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean, LebaMoreViewItem paramLebaMoreViewItem)
  {
    if (paramLebaMoreViewItem.f != 2) {
      return;
    }
    paramAppRuntime = "1";
    if (paramBoolean) {
      paramLebaMoreViewItem = "1";
    } else {
      paramLebaMoreViewItem = "0";
    }
    HashMap localHashMap = new HashMap();
    if ((!StudyModeManager.h()) && (paramBoolean)) {
      paramAppRuntime = "";
    } else if (!paramBoolean) {
      paramAppRuntime = "0";
    }
    if (!TextUtils.isEmpty(paramAppRuntime))
    {
      localHashMap.put("qqcircle_entrance_enable_on_children_mode", paramAppRuntime);
      QzoneConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_entrance_enable_on_children_mode", paramAppRuntime);
    }
    localHashMap.put("qqcircle_entrance_enable", paramLebaMoreViewItem);
    QzoneConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_entrance_enable", paramLebaMoreViewItem);
    paramLebaMoreViewItem = new HashMap();
    paramLebaMoreViewItem.put("qqcircle", localHashMap);
    paramLebaMoreViewItem = new QCircleSetMultiCircleWnsConfigRequest(paramLebaMoreViewItem);
    VSNetworkHelper.getInstance().sendRequest(paramLebaMoreViewItem, new LebaMoreQCircleBiz.1(this, paramBoolean, paramAppRuntime));
  }
  
  public boolean a(LebaMoreViewItem paramLebaMoreViewItem)
  {
    if ((paramLebaMoreViewItem.e) && (paramLebaMoreViewItem.f == 2))
    {
      if (a() == null) {
        return false;
      }
      paramLebaMoreViewItem = new HashMap();
      paramLebaMoreViewItem.put("xsj_main_entrance", "qq_updates_tab_second");
      QCircleUtils.a().enterBySchemeAction(a(), "openfolder", paramLebaMoreViewItem, null);
      if (!TextUtils.isEmpty(QCircleHostGlobalInfo.getEntranceGuideTips())) {
        QCircleHostGlobalInfo.setHasShowEntranceGuideTips(true);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.more.LebaMoreQCircleBiz
 * JD-Core Version:    0.7.0.1
 */