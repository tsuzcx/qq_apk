package com.tencent.mobileqq.troop.avatar;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.app.AppActivity;

class TroopPhotoController$5
  implements ActionSheet.OnButtonClickListener
{
  TroopPhotoController$5(TroopPhotoController paramTroopPhotoController, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.b.C != null)
    {
      if (paramInt >= this.b.C.length) {
        return;
      }
      paramInt = this.b.C[paramInt];
      if (paramInt != 13)
      {
        if (paramInt == 14) {
          ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoListEdit(this.b.m, ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getBusiByType(this.b.A));
        }
      }
      else
      {
        if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isUsingCameraOnVideo(this.b.q))
        {
          QQToast.makeText(this.b.m, 0, 2131893827, 0).show();
          return;
        }
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (this.b.m.checkSelfPermission("android.permission.CAMERA") != 0) {
            ((AppActivity)this.b.m).requestPermissions(new TroopPhotoController.5.1(this), 1, new String[] { "android.permission.CAMERA" });
          } else {
            TroopPhotoController.a(this.b);
          }
        }
        else {
          TroopPhotoController.a(this.b);
        }
      }
      try
      {
        this.a.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopPhotoController.5
 * JD-Core Version:    0.7.0.1
 */