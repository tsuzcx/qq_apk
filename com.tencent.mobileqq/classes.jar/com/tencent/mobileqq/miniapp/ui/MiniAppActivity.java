package com.tencent.mobileqq.miniapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import armq;
import armr;
import armw;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import sgi;

public class MiniAppActivity
  extends FragmentActivity
{
  protected int a;
  public armr a;
  private MiniAppBaseFragment a;
  protected String a;
  
  public void a(MiniAppBaseFragment paramMiniAppBaseFragment)
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    localFragmentTransaction.replace(2131301051, paramMiniAppBaseFragment);
    localFragmentTransaction.commit();
    this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppBaseFragment = paramMiniAppBaseFragment;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131492911);
    paramBundle = getIntent().getExtras();
    Object localObject = new MiniAppLoadingFragment();
    ((MiniAppLoadingFragment)localObject).setArguments(paramBundle);
    a((MiniAppBaseFragment)localObject);
    armw.a();
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("key_appid");
    this.jdField_a_of_type_Int = getIntent().getIntExtra("key_appType", 0);
    paramBundle = (MiniAppOptions)getIntent().getParcelableExtra("key_options");
    localObject = new armq();
    ((armq)localObject).jdField_a_of_type_Int = 2;
    ((armq)localObject).jdField_a_of_type_Boolean = true;
    ((armq)localObject).jdField_a_of_type_ArrayOfJavaLangObject = new Object[] { this, this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), paramBundle };
    sgi.a().dispatch("MiniAppManager", (Dispatcher.Dispatchable)localObject);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    armq localarmq = new armq();
    localarmq.jdField_a_of_type_Int = 3;
    localarmq.jdField_a_of_type_Boolean = true;
    localarmq.jdField_a_of_type_ArrayOfJavaLangObject = new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int) };
    sgi.a().dispatch("MiniAppManager", localarmq);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    moveTaskToBack(true);
    overridePendingTransition(2130772278, 2130771990);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.ui.MiniAppActivity
 * JD-Core Version:    0.7.0.1
 */