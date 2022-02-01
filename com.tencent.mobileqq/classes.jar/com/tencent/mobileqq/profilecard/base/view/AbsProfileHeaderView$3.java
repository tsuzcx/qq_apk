package com.tencent.mobileqq.profilecard.base.view;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.HashMap;

class AbsProfileHeaderView$3
  implements Runnable
{
  AbsProfileHeaderView$3(AbsProfileHeaderView paramAbsProfileHeaderView, AllInOne paramAllInOne, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject2 = (AvatarLayout)this.this$0.mHeaderChildMap.get("map_key_face");
    if (localObject2 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((AvatarLayout)localObject2).b(0);
    }
    Object localObject1 = (ImageView)localObject1;
    if ((localObject1 instanceof DynamicAvatarView))
    {
      ((AvatarLayout)localObject2).setFaceDrawable(this.this$0.mApp, 1, this.val$allinone.uin, 200, true, true, true, false, 3);
      localObject2 = (View)this.this$0.mHeaderChildMap.get("map_key_face_stoke");
      boolean bool;
      if ((this.this$0.mCardInfo != null) && (this.this$0.mCardInfo.card != null)) {
        bool = this.this$0.mCardInfo.card.isNoCover();
      } else {
        bool = false;
      }
      if (localObject2 != null)
      {
        if ((bool == true) && (!ThemeUtil.isNowThemeIsNight(this.this$0.mApp, false, null))) {
          ((View)localObject2).setVisibility(4);
        } else {
          ((View)localObject2).setVisibility(VasFaceManager.a(this.val$allinone.uin, this.this$0.mApp));
        }
        if (SimpleUIUtil.e()) {
          ((View)localObject2).setVisibility(4);
        }
      }
      AbsProfileHeaderView.access$200(this.this$0, (ImageView)localObject1);
      return;
    }
    this.this$0.updateAvatar(this.val$allinone, this.val$type, this.val$key, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.3
 * JD-Core Version:    0.7.0.1
 */