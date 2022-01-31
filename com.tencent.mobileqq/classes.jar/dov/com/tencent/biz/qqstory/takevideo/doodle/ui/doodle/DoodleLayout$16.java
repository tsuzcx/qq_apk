package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import bkao;
import bkay;
import bkbd;
import bkef;
import bkin;
import java.util.Map;

class DoodleLayout$16
  implements Runnable
{
  DoodleLayout$16(DoodleLayout paramDoodleLayout, Map paramMap) {}
  
  public void run()
  {
    bkin localbkin;
    if ((this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b != null) && (this.a != null))
    {
      localbkin = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b;
      if (!(localbkin instanceof bkao)) {
        break label97;
      }
      ((bkao)localbkin).a = this.a;
    }
    for (;;)
    {
      localbkin.i = 3;
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b = null;
      if (this.this$0.jdField_a_of_type_Bkef != null) {
        this.this$0.jdField_a_of_type_Bkef.s();
      }
      return;
      label97:
      if ((localbkin instanceof bkbd)) {
        ((bkbd)localbkin).a = this.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.16
 * JD-Core Version:    0.7.0.1
 */