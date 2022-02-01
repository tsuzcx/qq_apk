package dov.com.qq.im.capture.music;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditMusicExport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayerExport;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;

public class EditVideoQimMusic
  extends EditVideoPart
  implements View.OnClickListener, MusicMuteListener, EditMusicExport
{
  private long jdField_a_of_type_Long = -1L;
  private QimMusicPlayer jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
  private boolean jdField_a_of_type_Boolean;
  private boolean b = false;
  private boolean c = true;
  
  public EditVideoQimMusic(@NonNull EditVideoPartManager paramEditVideoPartManager, boolean paramBoolean)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private MusicItemInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = a();
    if (localObject1 != null) {}
    for (localObject1 = ((Bundle)localObject1).getBundle(MusicProviderView.class.getSimpleName());; localObject1 = null)
    {
      MusicItemInfo localMusicItemInfo;
      boolean bool;
      if (localObject1 != null)
      {
        localMusicItemInfo = (MusicItemInfo)((Bundle)localObject1).getParcelable("select_music");
        localObject2 = ((Bundle)localObject1).getString("select_music_local_path");
        bool = ((Bundle)localObject1).getBoolean("select_mute");
        if (localMusicItemInfo == null) {
          break label111;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localMusicItemInfo.setPath((String)localObject2);
        }
        localObject2 = localMusicItemInfo;
        if (QLog.isColorLevel())
        {
          QLog.i("EditVideoQimMusic", 2, "restore music" + localMusicItemInfo.mMusicName);
          localObject2 = localMusicItemInfo;
        }
      }
      label111:
      do
      {
        return localObject2;
        localObject2 = localMusicItemInfo;
      } while (!bool);
      localObject1 = new MusicItemInfo();
      ((MusicItemInfo)localObject1).mType = 3;
      ((MusicItemInfo)localObject1).mItemId = -2;
      return localObject1;
    }
  }
  
  private void a(int paramInt, GenerateContext paramGenerateContext, MusicItemInfo paramMusicItemInfo)
  {
    boolean bool = paramGenerateContext.a.getBooleanExtra("isMixOriginal", this.jdField_a_of_type_Boolean);
    if (paramMusicItemInfo != null)
    {
      paramGenerateContext.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
      int j = paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart;
      int i = j;
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c()) {
        i = Math.min(j, (int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramInt));
      }
      paramGenerateContext.a.backgroundMusicDuration = i;
      paramGenerateContext.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
      PublishVideoEntry localPublishVideoEntry = paramGenerateContext.a;
      if (!bool)
      {
        bool = true;
        localPublishVideoEntry.isMuteRecordVoice = bool;
        paramGenerateContext.a.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(paramMusicItemInfo.mItemId));
        paramGenerateContext.a.putExtra("vs_publish_entry_json_key_music_mid_id", paramMusicItemInfo.mSongMid);
        paramGenerateContext.a.putExtra("vs_publish_entry_json_key_song_name", paramMusicItemInfo.mMusicName);
        paramGenerateContext.a.putExtra("vs_publish_entry_json_key_music_album_pic", paramMusicItemInfo.mAlbumUrl);
      }
    }
    do
    {
      return;
      bool = false;
      break;
      paramMusicItemInfo = this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b();
    } while ((paramMusicItemInfo == null) || ((paramMusicItemInfo.mType != 3) && (!paramMusicItemInfo.isDownloading())));
    paramGenerateContext.a.backgroundMusicPath = null;
  }
  
  private void b(int paramInt, @NonNull GenerateContext paramGenerateContext, MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo != null) {
      if (paramMusicItemInfo.isMyMusicInfo())
      {
        paramGenerateContext.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
        paramInt = Math.min(paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart, (int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramInt));
        paramGenerateContext.a.backgroundMusicDuration = paramInt;
        paramGenerateContext.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
        paramGenerateContext.a.isMuteRecordVoice = true;
      }
    }
    do
    {
      return;
      paramGenerateContext.a.backgroundMusicOffset = 0;
      paramGenerateContext.a.backgroundMusicDuration = ((int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramInt));
      break;
      paramMusicItemInfo = this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b();
    } while ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType != 3));
    paramGenerateContext.a.backgroundMusicPath = null;
    paramGenerateContext.a.isMuteRecordVoice = true;
  }
  
  public void a()
  {
    super.a();
    a(EditMusicExport.class, this);
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this);
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer == null) {
      return;
    }
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a();
    if (localMusicItemInfo != null)
    {
      String str2 = localMusicItemInfo.mTagName;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "none";
      }
      AEBaseReportParam.a().h(str1 + "_" + localMusicItemInfo.mItemId);
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 14))
    {
      a(paramInt, paramGenerateContext, localMusicItemInfo);
      return;
    }
    b(paramInt, paramGenerateContext, localMusicItemInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
    if (localEditVideoPlayerExport != null) {
      localEditVideoPlayerExport.a(paramBoolean);
    }
  }
  
  public void aM_()
  {
    super.aM_();
    this.b = true;
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null) {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer == null) {}
    do
    {
      return;
      if (!this.b) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditVideoQimMusic", 2, "playBgMusic in = null isPause=" + this.b);
    return;
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer = ((QimMusicPlayer)QIMManager.a().c(8));
    MusicItemInfo localMusicItemInfo2;
    if (this.c)
    {
      this.c = false;
      localMusicItemInfo2 = a();
      localMusicItemInfo1 = localMusicItemInfo2;
      if (localMusicItemInfo2 == null) {
        this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.c();
      }
    }
    for (MusicItemInfo localMusicItemInfo1 = localMusicItemInfo2;; localMusicItemInfo1 = this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a())
    {
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoQimMusic", 2, "playBgMusic in mPreTime=" + this.jdField_a_of_type_Long + " currentTime=" + l);
      }
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(localMusicItemInfo1, true, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.c());
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer != null) {
      this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.b();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "resumeClipMusic isPause=" + this.b);
    }
    if ((this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer == null) || (this.b)) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a();
  }
  
  public void f()
  {
    super.f();
    this.b = false;
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "onResume");
    }
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer.a(null);
    this.jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer = null;
  }
  
  public void h()
  {
    super.h();
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.music.EditVideoQimMusic
 * JD-Core Version:    0.7.0.1
 */