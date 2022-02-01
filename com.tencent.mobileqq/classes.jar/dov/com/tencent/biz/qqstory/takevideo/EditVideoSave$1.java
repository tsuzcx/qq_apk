package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import anvx;
import botw;
import boug;
import bouo;
import com.tencent.mobileqq.widget.QQToast;

public class EditVideoSave$1
  implements Runnable
{
  public EditVideoSave$1(boug paramboug, int paramInt, Intent paramIntent) {}
  
  public void run()
  {
    this.this$0.c();
    if (this.jdField_a_of_type_Int == 222)
    {
      str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_video_save_path");
      this.this$0.jdField_a_of_type_Botw.a(str);
    }
    while (this.this$0.jdField_a_of_type_Botw.a.a() == 102)
    {
      String str;
      return;
    }
    QQToast.a(this.this$0.jdField_a_of_type_Bouo.a(), 2, anvx.a(2131703246), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.1
 * JD-Core Version:    0.7.0.1
 */