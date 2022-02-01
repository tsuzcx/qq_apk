package com.tencent.mobileqq.triton.engine;

import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.utils.TritonKeep;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/engine/TTLog;", "", "()V", "VCONSOLE_LOG_DEBUG", "", "printNativeLog", "", "level", "tagBytes", "", "infoBytes", "Triton_release"}, k=1, mv={1, 1, 16})
public final class TTLog
{
  public static final TTLog INSTANCE = new TTLog();
  private static final int VCONSOLE_LOG_DEBUG = 100;
  
  @JvmStatic
  @TritonKeep
  public static final void printNativeLog(int paramInt, @Nullable byte[] paramArrayOfByte1, @Nullable byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null) {
      Intrinsics.throwNpe();
    }
    paramArrayOfByte1 = new String(paramArrayOfByte1, Charsets.UTF_8);
    if (paramArrayOfByte2 == null) {
      Intrinsics.throwNpe();
    }
    paramArrayOfByte2 = new String(paramArrayOfByte2, Charsets.UTF_8);
    if (paramInt >= 100)
    {
      switch (paramInt - 100 + 2)
      {
      default: 
        Logger.cv$default(paramArrayOfByte1, paramArrayOfByte2, null, 4, null);
        return;
      case 4: 
        Logger.ci$default(paramArrayOfByte1, paramArrayOfByte2, null, 4, null);
        return;
      case 3: 
        Logger.cd$default(paramArrayOfByte1, paramArrayOfByte2, null, 4, null);
        return;
      case 5: 
        Logger.cw$default(paramArrayOfByte1, paramArrayOfByte2, null, 4, null);
        return;
      }
      Logger.ce$default(paramArrayOfByte1, paramArrayOfByte2, null, 4, null);
      return;
    }
    switch (paramInt + 2)
    {
    default: 
      Logger.v$default(paramArrayOfByte1, paramArrayOfByte2, null, 4, null);
      return;
    case 4: 
      Logger.i$default(paramArrayOfByte1, paramArrayOfByte2, null, 4, null);
      return;
    case 3: 
      Logger.d$default(paramArrayOfByte1, paramArrayOfByte2, null, 4, null);
      return;
    case 5: 
      Logger.w$default(paramArrayOfByte1, paramArrayOfByte2, null, 4, null);
      return;
    }
    Logger.e$default(paramArrayOfByte1, paramArrayOfByte2, null, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.TTLog
 * JD-Core Version:    0.7.0.1
 */