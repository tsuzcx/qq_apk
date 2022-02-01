package com.tencent.mobileqq.qqlive.api.impl.room.report;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.report.IQQLiveReportCallback;
import com.tencent.mobileqq.qqlive.report.IQQLiveReportCallbackRegister;
import com.tencent.mobileqq.qqlive.report.QQLiveReportCallbackWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class QQLiveRoomBizReportHelper
  implements IQQLiveReportCallbackRegister
{
  private static final long DEFAULT_HEART_DURATION = 5000L;
  private static final String TAG = "QQLive_room_report";
  private long enterRoomTime = 0L;
  private long heartDuration = 5000L;
  private Runnable heartRunnable = new QQLiveRoomBizReportHelper.1(this);
  private boolean isDestroy = false;
  private long lastHeartTime = 0L;
  private IQQLiveSDK liveSDK;
  private QQLiveReportCallbackWrapper reportCallbackWrapper = new QQLiveReportCallbackWrapper();
  private ILiveRoom room;
  private String seq;
  private long uid;
  
  private void checkAndCreateSeq()
  {
    if (this.uid <= 0L) {
      try
      {
        this.uid = this.liveSDK.getLoginModule().getLoginInfo().uid;
      }
      catch (Throwable localThrowable1)
      {
        QLog.e("QQLive_room_report", 1, localThrowable1, new Object[0]);
      }
    }
    if (!TextUtils.isEmpty(this.seq)) {
      return;
    }
    try
    {
      if (this.enterRoomTime <= 0L) {
        this.enterRoomTime = System.currentTimeMillis();
      }
      if (this.room != null)
      {
        if (this.seq != null) {
          return;
        }
        BaseRoomInfo localBaseRoomInfo = this.room.getRoomInfo();
        if (localBaseRoomInfo == null) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localBaseRoomInfo.getRoomId());
        localStringBuilder.append("_");
        localStringBuilder.append(localBaseRoomInfo.getProgramId());
        localStringBuilder.append("_");
        localStringBuilder.append(this.enterRoomTime);
        this.seq = localStringBuilder.toString();
        return;
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      QLog.e("QQLive_room_report", 1, localThrowable2, new Object[0]);
    }
  }
  
  private String covertToString(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        localStringBuilder.append("key:");
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append(", value:");
        localStringBuilder.append((String)localEntry.getValue());
        localStringBuilder.append("\n");
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private void fillCommonReportInfo(HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("key_room_uid", String.valueOf(this.uid));
    paramHashMap.put("key_room_app_id", this.liveSDK.getAppId());
    Object localObject = this.room.getAnchorInfo();
    if (localObject != null) {
      paramHashMap.put("key_room_anchor_id", String.valueOf(((BaseAnchorInfo)localObject).getAnchorUid()));
    }
    localObject = this.room.getRoomInfo();
    if (localObject != null)
    {
      paramHashMap.put("key_room_room_id", String.valueOf(((BaseRoomInfo)localObject).getRoomId()));
      paramHashMap.put("key_room_program_id", String.valueOf(((BaseRoomInfo)localObject).getProgramId()));
    }
    paramHashMap.put("key_room_seq", this.seq);
    paramHashMap.put("key_room_enter_time", String.valueOf(this.enterRoomTime));
    paramHashMap.put("key_room_window_mode", getRoomWindowMode());
  }
  
  private String getRoomWindowMode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void reportEnterRoomForBiz()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLive_room_report", 1, "reportEnterRoomForBiz");
    }
    try
    {
      if (this.seq == null) {
        return;
      }
      HashMap localHashMap = new HashMap();
      fillCommonReportInfo(localHashMap);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportEnterRoomForBiz, data: ");
        localStringBuilder.append(covertToString(localHashMap));
        QLog.d("QQLive_room_report", 1, localStringBuilder.toString());
      }
      this.reportCallbackWrapper.a("event_room_enter", localHashMap);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQLive_room_report", 1, localThrowable, new Object[0]);
    }
  }
  
  private void reportExitRoomForBiz()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLive_room_report", 1, "reportExitRoomForBiz");
    }
    try
    {
      if (this.seq == null) {
        return;
      }
      HashMap localHashMap = new HashMap();
      fillCommonReportInfo(localHashMap);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportExitRoomForBiz, data: ");
        localStringBuilder.append(covertToString(localHashMap));
        QLog.d("QQLive_room_report", 1, localStringBuilder.toString());
      }
      this.reportCallbackWrapper.a("event_room_exit", localHashMap);
      if (System.currentTimeMillis() - this.lastHeartTime < this.heartDuration)
      {
        reportRoomHeartForBiz();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQLive_room_report", 1, localThrowable, new Object[0]);
    }
  }
  
  private void reportRoomHeartForBiz()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLive_room_report", 1, "reportRoomHeartForBiz");
    }
    try
    {
      if (this.seq == null) {
        return;
      }
      HashMap localHashMap = new HashMap();
      fillCommonReportInfo(localHashMap);
      long l = System.currentTimeMillis();
      localHashMap.put("key_room_duration", String.valueOf(l - this.lastHeartTime));
      this.lastHeartTime = l;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportRoomHeartForBiz, data: ");
        localStringBuilder.append(covertToString(localHashMap));
        QLog.d("QQLive_room_report", 1, localStringBuilder.toString());
      }
      this.reportCallbackWrapper.a("event_room_heart", localHashMap);
      if ((this.heartRunnable != null) && (!this.isDestroy))
      {
        ThreadManager.getSubThreadHandler().postDelayed(this.heartRunnable, this.heartDuration);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQLive_room_report", 1, localThrowable, new Object[0]);
    }
  }
  
  public void clearReportCallback()
  {
    try
    {
      this.reportCallbackWrapper.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQLive_room_report", 1, localThrowable, new Object[0]);
    }
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLive_room_report", 1, "destroy");
    }
    this.isDestroy = true;
    reset();
    this.heartRunnable = null;
    this.liveSDK = null;
    this.room = null;
  }
  
  public long getEnterRoomTime()
  {
    return this.enterRoomTime;
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK, BaseLiveRoom paramBaseLiveRoom)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLive_room_report", 1, "init");
    }
    if (paramIQQLiveSDK != null)
    {
      if (paramBaseLiveRoom == null) {
        return;
      }
      this.liveSDK = paramIQQLiveSDK;
      this.room = paramBaseLiveRoom;
    }
  }
  
  public void onEnterRoom()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLive_room_report", 1, "onEnterRoom");
    }
    if ((!this.isDestroy) && (this.liveSDK != null))
    {
      if (this.room == null) {
        return;
      }
      checkAndCreateSeq();
      reportEnterRoomForBiz();
    }
  }
  
  public void onExitRoom()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLive_room_report", 1, "onExitRoom");
    }
    if ((!this.isDestroy) && (this.liveSDK != null))
    {
      if (this.room == null) {
        return;
      }
      checkAndCreateSeq();
      reportExitRoomForBiz();
    }
  }
  
  public void registerReportCallback(IQQLiveReportCallback paramIQQLiveReportCallback)
  {
    try
    {
      this.reportCallbackWrapper.registerReportCallback(paramIQQLiveReportCallback);
      return;
    }
    catch (Throwable paramIQQLiveReportCallback)
    {
      QLog.e("QQLive_room_report", 1, paramIQQLiveReportCallback, new Object[0]);
    }
  }
  
  public void reset()
  {
    stopRoomHeartForBiz();
    clearReportCallback();
    this.seq = null;
    this.lastHeartTime = 0L;
    this.enterRoomTime = 0L;
    this.heartDuration = 5000L;
  }
  
  public void setEnterRoomTime(long paramLong)
  {
    this.enterRoomTime = paramLong;
  }
  
  public void setSeq(String paramString1, String paramString2, long paramLong)
  {
    this.enterRoomTime = paramLong;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    this.seq = localStringBuilder.toString();
  }
  
  public void startRoomHeartForBiz(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLive_room_report", 1, "startRoomHeartForBiz");
    }
    try
    {
      if (!this.isDestroy)
      {
        if (this.heartRunnable == null) {
          return;
        }
        checkAndCreateSeq();
        if (paramLong > 0L) {
          this.heartDuration = paramLong;
        }
        this.lastHeartTime = System.currentTimeMillis();
        ThreadManager.getSubThreadHandler().postDelayed(this.heartRunnable, this.heartDuration);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQLive_room_report", 1, localThrowable, new Object[0]);
    }
  }
  
  public void stopRoomHeartForBiz()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLive_room_report", 1, "stopRoomHeartForBiz");
    }
    try
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.heartRunnable);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQLive_room_report", 1, localThrowable, new Object[0]);
    }
  }
  
  public void unRegisterReportCallback(IQQLiveReportCallback paramIQQLiveReportCallback)
  {
    try
    {
      this.reportCallbackWrapper.unRegisterReportCallback(paramIQQLiveReportCallback);
      return;
    }
    catch (Throwable paramIQQLiveReportCallback)
    {
      QLog.e("QQLive_room_report", 1, paramIQQLiveReportCallback, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.report.QQLiveRoomBizReportHelper
 * JD-Core Version:    0.7.0.1
 */