import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.redbag.OtherBtnController;

public class kfw
  implements Runnable
{
  public kfw(OtherBtnController paramOtherBtnController) {}
  
  public void run()
  {
    if (!this.a.a()) {}
    do
    {
      return;
      this.a.a();
    } while (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    if (this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver != null)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kfw
 * JD-Core Version:    0.7.0.1
 */