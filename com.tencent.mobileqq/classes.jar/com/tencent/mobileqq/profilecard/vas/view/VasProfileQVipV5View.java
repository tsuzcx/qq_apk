package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import asbe;
import azvr;
import azxr;
import azzw;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class VasProfileQVipV5View
  extends AbsProfileHeaderView
{
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  private ProfileNameView jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
  private VoteViewV2 jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  public VasProfileQVipV5View(BaseActivity paramBaseActivity, azxr paramazxr)
  {
    super(paramBaseActivity, paramazxr);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Azxr = paramazxr;
    this.jdField_a_of_type_Asbe = new asbe(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 1);
  }
  
  private void e()
  {
    int j = -16777216;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initHeadUI");
    }
    Object localObject = getContext();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368647));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368643));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
    azvr localazvr = new azvr(1, null);
    if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localObject = ((Context)localObject).getString(2131691044);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localazvr);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363327), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131368645));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368476));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localazvr);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371812));
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
      if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor != 1L) {
        break label489;
      }
      i = -16777216;
      label271:
      ((ProfileNameView)localObject).setTextColor(i);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131374346);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_details", this.b);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 = ((VoteViewV2)this.jdField_a_of_type_AndroidViewView.findViewById(2131381230));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368010));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.a(0);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374203));
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor != 1L) {
        break label494;
      }
    }
    label489:
    label494:
    for (int i = j;; i = -1)
    {
      ((TextView)localObject).setTextColor(i);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_uin_info", this.jdField_a_of_type_AndroidWidgetTextView);
      return;
      localObject = ((Context)localObject).getString(2131691043);
      break;
      i = -1;
      break label271;
    }
  }
  
  public void a(azxr paramazxr)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131562120, this, true);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368647));
    a(false);
    e();
    a(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    b(paramazxr, true);
    c(paramazxr);
    f(paramazxr);
    g(paramazxr);
    a(paramazxr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    super.a(paramazxr);
  }
  
  public void a(azxr paramazxr, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteViewV2))
    {
      localObject = (VoteViewV2)localObject;
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteViewV2)localObject).e;
      }
      if ((paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteViewV2)localObject).a();
      }
      ((VoteViewV2)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteViewV2)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691014), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(azxr paramazxr, boolean paramBoolean)
  {
    a(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    b(paramazxr, false);
    c(paramazxr);
    f(paramazxr);
    g(paramazxr);
    a(paramazxr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, " needRefreshUI=" + paramBoolean);
    }
    View localView = LayoutInflater.from(getContext()).inflate(2131562106, this.jdField_a_of_type_AndroidViewViewGroup, false);
    if (localView != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(localView);
      if (paramBoolean)
      {
        e();
        a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        b(this.jdField_a_of_type_Azxr, false);
        c(this.jdField_a_of_type_Azxr);
        f(this.jdField_a_of_type_Azxr);
        g(this.jdField_a_of_type_Azxr);
        a(this.jdField_a_of_type_Azxr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
    }
  }
  
  public void b(azxr paramazxr, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (!ProfileActivity.AllInOne.g(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_Long = 0L;
      return;
    }
    ThreadManager.post(new VasProfileQVipV5View.1(this, paramazxr, paramBoolean), 8, null, true);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Azxr != null) {
      b(this.jdField_a_of_type_Azxr, false);
    }
  }
  
  public void d(azxr paramazxr) {}
  
  public void g(azxr paramazxr)
  {
    if ((paramazxr.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazxr.jdField_a_of_type_JavaLangString))) {}
    Object localObject;
    do
    {
      return;
      localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject instanceof VoteViewV2));
    VoteViewV2 localVoteViewV2 = (VoteViewV2)localObject;
    boolean bool1 = a(paramazxr);
    if (this.jdField_a_of_type_Boolean) {
      bool1 = false;
    }
    for (;;)
    {
      boolean bool2 = TextUtils.equals(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (bool1)
      {
        localVoteViewV2.setVisibility(0);
        int j;
        int i;
        if (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard == null)
        {
          paramazxr = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691091);
          localObject = null;
          j = 0;
          bool1 = false;
          i = 0;
        }
        for (;;)
        {
          localVoteViewV2.a(bool2, bool1, i, j, this.jdField_a_of_type_Asbe, false);
          localVoteViewV2.setTag(localObject);
          localVoteViewV2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localVoteViewV2.setContentDescription(paramazxr);
          return;
          if (this.jdField_a_of_type_Asbe == null) {
            this.jdField_a_of_type_Asbe = new asbe(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
          }
          i = (int)paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
          j = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
          if (1 == paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
          for (bool1 = true;; bool1 = false)
          {
            this.jdField_a_of_type_Asbe.a = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
            if (j <= this.jdField_a_of_type_Asbe.a.size()) {
              this.jdField_a_of_type_Asbe.a = this.jdField_a_of_type_Asbe.a.subList(0, j);
            }
            this.jdField_a_of_type_Asbe.a = azzw.a(this.jdField_a_of_type_Asbe.a);
            if (!bool2) {
              break label346;
            }
            localObject = new azvr(10, paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard);
            paramazxr = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691089), new Object[] { String.valueOf(i) });
            break;
          }
          label346:
          localObject = new azvr(10, paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard);
          String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691002), new Object[] { String.valueOf(i) });
          if (paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
            localVoteViewV2.a();
          }
          paramazxr = str;
        }
      }
      localVoteViewV2.setVisibility(4);
      return;
    }
  }
  
  public void setProfileArgs(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipV5View
 * JD-Core Version:    0.7.0.1
 */