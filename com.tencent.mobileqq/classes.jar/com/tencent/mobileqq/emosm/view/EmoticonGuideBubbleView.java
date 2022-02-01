package com.tencent.mobileqq.emosm.view;

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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class EmoticonGuideBubbleView
  extends LinearLayout
{
  protected Context a;
  protected Drawable b;
  protected View c;
  
  public EmoticonGuideBubbleView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
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
      if (getMeasuredWidth() + paramInt < ViewUtils.getScreenWidth()) {}
    }
    else
    {
      i = ViewUtils.dip2px(6.0F);
    }
    return i;
  }
  
  private int a(View paramView, boolean paramBoolean)
  {
    int i = paramView.getRight();
    paramView = new int[2];
    this.c.getLocationOnScreen(paramView);
    int k = this.c.getWidth();
    measure(0, 0);
    int m = getMeasuredWidth();
    int j;
    if (paramBoolean)
    {
      i -= paramView[0] - ViewUtils.dip2px(20.0F);
      j = m / 2;
    }
    else
    {
      i -= paramView[0] + k / 2;
      j = m / 2;
    }
    i -= j;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonGuideBubbleView", 2, new Object[] { "calcOffset offset:", Integer.valueOf(i), " ,bW:", Integer.valueOf(m), " ,eW:", Integer.valueOf(k), " ,eLX:", Integer.valueOf(paramView[0]) });
    }
    return a(i);
  }
  
  private int a(LinearLayout paramLinearLayout, ImageView paramImageView, int paramInt, boolean paramBoolean)
  {
    int i = paramLinearLayout.getRight();
    paramLinearLayout = new int[2];
    this.c.getLocationOnScreen(paramLinearLayout);
    int k = this.c.getWidth();
    paramImageView.measure(0, 0);
    int j;
    if (paramBoolean)
    {
      i -= paramLinearLayout[0] - ViewUtils.dip2px(20.0F);
      j = paramImageView.getMeasuredWidth() / 4;
    }
    else
    {
      i = i - paramLinearLayout[0] - k / 2;
      j = paramImageView.getMeasuredWidth() / 4;
    }
    paramInt = i - j - paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonGuideBubbleView", 2, new Object[] { "calcArrowOffset arrowOffset:", Integer.valueOf(paramInt), " ,eW:", Integer.valueOf(k), " ,eLX:", Integer.valueOf(paramLinearLayout[0]) });
    }
    return a(paramInt);
  }
  
  protected Drawable a(String paramString, Drawable paramDrawable, boolean paramBoolean)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (paramDrawable == null)
    {
      if (this.b == null) {
        this.b = new ColorDrawable(0);
      }
      paramDrawable = this.b;
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
    }
    else
    {
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
    }
    localURLDrawableOptions.mPlayGifImage = paramBoolean;
    return a(paramString, localURLDrawableOptions);
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
    if (paramRelativeLayout != null)
    {
      if (getVisibility() == 8) {
        return;
      }
      setVisibility(8);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      setAnimation(localAlphaAnimation);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      startAnimation(localAlphaAnimation);
      localAlphaAnimation.setAnimationListener(new EmoticonGuideBubbleView.1(this));
      paramRelativeLayout.removeView(this);
    }
  }
  
  public boolean a(RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramRelativeLayout != null) && (paramLinearLayout != null) && (!TextUtils.isEmpty(paramString)) && (paramInt1 > 0))
    {
      if (paramInt2 <= 0) {
        return false;
      }
      if (getVisibility() == 0)
      {
        a(paramRelativeLayout);
        return false;
      }
      if (paramBoolean)
      {
        this.c = paramRelativeLayout.findViewById(2131433921);
      }
      else
      {
        this.c = paramLinearLayout.findViewById(2131442147);
        if (this.c == null) {
          this.c = paramLinearLayout.findViewById(2131442148);
        }
      }
      if (this.c == null) {
        return false;
      }
      View localView = paramRelativeLayout.findViewById(2131435809);
      if (localView == null) {
        return false;
      }
      removeAllViews();
      ImageView localImageView = new ImageView(this.a);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramString = a(paramString, null, true);
      Object localObject;
      if (((paramString instanceof URLDrawable)) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showGuideBubble drawable status: ");
        ((StringBuilder)localObject).append(((URLDrawable)paramString).getStatus());
        QLog.d("EmoticonGuideBubbleView", 2, ((StringBuilder)localObject).toString());
      }
      localImageView.setImageDrawable(paramString);
      int i = ViewUtils.dip2px(paramInt1 / 2);
      int j = ViewUtils.dip2px(paramInt2 / 2);
      paramInt2 = i;
      paramInt1 = j;
      if (i >= ViewUtils.getScreenWidth())
      {
        paramInt2 = ViewUtils.getScreenWidth() / 2;
        paramInt1 = j * paramInt2 / i;
      }
      localImageView.setLayoutParams(new ViewGroup.LayoutParams(paramInt2, paramInt1));
      localImageView.setBackgroundResource(2130837988);
      addView(localImageView);
      setVisibility(0);
      paramString = new AlphaAnimation(0.0F, 1.0F);
      setAnimation(paramString);
      paramString.setDuration(500L);
      paramString.setFillAfter(true);
      startAnimation(paramString);
      paramString = new RelativeLayout.LayoutParams(-2, -2);
      paramString.addRule(2, 2131435809);
      paramString.addRule(7, 2131435809);
      paramInt1 = a(paramLinearLayout, paramBoolean);
      if (paramInt1 > 0)
      {
        paramString.rightMargin = paramInt1;
        localImageView = new ImageView(this.a);
        localImageView.setImageDrawable(getResources().getDrawable(2130840119));
        localObject = new LinearLayout.LayoutParams(ViewUtils.dip2px(13.0F), ViewUtils.dip2px(8.0F));
        ((LinearLayout.LayoutParams)localObject).gravity = 8388613;
        ((LinearLayout.LayoutParams)localObject).rightMargin = a(paramLinearLayout, localImageView, paramInt1, paramBoolean);
        ((LinearLayout.LayoutParams)localObject).topMargin = (-ViewUtils.dip2px(1.0F));
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        addView(localImageView);
        paramString.bottomMargin = (-localView.getPaddingTop());
      }
      paramRelativeLayout.addView(this, paramString);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.EmoticonGuideBubbleView
 * JD-Core Version:    0.7.0.1
 */