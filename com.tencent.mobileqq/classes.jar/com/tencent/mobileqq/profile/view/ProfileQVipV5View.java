package com.tencent.mobileqq.profile.view;

import amwq;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import atuw;
import atwx;
import atyt;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PullToZoomHeaderListView;
import java.util.HashMap;
import java.util.List;

public class ProfileQVipV5View
  extends ProfileHeaderView
{
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  private ProfileNameView jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
  private VoteViewV2 jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2;
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View d;
  
  public ProfileQVipV5View(BaseActivity paramBaseActivity, atwx paramatwx, PullToZoomHeaderListView paramPullToZoomHeaderListView, TextView paramTextView, boolean paramBoolean)
  {
    super(paramBaseActivity, paramatwx);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Atwx = paramatwx;
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
    this.jdField_c_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Amwq = new amwq(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 1);
    a(paramatwx);
  }
  
  private void d()
  {
    int j = -16777216;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initHeadUI");
    }
    Object localObject = getContext();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131302479));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131302473));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
    atuw localatuw = new atuw(1, null);
    if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localObject = ((Context)localObject).getString(2131625610);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localatuw);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131297539), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131302477));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personal_like_tip", this.jdField_a_of_type_AndroidViewView.findViewById(2131305702));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302311));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localatuw);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Atwx.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131307357);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305142));
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
      if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor != 1L) {
        break label573;
      }
      i = -16777216;
      label309:
      ((ProfileNameView)localObject).setTextColor(i);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131307301);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131307300));
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor != 1L) {
        break label578;
      }
      i = -16777216;
      label396:
      ((TextView)localObject).setTextColor(i);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_details", this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 = ((VoteViewV2)this.jdField_a_of_type_AndroidViewView.findViewById(2131313488));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131301878));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.a(0);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131307160);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131307159));
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor != 1L) {
        break label583;
      }
    }
    label573:
    label578:
    label583:
    for (int i = j;; i = -1)
    {
      ((TextView)localObject).setTextColor(i);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_uin_info", this.jdField_b_of_type_AndroidWidgetTextView);
      return;
      localObject = ((Context)localObject).getString(2131625609);
      break;
      i = -1;
      break label309;
      i = -1;
      break label396;
    }
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Atwx != null) {
      b(this.jdField_a_of_type_Atwx, false);
    }
  }
  
  public void a(atwx paramatwx)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131496043, this, true);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131302479));
    a(false);
    d();
    a(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    b(paramatwx, true);
    f(paramatwx);
    i(paramatwx);
    e(paramatwx);
    a(paramatwx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    super.a(paramatwx);
  }
  
  public void a(atwx paramatwx, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteViewV2))
    {
      localObject = (VoteViewV2)localObject;
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteViewV2)localObject).e;
      }
      if ((paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteViewV2)localObject).a();
      }
      ((VoteViewV2)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteViewV2)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625584), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(atwx paramatwx, boolean paramBoolean)
  {
    a(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    b(paramatwx, false);
    f(paramatwx);
    i(paramatwx);
    e(paramatwx);
    a(paramatwx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, " needRefreshUI=" + paramBoolean);
    }
    View localView = LayoutInflater.from(getContext()).inflate(2131496026, this.jdField_a_of_type_AndroidViewViewGroup, false);
    if (localView != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(localView);
      if (paramBoolean)
      {
        d();
        a(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        b(this.jdField_a_of_type_Atwx, false);
        f(this.jdField_a_of_type_Atwx);
        i(this.jdField_a_of_type_Atwx);
        e(this.jdField_a_of_type_Atwx);
        a(this.jdField_a_of_type_Atwx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
    }
  }
  
  public void b(atwx paramatwx) {}
  
  public void b(atwx paramatwx, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (!ProfileActivity.AllInOne.g(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_Long = 0L;
      return;
    }
    ThreadManager.post(new ProfileQVipV5View.1(this, paramatwx, paramBoolean), 8, null, true);
  }
  
  public void c(atwx paramatwx)
  {
    this.jdField_d_of_type_Int &= 0xFFFFFFFE;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void e(atwx paramatwx)
  {
    if ((paramatwx.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramatwx.jdField_a_of_type_JavaLangString))) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject1 instanceof VoteViewV2));
    VoteViewV2 localVoteViewV2 = (VoteViewV2)localObject1;
    boolean bool1 = a(paramatwx);
    if (this.jdField_a_of_type_Boolean) {
      bool1 = false;
    }
    for (;;)
    {
      boolean bool2 = TextUtils.equals(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (bool1)
      {
        localVoteViewV2.setVisibility(0);
        Object localObject2;
        int j;
        int i;
        if (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard == null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625657);
          localObject2 = null;
          j = 0;
          bool1 = false;
          i = 0;
        }
        for (;;)
        {
          localVoteViewV2.a(bool2, bool1, i, j, this.jdField_a_of_type_Amwq, false);
          localVoteViewV2.setTag(localObject2);
          localVoteViewV2.setOnClickListener(paramatwx.jdField_a_of_type_AndroidViewView$OnClickListener);
          localVoteViewV2.setContentDescription((CharSequence)localObject1);
          return;
          if (this.jdField_a_of_type_Amwq == null) {
            this.jdField_a_of_type_Amwq = new amwq(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
          }
          i = (int)paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
          j = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
          if (1 == paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
          for (bool1 = true;; bool1 = false)
          {
            this.jdField_a_of_type_Amwq.a = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
            if (j <= this.jdField_a_of_type_Amwq.a.size()) {
              this.jdField_a_of_type_Amwq.a = this.jdField_a_of_type_Amwq.a.subList(0, j);
            }
            this.jdField_a_of_type_Amwq.a = atyt.a(this.jdField_a_of_type_Amwq.a);
            if (!bool2) {
              break label349;
            }
            localObject2 = new atuw(10, paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard);
            localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625655), new Object[] { String.valueOf(i) });
            break;
          }
          label349:
          localObject2 = new atuw(10, paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard);
          localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131625572), new Object[] { String.valueOf(i) });
          if (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
            localVoteViewV2.a();
          }
        }
      }
      localVoteViewV2.setVisibility(4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileQVipV5View
 * JD-Core Version:    0.7.0.1
 */