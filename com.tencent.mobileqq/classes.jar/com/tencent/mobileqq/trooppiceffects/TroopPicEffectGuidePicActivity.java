package com.tencent.mobileqq.trooppiceffects;

import ajwu;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
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
    paramView.setOnTouchListener(new ajwu(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    setContentView(2130971688);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131375363));
    this.b = ((ImageButton)findViewById(2131375360));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131375364));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375361));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.b.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidWidgetImageButton);
    a(this.b);
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    Object localObject = new ColorDrawable(0);
    paramBundle.mFailedDrawable = ((Drawable)localObject);
    paramBundle.mLoadingDrawable = ((Drawable)localObject);
    paramBundle = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/groupgift/troop_effect_pic_preview_img.png", paramBundle);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBundle);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    localObject = getResources().getDrawable(2130846322);
    paramBundle.mFailedDrawable = ((Drawable)localObject);
    paramBundle.mLoadingDrawable = ((Drawable)localObject);
    paramBundle = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_select_pic_button.png", paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundDrawable(paramBundle);
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    localObject = new ColorDrawable(0);
    paramBundle.mFailedDrawable = ((Drawable)localObject);
    paramBundle.mLoadingDrawable = ((Drawable)localObject);
    paramBundle = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_select_pic_wording.png", paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramBundle);
    TroopPicEffectsController.a("app_entry_guide", "page_exp");
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageButton)
    {
      TroopPicEffectsEditActivity.a(this, getIntent().getStringExtra("friendUin"), getIntent().getStringExtra("troopUin"));
      finish();
    }
    while (paramView != this.b) {
      return;
    }
    finish();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity
 * JD-Core Version:    0.7.0.1
 */