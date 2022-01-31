import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.redbag.OtherBtnController;

public class kfh
  implements Runnable
{
  public kfh(OtherBtnController paramOtherBtnController) {}
  
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
 * Qualified Name:     kfh
 * JD-Core Version:    0.7.0.1
 */