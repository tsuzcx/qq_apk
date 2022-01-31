package dov.com.tencent.biz.qqstory.takevideo;

import alpo;
import android.content.Intent;
import bmix;
import bmjn;
import bmkf;
import com.tencent.mobileqq.widget.QQToast;

public class EditVideoSave$1
  implements Runnable
{
  public EditVideoSave$1(bmjn parambmjn, int paramInt, Intent paramIntent) {}
  
  public void run()
  {
    this.this$0.j();
    if (this.jdField_a_of_type_Int == 222)
    {
      str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_video_save_path");
      this.this$0.jdField_a_of_type_Bmix.a(str);
    }
    while (this.this$0.jdField_a_of_type_Bmix.a.a() == 102)
    {
      String str;
      return;
    }
    QQToast.a(this.this$0.jdField_a_of_type_Bmkf.a(), 2, alpo.a(2131704144), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.1
 * JD-Core Version:    0.7.0.1
 */