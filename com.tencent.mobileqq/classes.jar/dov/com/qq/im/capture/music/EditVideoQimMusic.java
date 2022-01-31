package dov.com.qq.im.capture.music;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.tencent.biz.qqstory.takevideo.EditMusicExport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayerExport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoTag.EditBehavior;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;

public class EditVideoQimMusic
  extends EditVideoPart
  implements View.OnClickListener, MusicMuteListener, EditMusicExport
{
  private long jdField_a_of_type_Long = -1L;
  private QimMusicPlayer jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
  private boolean jdField_a_of_type_Boolean;
  
  public EditVideoQimMusic(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  @Nullable
  public MusicItemInfo a()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer == null) {
      return null;
    }
    return this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b();
  }
  
  public void a()
  {
    super.a();
    a(EditMusicExport.class, this);
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null) {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this);
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer == null) {}
    MusicItemInfo localMusicItemInfo;
    do
    {
      return;
      localMusicItemInfo = this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b();
      if (localMusicItemInfo != null)
      {
        if (localMusicItemInfo.e())
        {
          paramGenerateContext.a.backgroundMusicOffset = localMusicItemInfo.e;
          paramInt = Math.min(localMusicItemInfo.f - localMusicItemInfo.e, (int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramInt));
        }
        for (paramGenerateContext.a.backgroundMusicDuration = paramInt;; paramGenerateContext.a.backgroundMusicDuration = ((int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramInt)))
        {
          paramGenerateContext.a.backgroundMusicPath = localMusicItemInfo.a();
          paramGenerateContext.a.isMuteRecordVoice = true;
          return;
          paramGenerateContext.a.backgroundMusicOffset = 0;
        }
      }
      localMusicItemInfo = this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.c();
    } while ((localMusicItemInfo == null) || (localMusicItemInfo.d != 3));
    paramGenerateContext.a.isMuteRecordVoice = true;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer == null) {}
    while (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b() == null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(paramLong);
  }
  
  public void a(EditVideoTag.EditBehavior paramEditBehavior)
  {
    MusicItemInfo localMusicItemInfo = a();
    if (localMusicItemInfo == null)
    {
      paramEditBehavior.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localMusicItemInfo.d != 5) && (localMusicItemInfo.d != 1))
    {
      paramEditBehavior.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localMusicItemInfo.d)
    {
    }
    for (;;)
    {
      try
      {
        paramEditBehavior.jdField_a_of_type_Long = localMusicItemInfo.jdField_a_of_type_Int;
        paramEditBehavior.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EditVideoQimMusic", 2, "music id is error: title:" + localMusicItemInfo.jdField_a_of_type_JavaLangString + ", id:" + localMusicItemInfo.jdField_a_of_type_Int);
        paramEditBehavior.jdField_a_of_type_Boolean = false;
      }
      paramEditBehavior.jdField_a_of_type_Int = 0;
      continue;
      paramEditBehavior.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
    if (localEditVideoPlayerExport != null) {
      localEditVideoPlayerExport.a(paramBoolean);
    }
  }
  
  public void aF_()
  {
    super.aF_();
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "onResume");
    }
  }
  
  public void aG_()
  {
    super.aG_();
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null) {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.d();
    }
  }
  
  public void au_()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer == null) {}
    MusicItemInfo localMusicItemInfo;
    do
    {
      return;
      localMusicItemInfo = this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b();
      if ((localMusicItemInfo != null) && (!this.jdField_a_of_type_Boolean)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditVideoQimMusic", 2, "playBgMusic in = null isPause=" + this.jdField_a_of_type_Boolean);
    return;
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "playBgMusic in mPreTime=" + this.jdField_a_of_type_Long + " currentTime=" + l);
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(localMusicItemInfo, true, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c());
  }
  
  public void av_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "resumeClipMusic isPause=" + this.jdField_a_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer == null) || (this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.c();
  }
  
  public void az_()
  {
    super.az_();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null) {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.d();
    }
  }
  
  public void h()
  {
    super.h();
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(null);
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer = null;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.EditVideoQimMusic
 * JD-Core Version:    0.7.0.1
 */