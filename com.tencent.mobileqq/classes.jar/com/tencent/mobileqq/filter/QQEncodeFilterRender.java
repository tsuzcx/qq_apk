package com.tencent.mobileqq.filter;

import android.annotation.TargetApi;
import android.os.SystemClock;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.filter.music.MusicSoundFile;
import com.tencent.mobileqq.filter.music.MusicSoundFile.ProgressListener;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter.MusicWaveformSupporter;
import com.tencent.mobileqq.videocodec.mediacodec.Mp4ReEncoder.EncodeFilterRender;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQEncodeFilterRender
  implements QQSpecialAVFilter.MusicWaveformSupporter, Mp4ReEncoder.EncodeFilterRender
{
  private int jdField_a_of_type_Int;
  private MusicSoundFile jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile;
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = QQFilterRenderManagerHolder.a();
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  
  public QQEncodeFilterRender(List<FilterDesc> paramList, MusicItemInfo paramMusicItemInfo, int paramInt1, int paramInt2, PublishVideoEntry paramPublishVideoEntry)
  {
    this.jdField_a_of_type_Boolean = false;
    if (paramList != null)
    {
      paramPublishVideoEntry = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FilterDesc localFilterDesc = (FilterDesc)paramList.next();
        if (localFilterDesc != null)
        {
          int i = QQAVImageFilterConstants.getFilterType(localFilterDesc.id);
          if (i == 0)
          {
            this.jdField_a_of_type_Boolean = false;
            paramPublishVideoEntry.add(localFilterDesc);
          }
          else if (i == 2)
          {
            this.jdField_a_of_type_Boolean = false;
            paramPublishVideoEntry.add(localFilterDesc);
          }
          else if (i == 5)
          {
            this.jdField_a_of_type_Boolean = false;
            paramPublishVideoEntry.add(localFilterDesc);
          }
          else if (i == 1)
          {
            this.jdField_a_of_type_Boolean = true;
            paramPublishVideoEntry.clear();
            paramPublishVideoEntry.add(localFilterDesc);
          }
        }
      }
      if (paramPublishVideoEntry.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramPublishVideoEntry);
      }
    }
    paramList = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getQQFilters(80);
    if ((paramMusicItemInfo != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((QQSpecialAVFilter)paramList.next()).setMusicWaveformSupporter(this);
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
      this.jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile = new MusicSoundFile();
      if (MusicSoundFile.a())
      {
        this.jdField_c_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.e("QQEncodeFilterRender", 2, "musicSoundFile create give up, is rubbish Meizu");
        }
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      Object localObject = new QQEncodeFilterRender.1(this);
      try
      {
        long l = SystemClock.elapsedRealtimeNanos();
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, (MusicSoundFile.ProgressListener)localObject, 0);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("createSoundFile time: ");
          ((StringBuilder)localObject).append((SystemClock.elapsedRealtimeNanos() - l) / 1000000L);
          ((StringBuilder)localObject).append("ms");
          QLog.d("QQEncodeFilterRender", 2, ((StringBuilder)localObject).toString());
        }
        if (!bool)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile = null;
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
        this.jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile = null;
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.jdField_a_of_type_Int = ((int)(paramLong / 1000000L));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().SetTimeStamp(paramLong, paramLong);
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(paramInt3);
  }
  
  public int a(int paramInt, long paramLong)
  {
    return a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, paramInt, paramLong);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
    this.jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile = null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(paramInt1, paramInt2, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public float getCurrentMusicGain()
  {
    float f = -1.0F;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile != null)
      {
        if (this.jdField_c_of_type_Boolean) {
          return 0.5F;
        }
        f = this.jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile.a(this.jdField_a_of_type_Int);
      }
      return f;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCurrentMusicGain() error: ");
        localStringBuilder.append(localException.toString());
        QLog.e("QQEncodeFilterRender", 2, localStringBuilder.toString());
      }
    }
    return -1.0F;
  }
  
  public MusicItemInfo getMusicItemInfo()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filter.QQEncodeFilterRender
 * JD-Core Version:    0.7.0.1
 */