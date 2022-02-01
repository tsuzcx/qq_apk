package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import anni;
import bnqb;
import bnzb;
import bpau;
import bpav;
import bpep;
import bpfx;
import bpgu;
import bptq;
import bptr;
import com.tencent.mobileqq.widget.QQToast;

public class EditPicSave$1$1
  implements Runnable
{
  public EditPicSave$1$1(bpav parambpav) {}
  
  public void run()
  {
    boolean bool = true;
    if (bpau.a(this.a.a)) {}
    int i;
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      if (bpau.a(this.a.a) == 49) {}
      for (i = 1;; i = 0)
      {
        localObject1 = bpau.a(this.a.a);
        this.a.a.jdField_a_of_type_Bpep.a(0);
        this.a.a.jdField_a_of_type_Boolean = true;
        this.a.a.a(100);
        this.a.a.d();
        if (this.a.a.jdField_a_of_type_Bpep.a.a() != 102) {
          break;
        }
        bpau.a(this.a.a, this.a.a.jdField_a_of_type_Bpep.a.a());
        return;
      }
      if (bnqb.e(this.a.a.jdField_a_of_type_Bpfx.getActivity().getIntent()))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
        ((Intent)localObject1).putExtra("file_path", bpau.a(this.a.a));
        ((Intent)localObject1).putExtra("is_video", false);
        this.a.a.jdField_a_of_type_Bpfx.getActivity().sendBroadcast((Intent)localObject1);
        this.a.a.jdField_a_of_type_Bpfx.getActivity().setResult(-1, this.a.a.jdField_a_of_type_Bpfx.getActivity().getIntent());
        this.a.a.jdField_a_of_type_Bpfx.getActivity().finish();
        return;
      }
      if (this.a.a.jdField_a_of_type_Bpep.a.a() != 14) {
        break;
      }
      localObject2 = this.a.a.jdField_a_of_type_Bpfx.getActivity().getIntent();
    } while (bnqb.a((Intent)localObject2));
    this.a.a.jdField_a_of_type_Bpep.b = false;
    this.a.a.jdField_a_of_type_Bpep.a(0);
    if (bpau.b(this.a.a))
    {
      if (((Intent)localObject2).getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {}
      while (i == 0)
      {
        bpgu.a(this.a.a.jdField_a_of_type_Bpfx.getActivity(), bpau.a(this.a.a), bool);
        return;
        bool = false;
      }
      bptr.a().a(((Intent)localObject2).getStringExtra("widgetinfo"));
      localObject2 = ((Intent)localObject2).getStringExtra("key_camera_material_name");
      bnzb.b("EditPicSave", "onPostRun---takeSameName=" + (String)localObject2);
      bptr.a().b((String)localObject2);
      bptr.a().a(((bptq)localObject1).jdField_a_of_type_JavaLangString, ((bptq)localObject1).jdField_a_of_type_Int, bpau.a(this.a.a), "", false);
      return;
    }
    QQToast.a(this.a.a.jdField_a_of_type_Bpfx.a(), 1, anni.a(2131702473), 0).a();
    return;
    QQToast.a(this.a.a.jdField_a_of_type_Bpfx.a(), 2, anni.a(2131702475), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1.1
 * JD-Core Version:    0.7.0.1
 */