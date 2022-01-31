package dov.com.qq.im.capture.music;

import amvp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayer.AudioPlayerListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class MusicPlayerScene
  implements AudioPlayer.AudioPlayerListener
{
  protected int a;
  private long a;
  public AudioPlayer a;
  protected MusicItemInfo a;
  protected List a;
  
  public MusicPlayerScene()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(BaseApplicationImpl.getApplication(), this);
  }
  
  public int a()
  {
    int i = -1;
    if (a()) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
    }
    return i;
  }
  
  public void a()
  {
    int j = -1;
    try
    {
      this.jdField_a_of_type_Int = -1;
      StringBuilder localStringBuilder = new StringBuilder("startMusic");
      String str2 = "";
      String str1 = str2;
      int i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
      {
        str1 = str2;
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
        {
          str1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(3);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e < 0)
          {
            localStringBuilder.append(" musicStart=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e = 0;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e;
          a(i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e + (int)this.jdField_a_of_type_Long);
        }
      }
      localStringBuilder.append(" musicName=").append(str1);
      localStringBuilder.append(" position=").append(i);
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramMusicItemInfo = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((MusicPlayerSceneListener)paramMusicItemInfo.next()).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) {
      this.jdField_a_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e + (int)this.jdField_a_of_type_Long);
    }
  }
  
  public void a(AudioPlayer paramAudioPlayer)
  {
    b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    d();
    if (QLog.isColorLevel()) {
      QLog.d("MusicPlayerScene", 2, "MusicPlayerScene onCompletion");
    }
  }
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
      this.jdField_a_of_type_Int = paramMusicItemInfo.e;
      return;
    }
    finally
    {
      paramMusicItemInfo = finally;
      throw paramMusicItemInfo;
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    ThreadManager.postImmediately(new amvp(this, paramString, paramInt), null, true);
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a());
  }
  
  public void b()
  {
    int j = -1;
    String str2 = "";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("resumeMusic");
      String str1 = str2;
      int i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
      {
        str1 = str2;
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
        {
          str1 = str2;
          i = j;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a())
          {
            str1 = str2;
            i = j;
            if (this.jdField_a_of_type_Int != -1)
            {
              str1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a;
              a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a(), this.jdField_a_of_type_Int);
              i = this.jdField_a_of_type_Int;
            }
          }
        }
      }
      b(i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      localStringBuilder.append(" musicName=").append(str1);
      localStringBuilder.append(" position=").append(i);
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  protected void b(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramMusicItemInfo = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((MusicPlayerSceneListener)paramMusicItemInfo.next()).c(paramInt, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
    }
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  protected void b(MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramMusicItemInfo = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((MusicPlayerSceneListener)paramMusicItemInfo.next()).b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
    }
  }
  
  public void c()
  {
    int i = -1;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("pauseMusic");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a())
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
        i = this.jdField_a_of_type_Int;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      c(i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      localStringBuilder.append(" musicName=").append("");
      localStringBuilder.append(" position=").append(i);
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  protected void c(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramMusicItemInfo = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((MusicPlayerSceneListener)paramMusicItemInfo.next()).d(paramInt, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
    }
  }
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void d()
  {
    int j = -1;
    try
    {
      this.jdField_a_of_type_Int = -1;
      StringBuilder localStringBuilder = new StringBuilder("startMusic");
      String str2 = "";
      String str1 = str2;
      int i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
      {
        str1 = str2;
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
        {
          str1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(3);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e < 0)
          {
            localStringBuilder.append(" musicStart=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e = 0;
          }
          if (a()) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
          }
          i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e;
          d(i, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e);
        }
      }
      localStringBuilder.append(" musicName=").append(str1);
      localStringBuilder.append(" position=").append(i);
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  protected void d(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramMusicItemInfo = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramMusicItemInfo.hasNext()) {
        ((MusicPlayerSceneListener)paramMusicItemInfo.next()).b(paramInt, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
    }
  }
  
  public void e()
  {
    try
    {
      this.jdField_a_of_type_Int = -1;
      String str = "";
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
      }
      g();
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, "MusicPlayerScene stopMusic musicName=" + str);
      }
      return;
    }
    finally {}
  }
  
  public void f()
  {
    try
    {
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
      this.jdField_a_of_type_JavaUtilList = null;
      if (QLog.isColorLevel()) {
        QLog.d("MusicPlayerScene", 2, "MusicPlayerScene destroy");
      }
      return;
    }
    finally {}
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((MusicPlayerSceneListener)localIterator.next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.MusicPlayerScene
 * JD-Core Version:    0.7.0.1
 */