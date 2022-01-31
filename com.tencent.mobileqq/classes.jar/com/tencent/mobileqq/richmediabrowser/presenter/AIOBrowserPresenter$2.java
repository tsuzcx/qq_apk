package com.tencent.mobileqq.richmediabrowser.presenter;

import aghu;
import axyi;
import axyq;
import axzm;
import axzo;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.view.BrowserAdapter;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.page.Gallery;

public class AIOBrowserPresenter$2
  implements Runnable
{
  public AIOBrowserPresenter$2(axyq paramaxyq, long paramLong, AIOBrowserBaseData paramAIOBrowserBaseData, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBaseData.jdField_a_of_type_Long) || (this.jdField_a_of_type_Boolean))
    {
      BrowserBaseView localBrowserBaseView = this.this$0.jdField_a_of_type_Axzo.getCurrentView();
      if ((localBrowserBaseView instanceof axzm)) {
        ((axzm)localBrowserBaseView).a(this.jdField_a_of_type_Long);
      }
      aghu.a(this.this$0.jdField_a_of_type_Axzo.mActivity, this.this$0.jdField_a_of_type_Axzo.mRoot);
    }
    int i;
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Axyi.b(this.jdField_a_of_type_Long) == null)
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onRevokeMsg seq:" + this.jdField_a_of_type_Long + ", selectItem seq:" + this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBaseData.jdField_a_of_type_Long);
        return;
      }
      i = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBaseData.jdField_a_of_type_Long);
    } while ((i < 0) || (this.this$0.jdField_a_of_type_Axzo.mAdapter == null));
    this.this$0.jdField_a_of_type_Axzo.mAdapter.notifyDataSetChanged();
    this.this$0.jdField_a_of_type_Axzo.mGallery.setSelection(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter.2
 * JD-Core Version:    0.7.0.1
 */