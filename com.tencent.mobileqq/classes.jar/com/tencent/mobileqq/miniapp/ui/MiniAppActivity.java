package com.tencent.mobileqq.miniapp.ui;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import awlo;
import awlp;
import awlu;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import wfo;

public class MiniAppActivity
  extends FragmentActivity
{
  protected int a;
  public awlp a;
  private MiniAppBaseFragment a;
  protected String a;
  
  public void a(MiniAppBaseFragment paramMiniAppBaseFragment)
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    localFragmentTransaction.replace(2131367058, paramMiniAppBaseFragment);
    localFragmentTransaction.commit();
    this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppBaseFragment = paramMiniAppBaseFragment;
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
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131558454);
    paramBundle = getIntent().getExtras();
    Object localObject = new MiniAppLoadingFragment();
    ((MiniAppLoadingFragment)localObject).setArguments(paramBundle);
    a((MiniAppBaseFragment)localObject);
    awlu.a();
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("key_appid");
    this.jdField_a_of_type_Int = getIntent().getIntExtra("key_appType", 0);
    paramBundle = (MiniAppOptions)getIntent().getParcelableExtra("key_options");
    localObject = new awlo();
    ((awlo)localObject).jdField_a_of_type_Int = 2;
    ((awlo)localObject).jdField_a_of_type_Boolean = true;
    ((awlo)localObject).jdField_a_of_type_ArrayOfJavaLangObject = new Object[] { this, this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), paramBundle };
    wfo.a().dispatch("MiniAppManager", (Dispatcher.Dispatchable)localObject);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    awlo localawlo = new awlo();
    localawlo.jdField_a_of_type_Int = 3;
    localawlo.jdField_a_of_type_Boolean = true;
    localawlo.jdField_a_of_type_ArrayOfJavaLangObject = new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int) };
    wfo.a().dispatch("MiniAppManager", localawlo);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    moveTaskToBack(true);
    overridePendingTransition(2130772303, 2130771990);
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.ui.MiniAppActivity
 * JD-Core Version:    0.7.0.1
 */