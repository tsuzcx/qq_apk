package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import anvx;
import bnlb;
import bnrh;
import bosl;
import bosm;
import botw;
import bouo;
import bove;
import bpfr;
import bpfs;
import com.tencent.mobileqq.widget.QQToast;

public class EditPicSave$1$1
  implements Runnable
{
  public EditPicSave$1$1(bosm parambosm) {}
  
  public void run()
  {
    boolean bool = true;
    if (bosl.a(this.a.a)) {}
    int i;
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      if (bosl.a(this.a.a) == 20) {}
      for (i = 1;; i = 0)
      {
        localObject1 = bosl.a(this.a.a);
        this.a.a.jdField_a_of_type_Botw.a(0);
        this.a.a.jdField_a_of_type_Boolean = true;
        this.a.a.a(100);
        this.a.a.c();
        if (this.a.a.jdField_a_of_type_Botw.a.a() != 102) {
          break;
        }
        bosl.a(this.a.a, this.a.a.jdField_a_of_type_Botw.a.a());
        return;
      }
      if (bnlb.e(this.a.a.jdField_a_of_type_Bouo.getActivity().getIntent()))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
        ((Intent)localObject1).putExtra("file_path", bosl.a(this.a.a));
        ((Intent)localObject1).putExtra("is_video", false);
        this.a.a.jdField_a_of_type_Bouo.getActivity().sendBroadcast((Intent)localObject1);
        this.a.a.jdField_a_of_type_Bouo.getActivity().setResult(-1, this.a.a.jdField_a_of_type_Bouo.getActivity().getIntent());
        this.a.a.jdField_a_of_type_Bouo.getActivity().finish();
        return;
      }
      if (this.a.a.jdField_a_of_type_Botw.a.a() != 14) {
        break;
      }
      localObject2 = this.a.a.jdField_a_of_type_Bouo.getActivity().getIntent();
    } while (bnlb.a((Intent)localObject2));
    this.a.a.jdField_a_of_type_Botw.b = false;
    this.a.a.jdField_a_of_type_Botw.a(0);
    if (bosl.b(this.a.a))
    {
      if (((Intent)localObject2).getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {}
      while (i == 0)
      {
        bove.a(this.a.a.jdField_a_of_type_Bouo.getActivity(), bosl.a(this.a.a), bool);
        return;
        bool = false;
      }
      bpfs.a().a(((Intent)localObject2).getStringExtra("widgetinfo"));
      localObject2 = ((Intent)localObject2).getStringExtra("key_camera_material_name");
      bnrh.b("EditPicSave", "onPostRun---takeSameName=" + (String)localObject2);
      bpfs.a().b((String)localObject2);
      bpfs.a().a(((bpfr)localObject1).jdField_a_of_type_JavaLangString, ((bpfr)localObject1).jdField_a_of_type_Int, bosl.a(this.a.a), "", false);
      return;
    }
    QQToast.a(this.a.a.jdField_a_of_type_Bouo.a(), 1, anvx.a(2131703166), 0).a();
    return;
    QQToast.a(this.a.a.jdField_a_of_type_Bouo.a(), 2, anvx.a(2131703168), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1.1
 * JD-Core Version:    0.7.0.1
 */