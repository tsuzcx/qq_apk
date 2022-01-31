import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.qphone.base.util.QLog;

public class rsi
  implements Runnable
{
  public rsi(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "checkPESourceDowned onShow First");
    }
    PEPanelHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rsi
 * JD-Core Version:    0.7.0.1
 */