package com.tencent.qqperf.monitor.resource;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig.ResourcePlugin.ResourceType;
import com.tencent.qapmsdk.base.listener.IResourceListener;
import com.tencent.qapmsdk.base.meta.SceneMeta;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.base.AbstractMagnifierItem;
import com.tencent.qqperf.monitor.base.IAPMModuleScene;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class QAPMResourceWrapper
  extends AbstractMagnifierItem
  implements IResourceListener, IAPMModuleScene
{
  public String a()
  {
    return "resource";
  }
  
  public void a(String paramString)
  {
    if (n_()) {
      QAPM.beginScene(paramString, QAPM.ModeResource);
    }
  }
  
  public void b()
  {
    com.tencent.qapmsdk.base.config.SDKConfig.RES_TYPE = DefaultPluginConfig.ResourcePlugin.ResourceType.OUTSIDE_TAG.getValue();
    QAPM.setProperty(114, this);
  }
  
  public void b(String paramString)
  {
    if (n_()) {
      QAPM.endScene(paramString, QAPM.ModeResource);
    }
  }
  
  public void onEndScene(SceneMeta paramSceneMeta)
  {
    double d = 100.0D * paramSceneMeta.cpu;
    if (QLog.isColorLevel()) {
      QLog.i("QAPM_QQ_Impl", 2, "reportToDenta" + paramSceneMeta.stage + " " + d + " " + paramSceneMeta.memory + " " + paramSceneMeta.duration);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("cpuUsage", String.valueOf(d));
    localHashMap.put("memory", String.valueOf(paramSceneMeta.memory));
    localHashMap.put("scene", String.valueOf(paramSceneMeta.stage));
    localHashMap.put("duration", String.valueOf(paramSceneMeta.duration));
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance("", "actScenePerf", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.monitor.resource.QAPMResourceWrapper
 * JD-Core Version:    0.7.0.1
 */