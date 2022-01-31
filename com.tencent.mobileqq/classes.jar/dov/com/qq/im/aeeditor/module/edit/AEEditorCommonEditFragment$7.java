package dov.com.qq.im.aeeditor.module.edit;

import android.support.v4.app.FragmentActivity;
import baps;
import bapv;
import baqx;
import bdee;
import blfu;
import blig;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AEEditorCommonEditFragment$7
  implements Runnable
{
  AEEditorCommonEditFragment$7(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void run()
  {
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_Bapx = new blig(this);
    localbaps.jdField_a_of_type_JavaLangString = "http://down.qq.com/shadow_qqcamera/ProcessAnimation_270bd05f3b639a247bc5c1adf21be6a5.zip";
    localbaps.jdField_a_of_type_Int = 0;
    localbaps.jdField_c_of_type_JavaLangString = new File(blfu.e).getPath();
    localbaps.jdField_c_of_type_Int = bdee.a(baqx.a().a());
    localbaps.jdField_c_of_type_Long = 30000L;
    try
    {
      this.this$0.getActivity().getAppInterface().getNetEngine(0).a(localbaps);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.7
 * JD-Core Version:    0.7.0.1
 */