package com.tencent.qapmsdk.common.logger;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/logger/LogState$Companion;", "", "()V", "values", "", "Lcom/tencent/qapmsdk/common/logger/LogState;", "[Lcom/tencent/qapmsdk/common/logger/LogState;", "getByValue", "value", "", "common_release"}, k=1, mv={1, 1, 15})
public final class LogState$Companion
{
  @Nullable
  public final LogState getByValue(int paramInt)
  {
    LogState[] arrayOfLogState = LogState.access$getValues$cp();
    int k = arrayOfLogState.length;
    int i = 0;
    while (i < k)
    {
      LogState localLogState = arrayOfLogState[i];
      if (localLogState.getValue() == paramInt) {}
      for (int j = 1; j != 0; j = 0) {
        return localLogState;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.common.logger.LogState.Companion
 * JD-Core Version:    0.7.0.1
 */