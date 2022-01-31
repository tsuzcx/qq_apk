package com.tencent.mobileqq.profile.view;

import alpk;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import awor;
import awqt;
import awvr;
import awvs;
import awvt;
import awvu;
import awvv;
import awvw;
import awvx;
import awvy;
import awvz;
import awwa;
import awwu;
import azkz;
import azqs;
import bdob;
import bdpn;
import bdpo;
import bdpp;
import bdpq;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.RatioLayout;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ProfileTagView
  extends ProfileHeaderView
  implements Animation.AnimationListener, bdpo
{
  private static PointF[] jdField_a_of_type_ArrayOfAndroidGraphicsPointF = { new PointF(0.126562F, 0.478873F), new PointF(0.220312F, 0.242077F), new PointF(0.559375F, 0.206866F), new PointF(0.85F, 0.279049F), new PointF(0.889062F, 0.440141F), new PointF(0.815625F, 0.61F), new PointF(0.521875F, 0.75F), new PointF(0.18125F, 0.705F) };
  private static String jdField_c_of_type_JavaLangString = "ProfileTagView";
  private static final int[] jdField_c_of_type_ArrayOfInt = { 3, 1, 0, 5, 4, 2, 6 };
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public PointF a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public ImageView a;
  public TextView a;
  awwu jdField_a_of_type_Awwu;
  public bdob<Integer> a;
  bdpn jdField_a_of_type_Bdpn;
  public BreatheEffectView a;
  AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  ProfileNameView jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
  public RatioLayout a;
  public boolean a;
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  public View[] a;
  bdob[] jdField_a_of_type_ArrayOfBdob = new bdob[jdField_a_of_type_ArrayOfAndroidGraphicsPointF.length];
  public PointF b;
  public Drawable b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  bdob<Integer> jdField_b_of_type_Bdob;
  public boolean b;
  int[] jdField_b_of_type_ArrayOfInt = new int[2];
  bdob[] jdField_b_of_type_ArrayOfBdob = new bdob[jdField_a_of_type_ArrayOfAndroidGraphicsPointF.length];
  boolean jdField_c_of_type_Boolean;
  public boolean d;
  public boolean e = true;
  public boolean f;
  int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  int h;
  public int i;
  private final int j;
  private int k = 0;
  
  public ProfileTagView(BaseActivity paramBaseActivity, awqt paramawqt)
  {
    super(paramBaseActivity, paramawqt);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[jdField_a_of_type_ArrayOfAndroidGraphicsPointF.length];
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Awqt = paramawqt;
    this.j = paramBaseActivity.getResources().getDimensionPixelSize(2131298389);
    d(paramawqt);
    a(paramawqt);
  }
  
  public bdpp a(float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[2];
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int n = arrayOfView.length;
    int m = 0;
    while (m < n)
    {
      View localView = arrayOfView[m];
      if (((localView instanceof bdpp)) && (localView.getVisibility() == 0))
      {
        localView.getLocationOnScreen(arrayOfInt);
        int i1 = arrayOfInt[0];
        int i2 = localView.getWidth();
        int i3 = arrayOfInt[1];
        int i4 = localView.getHeight();
        if ((paramFloat1 >= arrayOfInt[0]) && (paramFloat1 <= i1 + i2) && (paramFloat2 >= arrayOfInt[1]) && (paramFloat2 <= i3 + i4)) {
          return (bdpp)localView;
        }
      }
      m += 1;
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Awqt != null)
    {
      super.b(this.jdField_a_of_type_Awqt, false);
      if ((this.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) && (this.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_g_of_type_Int != (int)this.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor)) {
        a((int)this.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor);
      }
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = azkz.a(15.0F);
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
    }
  }
  
  void a(int paramInt)
  {
    int n = -1;
    this.jdField_g_of_type_Int = paramInt;
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    int m;
    if (2 == paramInt)
    {
      m = -1;
      ((TextView)localObject).setTextColor(m);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
      if (2 != paramInt) {
        break label71;
      }
      m = -1;
      label39:
      ((ProfileNameView)localObject).setTextColor(m);
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (2 != paramInt) {
        break label77;
      }
    }
    label71:
    label77:
    for (paramInt = n;; paramInt = -16777216)
    {
      ((TextView)localObject).setTextColor(paramInt);
      return;
      m = -16777216;
      break;
      m = -16777216;
      break label39;
    }
  }
  
  public void a(awqt paramawqt)
  {
    Object localObject1 = getContext();
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    LayoutInflater.from((Context)localObject1).inflate(2131561838, this, true);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)findViewById(2131368242));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363115), false);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
    super.a(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    Object localObject2 = new awor(1, null);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localObject2);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (localObject1 = ((Context)localObject1).getString(2131691239);; localObject1 = ((Context)localObject1).getString(2131691238))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368078));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_AndroidWidgetImageView);
      super.b(paramawqt, true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)findViewById(2131368260));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      super.f(paramawqt);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368251));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.jdField_b_of_type_AndroidWidgetTextView);
      super.b(paramawqt);
      localObject1 = (VoteView)findViewById(2131380087);
      localObject2 = (HeartLayout)findViewById(2131367633);
      ((HeartLayout)localObject2).setEnabled(false);
      ((VoteView)localObject1).setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (HeartLayout)localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", localObject1);
      super.e(paramawqt);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personal_like_tip", findViewById(2131371734));
      this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout = ((RatioLayout)findViewById(2131377416));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag_cloud", this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout);
      localObject1 = (LinearLayout)findViewById(2131368308);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", localObject1);
      super.a(paramawqt);
      d();
      l(paramawqt);
      return;
    }
  }
  
  public void a(awqt paramawqt, boolean paramBoolean)
  {
    super.a(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    super.b(paramawqt);
    super.f(paramawqt);
    super.e(paramawqt);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = true;
    }
    for (;;)
    {
      super.b(paramawqt, false);
      return;
      l(paramawqt);
    }
  }
  
  public void a(bdpp parambdpp, float paramFloat1, float paramFloat2)
  {
    parambdpp = (View)parambdpp;
    this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.a(parambdpp, (int)paramFloat1 - this.jdField_a_of_type_ArrayOfInt[0], (int)paramFloat2 - this.jdField_a_of_type_ArrayOfInt[1]);
  }
  
  public void a(bdpq parambdpq, bdpp parambdpp, float paramFloat1, float paramFloat2)
  {
    this.f = false;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView.a(null);
    if (parambdpq != null)
    {
      ((VipTagView)parambdpp).setTag(2131374180, Boolean.valueOf(true));
      a((VipTagView)parambdpp);
      if ((!a((VipTagView)parambdpp)) && (this.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0))
      {
        int m = getResources().getDimensionPixelSize(2131298370);
        this.jdField_a_of_type_Awwu.a(getHandler(), 900, m);
      }
      return;
    }
    a((VipTagView)parambdpp, false);
  }
  
  void a(VipTagView paramVipTagView)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.2F, 1.0F, 0.2F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(150L);
    localScaleAnimation.setRepeatMode(2);
    localScaleAnimation.setRepeatCount(1);
    localScaleAnimation.setAnimationListener(new awvx(this, paramVipTagView));
    paramVipTagView.startAnimation(localScaleAnimation);
  }
  
  public void a(VipTagView paramVipTagView, long paramLong)
  {
    Object localObject = String.format("%s-%d", new Object[] { this.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqDataCard.uin, Long.valueOf(paramLong) });
    if (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean((String)localObject, false))
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "card_mall", "0X80047EF", 0, 0, Long.toString(paramLong), "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "appreciate the label");
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean((String)localObject, true).commit();
      localObject = (alpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      if (localObject == null) {
        return;
      }
      ((alpk)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqDataCard.uin, Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "submit the network params ：srcUin = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "destUin  = " + this.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqDataCard.uin + " labelId  = " + paramLong);
      }
      paramVipTagView.a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "the label has appreciated");
    }
    paramVipTagView.setShakingState(true);
  }
  
  public void a(VipTagView paramVipTagView, boolean paramBoolean)
  {
    Object localObject1 = (RatioLayout.LayoutParams)paramVipTagView.getLayoutParams();
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = paramVipTagView.getTag(2131374183);
    } while (localObject2 == null);
    int m = ((Integer)localObject2).intValue();
    float f1 = jdField_a_of_type_ArrayOfAndroidGraphicsPointF[m].x;
    float f2 = jdField_a_of_type_ArrayOfAndroidGraphicsPointF[m].y;
    float f3 = (paramVipTagView.getLeft() + paramVipTagView.getWidth() * ((RatioLayout.LayoutParams)localObject1).c) / this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getWidth();
    float f4 = paramVipTagView.getTop();
    float f5 = paramVipTagView.getHeight();
    localObject1 = new bdob(new PointF(f3, (((RatioLayout.LayoutParams)localObject1).d * f5 + f4) / this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getHeight()), new PointF(f1, f2), new awvy(this, paramVipTagView));
    ((bdob)localObject1).setDuration(400L);
    ((bdob)localObject1).setAnimationListener(new awvz(this, paramBoolean, paramVipTagView));
    paramVipTagView.startAnimation((Animation)localObject1);
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return false;
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) && (((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).k) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_g_of_type_Boolean = true;
      return false;
    }
    this.jdField_b_of_type_Boolean = true;
    Object localObject;
    if (this.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Bdob == null)
      {
        this.jdField_a_of_type_Bdob = new bdob(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getHeight()), Integer.valueOf(getResources().getDimensionPixelSize(2131298380)), null);
        localObject = this.jdField_a_of_type_Bdob;
        label105:
        if (this.jdField_a_of_type_Boolean) {
          break label330;
        }
      }
    }
    label330:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (localObject != null)
      {
        ((bdob)localObject).setDuration(500L);
        ((bdob)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
        ((bdob)localObject).setAnimationListener(this);
        ((bdob)localObject).a(new awvv(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.startAnimation((Animation)localObject);
      }
      return true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.startAnimation(this.jdField_a_of_type_Bdob);
      localObject = null;
      break label105;
      ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).y();
      if (this.h == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(16908290);
        if (localObject == null) {
          break;
        }
        this.h = ((View)localObject).getHeight();
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131363759);
        if (localObject != null) {
          this.h -= ((View)localObject).getHeight();
        }
      }
      if (Build.VERSION.SDK_INT < 11) {
        ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).w();
      }
      if (this.jdField_b_of_type_Bdob == null)
      {
        this.jdField_b_of_type_Bdob = new bdob(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getHeight()), Integer.valueOf(this.h), null);
        localObject = this.jdField_b_of_type_Bdob;
        break label105;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.startAnimation(this.jdField_b_of_type_Bdob);
      localObject = null;
      break label105;
    }
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (((this.jdField_a_of_type_Bdpn == null) || (!this.jdField_a_of_type_Bdpn.a(paramMotionEvent))) && (this.jdField_a_of_type_AndroidViewGestureDetector != null) && (!this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))) {
        dispatchTouchEvent(paramMotionEvent);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) && (((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).k)) {
        return super.a(paramView, paramMotionEvent);
      }
      return true;
    }
    if (this.jdField_a_of_type_AndroidViewGestureDetector != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getLocationInWindow(this.jdField_b_of_type_ArrayOfInt);
      if (this.jdField_b_of_type_ArrayOfInt[1] - this.jdField_a_of_type_ArrayOfInt[1] == 0) {
        return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      }
    }
    return super.a(paramView, paramMotionEvent);
  }
  
  public boolean a(bdpp parambdpp, float paramFloat1, float paramFloat2)
  {
    this.f = true;
    if (((VipTagView)parambdpp).a())
    {
      a(parambdpp, paramFloat1, paramFloat2);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView.a();
      return true;
    }
    return false;
  }
  
  boolean a(VipTagView paramVipTagView)
  {
    if (paramVipTagView.getTag(2131374182) == null) {
      return false;
    }
    long l = ((Long)paramVipTagView.getTag(2131374182)).longValue();
    if ((this.jdField_a_of_type_Awqt != null) && (this.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqDataCard.uin)))
    {
      paramVipTagView = String.format("%s-%d", new Object[] { this.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqDataCard.uin, Long.valueOf(l) });
      return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(paramVipTagView, false);
    }
    return false;
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      l(this.jdField_a_of_type_Awqt);
      bool = true;
    }
    return bool;
  }
  
  public void c(int paramInt)
  {
    super.c(paramInt);
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = (azkz.a(10.0F) + paramInt);
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard", 2, "onApolloExpand h:" + paramInt);
      }
    }
  }
  
  void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView = ((BreatheEffectView)findViewById(2131368243));
    Object localObject1 = (ImageView)findViewById(2131367632);
    this.jdField_a_of_type_Awwu = new awwu(5, getResources());
    ((ImageView)localObject1).setImageDrawable(this.jdField_a_of_type_Awwu);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377909));
    localObject1 = findViewById(2131367533);
    Object localObject2 = (RatioLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((RatioLayout.LayoutParams)localObject2).jdField_a_of_type_Float = 0.5F;
    ((RatioLayout.LayoutParams)localObject2).b = 0.5F;
    ((RatioLayout.LayoutParams)localObject2).c = 0.5F;
    ((RatioLayout.LayoutParams)localObject2).d = 0.5F;
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = (RatioLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localObject2 = jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(jdField_a_of_type_ArrayOfAndroidGraphicsPointF.length - 1)];
    ((RatioLayout.LayoutParams)localObject1).jdField_a_of_type_Float = (((PointF)localObject2).x + 0.07F);
    ((RatioLayout.LayoutParams)localObject1).b = ((PointF)localObject2).y;
    ((RatioLayout.LayoutParams)localObject1).c = 0.0F;
    ((RatioLayout.LayoutParams)localObject1).d = 0.5F;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_Bdpn = new bdpn(this, this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView, true);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new awvr(this));
  }
  
  public void d(awqt paramawqt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    super.a(paramawqt, new HashMap());
  }
  
  public void e()
  {
    this.i = 0;
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int i1 = arrayOfView.length;
    int n = 0;
    int m = 0;
    if (n < i1)
    {
      View localView = arrayOfView[n];
      Object localObject1;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        localObject1 = (Integer)localView.getTag(2131374183);
        if (localObject1 != null) {}
      }
      for (;;)
      {
        n += 1;
        break;
        PointF localPointF = jdField_a_of_type_ArrayOfAndroidGraphicsPointF[localObject1.intValue()];
        this.i += 1;
        Object localObject2 = this.jdField_a_of_type_ArrayOfBdob[m];
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.jdField_a_of_type_ArrayOfBdob;
          localObject1 = new bdob(Float.valueOf(0.0F), Float.valueOf(1.0F), new awwa(this, localView, localPointF), true, true);
          localObject2[m] = localObject1;
          ((bdob)localObject1).setInterpolator(new DecelerateInterpolator());
          ((bdob)localObject1).setAnimationListener(new awvs(this, localView, localPointF));
          ((bdob)localObject1).setDuration(600L);
        }
        localView.startAnimation((Animation)localObject1);
        localView.setVisibility(0);
        m += 1;
      }
    }
    if (this.i == 0)
    {
      this.jdField_b_of_type_Boolean = false;
      if (this.e)
      {
        g(this.jdField_a_of_type_Awqt);
        this.e = false;
      }
    }
  }
  
  public void f()
  {
    this.i = 0;
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int i1 = arrayOfView.length;
    int n = 0;
    int m = 0;
    if (n < i1)
    {
      View localView = arrayOfView[n];
      Object localObject1;
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        if ((localView instanceof VipTagView)) {
          ((VipTagView)localView).setShakingState(false);
        }
        localObject1 = (Integer)localView.getTag(2131374183);
        if (localObject1 != null) {}
      }
      for (;;)
      {
        n += 1;
        break;
        PointF localPointF = jdField_a_of_type_ArrayOfAndroidGraphicsPointF[localObject1.intValue()];
        localObject1 = (RatioLayout.LayoutParams)localView.getLayoutParams();
        if (localObject1 != null)
        {
          ((RatioLayout.LayoutParams)localObject1).jdField_a_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPointF.x;
          ((RatioLayout.LayoutParams)localObject1).b = this.jdField_a_of_type_AndroidGraphicsPointF.y;
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        this.i += 1;
        Object localObject2 = this.jdField_b_of_type_ArrayOfBdob[m];
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.jdField_b_of_type_ArrayOfBdob;
          localObject1 = new bdob(Float.valueOf(1.0F), Float.valueOf(0.0F), new awvt(this, localView, localPointF), false, true);
          localObject2[m] = localObject1;
          ((bdob)localObject1).setInterpolator(new AccelerateInterpolator());
          ((bdob)localObject1).setAnimationListener(new awvu(this, localView));
          ((bdob)localObject1).setDuration(600L);
        }
        localView.startAnimation((Animation)localObject1);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        m += 1;
      }
    }
    if (this.i == 0)
    {
      this.jdField_b_of_type_Boolean = false;
      ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).l();
    }
  }
  
  public void l(awqt paramawqt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "updateTagCloud");
    }
    ThreadManager.post(new ProfileTagView.2(this, paramawqt), 8, null, true);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.k = 1;
    if ((paramAnimation instanceof bdob))
    {
      bdob localbdob = (bdob)paramAnimation;
      if (paramAnimation != this.jdField_b_of_type_Bdob) {
        break label56;
      }
      if (!localbdob.a()) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView.a(new awvw(this));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.setSkipMeasure(false);
      return;
      label56:
      if (Build.VERSION.SDK_INT < 11)
      {
        ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).x();
      }
      else
      {
        paramAnimation = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(16908290);
        if ((paramAnimation != null) && (paramAnimation.getChildCount() > 0))
        {
          paramAnimation = paramAnimation.getChildAt(0);
          if (paramAnimation != null)
          {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramAnimation.getBackground();
            paramAnimation.setBackgroundDrawable(null);
          }
        }
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.setSkipMeasure(true);
    paramAnimation = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(16908290);
    if (paramAnimation != null)
    {
      if ((paramAnimation.getBackground() == null) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)) {
        paramAnimation.setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      }
      if (paramAnimation.getChildCount() > 0)
      {
        paramAnimation = paramAnimation.getChildAt(0);
        if ((paramAnimation != null) && (paramAnimation.getBackground() == null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
          paramAnimation.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.k == 1) && (this.jdField_b_of_type_Bdob != null)) {
      onAnimationEnd(this.jdField_b_of_type_Bdob);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.k = 1;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject;
    float f1;
    if (this.jdField_a_of_type_AndroidGraphicsPointF == null)
    {
      getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_Bdpn.a(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1]);
      paramInt3 = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getWidth();
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getHeight();
      localObject = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getLocationOnScreen((int[])localObject);
      int m = localObject[0];
      int n = this.jdField_a_of_type_ArrayOfInt[0];
      f1 = (paramInt3 / 2 + (m - n)) / getWidth();
      paramInt3 = localObject[1];
      m = this.jdField_a_of_type_ArrayOfInt[1];
      this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(f1, (paramInt1 / 2 + (paramInt3 - m)) / getHeight());
      if (this.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f != 1) {
        postDelayed(new ProfileTagView.3(this), 300L);
      }
    }
    if ((this.h > 0) && (paramInt4 - paramInt2 == this.h) && (this.jdField_b_of_type_AndroidGraphicsPointF == null))
    {
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getWidth();
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getHeight();
      localObject = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getLocationOnScreen((int[])localObject);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView.setHoverHotArea(new Rect(localObject[0], localObject[1], localObject[0] + paramInt2, localObject[1] + paramInt1));
      paramInt3 = localObject[0];
      paramInt4 = this.jdField_a_of_type_ArrayOfInt[0];
      f1 = (paramInt2 / 2 + (paramInt3 - paramInt4)) / getWidth();
      paramInt2 = localObject[1];
      paramInt3 = this.jdField_a_of_type_ArrayOfInt[1];
      this.jdField_b_of_type_AndroidGraphicsPointF = new PointF(f1, (paramInt1 / 2 + (paramInt2 - paramInt3)) / getHeight());
      paramInt1 = this.jdField_b_of_type_AndroidWidgetTextView.getHeight();
      this.jdField_b_of_type_AndroidWidgetTextView.getLocationOnScreen((int[])localObject);
      paramInt2 = jdField_a_of_type_ArrayOfAndroidGraphicsPointF.length;
      paramInt3 = (int)((45.0F * this.jdField_a_of_type_Float + 0.5D) / 2.0D);
      f1 = (paramInt1 + (localObject[1] - this.jdField_a_of_type_ArrayOfInt[1]) + paramInt3) / getHeight();
      localObject = jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(paramInt2 - 1)];
      ((PointF)localObject).set(((PointF)localObject).x, f1);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = (RatioLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (localObject != null)
        {
          ((RatioLayout.LayoutParams)localObject).b = f1;
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if ((!this.d) && (this.jdField_a_of_type_Awqt.jdField_a_of_type_AndroidViewView$OnClickListener != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.setTag(new awor(29, null));
        this.jdField_a_of_type_Awqt.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout);
        return true;
      }
      this.d = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileTagView
 * JD-Core Version:    0.7.0.1
 */