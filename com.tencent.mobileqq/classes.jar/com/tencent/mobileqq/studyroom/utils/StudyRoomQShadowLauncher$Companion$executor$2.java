package com.tencent.mobileqq.studyroom.utils;

import com.tencent.mobileqq.app.ThreadManagerExecutor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class StudyRoomQShadowLauncher$Companion$executor$2
  extends Lambda
  implements Function0<ExecutorService>
{
  public static final 2 INSTANCE = new 2();
  
  StudyRoomQShadowLauncher$Companion$executor$2()
  {
    super(0);
  }
  
  public final ExecutorService invoke()
  {
    return ThreadManagerExecutor.getSingleThreadExecutorService(192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.StudyRoomQShadowLauncher.Companion.executor.2
 * JD-Core Version:    0.7.0.1
 */