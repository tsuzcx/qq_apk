package dov.com.tencent.biz.qqstory.takevideo;

import acnc;
import android.app.Activity;
import bace;
import bacm;
import bice;
import bicg;
import bigb;
import bihj;
import bjeg;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EditPicSave$2$1
  implements Runnable
{
  public EditPicSave$2$1(bicg parambicg, String paramString) {}
  
  public void run()
  {
    try
    {
      if (bjeg.j(this.jdField_a_of_type_Bicg.a.jdField_a_of_type_Bihj.getActivity().getIntent()))
      {
        bice.a(this.jdField_a_of_type_Bicg.a, MiniAppFileManager.getInstance().getTmpPathFromOut(this.jdField_a_of_type_JavaLangString, bice.a(this.jdField_a_of_type_Bicg.a, this.jdField_a_of_type_Bicg.a.jdField_a_of_type_Bihj.a())));
        bace.a(new File(this.jdField_a_of_type_JavaLangString), new File(bice.a(this.jdField_a_of_type_Bicg.a)));
        return;
      }
      bice.a(this.jdField_a_of_type_Bicg.a, acnc.a());
      File localFile = new File(bice.a(this.jdField_a_of_type_Bicg.a));
      if (bace.a(new File(this.jdField_a_of_type_JavaLangString), localFile))
      {
        if (this.jdField_a_of_type_Bicg.a.jdField_a_of_type_Bigb.a.a() == 14) {
          bice.a(this.jdField_a_of_type_Bicg.a, true);
        }
        bacm.a(this.jdField_a_of_type_Bicg.a.jdField_a_of_type_Bihj.getActivity(), localFile);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.2.1
 * JD-Core Version:    0.7.0.1
 */