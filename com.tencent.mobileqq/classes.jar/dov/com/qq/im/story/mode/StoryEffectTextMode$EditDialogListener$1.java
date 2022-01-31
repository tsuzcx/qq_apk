package dov.com.qq.im.story.mode;

import android.text.TextUtils;
import android.widget.TextView;
import bmhu;
import bmii;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import xeb;
import xeq;

public class StoryEffectTextMode$EditDialogListener$1
  implements Runnable
{
  public StoryEffectTextMode$EditDialogListener$1(bmii parambmii) {}
  
  public void run()
  {
    ((xeb)bmhu.a(this.a.jdField_a_of_type_Bmhu).a("TextLayer")).a(this.a.jdField_a_of_type_Xeq);
    if (bmhu.a(this.a.jdField_a_of_type_Bmhu))
    {
      bmhu.a(this.a.jdField_a_of_type_Bmhu).setVisibility(8);
      bmhu.a(this.a.jdField_a_of_type_Bmhu).setVisibility(8);
    }
    bmhu.a(this.a.jdField_a_of_type_Bmhu, bmhu.a(this.a.jdField_a_of_type_Bmhu), this.a.jdField_a_of_type_Xeq.a, bmhu.c(this.a.jdField_a_of_type_Bmhu), bmhu.d(this.a.jdField_a_of_type_Bmhu), 8, null);
    if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_Xeq.a)) || (bmhu.a(this.a.jdField_a_of_type_Bmhu)))
    {
      bmhu.b(this.a.jdField_a_of_type_Bmhu).setVisibility(8);
      return;
    }
    bmhu.b(this.a.jdField_a_of_type_Bmhu).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.EditDialogListener.1
 * JD-Core Version:    0.7.0.1
 */