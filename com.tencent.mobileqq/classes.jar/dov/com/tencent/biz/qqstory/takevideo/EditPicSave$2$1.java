package dov.com.tencent.biz.qqstory.takevideo;

import afcm;
import android.app.Activity;
import bfvo;
import blvr;
import bnct;
import bncv;
import bnee;
import bnew;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EditPicSave$2$1
  implements Runnable
{
  public EditPicSave$2$1(bncv parambncv, String paramString) {}
  
  public void run()
  {
    try
    {
      if (blvr.e(this.jdField_a_of_type_Bncv.a.jdField_a_of_type_Bnew.getActivity().getIntent()))
      {
        bnct.a(this.jdField_a_of_type_Bncv.a, MiniAppFileManager.getInstance().getTmpPathFromOut(this.jdField_a_of_type_JavaLangString, bnct.a(this.jdField_a_of_type_Bncv.a, this.jdField_a_of_type_Bncv.a.jdField_a_of_type_Bnew.a())));
        FileUtils.copyFile(new File(this.jdField_a_of_type_JavaLangString), new File(bnct.a(this.jdField_a_of_type_Bncv.a)));
        return;
      }
      bnct.a(this.jdField_a_of_type_Bncv.a, afcm.a());
      File localFile = new File(bnct.a(this.jdField_a_of_type_Bncv.a));
      if (FileUtils.copyFile(new File(this.jdField_a_of_type_JavaLangString), localFile))
      {
        if (this.jdField_a_of_type_Bncv.a.jdField_a_of_type_Bnee.a.a() == 14) {
          bnct.a(this.jdField_a_of_type_Bncv.a, true);
        }
        bfvo.a(this.jdField_a_of_type_Bncv.a.jdField_a_of_type_Bnew.getActivity(), localFile);
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