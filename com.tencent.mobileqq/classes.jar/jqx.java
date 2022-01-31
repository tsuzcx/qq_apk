import android.os.Handler;
import com.tencent.av.ui.BaseCallbackUI;

public class jqx
  implements Runnable
{
  public jqx(BaseCallbackUI paramBaseCallbackUI) {}
  
  public void run()
  {
    BaseCallbackUI.a(this.a, this.a.jdField_a_of_type_Int);
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(BaseCallbackUI.a(this.a), 400L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jqx
 * JD-Core Version:    0.7.0.1
 */