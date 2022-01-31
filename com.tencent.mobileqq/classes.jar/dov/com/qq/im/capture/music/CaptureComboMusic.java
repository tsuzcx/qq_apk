package dov.com.qq.im.capture.music;

import android.app.Activity;
import anug;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboBase;
import dov.com.qq.im.capture.view.MusicProviderView;

public class CaptureComboMusic
  extends CaptureComboBase
{
  public MusicItemInfo a;
  MusicDownloadListener a;
  int c;
  
  public CaptureComboMusic(int paramInt)
  {
    super(null);
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener = new anug(this);
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = ((QIMMusicConfigManager)QIMManager.a(2)).b(paramInt);
  }
  
  public float a()
  {
    try
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.jdField_c_of_type_Int;
      float f = 1.0F * i / 100.0F;
      return f;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a()
  {
    int i = 3;
    for (;;)
    {
      boolean bool;
      try
      {
        MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
        if (localMusicItemInfo == null) {
          return i;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.jdField_c_of_type_Int > -1)
        {
          int j = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.jdField_c_of_type_Int;
          if (j == 100) {
            continue;
          }
          i = 1;
          continue;
        }
      }
      finally {}
      try
      {
        bool = FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a());
        if (bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        continue;
      }
      i = 2;
    }
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo.Music", 2, "applyMusic" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) {}
    do
    {
      return 0;
      paramActivity = (MusicProviderView)paramActivity.findViewById(2131362423);
    } while (paramActivity == null);
    MusicItemInfo localMusicItemInfo = ((QimMusicPlayer)QIMManager.a().c(8)).b();
    if ((MusicProviderView.a) && (localMusicItemInfo != null) && (localMusicItemInfo.a != this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a) && (localMusicItemInfo.d == 5))
    {
      paramActivity.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      return 0;
    }
    paramActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    return 0;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) {}
    while ((paramInt == 1) || (paramInt == 3)) {
      return;
    }
    ((QimMusicPlayer)QIMManager.a().c(8)).a(paramInt);
  }
  
  public int b()
  {
    int j = 3;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.i("MusicProviderView.Downloader", 2, "download STATE_DOWNLOADED" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
            i = j;
          }
          return i;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.jdField_c_of_type_Int > -1)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MusicProviderView.Downloader", 2, "download mMusic.mProgress" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.jdField_c_of_type_Int);
          }
        }
        else
        {
          if (!FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a()))
          {
            if (QLog.isColorLevel()) {
              QLog.i("MusicProviderView.Downloader", 2, "download ." + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.jdField_c_of_type_Int);
            }
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.jdField_c_of_type_Int = 1;
            QimMusicDownloader.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.a(), this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener);
            a();
            i = 2;
            continue;
          }
          i = j;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("MusicProviderView.Downloader", 2, "STATE_DOWNLOADED ." + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.jdField_c_of_type_Int);
          i = j;
          continue;
        }
        int i = 1;
      }
      finally {}
    }
  }
  
  public void c(Activity paramActivity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) {}
    while ((paramInt == 1) || (paramInt == 3)) {
      return;
    }
    ((QimMusicPlayer)QIMManager.a().c(8)).d();
  }
  
  public String toString()
  {
    return "Music@" + this.jdField_c_of_type_Int + "@" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.CaptureComboMusic
 * JD-Core Version:    0.7.0.1
 */