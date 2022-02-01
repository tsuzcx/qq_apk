package com.tencent.mobileqq.troop.troopcard;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController.OnGotoBigPicListener;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import java.util.ArrayList;

class VisitorTroopCardPresenter$4
  implements TroopPhotoController.OnGotoBigPicListener
{
  VisitorTroopCardPresenter$4(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  public void b(Bundle paramBundle)
  {
    if ((VisitorTroopCardPresenter.a(this.a) != null) && (VisitorTroopCardPresenter.a(this.a) != null))
    {
      if (VisitorTroopCardPresenter.a(this.a) == null) {
        return;
      }
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      Intent localIntent = new Intent();
      localIntent.setClass(VisitorTroopCardPresenter.a(this.a), ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopAvatarWallEditActivityClass());
      localBundle.putInt("index", 0);
      localBundle.putString("troop_uin", VisitorTroopCardPresenter.a(this.a).troopUin);
      localBundle.putLong("troop_flag_ext", VisitorTroopCardPresenter.a(this.a).dwGroupFlagExt);
      localBundle.putBoolean("isUseClassAvatar", VisitorTroopCardPresenter.a(this.a).isUseClassAvatar);
      boolean bool2 = localBundle.getBoolean("IS_EDIT");
      boolean bool1 = localBundle.getBoolean("IS_COVER") ^ true;
      if (bool1) {
        paramBundle = VisitorTroopCardPresenter.a(this.a);
      } else {
        paramBundle = VisitorTroopCardPresenter.b(this.a);
      }
      paramBundle = (ArrayList)paramBundle;
      if (bool2) {
        localBundle.putInt("vistor_type", 1);
      } else {
        localBundle.putInt("vistor_type", 2);
      }
      localBundle.putParcelableArrayList("PHOTO_LIST", paramBundle);
      int i;
      if (bool1)
      {
        if (bool2) {
          i = 260;
        } else {
          i = 261;
        }
      }
      else if (bool2) {
        i = 258;
      } else {
        i = 259;
      }
      localIntent.putExtras(localBundle);
      localIntent.addFlags(603979776);
      VisitorTroopCardPresenter.a(this.a).startActivityForResult(localIntent, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardPresenter.4
 * JD-Core Version:    0.7.0.1
 */