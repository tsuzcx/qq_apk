package com.tencent.qqmini.sdk.server.launch;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/server/launch/LaunchStrategy$LaunchData;", "", "intent", "Landroid/content/Intent;", "processState", "Lcom/tencent/qqmini/sdk/server/launch/ProcessState;", "(Landroid/content/Intent;Lcom/tencent/qqmini/sdk/server/launch/ProcessState;)V", "getIntent", "()Landroid/content/Intent;", "getProcessState", "()Lcom/tencent/qqmini/sdk/server/launch/ProcessState;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib_miniserver_internalRelease"}, k=1, mv={1, 1, 16})
public final class LaunchStrategy$LaunchData
{
  @NotNull
  private final Intent intent;
  @NotNull
  private final ProcessState processState;
  
  public LaunchStrategy$LaunchData(@NotNull Intent paramIntent, @NotNull ProcessState paramProcessState)
  {
    this.intent = paramIntent;
    this.processState = paramProcessState;
  }
  
  @NotNull
  public final Intent component1()
  {
    return this.intent;
  }
  
  @NotNull
  public final ProcessState component2()
  {
    return this.processState;
  }
  
  @NotNull
  public final LaunchData copy(@NotNull Intent paramIntent, @NotNull ProcessState paramProcessState)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    Intrinsics.checkParameterIsNotNull(paramProcessState, "processState");
    return new LaunchData(paramIntent, paramProcessState);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LaunchData))
      {
        paramObject = (LaunchData)paramObject;
        if ((Intrinsics.areEqual(this.intent, paramObject.intent)) && (Intrinsics.areEqual(this.processState, paramObject.processState))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final Intent getIntent()
  {
    return this.intent;
  }
  
  @NotNull
  public final ProcessState getProcessState()
  {
    return this.processState;
  }
  
  public int hashCode()
  {
    Object localObject = this.intent;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.processState;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LaunchData(intent=");
    localStringBuilder.append(this.intent);
    localStringBuilder.append(", processState=");
    localStringBuilder.append(this.processState);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.LaunchStrategy.LaunchData
 * JD-Core Version:    0.7.0.1
 */