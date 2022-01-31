import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomWebProtocol;
import java.util.concurrent.atomic.AtomicInteger;

public class jmq
  implements Runnable
{
  jmz jdField_a_of_type_Jmz;
  
  private jmq(RandomController paramRandomController) {}
  
  void a(jmz paramjmz)
  {
    this.jdField_a_of_type_Jmz = paramjmz;
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentAvRandomRandomController.a)
    {
      RandomController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController).incrementAndGet();
      RandomController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController).a(RandomController.b(this.jdField_a_of_type_ComTencentAvRandomRandomController), RandomController.c(this.jdField_a_of_type_ComTencentAvRandomRandomController), 2, new String[] { this.jdField_a_of_type_Jmz.f });
      if ((RandomController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController) != null) && (RandomController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController).a() != null)) {
        RandomController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController).a().removeCallbacks(RandomController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jmq
 * JD-Core Version:    0.7.0.1
 */