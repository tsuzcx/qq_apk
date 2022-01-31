package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import bijc;
import bijm;
import bijr;
import bimt;
import birb;
import java.util.Map;

class DoodleLayout$16
  implements Runnable
{
  DoodleLayout$16(DoodleLayout paramDoodleLayout, Map paramMap) {}
  
  public void run()
  {
    birb localbirb;
    if ((this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b != null) && (this.a != null))
    {
      localbirb = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b;
      if (!(localbirb instanceof bijc)) {
        break label97;
      }
      ((bijc)localbirb).a = this.a;
    }
    for (;;)
    {
      localbirb.i = 3;
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b = null;
      if (this.this$0.jdField_a_of_type_Bimt != null) {
        this.this$0.jdField_a_of_type_Bimt.s();
      }
      return;
      label97:
      if ((localbirb instanceof bijr)) {
        ((bijr)localbirb).a = this.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.16
 * JD-Core Version:    0.7.0.1
 */