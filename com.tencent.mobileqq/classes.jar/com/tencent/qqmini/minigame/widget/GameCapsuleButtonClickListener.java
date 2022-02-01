package com.tencent.qqmini.minigame.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.widget.AppCloseDialog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.ui.OnAppCloseAction;
import com.tencent.qqmini.sdk.launcher.ui.OnAppCloseAction.Action;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.widget.CapsuleButtonClickListener;

public class GameCapsuleButtonClickListener
  extends CapsuleButtonClickListener
{
  public static final String REPORT_ACTION_CLICK = "click";
  public static final String REPORT_ACTION_EXPO = "expo";
  public static final String REPORT_ACTION_TYPE = "sdk_popup";
  public static final String REPORT_SUB_ACTION_ACTION = "action";
  public static final String REPORT_SUB_ACTION_CLOSE = "close";
  public static final String REPORT_SUB_ACTION_POPUP = "popup";
  private static final String TAG = "GameCapsuleButton";
  
  public GameCapsuleButtonClickListener(IMiniAppContext paramIMiniAppContext)
  {
    super(paramIMiniAppContext);
  }
  
  public static boolean showAppCloseDialog(IMiniAppContext paramIMiniAppContext, OnAppCloseAction paramOnAppCloseAction)
  {
    Object localObject = paramIMiniAppContext.getAttachedActivity();
    paramIMiniAppContext = paramIMiniAppContext.getMiniAppInfo();
    if (localObject != null)
    {
      if (paramIMiniAppContext == null) {
        return false;
      }
      paramIMiniAppContext = DialogUtil.createAppCloseDialog((Context)localObject);
      FrameLayout localFrameLayout = new FrameLayout((Context)localObject);
      localObject = paramOnAppCloseAction.getContentView((Context)localObject, paramIMiniAppContext);
      if (localObject != null) {
        localFrameLayout.addView((View)localObject, ((View)localObject).getLayoutParams());
      }
      paramIMiniAppContext.setCancelable(false);
      paramIMiniAppContext.setTitle(null).addView(localFrameLayout, new LinearLayout.LayoutParams(-1, -2));
      if (!TextUtils.isEmpty(paramOnAppCloseAction.positiveButtonText))
      {
        SDKMiniProgramLpReportDC04239.report("sdk_popup", "action", "expo", paramOnAppCloseAction.positiveButtonExpoReportStr, null, null, false);
        paramIMiniAppContext.setPositiveButton(paramOnAppCloseAction.positiveButtonText, paramOnAppCloseAction.positiveButtonColor, new GameCapsuleButtonClickListener.2(paramOnAppCloseAction));
      }
      if (!TextUtils.isEmpty(paramOnAppCloseAction.negativeButtonText))
      {
        SDKMiniProgramLpReportDC04239.report("sdk_popup", "close", "expo", paramOnAppCloseAction.negativeButtonExpoReportStr, null, null, false);
        paramIMiniAppContext.setNegativeButton(paramOnAppCloseAction.negativeButtonText, paramOnAppCloseAction.negativeButtonColor, new GameCapsuleButtonClickListener.3(paramOnAppCloseAction));
      }
      if (paramIMiniAppContext.getWindow() != null) {
        paramIMiniAppContext.getWindow().setLayout(paramOnAppCloseAction.dialogWidth, paramOnAppCloseAction.dialogHeight);
      }
      if (paramOnAppCloseAction.appCloseAction != null) {
        paramOnAppCloseAction.appCloseAction.onAppCloseClicked(paramIMiniAppContext);
      }
      if (paramOnAppCloseAction.appCloseActionType == 1) {
        SDKMiniProgramLpReportDC04239.report("page_view", "expo", "4001", null, null, null, false);
      }
      return true;
    }
    return false;
  }
  
  public void onCloseClick()
  {
    QMLog.i("GameCapsuleButton", "on close click");
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    OnAppCloseAction localOnAppCloseAction = localMiniAppProxy.onAppClose(this.mMiniAppContext.getMiniAppInfo(), new GameCapsuleButtonClickListener.1(this));
    if (localOnAppCloseAction != null)
    {
      SDKMiniProgramLpReportDC04239.report("sdk_popup", "popup", "expo", localOnAppCloseAction.appCloseExpoReportStr, null, null, false);
      showAppCloseDialog(this.mMiniAppContext, localOnAppCloseAction);
      return;
    }
    if ((this.mMiniAppContext.getMiniAppInfo() != null) && (!localMiniAppProxy.onCapsuleButtonCloseClick(this.mMiniAppContext, this.mDialogCloseListener))) {
      doClose();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.widget.GameCapsuleButtonClickListener
 * JD-Core Version:    0.7.0.1
 */