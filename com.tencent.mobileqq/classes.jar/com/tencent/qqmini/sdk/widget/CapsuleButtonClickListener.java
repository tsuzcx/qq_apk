package com.tencent.qqmini.sdk.widget;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.action.HideInputAction;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NavigateBackUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.ui.InternalMiniActivity;

public class CapsuleButtonClickListener
  implements CapsuleButton.CapsuleBtnClickListener
{
  static final String TAG = "CapsuleButton";
  protected DialogInterface.OnClickListener mDialogCloseListener = new CapsuleButtonClickListener.1(this);
  protected IMiniAppContext mMiniAppContext;
  protected ShareProxy mShareProxy;
  
  public CapsuleButtonClickListener(IMiniAppContext paramIMiniAppContext)
  {
    this.mMiniAppContext = paramIMiniAppContext;
    this.mShareProxy = ((ShareProxy)ProxyManager.get(ShareProxy.class));
  }
  
  protected void doClose()
  {
    Object localObject = this.mMiniAppContext.getAttachedActivity();
    int i;
    boolean bool;
    if ((localObject != null) && (!((Activity)localObject).isFinishing())) {
      if ((localObject instanceof InternalMiniActivity))
      {
        ((Activity)localObject).finish();
      }
      else
      {
        i = 0;
        bool = this.mMiniAppContext.isMiniGame();
      }
    }
    try
    {
      bool = ((Activity)localObject).moveTaskToBack(bool);
      i = bool;
    }
    catch (Throwable localThrowable)
    {
      label55:
      break label55;
    }
    if (i == 0)
    {
      QMLog.e("CapsuleButton", "moveTaskToBack failed, finish the activity.");
      ((Activity)localObject).finish();
    }
    this.mMiniAppContext.performAction(AppStateEvent.obtain(60));
    if (this.mMiniAppContext.isMiniGame())
    {
      localObject = this.mMiniAppContext.getMiniAppInfo();
      if ((localObject != null) && (((MiniAppInfo)localObject).launchParam != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject).launchParam.fromMiniAppId))) {
        NavigateBackUtils.writeTagAppid(((MiniAppInfo)localObject).launchParam.fromMiniAppId);
      }
    }
  }
  
  public void onCloseClick()
  {
    QMLog.i("CapsuleButton", "on close click");
    if ((this.mMiniAppContext.getMiniAppInfo() != null) && (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonCloseClick(this.mMiniAppContext, this.mDialogCloseListener))) {
      doClose();
    }
    HideInputAction.hideInput(this.mMiniAppContext);
  }
  
  public void onMoreClick()
  {
    QMLog.i("CapsuleButton", "on more click");
    if (TextUtils.isEmpty(LoginManager.getInstance().getAccount()))
    {
      QMLog.e("CapsuleButton", "uin is empty, not show MoreClick. ");
      return;
    }
    ShareState localShareState = GetShareState.obtain(this.mMiniAppContext);
    if (localShareState != null)
    {
      localShareState.launchFrom = 0;
      localShareState.stagingJsonParams = null;
    }
    this.mShareProxy.showSharePanel(this.mMiniAppContext);
    if (this.mMiniAppContext.getMiniAppInfo() != null) {
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonMoreClick(this.mMiniAppContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.CapsuleButtonClickListener
 * JD-Core Version:    0.7.0.1
 */