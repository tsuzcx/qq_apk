package com.tencent.qqperf.monitor.looper;

import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.listener.ILooperListener;
import com.tencent.qapmsdk.base.meta.LooperMeta;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.QAPMIniter;
import com.tencent.qqperf.UnifiedMonitor;
import com.tencent.qqperf.config.APMModuleConfig;
import com.tencent.qqperf.monitor.base.AbstractMagnifierItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class QAPMLooperWrapper
  extends AbstractMagnifierItem
  implements ILooperListener
{
  private ArrayList<ILooperListener> b;
  
  private void a(LooperMeta paramLooperMeta)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ILooperListener)((Iterator)localObject).next()).onBeforeReport(paramLooperMeta);
      }
    }
  }
  
  public String a()
  {
    return "looper";
  }
  
  public void a(ILooperListener paramILooperListener)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    if (!this.b.contains(paramILooperListener)) {
      this.b.add(paramILooperListener);
    }
  }
  
  protected void a(APMModuleConfig paramAPMModuleConfig) {}
  
  public void j()
  {
    QAPM.setProperty(116, this);
  }
  
  public void onBeforeReport(LooperMeta paramLooperMeta)
  {
    a(paramLooperMeta);
    HashMap localHashMap = new HashMap();
    paramLooperMeta = paramLooperMeta.getLooperParams();
    try
    {
      Iterator localIterator = paramLooperMeta.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramLooperMeta.getString(str));
      }
      int i = QAPMIniter.b();
      int j = paramLooperMeta.getInt("cost_time");
      UnifiedMonitor.a().addEvent(i, "LooperSingle", j, 0, localHashMap);
      return;
    }
    catch (Exception paramLooperMeta)
    {
      QLog.e("MagnifierSDK.QAPM", 1, "onMetaGet looper", paramLooperMeta);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.looper.QAPMLooperWrapper
 * JD-Core Version:    0.7.0.1
 */