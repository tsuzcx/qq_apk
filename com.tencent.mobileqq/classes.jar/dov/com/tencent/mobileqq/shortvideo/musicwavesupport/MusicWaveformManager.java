package dov.com.tencent.mobileqq.shortvideo.musicwavesupport;

import android.os.Build;
import android.os.Build.VERSION;
import anzy;
import anzz;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;

public class MusicWaveformManager
{
  private int jdField_a_of_type_Int;
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private MusicSoundFile.ProgressListener jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile$ProgressListener = new anzy(this);
  private MusicSoundFile jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile;
  private Runnable jdField_a_of_type_JavaLangRunnable = new anzz(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public static boolean a()
  {
    return ("Meizu".equals(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT <= 22);
  }
  
  private void b()
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile = new MusicSoundFile();
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.postImmediately(this.jdField_a_of_type_JavaLangRunnable, null, true);
  }
  
  public float a(int paramInt)
  {
    if ((this.b) && (this.c)) {
      return 0.5F;
    }
    if ((this.b) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile != null) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile.jdField_a_of_type_Boolean) && (paramInt >= this.jdField_a_of_type_Int)) {
      return this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile.a(paramInt - this.jdField_a_of_type_Int);
    }
    return -1.0F;
  }
  
  public void a()
  {
    if (!this.b) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile != null) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile = null;
    }
    this.b = false;
  }
  
  public void a(MusicItemInfo paramMusicItemInfo, int paramInt)
  {
    if (paramMusicItemInfo == null) {
      a();
    }
    do
    {
      do
      {
        return;
        if (!this.b) {
          break;
        }
      } while ((paramMusicItemInfo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo)) && (this.jdField_a_of_type_Int <= paramInt) && (paramMusicItemInfo.e == this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.e) && (paramMusicItemInfo.f == this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.f));
      a();
      this.b = true;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo.a();
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile = null;
      this.jdField_a_of_type_Int = paramInt;
      if (!a()) {
        break;
      }
      this.c = true;
    } while (!QLog.isColorLevel());
    QLog.e("MusicWaveformManager", 2, "musicSoundFile create give up, is rubbish Meizu");
    return;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.musicwavesupport.MusicWaveformManager
 * JD-Core Version:    0.7.0.1
 */