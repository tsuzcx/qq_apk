package dov.com.tencent.biz.qqstory.takevideo;

import amtj;
import android.app.Activity;
import android.content.Intent;
import blvr;
import bmbx;
import bnct;
import bncu;
import bnee;
import bnew;
import bnfm;
import bnpz;
import bnqa;
import com.tencent.mobileqq.widget.QQToast;

public class EditPicSave$1$1
  implements Runnable
{
  public EditPicSave$1$1(bncu parambncu) {}
  
  public void run()
  {
    boolean bool = true;
    if (bnct.a(this.a.a)) {}
    int i;
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      if (bnct.a(this.a.a) == 20) {}
      for (i = 1;; i = 0)
      {
        localObject1 = bnct.a(this.a.a);
        this.a.a.jdField_a_of_type_Bnee.a(0);
        this.a.a.jdField_a_of_type_Boolean = true;
        this.a.a.a(100);
        this.a.a.c();
        if (this.a.a.jdField_a_of_type_Bnee.a.a() != 102) {
          break;
        }
        bnct.a(this.a.a, this.a.a.jdField_a_of_type_Bnee.a.a());
        return;
      }
      if (blvr.e(this.a.a.jdField_a_of_type_Bnew.getActivity().getIntent()))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
        ((Intent)localObject1).putExtra("file_path", bnct.a(this.a.a));
        ((Intent)localObject1).putExtra("is_video", false);
        this.a.a.jdField_a_of_type_Bnew.getActivity().sendBroadcast((Intent)localObject1);
        this.a.a.jdField_a_of_type_Bnew.getActivity().setResult(-1, this.a.a.jdField_a_of_type_Bnew.getActivity().getIntent());
        this.a.a.jdField_a_of_type_Bnew.getActivity().finish();
        return;
      }
      if (this.a.a.jdField_a_of_type_Bnee.a.a() != 14) {
        break;
      }
      localObject2 = this.a.a.jdField_a_of_type_Bnew.getActivity().getIntent();
    } while (blvr.a((Intent)localObject2));
    this.a.a.jdField_a_of_type_Bnee.b = false;
    this.a.a.jdField_a_of_type_Bnee.a(0);
    if (bnct.b(this.a.a))
    {
      if (((Intent)localObject2).getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {}
      while (i == 0)
      {
        bnfm.a(this.a.a.jdField_a_of_type_Bnew.getActivity(), bnct.a(this.a.a), bool);
        return;
        bool = false;
      }
      bnqa.a().a(((Intent)localObject2).getStringExtra("widgetinfo"));
      localObject2 = ((Intent)localObject2).getStringExtra("key_camera_material_name");
      bmbx.b("EditPicSave", "onPostRun---takeSameName=" + (String)localObject2);
      bnqa.a().b((String)localObject2);
      bnqa.a().a(((bnpz)localObject1).jdField_a_of_type_JavaLangString, ((bnpz)localObject1).jdField_a_of_type_Int, bnct.a(this.a.a), "", false);
      return;
    }
    QQToast.a(this.a.a.jdField_a_of_type_Bnew.a(), 1, amtj.a(2131702815), 0).a();
    return;
    QQToast.a(this.a.a.jdField_a_of_type_Bnew.a(), 2, amtj.a(2131702817), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1.1
 * JD-Core Version:    0.7.0.1
 */