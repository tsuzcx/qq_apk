package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import bmvp;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import wxe;

public class PersonalityOperator$1
  implements Runnable
{
  public PersonalityOperator$1(bmvp parambmvp, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.this$0.a(this.a.getId());
    this.this$0.a(this.this$0.a, this.this$0.b, 1.0D);
    long l2 = System.currentTimeMillis();
    wxe.b("PersonalityOperator", "setVideoFilter " + this.a.getId() + " t:" + (l2 - l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityOperator.1
 * JD-Core Version:    0.7.0.1
 */