package com.tencent.mobileqq.studyroom.utils;

import android.content.Context;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher$Companion;", "", "()V", "DATA_COST_WARNING_THRESHOLD", "", "FAKE_PROGRESS_INTERVAL_DATA", "", "FAKE_PROGRESS_INTERVAL_WIFI", "LOADING_IMAGE_URL", "", "PLUGIN_ENTRY_ACTIVITY", "PLUGIN_ID", "PROGRESS_GET_TICKET_OFFSET_HAS_DOWNLOAD", "PROGRESS_GET_TICKET_OFFSET_NO_DOWNLOAD", "PROGRESS_MAX_FAKE", "PROGRESS_OPEN_OFFSET_HAS_DOWNLOAD", "PROGRESS_OPEN_OFFSET_NO_DOWNLOAD", "PROGRESS_TOTAL", "STEP_DONE", "STEP_ERROR", "STEP_GET_TICKET", "STEP_INIT", "STEP_INSTALL", "STEP_LOAD", "STEP_NEW", "SUB_MODULE_ID", "TAG", "TRANSPARENT_COLOR", "WAIT_UPDATE_PLUGIN_INFO_TIME_SECOND", "executor", "Ljava/util/concurrent/ExecutorService;", "getExecutor", "()Ljava/util/concurrent/ExecutorService;", "executor$delegate", "Lkotlin/Lazy;", "formatSize", "s", "getFakeProgressInterval", "context", "Landroid/content/Context;", "qqstudyroom_impl_release"}, k=1, mv={1, 1, 16})
public final class StudyRoomQShadowLauncher$Companion
{
  private final long a(Context paramContext)
  {
    if (NetworkUtil.isWifiConnected(paramContext)) {
      return 200L;
    }
    return 500L;
  }
  
  private final String a(long paramLong)
  {
    double d = paramLong;
    if (d > 107374182.40000001D)
    {
      f = (float)paramLong / 1024.0F / 1024.0F / 1024.0F;
      localObject = StringCompanionObject.INSTANCE;
      localObject = new Object[1];
      localObject[0] = Float.valueOf(f);
      localObject = String.format("%.1f G", Arrays.copyOf((Object[])localObject, localObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
      return localObject;
    }
    if (d > 104857.60000000001D)
    {
      f = (float)paramLong / 1024.0F / 1024.0F;
      localObject = StringCompanionObject.INSTANCE;
      localObject = new Object[1];
      localObject[0] = Float.valueOf(f);
      localObject = String.format("%.1f M", Arrays.copyOf((Object[])localObject, localObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
      return localObject;
    }
    float f = (float)paramLong / 1024.0F;
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = new Object[1];
    localObject[0] = Float.valueOf(f);
    localObject = String.format("%.1f K", Arrays.copyOf((Object[])localObject, localObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
    return localObject;
  }
  
  private final ExecutorService a()
  {
    Lazy localLazy = StudyRoomQShadowLauncher.a();
    Companion localCompanion = StudyRoomQShadowLauncher.a;
    return (ExecutorService)localLazy.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.StudyRoomQShadowLauncher.Companion
 * JD-Core Version:    0.7.0.1
 */