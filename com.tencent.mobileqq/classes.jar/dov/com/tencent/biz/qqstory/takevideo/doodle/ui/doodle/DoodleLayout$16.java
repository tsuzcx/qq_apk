package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import bmqk;
import bmqu;
import bmqz;
import bmub;
import bmyj;
import java.util.Map;

class DoodleLayout$16
  implements Runnable
{
  DoodleLayout$16(DoodleLayout paramDoodleLayout, Map paramMap) {}
  
  public void run()
  {
    bmyj localbmyj;
    if ((this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b != null) && (this.a != null))
    {
      localbmyj = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b;
      if (!(localbmyj instanceof bmqk)) {
        break label97;
      }
      ((bmqk)localbmyj).a = this.a;
    }
    for (;;)
    {
      localbmyj.i = 3;
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b = null;
      if (this.this$0.jdField_a_of_type_Bmub != null) {
        this.this$0.jdField_a_of_type_Bmub.s();
      }
      return;
      label97:
      if ((localbmyj instanceof bmqz)) {
        ((bmqz)localbmyj).a = this.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.16
 * JD-Core Version:    0.7.0.1
 */