package dov.com.tencent.biz.qqstory.takevideo;

import alpo;
import android.app.Activity;
import android.content.Intent;
import bkwm;
import blfg;
import bmfc;
import bmfd;
import bmix;
import bmkf;
import bmlc;
import bmxy;
import bmxz;
import com.tencent.mobileqq.widget.QQToast;

public class EditPicSave$1$1
  implements Runnable
{
  public EditPicSave$1$1(bmfd parambmfd) {}
  
  public void run()
  {
    boolean bool = true;
    if (bmfc.a(this.a.a)) {}
    int i;
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      if (bmfc.a(this.a.a) == 49) {}
      for (i = 1;; i = 0)
      {
        localObject1 = bmfc.a(this.a.a);
        this.a.a.jdField_a_of_type_Bmix.a(0);
        this.a.a.jdField_a_of_type_Boolean = true;
        this.a.a.a(100);
        this.a.a.d();
        if (this.a.a.jdField_a_of_type_Bmix.a.a() != 102) {
          break;
        }
        bmfc.a(this.a.a, this.a.a.jdField_a_of_type_Bmix.a.a());
        return;
      }
      if (bkwm.e(this.a.a.jdField_a_of_type_Bmkf.getActivity().getIntent()))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
        ((Intent)localObject1).putExtra("file_path", bmfc.a(this.a.a));
        ((Intent)localObject1).putExtra("is_video", false);
        this.a.a.jdField_a_of_type_Bmkf.getActivity().sendBroadcast((Intent)localObject1);
        this.a.a.jdField_a_of_type_Bmkf.getActivity().setResult(-1, this.a.a.jdField_a_of_type_Bmkf.getActivity().getIntent());
        this.a.a.jdField_a_of_type_Bmkf.getActivity().finish();
        return;
      }
      if (this.a.a.jdField_a_of_type_Bmix.a.a() != 14) {
        break;
      }
      localObject2 = this.a.a.jdField_a_of_type_Bmkf.getActivity().getIntent();
    } while (bkwm.a((Intent)localObject2));
    this.a.a.jdField_a_of_type_Bmix.b = false;
    this.a.a.jdField_a_of_type_Bmix.a(0);
    if (bmfc.b(this.a.a))
    {
      if (((Intent)localObject2).getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {}
      while (i == 0)
      {
        bmlc.a(this.a.a.jdField_a_of_type_Bmkf.getActivity(), bmfc.a(this.a.a), bool);
        return;
        bool = false;
      }
      bmxz.a().a(((Intent)localObject2).getStringExtra("widgetinfo"));
      localObject2 = ((Intent)localObject2).getStringExtra("key_camera_material_name");
      blfg.b("EditPicSave", "onPostRun---takeSameName=" + (String)localObject2);
      bmxz.a().b((String)localObject2);
      bmxz.a().a(((bmxy)localObject1).jdField_a_of_type_JavaLangString, ((bmxy)localObject1).jdField_a_of_type_Int, bmfc.a(this.a.a), "", false);
      return;
    }
    QQToast.a(this.a.a.jdField_a_of_type_Bmkf.a(), 1, alpo.a(2131704064), 0).a();
    return;
    QQToast.a(this.a.a.jdField_a_of_type_Bmkf.a(), 2, alpo.a(2131704066), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1.1
 * JD-Core Version:    0.7.0.1
 */