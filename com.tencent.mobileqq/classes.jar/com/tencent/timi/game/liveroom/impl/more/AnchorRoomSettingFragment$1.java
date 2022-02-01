package com.tencent.timi.game.liveroom.impl.more;

import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AnchorRoomSettingFragment$1
  implements ActionSheet.OnButtonClickListener
{
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoList(this.b.getActivity(), 1);
      }
    }
    else {
      AnchorRoomSettingFragment.a(this.b, ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).profileCardUtils_enterSnapshot(this.b.getActivity(), 1));
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.more.AnchorRoomSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */