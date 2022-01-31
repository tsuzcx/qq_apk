import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class jdw
  implements Runnable
{
  public jdw(VideoController paramVideoController) {}
  
  public void run()
  {
    if (this.a.a() == null) {}
    do
    {
      int i;
      do
      {
        do
        {
          return;
        } while ((!this.a.a().n()) || (!this.a.a().af));
        if (QLog.isColorLevel()) {
          QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "MultiCheckCallNotAcceptRunnable");
        }
        i = this.a.c().size();
      } while (i <= 0);
      this.a.a().L = true;
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(701), Integer.valueOf(i) });
    } while ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() == null));
    if (this.a.jdField_a_of_type_Jdx == null) {
      this.a.jdField_a_of_type_Jdx = new jdx(this.a);
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_a_of_type_Jdx);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_Jdx, this.a.i * 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jdw
 * JD-Core Version:    0.7.0.1
 */