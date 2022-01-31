package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import bmly;
import bmmi;
import bmmn;
import bmpp;
import bmtx;
import java.util.Map;

class DoodleLayout$16
  implements Runnable
{
  DoodleLayout$16(DoodleLayout paramDoodleLayout, Map paramMap) {}
  
  public void run()
  {
    bmtx localbmtx;
    if ((this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b != null) && (this.a != null))
    {
      localbmtx = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b;
      if (!(localbmtx instanceof bmly)) {
        break label97;
      }
      ((bmly)localbmtx).a = this.a;
    }
    for (;;)
    {
      localbmtx.i = 3;
      this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.b = null;
      if (this.this$0.jdField_a_of_type_Bmpp != null) {
        this.this$0.jdField_a_of_type_Bmpp.s();
      }
      return;
      label97:
      if ((localbmtx instanceof bmmn)) {
        ((bmmn)localbmtx).a = this.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.16
 * JD-Core Version:    0.7.0.1
 */