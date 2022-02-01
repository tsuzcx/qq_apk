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
    int k = getIndent();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      getBuilder().append("|   ");
      i += 1;
    }
    getBuilder().append("|-> ");
    StringBuilder localStringBuilder1 = getBuilder();
    Object localObject1 = paramTaskExecutionStatics.getStatus();
    i = TaskStaticsVisualizer.Companion.ToStringVisitor.WhenMappings.$EnumSwitchMapping$0[localObject1.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              localObject1 = "💾";
            } else {
              throw new NoWhenBranchMatchedException();
            }
          }
          else {
            localObject1 = "🚀";
          }
        }
        else {
          localObject1 = "⛔️";
        }
      }
      else {
        localObject1 = "❌";
      }
    }
    else {
      localObject1 = "✅";
    }
    i = j;
    if (((CharSequence)paramTaskExecutionStatics.getMessage()).length() > 0) {
      i = 1;
    }
    Object localObject2;
    if (i != 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append('"');
      ((StringBuilder)localObject2).append(paramTaskExecutionStatics.getMessage());
      ((StringBuilder)localObject2).append('"');
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = "";
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append((String)localObject1);
    localStringBuilder2.append(" [");
    localStringBuilder2.append(paramTaskExecutionStatics.getName());
    localStringBuilder2.append("] ");
    localStringBuilder2.append(ms(paramTaskExecutionStatics.getRunDurationMs()));
    localStringBuilder2.append('/');
    localStringBuilder2.append(ms(paramTaskExecutionStatics.getTotalRunDurationMs()));
    localStringBuilder2.append(' ');
    localStringBuilder2.append((String)localObject2);
    localStringBuilder1.append(localStringBuilder2.toString());
    getBuilder().append('\n');
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
    if (paramLong < 1000)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("ms");
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = new Object[1];
    double d = paramLong;
    Double.isNaN(d);
    localObject[0] = Double.valueOf(d / 1000.0D);
    localObject = String.format("%.2fs", Arrays.copyOf((Object[])localObject, localObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(this, *args)");
    return localObject;
  }
  
  public final void setIndent(int paramInt)
  {
    this.indent = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.Companion.ToStringVisitor
 * JD-Core Version:    0.7.0.1
 */