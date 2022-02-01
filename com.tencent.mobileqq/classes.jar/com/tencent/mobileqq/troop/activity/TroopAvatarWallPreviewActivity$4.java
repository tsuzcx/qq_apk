package com.tencent.mobileqq.troop.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;

class TroopAvatarWallPreviewActivity$4
  implements AdapterView.OnItemSelectedListener
{
  TroopAvatarWallPreviewActivity$4(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    boolean bool2 = TroopAvatarWallPreviewActivity.access$100(this.a).isReport;
    boolean bool1 = true;
    if (bool2)
    {
      TroopAvatarWallPreviewActivity.access$100(this.a).addPicIndex(paramInt);
      paramAdapterView = TroopAvatarWallPreviewActivity.access$100(this.a);
      paramAdapterView.slide_number += 1;
    }
    this.a.mIndex = paramInt;
    paramAdapterView = new StringBuilder();
    paramAdapterView.append(this.a.mIndex + 1);
    paramAdapterView.append("/");
    paramAdapterView.append(this.a.mSeqListLength);
    paramAdapterView = paramAdapterView.toString();
    this.a.mTextView.setText(paramAdapterView);
    if (this.a.mIsTroopMember) {
      ReportController.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.mTroopUin, "0", "", "");
    } else {
      ReportController.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.mTroopUin, "1", "", "");
    }
    if (this.a.mNeedBottomBar)
    {
      paramAdapterView = this.a;
      TroopAvatarWallPreviewActivity.access$200(paramAdapterView, paramAdapterView.mIndex);
    }
    bool2 = this.a.mIsShowMenu;
    paramAdapterView = TroopAvatarWallPreviewActivity.access$300(this.a);
    paramInt = 0;
    if ((paramAdapterView != null) && (TroopAvatarWallPreviewActivity.access$300(this.a).getBoolean("from_personality_label", false)))
    {
      paramAdapterView = this.a;
      if (Long.valueOf((String)paramAdapterView.mPhotoIds.get(this.a.mIndex)).longValue() == -1L) {
        bool1 = false;
      }
      paramAdapterView.mIsShowMenu = bool1;
    }
    if (bool2 != this.a.mIsShowMenu)
    {
      paramAdapterView = this.a.mMenuBtn;
      if (!this.a.mIsShowMenu) {
        paramInt = 8;
      }
      paramAdapterView.setVisibility(paramInt);
    }
    if (this.a.isGridImageReport) {
      TroopAvatarWallPreviewActivity.access$400(this.a);
    }
    paramAdapterView = this.a;
    TroopAvatarWallPreviewActivity.access$500(paramAdapterView, paramAdapterView.mIndex);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */