package com.tencent.qqperf.monitor.memory;

import com.tencent.qapmsdk.base.listener.IMemoryDumpListener;
import com.tencent.qqperf.monitor.base.IDumpMemoryCallback;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class QAPMCellingHprofWrapper$1
  implements IMemoryDumpListener
{
  QAPMCellingHprofWrapper$1(QAPMCellingHprofWrapper paramQAPMCellingHprofWrapper, IDumpMemoryCallback paramIDumpMemoryCallback) {}
  
  public void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2) {}
  
  public void onHprofDumped(@NotNull String paramString)
  {
    this.jdField_a_of_type_ComTencentQqperfMonitorBaseIDumpMemoryCallback.a();
  }
  
  @NotNull
  public List<String> onPrepareDump(@NotNull String paramString)
  {
    long l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().freeMemory();
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.addAll(DumpMemInfoHandler.b());
    localArrayList.add(DumpMemInfoHandler.b());
    localArrayList.add(DumpMemInfoHandler.a());
    localArrayList.add(DumpMemInfoHandler.a(paramString, l1 - l2));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.QAPMCellingHprofWrapper.1
 * JD-Core Version:    0.7.0.1
 */