package com.tencent.mobileqq.forward;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ForwardQQStoryMsgOption
  extends ForwardStructingMsgOption
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  protected ScrollView a;
  
  public ForwardQQStoryMsgOption(Intent paramIntent)
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
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
      a("clk_send", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgAction, this.jdField_a_of_type_AndroidAppActivity);
    }
    super.a();
  }
  
  protected void a(String paramString1, String paramString2, Context paramContext)
  {
    Object localObject = null;
    try
    {
      paramString2 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramString2);
    }
    catch (Exception paramContext)
    {
      paramString2 = (String)localObject;
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.w("Q.qqstory.share", 2, "report exp:", paramContext);
          paramString2 = (String)localObject;
        }
        int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
        int j = -1;
        if (i == 0) {
          i = 1;
        } else if (i == 1) {
          i = 2;
        } else if (i == 3000) {
          i = 3;
        } else {
          i = -1;
        }
        if (paramString2 == null) {
          break label299;
        }
        localObject = paramString2.b("unionid");
        paramContext = paramString2.b("storyid");
        try
        {
          int k = Integer.valueOf(paramString2.b("contentType")).intValue();
          j = k;
          paramString2 = (String)localObject;
        }
        catch (Exception paramString2)
        {
          paramString2.printStackTrace();
          paramString2 = (String)localObject;
        }
        StoryReportor.a("share", paramString1, i, j, new String[] { paramString2, paramContext, "", "" });
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("reportClickEvent: opName=");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(", fromType=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", result=");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(", extra1=");
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append(", extra2=");
          ((StringBuilder)localObject).append(paramContext);
          QLog.d("ForwardOption.ForwardQQStoryMsgOption", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "reportClickEvent exp:", paramString1);
        }
      }
      return;
      label299:
      paramString2 = "";
      paramContext = paramString2;
    }
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    paramQQCustomDialog.getWindow().setSoftInputMode(19);
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      int i = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 12.0F);
      int j = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 164.0F);
      int k = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 265.0F);
      int m = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 140.0F);
      int n = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 27.0F);
      int i1 = Color.parseColor("#e1e1e5");
      Object localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
      ((LinearLayout)localObject1).setOrientation(1);
      Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).gravity = 1;
      Object localObject5 = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
      Object localObject6 = new LinearLayout.LayoutParams(j, k);
      Object localObject4 = new URLImageView(this.jdField_a_of_type_AndroidAppActivity);
      ((URLImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidAppActivity);
      localURLImageView.setScaleType(ImageView.ScaleType.FIT_START);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(m, n);
      localLayoutParams2.addRule(9);
      localLayoutParams2.addRule(10);
      localLayoutParams2.leftMargin = i;
      localLayoutParams2.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 15.0F);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      localTextView.setTextColor(-7829368);
      localTextView.setTextSize(1, 12.0F);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 5.0F);
      localLayoutParams.gravity = 3;
      ((RelativeLayout)localObject5).addView((View)localObject4, localLayoutParams1);
      ((RelativeLayout)localObject5).addView(localURLImageView, localLayoutParams2);
      ((LinearLayout)localObject1).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      ((LinearLayout)localObject1).addView(localTextView, localLayoutParams);
      paramQQCustomDialog.addView((View)localObject1, (LinearLayout.LayoutParams)localObject3);
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName);
      try
      {
        localObject3 = new JSONObject(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mQQStoryExtra);
        localObject1 = ((JSONObject)localObject3).optString("coverImgUrl");
        try
        {
          localObject3 = ((JSONObject)localObject3).optString("logoImgUrl");
        }
        catch (Exception localException3) {}
        if (!QLog.isColorLevel()) {
          break label424;
        }
      }
      catch (Exception localException4)
      {
        localObject1 = "";
      }
      QLog.w("Q.qqstory.share", 2, "addStructView:", localException4);
      label424:
      String str = "";
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("addStructView:");
        ((StringBuilder)localObject5).append(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mQQStoryExtra);
        QLog.d("Q.qqstory.share", 2, ((StringBuilder)localObject5).toString());
      }
      try
      {
        localObject5 = new ColorDrawable(i1);
        ((URLImageView)localObject4).setImageDrawable((Drawable)localObject5);
        localObject6 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject6).mFailedDrawable = ((Drawable)localObject5);
        ((URLDrawable.URLDrawableOptions)localObject6).mLoadingDrawable = ((Drawable)localObject5);
        ((URLDrawable.URLDrawableOptions)localObject6).mRequestWidth = j;
        ((URLDrawable.URLDrawableOptions)localObject6).mRequestHeight = k;
        localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject6);
        if (((URLDrawable)localObject1).getStatus() == 2) {
          ((URLDrawable)localObject1).restartDownload();
        }
        ((URLImageView)localObject4).setImageDrawable((Drawable)localObject1);
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "addStructView:", localException1);
        }
      }
      try
      {
        Object localObject2 = new ColorDrawable(Color.parseColor("#00000000"));
        localURLImageView.setImageDrawable((Drawable)localObject2);
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = m;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = n;
        localObject2 = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject4);
        if (((URLDrawable)localObject2).getStatus() == 2) {
          ((URLDrawable)localObject2).restartDownload();
        }
        localURLImageView.setImageDrawable((Drawable)localObject2);
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "addStructView:", localException2);
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
      a("list_clk", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgAction, this.jdField_a_of_type_AndroidAppActivity);
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
      localScrollView.post(new ForwardQQStoryMsgOption.1(this));
    }
  }
  
  protected void t()
  {
    super.t();
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
      a("cancel", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgAction, this.jdField_a_of_type_AndroidAppActivity);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "forwardOnCancel");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQQStoryMsgOption
 * JD-Core Version:    0.7.0.1
 */