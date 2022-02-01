package com.tencent.mobileqq.nearby.anim;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import java.util.Random;

public class NearbyZanAnimLayout
  extends HeartLayout
{
  public NearbyZanAnimLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public NearbyZanAnimLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NearbyZanAnimLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.c = (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 5);
    this.jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator = new NearbyZanAnimator(this);
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.a(this);
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator == null) || (paramBitmap == null)) {
      return;
    }
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageBitmap(paramBitmap);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.a(localImageView, paramFloat1, paramFloat2, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout
 * JD-Core Version:    0.7.0.1
 */