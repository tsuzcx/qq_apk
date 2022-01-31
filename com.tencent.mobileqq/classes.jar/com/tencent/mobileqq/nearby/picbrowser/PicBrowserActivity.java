package com.tencent.mobileqq.nearby.picbrowser;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import avey;
import com.tencent.image.AbstractVideoImage;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import zep;

public class PicBrowserActivity
  extends BaseActivity
{
  protected ImmersiveTitleBar2 a;
  public zep a;
  public int b;
  public ArrayList<PicInfo> b;
  public boolean b;
  
  public PicBrowserActivity()
  {
    this.jdField_a_of_type_Zep = new avey(this);
  }
  
  protected void a()
  {
    this.jdField_b_of_type_Int = getIntent().getIntExtra("intent_param_index", 0);
    this.jdField_b_of_type_JavaUtilArrayList = getIntent().getParcelableArrayListExtra("intent_param_pic_infos");
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("report_visited_pic", false);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131377976));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
    ImmersiveUtils.a(getWindow(), ThemeUtil.isNowThemeIsDefault(this.app, false, null));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(getResources().getColor(2131165307));
  }
  
  public void doOnBackPressed()
  {
    if (!this.jdField_a_of_type_Zep.b()) {
      super.doOnBackPressed();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = true;
    super.doOnCreate(paramBundle);
    setContentView(2131561071);
    d();
    a();
    this.jdField_a_of_type_Zep.a(this);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Zep.c(this);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_Zep.a(paramInt, paramKeyEvent)) {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void doOnPause()
  {
    AbstractVideoImage.pauseAll();
    this.jdField_a_of_type_Zep.b();
  }
  
  public void doOnResume()
  {
    AbstractVideoImage.resumeAll();
    this.jdField_a_of_type_Zep.c();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_Zep.b(this);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(8);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity
 * JD-Core Version:    0.7.0.1
 */