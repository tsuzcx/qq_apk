package dov.com.qq.im.aeeditor.module.edit;

import android.support.v4.app.FragmentActivity;
import bdvs;
import bdvu;
import bdwu;
import bgnt;
import bnzs;
import boei;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AEEditorCommonEditFragment$8
  implements Runnable
{
  AEEditorCommonEditFragment$8(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void run()
  {
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = new boei(this);
    localbdvs.jdField_a_of_type_JavaLangString = "https://downv6.qq.com/shadow_qqcamera/ProcessAnimation_b9f8fc550f1535b445b564bfbe0d82c5.zip";
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.jdField_c_of_type_JavaLangString = new File(bnzs.e).getPath();
    localbdvs.b = bgnt.a(bdwu.a().a());
    localbdvs.jdField_c_of_type_Long = 30000L;
    try
    {
      this.this$0.getActivity().getAppInterface().getNetEngine(0).a(localbdvs);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.8
 * JD-Core Version:    0.7.0.1
 */