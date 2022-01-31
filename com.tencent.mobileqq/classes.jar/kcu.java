import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.VideoLayerUI.TouchListener;
import com.tencent.qphone.base.util.QLog;

public class kcu
  implements Runnable
{
  public kcu(VideoLayerUI.TouchListener paramTouchListener) {}
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      VideoLayerUI.TouchListener.a(this.a, true);
      this.a.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(119), Integer.valueOf(1), Float.valueOf(VideoLayerUI.TouchListener.a(this.a)), Float.valueOf(VideoLayerUI.TouchListener.b(this.a)) });
      if (QLog.isColorLevel()) {
        QLog.e(this.a.a.jdField_a_of_type_JavaLangString, 2, "[childLock] trigger animation");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kcu
 * JD-Core Version:    0.7.0.1
 */