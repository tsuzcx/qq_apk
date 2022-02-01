package com.tencent.rmonitor.common.logger;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/logger/LogState$Companion;", "", "()V", "values", "", "Lcom/tencent/rmonitor/common/logger/LogState;", "[Lcom/tencent/rmonitor/common/logger/LogState;", "getByValue", "value", "", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class LogState$Companion
{
  @Nullable
  public final LogState a(int paramInt)
  {
    LogState[] arrayOfLogState = LogState.access$getValues$cp();
    int k = arrayOfLogState.length;
    int i = 0;
    while (i < k)
    {
      LogState localLogState = arrayOfLogState[i];
      int j;
      if (localLogState.getValue() == paramInt) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        return localLogState;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.logger.LogState.Companion
 * JD-Core Version:    0.7.0.1
 */