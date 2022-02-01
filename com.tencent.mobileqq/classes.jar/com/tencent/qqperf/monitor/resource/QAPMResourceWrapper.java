package com.tencent.qqperf.monitor.resource;

import com.tencent.mobileqq.perf.report.FeatureFlag;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig.ResourcePlugin.ResourceType;
import com.tencent.qapmsdk.base.listener.IResourceListener;
import com.tencent.qapmsdk.base.meta.SceneMeta;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.base.AbstractMagnifierItem;
import com.tencent.qqperf.monitor.base.IAPMModuleScene;
import java.util.HashMap;
import java.util.Map;
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
    if (dH_()) {
      QAPM.beginScene(paramString, QAPM.ModeResource);
    }
  }
  
  public void b(String paramString)
  {
    if (dH_()) {
      QAPM.endScene(paramString, QAPM.ModeResource);
    }
  }
  
  public void j()
  {
    com.tencent.qapmsdk.base.config.SDKConfig.RES_TYPE = DefaultPluginConfig.ResourcePlugin.ResourceType.OUTSIDE_TAG.getValue() | DefaultPluginConfig.ResourcePlugin.ResourceType.OPEN_TAG.getValue() | DefaultPluginConfig.ResourcePlugin.ResourceType.OPEN_RESOURCE.getValue() | DefaultPluginConfig.ResourcePlugin.ResourceType.OPEN_AUTO.getValue();
    QAPM.setProperty(114, this);
  }
  
  public void onEndScene(SceneMeta paramSceneMeta)
  {
    double d = paramSceneMeta.cpu * 100.0D;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportToDenta");
      ((StringBuilder)localObject).append(paramSceneMeta.stage);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(d);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramSceneMeta.memory);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramSceneMeta.duration);
      QLog.i("QAPM_QQ_Impl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("cpuUsage", String.valueOf(d));
    ((HashMap)localObject).put("memory", String.valueOf(paramSceneMeta.memory));
    ((HashMap)localObject).put("scene", String.valueOf(paramSceneMeta.stage));
    ((HashMap)localObject).put("duration", String.valueOf(paramSceneMeta.duration));
    FeatureFlag.a((Map)localObject);
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance("", "actScenePerf", true, 0L, 0L, (HashMap)localObject, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.resource.QAPMResourceWrapper
 * JD-Core Version:    0.7.0.1
 */