package com.tencent.mobileqq.richmediabrowser.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOVideoPresenter;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class AIOVideoView$9
  implements DialogInterface.OnClickListener
{
  AIOVideoView$9(AIOVideoView paramAIOVideoView, int paramInt, Object paramObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Int != 101)
    {
      paramDialogInterface = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showSaveFileTips type = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      paramDialogInterface.d("AIOVideoView", 4, localStringBuilder.toString());
      return;
    }
    paramDialogInterface = this.jdField_a_of_type_JavaLangObject;
    if ((paramDialogInterface instanceof AIOVideoData))
    {
      paramDialogInterface = (AIOVideoData)paramDialogInterface;
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.a.a(paramDialogInterface);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.a.a(paramDialogInterface.jdField_a_of_type_Long, paramDialogInterface.jdField_a_of_type_Int, 7);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.9
 * JD-Core Version:    0.7.0.1
 */