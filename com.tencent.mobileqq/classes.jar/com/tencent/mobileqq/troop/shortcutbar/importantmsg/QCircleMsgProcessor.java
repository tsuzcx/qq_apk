package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleClassApi;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.shortcutbar.IShortcutBarDataProvider;
import com.tencent.mobileqq.troop.shortcutbar.IShortcutBarProcessor;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import qqcircle.QQCircleCountergroup.GetGroupCountRsp;

public class QCircleMsgProcessor
  extends IShortcutBarProcessor
{
  private long jdField_a_of_type_Long;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private IShortcutBarDataProvider jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
  
  public QCircleMsgProcessor(BaseChatPie paramBaseChatPie, IShortcutBarDataProvider paramIShortcutBarDataProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider = paramIShortcutBarDataProvider;
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      return;
    }
    catch (Exception paramBaseChatPie) {}
  }
  
  private long a()
  {
    return a("key_last_close_troop_qcircle_msg_time", 0L);
  }
  
  private long a(String paramString, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null))
    {
      if (QZLog.isColorLevel()) {
        QLog.e("QCircleMsgProcessor", 2, "getTime: mChatPie == null || mChatPie.app == null || mChatPie.app.getApp() == null");
      }
      return 0L;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    return localQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getLong(paramString + "_" + localQQAppInterface.getCurrentUin() + "_" + this.jdField_a_of_type_Long, paramLong);
  }
  
  private void a(long paramLong)
  {
    a("key_last_request_troop_qcircle_msg_time", paramLong);
  }
  
  private void a(String paramString, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null))
    {
      if (QZLog.isColorLevel()) {
        QLog.e("QCircleMsgProcessor", 2, "setTime: mChatPie == null || mChatPie.app == null || mChatPie.app.getApp() == null");
      }
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramString = paramString + "_" + localQQAppInterface.getCurrentUin() + "_" + this.jdField_a_of_type_Long;
    localQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong(paramString, paramLong).apply();
  }
  
  private void a(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider.a(3, paramArrayList);
    }
  }
  
  private void a(QQCircleCountergroup.GetGroupCountRsp paramGetGroupCountRsp)
  {
    QCircleMsgInfo localQCircleMsgInfo = new QCircleMsgInfo();
    localQCircleMsgInfo.b(paramGetGroupCountRsp.iconUrl.get());
    localQCircleMsgInfo.a(paramGetGroupCountRsp.content.get());
    localQCircleMsgInfo.a(0);
    localQCircleMsgInfo.b(paramGetGroupCountRsp.latestFeedTime.get());
    paramGetGroupCountRsp = new ArrayList();
    paramGetGroupCountRsp.add(localQCircleMsgInfo);
    a(paramGetGroupCountRsp);
  }
  
  private boolean a()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    long l2 = a();
    long l3 = b();
    long l4 = c();
    if (QLog.isColorLevel()) {
      QLog.i("QCircleMsgProcessor", 2, String.format("iSInCoolingTime: curTime=%ss, lastCloseTime=%ss, lastRequestTime=%ss, reqIntervalTime=%ss, \nclose gap=%ss, request gap=%ss", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l1 - l2), Long.valueOf(l1 - l3) }));
    }
    boolean bool1;
    if (l1 - l2 < 86400L)
    {
      bool1 = true;
      if (l1 - l3 >= l4) {
        break label177;
      }
    }
    label177:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCircleMsgProcessor", 2, String.format("iSInCoolingTime: isInCloseCoolingTime=%b, isInRequestCoolingTime=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if ((!bool1) && (!bool2)) {
        break label183;
      }
      return true;
      bool1 = false;
      break;
    }
    label183:
    return false;
  }
  
  private long b()
  {
    return a("key_last_request_troop_qcircle_msg_time", 0L);
  }
  
  private void b(long paramLong)
  {
    a("key_request_troop_qcircle_msg_time_interval", paramLong);
  }
  
  private long c()
  {
    return a("key_request_troop_qcircle_msg_time_interval", 1200L);
  }
  
  private void e()
  {
    if (!QzoneConfig.isQQCircleShowTroopToolBarEntrance()) {
      QLog.i("QCircleMsgProcessoronInit", 2, "QzoneConfig.isQQCircleShowTroopToolBarEntrance()==false");
    }
    do
    {
      return;
      if (!a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QCircleMsgProcessor", 2, "onInit: 冷却时间不发小世界快捷消息请求");
    return;
    VSNetworkHelper.getInstance().sendRequest(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), ((IQCircleClassApi)QRoute.api(IQCircleClassApi.class)).getQQCircleGetGroupCountRequest(this.jdField_a_of_type_Long), new QCircleMsgProcessor.1(this));
  }
  
  private void f()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_troop_uin", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("key_jump_from", "24");
    QCircleUtils.a().enterBySchemeAction(BaseApplicationImpl.getContext(), "openAggregation", localHashMap);
  }
  
  private void g()
  {
    a("key_last_close_troop_qcircle_msg_time", NetConnInfoCenter.getServerTimeMillis() / 1000L);
  }
  
  public void a()
  {
    VSNetworkHelper.getInstance().cancelRequest(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof QCircleMsgInfo)) {
      return;
    }
    QLog.d("QCircleMsgProcessor", 2, "QCircleMsgInfo onClick");
    f();
    ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800B24F", "0X800B24F", 0, 0, "", "", "", "");
  }
  
  public void b()
  {
    e();
  }
  
  public void b(Object paramObject)
  {
    if (!(paramObject instanceof QCircleMsgInfo)) {
      return;
    }
    QLog.d("QCircleMsgProcessor", 2, "QCircleMsgInfo onClickMessageCloseBtn");
    a((ArrayList)null);
    g();
    ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_Long), "0X800B252", "0X800B252", 0, 0, "", "", "", "");
  }
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.QCircleMsgProcessor
 * JD-Core Version:    0.7.0.1
 */