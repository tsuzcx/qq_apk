package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
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
import mqq.app.AppRuntime;
import qqcircle.QQCircleCountergroup.GetGroupCountRsp;

public class QCircleMsgProcessor
  extends IShortcutBarProcessor
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private AIOShortcutBarContext jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
  private IShortcutBarDataProvider jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public QCircleMsgProcessor(AIOShortcutBarContext paramAIOShortcutBarContext, IShortcutBarDataProvider paramIShortcutBarDataProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext = paramAIOShortcutBarContext;
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider = paramIShortcutBarDataProvider;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramAIOShortcutBarContext.a();
    this.jdField_a_of_type_AndroidAppActivity = paramAIOShortcutBarContext.a();
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      return;
    }
    catch (Exception paramAIOShortcutBarContext) {}
  }
  
  private long a()
  {
    return a("key_last_close_troop_qcircle_msg_time", 0L);
  }
  
  private long a(String paramString, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
    if ((localObject != null) && (((AppRuntime)localObject).getApp() != null))
    {
      localObject = (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime;
      SharedPreferences localSharedPreferences = ((QQAppInterface)localObject).getApp().getSharedPreferences("qzone_sp_in_qq", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(((QQAppInterface)localObject).getCurrentUin());
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      return localSharedPreferences.getLong(localStringBuilder.toString(), paramLong);
    }
    if (QZLog.isColorLevel()) {
      QLog.e("QCircleMsgProcessor", 2, "getTime: mChatPie == null || mChatPie.app == null || mChatPie.app.getApp() == null");
    }
    return 0L;
  }
  
  private void a(long paramLong)
  {
    a("key_last_request_troop_qcircle_msg_time", paramLong);
  }
  
  private void a(String paramString, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
    if ((localObject != null) && (((AppRuntime)localObject).getApp() != null))
    {
      localObject = (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(((QQAppInterface)localObject).getCurrentUin());
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      paramString = localStringBuilder.toString();
      ((QQAppInterface)localObject).getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong(paramString, paramLong).apply();
      return;
    }
    if (QZLog.isColorLevel()) {
      QLog.e("QCircleMsgProcessor", 2, "setTime: mChatPie == null || mChatPie.app == null || mChatPie.app.getApp() == null");
    }
  }
  
  private void a(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    IShortcutBarDataProvider localIShortcutBarDataProvider = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
    if (localIShortcutBarDataProvider != null) {
      localIShortcutBarDataProvider.a(3, paramArrayList);
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
    boolean bool1 = QLog.isColorLevel();
    boolean bool3 = true;
    if (bool1) {
      QLog.i("QCircleMsgProcessor", 2, String.format("iSInCoolingTime: curTime=%ss, lastCloseTime=%ss, lastRequestTime=%ss, reqIntervalTime=%ss, \nclose gap=%ss, request gap=%ss", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l1 - l2), Long.valueOf(l1 - l3) }));
    }
    if (l1 - l2 < 86400L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (l1 - l3 < l4) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QCircleMsgProcessor", 2, String.format("iSInCoolingTime: isInCloseCoolingTime=%b, isInRequestCoolingTime=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    if (!bool1)
    {
      if (bool2) {
        return true;
      }
      bool3 = false;
    }
    return bool3;
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
    if (!QzoneConfig.isQQCircleShowTroopToolBarEntrance())
    {
      QLog.i("QCircleMsgProcessoronInit", 2, "QzoneConfig.isQQCircleShowTroopToolBarEntrance()==false");
      return;
    }
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCircleMsgProcessor", 2, "onInit: 冷却时间不发小世界快捷消息请求");
      }
      return;
    }
    ThreadManager.excute(new QCircleMsgProcessor.QCircleMsgTask(this, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long), 128, null, false);
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
    VSNetworkHelper.getInstance().cancelRequest(this.jdField_a_of_type_AndroidAppActivity);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.QCircleMsgProcessor
 * JD-Core Version:    0.7.0.1
 */