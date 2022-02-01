package com.tencent.qapmsdk.base.protect;

import android.app.Application;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/protect/SoProtect;", "", "()V", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class SoProtect
{
  public static final SoProtect.Companion Companion;
  private static final File soCrashFile;
  
  static
  {
    File localFile = null;
    Companion = new SoProtect.Companion(null);
    Application localApplication = BaseInfo.app;
    if (localApplication != null)
    {
      localFile = localApplication.getDir("apmcrash", 0);
      Intrinsics.checkExpressionValueIsNotNull(localFile, "it.getDir(\"apmcrash\", Context.MODE_PRIVATE)");
      localFile = new File(localFile.getAbsolutePath(), "so_crash.txt");
    }
    soCrashFile = localFile;
  }
  
  @JvmStatic
  public static final void createRestrictFile()
  {
    Companion.createRestrictFile();
  }
  
  @JvmStatic
  public static final boolean hasApmSoCrash()
  {
    return Companion.hasApmSoCrash();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.protect.SoProtect
 * JD-Core Version:    0.7.0.1
 */