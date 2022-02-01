package com.tencent.mobileqq.richmediabrowser.presenter;

import ahrf;
import bbps;
import bbqa;
import bbqx;
import bbqz;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.view.BrowserBaseView;

public class AIOBrowserPresenter$2
  implements Runnable
{
  public AIOBrowserPresenter$2(bbqa parambbqa, long paramLong, AIOBrowserBaseData paramAIOBrowserBaseData, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBaseData.jdField_a_of_type_Long) || (this.jdField_a_of_type_Boolean))
    {
      BrowserBaseView localBrowserBaseView = this.this$0.jdField_a_of_type_Bbqz.getCurrentView();
      if ((localBrowserBaseView instanceof bbqx)) {
        ((bbqx)localBrowserBaseView).a(this.jdField_a_of_type_Long);
      }
      ahrf.a(this.this$0.jdField_a_of_type_Bbqz.mActivity, this.this$0.jdField_a_of_type_Bbqz.mRoot);
    }
    int i;
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Bbps.b(this.jdField_a_of_type_Long) == null)
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onRevokeMsg seq:" + this.jdField_a_of_type_Long + ", selectItem seq:" + this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBaseData.jdField_a_of_type_Long);
        return;
      }
      i = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBaseData.jdField_a_of_type_Long);
    } while ((i < 0) || (i >= this.this$0.jdField_a_of_type_Bbps.getCount()));
    this.this$0.jdField_a_of_type_Bbps.setSelectedIndex(i);
    this.this$0.jdField_a_of_type_Bbqz.notifyImageModelDataChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter.2
 * JD-Core Version:    0.7.0.1
 */