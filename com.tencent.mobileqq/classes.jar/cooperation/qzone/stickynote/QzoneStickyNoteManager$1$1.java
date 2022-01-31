package cooperation.qzone.stickynote;

import android.os.Handler;
import bjho;
import bjtj;
import bjtk;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;

public class QzoneStickyNoteManager$1$1
  implements Runnable
{
  public QzoneStickyNoteManager$1$1(bjtk parambjtk) {}
  
  public void run()
  {
    try
    {
      QzonePluginProxyActivity.a(this.a.jdField_a_of_type_AndroidAppActivity);
      boolean bool = bjho.b(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((bjho.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (bool)) {
        bjtj.a(this.a.jdField_a_of_type_Bjtj).post(new QzoneStickyNoteManager.1.1.1(this));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("QzoneStickyNoteManager", 1, "tryLoadQzonePlugin: failed to load qzone plugin");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.stickynote.QzoneStickyNoteManager.1.1
 * JD-Core Version:    0.7.0.1
 */