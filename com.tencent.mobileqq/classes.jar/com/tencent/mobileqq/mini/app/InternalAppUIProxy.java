package com.tencent.mobileqq.mini.app;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import anzj;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.apkg.AppMode;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandFragment;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.util.AnimUtil;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class InternalAppUIProxy
  extends AppUIProxy
  implements Handler.Callback
{
  public static final String TAG = "miniapp-start_AppUIProxy_Internal";
  private BaseActivity mActivity;
  private Handler mHandler;
  private View mLoadingLayout;
  private View mRootView;
  
  public void completeLoading(BaseActivity paramBaseActivity)
  {
    QLog.i("miniapp-start_AppUIProxy_Internal", 1, "completeLoading");
    this.mLoadingLayout.setVisibility(8);
    paramBaseActivity = getCurrentFragment();
    if ((paramBaseActivity != null) && ((paramBaseActivity instanceof AppBrandFragment)))
    {
      ((AppBrandFragment)paramBaseActivity).onResume();
      ((AppBrandFragment)paramBaseActivity).completeLoading();
    }
    this.mRootView.setBackgroundColor(0);
  }
  
  public void doOnBackPressed(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    QLog.i("miniapp-start_AppUIProxy_Internal", 1, "doOnBackPressed");
    Fragment localFragment = getCurrentFragment();
    if ((localFragment != null) && ((localFragment instanceof AppBrandFragment)))
    {
      ((AppBrandFragment)localFragment).doOnBackPressed(paramBoolean);
      return;
    }
    paramBaseActivity.finish();
  }
  
  public boolean doOnCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    this.mActivity = paramBaseActivity;
    boolean bool = super.doOnCreate(paramBaseActivity, paramBundle);
    this.mLoadingLayout = this.mActivity.findViewById(2131370318);
    this.mLoadingLayout.setVisibility(8);
    this.mRootView = this.mActivity.findViewById(2131371067);
    return bool;
  }
  
  public void doOnDestroy(BaseActivity paramBaseActivity)
  {
    this.mActivity = null;
    AppLoaderFactory.getAppLoaderManager().removeListner(this.mHandler);
    super.doOnDestroy(paramBaseActivity);
  }
  
  protected int getLayoutResourceId()
  {
    return 2131559394;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.mHandler.post(new InternalAppUIProxy.2(this, paramMessage));
      continue;
      this.mHandler.post(new InternalAppUIProxy.3(this, paramMessage));
      continue;
      QLog.i("miniapp-start_AppUIProxy_Internal", 1, "MSG_WHAT_APP_EVENT_APPROUTE_DONE");
      AppLoaderFactory.getAppUIProxy().completeLoading(null);
    }
  }
  
  public boolean isWrapContent(BaseActivity paramBaseActivity)
  {
    return false;
  }
  
  public boolean moveTaskToBack(BaseActivity paramBaseActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBaseActivity == null)
    {
      QLog.i("miniapp-start_AppUIProxy_Internal", 1, "moveTaskToBack activity is null.");
      return false;
    }
    paramBaseActivity.finish();
    if (paramBoolean2) {
      AnimUtil.setCloseAnim(paramBaseActivity);
    }
    QLog.i("miniapp-start_AppUIProxy_Internal", 1, "moveTaskToBack nonRoot=" + paramBoolean1 + " bAnim=" + paramBoolean2);
    return true;
  }
  
  public void startLoading(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppUIProxy_Internal", 1, "startLoading");
    this.mLoadingLayout.setVisibility(0);
    this.mRootView.setBackgroundColor(-1);
    if (paramBundle != null) {}
    for (paramBundle = (MiniAppConfig)paramBundle.getParcelable("CONFIG"); paramBundle == null; paramBundle = null)
    {
      Toast.makeText(paramBaseActivity, anzj.a(2131704704), 1).show();
      paramBaseActivity.finish();
      return;
    }
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject).topMargin = (DisplayUtil.dip2px(paramBaseActivity, 9.0F) + ImmersiveUtils.getStatusBarHeight(paramBaseActivity));
    this.mLoadingLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (ViewGroup)this.mLoadingLayout.findViewById(2131365042);
    if ((paramBundle.isInternalApp()) && (paramBundle.config.appMode.closeTopRightCapsule)) {
      ((ViewGroup)localObject).setVisibility(8);
    }
    for (;;)
    {
      if (paramBundle.baseLibInfo == null) {
        paramBundle.baseLibInfo = AppLoaderFactory.getAppLoaderManager().getBaseLibInfo();
      }
      this.mHandler = new Handler(this);
      AppLoaderFactory.getAppLoaderManager().addListener(this.mHandler);
      AppLoaderFactory.getAppLoaderManager().start(paramBaseActivity);
      AppLoaderFactory.getAppLoaderManager().loadApkgByConfig(paramBundle);
      return;
      ((ViewGroup)localObject).setVisibility(0);
      localObject = (ImageView)this.mLoadingLayout.findViewById(2131363765);
      if (!TextUtils.isEmpty(MiniAppGlobal.CAPSULE_CLOSE_URL)) {
        ((ImageView)localObject).setImageDrawable(MiniAppUtils.getIcon(paramBaseActivity, MiniAppGlobal.CAPSULE_CLOSE_URL, true, 2130841239, 40, 30));
      }
      ((ImageView)localObject).setOnClickListener(new InternalAppUIProxy.1(this, paramBaseActivity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.InternalAppUIProxy
 * JD-Core Version:    0.7.0.1
 */