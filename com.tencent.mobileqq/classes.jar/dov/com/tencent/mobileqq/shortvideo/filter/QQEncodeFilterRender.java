package dov.com.tencent.mobileqq.shortvideo.filter;

import android.annotation.TargetApi;
import android.os.SystemClock;
import anzm;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter.MusicWaveformSupporter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QQFilterRenderManagerHolder;
import dov.com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoder.EncodeFilterRender;
import dov.com.tencent.mobileqq.shortvideo.musicwavesupport.MusicSoundFile;
import dov.com.tencent.mobileqq.shortvideo.musicwavesupport.MusicWaveformManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQEncodeFilterRender
  implements QQSpecialAVFilter.MusicWaveformSupporter, Mp4ReEncoder.EncodeFilterRender
{
  private int jdField_a_of_type_Int;
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = QQFilterRenderManagerHolder.a();
  private MusicSoundFile jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  
  public QQEncodeFilterRender(List paramList, MusicItemInfo paramMusicItemInfo, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FilterDesc localFilterDesc = (FilterDesc)paramList.next();
      if (localFilterDesc != null)
      {
        int i = QQAVImageFilterConstants.a(localFilterDesc.jdField_b_of_type_Int);
        if (i == 0) {
          localArrayList.add(localFilterDesc);
        } else if (i == 2) {
          localArrayList.add(localFilterDesc);
        }
      }
    }
    if (localArrayList.size() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(localArrayList);
    }
    paramList = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(80);
    if ((paramMusicItemInfo != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((QQSpecialAVFilter)paramList.next()).a(this);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) {
      b();
    }
  }
  
  @TargetApi(17)
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile = new MusicSoundFile();
      if (!MusicWaveformManager.a()) {
        break label44;
      }
      this.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.e("QQEncodeFilterRender", 2, "musicSoundFile create give up, is rubbish Meizu");
      }
    }
    for (;;)
    {
      return;
      label44:
      this.jdField_b_of_type_Boolean = true;
      anzm localanzm = new anzm(this);
      try
      {
        long l = SystemClock.elapsedRealtimeNanos();
        boolean bool = this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, localanzm, 0);
        if (QLog.isColorLevel()) {
          QLog.d("QQEncodeFilterRender", 2, "createSoundFile time: " + (SystemClock.elapsedRealtimeNanos() - l) / 1000000L + "ms");
        }
        if (!bool)
        {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile = null;
          if (QLog.isColorLevel())
          {
            QLog.e("QQEncodeFilterRender", 2, "create MusicSoundFile fail");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("QQEncodeFilterRender", 2, localException.toString());
        }
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile = null;
      }
    }
  }
  
  public float a()
  {
    try
    {
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile != null)
      {
        if (this.jdField_c_of_type_Boolean) {
          return 0.5F;
        }
        float f = this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile.a(this.jdField_a_of_type_Int);
        return f;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQEncodeFilterRender", 2, "getCurrentMusicGain() error: " + localException.toString());
      }
    }
    return -1.0F;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.jdField_a_of_type_Int = ((int)(paramLong / 1000000L));
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(paramInt3);
  }
  
  public int a(int paramInt, long paramLong)
  {
    return a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, paramInt, paramLong);
  }
  
  public MusicItemInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.o();
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile = null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b(paramInt1, paramInt2, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.c(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.filter.QQEncodeFilterRender
 * JD-Core Version:    0.7.0.1
 */