package com.tencent.rmonitor.base.reporter.data;

import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.common.util.FileUtil.Companion;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/data/FlushFile;", "", "()V", "TAG", "", "flush", "", "fileName", "metas", "", "Lcom/tencent/rmonitor/base/reporter/data/IMetaData;", "flushSync", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class FlushFile
{
  public static final FlushFile a = new FlushFile();
  
  public final void a(@NotNull String paramString, @NotNull List<? extends IMetaData> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "fileName");
    Intrinsics.checkParameterIsNotNull(paramList, "metas");
    Object localObject = new StringBuffer(1024);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((StringBuffer)localObject).append(((IMetaData)paramList.next()).a());
    }
    paramList = ((StringBuffer)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramList, "sb.toString()");
    if (new File(paramString).exists())
    {
      FileUtil.a.a(paramString, paramList, true);
      return;
    }
    paramList = Logger.b;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("file ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" is not exists, so can not write file");
    paramList.w(new String[] { "RMonitor_base_FlushFile", ((StringBuilder)localObject).toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.data.FlushFile
 * JD-Core Version:    0.7.0.1
 */