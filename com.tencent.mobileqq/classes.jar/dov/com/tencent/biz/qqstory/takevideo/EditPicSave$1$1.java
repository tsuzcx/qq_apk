package dov.com.tencent.biz.qqstory.takevideo;

import ajya;
import android.app.Activity;
import android.content.Intent;
import bcql;
import birt;
import bjts;
import bjtt;
import bjxn;
import bjyv;
import bjzs;
import bkmo;
import bkmp;

public class EditPicSave$1$1
  implements Runnable
{
  public EditPicSave$1$1(bjtt parambjtt) {}
  
  public void run()
  {
    boolean bool = true;
    if (bjts.a(this.a.a)) {}
    int i;
    Object localObject;
    Intent localIntent;
    do
    {
      return;
      if (bjts.a(this.a.a) == 49) {}
      for (i = 1;; i = 0)
      {
        localObject = bjts.a(this.a.a);
        this.a.a.jdField_a_of_type_Bjxn.a(0);
        this.a.a.jdField_a_of_type_Boolean = true;
        this.a.a.a(100);
        this.a.a.d();
        if (this.a.a.jdField_a_of_type_Bjxn.a.a() != 102) {
          break;
        }
        bjts.a(this.a.a, this.a.a.jdField_a_of_type_Bjxn.a.a());
        return;
      }
      if (birt.e(this.a.a.jdField_a_of_type_Bjyv.getActivity().getIntent()))
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
        ((Intent)localObject).putExtra("file_path", bjts.a(this.a.a));
        ((Intent)localObject).putExtra("is_video", false);
        this.a.a.jdField_a_of_type_Bjyv.getActivity().sendBroadcast((Intent)localObject);
        this.a.a.jdField_a_of_type_Bjyv.getActivity().setResult(-1, this.a.a.jdField_a_of_type_Bjyv.getActivity().getIntent());
        this.a.a.jdField_a_of_type_Bjyv.getActivity().finish();
        return;
      }
      if (this.a.a.jdField_a_of_type_Bjxn.a.a() != 14) {
        break;
      }
      localIntent = this.a.a.jdField_a_of_type_Bjyv.getActivity().getIntent();
    } while (birt.a(localIntent));
    this.a.a.jdField_a_of_type_Bjxn.b = false;
    this.a.a.jdField_a_of_type_Bjxn.a(0);
    if (bjts.b(this.a.a))
    {
      if (localIntent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {}
      while (i == 0)
      {
        bjzs.a(this.a.a.jdField_a_of_type_Bjyv.getActivity(), bjts.a(this.a.a), bool);
        return;
        bool = false;
      }
      bkmp.a().a(localIntent.getStringExtra("widgetinfo"));
      bkmp.a().a(((bkmo)localObject).jdField_a_of_type_JavaLangString, ((bkmo)localObject).jdField_a_of_type_Int, bjts.a(this.a.a), "", false);
      return;
    }
    bcql.a(this.a.a.jdField_a_of_type_Bjyv.a(), 1, ajya.a(2131703692), 0).a();
    return;
    bcql.a(this.a.a.jdField_a_of_type_Bjyv.a(), 2, ajya.a(2131703694), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1.1
 * JD-Core Version:    0.7.0.1
 */