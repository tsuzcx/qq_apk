package com.tencent.plato.module;

import com.tencent.plato.ExportedModule;
import com.tencent.plato.annotation.Exported;
import com.tencent.plato.core.utils.Ev;
import com.tencent.plato.core.utils.IReporter;
import com.tencent.plato.core.utils.TimeMonitorUtils;

public class ToolsModule
  extends ExportedModule
{
  public ToolsModule()
  {
    super("Tools");
  }
  
  @Exported("report")
  public void report(Object... paramVarArgs)
  {
    if (Ev.getReporter() != null) {
      Ev.getReporter().report(paramVarArgs);
    }
  }
  
  @Exported("setTimeMonitorName")
  public void setTimeMonitorName(String paramString)
  {
    TimeMonitorUtils.getInstance().setTimeMonitorName(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.module.ToolsModule
 * JD-Core Version:    0.7.0.1
 */