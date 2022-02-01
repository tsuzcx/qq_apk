package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import bqjl;
import bqjv;
import bqka;
import bqnc;
import bqrk;
import java.util.Map;

class DoodleLayout$16
  implements Runnable
{
  DoodleLayout$16(DoodleLayout paramDoodleLayout, Map paramMap) {}
  
  public void run()
  {
    bqrk localbqrk;
    if ((this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b != null) && (this.a != null))
    {
      localbqrk = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b;
      if (!(localbqrk instanceof bqjl)) {
        break label97;
      }
      ((bqjl)localbqrk).a = this.a;
    }
    for (;;)
    {
      localbqrk.i = 3;
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b = null;
      if (this.this$0.jdField_a_of_type_Bqnc != null) {
        this.this$0.jdField_a_of_type_Bqnc.s();
      }
      return;
      label97:
      if ((localbqrk instanceof bqka)) {
        ((bqka)localbqrk).a = this.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.16
 * JD-Core Version:    0.7.0.1
 */