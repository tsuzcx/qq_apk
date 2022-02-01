package com.tencent.mobileqq.qwallet.hb.emoji.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.RoundImageView;
import cooperation.qwallet.plugin.QWalletPicHelper;

class EmojiRedpacketUserGuideDialog$UserGuidView
  extends FrameLayout
{
  public EmojiRedpacketUserGuideDialog$UserGuidView(EmojiRedpacketUserGuideDialog paramEmojiRedpacketUserGuideDialog, @NonNull Context paramContext)
  {
    super(paramContext);
    Object localObject1 = new RelativeLayout(paramContext);
    ((RelativeLayout)localObject1).setClickable(true);
    addView((View)localObject1);
    Object localObject2 = (FrameLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).width = -1;
    ((FrameLayout.LayoutParams)localObject2).height = -1;
    ((RelativeLayout)localObject1).setOnClickListener(new EmojiRedpacketUserGuideDialog.UserGuidView.1(this, paramEmojiRedpacketUserGuideDialog));
    paramEmojiRedpacketUserGuideDialog = new View(paramContext);
    ((RelativeLayout)localObject1).addView(paramEmojiRedpacketUserGuideDialog);
    localObject2 = (RelativeLayout.LayoutParams)paramEmojiRedpacketUserGuideDialog.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).addRule(13);
    ((RelativeLayout.LayoutParams)localObject2).width = DisplayUtil.a(paramContext, 40.0F);
    ((RelativeLayout.LayoutParams)localObject2).height = DisplayUtil.a(paramContext, 40.0F);
    localObject2 = getResources().getDrawable(R.drawable.q);
    paramEmojiRedpacketUserGuideDialog.setBackgroundDrawable((Drawable)localObject2);
    ((Animatable)localObject2).start();
    paramEmojiRedpacketUserGuideDialog = new LinearLayout(paramContext);
    paramEmojiRedpacketUserGuideDialog.setOrientation(1);
    ((RelativeLayout)localObject1).addView(paramEmojiRedpacketUserGuideDialog);
    localObject1 = (RelativeLayout.LayoutParams)paramEmojiRedpacketUserGuideDialog.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    ((RelativeLayout.LayoutParams)localObject1).width = -1;
    ((RelativeLayout.LayoutParams)localObject1).height = -2;
    localObject1 = new RoundImageView(paramContext);
    ((RoundImageView)localObject1).setmRadius(ScreenUtil.dip2px(10.0F), false);
    ((RoundImageView)localObject1).setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(EmojiRedpacketUserGuideDialog.a, URLDrawableHelperConstants.a, URLDrawableHelperConstants.a));
    paramEmojiRedpacketUserGuideDialog.addView((View)localObject1);
    localObject1 = (LinearLayout.LayoutParams)((RoundImageView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).gravity = 1;
    double d = ScreenUtil.getInstantScreenHeight(paramContext);
    Double.isNaN(d);
    ((LinearLayout.LayoutParams)localObject1).height = ((int)(d * 0.7D));
    ((LinearLayout.LayoutParams)localObject1).width = ScreenUtil.dip2px(320.0F);
    localObject1 = new ImageView(paramContext);
    ((ImageView)localObject1).setImageResource(R.drawable.y);
    paramEmojiRedpacketUserGuideDialog.addView((View)localObject1);
    paramEmojiRedpacketUserGuideDialog = (LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
    d = ScreenUtil.getInstantScreenHeight(paramContext);
    Double.isNaN(d);
    paramEmojiRedpacketUserGuideDialog.topMargin = ((int)(d * 0.02D));
    paramEmojiRedpacketUserGuideDialog.gravity = 1;
    paramEmojiRedpacketUserGuideDialog.width = ScreenUtil.dip2px(37.0F);
    paramEmojiRedpacketUserGuideDialog.height = ScreenUtil.dip2px(37.0F);
    AccessibilityUtil.a((View)localObject1, HardCodeUtil.a(R.string.aE), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.emoji.impl.EmojiRedpacketUserGuideDialog.UserGuidView
 * JD-Core Version:    0.7.0.1
 */