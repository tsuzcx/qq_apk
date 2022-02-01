package com.tencent.mobileqq.troop.activity;

import android.os.Bundle;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopAvatarWallPreviewActivity$17
  implements ActionSheet.OnButtonClickListener
{
  String a = this.d.mAdapter.a(this.d.mIndex);
  
  TroopAvatarWallPreviewActivity$17(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, ActionSheet paramActionSheet, URLDrawable paramURLDrawable) {}
  
  public void onClick(View paramView, int paramInt)
  {
    ITroopAvatarUtilApi localITroopAvatarUtilApi = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    if ((localITroopAvatarUtilApi.isNumeric(this.a) ^ true))
    {
      paramView = this.a;
    }
    else
    {
      if (this.a.equals(AvatarInfo.a)) {
        paramView = localITroopAvatarUtilApi.getAvatarAddress(this.a, this.d.mTroopUin, 0);
      } else {
        paramView = localITroopAvatarUtilApi.getAvatarAddress(this.a, this.d.mTroopUin, 1);
      }
      localITroopAvatarUtilApi.getThumbPhoto(paramView);
    }
    paramView = this.b.getContent(paramInt);
    if (this.d.getString(2131890804).equals(paramView))
    {
      this.d.forward(this.c, this.a);
    }
    else if (this.d.getString(2131890810).equals(paramView))
    {
      TroopAvatarWallPreviewActivity.access$1600(this.d, this.c);
    }
    else if (this.d.getString(2131890808).equals(paramView))
    {
      paramView = this.d;
      paramView.onQRDecodeSucceed(paramView.tempPath, this.a);
    }
    else if (this.d.getString(2131895534).equals(paramView))
    {
      paramView = this.d;
      paramView.setDefaultAvatar(paramView.mIndex);
    }
    else if (this.d.getString(2131890801).equals(paramView))
    {
      if ((this.d.mDeleteAbility) && (TroopAvatarWallPreviewActivity.access$500(this.d) != null) && (TroopAvatarWallPreviewActivity.access$500(this.d).getBoolean("from_personality_label", false)))
      {
        paramView = this.d;
        TroopAvatarWallPreviewActivity.access$1700(paramView, paramView.mIndex, TroopAvatarWallPreviewActivity.access$500(this.d));
      }
      else if ((this.d.mDeleteAbility) && (TroopAvatarWallPreviewActivity.access$500(this.d) != null) && (TroopAvatarWallPreviewActivity.access$500(this.d).getBoolean("from_extend_Friend_edit", false)))
      {
        paramView = this.d;
        TroopAvatarWallPreviewActivity.access$1800(paramView, paramView.mIndex);
      }
      else
      {
        if (this.d.mDeleteAbility)
        {
          paramView = this.d;
          if (paramView.canDelete(paramView.mIndex))
          {
            paramView = this.d;
            paramView.deletePhotoWall(paramView.mIndex);
            break label417;
          }
        }
        paramView = this.d;
        paramView.setDefaultAvatar(paramView.mIndex);
      }
    }
    label417:
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.17
 * JD-Core Version:    0.7.0.1
 */