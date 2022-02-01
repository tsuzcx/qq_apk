package com.tencent.qqmini.minigame.api;

import android.content.Context;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.ErrorSeverity;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.statistic.ErrorCallback;
import com.tencent.qqmini.minigame.manager.GameReportManager;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.utils.thread.ThreadPools;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/api/MiniErrorListener;", "Lcom/tencent/mobileqq/triton/statistic/ErrorCallback;", "context", "Landroid/content/Context;", "miniAppInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "gameReportManager", "Lcom/tencent/qqmini/minigame/manager/GameReportManager;", "(Landroid/content/Context;Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;Lcom/tencent/qqmini/minigame/manager/GameReportManager;)V", "onError", "", "message", "", "exception", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "onScriptError", "stack", "Companion", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class MiniErrorListener
  implements ErrorCallback
{
  public static final MiniErrorListener.Companion Companion = new MiniErrorListener.Companion(null);
  private static final int JS_ERROR = 23;
  private static final String TAG = "MiniErrorListener";
  private final Context context;
  private final GameReportManager gameReportManager;
  private final MiniAppInfo miniAppInfo;
  
  public MiniErrorListener(@NotNull Context paramContext, @NotNull MiniAppInfo paramMiniAppInfo, @NotNull GameReportManager paramGameReportManager)
  {
    this.context = paramContext;
    this.miniAppInfo = paramMiniAppInfo;
    this.gameReportManager = paramGameReportManager;
  }
  
  public void onError(@NotNull String paramString, @NotNull TritonException paramTritonException)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    Intrinsics.checkParameterIsNotNull(paramTritonException, "exception");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("On TritonError ");
    localStringBuilder.append(paramString);
    QMLog.e("MiniErrorListener", localStringBuilder.toString(), (Throwable)paramTritonException);
    if ((paramTritonException.getError().getSeverity().compareTo((Enum)ErrorSeverity.SEVER) >= 0) && (GameWnsUtils.getGameErrorDialogEnable()) && (!GameWnsUtils.getGameErrorDialogIsBlack()))
    {
      ThreadPools.getMainThreadExecutor().execute((Runnable)new MiniErrorListener.onError.1(this));
      MiniReportManager.reportEventType(this.miniAppInfo, 1024, "1");
    }
  }
  
  public void onScriptError(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "message");
    Intrinsics.checkParameterIsNotNull(paramString2, "stack");
    MiniAppInfo localMiniAppInfo = ReportConst.miniAppConfigForPreload();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    MiniReportManager.reportEventType(localMiniAppInfo, 23, localStringBuilder.toString(), "1");
    this.gameReportManager.onJsError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.MiniErrorListener
 * JD-Core Version:    0.7.0.1
 */