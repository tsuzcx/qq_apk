package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apit;
import awor;
import awqt;
import awsp;
import azkz;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PullToZoomHeaderListView;
import java.util.HashMap;
import java.util.List;

public class ProfileBaseView
  extends ProfileHeaderView
{
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  private ProfileNameView jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
  private RandomCoverView jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView;
  private VoteViewV2 jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2;
  private PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  private View c;
  private View d;
  private View e;
  private View f;
  private int g;
  
  public ProfileBaseView(BaseActivity paramBaseActivity, awqt paramawqt, PullToZoomHeaderListView paramPullToZoomHeaderListView, TextView paramTextView, boolean paramBoolean)
  {
    super(paramBaseActivity, paramawqt);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Awqt = paramawqt;
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = paramPullToZoomHeaderListView;
    this.jdField_b_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Apit = new apit(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 1);
    a(paramawqt);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initHeadUI");
    }
    Object localObject = getContext();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368248));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368242));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
    awor localawor = new awor(1, null);
    if (this.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (localObject = ((Context)localObject).getString(2131691239);; localObject = ((Context)localObject).getString(2131691238))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localawor);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this.jdField_a_of_type_Awqt.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363115), false);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face_stoke", this.jdField_a_of_type_AndroidViewView.findViewById(2131368246));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personal_like_tip", this.jdField_a_of_type_AndroidViewView.findViewById(2131371734));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368078));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localawor);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Awqt.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131373557);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371145));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickable(true);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373503);
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373502);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_details", this.jdField_e_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 = ((VoteViewV2)this.jdField_a_of_type_AndroidViewView.findViewById(2131380087));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367633));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131373364);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373363));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_uin_info", this.jdField_a_of_type_AndroidWidgetTextView);
      return;
    }
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Awqt != null) {
      b(this.jdField_a_of_type_Awqt, false);
    }
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
    invalidate();
  }
  
  public void a(int paramInt, awqt paramawqt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("onCoverModeChange mode: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setTextColor(getResources().getColor(2131166903));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.a(1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) {
        ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).i(0);
      }
      paramawqt = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      paramawqt.addRule(3, 0);
      paramawqt.addRule(10, 1);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramawqt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setTag(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setContentDescription(null);
      b(paramInt);
      return;
    }
    int i;
    awor localawor;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView != null)
    {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        i = 2131166903;
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setTextColor(getResources().getColor(i));
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetVoteViewV2.a(0);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) {
        ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).i(1);
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131368265);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, 0);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localawor = new awor(17, null);
      if (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label342;
      }
    }
    label342:
    for (Object localObject = getContext().getString(2131691234);; localObject = getContext().getString(2131691233))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setTag(localawor);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setOnClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setContentDescription((CharSequence)localObject);
      b(paramInt);
      return;
      i = 2131167059;
      break;
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "loadHeadLayout mode=" + paramInt + ", needRefreshUI=" + paramBoolean);
    }
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    View localView = null;
    if (paramInt == 1) {
      localView = localLayoutInflater.inflate(2131561806, this.jdField_a_of_type_AndroidViewViewGroup, false);
    }
    for (;;)
    {
      if (localView != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_AndroidViewViewGroup.addView(localView);
        if (paramBoolean)
        {
          d();
          a(this.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          b(this.jdField_a_of_type_Awqt, false);
          f(this.jdField_a_of_type_Awqt);
          i(this.jdField_a_of_type_Awqt);
          e(this.jdField_a_of_type_Awqt);
          a(this.jdField_a_of_type_Awqt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
      }
      return;
      if (paramInt == 0) {
        localView = localLayoutInflater.inflate(2131561805, this.jdField_a_of_type_AndroidViewViewGroup, false);
      }
    }
  }
  
  public void a(awqt paramawqt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561804, this, true);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368248));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView = ((RandomCoverView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368265));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setHeaderImage(this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a());
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setHeaderMask(this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a());
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setProfileBaseView(this);
    int i;
    if (ProfileActivity.AllInOne.i(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
      i = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView = ((RandomCoverView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368265));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368239);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.setVisibility(0);
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str1 = paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      String str2 = this.jdField_b_of_type_JavaLangString;
      if (this.jdField_e_of_type_Int == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((RandomCoverView)localObject1).a((QQAppInterface)localObject2, str1, i, str2, bool, true);
        a(i, false);
        d();
        a(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        b(paramawqt, true);
        f(paramawqt);
        i(paramawqt);
        e(paramawqt);
        a(paramawqt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        super.a(paramawqt);
        a(i, paramawqt);
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          paramawqt = (ImageView)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363115);
          localObject1 = (ImageView)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_face_stoke");
          localObject2 = this.jdField_a_of_type_AndroidWidgetImageView;
          paramawqt.setColorFilter(1996488704);
          ((ImageView)localObject1).setColorFilter(1996488704);
          ((ImageView)localObject2).setColorFilter(1996488704);
        }
        return;
        if (paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
          break label410;
        }
        localObject1 = paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.getCoverData(this.jdField_e_of_type_Int);
        localObject2 = (String)localObject1[0];
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.jdField_b_of_type_JavaLangString = ((String)localObject2);
          this.jdField_e_of_type_Int = ((Integer)localObject1[1]).intValue();
        }
        if (!paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()) {
          break label410;
        }
        i = 1;
        break;
      }
      label410:
      i = 0;
    }
  }
  
  public void a(awqt paramawqt, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteViewV2))
    {
      localObject = (VoteViewV2)localObject;
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteViewV2)localObject).jdField_e_of_type_Int;
      }
      if ((paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteViewV2)localObject).a();
      }
      ((VoteViewV2)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteViewV2)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691210), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(awqt paramawqt, boolean paramBoolean)
  {
    d(paramawqt);
    a(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    b(paramawqt, false);
    f(paramawqt);
    i(paramawqt);
    e(paramawqt);
    a(paramawqt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a() == 1);
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView == null) || (this.f == null) || (this.c == null)) {}
    int i;
    int j;
    do
    {
      return;
      if (paramInt == 1)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = azkz.a(5.0F);
        this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      Object localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = azkz.a(15.0F);
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = getResources();
      i = ((Resources)localObject).getDimensionPixelSize(2131297398);
      j = ((Resources)localObject).getDimensionPixelSize(2131297400);
      localObject = (ViewGroup.MarginLayoutParams)this.c.getLayoutParams();
      if (((ViewGroup.MarginLayoutParams)localObject).bottomMargin != i)
      {
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = i;
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = (ViewGroup.MarginLayoutParams)this.f.getLayoutParams();
      if (((ViewGroup.MarginLayoutParams)localObject).topMargin != j)
      {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = j;
        this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, String.format("updateLayoutMargin mode: %s, name:%s, level:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j) }));
  }
  
  public void b(awqt paramawqt) {}
  
  public void b(awqt paramawqt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (!ProfileActivity.AllInOne.g(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_Long = 0L;
      return;
    }
    ThreadManager.post(new ProfileBaseView.1(this, paramawqt, paramBoolean), 8, null, true);
  }
  
  public void c(awqt paramawqt)
  {
    this.jdField_d_of_type_Int &= 0xFFFFFFFE;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  protected void d(awqt paramawqt)
  {
    int i;
    if (paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a();
      if (!paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()) {
        break label135;
      }
      i = 1;
      if (j != i)
      {
        a(i, true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a(i);
        a(i, paramawqt);
      }
      Object localObject = paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.getCoverData(this.jdField_e_of_type_Int);
      paramawqt = (String)localObject[0];
      if ((TextUtils.isEmpty(paramawqt)) || (paramawqt.equals(this.jdField_b_of_type_JavaLangString))) {
        break label146;
      }
      this.jdField_b_of_type_JavaLangString = paramawqt;
      this.jdField_e_of_type_Int = ((Integer)localObject[1]).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView;
      if (this.jdField_e_of_type_Int != 0) {
        break label140;
      }
      bool = true;
      ((RandomCoverView)localObject).a(paramawqt, bool);
    }
    label135:
    label140:
    label146:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        i = 0;
        break;
        boolean bool = false;
      }
    }
    QLog.i("Q.profilecard.", 2, "same cover " + paramawqt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
        this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      }
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      }
      this.jdField_a_of_type_AndroidGraphicsRectF.set(getLeft(), this.g, getRight(), getBottom());
      paramCanvas.save();
      paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRectF);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void e(awqt paramawqt)
  {
    if ((paramawqt.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawqt.jdField_a_of_type_JavaLangString))) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject1 instanceof VoteViewV2));
    VoteViewV2 localVoteViewV2 = (VoteViewV2)localObject1;
    boolean bool1 = a(paramawqt);
    if (this.jdField_a_of_type_Boolean) {
      bool1 = false;
    }
    for (;;)
    {
      boolean bool2 = TextUtils.equals(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (bool1)
      {
        localVoteViewV2.setVisibility(0);
        Object localObject2;
        int j;
        int i;
        if (paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard == null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691286);
          localObject2 = null;
          j = 0;
          bool1 = false;
          i = 0;
        }
        for (;;)
        {
          localVoteViewV2.a(bool2, bool1, i, j, this.jdField_a_of_type_Apit, false);
          localVoteViewV2.setTag(localObject2);
          localVoteViewV2.setOnClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnClickListener);
          localVoteViewV2.setContentDescription((CharSequence)localObject1);
          return;
          if (this.jdField_a_of_type_Apit == null) {
            this.jdField_a_of_type_Apit = new apit(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 1);
          }
          i = (int)paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
          j = paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
          if (1 == paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
          for (bool1 = true;; bool1 = false)
          {
            this.jdField_a_of_type_Apit.a = paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
            if (j <= this.jdField_a_of_type_Apit.a.size()) {
              this.jdField_a_of_type_Apit.a = this.jdField_a_of_type_Apit.a.subList(0, j);
            }
            this.jdField_a_of_type_Apit.a = awsp.a(this.jdField_a_of_type_Apit.a);
            if (!bool2) {
              break label349;
            }
            localObject2 = new awor(10, paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard);
            localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691284), new Object[] { String.valueOf(i) });
            break;
          }
          label349:
          localObject2 = new awor(10, paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard);
          localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691198), new Object[] { String.valueOf(i) });
          if (paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
            localVoteViewV2.a();
          }
        }
      }
      localVoteViewV2.setVisibility(4);
      return;
    }
  }
  
  public void f(awqt paramawqt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawqt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView != null) {
      b(this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a());
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      paramInt1 = this.jdField_b_of_type_AndroidViewView.getLeft();
      paramInt2 = this.jdField_b_of_type_AndroidViewView.getTop();
      paramInt3 = this.jdField_b_of_type_AndroidViewView.getRight();
      this.jdField_b_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setClipChildren(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    super.setClipChildren(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileBaseView
 * JD-Core Version:    0.7.0.1
 */