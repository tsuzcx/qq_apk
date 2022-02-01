package com.tencent.mobileqq.richmediabrowser.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOPicturePresenter;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class AIOPictureView$7
  implements DialogInterface.OnClickListener
{
  AIOPictureView$7(AIOPictureView paramAIOPictureView, int paramInt, Object paramObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Int != 100)
    {
      paramDialogInterface = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showSaveFileTips type = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      paramDialogInterface.d("AIOPictureView", 4, localStringBuilder.toString());
      return;
    }
    if ((this.jdField_a_of_type_JavaLangObject instanceof AIOPictureData))
    {
      AIOPictureView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView).a((AIOPictureData)this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.7
 * JD-Core Version:    0.7.0.1
 */