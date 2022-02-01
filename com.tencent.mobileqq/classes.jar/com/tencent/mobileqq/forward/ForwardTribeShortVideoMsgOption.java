package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class ForwardTribeShortVideoMsgOption
  extends ForwardStructingMsgOption
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  protected ScrollView a;
  protected String i;
  
  public ForwardTribeShortVideoMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected void a()
  {
    String str;
    if (c() != 0) {
      str = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
    } else {
      str = "";
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", str);
    e();
    super.a();
  }
  
  public boolean a()
  {
    super.a();
    this.i = this.jdField_a_of_type_AndroidOsBundle.getString("qqtribeVideoInfoExtra ");
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("stuctmsg_bytes"));
    if ((localAbsStructMsg != null) && ((localAbsStructMsg instanceof AbsShareMsg))) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localAbsStructMsg);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 3);
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mTribeShortVideoExtra = this.i;
    }
    return true;
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    paramQQCustomDialog.getWindow().setSoftInputMode(19);
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      int j = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 12.0F);
      int k = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 164.0F);
      int m = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 265.0F);
      int n = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 140.0F);
      int i1 = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 27.0F);
      int i2 = Color.parseColor("#e1e1e5");
      Object localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      ((LinearLayout)localObject1).setOrientation(1);
      Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 1;
      Object localObject3 = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(k, m);
      URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidAppActivity);
      localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      Object localObject4 = new RelativeLayout.LayoutParams(n, i1);
      ((RelativeLayout.LayoutParams)localObject4).addRule(9);
      ((RelativeLayout.LayoutParams)localObject4).addRule(10);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = j;
      ((RelativeLayout.LayoutParams)localObject4).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 15.0F);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      ((TextView)localObject4).setTextColor(-7829368);
      ((TextView)localObject4).setTextSize(1, 12.0F);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams2.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 5.0F);
      localLayoutParams2.gravity = 3;
      ((RelativeLayout)localObject3).addView(localURLImageView, localLayoutParams);
      ((LinearLayout)localObject1).addView((View)localObject3, localLayoutParams1);
      ((LinearLayout)localObject1).addView((View)localObject4, localLayoutParams2);
      paramQQCustomDialog.addView((View)localObject1, (LinearLayout.LayoutParams)localObject2);
      ((TextView)localObject4).setText(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentCover;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addStructView:");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mTribeShortVideoExtra);
        QLog.d("ForwardOption.ForwardTribeShortVideoMsgOption", 2, ((StringBuilder)localObject2).toString());
      }
      try
      {
        localObject2 = new ColorDrawable(i2);
        localURLImageView.setImageDrawable((Drawable)localObject2);
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = k;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = m;
        localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
        if (((URLDrawable)localObject1).getStatus() == 2) {
          ((URLDrawable)localObject1).restartDownload();
        }
        localURLImageView.setImageDrawable((Drawable)localObject1);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "addStructView:", localException);
        }
      }
      try
      {
        this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)paramQQCustomDialog.getWindow().getDecorView().findViewById(2131376994));
        if (this.jdField_a_of_type_AndroidWidgetScrollView != null) {
          this.jdField_a_of_type_AndroidWidgetScrollView.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
      }
      catch (Exception paramQQCustomDialog)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("addStructView:");
          localStringBuilder.append(paramQQCustomDialog.toString());
          QLog.w("Q.qqstory.share", 2, localStringBuilder.toString());
        }
      }
    }
    return true;
  }
  
  protected void e()
  {
    ScrollView localScrollView = this.jdField_a_of_type_AndroidWidgetScrollView;
    if (localScrollView != null) {
      try
      {
        localScrollView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "removeLayoutListener:", localException);
        }
      }
    }
  }
  
  protected boolean m()
  {
    return false;
  }
  
  public void onGlobalLayout()
  {
    ScrollView localScrollView = this.jdField_a_of_type_AndroidWidgetScrollView;
    if (localScrollView != null) {
      localScrollView.post(new ForwardTribeShortVideoMsgOption.1(this));
    }
  }
  
  protected void t()
  {
    super.t();
    e();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "forwardOnCancel");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTribeShortVideoMsgOption
 * JD-Core Version:    0.7.0.1
 */