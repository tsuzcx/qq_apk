package dov.com.tencent.mobileqq.activity.richmedia;

import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.AudioPlayerListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.FileUtils;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import dov.com.qq.im.capture.music.MusicDownloadListener;
import dov.com.qq.im.capture.music.QQMusicDownloader;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayerExport;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class QzoneEditTopic
  extends EditVideoPart
{
  private View jdField_a_of_type_AndroidViewView;
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer;
  private final AudioPlayerBase.AudioPlayerListener jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener = new QzoneEditTopic.2(this);
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private QzoneVerticalVideoTopicInfo jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  private MusicDownloadListener jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener = new QzoneEditTopic.1(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public QzoneEditTopic(QzEditVideoPartManager paramQzEditVideoPartManager, QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo)
  {
    super(paramQzEditVideoPartManager);
    this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = paramQzoneVerticalVideoTopicInfo;
  }
  
  private void a(MusicItemInfo paramMusicItemInfo)
  {
    paramMusicItemInfo = QQMusicDownloader.a(paramMusicItemInfo.mUrl, paramMusicItemInfo.getLocalPath(), this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener);
    if (paramMusicItemInfo != null) {
      QQMusicDownloader.a(paramMusicItemInfo, this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener);
    }
  }
  
  private boolean a(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo == null) {}
    while (((paramMusicItemInfo.mType == 5) || (paramMusicItemInfo.mType == 1)) && (!FileUtils.b(paramMusicItemInfo.getLocalPath()))) {
      return false;
    }
    return true;
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if (this.b) {}
    do
    {
      return;
      i();
    } while ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer == null) || (paramMusicItemInfo == null) || (!a(paramMusicItemInfo)));
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.b(7);
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.a(paramMusicItemInfo.getLocalPath());
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131562417, null);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380639)).setText(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getDescName());
    Object localObject = (URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369746);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getThumbImgUrl())) {
      ((URLImageView)localObject).setBackgroundURL(this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getThumbImgUrl());
    }
    for (;;)
    {
      localObject = (RelativeLayout)a(2131366183);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = AIOUtils.a(110.0F, a());
      localLayoutParams.leftMargin = AIOUtils.a(10.0F, a());
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
      ((URLImageView)localObject).setVisibility(8);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.hasMusic())
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = new MusicItemInfo();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mSongMid = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getMusicId();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getMusicName();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mUrl = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.getMusicUrl();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mType = 1;
      EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
      if (localEditVideoPlayerExport != null) {
        localEditVideoPlayerExport.a(true);
      }
      if (a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo)) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer = new AudioPlayer(a(), this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener);
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.d(3);
    }
  }
  
  private void k()
  {
    if (this.b) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 1, 0));
    m();
    b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.d();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer = null;
    }
  }
  
  public void a()
  {
    super.a();
    c();
    d();
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath())))
    {
      paramGenerateContext.a.backgroundMusicPath = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath();
      paramGenerateContext.a.isMuteRecordVoice = true;
      paramGenerateContext.a.backgroundMusicOffset = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
      paramGenerateContext.a.backgroundMusicDuration = ((int)ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath()));
      if (paramGenerateContext.a.backgroundMusicDuration <= 0) {
        paramGenerateContext.a.backgroundMusicPath = null;
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      break;
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidViewView == null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    } while (this.jdField_a_of_type_AndroidViewView == null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      m();
      b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
  }
  
  public void aM_()
  {
    this.b = true;
    super.aM_();
    m();
  }
  
  public void f()
  {
    this.b = false;
    super.f();
    if (this.jdField_a_of_type_Boolean) {
      k();
    }
  }
  
  public void g()
  {
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditTopic
 * JD-Core Version:    0.7.0.1
 */