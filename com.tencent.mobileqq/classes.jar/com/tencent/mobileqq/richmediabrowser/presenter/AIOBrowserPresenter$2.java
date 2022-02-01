package com.tencent.mobileqq.richmediabrowser.presenter;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserBaseView;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class AIOBrowserPresenter$2
  implements Runnable
{
  AIOBrowserPresenter$2(AIOBrowserPresenter paramAIOBrowserPresenter, long paramLong, AIOBrowserBaseData paramAIOBrowserBaseData, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject;
    if ((this.jdField_a_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBaseData.jdField_a_of_type_Long) && (!this.jdField_a_of_type_Boolean))
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.b(this.jdField_a_of_type_Long) == null)
      {
        localObject = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRevokeMsg seq:");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append(", selectItem seq:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBaseData.jdField_a_of_type_Long);
        ((IBrowserLog)localObject).i("AIOGalleryPresenter", 2, localStringBuilder.toString());
        return;
      }
      int i = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserAIOBrowserBaseData.jdField_a_of_type_Long);
      if ((i >= 0) && (i < this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.getCount()))
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.setSelectedIndex(i);
        this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.notifyImageModelDataChanged();
      }
    }
    else
    {
      localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.a();
      if ((localObject instanceof AIOBrowserBaseView)) {
        ((AIOBrowserBaseView)localObject).a(this.jdField_a_of_type_Long);
      }
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).buildMessageRevokeUI((Activity)this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.mContext, this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.mRoot);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter.2
 * JD-Core Version:    0.7.0.1
 */