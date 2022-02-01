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
  protected String ag;
  
  public ForwardTribeShortVideoMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected void W()
  {
    super.W();
    o();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "forwardOnCancel");
    }
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    paramQQCustomDialog.getWindow().setSoftInputMode(19);
    if (this.ad != null)
    {
      int i = DisplayUtil.a(this.s, 12.0F);
      int j = DisplayUtil.a(this.s, 164.0F);
      int k = DisplayUtil.a(this.s, 265.0F);
      int m = DisplayUtil.a(this.s, 140.0F);
      int n = DisplayUtil.a(this.s, 27.0F);
      int i1 = Color.parseColor("#e1e1e5");
      Object localObject1 = new LinearLayout(this.s);
      ((LinearLayout)localObject1).setOrientation(1);
      Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 1;
      Object localObject3 = new RelativeLayout(this.s);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(j, k);
      URLImageView localURLImageView = new URLImageView(this.s);
      localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      Object localObject4 = new RelativeLayout.LayoutParams(m, n);
      ((RelativeLayout.LayoutParams)localObject4).addRule(9);
      ((RelativeLayout.LayoutParams)localObject4).addRule(10);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = i;
      ((RelativeLayout.LayoutParams)localObject4).topMargin = DisplayUtil.a(this.s, 15.0F);
      localObject4 = new TextView(this.s);
      ((TextView)localObject4).setTextColor(-7829368);
      ((TextView)localObject4).setTextSize(1, 12.0F);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams2.topMargin = DisplayUtil.a(this.s, 5.0F);
      localLayoutParams2.gravity = 3;
      ((RelativeLayout)localObject3).addView(localURLImageView, localLayoutParams);
      ((LinearLayout)localObject1).addView((View)localObject3, localLayoutParams1);
      ((LinearLayout)localObject1).addView((View)localObject4, localLayoutParams2);
      paramQQCustomDialog.addView((View)localObject1, (LinearLayout.LayoutParams)localObject2);
      ((TextView)localObject4).setText(this.ad.mSourceName);
      localObject1 = this.ad.mContentCover;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addStructView:");
        ((StringBuilder)localObject2).append(this.ad.mTribeShortVideoExtra);
        QLog.d("ForwardOption.ForwardTribeShortVideoMsgOption", 2, ((StringBuilder)localObject2).toString());
      }
      try
      {
        localObject2 = new ColorDrawable(i1);
        localURLImageView.setImageDrawable((Drawable)localObject2);
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = j;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = k;
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
        this.a = ((ScrollView)paramQQCustomDialog.getWindow().getDecorView().findViewById(2131445358));
        if (this.a != null) {
          this.a.getViewTreeObserver().addOnGlobalLayoutListener(this);
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
  
  protected void b()
  {
    String str;
    if (F() != 0) {
      str = this.A.getInputValue();
    } else {
      str = "";
    }
    this.t.putString("share_comment_message", str);
    o();
    super.b();
  }
  
  public boolean e()
  {
    super.e();
    this.ag = this.t.getString("qqtribeVideoInfoExtra ");
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(this.t.getByteArray("stuctmsg_bytes"));
    if ((localAbsStructMsg != null) && ((localAbsStructMsg instanceof AbsShareMsg))) {
      this.ad = ((AbsShareMsg)localAbsStructMsg);
    }
    if (this.ad != null)
    {
      this.t.putInt("emoInputType", 3);
      this.ad.mTribeShortVideoExtra = this.ag;
    }
    return true;
  }
  
  protected boolean k()
  {
    return false;
  }
  
  protected void o()
  {
    ScrollView localScrollView = this.a;
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
  
  public void onGlobalLayout()
  {
    ScrollView localScrollView = this.a;
    if (localScrollView != null) {
      localScrollView.post(new ForwardTribeShortVideoMsgOption.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTribeShortVideoMsgOption
 * JD-Core Version:    0.7.0.1
 */