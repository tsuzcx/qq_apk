package dov.com.tencent.biz.qqstory.takevideo;

import alud;
import android.app.Activity;
import android.content.Intent;
import blat;
import bljn;
import bmjo;
import bmjp;
import bmnj;
import bmor;
import bmpo;
import bnck;
import bncl;
import com.tencent.mobileqq.widget.QQToast;

public class EditPicSave$1$1
  implements Runnable
{
  public EditPicSave$1$1(bmjp parambmjp) {}
  
  public void run()
  {
    boolean bool = true;
    if (bmjo.a(this.a.a)) {}
    int i;
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      if (bmjo.a(this.a.a) == 49) {}
      for (i = 1;; i = 0)
      {
        localObject1 = bmjo.a(this.a.a);
        this.a.a.jdField_a_of_type_Bmnj.a(0);
        this.a.a.jdField_a_of_type_Boolean = true;
        this.a.a.a(100);
        this.a.a.d();
        if (this.a.a.jdField_a_of_type_Bmnj.a.a() != 102) {
          break;
        }
        bmjo.a(this.a.a, this.a.a.jdField_a_of_type_Bmnj.a.a());
        return;
      }
      if (blat.e(this.a.a.jdField_a_of_type_Bmor.getActivity().getIntent()))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
        ((Intent)localObject1).putExtra("file_path", bmjo.a(this.a.a));
        ((Intent)localObject1).putExtra("is_video", false);
        this.a.a.jdField_a_of_type_Bmor.getActivity().sendBroadcast((Intent)localObject1);
        this.a.a.jdField_a_of_type_Bmor.getActivity().setResult(-1, this.a.a.jdField_a_of_type_Bmor.getActivity().getIntent());
        this.a.a.jdField_a_of_type_Bmor.getActivity().finish();
        return;
      }
      if (this.a.a.jdField_a_of_type_Bmnj.a.a() != 14) {
        break;
      }
      localObject2 = this.a.a.jdField_a_of_type_Bmor.getActivity().getIntent();
    } while (blat.a((Intent)localObject2));
    this.a.a.jdField_a_of_type_Bmnj.b = false;
    this.a.a.jdField_a_of_type_Bmnj.a(0);
    if (bmjo.b(this.a.a))
    {
      if (((Intent)localObject2).getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {}
      while (i == 0)
      {
        bmpo.a(this.a.a.jdField_a_of_type_Bmor.getActivity(), bmjo.a(this.a.a), bool);
        return;
        bool = false;
      }
      bncl.a().a(((Intent)localObject2).getStringExtra("widgetinfo"));
      localObject2 = ((Intent)localObject2).getStringExtra("key_camera_material_name");
      bljn.b("EditPicSave", "onPostRun---takeSameName=" + (String)localObject2);
      bncl.a().b((String)localObject2);
      bncl.a().a(((bnck)localObject1).jdField_a_of_type_JavaLangString, ((bnck)localObject1).jdField_a_of_type_Int, bmjo.a(this.a.a), "", false);
      return;
    }
    QQToast.a(this.a.a.jdField_a_of_type_Bmor.a(), 1, alud.a(2131704076), 0).a();
    return;
    QQToast.a(this.a.a.jdField_a_of_type_Bmor.a(), 2, alud.a(2131704078), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1.1
 * JD-Core Version:    0.7.0.1
 */