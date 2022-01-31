package dov.com.tencent.biz.qqstory.takevideo;

import aetu;
import android.app.Activity;
import bdhb;
import bdhj;
import blat;
import bmjo;
import bmjq;
import bmnj;
import bmor;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EditPicSave$2$1
  implements Runnable
{
  public EditPicSave$2$1(bmjq parambmjq, String paramString) {}
  
  public void run()
  {
    try
    {
      if (blat.e(this.jdField_a_of_type_Bmjq.a.jdField_a_of_type_Bmor.getActivity().getIntent()))
      {
        bmjo.a(this.jdField_a_of_type_Bmjq.a, MiniAppFileManager.getInstance().getTmpPathFromOut(this.jdField_a_of_type_JavaLangString, bmjo.a(this.jdField_a_of_type_Bmjq.a, this.jdField_a_of_type_Bmjq.a.jdField_a_of_type_Bmor.a())));
        bdhb.a(new File(this.jdField_a_of_type_JavaLangString), new File(bmjo.a(this.jdField_a_of_type_Bmjq.a)));
        return;
      }
      bmjo.a(this.jdField_a_of_type_Bmjq.a, aetu.a());
      File localFile = new File(bmjo.a(this.jdField_a_of_type_Bmjq.a));
      if (bdhb.a(new File(this.jdField_a_of_type_JavaLangString), localFile))
      {
        if (this.jdField_a_of_type_Bmjq.a.jdField_a_of_type_Bmnj.a.a() == 14) {
          bmjo.a(this.jdField_a_of_type_Bmjq.a, true);
        }
        bdhj.a(this.jdField_a_of_type_Bmjq.a.jdField_a_of_type_Bmor.getActivity(), localFile);
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