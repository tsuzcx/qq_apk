package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import anzj;
import bqgk;
import bqha;
import bqhs;
import com.tencent.mobileqq.widget.QQToast;

public class EditVideoSave$1
  implements Runnable
{
  public EditVideoSave$1(bqha parambqha, int paramInt, Intent paramIntent) {}
  
  public void run()
  {
    this.this$0.j();
    if (this.jdField_a_of_type_Int == 222)
    {
      str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_video_save_path");
      this.this$0.jdField_a_of_type_Bqgk.a(str);
    }
    while (this.this$0.jdField_a_of_type_Bqgk.a.a() == 102)
    {
      String str;
      return;
    }
    QQToast.a(this.this$0.jdField_a_of_type_Bqhs.a(), 2, anzj.a(2131702660), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.1
 * JD-Core Version:    0.7.0.1
 */