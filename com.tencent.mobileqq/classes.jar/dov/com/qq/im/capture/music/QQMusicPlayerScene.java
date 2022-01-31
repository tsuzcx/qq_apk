package dov.com.qq.im.capture.music;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import anuq;
import anur;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.Timer;
import java.util.TimerTask;

public class QQMusicPlayerScene
  extends MusicPlayerScene
  implements Handler.Callback
{
  public WeakReferenceHandler a;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  private boolean jdField_a_of_type_Boolean = true;
  
  public QQMusicPlayerScene()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
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
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(3);
          str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a;
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.g < this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.f)
          {
            localStringBuilder.append(" music format no correct musicName=").append(str);
            localStringBuilder.append(" musicDuration=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.g);
            localStringBuilder.append(" musicEnd=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.f);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e = 0;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.f = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.g;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.f <= this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e)
          {
            localStringBuilder.append(" musicEnd <= musicStart don't play music musicName=").append(str);
            localStringBuilder.append(" musicEnd=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.f);
            localStringBuilder.append(" musicStart=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e);
            localStringBuilder.append("\n");
            if (QLog.isColorLevel()) {
              QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
            }
            a(-1, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
            return;
          }
          j = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e;
          a(j, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.f - this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e;
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e, i);
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
    this.jdField_a_of_type_JavaUtilTimerTask = new anur(this, null);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_JavaUtilTimerTask, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicPlayerScene", 2, "setMyMusicTimer");
    }
  }
  
  public void a(AudioPlayer paramAudioPlayer) {}
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.postImmediately(new anuq(this, paramString, paramInt1, paramInt2), null, true);
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
          str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a;
          if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.f)
          {
            localStringBuilder.append(" mCurrentPosition>=musicEnd reset musicName").append(str);
            localStringBuilder.append(" mCurrentPosition=").append(this.jdField_a_of_type_Int);
            localStringBuilder.append(" musicEnd").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.f);
            this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.f - this.jdField_a_of_type_Int;
          if (i <= 0)
          {
            a(-1, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
            localStringBuilder.append("resumeMusic music info musicEnd <= musicStart don't play music");
            if (QLog.isColorLevel()) {
              QLog.d("QQMusicPlayerScene", 2, localStringBuilder.toString());
            }
            return;
          }
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a(), this.jdField_a_of_type_Int, i);
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
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
        i = this.jdField_a_of_type_Int;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) {
        str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a;
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
          str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(3);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.g < this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.f)
          {
            localStringBuilder.append(" music format no correct musicName=").append(str);
            localStringBuilder.append(" musicDuration=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.g);
            localStringBuilder.append(" musicEnd=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.f);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e = 0;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.f = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.g;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.f <= this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e)
          {
            a(-1, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
            if (QLog.isColorLevel()) {
              QLog.d("QQMusicPlayerScene", 2, "replayMusic music info musicEnd <= musicStart don't play music");
            }
            return;
          }
          j = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e;
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.f - this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e;
          if (a()) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
          }
          d(j, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e, i);
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
        str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QQMusicPlayerScene
 * JD-Core Version:    0.7.0.1
 */