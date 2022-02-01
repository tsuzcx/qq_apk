package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.app.ThreadManager;
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

public class BlankVideoPlayer
  extends LinearLayout
  implements Callback, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnVideoPreparingListener, IVideoViewBase.IVideoViewCallBack
{
  private GuideVideoView.OnCloseListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView$OnCloseListener;
  private GuideVideoView.OnCompleteListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView$OnCompleteListener;
  private GuideVideoView.OnErrorListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView$OnErrorListener;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  boolean jdField_a_of_type_Boolean = false;
  
  public BlankVideoPlayer(Context paramContext)
  {
    super(paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("BlankVideoPlayer", 2, "new BlankVideoPlayer");
    }
  }
  
  public void OnDownloadCallback(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnDownloadCallback ");
      localStringBuilder.append(paramString);
      QLog.d("BlankVideoPlayer", 2, localStringBuilder.toString());
    }
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlankVideoPlayer", 2, "handleMessage");
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    paramTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView$OnCompleteListener;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.a();
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView$OnErrorListener;
    if (paramTVK_IMediaPlayer != null)
    {
      paramString = new StringBuilder();
      paramString.append("onError sdkError : ");
      paramString.append(paramInt1);
      paramString.append("  sdkDetailError : ");
      paramString.append(paramInt2);
      paramTVK_IMediaPlayer.a(paramString.toString());
    }
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlankVideoPlayer", 2, "onInfo");
    }
    return false;
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlankVideoPlayer", 2, "onNetVideoInfo");
    }
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlankVideoPlayer", 2, "onSurfaceChanged");
    }
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlankVideoPlayer", 2, "onSurfaceCreated");
    }
  }
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlankVideoPlayer", 2, "onSurfaceDestory");
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.d("BlankVideoPlayer", 2, "onVideoPrepared");
    ThreadManager.getUIHandler().post(new BlankVideoPlayer.1(this));
  }
  
  public void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlankVideoPlayer", 2, "onVideoPreparing");
    }
  }
  
  public void setOnCloseListener(GuideVideoView.OnCloseListener paramOnCloseListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView$OnCloseListener = paramOnCloseListener;
  }
  
  public void setOnCompleteListener(GuideVideoView.OnCompleteListener paramOnCompleteListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView$OnCompleteListener = paramOnCompleteListener;
  }
  
  public void setOnErrorListener(GuideVideoView.OnErrorListener paramOnErrorListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView$OnErrorListener = paramOnErrorListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.BlankVideoPlayer
 * JD-Core Version:    0.7.0.1
 */