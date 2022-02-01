package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import anzj;
import born;
import bpam;
import bqcp;
import bqcq;
import bqgk;
import bqhs;
import bqip;
import bqvl;
import bqvm;
import com.tencent.mobileqq.widget.QQToast;

public class EditPicSave$1$1
  implements Runnable
{
  public EditPicSave$1$1(bqcq parambqcq) {}
  
  public void run()
  {
    boolean bool = true;
    if (bqcp.a(this.a.a)) {}
    int i;
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      if (bqcp.a(this.a.a) == 49) {}
      for (i = 1;; i = 0)
      {
        localObject1 = bqcp.a(this.a.a);
        this.a.a.jdField_a_of_type_Bqgk.a(0);
        this.a.a.jdField_a_of_type_Boolean = true;
        this.a.a.a(100);
        this.a.a.d();
        if (this.a.a.jdField_a_of_type_Bqgk.a.a() != 102) {
          break;
        }
        bqcp.a(this.a.a, this.a.a.jdField_a_of_type_Bqgk.a.a());
        return;
      }
      if (born.e(this.a.a.jdField_a_of_type_Bqhs.getActivity().getIntent()))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
        ((Intent)localObject1).putExtra("file_path", bqcp.a(this.a.a));
        ((Intent)localObject1).putExtra("is_video", false);
        this.a.a.jdField_a_of_type_Bqhs.getActivity().sendBroadcast((Intent)localObject1);
        this.a.a.jdField_a_of_type_Bqhs.getActivity().setResult(-1, this.a.a.jdField_a_of_type_Bqhs.getActivity().getIntent());
        this.a.a.jdField_a_of_type_Bqhs.getActivity().finish();
        return;
      }
      if (this.a.a.jdField_a_of_type_Bqgk.a.a() != 14) {
        break;
      }
      localObject2 = this.a.a.jdField_a_of_type_Bqhs.getActivity().getIntent();
    } while (born.a((Intent)localObject2));
    this.a.a.jdField_a_of_type_Bqgk.b = false;
    this.a.a.jdField_a_of_type_Bqgk.a(0);
    if (bqcp.b(this.a.a))
    {
      if (((Intent)localObject2).getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {}
      while (i == 0)
      {
        bqip.a(this.a.a.jdField_a_of_type_Bqhs.getActivity(), bqcp.a(this.a.a), bool);
        return;
        bool = false;
      }
      bqvm.a().a(((Intent)localObject2).getStringExtra("widgetinfo"));
      localObject2 = ((Intent)localObject2).getStringExtra("key_camera_material_name");
      bpam.b("EditPicSave", "onPostRun---takeSameName=" + (String)localObject2);
      bqvm.a().b((String)localObject2);
      bqvm.a().a(((bqvl)localObject1).jdField_a_of_type_JavaLangString, ((bqvl)localObject1).jdField_a_of_type_Int, bqcp.a(this.a.a), "", false);
      return;
    }
    QQToast.a(this.a.a.jdField_a_of_type_Bqhs.a(), 1, anzj.a(2131702580), 0).a();
    return;
    QQToast.a(this.a.a.jdField_a_of_type_Bqhs.a(), 2, anzj.a(2131702582), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1.1
 * JD-Core Version:    0.7.0.1
 */