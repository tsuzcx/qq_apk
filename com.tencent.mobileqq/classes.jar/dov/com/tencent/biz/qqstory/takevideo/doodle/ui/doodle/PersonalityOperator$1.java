package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class PersonalityOperator$1
  implements Runnable
{
  PersonalityOperator$1(PersonalityOperator paramPersonalityOperator, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.this$0.a(this.a.getId());
    this.this$0.a(this.this$0.a, this.this$0.b, 1.0D);
    long l2 = System.currentTimeMillis();
    SLog.b("PersonalityOperator", "setVideoFilter " + this.a.getId() + " t:" + (l2 - l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityOperator.1
 * JD-Core Version:    0.7.0.1
 */