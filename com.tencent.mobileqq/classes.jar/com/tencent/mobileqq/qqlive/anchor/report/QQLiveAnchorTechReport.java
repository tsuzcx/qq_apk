package com.tencent.mobileqq.qqlive.anchor.report;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.datareport.ReportTask;
import com.tencent.mobileqq.qqlive.data.datareport.StatisticData;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class QQLiveAnchorTechReport
{
  private static final ConcurrentHashMap<String, Long> a = new ConcurrentHashMap();
  private IDataReportModule b;
  private boolean c = false;
  private QQLiveAnchorRoom d;
  private boolean e = false;
  private boolean f = false;
  private long g = System.currentTimeMillis();
  private String h = null;
  private int i = -1;
  private boolean j;
  private long k = 0L;
  private IQQLiveAnchorRoomThirdPushCallback l = new QQLiveAnchorTechReport.1(this);
  
  private ReportTask a(String paramString, boolean paramBoolean, QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    i();
    k();
    j();
    try
    {
      localReportTask = this.b.newReportTask().setEventName(paramString).addKeyValue("sequenceId", this.h).addKeyValue("networkType", NetworkUtil.getNetWorkType()).addKeyValue("sdkVersion", "1.0.0");
      paramString = this.d.g();
      str = "";
      if (paramString == null) {
        paramString = "";
      } else {
        paramString = this.d.g().getCurrentUin();
      }
      paramString = localReportTask.addKeyValue("qqUin", paramString).addKeyValue("liveType", h());
      n = 0;
      if ((paramBoolean) || (paramQQLiveErrorMsg == null)) {
        break label247;
      }
      m = paramQQLiveErrorMsg.bizErrCode;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        ReportTask localReportTask;
        String str;
        int n;
        continue;
        int m = 0;
        continue;
        paramString = "";
      }
    }
    localReportTask = paramString.addKeyValue("errCode", m);
    if ((!paramBoolean) && (paramQQLiveErrorMsg != null))
    {
      paramString = paramQQLiveErrorMsg.bizErrMsg;
      paramString = localReportTask.addKeyValue("errMsg", paramString);
      if (paramQQLiveErrorMsg == null) {
        m = n;
      } else {
        m = paramQQLiveErrorMsg.originErrCode;
      }
      localReportTask = paramString.addKeyValue("originErrCode", m);
      if (paramQQLiveErrorMsg == null) {
        paramString = str;
      } else {
        paramString = paramQQLiveErrorMsg.originErrMsg;
      }
      paramString = localReportTask.addKeyValue("originErrMsg", paramString);
      return paramString;
      this.j = true;
      return null;
    }
  }
  
  private void a(LoginInfo paramLoginInfo)
  {
    if (!this.c)
    {
      if (paramLoginInfo == null) {
        return;
      }
      try
      {
        if (this.b != null) {
          this.b.setLoginInfo(paramLoginInfo);
        }
        this.e = true;
        return;
      }
      catch (Throwable paramLoginInfo)
      {
        QLog.e("QQLiveAnchor_techReport", 1, paramLoginInfo, new Object[0]);
      }
    }
  }
  
  private void a(BaseRoomInfo paramBaseRoomInfo)
  {
    if (!this.c)
    {
      if (paramBaseRoomInfo == null) {
        return;
      }
      try
      {
        if (this.b != null) {
          this.b.setRoomInfo(paramBaseRoomInfo);
        }
        this.f = true;
        return;
      }
      catch (Throwable paramBaseRoomInfo)
      {
        QLog.e("QQLiveAnchor_techReport", 1, paramBaseRoomInfo, new Object[0]);
      }
    }
  }
  
  private void a(String paramString)
  {
    a.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  private long b(String paramString)
  {
    try
    {
      long l1 = ((Long)a.get(paramString)).longValue();
      return l1;
    }
    catch (Throwable paramString)
    {
      label16:
      break label16;
    }
    this.j = true;
    return 0L;
  }
  
  private int h()
  {
    int m = this.i;
    if (m != -1) {
      return m;
    }
    try
    {
      m = QQLiveAnchorTechReport.2.a[this.d.getRoomConfig().streamRecordType.ordinal()];
      if (m != 1)
      {
        if (m != 2)
        {
          if (m == 3) {
            this.i = 0;
          }
        }
        else {
          this.i = 2;
        }
      }
      else {
        this.i = 1;
      }
    }
    catch (Throwable localThrowable)
    {
      label72:
      break label72;
    }
    this.j = true;
    return this.i;
  }
  
  private void i()
  {
    Object localObject1;
    if (this.h == null)
    {
      localObject1 = this.d;
      if (localObject1 == null) {
        return;
      }
    }
    try
    {
      Object localObject2 = ((QQLiveAnchorRoom)localObject1).getRoomInfo();
      long l1 = ((BaseRoomInfo)localObject2).getRoomId();
      localObject1 = ((BaseRoomInfo)localObject2).getProgramId();
      if ((localObject2 != null) && (l1 > 0L))
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(this.g);
        this.h = ((StringBuilder)localObject2).toString();
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      label118:
      break label118;
    }
    this.j = true;
  }
  
  private void j()
  {
    if (this.e) {
      return;
    }
    try
    {
      a(this.d.c().getLoginModule().getLoginInfo());
      return;
    }
    catch (Throwable localThrowable)
    {
      label30:
      break label30;
    }
    this.j = true;
  }
  
  private void k()
  {
    if (this.f) {
      return;
    }
    try
    {
      a(this.d.getRoomInfo());
      return;
    }
    catch (Throwable localThrowable)
    {
      label20:
      break label20;
    }
    this.j = true;
  }
  
  public void a()
  {
    if (this.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_techReport", 1, "prepareStart");
    }
    a("time_prepare_start");
  }
  
  public void a(QQLiveAnchorRoom paramQQLiveAnchorRoom)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init, ");
      localStringBuilder.append(this.j);
      QLog.d("QQLiveAnchor_techReport", 1, localStringBuilder.toString());
    }
    try
    {
      this.d = paramQQLiveAnchorRoom;
      this.b = paramQQLiveAnchorRoom.c().getDataReportModule();
      this.d.a(this.l);
      return;
    }
    catch (Throwable paramQQLiveAnchorRoom)
    {
      QLog.e("QQLiveAnchor_techReport", 1, paramQQLiveAnchorRoom, new Object[0]);
    }
  }
  
  public void a(QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    if (this.c) {
      return;
    }
    try
    {
      a("anchor_room_heart", false, paramQQLiveErrorMsg).send();
      return;
    }
    catch (Throwable paramQQLiveErrorMsg)
    {
      QLog.e("QQLiveAnchor_techReport", 1, paramQQLiveErrorMsg, new Object[0]);
    }
  }
  
  public void a(StatisticData paramStatisticData)
  {
    if (!this.c)
    {
      if (paramStatisticData == null) {
        return;
      }
      long l1 = System.currentTimeMillis();
      if (l1 - this.k < 3000L) {
        return;
      }
      this.k = l1;
    }
    try
    {
      if (!(this.d instanceof IQQLiveAnchorTRTCRoom)) {
        return;
      }
      TRTCVideoQualityParams localTRTCVideoQualityParams = ((IQQLiveAnchorTRTCRoom)this.d).getVideoQuality();
      if (localTRTCVideoQualityParams == null) {
        return;
      }
      a("anchor_quality_statictis", true, null).addKeyValue("fps", localTRTCVideoQualityParams.getVideoFps()).addKeyValue("bitrate", localTRTCVideoQualityParams.getVideoBitRate()).addKeyValue("resolution", localTRTCVideoQualityParams.getVideoResolution()).addKeyValue("resolutionMode", localTRTCVideoQualityParams.getVideoResolutionMode()).addKeyValue("appCpu", paramStatisticData.appCpu).addKeyValue("systemCpu", paramStatisticData.systemCpu).addKeyValue("rtt", paramStatisticData.rtt).addKeyValue("upLoss", paramStatisticData.upLoss).addKeyValue("downLoss", paramStatisticData.downLoss).addKeyValue("sendBytes", paramStatisticData.sendBytes).addKeyValue("receiveBytes", paramStatisticData.receiveBytes).send();
      return;
    }
    catch (Throwable paramStatisticData)
    {
      label217:
      break label217;
    }
    this.j = true;
  }
  
  public void a(boolean paramBoolean, QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    if (this.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_techReport", 1, "prepareEnd");
    }
    a("time_prepare_end");
    try
    {
      a("anchor_room_prepare", paramBoolean, paramQQLiveErrorMsg).addKeyValue("duration", b("time_prepare_end") - b("time_prepare_start")).send();
      return;
    }
    catch (Throwable paramQQLiveErrorMsg)
    {
      QLog.d("QQLiveAnchor_techReport", 1, paramQQLiveErrorMsg, new Object[0]);
    }
  }
  
  public void b()
  {
    if (this.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_techReport", 1, "setStart");
    }
    a("time_set_start");
  }
  
  public void b(QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    if (this.c) {
      return;
    }
    try
    {
      a("anchor_room_pull_stream", false, paramQQLiveErrorMsg).send();
      return;
    }
    catch (Throwable paramQQLiveErrorMsg)
    {
      QLog.e("QQLiveAnchor_techReport", 1, paramQQLiveErrorMsg, new Object[0]);
    }
  }
  
  public void b(boolean paramBoolean, QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    if (this.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_techReport", 1, "setEnd");
    }
    a("time_set_end");
    try
    {
      a("anchor_room_set", paramBoolean, paramQQLiveErrorMsg).addKeyValue("duration", b("time_set_end") - b("time_set_start")).send();
      return;
    }
    catch (Throwable paramQQLiveErrorMsg)
    {
      QLog.d("QQLiveAnchor_techReport", 1, paramQQLiveErrorMsg, new Object[0]);
    }
  }
  
  public void c()
  {
    if (this.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_techReport", 1, "enterRoomStart");
    }
    a("time_enter_start");
  }
  
  public void c(boolean paramBoolean, QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    if (this.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_techReport", 1, "enterRoomEnd");
    }
    try
    {
      a("time_enter_end");
      a("anchor_room_enter", paramBoolean, paramQQLiveErrorMsg).addKeyValue("duration", b("time_enter_end") - b("time_enter_start")).addKeyValue("enterRoomTime", b("time_enter_start")).send();
      return;
    }
    catch (Throwable paramQQLiveErrorMsg)
    {
      QLog.e("QQLiveAnchor_techReport", 1, paramQQLiveErrorMsg, new Object[0]);
    }
  }
  
  public void d()
  {
    if (this.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_techReport", 1, "publishStreamStart");
    }
    a("time_publish_start");
  }
  
  public void d(boolean paramBoolean, QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    if (this.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_techReport", 1, "publishStreamEnd");
    }
    try
    {
      a("time_publish_end");
      a("anchor_room_push_begin", paramBoolean, paramQQLiveErrorMsg).addKeyValue("duration", b("time_publish_end") - b("time_publish_start")).send();
      return;
    }
    catch (Throwable paramQQLiveErrorMsg)
    {
      QLog.e("QQLiveAnchor_techReport", 1, paramQQLiveErrorMsg, new Object[0]);
    }
  }
  
  public void e()
  {
    if (this.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_techReport", 1, "stopPushStart");
    }
    a("time_stop_push_start");
  }
  
  public void e(boolean paramBoolean, QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    if (this.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_techReport", 1, "stopPushEnd");
    }
    a("time_stop_push_end");
    try
    {
      a("anchor_room_push_end", paramBoolean, paramQQLiveErrorMsg).addKeyValue("duration", b("time_stop_push_end") - b("time_stop_push_start")).send();
      return;
    }
    catch (Throwable paramQQLiveErrorMsg)
    {
      QLog.e("QQLiveAnchor_techReport", 1, paramQQLiveErrorMsg, new Object[0]);
    }
  }
  
  public void f()
  {
    if (this.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_techReport", 1, "exitRoomStart");
    }
    a("time_exit_start");
  }
  
  public void f(boolean paramBoolean, QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    if (this.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_techReport", 1, "exitRoom");
    }
    try
    {
      a("time_exit_end");
      a("anchor_room_exit", paramBoolean, paramQQLiveErrorMsg).addKeyValue("duration", b("time_exit_end") - b("time_exit_start")).send();
      return;
    }
    catch (Throwable paramQQLiveErrorMsg)
    {
      QLog.e("QQLiveAnchor_techReport", 1, paramQQLiveErrorMsg, new Object[0]);
    }
  }
  
  public void g()
  {
    this.c = true;
    try
    {
      if (this.d != null) {
        this.d.b(this.l);
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQLiveAnchor_techReport", 1, localThrowable, new Object[0]);
    }
    this.d = null;
    this.b = null;
    a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.report.QQLiveAnchorTechReport
 * JD-Core Version:    0.7.0.1
 */