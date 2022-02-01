package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import bngd;
import bngl;
import bngq;
import bnjl;
import bnno;
import java.util.Map;

class DoodleLayout$12
  implements Runnable
{
  DoodleLayout$12(DoodleLayout paramDoodleLayout, Map paramMap) {}
  
  public void run()
  {
    bnno localbnno;
    if ((this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b != null) && (this.a != null))
    {
      localbnno = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b;
      if (!(localbnno instanceof bngd)) {
        break label97;
      }
      ((bngd)localbnno).a = this.a;
    }
    for (;;)
    {
      localbnno.i = 3;
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b = null;
      if (this.this$0.jdField_a_of_type_Bnjl != null) {
        this.this$0.jdField_a_of_type_Bnjl.h();
      }
      return;
      label97:
      if ((localbnno instanceof bngq)) {
        ((bngq)localbnno).a = this.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.12
 * JD-Core Version:    0.7.0.1
 */