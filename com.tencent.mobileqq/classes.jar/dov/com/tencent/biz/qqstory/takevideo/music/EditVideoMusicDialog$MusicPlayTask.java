package dov.com.tencent.biz.qqstory.takevideo.music;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import java.util.TimerTask;

public class EditVideoMusicDialog$MusicPlayTask
  extends TimerTask
{
  protected EditVideoMusicDialog$MusicPlayTask(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.a() != null)
    {
      EditVideoMusicDialog localEditVideoMusicDialog = this.a;
      localEditVideoMusicDialog.b += 1;
      if (QLog.isColorLevel()) {}
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog.MusicPlayTask
 * JD-Core Version:    0.7.0.1
 */