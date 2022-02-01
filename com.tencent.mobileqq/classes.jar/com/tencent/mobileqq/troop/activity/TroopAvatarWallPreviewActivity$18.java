package com.tencent.mobileqq.troop.activity;

import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopAvatarWallPreviewActivity$18
  implements ActionSheet.OnButtonClickListener
{
  TroopAvatarWallPreviewActivity$18(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, ActionSheet paramActionSheet, URLDrawable paramURLDrawable, String paramString1, String paramString2) {}
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = this.a.getContent(paramInt);
    if (this.e.getString(2131890810).equals(paramView))
    {
      TroopAvatarWallPreviewActivity.access$1600(this.e, this.b);
    }
    else
    {
      if (!TextUtils.isEmpty(this.c)) {
        ProfileCardUtil.a(this.e, Long.parseLong(this.c), "0", null, 20006);
      } else if ((!TextUtils.isEmpty(this.d)) && (!"0".equals(this.d))) {
        ProfileCardUtil.a(this.e, 0L, this.d, null, 20006);
      } else {
        QQToast.makeText(this.e, 2, HardCodeUtil.a(2131912486), 0).show();
      }
      ReportController.b(null, "dc00899", "grp_lbs", this.c, "video", "clk_rep", 0, 0, "", "", "", "");
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.18
 * JD-Core Version:    0.7.0.1
 */