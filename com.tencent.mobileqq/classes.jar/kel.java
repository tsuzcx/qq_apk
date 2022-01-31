import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.VideoLayerUIBase;
import com.tencent.qphone.base.util.QLog;

public class kel
  implements Runnable
{
  public kel(VideoLayerUIBase paramVideoLayerUIBase) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {}
    try
    {
      String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
      this.a.jdField_a_of_type_ComTencentAvVideoController.b(str);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "pauseVideo Runnable exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kel
 * JD-Core Version:    0.7.0.1
 */