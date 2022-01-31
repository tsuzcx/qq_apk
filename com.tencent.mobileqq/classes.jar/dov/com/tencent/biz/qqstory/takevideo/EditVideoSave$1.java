package dov.com.tencent.biz.qqstory.takevideo;

import alud;
import android.content.Intent;
import bmnj;
import bmnz;
import bmor;
import com.tencent.mobileqq.widget.QQToast;

public class EditVideoSave$1
  implements Runnable
{
  public EditVideoSave$1(bmnz parambmnz, int paramInt, Intent paramIntent) {}
  
  public void run()
  {
    this.this$0.j();
    if (this.jdField_a_of_type_Int == 222)
    {
      str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_video_save_path");
      this.this$0.jdField_a_of_type_Bmnj.a(str);
    }
    while (this.this$0.jdField_a_of_type_Bmnj.a.a() == 102)
    {
      String str;
      return;
    }
    QQToast.a(this.this$0.jdField_a_of_type_Bmor.a(), 2, alud.a(2131704156), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.1
 * JD-Core Version:    0.7.0.1
 */