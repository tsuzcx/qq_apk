package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilder;
import com.tencent.mobileqq.profile.like.PraiseAnimation;
import com.tencent.mobileqq.profile.like.PraiseInfo;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseLoadListener;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;

public class VoteView
  extends RelativeLayout
  implements PraiseManager.OnPraiseLoadListener
{
  private double jdField_a_of_type_Double;
  public int a;
  public FrameLayout a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public QQAppInterface a;
  HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  FloatViewBuilder jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder;
  PraiseAnimation jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation = new PraiseAnimation();
  public SingleLineTextView a;
  public boolean a;
  public int b;
  private boolean b;
  private boolean c;
  private boolean d = false;
  
  public VoteView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public VoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public VoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    Object localObject1 = getResources();
    this.jdField_a_of_type_Double = ((Resources)localObject1).getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setId(2131369557);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130846081);
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    double d1 = this.jdField_a_of_type_Double;
    localRelativeLayout.setPadding((int)(d1 * 8.0D), (int)(d1 * 3.0D), (int)(8.0D * d1), (int)(d1 * 3.0D));
    Object localObject2 = new RelativeLayout.LayoutParams(-2, (int)(this.jdField_a_of_type_Double * 24.0D));
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(this.jdField_a_of_type_Double * 6.0D));
    localRelativeLayout = new RelativeLayout(getContext());
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(getContext()).inflate(2131561391, null);
    localViewGroup.setId(2131369739);
    addView(localViewGroup, new RelativeLayout.LayoutParams(-2, -2));
    addView(localRelativeLayout, new RelativeLayout.LayoutParams(-2, -2));
    localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject2);
    VoteRotateAnimation.a();
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131373010);
    localObject2 = ((Resources)localObject1).getDrawable(2130850367);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
    int i;
    if (localObject2 == null) {
      i = (int)(this.jdField_a_of_type_Double * 18.0D);
    } else {
      i = ((Drawable)localObject2).getIntrinsicWidth();
    }
    int j;
    if (localObject2 == null) {
      j = (int)(this.jdField_a_of_type_Double * 18.0D);
    } else {
      j = ((Drawable)localObject2).getIntrinsicHeight();
    }
    localObject2 = new RelativeLayout.LayoutParams(i, j);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(this.jdField_a_of_type_Double * 3.0D));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = new SingleLineTextView(getContext());
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setId(2131370026);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(-1);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(13.0F);
    localObject2 = new RelativeLayout.LayoutParams(-2, (int)(this.jdField_a_of_type_Double * 24.0D));
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131373010);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentWidgetSingleLineTextView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131369478);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130850777);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumHeight((int)(this.jdField_a_of_type_Double * 6.0D));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumWidth((int)(this.jdField_a_of_type_Double * 6.0D));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(((Resources)localObject1).getString(2131691151));
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131369557);
    localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131371828);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 11.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, -2, -2);
  }
  
  public void a()
  {
    if (SimpleUIUtil.a())
    {
      QLog.i("PraiseManager", 1, "showPatternVote, SimpleUIMode is open now");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean = false;
    if (!this.d)
    {
      VoteRotateAnimation.a();
      VasWebviewUtil.a(null, "thumbup", "others_pageview", null, 1, 0, 0, null, "1", null);
    }
    this.d = true;
    postDelayed(new VoteView.1(this), 3000L);
  }
  
  public void a(int paramInt1, PraiseInfo paramPraiseInfo, int paramInt2, String paramString)
  {
    if (paramInt1 == 0) {
      return;
    }
    if ((paramInt1 == PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramPraiseInfo != null) && (!this.c))
    {
      a(paramPraiseInfo);
      paramPraiseInfo = (Pair)this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
      if (paramPraiseInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder.b(), this, paramInt1, false, 0, ((Point)paramPraiseInfo.first).x, ((Point)paramPraiseInfo.first).y);
        this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
      }
    }
  }
  
  public void a(PraiseInfo paramPraiseInfo)
  {
    if (SimpleUIUtil.a())
    {
      QLog.i("PraiseManager", 1, "startPraiseAnim, SimpleUIMode is open now");
      return;
    }
    if ((!this.c) && (paramPraiseInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean))
    {
      PraiseAnimation localPraiseAnimation = this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation;
      localPraiseAnimation.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetImageView;
      localPraiseAnimation.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(getResources(), paramPraiseInfo.a);
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(this.jdField_b_of_type_Boolean, false, this.jdField_a_of_type_AndroidWidgetImageView.getDrawable(), getResources());
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(PraiseAnimation.a(this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation, 1.0F, 0.3F));
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localObject != null)
    {
      if (((FrameLayout)localObject).getVisibility() == 0) {
        return;
      }
      int i = 0;
      if (paramBoolean)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        if (localObject != null) {
          ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
        }
        localObject = localLayoutParams;
        if (localLayoutParams == null) {
          localObject = new RelativeLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext(), null);
        }
        double d1 = this.jdField_a_of_type_Double;
        ((RelativeLayout.LayoutParams)localObject).width = ((int)(d1 * 6.0D + 0.5D));
        ((RelativeLayout.LayoutParams)localObject).height = ((int)(6.0D * d1 + 0.5D));
        ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(3.0D % d1 + 0.5D));
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130850767);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if (!paramBoolean) {
        i = 4;
      }
      ((FrameLayout)localObject).setVisibility(i);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    boolean bool = this.c;
    int j = 4;
    Object localObject2;
    Object localObject1;
    if ((bool) && (this.jdField_b_of_type_Int > 0))
    {
      Object localObject3 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      int k;
      int i;
      if (paramBoolean)
      {
        k = 2130850767;
        if (localLayoutParams != null) {
          localLayoutParams.topMargin = 0;
        }
        localObject2 = String.valueOf(this.jdField_a_of_type_Int);
        i = k;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          double d1 = this.jdField_a_of_type_Double;
          ((RelativeLayout.LayoutParams)localObject3).width = ((int)(d1 * 6.0D + 0.5D));
          ((RelativeLayout.LayoutParams)localObject3).height = ((int)(6.0D * d1 + 0.5D));
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = ((int)(3.0D % d1 + 0.5D));
          i = k;
          localObject1 = localObject2;
        }
      }
      else
      {
        k = 2130850770;
        if (localLayoutParams != null) {
          localLayoutParams.topMargin = ((int)(this.jdField_a_of_type_Double * 15.0D + 0.5D));
        }
        localObject2 = String.valueOf(this.jdField_a_of_type_Int - this.jdField_b_of_type_Int);
        i = k;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          ((RelativeLayout.LayoutParams)localObject3).width = -2;
          ((RelativeLayout.LayoutParams)localObject3).height = -2;
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = 0;
          localObject1 = localObject2;
          i = k;
        }
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(i);
      if (localObject3 != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(paramInt);
      localObject3 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramBoolean)
      {
        localObject2 = "";
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("+");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      ((TextView)localObject3).setText((CharSequence)localObject2);
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramBoolean) {
        paramInt = j;
      } else {
        paramInt = 0;
      }
      ((TextView)localObject2).setVisibility(paramInt);
    }
    else
    {
      if (localLayoutParams != null) {
        localLayoutParams.topMargin = 0;
      }
      localObject2 = String.valueOf(this.jdField_a_of_type_Int);
      if (this.c)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Boolean) {}
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
        localObject1 = localObject2;
      }
    }
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localObject1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, NewVoteAnimHelper paramNewVoteAnimHelper, boolean paramBoolean3)
  {
    this.c = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    if (paramInt1 <= 0) {
      paramInt1 = 0;
    }
    this.jdField_a_of_type_Int = paramInt1;
    paramInt1 = this.jdField_a_of_type_Int;
    if (paramInt2 > paramInt1) {
      this.jdField_b_of_type_Int = (paramInt1 % 20);
    } else if (paramInt2 < 0) {
      this.jdField_b_of_type_Int = 0;
    } else {
      this.jdField_b_of_type_Int = paramInt2;
    }
    Object localObject;
    if ((!this.c) && (this.jdField_b_of_type_Boolean)) {
      localObject = super.getResources().getDrawable(2130850370);
    } else {
      localObject = super.getResources().getDrawable(2130850367);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(this.jdField_b_of_type_Boolean, false, (Drawable)localObject, getResources());
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    if ((!paramBoolean1) && (!this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.jdField_a_of_type_Boolean) && (!paramBoolean3) && (!this.d))
    {
      paramInt1 = PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramInt1 > 0)
      {
        localObject = (PraiseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
        ((PraiseManager)localObject).a(this);
        a(((PraiseManager)localObject).a(paramInt1, true, "from_profile_card"));
      }
    }
    setContentDescription(String.format(getContext().getString(2131691167), new Object[] { String.valueOf(this.jdField_a_of_type_Int) }));
    if (!this.c)
    {
      a(false, 4);
      if ((paramBoolean3) && (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null))
      {
        paramNewVoteAnimHelper = new int[2];
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLocationInWindow(paramNewVoteAnimHelper);
        if (this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder == null) {
          this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder = new FloatViewBuilder(getContext(), 2130846080);
        }
        double d1 = paramNewVoteAnimHelper[0];
        double d2 = this.jdField_a_of_type_AndroidWidgetImageView.getWidth() + this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
        Double.isNaN(d2);
        Double.isNaN(d1);
        float f1 = (float)(d1 + d2 * 0.5D);
        float f2 = paramNewVoteAnimHelper[1];
        paramInt1 = PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramInt1 > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseAnimation.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder.b(), this, paramInt1, true, 0, f1, f2);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder.b(), f1, f2);
      }
    }
    else
    {
      if (paramNewVoteAnimHelper != null)
      {
        paramNewVoteAnimHelper.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
        a(this.jdField_a_of_type_Boolean);
        return;
      }
      a(true, 0);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    HeartLayout localHeartLayout = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
    if (localHeartLayout != null) {
      localHeartLayout.setCanDoAnim(paramBoolean);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      ((PraiseManager)localQQAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER)).b(this);
    }
    this.d = false;
    super.onDetachedFromWindow();
  }
  
  public void setHeartLayout(QQAppInterface paramQQAppInterface, HeartLayout paramHeartLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = paramHeartLayout;
    FloatViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteView
 * JD-Core Version:    0.7.0.1
 */