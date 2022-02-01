package dov.com.tencent.biz.qqstory.takevideo;

import amtj;
import android.content.Intent;
import bnee;
import bneo;
import bnew;
import com.tencent.mobileqq.widget.QQToast;

public class EditVideoSave$1
  implements Runnable
{
  public EditVideoSave$1(bneo parambneo, int paramInt, Intent paramIntent) {}
  
  public void run()
  {
    this.this$0.c();
    if (this.jdField_a_of_type_Int == 222)
    {
      str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_video_save_path");
      this.this$0.jdField_a_of_type_Bnee.a(str);
    }
    while (this.this$0.jdField_a_of_type_Bnee.a.a() == 102)
    {
      String str;
      return;
    }
    QQToast.a(this.this$0.jdField_a_of_type_Bnew.a(), 2, amtj.a(2131702895), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.1
 * JD-Core Version:    0.7.0.1
 */