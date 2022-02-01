package com.tencent.mobileqq.richmediabrowser.model;

import android.content.Context;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView;

class AIOFileVideoModel$1
  implements FMDialogUtil.FMDialogInterface
{
  AIOFileVideoModel$1(AIOFileVideoModel paramAIOFileVideoModel, Context paramContext, AIOFileVideoData paramAIOFileVideoData, AIOFileVideoView paramAIOFileVideoView) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFileVideoData;
      if (localAIOFileVideoData != null)
      {
        AIOFileVideoView localAIOFileVideoView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOFileVideoView;
        if (localAIOFileVideoView != null)
        {
          localAIOFileVideoData.g = true;
          localAIOFileVideoView.m();
        }
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoModel.1
 * JD-Core Version:    0.7.0.1
 */