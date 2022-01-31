import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomWebProtocol;
import java.util.concurrent.atomic.AtomicInteger;

public class jlc
  implements Runnable
{
  jll jdField_a_of_type_Jll;
  
  private jlc(RandomController paramRandomController) {}
  
  void a(jll paramjll)
  {
    this.jdField_a_of_type_Jll = paramjll;
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentAvRandomRandomController.a)
    {
      RandomController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController).incrementAndGet();
      RandomController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController).a(RandomController.b(this.jdField_a_of_type_ComTencentAvRandomRandomController), RandomController.c(this.jdField_a_of_type_ComTencentAvRandomRandomController), 2, new String[] { this.jdField_a_of_type_Jll.f });
      if ((RandomController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController) != null) && (RandomController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController).a() != null)) {
        RandomController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController).a().removeCallbacks(RandomController.a(this.jdField_a_of_type_ComTencentAvRandomRandomController));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jlc
 * JD-Core Version:    0.7.0.1
 */