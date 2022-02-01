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
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add("logcat");
    CollectionsKt.addAll((Collection)localObject2, this.logcatArguments);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(FileUtil.Companion.getRootPath());
    ((StringBuilder)localObject1).append("/logcat/log_");
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    ((StringBuilder)localObject1).append(".txt");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    localObject2 = new ProcessBuilder(new String[0]).command((List)localObject2).redirectErrorStream(true).start();
    FileUtil.Companion localCompanion1 = FileUtil.Companion;
    String str = ((File)localObject1).getAbsolutePath();
    FileUtil.Companion localCompanion2 = FileUtil.Companion;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "process");
    InputStream localInputStream = ((Process)localObject2).getInputStream();
    Intrinsics.checkExpressionValueIsNotNull(localInputStream, "process.inputStream");
    localCompanion1.writeFile(str, localCompanion2.readStream(localInputStream, 8196), false);
    ((Process)localObject2).destroy();
    return ((File)localObject1).getAbsolutePath();
  }
  
  public void setArgs(@Nullable String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      paramArrayOfString = new String[0];
    }
    this.logcatArguments = paramArrayOfString;
  }
  
  public final void setLogcatArguments(@NotNull String[] paramArrayOfString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "<set-?>");
    this.logcatArguments = paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.logcat.LogcatFromJava
 * JD-Core Version:    0.7.0.1
 */