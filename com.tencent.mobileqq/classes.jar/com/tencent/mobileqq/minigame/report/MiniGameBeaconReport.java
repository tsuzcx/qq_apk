package com.tencent.mobileqq.minigame.report;

import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import cooperation.qzone.QUA;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/report/MiniGameBeaconReport;", "", "()V", "BEACON_MAX_EVENT_NAME_LENGTH", "", "JANK_TRACE_TOP_RECORDS_COUNT", "MINI_GAME_BEACON_KEY", "", "init", "", "report", "eventCode", "params", "", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class MiniGameBeaconReport
{
  private static final int BEACON_MAX_EVENT_NAME_LENGTH = 59;
  public static final MiniGameBeaconReport INSTANCE = new MiniGameBeaconReport();
  private static final int JANK_TRACE_TOP_RECORDS_COUNT = 20;
  private static final String MINI_GAME_BEACON_KEY = "00000ARN3S3S9UE8";
  
  static
  {
    init();
  }
  
  @JvmStatic
  public static final void init()
  {
    UserAction.registerTunnel(new TunnelInfo("00000ARN3S3S9UE8", AppSetting.f(), "1000"));
  }
  
  @JvmStatic
  public static final void report(@NotNull String paramString, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventCode");
    if (paramMap != null)
    {
      Map localMap = MapsKt.toMutableMap(paramMap);
      if (localMap != null)
      {
        paramMap = QUA.getQUA3();
        Intrinsics.checkExpressionValueIsNotNull(paramMap, "QUA.getQUA3()");
        localMap.put("qua", paramMap);
        paramMap = BaseApplicationImpl.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(paramMap, "BaseApplicationImpl.getApplication()");
        paramMap = paramMap.getRuntime();
        if (paramMap != null)
        {
          paramMap = paramMap.getAccount();
          if (paramMap != null) {}
        }
        else
        {
          paramMap = "";
        }
        localMap.put("uid", paramMap);
        localMap.put("perfLevel", String.valueOf(DeviceInfoUtils.a()));
        paramMap = localMap;
        break label105;
      }
    }
    paramMap = null;
    label105:
    UserAction.onUserActionToTunnel("00000ARN3S3S9UE8", paramString, paramMap, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.report.MiniGameBeaconReport
 * JD-Core Version:    0.7.0.1
 */