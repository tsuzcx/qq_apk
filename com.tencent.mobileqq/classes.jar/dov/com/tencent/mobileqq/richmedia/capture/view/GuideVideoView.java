package dov.com.tencent.mobileqq.richmedia.capture.view;

import afsn;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import bpnu;
import bpnv;
import bpnw;
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
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class GuideVideoView
  extends LinearLayout
  implements afsn, View.OnClickListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnVideoPreparingListener, IVideoViewBase.IVideoViewCallBack
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bpnu jdField_a_of_type_Bpnu;
  private bpnv jdField_a_of_type_Bpnv;
  private bpnw jdField_a_of_type_Bpnw;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  protected FadedButton a;
  private List<String> jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean;
  private FadedButton jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewFadedButton;
  boolean jdField_b_of_type_Boolean;
  boolean c;
  
  public void OnDownloadCallback(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "OnDownloadCallback " + paramString);
    }
  }
  
  public void a()
  {
    if (!this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "hasn't opening URL, now prepare");
      }
      b();
    }
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "handleMessage");
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "ERROR : mVideoProxyFactory is null");
        }
        return;
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(getContext(), (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnNetVideoInfoListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparingListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
    }
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
    localTVK_PlayerVideoInfo.setPlayType(2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_capture_guide");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(getContext(), (String[])this.jdField_a_of_type_JavaUtilList.toArray(new String[0]), 0L, 0L, localTVK_PlayerVideoInfo, null);
    this.c = true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewFadedButton) {
      if (this.jdField_a_of_type_Bpnu != null) {
        this.jdField_a_of_type_Bpnu.a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewFadedButton)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewFadedButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "has prepared, now start");
          }
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
        }
        else if (!this.c)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "hasn't opening URL, now prepare video");
          }
          a();
        }
      }
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (this.jdField_a_of_type_Bpnv != null) {
      this.jdField_a_of_type_Bpnv.a();
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (this.jdField_a_of_type_Bpnw != null) {
      this.jdField_a_of_type_Bpnw.a("onError sdkError : " + paramInt1 + "  sdkDetailError : " + paramInt2);
    }
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "onInfo");
    }
    return false;
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "onNetVideoInfo");
    }
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "onSurfaceChanged");
    }
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "onSurfaceCreated");
    }
  }
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "onSurfaceDestory");
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new GuideVideoView.1(this));
    }
  }
  
  public void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "onVideoPreparing");
    }
  }
  
  public void setOnCloseListener(bpnu parambpnu)
  {
    this.jdField_a_of_type_Bpnu = parambpnu;
  }
  
  public void setOnCompleteListener(bpnv parambpnv)
  {
    this.jdField_a_of_type_Bpnv = parambpnv;
  }
  
  public void setOnErrorListener(bpnw parambpnw)
  {
    this.jdField_a_of_type_Bpnw = parambpnw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.GuideVideoView
 * JD-Core Version:    0.7.0.1
 */