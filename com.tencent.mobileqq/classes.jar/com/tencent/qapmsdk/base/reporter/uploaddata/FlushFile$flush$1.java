package com.tencent.qapmsdk.base.reporter.uploaddata;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.FileUtil.Companion;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 15})
final class FlushFile$flush$1
  implements Runnable
{
  FlushFile$flush$1(List paramList, String paramString) {}
  
  public final void run()
  {
    StringBuffer localStringBuffer = new StringBuffer(1024);
    Iterator localIterator = this.$metas.iterator();
    while (localIterator.hasNext()) {
      localStringBuffer.append(((IMetaData)localIterator.next()).metaSerialize());
    }
    if (new File(this.$fileName).exists())
    {
      FileUtil.Companion.writeFile(this.$fileName, localStringBuffer.toString(), true);
      return;
    }
    Logger.INSTANCE.w(new String[] { "QAPM_base_FlushFile", "file " + this.$fileName + " is not exists, so can not write file" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.FlushFile.flush.1
 * JD-Core Version:    0.7.0.1
 */