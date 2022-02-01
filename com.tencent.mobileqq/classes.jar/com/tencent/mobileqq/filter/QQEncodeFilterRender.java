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
  public boolean a = false;
  private MusicItemInfo b;
  private MusicSoundFile c;
  private boolean d;
  private int e;
  private QQFilterRenderManager f = QQFilterRenderManagerHolder.a();
  private int g;
  private int h;
  private boolean i;
  
  public QQEncodeFilterRender(List<FilterDesc> paramList, MusicItemInfo paramMusicItemInfo, int paramInt1, int paramInt2, PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramList != null)
    {
      paramPublishVideoEntry = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FilterDesc localFilterDesc = (FilterDesc)paramList.next();
        if (localFilterDesc != null)
        {
          int j = QQAVImageFilterConstants.getFilterType(localFilterDesc.id);
          if (j == 0)
          {
            this.a = false;
            paramPublishVideoEntry.add(localFilterDesc);
          }
          else if (j == 2)
          {
            this.a = false;
            paramPublishVideoEntry.add(localFilterDesc);
          }
          else if (j == 5)
          {
            this.a = false;
            paramPublishVideoEntry.add(localFilterDesc);
          }
          else if (j == 1)
          {
            this.a = true;
            paramPublishVideoEntry.clear();
            paramPublishVideoEntry.add(localFilterDesc);
          }
        }
      }
      if (paramPublishVideoEntry.size() > 0) {
        this.f.getBusinessOperation().setFilterEffectList(paramPublishVideoEntry);
      }
    }
    paramList = this.f.getQQFilters(80);
    if ((paramMusicItemInfo != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((QQSpecialAVFilter)paramList.next()).setMusicWaveformSupporter(this);
      }
    }
    this.b = paramMusicItemInfo;
    this.d = false;
    this.g = paramInt1;
    this.h = paramInt2;
    if (this.b != null) {
      b();
    }
  }
  
  @TargetApi(17)
  private void b()
  {
    if (this.b != null)
    {
      this.c = new MusicSoundFile();
      if (MusicSoundFile.c())
      {
        this.i = true;
        if (QLog.isColorLevel()) {
          QLog.e("QQEncodeFilterRender", 2, "musicSoundFile create give up, is rubbish Meizu");
        }
        return;
      }
      this.d = true;
      Object localObject = new QQEncodeFilterRender.1(this);
      try
      {
        long l = SystemClock.elapsedRealtimeNanos();
        boolean bool = this.c.a(this.b, (MusicSoundFile.ProgressListener)localObject, 0);
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
          this.c = null;
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
        this.c = null;
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.e = ((int)(paramLong / 1000000L));
    this.f.getBusinessOperation().SetTimeStamp(paramLong, paramLong);
    return this.f.drawFrame(paramInt3);
  }
  
  public int a(int paramInt, long paramLong)
  {
    return a(this.g, this.h, paramInt, paramLong);
  }
  
  public void a()
  {
    this.f.surfaceDestroyed();
    this.c = null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.f.surfaceCreate(paramInt1, paramInt2, paramInt1, paramInt2);
    this.f.surfaceChange(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f.surfaceCreate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public float getCurrentMusicGain()
  {
    float f1 = -1.0F;
    try
    {
      if (this.c != null)
      {
        if (this.i) {
          return 0.5F;
        }
        f1 = this.c.a(this.e);
      }
      return f1;
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
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filter.QQEncodeFilterRender
 * JD-Core Version:    0.7.0.1
 */