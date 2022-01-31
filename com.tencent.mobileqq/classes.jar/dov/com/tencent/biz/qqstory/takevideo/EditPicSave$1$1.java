package dov.com.tencent.biz.qqstory.takevideo;

import ajyc;
import android.app.Activity;
import android.content.Intent;
import bcpw;
import birc;
import bjtb;
import bjtc;
import bjww;
import bjye;
import bjzb;
import bklx;
import bkly;

public class EditPicSave$1$1
  implements Runnable
{
  public EditPicSave$1$1(bjtc parambjtc) {}
  
  public void run()
  {
    boolean bool = true;
    if (bjtb.a(this.a.a)) {}
    int i;
    Object localObject;
    Intent localIntent;
    do
    {
      return;
      if (bjtb.a(this.a.a) == 49) {}
      for (i = 1;; i = 0)
      {
        localObject = bjtb.a(this.a.a);
        this.a.a.jdField_a_of_type_Bjww.a(0);
        this.a.a.jdField_a_of_type_Boolean = true;
        this.a.a.a(100);
        this.a.a.d();
        if (this.a.a.jdField_a_of_type_Bjww.a.a() != 102) {
          break;
        }
        bjtb.a(this.a.a, this.a.a.jdField_a_of_type_Bjww.a.a());
        return;
      }
      if (birc.e(this.a.a.jdField_a_of_type_Bjye.getActivity().getIntent()))
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
        ((Intent)localObject).putExtra("file_path", bjtb.a(this.a.a));
        ((Intent)localObject).putExtra("is_video", false);
        this.a.a.jdField_a_of_type_Bjye.getActivity().sendBroadcast((Intent)localObject);
        this.a.a.jdField_a_of_type_Bjye.getActivity().setResult(-1, this.a.a.jdField_a_of_type_Bjye.getActivity().getIntent());
        this.a.a.jdField_a_of_type_Bjye.getActivity().finish();
        return;
      }
      if (this.a.a.jdField_a_of_type_Bjww.a.a() != 14) {
        break;
      }
      localIntent = this.a.a.jdField_a_of_type_Bjye.getActivity().getIntent();
    } while (birc.a(localIntent));
    this.a.a.jdField_a_of_type_Bjww.b = false;
    this.a.a.jdField_a_of_type_Bjww.a(0);
    if (bjtb.b(this.a.a))
    {
      if (localIntent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {}
      while (i == 0)
      {
        bjzb.a(this.a.a.jdField_a_of_type_Bjye.getActivity(), bjtb.a(this.a.a), bool);
        return;
        bool = false;
      }
      bkly.a().a(localIntent.getStringExtra("widgetinfo"));
      bkly.a().a(((bklx)localObject).jdField_a_of_type_JavaLangString, ((bklx)localObject).jdField_a_of_type_Int, bjtb.a(this.a.a), "", false);
      return;
    }
    bcpw.a(this.a.a.jdField_a_of_type_Bjye.a(), 1, ajyc.a(2131703681), 0).a();
    return;
    bcpw.a(this.a.a.jdField_a_of_type_Bjye.a(), 2, ajyc.a(2131703683), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1.1
 * JD-Core Version:    0.7.0.1
 */