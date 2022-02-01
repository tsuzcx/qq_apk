package com.tencent.qqperf.monitor.battery;

import com.tencent.qapmsdk.qqbattery.IBatteryListener;
import com.tencent.qapmsdk.qqbattery.QQBatteryMonitor;
import com.tencent.qapmsdk.qqbattery.config.BatteryConfig;
import com.tencent.qapmsdk.qqbattery.config.CmdMeta;
import com.tencent.qapmsdk.qqbattery.config.CpuMeta;
import com.tencent.qapmsdk.qqbattery.config.GpsMeta;
import com.tencent.qapmsdk.qqbattery.config.LogMeta;
import com.tencent.qapmsdk.qqbattery.config.TrafficMeta;
import com.tencent.qapmsdk.qqbattery.config.WakeLockMeta;
import com.tencent.qapmsdk.qqbattery.config.WifiMeta;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.QLog.ILogCallback;
import com.tencent.qqperf.config.APMModuleConfig;
import com.tencent.qqperf.monitor.base.AbstractMagnifierItem;
import com.tencent.qqperf.monitor.base.IAPMModuleBattery;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MainService;
import mqq.util.IServiceCmdCallback;

public class QAPMBatteryWrapper
  extends AbstractMagnifierItem
  implements IAPMModuleBattery
{
  public String a()
  {
    return "battery";
  }
  
  protected void a(APMModuleConfig paramAPMModuleConfig) {}
  
  public void a(String paramString, Object[] paramArrayOfObject)
  {
    QQBatteryMonitor.getInstance().onGpsScan(paramString, paramArrayOfObject);
  }
  
  public String b()
  {
    return f().getOldStrategy("0.002;0.000025;1;3600;5|5,30,60;5,0;5,1|5,30,60;5,1|2,200,300,20|2,30,40,20|30;3,10;10,120|3,15;10,300|3,15,10,300|1800|1800||0;0;8;8;5;5;1;0|");
  }
  
  public void d()
  {
    super.d();
  }
  
  public void j()
  {
    Object localObject1 = b();
    try
    {
      Object localObject2 = ((String)localObject1).split("\\|");
      localObject1 = localObject2[0].split(";");
      long l = Long.parseLong(localObject1[3]);
      localObject1 = new BatteryConfig(localObject1[2].equals("1"), (l + 60L) * 1000L);
      ((BatteryConfig)localObject1).cpuConfig = new CpuMeta().parse(localObject2[1]);
      ((BatteryConfig)localObject1).logConfig = new LogMeta().parse(localObject2[3]);
      ((BatteryConfig)localObject1).cmdConfig = new CmdMeta().parse(localObject2[4]);
      ((BatteryConfig)localObject1).wakeLockConfig = new WakeLockMeta().parse(localObject2[5]);
      ((BatteryConfig)localObject1).wifiConfig = new WifiMeta().parse(localObject2[6]);
      ((BatteryConfig)localObject1).gpsConfig = new GpsMeta().parse(localObject2[7]);
      ((BatteryConfig)localObject1).trafficConfig = new TrafficMeta().parse(localObject2[2]);
      localObject2 = new QApmBatteryListenerImpl();
      QQBatteryMonitor.setBatteryListener((IBatteryListener)localObject2);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("MSF.D.MonitorSocket");
      localArrayList.add("Q.msg.MsgProxy|addMsgQueue");
      localArrayList.add("Q.db.Cache|writeRunable");
      localArrayList.add("Q.msg.MsgProxy|writeRunable");
      localArrayList.add("Q.db.Cache|addMsgQueue");
      localArrayList.add("SQLiteOpenHelper| getWritableDatabase");
      localArrayList.add("SQLiteOpenHelper| getReadableDatabase");
      QQBatteryMonitor.getInstance().setLogWhite(localArrayList, 0);
      QLog.setLogCallback((QLog.ILogCallback)localObject2);
      localArrayList = new ArrayList();
      localArrayList.add("OidbSvc.0x58b_0");
      QQBatteryMonitor.getInstance().setLogWhite(localArrayList, 150);
      localArrayList.clear();
      localArrayList.add("IncreaseURLSvr.QQHeadUrlReq");
      localArrayList.add("AvatarInfoSvr.QQHeadUrlReq");
      QQBatteryMonitor.getInstance().setCmdWhite(localArrayList, 100);
      localArrayList.clear();
      localArrayList.add("OnlinePush.RespPush");
      QQBatteryMonitor.getInstance().setCmdWhite(localArrayList, 120);
      localArrayList.clear();
      localArrayList.add("CliLogSvc.UploadReq");
      QQBatteryMonitor.getInstance().setCmdWhite(localArrayList, 50);
      localArrayList.clear();
      localArrayList.add("OidbSvc.0x787_1");
      QQBatteryMonitor.getInstance().setCmdWhite(localArrayList, 90);
      localArrayList.clear();
      localArrayList.add("friendlist.getTroopMemberList");
      QQBatteryMonitor.getInstance().setCmdWhite(localArrayList, 40);
      localArrayList.clear();
      localArrayList.add("MessageSvc.PbDeleteMsg");
      QQBatteryMonitor.getInstance().setCmdWhite(localArrayList, 100);
      MainService.setServiceCmdCallback((IServiceCmdCallback)localObject2);
      QQBatteryMonitor.getInstance().setupConfig((BatteryConfig)localObject1);
      QLog.i("MagnifierSDK.QAPM.QAPMBatteryWrapper", 1, "openBattery");
      return;
    }
    catch (Exception localException)
    {
      QLog.i("MagnifierSDK.QAPM.QAPMBatteryWrapper", 1, "openBattery", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.battery.QAPMBatteryWrapper
 * JD-Core Version:    0.7.0.1
 */