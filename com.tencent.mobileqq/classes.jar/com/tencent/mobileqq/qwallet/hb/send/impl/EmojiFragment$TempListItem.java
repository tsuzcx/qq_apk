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
  private LinearLayout b;
  private ImageView c;
  private ImageView d;
  private TextView e;
  private View f;
  
  public EmojiFragment$TempListItem(EmojiFragment paramEmojiFragment, @NonNull Context paramContext)
  {
    super(paramContext);
    this.b = new LinearLayout(paramContext);
    this.b.setOrientation(1);
    this.b.setClickable(true);
    addView(this.b);
    paramEmojiFragment = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    paramEmojiFragment.width = -2;
    paramEmojiFragment.height = -2;
    paramEmojiFragment = new RelativeLayout(paramContext);
    this.b.addView(paramEmojiFragment);
    Object localObject = (LinearLayout.LayoutParams)paramEmojiFragment.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = ScreenUtil.dip2px(66.0F);
    ((LinearLayout.LayoutParams)localObject).height = ScreenUtil.dip2px(66.0F);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    this.c = new ImageView(paramContext);
    paramEmojiFragment.addView(this.c);
    this.c.getLayoutParams().width = ScreenUtil.dip2px(66.0F);
    this.c.getLayoutParams().height = ScreenUtil.dip2px(66.0F);
    this.c.setScaleType(ImageView.ScaleType.FIT_XY);
    this.c.setImageResource(R.drawable.g);
    this.c.setVisibility(8);
    this.f = new View(paramContext);
    paramEmojiFragment.addView(this.f);
    localObject = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ScreenUtil.dip2px(40.0F);
    ((RelativeLayout.LayoutParams)localObject).height = ScreenUtil.dip2px(40.0F);
    ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
    this.d = new ImageView(paramContext);
    paramEmojiFragment.addView(this.d);
    this.d.getLayoutParams().width = -1;
    this.d.getLayoutParams().height = -1;
    this.e = new TextView(paramContext);
    this.e.setSingleLine(true);
    this.e.setMaxEms(5);
    this.e.setEllipsize(TextUtils.TruncateAt.END);
    this.e.setTextSize(1, 14.0F);
    this.e.setTextColor(Color.parseColor("#FF777777"));
    this.b.addView(this.e);
    paramEmojiFragment = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    paramEmojiFragment.width = -2;
    paramEmojiFragment.height = -2;
    paramEmojiFragment.gravity = 1;
    paramEmojiFragment.topMargin = ScreenUtil.dip2px(6.0F);
  }
  
  public void a(EmojiFragment.TemplateInfo paramTemplateInfo)
  {
    Object localObject1 = this.b;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).setOnClickListener(new EmojiFragment.TempListItem.1(this, paramTemplateInfo));
    }
    localObject1 = this.e;
    if (localObject1 != null) {
      ((TextView)localObject1).setText(paramTemplateInfo.d);
    }
    if (this.d != null)
    {
      localObject1 = paramTemplateInfo.e;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("模板url: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("EmojiFragment", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = getResources().getDrawable(R.drawable.q);
      this.f.setBackgroundDrawable((Drawable)localObject2);
      ((Animatable)localObject2).start();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("qwallet_config_md5", paramTemplateInfo.f);
      localObject1 = QWalletPicHelper.getNetDrawableForQWallet((String)localObject1, URLDrawableHelperConstants.a, URLDrawableHelperConstants.a, (Bundle)localObject2);
      this.d.setImageDrawable((Drawable)localObject1);
      if (localObject1 != null)
      {
        if (((URLDrawable)localObject1).getStatus() == 1)
        {
          this.f.setBackgroundDrawable(null);
          this.c.setVisibility(0);
          this.a.a((URLDrawable)localObject1, paramTemplateInfo.g, paramTemplateInfo.b, this.d);
        }
        else if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0))
        {
          ((URLDrawable)localObject1).restartDownload();
        }
        ((URLDrawable)localObject1).setURLDrawableListener(new EmojiFragment.TempListItem.2(this, paramTemplateInfo));
      }
      else
      {
        this.d.setImageDrawable(null);
        this.f.setBackgroundDrawable(getResources().getDrawable(R.drawable.x));
        this.c.setVisibility(8);
      }
      if (paramTemplateInfo.g) {
        this.a.a(paramTemplateInfo, this.d);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.EmojiFragment.TempListItem
 * JD-Core Version:    0.7.0.1
 */