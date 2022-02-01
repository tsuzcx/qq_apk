package com.tencent.mobileqq.nearby.profilecard;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

class NearbyProfileEditTribePanel$5
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    if (localPicInfo == null) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.create(this.b.A);
    if (this.a != 0) {
      localActionSheet.addButton(this.b.A.getResources().getString(2131892092));
    }
    localActionSheet.addButton(HardCodeUtil.a(2131905175));
    if (this.b.E.size() > 1) {
      localActionSheet.addButton(HardCodeUtil.a(2131905150), 3);
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new NearbyProfileEditTribePanel.5.1(this, paramView, localPicInfo, localActionSheet));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.5
 * JD-Core Version:    0.7.0.1
 */