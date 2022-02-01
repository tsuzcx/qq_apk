package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import bmbx;
import bnee;
import bnet;
import bnew;
import bnfm;
import bnpz;
import bnqa;

public class EditVideoStoryButton$1
  implements Runnable
{
  public EditVideoStoryButton$1(bnet parambnet, Intent paramIntent, boolean paramBoolean, bnpz parambnpz) {}
  
  public void run()
  {
    boolean bool = false;
    this.this$0.d();
    String str1;
    String str2;
    if (this.this$0.jdField_a_of_type_Bnee.a.a() != 102)
    {
      str1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_video_save_path");
      str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_send_path");
      if (this.this$0.jdField_a_of_type_Bnee.a.a("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {
        bool = true;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        bnqa.a().a(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("widgetinfo"));
        String str3 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_camera_material_name");
        bmbx.b("EditVideoStoryButton", "onPostRun---takeSameName=" + str3);
        bnqa.a().b(str3);
        bnqa.a().a(this.jdField_a_of_type_Bnpz.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bnpz.jdField_a_of_type_Int, str1, str2, true);
      }
    }
    else
    {
      return;
    }
    bnfm.a(this.this$0.jdField_a_of_type_Bnew.getActivity(), str1, str2, bool, "caller_aecamera");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.1
 * JD-Core Version:    0.7.0.1
 */