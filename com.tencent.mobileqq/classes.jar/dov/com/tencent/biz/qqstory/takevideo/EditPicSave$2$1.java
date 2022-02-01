package dov.com.tencent.biz.qqstory.takevideo;

import aftr;
import android.app.Activity;
import bheg;
import bnlb;
import bosl;
import bosn;
import botw;
import bouo;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EditPicSave$2$1
  implements Runnable
{
  public EditPicSave$2$1(bosn parambosn, String paramString) {}
  
  public void run()
  {
    try
    {
      if (bnlb.e(this.jdField_a_of_type_Bosn.a.jdField_a_of_type_Bouo.getActivity().getIntent()))
      {
        bosl.a(this.jdField_a_of_type_Bosn.a, MiniAppFileManager.getInstance().getTmpPathFromOut(this.jdField_a_of_type_JavaLangString, bosl.a(this.jdField_a_of_type_Bosn.a, this.jdField_a_of_type_Bosn.a.jdField_a_of_type_Bouo.a())));
        FileUtils.copyFile(new File(this.jdField_a_of_type_JavaLangString), new File(bosl.a(this.jdField_a_of_type_Bosn.a)));
        return;
      }
      bosl.a(this.jdField_a_of_type_Bosn.a, aftr.a());
      File localFile = new File(bosl.a(this.jdField_a_of_type_Bosn.a));
      if (FileUtils.copyFile(new File(this.jdField_a_of_type_JavaLangString), localFile))
      {
        if (this.jdField_a_of_type_Bosn.a.jdField_a_of_type_Botw.a.a() == 14) {
          bosl.a(this.jdField_a_of_type_Bosn.a, true);
        }
        bheg.a(this.jdField_a_of_type_Bosn.a.jdField_a_of_type_Bouo.getActivity(), localFile);
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