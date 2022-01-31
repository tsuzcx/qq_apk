import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenVideoController;
import com.tencent.av.smallscreen.SmallScreenVideoLayerUI;
import java.util.Timer;
import java.util.TimerTask;

public class jqx
  extends TimerTask
{
  public jqx(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    long l1;
    long l2;
    do
    {
      do
      {
        SessionInfo localSessionInfo;
        do
        {
          return;
          localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
        } while (localSessionInfo == null);
        if (localSessionInfo.Q > 0) {
          break;
        }
      } while (this.a.jdField_a_of_type_JavaUtilTimer == null);
      this.a.jdField_a_of_type_JavaUtilTimer.cancel();
      this.a.jdField_a_of_type_JavaUtilTimer = null;
      return;
      l1 = this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c);
      l2 = System.currentTimeMillis();
    } while ((l1 == 0L) || (l2 - l1 <= this.a.jdField_a_of_type_ComTencentAvVideoController.a().Q * 1000));
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.runOnUiThread(new jqy(this, l2, l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jqx
 * JD-Core Version:    0.7.0.1
 */