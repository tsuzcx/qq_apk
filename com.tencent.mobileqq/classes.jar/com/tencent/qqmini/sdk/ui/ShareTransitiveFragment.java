package com.tencent.qqmini.sdk.ui;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ShareData;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;

@MiniKeep
public class ShareTransitiveFragment
  extends MiniBaseFragment
{
  private static final int INVALID_TASK_ID = -1;
  private static final String TAG = "ShareTransitiveFragment";
  private boolean mIsAlreadyResumed;
  private int mOriginTaskId;
  private ShareData mShareData;
  private ShareProxy mShareProxy = (ShareProxy)ProxyManager.get(ShareProxy.class);
  
  private void finish()
  {
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  private Intent getIntent()
  {
    if (getActivity() == null) {
      return null;
    }
    return getActivity().getIntent();
  }
  
  private void moveTaskToFront(int paramInt, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramInt != -1)) {
      try
      {
        ((ActivityManager)getActivity().getSystemService("activity")).moveTaskToFront(paramInt, 1);
        return;
      }
      catch (Exception localException)
      {
        QMLog.w("ShareTransitiveFragment", "Failed to moveTaskToFront", localException);
        QMLog.i("ShareTransitiveFragment", "Restart mini app");
        MiniSDK.startMiniApp(getActivity(), this.mShareData.getMiniAppId());
        return;
      }
    }
    QMLog.w("ShareTransitiveFragment", "Invalid task id, restart mini app");
    MiniSDK.startMiniApp(getActivity(), this.mShareData.getMiniAppId());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityResult() requestCode=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" ,resultCode=");
    localStringBuilder.append(paramInt2);
    QMLog.i("ShareTransitiveFragment", localStringBuilder.toString());
    this.mShareProxy.onShareActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      moveTaskToFront(this.mOriginTaskId, true);
    } else if ((paramInt1 == 10104) && (paramInt2 == 0)) {
      moveTaskToFront(this.mOriginTaskId, true);
    }
    finish();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QMLog.i("ShareTransitiveFragment", "onCreate()");
    paramBundle = getIntent();
    if (paramBundle == null) {
      finish();
    }
    try
    {
      this.mOriginTaskId = paramBundle.getIntExtra("key_origin_task_id", -1);
      this.mShareData = ((ShareData)paramBundle.getParcelableExtra("key_share_data"));
      this.mShareProxy.share(getActivity(), this.mShareData);
      return;
    }
    catch (Exception paramBundle)
    {
      QMLog.e("ShareTransitiveFragment", "Failed to share", paramBundle);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.mIsAlreadyResumed)
    {
      this.mIsAlreadyResumed = true;
      return;
    }
    QMLog.i("ShareTransitiveFragment", "Finish self when second time onResume");
    moveTaskToFront(this.mOriginTaskId, true);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.ShareTransitiveFragment
 * JD-Core Version:    0.7.0.1
 */