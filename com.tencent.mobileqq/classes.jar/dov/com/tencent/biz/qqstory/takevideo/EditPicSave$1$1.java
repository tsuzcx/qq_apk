package dov.com.tencent.biz.qqstory.takevideo;

import ajjy;
import android.app.Activity;
import android.content.Intent;
import bbmy;
import bice;
import bicf;
import bigb;
import bihj;
import biig;
import bivl;
import bivm;
import bjeg;

public class EditPicSave$1$1
  implements Runnable
{
  public EditPicSave$1$1(bicf parambicf) {}
  
  public void run()
  {
    boolean bool = true;
    if (bice.a(this.a.a)) {}
    int i;
    Object localObject;
    Intent localIntent;
    do
    {
      return;
      if (bice.a(this.a.a) == 49) {}
      for (i = 1;; i = 0)
      {
        localObject = bice.a(this.a.a);
        this.a.a.jdField_a_of_type_Bigb.a(0);
        this.a.a.jdField_a_of_type_Boolean = true;
        this.a.a.a(100);
        this.a.a.d();
        if (this.a.a.jdField_a_of_type_Bigb.a.a() != 102) {
          break;
        }
        bice.a(this.a.a, this.a.a.jdField_a_of_type_Bigb.a.a());
        return;
      }
      if (bjeg.j(this.a.a.jdField_a_of_type_Bihj.getActivity().getIntent()))
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
        ((Intent)localObject).putExtra("file_path", bice.a(this.a.a));
        ((Intent)localObject).putExtra("is_video", false);
        this.a.a.jdField_a_of_type_Bihj.getActivity().sendBroadcast((Intent)localObject);
        this.a.a.jdField_a_of_type_Bihj.getActivity().setResult(-1, this.a.a.jdField_a_of_type_Bihj.getActivity().getIntent());
        this.a.a.jdField_a_of_type_Bihj.getActivity().finish();
        return;
      }
      if (this.a.a.jdField_a_of_type_Bigb.a.a() != 14) {
        break;
      }
      localIntent = this.a.a.jdField_a_of_type_Bihj.getActivity().getIntent();
    } while (bjeg.c(localIntent));
    this.a.a.jdField_a_of_type_Bigb.b = false;
    this.a.a.jdField_a_of_type_Bigb.a(0);
    if (bice.b(this.a.a))
    {
      if (localIntent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {}
      while (i == 0)
      {
        biig.a(this.a.a.jdField_a_of_type_Bihj.getActivity(), bice.a(this.a.a), bool);
        return;
        bool = false;
      }
      bivm.a().a(localIntent.getStringExtra("widgetinfo"));
      bivm.a().a(((bivl)localObject).jdField_a_of_type_JavaLangString, ((bivl)localObject).jdField_a_of_type_Int, bice.a(this.a.a), "", false);
      return;
    }
    bbmy.a(this.a.a.jdField_a_of_type_Bihj.a(), 1, ajjy.a(2131637896), 0).a();
    return;
    bbmy.a(this.a.a.jdField_a_of_type_Bihj.a(), 2, ajjy.a(2131637898), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1.1
 * JD-Core Version:    0.7.0.1
 */