package dov.com.tencent.biz.qqstory.takevideo;

import agju;
import android.app.Activity;
import bhmi;
import bhmq;
import born;
import bqcp;
import bqcr;
import bqgk;
import bqhs;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EditPicSave$2$1
  implements Runnable
{
  public EditPicSave$2$1(bqcr parambqcr, String paramString) {}
  
  public void run()
  {
    try
    {
      if (born.e(this.jdField_a_of_type_Bqcr.a.jdField_a_of_type_Bqhs.getActivity().getIntent()))
      {
        bqcp.a(this.jdField_a_of_type_Bqcr.a, MiniAppFileManager.getInstance().getTmpPathFromOut(this.jdField_a_of_type_JavaLangString, bqcp.a(this.jdField_a_of_type_Bqcr.a, this.jdField_a_of_type_Bqcr.a.jdField_a_of_type_Bqhs.a())));
        bhmi.a(new File(this.jdField_a_of_type_JavaLangString), new File(bqcp.a(this.jdField_a_of_type_Bqcr.a)));
        return;
      }
      bqcp.a(this.jdField_a_of_type_Bqcr.a, agju.a());
      File localFile = new File(bqcp.a(this.jdField_a_of_type_Bqcr.a));
      if (bhmi.a(new File(this.jdField_a_of_type_JavaLangString), localFile))
      {
        if (this.jdField_a_of_type_Bqcr.a.jdField_a_of_type_Bqgk.a.a() == 14) {
          bqcp.a(this.jdField_a_of_type_Bqcr.a, true);
        }
        bhmq.a(this.jdField_a_of_type_Bqcr.a.jdField_a_of_type_Bqhs.getActivity(), localFile);
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