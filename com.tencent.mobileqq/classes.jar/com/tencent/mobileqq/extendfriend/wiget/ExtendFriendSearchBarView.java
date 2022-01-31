package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import aqic;
import aqid;
import aqig;
import aqih;
import aqii;
import aqij;
import aqik;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mww;

public class ExtendFriendSearchBarView
  extends FrameLayout
  implements View.OnClickListener, aqic
{
  private int jdField_a_of_type_Int = -1;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new LinearInterpolator();
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private aqik jdField_a_of_type_Aqik;
  private Animator.AnimatorListener jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener;
  private ValueAnimator jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator;
  private ExtendFriendHorizontalTagsView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView;
  private InterceptHorizontalScrollView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetInterceptHorizontalScrollView;
  private boolean jdField_a_of_type_Boolean = true;
  private Animator.AnimatorListener jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener;
  private ValueAnimator jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator;
  private boolean jdField_b_of_type_Boolean;
  
  public ExtendFriendSearchBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendSearchBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendSearchBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131560958, this);
    d();
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_Int = (((FrameLayout.LayoutParams)paramView.getLayoutParams()).topMargin + paramView.getHeight());
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void b(View paramView)
  {
    if (!this.jdField_b_of_type_Boolean) {
      a(paramView);
    }
    if (this.jdField_a_of_type_Int <= 0) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(200L);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new aqig(this, localLayoutParams, paramView));
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new aqih(this);
    }
    if ((this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
    {
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    }
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  private void c(View paramView)
  {
    if (!this.jdField_b_of_type_Boolean) {
      a(paramView);
    }
    if (this.jdField_a_of_type_Int <= 0) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    if (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(200L);
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new aqii(this, localLayoutParams, paramView));
      this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new aqij(this, paramView);
    }
    if ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    }
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376223));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetInterceptHorizontalScrollView = ((InterceptHorizontalScrollView)findViewById(2131376284));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView = ((ExtendFriendHorizontalTagsView)findViewById(2131376280));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376242));
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView.setOnItemClickListener(this);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(mww.a);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (!this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()) && (((FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams()).topMargin != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSearchBarView", 2, "showSearchBar catch a display exception");
        }
        c();
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    b(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void a(int paramInt)
  {
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    int k = getHeight();
    int j = paramInt + i;
    if ((j > i) && (i > 0))
    {
      paramInt = k;
      if (k > 0) {}
    }
    else
    {
      j = 1920;
      i = 223;
      paramInt = 105;
    }
    int m = i * 36 / j;
    k = (i + paramInt) * 36 / j;
    int n = i * -35 / j;
    paramInt = (paramInt + i) * -35 / j;
    i = Color.argb(255, 79 - m, 127 - n, 255);
    paramInt = Color.argb(255, 79 - k, 127 - paramInt, 255);
    setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, paramInt }));
  }
  
  public void a(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (!TextUtils.isEmpty(paramString))
    {
      i = 0;
      localObject1 = localObject2;
      if (i < this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView.getChildCount())
      {
        localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView.getChildAt(i);
        if ((!(((TextView)localObject1).getTag() instanceof aqid)) || (!paramString.equals(((aqid)((TextView)localObject1).getTag()).a))) {}
      }
    }
    for (int i = ((TextView)localObject1).getRight();; i = 0)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetInterceptHorizontalScrollView.getWidth();
      if ((i > j) && (j > 0) && (localObject1 != null)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetInterceptHorizontalScrollView.scrollTo(i - j, 0);
      }
      return;
      i += 1;
      break;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Aqik != null) {
      this.jdField_a_of_type_Aqik.a(paramString, paramInt);
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    c(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void c()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.topMargin = 0;
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aqik != null) {
      this.jdField_a_of_type_Aqik.b();
    }
  }
  
  public void setItemClickListener(aqik paramaqik)
  {
    this.jdField_a_of_type_Aqik = paramaqik;
  }
  
  public void setSearchButtonEnable(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setSearchTags(ArrayList<String> paramArrayList, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView.setSearchTags(paramArrayList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView
 * JD-Core Version:    0.7.0.1
 */