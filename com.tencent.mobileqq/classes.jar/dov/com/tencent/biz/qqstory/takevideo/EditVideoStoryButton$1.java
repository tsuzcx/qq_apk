package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import bpam;
import bqgk;
import bqhi;
import bqhs;
import bqip;
import bqvl;
import bqvm;

public class EditVideoStoryButton$1
  implements Runnable
{
  public EditVideoStoryButton$1(bqhi parambqhi, Intent paramIntent, boolean paramBoolean, bqvl parambqvl) {}
  
  public void run()
  {
    boolean bool = false;
    this.this$0.k();
    String str1;
    String str2;
    if (this.this$0.jdField_a_of_type_Bqgk.a.a() != 102)
    {
      str1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_video_save_path");
      str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_send_path");
      if (this.this$0.jdField_a_of_type_Bqgk.a.a("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {
        bool = true;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        bqvm.a().a(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("widgetinfo"));
        String str3 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_camera_material_name");
        bpam.b("EditVideoStoryButton", "onPostRun---takeSameName=" + str3);
        bqvm.a().b(str3);
        bqvm.a().a(this.jdField_a_of_type_Bqvl.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bqvl.jdField_a_of_type_Int, str1, str2, true);
      }
    }
    else
    {
      return;
    }
    bqip.a(this.this$0.jdField_a_of_type_Bqhs.getActivity(), str1, str2, bool, "caller_aecamera");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.1
 * JD-Core Version:    0.7.0.1
 */