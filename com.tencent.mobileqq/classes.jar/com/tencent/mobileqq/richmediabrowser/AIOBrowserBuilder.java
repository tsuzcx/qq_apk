package com.tencent.mobileqq.richmediabrowser;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.core.IBrowserBuilder;

public class AIOBrowserBuilder
  implements IBrowserBuilder
{
  private Context jdField_a_of_type_AndroidContentContext;
  private AIOBrowserModel jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel;
  private AIOBrowserPresenter jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
  private AIOBrowserScene jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene;
  private BrowserParamsBuilder jdField_a_of_type_ComTencentRichmediabrowserApiBrowserParamsBuilder;
  
  public AIOBrowserBuilder(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public AIOBrowserPresenter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
  }
  
  public void a(BrowserParamsBuilder paramBrowserParamsBuilder)
  {
    this.jdField_a_of_type_ComTencentRichmediabrowserApiBrowserParamsBuilder = paramBrowserParamsBuilder;
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
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.setParamsBuilder(this.jdField_a_of_type_ComTencentRichmediabrowserApiBrowserParamsBuilder);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene = new AIOBrowserScene(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel = new AIOBrowserModel(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel);
  }
  
  public void buildView()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.buildView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOBrowserBuilder
 * JD-Core Version:    0.7.0.1
 */