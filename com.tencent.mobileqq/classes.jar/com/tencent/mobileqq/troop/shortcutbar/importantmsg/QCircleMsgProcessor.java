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
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import qqcircle.QQCircleCountergroup.GetGroupCountRsp;

public class QCircleMsgProcessor
  extends IShortcutBarProcessor
{
  private AIOShortcutBarContext a;
  private IShortcutBarDataProvider b;
  private long c;
  private SessionInfo d;
  private Activity e;
  private AppRuntime f;
  
  public QCircleMsgProcessor(AIOShortcutBarContext paramAIOShortcutBarContext, IShortcutBarDataProvider paramIShortcutBarDataProvider)
  {
    this.a = paramAIOShortcutBarContext;
    this.b = paramIShortcutBarDataProvider;
    this.d = paramAIOShortcutBarContext.d();
    this.e = paramAIOShortcutBarContext.f();
    try
    {
      this.c = Long.parseLong(this.d.b);
      return;
    }
    catch (Exception paramAIOShortcutBarContext) {}
  }
  
  private long a(String paramString, long paramLong)
  {
    Object localObject = this.f;
    if ((localObject != null) && (((AppRuntime)localObject).getApp() != null))
    {
      localObject = (QQAppInterface)this.f;
      SharedPreferences localSharedPreferences = ((QQAppInterface)localObject).getApp().getSharedPreferences("qzone_sp_in_qq", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(((QQAppInterface)localObject).getCurrentUin());
      localStringBuilder.append("_");
      localStringBuilder.append(this.c);
      return localSharedPreferences.getLong(localStringBuilder.toString(), paramLong);
    }
    if (QZLog.isColorLevel()) {
      QLog.e("QCircleMsgProcessor", 2, "getTime: mChatPie == null || mChatPie.app == null || mChatPie.app.getApp() == null");
    }
    return 0L;
  }
  
  private void a(long paramLong)
  {
    b("key_last_request_troop_qcircle_msg_time", paramLong);
  }
  
  private void a(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    IShortcutBarDataProvider localIShortcutBarDataProvider = this.b;
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
  
  private void b(long paramLong)
  {
    b("key_request_troop_qcircle_msg_time_interval", paramLong);
  }
  
  private void b(String paramString, long paramLong)
  {
    Object localObject = this.f;
    if ((localObject != null) && (((AppRuntime)localObject).getApp() != null))
    {
      localObject = (QQAppInterface)this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(((QQAppInterface)localObject).getCurrentUin());
      localStringBuilder.append("_");
      localStringBuilder.append(this.c);
      paramString = localStringBuilder.toString();
      ((QQAppInterface)localObject).getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong(paramString, paramLong).apply();
      return;
    }
    if (QZLog.isColorLevel()) {
      QLog.e("QCircleMsgProcessor", 2, "setTime: mChatPie == null || mChatPie.app == null || mChatPie.app.getApp() == null");
    }
  }
  
  private void e()
  {
    if (!QCircleConfigHelper.ai())
    {
      QLog.i("QCircleMsgProcessoronInit", 2, "QzoneConfig.isQQCircleShowTroopToolBarEntrance()==false");
      return;
    }
    if (g())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCircleMsgProcessor", 2, "onInit: 冷却时间不发小世界快捷消息请求");
      }
      return;
    }
    ThreadManager.excute(new QCircleMsgProcessor.QCircleMsgTask(this, this.e, this.c), 128, null, false);
  }
  
  private void f()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_troop_uin", String.valueOf(this.c));
    localHashMap.put("key_jump_from", "24");
    QCircleUtils.a().enterBySchemeAction(BaseApplicationImpl.getContext(), "openAggregation", localHashMap);
  }
  
  private boolean g()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    long l2 = h();
    long l3 = j();
    long l4 = k();
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
  
  private long h()
  {
    return a("key_last_close_troop_qcircle_msg_time", 0L);
  }
  
  private void i()
  {
    b("key_last_close_troop_qcircle_msg_time", NetConnInfoCenter.getServerTimeMillis() / 1000L);
  }
  
  private long j()
  {
    return a("key_last_request_troop_qcircle_msg_time", 0L);
  }
  
  private long k()
  {
    return a("key_request_troop_qcircle_msg_time_interval", 1200L);
  }
  
  public void a()
  {
    VSNetworkHelper.getInstance().cancelRequest(this.e);
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof QCircleMsgInfo)) {
      return;
    }
    QLog.d("QCircleMsgProcessor", 2, "QCircleMsgInfo onClick");
    f();
    ReportController.b(null, "dc00898", "", String.valueOf(this.c), "0X800B24F", "0X800B24F", 0, 0, "", "", "", "");
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
    i();
    ReportController.b(null, "dc00898", "", String.valueOf(this.c), "0X800B252", "0X800B252", 0, 0, "", "", "", "");
  }
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.QCircleMsgProcessor
 * JD-Core Version:    0.7.0.1
 */