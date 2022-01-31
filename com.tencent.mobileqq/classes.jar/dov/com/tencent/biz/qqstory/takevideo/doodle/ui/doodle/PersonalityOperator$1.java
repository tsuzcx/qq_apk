package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import bkfc;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import veg;

public class PersonalityOperator$1
  implements Runnable
{
  public PersonalityOperator$1(bkfc parambkfc, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.this$0.a(this.a.getId());
    this.this$0.a(this.this$0.a, this.this$0.b, 1.0D);
    long l2 = System.currentTimeMillis();
    veg.b("PersonalityOperator", "setVideoFilter " + this.a.getId() + " t:" + (l2 - l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityOperator.1
 * JD-Core Version:    0.7.0.1
 */