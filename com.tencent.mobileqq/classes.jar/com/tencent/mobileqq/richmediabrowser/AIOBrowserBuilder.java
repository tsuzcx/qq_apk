package com.tencent.mobileqq.richmediabrowser;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.richmediabrowser.core.IBrowserBuilder;

public class AIOBrowserBuilder
  implements IBrowserBuilder
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private AIOBrowserModel jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel;
  private AIOBrowserPresenter jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
  private AIOBrowserScene jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene;
  
  public AIOBrowserBuilder(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public AIOBrowserPresenter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.onWindowFocusChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.onBackEvent();
    }
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.onKeyDown(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.onStart();
    }
  }
  
  public void buildComplete()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.buildComplete();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.buildComplete();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.buildComplete();
  }
  
  public void buildModel()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.buildModel();
  }
  
  public void buildParams(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.buildParams(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.buildParams(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.buildParams(paramIntent);
  }
  
  public void buildPresenter()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter = new AIOBrowserPresenter();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene = new AIOBrowserScene(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel = new AIOBrowserModel(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.buildView(paramViewGroup);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.onResume();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.onPause();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOBrowserBuilder
 * JD-Core Version:    0.7.0.1
 */