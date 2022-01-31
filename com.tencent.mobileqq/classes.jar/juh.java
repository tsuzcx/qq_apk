import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.utils.TraeHelper;

public class juh
  implements Runnable
{
  public juh(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) && (this.a.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b()) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.runOnUiThread(new jui(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     juh
 * JD-Core Version:    0.7.0.1
 */