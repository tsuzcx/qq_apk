package com.tencent.mobileqq.forward;

import afur;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aufz;
import bggq;
import bgpa;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.qphone.base.util.QLog;

public class ForwardTroopStoryMsgOption
  extends aufz
{
  public ForwardTroopStoryMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public boolean a(bgpa parambgpa)
  {
    int i = bggq.a(this.jdField_a_of_type_AndroidAppActivity, 164.0F);
    int j = bggq.a(this.jdField_a_of_type_AndroidAppActivity, 265.0F);
    int k = Color.parseColor("#e1e1e5");
    Object localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
    ((LinearLayout)localObject1).setOrientation(1);
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).gravity = 1;
    Object localObject3 = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    Object localObject4 = new LinearLayout.LayoutParams(i, j);
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidAppActivity);
    localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    ((RelativeLayout)localObject3).addView(localURLImageView, new RelativeLayout.LayoutParams(-1, -1));
    Object localObject5 = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    ((ImageView)localObject5).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject5).setImageResource(2130839583);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    int m = bggq.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F);
    localLayoutParams.setMargins(0, m, m, 0);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(11);
    ((RelativeLayout)localObject3).addView((View)localObject5, localLayoutParams);
    ((LinearLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("key_source_name");
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject4 = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      ((TextView)localObject4).setTextColor(-7829368);
      ((TextView)localObject4).setTextSize(1, 12.0F);
      localObject5 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject5).topMargin = bggq.a(this.jdField_a_of_type_AndroidAppActivity, 5.0F);
      ((LinearLayout.LayoutParams)localObject5).gravity = 3;
      ((TextView)localObject4).setText((CharSequence)localObject3);
      ((LinearLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
    }
    parambgpa.addView((View)localObject1, (LinearLayout.LayoutParams)localObject2);
    parambgpa = this.jdField_a_of_type_AndroidOsBundle.getString("key_thumb_url");
    try
    {
      localObject1 = new ColorDrawable(k);
      localURLImageView.setImageDrawable((Drawable)localObject1);
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = j;
      parambgpa = URLDrawable.getDrawable(parambgpa, (URLDrawable.URLDrawableOptions)localObject2);
      if (parambgpa.getStatus() == 2) {
        parambgpa.restartDownload();
      }
      localURLImageView.setImageDrawable(parambgpa);
    }
    catch (Exception parambgpa)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.troopstory.share", 2, "addStructView:", parambgpa);
        }
      }
    }
    return true;
  }
  
  public boolean c()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    localIntent = afur.a(localIntent, null);
    localIntent.putExtra("isBack2Root", true);
    ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTroopStoryMsgOption
 * JD-Core Version:    0.7.0.1
 */