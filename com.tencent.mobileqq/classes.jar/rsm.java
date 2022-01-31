import android.text.Editable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class rsm
  implements Runnable
{
  public rsm(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    int i = this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length();
    if ((BaseChatPie.c(this.a) == i) && (BaseChatPie.d(this.a) != 1)) {
      BaseChatPie.e(this.a);
    }
    while (BaseChatPie.f(this.a) <= BaseChatPie.g(this.a))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendMsgSignal();
      BaseChatPie.h(this.a);
      ThreadManager.getSubThreadHandler().postDelayed(BaseChatPie.a(this.a), 2000L);
      return;
      BaseChatPie.c(this.a, i);
      BaseChatPie.d(this.a, 0);
    }
    BaseChatPie.c(this.a, false);
    BaseChatPie.e(this.a, 50);
    BaseChatPie.d(this.a, 0);
    BaseChatPie.f(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rsm
 * JD-Core Version:    0.7.0.1
 */