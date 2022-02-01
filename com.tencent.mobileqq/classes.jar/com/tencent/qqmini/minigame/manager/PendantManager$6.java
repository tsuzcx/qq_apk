package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.qqmini.minigame.widget.DragImageView;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;

final class PendantManager$6
  implements IActivityResultListener
{
  PendantManager$6(DragImageView paramDragImageView, PendantAdInfo paramPendantAdInfo, Activity paramActivity, IMiniAppContext paramIMiniAppContext) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = false;
    QMLog.d("PendantManager", "closeWebView doOnActivityResult requestCode" + paramInt1 + " resultCode:" + paramInt2);
    if (paramInt1 == 11007)
    {
      paramIntent = paramIntent.getExtras();
      if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.get("allCloseState") != null))
      {
        boolean bool2 = paramIntent.get("allCloseState").toString().equals("0");
        boolean bool3 = paramIntent.get("allCloseState").toString().equals("2");
        if ((bool2) || (bool3)) {
          bool1 = true;
        }
        PendantDataManager.TIME_EXTENSION_ENABLE = bool2;
        QMLog.d("PendantManager", "allCloseState=" + paramIntent.get("allCloseState").toString() + ", shouldShowStaticPic=" + bool1);
        if (!bool1) {
          break label241;
        }
        PendantDataManager.entranceStrategy = 1;
        if (this.jdField_a_of_type_ComTencentQqminiMinigameWidgetDragImageView != null) {
          PendantManager.showNewPendantIcon(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelPendantAdInfo, this.jdField_a_of_type_ComTencentQqminiMinigameWidgetDragImageView, this.jdField_a_of_type_AndroidAppActivity);
        }
        if (!bool2) {
          break label235;
        }
        paramIntent = "2";
        PendantDataManager.reportExposure(paramIntent);
      }
      for (;;)
      {
        PendantDataManager.requestAd(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelPendantAdInfo.getAppId(), this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelPendantAdInfo.getScene());
        ActivityResultManager.g().removeActivityResultListener(this);
        return true;
        label235:
        paramIntent = "4";
        break;
        label241:
        PendantDataManager.entranceStrategy = 2;
        PendantDataManager.getSp().edit().putString("numMaxConsumption", Integer.toString(Integer.parseInt(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelPendantAdInfo.getNumMaxConsumption()) - 1)).commit();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantManager.6
 * JD-Core Version:    0.7.0.1
 */