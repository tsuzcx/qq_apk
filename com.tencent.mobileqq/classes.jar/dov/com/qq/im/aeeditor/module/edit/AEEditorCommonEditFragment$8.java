package dov.com.qq.im.aeeditor.module.edit;

import android.support.v4.app.FragmentActivity;
import baub;
import baue;
import bavg;
import bdin;
import blkb;
import blmq;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AEEditorCommonEditFragment$8
  implements Runnable
{
  AEEditorCommonEditFragment$8(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void run()
  {
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = new blmq(this);
    localbaub.jdField_a_of_type_JavaLangString = "https://down.qq.com/shadow_qqcamera/ProcessAnimation_b9f8fc550f1535b445b564bfbe0d82c5.zip";
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.jdField_c_of_type_JavaLangString = new File(blkb.e).getPath();
    localbaub.jdField_c_of_type_Int = bdin.a(bavg.a().a());
    localbaub.jdField_c_of_type_Long = 30000L;
    try
    {
      this.this$0.getActivity().getAppInterface().getNetEngine(0).a(localbaub);
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
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.8
 * JD-Core Version:    0.7.0.1
 */