package com.tencent.mobileqq.forward;

import agif;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import atky;
import atmq;
import bfvo;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class ForwardMarketFaceOption
  extends atky
{
  private ImageView a;
  private boolean i;
  
  public ForwardMarketFaceOption(Intent paramIntent)
  {
    super(paramIntent);
    this.i = paramIntent.getBooleanExtra("direct_send_emoji", false);
    this.jdField_b_of_type_Int = 4;
  }
  
  public View a()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    localFrameLayout.setMinimumHeight(ViewUtils.dip2px(85.0F));
    int j = ViewUtils.dip2px(15.0F);
    localFrameLayout.setPadding(0, j, 0, j);
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    localImageView.setAdjustViewBounds(true);
    localImageView.setMaxWidth(ViewUtils.dip2px(120.0F));
    localImageView.setMaxHeight(ViewUtils.dip2px(120.0F));
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localFrameLayout.addView(localImageView, new FrameLayout.LayoutParams(-2, -2, 17));
    this.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    e();
    return localFrameLayout;
  }
  
  public void a()
  {
    if (o()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.i)
    {
      if (paramInt >= 0) {
        this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", paramInt);
      }
      if (paramBundle != null) {
        this.jdField_a_of_type_AndroidOsBundle.putAll(paramBundle);
      }
      d();
      return;
    }
    super.a(paramInt, paramBundle);
  }
  
  public boolean c()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    ForwardUtils.handleForwardData(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    return false;
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardMarketFaceOption", 2, "setPreviewImage");
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_emotion_from_preview", false)) {}
    for (Object localObject = AIOEmotionFragment.a; localObject == null; localObject = agif.a) {
      return;
    }
    localObject = ((PicEmoticonInfo)localObject).getLoadingDrawable("fromAIO", false);
    ((URLDrawable)localObject).setBounds(bfvo.a((Drawable)localObject, 36, 100, this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    ((URLDrawable)localObject).setURLDrawableListener(new atmq(this));
  }
  
  public void k()
  {
    super.k();
    AbstractGifImage.pauseAll();
  }
  
  public void l()
  {
    super.l();
    AbstractGifImage.resumeAll();
  }
  
  public boolean l()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMarketFaceOption
 * JD-Core Version:    0.7.0.1
 */