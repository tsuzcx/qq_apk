package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import apek;
import awki;
import awmk;
import awog;
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
  private View c;
  private View d;
  private View e;
  
  public ProfileQVipV5View(BaseActivity paramBaseActivity, awmk paramawmk, PullToZoomHeaderListView paramPullToZoomHeaderListView, TextView paramTextView, boolean paramBoolean)
  {
    super(paramBaseActivity, paramawmk);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Awmk = paramawmk;
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
    this.jdField_b_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Apek = new apek(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 1);
    a(paramawmk);
  }
  
  private void d()
  {
    int j = -16777216;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initHeadUI");
    }
    Object localObject = getContext();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368237));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368231));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
    awki localawki = new awki(1, null);
    if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localObject = ((Context)localObject).getString(2131691238);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localawki);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this.jdField_a_of_type_Awmk.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363115), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131368235));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personal_like_tip", this.jdField_a_of_type_AndroidViewView.findViewById(2131371714));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368067));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localawki);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Awmk.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373505);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371126));
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor != 1L) {
        break label542;
      }
      i = -16777216;
      label309:
      ((ProfileNameView)localObject).setTextColor(i);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131373451);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373450);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_details", this.jdField_d_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 = ((VoteViewV2)this.jdField_a_of_type_AndroidViewView.findViewById(2131380029));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367623));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.a(0);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131373312);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373311));
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor != 1L) {
        break label547;
      }
    }
    label542:
    label547:
    for (int i = j;; i = -1)
    {
      ((TextView)localObject).setTextColor(i);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_uin_info", this.jdField_a_of_type_AndroidWidgetTextView);
      return;
      localObject = ((Context)localObject).getString(2131691237);
      break;
      i = -1;
      break label309;
    }
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Awmk != null) {
      b(this.jdField_a_of_type_Awmk, false);
    }
  }
  
  public void a(awmk paramawmk)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561825, this, true);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368237));
    a(false);
    d();
    a(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    b(paramawmk, true);
    f(paramawmk);
    i(paramawmk);
    e(paramawmk);
    a(paramawmk, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    super.a(paramawmk);
  }
  
  public void a(awmk paramawmk, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteViewV2))
    {
      localObject = (VoteViewV2)localObject;
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteViewV2)localObject).e;
      }
      if ((paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteViewV2)localObject).a();
      }
      ((VoteViewV2)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteViewV2)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691209), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(awmk paramawmk, boolean paramBoolean)
  {
    a(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    b(paramawmk, false);
    f(paramawmk);
    i(paramawmk);
    e(paramawmk);
    a(paramawmk, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, " needRefreshUI=" + paramBoolean);
    }
    View localView = LayoutInflater.from(getContext()).inflate(2131561808, this.jdField_a_of_type_AndroidViewViewGroup, false);
    if (localView != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(localView);
      if (paramBoolean)
      {
        d();
        a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        b(this.jdField_a_of_type_Awmk, false);
        f(this.jdField_a_of_type_Awmk);
        i(this.jdField_a_of_type_Awmk);
        e(this.jdField_a_of_type_Awmk);
        a(this.jdField_a_of_type_Awmk, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
    }
  }
  
  public void b(awmk paramawmk) {}
  
  public void b(awmk paramawmk, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (!ProfileActivity.AllInOne.g(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_Long = 0L;
      return;
    }
    ThreadManager.post(new ProfileQVipV5View.1(this, paramawmk, paramBoolean), 8, null, true);
  }
  
  public void c(awmk paramawmk)
  {
    this.jdField_d_of_type_Int &= 0xFFFFFFFE;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void e(awmk paramawmk)
  {
    if ((paramawmk.b) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawmk.jdField_a_of_type_JavaLangString))) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject1 instanceof VoteViewV2));
    VoteViewV2 localVoteViewV2 = (VoteViewV2)localObject1;
    boolean bool1 = a(paramawmk);
    if (this.jdField_a_of_type_Boolean) {
      bool1 = false;
    }
    for (;;)
    {
      boolean bool2 = TextUtils.equals(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (bool1)
      {
        localVoteViewV2.setVisibility(0);
        Object localObject2;
        int j;
        int i;
        if (paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard == null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691285);
          localObject2 = null;
          j = 0;
          bool1 = false;
          i = 0;
        }
        for (;;)
        {
          localVoteViewV2.a(bool2, bool1, i, j, this.jdField_a_of_type_Apek, false);
          localVoteViewV2.setTag(localObject2);
          localVoteViewV2.setOnClickListener(paramawmk.jdField_a_of_type_AndroidViewView$OnClickListener);
          localVoteViewV2.setContentDescription((CharSequence)localObject1);
          return;
          if (this.jdField_a_of_type_Apek == null) {
            this.jdField_a_of_type_Apek = new apek(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
          }
          i = (int)paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
          j = paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
          if (1 == paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
          for (bool1 = true;; bool1 = false)
          {
            this.jdField_a_of_type_Apek.a = paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
            if (j <= this.jdField_a_of_type_Apek.a.size()) {
              this.jdField_a_of_type_Apek.a = this.jdField_a_of_type_Apek.a.subList(0, j);
            }
            this.jdField_a_of_type_Apek.a = awog.a(this.jdField_a_of_type_Apek.a);
            if (!bool2) {
              break label349;
            }
            localObject2 = new awki(10, paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard);
            localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691283), new Object[] { String.valueOf(i) });
            break;
          }
          label349:
          localObject2 = new awki(10, paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard);
          localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691197), new Object[] { String.valueOf(i) });
          if (paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
            localVoteViewV2.a();
          }
        }
      }
      localVoteViewV2.setVisibility(4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileQVipV5View
 * JD-Core Version:    0.7.0.1
 */