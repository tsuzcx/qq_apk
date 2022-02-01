package com.tencent.qqperf.monitor.memory;

import com.tencent.qapmsdk.base.listener.IMemoryDumpListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.base.IDumpMemoryCallback;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class QAPMLeakWrapper$1
  implements IMemoryDumpListener
{
  QAPMLeakWrapper$1(QAPMLeakWrapper paramQAPMLeakWrapper, IDumpMemoryCallback paramIDumpMemoryCallback) {}
  
  public void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFinishDump ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString2);
    QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, localStringBuilder.toString());
  }
  
  public void onHprofDumped(@NotNull String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentQqperfMonitorBaseIDumpMemoryCallback;
    if (paramString != null) {
      paramString.a();
    }
  }
  
  @NotNull
  public List<String> onPrepareDump(@NotNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPrepareDump ");
    localStringBuilder.append(paramString);
    QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, localStringBuilder.toString());
    paramString = new ArrayList(4);
    paramString.addAll(DumpMemInfoHandler.a());
    paramString.addAll(DumpMemInfoHandler.b());
    paramString.add(DumpMemInfoHandler.b());
    paramString.add(DumpMemInfoHandler.a());
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.QAPMLeakWrapper.1
 * JD-Core Version:    0.7.0.1
 */