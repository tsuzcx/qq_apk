package dov.com.qq.im.story.mode;

import android.text.TextUtils;
import android.widget.TextView;
import bmdi;
import bmdw;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import wzs;
import xah;

public class StoryEffectTextMode$EditDialogListener$1
  implements Runnable
{
  public StoryEffectTextMode$EditDialogListener$1(bmdw parambmdw) {}
  
  public void run()
  {
    ((wzs)bmdi.a(this.a.jdField_a_of_type_Bmdi).a("TextLayer")).a(this.a.jdField_a_of_type_Xah);
    if (bmdi.a(this.a.jdField_a_of_type_Bmdi))
    {
      bmdi.a(this.a.jdField_a_of_type_Bmdi).setVisibility(8);
      bmdi.a(this.a.jdField_a_of_type_Bmdi).setVisibility(8);
    }
    bmdi.a(this.a.jdField_a_of_type_Bmdi, bmdi.a(this.a.jdField_a_of_type_Bmdi), this.a.jdField_a_of_type_Xah.a, bmdi.c(this.a.jdField_a_of_type_Bmdi), bmdi.d(this.a.jdField_a_of_type_Bmdi), 8, null);
    if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_Xah.a)) || (bmdi.a(this.a.jdField_a_of_type_Bmdi)))
    {
      bmdi.b(this.a.jdField_a_of_type_Bmdi).setVisibility(8);
      return;
    }
    bmdi.b(this.a.jdField_a_of_type_Bmdi).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.story.mode.StoryEffectTextMode.EditDialogListener.1
 * JD-Core Version:    0.7.0.1
 */