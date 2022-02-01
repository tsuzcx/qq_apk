package com.tencent.mobileqq.richmediabrowser.view;

import android.graphics.Bitmap;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.photo.VideoPlayMedioInfo;
import com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.BrowserDanmakuUtils;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOVideoPresenter;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;

class AIOVideoView$2
  implements VideoPlayerCallback
{
  AIOVideoView$2(AIOVideoView paramAIOVideoView, VideoPlayParam paramVideoPlayParam) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOVideoView", 0, "onCapFrame, id:" + paramLong + ", isSuccess:" + paramBoolean + ", w:" + paramInt1 + ", h:" + paramInt2);
    }
    AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView, paramBitmap);
  }
  
  public void onDownloadComplete(long paramLong)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onDownloadComplete");
    VideoPlayMedioInfo localVideoPlayMedioInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.a());
    if (localVideoPlayMedioInfo != null) {
      localVideoPlayMedioInfo.a = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(2003, 0L);
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onFirstFrameRendered, id:" + paramLong);
    }
    AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView, paramLong, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
  }
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().e("AIOVideoView", 1, "onPlayError, id = " + paramLong + " ,module = " + paramInt1 + " , errorType = " + paramInt2 + ", errCode = " + paramInt3 + " , exInfo = " + paramString);
    AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView, paramInt1, paramInt3, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView, paramLong2);
    int i = (int)(paramLong2 / this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs() * 10000.0D);
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onPlayProgress, id = " + paramLong1 + " , position = " + paramLong2 + " , progress = " + i);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(paramLong2));
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onStateChange , state = " + paramInt + ", msgUniseq=" + paramLong);
    }
    switch (paramInt)
    {
    case 7: 
    default: 
    case 4: 
      Object localObject;
      do
      {
        do
        {
          return;
          AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView, 5);
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.updateUI();
          if (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mIsMute) {
            AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView);
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.a();
          if (localObject != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(((AIOVideoData)localObject).a);
            this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(((AIOVideoData)localObject).a, false);
          }
        } while (!this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getCurrentPosition()));
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a();
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedItem();
      } while ((localObject == null) || (!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData)) || (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null));
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().a(BrowserDanmakuUtils.a(((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).d, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a));
      return;
    case 8: 
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs()));
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
      AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView, 0);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.updateUI();
      return;
    case 9: 
      AIOVideoView.b(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView);
      return;
    case 6: 
      AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView, 6);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.updateUI();
      return;
    }
    AIOVideoView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView, 3);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOVideoView.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.2
 * JD-Core Version:    0.7.0.1
 */