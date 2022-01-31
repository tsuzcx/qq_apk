import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI;
import com.tencent.av.smallscreen.SmallScreenVideoController;

public class joy
  implements Runnable
{
  public joy(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI instanceof SmallScreenDoubleVideoControlUI))
    {
      String str = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().P;
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(42), str, Integer.valueOf(i) });
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     joy
 * JD-Core Version:    0.7.0.1
 */