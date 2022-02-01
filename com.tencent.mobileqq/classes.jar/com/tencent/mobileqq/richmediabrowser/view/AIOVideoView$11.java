package com.tencent.mobileqq.richmediabrowser.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOVideoPresenter;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class AIOVideoView$11
  implements DialogInterface.OnClickListener
{
  AIOVideoView$11(AIOVideoView paramAIOVideoView, int paramInt, Object paramObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showSaveFileTips type = " + this.jdField_a_of_type_Int);
    }
    do
    {
      return;
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOVideoData));
    paramDialogInterface = (AIOVideoData)this.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.a.a(paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.a.a(paramDialogInterface.jdField_a_of_type_Long, paramDialogInterface.jdField_a_of_type_Int, 2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.11
 * JD-Core Version:    0.7.0.1
 */