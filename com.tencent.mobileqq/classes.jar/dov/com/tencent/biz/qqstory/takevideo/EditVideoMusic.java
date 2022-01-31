package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import andz;
import anea;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayer.AudioPlayerListener;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import dov.com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import java.util.ArrayList;
import java.util.Timer;

public class EditVideoMusic
  extends EditVideoPart
  implements AudioPlayer.AudioPlayerListener, EditMusicExport
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  public Handler a;
  public SparseArray a;
  protected anea a;
  protected AudioPlayer a;
  public ArrayList a;
  protected Timer a;
  public boolean a;
  private int b;
  protected boolean b;
  protected boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  private void n()
  {
    if (this.e) {
      return;
    }
    QQStoryMusicInfo localQQStoryMusicInfo = a();
    if ((localQQStoryMusicInfo == null) || (localQQStoryMusicInfo.equals(QQStoryMusicInfo.jdField_b_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo)))
    {
      VideoSourceHelper.nativeSetPlayAFMute(this.d);
      return;
    }
    if (this.d)
    {
      j();
      return;
    }
    ar_();
  }
  
  private void o()
  {
    if (this.f)
    {
      QQToast.a(a(), "GIF不支持添加音乐", 0).a();
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(2);
  }
  
  public QQStoryMusicInfo a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return (QQStoryMusicInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a());
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.c = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a();
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(6);
      int i = 0;
      if (i < 6)
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
          this.jdField_a_of_type_AndroidUtilSparseArray.put(i, QQStoryMusicInfo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
        }
        for (;;)
        {
          i += 1;
          break;
          this.jdField_a_of_type_AndroidUtilSparseArray.put(i, QQStoryMusicInfo.jdField_b_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
        }
      }
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a())
    {
      a(QQStoryMusicInfo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
      a(0);
    }
    a(EditMusicExport.class, this);
  }
  
  public void a(int paramInt)
  {
    EditButtonExport localEditButtonExport = (EditButtonExport)a(EditButtonExport.class);
    if (localEditButtonExport != null)
    {
      if (paramInt == 0) {
        localEditButtonExport.a(2130843462);
      }
    }
    else {
      return;
    }
    if (3 == paramInt)
    {
      localEditButtonExport.a(2130843461);
      return;
    }
    localEditButtonExport.a(2130841734);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "doOnActivityResult selectMusic() resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    if (a() != null)
    {
      k();
      l();
      aq_();
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    QQStoryMusicInfo localQQStoryMusicInfo = (QQStoryMusicInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localQQStoryMusicInfo == null)
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoMusic", "editVideoPrePublish music error---------");
      return;
    }
    paramGenerateContext.a.backgroundMusicPath = localQQStoryMusicInfo.h;
    Object localObject = paramGenerateContext.a;
    if (localQQStoryMusicInfo.jdField_b_of_type_Int != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((PublishVideoEntry)localObject).isMuteRecordVoice = bool;
      paramGenerateContext.a.backgroundMusicOffset = localQQStoryMusicInfo.d;
      paramGenerateContext.a.backgroundMusicDuration = ((int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramInt));
      switch (localQQStoryMusicInfo.jdField_b_of_type_Int)
      {
      default: 
        SLog.d("Q.qqstory.publish.edit.EditVideoMusic", "mCurrentMusicType illegal %d", new Object[] { Integer.valueOf(-999) });
        return;
      }
    }
    if (localQQStoryMusicInfo.jdField_b_of_type_Int == 2)
    {
      paramGenerateContext = "1";
      EditVideoPartManager localEditVideoPartManager = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
      paramInt = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b();
      String str = localQQStoryMusicInfo.jdField_b_of_type_JavaLangString;
      if (!this.c) {
        break label267;
      }
      localObject = "2";
      label202:
      localEditVideoPartManager.b("pub_music", paramInt, 0, new String[] { paramGenerateContext, str, localObject });
      if (!paramGenerateContext.equals("1")) {
        break label274;
      }
    }
    label267:
    label274:
    for (paramGenerateContext = "0X80076E6";; paramGenerateContext = "0X80076E5")
    {
      VideoEditReport.a(paramGenerateContext, String.valueOf(VideoEditReport.jdField_b_of_type_Int), "", localQQStoryMusicInfo.jdField_b_of_type_JavaLangString, "");
      return;
      paramGenerateContext = "2";
      break;
      localObject = "1";
      break label202;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b("sound_off", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(), 0, new String[0]);
    VideoEditReport.a("0X80076E7", VideoEditReport.jdField_b_of_type_Int);
    return;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b("sound_on", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b(), 0, new String[0]);
    VideoEditReport.a("0X80076E8");
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    QQStoryMusicInfo localQQStoryMusicInfo = a();
    if ((localQQStoryMusicInfo == null) || (TextUtils.isEmpty(localQQStoryMusicInfo.h))) {
      return;
    }
    int i = (int)paramLong;
    this.jdField_a_of_type_Int = (localQQStoryMusicInfo.d + i);
  }
  
  public void a(AudioPlayer paramAudioPlayer) {}
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void a(EditVideoTag.EditBehavior paramEditBehavior)
  {
    QQStoryMusicInfo localQQStoryMusicInfo = a();
    if (localQQStoryMusicInfo == null)
    {
      paramEditBehavior.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localQQStoryMusicInfo.jdField_b_of_type_Int != 2) && (localQQStoryMusicInfo.jdField_b_of_type_Int != 3))
    {
      paramEditBehavior.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localQQStoryMusicInfo.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      try
      {
        paramEditBehavior.jdField_a_of_type_Long = Long.valueOf(localQQStoryMusicInfo.jdField_a_of_type_JavaLangString).longValue();
        paramEditBehavior.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        SLog.e("Q.qqstory.publish.edit.EditVideoMusic", "music id is error: title:%s, id:%s", new Object[] { localQQStoryMusicInfo.jdField_b_of_type_JavaLangString, localQQStoryMusicInfo.jdField_a_of_type_JavaLangString });
        paramEditBehavior.jdField_a_of_type_Boolean = false;
      }
      paramEditBehavior.jdField_a_of_type_Int = 0;
      continue;
      paramEditBehavior.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    QQStoryMusicInfo localQQStoryMusicInfo = null;
    if (paramQQStoryMusicInfo != null)
    {
      localQQStoryMusicInfo = new QQStoryMusicInfo();
      localQQStoryMusicInfo.a(paramQQStoryMusicInfo);
      if (paramQQStoryMusicInfo.jdField_b_of_type_Int != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.e = bool;
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(), localQQStoryMusicInfo);
      return;
    }
  }
  
  public void a(String paramString)
  {
    QQStoryMusicInfo localQQStoryMusicInfo = a();
    if (localQQStoryMusicInfo != null) {
      localQQStoryMusicInfo.h = paramString;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  protected boolean a(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    }
    QQStoryMusicInfo localQQStoryMusicInfo;
    label69:
    EditVideoPlayerExport localEditVideoPlayerExport;
    do
    {
      do
      {
        return super.a(paramMessage);
      } while (paramMessage.arg1 != 4);
      o();
      return true;
      localQQStoryMusicInfo = a();
      if (localQQStoryMusicInfo == null) {
        break;
      }
      a(localQQStoryMusicInfo.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "Message change fragment()");
      }
      if ((QQStoryMusicInfo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.equals(localQQStoryMusicInfo)) || (QQStoryMusicInfo.jdField_b_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.equals(localQQStoryMusicInfo))) {
        j();
      }
      localEditVideoPlayerExport = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    } while (localEditVideoPlayerExport == null);
    if (!QQStoryMusicInfo.jdField_b_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.equals(localQQStoryMusicInfo)) {}
    for (;;)
    {
      localEditVideoPlayerExport.a(bool);
      break;
      a(1);
      break label69;
      bool = false;
    }
  }
  
  public void aC_()
  {
    super.aC_();
    this.jdField_b_of_type_Boolean = true;
    ar_();
    n();
  }
  
  public void aD_()
  {
    super.aD_();
    this.jdField_b_of_type_Boolean = false;
    j();
    if (this.jdField_b_of_type_Int > 0) {
      this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, this.jdField_b_of_type_Int, 0);
    }
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      VideoEditReport.a("0X80076BB", VideoEditReport.jdField_b_of_type_Int);
      paramObject = new EditVideoMusicDialog(a(), this, this.c, (int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a);
      paramObject.setCanceledOnTouchOutside(true);
      paramObject.setOnDismissListener(new andz(this));
      paramObject.setCancelable(true);
      paramObject.show();
      return;
    } while ((!this.c) || (a() != null));
    a(0);
  }
  
  public void aq_()
  {
    b(-1);
  }
  
  public void ar_()
  {
    if (this.c)
    {
      aq_();
      return;
    }
    b(this.jdField_a_of_type_Int);
  }
  
  public void b(int paramInt)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "playBgMusic()");
    }
    if ((!this.jdField_b_of_type_Boolean) || (this.d))
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic ignore");
      return;
    }
    QQStoryMusicInfo localQQStoryMusicInfo = a();
    if ((localQQStoryMusicInfo == null) || (TextUtils.isEmpty(localQQStoryMusicInfo.h)))
    {
      if (localQQStoryMusicInfo == null) {}
      for (;;)
      {
        SLog.a("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic music=%s, path=%s", localQQStoryMusicInfo, localObject);
        return;
        localObject = localQQStoryMusicInfo.h;
      }
    }
    j();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(a(), this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(3);
    if (paramInt >= 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(localQQStoryMusicInfo.h, paramInt);
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = 0L;
      if (this.c)
      {
        this.jdField_a_of_type_JavaUtilTimer = new Timer();
        this.jdField_a_of_type_Anea = new anea(this, null);
        this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_Anea, 5000L, 5000L);
      }
      a().sendBroadcast(new Intent("action_music_start"));
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(localQQStoryMusicInfo.h, localQQStoryMusicInfo.d + (int)this.jdField_a_of_type_Long);
    }
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void c()
  {
    if (this.c) {
      j();
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a()));
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
    } while (!QLog.isColorLevel());
    QLog.d("zivonchen", 2, "pauseClipMusic()");
  }
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void h()
  {
    super.h();
    a(1);
    j();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_Anea != null)
    {
      this.jdField_a_of_type_Anea.cancel();
      this.jdField_a_of_type_Anea = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "stopClipMusic()");
    }
  }
  
  public void k()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 3, 0));
  }
  
  public void l()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 1, 0));
  }
  
  public void m()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoMusic
 * JD-Core Version:    0.7.0.1
 */