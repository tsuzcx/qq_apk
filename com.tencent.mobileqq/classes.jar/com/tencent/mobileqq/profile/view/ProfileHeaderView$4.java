package com.tencent.mobileqq.profile.view;

import android.view.View;
import android.widget.ImageView;
import awqt;
import azmk;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import java.util.HashMap;

class ProfileHeaderView$4
  implements Runnable
{
  ProfileHeaderView$4(ProfileHeaderView paramProfileHeaderView, ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject2 = (AvatarLayout)this.this$0.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
    Object localObject1;
    int i;
    if (localObject2 == null)
    {
      localObject1 = null;
      localObject1 = (ImageView)localObject1;
      if (!(localObject1 instanceof DynamicAvatarView)) {
        break label208;
      }
      ((AvatarLayout)localObject2).setFaceDrawable(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 200, true, true, true, false, 3);
      localObject2 = (View)this.this$0.jdField_a_of_type_JavaUtilHashMap.get("map_key_face_stoke");
      if ((this.this$0.jdField_a_of_type_Awqt == null) || (this.this$0.jdField_a_of_type_Awqt.a == null)) {
        break label229;
      }
      if (!this.this$0.jdField_a_of_type_Awqt.a.isNoCover()) {
        break label179;
      }
      i = 1;
    }
    for (;;)
    {
      label121:
      if (localObject2 != null)
      {
        if ((i != 1) || (ThemeUtil.isNowThemeIsNight(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))) {
          break label184;
        }
        ((View)localObject2).setVisibility(4);
      }
      for (;;)
      {
        if (azmk.b()) {
          ((View)localObject2).setVisibility(4);
        }
        ProfileHeaderView.a(this.this$0, (ImageView)localObject1);
        return;
        localObject1 = ((AvatarLayout)localObject2).a(0);
        break;
        label179:
        i = 0;
        break label121;
        label184:
        ((View)localObject2).setVisibility(VasFaceManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      label208:
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, false);
      return;
      label229:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView.4
 * JD-Core Version:    0.7.0.1
 */