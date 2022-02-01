package com.tencent.rmonitor.common.util;

import android.app.Application;
import com.tencent.rmonitor.base.meta.BaseInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/SoProtect;", "", "()V", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class SoProtect
{
  public static final SoProtect.Companion a;
  private static final File b;
  
  static
  {
    File localFile = null;
    a = new SoProtect.Companion(null);
    Application localApplication = BaseInfo.app;
    if (localApplication != null)
    {
      localFile = localApplication.getDir("apmcrash", 0);
      Intrinsics.checkExpressionValueIsNotNull(localFile, "it.getDir(\"apmcrash\", Context.MODE_PRIVATE)");
      localFile = new File(localFile.getAbsolutePath(), "so_crash.txt");
    }
    b = localFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.SoProtect
 * JD-Core Version:    0.7.0.1
 */