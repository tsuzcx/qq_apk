import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.qphone.base.util.QLog;

public class row
  implements Runnable
{
  public row(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "checkAllSourceDowned showPokePanel");
    }
    PokePanel.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     row
 * JD-Core Version:    0.7.0.1
 */