package com.tencent.mobileqq.profilecard.vas.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import aryq;
import azpb;
import azrb;
import aztg;
import bhnz;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.vas.QidCoolTextView;
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
  private QidCoolTextView jdField_a_of_type_ComTencentMobileqqVasQidCoolTextView;
  private AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  private ProfileNameView jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
  private VoteViewV2 jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public VasProfileQVipV5View(BaseActivity paramBaseActivity, azrb paramazrb)
  {
    super(paramBaseActivity, paramazrb);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Azrb = paramazrb;
    this.jdField_a_of_type_Aryq = new aryq(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 1);
  }
  
  private void e()
  {
    int j = -16777216;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initHeadUI");
    }
    Object localObject = getContext();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368830));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368826));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
    azpb localazpb = new azpb(1, null);
    int i;
    if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localObject = ((Context)localObject).getString(2131691169);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localazpb);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363426), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131368828));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368659));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localazpb);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371965));
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
      if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor != 1L) {
        break label600;
      }
      i = -16777216;
      label276:
      ((ProfileNameView)localObject).setTextColor(i);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376508));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_remark_name", this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374348);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_details", this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 = ((VoteViewV2)this.jdField_a_of_type_AndroidViewView.findViewById(2131381304));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368178));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.a(0);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374177));
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor != 1L) {
        break label605;
      }
      i = j;
      label496:
      ((TextView)localObject).setTextColor(i);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_uin_info", this.jdField_b_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentMobileqqVasQidCoolTextView = ((QidCoolTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374425));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qid_info", this.jdField_a_of_type_ComTencentMobileqqVasQidCoolTextView);
      this.jdField_a_of_type_ComTencentMobileqqVasQidCoolTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localObject = this.jdField_a_of_type_ComTencentMobileqqVasQidCoolTextView;
      if (bhnz.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard) != 1) {
        break label610;
      }
    }
    label600:
    label605:
    label610:
    for (float f = 8.5F;; f = 7.0F)
    {
      ((QidCoolTextView)localObject).a(f, 0.0F);
      return;
      localObject = ((Context)localObject).getString(2131691168);
      break;
      i = -1;
      break label276;
      i = -1;
      break label496;
    }
  }
  
  public void a(azrb paramazrb)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131562060, this, true);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368830));
    a(false);
    e();
    a(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    b(paramazrb, true);
    c(paramazrb);
    g(paramazrb);
    h(paramazrb);
    a(paramazrb, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    e(paramazrb);
    super.a(paramazrb);
  }
  
  public void a(azrb paramazrb, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteViewV2))
    {
      localObject = (VoteViewV2)localObject;
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteViewV2)localObject).e;
      }
      if ((paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteViewV2)localObject).a();
      }
      ((VoteViewV2)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteViewV2)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691139), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(azrb paramazrb, boolean paramBoolean)
  {
    a(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    b(paramazrb, false);
    c(paramazrb);
    g(paramazrb);
    h(paramazrb);
    a(paramazrb, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    e(paramazrb);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, " needRefreshUI=" + paramBoolean);
    }
    View localView = LayoutInflater.from(getContext()).inflate(2131562046, this.jdField_a_of_type_AndroidViewViewGroup, false);
    if (localView != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(localView);
      if (paramBoolean)
      {
        e();
        a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        b(this.jdField_a_of_type_Azrb, false);
        c(this.jdField_a_of_type_Azrb);
        g(this.jdField_a_of_type_Azrb);
        h(this.jdField_a_of_type_Azrb);
        a(this.jdField_a_of_type_Azrb, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        e(this.jdField_a_of_type_Azrb);
      }
    }
  }
  
  public void b(azrb paramazrb, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (!ProfileActivity.AllInOne.g(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_Long = 0L;
      return;
    }
    ThreadManager.post(new VasProfileQVipV5View.1(this, paramazrb, paramBoolean), 8, null, true);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Azrb != null) {
      b(this.jdField_a_of_type_Azrb, false);
    }
  }
  
  public void d(azrb paramazrb) {}
  
  public void h(azrb paramazrb)
  {
    if ((paramazrb.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazrb.jdField_a_of_type_JavaLangString))) {}
    Object localObject;
    do
    {
      return;
      localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject instanceof VoteViewV2));
    VoteViewV2 localVoteViewV2 = (VoteViewV2)localObject;
    boolean bool1 = a(paramazrb);
    if (this.jdField_a_of_type_Boolean) {
      bool1 = false;
    }
    for (;;)
    {
      boolean bool2 = TextUtils.equals(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (bool1)
      {
        localVoteViewV2.setVisibility(0);
        int j;
        int i;
        if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard == null)
        {
          paramazrb = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691216);
          localObject = null;
          j = 0;
          bool1 = false;
          i = 0;
        }
        for (;;)
        {
          localVoteViewV2.a(bool2, bool1, i, j, this.jdField_a_of_type_Aryq, false);
          localVoteViewV2.setTag(localObject);
          localVoteViewV2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localVoteViewV2.setContentDescription(paramazrb);
          return;
          if (this.jdField_a_of_type_Aryq == null) {
            this.jdField_a_of_type_Aryq = new aryq(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
          }
          i = (int)paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
          j = paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
          if (1 == paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
          for (bool1 = true;; bool1 = false)
          {
            this.jdField_a_of_type_Aryq.a = paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
            if (j <= this.jdField_a_of_type_Aryq.a.size()) {
              this.jdField_a_of_type_Aryq.a = this.jdField_a_of_type_Aryq.a.subList(0, j);
            }
            this.jdField_a_of_type_Aryq.a = aztg.a(this.jdField_a_of_type_Aryq.a);
            if (!bool2) {
              break label346;
            }
            localObject = new azpb(10, paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard);
            paramazrb = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691214), new Object[] { String.valueOf(i) });
            break;
          }
          label346:
          localObject = new azpb(10, paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard);
          String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691127), new Object[] { String.valueOf(i) });
          if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
            localVoteViewV2.a();
          }
          paramazrb = str;
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