package com.tencent.rmonitor.common.logcat;

import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.common.util.FileUtil.Companion;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/logcat/LogcatFromJava;", "Lcom/tencent/rmonitor/common/logcat/ILogcat;", "()V", "logcatArguments", "", "", "getLogcatArguments", "()[Ljava/lang/String;", "setLogcatArguments", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getLogcatFile", "setArgs", "", "args", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class LogcatFromJava
  implements ILogcat
{
  @NotNull
  private String[] a = { "-t", "100", "-v", "threadtime" };
  
  @Nullable
  public String a()
  {
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add("logcat");
    CollectionsKt.addAll((Collection)localObject2, this.a);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(FileUtil.a.b());
    ((StringBuilder)localObject1).append("/logcat/log_");
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    ((StringBuilder)localObject1).append(".txt");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    localObject2 = new ProcessBuilder(new String[0]).command((List)localObject2).redirectErrorStream(true).start();
    FileUtil.Companion localCompanion1 = FileUtil.a;
    String str = ((File)localObject1).getAbsolutePath();
    FileUtil.Companion localCompanion2 = FileUtil.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "process");
    InputStream localInputStream = ((Process)localObject2).getInputStream();
    Intrinsics.checkExpressionValueIsNotNull(localInputStream, "process.inputStream");
    localCompanion1.a(str, localCompanion2.a(localInputStream, 8196), false);
    ((Process)localObject2).destroy();
    return ((File)localObject1).getAbsolutePath();
  }
  
  public void a(@Nullable String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      paramArrayOfString = new String[0];
    }
    this.a = paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.logcat.LogcatFromJava
 * JD-Core Version:    0.7.0.1
 */