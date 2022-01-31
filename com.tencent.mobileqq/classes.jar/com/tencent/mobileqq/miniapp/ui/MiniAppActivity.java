package com.tencent.mobileqq.miniapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import asit;
import asiu;
import asiz;
import com.tencent.mobileqq.miniapp.MiniAppOptions;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import ste;

public class MiniAppActivity
  extends FragmentActivity
{
  protected int a;
  public asiu a;
  private MiniAppBaseFragment a;
  protected String a;
  
  public void a(MiniAppBaseFragment paramMiniAppBaseFragment)
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    localFragmentTransaction.replace(2131366662, paramMiniAppBaseFragment);
    localFragmentTransaction.commit();
    this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppBaseFragment = paramMiniAppBaseFragment;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131558448);
    paramBundle = getIntent().getExtras();
    Object localObject = new MiniAppLoadingFragment();
    ((MiniAppLoadingFragment)localObject).setArguments(paramBundle);
    a((MiniAppBaseFragment)localObject);
    asiz.a();
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("key_appid");
    this.jdField_a_of_type_Int = getIntent().getIntExtra("key_appType", 0);
    paramBundle = (MiniAppOptions)getIntent().getParcelableExtra("key_options");
    localObject = new asit();
    ((asit)localObject).jdField_a_of_type_Int = 2;
    ((asit)localObject).jdField_a_of_type_Boolean = true;
    ((asit)localObject).jdField_a_of_type_ArrayOfJavaLangObject = new Object[] { this, this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), paramBundle };
    ste.a().dispatch("MiniAppManager", (Dispatcher.Dispatchable)localObject);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    asit localasit = new asit();
    localasit.jdField_a_of_type_Int = 3;
    localasit.jdField_a_of_type_Boolean = true;
    localasit.jdField_a_of_type_ArrayOfJavaLangObject = new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int) };
    ste.a().dispatch("MiniAppManager", localasit);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    moveTaskToBack(true);
    overridePendingTransition(2130772279, 2130771990);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.ui.MiniAppActivity
 * JD-Core Version:    0.7.0.1
 */