package com.tencent.mobileqq.richmediabrowser.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOPicturePresenter;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class AIOPictureView$10
  implements DialogInterface.OnClickListener
{
  AIOPictureView$10(AIOPictureView paramAIOPictureView, int paramInt, Object paramObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "showSaveFileTips type = " + this.jdField_a_of_type_Int);
    }
    do
    {
      return;
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOPictureData));
    AIOPictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView).a((AIOPictureData)this.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.10
 * JD-Core Version:    0.7.0.1
 */