package dov.com.tencent.biz.qqstory.takevideo;

import aepf;
import android.app.Activity;
import bdcs;
import bdda;
import bkwm;
import bmfc;
import bmfe;
import bmix;
import bmkf;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EditPicSave$2$1
  implements Runnable
{
  public EditPicSave$2$1(bmfe parambmfe, String paramString) {}
  
  public void run()
  {
    try
    {
      if (bkwm.e(this.jdField_a_of_type_Bmfe.a.jdField_a_of_type_Bmkf.getActivity().getIntent()))
      {
        bmfc.a(this.jdField_a_of_type_Bmfe.a, MiniAppFileManager.getInstance().getTmpPathFromOut(this.jdField_a_of_type_JavaLangString, bmfc.a(this.jdField_a_of_type_Bmfe.a, this.jdField_a_of_type_Bmfe.a.jdField_a_of_type_Bmkf.a())));
        bdcs.a(new File(this.jdField_a_of_type_JavaLangString), new File(bmfc.a(this.jdField_a_of_type_Bmfe.a)));
        return;
      }
      bmfc.a(this.jdField_a_of_type_Bmfe.a, aepf.a());
      File localFile = new File(bmfc.a(this.jdField_a_of_type_Bmfe.a));
      if (bdcs.a(new File(this.jdField_a_of_type_JavaLangString), localFile))
      {
        if (this.jdField_a_of_type_Bmfe.a.jdField_a_of_type_Bmix.a.a() == 14) {
          bmfc.a(this.jdField_a_of_type_Bmfe.a, true);
        }
        bdda.a(this.jdField_a_of_type_Bmfe.a.jdField_a_of_type_Bmkf.getActivity(), localFile);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.2.1
 * JD-Core Version:    0.7.0.1
 */