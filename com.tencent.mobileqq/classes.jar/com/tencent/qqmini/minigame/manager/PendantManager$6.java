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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("closeWebView doOnActivityResult requestCode");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" resultCode:");
    ((StringBuilder)localObject1).append(paramInt2);
    QMLog.d("PendantManager", ((StringBuilder)localObject1).toString());
    boolean bool1 = false;
    if (paramInt1 == 11007)
    {
      localObject1 = paramIntent.getExtras();
      if ((paramInt2 == -1) && (localObject1 != null) && (((Bundle)localObject1).get("allCloseState") != null))
      {
        boolean bool2 = ((Bundle)localObject1).get("allCloseState").toString().equals("0");
        Object localObject2 = ((Bundle)localObject1).get("allCloseState").toString();
        paramIntent = "2";
        boolean bool3 = ((String)localObject2).equals("2");
        if ((bool2) || (bool3)) {
          bool1 = true;
        }
        PendantDataManager.TIME_EXTENSION_ENABLE = bool2;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("allCloseState=");
        ((StringBuilder)localObject2).append(((Bundle)localObject1).get("allCloseState").toString());
        ((StringBuilder)localObject2).append(", shouldShowStaticPic=");
        ((StringBuilder)localObject2).append(bool1);
        QMLog.d("PendantManager", ((StringBuilder)localObject2).toString());
        if (bool1)
        {
          PendantDataManager.entranceStrategy = 1;
          localObject1 = this.a;
          if (localObject1 != null) {
            PendantManager.showNewPendantIcon(this.b, (DragImageView)localObject1, this.c);
          }
          if (!bool2) {
            paramIntent = "4";
          }
          PendantDataManager.reportExposure(paramIntent);
        }
        else
        {
          PendantDataManager.entranceStrategy = 2;
          PendantDataManager.getSp().edit().putString("numMaxConsumption", Integer.toString(Integer.parseInt(this.b.getNumMaxConsumption()) - 1)).commit();
        }
        PendantDataManager.requestAd(this.c, this.d, this.b.getAppId(), this.b.getScene());
      }
      ActivityResultManager.g().removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantManager.6
 * JD-Core Version:    0.7.0.1
 */