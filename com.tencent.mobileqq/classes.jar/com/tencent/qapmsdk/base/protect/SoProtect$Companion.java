package com.tencent.qapmsdk.base.protect;

import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.FileUtil.Companion;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/protect/SoProtect$Companion;", "", "()V", "soCrashFile", "Ljava/io/File;", "createRestrictFile", "", "hasApmSoCrash", "", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class SoProtect$Companion
{
  @JvmStatic
  public final void createRestrictFile()
  {
    File localFile = SoProtect.access$getSoCrashFile$cp();
    if (localFile != null) {
      FileUtil.Companion.writeFile(localFile.getAbsolutePath(), "", false);
    }
  }
  
  @JvmStatic
  public final boolean hasApmSoCrash()
  {
    File localFile = SoProtect.access$getSoCrashFile$cp();
    if (localFile != null) {
      return localFile.exists();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.protect.SoProtect.Companion
 * JD-Core Version:    0.7.0.1
 */