package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import bphq;
import bpia;
import bpif;
import bplh;
import bppp;
import java.util.Map;

class DoodleLayout$16
  implements Runnable
{
  DoodleLayout$16(DoodleLayout paramDoodleLayout, Map paramMap) {}
  
  public void run()
  {
    bppp localbppp;
    if ((this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b != null) && (this.a != null))
    {
      localbppp = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b;
      if (!(localbppp instanceof bphq)) {
        break label97;
      }
      ((bphq)localbppp).a = this.a;
    }
    for (;;)
    {
      localbppp.i = 3;
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b = null;
      if (this.this$0.jdField_a_of_type_Bplh != null) {
        this.this$0.jdField_a_of_type_Bplh.s();
      }
      return;
      label97:
      if ((localbppp instanceof bpif)) {
        ((bpif)localbppp).a = this.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.16
 * JD-Core Version:    0.7.0.1
 */