package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import apud;
import bdoo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class EmoticonGuideBubbleView
  extends LinearLayout
{
  protected Context a;
  protected Drawable a;
  protected View a;
  
  public EmoticonGuideBubbleView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setOrientation(1);
    setGravity(8388613);
    setVisibility(8);
  }
  
  private int a(int paramInt)
  {
    int i;
    if (paramInt > 0)
    {
      i = paramInt;
      if (getMeasuredWidth() + paramInt < bdoo.a()) {}
    }
    else
    {
      i = bdoo.a(6.0F);
    }
    return i;
  }
  
  private int a(View paramView, boolean paramBoolean)
  {
    int i = paramView.getRight();
    paramView = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(paramView);
    int j = this.jdField_a_of_type_AndroidViewView.getWidth();
    measure(0, 0);
    int k = getMeasuredWidth();
    if (paramBoolean) {}
    for (i = i - (paramView[0] - bdoo.a(20.0F)) - k / 2;; i = i - (paramView[0] + j / 2) - k / 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonGuideBubbleView", 2, new Object[] { "calcOffset offset:", Integer.valueOf(i), " ,bW:", Integer.valueOf(k), " ,eW:", Integer.valueOf(j), " ,eLX:", Integer.valueOf(paramView[0]) });
      }
      return a(i);
    }
  }
  
  private int a(LinearLayout paramLinearLayout, ImageView paramImageView, int paramInt, boolean paramBoolean)
  {
    int j = paramLinearLayout.getRight();
    paramLinearLayout = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(paramLinearLayout);
    int i = this.jdField_a_of_type_AndroidViewView.getWidth();
    paramImageView.measure(0, 0);
    if (paramBoolean) {}
    for (paramInt = j - (paramLinearLayout[0] - bdoo.a(20.0F)) - paramImageView.getMeasuredWidth() / 4 - paramInt;; paramInt = j - paramLinearLayout[0] - i / 2 - paramImageView.getMeasuredWidth() / 4 - paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonGuideBubbleView", 2, new Object[] { "calcArrowOffset arrowOffset:", Integer.valueOf(paramInt), " ,eW:", Integer.valueOf(i), " ,eLX:", Integer.valueOf(paramLinearLayout[0]) });
      }
      return a(paramInt);
    }
  }
  
  protected Drawable a(String paramString, Drawable paramDrawable, boolean paramBoolean)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (paramDrawable == null)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
      }
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    for (localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;; localURLDrawableOptions.mFailedDrawable = paramDrawable)
    {
      localURLDrawableOptions.mPlayGifImage = paramBoolean;
      return a(paramString, localURLDrawableOptions);
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    }
  }
  
  protected URLDrawable a(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    return URLDrawable.getDrawable(paramString, paramURLDrawableOptions);
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonGuideBubbleView", 2, "removeGuideBubble ");
    }
    if ((paramRelativeLayout == null) || (getVisibility() == 8)) {
      return;
    }
    setVisibility(8);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    setAnimation(localAlphaAnimation);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    startAnimation(localAlphaAnimation);
    localAlphaAnimation.setAnimationListener(new apud(this));
    paramRelativeLayout.removeView(this);
  }
  
  public boolean a(RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramRelativeLayout == null) || (paramLinearLayout == null) || (TextUtils.isEmpty(paramString)) || (paramInt1 <= 0) || (paramInt2 <= 0)) {
      return false;
    }
    if (getVisibility() == 0)
    {
      a(paramRelativeLayout);
      return false;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidViewView = paramRelativeLayout.findViewById(2131367007);
    }
    while (this.jdField_a_of_type_AndroidViewView == null)
    {
      return false;
      this.jdField_a_of_type_AndroidViewView = paramLinearLayout.findViewById(2131373378);
      if (this.jdField_a_of_type_AndroidViewView == null) {
        this.jdField_a_of_type_AndroidViewView = paramLinearLayout.findViewById(2131373379);
      }
    }
    View localView = paramRelativeLayout.findViewById(2131368344);
    if (localView == null) {
      return false;
    }
    removeAllViews();
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    paramString = a(paramString, null, true);
    if (((paramString instanceof URLDrawable)) && (QLog.isColorLevel())) {
      QLog.d("EmoticonGuideBubbleView", 2, "showGuideBubble drawable status: " + ((URLDrawable)paramString).getStatus());
    }
    localImageView.setImageDrawable(paramString);
    paramInt1 = bdoo.a(paramInt1 / 2);
    int i = bdoo.a(paramInt2 / 2);
    if (paramInt1 >= bdoo.a()) {
      paramInt2 = bdoo.a() / 2;
    }
    for (paramInt1 = i * paramInt2 / paramInt1;; paramInt1 = i)
    {
      localImageView.setLayoutParams(new ViewGroup.LayoutParams(paramInt2, paramInt1));
      localImageView.setBackgroundResource(2130837904);
      addView(localImageView);
      setVisibility(0);
      paramString = new AlphaAnimation(0.0F, 1.0F);
      setAnimation(paramString);
      paramString.setDuration(500L);
      paramString.setFillAfter(true);
      startAnimation(paramString);
      paramString = new RelativeLayout.LayoutParams(-2, -2);
      paramString.addRule(2, 2131368344);
      paramString.addRule(7, 2131368344);
      paramInt1 = a(paramLinearLayout, paramBoolean);
      if (paramInt1 > 0)
      {
        paramString.rightMargin = paramInt1;
        localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        localImageView.setImageDrawable(getResources().getDrawable(2130839466));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(bdoo.a(13.0F), bdoo.a(8.0F));
        localLayoutParams.gravity = 8388613;
        localLayoutParams.rightMargin = a(paramLinearLayout, localImageView, paramInt1, paramBoolean);
        localLayoutParams.topMargin = (-bdoo.a(1.0F));
        localImageView.setLayoutParams(localLayoutParams);
        addView(localImageView);
        paramString.bottomMargin = (-localView.getPaddingTop());
      }
      paramRelativeLayout.addView(this, paramString);
      return true;
      paramInt2 = paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonGuideBubbleView
 * JD-Core Version:    0.7.0.1
 */