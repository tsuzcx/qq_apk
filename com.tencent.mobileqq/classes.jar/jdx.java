import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class jdx
  implements Runnable
{
  jdx(VideoController paramVideoController) {}
  
  public void run()
  {
    if (this.a.a() == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "MultiHideCallNotAcceptRunnable");
    }
    this.a.a().L = false;
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(702) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jdx
 * JD-Core Version:    0.7.0.1
 */