package dov.com.tencent.biz.qqstory.takevideo.doodle.model;

import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.support.logging.SLog;

class DoodleEmojiManager$4
  implements LbsManager.LbsUpdateListener
{
  DoodleEmojiManager$4(DoodleEmojiManager paramDoodleEmojiManager) {}
  
  public void a(boolean paramBoolean, BasicLocation paramBasicLocation)
  {
    SLog.b("DoodleEmojiManager", "requestPoiFaces onLbsUpdate.");
    if ((paramBoolean) && (paramBasicLocation != null) && (this.a.a != null)) {
      this.a.a(paramBasicLocation.b, paramBasicLocation.a, this.a.a);
    }
    for (;;)
    {
      paramBasicLocation = (LbsManager)SuperManager.a(9);
      if (paramBasicLocation != null) {
        paramBasicLocation.b(this);
      }
      this.a.a = null;
      return;
      SLog.e("DoodleEmojiManager", "onLbsUpdate failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.4
 * JD-Core Version:    0.7.0.1
 */