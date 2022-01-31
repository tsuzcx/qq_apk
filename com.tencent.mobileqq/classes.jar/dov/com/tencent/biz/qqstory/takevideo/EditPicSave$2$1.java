package dov.com.tencent.biz.qqstory.takevideo;

import acxs;
import android.app.Activity;
import bbdx;
import bbef;
import birt;
import bjts;
import bjtu;
import bjxn;
import bjyv;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EditPicSave$2$1
  implements Runnable
{
  public EditPicSave$2$1(bjtu parambjtu, String paramString) {}
  
  public void run()
  {
    try
    {
      if (birt.e(this.jdField_a_of_type_Bjtu.a.jdField_a_of_type_Bjyv.getActivity().getIntent()))
      {
        bjts.a(this.jdField_a_of_type_Bjtu.a, MiniAppFileManager.getInstance().getTmpPathFromOut(this.jdField_a_of_type_JavaLangString, bjts.a(this.jdField_a_of_type_Bjtu.a, this.jdField_a_of_type_Bjtu.a.jdField_a_of_type_Bjyv.a())));
        bbdx.a(new File(this.jdField_a_of_type_JavaLangString), new File(bjts.a(this.jdField_a_of_type_Bjtu.a)));
        return;
      }
      bjts.a(this.jdField_a_of_type_Bjtu.a, acxs.a());
      File localFile = new File(bjts.a(this.jdField_a_of_type_Bjtu.a));
      if (bbdx.a(new File(this.jdField_a_of_type_JavaLangString), localFile))
      {
        if (this.jdField_a_of_type_Bjtu.a.jdField_a_of_type_Bjxn.a.a() == 14) {
          bjts.a(this.jdField_a_of_type_Bjtu.a, true);
        }
        bbef.a(this.jdField_a_of_type_Bjtu.a.jdField_a_of_type_Bjyv.getActivity(), localFile);
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