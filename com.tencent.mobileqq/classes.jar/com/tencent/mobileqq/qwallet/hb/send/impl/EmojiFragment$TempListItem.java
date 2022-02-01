package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;

class EmojiFragment$TempListItem
  extends FrameLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageView b;
  
  public EmojiFragment$TempListItem(EmojiFragment paramEmojiFragment, @NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    paramEmojiFragment = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramEmojiFragment.width = -2;
    paramEmojiFragment.height = -2;
    paramEmojiFragment = new RelativeLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramEmojiFragment);
    Object localObject = (LinearLayout.LayoutParams)paramEmojiFragment.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = ScreenUtil.dip2px(66.0F);
    ((LinearLayout.LayoutParams)localObject).height = ScreenUtil.dip2px(66.0F);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    paramEmojiFragment.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = ScreenUtil.dip2px(66.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = ScreenUtil.dip2px(66.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(R.drawable.g);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = new View(paramContext);
    paramEmojiFragment.addView(this.jdField_a_of_type_AndroidViewView);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ScreenUtil.dip2px(40.0F);
    ((RelativeLayout.LayoutParams)localObject).height = ScreenUtil.dip2px(40.0F);
    ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
    this.b = new ImageView(paramContext);
    paramEmojiFragment.addView(this.b);
    this.b.getLayoutParams().width = -1;
    this.b.getLayoutParams().height = -1;
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxEms(5);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF777777"));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    paramEmojiFragment = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    paramEmojiFragment.width = -2;
    paramEmojiFragment.height = -2;
    paramEmojiFragment.gravity = 1;
    paramEmojiFragment.topMargin = ScreenUtil.dip2px(6.0F);
  }
  
  public void a(EmojiFragment.TemplateInfo paramTemplateInfo)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).setOnClickListener(new EmojiFragment.TempListItem.1(this, paramTemplateInfo));
    }
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject1 != null) {
      ((TextView)localObject1).setText(paramTemplateInfo.jdField_a_of_type_JavaLangString);
    }
    if (this.b != null)
    {
      localObject1 = paramTemplateInfo.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("模板url: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("EmojiFragment", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = getResources().getDrawable(R.drawable.q);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject2);
      ((Animatable)localObject2).start();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("qwallet_config_md5", paramTemplateInfo.c);
      localObject1 = QWalletPicHelper.getNetDrawableForQWallet((String)localObject1, URLDrawableHelperConstants.a, URLDrawableHelperConstants.a, (Bundle)localObject2);
      this.b.setImageDrawable((Drawable)localObject1);
      if (localObject1 != null)
      {
        if (((URLDrawable)localObject1).getStatus() == 1)
        {
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment.a((URLDrawable)localObject1, paramTemplateInfo.jdField_a_of_type_Boolean, paramTemplateInfo.jdField_b_of_type_Int, this.b);
        }
        else if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0))
        {
          ((URLDrawable)localObject1).restartDownload();
        }
        ((URLDrawable)localObject1).setURLDrawableListener(new EmojiFragment.TempListItem.2(this, paramTemplateInfo));
      }
      else
      {
        this.b.setImageDrawable(null);
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(R.drawable.x));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (paramTemplateInfo.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment.a(paramTemplateInfo, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.EmojiFragment.TempListItem
 * JD-Core Version:    0.7.0.1
 */