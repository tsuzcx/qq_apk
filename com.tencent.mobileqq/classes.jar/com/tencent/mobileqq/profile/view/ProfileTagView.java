package com.tencent.mobileqq.profile.view;

import agwc;
import agwd;
import agwe;
import agwf;
import agwg;
import agwi;
import agwj;
import agwk;
import agwl;
import agwm;
import agwn;
import agwo;
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
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.helper.HeartRiseLayerDrawable;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector.DragSource;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector.Draggable;
import com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector.DropTarget;
import com.tencent.mobileqq.widget.RatioLayout;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ProfileTagView
  extends ProfileHeaderView
  implements Animation.AnimationListener, DragAndDropDetector.DragSource
{
  private static PointF[] jdField_a_of_type_ArrayOfAndroidGraphicsPointF = { new PointF(0.126562F, 0.478873F), new PointF(0.220312F, 0.242077F), new PointF(0.559375F, 0.206866F), new PointF(0.85F, 0.279049F), new PointF(0.889062F, 0.440141F), new PointF(0.815625F, 0.61F), new PointF(0.521875F, 0.75F), new PointF(0.18125F, 0.705F) };
  private static String jdField_c_of_type_JavaLangString = "ProfileTagView";
  private static final int[] jdField_c_of_type_ArrayOfInt = { 3, 1, 0, 5, 4, 2, 6 };
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public PointF a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public TextView a;
  public BreatheEffectView a;
  HeartRiseLayerDrawable jdField_a_of_type_ComTencentMobileqqProfileViewHelperHeartRiseLayerDrawable;
  public ValueAnimation a;
  DragAndDropDetector jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector;
  public RatioLayout a;
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  public View[] a;
  ValueAnimation[] jdField_a_of_type_ArrayOfComTencentMobileqqUtilsValueAnimation = new ValueAnimation[jdField_a_of_type_ArrayOfAndroidGraphicsPointF.length];
  public PointF b;
  public Drawable b;
  public TextView b;
  ValueAnimation jdField_b_of_type_ComTencentMobileqqUtilsValueAnimation;
  int[] jdField_b_of_type_ArrayOfInt = new int[2];
  ValueAnimation[] jdField_b_of_type_ArrayOfComTencentMobileqqUtilsValueAnimation = new ValueAnimation[jdField_a_of_type_ArrayOfAndroidGraphicsPointF.length];
  public ImageView c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  TextView d;
  public boolean d;
  boolean e;
  public boolean f;
  public boolean g = true;
  public boolean h;
  private boolean i;
  int j;
  int k;
  public int l;
  private final int m;
  
  public ProfileTagView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[jdField_a_of_type_ArrayOfAndroidGraphicsPointF.length];
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    this.m = paramBaseActivity.getResources().getDimensionPixelSize(2131558987);
    b(paramProfileCardInfo);
    a(paramProfileCardInfo);
  }
  
  public DragAndDropDetector.Draggable a(float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[2];
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int i1 = arrayOfView.length;
    int n = 0;
    while (n < i1)
    {
      View localView = arrayOfView[n];
      if (((localView instanceof DragAndDropDetector.Draggable)) && (localView.getVisibility() == 0))
      {
        localView.getLocationOnScreen(arrayOfInt);
        int i2 = arrayOfInt[0];
        int i3 = localView.getWidth();
        int i4 = arrayOfInt[1];
        int i5 = localView.getHeight();
        if ((paramFloat1 >= arrayOfInt[0]) && (paramFloat1 <= i2 + i3) && (paramFloat2 >= arrayOfInt[1]) && (paramFloat2 <= i4 + i5)) {
          return (DragAndDropDetector.Draggable)localView;
        }
      }
      n += 1;
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null)
    {
      super.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, false);
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.j != (int)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor)) {
        b((int)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor);
      }
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = ScreenUtil.a(15.0F);
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((VoteView)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = (ScreenUtil.a(10.0F) + paramInt);
      ((VoteView)localObject).setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard", 2, "onApolloExpand h:" + paramInt);
      }
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = getContext();
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    LayoutInflater.from((Context)localObject1).inflate(2130971032, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369101));
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_AndroidWidgetImageView);
    super.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    Object localObject2 = new DataTag(1, null);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (localObject1 = ((Context)localObject1).getString(2131427397);; localObject1 = ((Context)localObject1).getString(2131427396))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364689));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setTag(localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_c_of_type_AndroidWidgetImageView);
      super.c(paramProfileCardInfo, true);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370266));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_c_of_type_AndroidWidgetTextView);
      super.i(paramProfileCardInfo);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372550));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.jdField_d_of_type_AndroidWidgetTextView);
      super.c(paramProfileCardInfo);
      localObject1 = (VoteView)findViewById(2131370545);
      localObject2 = (HeartLayout)findViewById(2131370086);
      ((HeartLayout)localObject2).setEnabled(false);
      ((VoteView)localObject1).setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (HeartLayout)localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", localObject1);
      super.g(paramProfileCardInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_personal_like_tip", findViewById(2131372546));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372551));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag_jueban", this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout = ((RatioLayout)findViewById(2131365234));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag_cloud", this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout);
      localObject1 = (LinearLayout)findViewById(2131372547);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", localObject1);
      localObject1 = (TextView)findViewById(2131372537);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_num", localObject1);
      ((TextView)localObject1).setOnClickListener(this);
      localObject1 = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, findViewById(2131372534)).a(53).a(true).c(1).e(10).a();
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_increment", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_medal_container", findViewById(2131372534));
      d(paramProfileCardInfo);
      super.a(paramProfileCardInfo);
      d();
      l(paramProfileCardInfo);
      return;
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    super.c(paramProfileCardInfo);
    super.i(paramProfileCardInfo);
    super.g(paramProfileCardInfo);
    if (this.jdField_d_of_type_Boolean) {
      this.e = true;
    }
    for (;;)
    {
      super.c(paramProfileCardInfo, false);
      return;
      l(paramProfileCardInfo);
    }
  }
  
  void a(VipTagView paramVipTagView)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.2F, 1.0F, 0.2F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(150L);
    localScaleAnimation.setRepeatMode(2);
    localScaleAnimation.setRepeatCount(1);
    localScaleAnimation.setAnimationListener(new agwl(this, paramVipTagView));
    paramVipTagView.startAnimation(localScaleAnimation);
  }
  
  public void a(VipTagView paramVipTagView, long paramLong)
  {
    Object localObject = String.format("%s-%d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin, Long.valueOf(paramLong) });
    if (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean((String)localObject, false))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "card_mall", "0X80047EF", 0, 0, Long.toString(paramLong), "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "appreciate the label");
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean((String)localObject, true).commit();
      localObject = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      if (localObject == null) {
        return;
      }
      ((CardHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin, Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "submit the network params ：srcUin = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "destUin  = " + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin + " labelId  = " + paramLong);
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
      localObject2 = paramVipTagView.getTag(2131362044);
    } while (localObject2 == null);
    int n = ((Integer)localObject2).intValue();
    float f1 = jdField_a_of_type_ArrayOfAndroidGraphicsPointF[n].x;
    float f2 = jdField_a_of_type_ArrayOfAndroidGraphicsPointF[n].y;
    float f3 = (paramVipTagView.getLeft() + paramVipTagView.getWidth() * ((RatioLayout.LayoutParams)localObject1).c) / this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getWidth();
    float f4 = paramVipTagView.getTop();
    float f5 = paramVipTagView.getHeight();
    localObject1 = new ValueAnimation(new PointF(f3, (((RatioLayout.LayoutParams)localObject1).d * f5 + f4) / this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getHeight()), new PointF(f1, f2), new agwm(this, paramVipTagView));
    ((ValueAnimation)localObject1).setDuration(400L);
    ((ValueAnimation)localObject1).setAnimationListener(new agwn(this, paramBoolean, paramVipTagView));
    paramVipTagView.startAnimation((Animation)localObject1);
  }
  
  public void a(DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2)
  {
    paramDraggable = (View)paramDraggable;
    this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.a(paramDraggable, (int)paramFloat1 - this.jdField_a_of_type_ArrayOfInt[0], (int)paramFloat2 - this.jdField_a_of_type_ArrayOfInt[1]);
  }
  
  public void a(DragAndDropDetector.DropTarget paramDropTarget, DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2)
  {
    this.h = false;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView.a(null);
    if (paramDropTarget != null)
    {
      ((VipTagView)paramDraggable).setTag(2131362046, Boolean.valueOf(true));
      a((VipTagView)paramDraggable);
      if ((!a((VipTagView)paramDraggable)) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0))
      {
        int n = getResources().getDimensionPixelSize(2131558984);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewHelperHeartRiseLayerDrawable.a(getHandler(), 900, n);
      }
      return;
    }
    a((VipTagView)paramDraggable, false);
  }
  
  public boolean a()
  {
    if (this.jdField_d_of_type_Boolean) {
      return false;
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) && (((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).j) && (!this.i))
    {
      this.i = true;
      return false;
    }
    this.jdField_d_of_type_Boolean = true;
    Object localObject;
    if (this.jdField_c_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation = new ValueAnimation(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getHeight()), Integer.valueOf(getResources().getDimensionPixelSize(2131558971)), null);
        localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation;
        label105:
        if (this.jdField_c_of_type_Boolean) {
          break label330;
        }
      }
    }
    label330:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      if (localObject != null)
      {
        ((ValueAnimation)localObject).setDuration(500L);
        ((ValueAnimation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
        ((ValueAnimation)localObject).setAnimationListener(this);
        ((ValueAnimation)localObject).a(new agwj(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.startAnimation((Animation)localObject);
      }
      return true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.startAnimation(this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation);
      localObject = null;
      break label105;
      ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).E();
      if (this.k == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(16908290);
        if (localObject == null) {
          break;
        }
        this.k = ((View)localObject).getHeight();
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131364173);
        if (localObject != null) {
          this.k -= ((View)localObject).getHeight();
        }
      }
      if (Build.VERSION.SDK_INT < 11) {
        ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).C();
      }
      if (this.jdField_b_of_type_ComTencentMobileqqUtilsValueAnimation == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqUtilsValueAnimation = new ValueAnimation(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.getHeight()), Integer.valueOf(this.k), null);
        localObject = this.jdField_b_of_type_ComTencentMobileqqUtilsValueAnimation;
        break label105;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.startAnimation(this.jdField_b_of_type_ComTencentMobileqqUtilsValueAnimation);
      localObject = null;
      break label105;
    }
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector == null) || (!this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector.a(paramMotionEvent))) && (this.jdField_a_of_type_AndroidViewGestureDetector != null) && (!this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))) {
        dispatchTouchEvent(paramMotionEvent);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)) && (((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).j)) {
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
  
  public boolean a(VipTagView paramVipTagView)
  {
    if (paramVipTagView.getTag(2131362047) == null) {
      return false;
    }
    long l1 = ((Long)paramVipTagView.getTag(2131362047)).longValue();
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin)))
    {
      paramVipTagView = String.format("%s-%d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin, Long.valueOf(l1) });
      return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(paramVipTagView, false);
    }
    return false;
  }
  
  public boolean a(DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2)
  {
    this.h = true;
    if (((VipTagView)paramDraggable).a())
    {
      a(paramDraggable, paramFloat1, paramFloat2);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView.a();
      return true;
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    int i1 = -1;
    this.j = paramInt;
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    int n;
    if (2 == paramInt)
    {
      n = -1;
      localTextView.setTextColor(n);
      localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      if (2 != paramInt) {
        break label72;
      }
      n = -1;
      label39:
      localTextView.setTextColor(n);
      localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
      if (2 != paramInt) {
        break label79;
      }
    }
    label72:
    label79:
    for (paramInt = i1;; paramInt = -16777216)
    {
      localTextView.setTextColor(paramInt);
      return;
      n = -16777216;
      break;
      n = -16777216;
      break label39;
    }
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    super.a(paramProfileCardInfo, new HashMap());
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.e)
    {
      this.e = false;
      l(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
      bool = true;
    }
    return bool;
  }
  
  void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView = ((BreatheEffectView)findViewById(2131371013));
    Object localObject1 = (ImageView)findViewById(2131372579);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewHelperHeartRiseLayerDrawable = new HeartRiseLayerDrawable(5, getResources());
    ((ImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqProfileViewHelperHeartRiseLayerDrawable);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372580));
    localObject1 = findViewById(2131372578);
    Object localObject2 = (RatioLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((RatioLayout.LayoutParams)localObject2).a = 0.5F;
    ((RatioLayout.LayoutParams)localObject2).jdField_b_of_type_Float = 0.5F;
    ((RatioLayout.LayoutParams)localObject2).c = 0.5F;
    ((RatioLayout.LayoutParams)localObject2).d = 0.5F;
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = (RatioLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    localObject2 = jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(jdField_a_of_type_ArrayOfAndroidGraphicsPointF.length - 1)];
    ((RatioLayout.LayoutParams)localObject1).a = (((PointF)localObject2).x + 0.07F);
    ((RatioLayout.LayoutParams)localObject1).jdField_b_of_type_Float = ((PointF)localObject2).y;
    ((RatioLayout.LayoutParams)localObject1).c = 0.0F;
    ((RatioLayout.LayoutParams)localObject1).d = 0.5F;
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector = new DragAndDropDetector(this, this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView, true);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new agwc(this));
  }
  
  public void e()
  {
    this.l = 0;
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int i2 = arrayOfView.length;
    int i1 = 0;
    int n = 0;
    if (i1 < i2)
    {
      View localView = arrayOfView[i1];
      Object localObject1;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        localObject1 = (Integer)localView.getTag(2131362044);
        if (localObject1 != null) {}
      }
      for (;;)
      {
        i1 += 1;
        break;
        PointF localPointF = jdField_a_of_type_ArrayOfAndroidGraphicsPointF[localObject1.intValue()];
        this.l += 1;
        Object localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsValueAnimation[n];
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsValueAnimation;
          localObject1 = new ValueAnimation(Float.valueOf(0.0F), Float.valueOf(1.0F), new agwo(this, localView, localPointF), true, true);
          localObject2[n] = localObject1;
          ((ValueAnimation)localObject1).setInterpolator(new DecelerateInterpolator());
          ((ValueAnimation)localObject1).setAnimationListener(new agwd(this, localView, localPointF));
          ((ValueAnimation)localObject1).setDuration(600L);
        }
        localView.startAnimation((Animation)localObject1);
        localView.setVisibility(0);
        n += 1;
      }
    }
    if (this.l == 0)
    {
      this.jdField_d_of_type_Boolean = false;
      if (this.g)
      {
        h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        this.g = false;
      }
    }
  }
  
  public void f()
  {
    this.l = 0;
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int i2 = arrayOfView.length;
    int i1 = 0;
    int n = 0;
    if (i1 < i2)
    {
      View localView = arrayOfView[i1];
      Object localObject1;
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        if ((localView instanceof VipTagView)) {
          ((VipTagView)localView).setShakingState(false);
        }
        localObject1 = (Integer)localView.getTag(2131362044);
        if (localObject1 != null) {}
      }
      for (;;)
      {
        i1 += 1;
        break;
        PointF localPointF = jdField_a_of_type_ArrayOfAndroidGraphicsPointF[localObject1.intValue()];
        localObject1 = (RatioLayout.LayoutParams)localView.getLayoutParams();
        if (localObject1 != null)
        {
          ((RatioLayout.LayoutParams)localObject1).a = this.jdField_a_of_type_AndroidGraphicsPointF.x;
          ((RatioLayout.LayoutParams)localObject1).jdField_b_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPointF.y;
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        this.l += 1;
        Object localObject2 = this.jdField_b_of_type_ArrayOfComTencentMobileqqUtilsValueAnimation[n];
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = this.jdField_b_of_type_ArrayOfComTencentMobileqqUtilsValueAnimation;
          localObject1 = new ValueAnimation(Float.valueOf(1.0F), Float.valueOf(0.0F), new agwe(this, localView, localPointF), false, true);
          localObject2[n] = localObject1;
          ((ValueAnimation)localObject1).setInterpolator(new AccelerateInterpolator());
          ((ValueAnimation)localObject1).setAnimationListener(new agwf(this, localView));
          ((ValueAnimation)localObject1).setDuration(600L);
        }
        localView.startAnimation((Animation)localObject1);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        n += 1;
      }
    }
    if (this.l == 0)
    {
      this.jdField_d_of_type_Boolean = false;
      ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).k();
    }
  }
  
  public void l(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "updateTagCloud");
    }
    ThreadManager.post(new agwg(this, paramProfileCardInfo), 8, null, true);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((paramAnimation instanceof ValueAnimation))
    {
      ValueAnimation localValueAnimation = (ValueAnimation)paramAnimation;
      if (paramAnimation != this.jdField_b_of_type_ComTencentMobileqqUtilsValueAnimation) {
        break label51;
      }
      if (!localValueAnimation.a()) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView.a(new agwk(this));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.setSkipMeasure(false);
      return;
      label51:
      if (Build.VERSION.SDK_INT < 11)
      {
        ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).D();
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
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject;
    float f1;
    if (this.jdField_a_of_type_AndroidGraphicsPointF == null)
    {
      getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_ComTencentMobileqqUtilsDrag_n_dropDragAndDropDetector.a(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfInt[1]);
      paramInt3 = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      paramInt1 = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
      localObject = new int[2];
      this.jdField_a_of_type_AndroidWidgetImageView.getLocationOnScreen((int[])localObject);
      int n = localObject[0];
      int i1 = this.jdField_a_of_type_ArrayOfInt[0];
      f1 = (paramInt3 / 2 + (n - i1)) / getWidth();
      paramInt3 = localObject[1];
      n = this.jdField_a_of_type_ArrayOfInt[1];
      this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(f1, (paramInt1 / 2 + (paramInt3 - n)) / getHeight());
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f != 1) {
        postDelayed(new agwi(this), 300L);
      }
    }
    if ((this.k > 0) && (paramInt4 - paramInt2 == this.k) && (this.jdField_b_of_type_AndroidGraphicsPointF == null))
    {
      paramInt2 = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      paramInt1 = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
      localObject = new int[2];
      this.jdField_a_of_type_AndroidWidgetImageView.getLocationOnScreen((int[])localObject);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView.setHoverHotArea(new Rect(localObject[0], localObject[1], localObject[0] + paramInt2, localObject[1] + paramInt1));
      paramInt3 = localObject[0];
      paramInt4 = this.jdField_a_of_type_ArrayOfInt[0];
      f1 = (paramInt2 / 2 + (paramInt3 - paramInt4)) / getWidth();
      paramInt2 = localObject[1];
      paramInt3 = this.jdField_a_of_type_ArrayOfInt[1];
      this.jdField_b_of_type_AndroidGraphicsPointF = new PointF(f1, (paramInt1 / 2 + (paramInt2 - paramInt3)) / getHeight());
      paramInt1 = this.jdField_d_of_type_AndroidWidgetTextView.getHeight();
      this.jdField_d_of_type_AndroidWidgetTextView.getLocationOnScreen((int[])localObject);
      paramInt2 = jdField_a_of_type_ArrayOfAndroidGraphicsPointF.length;
      paramInt3 = (int)((45.0F * this.jdField_b_of_type_Float + 0.5D) / 2.0D);
      f1 = (paramInt1 + (localObject[1] - this.jdField_a_of_type_ArrayOfInt[1]) + paramInt3) / getHeight();
      localObject = jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(paramInt2 - 1)];
      ((PointF)localObject).set(((PointF)localObject).x, f1);
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        localObject = (RatioLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if (localObject != null)
        {
          ((RatioLayout.LayoutParams)localObject).jdField_b_of_type_Float = f1;
          this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
      if ((!this.f) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout.setTag(new DataTag(29, null));
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqWidgetRatioLayout);
        return true;
      }
      this.f = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileTagView
 * JD-Core Version:    0.7.0.1
 */