package com.tencent.mobileqq.nearby.profilecard;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

class NearbyProfileEditPanel$7
  implements View.OnClickListener
{
  NearbyProfileEditPanel$7(NearbyProfileEditPanel paramNearbyProfileEditPanel, int paramInt) {}
  
  public void onClick(View paramView)
  {
    PicInfo localPicInfo = (PicInfo)paramView.getTag();
    if (localPicInfo == null) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.create(this.b.F);
    if (this.a != 0) {
      localActionSheet.addButton(this.b.F.getResources().getString(2131892092));
    }
    localActionSheet.addButton(HardCodeUtil.a(2131905124));
    if (this.b.J.size() > 1) {
      localActionSheet.addButton(HardCodeUtil.a(2131905201), 3);
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new NearbyProfileEditPanel.7.1(this, paramView, localPicInfo, localActionSheet));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.7
 * JD-Core Version:    0.7.0.1
 */