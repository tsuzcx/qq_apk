package com.tencent.mobileqq.minigame.api;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.minigame.manager.GameReportManager;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.ErrorSeverity;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.statistic.ErrorCallback;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/api/QQMiniErrorListener;", "Lcom/tencent/mobileqq/triton/statistic/ErrorCallback;", "context", "Landroid/content/Context;", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;", "gameReportManager", "Lcom/tencent/mobileqq/minigame/manager/GameReportManager;", "(Landroid/content/Context;Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Lcom/tencent/mobileqq/minigame/manager/GameReportManager;)V", "onError", "", "message", "", "exception", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "onScriptError", "stack", "Companion", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class QQMiniErrorListener
  implements ErrorCallback
{
  public static final QQMiniErrorListener.Companion Companion = new QQMiniErrorListener.Companion(null);
  private static final int JS_ERROR = 23;
  private static final String TAG = "MiniErrorListener";
  private final Context context;
  private final GameReportManager gameReportManager;
  private final MiniAppConfig miniAppInfo;
  
  public QQMiniErrorListener(@NotNull Context paramContext, @NotNull MiniAppConfig paramMiniAppConfig, @NotNull GameReportManager paramGameReportManager)
  {
    this.context = paramContext;
    this.miniAppInfo = paramMiniAppConfig;
    this.gameReportManager = paramGameReportManager;
  }
  
  public void onError(@NotNull String paramString, @NotNull TritonException paramTritonException)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    Intrinsics.checkParameterIsNotNull(paramTritonException, "exception");
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("On TritonError ");
    localStringBuilder.append(paramString);
    localGameLog.e("MiniErrorListener", localStringBuilder.toString(), (Throwable)paramTritonException);
    if ((paramTritonException.getError().getSeverity().compareTo((Enum)ErrorSeverity.SEVER) >= 0) && (GameWnsUtils.getGameErrorDialogEnable()) && (!GameWnsUtils.getGameErrorDialogIsBlack()))
    {
      paramString = DialogUtil.a(this.context, 230, null, (CharSequence)GameWnsUtils.getGameErrorDialogContent(), HardCodeUtil.a(2131898212), HardCodeUtil.a(2131899883), (DialogInterface.OnClickListener)QQMiniErrorListener.onError.dialog.1.INSTANCE, (DialogInterface.OnClickListener)QQMiniErrorListener.onError.dialog.2.INSTANCE);
      paramString.setCanceledOnTouchOutside(false);
      paramString.show();
      MiniReportManager.reportEventType(this.miniAppInfo, 1024, "1");
    }
  }
  
  public void onScriptError(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "message");
    Intrinsics.checkParameterIsNotNull(paramString2, "stack");
    MiniAppConfig localMiniAppConfig = MiniProgramReportHelper.miniAppConfigForPreload();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    MiniReportManager.reportEventType(localMiniAppConfig, 23, localStringBuilder.toString(), "1");
    this.gameReportManager.onJsError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQMiniErrorListener
 * JD-Core Version:    0.7.0.1
 */