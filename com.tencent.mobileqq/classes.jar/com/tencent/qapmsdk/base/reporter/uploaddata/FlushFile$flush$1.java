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
    Object localObject1 = new StringBuffer(1024);
    Object localObject2 = this.$metas.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((StringBuffer)localObject1).append(((IMetaData)((Iterator)localObject2).next()).metaSerialize());
    }
    if (new File(this.$fileName).exists())
    {
      FileUtil.Companion.writeFile(this.$fileName, ((StringBuffer)localObject1).toString(), true);
      return;
    }
    localObject1 = Logger.INSTANCE;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("file ");
    ((StringBuilder)localObject2).append(this.$fileName);
    ((StringBuilder)localObject2).append(" is not exists, so can not write file");
    ((Logger)localObject1).w(new String[] { "QAPM_base_FlushFile", ((StringBuilder)localObject2).toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.FlushFile.flush.1
 * JD-Core Version:    0.7.0.1
 */