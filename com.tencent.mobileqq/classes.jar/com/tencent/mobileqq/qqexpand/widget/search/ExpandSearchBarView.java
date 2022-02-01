package com.tencent.mobileqq.qqexpand.widget.search;

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
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.av.utils.UITools;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ExpandSearchBarView
  extends FrameLayout
  implements View.OnClickListener, ExpandHorizontalTagsView.OnItemClickListener
{
  private int jdField_a_of_type_Int = -1;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new LinearInterpolator();
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Animator.AnimatorListener jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = null;
  private ValueAnimator jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = null;
  private ExpandHorizontalTagsView jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandHorizontalTagsView;
  private ExpandSearchBarView.OnItemClickListener jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView$OnItemClickListener;
  private InterceptHorizontalScrollView jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchInterceptHorizontalScrollView;
  private boolean jdField_a_of_type_Boolean = true;
  private Animator.AnimatorListener jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = null;
  private ValueAnimator jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator = null;
  private boolean jdField_b_of_type_Boolean = false;
  
  public ExpandSearchBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExpandSearchBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExpandSearchBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131561060, this);
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
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new ExpandSearchBarView.1(this, localLayoutParams, paramView));
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new ExpandSearchBarView.2(this);
    }
    paramView = this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator;
    if ((paramView != null) && (paramView.isRunning()))
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
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new ExpandSearchBarView.3(this, localLayoutParams, paramView));
      this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new ExpandSearchBarView.4(this, paramView);
    }
    paramView = this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator;
    if ((paramView != null) && (paramView.isRunning()))
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
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377020));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchInterceptHorizontalScrollView = ((InterceptHorizontalScrollView)findViewById(2131377083));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandHorizontalTagsView = ((ExpandHorizontalTagsView)findViewById(2131377080));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377043));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377021));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandHorizontalTagsView;
    if (localObject != null) {
      ((ExpandHorizontalTagsView)localObject).setOnItemClickListener(this);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      ((ImageView)localObject).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(UITools.a);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(this);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ValueAnimator localValueAnimator = this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator;
      if ((localValueAnimator != null) && (!localValueAnimator.isRunning()) && (((FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams()).topMargin != 0))
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
    paramInt += i;
    if ((paramInt > i) && (i > 0))
    {
      j = k;
      if (k > 0) {}
    }
    else
    {
      paramInt = 1920;
      i = 223;
      j = 105;
    }
    k = i * 36 / paramInt;
    int m = j + i;
    int j = m * 36 / paramInt;
    i = i * -35 / paramInt;
    paramInt = m * -35 / paramInt;
    i = Color.argb(255, 79 - k, 127 - i, 255);
    paramInt = Color.argb(255, 79 - j, 127 - paramInt, 255);
    setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, paramInt }));
  }
  
  public void a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    Object localObject2 = null;
    if (!bool)
    {
      i = 0;
      localObject1 = localObject2;
      while (i < this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandHorizontalTagsView.getChildCount())
      {
        localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandHorizontalTagsView.getChildAt(i);
        if (((((TextView)localObject1).getTag() instanceof ExpandHorizontalTagsView.TagInfo)) && (paramString.equals(((ExpandHorizontalTagsView.TagInfo)((TextView)localObject1).getTag()).a)))
        {
          i = ((TextView)localObject1).getRight();
          break label94;
        }
        i += 1;
      }
    }
    int i = 0;
    label94:
    int j = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchInterceptHorizontalScrollView.getWidth();
    if ((i > j) && (j > 0) && (localObject1 != null)) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchInterceptHorizontalScrollView.scrollTo(i - j, 0);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    ExpandSearchBarView.OnItemClickListener localOnItemClickListener = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView$OnItemClickListener;
    if (localOnItemClickListener != null) {
      localOnItemClickListener.a(paramString, paramInt);
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
    ExpandSearchBarView.OnItemClickListener localOnItemClickListener = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView$OnItemClickListener;
    if (localOnItemClickListener != null) {
      localOnItemClickListener.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setItemClickListener(ExpandSearchBarView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void setSearchButtonEnable(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
  }
  
  public void setSearchTags(ArrayList<String> paramArrayList, int paramInt)
  {
    ExpandHorizontalTagsView localExpandHorizontalTagsView = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandHorizontalTagsView;
    if (localExpandHorizontalTagsView != null) {
      localExpandHorizontalTagsView.setSearchTags(paramArrayList, paramInt);
    }
  }
  
  public void setSearchTextShow(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchInterceptHorizontalScrollView != null)
    {
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView == null) {
        return;
      }
      if (paramBoolean)
      {
        if (localTextView.getVisibility() == 8)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchInterceptHorizontalScrollView.setVisibility(4);
        }
      }
      else if (localTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchInterceptHorizontalScrollView.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.search.ExpandSearchBarView
 * JD-Core Version:    0.7.0.1
 */