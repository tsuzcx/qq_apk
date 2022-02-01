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
  private boolean a;
  private ImageView ad;
  
  public ForwardMarketFaceOption(Intent paramIntent)
  {
    super(paramIntent);
    this.a = paramIntent.getBooleanExtra("direct_send_emoji", false);
    this.L = 4;
  }
  
  protected View a()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.s);
    localFrameLayout.setMinimumHeight(ViewUtils.dip2px(85.0F));
    int i = ViewUtils.dip2px(15.0F);
    localFrameLayout.setPadding(0, i, 0, i);
    ImageView localImageView = new ImageView(this.s);
    localImageView.setAdjustViewBounds(true);
    localImageView.setMaxWidth(ViewUtils.dip2px(120.0F));
    localImageView.setMaxHeight(ViewUtils.dip2px(120.0F));
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localFrameLayout.addView(localImageView, new FrameLayout.LayoutParams(-2, -2, 17));
    this.ad = localImageView;
    o();
    return localFrameLayout;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.a)
    {
      if (paramInt >= 0) {
        this.t.putInt("key_forward_ability_type", paramInt);
      }
      if (paramBundle != null) {
        this.t.putAll(paramBundle);
      }
      b();
      return;
    }
    super.a(paramInt, paramBundle);
  }
  
  protected void c()
  {
    if (ag()) {
      this.C.add(e);
    }
    if (ah()) {
      this.C.add(d);
    }
    if (ai()) {
      this.C.add(c);
    }
  }
  
  protected boolean f()
  {
    Intent localIntent = new Intent(this.s, SplashActivity.class);
    localIntent.putExtras(this.t);
    ForwardUtils.a(this.q, this.s, this.I, localIntent, null);
    this.s.setResult(-1, localIntent);
    this.s.finish();
    return false;
  }
  
  public void i()
  {
    super.i();
    AbstractGifImage.resumeAll();
  }
  
  public void j()
  {
    super.j();
    AbstractGifImage.pauseAll();
  }
  
  protected boolean k()
  {
    return true;
  }
  
  protected void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardMarketFaceOption", 2, "setPreviewImage");
    }
    if (this.t.getBoolean("forward_emotion_from_preview", false)) {
      localObject = AIOEmotionFragment.d;
    } else {
      localObject = MarketFaceItemBuilder.w;
    }
    if (localObject == null) {
      return;
    }
    Object localObject = ((IPicEmoticonInfo)localObject).getLoadingDrawable("fromAIO", false);
    ((URLDrawable)localObject).setBounds(ImageUtil.a((Drawable)localObject, 36, 100, this.z));
    this.ad.setImageDrawable((Drawable)localObject);
    ((URLDrawable)localObject).setURLDrawableListener(new ForwardMarketFaceOption.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMarketFaceOption
 * JD-Core Version:    0.7.0.1
 */