package dov.com.tencent.biz.qqstory.takevideo;

import ajya;
import android.content.Intent;
import bcql;
import bjxn;
import bjyd;
import bjyv;

public class EditVideoSave$1
  implements Runnable
{
  public EditVideoSave$1(bjyd parambjyd, int paramInt, Intent paramIntent) {}
  
  public void run()
  {
    this.this$0.j();
    if (this.jdField_a_of_type_Int == 222)
    {
      str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_video_save_path");
      this.this$0.jdField_a_of_type_Bjxn.a(str);
    }
    while (this.this$0.jdField_a_of_type_Bjxn.a.a() == 102)
    {
      String str;
      return;
    }
    bcql.a(this.this$0.jdField_a_of_type_Bjyv.a(), 2, ajya.a(2131703772), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.1
 * JD-Core Version:    0.7.0.1
 */