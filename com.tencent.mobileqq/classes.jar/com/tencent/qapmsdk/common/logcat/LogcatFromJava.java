package com.tencent.qapmsdk.common.logcat;

import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.FileUtil.Companion;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/logcat/LogcatFromJava;", "Lcom/tencent/qapmsdk/common/logcat/ILogcat;", "()V", "logcatArguments", "", "", "getLogcatArguments", "()[Ljava/lang/String;", "setLogcatArguments", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getLogcatFile", "setArgs", "", "args", "common_release"}, k=1, mv={1, 1, 15})
public final class LogcatFromJava
  implements ILogcat
{
  @NotNull
  private String[] logcatArguments = { "-t", "100", "-v", "threadtime" };
  
  @NotNull
  public final String[] getLogcatArguments()
  {
    return this.logcatArguments;
  }
  
  @Nullable
  public String getLogcatFile()
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add("logcat");
    CollectionsKt.addAll((Collection)localObject, this.logcatArguments);
    File localFile = new File(FileUtil.Companion.getRootPath() + "/logcat/log_" + System.currentTimeMillis() + ".txt");
    localObject = new ProcessBuilder(new String[0]).command((List)localObject).redirectErrorStream(true).start();
    FileUtil.Companion localCompanion1 = FileUtil.Companion;
    String str = localFile.getAbsolutePath();
    FileUtil.Companion localCompanion2 = FileUtil.Companion;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "process");
    InputStream localInputStream = ((Process)localObject).getInputStream();
    Intrinsics.checkExpressionValueIsNotNull(localInputStream, "process.inputStream");
    localCompanion1.writeFile(str, localCompanion2.readStream(localInputStream, 8196), false);
    ((Process)localObject).destroy();
    return localFile.getAbsolutePath();
  }
  
  public void setArgs(@Nullable String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {}
    for (;;)
    {
      this.logcatArguments = paramArrayOfString;
      return;
      paramArrayOfString = new String[0];
    }
  }
  
  public final void setLogcatArguments(@NotNull String[] paramArrayOfString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "<set-?>");
    this.logcatArguments = paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.logcat.LogcatFromJava
 * JD-Core Version:    0.7.0.1
 */