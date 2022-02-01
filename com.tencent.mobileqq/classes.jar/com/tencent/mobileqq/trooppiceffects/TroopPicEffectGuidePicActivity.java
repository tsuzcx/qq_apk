package com.tencent.mobileqq.trooppiceffects;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import bhbf;
import bhbg;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class TroopPicEffectGuidePicActivity
  extends BaseActivity
  implements View.OnClickListener
{
  protected ImageButton a;
  protected ImageView a;
  protected URLImageView a;
  protected ImageButton b;
  
  protected void a(View paramView)
  {
    paramView.setOnTouchListener(new bhbf(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    setContentView(2131563062);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131379505));
    this.b = ((ImageButton)findViewById(2131379506));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131379507));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379509));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.b.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidWidgetImageButton);
    a(this.b);
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    Object localObject = new ColorDrawable(0);
    paramBundle.mFailedDrawable = ((Drawable)localObject);
    paramBundle.mLoadingDrawable = ((Drawable)localObject);
    paramBundle = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/groupgift/troop_effect_pic_preview_img.png", paramBundle);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBundle);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    localObject = getResources().getDrawable(2130850738);
    paramBundle.mFailedDrawable = ((Drawable)localObject);
    paramBundle.mLoadingDrawable = ((Drawable)localObject);
    paramBundle = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_select_pic_button.png", paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundDrawable(paramBundle);
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    localObject = new ColorDrawable(0);
    paramBundle.mFailedDrawable = ((Drawable)localObject);
    paramBundle.mLoadingDrawable = ((Drawable)localObject);
    paramBundle = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_select_pic_wording.png", paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramBundle);
    bhbg.a("app_entry_guide", "page_exp");
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageButton)
    {
      TroopPicEffectsEditActivity.a(this, getIntent().getStringExtra("friendUin"), getIntent().getStringExtra("troopUin"));
      finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.b) {
        finish();
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void setImmersiveStatus()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if ((this.mActNeedImmersive) && (this.mSystemBarComp == null)) {
        this.mSystemBarComp = new SystemBarCompact(this, true, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity
 * JD-Core Version:    0.7.0.1
 */