package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class ForwardMarketFaceOption
  extends ForwardBaseOption
{
  private ImageView a;
  private boolean j;
  
  public ForwardMarketFaceOption(Intent paramIntent)
  {
    super(paramIntent);
    this.j = paramIntent.getBooleanExtra("direct_send_emoji", false);
    this.jdField_b_of_type_Int = 4;
  }
  
  protected View a()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    localFrameLayout.setMinimumHeight(ViewUtils.a(85.0F));
    int i = ViewUtils.a(15.0F);
    localFrameLayout.setPadding(0, i, 0, i);
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    localImageView.setAdjustViewBounds(true);
    localImageView.setMaxWidth(ViewUtils.a(120.0F));
    localImageView.setMaxHeight(ViewUtils.a(120.0F));
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localFrameLayout.addView(localImageView, new FrameLayout.LayoutParams(-2, -2, 17));
    this.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    e();
    return localFrameLayout;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.j)
    {
      if (paramInt >= 0) {
        this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", paramInt);
      }
      if (paramBundle != null) {
        this.jdField_a_of_type_AndroidOsBundle.putAll(paramBundle);
      }
      a();
      return;
    }
    super.a(paramInt, paramBundle);
  }
  
  protected void b()
  {
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (r()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
  }
  
  protected boolean c()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    return false;
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardMarketFaceOption", 2, "setPreviewImage");
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_emotion_from_preview", false)) {
      localObject = AIOEmotionFragment.a;
    } else {
      localObject = MarketFaceItemBuilder.a;
    }
    if (localObject == null) {
      return;
    }
    Object localObject = ((IPicEmoticonInfo)localObject).getLoadingDrawable("fromAIO", false);
    ((URLDrawable)localObject).setBounds(ImageUtil.a((Drawable)localObject, 36, 100, this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    ((URLDrawable)localObject).setURLDrawableListener(new ForwardMarketFaceOption.1(this));
  }
  
  public void l()
  {
    super.l();
    AbstractGifImage.pauseAll();
  }
  
  public void m()
  {
    super.m();
    AbstractGifImage.resumeAll();
  }
  
  protected boolean m()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMarketFaceOption
 * JD-Core Version:    0.7.0.1
 */