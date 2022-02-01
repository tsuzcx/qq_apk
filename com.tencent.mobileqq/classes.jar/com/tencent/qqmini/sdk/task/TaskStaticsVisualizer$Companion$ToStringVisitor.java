package com.tencent.qqmini.sdk.task;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/task/TaskStaticsVisualizer$Companion$ToStringVisitor;", "Lcom/tencent/qqmini/sdk/task/TaskStaticsVisualizer$TaskVisitor;", "()V", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getBuilder", "()Ljava/lang/StringBuilder;", "indent", "", "getIndent", "()I", "setIndent", "(I)V", "beginDependencies", "", "beginTask", "statics", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "build", "", "buildLine", "line", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "endDependencies", "endTask", "ms", "", "lib_minisdk_internalRelease"}, k=1, mv={1, 1, 16})
final class TaskStaticsVisualizer$Companion$ToStringVisitor
  implements TaskStaticsVisualizer.TaskVisitor
{
  @NotNull
  private final StringBuilder builder = new StringBuilder();
  private int indent;
  
  private final void buildLine(Function1<? super StringBuilder, Unit> paramFunction1)
  {
    int j = getIndent();
    int i = 0;
    while (i < j)
    {
      getBuilder().append("|   ");
      i += 1;
    }
    getBuilder().append("|-> ");
    paramFunction1.invoke(getBuilder());
    getBuilder().append('\n');
  }
  
  public void beginDependencies()
  {
    this.indent += 1;
  }
  
  public void beginTask(@NotNull TaskExecutionStatics paramTaskExecutionStatics)
  {
    Intrinsics.checkParameterIsNotNull(paramTaskExecutionStatics, "statics");
    int j = getIndent();
    int i = 0;
    while (i < j)
    {
      getBuilder().append("|   ");
      i += 1;
    }
    getBuilder().append("|-> ");
    StringBuilder localStringBuilder = getBuilder();
    Object localObject = paramTaskExecutionStatics.getStatus();
    switch (TaskStaticsVisualizer.Companion.ToStringVisitor.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 1: 
      localObject = "✅";
      if (((CharSequence)paramTaskExecutionStatics.getMessage()).length() > 0)
      {
        i = 1;
        label129:
        if (i == 0) {
          break label281;
        }
      }
      break;
    }
    label281:
    for (String str = '"' + paramTaskExecutionStatics.getMessage() + '"';; str = "")
    {
      localStringBuilder.append((String)localObject + " [" + paramTaskExecutionStatics.getName() + "] " + ms(paramTaskExecutionStatics.getRunDurationMs()) + '/' + ms(paramTaskExecutionStatics.getTotalRunDurationMs()) + ' ' + str);
      getBuilder().append('\n');
      return;
      localObject = "❌";
      break;
      localObject = "⛔️";
      break;
      localObject = "🚀";
      break;
      localObject = "💾";
      break;
      i = 0;
      break label129;
    }
  }
  
  @NotNull
  public final String build()
  {
    String str = this.builder.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "builder.toString()");
    return str;
  }
  
  public void endDependencies()
  {
    this.indent -= 1;
  }
  
  public void endTask() {}
  
  @NotNull
  public final StringBuilder getBuilder()
  {
    return this.builder;
  }
  
  public final int getIndent()
  {
    return this.indent;
  }
  
  @NotNull
  public final String ms(long paramLong)
  {
    if (paramLong < 1000) {
      return paramLong + "ms";
    }
    Object localObject = new Object[1];
    localObject[0] = Double.valueOf(paramLong / 1000.0D);
    localObject = String.format("%.2fs", Arrays.copyOf((Object[])localObject, localObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(this, *args)");
    return localObject;
  }
  
  public final void setIndent(int paramInt)
  {
    this.indent = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.Companion.ToStringVisitor
 * JD-Core Version:    0.7.0.1
 */