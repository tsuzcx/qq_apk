package com.tencent.mobileqq.richmediabrowser.presenter;

import ahsa;
import bawp;
import bawx;
import baxu;
import baxw;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.view.BrowserBaseView;

public class AIOBrowserPresenter$2
  implements Runnable
{
  public AIOBrowserPresenter$2(bawx parambawx, long paramLong, AIOBrowserBaseData paramAIOBrowserBaseData, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBaseData.jdField_a_of_type_Long) || (this.jdField_a_of_type_Boolean))
    {
      BrowserBaseView localBrowserBaseView = this.this$0.jdField_a_of_type_Baxw.getCurrentView();
      if ((localBrowserBaseView instanceof baxu)) {
        ((baxu)localBrowserBaseView).a(this.jdField_a_of_type_Long);
      }
      ahsa.a(this.this$0.jdField_a_of_type_Baxw.mActivity, this.this$0.jdField_a_of_type_Baxw.mRoot);
    }
    int i;
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_Bawp.b(this.jdField_a_of_type_Long) == null)
      {
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onRevokeMsg seq:" + this.jdField_a_of_type_Long + ", selectItem seq:" + this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBaseData.jdField_a_of_type_Long);
        return;
      }
      i = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBaseData.jdField_a_of_type_Long);
    } while ((i < 0) || (i >= this.this$0.jdField_a_of_type_Bawp.getCount()));
    this.this$0.jdField_a_of_type_Bawp.setSelectedIndex(i);
    this.this$0.jdField_a_of_type_Baxw.notifyImageModelDataChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter.2
 * JD-Core Version:    0.7.0.1
 */