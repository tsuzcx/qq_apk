package com.tencent.qqmini.sdk.ui;

import android.content.Intent;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.ui.OnMoreItemSelectedListener;

final class MorePanel$1
  implements IActivityResultListener
{
  MorePanel$1(ShareState paramShareState, MiniAppProxy paramMiniAppProxy, IMiniAppContext paramIMiniAppContext) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (9527 != paramInt1) {
      return false;
    }
    MorePanel.access$002(false);
    ActivityResultManager.g().removeActivityResultListener(this);
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("more_item_id", -1);
      this.val$shareState.isShareInMiniProcess = paramIntent.getBooleanExtra("share_in_mini_process", false);
      paramIntent = this.val$proxy.getMoreItemSelectedListener();
      if (paramIntent != null) {
        paramIntent.onMoreItemSelected(this.val$miniAppContext, paramInt1);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MorePanel.1
 * JD-Core Version:    0.7.0.1
 */