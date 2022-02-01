package dov.com.qq.im.capture.music;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import bkgm;
import bomy;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;

public class QQMusicPlayerScene
  extends bomy
  implements Handler.Callback
{
  bkgm jdField_a_of_type_Bkgm = new bkgm(Looper.getMainLooper(), this);
  private Timer jdField_a_of_type_JavaUtilTimer;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  private boolean jdField_a_of_type_Boolean = true;
  
  public void a()
  {
    int i = -1;
    String str = "";
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Int = -1;
        StringBuilder localStringBuilder = new StringBuilder("startMusic");
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(3);
          str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration < this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd)
          {
            localStringBuilder.append(" music format no correct musicName=").append(str);
            localStringBuilder.append(" musicDuration=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration);
            localStringBuilder.append(" musicEnd=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart = 0;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd <= this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart)
          {
            localStringBuilder.append(" musicEnd <= musicStart don't play music musicName=").append(str);
            localStringBuilder.append(" musicEnd=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
            localStringBuilder.append(" musicStart=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart);
            localStringBuilder.append("\n");
            if (QLog.isColorLevel()) {
              QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
            }
            a(-1, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
            return;
          }
          j = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
          a(j, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd - this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart, i);
          localStringBuilder.append(" musicName=").append(str);
          localStringBuilder.append(" position=").append(j);
          localStringBuilder.append(" timer=").append(i);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
          continue;
        }
        int j = -1;
      }
      finally {}
    }
  }
  
  public void a(int paramInt)
  {
    h();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimerTask = new QQMusicPlayerScene.MyMusicTimerTask(this, null);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_JavaUtilTimerTask, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicPlayerScene", 2, "setMyMusicTimer");
    }
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase) {}
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.postImmediately(new QQMusicPlayerScene.1(this, paramString, paramInt1, paramInt2), null, true);
  }
  
  public void b()
  {
    int i = -1;
    String str = "";
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder("resumeMusic");
        this.jdField_a_of_type_Boolean = true;
        if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a()) && (this.jdField_a_of_type_Int != -1))
        {
          str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
          if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd)
          {
            localStringBuilder.append(" mCurrentPosition>=musicEnd reset musicName").append(str);
            localStringBuilder.append(" mCurrentPosition=").append(this.jdField_a_of_type_Int);
            localStringBuilder.append(" musicEnd").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
            this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd - this.jdField_a_of_type_Int;
          if (i <= 0)
          {
            a(-1, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
            localStringBuilder.append("resumeMusic music info musicEnd <= musicStart don't play music");
            if (QLog.isColorLevel()) {
              QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
            }
            return;
          }
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath(), this.jdField_a_of_type_Int, i);
          j = this.jdField_a_of_type_Int;
          b(j, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          localStringBuilder.append(" musicName=").append(str);
          localStringBuilder.append(" position=").append(j);
          localStringBuilder.append(" timer=").append(i);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
          continue;
        }
        int j = -1;
      }
      finally {}
    }
  }
  
  public void c()
  {
    int i = -1;
    String str = "";
    try
    {
      this.jdField_a_of_type_Boolean = false;
      StringBuilder localStringBuilder = new StringBuilder("pauseMusic");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a())
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
        i = this.jdField_a_of_type_Int;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) {
        str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      h();
      c(i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      localStringBuilder.append(" musicName=").append(str);
      localStringBuilder.append(" position=").append(i);
      if (QLog.isColorLevel()) {
        QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public void d()
  {
    int i = -1;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Int = -1;
        String str = "";
        this.jdField_a_of_type_Boolean = true;
        StringBuilder localStringBuilder = new StringBuilder("replayMusic");
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null))
        {
          str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(3);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration < this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd)
          {
            localStringBuilder.append(" music format no correct musicName=").append(str);
            localStringBuilder.append(" musicDuration=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration);
            localStringBuilder.append(" musicEnd=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart = 0;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd <= this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart)
          {
            a(-1, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
            if (QLog.isColorLevel()) {
              QLog.d("QQMusicPlayerScene", 2, "replayMusic music info musicEnd <= musicStart don't play music");
            }
            return;
          }
          j = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd - this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
          if (a()) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
          }
          d(j, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart, i);
          localStringBuilder.append(" musicName=").append(str);
          localStringBuilder.append(" position=").append(j);
          localStringBuilder.append(" timer=").append(i);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
          continue;
        }
        int j = -1;
      }
      finally {}
    }
  }
  
  public void e()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      String str = "";
      h();
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
      }
      super.e();
      if (QLog.isColorLevel()) {
        QLog.d("QQMusicPlayerScene", 2, "QQMusicPlayerScene stopMusic musicName=" + str);
      }
      return;
    }
    finally {}
  }
  
  public void f()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      h();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
      super.f();
      if (QLog.isColorLevel()) {
        QLog.d("QQMusicPlayerScene", 2, "QQMusicPlayerScene destroy");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_JavaUtilTimerTask != null)
    {
      this.jdField_a_of_type_JavaUtilTimerTask.cancel();
      this.jdField_a_of_type_JavaUtilTimerTask = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicPlayerScene", 2, "cancelMyMusicTimer");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("QQMusicPlayerScene", 2, "handleMessage MSG_MUSIC_REPLAY isNeedPlay=" + this.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Boolean) {
        d();
      } else {
        e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QQMusicPlayerScene
 * JD-Core Version:    0.7.0.1
 */