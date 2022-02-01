package com.tencent.mobileqq.richmediabrowser.presenter;

import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserBaseView;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.view.BrowserBaseView;

class AIOBrowserPresenter$2
  implements Runnable
{
  AIOBrowserPresenter$2(AIOBrowserPresenter paramAIOBrowserPresenter, long paramLong, AIOBrowserBaseData paramAIOBrowserBaseData, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBaseData.jdField_a_of_type_Long) || (this.jdField_a_of_type_Boolean))
    {
      BrowserBaseView localBrowserBaseView = this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.getCurrentView();
      if ((localBrowserBaseView instanceof AIOBrowserBaseView)) {
        ((AIOBrowserBaseView)localBrowserBaseView).a(this.jdField_a_of_type_Long);
      }
      AIOGalleryMsgRevokeMgr.a(this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.mActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.mRoot);
    }
    int i;
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.b(this.jdField_a_of_type_Long) == null)
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onRevokeMsg seq:" + this.jdField_a_of_type_Long + ", selectItem seq:" + this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBaseData.jdField_a_of_type_Long);
        return;
      }
      i = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBaseData.jdField_a_of_type_Long);
    } while ((i < 0) || (i >= this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getCount()));
    this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.setSelectedIndex(i);
    this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.notifyImageModelDataChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter.2
 * JD-Core Version:    0.7.0.1
 */