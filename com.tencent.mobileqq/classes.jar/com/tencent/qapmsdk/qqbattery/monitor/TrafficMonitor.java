package com.tencent.qapmsdk.qqbattery.monitor;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.qqbattery.BatteryLog;
import com.tencent.qapmsdk.qqbattery.BatteryUsageItem;
import com.tencent.qapmsdk.qqbattery.config.TrafficMeta;

public class TrafficMonitor
  extends BatteryUsageItem
  implements Handler.Callback
{
  public static final String BG_5_TRF = "bg5Trf";
  public static final String FG_30_TRF = "fg30Trf";
  private static final int MSG_BG_TIMER = 3;
  private static final int MSG_FG_TIMER = 0;
  public static final String TAG = "QAPM_battery_TrafficMonitor";
  private long bgCollectCount;
  private long deviceRxBytesOnAppStart;
  private long deviceRxBytesOnEnterBg;
  private long deviceTxBytesOnAppStart;
  private long deviceTxBytesOnEnterBg;
  private long dumpQqBgInterval;
  private long dumpQqProcessInterval1;
  private long dumpQqProcessInterval2;
  private long dumpQqProcessInterval3;
  private long enterBgTimeStamp;
  private long qqRxBytesOnAppStart;
  private long qqRxBytesOnEnterBg;
  private long qqTxBytesOnAppStart;
  private long qqTxBytesOnEnterBg;
  @NonNull
  private Handler subHandler;
  private int uid;
  
  public TrafficMonitor(@NonNull TrafficMeta paramTrafficMeta)
  {
    this.dumpQqProcessInterval1 = (paramTrafficMeta.firstFgInterval * 60000L);
    this.dumpQqProcessInterval2 = (paramTrafficMeta.secondFgInterval * 60000L);
    this.dumpQqProcessInterval3 = (paramTrafficMeta.thirdFgInterval * 60000L);
    this.dumpQqBgInterval = (paramTrafficMeta.firstBgInterval * 60000L);
    this.bgCollectCount = paramTrafficMeta.bgCollectCount;
    this.subHandler = new Handler(ThreadManager.getBatteryThreadLooper(), this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.uid == 0) {
      return false;
    }
    long l1;
    long l2;
    long l3;
    long l4;
    int i;
    if (paramMessage.what == 0)
    {
      l1 = TrafficStats.getUidRxBytes(this.uid) - this.qqRxBytesOnAppStart;
      l2 = TrafficStats.getUidTxBytes(this.uid) - this.qqTxBytesOnAppStart;
      l3 = TrafficStats.getTotalRxBytes() - this.deviceRxBytesOnAppStart;
      l4 = TrafficStats.getTotalTxBytes() - this.deviceTxBytesOnAppStart;
      i = (int)(((Long)paramMessage.obj).longValue() / 1000L);
      paramMessage = new StringBuilder(50);
      paramMessage.append("on startup ");
      paramMessage.append(i);
      paramMessage.append("secs, network:");
      paramMessage.append(l1 / 1000L);
      paramMessage.append("/");
      paramMessage.append(l3 / 1000L);
      paramMessage.append("|");
      paramMessage.append(l2 / 1000L);
      paramMessage.append("/");
      paramMessage.append(l4 / 1000L);
      Logger.INSTANCE.i(new String[] { "QAPM_battery_TrafficMonitor", paramMessage.toString() });
      BatteryLog.writeCommonLogByMonitor(new String[] { "nt|fg|", String.valueOf(i), "|", String.valueOf(l1), "|", String.valueOf(l2), "|", String.valueOf(l3), "|", String.valueOf(l4) });
      if (i == 1800) {
        BatteryLog.writeReportLogByMonitor(new String[] { "fg30Trf", "|", String.valueOf(l1), "|", String.valueOf(l2), "|", String.valueOf(l3), "|", String.valueOf(l4) });
      }
    }
    else if (paramMessage.what == 3)
    {
      this.bgCollectCount -= 1L;
      if (System.currentTimeMillis() - this.enterBgTimeStamp < this.dumpQqBgInterval + 2000L)
      {
        l1 = TrafficStats.getUidRxBytes(this.uid) - this.qqRxBytesOnEnterBg;
        l2 = TrafficStats.getUidTxBytes(this.uid) - this.qqTxBytesOnEnterBg;
        l3 = TrafficStats.getTotalRxBytes() - this.deviceRxBytesOnEnterBg;
        l4 = TrafficStats.getTotalTxBytes() - this.deviceTxBytesOnEnterBg;
        i = (int)(this.dumpQqBgInterval / 1000L);
        paramMessage = new StringBuilder(50);
        paramMessage.append("onBG");
        paramMessage.append(i);
        paramMessage.append("secs, network:");
        paramMessage.append(l1 / 1000L);
        paramMessage.append("/");
        paramMessage.append(l3 / 1000L);
        paramMessage.append("|");
        paramMessage.append(l2 / 1000L);
        paramMessage.append("/");
        paramMessage.append(l4 / 1000L);
        Logger.INSTANCE.i(new String[] { "QAPM_battery_TrafficMonitor", paramMessage.toString() });
        BatteryLog.writeCommonLogByMonitor(new String[] { "nt|bg|", String.valueOf(i), "|", String.valueOf(l1), "|", String.valueOf(l2), "|", String.valueOf(l3), "|", String.valueOf(l4) });
        if (i == 300) {
          BatteryLog.writeReportLogByMonitor(new String[] { "bg5Trf", "|", String.valueOf(l1), "|", String.valueOf(l2), "|", String.valueOf(l3), "|", String.valueOf(l4) });
        }
      }
    }
    return false;
  }
  
  public void onAppBackground()
  {
    super.onAppBackground();
    if ((this.uid != 0) && (this.bgCollectCount > 0L))
    {
      this.enterBgTimeStamp = System.currentTimeMillis();
      this.qqRxBytesOnEnterBg = TrafficStats.getUidRxBytes(this.uid);
      this.qqTxBytesOnEnterBg = TrafficStats.getUidTxBytes(this.uid);
      this.deviceRxBytesOnEnterBg = TrafficStats.getTotalRxBytes();
      this.deviceTxBytesOnEnterBg = TrafficStats.getTotalTxBytes();
      this.subHandler.sendEmptyMessageDelayed(3, this.dumpQqBgInterval);
    }
  }
  
  public void onAppForeground()
  {
    super.onAppForeground();
    this.subHandler.removeMessages(3);
  }
  
  public void onOtherProcReport(Bundle paramBundle) {}
  
  public void onProcessStart()
  {
    if (BaseInfo.app == null) {
      return;
    }
    try
    {
      this.uid = BaseInfo.app.getPackageManager().getApplicationInfo(BaseInfo.app.getPackageName(), 128).uid;
      if (this.uid != 0)
      {
        this.qqRxBytesOnAppStart = TrafficStats.getUidRxBytes(this.uid);
        this.qqTxBytesOnAppStart = TrafficStats.getUidTxBytes(this.uid);
        this.deviceRxBytesOnAppStart = TrafficStats.getTotalRxBytes();
        this.deviceTxBytesOnAppStart = TrafficStats.getTotalTxBytes();
        Message localMessage = this.subHandler.obtainMessage(0, Long.valueOf(this.dumpQqProcessInterval1));
        this.subHandler.sendMessageDelayed(localMessage, this.dumpQqProcessInterval1);
        localMessage = this.subHandler.obtainMessage(0, Long.valueOf(this.dumpQqProcessInterval2));
        this.subHandler.sendMessageDelayed(localMessage, this.dumpQqProcessInterval2);
        localMessage = this.subHandler.obtainMessage(0, Long.valueOf(this.dumpQqProcessInterval3));
        this.subHandler.sendMessageDelayed(localMessage, this.dumpQqProcessInterval3);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM_battery_TrafficMonitor", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.monitor.TrafficMonitor
 * JD-Core Version:    0.7.0.1
 */