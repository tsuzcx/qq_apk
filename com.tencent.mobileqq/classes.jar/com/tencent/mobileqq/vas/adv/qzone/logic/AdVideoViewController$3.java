package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

class AdVideoViewController$3
  implements VideoPlayerCallback
{
  AdVideoViewController$3(AdVideoViewController paramAdVideoViewController, AlumBasicData paramAlumBasicData, BaseVideoView paramBaseVideoView) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if (localObject != null) {
      paramLong1 = ((BaseVideoView)localObject).getCurPlayingPos();
    } else {
      paramLong1 = 0L;
    }
    AdVideoViewController.b(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController);
    if (AdVideoViewController.a(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController) != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController;
      AdVideoViewController.a((AdVideoViewController)localObject, AdVideoViewController.a((AdVideoViewController)localObject), paramLong1, 0, 3, true, this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData.mVideoReportUrl);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdVideoView", 0, "onLoopBack ");
    }
  }
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if (paramString != null) {
      paramLong = paramString.getCurPlayingPos();
    } else {
      paramLong = 0L;
    }
    if (AdVideoViewController.a(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController) != null)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController;
      AdVideoViewController.a(paramString, AdVideoViewController.a(paramString), paramLong, 3, 3, false, this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData.mVideoReportUrl);
    }
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    AdVideoViewController.a(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController, paramLong2);
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStateChange , state = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", msgUniseq=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("time ");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("AdVideoView", 0, ((StringBuilder)localObject).toString());
    }
    if (paramInt != 4)
    {
      if (paramInt != 6) {
        return;
      }
      if (AdVideoViewController.a(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController) != null) {
        AdVideoViewController.a(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController).setVisibility(0);
      }
      if (AdVideoViewController.a(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController))
      {
        AdVideoViewController.a(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController, false);
        paramInt = 2;
      }
      else
      {
        paramInt = 3;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController;
        AdVideoViewController.a((AdVideoViewController)localObject, AdVideoViewController.a((AdVideoViewController)localObject), AdVideoViewController.a(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController), 0, paramInt, false, this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData.mVideoReportUrl);
      }
    }
    else
    {
      if (AdVideoViewController.a(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController) != null) {
        AdVideoViewController.a(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController).setVisibility(8);
      }
      if (AdVideoViewController.b(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController) != null) {
        AdVideoViewController.b(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController).setVisibility(8);
      }
      AdVideoViewController.b(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdVideoViewController, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController.3
 * JD-Core Version:    0.7.0.1
 */