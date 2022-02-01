package dov.com.tencent.biz.qqstory.takevideo;

import agaa;
import android.app.Activity;
import bgmg;
import bgmo;
import bnqb;
import bpau;
import bpaw;
import bpep;
import bpfx;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EditPicSave$2$1
  implements Runnable
{
  public EditPicSave$2$1(bpaw parambpaw, String paramString) {}
  
  public void run()
  {
    try
    {
      if (bnqb.e(this.jdField_a_of_type_Bpaw.a.jdField_a_of_type_Bpfx.getActivity().getIntent()))
      {
        bpau.a(this.jdField_a_of_type_Bpaw.a, MiniAppFileManager.getInstance().getTmpPathFromOut(this.jdField_a_of_type_JavaLangString, bpau.a(this.jdField_a_of_type_Bpaw.a, this.jdField_a_of_type_Bpaw.a.jdField_a_of_type_Bpfx.a())));
        bgmg.a(new File(this.jdField_a_of_type_JavaLangString), new File(bpau.a(this.jdField_a_of_type_Bpaw.a)));
        return;
      }
      bpau.a(this.jdField_a_of_type_Bpaw.a, agaa.a());
      File localFile = new File(bpau.a(this.jdField_a_of_type_Bpaw.a));
      if (bgmg.a(new File(this.jdField_a_of_type_JavaLangString), localFile))
      {
        if (this.jdField_a_of_type_Bpaw.a.jdField_a_of_type_Bpep.a.a() == 14) {
          bpau.a(this.jdField_a_of_type_Bpaw.a, true);
        }
        bgmo.a(this.jdField_a_of_type_Bpaw.a.jdField_a_of_type_Bpfx.getActivity(), localFile);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EditPicSave", 2, "savePic " + localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.2.1
 * JD-Core Version:    0.7.0.1
 */