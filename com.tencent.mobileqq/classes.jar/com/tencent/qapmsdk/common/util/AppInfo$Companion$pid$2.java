package com.tencent.qapmsdk.common.util;

import android.os.Process;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
final class AppInfo$Companion$pid$2
  extends Lambda
  implements Function0<Integer>
{
  public static final 2 INSTANCE = new 2();
  
  AppInfo$Companion$pid$2()
  {
    super(0);
  }
  
  public final int invoke()
  {
    return Process.myPid();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.AppInfo.Companion.pid.2
 * JD-Core Version:    0.7.0.1
 */