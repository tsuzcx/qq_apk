package com.tencent.mobileqq.profilecard.base.view;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import java.util.HashMap;

class AbsProfileHeaderView$3
  implements Runnable
{
  AbsProfileHeaderView$3(AbsProfileHeaderView paramAbsProfileHeaderView, ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject2 = (AvatarLayout)this.this$0.mHeaderChildMap.get("map_key_face");
    Object localObject1;
    int i;
    if (localObject2 == null)
    {
      localObject1 = null;
      localObject1 = (ImageView)localObject1;
      if (!(localObject1 instanceof DynamicAvatarView)) {
        break label208;
      }
      ((AvatarLayout)localObject2).setFaceDrawable(this.this$0.mApp, 1, this.val$allinone.a, 200, true, true, true, false, 3);
      localObject2 = (View)this.this$0.mHeaderChildMap.get("map_key_face_stoke");
      if ((this.this$0.mCardInfo == null) || (this.this$0.mCardInfo.a == null)) {
        break label229;
      }
      if (!this.this$0.mCardInfo.a.isNoCover()) {
        break label179;
      }
      i = 1;
    }
    for (;;)
    {
      label121:
      if (localObject2 != null)
      {
        if ((i != 1) || (ThemeUtil.isNowThemeIsNight(this.this$0.mApp, false, null))) {
          break label184;
        }
        ((View)localObject2).setVisibility(4);
      }
      for (;;)
      {
        if (SimpleUIUtil.a()) {
          ((View)localObject2).setVisibility(4);
        }
        AbsProfileHeaderView.access$200(this.this$0, (ImageView)localObject1);
        return;
        localObject1 = ((AvatarLayout)localObject2).a(0);
        break;
        label179:
        i = 0;
        break label121;
        label184:
        ((View)localObject2).setVisibility(VasFaceManager.a(this.val$allinone.a, this.this$0.mApp));
      }
      label208:
      this.this$0.updateAvatar(this.val$allinone, this.val$type, this.val$key, false);
      return;
      label229:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.3
 * JD-Core Version:    0.7.0.1
 */