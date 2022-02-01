package com.tencent.tkd.topicsdk.debug;

import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import java.io.File;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/debug/DebugHelper;", "", "()V", "isDebugMode", "", "()Z", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DebugHelper
{
  public static final DebugHelper a = new DebugHelper();
  
  public final boolean a()
  {
    try
    {
      boolean bool = new File(TopicSDKHelperKt.a() + "debug_entry").exists();
      return bool;
    }
    catch (Exception localException)
    {
      TLog.d("DebugHelper", "isDebugMode exception, e=" + localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.debug.DebugHelper
 * JD-Core Version:    0.7.0.1
 */