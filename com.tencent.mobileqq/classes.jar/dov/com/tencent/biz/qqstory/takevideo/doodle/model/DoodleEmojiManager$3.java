package dov.com.tencent.biz.qqstory.takevideo.doodle.model;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.logging.SLog;

class DoodleEmojiManager$3
  extends DoodleEmojiManager.DownloadAndUnZipJob
{
  DoodleEmojiManager$3(DoodleEmojiManager paramDoodleEmojiManager, DoodleEmojiItem paramDoodleEmojiItem)
  {
    super(paramDoodleEmojiItem);
  }
  
  protected void a(@Nullable DoodleEmojiItem arg1)
  {
    super.onResult(???);
    SLog.b("DoodleEmojiManager", "startDownload again");
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem = null;
      this.a.d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.3
 * JD-Core Version:    0.7.0.1
 */