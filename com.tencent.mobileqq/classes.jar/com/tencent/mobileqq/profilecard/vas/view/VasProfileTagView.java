package com.tencent.mobileqq.profilecard.vas.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anum;
import azvr;
import azxr;
import bacv;
import baei;
import bajf;
import bajg;
import bajh;
import baji;
import bajj;
import bajk;
import bajl;
import bajm;
import bajn;
import bajo;
import bajp;
import bdep;
import bdll;
import bhup;
import bhuq;
import bhur;
import bhus;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.view.BreatheEffectView;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.RatioLayout;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class VasProfileTagView
  extends AbsProfileHeaderView
  implements Animator.AnimatorListener, bhuq
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 3, 1, 0, 5, 4, 2, 6 };
  private static PointF[] jdField_a_of_type_ArrayOfAndroidGraphicsPointF;
  private static String jdField_c_of_type_JavaLangString = "ProfileTagView";
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private PointF jdField_a_of_type_AndroidGraphicsPointF;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bacv jdField_a_of_type_Bacv;
  private baei jdField_a_of_type_Baei;
  private bhup jdField_a_of_type_Bhup;
  private BreatheEffectView jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView;
  private AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  private ProfileNameView jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
  private RatioLayout jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout;
  public boolean a;
  private ValueAnimator[] jdField_a_of_type_ArrayOfAndroidAnimationValueAnimator = new ValueAnimator[jdField_a_of_type_ArrayOfAndroidGraphicsPointF.length];
  private View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[jdField_a_of_type_ArrayOfAndroidGraphicsPointF.length];
  private int jdField_b_of_type_Int;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private PointF jdField_b_of_type_AndroidGraphicsPointF;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  private ValueAnimator[] jdField_b_of_type_ArrayOfAndroidAnimationValueAnimator = new ValueAnimator[jdField_a_of_type_ArrayOfAndroidGraphicsPointF.length];
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int[] jdField_c_of_type_ArrayOfInt = new int[2];
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private final int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g = true;
  
  static
  {
    jdField_a_of_type_ArrayOfAndroidGraphicsPointF = new PointF[] { new PointF(0.126562F, 0.478873F), new PointF(0.220312F, 0.242077F), new PointF(0.559375F, 0.206866F), new PointF(0.85F, 0.279049F), new PointF(0.889062F, 0.440141F), new PointF(0.815625F, 0.61F), new PointF(0.521875F, 0.75F), new PointF(0.18125F, 0.705F) };
  }
  
  public VasProfileTagView(BaseActivity paramBaseActivity, azxr paramazxr)
  {
    super(paramBaseActivity, paramazxr);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_Azxr = paramazxr;
    this.jdField_e_of_type_Int = paramBaseActivity.getResources().getDimensionPixelSize(2131298484);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131562116, this, true);
  }
  
  private void a(azxr paramazxr, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)findViewById(2131368643));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363327), false);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
    super.a(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    azvr localazvr = new azvr(1, null);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setTag(localazvr);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (paramContext = paramContext.getString(2131691044);; paramContext = paramContext.getString(2131691043))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setContentDescription(paramContext);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368476));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(localazvr);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_AndroidWidgetImageView);
      super.b(paramazxr, true);
      return;
    }
  }
  
  private void a(baei parambaei)
  {
    if (parambaei != null)
    {
      parambaei = (ProfileColorScreenComponent)parambaei.a(1004);
      if (parambaei != null) {
        parambaei.a();
      }
    }
  }
  
  private void h()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131368689);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", localLinearLayout);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout = ((RatioLayout)findViewById(2131378402));
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag_cloud", this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout);
  }
  
  private void j(azxr paramazxr)
  {
    VoteView localVoteView = (VoteView)findViewById(2131381230);
    HeartLayout localHeartLayout = (HeartLayout)findViewById(2131368010);
    localHeartLayout.setEnabled(false);
    localVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHeartLayout);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", localVoteView);
    super.g(paramazxr);
  }
  
  private void k(azxr paramazxr)
  {
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368650));
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.jdField_b_of_type_AndroidWidgetTextView);
    super.d(paramazxr);
  }
  
  private void l(azxr paramazxr)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = ((ProfileNameView)findViewById(2131368658));
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView.setClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
    super.c(paramazxr);
  }
  
  public bhur a(float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[2];
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      if (((localView instanceof bhur)) && (localView.getVisibility() == 0))
      {
        localView.getLocationOnScreen(arrayOfInt);
        int k = arrayOfInt[0];
        int m = localView.getWidth();
        int n = arrayOfInt[1];
        int i1 = localView.getHeight();
        if ((paramFloat1 >= arrayOfInt[0]) && (paramFloat1 <= k + m) && (paramFloat2 >= arrayOfInt[1]) && (paramFloat2 <= n + i1)) {
          return (bhur)localView;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = (bdep.a(10.0F) + paramInt);
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard", 2, "onApolloExpand h:" + paramInt);
      }
    }
  }
  
  public void a(azxr paramazxr)
  {
    Context localContext = getContext();
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    a(localContext);
    a(paramazxr, localContext);
    l(paramazxr);
    k(paramazxr);
    j(paramazxr);
    i();
    h();
    super.a(paramazxr);
    e();
    i(paramazxr);
  }
  
  public void a(azxr paramazxr, boolean paramBoolean)
  {
    super.a(paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    super.d(paramazxr);
    super.c(paramazxr);
    super.g(paramazxr);
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_d_of_type_Boolean = true;
    }
    for (;;)
    {
      super.b(paramazxr, false);
      return;
      i(paramazxr);
    }
  }
  
  public void a(bhur parambhur, float paramFloat1, float paramFloat2)
  {
    parambhur = (View)parambhur;
    this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.a(parambhur, (int)paramFloat1 - this.jdField_b_of_type_ArrayOfInt[0], (int)paramFloat2 - this.jdField_b_of_type_ArrayOfInt[1]);
  }
  
  public void a(bhus parambhus, bhur parambhur, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView.a(null);
    if (parambhus != null)
    {
      ((VipTagView)parambhur).setTag(2131375036, Boolean.valueOf(true));
      a((VipTagView)parambhur);
      if ((!a((VipTagView)parambhur)) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0))
      {
        int i = getResources().getDimensionPixelSize(2131298465);
        if (getHandler() != null) {
          this.jdField_a_of_type_Bacv.a(getHandler(), 900, i);
        }
      }
      return;
    }
    a((VipTagView)parambhur, false);
  }
  
  void a(VipTagView paramVipTagView)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.2F, 1.0F, 0.2F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(150L);
    localScaleAnimation.setRepeatMode(2);
    localScaleAnimation.setRepeatCount(1);
    localScaleAnimation.setAnimationListener(new bajm(this, paramVipTagView));
    paramVipTagView.startAnimation(localScaleAnimation);
  }
  
  public void a(VipTagView paramVipTagView, long paramLong)
  {
    Object localObject = String.format("%s-%d", new Object[] { this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.uin, Long.valueOf(paramLong) });
    if (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean((String)localObject, false))
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "card_mall", "0X80047EF", 0, 0, Long.toString(paramLong), "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "appreciate the label");
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean((String)localObject, true).commit();
      localObject = (anum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      if (localObject == null) {
        return;
      }
      ((anum)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.uin, Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "submit the network params ：srcUin = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "destUin  = " + this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.uin + " labelId  = " + paramLong);
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
      localObject2 = paramVipTagView.getTag(2131375039);
    } while (localObject2 == null);
    int i = ((Integer)localObject2).intValue();
    float f1 = jdField_a_of_type_ArrayOfAndroidGraphicsPointF[i].x;
    float f2 = jdField_a_of_type_ArrayOfAndroidGraphicsPointF[i].y;
    float f3 = (paramVipTagView.getLeft() + paramVipTagView.getWidth() * ((RatioLayout.LayoutParams)localObject1).c) / this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getWidth();
    float f4 = paramVipTagView.getTop();
    float f5 = paramVipTagView.getHeight();
    f4 = (((RatioLayout.LayoutParams)localObject1).d * f5 + f4) / this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getHeight();
    localObject1 = ObjectAnimator.ofObject(new bajn(this), new Object[] { new PointF(f3, f4), new PointF(f1, f2) });
    ((ValueAnimator)localObject1).addUpdateListener(new bajo(this, paramVipTagView));
    ((ValueAnimator)localObject1).setDuration(400L);
    ((ValueAnimator)localObject1).addListener(new bajp(this, paramBoolean, paramVipTagView));
    ((ValueAnimator)localObject1).start();
  }
  
  public boolean a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return false;
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) && (((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).jdField_e_of_type_Boolean) && (!this.f))
    {
      this.f = true;
      return false;
    }
    this.jdField_c_of_type_Boolean = true;
    Object localObject;
    if (this.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofInt(new int[] { this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getHeight(), getResources().getDimensionPixelSize(2131298475) });
        localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        label103:
        if (this.jdField_b_of_type_Boolean) {
          break label324;
        }
      }
    }
    label324:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      if (localObject != null)
      {
        ((ValueAnimator)localObject).setDuration(500L);
        ((ValueAnimator)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
        ((ValueAnimator)localObject).removeListener(this);
        ((ValueAnimator)localObject).removeAllUpdateListeners();
        ((ValueAnimator)localObject).addListener(this);
        ((ValueAnimator)localObject).addUpdateListener(new bajk(this));
        ((ValueAnimator)localObject).start();
      }
      return true;
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      localObject = null;
      break label103;
      ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).j();
      if (this.jdField_c_of_type_Int == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(16908290);
        if (localObject == null) {
          break;
        }
        this.jdField_c_of_type_Int = ((View)localObject).getHeight();
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131363990);
        if (localObject != null) {
          this.jdField_c_of_type_Int -= ((View)localObject).getHeight();
        }
      }
      if (Build.VERSION.SDK_INT < 11) {
        ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).h();
      }
      if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_b_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofInt(new int[] { this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getHeight(), this.jdField_c_of_type_Int });
        localObject = this.jdField_b_of_type_AndroidAnimationValueAnimator;
        break label103;
      }
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
      localObject = null;
      break label103;
    }
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (((this.jdField_a_of_type_Bhup == null) || (!this.jdField_a_of_type_Bhup.a(paramMotionEvent))) && (this.jdField_a_of_type_AndroidViewGestureDetector != null) && (!this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))) {
        dispatchTouchEvent(paramMotionEvent);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) && (((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).jdField_e_of_type_Boolean)) {
        return super.a(paramView, paramMotionEvent);
      }
      return true;
    }
    if (this.jdField_a_of_type_AndroidViewGestureDetector != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getLocationInWindow(this.jdField_c_of_type_ArrayOfInt);
      if (this.jdField_c_of_type_ArrayOfInt[1] - this.jdField_b_of_type_ArrayOfInt[1] == 0) {
        return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      }
    }
    return super.a(paramView, paramMotionEvent);
  }
  
  public boolean a(bhur parambhur, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Boolean = true;
    if (((VipTagView)parambhur).a())
    {
      a(parambhur, paramFloat1, paramFloat2);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView.a();
      return true;
    }
    return false;
  }
  
  boolean a(VipTagView paramVipTagView)
  {
    if (paramVipTagView.getTag(2131375038) == null) {
      return false;
    }
    long l = ((Long)paramVipTagView.getTag(2131375038)).longValue();
    if ((this.jdField_a_of_type_Azxr != null) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.uin)))
    {
      paramVipTagView = String.format("%s-%d", new Object[] { this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.uin, Long.valueOf(l) });
      return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(paramVipTagView, false);
    }
    return false;
  }
  
  void b(int paramInt)
  {
    int j = -1;
    this.jdField_b_of_type_Int = paramInt;
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    int i;
    if (2 == paramInt)
    {
      i = -1;
      ((TextView)localObject).setTextColor(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
      if (2 != paramInt) {
        break label72;
      }
      i = -1;
      label39:
      ((ProfileNameView)localObject).setTextColor(i);
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (2 != paramInt) {
        break label79;
      }
    }
    label72:
    label79:
    for (paramInt = j;; paramInt = -16777216)
    {
      ((TextView)localObject).setTextColor(paramInt);
      return;
      i = -16777216;
      break;
      i = -16777216;
      break label39;
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      i(this.jdField_a_of_type_Azxr);
      bool = true;
    }
    return bool;
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Azxr != null)
    {
      super.b(this.jdField_a_of_type_Azxr, false);
      if ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) && (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_b_of_type_Int != (int)this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor)) {
        b((int)this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor);
      }
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = bdep.a(15.0F);
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
    }
  }
  
  void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView = ((BreatheEffectView)findViewById(2131368644));
    Object localObject1 = (ImageView)findViewById(2131368009);
    this.jdField_a_of_type_Bacv = new bacv(5, getResources());
    ((ImageView)localObject1).setImageDrawable(this.jdField_a_of_type_Bacv);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378907));
    localObject1 = findViewById(2131367911);
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
    this.jdField_a_of_type_Bhup = new bhup(this, this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView, true);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new bajf(this));
  }
  
  public void f()
  {
    this.jdField_d_of_type_Int = 0;
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int k = arrayOfView.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = arrayOfView[j];
      Object localObject1;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        localObject1 = (Integer)localView.getTag(2131375039);
        if (localObject1 != null) {}
      }
      for (;;)
      {
        j += 1;
        break;
        PointF localPointF = jdField_a_of_type_ArrayOfAndroidGraphicsPointF[localObject1.intValue()];
        this.jdField_d_of_type_Int += 1;
        Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidAnimationValueAnimator[i];
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.jdField_a_of_type_ArrayOfAndroidAnimationValueAnimator;
          localObject1 = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          localObject2[i] = localObject1;
          ((ValueAnimator)localObject1).addUpdateListener(new bajg(this, localView, localPointF));
          ((ValueAnimator)localObject1).setInterpolator(new DecelerateInterpolator());
          ((ValueAnimator)localObject1).addListener(new bajh(this, localView, localPointF));
          ((ValueAnimator)localObject1).setDuration(600L);
        }
        localView.setVisibility(0);
        ((ValueAnimator)localObject1).start();
        i += 1;
      }
    }
    if (this.jdField_d_of_type_Int == 0)
    {
      this.jdField_c_of_type_Boolean = false;
      if (this.g)
      {
        b(this.jdField_a_of_type_Azxr);
        this.g = false;
      }
    }
  }
  
  public void g()
  {
    this.jdField_d_of_type_Int = 0;
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int k = arrayOfView.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = arrayOfView[j];
      Object localObject1;
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        if ((localView instanceof VipTagView)) {
          ((VipTagView)localView).setShakingState(false);
        }
        localObject1 = (Integer)localView.getTag(2131375039);
        if (localObject1 != null) {}
      }
      for (;;)
      {
        j += 1;
        break;
        PointF localPointF = jdField_a_of_type_ArrayOfAndroidGraphicsPointF[localObject1.intValue()];
        localObject1 = (RatioLayout.LayoutParams)localView.getLayoutParams();
        if (localObject1 != null)
        {
          ((RatioLayout.LayoutParams)localObject1).jdField_a_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPointF.x;
          ((RatioLayout.LayoutParams)localObject1).b = this.jdField_a_of_type_AndroidGraphicsPointF.y;
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        this.jdField_d_of_type_Int += 1;
        Object localObject2 = this.jdField_b_of_type_ArrayOfAndroidAnimationValueAnimator[i];
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.jdField_b_of_type_ArrayOfAndroidAnimationValueAnimator;
          localObject1 = ObjectAnimator.ofFloat(new float[] { 1.0F, 0.0F });
          localObject2[i] = localObject1;
          ((ValueAnimator)localObject1).addUpdateListener(new baji(this, localView, localPointF));
          ((ValueAnimator)localObject1).setInterpolator(new AccelerateInterpolator());
          ((ValueAnimator)localObject1).addListener(new bajj(this, localView));
          ((ValueAnimator)localObject1).setDuration(600L);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        ((ValueAnimator)localObject1).start();
        i += 1;
      }
    }
    if (this.jdField_d_of_type_Int == 0)
    {
      this.jdField_c_of_type_Boolean = false;
      a(this.jdField_a_of_type_Baei);
    }
  }
  
  public void i(azxr paramazxr)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "updateTagCloud");
    }
    ThreadManager.post(new VasProfileTagView.2(this, paramazxr), 8, null, true);
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (paramAnimator != null)
    {
      if (paramAnimator != this.jdField_b_of_type_AndroidAnimationValueAnimator) {
        break label36;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView.a(new bajl(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.setSkipMeasure(false);
      return;
      label36:
      if (Build.VERSION.SDK_INT < 11)
      {
        ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).i();
      }
      else
      {
        paramAnimator = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(16908290);
        if ((paramAnimator != null) && (paramAnimator.getChildCount() > 0))
        {
          paramAnimator = paramAnimator.getChildAt(0);
          if (paramAnimator != null)
          {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramAnimator.getBackground();
            paramAnimator.setBackgroundDrawable(null);
          }
        }
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.setSkipMeasure(true);
    paramAnimator = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(16908290);
    if (paramAnimator != null)
    {
      if ((paramAnimator.getBackground() == null) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)) {
        paramAnimator.setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      }
      if (paramAnimator.getChildCount() > 0)
      {
        paramAnimator = paramAnimator.getChildAt(0);
        if ((paramAnimator != null) && (paramAnimator.getBackground() == null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
          paramAnimator.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject;
    float f1;
    if (this.jdField_a_of_type_AndroidGraphicsPointF == null)
    {
      getLocationOnScreen(this.jdField_b_of_type_ArrayOfInt);
      this.jdField_a_of_type_Bhup.a(this.jdField_b_of_type_ArrayOfInt[0], this.jdField_b_of_type_ArrayOfInt[1]);
      paramInt3 = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getWidth();
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getHeight();
      localObject = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = this.jdField_b_of_type_ArrayOfInt[0];
      f1 = (paramInt3 / 2 + (i - j)) / getWidth();
      paramInt3 = localObject[1];
      i = this.jdField_b_of_type_ArrayOfInt[1];
      this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(f1, (paramInt1 / 2 + (paramInt3 - i)) / getHeight());
      if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f != 1) {
        postDelayed(new VasProfileTagView.3(this), 300L);
      }
    }
    if ((this.jdField_c_of_type_Int > 0) && (paramInt4 - paramInt2 == this.jdField_c_of_type_Int) && (this.jdField_b_of_type_AndroidGraphicsPointF == null))
    {
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getWidth();
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getHeight();
      localObject = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getLocationOnScreen((int[])localObject);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView.setHoverHotArea(new Rect(localObject[0], localObject[1], localObject[0] + paramInt2, localObject[1] + paramInt1));
      paramInt3 = localObject[0];
      paramInt4 = this.jdField_b_of_type_ArrayOfInt[0];
      f1 = (paramInt2 / 2 + (paramInt3 - paramInt4)) / getWidth();
      paramInt2 = localObject[1];
      paramInt3 = this.jdField_b_of_type_ArrayOfInt[1];
      this.jdField_b_of_type_AndroidGraphicsPointF = new PointF(f1, (paramInt1 / 2 + (paramInt2 - paramInt3)) / getHeight());
      paramInt1 = this.jdField_b_of_type_AndroidWidgetTextView.getHeight();
      this.jdField_b_of_type_AndroidWidgetTextView.getLocationOnScreen((int[])localObject);
      paramInt2 = jdField_a_of_type_ArrayOfAndroidGraphicsPointF.length;
      paramInt3 = (int)((45.0F * this.jdField_a_of_type_Float + 0.5D) / 2.0D);
      f1 = (paramInt1 + (localObject[1] - this.jdField_b_of_type_ArrayOfInt[1]) + paramInt3) / getHeight();
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
      if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView$OnClickListener != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.setTag(new azvr(29, null));
        this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout);
        return true;
      }
      this.jdField_e_of_type_Boolean = false;
    }
  }
  
  public void setProfileArgs(baei parambaei)
  {
    this.jdField_a_of_type_Baei = parambaei;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView
 * JD-Core Version:    0.7.0.1
 */