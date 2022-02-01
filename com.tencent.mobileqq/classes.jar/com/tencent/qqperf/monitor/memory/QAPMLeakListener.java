package com.tencent.qqperf.monitor.memory;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qapmsdk.base.listener.IInspectorListener;
import com.tencent.qapmsdk.common.util.InspectUUID;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class QAPMLeakListener
  implements IInspectorListener
{
  public void onCheckingLeaked(int paramInt, @NotNull String paramString) {}
  
  public boolean onFilter(@NotNull Object paramObject)
  {
    return ((IPerfApi)QRoute.api(IPerfApi.class)).onQAPMLeakListenerFilter(paramObject);
  }
  
  public void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("finishDump");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, localStringBuilder.toString());
  }
  
  public void onHprofDumped(@NotNull String paramString) {}
  
  public boolean onLeaked(@NotNull InspectUUID paramInspectUUID)
  {
    if (paramInspectUUID == null) {
      return false;
    }
    paramInspectUUID.toString();
    boolean bool = AppSetting.e;
    return false;
  }
  
  @NotNull
  public List<String> onPrepareDump(@NotNull String paramString)
  {
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(DumpMemInfoHandler.b());
    localArrayList.add(DumpMemInfoHandler.a());
    localArrayList.addAll(DumpMemInfoHandler.b());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("leakDump");
    localStringBuilder.append(paramString);
    QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, localStringBuilder.toString());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.QAPMLeakListener
 * JD-Core Version:    0.7.0.1
 */