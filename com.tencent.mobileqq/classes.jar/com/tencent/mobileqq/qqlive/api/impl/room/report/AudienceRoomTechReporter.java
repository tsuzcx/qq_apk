package com.tencent.mobileqq.qqlive.api.impl.room.report;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.datareport.ReportTask;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveWatchMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.os.MqqHandler;

public class AudienceRoomTechReporter
  implements AudienceRoomPlayerListener, EnterAudienceRoomCallback, ExitRoomCallback
{
  public static final long PERIOD_REPORT_INTERVAL = 10000L;
  public static final String TAG = "AudienceRoomTechReporter";
  private int blockCostTime;
  private final AtomicLong blockCostTimeInPeriod = new AtomicLong(0L);
  private int blockCount;
  private final AtomicInteger blockCountInPeriod = new AtomicInteger(0);
  private long blockStartTime;
  private long clickTime;
  private long enterRoomTime;
  private long initTime;
  private final AtomicBoolean isPeriodReporting = new AtomicBoolean(false);
  private final AtomicLong lastPeriodReportTime = new AtomicLong(0L);
  private String mediaUrl;
  private final Runnable periodReportTask = new AudienceRoomTechReporter.1(this);
  private int protoType;
  private String resolution;
  private IQQLiveSDK sdk;
  private long startEnterRoomTime;
  private long startPlayTime;
  private String toolState;
  
  private void doPeriodReport(int paramInt, String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.lastPeriodReportTime.get();
    getAudienceReportTask("live_period_report").addKeyValue("blockcount", this.blockCountInPeriod.get()).addKeyValue("blocktime", this.blockCostTimeInPeriod.get()).addKeyValue("period", l1 - l2).addKeyValue("errorcode", paramInt).addKeyValue("errormsg", paramString).send();
    this.lastPeriodReportTime.set(System.currentTimeMillis());
    this.blockCountInPeriod.set(0);
    this.blockCostTimeInPeriod.set(0L);
  }
  
  private ReportTask getAudienceReportTask(String paramString)
  {
    return this.sdk.getDataReportModule().newReportTask().setEventName(paramString).addKeyValue("url", this.mediaUrl).addKeyValue("videocodec", 1).addKeyValue("videotrans", this.protoType).addKeyValue("videoresolution", this.resolution).setPage("AudienceRoom");
  }
  
  private void onEnterRoomEnd(int paramInt, String paramString)
  {
    this.enterRoomTime = System.currentTimeMillis();
    long l1 = this.enterRoomTime;
    long l2 = this.startEnterRoomTime;
    getAudienceReportTask("enter_room").addKeyValue("errorcode", paramInt).addKeyValue("errormsg", paramString).addKeyValue("costtime", l1 - l2).send();
    startPeriodReport();
  }
  
  private void onExitRoomEnd(int paramInt, String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.enterRoomTime;
    getAudienceReportTask("exit_room").addKeyValue("errorcode", paramInt).addKeyValue("errormsg", paramString).addKeyValue("stime", this.enterRoomTime).addKeyValue("etime", l1).addKeyValue("costtime", l1 - l2).addKeyValue("blockcount", this.blockCount).addKeyValue("blocktime", this.blockCostTime).send();
  }
  
  private void onPlayEnd(int paramInt, String paramString)
  {
    this.blockCount = 0;
    this.blockCostTime = 0;
    this.resolution = "";
    doPeriodReport(paramInt, paramString);
    stopPeriodReport();
  }
  
  private void reportFirstFrame()
  {
    long l2 = System.currentTimeMillis();
    Object localObject = this.sdk.getCurRoomInfo();
    if (localObject != null)
    {
      long l3 = this.clickTime;
      long l1 = 0L;
      if (l3 > 0L)
      {
        HashMap localHashMap = new HashMap();
        LoginInfo localLoginInfo = this.sdk.getLoginModule().getLoginInfo();
        if (localLoginInfo != null) {
          l1 = localLoginInfo.uid;
        }
        localHashMap.put("qqlive_user_id", Long.valueOf(l1));
        localHashMap.put("qqlive_logined_when_enter", Integer.valueOf(0));
        localHashMap.put("qqlive_room_id", Long.valueOf(((QQLiveCurRoomInfo)localObject).roomId));
        localHashMap.put("qqlive_zhibo_type", Integer.valueOf(0));
        localHashMap.put("qqlive_click_to_play_cost", Long.valueOf(l2 - this.clickTime));
        localHashMap.put("qqlive_tool_state", this.toolState);
        localHashMap.put("dt_appkey", "0AND06MK9E48EOTF");
        VideoReport.reportEvent("ev_qqlive_click_to_first_frame", localHashMap);
        this.clickTime = -1L;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("report qqlive_click_to_play_cost: ");
          ((StringBuilder)localObject).append(localHashMap);
          QLog.i("AudienceRoomTechReporter", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private void startPeriodReport()
  {
    this.isPeriodReporting.set(true);
    this.lastPeriodReportTime.set(System.currentTimeMillis());
    ThreadManager.getSubThreadHandler().postDelayed(this.periodReportTask, 10000L);
  }
  
  private void stopPeriodReport()
  {
    this.isPeriodReporting.set(false);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.periodReportTask);
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.sdk = paramIQQLiveSDK;
    this.initTime = System.currentTimeMillis();
  }
  
  public void onComplete(int paramInt, String paramString)
  {
    onExitRoomEnd(paramInt, paramString);
    this.mediaUrl = "";
    this.protoType = 0;
  }
  
  public void onEnterRoomStart()
  {
    this.startEnterRoomTime = System.currentTimeMillis();
  }
  
  public void onError(int paramInt, String paramString)
  {
    onPlayEnd(paramInt, paramString);
    getAudienceReportTask("play_error").addKeyValue("errorcode", paramInt).addKeyValue("errormsg", paramString).send();
  }
  
  public void onExitRoomStart()
  {
    stopPeriodReport();
  }
  
  public void onFailed(int paramInt, String paramString)
  {
    onEnterRoomEnd(paramInt, paramString);
  }
  
  public void onFirstFrameCome()
  {
    int i;
    if (this.startPlayTime <= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    long l2 = System.currentTimeMillis();
    long l1;
    if (i != 0) {
      l1 = this.initTime;
    } else {
      l1 = this.startPlayTime;
    }
    getAudienceReportTask("play_start").addKeyValue("firstframetime", l2 - l1).addKeyValue("ispreload", i).send();
    reportFirstFrame();
  }
  
  public void onPause() {}
  
  public void onPlay()
  {
    this.startPlayTime = System.currentTimeMillis();
  }
  
  public void onPlayCompleted()
  {
    onPlayEnd(0, "");
  }
  
  public void onResume() {}
  
  public void onStartBuffer()
  {
    this.blockStartTime = System.currentTimeMillis();
  }
  
  public void onStopBuffer()
  {
    long l = System.currentTimeMillis() - this.blockStartTime;
    this.blockCostTime = ((int)(this.blockCostTime + l));
    this.blockCount += 1;
    this.blockCostTimeInPeriod.addAndGet(l);
    this.blockCountInPeriod.incrementAndGet();
  }
  
  public void onSuccess(LiveInfo paramLiveInfo)
  {
    this.mediaUrl = paramLiveInfo.watchMediaInfo.getMediaUrl();
    this.protoType = paramLiveInfo.watchMediaInfo.getProtoType();
    onEnterRoomEnd(0, "");
  }
  
  public void onVideoSizeChanged(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    this.resolution = localStringBuilder.toString();
  }
  
  public void reset() {}
  
  public void setExtraData(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.clickTime = paramBundle.getLong("starttime", 0L);
      this.toolState = paramBundle.getString("tool_state");
    }
  }
  
  public void setMediaUrl(String paramString)
  {
    this.mediaUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.report.AudienceRoomTechReporter
 * JD-Core Version:    0.7.0.1
 */