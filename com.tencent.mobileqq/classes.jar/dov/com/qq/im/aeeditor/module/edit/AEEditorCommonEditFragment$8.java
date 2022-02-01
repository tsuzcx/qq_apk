package dov.com.qq.im.aeeditor.module.edit;

import android.support.v4.app.FragmentActivity;
import beum;
import beuo;
import bevn;
import bhnv;
import bpbn;
import bpgd;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AEEditorCommonEditFragment$8
  implements Runnable
{
  AEEditorCommonEditFragment$8(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void run()
  {
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = new bpgd(this);
    localbeum.jdField_a_of_type_JavaLangString = "https://downv6.qq.com/shadow_qqcamera/ProcessAnimation_b9f8fc550f1535b445b564bfbe0d82c5.zip";
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.jdField_c_of_type_JavaLangString = new File(bpbn.e).getPath();
    localbeum.b = bhnv.a(bevn.a().a());
    localbeum.jdField_c_of_type_Long = 30000L;
    try
    {
      this.this$0.getActivity().getAppInterface().getNetEngine(0).a(localbeum);
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