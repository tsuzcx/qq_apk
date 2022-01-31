import android.os.Handler;
import com.tencent.av.ui.BaseCallbackUI;

public class jsm
  implements Runnable
{
  public jsm(BaseCallbackUI paramBaseCallbackUI) {}
  
  public void run()
  {
    BaseCallbackUI.a(this.a, this.a.jdField_a_of_type_Int);
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(BaseCallbackUI.a(this.a), 400L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jsm
 * JD-Core Version:    0.7.0.1
 */