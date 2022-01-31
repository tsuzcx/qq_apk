package dov.com.tencent.biz.qqstory.takevideo;

import ajyc;
import android.content.Intent;
import bcpw;
import bjww;
import bjxm;
import bjye;

public class EditVideoSave$1
  implements Runnable
{
  public EditVideoSave$1(bjxm parambjxm, int paramInt, Intent paramIntent) {}
  
  public void run()
  {
    this.this$0.j();
    if (this.jdField_a_of_type_Int == 222)
    {
      str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_video_save_path");
      this.this$0.jdField_a_of_type_Bjww.a(str);
    }
    while (this.this$0.jdField_a_of_type_Bjww.a.a() == 102)
    {
      String str;
      return;
    }
    bcpw.a(this.this$0.jdField_a_of_type_Bjye.a(), 2, ajyc.a(2131703761), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.1
 * JD-Core Version:    0.7.0.1
 */