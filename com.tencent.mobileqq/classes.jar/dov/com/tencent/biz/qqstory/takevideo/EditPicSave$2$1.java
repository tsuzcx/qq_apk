package dov.com.tencent.biz.qqstory.takevideo;

import acxv;
import android.app.Activity;
import bbdj;
import bbdr;
import birc;
import bjtb;
import bjtd;
import bjww;
import bjye;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EditPicSave$2$1
  implements Runnable
{
  public EditPicSave$2$1(bjtd parambjtd, String paramString) {}
  
  public void run()
  {
    try
    {
      if (birc.e(this.jdField_a_of_type_Bjtd.a.jdField_a_of_type_Bjye.getActivity().getIntent()))
      {
        bjtb.a(this.jdField_a_of_type_Bjtd.a, MiniAppFileManager.getInstance().getTmpPathFromOut(this.jdField_a_of_type_JavaLangString, bjtb.a(this.jdField_a_of_type_Bjtd.a, this.jdField_a_of_type_Bjtd.a.jdField_a_of_type_Bjye.a())));
        bbdj.a(new File(this.jdField_a_of_type_JavaLangString), new File(bjtb.a(this.jdField_a_of_type_Bjtd.a)));
        return;
      }
      bjtb.a(this.jdField_a_of_type_Bjtd.a, acxv.a());
      File localFile = new File(bjtb.a(this.jdField_a_of_type_Bjtd.a));
      if (bbdj.a(new File(this.jdField_a_of_type_JavaLangString), localFile))
      {
        if (this.jdField_a_of_type_Bjtd.a.jdField_a_of_type_Bjww.a.a() == 14) {
          bjtb.a(this.jdField_a_of_type_Bjtd.a, true);
        }
        bbdr.a(this.jdField_a_of_type_Bjtd.a.jdField_a_of_type_Bjye.getActivity(), localFile);
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