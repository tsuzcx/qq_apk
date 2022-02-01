package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.view.SurfaceHolder;
import android.view.View;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparingListener;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import mqq.os.MqqHandler;

public class TvkVideoViewHelper
  implements FileTransferManager.Callback, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnVideoPreparingListener, IVideoViewBase.IVideoViewCallBack
{
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TvkVideoViewHelper.OnCompleteListener jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewTvkVideoViewHelper$OnCompleteListener;
  private TvkVideoViewHelper.OnErrorListener jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewTvkVideoViewHelper$OnErrorListener;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean;
  
  public void OnDownloadCallback(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "OnDownloadCallback " + paramString);
    }
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "handleMessage");
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewTvkVideoViewHelper$OnCompleteListener != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewTvkVideoViewHelper$OnCompleteListener.a();
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramTVK_IMediaPlayer = "onError sdkError : " + paramInt1 + "  sdkDetailError : " + paramInt2 + "s:" + paramString;
    if (QLog.isColorLevel()) {
      QLog.e("TvkVideoViewHelper", 2, paramTVK_IMediaPlayer);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewTvkVideoViewHelper$OnErrorListener != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewTvkVideoViewHelper$OnErrorListener.a(paramTVK_IMediaPlayer);
    }
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "onInfo");
    }
    return false;
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "onNetVideoInfo");
    }
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "onSurfaceChanged");
    }
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "onSurfaceCreated");
    }
  }
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "onSurfaceDestory");
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new TvkVideoViewHelper.1(this));
    }
  }
  
  public void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TvkVideoViewHelper", 2, "onVideoPreparing");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.TvkVideoViewHelper
 * JD-Core Version:    0.7.0.1
 */